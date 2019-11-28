package com.example.animationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimationTweenActivity extends AppCompatActivity implements View.OnClickListener {


    private ImageView iv_inside_circle;
    private ImageView iv_outer_circle;
    private TextView tv_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_tween_animation );


        iv_inside_circle =findViewById( R.id.iv_inside_circle );
        iv_outer_circle =findViewById( R.id.iv_outer_circle );
        tv_view =findViewById( R.id.tv_view );



    }




    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btn_translation:
                //根据anim/xml创建

//                Animation animation = AnimationUtils.loadAnimation( this,R.anim.anim_translate );
//                tv_view.startAnimation( animation );


                //动态创建，完成跟xml一样
                Animation animation = new TranslateAnimation( 0,100,0,300 );
                animation.setDuration( 3000 );
                tv_view.startAnimation( animation );

                break;


            case R.id.btn_scale :

                //根据anim/xml创建
                animation =AnimationUtils.loadAnimation( this,R.anim.anim_scale );
                tv_view.startAnimation( animation );

                //动态创建，完成跟xml一样
//                animation = new ScaleAnimation( 0,2,0,2 ,Animation.RELATIVE_TO_SELF,0.5f,
//                        Animation.RELATIVE_TO_PARENT,0.5f);
//                tv_view.startAnimation( animation );

                break;


            case R.id.btn_rotate :

                Animation insideCircle = AnimationUtils.loadAnimation( this,R.anim.inside_rotate );
                insideCircle.setInterpolator( new LinearInterpolator(  ) );

                Animation outerCircle = AnimationUtils.loadAnimation( this,R.anim.outer_rotate );
                outerCircle.setInterpolator( new LinearInterpolator(  ) );

                iv_inside_circle.startAnimation( insideCircle);
                iv_outer_circle.startAnimation( outerCircle );

                break;

            case R.id.btn_alpha :
                //根据anim/xml创建
                animation =AnimationUtils.loadAnimation( this,R.anim.view_alpha );
                tv_view.startAnimation( animation );
                break;

            case R.id.btn_set :
                //组合方式 startOffset

                animation = AnimationUtils.loadAnimation( this,R.anim.anim_set );
                tv_view.startAnimation( animation );

                break;


        }

    }


}
