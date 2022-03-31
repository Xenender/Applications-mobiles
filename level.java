package com.example.ptiles;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class level extends AppCompatActivity {

    Button startBtn;

    Button note1,note2,note3,note4,note11,note22,note33,note44,note111,note222,note333,note444;
    Button note1Img,note2Img,note3Img,note4Img,note11Img,note22Img,note33Img,note44Img,note111Img,note222Img,note333Img,note444Img;

    Button long1,long2,long3,long4;
    Button long1Img,long2Img,long3Img,long4Img;



    TextView score;
    ProgressBar progress_bar;
    LinearLayout layoutFail;
    RelativeLayout mainLayout2;
    ConstraintLayout mainLayout;




    AnimatorSet animSetXY1,animSetXY2,animSetXY3,animSetXY4,
            animSetXY11,animSetXY22,animSetXY33,animSetXY44,
            animSetXY111,animSetXY222,animSetXY333,animSetXY444,
            animSetXYL1,animSetXYL2,animSetXYL3,animSetXYL4;


    ObjectAnimator animX1,animY1,animX2,animY2,animX3,animY3,animX4,animY4,
            animX11,animY11,animX22,animY22,animX33,animY33,animX44,animY44,
            animX111,animY111,animX222,animY222,animX333,animY333,animX444,animY444,
            animXL1,animYL1,animXL2,animYL2,animXL3,animYL3,animXL4,animYL4;


    private  MediaPlayer musique;

    int speedNote;
    int speedLong;
    float multiplier;

    int indice;
    int[] snk1_tab = {1,4,2,3,2,2,1,4,3,2,2,1,4,2,3,2,4,3,4,1,3,2,3,4,22  //[25] = coup 1
            ,4,3,2,1,2,1,2,1,4,3,4,3,11,3,4,3,4,2,1,4,2,1,3,44,1,2,3,4,2,2,4,3,1,2,2,3,1,3,1,4,2,11,3,3,4,2,1,4,3,1,3,2,4,3,2,4,2,3//57/58
            ,1,1,1,3,3,2,2,2,4,4,4 //12
            ,1,2,3,4,4,3,2,1,4,1,3,2,4,5,4,3,1,33,1,1,2,1,4,1,1,2,3,3,4,2,1,3,4,3,2,1,3,11,4,3,2,1,2,3,1,2,2,1,4,33,1,4,2,3,1,22,4,2,1,2,3,4,4,3,2,1,4,1,3,2,4,5,4,3,1,33,1,1,2,1,4,1,1,2,3,3,4,2,1,3,4,3,2,1,3,11,4,3,2,1,2,3,1,22,4,1,4,3,1,4,2,33 //120
    };

    int[] tab_demonSlayer1 = {1,2,1, //0
            2,3,2,//3
            3,4,3,4,22,9999,9999,9999,2,//6
            1,2,3,//15
            3,2,1,//18
            4,4,22,9999,//21
            14//25
            ,1,3,2,4,13,2,4,3,2,14,2,3,2,1,24,1,2,3,44,9999,//26
            1,2,4,2,33,1,1,//46
            13,24,13,24,13,//53
            1,4,22,9999,13,2,3,24,1,2,33,9999//58
            ,1,3,2,4,13,2,4,3,2,14,2,3,2,1,24,1,2,3,44,9999,2,2,1,22,9999,2,1,//70
            13,24,13,24,13,//97
            1,2,3,2,3,//102
            13,24,13,24,13,//107
            1,2,3,4,1,2,4,3,2,11,9999,4,3,2,2,3,1,2,3,2,3,14,//112
            1,2,1,//134
            2,3,2,//137
            3,4,3,4,22,9999,9999,9999,2,//140
            4,3,2,//149
            2,3,4,//152
            2,2,33,9999//155
            ,1,3,2,4,13,2,4,3,2,14,2,3,2,1,24,1,2,3,44,9999, // =20 notes
            1,2,3,4,1,2,4,3,2,11,9999,4,3,2,2,3,1,2,3,2,3,14, //=22 notes
            1,3,2,4,13,2,4,3,2,14,2,3,2,1,24,1,2,3,44,9999,2,2,1,22,9999,2,1 // =27 notes
    };

    int[] snk7_tab = {1,4,2,3,//1,1.8sec
            3,2,//2
            3,3,3,//3
            1144,//4
            2,1,3,//5
            11,3,3,4,3,2,11,3,3,4,1,4,2,3,2,2,2,3,11,4,4,4,2,3,3,3,1,1,1,2,2,2,4,1, //6 , indice fin 47
            4,1,1,4,4,3,3,2,2,1,1,3,3,2,4,2,3,1,4,1,1,1,3,3,3,//7,20sec
            11,4,2,1,4,3,1,33,1,4,2,2,1,1,4,3,//8
            11,3,4,2,3,2,2,1,2,1,3,4,3,2,1,2,4,3,4,22,//9,fin 109
            4,1,2,13,3,4,1,2,3,1,2,13,24,3,2,3,1,3,4,4,//10,36sec
            1,1,4,1,4,3,4,2,4,2,1,2,1,3,2,1,//11 ,145
            1,3,2,2,3,11,3,4,3,1,2,24,2,1,3,2,4,3,2,1,1,2,3,2,14,2,3,4,3,2,1,1,1,22,4,4,3,1,4,1,4,24,1,2,2,1,3,1,11,3,//12,53sec , fin 195
            24,13,24,2,2,4,4,13,13,13,//13 55sec
            2,1,3,2,2,3,11,3,4,3,1,2,24,2,1,3,22,4,3,2,1,1,2,33,1,1,2,44,1,1,2,11,3,3,22,4,2,11,//14 1min08  , fin 243
            3,4,2,3,4,24,2,1,13,22,4,4,3,4,11,3,4,33,1,1,44,1,2,33,1,2,2,11,3,3,13,14,//15,1min20  fin 275
            14,14,14,//16
            3,3,1,24,24,13,3,1,14,3,13,3,13,2,2,1,1,4,4,1,2,3,4,3,3,1,1,3,3,24,24,24//17, fin


    };

    int[] tab_cowboy_bebop={1,4,2,3,4,11,// 0
            4,1,3,2,//6
            3,1,2,3,4,1,3,9999,9999,9999,4,3,2,1,3,//10
            1,2,3,44,9999,9999,9999,9999,4,3,2,11,9999,9999,9999,9999,1,2,3,44,9999,9999,9999,9999,4,3,2,11,//24
            2,4,3,1,4,2,1,4,2,33,4,1,3,22,//52
            4,3,2,11,9999,14,4,3,2,11,9999,2,4,1,3,2,4,1,1,22,//66
            1,2,3,44,9999,1,11,9999,4,3,2,11,9999,4,3,4,1,2,3,44,9999,11,9999,9999,4,3,2,11,4,3,44,//86
            2,4,3,1,4,2,1,4,2,9999,11,44,9999,9999,9999,22,33,9999,//117
            1,2,3,2,3,4,//136
            4,3,2,3,2,11,9999,1,//142
            1,4,1,4,1,4,1,4,1,4,1,4,9999,1144,9999//150
    };










    //LONG VAR
    final double[] firstTouch1 = {0.},firstTouch2 = {0.},firstTouch3 = {0.},firstTouch4 = {0.};
    final boolean[] longHold1={false},longHold2={false},longHold3={false},longHold4={false};



    final boolean[] arret={false};

    Animation transition;
    Vibrator vibrator;


    //VERIFIER QUE LES NOTES SONT TOUTES CLIQUES, type = tableau à 1 element de boulean -> pour que les valeurs puisse être modifiés à l'interieur des fonctions.
    final Boolean[] note1cliqued={false},note2cliqued={false},note3cliqued={false},note4cliqued={false},note11cliqued={false},note22cliqued={false},note33cliqued={false},note44cliqued={false},
            note111cliqued={false},note222cliqued={false},note333cliqued={false},note444cliqued={false},long1cliqued={false},long2cliqued={false},long3cliqued={false},long4cliqued={false};


    String niveau;

    Boolean launched = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);


        startBtn = findViewById(R.id.startBtn);

        note1=findViewById(R.id.note1);
        note2=findViewById(R.id.note2);
        note3=findViewById(R.id.note3);
        note4=findViewById(R.id.note4);
        note11=findViewById(R.id.note11);
        note22=findViewById(R.id.note22);
        note33=findViewById(R.id.note33);
        note44=findViewById(R.id.note44);
        note111 = findViewById(R.id.note111);
        note222 = findViewById(R.id.note222);
        note333 = findViewById(R.id.note333);
        note444 = findViewById(R.id.note444);

        note1Img=findViewById(R.id.note1Img);
        note2Img=findViewById(R.id.note2Img);
        note3Img=findViewById(R.id.note3Img);
        note4Img=findViewById(R.id.note4Img);
        note11Img=findViewById(R.id.note11Img);
        note22Img=findViewById(R.id.note22Img);
        note33Img=findViewById(R.id.note33Img);
        note44Img=findViewById(R.id.note44Img);
        note111Img=findViewById(R.id.note111Img);
        note222Img=findViewById(R.id.note222Img);
        note333Img=findViewById(R.id.note333Img);
        note444Img=findViewById(R.id.note444Img);



        long1=findViewById(R.id.long1);
        long2=findViewById(R.id.long2);
        long3=findViewById(R.id.long3);
        long4=findViewById(R.id.long4);

        long1Img=findViewById(R.id.long1Img);
        long2Img=findViewById(R.id.long2Img);
        long3Img=findViewById(R.id.long3Img);
        long4Img=findViewById(R.id.long4Img);


        score = findViewById(R.id.score);
        progress_bar = findViewById(R.id.progress_bar);

        layoutFail = findViewById(R.id.layoutFail);
        mainLayout = findViewById(R.id.mainLayout);
        mainLayout2=findViewById(R.id.mainLayout2);


        speedNote=1000;   //VITESSE DE BASE
        speedLong = 1388; //VITESSE DE BASE
        multiplier = 1.0f;

        //height +500 = augmentation de 250 SUR LA VITESSE


        int baseHeight = 2270;


        final boolean[] start = {false};


        //GET SCREEN SIZE

        DisplayMetrics metrics = this.getResources().getDisplayMetrics();
        int height = metrics.heightPixels; //LONGUEUR

        /*height = 2768;
        int diff =(height - baseHeight)%250;

         */

        /*if(diff>=1){
            speedNote += diff*50;
            speedNote += diff*50;

        }

         */


        //On change le temps de parcour de l'écran par les notes en fonction de la taille de l'écran pour obtenir la meme vitesse sur toute tailles d'écran

        speedNote = findTempsNote(height,3.27); //3.27 étant la vitesses voulu
        speedLong = findTempsLong(height,3.27);



        //Affichage de test ...
        //Toast.makeText(level.this,String.valueOf(findTempsLong(height,3.27)),Toast.LENGTH_LONG).show();




        transition = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blinking_animation150);

        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);



