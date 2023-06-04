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
                Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse("https://portal.ct.gov/DEEP/Water/Water-Quantity/Tips-for-Conserving-Water"));
                startActivity(viewIntent);
            }
        });
    }
}