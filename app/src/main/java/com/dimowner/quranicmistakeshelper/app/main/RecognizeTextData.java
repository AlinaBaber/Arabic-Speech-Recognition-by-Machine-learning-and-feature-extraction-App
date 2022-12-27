package com.dimowner.quranicmistakeshelper.app.main;

public class RecognizeTextData {
    String word,error,time,endTime;

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public RecognizeTextData(String word, String error, String time, String endTime) {
        this.word = word;
        this.error = error;
        this.time = time;
        this.endTime = endTime;

    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
