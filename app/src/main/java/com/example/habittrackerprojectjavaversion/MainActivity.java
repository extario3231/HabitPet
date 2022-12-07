package com.example.habittrackerprojectjavaversion;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
    private ImageView myImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initViews();

        initData();

        setListeners();

        Animation animation = new AlphaAnimation(0, 1);
        animation.setStartOffset(2000);
        animation.setDuration(2000);
        animation.setRepeatMode(10);

        myImageView.startAnimation(animation);

    }

    private void initViews() {
        myImageView = (ImageView)findViewById(R.id.imageView1);
    }

    private void initData() {
    }

    private void setListeners() {
        myImageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ImageView t_v = (ImageView)v;
                if(t_v == myImageView)
                {
                    Intent intent = new Intent(MainActivity.this,home.class) ;
                    startActivity(intent);
                    finish();
                }
                return false;
            }
        });
    }
}
