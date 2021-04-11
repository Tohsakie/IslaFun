package com.example.fontanathacquarg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class AddUserActivity extends AppCompatActivity {
    private UserAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        DatabaseClient mdb = DatabaseClient.getInstance(getApplicationContext());

        Button button = findViewById(R.id.valider);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = ((EditText) findViewById(R.id.nom)).getText().toString();
                String prenom = ((EditText) findViewById(R.id.prenom)).getText().toString();
                mdb.getAppDatabase().userDao().insert(new User(nom, prenom));
                System.out.println("############################");
                System.out.println(getUsers());
                System.out.println("############################");
            }
        });


        private void getUsers(){
            ///////////////////////
            // Classe asynchrone permettant de récupérer des taches et de mettre à jour le listView de l'activité
            class GetUsers extends AsyncTask<Void, Void, List<User>> {

                @Override
                protected List<User> doInBackground(Void... voids) {
                    List<User> userList = mdb.getAppDatabase()
                            .userDao()
                            .getAll();
                    return userList;
                }

                @Override
                protected void onPostExecute(List<User> tasks) {
                    super.onPostExecute(tasks);

                    // Mettre à jour l'adapter avec la liste de taches
                    adapter.clear();
                    adapter.addAll(tasks);

                    // Now, notify the adapter of the change in source
                    adapter.notifyDataSetChanged();
                }
            }

            //////////////////////////
            // IMPORTANT bien penser à executer la demande asynchrone
            // Création d'un objet de type GetTasks et execution de la demande asynchrone
            GetUsers gu = new GetUsers();
            gu.execute();
        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == REQUEST_CODE_ADD && resultCode == RESULT_OK) {

                // Mise à jour des taches
                getTasks();
            }
        }


    }

}