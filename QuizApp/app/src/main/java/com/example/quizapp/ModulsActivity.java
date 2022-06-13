package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ModulsActivity extends AppCompatActivity {
   public static ArrayList<Modele> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moduls);
        questions.add(new Modele("question1","answer1","answer2","answer3","answer4"));
        questions.add(new Modele("question2","answer1","answer2","answer3","answer4"));
        questions.add(new Modele("question3","answer1","answer2","answer3","answer4"));
        questions.add(new Modele("question4","answer1","answer2","answer3","answer4"));

    }

}