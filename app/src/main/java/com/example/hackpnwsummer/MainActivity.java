package com.example.hackpnwsummer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static int progress = 0;
    static int goal = 100;
    static double gallon = 0;
    static int flush, dish, wash;
    static double shower, sink, hose, sprink;

    static ProgressBar waterProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        waterProgressBar = findViewById(R.id.waterProgressBar);
        Button buttonGoal = findViewById(R.id.setGoalButton);
        Thread thread = new Thread(new Runnable(){
            public void run(){
                while(true){
                    MainActivity.progress = (int)(MainActivity.gallon / ((double)MainActivity.goal) * 100);
                    MainActivity.waterProgressBar.setProgress(progress);
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }
    public void goalClick(View v){
        try {
            EditText setGoal = findViewById(R.id.goalEditText);
            MainActivity.goal = Integer.parseInt(setGoal.getText().toString());
            TextView goal = findViewById(R.id.goalTextView);

            goal.setText("Goal: " + setGoal.getText().toString() + " gallons");

        } catch(NumberFormatException e) {
            Toast.makeText(this, "Invalid Goal", Toast.LENGTH_SHORT).show();
        }
    }

    public void calculateTotal() {
        gallon += flush * 1.6;
        gallon += shower * 2.1;
        gallon += sink * 2.2;
        gallon += dish * 4;
        gallon += wash * 15;
        gallon += hose * 12;
        gallon += sprink * 4;
    }
}