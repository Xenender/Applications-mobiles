package com.example.ptiles;

import android.animation.AnimatorSet;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.RelativeLayout;

public class level_demon_slayer1 extends MainActivity{


    public Button note1,note2,note3,note4,note11,note22,note33,note44,note111,note222,note333,note444;
    public Button note1Img,note2Img,note3Img,note4Img,note11Img,note22Img,note33Img,note44Img,note111Img,note222Img,note333Img,note444Img;

    public Button long1,long2,long3,long4;
    public Button long1Img,long2Img,long3Img,long4Img;

    public RelativeLayout mainLayout2;
    public ConstraintLayout mainLayout;


    public AnimatorSet animSetXY1,animSetXY2,animSetXY3,animSetXY4,
            animSetXY11,animSetXY22,animSetXY33,animSetXY44,
            animSetXY111,animSetXY222,animSetXY333,animSetXY444,
            animSetXYL1,animSetXYL2,animSetXYL3,animSetXYL4;


    public MediaPlayer musique;

    public int speedNote;
    public int speedLong;
    public float multiplier;

    public int indice;
    /*int[] tab = {1,4,2,3,2,2,1,4,3,2,2,1,4,2,3,2,4,3,4,1,3,2,3,4,22  //[25] = coup 1
            ,4,3,2,1,2,1,2,1,4,3,4,3,11,3,4,3,4,2,1,4,2,1,3,44,1,2,3,4,2,2,4,3,1,2,2,3,1,3,1,4,2,11,3,3,4,2,1,4,3,1,3,2,4,3,2,4,2,3//57/58
            ,1,1,1,3,3,2,2,2,4,4,4 //12
            ,1,2,3,4,4,3,2,1,4,1,3,2,4,5,4,3,1,33,1,1,2,1,4,1,1,2,3,3,4,2,1,3,4,3,2,1,3,11,4,3,2,1,2,3,1,2,2,1,4,33,1,4,2,3,1,22,4,2,1,2,3,4,4,3,2,1,4,1,3,2,4,5,4,3,1,33,1,1,2,1,4,1,1,2,3,3,4,2,1,3,4,3,2,1,3,11,4,3,2,1,2,3,1,22,4,1,4,3,1,4,2,33 //120
    };

     */
    public int[] tab_demonSlayer1;
    public boolean[] arret;
    public Animation transition;


    public level_demon_slayer1(Button note1,Button note11,Button note111,Button note2,Button note22,Button note222,Button note3,Button note33,Button note333,Button note4,Button note44,Button note444,
                      Button note1Img,Button note11Img,Button note111Img,Button note2Img,Button note22Img,Button note222Img,Button note3Img,Button note33Img,Button note333Img,Button note4Img,Button note44Img,Button note444Img,
                      Button long1,Button long2,Button long3,Button long4,
                      Button long1Img,Button long2Img,Button long3Img,Button long4Img,
                      RelativeLayout mainLayout2,
                      ConstraintLayout mainLayout,
                      AnimatorSet animSetXY1,AnimatorSet animSetXY2,AnimatorSet animSetXY3,AnimatorSet animSetXY4,
                      AnimatorSet animSetXY11,AnimatorSet animSetXY22,AnimatorSet animSetXY33,AnimatorSet animSetXY44,
                      AnimatorSet animSetXY111,AnimatorSet animSetXY222,AnimatorSet animSetXY333,AnimatorSet animSetXY444,
                      AnimatorSet animSetXYL1,AnimatorSet animSetXYL2,AnimatorSet animSetXYL3,AnimatorSet animSetXYL4,

                      int speedNote,
                      int speedLong,
                      float multiplier,
                      int indice,
                      int[] tab_demonSlayer1,
                      boolean[] arret,Animation transition,MediaPlayer musique


    ){

        this.note1 = note1;this.note2= note2;this.note3= note3;this.note4= note4;this.note11= note11;this.note22= note22;this.note33= note33;this.note44= note44;this.note111= note111;this.note222= note222;this.note333= note333;this.note444= note444;

        this.note1Img = note1Img;this.note2Img= note2Img;this.note3Img= note3Img;this.note4Img= note4Img;this.note11Img= note11Img;this.note22Img= note22Img;this.note33Img= note33Img;this.note44Img= note44Img;this.note111Img= note111Img;this.note222Img= note222Img;this.note333Img= note333Img;this.note444Img= note444Img;

        this.long1 = long1;this.long2= long2;this.long3= long3;this.long4= long4;
        this.long1Img = long1Img;this.long2Img= long2Img;this.long3Img= long3Img;this.long4Img= long4Img;
        this.mainLayout = mainLayout;this.mainLayout2 = mainLayout2;

        this.animSetXY1=animSetXY1;this.animSetXY2=animSetXY2;this.animSetXY3=animSetXY3;this.animSetXY4=animSetXY4;
        this.animSetXY11=animSetXY11;this.animSetXY22=animSetXY22;this.animSetXY33=animSetXY33;this.animSetXY44=animSetXY44;
        this.animSetXY111=animSetXY111;this.animSetXY222=animSetXY222;this.animSetXY333=animSetXY333;this.animSetXY444=animSetXY444;
        this.animSetXYL1=animSetXYL1;this.animSetXYL2=animSetXYL2;this.animSetXYL3=animSetXYL3;this.animSetXYL4=animSetXYL4;

        this.speedNote = speedNote;this.speedLong=speedLong;this.multiplier=multiplier;this.indice=indice;
        this.tab_demonSlayer1 = tab_demonSlayer1;this.arret = arret;this.transition = transition;this.musique = musique;
    }

