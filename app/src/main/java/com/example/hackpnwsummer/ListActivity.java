package com.example.hackpnwsummer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);
        // Gallons for toilet flushes
        TextView toiletFlush = findViewById(R.id.toiletFlushes);
        toiletFlush.setText("Toilet: " + (MainActivity.amounts[0] * 1.6) + " gallons");
        // Gallons for dishwasher loads
        TextView dishwasherLoads = findViewById(R.id.dishwasherLoads);
        dishwasherLoads.setText("Dishwasher: " + (MainActivity.amounts[1] * 4) + " gallons");
        // Gallons for washing machine loads
        TextView washingMachineLoads = findViewById(R.id.washingMachineLoads);
        washingMachineLoads.setText("Washing Machine: " + (MainActivity.amounts[2] * 15) + " gallons");
        // Gallons for time in shower
        TextView timeInShower = findViewById(R.id.timeInShower);
        timeInShower.setText("Shower: " + (MainActivity.amounts[3] * 2.1) + " gallons");
        // Gallons for time faucet was on
        TextView timeFaucetWasOn = findViewById(R.id.timeFaucetWasOn);
        timeFaucetWasOn.setText("Sink Faucet: " + (MainActivity.amounts[4] * 2.2) + " gallons");
        // Gallons used by Garden Hose
        TextView gardenHose = findViewById(R.id.timeGardenHoseWasOn);
        gardenHose.setText("Garden Hose: " + MainActivity.amounts[5] * 12);
        // Gallons for time time sprinkler was on
        TextView timeSprinklerWasOn = findViewById(R.id.timeSprinklerWasOn);
        timeSprinklerWasOn.setText("Sprinkler: " + (MainActivity.amounts[6] * 3.5   ) + " gallons");
        Button backButton = findViewById(R.id.backButton2);
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

}