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
        TextView textview = listItem.findViewById(R.id.list_item_question);
        textview.setText(currentRow.getQuestion()); //ICI
        EditText editText = listItem.findViewById(R.id.list_item_reponse);

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
