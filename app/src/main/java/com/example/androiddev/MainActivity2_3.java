package com.example.androiddev;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.MediaController;


public class MainActivity2_3 extends AppCompatActivity {

    VideoView videoAnimal;
    TextView txtDescription, txtAnimalNom;
    Button btnRetour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main23);

        videoAnimal = findViewById(R.id.videoAnimal);
        txtAnimalNom = findViewById(R.id.animalNom);
        txtDescription = findViewById(R.id.descr);
        btnRetour = findViewById(R.id.backMenu);

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoAnimal);
        videoAnimal.setMediaController(mediaController);

        String animal = getIntent().getStringExtra("animal");

        int videoResId = 0;
        String title = "";
        String description = "";

        switch (animal) {

            case "cat":
                videoResId = R.raw.vid_cat1;
                title = "Le Chat";
                description = "Le chat est un animal domestique agile et élégant.\nIl aime explorer son environnement et jouer avec tout ce qui bouge.\nIl peut être indépendant mais adore aussi les caresses.";
                break;

            case "dog":
                videoResId = R.raw.vid_dog;
                title = "Le Chien";
                description = "Le chien est loyal, protecteur et fidèle à son maître.\nIl adore les promenades et les jeux en plein air.\nC’est un compagnon affectueux et très social.";
                break;

            case "rabbit":
                videoResId = R.raw.vid_rabbit;
                title = "Le Lapin";
                description = "Le lapin est doux, rapide et très attentif à son environnement.\nIl aime grignoter des légumes et sauter partout.\nC’est un animal calme mais curieux, parfait pour les petits espaces.";
                break;

            case "fox":
                videoResId = R.raw.vid_fox;
                title = "Le Renard";
                description = "Le renard est malin et discret, très adaptable à son environnement.\nIl chasse principalement la nuit et se nourrit de petits animaux.\nIl est réputé pour son intelligence et sa ruse.";
                break;

            case "crow":
                videoResId = R.raw.vid_crow;
                title = "Le Corbeau";
                description = "Le corbeau est très intelligent et peut résoudre des problèmes complexes.\nIl peut reconnaître les visages et mémoriser des situations.\nIl est curieux et souvent observateur de son environnement.";
                break;

            case "squerrel":
                videoResId = R.raw.vid_squirrel;
                title = "L’Écureuil";
                description = "L’écureuil est vif et rapide, il adore grimper aux arbres.\nIl stocke des noisettes et autres graines pour l’hiver.\nC’est un animal curieux et très actif durant la journée.";
                break;

            case "elephant":
                videoResId = R.raw.vid_elephant;
                title = "L’Éléphant";
                description = "L’éléphant est le plus grand animal terrestre et très social.\nIl communique avec ses congénères par des sons et des gestes.\nIl est intelligent et possède une excellente mémoire.";
                break;

            case "penguin":
                videoResId = R.raw.vid_penguin;
                title = "Le Manchot";
                description = "Le manchot vit dans des régions froides et possède un corps adapté au froid.\nIl nage très bien mais ne peut pas voler.\nIl vit souvent en colonies et prend soin de ses petits.";
                break;

            case "bear":
                videoResId = R.raw.vid_bear;
                title = "L’Ours Polaire";
                description = "L’ours polaire est un grand prédateur des régions arctiques.\nIl est excellent nageur et se nourrit principalement de phoques.\nIl est adapté au froid avec son épaisse fourrure et sa couche de graisse.";
                break;

        }


        txtAnimalNom.setText(title);
        txtDescription.setText(description);

        videoAnimal.setVideoURI(
                Uri.parse("android.resource://" + getPackageName() + "/" + videoResId)
        );
        videoAnimal.start();

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