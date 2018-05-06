package com.s2ee.etic.apps2ee;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionMenu;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class EnstrepriseActivity extends AppCompatActivity {

    public Boolean change = false;

    private EntrepriseListAdapter adapter;
    private RecyclerView cardView;
    private List<Entreprise> entrepriseList;

    FloatingActionMenu materialDesignFAM;
    com.github.clans.fab.FloatingActionButton floatingActionButton1, floatingActionButton2, floatingActionButton3;
    
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entreprise);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Entreprise");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Listes des entreprises");

        cardView = (RecyclerView) findViewById(R.id.my_recycler_view);
        entrepriseList = new ArrayList<Entreprise>();
        adapter = new EntrepriseListAdapter(entrepriseList,getApplicationContext());
        cardView.setAdapter(adapter);
        cardView.setLayoutManager(new LinearLayoutManager(this));
        cardView.setItemAnimator(new DefaultItemAnimator());

        //code of firebase here
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                Entreprise entreprise=new Entreprise();
                entreprise.setEntreprisenom(dataSnapshot.child("nom").getValue().toString());
                entreprise.setMail(dataSnapshot.child("mail").getValue().toString());
                entreprise.setTel(dataSnapshot.child("tel").getValue().toString());
                entreprise.setNbposte(dataSnapshot.child("nbPoste").getValue().toString());
                entreprise.setNbstage(dataSnapshot.child("nbStg").getValue().toString());
                entreprise.setProfilrechercher(dataSnapshot.child("prflRech").getValue().toString());
                entreprise.setProfilvise(dataSnapshot.child("prflVise").getValue().toString());
                entreprise.setStagepropose(dataSnapshot.child("stgPrps").getValue().toString());
                entreprise.setAdresse(dataSnapshot.child("adr").getValue().toString());
                entreprise.setWebsite(dataSnapshot.child("web").getValue().toString());
                entreprise.setPostPrps(dataSnapshot.child("postPrps").getValue().toString());
                entreprise.setEntreprisepic(dataSnapshot.child("logo").getValue().toString());
                entrepriseList.add(entreprise);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {


            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        materialDesignFAM = (FloatingActionMenu) findViewById(R.id.material_design_android_floating_action_menu);
        floatingActionButton1 = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item1);
        floatingActionButton2 = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item2);
        floatingActionButton3 = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item3);

        floatingActionButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Search Stage
                for(int i = 0;i < entrepriseList.size();i++)
                {
                    for (int j = i ; j < entrepriseList.size();j++)
                    {
                        int nbstagei,nbstagej;
                        nbstagei = Integer.parseInt(entrepriseList.get(i).getNbstage());
                        nbstagej = Integer.parseInt(entrepriseList.get(j).getNbstage());
                        if (nbstagei < nbstagej)
                        {
                            Entreprise entreprise = entrepriseList.get(i);
                            entrepriseList.set(i,entrepriseList.get(j));
                            entrepriseList.set(j,entreprise);

                        }

                    }

                }
                adapter.notifyDataSetChanged();
            }
        });
        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Search Poste
                for(int i = 0;i < entrepriseList.size();i++)
                {
                    for (int j = i ; j < entrepriseList.size();j++)
                    {
                        int nbpostei,nbpostej;
                        nbpostei = Integer.parseInt(entrepriseList.get(i).getNbposte());
                        nbpostej = Integer.parseInt(entrepriseList.get(j).getNbposte());
                        if (nbpostei < nbpostej)
                        {
                            Entreprise entreprise = entrepriseList.get(i);
                            entrepriseList.set(i,entrepriseList.get(j));
                            entrepriseList.set(j,entreprise);

                        }

                    }

                }
                adapter.notifyDataSetChanged();
            }
        });
        floatingActionButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Ordre Alphabétique
                for(int i = 0;i < entrepriseList.size();i++)
                {
                    for (int j = i ; j < entrepriseList.size();j++)
                    {
                        String nomi,nomj;
                        nomi = entrepriseList.get(i).getEntreprisenom().toLowerCase();
                        nomj = entrepriseList.get(j).getEntreprisenom().toLowerCase();
                        if (nomi.compareTo(nomj) > 0)
                        {
                            Entreprise entreprise = entrepriseList.get(i);
                            entrepriseList.set(i,entrepriseList.get(j));
                            entrepriseList.set(j,entreprise);

                        }

                    }

                }
                adapter.notifyDataSetChanged();
            }
        });
    }
}
