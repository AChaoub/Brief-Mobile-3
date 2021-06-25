package com.example.breakingbad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.breakingbad.model.ActeurGOT;
import com.example.breakingbad.model.ContinentsGOT;
import com.example.breakingbad.service.GOTActeurServiceRepo;
import com.example.breakingbad.service.GOTContinentServiceRepo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    List<String> data =new ArrayList<String>();

    String data1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.editTextID);
        Button btnRech = findViewById(R.id.BtnRech);
        Button btnAll = findViewById(R.id.BtnAll);
        ListView liste_Acteurs = findViewById(R.id.liste_Acteurs);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,data);

        liste_Acteurs.setAdapter(arrayAdapter);




        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://thronesapi.com/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();




        // ACTEUR GAME OF THRONES
        btnAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = editText.getText().toString();
                GOTActeurServiceRepo gotActeurServiceRepo = retrofit.create(GOTActeurServiceRepo.class);
                Call<List<ActeurGOT>> callActeurGot =  gotActeurServiceRepo.getAllActors();

                callActeurGot.enqueue(new Callback<List<ActeurGOT>>() {
                    @Override
                    public void onResponse(Call<List<ActeurGOT>> call, Response<List<ActeurGOT>> response) {
                        Log.i("infoCALL",call.request().url().toString());
                        Log.i("boolean", String.valueOf(response.isSuccessful()));
                        Log.i("info",String.valueOf(response.code()));
                        if(!response.isSuccessful()){
                            Log.i("info",String.valueOf(response.code()));
                            return;
                        }
                        List<ActeurGOT> acteursGOT = response.body();
                        //data.add(acteurBrB.getName());
                        for(ActeurGOT ac:acteursGOT){
                            data.add(ac.fullName);
                            arrayAdapter.notifyDataSetChanged();
                        }


                        //changement en meme temps + affichage.
                        arrayAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<List<ActeurGOT>> call, Throwable t) {
                        Log.i("infoCALL", call.request().url().toString());
                        Log.e("error", "Error");
                    }


                });

            }
        });


        btnRech.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                liste_Acteurs.setAdapter(null);
                liste_Acteurs.setAdapter(arrayAdapter);

                String query = editText.getText().toString();
                GOTActeurServiceRepo gotActeurServiceRepo = retrofit.create(GOTActeurServiceRepo.class);
                Call<ActeurGOT> callActeurGot =  gotActeurServiceRepo.getGOT(query);

                callActeurGot.enqueue(new Callback<ActeurGOT>() {
                    @Override
                    public void onResponse(Call<ActeurGOT> call, Response<ActeurGOT> response) {
                        Log.i("infoCALL",call.request().url().toString());
                        Log.i("boolean", String.valueOf(response.isSuccessful()));
                        Log.i("info",String.valueOf(response.code()));
                        if(!response.isSuccessful()){
                            Log.i("info",String.valueOf(response.code()));
                            return;
                        }
                        ActeurGOT acteurGOT = response.body();
                        //data.add(acteurBrB.getName());
                        data.add(acteurGOT.fullName);


                        //changement en meme temps + affichage.
                        arrayAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<ActeurGOT> call, Throwable t) {
                        Log.i("infoCALL", call.request().url().toString());
                        Log.e("error", "Error");
                    }
                });
            }
        });



        // CONTINENTS GAME OF THRONES
        /*Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://thronesapi.com/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        btnRech.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String query = editText.getText().toString();
                Log.i("QUERY SIASIE:",query);

                GOTContinentServiceRepo gotContinentServiceRepo = retrofit.create(GOTContinentServiceRepo.class);

                Call<ContinentsGOT> callGOT =  gotContinentServiceRepo.getGOT(query);

                callGOT.enqueue(new Callback<ContinentsGOT>() {
                    @Override
                    public void onResponse(Call<ContinentsGOT> call, Response<ContinentsGOT> response) {
                        Log.i("infoCALL",call.request().url().toString());
                        Log.i("boolean", String.valueOf(response.isSuccessful()));
                        Log.i("info",String.valueOf(response.code()));
                        if(!response.isSuccessful()){
                            Log.i("info",String.valueOf(response.code()));
                            return;
                        }
                        ContinentsGOT continentsGot = response.body();
                        //data.add(acteurBrB.getName());
                        data.add(continentsGot.name);


                        //changement en meme temps + affichage.
                        arrayAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<ContinentsGOT> call, Throwable t) {
                        Log.i("infoCALL", call.request().url().toString());
                        Log.e("error", "Error");
                    }
                });

            }
        });*/






        // ACTEUR BREAKING BAD
       /* Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://breakingbadapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        btnRech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = editText.getText().toString();
                Log.i("QUERY SIASIE:",query);

                ActeurRepoService acteurRepoService = retrofit.create(ActeurRepoService.class);

                Call<ActeurBrB> callActeur =  acteurRepoService.getActeur(query.toString());

                callActeur.enqueue(new Callback<ActeurBrB>() {
                    @Override
                    public void onResponse(Call<ActeurBrB> call, Response<ActeurBrB> response) {

                        Log.i("infoCALL",call.request().url().toString());
                        Log.i("boolean", String.valueOf(response.isSuccessful()));
                        Log.i("info",String.valueOf(response.code()));
                        if(!response.isSuccessful()){
                            Log.i("info",String.valueOf(response.code()));
                            return;
                        }
                        ActeurBrB acteurBrB = response.body();
                        //data.add(acteurBrB.getName());
                        data.add(acteurBrB.getName());


                        //changement en meme temps + affichage.
                        arrayAdapter.notifyDataSetChanged();
                    }

                   @Override
                    public void onFailure(Call<ActeurBrB> call, Throwable t) {

                       // Log.i("infoCALL",call.request().url().toString());
                        //Log.e("error","Error");
                    }
                });

            }
        });*/
    }
}