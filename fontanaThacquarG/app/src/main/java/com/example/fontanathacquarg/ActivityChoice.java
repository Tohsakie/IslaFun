package com.example.fontanathacquarg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fontanathacquarg.culture.CultureActivity;
import com.example.fontanathacquarg.culture.CultureExerciceActivity;
import com.example.fontanathacquarg.data.Culture;
import com.example.fontanathacquarg.math.MathActivity;

public class ActivityChoice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
    }

    public void onMath(View view){
        Intent mathViewActivityIntent = new Intent(ActivityChoice.this, MathActivity.class);
        startActivity(mathViewActivityIntent);
    }

    public void onCulture(View view){
        Intent cultureActivity = new Intent(ActivityChoice.this, CultureActivity.class);
        startActivity(cultureActivity);
    }


}