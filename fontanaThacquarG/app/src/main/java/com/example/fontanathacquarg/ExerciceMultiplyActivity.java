package com.example.fontanathacquarg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ExerciceMultiplyActivity extends AppCompatActivity {

    public static int MATH_KEY = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice_multiply);
        MATH_KEY = getIntent().getExtras().getInt("laTable");
        ArrayList<String> multiplicationArray = new ArrayList<>();
        String tempStr;
        for(int i = 0; i <= 10; i++){
            tempStr = MATH_KEY + " x " + i + " = ";
            multiplicationArray.add(tempStr);
        }

        ArrayAdapter adapter = new ArrayAdapter<>(this, R.layout.activity_exercice_multiply_row, multiplicationArray);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }
}