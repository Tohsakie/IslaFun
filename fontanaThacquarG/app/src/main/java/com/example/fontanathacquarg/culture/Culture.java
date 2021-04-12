package com.example.fontanathacquarg.culture;

import androidx.*;
import java.io.Serializable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Culture {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "question")
    private String question;

    @ColumnInfo(name = "bonneReponse")
    private String bonneReponse;

    @ColumnInfo(name = "mauvaiseReponse1")
    private String mauvaiseReponse1;

    @ColumnInfo(name = "mauvaiseReponse2")
    private String mauvaiseReponse2;

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getBonneReponse() {
        return bonneReponse;
    }

    public String getMauvaiseReponse1() {
        return mauvaiseReponse1;
    }

    public String getMauvaiseReponse2() {
        return mauvaiseReponse2;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setBonneReponse(String bonneReponse) {
        this.bonneReponse = bonneReponse;
    }

    public void setMauvaiseReponse1(String mauvaiseReponse1) {
        this.mauvaiseReponse1 = mauvaiseReponse1;
    }

    public void setMauvaiseReponse2(String mauvaiseReponse2) {
        this.mauvaiseReponse2 = mauvaiseReponse2;
    }
}

