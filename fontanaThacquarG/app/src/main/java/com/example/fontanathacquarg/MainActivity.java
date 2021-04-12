package com.example.fontanathacquarg;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

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

                adapter.clear();
                adapter.addAll(users);
                adapter.notifyDataSetChanged();
            }
        }

        GetUser gt = new GetUser();
        gt.execute();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 0 && resultCode == RESULT_OK) {
            getUsers();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        getUsers();
        ArrayList<String> question = new ArrayList<>();

        question.add("Quel champignon n’existe pas ?");
        question.add("L’art de cultiver les bonsaïs (ou arbres nains) est originaire : ");
        question.add("Comment appelle-t-on une grande pierre dressée ?");
        question.add("Qu’est-ce qui doit arriver sur le stigmate pour que la fleur se reproduise ?");
        question.add("D’un iceberg flottant dans  les régions polaires, on ne voit en fait :");

        question.add("Combien de kilos de raisin faut-il pour faire 50 litres de vin ?");
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

        mauvaiseReponse1.add("La trompette-de-la-mort");
        mauvaiseReponse1.add("d’Afrique");
        mauvaiseReponse1.add("Un grohir");
        mauvaiseReponse1.add("L’amidon");
        mauvaiseReponse1.add("qu’un tiers");

        mauvaiseReponse1.add("50 kg");
        mauvaiseReponse1.add("arbre-mammouth");
        mauvaiseReponse1.add("d’érosion");
        mauvaiseReponse1.add("Une boule de gaz");
        mauvaiseReponse1.add("courbées vers le bas");


        ArrayList<String> mauvaiseReponse2 = new ArrayList<>();

        mauvaiseReponse2.add("La barbe-de-bouc");
        mauvaiseReponse2.add("d’Indonésie");
        mauvaiseReponse2.add("Un lourhir");
        mauvaiseReponse2.add("La farine");
        mauvaiseReponse2.add("que la moitié");

        mauvaiseReponse2.add("250 kg");
        mauvaiseReponse2.add("arbre géant");
        mauvaiseReponse2.add("d’équation");
        mauvaiseReponse2.add("Une accumulation de matière");
        mauvaiseReponse2.add("droites, elles se courbent après la récolte");

        Culture culture = new Culture();


        for (int i = 0; i <= 9; i++) {
            System.out.println(question.get(i));
            System.out.println(bonneReponse.get(i));
            System.out.println(mauvaiseReponse1.get(i));
            System.out.println(mauvaiseReponse2.get(i));

            culture.setQuestion(question.get(i));
            culture.setBonneReponse(bonneReponse.get(i));
            culture.setMauvaiseReponse1(mauvaiseReponse1.get(i));
            culture.setMauvaiseReponse2(mauvaiseReponse2.get(i));
            mdb.getAppDatabase().cultureDAO().insert(culture);


        }
    }
}