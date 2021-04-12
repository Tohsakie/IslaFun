package com.example.fontanathacquarg.culture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fontanathacquarg.R;

public class CultureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_culture);


    }

    public void onAdd(String nameAcitivty){

        Intent addQuestionIntent = new Intent(this, AddQuestionActivity.class);
        startActivity(addQuestionIntent);
        }

    public void onExerciceQuestion(View view){

        Intent exerciceQuestionIntent = new Intent(CultureActivity.this, CultureExerciceActivity.class);
        startActivity(exerciceQuestionIntent);
    }

    public void onAddQuestion(View view){
        Intent cultureExerciceIntent = new Intent(CultureActivity.this, AddQuestionActivity.class);
        startActivity(cultureExerciceIntent);
    }
}