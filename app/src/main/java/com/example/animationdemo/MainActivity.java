package com.example.animationdemo;

import android.content.Intent;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_buZhen;
    private Button bt_zhen;
    private Button bt_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        bt_buZhen =findViewById( R.id.bt_bujian );
        bt_zhen = findViewById( R.id.bt_zhen ) ;
        bt_type =findViewById( R.id.bt_type );

        bt_buZhen.setOnClickListener( this );
        bt_zhen.setOnClickListener( this );
        bt_type.setOnClickListener( this );

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case  R.id.bt_bujian :
                Intent intent = new Intent( MainActivity.this,AnimationTweenActivity.class );
                startActivity( intent );

                break;


            case R.id.bt_zhen :
                   intent = new Intent( MainActivity.this,FrameAnimActivity.class );
                   startActivity( intent );

                break;

            case R.id.bt_type :

                   intent = new Intent( MainActivity.this, ValueAnimationActivity.class );
                   startActivity(intent );

                break;


        }



    }
}
