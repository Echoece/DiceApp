package com.echoece.diceappnew;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ImageView dice1=findViewById(R.id.dice1);
        final ImageView dice2=findViewById(R.id.dice2);

        final Button button= findViewById(R.id.btn); //R.id.btn returns an integer value. so does the R.drawable.dice1 . thats why we used int array
        final int[] images={R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};

        final MediaPlayer mp=MediaPlayer.create(this,R.raw.dice_sound);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rn=new Random();

                int number=rn.nextInt(6);
                dice1.setImageResource(images[number]);
                number=rn.nextInt(6);
                dice2.setImageResource(images[number]);
                YoYo.with(Techniques.RotateInDownRight)
                        .duration(455)
                        .repeat(5)
                        .playOn(findViewById(R.id.dice1));
                YoYo.with(Techniques.FlipInX)
                        .duration(422)
                        .repeat(3)
                        .playOn(findViewById(R.id.dice2));
                mp.start();
            }
        });
            }
}