package com.example.androiddev;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2_2 extends AppCompatActivity {

    ImageButton imgCat, imgDog, imgRabbit, imgFox, imgCrow, imgSquerrel, imgElephant, imgPenguin, imgBear;
    Button btnRetour;
    View.OnClickListener animalClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main22);


        imgCat = findViewById(R.id.imgCat);
        imgDog = findViewById(R.id.imgDog);
        imgRabbit = findViewById(R.id.imgRabbit);
        imgFox = findViewById(R.id.imgFox);
        imgCrow = findViewById(R.id.imgCrow);
        imgSquerrel = findViewById(R.id.imgSquerrel);
        imgElephant = findViewById(R.id.imgElephant);
        imgPenguin = findViewById(R.id.imgPenguin);
        imgBear = findViewById(R.id.imgBear);
        btnRetour = findViewById(R.id.btnBack12);

        animalClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = v.getId();
                String viewName = getResources().getResourceEntryName(id);
                String animalName = viewName.substring(3).toLowerCase();

                Intent intent = new Intent(getApplicationContext(), MainActivity2_3.class);

                switch (animalName) {
                    case "cat":
                    case "dog":
                    case "rabbit":
                    case "crow":
                    case "fox":
                    case "squerrel":
                    case "elephant":
                    case "bear":
                    case "penguin":
                        intent.putExtra("animal", animalName);
                        break;
                }

                startActivity(intent);
            }
        };

        imgCat.setOnClickListener(animalClickListener);
        imgDog.setOnClickListener(animalClickListener);
        imgFox.setOnClickListener(animalClickListener);
        imgCrow.setOnClickListener(animalClickListener);
        imgSquerrel.setOnClickListener(animalClickListener);
        imgBear.setOnClickListener(animalClickListener);
        imgElephant.setOnClickListener(animalClickListener);
        imgRabbit.setOnClickListener(animalClickListener);
        imgPenguin.setOnClickListener(animalClickListener);

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
}