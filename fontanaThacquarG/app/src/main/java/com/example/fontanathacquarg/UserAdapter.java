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

        // Récupération de la multiplication
        final User user = getItem(position);

        // Charge le template XML
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.user_row, parent, false);
        mdb = DatabaseClient.getInstance(rowView.getContext());


        // Récupération des objets graphiques dans le template
        TextView nomPrenom = rowView.findViewById(R.id.nomPrenom);

        String nomStr = getUserById(id);
        String prenomStr = mdb.getAppDatabase().userDao().findUserById(id++).getPrenom();
        nomPrenom.setText(nomStr + " " + prenomStr);
        nomPrenom.setText("hahaha");

//
//        //
//        textViewTask.setText(user.getNom());
//        textViewDesc.setText(task.getDescription());

        //
        return rowView;
    }

    private void getUserById(int id) {
        ///////////////////////
        // Classe asynchrone permettant de récupérer des taches et de mettre à jour le listView de l'activité
        class GetUser extends AsyncTask<Void, Void, List<User>> {

            @Override
             List<User> doInBackground(Void... voids) {
                List<User> userList = (List<User>) mdb.getAppDatabase()
                        .userDao().findUserById(UserAdapter.id);
                return userList;
            }//cast to list pour rien detruire, recuperer .get(0)

            @Override
            protected void onPostExecute(List<User> users) {
                super.onPostExecute(users);

                // Mettre à jour l'adapter avec la liste de taches
                adapter.clear();
                adapter.addAll(users);

                // Now, notify the adapter of the change in source
                adapter.notifyDataSetChanged();
            }
        }

        //////////////////////////
        // IMPORTANT bien penser à executer la demande asynchrone
        // Création d'un objet de type GetTasks et execution de la demande asynchrone
        GetUser gt = new GetUser();
        gt.execute();
        return
    }


}