package com.example.task31c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz5 extends AppCompatActivity {

    //set score to zero
    public Integer currentScoreNow = 0;

    //Correct answer
    public String answerValidate = "";

    //define elements in app
    //TextView nameTextView;
    TextView progressBarCurrentTextView;

    //Buttons
    Button answer1Button;
    Button answer2Button;
    Button answer3Button;
    Button submitButton;

    //Progress Bar
    ProgressBar progressBar;

    //Texts
    TextView questionTitleTextView;
    TextView questionTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);

        //Buttons
        answer1Button = findViewById(R.id.answer1Button);
        answer2Button = findViewById(R.id.answer2Button);
        answer3Button = findViewById(R.id.answer3Button);
        submitButton = findViewById(R.id.submitButton);

        //Text
        questionTitleTextView = findViewById(R.id.questionTitleTextView);
        questionTextView = findViewById(R.id.questionTextView);

        //-------------------------------------------------------------------------------------
        //Set current score from previous page using intent
        Intent intent5 = getIntent();
        String score = intent5.getStringExtra("currentScoreNow");
        currentScoreNow = currentScoreNow + Integer.parseInt(score);

        //-------------------------------------------------------------------------------------
        //Set progress bar depending on questions completed so far
        //Text
        progressBarCurrentTextView = findViewById(R.id.progressBarCurrentTextView);
        progressBarCurrentTextView.setText("4/5");
        //Progress Bar
        progressBar = findViewById(R.id.progressBar);
        progressBar.setProgress(80);

        //-------------------------------------------------------------------------------------
        //Set questions
        questionTitleTextView.setText("General Knowledge");
        questionTextView.setText("Which of the below is not an possible activity lifecycle state?");
        //Set answer
        answer1Button.setText("Startup");
        answer2Button.setText("Foreground");
        answer3Button.setText("Destroyed");

    }

    public void answer1Button(View view) {
        // if correct button pressed set answerValidate to 1 else set to 0
        answerValidate = "Correct";
        //Toast.makeText(Quiz1.this, answerValidate, Toast.LENGTH_SHORT).show();
    }

    public void answer2Button(View view) {
        answerValidate = "Wrong1";
        //Toast.makeText(Quiz1.this, answerValidate, Toast.LENGTH_SHORT).show();
    }

    public void answer3Button(View view) {
        answerValidate = "Wrong2";
        //Toast.makeText(Quiz1.this, answerValidate, Toast.LENGTH_SHORT).show();
    }

    public void submitButton(View view) {
        //if correct make that button background green and change progress bar percentage and value else make background red and don't change progress bar
        //change text to next after pressing submitButton for first time, if not selected prompt error using result ok, then if text = next for button take to next activity

        if (submitButton.getText().equals("Next")) // go to next page if user enters a answer
        {
            //go next activity
            Intent intent6 = new Intent(this, FinalPage.class);

            //get entered text and assign to valScore
            String valScore = currentScoreNow.toString();

            //send score to next activity
            intent6.putExtra("currentScoreNow", valScore);

            //send name to next activity
            Intent intent5 = getIntent();
            String name = intent5.getStringExtra("username");
            intent6.putExtra("username", name);

            //start next activity and finish current
            startActivity(intent6);
            finish();
        }
        else if (answerValidate.equals("")) //if nothing selected prompt error message
        {
            //prompt toast
            Toast.makeText(Quiz5.this, "Please select a answer", Toast.LENGTH_SHORT).show();
        }
        else
        {
            submitButton.setText("Next");
            //Set progress bar depending on questions completed so far
            progressBarCurrentTextView = findViewById(R.id.progressBarCurrentTextView);
            progressBarCurrentTextView.setText("5/5");
            //Progress Bar
            progressBar = findViewById(R.id.progressBar);
            progressBar.setProgress(100);

            if (answerValidate.equals("Correct"))
            {
                //set background
                answer1Button.setBackgroundResource(R.color.green);
                //change score
                currentScoreNow = currentScoreNow + 1;
            }
            else if (answerValidate.equals("Wrong1"))
            {
                //set background
                answer2Button.setBackgroundResource(R.color.red);
            }
            else if (answerValidate.equals("Wrong2"))
            {
                //set background
                answer3Button.setBackgroundResource(R.color.red);
            }
        }

    }
}