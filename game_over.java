package com.example.ptiles;

import static java.lang.Integer.parseInt;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class game_over extends AppCompatActivity {

    RelativeLayout over_Layout,over_Layout_score,over_Layout_score_max;
    CircleImageView over_circle_image;
    ImageView over_img_menu,over_img_rejouer;
    TextView over_score;
    ProgressBar over_Progress_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        over_circle_image = findViewById(R.id.over_circle_image);

        over_Layout = findViewById(R.id.over_Layout);
        over_Layout_score = findViewById(R.id.over_Layout_score);
        over_Progress_bar = findViewById(R.id.over_Progress_bar);
        over_img_menu = findViewById(R.id.over_img_menu);
        over_img_rejouer = findViewById(R.id.over_img_rejouer);

        over_score = findViewById(R.id.over_score);


        //RECUPERATION INTENT

        Intent i = getIntent();
        String score,niveau;
        int progress;
        score = i.getStringExtra("score");
        niveau = i.getStringExtra("niveau");
        progress = i.getIntExtra("progress",0);



        over_score.setText(score);

        switch (niveau){
            case "snk1":
                over_circle_image.setImageResource(R.drawable.snk1_img);
                MediaPlayer musique1= MediaPlayer.create(game_over.this,R.raw.snk1);
                over_Progress_bar.setMax(musique1.getDuration());
                break;

            case "demon_slayer1":
                over_circle_image.setImageResource(R.drawable.demon_slayer1_img);
                MediaPlayer musique2= MediaPlayer.create(game_over.this,R.raw.demon_slayer1);
                over_Progress_bar.setMax(musique2.getDuration());

                break;

            case "snk7":
                over_circle_image.setImageResource(R.drawable.snk7_img);
                MediaPlayer musique3= MediaPlayer.create(game_over.this,R.raw.op7);
                over_Progress_bar.setMax(musique3.getDuration());
                break;
            case "cowboy":
                over_circle_image.setImageResource(R.drawable.cowboy_bebop_img);
                MediaPlayer musique4= MediaPlayer.create(game_over.this,R.raw.cowboy);
                over_Progress_bar.setMax(musique4.getDuration());
                break;

        }
        over_Progress_bar.setProgress(progress);


        over_img_rejouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(game_over.this, level.class);
                j.putExtra("niveau",niveau);
                startActivity(j);
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });

        over_img_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(game_over.this, listLvl.class);
                startActivity(j);
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });



    }

}