package com.dimowner.quranicmistakeshelper.app.main;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import com.dimowner.quranicmistakeshelper.R;

public class KausarAyatActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    String flag="a";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String UserId = getIntent().getStringExtra("username");
        setContentView(R.layout.content_kausar_ayat2);
        Button btn1 = findViewById(R.id.btnkausar);
        Button btn2= findViewById(R.id.btnfalaq);
        Button btn3= findViewById(R.id.btnikhlas);
        Button btn4= findViewById(R.id.btnnaas);
        btn1.setOnClickListener(arg0 -> {
            flag="k";
            Log.e("char value : ",String.valueOf(flag));
            Intent intent = new Intent(getApplicationContext(), ListAyatKousarActivity .class);
            intent.putExtra("surah",flag);
            intent.putExtra("username",UserId);
            startActivity((intent));
        });
        btn2.setOnClickListener(arg0 -> {
            flag="f";
            Log.e("char value : ",String.valueOf(flag));
            Intent intent = new Intent(getApplicationContext(), ListAyatFalakActivity .class);
            intent.putExtra("surah",flag);
            startActivity((intent));
        });
        btn3.setOnClickListener(arg0 -> {
            flag="i";
            Log.e("char value : ",String.valueOf(flag));
            Intent intent = new Intent(getApplicationContext(), ListAyatIkhlasActivity .class);
            intent.putExtra("surah",flag);
            intent.putExtra("username",UserId);
            startActivity((intent));
        });
        btn4.setOnClickListener(arg0 -> {
            flag="n";
            Log.e("char value : ",String.valueOf(flag));
            Intent intent = new Intent(getApplicationContext(), ListAyatNaasActivity.class);
            intent.putExtra("surah",flag);
            intent.putExtra("username",UserId);
            startActivity((intent));
        });





    }



   // public void onClickAyat(View view) {
   //     Intent intent = new Intent(getApplicationContext(), ListAyatKousarActivity .class);
   //     startActivity((intent));
        //	finish();
    //}
}