package com.example.fontanathacquarg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultatAdditionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat_addition);

        TextView textView = findViewById(R.id.addition_resultat);
        int note = getIntent().getExtras().getInt("note");
        textView.setText(note + "/10");
    }
}