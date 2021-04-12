package com.example.fontanathacquarg;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.fontanathacquarg.data.DatabaseClient;
import com.example.fontanathacquarg.data.User;
import com.example.fontanathacquarg.data.UserAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private UserAdapter adapter;
    private DatabaseClient mdb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.mainListView);
        adapter = new UserAdapter(this, new ArrayList<User>());
        listView.setAdapter(adapter);
        mdb = DatabaseClient.getInstance(getApplicationContext());

    }

    public void onAno(View view){
        Intent ExoViewActivityIntent = new Intent(MainActivity.this, ActivityChoice.class);
        startActivity(ExoViewActivityIntent);
    }

    public void onPlus(View view){
        Intent ExoViewActivityIntent = new Intent(MainActivity.this, AddUserActivity.class);
        startActivity(ExoViewActivityIntent);
    }

    private void getUsers() {
        ///////////////////////
        // Classe asynchrone permettant de récupérer des taches et de mettre à jour le listView de l'activité
        class GetUser extends AsyncTask<Void, Void, List<User>> {

            @Override
            protected List<User> doInBackground(Void... voids) {
                List<User> userList = mdb.getAppDatabase()
                        .userDao()
                        .getAll();
                return userList;
            }

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
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 0 && resultCode == RESULT_OK) {

            // Mise à jour des taches
            getUsers();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Mise à jour des taches
        getUsers();

    }
}