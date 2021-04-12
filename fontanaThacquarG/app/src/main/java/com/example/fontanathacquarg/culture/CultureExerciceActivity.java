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



//        class getCultures extends AsyncTask<Void, Void, List<Culture>>{
//
//            private CultureDAO mAsyncTaskDao;
//            List<Culture> a;
//
//            getCultures(CultureDAO dao) {
//                mAsyncTaskDao = dao;
//            }
//
//            @Override
//            protected List<Culture> doInBackground(Void... voids) {
//                return mAsyncTaskDao.getAll();
//            }
//
//        }
//        getCultures gt = new getCultures(mcultureDao);
//        gt.execute();


        cultureList = mdb.getAppDatabase()
                .cultureDAO()
                .getAll();

        updateQuestion();
    }

    public void valider(View view){

        RadioGroup radioGroup = findViewById(R.id.radio_groupe);
        radioGroup.clearCheck();
        switch (bonneRep){
            case 0:
                if (radioGroup.getCheckedRadioButtonId() == R.id.rep1){
                    bonneRep++;
                }
            case 1:
                if (radioGroup.getCheckedRadioButtonId() == R.id.rep2){
                    bonneRep++;
                }
            case 2:
                if (radioGroup.getCheckedRadioButtonId() == R.id.rep3){
                    bonneRep++;
                }
        }
        updateQuestion();
    }

    public void updateQuestion(){


        if(cultureList.size() >= round){
            RadioButton rep1 = findViewById(R.id.rep1);
            RadioButton rep2 = findViewById(R.id.rep2);
            RadioButton rep3 = findViewById(R.id.rep3);

            TextView question = findViewById(R.id.question);

            question.setText(cultureList.get(round).getQuestion());

            System.out.println("\n\n\n\n---------"+ cultureList.get(round).getQuestion() + "\n\n\n\n---------");

            int value = (int) (Math.random()*(2));

            switch (value){
                case 0:
                    rep1.setText(cultureList.get(round).getBonneReponse());
                    rep2.setText(cultureList.get(round).getMauvaiseReponse1());
                    rep2.setText(cultureList.get(round).getMauvaiseReponse2());
                    bonneRep = 0;
                    break;
                case 1:
                    rep2.setText(cultureList.get(round).getBonneReponse());
                    rep3.setText(cultureList.get(round).getMauvaiseReponse1());
                    rep1.setText(cultureList.get(round).getMauvaiseReponse2());
                    bonneRep = 1;
                    break;
                case 2:
                    rep3.setText(cultureList.get(round).getBonneReponse());
                    rep1.setText(cultureList.get(round).getMauvaiseReponse1());
                    rep2.setText(cultureList.get(round).getMauvaiseReponse2());
                    bonneRep = 2;
                    break;

            }

            round++;
        } else {
            Intent resultatIntent = new Intent(this, ResultatActivity.class);
            resultatIntent.putExtra("note", nbBonneReponses);
            startActivity(resultatIntent);
        }






    }
}