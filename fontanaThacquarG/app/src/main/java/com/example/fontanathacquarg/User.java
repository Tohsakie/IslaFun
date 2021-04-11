package com.example.fontanathacquarg;
import androidx.*;
import java.io.Serializable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User{
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name ="nom")
    private String nom;

    @ColumnInfo(name ="prenom")
    private String prenom;


    public User(String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getId() {
        return id;
    }
}