package com.example.fontanathacquarg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {

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

        // Récupération de la multiplication
        final User user = getItem(position);

        // Charge le template XML
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.activity_add_user, parent, false);

        // Récupération des objets graphiques dans le template
        EditText nom = rowView.findViewById(R.id.nom);
        EditText prenom = rowView.findViewById(R.id.prenom);
//
//        //
//        textViewTask.setText(user.getNom());
//        textViewDesc.setText(task.getDescription());

        //
        return rowView;
    }

}