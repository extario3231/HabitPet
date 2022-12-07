package com.example.habittrackerprojectjavaversion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class home extends AppCompatActivity {

    ImageButton homeButton;
    ImageButton habitButton;
    ImageButton taskButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        habitButton = findViewById(R.id.habitButton);
        habitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(home.this, habit.class);
                startActivity(intent);
            }
        });

        taskButton = findViewById(R.id.taskButton);
        taskButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(home.this, task.class);
                startActivity(intent);
            }
        });
    }
}