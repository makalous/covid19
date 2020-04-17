package com.example.covid19;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class YoutubeActivity extends AppCompatActivity {

    int choice=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        List<String> funny = new ArrayList<String>();
        funny.add("frUKZFpmAfg"); funny.add("FFLTU9eIijw"); funny.add("DRhoplyBAWc");

        List<String> receipt = new ArrayList<String>();
        receipt.add("sv3TXMSv6Lw"); receipt.add("YfDKe2b9Si4"); receipt.add("G8DAY_2vyL4");

        List<String> science = new ArrayList<String>();
        science.add("kD5yc1LQrpQ"); science.add("-EVqrDlAqYo"); science.add("IUHkhB366tE");

        List<String> tech = new ArrayList<String>();
        tech.add("_CTUs_2hq6Y"); tech.add("sL8AsaEJDdo"); tech.add("39YqCLYELnM");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);

        if(getIntent().hasExtra("which")) {
            choice=getIntent().getExtras().getInt("which");
        }
        LinearLayout layout = (LinearLayout) findViewById(R.id.linearYt);
        YouTubePlayerView youTubePlayerView = new YouTubePlayerView(this);
        layout.addView(youTubePlayerView);
        getLifecycle().addObserver(youTubePlayerView);

        Random rand = new Random();

        String n="";
        if (choice==1) n = funny.get(rand.nextInt(funny.size()));
        else if (choice==2) n = receipt.get(rand.nextInt(receipt.size()));
        else if (choice==3)     n = science.get(rand.nextInt(science.size()));
        else if (choice==4)    n = tech.get(rand.nextInt(tech.size()));
        else n = tech.get(rand.nextInt(tech.size()));


        final String finalN = n;
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {

            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = finalN;
                youTubePlayer.loadVideo(videoId, 0);
            }
        });


    }
}
