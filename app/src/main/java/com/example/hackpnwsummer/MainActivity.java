package com.example.hackpnwsummer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;

public class MainActivity extends AppCompatActivity {

    static int progress = 0;
    static int goal = 100;
    static double gallon = 0;

    // [flush, dish, wash, shower, sink, hose, sprink]
    static double[] amounts = new double[7];
    static Double[] gallonPer = new Double[7];

    static ProgressBar waterProgressBar;
    static TextView gallonOverGoal;
    static SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        load();
        waterProgressBar = findViewById(R.id.waterProgressBar);
        Button buttonGoal = findViewById(R.id.setGoalButton);
        Button activityButton = findViewById(R.id.activityButton);
        Button listButton = findViewById(R.id.activityButton2);
        gallonOverGoal = findViewById(R.id.goalTextView);
        calculateTotal();
        gallonOverGoal.setText(gallon + " / " + goal + " Gallons");
        TextView moneySaved = findViewById(R.id.moneySaved);
        double moneySavedNum = ((gallon*30.0/748)*22);
        String moneySavedString = moneySavedNum + "";
        moneySaved.setText("Money Spent: $" + moneySavedString);
        for (int i = 0; i < moneySavedString.length(); i++) {
            if (i > 4) {
                moneySaved.setText("Money Spent: $" + moneySavedString.substring(0, 4));
                break;
            }
        }
        MainActivity.calculateTotal();
        // Puts the progress bar
        MainActivity.progress = (int)(MainActivity.gallon / ((double)MainActivity.goal) * 100);
        MainActivity.waterProgressBar.setProgress(progress);
        // This thread constantly updates the progress bar and money saved as gallons of water used
        // increases, updating every 5 seconds to save resources while also maintaining up to date info
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
        ImageView image = findViewById(R.id.settingImage);
        image.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

            }
        } );
        buttonGoal.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                try {
                    EditText setGoal = findViewById(R.id.goalEditText);

                    goal = Integer.parseInt(setGoal.getText().toString());

                    MainActivity.progress = (int)(MainActivity.gallon / ((double)MainActivity.goal) * 100);
                    MainActivity.waterProgressBar.setProgress(progress);
                    gallonOverGoal.setText(MainActivity.gallon + " / " + MainActivity.goal + " Gallons");

                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Invalid Goal", Toast.LENGTH_SHORT).show();
                }
            }
        });
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
        gallon = Double.parseDouble((gallon + "").substring(0, 3));
    }
    public void save() {
        sp = getSharedPreferences("UserData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("flush", Double.toString(amounts[0]));
        editor.putString("dish", Double.toString(amounts[1]));
        editor.putString("wash", Double.toString(amounts[2]));
        editor.putString("shower", Double.toString(amounts[3]));
        editor.putString("sink", Double.toString(amounts[4]));
        editor.putString("hose", Double.toString(amounts[5]));
        editor.putString("sprink", Double.toString(amounts[6]));
        editor.putInt("goal", goal);
        editor.commit();
    }

    public void load() {
        sp = getSharedPreferences("UserData", Context.MODE_PRIVATE);
        amounts[0] = Double.parseDouble(sp.getString("flush", "0"));
        amounts[1] = Double.parseDouble(sp.getString("dish", "0"));
        amounts[2] = Double.parseDouble(sp.getString("wash", "0"));
        amounts[3] = Double.parseDouble(sp.getString("shower", "0"));
        amounts[4] = Double.parseDouble(sp.getString("sink", "0"));
        amounts[5] = Double.parseDouble(sp.getString("hose", "0"));
        amounts[6] = Double.parseDouble(sp.getString("sprink", "0"));
        goal = sp.getInt("goal", 100);
    }

    @Override
    protected void onStop() {
        super.onStop();
        save();
    }


}


