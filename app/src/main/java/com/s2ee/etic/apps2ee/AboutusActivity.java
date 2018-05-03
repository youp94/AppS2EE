package com.s2ee.etic.apps2ee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class AboutusActivity extends AppCompatActivity {
        private TextView A1,A2,A3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("About Us");
    A1 = (TextView) findViewById(R.id.A1);
        A2 = (TextView) findViewById(R.id.A2);
        A3 = (TextView) findViewById(R.id.A3);
    A1.setText(" ETIC est une organisation estudiantine destinée à toute personne voulant partager et développer sa créativité en vivant de nouvelles expériences, elle a été créé en Septembre 2009 par des étudiants de l’école nationale supérieure d’informatique afin de faciliter l’intégration des étudiants au monde professionnel et entrepreneurial. Les thématiques abordées s’articulent autour des TIC.");
    A2.setText("ETIC vise à enrichir la formation des étudiants et participer à sa diversité en faisant profiter les futurs ingéinieurs des expériences, du savoir et du savoir-faire des membres du club ainsi que celui de leurs partenaires et invités pour ainsi contribuer à la production d'une génération d'excellence.");
    A3.setText("- Compléter les notions théoriques acquises par les étudiants par des compétences techniques. - Préparer les étudiants à affronter le monde de l'entreprise en les rapprochant de cette dernière dès leurs premières années de formation. - Aider les étudiants à développer un esprit entrepreneurial.");
    }
}
