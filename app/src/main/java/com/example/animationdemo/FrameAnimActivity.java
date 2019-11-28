package com.example.animationdemo;

import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FrameAnimActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView ivFrame;
    private AnimationDrawable drawable;

    private Button btn_start;
    private Button btn_stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_frame_animation );

//        第一种方式
        ivFrame = findViewById( R.id.iv_progress );
//                drawable = (AnimationDrawable) ivFrame.getBackground();

//        第二种方法
//        ivFrame.setImageResource( R.drawable.frame_anim );
//        drawable = (AnimationDrawable) ivFrame.getBackground();
//        drawable.start();


        //第三种方法
        drawable =createAnimation();
        ivFrame.setImageDrawable( drawable );
        drawable.start();

        btn_start =findViewById( R.id.btn_start );
        btn_stop =findViewById( R.id.btn_stop );
        btn_start.setOnClickListener( this );
        btn_stop.setOnClickListener( this );
        drawable.start();
    }

    private AnimationDrawable createAnimation() {
        AnimationDrawable animationDrawable = new AnimationDrawable();
      for (int i=0;i<8;i++){
          int id =getResources().getIdentifier( "wait"+i ,"drawable",
                  getPackageName());
          Drawable drawable= getResources().getDrawable(id);
          animationDrawable.addFrame( drawable,100 );
      }


        return animationDrawable;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btn_start:

                drawable.start();
                break;

            case R.id.btn_stop:
                drawable.stop();
                break;
        }



    }
}
