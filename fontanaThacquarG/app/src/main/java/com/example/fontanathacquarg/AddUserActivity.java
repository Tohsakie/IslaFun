package com.example.fontanathacquarg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fontanathacquarg.data.DatabaseClient;
import com.example.fontanathacquarg.data.User;
import com.example.fontanathacquarg.data.UserAdapter;

public class AddUserActivity extends AppCompatActivity {
    private UserAdapter adapter;
    private DatabaseClient mdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        mdb = DatabaseClient.getInstance(getApplicationContext());

        Button button = findViewById(R.id.valider);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUser();
                finish();
            }
        });
    }
    private void saveUser() {

        // Récupérer les informations contenues dans les vues
        final String nom = ((EditText) findViewById(R.id.nom)).getText().toString();
        final String prenom = ((EditText) findViewById(R.id.prenom)).getText().toString();

        // Vérifier les informations fournies par l'utilisateur
        if (nom.isEmpty()) {
            EditText editTextNom = findViewById(R.id.nom);
            editTextNom.setError("nom required");
            editTextNom.requestFocus();
            return;
        }

        if (prenom.isEmpty()) {
            EditText editTextPrenom = findViewById(R.id.prenom);
            editTextPrenom.setError("prenom required");
            editTextPrenom.requestFocus();
            return;
        }

        /**
         * Création d'une classe asynchrone pour sauvegarder la tache donnée par l'utilisateur
         */

        class SaveUser extends AsyncTask<Void, Void, User> {

            @Override
            protected User doInBackground(Void... voids) {

                User user = new User(nom, prenom);


                    mdb.getAppDatabase()
                        .userDao()
                        .insert(user);

                return user;
            }

            @Override
            protected void onPostExecute(User user) {
                super.onPostExecute(user);

                setResult(RESULT_OK);
                finish();
                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
            }
        }


        SaveUser st = new SaveUser();
        st.execute();
    }}