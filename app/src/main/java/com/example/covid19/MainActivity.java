package com.example.covid19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenMapActivity();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenYtActivity();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenSanepidActivity();
            }
        });
    }

    private void OpenSanepidActivity() {
        Intent intent = new Intent(this, SanepidActivity.class);
        startActivity(intent);
    }

    private void OpenYtActivity() {
        Intent intent = new Intent(this, BoredActivity.class);
        startActivity(intent);
    }

    public void OpenMapActivity(){
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }
}
