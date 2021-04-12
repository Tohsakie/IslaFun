package com.example.fontanathacquarg;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.List;

import static android.app.Activity.RESULT_OK;

public class UserAdapter extends ArrayAdapter<User> {
    private DatabaseClient mdb;
    private UserAdapter adapter;

    static int id = 0;

    public UserAdapter(Context mCtx, List<User> userList) {
        super(mCtx, R.layout.activity_add_user, userList);
    }

    /**
     * Remplit une ligne de la listView avec les informations de la multiplication associée
     *
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final User user = getItem(position);

        // Charge le template XML
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.user_row, parent, false);
        mdb = DatabaseClient.getInstance(rowView.getContext());


        // Récupération des objets graphiques dans le template
        TextView nomPrenom = rowView.findViewById(R.id.nomPrenom);

        nomPrenom.setText(user.getNom() + " " + user.getPrenom());

//
//        //
//        textViewTask.setText(user.getNom());
//        textViewDesc.setText(task.getDescription());

        //
        return rowView;
    }

}