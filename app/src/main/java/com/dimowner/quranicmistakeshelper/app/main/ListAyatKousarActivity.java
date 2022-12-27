package com.dimowner.quranicmistakeshelper.app.main;

import android.annotation.SuppressLint;
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

public class ListAyatKousarActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;

    MediaPlayer mediaPlayerFirstAyat;
    MediaPlayer mediaPlayerFirstAyatAtina;
    MediaPlayer mediaPlayerFirstAyatInna;
    MediaPlayer mediaPlayerFirstAyatKausar;

    MediaPlayer mediaPlayerSecondAyat ;
    MediaPlayer mediaPlayerSecondAyatFasalli ;
    MediaPlayer mediaPlayerSecondAyatLirabbika ;
    MediaPlayer mediaPlayerSecondAyatWanhar ;


    MediaPlayer mediaPlayerThirdAyat;
    MediaPlayer mediaPlayerThirdAyatIna;
    MediaPlayer mediaPlayerThirdAyatShaniaka;
    MediaPlayer mediaPlayerThirdAyatAbtar;


    ImageButton firstAyat,firstAyatInna,firstAyatAtina, firstAyatKausar,secondAyatImageButton,secondAyatImageButtonFasalli,secondAyatImageButtonLirabbika,secondAyatImageButtonWanhar,
            thirdAyatImageButton,thirdAyatImageButtonIna,thirdAyatImageButtonShaniaka, thirdAyatImageButtonAbtar;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
