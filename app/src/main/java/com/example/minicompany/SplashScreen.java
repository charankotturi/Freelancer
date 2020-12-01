package com.example.minicompany;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

import android.content.Intent;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {

    private ImageView surround_path;
    private ImageView text_path;
    private AnimatedVectorDrawable avd;
    private AnimatedVectorDrawableCompat avdc;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        text_path = findViewById(R.id.text);
        surround_path = findViewById(R.id.surround);

        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        );

        Drawable drawable = surround_path.getDrawable();

        if(drawable instanceof AnimatedVectorDrawable){
            avd = (AnimatedVectorDrawable) drawable;
            avd.start();
        }
        else if(drawable instanceof AnimatedVectorDrawableCompat) {
            avdc = (AnimatedVectorDrawableCompat) drawable;
            avdc.start();
        }

        Drawable drawable1 = text_path.getDrawable();

        if(drawable1 instanceof AnimatedVectorDrawable){
            avd = (AnimatedVectorDrawable) drawable;
            avd.start();
        }
        else if(drawable1 instanceof AnimatedVectorDrawableCompat) {
            avdc = (AnimatedVectorDrawableCompat) drawable;
            avdc.start();
        }

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(3500);
                startActivity(new Intent(SplashScreen.this, SecondActivity.class));
                finish();
            }
        });

        thread.start();

    }
}