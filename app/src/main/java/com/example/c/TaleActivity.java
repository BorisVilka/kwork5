package com.example.c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.yandex.mobile.ads.banner.AdSize;
import com.yandex.mobile.ads.banner.BannerAdView;
import com.yandex.mobile.ads.common.AdRequest;


public class TaleActivity extends AppCompatActivity {
    private Handler handler;
    private Runnable runnable;
    private MediaPlayer mediaPlayer;
    private SeekBar seekBar;
    private Button startButton, pauseButton, stopButton;
    private TextView txt_pause,txt_start,txt_next,btn_back;
    private BannerAdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tale);
        final AdRequest adRequest = new AdRequest.Builder().build();
        adView = (BannerAdView) findViewById(R.id.adView4);
        adView.setAdUnitId("R-M-1955340-4");
        adView.setAdSize(AdSize.BANNER_320x50);
        adView.loadAd(adRequest);

        mediaPlayer=MediaPlayer.create(this, R.raw.skazka1);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopPlay();
            }
        });


        handler = new Handler();
//      Иницлизирую объекты
        seekBar = (SeekBar)findViewById(R.id.seekBar);
        final Button startButton = (Button)findViewById(R.id.start);
        final Button pauseButton = (Button)findViewById(R.id.pause);
        final Button stopButton = (Button) findViewById(R.id. stop);
        TextView txt_pause = (TextView)findViewById(R.id.txt_pause);
        TextView txt_start = (TextView)findViewById(R.id.txt_start);
        TextView txt_next = (TextView)findViewById(R.id.txt_next);
        final TextView btn_back = (TextView)findViewById(R.id.btn_back);
        handler = new Handler();
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/Qlassik Medium Regular.ttf");
        txt_pause.setTypeface(face);
        txt_start.setTypeface(face);
        txt_next.setTypeface(face);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                Intent intent = new Intent(TaleActivity.this, MainActivity.class);
                startActivity(intent);
                btn_back.setBackgroundResource(R.drawable.pushed_back_btn);
            }
        });

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
                changeSeekbar();
                    startButton.setBackgroundResource(R.mipmap.play_foreground);
                pauseButton.setBackgroundResource(R.mipmap.stop_foreground);
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
                startButton.setBackgroundResource(R.mipmap.play_foreground);
                pauseButton.setBackgroundResource(R.mipmap.stop_foreground);
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlay();
                mediaPlayer.start();
                startButton.setBackgroundResource(R.mipmap.play_foreground);
            }
        });

        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBar.setMax(mediaPlayer.getDuration());
                changeSeekbar();
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(b){
                    mediaPlayer.seekTo(i);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //      Добавляем фотографию в качестве ползунка
        Drawable thumb = getResources().getDrawable
                (R.drawable.round_green);
//      Цвет для SeekBar (ползунок и прогресс)
        seekBar.getProgressDrawable().setColorFilter(getResources().getColor(R.color.colorLineSeekBar),
                PorterDuff.Mode.SRC_ATOP);
//      Установил ползунок
        seekBar.setThumb(thumb);
    }

    private void changeSeekbar() {
        seekBar.setProgress(mediaPlayer.getCurrentPosition());

        if(mediaPlayer.isPlaying()){
            runnable = new Runnable() {
                @Override
                public void run() {
                    changeSeekbar();
                }
            };
            handler.postDelayed(runnable, 1000);
        }
    }

    private void stopPlay(){
        mediaPlayer.stop();
        try {
            mediaPlayer.prepare();
            mediaPlayer.seekTo(0);
            startButton.setEnabled(true);
        }
        catch (Throwable t) {
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
    }
}
