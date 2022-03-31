package com.example.ptiles;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class listLvl extends AppCompatActivity {


    ListView lv;
    String[] ListName = {"Didacticiel","Guren no yumiya", "Gurenge", "Rumbling", "Tank!"};
    int[] ListImage = {

            R.drawable.didact_img,
            R.drawable.snk1_img,
            R.drawable.demon_slayer1_img,
            R.drawable.snk7_img,
            R.drawable.cowboy_bebop_img


    };

    Boolean musiquePlaying;
    MediaPlayer musique_menu,musique_transition;
    Boolean pause = false;
    int length;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_lvl);

        musiquePlaying = false;


        pause = true;

        lv = (ListView) findViewById(R.id.lv);
        MyAdapter myAdapter = new MyAdapter(listLvl.this, ListName, ListImage);
        lv.setAdapter(myAdapter);

        musique_transition = MediaPlayer.create(listLvl.this,R.raw.effet_transition);

        musique_menu = MediaPlayer.create(listLvl.this, R.raw.musique_menu);
        musique_menu.setLooping(true);
        if(!musiquePlaying) {
            musique_menu.start();
            musiquePlaying = true;
        }


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent level = new Intent(listLvl.this, level.class);
                musique_transition.start();
                switch (ListName[i]) {
                    case "Guren no yumiya":
                        level.putExtra("niveau", "snk1");
                        startActivity(level);
                        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                        break;

                    case "Gurenge":
                        level.putExtra("niveau", "demon_slayer1");
                        startActivity(level);
                        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                        break;

                    case "Rumbling":
                        level.putExtra("niveau", "snk7");
                        startActivity(level);
                        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

                        break;
                    case "Didacticiel":

                        Intent didacticiel = new Intent(listLvl.this, level_didacticiel.class);
                        didacticiel.putExtra("length_musique",musique_menu.getCurrentPosition()+1000);
                        startActivity(didacticiel);
                        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

                        break;
                    case "Tank!":

                        level.putExtra("niveau","cowboy");
                        startActivity(level);
                        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

                        break;
                }

            }
        });


    }
    @Override
    protected void onPause() {
        super.onPause();

        musique_menu.pause();
        length = musique_menu.getCurrentPosition();

        }

    @Override
    protected void onResume() {

        super.onResume();

        if (pause) { //Si pause est vrai on est bien dans le onResume

            musique_menu.seekTo(length);
            musique_menu.start();

        }
    }
}