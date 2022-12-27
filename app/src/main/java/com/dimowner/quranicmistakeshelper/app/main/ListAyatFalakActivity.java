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

public class ListAyatFalakActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;

    MediaPlayer mediaPlayerFirstAyatFalaq;
    MediaPlayer mediaPlayerSecondAyatFalaq;
    MediaPlayer mediaPlayerThirdAyatFalaq;
    MediaPlayer mediaPlayerFourthAyatFalaq;
    MediaPlayer mediaPlayerFifthAyatFalaq;


    ImageButton firstAyatfalaq,secondAyatfalaq,thirdAyatfalaq, fourthAyatfalaq, fifthAyatfalaq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_list_ayat_falak);
        Bundle bundle = getIntent().getExtras();

        if(bundle != null) {
            char surah = bundle.getChar("surah");
        }
        mediaPlayerFirstAyatFalaq = new MediaPlayer();
        mediaPlayerSecondAyatFalaq = new MediaPlayer();
         mediaPlayerThirdAyatFalaq = new MediaPlayer();
         mediaPlayerFourthAyatFalaq = new MediaPlayer();
         mediaPlayerFifthAyatFalaq = new MediaPlayer();

        firstAyatfalaq = findViewById(R.id.btnfalak1);
        secondAyatfalaq = findViewById(R.id.btnfalak2);
        thirdAyatfalaq = findViewById(R.id.btnfalak3);
        fourthAyatfalaq = findViewById(R.id.btnfalak4);
        fifthAyatfalaq = findViewById(R.id.btnfalak5);

        try {
            AssetFileDescriptor descriptorOneAyatFalaq = this.getAssets().openFd("falaq1.wav");
            mediaPlayerFirstAyatFalaq.setDataSource(descriptorOneAyatFalaq.getFileDescriptor(), descriptorOneAyatFalaq.getStartOffset(), descriptorOneAyatFalaq.getLength());
            mediaPlayerFirstAyatFalaq.prepare();
            mediaPlayerFirstAyatFalaq.setVolume(1f, 1f);
            mediaPlayerFirstAyatFalaq.setLooping(false);

            AssetFileDescriptor descriptorSecondAyatFalaq = this.getAssets().openFd("falaq2.wav");
            mediaPlayerSecondAyatFalaq.setDataSource(descriptorSecondAyatFalaq.getFileDescriptor(), descriptorSecondAyatFalaq.getStartOffset(), descriptorSecondAyatFalaq.getLength());


            mediaPlayerSecondAyatFalaq.prepare();
            mediaPlayerSecondAyatFalaq.setVolume(1f, 1f);
            mediaPlayerSecondAyatFalaq.setLooping(false);

            AssetFileDescriptor descriptorThirdAyatFalaq = this.getAssets().openFd("falaq3.wav");
            mediaPlayerThirdAyatFalaq.setDataSource(descriptorThirdAyatFalaq.getFileDescriptor(), descriptorThirdAyatFalaq.getStartOffset(), descriptorThirdAyatFalaq.getLength());

            mediaPlayerThirdAyatFalaq.prepare();
            mediaPlayerThirdAyatFalaq.setVolume(1f, 1f);
            mediaPlayerThirdAyatFalaq.setLooping(false);

            AssetFileDescriptor descriptorFourthAyatFalaq = this.getAssets().openFd("falaq4.wav");
            mediaPlayerFourthAyatFalaq.setDataSource(descriptorFourthAyatFalaq.getFileDescriptor(), descriptorFourthAyatFalaq.getStartOffset(), descriptorFourthAyatFalaq.getLength());

            mediaPlayerFourthAyatFalaq.prepare();
            mediaPlayerFourthAyatFalaq.setVolume(1f, 1f);
            mediaPlayerFourthAyatFalaq.setLooping(false);

            AssetFileDescriptor descriptorFifthAyatFalaq = this.getAssets().openFd("falaq5.wav");
            mediaPlayerFifthAyatFalaq.setDataSource(descriptorFifthAyatFalaq.getFileDescriptor(), descriptorFifthAyatFalaq.getStartOffset(), descriptorFifthAyatFalaq.getLength());

            mediaPlayerFifthAyatFalaq.prepare();
            mediaPlayerFifthAyatFalaq.setVolume(1f, 1f);
            mediaPlayerFifthAyatFalaq.setLooping(false);

            descriptorOneAyatFalaq.close();
            descriptorSecondAyatFalaq.close();
            descriptorThirdAyatFalaq.close();
            descriptorFourthAyatFalaq.close();
            descriptorFifthAyatFalaq.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (mediaPlayerFirstAyatFalaq.isPlaying()){
            firstAyatfalaq.setBackgroundResource(R.drawable.ic_pause);
        }



    }


    public void onClickReco(View view) {

        startActivity(SetupActivity.getStartIntent(getApplicationContext()));
    }

    public void firstAyatPlayfalaq(View view) {
        try {
            if (mediaPlayerFirstAyatFalaq.isPlaying()){
                mediaPlayerFirstAyatFalaq.pause();
                firstAyatfalaq.setBackgroundResource(R.drawable.ic_stop);
                Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
            }

            else {
                firstAyatfalaq.setBackgroundResource(R.drawable.ic_play);


                mediaPlayerFirstAyatFalaq.start();
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

    public void secondAyatPlayfalaq(View view) {
        try {
            if (mediaPlayerSecondAyatFalaq.isPlaying()){
                mediaPlayerSecondAyatFalaq.pause();
                secondAyatfalaq.setBackgroundResource(R.drawable.ic_stop);
                Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
            }

            else {
                secondAyatfalaq.setBackgroundResource(R.drawable.ic_play);

                mediaPlayerSecondAyatFalaq.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void thirdAyatPlayfalaq(View view) {

        try {
            if (mediaPlayerThirdAyatFalaq.isPlaying()){

                mediaPlayerThirdAyatFalaq.pause();
                thirdAyatfalaq.setBackgroundResource(R.drawable.ic_stop);
                Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
            }

            else {
                thirdAyatfalaq.setBackgroundResource(R.drawable.ic_play);

                mediaPlayerThirdAyatFalaq.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fourthAyatPlayfalaq(View view) {

        try {
            if (mediaPlayerThirdAyatFalaq.isPlaying()){

                mediaPlayerFourthAyatFalaq.pause();
                fourthAyatfalaq.setBackgroundResource(R.drawable.ic_stop);
                Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
            }

            else {
                fourthAyatfalaq.setBackgroundResource(R.drawable.ic_play);

                mediaPlayerFourthAyatFalaq.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fifthAyatPlayfalaq(View view) {

        try {
            if (mediaPlayerFifthAyatFalaq.isPlaying()){

                mediaPlayerFifthAyatFalaq.pause();
                fifthAyatfalaq.setBackgroundResource(R.drawable.ic_stop);
                Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
            }

            else {
                fifthAyatfalaq.setBackgroundResource(R.drawable.ic_play);

                mediaPlayerFifthAyatFalaq.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void onRecording(View view) {
        startActivity(SetupActivity.getStartIntent(getApplicationContext()));

    }
}