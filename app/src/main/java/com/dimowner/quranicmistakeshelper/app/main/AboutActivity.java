package com.dimowner.quranicmistakeshelper.app.main;

import android.content.Intent;
import android.os.Bundle;

import com.dimowner.quranicmistakeshelper.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

public class AboutActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    String flag="a";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_about);



    }

    private void finish(Intent intent) {
    }


    // public void onClickAyat(View view) {
   //     Intent intent = new Intent(getApplicationContext(), ListAyatKousarActivity .class);
   //     startActivity((intent));
        //	finish();
    //}
}