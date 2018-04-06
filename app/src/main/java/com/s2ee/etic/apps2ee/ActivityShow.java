package com.s2ee.etic.apps2ee;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ActivityShow extends AppCompatActivity {

    private Entreprise Ecurrent;
    private TextView Nom,Adresse;
    private de.hdodenhof.circleimageview.CircleImageView Pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        Ecurrent = (Entreprise) getIntent().getSerializableExtra("entreprise");
        Pic = (de.hdodenhof.circleimageview.CircleImageView) findViewById(R.id.photo) ;
        Nom = (TextView) findViewById(R.id.name);Nom.setText(Nom.getText()+ " : "+Ecurrent.getEntreprisenom());
        Adresse = (TextView) findViewById(R.id.adresse);Adresse.setText(Adresse.getText()+" : "+Ecurrent.getEntreprisedescrition());
        Picasso.with(getApplicationContext()).load(Ecurrent.getEntreprisepic()).into(Pic);
    }
}
