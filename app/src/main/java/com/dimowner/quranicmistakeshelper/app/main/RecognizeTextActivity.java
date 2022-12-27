package com.dimowner.quranicmistakeshelper.app.main;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.dimowner.quranicmistakeshelper.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecognizeTextActivity extends AppCompatActivity {
    private final ArrayList<Logindata> data;
    private AppBarConfiguration appBarConfiguration;
    Intent intent = getIntent();
    String username;
    RecyclerView mRecyclerView;
    RecognizeTextAdapter recognizeTextAdapter;
    TextView word,errorRate,timestamp;
  public String[] Words=new String[100];

    public RecognizeTextActivity(ArrayList<Logindata> data) {
        this.data = data;
    }

    public void insertmistakeapivolleyPost(String username, String ayat,String words,String errorrate,String startime,String endTime){
        String postUrl = "https://arabicspeechbackend.herokuapp.com/insertmistakeapi";
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JSONObject postData = new JSONObject();
        try {

            postData.put("username", username);
            postData.put("ayat",ayat);
            postData.put("word",words);
            postData.put("errorrate",errorrate);
            postData.put("starttime",startime);
            postData.put("startend",endTime);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, postUrl, postData, new Response.Listener<JSONObject>() {
                public void onResponse(JSONObject response) {
                    System.out.println(response.toString());
                    //Intent intent = new Intent(getApplicationContext(), HomePageActivity .class);
                    //intent.putExtra("username",username);
                    //startActivity((intent));
                    Toast.makeText(getApplicationContext(), (CharSequence) response, Toast.LENGTH_SHORT).show();
                }
            }, new Response.ErrorListener() {

                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                }
            });

            requestQueue.add(jsonObjectRequest);

        }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.content_recognize_text);
        word = findViewById(R.id.word);
        timestamp = findViewById(R.id.timestamp);
        mRecyclerView = findViewById(R.id.mRecylerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        ArrayList<RecognizeTextData> myListData =new ArrayList<>();
        try {
            String sessionId = getIntent().getStringExtra("FirstApiRes");
            JSONArray jsonArray = new JSONArray(sessionId);
            JSONObject hello = jsonArray.getJSONObject(0);
            String words = hello.getString("surahverse");
            String ayat= words;
            String chunks_timestampes = hello.getString("status");
            Log.i("error",words+"\n"+chunks_timestampes);

            word.setText(words);

            timestamp.setText(chunks_timestampes);

            JSONArray combinewordsresult = hello.getJSONArray("combinewordsresult");
            for (int n=0;n<combinewordsresult.length();n++){
                Toast.makeText(this, ""+combinewordsresult.length(), Toast.LENGTH_SHORT).show();
                JSONObject object = combinewordsresult.getJSONObject(n);
                String surah=object.getString("word");
                String wordpredic= surah;
                String startTime = object.getString("starttime");
                String endTime = object.getString("endtime");
                String score = object.getString("score");
                String error = object.getString("distance");
                Bundle extras = getIntent().getExtras();
               // if(extras == null) {
               //     username= null;
               // } else {
                //    username= extras.getString("username");
               // }
               // System.out.println(UserId);
                SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                String username = sp.getString("username", String.valueOf(-1));
                System.out.println(username);
                insertmistakeapivolleyPost(username,ayat,wordpredic,error,startTime,endTime);
                myListData.add(new RecognizeTextData(surah,error,startTime,endTime));

            }
            recognizeTextAdapter = new RecognizeTextAdapter(myListData);

            mRecyclerView.setAdapter(recognizeTextAdapter);
//            Log.i("intentData",sessionId);
//
//            for (int i=0;i<jsonArray.length();i++){
//                Words[i]=jsonArray.getString(i).
//            }
           // timestamp.setText(name);
        }catch (Exception er){
            Log.i("error",er.getLocalizedMessage());
        }


    }
}
