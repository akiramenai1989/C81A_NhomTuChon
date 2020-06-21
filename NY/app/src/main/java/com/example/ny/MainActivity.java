package com.example.ny;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout mh;
    MediaPlayer song;
    ImageView imgLogo;
    public void anhXa(){
        mh = (ConstraintLayout)findViewById(R.id.manhinh);
        imgLogo =(ImageView)findViewById(R.id.imglogo);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();

        //manhinh
        mh.setBackgroundResource(R.drawable.bgpng1);
        //music
        song = (MediaPlayer.create(getApplicationContext(), R.raw.happynewyear));
        song.start();
        //hieuung
        Animation f = AnimationUtils.loadAnimation(this, R.anim.fade);
        f.reset();
        imgLogo.clearAnimation();
        imgLogo.startAnimation(f);

        imgLogo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                song.stop();
                Intent mhMusic = new Intent(getApplicationContext(), Music.class);
                startActivity(mhMusic);
            }
                                   }
        );

    }
}
