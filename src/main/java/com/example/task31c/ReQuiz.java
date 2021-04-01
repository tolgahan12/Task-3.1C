package com.example.task31c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ReQuiz extends AppCompatActivity {

    Button startQuizButton;
    TextView enterNameTextView;
    TextView oldNameTextView;

    public void startQuizButton(View view)
    {
        Intent intent = new Intent(this, Quiz1.class);
        intent.putExtra("username", oldNameTextView.getText().toString());
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re_quiz);

        enterNameTextView = findViewById(R.id.enterNameTextView);
        oldNameTextView = findViewById(R.id.oldNameTextView);
        startQuizButton = findViewById(R.id.startQuizButton);

        Intent intent = getIntent();
        String name = intent.getStringExtra("currentName");

        oldNameTextView.setText(name); //Set name to previous name given

    }
}