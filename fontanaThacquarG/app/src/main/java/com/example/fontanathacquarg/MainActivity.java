package com.example.fontanathacquarg;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.fontanathacquarg.data.Culture;
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
        ArrayList<String> question = new ArrayList<>();

        question.add("Quel champignon n’existe pas ?");
        question.add("L’art de cultiver les bonsaïs (ou arbres nains) est originaire : ");
        question.add("Comment appelle-t-on une grande pierre dressée ?");
        question.add("Qu’est-ce qui doit arriver sur le stigmate pour que la fleur se reproduise ?");
        question.add("D’un iceberg flottant dans  les régions polaires, on ne voit en fait :");

        question.add("Combien de kilos de raisin faut-il pour faire 50 litres de vin ?" );
        question.add("Le baobab est un des plus grands arbres du monde. Cet arbre est aussi appelé :");
        question.add("Lorsqu’un volcan se déchaine, on parle :");
        question.add("Qu’est-ce qu’une météorite ?");
        question.add("Les bananes poussent : ");

        ArrayList<String> bonneReponse = new ArrayList<>();

        bonneReponse.add("Le bolet de céléri");
        bonneReponse.add("du Japon");
        bonneReponse.add("Un menhir");
        bonneReponse.add("Le pollen");
        bonneReponse.add("qu’un cinquième");

        bonneReponse.add("100 kg");
        bonneReponse.add("arbre à pain de singe");
        bonneReponse.add("d’éruption");
        bonneReponse.add("Une pierre dans l’espace");
        bonneReponse.add("courbées vers le haut");

        ArrayList<String> mauvaiseReponse1 = new ArrayList<>();

        bonneReponse.add("La trompette-de-la-mort");
        bonneReponse.add("d’Afrique");
        bonneReponse.add("Un grohir");
        bonneReponse.add("L’amidon");
        bonneReponse.add("qu’un tiers");

        bonneReponse.add("50 kg");
        bonneReponse.add("arbre-mammouth");
        bonneReponse.add("d’érosion");
        bonneReponse.add("Une boule de gaz");
        bonneReponse.add("courbées vers le bas");


        ArrayList<String> mauvaiseReponse2 = new ArrayList<>();

        bonneReponse.add("La barbe-de-bouc");
        bonneReponse.add("d’Indonésie");
        bonneReponse.add("Un lourhir");
        bonneReponse.add("La farine");
        bonneReponse.add("que la moitié");

        bonneReponse.add("250 kg");
        bonneReponse.add("arbre géant");
        bonneReponse.add("d’équation");
        bonneReponse.add("Une accumulation de matière");
        bonneReponse.add("droites, elles se courbent après la récolte");

        Culture culture = new Culture();

        for(int i =0; i <= 10; i++){
            culture.setQuestion(question.get(i));
            culture.setBonneReponse(bonneReponse.get(i));
            culture.setMauvaiseReponse1(mauvaiseReponse1.get(i));
            culture.setMauvaiseReponse2(mauvaiseReponse2.get(i));
            mdb.getAppDatabase().cultureDAO().insert(culture);
        }
        mdb.getAppDatabase().cultureDAO().insert(culture);
    }
}