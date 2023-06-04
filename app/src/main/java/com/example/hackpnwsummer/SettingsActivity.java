package com.example.hackpnwsummer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

import java.util.ArrayList;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        Button backButton = findViewById(R.id.BackButtonSetting);
        setValue();
        backButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void setValue(){
        EditText flushes = findViewById(R.id.editTextText);
        EditText dishwasher = findViewById(R.id.editTextText2);
        EditText washingMachine = findViewById(R.id.editTextText3);
        EditText shower = findViewById(R.id.editTextText4);
        EditText faucet = findViewById(R.id.editTextText5);
        EditText hose = findViewById(R.id.editTextText6);
        EditText sprinkler = findViewById(R.id.editTextText7);

        ArrayList<EditText> texts = new ArrayList<EditText>();
        texts.add(flushes);
        texts.add(dishwasher);
        texts.add(washingMachine);
        texts.add(shower);
        texts.add(faucet);
        texts.add(hose);
        texts.add(sprinkler);
        for(int i = 0; i < texts.size(); i++){
            if(MainActivity.gallonPer[i] != 0){
                texts.get(i).setHint(texts.get(i).getHint().toString() + ": " + MainActivity.amounts[i] + "gallons");
            }
        }
    }
}