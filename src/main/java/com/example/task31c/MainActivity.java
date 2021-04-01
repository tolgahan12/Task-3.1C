package com.example.task31c;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button startQuizButton;
    EditText enterNameEditText;
    TextView enterNameTextView;

    public Integer currentScore = 0;

    public void startQuizButton(View view)
    {
        Intent intent = new Intent(this, Quiz1.class);
        intent.putExtra("username", enterNameEditText.getText().toString());
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterNameEditText = findViewById(R.id.enterNameEditText);
        enterNameTextView = findViewById(R.id.enterNameTextView);
        startQuizButton = findViewById(R.id.startQuizButton);

    }


}