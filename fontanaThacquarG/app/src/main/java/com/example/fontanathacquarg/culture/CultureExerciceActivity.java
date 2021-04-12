package com.example.fontanathacquarg.culture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fontanathacquarg.R;
import com.example.fontanathacquarg.data.Culture;
import com.example.fontanathacquarg.data.CultureDAO;
import com.example.fontanathacquarg.data.DatabaseClient;
import com.example.fontanathacquarg.math.ResultatActivity;

import java.util.List;
import java.util.Random;

public class CultureExerciceActivity extends AppCompatActivity {

    List<Culture> cultureList;

    private int round = 0;
    private int bonneRep = 0;
    private int nbBonneReponses = 0;

    private CultureDAO mcultureDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_culture_exercice);
        DatabaseClient mdb = DatabaseClient.getInstance(getApplicationContext());


        cultureList = mdb.getAppDatabase()
                .cultureDAO()
                .getAll();

        updateQuestion();
    }

    public void valider(View view){

        RadioGroup radioGroup = findViewById(R.id.radio_groupe);

        switch (bonneRep){
            case 0:
                if (radioGroup.getCheckedRadioButtonId() == R.id.rep1){
                    nbBonneReponses++;
                }
            case 1:
                if (radioGroup.getCheckedRadioButtonId() == R.id.rep2){
                    nbBonneReponses++;
                }
            case 2:
                if (radioGroup.getCheckedRadioButtonId() == R.id.rep3){
                    nbBonneReponses++;
                }
        }
        radioGroup.clearCheck();
        updateQuestion();
    }

    public void updateQuestion(){



        if(round < 10){

            Random random = new Random();
//            System.out.println(cultureList.size());
//            System.out.println(cultureList.size());
//            System.out.println(cultureList.size());
//            System.out.println(cultureList.size());
//            System.out.println(cultureList.size());
//            System.out.println(cultureList.size());
//            System.out.println(cultureList.size());
//            System.out.println(cultureList.size());
            int value;
            if(cultureList.size() == 1){
                value= 0;
            }else{
                value =  random.nextInt(cultureList.size()-1);
            }
            RadioButton rep1 = findViewById(R.id.rep1);
            RadioButton rep2 = findViewById(R.id.rep2);
            RadioButton rep3 = findViewById(R.id.rep3);

            TextView question = findViewById(R.id.question);
            question.setText(cultureList.get(value).getQuestion());

            switch (new Random().nextInt(2)){
                case 0:
                    rep1.setText(cultureList.get(value).getBonneReponse());
                    rep2.setText(cultureList.get(value).getMauvaiseReponse1());
                    rep3.setText(cultureList.get(value).getMauvaiseReponse2());
                    bonneRep = 0;
                    break;
                case 1:
                    rep2.setText(cultureList.get(value).getBonneReponse());
                    rep3.setText(cultureList.get(value).getMauvaiseReponse1());
                    rep1.setText(cultureList.get(value).getMauvaiseReponse2());
                    bonneRep = 1;
                    break;
                case 2:
                    rep3.setText(cultureList.get(value).getBonneReponse());
                    rep1.setText(cultureList.get(value).getMauvaiseReponse1());
                    rep2.setText(cultureList.get(value).getMauvaiseReponse2());
                    bonneRep = 2;
                    break;

                default:
                    System.out.println("erreur");

            }
            cultureList.remove(value);
            round++;
        } else {
            Intent resultatIntent = new Intent(this, ResultatActivity.class);
            resultatIntent.putExtra("note", nbBonneReponses);
            startActivity(resultatIntent);
        }






    }
}