package com.example.hackpnwsummer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

    // [flush, dish, wash, shower, sink, hose, sprink]
    static double[] amounts = new double[7];

    static ProgressBar waterProgressBar;
    static TextView gallonOverGoal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        waterProgressBar = findViewById(R.id.waterProgressBar);
        Button buttonGoal = findViewById(R.id.setGoalButton);
        Button activityButton = findViewById(R.id.activityButton);
        Button listButton = findViewById(R.id.activityButton2);
        gallonOverGoal = findViewById(R.id.goalTextView);
        Toast.makeText(this, progress + "", Toast.LENGTH_SHORT);
        gallonOverGoal.setText(gallon + " / " + goal + " Gallons");
        // This thread constantly updates the progress bar and money saved as gallons of water used
        // increases, updating every 5 seconds to save resources while also maintaining up to date info
        Thread thread = new Thread(new Runnable(){
            public void run(){
                TextView moneySaved = findViewById(R.id.moneySaved);
                while(true){
                    MainActivity.calculateTotal();
                    System.out.println(progress);
                    MainActivity.progress = (int)(MainActivity.gallon / ((double)MainActivity.goal) * 100);
                    MainActivity.waterProgressBar.setProgress(progress);

                    double moneySavedNum = ((100.0*30/748)*22) - ((gallon*30.0/748)*22);
                    String moneySavedString = moneySavedNum + "";
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
        activityButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                    Intent intent = new Intent(MainActivity.this, AddWaterActivity2.class);
                    startActivity(intent);
            }
        });
        listButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });
    }
    public void goalClick(View v){
        try {
            EditText setGoal = findViewById(R.id.goalEditText);
            MainActivity.goal = Integer.parseInt(setGoal.getText().toString());
            TextView goal = findViewById(R.id.goalTextView);

            goal.setText(this.gallon + " / " + setGoal.getText().toString() + " gallons");

        } catch(NumberFormatException e) {
            Toast.makeText(this, "Invalid Goal", Toast.LENGTH_SHORT).show();
        }
    }

    public static void calculateTotal() {
        gallon = 0;
        // flush
        gallon += amounts[0] * 1.6;
        // dish
        gallon += amounts[1]  * 2.1;
        // wash
        gallon += amounts[2]  * 2.2;
        // shower
        gallon += amounts[3]  * 4;
        // sink
        gallon += amounts[4]  * 15;
        // hose
        gallon += amounts[5]  * 12;
        // sprink
        gallon += amounts[6]  * 4;
    }

}