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

public class ListAyatIkhlasActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;

    MediaPlayer mediaPlayerFirstAyatikhlaas;
    MediaPlayer mediaPlayerSecondAyatikhlaas ;
    MediaPlayer mediaPlayerThirdAyatikhlaas;
    MediaPlayer mediaPlayerFourthAyatikhlaas;

    ImageButton firstAyatikhlaas,secondAyatikhlaas,thirdAyatikhlaas,fouthAyatikhlaas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
;
        setContentView(R.layout.content_list_ayat_ikhlas);
        Bundle bundle = getIntent().getExtras();

        if(bundle != null) {
            char surah = bundle.getChar("surah");
        }
        mediaPlayerFirstAyatikhlaas = new MediaPlayer();
        mediaPlayerSecondAyatikhlaas = new MediaPlayer();
        mediaPlayerThirdAyatikhlaas = new MediaPlayer();
        mediaPlayerFourthAyatikhlaas = new MediaPlayer();

        firstAyatikhlaas = findViewById(R.id.btnikhlas1);
        secondAyatikhlaas = findViewById(R.id.btnikhlas1);
        thirdAyatikhlaas = findViewById(R.id.btnikhlas3);
        fouthAyatikhlaas = findViewById(R.id.btnikhlas1);

        try {
            AssetFileDescriptor descriptorOneAyatiklas = this.getAssets().openFd("ikhlas1.wav");
            mediaPlayerFirstAyatikhlaas.setDataSource(descriptorOneAyatiklas.getFileDescriptor(), descriptorOneAyatiklas.getStartOffset(), descriptorOneAyatiklas.getLength());
            mediaPlayerFirstAyatikhlaas.prepare();
            mediaPlayerFirstAyatikhlaas.setVolume(1f, 1f);
            mediaPlayerFirstAyatikhlaas.setLooping(false);

            AssetFileDescriptor descriptorSecondAyatiklaas = this.getAssets().openFd("ikhlas2.wav");
            mediaPlayerSecondAyatikhlaas.setDataSource(descriptorSecondAyatiklaas.getFileDescriptor(), descriptorSecondAyatiklaas.getStartOffset(), descriptorSecondAyatiklaas.getLength());


            mediaPlayerSecondAyatikhlaas.prepare();
            mediaPlayerSecondAyatikhlaas.setVolume(1f, 1f);
            mediaPlayerSecondAyatikhlaas.setLooping(false);

            AssetFileDescriptor descriptorThirdAyatiklaas = this.getAssets().openFd("ikhlas3.wav");
            mediaPlayerThirdAyatikhlaas.setDataSource(descriptorThirdAyatiklaas.getFileDescriptor(), descriptorThirdAyatiklaas.getStartOffset(), descriptorThirdAyatiklaas.getLength());

            mediaPlayerThirdAyatikhlaas.prepare();
            mediaPlayerThirdAyatikhlaas.setVolume(1f, 1f);
            mediaPlayerThirdAyatikhlaas.setLooping(false);

            AssetFileDescriptor descriptorFourthAyatiklaas = this.getAssets().openFd("ikhals4.wav");
            mediaPlayerFourthAyatikhlaas.setDataSource(descriptorFourthAyatiklaas.getFileDescriptor(), descriptorFourthAyatiklaas.getStartOffset(), descriptorFourthAyatiklaas.getLength());

            mediaPlayerFourthAyatikhlaas.prepare();
            mediaPlayerFourthAyatikhlaas.setVolume(1f, 1f);
            mediaPlayerFourthAyatikhlaas.setLooping(false);
            descriptorOneAyatiklas.close();
            descriptorSecondAyatiklaas.close();
            descriptorThirdAyatiklaas.close();
            descriptorFourthAyatiklaas.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (mediaPlayerFirstAyatikhlaas.isPlaying()){
            firstAyatikhlaas.setBackgroundResource(R.drawable.ic_pause);
        }



    }


    public void onClickReco(View view) {
        startActivity(SetupActivity.getStartIntent(getApplicationContext()));
    }

    public void firstAyatPlayiklas(View view) {
        try {
            if (mediaPlayerFirstAyatikhlaas.isPlaying()){
                mediaPlayerFirstAyatikhlaas.pause();
                firstAyatikhlaas.setBackgroundResource(R.drawable.ic_stop);
                Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
            }

            else {
                firstAyatikhlaas.setBackgroundResource(R.drawable.ic_play);


                mediaPlayerFirstAyatikhlaas.start();
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

    public void secondAyatPlayikhlas(View view) {
        try {
            if (mediaPlayerSecondAyatikhlaas.isPlaying()){
                mediaPlayerSecondAyatikhlaas.pause();
                secondAyatikhlaas.setBackgroundResource(R.drawable.ic_stop);
                Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
            }

            else {
                secondAyatikhlaas.setBackgroundResource(R.drawable.ic_play);

                mediaPlayerSecondAyatikhlaas.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void thirdAyatPlayikhlas(View view) {

        try {
            if (mediaPlayerThirdAyatikhlaas.isPlaying()){

                mediaPlayerThirdAyatikhlaas.pause();
                thirdAyatikhlaas.setBackgroundResource(R.drawable.ic_stop);
                Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
            }

            else {
                thirdAyatikhlaas.setBackgroundResource(R.drawable.ic_play);

                mediaPlayerThirdAyatikhlaas.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void fourhtAyatPlayiklas(View view) {

        try {
            if (mediaPlayerFourthAyatikhlaas.isPlaying()){

                mediaPlayerFourthAyatikhlaas.pause();
                fouthAyatikhlaas.setBackgroundResource(R.drawable.ic_stop);
                Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
            }

            else {
                fouthAyatikhlaas.setBackgroundResource(R.drawable.ic_play);

                mediaPlayerFourthAyatikhlaas.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void onRecording(View view) {

        startActivity(SetupActivity.getStartIntent(getApplicationContext()));

    }
}