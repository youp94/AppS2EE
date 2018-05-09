package com.s2ee.etic.apps2ee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FavouritActivity extends AppCompatActivity {

    String ID;
    User user;

    private DatabaseReference mDatabase;

    private EntrepriseListAdapter adapter;
    private RecyclerView cardView;
    private List<Entreprise> entrepriseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourit);

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if(account != null) {
            ID = account.getId();
        }

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(ID);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Mes favoris");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        cardView = (RecyclerView) findViewById(R.id.my_recycler_view_user);
        entrepriseList = new ArrayList<Entreprise>();
        adapter = new EntrepriseListAdapter(entrepriseList,getApplicationContext());
        cardView.setAdapter(adapter);
        cardView.setLayoutManager(new LinearLayoutManager(this));
        cardView.setItemAnimator(new DefaultItemAnimator());

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                entrepriseList.clear();
                String userId = dataSnapshot.child("userId").getValue(String.class);
                String userEmail = dataSnapshot.child("userEmail").getValue(String.class);
                String username = dataSnapshot.child("username").getValue(String.class);
                user = new User(userId, userEmail, username);

                Iterator<DataSnapshot> i = dataSnapshot.child("interested").getChildren().iterator();
                while (i.hasNext()){
                    Entreprise e = i.next().getValue(Entreprise.class);
                    entrepriseList.add(e);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

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
