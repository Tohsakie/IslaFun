package com.example.fontanathacquarg;
import android.annotation.SuppressLint;
import android.content.Context;
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
import java.util.ArrayList;

public class RowAdapter extends ArrayAdapter<Row> {

    private int m_ressource;
    private Context m_context;
    private ArrayList<Row> m_rows;
    static int idReponse= 1000;//pour eviter id deja utilisés
    static int idResultat= 2000;//pour eviter id deja utilisés
    public RowAdapter(Context context, int ressource, @SuppressLint("SupportAnnotationUsage") @LayoutRes ArrayList<Row> rows){//Lint pour enlever warning
        super(context, ressource, rows);
        m_context = context;
        m_rows = rows;
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
//        reponse.setId(idReponse++);

        TextView resultat = listItem.findViewById(R.id.list_item_resultat);
//        resultat.setId(idResultat++);


        reponse.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
//                int tempIdReponse = reponse.getId();
//                tempIdReponse += 1000;//voir la correspondance des id dans rowadapter

                //hasFocus pose probleme pour le moment, quand clique sur un Editext le else est fait d'abord, donc le setEnable(false) est fait avant l'input ;--;TODO fix this ubisoft FFS
                if(hasFocus){
                    resultat.setText("");
                }
                else{
                    resultat.setText("FAUX");
                    reponse.setEnabled(false);
                }
            }
        });
//        ImageView image = (ImageView)listItem.findViewById(R.id.imageView_poster);
//        image.setImageResource(currentMovie.getmImageDrawable());
//
//        TextView name = (TextView) listItem.findViewById(R.id.textView_name);
//        name.setText(currentMovie.getmName());
//
//        TextView release = (TextView) listItem.findViewById(R.id.textView_release);
//        release.setText(currentMovie.getmRelease());

        return listItem;
    }
}