;
        setContentView(R.layout.content_list_ayat_kousar);
        mediaPlayerFirstAyat = new MediaPlayer();
        mediaPlayerFirstAyatInna = new MediaPlayer();
        mediaPlayerFirstAyatAtina = new MediaPlayer();
        mediaPlayerFirstAyatKausar =new MediaPlayer();

        mediaPlayerSecondAyat = new MediaPlayer();
        mediaPlayerSecondAyatFasalli = new MediaPlayer();
        mediaPlayerSecondAyatLirabbika = new MediaPlayer();
        mediaPlayerSecondAyatWanhar = new MediaPlayer();

         mediaPlayerThirdAyat = new MediaPlayer();
        mediaPlayerThirdAyatIna = new MediaPlayer();
        mediaPlayerThirdAyatShaniaka = new MediaPlayer();
        mediaPlayerThirdAyatAbtar = new MediaPlayer();

        firstAyat = findViewById(R.id.btnkausar1n);
        firstAyatInna = findViewById(R.id.btnkausar1nInna);
        firstAyatAtina = findViewById(R.id.btnkausar1nAtina);
        firstAyatKausar = findViewById(R.id.btnkausar1nKausar);

        secondAyatImageButton = findViewById(R.id.btnkausar2);
        secondAyatImageButtonFasalli = findViewById(R.id.btnkausar2Fasalli);
        secondAyatImageButtonLirabbika = findViewById(R.id.btnkausar2Lirabbika);
        secondAyatImageButtonWanhar = findViewById(R.id.btnkausar2Wanhar);


        thirdAyatImageButton = findViewById(R.id.btnkausar3);
        thirdAyatImageButtonIna = findViewById(R.id.btnkausar3Ina);
        thirdAyatImageButtonShaniaka = findViewById(R.id.btnkausar3Shaniaka);
        thirdAyatImageButtonAbtar = findViewById(R.id.btnkausar3Abtar);


        try {
            AssetFileDescriptor descriptor = this.getAssets().openFd("firstayat.wav");
            mediaPlayerFirstAyat.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getLength());
            mediaPlayerFirstAyat.prepare();
            mediaPlayerFirstAyat.setVolume(1f, 1f);
            mediaPlayerFirstAyat.setLooping(false);

            AssetFileDescriptor descriptorInna = this.getAssets().openFd("Inna.wav");
            mediaPlayerFirstAyatInna.setDataSource(descriptor.getFileDescriptor(), descriptorInna.getStartOffset(), descriptor.getLength());
            mediaPlayerFirstAyatInna.prepare();
            mediaPlayerFirstAyatInna.setVolume(1f, 1f);
            mediaPlayerFirstAyatInna.setLooping(false);

            AssetFileDescriptor descriptorAtina = this.getAssets().openFd("Atina.wav");
            mediaPlayerFirstAyatAtina.setDataSource(descriptor.getFileDescriptor(), descriptorAtina.getStartOffset(), descriptor.getLength());
            mediaPlayerFirstAyatAtina.prepare();
            mediaPlayerFirstAyatAtina.setVolume(1f, 1f);
            mediaPlayerFirstAyatAtina.setLooping(false);

            AssetFileDescriptor descriptorKausar = this.getAssets().openFd("Kausar.wav");
            mediaPlayerFirstAyatKausar.setDataSource(descriptor.getFileDescriptor(), descriptorKausar.getStartOffset(), descriptor.getLength());
            mediaPlayerFirstAyatKausar.prepare();
            mediaPlayerFirstAyatKausar.setVolume(1f, 1f);
            mediaPlayerFirstAyatKausar.setLooping(false);



            AssetFileDescriptor descriptorSecondAyat = this.getAssets().openFd("secondayat.wav");
            mediaPlayerSecondAyat.setDataSource(descriptorSecondAyat.getFileDescriptor(), descriptorSecondAyat.getStartOffset(), descriptorSecondAyat.getLength());

            mediaPlayerSecondAyat.prepare();
            mediaPlayerSecondAyat.setVolume(1f, 1f);
            mediaPlayerSecondAyat.setLooping(false);


            AssetFileDescriptor descriptorSecondAyatFasalli = this.getAssets().openFd("Fasalli.wav");
            mediaPlayerSecondAyatFasalli.setDataSource(descriptorSecondAyatFasalli.getFileDescriptor(), descriptorSecondAyatFasalli.getStartOffset(), descriptorSecondAyat.getLength());

            mediaPlayerSecondAyatFasalli.prepare();
            mediaPlayerSecondAyatFasalli.setVolume(1f, 1f);
            mediaPlayerSecondAyatFasalli.setLooping(false);


            AssetFileDescriptor descriptorSecondAyatLirabbika = this.getAssets().openFd("Lirabbika.wav");
            mediaPlayerSecondAyatLirabbika.setDataSource(descriptorSecondAyatLirabbika.getFileDescriptor(), descriptorSecondAyatLirabbika.getStartOffset(), descriptorSecondAyat.getLength());

            mediaPlayerSecondAyatLirabbika.prepare();
            mediaPlayerSecondAyatLirabbika.setVolume(1f, 1f);
            mediaPlayerSecondAyatLirabbika.setLooping(false);

            AssetFileDescriptor descriptorSecondAyatWanhar = this.getAssets().openFd("Wanhar.wav");
            mediaPlayerSecondAyatWanhar.setDataSource(descriptorSecondAyatWanhar.getFileDescriptor(), descriptorSecondAyatWanhar.getStartOffset(), descriptorSecondAyat.getLength());

            mediaPlayerSecondAyatWanhar.prepare();
            mediaPlayerSecondAyatWanhar.setVolume(1f, 1f);
            mediaPlayerSecondAyatWanhar.setLooping(false);



            AssetFileDescriptor descriptorThirdAyat = this.getAssets().openFd("thirdayat.wav");
            mediaPlayerThirdAyat.setDataSource(descriptorThirdAyat.getFileDescriptor(), descriptorThirdAyat.getStartOffset(), descriptorThirdAyat.getLength());

            mediaPlayerThirdAyat.prepare();
            mediaPlayerThirdAyat.setVolume(1f, 1f);
            mediaPlayerThirdAyat.setLooping(false);

            AssetFileDescriptor descriptorThirdAyatIna = this.getAssets().openFd("Ina.wav");
            mediaPlayerThirdAyatIna.setDataSource(descriptorThirdAyatIna.getFileDescriptor(), descriptorThirdAyatIna.getStartOffset(), descriptorThirdAyat.getLength());

            mediaPlayerThirdAyatIna.prepare();
            mediaPlayerThirdAyatIna.setVolume(1f, 1f);
            mediaPlayerThirdAyatIna.setLooping(false);

            AssetFileDescriptor descriptorThirdAyatShaniaka = this.getAssets().openFd("Shaniaka.wav");
            mediaPlayerThirdAyatShaniaka.setDataSource(descriptorThirdAyatShaniaka.getFileDescriptor(), descriptorThirdAyatShaniaka.getStartOffset(), descriptorThirdAyat.getLength());

            mediaPlayerThirdAyatShaniaka.prepare();
            mediaPlayerThirdAyatShaniaka.setVolume(1f, 1f);
            mediaPlayerThirdAyatShaniaka.setLooping(false);

            AssetFileDescriptor descriptorThirdAyatAbtar = this.getAssets().openFd("Abtar.wav");
            mediaPlayerThirdAyatAbtar.setDataSource(descriptorThirdAyatAbtar.getFileDescriptor(), descriptorThirdAyatAbtar.getStartOffset(), descriptorThirdAyat.getLength());

            mediaPlayerThirdAyatAbtar.prepare();
            mediaPlayerThirdAyatAbtar.setVolume(1f, 1f);
            mediaPlayerThirdAyatAbtar.setLooping(false);

            descriptor.close();
            descriptorSecondAyat.close();
            descriptorThirdAyat.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (mediaPlayerFirstAyat.isPlaying()){
            firstAyat.setBackgroundResource(R.drawable.ic_pause);
        }



    }


    public void onClickReco(View view) {
        startActivity(SetupActivity.getStartIntent(getApplicationContext()));
    }

    public void firstAyatPlay(View view) {
        try {
            if (mediaPlayerFirstAyat.isPlaying()){
                mediaPlayerFirstAyat.pause();
                firstAyat.setBackgroundResource(R.drawable.ic_stop);
                Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
            }

            else {
                firstAyat.setBackgroundResource(R.drawable.ic_play);


                mediaPlayerFirstAyat.start();
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

    public void InnaPlay(View view) {
        try {
            if (mediaPlayerFirstAyatInna.isPlaying()){
                mediaPlayerFirstAyatInna.pause();
                firstAyatInna.setBackgroundResource(R.drawable.ic_stop);
                Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
            }

            else {
                firstAyatInna.setBackgroundResource(R.drawable.ic_play);


                mediaPlayerFirstAyatInna.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    public void AtinaPlay(View view) {
        try {
            if (mediaPlayerFirstAyatAtina.isPlaying()){
                mediaPlayerFirstAyatAtina.pause();
                firstAyatAtina.setBackgroundResource(R.drawable.ic_stop);
                Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
            }

            else {
                firstAyatAtina.setBackgroundResource(R.drawable.ic_play);


                mediaPlayerFirstAyatAtina.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    public void KausarPlay(View view) {
        try {
            if (mediaPlayerFirstAyatKausar.isPlaying()){
                mediaPlayerFirstAyatKausar.pause();
                firstAyatKausar.setBackgroundResource(R.drawable.ic_stop);
                Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
            }

            else {
                firstAyatKausar.setBackgroundResource(R.drawable.ic_play);


                mediaPlayerFirstAyatKausar.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }



    }






    public void secondAyatPlay(View view) {
        try {
            if (mediaPlayerSecondAyat.isPlaying()){
                mediaPlayerSecondAyat.pause();
                secondAyatImageButton.setBackgroundResource(R.drawable.ic_stop);
                Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
            }

            else {
                secondAyatImageButton.setBackgroundResource(R.drawable.ic_play);

                mediaPlayerSecondAyat.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void secondAyatPlayFasalli(View view) {
        try {
            if (mediaPlayerSecondAyatFasalli.isPlaying()){
                mediaPlayerSecondAyatFasalli.pause();
                secondAyatImageButtonFasalli.setBackgroundResource(R.drawable.ic_stop);
                Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
            }

            else {
                secondAyatImageButtonFasalli.setBackgroundResource(R.drawable.ic_play);

                mediaPlayerSecondAyatFasalli.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void secondAyatPlayLirabbika(View view) {
        try {
            if (mediaPlayerSecondAyatLirabbika.isPlaying()){
                mediaPlayerSecondAyatLirabbika.pause();
                secondAyatImageButtonLirabbika.setBackgroundResource(R.drawable.ic_stop);
                Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
            }

            else {
                secondAyatImageButtonLirabbika.setBackgroundResource(R.drawable.ic_play);

                mediaPlayerSecondAyatLirabbika.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void secondAyatPlayWanhar(View view) {
        try {
            if (mediaPlayerSecondAyatWanhar.isPlaying()){
                mediaPlayerSecondAyatWanhar.pause();
                secondAyatImageButtonWanhar.setBackgroundResource(R.drawable.ic_stop);
                Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
            }

            else {
                secondAyatImageButtonWanhar.setBackgroundResource(R.drawable.ic_play);

                mediaPlayerSecondAyatWanhar.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void thirdAyatPlay(View view) {

        try {
            if (mediaPlayerThirdAyat.isPlaying()){

                mediaPlayerThirdAyat.pause();
                thirdAyatImageButton.setBackgroundResource(R.drawable.ic_stop);
                Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
            }

            else {
                thirdAyatImageButton.setBackgroundResource(R.drawable.ic_play);

                mediaPlayerThirdAyat.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void thirdAyatPlayIna(View view) {

        try {
            if (mediaPlayerThirdAyatIna.isPlaying()){

                mediaPlayerThirdAyatIna.pause();
                thirdAyatImageButtonIna.setBackgroundResource(R.drawable.ic_stop);
                Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
            }

            else {
                thirdAyatImageButtonIna.setBackgroundResource(R.drawable.ic_play);

                mediaPlayerThirdAyatIna.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void thirdAyatPlayShaniaka(View view) {

        try {
            if (mediaPlayerThirdAyatShaniaka.isPlaying()){

                mediaPlayerThirdAyatShaniaka.pause();
                thirdAyatImageButtonShaniaka.setBackgroundResource(R.drawable.ic_stop);
                Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
            }

            else {
                thirdAyatImageButtonShaniaka.setBackgroundResource(R.drawable.ic_play);

                mediaPlayerThirdAyatShaniaka.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void thirdAyatPlayAbtar(View view) {

        try {
            if (mediaPlayerThirdAyatAbtar.isPlaying()){

                mediaPlayerThirdAyatAbtar.pause();
                thirdAyatImageButtonAbtar.setBackgroundResource(R.drawable.ic_stop);
                Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
            }

            else {
                thirdAyatImageButtonAbtar.setBackgroundResource(R.drawable.ic_play);

                mediaPlayerThirdAyatAbtar.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onRecording(View view) {

        startActivity(SetupActivity.getStartIntent(getApplicationContext()));

    }
}