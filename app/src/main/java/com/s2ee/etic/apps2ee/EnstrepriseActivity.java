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

import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;
import java.util.List;

public class EnstrepriseActivity extends AppCompatActivity {

    public Boolean change = false;
    private EntrepriseListAdapter adapter;
    private RecyclerView cardView;
    private List<Entreprise> entrepriseList;
    FloatingActionMenu materialDesignFAM;
    com.github.clans.fab.FloatingActionButton floatingActionButton1, floatingActionButton2, floatingActionButton3;
    private Entreprise e1,e2,e3,e4,e5,e6;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entreprise);

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


       //just examples :)
        e1 = new Entreprise("https://beta.receiptmatch.com/admin/webresources/images/no_company_image.jpg","Mario","SUPERMARIO");
        entrepriseList.add(e1);
        e2 = new Entreprise("http://oi41.tinypic.com/wqq5px.jpg","Luigi","Luigi Land");
        entrepriseList.add(e2);
        e3 = new Entreprise("http://oi48.tinypic.com/334oizb.jpg","Wario","Wario Land");
        entrepriseList.add(e3);
        e4 = new Entreprise("http://oi64.tinypic.com/2n9yxjb.jpg","Ghost","Ghost Land");
        entrepriseList.add(e4);
        e5 = new Entreprise("http://oi57.tinypic.com/16awima.jpg","Cj","San Andreas");
        entrepriseList.add(e5);
        e6 = new Entreprise("http://oi39.tinypic.com/20zrwol.jpg","Most Wanted","Los Angelos");
        entrepriseList.add(e6);






        materialDesignFAM = (FloatingActionMenu) findViewById(R.id.material_design_android_floating_action_menu);
        floatingActionButton1 = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item1);
        floatingActionButton2 = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item2);
        floatingActionButton3 = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item3);

        floatingActionButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Search type 1

            }
        });
        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Search type 2

            }
        });
        floatingActionButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Search type 3

            }
        });
    }
}