//RECUPERATION INTENT

        Intent recup = getIntent();
        niveau = recup.getStringExtra("niveau");



        //SET ANIM POUR IMAGE ET BOUTON


        animX1 = ObjectAnimator.ofFloat(note1, "y", -1200,height-200);//height = longueur ecran donc parcour tout l'ecran
        animY1 = ObjectAnimator.ofFloat(note1Img, "y", -1000,height);
        animSetXY1 = new AnimatorSet();
        animSetXY1.playTogether(animX1, animY1);
        animSetXY1.setDuration(2500);
        animSetXY1.setInterpolator(new LinearInterpolator());


        animX2 = ObjectAnimator.ofFloat(note2, "y", -1200,height-200);//height = longueur ecran donc parcour tout l'ecran
        animY2 = ObjectAnimator.ofFloat(note2Img, "y", -1000,height);
        animSetXY2 = new AnimatorSet();
        animSetXY2.playTogether(animX2, animY2);
        animSetXY2.setInterpolator(new LinearInterpolator());

        animX3 = ObjectAnimator.ofFloat(note3, "y", -1200,height-200);//height = longueur ecran donc parcour tout l'ecran
        animY3 = ObjectAnimator.ofFloat(note3Img, "y", -1000,height);
        animSetXY3 = new AnimatorSet();
        animSetXY3.playTogether(animX3, animY3);
        animSetXY3.setInterpolator(new LinearInterpolator());


        animX4 = ObjectAnimator.ofFloat(note4, "y", -1200,height-200);//height = longueur ecran donc parcourstout l'ecran
        animY4 = ObjectAnimator.ofFloat(note4Img, "y", -1000,height);
        animSetXY4 = new AnimatorSet();
        animSetXY4.playTogether(animX4, animY4);
        animSetXY4.setInterpolator(new LinearInterpolator());


        //SECONDES NOTES PAR LIGNES

        animX11 = ObjectAnimator.ofFloat(note11, "y", -1200,height-200);//height = longueur ecran donc parcour tout l'ecran
        animY11 = ObjectAnimator.ofFloat(note11Img, "y", -1000,height);
        animSetXY11 = new AnimatorSet();
        animSetXY11.playTogether(animX11, animY11);
        animSetXY11.setInterpolator(new LinearInterpolator());


        animX22 = ObjectAnimator.ofFloat(note22, "y", -1200,height-200);//height = longueur ecran donc parcour tout l'ecran
        animY22 = ObjectAnimator.ofFloat(note22Img, "y", -1000,height);
        animSetXY22 = new AnimatorSet();
        animSetXY22.playTogether(animX22, animY22);
        animSetXY22.setInterpolator(new LinearInterpolator());

        animX33 = ObjectAnimator.ofFloat(note33, "y", -1200,height-200);//height = longueur ecran donc parcour tout l'ecran
        animY33 = ObjectAnimator.ofFloat(note33Img, "y", -1000,height);
        animSetXY33 = new AnimatorSet();
        animSetXY33.playTogether(animX33, animY33);
        animSetXY33.setInterpolator(new LinearInterpolator());

        animX44 = ObjectAnimator.ofFloat(note44, "y", -1200,height-200);//height = longueur ecran donc parcours tout l'ecran
        animY44 = ObjectAnimator.ofFloat(note44Img, "y", -1000,height);
        animSetXY44 = new AnimatorSet();
        animSetXY44.playTogether(animX44, animY44);
        animSetXY44.setInterpolator(new LinearInterpolator());


        //TROISIEME PAR LIGNES

        animX111 = ObjectAnimator.ofFloat(note111, "y", -1200,height-200);//height = longueur ecran donc parcour tout l'ecran
        animY111 = ObjectAnimator.ofFloat(note111Img, "y", -1000,height);
        animSetXY111 = new AnimatorSet();
        animSetXY111.playTogether(animX111, animY111);
        animSetXY111.setInterpolator(new LinearInterpolator());


        animX222 = ObjectAnimator.ofFloat(note222, "y", -1200,height-200);//height = longueur ecran donc parcour tout l'ecran
        animY222 = ObjectAnimator.ofFloat(note222Img, "y", -1000,height);
        animSetXY222 = new AnimatorSet();
        animSetXY222.playTogether(animX222, animY222);
        animSetXY222.setInterpolator(new LinearInterpolator());

        animX333 = ObjectAnimator.ofFloat(note333, "y", -1200,height-200);//height = longueur ecran donc parcour tout l'ecran
        animY333 = ObjectAnimator.ofFloat(note333Img, "y", -1000,height);
        animSetXY333 = new AnimatorSet();
        animSetXY333.playTogether(animX333, animY333);
        animSetXY333.setInterpolator(new LinearInterpolator());

        animX444 = ObjectAnimator.ofFloat(note444, "y", -1200,height-200);//height = longueur ecran donc parcours tout l'ecran
        animY444 = ObjectAnimator.ofFloat(note444Img, "y", -1000,height);
        animSetXY444 = new AnimatorSet();
        animSetXY444.playTogether(animX444, animY444);
        animSetXY444.setInterpolator(new LinearInterpolator());


        //LONGUES

        animXL1 = ObjectAnimator.ofFloat(long1, "y", (-1*height),height);//height = longueur ecran donc parcours tout l'ecran
        animYL1 = ObjectAnimator.ofFloat(long1Img, "y", -1*height,height);
        animSetXYL1 = new AnimatorSet();
        animSetXYL1.playTogether(animXL1, animYL1);
        animSetXYL1.setInterpolator(new LinearInterpolator());

        animXL2 = ObjectAnimator.ofFloat(long2, "y", (-1*height),height);//height = longueur ecran donc parcours tout l'ecran
        animYL2 = ObjectAnimator.ofFloat(long2Img, "y", -1*height,height);
        animSetXYL2 = new AnimatorSet();
        animSetXYL2.playTogether(animXL2, animYL2);
        animSetXYL2.setInterpolator(new LinearInterpolator());

        animXL3 = ObjectAnimator.ofFloat(long3, "y", (-1*height),height);//height = longueur ecran donc parcours tout l'ecran
        animYL3 = ObjectAnimator.ofFloat(long3Img, "y", -1*height,height);
        animSetXYL3 = new AnimatorSet();
        animSetXYL3.playTogether(animXL3, animYL3);
        animSetXYL3.setInterpolator(new LinearInterpolator());

        animXL4 = ObjectAnimator.ofFloat(long4, "y", (-1*height),height);//height = longueur ecran donc parcours tout l'ecran
        animYL4 = ObjectAnimator.ofFloat(long4Img, "y", -1*height,height);
        animSetXYL4 = new AnimatorSet();
        animSetXYL4.playTogether(animXL4, animYL4);
        animSetXYL4.setInterpolator(new LinearInterpolator());







        animSetXY1.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animator) {
                note1Img.setAlpha(1.0f);;

            }

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onAnimationEnd(Animator animator) {

                restartAnimNote(note1,note1Img,note1cliqued);
            }

        });



        animSetXY2.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animator) {

                note2Img.setAlpha(1.0f);
            }

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onAnimationEnd(Animator animator) {
                restartAnimNote(note2,note2Img,note2cliqued);

            }
        });



        animSetXY3.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animator) {

                note3Img.setAlpha(1.0f);
            }

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onAnimationEnd(Animator animator) {
                restartAnimNote(note3,note3Img,note3cliqued);

            }

        });




        animSetXY4.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animator) {
                note4Img.setAlpha(1.0f);

            }

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onAnimationEnd(Animator animator) {
                restartAnimNote(note4,note4Img,note4cliqued);

            }
        });

        //


        animSetXY11.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animator) {
                note11Img.setAlpha(1.0f);

            }

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onAnimationEnd(Animator animator) {
                restartAnimNote(note11,note11Img,note11cliqued);
            }

        });



        animSetXY22.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animator) {

                note22Img.setAlpha(1.0f);

            }

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onAnimationEnd(Animator animator) {
                restartAnimNote(note22,note22Img,note22cliqued);
            }
        });



        animSetXY33.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animator) {

                note33Img.setAlpha(1.0f);
            }

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onAnimationEnd(Animator animator) {
                restartAnimNote(note33,note33Img,note33cliqued);
            }

        });




        animSetXY44.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animator) {
                note44Img.setAlpha(1.0f);
            }

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onAnimationEnd(Animator animator) {
                restartAnimNote(note44,note44Img,note44cliqued);
            }
        });
        //TROISIEME


        animSetXY111.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animator) {

                note111Img.setAlpha(1.0f);
            }

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onAnimationEnd(Animator animator) {
                restartAnimNote(note111,note111Img,note111cliqued);
            }

        });



        animSetXY222.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animator) {


                note222Img.setAlpha(1.0f);
            }

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onAnimationEnd(Animator animator) {
                restartAnimNote(note222,note222Img,note222cliqued);
            }
        });



        animSetXY333.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animator) {
                note333Img.setAlpha(1.0f);

            }

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onAnimationEnd(Animator animator) {
                restartAnimNote(note333,note333Img,note333cliqued);
            }

        });




        animSetXY444.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animator) {
                note444Img.setAlpha(1.0f);
            }

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onAnimationEnd(Animator animator) {
                restartAnimNote(note444,note444Img,note444cliqued);
            }
        });


        //LONG

        animSetXYL1.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animator) {
                long1Img.setAlpha(1.0f);
            }

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onAnimationEnd(Animator animator) {

                restartAnimLong(long1,long1Img,longHold1[0],long1cliqued,firstTouch1[0]);

            }
        });


        animSetXYL2.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animator) {
                long2Img.setAlpha(1.0f);
            }

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onAnimationEnd(Animator animator) {
                restartAnimLong(long2,long2Img,longHold2[0],long2cliqued,firstTouch2[0]);

            }
        });


        animSetXYL3.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animator) {
                long3Img.setAlpha(1.0f);
            }

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onAnimationEnd(Animator animator) {
                restartAnimLong(long3,long3Img,longHold3[0],long3cliqued,firstTouch3[0]);

            }
        });


        animSetXYL4.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animator) {

                long4Img.setAlpha(1.0f);

            }

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onAnimationEnd(Animator animator) {
                restartAnimLong(long4,long4Img,longHold4[0],long4cliqued,firstTouch4[0]);
            }
        });



        note1.setOnTouchListener(new View.OnTouchListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){

                    noteTouch(note1,note1Img,note1cliqued);
                }
                return false;
            }
        });


        note2.setOnTouchListener(new View.OnTouchListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){

                    noteTouch(note2,note2Img,note2cliqued);
                }
                return false;
            }
        });

        note3.setOnTouchListener(new View.OnTouchListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){

                    noteTouch(note3,note3Img,note3cliqued);
                }
                return false;
            }
        });

        note4.setOnTouchListener(new View.OnTouchListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){

                    noteTouch(note4,note4Img,note4cliqued);
                }
                return false;
            }
        });

        //SECOND

        note11.setOnTouchListener(new View.OnTouchListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){

                    noteTouch(note11,note11Img,note11cliqued);
                }
                return false;
            }
        });

        note22.setOnTouchListener(new View.OnTouchListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){

                    noteTouch(note22,note22Img,note22cliqued);
                }
                return false;
            }
        });

        note33.setOnTouchListener(new View.OnTouchListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){

                    noteTouch(note33,note33Img,note33cliqued);
                }
                return false;
            }
        });

        note44.setOnTouchListener(new View.OnTouchListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){

                    noteTouch(note44,note44Img,note44cliqued);
                }
                return false;
            }
        });

        //TROISIEME

        note111.setOnTouchListener(new View.OnTouchListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){

                    noteTouch(note111,note111Img,note111cliqued);
                }
                return false;
            }
        });

        note222.setOnTouchListener(new View.OnTouchListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){

                    noteTouch(note222,note222Img,note222cliqued);
                }
                return false;
            }
        });

        note333.setOnTouchListener(new View.OnTouchListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){

                    noteTouch(note333,note333Img,note333cliqued);
                }
                return false;
            }
        });

        note444.setOnTouchListener(new View.OnTouchListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){

                    noteTouch(note444,note444Img,note444cliqued);
                }
                return false;
            }
        });


        //LONG

        long1.setOnTouchListener(new View.OnTouchListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                longTouch(event,long1Img,long1cliqued,longHold1,firstTouch1,animSetXYL1);

                return false;
            }
        });

        long2.setOnTouchListener(new View.OnTouchListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                longTouch(event,long2Img,long2cliqued,longHold2,firstTouch2,animSetXYL2);
                return false;
            }
        });

        long3.setOnTouchListener(new View.OnTouchListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                longTouch(event,long3Img,long3cliqued,longHold3,firstTouch3,animSetXYL3);
                return false;
            }
        });

        long4.setOnTouchListener(new View.OnTouchListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                longTouch(event,long4Img,long4cliqued,longHold4,firstTouch4,animSetXYL4);
                return false;
            }
        });


        layoutFail.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {

                if(start[0]) {
                    gameOver();                }
            }
        });




        startBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                if(!start[0]) {
                    start[0] = true;
                    startBtn.setVisibility(Button.GONE);
                    launched = true;


                    switch (niveau){

                        case "snk1":
                            musique = MediaPlayer.create(level.this, R.raw.snk1);
                            progress_bar.setMax(musique.getDuration());

                            level_snk1 snk1 = new level_snk1(note1, note11, note111, note2, note22, note222, note3, note33, note333, note4, note44, note444,
                                    note1Img, note11Img, note111Img, note2Img, note22Img, note222Img, note3Img, note33Img, note333Img, note4Img, note44Img, note444Img,
                                    long1, long2, long3, long4,
                                    long1Img, long2Img, long3Img, long4Img,
                                    mainLayout2,
                                    mainLayout,
                                    animSetXY1, animSetXY2, animSetXY3, animSetXY4,
                                    animSetXY11, animSetXY22, animSetXY33, animSetXY44,
                                    animSetXY111, animSetXY222, animSetXY333, animSetXY444,
                                    animSetXYL1, animSetXYL2, animSetXYL3, animSetXYL4,

                                    speedNote,
                                    speedLong,
                                    multiplier,
                                    indice,
                                    snk1_tab,arret,transition,musique);


                            snk1.start();
                            break;

                        case "demon_slayer1":
                            musique = MediaPlayer.create(level.this, R.raw.demon_slayer1);
                            progress_bar.setMax(musique.getDuration());


                            level_demon_slayer1 dm = new level_demon_slayer1(note1, note11, note111, note2, note22, note222, note3, note33, note333, note4, note44, note444,
                                    note1Img, note11Img, note111Img, note2Img, note22Img, note222Img, note3Img, note33Img, note333Img, note4Img, note44Img, note444Img,
                                    long1, long2, long3, long4,
                                    long1Img, long2Img, long3Img, long4Img,
                                    mainLayout2,
                                    mainLayout,
                                    animSetXY1, animSetXY2, animSetXY3, animSetXY4,
                                    animSetXY11, animSetXY22, animSetXY33, animSetXY44,
                                    animSetXY111, animSetXY222, animSetXY333, animSetXY444,
                                    animSetXYL1, animSetXYL2, animSetXYL3, animSetXYL4,

                                    speedNote,
                                    speedLong,
                                    multiplier,
                                    indice,
                                    tab_demonSlayer1,arret,transition,musique);


                            dm.start();

                            break;

                        case "snk7":
                            musique=MediaPlayer.create(level.this,R.raw.op7);
                            progress_bar.setMax(musique.getDuration());

                            level_snk7 snk7 = new level_snk7(note1, note11, note111, note2, note22, note222, note3, note33, note333, note4, note44, note444,
                                    note1Img, note11Img, note111Img, note2Img, note22Img, note222Img, note3Img, note33Img, note333Img, note4Img, note44Img, note444Img,
                                    long1, long2, long3, long4,
                                    long1Img, long2Img, long3Img, long4Img,
                                    mainLayout2,
                                    mainLayout,
                                    animSetXY1, animSetXY2, animSetXY3, animSetXY4,
                                    animSetXY11, animSetXY22, animSetXY33, animSetXY44,
                                    animSetXY111, animSetXY222, animSetXY333, animSetXY444,
                                    animSetXYL1, animSetXYL2, animSetXYL3, animSetXYL4,

                                    speedNote,
                                    speedLong,
                                    multiplier,
                                    indice,
                                    snk7_tab,arret,transition,musique);


                            snk7.start();

                            break;
                        case "cowboy":
                            musique=MediaPlayer.create(level.this,R.raw.cowboy);
                            progress_bar.setMax(musique.getDuration());

                            level_cowboy_bebop cowboy_bebop = new level_cowboy_bebop(note1, note11, note111, note2, note22, note222, note3, note33, note333, note4, note44, note444,
                                    note1Img, note11Img, note111Img, note2Img, note22Img, note222Img, note3Img, note33Img, note333Img, note4Img, note44Img, note444Img,
                                    long1, long2, long3, long4,
                                    long1Img, long2Img, long3Img, long4Img,
                                    mainLayout2,
                                    mainLayout,
                                    animSetXY1, animSetXY2, animSetXY3, animSetXY4,
                                    animSetXY11, animSetXY22, animSetXY33, animSetXY44,
                                    animSetXY111, animSetXY222, animSetXY333, animSetXY444,
                                    animSetXYL1, animSetXYL2, animSetXYL3, animSetXYL4,

                                    speedNote,
                                    speedLong,
                                    multiplier,
                                    indice,
                                    tab_cowboy_bebop,arret,transition,musique);


                            cowboy_bebop.start();

                            break;


                    }

                }
            }
        });


        Handler mHandler = new Handler();
