package com.s2ee.etic.apps2ee;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.like.LikeButton;
import com.like.OnLikeListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ShowActivity extends AppCompatActivity {

    private Entreprise Ecurrent;
    private TextView nom;
    private TextView mail;
    private TextView tel;
    private TextView web;
    private TextView adr;
    private TextView nbposte;
    private TextView nbstage;
    private TextView stagepropose;
    private TextView profilvise;
    private TextView profilrech;
    private TextView postprps;
    private de.hdodenhof.circleimageview.CircleImageView Pic;

    private LikeButton btnLike;
    private ArrayList<Entreprise> interested = new ArrayList<>();

    String ID;
    User user;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        Ecurrent = (Entreprise) getIntent().getSerializableExtra("entreprise");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(Ecurrent.getEntreprisenom());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        nom = (TextView) findViewById(R.id.name);
        nom.setText(Ecurrent.getEntreprisenom());

        mail = (TextView) findViewById(R.id.mail);
        mail.setText(Ecurrent.getMail());

        tel = (TextView) findViewById(R.id.tel);
        SpannableString content1 = new SpannableString("+213"+Ecurrent.getTel());
        content1.setSpan(new UnderlineSpan(), 0, ("+213"+Ecurrent.getTel()).length(), 0);
        tel.setText(content1);
        tel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });

        web = (TextView) findViewById(R.id.site);
        SpannableString content = new SpannableString(Ecurrent.getWebsite());
        content.setSpan(new UnderlineSpan(), 0, Ecurrent.getWebsite().length(), 0);
        web.setText(content);
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = Ecurrent.getWebsite();
                if (!url.startsWith("http://") && !url.startsWith("https://"))
                    url = "http://" + url;
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse(url));
                startActivity(viewIntent);
            }
        });

        adr = (TextView) findViewById(R.id.adresse);
        adr.setText(Ecurrent.getAdresse());

        nbposte  = (TextView) findViewById(R.id.nb_poste);
        nbposte.setText(Ecurrent.getNbposte()+ " postes");

        nbstage  = (TextView) findViewById(R.id.nb_stage);
        nbstage.setText(Ecurrent.getNbstage()+ " postes");

        profilrech = (TextView) findViewById(R.id.profile_recherche);
        profilrech.setText(Ecurrent.getProfilrechercher());

        stagepropose = (TextView) findViewById(R.id.stage_propose);
        stagepropose.setText(Ecurrent.getStagepropose());

        profilvise = (TextView) findViewById(R.id.profile_vise);
        profilvise.setText(Ecurrent.getProfilvise());

        postprps = (TextView) findViewById(R.id.poste_propose);
        postprps.setText(Ecurrent.getPostPrps());

        Pic = (de.hdodenhof.circleimageview.CircleImageView) findViewById(R.id.photo) ;
        if (!Ecurrent.getEntreprisepic().equals("/")){
            Picasso.with(getApplicationContext()).load(Ecurrent.getEntreprisepic()).into(Pic);
        }else{
            Pic.setImageResource(R.drawable.blank);
        }

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if(account != null) {
            ID = account.getId();
        }

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(ID);
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String userId = dataSnapshot.child("userId").getValue(String.class);
                String userEmail = dataSnapshot.child("userEmail").getValue(String.class);
                String username = dataSnapshot.child("username").getValue(String.class);
                user = new User(userId, userEmail, username);

                Iterator<DataSnapshot> i = dataSnapshot.child("interested").getChildren().iterator();
                while (i.hasNext()){
                    Entreprise e = i.next().getValue(Entreprise.class);
                    interested.add(e);
                    if(e.getEntreprisenom().equals(Ecurrent.getEntreprisenom())){
                        btnLike.setLiked(true);
                    }else {

                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

       btnLike = findViewById(R.id.star_button);
       btnLike.setOnLikeListener(new OnLikeListener() {
           @Override
           public void liked(LikeButton likeButton) {
               mDatabase.child("interested").child(Ecurrent.getEntreprisenom().replace('.','_')).setValue(Ecurrent);
           }

           @Override
           public void unLiked(LikeButton likeButton) {
               mDatabase.child("interested").child(Ecurrent.getEntreprisenom().replace('.','_')).removeValue();
           }
       });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }

}
