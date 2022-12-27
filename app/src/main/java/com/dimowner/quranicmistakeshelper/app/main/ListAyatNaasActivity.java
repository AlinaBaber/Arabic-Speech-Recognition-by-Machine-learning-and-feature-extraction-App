package com.dimowner.quranicmistakeshelper.app.main;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.dimowner.quranicmistakeshelper.R;
import com.dimowner.quranicmistakeshelper.app.setup.SetupActivity;

import java.io.IOException;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

public class ListAyatNaasActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;

    MediaPlayer mediaPlayerFirstAyatNaas;
    MediaPlayer mediaPlayerSecondAyatNaas ;
    MediaPlayer mediaPlayerThirdAyatNaas;
    MediaPlayer mediaPlayerFourthAyatNaas;
    MediaPlayer mediaPlayerFifthAyatNaas;
    MediaPlayer mediaPlayerSixthAyatNaas;

    ImageButton firstAyatNaas,secondAyatNaas,thirdAyatNaas,fourthAyatNaas, fifthAyatNaas, sixthAyatNaas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_list_ayat_naas);
        Bundle bundle = getIntent().getExtras();

        if(bundle != null) {
            char surah = bundle.getChar("surah");
        }
        mediaPlayerFirstAyatNaas = new MediaPlayer();
        mediaPlayerSecondAyatNaas = new MediaPlayer();
         mediaPlayerThirdAyatNaas = new MediaPlayer();
         mediaPlayerFourthAyatNaas = new MediaPlayer();
         mediaPlayerFifthAyatNaas =new MediaPlayer();
         mediaPlayerSixthAyatNaas = new MediaPlayer();

        firstAyatNaas = findViewById(R.id.btnnaas1);
        secondAyatNaas = findViewById(R.id.btnnaas2);
        thirdAyatNaas = findViewById(R.id.btnnaas3);
        fourthAyatNaas= findViewById(R.id.btnnaas4);
        fifthAyatNaas = findViewById(R.id.btnnaas5);
        sixthAyatNaas = findViewById(R.id.btnnaas6);
        

        try {
            AssetFileDescriptor descriptorOneAyatNaas = this.getAssets().openFd("nas1.mp3");
            mediaPlayerFirstAyatNaas.setDataSource(descriptorOneAyatNaas.getFileDescriptor(), descriptorOneAyatNaas.getStartOffset(), descriptorOneAyatNaas.getLength());
            mediaPlayerFirstAyatNaas.prepare();
            mediaPlayerFirstAyatNaas.setVolume(1f, 1f);
            mediaPlayerFirstAyatNaas.setLooping(false);

            AssetFileDescriptor descriptorSecondAyatNaas = this.getAssets().openFd("nas2.wav");
            mediaPlayerSecondAyatNaas.setDataSource(descriptorSecondAyatNaas.getFileDescriptor(), descriptorSecondAyatNaas.getStartOffset(), descriptorSecondAyatNaas.getLength());


            mediaPlayerSecondAyatNaas.prepare();
            mediaPlayerSecondAyatNaas.setVolume(1f, 1f);
            mediaPlayerSecondAyatNaas.setLooping(false);

            AssetFileDescriptor descriptorThirdAyatNaas = this.getAssets().openFd("nas3.mp3");
            mediaPlayerThirdAyatNaas.setDataSource(descriptorThirdAyatNaas.getFileDescriptor(), descriptorThirdAyatNaas.getStartOffset(), descriptorThirdAyatNaas.getLength());

            mediaPlayerThirdAyatNaas.prepare();
            mediaPlayerThirdAyatNaas.setVolume(1f, 1f);
            mediaPlayerThirdAyatNaas.setLooping(false);

            AssetFileDescriptor descriptorfourthAyatNaas = this.getAssets().openFd("nas4.mp3");
            mediaPlayerFourthAyatNaas.setDataSource(descriptorfourthAyatNaas.getFileDescriptor(), descriptorfourthAyatNaas.getStartOffset(), descriptorfourthAyatNaas.getLength());

            mediaPlayerFourthAyatNaas.prepare();
            mediaPlayerFourthAyatNaas.setVolume(1f, 1f);
            mediaPlayerFourthAyatNaas.setLooping(false);

            AssetFileDescriptor descriptorfifthAyatNaas = this.getAssets().openFd("nas5.mp3");
            mediaPlayerFifthAyatNaas.setDataSource(descriptorfifthAyatNaas.getFileDescriptor(), descriptorfifthAyatNaas.getStartOffset(), descriptorfifthAyatNaas.getLength());

            mediaPlayerFifthAyatNaas.prepare();
            mediaPlayerFifthAyatNaas.setVolume(1f, 1f);
            mediaPlayerFifthAyatNaas.setLooping(false);

            AssetFileDescriptor descriptorsixthAyatNaas = this.getAssets().openFd("nas6.mp3");
            mediaPlayerSixthAyatNaas.setDataSource(descriptorsixthAyatNaas.getFileDescriptor(), descriptorsixthAyatNaas.getStartOffset(), descriptorsixthAyatNaas.getLength());

            mediaPlayerSixthAyatNaas.prepare();
            mediaPlayerSixthAyatNaas.setVolume(1f, 1f);
            mediaPlayerSixthAyatNaas.setLooping(false);
            descriptorOneAyatNaas.close();
            descriptorSecondAyatNaas.close();
            descriptorThirdAyatNaas.close();
            descriptorfourthAyatNaas.close();
            descriptorfifthAyatNaas.close();
            descriptorsixthAyatNaas.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (mediaPlayerFirstAyatNaas.isPlaying()){
            firstAyatNaas.setBackgroundResource(R.drawable.ic_pause);
        }



    }


    public void onClickReco(View view) {
        startActivity(SetupActivity.getStartIntent(getApplicationContext()));
    }

    public void firstAyatNaasPlay(View view) {
        try {
            if (mediaPlayerFirstAyatNaas.isPlaying()){
                mediaPlayerFirstAyatNaas.pause();
                firstAyatNaas.setBackgroundResource(R.drawable.ic_stop);
                Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
            }

            else {
                firstAyatNaas.setBackgroundResource(R.drawable.ic_play);


                mediaPlayerFirstAyatNaas.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


//
//        MediaPlayer mediaPlayer = new MediaPlayer();
//        AssetFileDescriptor afd;
//        try {
//            afd = getAssets().openFd("simple.mp3");
//            Toast.makeText(this, ""+afd.getFileDescriptor(), Toast.LENGTH_SHORT).show();
////            mediaPlayer.setDataSource(afd.getFileDescriptor());
////            mediaPlayer.prepare();
////            mediaPlayer.start();
//        } catch (IOException e) {
//            e.getMessage();
//        }
    }

    public void secondAyatPlayNaas(View view) {
        try {
            if (mediaPlayerSecondAyatNaas.isPlaying()){
                mediaPlayerSecondAyatNaas.pause();
                secondAyatNaas.setBackgroundResource(R.drawable.ic_stop);
                Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
            }

            else {
                secondAyatNaas.setBackgroundResource(R.drawable.ic_play);

                mediaPlayerSecondAyatNaas.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void thirdAyatPlayNaas(View view) {

        try {
            if (mediaPlayerThirdAyatNaas.isPlaying()){

                mediaPlayerThirdAyatNaas.pause();
                thirdAyatNaas.setBackgroundResource(R.drawable.ic_stop);
                Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
            }

            else {
                thirdAyatNaas.setBackgroundResource(R.drawable.ic_play);

                mediaPlayerThirdAyatNaas.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void fourthAyatPlayNaas(View view) {

        try {
            if (mediaPlayerFourthAyatNaas.isPlaying()){

                mediaPlayerFourthAyatNaas.pause();
                fourthAyatNaas.setBackgroundResource(R.drawable.ic_stop);
                Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
            }

            else {
                fourthAyatNaas.setBackgroundResource(R.drawable.ic_play);

                mediaPlayerFourthAyatNaas.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void fifthAyatPlayNaas(View view) {

        try {
            if (mediaPlayerFifthAyatNaas.isPlaying()){

                mediaPlayerFifthAyatNaas.pause();
                fifthAyatNaas.setBackgroundResource(R.drawable.ic_stop);
                Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
            }

            else {
                fifthAyatNaas.setBackgroundResource(R.drawable.ic_play);

                mediaPlayerFifthAyatNaas.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sixthAyatPlayNaas(View view) {

        try {
            if (mediaPlayerSixthAyatNaas.isPlaying()){

                mediaPlayerSixthAyatNaas.pause();
                sixthAyatNaas.setBackgroundResource(R.drawable.ic_stop);
                Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
            }

            else {
                sixthAyatNaas.setBackgroundResource(R.drawable.ic_play);

                mediaPlayerSixthAyatNaas.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void onRecording(View view) {
;
        startActivity(SetupActivity.getStartIntent(getApplicationContext()));

    }
}