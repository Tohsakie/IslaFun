package com.example.fontanathacquarg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityChoice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
    }

    public void onMath(View view){
        Intent MathViewActivityIntent = new Intent(ActivityChoice.this, MathActivity.class);
        startActivity(MathViewActivityIntent);
    }
}