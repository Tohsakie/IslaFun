package com.example.fontanathacquarg.culture;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fontanathacquarg.R;
import com.example.fontanathacquarg.data.Culture;
import com.example.fontanathacquarg.data.DatabaseClient;

public class AddQuestionActivity extends AppCompatActivity {

    private DatabaseClient mdb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);
        mdb = DatabaseClient.getInstance(getApplicationContext());

        EditText question = findViewById(R.id.add_question);
        EditText reponse = findViewById(R.id.add_bonneReponse);
        EditText reponse1 = findViewById(R.id.add_mauvaise_reponse1);
        EditText reponse2 = findViewById(R.id.add_mauvaise_reponse2);

        Culture culture = new Culture();

        Button button = findViewById(R.id.valider);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Culture culture = new Culture();
                TextView question = findViewById(R.id.add_question);
                TextView bonneReponse = findViewById(R.id.add_bonneReponse);
                TextView mauvaiseReponse1 = findViewById(R.id.add_mauvaise_reponse1);
                TextView mauvaiseReponse2 = findViewById(R.id.add_mauvaise_reponse2);

                culture.setQuestion(question.getText().toString());
                culture.setBonneReponse(bonneReponse.getText().toString());
                culture.setMauvaiseReponse1(mauvaiseReponse1.getText().toString());
                culture.setMauvaiseReponse2(mauvaiseReponse2.getText().toString());

                mdb.getAppDatabase().cultureDAO().insert(culture);
                finish();
            }
        });
    }
}