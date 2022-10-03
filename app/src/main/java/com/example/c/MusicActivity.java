package com.example.c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.yandex.mobile.ads.banner.AdSize;
import com.yandex.mobile.ads.banner.BannerAdView;
import com.yandex.mobile.ads.common.AdRequest;


public class MusicActivity extends AppCompatActivity {
    private TextView sing1;
    private TextView sing2;
    private TextView sing3;
    private TextView sing4;
    private Button start1,start2,start3,start4;
    private MediaPlayer mediaPlayer1,mediaPlayer2,mediaPlayer3,mediaPlayer4;
    private BannerAdView adView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        final AdRequest adRequest = new AdRequest.Builder().build();
        adView = (BannerAdView) findViewById(R.id.adView3);
        adView.setAdUnitId("R-M-1955340-3");
        adView.setAdSize(AdSize.BANNER_320x50);
        adView.loadAd(adRequest);

        mediaPlayer1=MediaPlayer.create(this, R.raw.song1);
        mediaPlayer1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopPlay1();
            }
        });
        mediaPlayer2=MediaPlayer.create(this, R.raw.song2);
        mediaPlayer2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopPlay2();
            }
        });
        mediaPlayer3=MediaPlayer.create(this, R.raw.song4);
        mediaPlayer3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopPlay3();
            }
        });
        mediaPlayer4=MediaPlayer.create(this, R.raw.song3);
        mediaPlayer4.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopPlay4();
            }
        });

        TextView sing1 = (TextView)findViewById(R.id.name_song1);
        TextView sing2 = (TextView)findViewById(R.id.name_song2);
        TextView sing3 = (TextView)findViewById(R.id.name_song3);
        TextView sing4 = (TextView)findViewById(R.id.name_song4);
        final Button btn_back = (Button)findViewById(R.id.btn_back);
        final Button start1 = (Button)findViewById(R.id.start1);
        final Button start2 = (Button)findViewById(R.id.start2);
        final Button start3 = (Button)findViewById(R.id.start3);
        final Button start4 = (Button)findViewById(R.id.start4);

        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/Qlassik Medium Regular.ttf");
        sing1.setTypeface(face);
        sing2.setTypeface(face);
        sing3.setTypeface(face);
        sing4.setTypeface(face);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MusicActivity.this, MainActivity.class);
                startActivity(intent);
                mediaPlayer1.stop();
                start1.setBackgroundResource(R.mipmap.play_foreground);
                mediaPlayer2.stop();
                start2.setBackgroundResource(R.mipmap.play_foreground);
                mediaPlayer3.stop();
                start3.setBackgroundResource(R.mipmap.play_foreground);
                mediaPlayer4.stop();
                start4.setBackgroundResource(R.mipmap.play_foreground);
                btn_back.setBackgroundResource(R.drawable.pushed_back_btn);
            }
        });
        start1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer1.isPlaying()){
                    mediaPlayer1.pause();
                    start1.setBackgroundResource(R.mipmap.play_foreground);
                }
                else {
                    mediaPlayer1.start();
                    start1.setBackgroundResource(R.mipmap.stop_foreground);
                    if (mediaPlayer2.isPlaying()){
                        stopPlay2();
                        start2.setBackgroundResource(R.mipmap.play_foreground);
                        }
                    if (mediaPlayer3.isPlaying()){
                        stopPlay3();
                        start3.setBackgroundResource(R.mipmap.play_foreground);
                    }
                    if (mediaPlayer4.isPlaying()){
                        stopPlay4();
                        start4.setBackgroundResource(R.mipmap.play_foreground);
                    }
                }
            }
        });
        start2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer2.isPlaying()){
                    mediaPlayer2.pause();
                    start2.setBackgroundResource(R.mipmap.play_foreground);
                }
                else {
                    mediaPlayer2.start();
                    start2.setBackgroundResource(R.mipmap.stop_foreground);
                    if (mediaPlayer1.isPlaying()){
                        stopPlay1();
                        start1.setBackgroundResource(R.mipmap.play_foreground);
                    }
                    if (mediaPlayer3.isPlaying()){
                        stopPlay3();
                        start3.setBackgroundResource(R.mipmap.play_foreground);
                    }
                    if (mediaPlayer4.isPlaying()){
                        stopPlay4();
                        start4.setBackgroundResource(R.mipmap.play_foreground);
                    }
                }
            }
        });
        start3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer3.isPlaying()){
                    mediaPlayer3.pause();
                    start3.setBackgroundResource(R.mipmap.play_foreground);
                }
                else {
                    mediaPlayer3.start();
                    start3.setBackgroundResource(R.mipmap.stop_foreground);
                    if (mediaPlayer2.isPlaying()){
                        stopPlay2();
                        start2.setBackgroundResource(R.mipmap.play_foreground);
                    }
                    if (mediaPlayer1.isPlaying()){
                        stopPlay1();
                        start1.setBackgroundResource(R.mipmap.play_foreground);
                    }
                    if (mediaPlayer4.isPlaying()){
                        stopPlay4();
                        start4.setBackgroundResource(R.mipmap.play_foreground);
                    }
                }
            }
        });
        start4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer4.isPlaying()){
                    mediaPlayer4.pause();
                    start4.setBackgroundResource(R.mipmap.play_foreground);
                }
                else {
                    mediaPlayer4.start();
                    start4.setBackgroundResource(R.mipmap.stop_foreground);
                    if (mediaPlayer2.isPlaying()){
                        stopPlay2();
                        start2.setBackgroundResource(R.mipmap.play_foreground);
                    }
                    if (mediaPlayer3.isPlaying()){
                        stopPlay3();
                        start3.setBackgroundResource(R.mipmap.play_foreground);
                    }
                    if (mediaPlayer1.isPlaying()){
                        stopPlay1();
                        start1.setBackgroundResource(R.mipmap.play_foreground);
                    }
                }
            }
        });
    }
    private void stopPlay1(){
        mediaPlayer1.stop();
        try {
            mediaPlayer1.prepare();
            mediaPlayer1.seekTo(0);
            start1.setEnabled(true);
        }
        catch (Throwable t) {
        }
    }
    private void stopPlay2(){
        mediaPlayer2.stop();
        try {
            mediaPlayer2.prepare();
            mediaPlayer2.seekTo(0);
            start2.setEnabled(true);
        }
        catch (Throwable t) {
        }
    }
    private void stopPlay3(){
        mediaPlayer3.stop();
        try {
            mediaPlayer3.prepare();
            mediaPlayer3.seekTo(0);
            start3.setEnabled(true);
        }
        catch (Throwable t) {
        }
    }
    private void stopPlay4(){
        mediaPlayer4.stop();
        try {
            mediaPlayer4.prepare();
            mediaPlayer4.seekTo(0);
            start4.setEnabled(true);
        }
        catch (Throwable t) {
        }
    }
}
