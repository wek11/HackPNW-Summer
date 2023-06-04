package com.example.hackpnwsummer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class AddWaterActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_water2);
        Button button = findViewById(R.id.saveButton);
        Button backButton = findViewById(R.id.backButton);
        setValue();
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                MainActivity.gallonOverGoal.setText(MainActivity.gallon + " / " + MainActivity.goal + " Gallons");
                Intent intent = new Intent(AddWaterActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText flushes = findViewById(R.id.toiletFlushAmt);
                EditText dishwasher = findViewById(R.id.dishwasherAmt);
                EditText washingMachine = findViewById(R.id.washingMachineLoads);
                EditText shower = findViewById(R.id.showerTime);
                EditText faucet = findViewById(R.id.sinkTime);
                EditText hose = findViewById(R.id.gardenhoseTime);
                EditText sprinkler = findViewById(R.id.sprinklerTime);

                ArrayList<EditText> texts = new ArrayList<EditText>();
                texts.add(flushes);
                texts.add(dishwasher);
                texts.add(washingMachine);
                texts.add(shower);
                texts.add(faucet);
                texts.add(hose);
                texts.add(sprinkler);

                for (EditText text : texts) {
                    boolean cont = false;
                    char[] temp = text.getText().toString().toCharArray();

                    for (char letter : temp) {
                        if ('0' <= letter && letter <= '9') {
                            cont = true;
                            continue;
                        }
                    }
                    if (!cont) {
                        text.setText("0.0");
                    }

                }

                for (int i = 0; i < MainActivity.amounts.length; i++) {
                    MainActivity.amounts[i] = Double.parseDouble(texts.get(i).getText().toString());
                }

            }

        });
    }
    public void setValue(){
        EditText flushes = findViewById(R.id.toiletFlushAmt);
        EditText dishwasher = findViewById(R.id.dishwasherAmt);
        EditText washingMachine = findViewById(R.id.washingMachineLoads);
        EditText shower = findViewById(R.id.showerTime);
        EditText faucet = findViewById(R.id.sinkTime);
        EditText hose = findViewById(R.id.gardenhoseTime);
        EditText sprinkler = findViewById(R.id.sprinklerTime);

        ArrayList<EditText> texts = new ArrayList<EditText>();
        texts.add(flushes);
        texts.add(dishwasher);
        texts.add(washingMachine);
        texts.add(shower);
        texts.add(faucet);
        texts.add(hose);
        texts.add(sprinkler);
        for(int i = 0; i < texts.size(); i++){
            if(MainActivity.amounts[i] != 0){
                texts.get(i).setHint(texts.get(i).getHint().toString() + ": " + MainActivity.amounts[i] + "gallons");
            }
        }
    }
}