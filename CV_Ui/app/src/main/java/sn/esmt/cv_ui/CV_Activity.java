package sn.esmt.cv_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.Serializable;

import sn.esmt.cv_ui.httpconfig.CVResponse;

public class CV_Activity extends AppCompatActivity {

    private TextView nom;
    private TextView prenom;
    private TextView age;
    private TextView adresse;
    private TextView email;
    private TextView telephone;
    private TextView NivEtude;
    private TextView Specialite;
    private TextView ExpProfessionel;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_cv);
        Serializable s = getIntent().getSerializableExtra("cv_to_display");

        nom = (TextView) findViewById(R.id.textNom);
        prenom = (TextView) findViewById(R.id.textPrenom);
        age = (TextView) findViewById(R.id.textAge);
        adresse = (TextView) findViewById(R.id.textAdresse);
        email = (TextView) findViewById(R.id.textEmail);
        telephone = (TextView) findViewById(R.id.textTelephone);
        NivEtude = (TextView) findViewById(R.id.textNivEtude);
        Specialite = (TextView) findViewById(R.id.textSpe);
        ExpProfessionel = (TextView) findViewById(R.id.textExpPro);

        if(s != null) {
            CVResponse cv = (CVResponse) s;

            nom.setText(cv.getNom());
            prenom.setText(cv.getPrenom());
            age.setText( String.valueOf(cv.getAge()));
            adresse.setText(cv.getAddresse());
            email.setText(cv.getEmail());

            telephone.setText(cv.getTelephone());
            NivEtude.setText(cv.getNiveauEtude());
            Specialite.setText(cv.getSpecialite());
            ExpProfessionel.setText(cv.getExperienceProfessionnelle());



        }
        else
        {
            Log.d("Error", "We can't load data for CV");
        }

    }
}