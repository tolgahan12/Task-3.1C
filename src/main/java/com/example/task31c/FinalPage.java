package com.example.task31c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinalPage extends AppCompatActivity {

    //Text
    TextView congratulationsTextView;
    TextView yourScoreTextView;
    TextView correctAnswersTextView;

    //Buttons
    Button takeNewQuizButton;
    Button finishButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_page);

        //Text
        congratulationsTextView = findViewById(R.id.congratulationsTextView);
        yourScoreTextView = findViewById(R.id.yourScoreTextView);
        correctAnswersTextView = findViewById(R.id.correctAnswersTextView);

        //Buttons
        takeNewQuizButton = findViewById(R.id.takeNewQuizButton);
        finishButton = findViewById(R.id.finishButton);

        //Get data from intent from previous activities set name and set score
        Intent intent6 = getIntent();
        //set name
        String name = intent6.getStringExtra("username");
        congratulationsTextView.setText("Congratulations " + name + "!");

        //set score
        //Intent intent6 = getIntent();
        String score = intent6.getStringExtra("currentScoreNow");
        correctAnswersTextView.setText(score + "/5");

    }

    public void takeNewQuizButton(View view) {
        //go next activity
        //make intent
        Intent intent7 = new Intent(this, ReQuiz.class);

        //Get name from previous activity
        Intent intent6 = getIntent();
        String name = intent6.getStringExtra("username");

        //Send name to new quiz
        intent7.putExtra("currentName", name);


        //start next activity and finish current
        startActivity(intent7);
        finish();
    }

    public void finishButton(View view) {
        //Intent intent8 = new Intent(this, MainActivity.class);
        //startActivity(intent8);
        finish();
    }

}