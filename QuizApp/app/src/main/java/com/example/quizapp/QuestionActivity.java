package com.example.quizapp;

import static com.example.quizapp.ModulsActivity.questions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class QuestionActivity extends AppCompatActivity {
    TextView question,option1,option2,option3,option4;
    CardView card1,card2,card3,card4,btnNext;
    int index=0;
    Modele model;
    int correctCount=0;
    int wrongCount=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        model=questions.get(index);
    }
    private void setAllData(){
    question.setText(model.getQuestion());
    option1.setText(model.getAnswer1());
    option2.setText(model.getAnswer2());
    option3.setText(model.getAnswer3());
    option4.setText(model.getAnswer4());
    }
    private void recuperer(){
        //textviews
        question=findViewById(R.id.question_card);
        option1=findViewById(R.id.ans1);
        option2=findViewById(R.id.ans2);
        option3=findViewById(R.id.ans3);
        option4=findViewById(R.id.ans4);
        //cards
        card1=findViewById(R.id.card1);
        card2=findViewById(R.id.card2);
        card3=findViewById(R.id.card3);
        card4=findViewById(R.id.card4);
        //card next :
        btnNext=findViewById(R.id.next);

    }
    public void correct(){
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correctCount++;
                index++;
                model=questions.get(index);
                setAllData();
            }
        });

    }
    public void wrong(){
        wrongCount++;
       btnNext.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(index<questions.size()-1){
                   index++;
                   model=questions.get(index);
                   setAllData();
               }else{
                   gameWrong();
               }
           }
       });
    }
    public void enableButton(){
        card1.setClickable(true);
        card2.setClickable(true);
        card3.setClickable(true);
        card4.setClickable(true);
    }
    public void disablebleButton(){
        card1.setClickable(false);
        card2.setClickable(false);
        card3.setClickable(false);
        card4.setClickable(false);
    }
    public void resetColor(){
        card1.setBackgroundColor(getResources().getColor(R.color.white));
        card2.setBackgroundColor(getResources().getColor(R.color.white));
        card3.setBackgroundColor(getResources().getColor(R.color.white));
        card4.setBackgroundColor(getResources().getColor(R.color.white));
    }
    private void gameWrong() {
        Intent intent=new Intent(getApplicationContext(),ResultActivity.class);
        startActivity(intent);
    }
    public void optionClick(View view){
        if(model.answer1.equals(model.answer1)){
            card1.setCardBackgroundColor(getResources().getColor(R.color.teal_200));
        }
    }
}