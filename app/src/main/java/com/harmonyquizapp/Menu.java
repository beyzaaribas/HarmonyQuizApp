package com.harmonyquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Menu extends AppCompatActivity {

    public static ArrayList<ModelClass> easyQuizList;
    public static ArrayList<ModelClass> hardQuizList;
    public static ArrayList<tutorialModel> tutorialList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


            //Easy Quiz
        easyQuizList = new ArrayList<>();


        easyQuizList.add(new ModelClass("Which instrument is the sound you hear?","Piano","Guitar","Drums","Flute","Piano"));
        easyQuizList.add(new ModelClass("Which instrument is the sound you hear?","Harp","Violin","Cello","Guitar","Violin"));
        easyQuizList.add(new ModelClass("Which instrument is the sound you hear?","Piano","Harp","Flute","Marimba","Harp"));
        easyQuizList.add(new ModelClass("Which instrument is the sound you hear?","Saxophone","Marimba","Harp","Harmonica","Harmonica"));
        easyQuizList.add(new ModelClass("Which instrument is the sound you hear?","Guitar","Cello","Violin","Harp","Cello"));
        easyQuizList.add(new ModelClass("Which instrument is the sound you hear?","Piano","Drums","Saxophone","Flute","Flute"));
        easyQuizList.add(new ModelClass("Which instrument is the sound you hear?","Violin","Harp","Drums","Harmonica","Drums"));
        easyQuizList.add(new ModelClass("Which instrument is the sound you hear?","Violin","Cello","Harp","Guitar","Guitar"));
        easyQuizList.add(new ModelClass("Which instrument is the sound you hear?","Saxophone","Flute","Harmonica","Marimba","Saxophone"));
        easyQuizList.add(new ModelClass("Which instrument is the sound you hear?","Harp","Marimba","Harmonica","Piano","Marimba"));

        //Hard Quiz List

        hardQuizList = new ArrayList<>();

        hardQuizList.add(new ModelClass("Which instruments do you hear?","Piano-Cello","Violin-Piano","Drums-Violin","Flute-Cello","Piano-Cello"));
        hardQuizList.add(new ModelClass("Which instruments do you hear?","Harp-Guitar","Violin-Guitar","Saxophone-Guitar","Harmonica-Guitar","Harmonica-Guitar"));
        hardQuizList.add(new ModelClass("Which instruments do you hear?","Harp-Drums","Harmonica-Drums","Guitar-Drums","Violin-Drums","Harp-Drums"));
        hardQuizList.add(new ModelClass("Which instruments do you hear?","Marimba","Saxophone","Harp","Harmonica","Marimba"));
        hardQuizList.add(new ModelClass("Which instruments do you hear?","Cello-Piano","Violin-Piano","Harp-Piano","Guitar-Piano","Violin-Piano"));
        hardQuizList.add(new ModelClass("Which instruments do you hear?","Flute-Violin","Harmonica-Cello","Flute-Cello","Saxophone-Cello","Flute-Cello"));
        hardQuizList.add(new ModelClass("Which instruments do you hear?","Harp-Piano","Violin-Piano","Cello-Piano","Guitar-Piano","Guitar-Piano"));
        hardQuizList.add(new ModelClass("Which instruments do you hear?","Cello-Violin-Guitar","Cello-Violin-Piano","Cello-Violin-Harp","Cello-Violin-Marimba","Cello-Violin-Piano"));
        hardQuizList.add(new ModelClass("Which instruments do you hear?","Saxophone-Guitar","Harmonica-Guitar","Harp-Guitar","Marimba-Guitar","Saxophone-Guitar"));
        hardQuizList.add(new ModelClass("Which instruments do you hear?","Drums-Harp","Drums-Marimba","Drums-Violin","Drums-Guitar","Drums-Guitar"));


        //Tutorial List

        tutorialList = new ArrayList<>();

        tutorialList.add(new tutorialModel("This sound you hear belongs to the","Piano."));
        tutorialList.add(new tutorialModel("This sound you hear belongs to the","Violin"));
        tutorialList.add(new tutorialModel("This sound you hear belongs to the","Harp"));
        tutorialList.add(new tutorialModel("This sound you hear belongs to the","Harmonica"));
        tutorialList.add(new tutorialModel("This sound you hear belongs to the","Cello"));
        tutorialList.add(new tutorialModel("This sound you hear belongs to the","Flute"));
        tutorialList.add(new tutorialModel("This sound you hear belongs to the","Drums"));
        tutorialList.add(new tutorialModel("This sound you hear belongs to the","Guitar"));
        tutorialList.add(new tutorialModel("This sound you hear belongs to the","Saxophone"));
        tutorialList.add(new tutorialModel("This sound you hear belongs to the","Marimba"));




        Button tButton = findViewById(R.id.Tbutton);
        Button eButton = findViewById(R.id.easyButton);
        Button hButton = findViewById(R.id.hardButton);

        tButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, Tutorial.class);
                startActivity(intent);
            }
        });

        eButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, EasyQuiz.class);
                startActivity(intent);
            }
        });
        hButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, HardQuiz.class);
                startActivity(intent);
            }
        });



    }
}