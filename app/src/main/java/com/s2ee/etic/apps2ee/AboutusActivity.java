package com.s2ee.etic.apps2ee;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

public class AboutusActivity extends AppCompatActivity {
        private TextView A1,A2,A3;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("About Us");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        A1 = (TextView) findViewById(R.id.A1);
        A2 = (TextView) findViewById(R.id.A2);
        A3 = (TextView) findViewById(R.id.A3);

        A1.setText("Pour sa neuvième année d’existence, ETIC," +
                "organisation estudiantine de l’école nationale" +
                "supérieure d’informatique ESI (ex : INI) aspire à" +
                "renouveler son engagement pour l’évolution et" +
                "l’amélioration de son écosystème. Pour ce faire le" +
                "club ambitionne un élargissement de son champ" +
                "d’action à travers :\n" +
                "-Le renforcement du réseau estudiantin au-" +
                "delà de l’ESI.\n" +
                "-Le rapprochement entre étudiants," +
                "entreprises et le monde de la recherche" +
                "scientifique.\n" +
                "-Le développement constant d’une" +
                "synergie au sein de notre écosystème.");
        A2.setText("Pour pouvoir atteindre ses objectifs et remplir sa" +
                "mission, le club ETIC a établi un programme qui" +
                "vise à organiser différentes activités. Depuis sa" +
                "création, le club ETIC a organisé plusieurs" +
                "évènements à caractère managériale d’envergure" +
                "nationale et internationale notamment des salons" +
                "de l’emploi dont nous citerons les huit éditions du" +
                "salon de l’emploi de l’ESI (S2EE) qui est un" +
                "véritable pont entre les étudiants demandeurs" +
                "d’emplois ou de stages et les entreprises" +
                "participantes. ETIC ne se contente pas seulement" +
                "du caractère managérial, en effet, plusieurs" +
                "évènements d’aspect techniques ont été organisés" +
                "telles des camps de formation. Le Training Camp" +
                "est un camp de formation accélérées de trois jours" +
                "dans différents domaines techniques et" +
                "managériaux, trois jours au bout desquels des" +
                "équipes sont amenées à réaliser un projet.");
        A3.setText("L’organisation vise à créer une cellule d’excellence au sein d’une école d’excellence. ETIC croit" +
                " en la force" +
                "des idées, à la volonté d’entreprendre pour changer les choses et avoir un impact positif sur la société en" +
                "mettant l’accent sur l’innovation personnelle et collective, tout cela dans un cadre sérieux et professionnel");
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
