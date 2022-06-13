package com.example.quizapp;

import static com.example.quizapp.ModulsActivity.questions;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    CardView btnQuiz;
    Button btnProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_student_page);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        btnQuiz=findViewById(R.id.quizId);
        btnProfile=findViewById(R.id.profileId);
        btnQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ModulsActivity.class);
                startActivity(intent);

            }
        });
    }
}
