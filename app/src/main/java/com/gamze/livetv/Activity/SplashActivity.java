package com.gamze.livetv.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.gamze.livetv.R;

public class SplashActivity extends AppCompatActivity {
    private ImageView logo;
    private static int splashTimeOut= 4000;



  @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
      super.onCreate(savedInstanceState);
      setContentView(R.layout.splash_activity);

      new Handler().postDelayed(new Runnable() {
          @Override
          public void run() {
              Intent i = new Intent(SplashActivity.this,MainActivity.class);
              startActivity(i);
               finish();
          }
      },splashTimeOut);

       logo = findViewById(R.id.logo);

      Animation anim= AnimationUtils.loadAnimation(this,R.anim.splashanimation);
      logo.startAnimation(anim);


  }
}
