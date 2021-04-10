package com.example.fontanathacquarg;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class RowAdapter extends ArrayAdapter<Row> {

    private int m_ressource;
    private Context m_context;
    private ArrayList<Row> m_rows;
    private int nbOperationDone = 0;
    private int nbBonneReponses = 0;
    String m_operator;

    public RowAdapter(Context context, int ressource, @SuppressLint("SupportAnnotationUsage") @LayoutRes ArrayList<Row> rows, String operator){//Lint pour enlever warning
        super(context, ressource, rows);
        m_context = context;
        m_rows = rows;
        m_operator = operator;
    }
    public int getNbBonneReponses(){
        return nbBonneReponses;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(m_context).inflate(R.layout.activity_exercice_multiply_row,parent, false);

        Row currentRow = m_rows.get(position);

        TextView question = listItem.findViewById(R.id.list_item_question);
        question.setText(currentRow.getQuestion());

        EditText reponse = listItem.findViewById(R.id.list_item_reponse);

        TextView resultat = listItem.findViewById(R.id.list_item_resultat);


        reponse.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if(hasFocus || !hasFocus && reponse.getText().length() == 0){
                    resultat.setText("");
                }

                else if(!hasFocus){
                    String questionStr;
                    int numQuestion1;
                    int numQuestion2;
                    int numReponse;
                    int numReponseCorrect;
                    questionStr = question.getText().toString().replaceAll(" ", "");

                    if(m_operator.equals("*")){
                        numQuestion1 = Integer.parseInt(questionStr.split("\\*", 2)[0]);
                        numQuestion2 = Integer.parseInt(questionStr.split("\\*", 2)[1]);
                        numReponse = Integer.parseInt(reponse.getText().toString());
                        numReponseCorrect = numQuestion1 * numQuestion2;
                        if(String.valueOf(numReponseCorrect).length() == reponse.getText().length()){
                            System.out.println(String.valueOf(numReponseCorrect).length());
                            System.out.println(reponse.getText().length());
                            if(numReponse == numReponseCorrect){
                                resultat.setText("VRAI");
                            }
                            else{
                                resultat.setText("FAUX");
                            }

                            reponse.setEnabled(false);
                        }
                    }
                    else if(m_operator.equals("+")){
                        numQuestion1 = Integer.parseInt(questionStr.split("\\+", 2)[0].replace(" ", "").replace("=", ""));
                        numQuestion2 = Integer.parseInt(questionStr.split("\\+", 2)[1].replace(" ", "").replace("=", ""));
                        numReponse = Integer.parseInt(reponse.getText().toString());
                        numReponseCorrect = numQuestion1 + numQuestion2;
                        if(String.valueOf(numReponseCorrect).length() == reponse.getText().length()){
                            System.out.println(String.valueOf(numReponseCorrect).length());
                            System.out.println(reponse.getText().length());
                            if(numReponse == numReponseCorrect){
                                resultat.setText("VRAI");
                                nbBonneReponses++;
                            }
                            else{
                                resultat.setText("FAUX");
                            }

                            reponse.setEnabled(false);
                            nbOperationDone++;
                            if (nbOperationDone == 10){
                                Intent resultatIntent = new Intent(m_context, ResultatAdditionActivity.class);
                                resultatIntent.putExtra("note", nbBonneReponses);
                                m_context.startActivity(resultatIntent);
                            }
                        }
                    }


                }
            }
        });
        return listItem;
    }
}
