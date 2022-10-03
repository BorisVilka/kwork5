package com.example.c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yandex.mobile.ads.banner.AdSize;
import com.yandex.mobile.ads.banner.BannerAdView;
import com.yandex.mobile.ads.common.AdRequest;


public class AboutAuthorActivity extends AppCompatActivity {

    private Button vk_logo,btn_back,btn_go_titre;
    private BannerAdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_author);
        final AdRequest adRequest = new AdRequest.Builder().build();
        adView = (BannerAdView) findViewById(R.id.adView2);
        adView.setAdUnitId("R-M-1955340-2");
        adView.setAdSize(AdSize.BANNER_320x50);
        adView.loadAd(adRequest);

        Button btn_go_titre = (Button)findViewById(R.id.btn_go_titre);
        final Button btn_back = (Button)findViewById(R.id.btn_back);
        Button vk_logo = (Button)findViewById(R.id.vk_logo);
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/Qlassik Medium Regular.ttf");

        vk_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://vk.com/sergey_scromnyi";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AboutAuthorActivity.this, MainActivity.class);
                startActivity(intent);
                btn_back.setBackgroundResource(R.drawable.pushed_back_btn);
            }
        });

        btn_go_titre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AboutAuthorActivity.this, TitersActivity.class);
                startActivity(intent);
            }
        });

        (findViewById(R.id.vk1)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://vk.com/sergey_scromnyi?w=app5727453_-12890147";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        (findViewById(R.id.friends)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://vk.com/public207867195";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        (findViewById(R.id.dsen)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://dzen.ru/prokachka";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
}
