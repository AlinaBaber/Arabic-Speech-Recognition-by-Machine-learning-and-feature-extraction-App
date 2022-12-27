package com.dimowner.quranicmistakeshelper.app.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
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

public class LoginSignupPageActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    String flag="a";
    String Username,Password,Email;
    Void loginresponse,signupresponse;

    public void showSoftKeyboard(View view){
        if(view.requestFocus()){
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(view,InputMethodManager.SHOW_IMPLICIT);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_login);
        Button login = findViewById(R.id.loginbtn);
        Button clearlogin= findViewById(R.id.loginclearbtn);
        Button signuppages= findViewById(R.id.creataccountbtn);
        Button exit= findViewById(R.id.loginexitbtn);
        EditText et = (EditText) findViewById(R.id.loginusernamestxt);
        EditText et1 = (EditText) findViewById(R.id.loginpasswordtxt);
        et.setOnClickListener(arg0->{
            showSoftKeyboard(et);
                });
        et1.setOnClickListener(arg0->{
            showSoftKeyboard(et1);
        });

        et.setImeOptions(EditorInfo.IME_ACTION_DONE);
        et1.setImeOptions(EditorInfo.IME_ACTION_DONE);
       // Username= et.getText().toString();

        //Password= et1.getText().toString();
        login.setOnClickListener(arg0 -> {
            Username= et.getText().toString();
            Password= et1.getText().toString();
            loginapivolleyPost( Username, Password);
            flag="k";
            Log.e("char value : ",String.valueOf(flag));
            //Intent intent = new Intent(getApplicationContext(), HomePageActivity .class);
            //intent.putExtra("Page",flag);
            //startActivity((intent));
        });
        clearlogin.setOnClickListener(arg0 -> {
            et.getText().clear();
            et1.getText().clear();
            flag="f";
           Log.e("char value : ",String.valueOf(flag));
        //    startActivity(RecordsActivity.getStartIntent(getApplicationContext()));
        });
        signuppages.setOnClickListener(arg0 -> {
        //    signapi(Username, Email,Password);
           flag="i";
            Log.e("char value : ",String.valueOf(flag));
            Intent intent = new Intent(getApplicationContext(), SignupPageActivity.class);
            intent.putExtra("Page",flag);
            startActivity((intent));
        });
        exit.setOnClickListener(arg0 -> {
            //    signapi(Username, Email,Password);
            flag="k";
            Log.e("char value : ",String.valueOf(flag));

            finishAffinity();

        });






    }

    public void loginapivolleyPost(String username, String password){
        String postUrl = "https://arabicspeechbackend.herokuapp.com/loginapi";
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JSONObject postData = new JSONObject();
        try {
            postData.put("username", username);
            postData.put("password", password);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, postUrl, postData, new Response.Listener<JSONObject>() {
            public void onResponse(JSONObject response) {
                System.out.println(response.toString());

                Intent intent = new Intent(getApplicationContext(), HomePageActivity .class);
                intent.putExtra("username",username);
                SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("username", username);
                editor.commit();

                startActivity((intent));
                Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
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