package com.example.hackpnwsummer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TipsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        Button donateButton = findViewById(R.id.donateButton);
        Button tipsButton = findViewById(R.id.TipsButton);

        // Donate button
        donateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                // redirects to a charity page
                Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.purewaterfortheworld.org/"));
                startActivity(viewIntent);
            }
        });

        // tips button
        tipsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                // redirects to a tips for saving water page
                Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse("https://ecology.wa.gov/Issues-and-local-projects/Education-training/What-you-can-do/Water-conservation"));
                startActivity(viewIntent);
            }
        });
        Button backButton = findViewById(R.id.bootyCheeks);
        // exits the tips page
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TipsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}