package com.s2ee.etic.apps2ee;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ActivityShow extends AppCompatActivity {

    private Entreprise Ecurrent;
    private TextView Nom,Adresse,mail,tel,web,adr,nbposte,nbstage,stagepropose,profilvise,profilrech,postprps;
    private de.hdodenhof.circleimageview.CircleImageView Pic;
    private ImageView btnLike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        Ecurrent = (Entreprise) getIntent().getSerializableExtra("entreprise");
        Pic = (de.hdodenhof.circleimageview.CircleImageView) findViewById(R.id.photo) ;
        Nom = (TextView) findViewById(R.id.name);Nom.setText(Ecurrent.getEntreprisenom());
        mail = (TextView) findViewById(R.id.mail);mail.setText(Ecurrent.getMail());
        tel = (TextView) findViewById(R.id.tel);tel.setText(Ecurrent.getTel());
        web = (TextView) findViewById(R.id.site);web.setText(Ecurrent.getWebsite());
        adr = (TextView) findViewById(R.id.adresse);adr.setText(Ecurrent.getAdresse());
        nbposte  = (TextView) findViewById(R.id.nb_poste);nbposte.setText(Ecurrent.getNbposte());
        nbstage  = (TextView) findViewById(R.id.nb_stage);nbstage.setText(Ecurrent.getNbstage());
        profilrech = (TextView) findViewById(R.id.profile_recherche);profilrech.setText(Ecurrent.getProfilrechercher());
        stagepropose = (TextView) findViewById(R.id.stage_propose);stagepropose.setText(Ecurrent.getStagepropose());
        profilvise = (TextView) findViewById(R.id.profile_vise);profilvise.setText(Ecurrent.getProfilvise());
        postprps = (TextView) findViewById(R.id.poste_propose); postprps.setText(Ecurrent.getPostPrps());
       if (Ecurrent.getEntreprisepic() != "/"){ Picasso.with(getApplicationContext()).load(Ecurrent.getEntreprisepic()).into(Pic);}
       btnLike = findViewById(R.id.btn_dis);
       btnLike.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Integer integer = (Integer) btnLike.getTag();
               integer = integer == null ? 0 : integer;
                    btnLike.setImageResource(R.drawable.like);
           }
       });
    }
}
