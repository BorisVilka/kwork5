package com.example.c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yandex.mobile.ads.banner.AdSize;
import com.yandex.mobile.ads.banner.BannerAdView;
import com.yandex.mobile.ads.common.AdRequest;


public class TitersActivity extends AppCompatActivity {
    private TextView textView2;
    private Button btn_back,baner_forest, button_vk;
    private BannerAdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_titers);
        // Создание объекта таргетирования рекламы.
        final AdRequest adRequest = new AdRequest.Builder().build();
        adView = (BannerAdView) findViewById(R.id.adView5);
        adView.setAdUnitId("R-M-1955340-5");
        adView.setAdSize(AdSize.BANNER_320x50);
        adView.loadAd(adRequest);


        TextView textView2 = (TextView)findViewById(R.id.textView2);
        Button button_vk = (Button)findViewById(R.id.button_vk);
        final Button btn_back = (Button)findViewById(R.id.btn_back);
       textView2.setMovementMethod(LinkMovementMethod.getInstance());
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/Qlassik Medium Regular.ttf");
        textView2.setTypeface(face);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TitersActivity.this, AboutAuthorActivity.class);
                startActivity(intent);
                btn_back.setBackgroundResource(R.drawable.pushed_back_btn);
            }
        });
        button_vk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://vk.com/sergey_scromnyi";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
}
