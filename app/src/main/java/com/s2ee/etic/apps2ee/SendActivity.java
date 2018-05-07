package com.s2ee.etic.apps2ee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class SendActivity extends AppCompatActivity {

    EditText editText;
    Button button;

    String ID;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if(account != null) {
            ID = account.getId();
        }

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(ID);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Vos avis");

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = editText.getText().toString();

                Random r = new Random();
                int i1 = r.nextInt(1000000);
                String child = String.valueOf(i1);

                mDatabase.child("Messages").child(child).setValue(message);
                editText.setText("");
                Toast.makeText(getApplicationContext(), "Message envoyé avec succsés !", Toast.LENGTH_LONG).show();
            }
        });
    }
}
