package sn.esmt.cv_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import sn.esmt.cv_ui.httpconfig.Api;
import sn.esmt.cv_ui.httpconfig.CVResponse;
import sn.esmt.cv_ui.tools.MyAdapterCV;

import java.io.Serializable;
import java.util.ArrayList;

import retrofit2.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VisualisationCV extends AppCompatActivity {
    private ListView list;
    private ArrayList<CVResponse> cv = new ArrayList<CVResponse>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualisation_cv);
        list = (ListView) findViewById(R.id.listCV);
        chargerListe();

        //Evennement lorsqu'on clique sur un element de la liste view
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("OKay", "On est au debut");
                Intent intent = new Intent(VisualisationCV.this, CV_Activity.class);
                Log.d("OKay", "On est au milieu");
                //intent.putExtra("cv_to_display", (Serializable) list.getSelectedItem());

                intent.putExtra("cv_to_display", cv.get(i));

                //intent.putExtra("nom",cv.get(i).getNom());


                Log.d("OKay", "On a la fin");
                startActivity(intent);
            }
        });


    }
    public void chargerListe(){

        //Création de l'objet Retrofit pour accéder à l'API
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.16:8081") //URL de base de l'API
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Crée une instance de l'interface Api,
        //qui définit les méthodes pour les appels HTTP.
        Api api = retrofit.create(Api.class);

        //creation d'un objet Call pour l'appel à la méthode login() de l'interface Api.
        Call<ArrayList<CVResponse>> call = api.all();

        call.enqueue(new Callback<ArrayList<CVResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<CVResponse>> call, Response<ArrayList<CVResponse>> response) {
                if (response.isSuccessful()) {
                    Log.d("Response :", response.body().get(0).getNom());
                    response.body().stream().forEach(usersResponse -> cv.add(usersResponse));
                    MyAdapterCV adpt = new MyAdapterCV(VisualisationCV.this,cv);
                    Log.d("Debbugage : " , cv.get(0).getNom());
                    list.setAdapter(adpt);
                } else {
                    Log.d("error message exception", response.toString());

                }
            }

            @Override
            public void onFailure(Call<ArrayList<CVResponse>> call, Throwable t) {
                Log.d("Error : ", t.getMessage());
                //D/Error :: CLEARTEXT communication to 192.168.90.167 not permitted by network security policy
            }

        });


    }

}