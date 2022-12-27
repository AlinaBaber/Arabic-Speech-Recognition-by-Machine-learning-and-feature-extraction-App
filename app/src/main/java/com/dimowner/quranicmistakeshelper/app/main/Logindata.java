package com.dimowner.quranicmistakeshelper.app.main;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Logindata {
    String username,password;

    //public String getEndTime() {
     //   return endTime;
    //}
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    //public void setEndTime(String endTime) {
     //   this.endTime = endTime;
    //}

    public Logindata(String username, String password) {
        this.username = username;
        this.password = password;
        //this.time = time;
        //this.endTime = endTime;

    }

    //public String getWord() {
    //    return word;
    //}

    //public void setWord(String word) {
    //    this.word = word;
    //}

   // public String getError() {
    //    return error;
   // }

    //public void setError(String error) {
     //   this.error = error;
    //}

    //public String getTime() {
    //    return time;
    //}

    //public void setTime(String time) {
    //    this.time = time;
    //}

}
