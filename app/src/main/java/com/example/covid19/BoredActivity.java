package com.example.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BoredActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bored);
        btn1=findViewById(R.id.video);
        btn2=findViewById(R.id.receipt);
        btn3=findViewById(R.id.science);
        btn4=findViewById(R.id.techno);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenYtFunny();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenYtReceipt();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenYtScience();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenYtTechno();
            }
        });
    }

    private void OpenYtTechno() {
        Intent intent = new Intent(this, YoutubeActivity.class);
        intent.putExtra("which", 4);
        startActivity(intent);
    }

    private void OpenYtScience() {
        Intent intent = new Intent(this, YoutubeActivity.class);
        intent.putExtra("which", 3);
        startActivity(intent);
    }

    private void OpenYtReceipt() {
        Intent intent = new Intent(this, YoutubeActivity.class);
        intent.putExtra("which", 2);
        startActivity(intent);
    }

    private void OpenYtFunny() {
        Intent intent = new Intent(this, YoutubeActivity.class);
        intent.putExtra("which", 1);
        startActivity(intent);
    }
}
