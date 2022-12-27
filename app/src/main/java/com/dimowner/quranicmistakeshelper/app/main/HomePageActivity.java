package com.dimowner.quranicmistakeshelper.app.main;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.dimowner.quranicmistakeshelper.R;
import com.dimowner.quranicmistakeshelper.app.settings.SettingsActivity;

import org.json.JSONObject;

public class HomePageActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    String flag="a";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_home_page);
        String UserId = getIntent().getStringExtra("username");
        TextView welcometext = findViewById(R.id.welcomeusertxt);
        welcometext.setText("Welcome "+UserId+ " Start reciting Quran Today.");
        Button btn1 = findViewById(R.id.btnstartrecitation);
        Button btn2= findViewById(R.id.btnlistenmistakes);
        Button btn3= findViewById(R.id.btnsettings);
        Button btn4= findViewById(R.id.btnabout);
        Button btn5= findViewById(R.id.btnfaq);
        Button btn6= findViewById(R.id.btnexit) ;
        btn1.setOnClickListener(arg0 -> {
            flag="k";
            Log.e("char value : ",String.valueOf(flag));
            Intent intent = new Intent(getApplicationContext(), KausarAyatActivity .class);
            intent.putExtra("Page",flag);
            startActivity((intent));
        });
        btn2.setOnClickListener(arg0 -> {
            flag="n";
            Log.e("char value : ",String.valueOf(flag));
            Intent intent = new Intent(getApplicationContext(), ListofMistakesActivity .class);
            intent.putExtra("username",UserId);
            startActivity((intent));
        });
        btn3.setOnClickListener(arg0 -> {
            flag="i";
            Log.e("char value : ",String.valueOf(flag));
            startActivity(SettingsActivity.getStartIntent(getApplicationContext()));
        });
        btn4.setOnClickListener(arg0 -> {
            flag="n";
            Log.e("char value : ",String.valueOf(flag));
            Intent intent = new Intent(getApplicationContext(), AboutActivity .class);
            intent.putExtra("Page",flag);
            startActivity((intent));
        });
        btn5.setOnClickListener(arg0 -> {
            flag="k";
            Log.e("char value : ",String.valueOf(flag));
            Intent intent = new Intent(getApplicationContext(), FAQActivity .class);
            intent.putExtra("Page",flag);
            startActivity((intent));
        });
        btn6.setOnClickListener(arg0 -> {
            flag="k";
            Log.e("char value : ",String.valueOf(flag));
            logoutapivolleyPost();
            Intent intent = new Intent(getApplicationContext(), LoginSignupPageActivity .class);
            intent.putExtra("Page",flag);
            startActivity((intent));
            //finishAffinity();


        });





    }

    public void logoutapivolleyPost(){
        String postUrl = "https://arabicspeechbackend.herokuapp.com/logoutapi";
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JSONObject postData = new JSONObject();
        //try {
           // postData.put("username", username);
         //   postData.put("password", password);

       // } catch (JSONException e) {
         //   e.printStackTrace();
        //}

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, postUrl, postData, new Response.Listener<JSONObject>() {
            public void onResponse(JSONObject response) {
                System.out.println(response.toString());
                Intent intent = new Intent(getApplicationContext(), LoginSignupPageActivity .class);
                intent.putExtra("response",response.toString());

                Toast.makeText(getApplicationContext(), (CharSequence)response.toString(), Toast.LENGTH_SHORT).show();
                startActivity((intent));
            }
        }, new Response.ErrorListener() {

            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(jsonObjectRequest);

    }


    // public void onClickAyat(View view) {
   //     Intent intent = new Intent(getApplicationContext(), ListAyatKousarActivity .class);
   //     startActivity((intent));
        //	finish();
    //}
}