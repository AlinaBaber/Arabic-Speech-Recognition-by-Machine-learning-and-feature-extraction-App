package com.dimowner.quranicmistakeshelper.app.main;

import android.content.Intent;
import android.os.Bundle;
import android.widget.VideoView;

import com.dimowner.quranicmistakeshelper.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

public class FAQActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    String flag="a";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_faq);
        VideoView videoView = (VideoView) findViewById(R.id.videotutorials);  //casting to VideoView is not Strictly required above API level 26
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.video1); //set the path of the video that we need to use in our VideoView
        videoView.start();



    }

    private void finish(Intent intent) {
    }


    // public void onClickAyat(View view) {
   //     Intent intent = new Intent(getApplicationContext(), ListAyatKousarActivity .class);
   //     startActivity((intent));
        //	finish();
    //}
}