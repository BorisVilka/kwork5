package com.example.c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.yandex.mobile.ads.banner.AdSize;
import com.yandex.mobile.ads.banner.BannerAdView;
import com.yandex.mobile.ads.common.AdRequest;


public class MainActivity extends AppCompatActivity {

    private Button btnTale, btnSings, btnAboutUs;
    private BannerAdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final AdRequest adRequest = new AdRequest.Builder().build();
        adView = (BannerAdView) findViewById(R.id.adView1);
        adView.setAdUnitId("R-M-1955340-1");
        adView.setAdSize(AdSize.BANNER_320x50);
        adView.loadAd(adRequest);

//      Нахожу поля
            final Button btnTale = (Button) findViewById(R.id.btnTale);
            final Button btnSings = (Button) findViewById(R.id.btnSings);
            final Button btnAboutUs = (Button) findViewById(R.id.btnAboutUs);

//      Меняю шрифт текста у кнопок
            Typeface face = Typeface.createFromAsset(getAssets(), "fonts/Qlassik Medium Regular.ttf");
            btnTale.setTypeface(face);
            btnSings.setTypeface(face);
            btnAboutUs.setTypeface(face);

//      Переход на другую страницу при клике на кнопку
            btnTale.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(btnTale.isPressed()){
                        btnTale.setBackgroundResource(R.drawable.pushed_tale_btn);
                    }else{
                        btnTale.setBackgroundResource(R.drawable.tale_btn);
                    }
                    Intent intent = new Intent(MainActivity.this, TaleActivity.class);
                    startActivity(intent);
                }
            });
            btnSings.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, MusicActivity.class);
                    startActivity(intent);
                    btnSings.setBackgroundResource(R.drawable.pushed_song_btn);
                }
            });
            btnAboutUs.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, AboutAuthorActivity.class);
                    startActivity(intent);
                    btnAboutUs.setBackgroundResource(R.drawable.pushed_about_author_btn);
                }
            });
        }
    }

