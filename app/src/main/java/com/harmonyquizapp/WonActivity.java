package com.harmonyquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class WonActivity extends AppCompatActivity {

    TextView resulText;
    int correct, wrong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_won);

        correct = getIntent().getIntExtra("correct",0);
        wrong = getIntent().getIntExtra("wrong",0);

        resulText = findViewById(R.id.resultText);

        resulText.setText(correct+"/10");

    }

    public void exitDoorClick(View view) {
        finishAffinity();
        System.exit(0);
    }
    public void leftArrowClick(View view) {

        Intent intent = new Intent(WonActivity.this, Menu.class);
        startActivity(intent);

    }

}