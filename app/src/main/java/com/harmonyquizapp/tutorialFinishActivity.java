package com.harmonyquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class tutorialFinishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_finish);


    }


    public void exitDoorClick(View view) {
        finishAffinity();
        System.exit(0);
    }
    public void leftArrowClick(View view) {

        Intent intent = new Intent(tutorialFinishActivity.this, Menu.class);
        startActivity(intent);

    }

}