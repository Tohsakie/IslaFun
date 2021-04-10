package com.example.fontanathacquarg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ExerciceMultiplyActivity extends AppCompatActivity {

    public static int MATH_KEY = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice_multiply);
        MATH_KEY = getIntent().getExtras().getInt("laTable");
        ArrayList<Row> multiplicationArray = new ArrayList<>();
        String tempStr;
        Row tempRow;
        RowAdapter rowAdapter;
        for(int i = 0; i <= 10; i++){
            tempStr = MATH_KEY + " x " + i + " = ";
            tempRow = new Row(tempStr);
            tempRow.setId(i);
            multiplicationArray.add(tempRow);
        }

        rowAdapter = new RowAdapter(this, R.layout.activity_exercice_multiply_row, multiplicationArray, "*");
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(rowAdapter);
    }

}