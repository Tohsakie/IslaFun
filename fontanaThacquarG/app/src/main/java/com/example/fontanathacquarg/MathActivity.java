package com.example.fontanathacquarg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MathActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathex);
    }

    public void onMult(View view){
        Intent ExoViewActivityIntent = new Intent(MathActivity.this, ChoiceMultiplyActivity.class);

        startActivity(ExoViewActivityIntent);
    }
}