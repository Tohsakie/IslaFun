package com.example.fontanathacquarg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;

public class ExerciceAdditionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice_addition);

        ArrayList<Row> additionArray = new ArrayList<>();
        String tempStr;
        Row tempRow;
        RowAdapter rowAdapter;
        ListView listView;

        for(int i = 1; i <= 10; i++){
            tempStr = new Random().nextInt(100) + " + " + new Random().nextInt(100) + " = ";
            tempRow = new Row(tempStr);
            tempRow.setId(i);
            additionArray.add(tempRow);
        }

        rowAdapter = new RowAdapter(this, R.layout.activity_exercice_multiply_row, additionArray, "+");
        listView = findViewById(R.id.listView);
        listView.setAdapter(rowAdapter);
    }
}