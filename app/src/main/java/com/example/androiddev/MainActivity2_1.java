package com.example.androiddev ;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2_1 extends AppCompatActivity {

    Button btnRetour;
    private MediaPlayer mediaPlayer;
    ImageButton img1, img2, img3, img4, img5, img6, img7, img8, img9;
    private View.OnClickListener chiffreClickListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main21);

        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        img5 = findViewById(R.id.img5);
        img6 = findViewById(R.id.img6);
        img7 = findViewById(R.id.img7);
        img8 = findViewById(R.id.img8);
        img9 = findViewById(R.id.img9);

        chiffreClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = v.getId();
                String viewName = getResources().getResourceEntryName(id);
                char lastChar = viewName.charAt(viewName.length() - 1);

                int soundResId=0;
                switch (lastChar) {
                    case '1': soundResId = R.raw.a1; break;
                    case '2': soundResId = R.raw.a2; break;
                    case '3': soundResId = R.raw.a3; break;
                    case '4': soundResId = R.raw.a4; break;
                    case '5': soundResId = R.raw.a5; break;
                    case '6': soundResId = R.raw.a6; break;
                    case '7': soundResId = R.raw.a7; break;
                    case '8': soundResId = R.raw.a8; break;
                    case '9': soundResId = R.raw.a9; break;
                }

                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = null;
                }

                mediaPlayer = MediaPlayer.create(getApplicationContext(), soundResId);
                mediaPlayer.start();
            }
        };

        img1.setOnClickListener(chiffreClickListener);
        img2.setOnClickListener(chiffreClickListener);
        img3.setOnClickListener(chiffreClickListener);
        img4.setOnClickListener(chiffreClickListener);
        img5.setOnClickListener(chiffreClickListener);
        img6.setOnClickListener(chiffreClickListener);
        img7.setOnClickListener(chiffreClickListener);
        img8.setOnClickListener(chiffreClickListener);
        img9.setOnClickListener(chiffreClickListener);

        btnRetour = findViewById(R.id.btnBack7);

        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}