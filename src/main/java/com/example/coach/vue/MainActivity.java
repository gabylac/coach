package com.example.coach.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coach.R;
import com.example.coach.controleur.Controle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private EditText txtPoids;
    private EditText txtTaille;
    private EditText txtAge;
    private RadioButton rdHomme;
    private TextView lblIMG;
    private ImageView imageSmiley;
    private Button btnCalc;
    private Controle controle;

    /**
     * démarrage appli avec récupération des objets graphiques
     * création du controleur
     *
     */
    private void init(){
        txtPoids = (EditText) findViewById(R.id.txtPoids);
        txtTaille = (EditText) findViewById((R.id.txtTaille));
        txtAge = (EditText) findViewById(R.id.txtAge);
        rdHomme = (RadioButton) findViewById(R.id.rdHomme);
        lblIMG = (TextView) findViewById(R.id.lblIMG);
        imageSmiley = (ImageView) findViewById(R.id.imageSmiley);
        btnCalc = (Button) findViewById(R.id.btnCalc);
        controle = Controle.getInstance();
        ecouteCalcul();
    }

    public void ecouteCalcul(){
        btnCalc.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Integer poids =0;
                Integer taille =0;
                Integer age =0;
                try{
                    poids = Integer.parseInt(txtPoids.getText().toString());
                    taille = Integer.parseInt(txtTaille.getText().toString());
                    age = Integer.parseInt(txtAge.getText().toString());
                }catch (Exception e){}
                Integer sexe = 0;
                if (rdHomme.isChecked()){
                    sexe = 1;
                }
                if (poids == 0 || taille == 0 || age == 0){
                    Toast.makeText(MainActivity.this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                }else {
                    affichResult(poids, taille, age, sexe);
                }
            }

        });
    }

    public void affichResult(Integer poids, Integer taille, Integer age, Integer sexe){
        controle.creerProfil(poids, taille, age, sexe);
        String message;
        message = controle.getMessage();
        float img;
        img = controle.getImg();
        if (message == "trop élevé"){
            imageSmiley.setImageResource(R.drawable.graisse);
            lblIMG.setTextColor(Color.RED);
        }else {
            if (message== "trop faible") {
                imageSmiley.setImageResource(R.drawable.maigre);
                lblIMG.setTextColor(Color.RED);
            }else{
                imageSmiley.setImageResource(R.drawable.normal);
                lblIMG.setTextColor(Color.GREEN);
            }
        }
        lblIMG.setText(String.format("%.01f", img) + " : IMG "+ message);

    }
}