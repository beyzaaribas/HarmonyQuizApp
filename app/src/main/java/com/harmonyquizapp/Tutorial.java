package com.harmonyquizapp;


import static com.harmonyquizapp.Menu.tutorialList;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Tutorial extends AppCompatActivity  {

    List<tutorialModel> allQuestionList;
    tutorialModel tutorialmodel;
    int index = 0;
    TextView card_question, optiona;
    LinearLayout nextBtn;
    Button baslat, durdur;
    int currentIndex = 0;
    static MediaPlayer mMediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);



        Hooks();

        allQuestionList = tutorialList;
        tutorialmodel = tutorialList.get(index);


        durdur =findViewById(R.id.btnStop);
        baslat =findViewById(R.id.btnBaslat);

        ArrayList<Integer> songs = new ArrayList<>();
        songs.add(0, R.raw.piano);
        songs.add(1, R.raw.violin);
        songs.add(2, R.raw.harp);
        songs.add(3, R.raw.harmonica);
        songs.add(4, R.raw.cello);
        songs.add(5, R.raw.flute);
        songs.add(6, R.raw.drums);
        songs.add(7, R.raw.guitar);
        songs.add(8, R.raw.saxophone);
        songs.add(9, R.raw.marimba);

        mMediaPlayer = MediaPlayer.create(getApplicationContext(),songs.get(currentIndex));

        baslat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMediaPlayer = MediaPlayer.create(getApplicationContext(),songs.get(currentIndex));
                mMediaPlayer.start();

            }
        });


        durdur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMediaPlayer.stop();
            }
        });

        card_question.setText(tutorialmodel.getInformation());
        optiona.setText(tutorialmodel.getoInfo());

    }



    public void nextBtnClick(View view) {
        nextBtn.setClickable(true);
            currentIndex++;

        if (tutorialmodel.getoInfo().equals(tutorialmodel.getoInfo())){
            if(index<tutorialList.size() - 1){
            index++;
            tutorialmodel = tutorialList.get(index);
            card_question.setText(tutorialmodel.getInformation());
            optiona.setText(tutorialmodel.getoInfo());
             }else{
                FinishTutorial();
            }
        }

    }
    private void FinishTutorial() {
        Intent intent = new Intent(Tutorial.this, tutorialFinishActivity.class);
        startActivity(intent);

    }

    private void Hooks() {

        card_question = findViewById(R.id.card_question);
        optiona = findViewById(R.id.card_optionA);
        nextBtn = findViewById(R.id.nextBtn);
    }

    public void exitDoorClick(View view) {
        finishAffinity();
        mMediaPlayer.stop();
        System.exit(0);
    }
    public void leftArrowClick(View view) {

        Intent intent = new Intent(Tutorial.this, Menu.class);
        startActivity(intent);
        mMediaPlayer.stop();


    }

}