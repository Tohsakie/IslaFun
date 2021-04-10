package com.example.fontanathacquarg;

import android.widget.ArrayAdapter;

public class Row {
    private String question;
    private String reponse;

    public Row(String question){
        this.question = question;
        this.reponse = "default";
    }

    public String getQuestion() {
        return question;
    }

    public String getReponse() {
        return reponse;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }
}