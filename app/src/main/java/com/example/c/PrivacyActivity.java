package com.example.c;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;

public class PrivacyActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(getSharedPreferences("prefs",MODE_PRIVATE).getBoolean("privacy",false)) {
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy);
        findViewById(R.id.button5).setOnClickListener(view -> {
            getSharedPreferences("prefs",MODE_PRIVATE)
                    .edit()
                            .putBoolean("privacy",true)
                                    .apply();
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        });
        ((TextView)findViewById(R.id.textView2)).setMovementMethod(LinkMovementMethod.getInstance());
        ((TextView)findViewById(R.id.textView2)).setLinkTextColor(getColor(R.color.stop_background));
        ((TextView)findViewById(R.id.textView2)).setLinksClickable(true);
    }
}