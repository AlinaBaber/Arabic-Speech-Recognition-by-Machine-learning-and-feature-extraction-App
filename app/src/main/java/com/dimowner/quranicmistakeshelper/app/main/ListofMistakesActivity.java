package com.dimowner.quranicmistakeshelper.app.main;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.dimowner.quranicmistakeshelper.R;

import org.json.JSONException;
import org.json.JSONObject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

public class ListofMistakesActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    String flag="a";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_listmistakes);


        SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
        String username1 = sp.getString("username", String.valueOf(-1));
        System.out.println(username1);
        viewmistakesvolleyPost(username1);


    }
    public void viewmistakesvolleyPost(String username){
        String postUrl = "https://arabicspeechbackend.herokuapp.com/viewmistakeapi";
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JSONObject postData = new JSONObject();
        try {
            postData.put("username", username);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, postUrl, postData, new Response.Listener<JSONObject>() {
            public void onResponse(JSONObject response) {
                System.out.println(response.toString());
                //Intent intent = new Intent(getApplicationContext(), HomePageActivity .class);
                //intent.putExtra("username",username);
                //startActivity((intent));
                TextView et = (TextView) findViewById(R.id.listofmistakestxt);

                    Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();

                    et.setText(response.toString());
                }
        }, new Response.ErrorListener() {

            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(jsonObjectRequest);

    }
    private void finish(Intent intent) {
    }


    // public void onClickAyat(View view) {
   //     Intent intent = new Intent(getApplicationContext(), ListAyatKousarActivity .class);
   //     startActivity((intent));
        //	finish();
    //}
}