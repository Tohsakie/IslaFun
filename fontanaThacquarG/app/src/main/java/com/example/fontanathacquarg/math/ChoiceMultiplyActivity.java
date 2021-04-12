package com.example.fontanathacquarg.math;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;

import com.example.fontanathacquarg.R;

public class ChoiceMultiplyActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_multiply);
        NumberPicker np = findViewById(R.id.tablePicker);

        np.setMinValue(0);
        np.setMaxValue(10);
    }

    public void validerTable(View view){
        NumberPicker np = findViewById(R.id.tablePicker);
        int laTable = np.getValue();

        Intent intent = new Intent(this, ExerciceMultiplyActivity.class);
        intent.putExtra("laTable", laTable);
        startActivity(intent);
    }
}