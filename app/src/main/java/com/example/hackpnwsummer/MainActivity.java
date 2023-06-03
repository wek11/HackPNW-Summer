package com.example.hackpnwsummer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static int progress = 0;
    static int goal = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String test;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonGoal = findViewById(R.id.setGoalButton);
        buttonGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                TextView goal = findViewById(R.id.goalTextView);
                EditText setGoal = findViewById(R.id.goalEditText);
                goal.setText(setGoal.getText().toString() + " gallons");
                MainActivity.goal = Integer.parseInt(setGoal.getText().toString());
            }
        });
    }
}