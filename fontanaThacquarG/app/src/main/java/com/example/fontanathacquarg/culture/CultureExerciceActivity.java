package com.example.fontanathacquarg.culture;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.fontanathacquarg.R;
import com.example.fontanathacquarg.data.DatabaseClient;

public class CultureExerciceActivity extends AppCompatActivity {

    private DatabaseClient mdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_culture_exercice);
        mdb = DatabaseClient.getInstance(getApplicationContext());


    }
}