    public void setSpeedNote(int speed){
        this.speedNote = speed;
    }
    public void setSpeedLong(int speed){
        this.speedLong = speed;
    }
    public void setMultiplier(float speed){
        this.multiplier = speed;
    }
    public int getSpeedNote(){
        return this.speedNote;
    }
    public int getSpeedLong(){
        return this.speedLong;
    }
    public float getMultiplier(){
        return this.multiplier;
    }


    public void fall(int[] tab){

        if(!arret[0]) {


            if(tab[indice]==1144) {
                long1Img.setVisibility(Button.VISIBLE);
                long1.setVisibility(Button.VISIBLE);
                long4Img.setVisibility(Button.VISIBLE);
                long4.setVisibility(Button.VISIBLE);
                animSetXYL1.start();
                animSetXYL4.start();
            }


            if(tab[indice]==2244) {
                long2Img.setVisibility(Button.VISIBLE);
                long2.setVisibility(Button.VISIBLE);
                long4Img.setVisibility(Button.VISIBLE);
                long4.setVisibility(Button.VISIBLE);
                animSetXYL2.start();
                animSetXYL4.start();
            }


            if(tab[indice]==1133) {
                long1Img.setVisibility(Button.VISIBLE);
                long1.setVisibility(Button.VISIBLE);
                long3Img.setVisibility(Button.VISIBLE);
                long3.setVisibility(Button.VISIBLE);
                animSetXYL1.start();
                animSetXYL3.start();
            }




            if (tab[indice] == 1) {
                if (!animSetXY1.isStarted()) {
                    note1Img.setVisibility(Button.VISIBLE);
                    note1.setVisibility(Button.VISIBLE);
                    animSetXY1.start();
                } else {
                    if (!animSetXY11.isStarted()) {
                        note11Img.setVisibility(Button.VISIBLE);
                        note11.setVisibility(Button.VISIBLE);
                        animSetXY11.start();
                    } else {
                        note111Img.setVisibility(Button.VISIBLE);
                        note111.setVisibility(Button.VISIBLE);
                        animSetXY111.start();
                    }
                }
            } else if (tab[indice] == 2) {
                if (!animSetXY2.isStarted()) {
                    note2Img.setVisibility(Button.VISIBLE);
                    note2.setVisibility(Button.VISIBLE);
                    animSetXY2.start();


                } else {
                    if (!animSetXY22.isStarted()) {
                        note22Img.setVisibility(Button.VISIBLE);
                        note22.setVisibility(Button.VISIBLE);
                        animSetXY22.start();
                    } else {
                        note222Img.setVisibility(Button.VISIBLE);
                        note222.setVisibility(Button.VISIBLE);
                        animSetXY222.start();
                    }
                }
            } else if (tab[indice] == 3) {
                if (!animSetXY3.isStarted()) {
                    note3Img.setVisibility(Button.VISIBLE);
                    note3.setVisibility(Button.VISIBLE);
                    animSetXY3.start();
                } else {
                    if (!animSetXY33.isStarted()) {
                        note33Img.setVisibility(Button.VISIBLE);
                        note33.setVisibility(Button.VISIBLE);
                        animSetXY33.start();
                    } else {
                        note333Img.setVisibility(Button.VISIBLE);
                        note333.setVisibility(Button.VISIBLE);
                        animSetXY333.start();
                    }
                }
            } else if (tab[indice] == 4) {
                if (!animSetXY4.isStarted()) {
                    note4Img.setVisibility(Button.VISIBLE);
                    note4.setVisibility(Button.VISIBLE);
                    animSetXY4.start();
                } else {
                    if (!animSetXY44.isStarted()) {
                        note44Img.setVisibility(Button.VISIBLE);
                        note44.setVisibility(Button.VISIBLE);
                        animSetXY44.start();
                    } else {
                        note444Img.setVisibility(Button.VISIBLE);
                        note444.setVisibility(Button.VISIBLE);
                        animSetXY444.start();
                    }
                }
            } else if (tab[indice] == 12) {
                if (!animSetXY1.isStarted()) {
                    note1Img.setVisibility(Button.VISIBLE);
                    note1.setVisibility(Button.VISIBLE);
                    animSetXY1.start();
                } else {
                    if (!animSetXY11.isStarted()) {
                        note11Img.setVisibility(Button.VISIBLE);
                        note11.setVisibility(Button.VISIBLE);
                        animSetXY11.start();
                    } else {
                        note111Img.setVisibility(Button.VISIBLE);
                        note111.setVisibility(Button.VISIBLE);
                        animSetXY111.start();
                    }
                }
                if (!animSetXY2.isStarted()) {
                    note2Img.setVisibility(Button.VISIBLE);
                    note2.setVisibility(Button.VISIBLE);
                    animSetXY2.start();
                } else {
                    if (!animSetXY22.isStarted()) {
                        note22Img.setVisibility(Button.VISIBLE);
                        note22.setVisibility(Button.VISIBLE);
                        animSetXY22.start();
                    } else {
                        note222Img.setVisibility(Button.VISIBLE);
                        note222.setVisibility(Button.VISIBLE);
                        animSetXY222.start();
                    }
                }
            } else if (tab[indice] == 13) {
                if (!animSetXY1.isStarted()) {
                    note1Img.setVisibility(Button.VISIBLE);
                    note1.setVisibility(Button.VISIBLE);
                    animSetXY1.start();
                } else {
                    if (!animSetXY11.isStarted()) {
                        note11Img.setVisibility(Button.VISIBLE);
                        note11.setVisibility(Button.VISIBLE);
                        animSetXY11.start();
                    } else {
                        note111Img.setVisibility(Button.VISIBLE);
                        note111.setVisibility(Button.VISIBLE);
                        animSetXY111.start();
                    }
                }
                if (!animSetXY3.isStarted()) {
                    note3Img.setVisibility(Button.VISIBLE);
                    note3.setVisibility(Button.VISIBLE);
                    animSetXY3.start();
                } else {
                    if (!animSetXY33.isStarted()) {
                        note33Img.setVisibility(Button.VISIBLE);
                        note33.setVisibility(Button.VISIBLE);
                        animSetXY33.start();
                    } else {
                        note333Img.setVisibility(Button.VISIBLE);
                        note333.setVisibility(Button.VISIBLE);
                        animSetXY333.start();
                    }
                }
            } else if (tab[indice] == 14) {
                if (!animSetXY1.isStarted()) {
                    note1Img.setVisibility(Button.VISIBLE);
                    note1.setVisibility(Button.VISIBLE);
                    animSetXY1.start();
                } else {
                    if (!animSetXY11.isStarted()) {
                        note11Img.setVisibility(Button.VISIBLE);
                        note11.setVisibility(Button.VISIBLE);
                        animSetXY11.start();
                    } else {
                        note111Img.setVisibility(Button.VISIBLE);
                        note111.setVisibility(Button.VISIBLE);
                        animSetXY111.start();
                    }
                }
                if (!animSetXY4.isStarted()) {
                    note4Img.setVisibility(Button.VISIBLE);
                    note4.setVisibility(Button.VISIBLE);
                    animSetXY4.start();
                } else {
                    if (!animSetXY44.isStarted()) {
                        note44Img.setVisibility(Button.VISIBLE);
                        note44.setVisibility(Button.VISIBLE);
                        animSetXY44.start();
                    } else {
                        note444Img.setVisibility(Button.VISIBLE);
                        note444.setVisibility(Button.VISIBLE);
                        animSetXY444.start();
                    }
                }
            } else if (tab[indice] == 23) {
                if (!animSetXY2.isStarted()) {
                    note2Img.setVisibility(Button.VISIBLE);
                    note2.setVisibility(Button.VISIBLE);
                    animSetXY2.start();
                } else {
                    if (!animSetXY22.isStarted()) {
                        note22Img.setVisibility(Button.VISIBLE);
                        note22.setVisibility(Button.VISIBLE);
                        animSetXY22.start();
                    } else {
                        note222Img.setVisibility(Button.VISIBLE);
                        note222.setVisibility(Button.VISIBLE);
                        animSetXY222.start();
                    }
                }
                if (!animSetXY3.isStarted()) {
                    note3Img.setVisibility(Button.VISIBLE);
                    note3.setVisibility(Button.VISIBLE);
                    animSetXY3.start();
                } else {
                    if (!animSetXY33.isStarted()) {
                        note33Img.setVisibility(Button.VISIBLE);
                        note33.setVisibility(Button.VISIBLE);
                        animSetXY33.start();
                    } else {
                        note333Img.setVisibility(Button.VISIBLE);
                        note333.setVisibility(Button.VISIBLE);
                        animSetXY333.start();
                    }
                }
            } else if (tab[indice] == 24) {
                if (!animSetXY2.isStarted()) {
                    note2Img.setVisibility(Button.VISIBLE);
                    note2.setVisibility(Button.VISIBLE);
                    animSetXY2.start();
                } else {
                    if (!animSetXY22.isStarted()) {
                        note22Img.setVisibility(Button.VISIBLE);
                        note22.setVisibility(Button.VISIBLE);
                        animSetXY22.start();
                    } else {
                        note222Img.setVisibility(Button.VISIBLE);
                        note222.setVisibility(Button.VISIBLE);
                        animSetXY222.start();
                    }
                }
                if (!animSetXY4.isStarted()) {
                    note4Img.setVisibility(Button.VISIBLE);
                    note4.setVisibility(Button.VISIBLE);
                    animSetXY4.start();
                } else {
                    if (!animSetXY44.isStarted()) {
                        note44Img.setVisibility(Button.VISIBLE);
                        note44.setVisibility(Button.VISIBLE);
                        animSetXY44.start();
                    } else {
                        note444Img.setVisibility(Button.VISIBLE);
                        note444.setVisibility(Button.VISIBLE);
                        animSetXY444.start();
                    }
                }
            } else if (tab[indice] == 34) {
                if (!animSetXY3.isStarted()) {
                    note3Img.setVisibility(Button.VISIBLE);
                    note3.setVisibility(Button.VISIBLE);
                    animSetXY3.start();
                } else {
                    if (!animSetXY33.isStarted()) {
                        note33Img.setVisibility(Button.VISIBLE);
                        note33.setVisibility(Button.VISIBLE);
                        animSetXY33.start();
                    } else {
                        note333Img.setVisibility(Button.VISIBLE);
                        note333.setVisibility(Button.VISIBLE);
                        animSetXY333.start();
                    }
                }
                if (!animSetXY4.isStarted()) {
                    note4Img.setVisibility(Button.VISIBLE);
                    note4.setVisibility(Button.VISIBLE);
                    animSetXY4.start();
                } else {
                    if (!animSetXY44.isStarted()) {
                        note44Img.setVisibility(Button.VISIBLE);
                        note44.setVisibility(Button.VISIBLE);
                        animSetXY44.start();
                    } else {
                        note444Img.setVisibility(Button.VISIBLE);
                        note444.setVisibility(Button.VISIBLE);
                        animSetXY444.start();
                    }
                }
            } else if (tab[indice] == 123) {
                if (!animSetXY1.isStarted()) {
                    note1Img.setVisibility(Button.VISIBLE);
                    note1.setVisibility(Button.VISIBLE);
                    animSetXY1.start();
                } else {
                    if (!animSetXY11.isStarted()) {
                        note11Img.setVisibility(Button.VISIBLE);
                        note11.setVisibility(Button.VISIBLE);
                        animSetXY11.start();
                    } else {
                        note111Img.setVisibility(Button.VISIBLE);
                        note111.setVisibility(Button.VISIBLE);
                        animSetXY111.start();
                    }
                }
                if (!animSetXY2.isStarted()) {
                    note2Img.setVisibility(Button.VISIBLE);
                    note2.setVisibility(Button.VISIBLE);
                    animSetXY2.start();
                } else {
                    if (!animSetXY22.isStarted()) {
                        note22Img.setVisibility(Button.VISIBLE);
                        note22.setVisibility(Button.VISIBLE);
                        animSetXY22.start();
                    } else {
                        note222Img.setVisibility(Button.VISIBLE);
                        note222.setVisibility(Button.VISIBLE);
                        animSetXY222.start();
                    }
                }
                if (!animSetXY3.isStarted()) {
                    note3Img.setVisibility(Button.VISIBLE);
                    note3.setVisibility(Button.VISIBLE);
                    animSetXY3.start();
                } else {
                    if (!animSetXY33.isStarted()) {
                        note33Img.setVisibility(Button.VISIBLE);
                        note33.setVisibility(Button.VISIBLE);
                        animSetXY33.start();
                    } else {
                        note333Img.setVisibility(Button.VISIBLE);
                        note333.setVisibility(Button.VISIBLE);
                        animSetXY333.start();
                    }
                }
            } else if (tab[indice] == 124) {
                if (!animSetXY1.isStarted()) {
                    note1Img.setVisibility(Button.VISIBLE);
                    note1.setVisibility(Button.VISIBLE);
                    animSetXY1.start();
                } else {
                    if (!animSetXY11.isStarted()) {
                        note11Img.setVisibility(Button.VISIBLE);
                        note11.setVisibility(Button.VISIBLE);
                        animSetXY11.start();
                    } else {
                        note111Img.setVisibility(Button.VISIBLE);
                        note111.setVisibility(Button.VISIBLE);
                        animSetXY111.start();
                    }
                }
                if (!animSetXY2.isStarted()) {
                    note2Img.setVisibility(Button.VISIBLE);
                    note2.setVisibility(Button.VISIBLE);
                    animSetXY2.start();
                } else {
                    if (!animSetXY22.isStarted()) {
                        note22Img.setVisibility(Button.VISIBLE);
                        note22.setVisibility(Button.VISIBLE);
                        animSetXY22.start();
                    } else {
                        note222Img.setVisibility(Button.VISIBLE);
                        note222.setVisibility(Button.VISIBLE);
                        animSetXY222.start();
                    }
                }
                if (!animSetXY4.isStarted()) {
                    note4Img.setVisibility(Button.VISIBLE);
                    note4.setVisibility(Button.VISIBLE);
                    animSetXY4.start();
                } else {
                    if (!animSetXY44.isStarted()) {
                        note44Img.setVisibility(Button.VISIBLE);
                        note44.setVisibility(Button.VISIBLE);
                        animSetXY44.start();
                    } else {
                        note444Img.setVisibility(Button.VISIBLE);
                        note444.setVisibility(Button.VISIBLE);
                        animSetXY444.start();
                    }
                }
            } else if (tab[indice] == 134) {
                if (!animSetXY1.isStarted()) {
                    note1Img.setVisibility(Button.VISIBLE);
                    note1.setVisibility(Button.VISIBLE);
                    animSetXY1.start();
                } else {
                    if (!animSetXY11.isStarted()) {
                        note11Img.setVisibility(Button.VISIBLE);
                        note11.setVisibility(Button.VISIBLE);
                        animSetXY11.start();
                    } else {
                        note111Img.setVisibility(Button.VISIBLE);
                        note111.setVisibility(Button.VISIBLE);
                        animSetXY111.start();
                    }
                }
                if (!animSetXY3.isStarted()) {
                    note3Img.setVisibility(Button.VISIBLE);
                    note3.setVisibility(Button.VISIBLE);
                    animSetXY3.start();
                } else {
                    if (!animSetXY33.isStarted()) {
                        note33Img.setVisibility(Button.VISIBLE);
                        note33.setVisibility(Button.VISIBLE);
                        animSetXY33.start();
                    } else { note333Img.setVisibility(Button.VISIBLE);
                        note333.setVisibility(Button.VISIBLE);
                        animSetXY333.start();
                    }
                }
                if (!animSetXY4.isStarted()) {
                    note4Img.setVisibility(Button.VISIBLE);
                    note4.setVisibility(Button.VISIBLE);
                    animSetXY4.start();
                } else {
                    if (!animSetXY44.isStarted()) {
                        note44Img.setVisibility(Button.VISIBLE);
                        note44.setVisibility(Button.VISIBLE);
                        animSetXY44.start();
                    } else {
                        note444Img.setVisibility(Button.VISIBLE);
                        note444.setVisibility(Button.VISIBLE);
                        animSetXY444.start();
                    }
                }
            }
            else if (tab[indice] == 234) {
                if (!animSetXY2.isStarted()) {
                    note2Img.setVisibility(Button.VISIBLE);
                    note2.setVisibility(Button.VISIBLE);
                    animSetXY2.start();
                } else {
                    if (!animSetXY22.isStarted()) {
                        note22Img.setVisibility(Button.VISIBLE);
                        note22.setVisibility(Button.VISIBLE);
                        animSetXY22.start();
                    } else {
                        note222Img.setVisibility(Button.VISIBLE);
                        note222.setVisibility(Button.VISIBLE);
                        animSetXY222.start();
                    }
                }
                if (!animSetXY3.isStarted()) {
                    note3Img.setVisibility(Button.VISIBLE);
                    note3.setVisibility(Button.VISIBLE);
                    animSetXY3.start();
                } else {
                    if (!animSetXY33.isStarted()) {
                        note33Img.setVisibility(Button.VISIBLE);
                        note33.setVisibility(Button.VISIBLE);
                        animSetXY33.start();
                    } else {
                        note333Img.setVisibility(Button.VISIBLE);
                        note333.setVisibility(Button.VISIBLE);
                        animSetXY333.start();
                    }
                }
                if (!animSetXY4.isStarted()) {
                    note4Img.setVisibility(Button.VISIBLE);
                    note4.setVisibility(Button.VISIBLE);
                    animSetXY4.start();
                } else {
                    if (!animSetXY44.isStarted()) {
                        note44Img.setVisibility(Button.VISIBLE);
                        note44.setVisibility(Button.VISIBLE);
                        animSetXY44.start();
                    } else {
                        note444Img.setVisibility(Button.VISIBLE);
                        note444.setVisibility(Button.VISIBLE);
                        animSetXY444.start();
                    }
                }
            } else if (tab[indice] == 1234) {
                if (!animSetXY1.isStarted()) {
                    note1Img.setVisibility(Button.VISIBLE);
                    note1.setVisibility(Button.VISIBLE);
                    animSetXY1.start();
                } else {
                    if (!animSetXY11.isStarted()) {
                        note11Img.setVisibility(Button.VISIBLE);
                        note11.setVisibility(Button.VISIBLE);
                        animSetXY11.start();
                    } else {
                        note111Img.setVisibility(Button.VISIBLE);
                        note111.setVisibility(Button.VISIBLE);
                        animSetXY111.start();
                    }
                }
                if (!animSetXY2.isStarted()) {
                    note2Img.setVisibility(Button.VISIBLE);
                    note2.setVisibility(Button.VISIBLE);
                    animSetXY2.start();
                } else {
                    if (!animSetXY22.isStarted()) {
                        note22Img.setVisibility(Button.VISIBLE);
                        note22.setVisibility(Button.VISIBLE);
                        animSetXY22.start();
                    } else {
                        note222Img.setVisibility(Button.VISIBLE);
                        note222.setVisibility(Button.VISIBLE);
                        animSetXY222.start();
                    }
                }
                if (!animSetXY3.isStarted()) {
                    note3Img.setVisibility(Button.VISIBLE);
                    note3.setVisibility(Button.VISIBLE);
                    animSetXY3.start();
                } else {
                    if (!animSetXY33.isStarted()) {
                        note33Img.setVisibility(Button.VISIBLE);
                        note33.setVisibility(Button.VISIBLE);
                        animSetXY33.start();
                    } else {
                        note333Img.setVisibility(Button.VISIBLE);
                        note333.setVisibility(Button.VISIBLE);
                        animSetXY333.start();
                    }
                }
                if (!animSetXY4.isStarted()) {
                    note4Img.setVisibility(Button.VISIBLE);
                    note4.setVisibility(Button.VISIBLE);
                    animSetXY4.start();
                } else {
                    if (!animSetXY44.isStarted()) {
                        note44Img.setVisibility(Button.VISIBLE);
                        note44.setVisibility(Button.VISIBLE);
                        animSetXY44.start();
                    } else {
                        note444Img.setVisibility(Button.VISIBLE);
                        note444.setVisibility(Button.VISIBLE);
                        animSetXY444.start();
                    }
                }
            } else if (tab[indice] == 11) {
                if (!animSetXYL1.isStarted()) {
                    long1Img.setVisibility(Button.VISIBLE);
                    long1.setVisibility(Button.VISIBLE);
                    animSetXYL1.start();
                }
            } else if (tab[indice] == 22) {
                if (!animSetXYL2.isStarted()) {
                    long2Img.setVisibility(Button.VISIBLE);
                    long2.setVisibility(Button.VISIBLE);
                    animSetXYL2.start();
                }
            } else if (tab[indice] == 33) {
                if (!animSetXYL3.isStarted()) {
                    long3Img.setVisibility(Button.VISIBLE);
                    long3.setVisibility(Button.VISIBLE);
                    animSetXYL3.start();
                }
            } else if (tab[indice] == 44) {
                if (!animSetXYL4.isStarted()) {
                    long4Img.setVisibility(Button.VISIBLE);
                    long4.setVisibility(Button.VISIBLE);
                    animSetXYL4.start();
                }
            }
            //if tab [indice] == 9999 on passe au suivant : permet d'attendre plus longtemps avant la prochaine note

            indice = indice + 1;
            if (indice == tab.length) { //protection au cas ou la taille du tableau est dépassée
                indice = 0;
            }

        }


    }


