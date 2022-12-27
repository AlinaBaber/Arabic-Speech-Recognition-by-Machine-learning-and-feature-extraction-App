package com.dimowner.quranicmistakeshelper.app.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
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

import org.json.JSONException;
import org.json.JSONObject;
//import okhttp3.Response;

public class SignupPageActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    String flag = "a";
    String Username, Password, Email;
    Void loginresponse, signupresponse;
    public void showSoftKeyboard(View view){
        if(view.requestFocus()){
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(view,InputMethodManager.SHOW_IMPLICIT);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_signup);
        //Button login = findViewById(R.id.loginbtn);
        Button exitsignup = findViewById(R.id.signupexitbtn);
        Button signup = findViewById(R.id.signupbtn);
        Button clearsignup = findViewById(R.id.signclearbtn);
        EditText et = (EditText) findViewById(R.id.signusernametxt);

        EditText et1 = (EditText) findViewById(R.id.signupemailtxt);

        EditText et2 = (EditText) findViewById(R.id.signuppasswordtxt);

        showSoftKeyboard(et);
        showSoftKeyboard(et1);
        showSoftKeyboard(et2);
        et.setImeOptions(EditorInfo.IME_ACTION_DONE);
        et1.setImeOptions(EditorInfo.IME_ACTION_DONE);
        et2.setImeOptions(EditorInfo.IME_ACTION_DONE);

        exitsignup.setOnClickListener(arg0 -> {
            //    signapi(Username, Email,Password);
            flag = "k";
            Log.e("char value : ", String.valueOf(flag));

            finishAffinity();

        });
        clearsignup.setOnClickListener(arg0 -> {
            flag = "f";
            Log.e("char value : ", String.valueOf(flag));
            et.getText().clear();
            et1.getText().clear();
            et2.getText().clear();
            //    startActivity(RecordsActivity.getStartIntent(getApplicationContext()));
        });
        signup.setOnClickListener(arg0 -> {
            Username = et.getText().toString();
            Email = et1.getText().toString();
            Password = et2.getText().toString();
            signapivolleyPost(Username, Email, Password);
            flag = "i";
            Log.e("char value : ", String.valueOf(flag));
            //Intent intent = new Intent(getApplicationContext(), HomePageActivity .class);
            //intent.putExtra("Page",flag);
            //startActivity((intent));
        });


    }
    public void signapivolleyPost(String username, String email, String password){
        String postUrl = "https://arabicspeechbackend.herokuapp.com/signupapi";
            RequestQueue requestQueue = Volley.newRequestQueue(this);

            JSONObject postData = new JSONObject();
            try {
                postData.put("username", username);
                postData.put("email",email);
                postData.put("password", password);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, postUrl, postData, new Response.Listener<JSONObject>() {
                public void onResponse(JSONObject response) {
                    System.out.println(response.toString());
                    Intent intent = new Intent(getApplicationContext(), HomePageActivity .class);
                    intent.putExtra("username",username);
                    startActivity((intent));
                    Toast.makeText(getApplicationContext(), (CharSequence) response, Toast.LENGTH_SHORT).show();
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