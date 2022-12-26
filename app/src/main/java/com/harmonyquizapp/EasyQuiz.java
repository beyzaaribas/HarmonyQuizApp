package com.harmonyquizapp;

import static com.harmonyquizapp.Menu.easyQuizList;
import static com.harmonyquizapp.R.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.CoreComponentFactory;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.progressindicator.LinearProgressIndicator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class EasyQuiz extends AppCompatActivity {
    CountDownTimer countDownTimer;
    int timerValue = 20;
    LinearProgressIndicator progressBar;
    List<ModelClass> allQuestionList;
    ModelClass modelclass;
    int index = 0;
    TextView card_question, optiona, optionb, optionc, optiond;
    Button ansA, ansB, ansC, ansD;
    int correctCount = 0;
    int wrongCount = 0;
    LinearLayout nextBtn;
    Button baslat, durdur;
    int currentIndex = 0;
    static MediaPlayer mMediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_easy_quiz);

        Hooks();


        allQuestionList = easyQuizList;
        modelclass = easyQuizList.get(index);

        ansA.setBackgroundColor(getResources().getColor(color.white,null));
        ansB.setBackgroundColor(getResources().getColor(color.white,null));
        ansC.setBackgroundColor(getResources().getColor(color.white,null));
        ansD.setBackgroundColor(getResources().getColor(color.white,null));

        nextBtn.setClickable(false);

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


        countDownTimer = new CountDownTimer(21000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                timerValue = timerValue - 1;
                progressBar.setProgress(timerValue);

            }

            @Override
            public void onFinish() {
                Dialog dialog = new Dialog(EasyQuiz.this);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setContentView(layout.time_out_dialog);

                dialog.findViewById(id.btn_tryagain).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(EasyQuiz.this,Menu.class);
                        startActivity(intent);
                    }
                });

                dialog.show();
            }
        }.start();
        setAllData();
    }

    private void setAllData() {

        card_question.setText(modelclass.getQuestion());
        optiona.setText(modelclass.getoA());
        optionb.setText(modelclass.getoB());
        optionc.setText(modelclass.getoC());
        optiond.setText(modelclass.getoD());
        timerValue = 20;
        countDownTimer.cancel();
        countDownTimer.start();

    }

    private void Hooks() {

        progressBar = findViewById(id.quiz_timer);
        card_question = findViewById(id.card_question);
        optiona = findViewById(id.card_optionA);
        optionb = findViewById(id.card_optionB);
        optionc = findViewById(id.card_optionC);
        optiond = findViewById(id.card_optionD);

        ansA = findViewById(id.ansA);
        ansB = findViewById(id.ansB);
        ansC = findViewById(id.ansC);
        ansD = findViewById(id.ansD);

        nextBtn = findViewById(id.nextBtn);
    }



    public void Correct(Button button){

        button.setBackgroundColor(getResources().getColor(color.green,null));

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                   correctCount++;
                   currentIndex++;
                    index++;
                    modelclass = easyQuizList.get(index);
                    resetColor();
                    setAllData();



            }
        });
    }



    public void Wrong(Button button){

        button.setBackgroundColor(getResources().getColor(color.red,null));

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wrongCount++;
                currentIndex++;
                if (index<easyQuizList.size() - 1){
                    index++;
                    modelclass = easyQuizList.get(index);
                    resetColor();
                    setAllData();

                }else{
                    GameWon();
                }

            }
        });


    }

    private void GameWon() {
        Intent intent = new Intent(EasyQuiz.this, WonActivity.class);
        intent.putExtra("correct", correctCount);
        intent.putExtra("wrong", wrongCount);

        startActivity(intent);

    }


   public void enableButton(){
            ansA.setClickable(true);
            ansB.setClickable(true);
            ansC.setClickable(true);
            ansD.setClickable(true);
    }

    public void disableButton(){
        ansA.setClickable(false);
        ansB.setClickable(false);
        ansC.setClickable(false);
        ansD.setClickable(false);
    }


    public  void resetColor(){
        ansA.setBackgroundColor(getResources().getColor(color.white,null));
        ansB.setBackgroundColor(getResources().getColor(color.white,null));
        ansC.setBackgroundColor(getResources().getColor(color.white,null));
        ansD.setBackgroundColor(getResources().getColor(color.white,null));


    }



    public void onAClick(View view){


        nextBtn.setClickable(true);

        if (modelclass.getoA().equals(modelclass.getAns())){
            ansA.setBackgroundColor(getResources().getColor(color.green,null));

            if (index<easyQuizList.size() -1){
               Correct(ansA);
            }else{
                GameWon();
            }

        }
        else{
            Wrong(ansA);

        }

    }

    public void onBClick(View view){

        nextBtn.setClickable(true);
        if (modelclass.getoB().equals(modelclass.getAns())){
            ansB.setBackgroundColor(getResources().getColor(color.green,null));

            if (index<easyQuizList.size() - 1){
                Correct(ansB);
            }else{
                GameWon();
            }

        }
        else{
            Wrong(ansB);

        }

    }
    public void onCClick(View view){

        nextBtn.setClickable(true);

        if (modelclass.getoC().equals(modelclass.getAns())){
            ansC.setBackgroundColor(getResources().getColor(color.green,null));

            if (index<easyQuizList.size() - 1){
                Correct(ansC);

            }else{
                GameWon();
            }

        }
        else{
            Wrong(ansC);

        }

    }
    public void onDClick(View view){


        nextBtn.setClickable(true);
        if (modelclass.getoD().equals(modelclass.getAns())){
            ansD.setBackgroundColor(getResources().getColor(color.green,null));

            if (index<easyQuizList.size() - 1){
                Correct(ansD);
            }else{
                GameWon();
            }

        }
        else{
            Wrong(ansD);

        }

    }

    public void exitDoorClick(View view) {
        finishAffinity();
        System.exit(0);
    }
    public void leftArrowClick(View view) {

                Intent intent = new Intent(EasyQuiz.this, Menu.class);
                startActivity(intent);

    }



}