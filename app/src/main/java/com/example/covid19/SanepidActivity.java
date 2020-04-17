package com.example.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SanepidActivity extends AppCompatActivity {
    Button button_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sanepid);
        button_back=findViewById(R.id.back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenMainAct();
            }
        });

        Intent viewIntent =
                new Intent("android.intent.action.VIEW",
                        Uri.parse("https://gis.gov.pl/problem/"));
        startActivity(viewIntent);
    }

    private void OpenMainAct() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