//Make sure you update Seekbar on UI thread
        level.this.runOnUiThread(new Runnable() {

            @Override
            public void run() {
                if(musique != null){
                    int mCurrentPosition = musique.getCurrentPosition();
                    progress_bar.setProgress(mCurrentPosition);
                }
                mHandler.postDelayed(this, 100);
            }
        });


    }
    @Override
    protected void onPause() {

        super.onPause();
        if(launched) gameOver();

    }

    @Override
    protected void onResume() {

        super.onResume();

    }



    void noteTouch(Button note,Button noteImg,Boolean[] clicked) {
        if (!clicked[0]) {
            int intscore = parseInt(score.getText().toString()) + 100;
            score.setText(String.valueOf(intscore));
            noteImg.setAlpha(0.3f);
            clicked[0] = true;
            note.setVisibility(Button.GONE);



            vibrator.vibrate(50); //VIBRATE
        }
    }

    void longTouch(MotionEvent event,Button longImg,Boolean[] cliqued, boolean[] hold,double[] firstTouch,AnimatorSet animSet){

        cliqued[0] = true;


        if (event.getAction()==MotionEvent.ACTION_DOWN) {
            hold[0]=true;
            firstTouch[0] = System.currentTimeMillis();
            longImg.setBackgroundResource(R.color.grey);


        } else if (event.getAction()==MotionEvent.ACTION_UP) {

            longImg.startAnimation(transition);
            longImg.setBackgroundResource(R.drawable.degrad_black_blue);
            longImg.setAlpha(0.3f);
            hold[0] = false;
            if(animSet.isStarted()){
                addLongPoint(System.currentTimeMillis()-firstTouch[0]);
            }
        }


    }

    void restartAnimNote(Button note,Button noteImg,Boolean[] cliqued){
        if(!cliqued[0]){
            gameOver(); //SI LA NOTE N'EST PAS CLIQUE QUAND L'ANIMATION FINI : elle est passé donc c'est perdu
        }
        cliqued[0] = false;

        note.setVisibility(Button.GONE);
        noteImg.setVisibility(Button.GONE);
    }

    void restartAnimLong(Button longue,Button longImg,Boolean hold,Boolean[] cliqued,double firstTouch){

        if(hold) {   //On prend le deuxieme temps
            addLongPoint(System.currentTimeMillis()-firstTouch);
        }

        if(!cliqued[0]){
            gameOver();                }
        cliqued[0] = false;
        longue.setVisibility(Button.GONE);
        longImg.setVisibility(Button.GONE);

    }


    void gameOver(){

        if(!arret[0]) {

            musique.stop();

            arret[0] = true;
            Intent i = new Intent(level.this, game_over.class);
            String s = score.getText().toString();
            i.putExtra("score", s);
            i.putExtra("niveau",niveau);
            i.putExtra("progress",musique.getCurrentPosition());

            startActivity(i);
            finish();

            overridePendingTransition(R.anim.fadein, R.anim.fadeout);

        }
    }




    void addLongPoint(double seconds){
        double dbscore = parseInt(score.getText().toString())+(seconds/5);
        int intscore = (int) dbscore;
        score.setText(String.valueOf(intscore));

    }


    int findTempsNote(int height,double vitesseDemande){

        int distance = 1000 + height;
        int temps = 1000;
        double vitesse = (double)distance / temps;
        if(vitesse < vitesseDemande){ //vitesse de reference = 3.27

            while(vitesse<vitesseDemande){
                temps = temps -1;
                vitesse = (double)distance / temps;

            }

        }
        else if(vitesse > vitesseDemande){

            while(vitesse>vitesseDemande){
                temps = temps +1;
                vitesse = (double)distance / temps;

            }

        }
        return temps;

    }
    int findTempsLong(int height,double vitesseDemande){

        int distance = height*2;
        int temps = 1388;
        double vitesse = (double)distance / temps;
        if(vitesse < vitesseDemande){ //vitesse de reference = 3.27

            while(vitesse<vitesseDemande){
                temps = temps -1;
                vitesse = (double)distance / temps;

            }

        }
        else if(vitesse > vitesseDemande){

            while(vitesse>vitesseDemande){
                temps = temps +1;
                vitesse = (double)distance / temps;

            }

        }
        return temps;
    }


}




/*

CREATION NIVEAU :

Handler handler = new Handler();
handler.postDelayed(new Runnable() {public void run() {

}
}, (long)(2000/multiplier));




new CountDownTimer((long)(5000/multiplier),(long)(5000/multiplier)) {

            @Override
            public void onTick(long millisUntilFinished) {
                // do something after 1s
            }

            @Override
            public void onFinish() {


            }

        }.start();



        ANIMATOR TOGETHER

        ObjectAnimator animX = ObjectAnimator.ofFloat(myView, "x", 50f);
ObjectAnimator animY = ObjectAnimator.ofFloat(myView, "y", 100f);
AnimatorSet animSetXY = new AnimatorSet();
animSetXY.playTogether(animX, animY);
animSetXY.start();


 */
