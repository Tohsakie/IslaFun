package com.example.fontanathacquarg.math;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.fontanathacquarg.ActivityChoice;
import com.example.fontanathacquarg.R;

public class ResultatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat_addition);

        TextView textView = findViewById(R.id.addition_resultat);
        int note = getIntent().getExtras().getInt("note");
        textView.setText(note + "/10");
    }

    public void onHome(View view){
        Intent intent = new Intent(ResultatActivity.this, ActivityChoice.class);
        startActivity(intent);
    }

}