    public void start(){

        animSetXY1.setDuration(speedNote);
        animSetXY2.setDuration(speedNote);
        animSetXY3.setDuration(speedNote);
        animSetXY4.setDuration(speedNote);

        animSetXY11.setDuration(speedNote);
        animSetXY22.setDuration(speedNote);
        animSetXY33.setDuration(speedNote);
        animSetXY44.setDuration(speedNote);

        animSetXY111.setDuration(speedNote);
        animSetXY222.setDuration(speedNote);
        animSetXY333.setDuration(speedNote);
        animSetXY444.setDuration(speedNote);

        animSetXYL1.setDuration(speedLong);
        animSetXYL2.setDuration(speedLong);
        animSetXYL3.setDuration(speedLong);
        animSetXYL4.setDuration(speedLong);

        indice=0;


        musique.start();


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {public void run() {


            new CountDownTimer((long)(420/multiplier), (long)(200/multiplier)) {

                @Override
                public void onTick(long millisUntilFinished) {
                    fall(tab_demonSlayer1);
                }

                @Override
                public void onFinish() {
                    indice=3;
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {public void run() {


                        new CountDownTimer((long)(420/multiplier), (long)(200/multiplier)) {

                            @Override
                            public void onTick(long millisUntilFinished) {
                                fall(tab_demonSlayer1);
                            }

                            @Override
                            public void onFinish() {
                                indice=6;

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {public void run() {

                                    new CountDownTimer((long)(1620/multiplier), (long)(200/multiplier)) {

                                        @Override
                                        public void onTick(long millisUntilFinished) {
                                            fall(tab_demonSlayer1);
                                        }

                                        @Override
                                        public void onFinish() {

                                            indice =15;
                                            Handler handler = new Handler();
                                            handler.postDelayed(new Runnable() {public void run() {


                                                new CountDownTimer((long)(420/multiplier), (long)(200/multiplier)) {

                                                    @Override
                                                    public void onTick(long millisUntilFinished) {
                                                        fall(tab_demonSlayer1);
                                                    }

                                                    @Override
                                                    public void onFinish() {

                                                        indice=18;

                                                        handler.postDelayed(new Runnable() {public void run() {

                                                            new CountDownTimer((long)(420/multiplier), (long)(200/multiplier)) {

                                                                @Override
                                                                public void onTick(long millisUntilFinished) {
                                                                    fall(tab_demonSlayer1);
                                                                }

                                                                @Override
                                                                public void onFinish() {

                                                                    indice=21;

                                                                    Handler handler = new Handler();
                                                                    handler.postDelayed(new Runnable() {public void run() {


                                                                        new CountDownTimer((long)(620/multiplier), (long)(300/multiplier)) {

                                                                            @Override
                                                                            public void onTick(long millisUntilFinished) {

                                                                                fall(tab_demonSlayer1);
                                                                            }

                                                                            @Override
                                                                            public void onFinish() {

                                                                                indice=24;
                                                                                Handler handler = new Handler();
                                                                                handler.postDelayed(new Runnable() {public void run() {


                                                                                    new CountDownTimer((long)(6500/multiplier), (long)(300/multiplier)) {

                                                                                        @Override
                                                                                        public void onTick(long millisUntilFinished) {
                                                                                            fall(tab_demonSlayer1);
                                                                                        }

                                                                                        @Override
                                                                                        public void onFinish() {
                                                                                            indice =46;

                                                                                            Handler handler = new Handler();
                                                                                            handler.postDelayed(new Runnable() {public void run() {


                                                                                                new CountDownTimer((long)(2000/multiplier),(long)(300/multiplier)) {

                                                                                                    @Override
                                                                                                    public void onTick(long millisUntilFinished) {
                                                                                                        fall(tab_demonSlayer1);
                                                                                                    }

                                                                                                    @Override
                                                                                                    public void onFinish() {
                                                                                                        indice=53;

                                                                                                        Handler handler = new Handler();
                                                                                                        handler.postDelayed(new Runnable() {public void run() {

                                                                                                            new CountDownTimer((long)(820/multiplier),(long)(200/multiplier)) {  //DOUBLES RAPIDES

                                                                                                                @Override
                                                                                                                public void onTick(long millisUntilFinished) {
                                                                                                                    fall(tab_demonSlayer1);
                                                                                                                }

                                                                                                                @Override
                                                                                                                public void onFinish() {
                                                                                                                    indice =58;

                                                                                                                    Handler handler = new Handler();
                                                                                                                    handler.postDelayed(new Runnable() {public void run() {


                                                                                                                        new CountDownTimer((long)(3320/multiplier),(long)(300/multiplier)) {

                                                                                                                            @Override
                                                                                                                            public void onTick(long millisUntilFinished) {
                                                                                                                                fall(tab_demonSlayer1);
                                                                                                                            }

                                                                                                                            @Override
                                                                                                                            public void onFinish() {
                                                                                                                                indice=70;
                                                                                                                                Handler handler = new Handler();
                                                                                                                                handler.postDelayed(new Runnable() {public void run() {

                                                                                                                                    new CountDownTimer((long)(7700/multiplier),(long)(300/multiplier)) {

                                                                                                                                        @Override
                                                                                                                                        public void onTick(long millisUntilFinished) {
                                                                                                                                            fall(tab_demonSlayer1);
                                                                                                                                        }

                                                                                                                                        @Override
                                                                                                                                        public void onFinish() {
                                                                                                                                            indice=97;

                                                                                                                                            Handler handler = new Handler();
                                                                                                                                            handler.postDelayed(new Runnable() {public void run() {

                                                                                                                                                new CountDownTimer((long)(820/multiplier),(long)(200/multiplier)) {

                                                                                                                                                    @Override
                                                                                                                                                    public void onTick(long millisUntilFinished) {

                                                                                                                                                        fall(tab_demonSlayer1);
                                                                                                                                                    }

                                                                                                                                                    @Override
                                                                                                                                                    public void onFinish() {
                                                                                                                                                        indice=102;
                                                                                                                                                        Handler handler = new Handler();
                                                                                                                                                        handler.postDelayed(new Runnable() {public void run() {

                                                                                                                                                            new CountDownTimer((long)(1700/multiplier),(long)(300/multiplier)) {

                                                                                                                                                                @Override
                                                                                                                                                                public void onTick(long millisUntilFinished) {
                                                                                                                                                                    fall(tab_demonSlayer1);
                                                                                                                                                                }

                                                                                                                                                                @Override
                                                                                                                                                                public void onFinish() {
                                                                                                                                                                    indice=107;

                                                                                                                                                                    Handler handler = new Handler();
                                                                                                                                                                    handler.postDelayed(new Runnable() {public void run() {

                                                                                                                                                                        new CountDownTimer((long)(820/multiplier),(long)(200/multiplier)) {

                                                                                                                                                                            @Override
                                                                                                                                                                            public void onTick(long millisUntilFinished) {
                                                                                                                                                                                fall(tab_demonSlayer1);
                                                                                                                                                                            }

                                                                                                                                                                            @Override
                                                                                                                                                                            public void onFinish() {
                                                                                                                                                                                indice=112;
                                                                                                                                                                                Handler handler = new Handler();
                                                                                                                                                                                handler.postDelayed(new Runnable() {public void run() {

                                                                                                                                                                                    new CountDownTimer((long)(6320/multiplier),(long)(300/multiplier)) {

                                                                                                                                                                                        @Override
                                                                                                                                                                                        public void onTick(long millisUntilFinished) {
                                                                                                                                                                                            fall(tab_demonSlayer1);
                                                                                                                                                                                        }

                                                                                                                                                                                        @Override
                                                                                                                                                                                        public void onFinish() { //COMME AU DEBUT

                                                                                                                                                                                            indice=134;


                                                                                                                                                                                            Handler handler = new Handler();
                                                                                                                                                                                            handler.postDelayed(new Runnable() {public void run() {


                                                                                                                                                                                                new CountDownTimer(420, 200) {

                                                                                                                                                                                                    @Override
                                                                                                                                                                                                    public void onTick(long millisUntilFinished) {
                                                                                                                                                                                                        fall(tab_demonSlayer1);
                                                                                                                                                                                                    }

                                                                                                                                                                                                    @Override
                                                                                                                                                                                                    public void onFinish() {
                                                                                                                                                                                                        indice=137;
                                                                                                                                                                                                        Handler handler = new Handler();
                                                                                                                                                                                                        handler.postDelayed(new Runnable() {public void run() {


                                                                                                                                                                                                            new CountDownTimer(420, 200) {

                                                                                                                                                                                                                @Override
                                                                                                                                                                                                                public void onTick(long millisUntilFinished) {
                                                                                                                                                                                                                    fall(tab_demonSlayer1);
                                                                                                                                                                                                                }

                                                                                                                                                                                                                @Override
                                                                                                                                                                                                                public void onFinish() {
                                                                                                                                                                                                                    indice=140;

                                                                                                                                                                                                                    Handler handler = new Handler();
                                                                                                                                                                                                                    handler.postDelayed(new Runnable() {public void run() {

                                                                                                                                                                                                                        new CountDownTimer(1620, 200) {

                                                                                                                                                                                                                            @Override
                                                                                                                                                                                                                            public void onTick(long millisUntilFinished) {
                                                                                                                                                                                                                                fall(tab_demonSlayer1);
                                                                                                                                                                                                                            }

                                                                                                                                                                                                                            @Override
                                                                                                                                                                                                                            public void onFinish() {
                                                                                                                                                                                                                                indice=149;

                                                                                                                                                                                                                                Handler handler = new Handler();
                                                                                                                                                                                                                                handler.postDelayed(new Runnable() {public void run() {

                                                                                                                                                                                                                                    new CountDownTimer((long)(420/multiplier),(long)(200/multiplier)) {

                                                                                                                                                                                                                                        @Override
                                                                                                                                                                                                                                        public void onTick(long millisUntilFinished) {
                                                                                                                                                                                                                                            fall(tab_demonSlayer1);
                                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                        @Override
                                                                                                                                                                                                                                        public void onFinish() {
                                                                                                                                                                                                                                            indice=152;

                                                                                                                                                                                                                                            Handler handler = new Handler();
                                                                                                                                                                                                                                            handler.postDelayed(new Runnable() {public void run() {

                                                                                                                                                                                                                                                new CountDownTimer((long)(420/multiplier),(long)(200/multiplier)) {

                                                                                                                                                                                                                                                    @Override
                                                                                                                                                                                                                                                    public void onTick(long millisUntilFinished) {
                                                                                                                                                                                                                                                        fall(tab_demonSlayer1);
                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                    @Override
                                                                                                                                                                                                                                                    public void onFinish() {
                                                                                                                                                                                                                                                        indice=155;
                                                                                                                                                                                                                                                        Handler handler = new Handler();
                                                                                                                                                                                                                                                        handler.postDelayed(new Runnable() {public void run() {

                                                                                                                                                                                                                                                            new CountDownTimer((long)(620/multiplier),(long)(300/multiplier)) {

                                                                                                                                                                                                                                                                @Override
                                                                                                                                                                                                                                                                public void onTick(long millisUntilFinished) {
                                                                                                                                                                                                                                                                    fall(tab_demonSlayer1);
                                                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                                                @Override
                                                                                                                                                                                                                                                                public void onFinish() {


                                                                                                                                                                                                                                                                    Handler handler = new Handler();
                                                                                                                                                                                                                                                                    handler.postDelayed(new Runnable() {public void run() {

                                                                                                                                                                                                                                                                        mainLayout2.setBackgroundResource(R.drawable.degrad_red);
                                                                                                                                                                                                                                                                        mainLayout2.startAnimation(transition);
                                                                                                                                                                                                                                                                        mainLayout.setBackgroundResource(R.drawable.degrad_red);

                                                                                                                                                                                                                                                                        new CountDownTimer((long)(29000/multiplier),(long)(300/multiplier)) {

                                                                                                                                                                                                                                                                            @Override
                                                                                                                                                                                                                                                                            public void onTick(long millisUntilFinished) {
                                                                                                                                                                                                                                                                                fall(tab_demonSlayer1);
                                                                                                                                                                                                                                                                            }

                                                                                                                                                                                                                                                                            @Override
                                                                                                                                                                                                                                                                            public void onFinish() {


                                                                                                                                                                                                                                                                                Handler handler = new Handler();
                                                                                                                                                                                                                                                                                handler.postDelayed(new Runnable() {
                                                                                                                                                                                                                                                                                    @RequiresApi(api = Build.VERSION_CODES.M)
                                                                                                                                                                                                                                                                                    public void run() {

                                                                                                                                                                                                                                                                                        if(!arret[0]) {
                                                                                                                                                                                                                                                                                            setMultiplier(getMultiplier() + (0.05f));
                                                                                                                                                                                                                                                                                            musique.setPlaybackParams(musique.getPlaybackParams().setSpeed(multiplier));
                                                                                                                                                                                                                                                                                            setSpeedNote((int) (getSpeedNote() / getMultiplier()));
                                                                                                                                                                                                                                                                                            setSpeedLong((int) (getSpeedLong() / getMultiplier()));
                                                                                                                                                                                                                                                                                            mainLayout2.setBackgroundResource(R.drawable.degrad_pink_blue);
                                                                                                                                                                                                                                                                                            mainLayout2.startAnimation(transition);
                                                                                                                                                                                                                                                                                            mainLayout.setBackgroundResource(R.drawable.degrad_pink_blue);

                                                                                                                                                                                                                                                                                            level_demon_slayer1 recommencer = new level_demon_slayer1(note1, note11, note111, note2, note22, note222, note3, note33, note333, note4, note44, note444,
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

                                                                                                                                                                                                                                                                                            recommencer.start();

                                                                                                                                                                                                                                                                                        }


                                                                                                                                                                                                                                                                                    }


                                                                                                                                                                                                                                                                                }, (long)(5000));

                                                                                                                                                                                                                                                                            }

                                                                                                                                                                                                                                                                        }.start();

                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                    }, (long)(2000/multiplier));


                                                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                                            }.start();

                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                        }, (long)(1100/multiplier));

                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                }.start();


                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                            }, (long)(1000/multiplier));

                                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                    }.start();


                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                }, (long)(1600/multiplier));

                                                                                                                                                                                                                            }

                                                                                                                                                                                                                        }.start();


                                                                                                                                                                                                                    }
                                                                                                                                                                                                                    }, (long)(1200/multiplier));
                                                                                                                                                                                                                }

                                                                                                                                                                                                            }.start();

                                                                                                                                                                                                        }
                                                                                                                                                                                                        }, (long)(1200/multiplier));


                                                                                                                                                                                                    }

                                                                                                                                                                                                }.start();

                                                                                                                                                                                            }
                                                                                                                                                                                            }, (long)(1600/multiplier));

                                                                                                                                                                                        }

                                                                                                                                                                                    }.start();

                                                                                                                                                                                }
                                                                                                                                                                                }, (long)(400/multiplier));


                                                                                                                                                                            }

                                                                                                                                                                        }.start();

                                                                                                                                                                    }
                                                                                                                                                                    }, (long)(500/multiplier));

                                                                                                                                                                }

                                                                                                                                                            }.start();

                                                                                                                                                        }
                                                                                                                                                        }, (long)(400/multiplier));

                                                                                                                                                    }

                                                                                                                                                }.start();

                                                                                                                                            }
                                                                                                                                            }, (long)(500/multiplier));

                                                                                                                                        }

                                                                                                                                    }.start();

                                                                                                                                }
                                                                                                                                }, (long)(1000/multiplier));

                                                                                                                            }

                                                                                                                        }.start();


                                                                                                                    }
                                                                                                                    }, (long)(300/multiplier));

                                                                                                                }

                                                                                                            }.start();


                                                                                                        }
                                                                                                        }, (long)(400/multiplier));

                                                                                                    }

                                                                                                }.start();


                                                                                            }
                                                                                            }, (long)(800/multiplier));

                                                                                        }

                                                                                    }.start();


                                                                                }
                                                                                }, (long)(300/multiplier));


                                                                            }

                                                                        }.start();

                                                                    }
                                                                    }, (long)(1100/multiplier));



                                                                }

                                                            }.start();


                                                        }
                                                        }, (long)(1000/multiplier));


                                                    }

                                                }.start();



                                            }
                                            }, (long)(1600/multiplier));


                                        }

                                    }.start();


                                }
                                }, (long)(1200/multiplier));
                            }

                        }.start();

                    }
                    }, (long)(1200/multiplier));


                }

            }.start();

        }
        }, (long)(500/multiplier));




    }


}
