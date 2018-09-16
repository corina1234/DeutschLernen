package com.example.corina.deutschlernen.meniuri;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.corina.deutschlernen.R;
import com.example.corina.deutschlernen.gramaticaStuff.DeclAdj;
import com.example.corina.deutschlernen.gramaticaStuff.Fehlerere;
import com.example.corina.deutschlernen.gramaticaStuff.HinHer;
import com.example.corina.deutschlernen.gramaticaStuff.NachdemSatze;
import com.example.corina.deutschlernen.gramaticaStuff.Prepozitii;
import com.example.corina.deutschlernen.gramaticaStuff.Pronume;
import com.example.corina.deutschlernen.gramaticaStuff.RelativPronomen;
import com.example.corina.deutschlernen.gramaticaStuff.VbFinal;
import com.example.corina.deutschlernen.gramaticaStuff.VbLoc2;
import com.example.corina.deutschlernen.gramaticaStuff.diatezaPasiva;
import com.example.corina.deutschlernen.gramaticaStuff.gradpartikeln;
import com.example.corina.deutschlernen.gramaticaStuff.nDekl;
import com.example.corina.deutschlernen.gramaticaStuff.wissenKennenKonnen;

public class meniuGramatica extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meniu_gramatica);

        Button button = (Button)findViewById(R.id.gradPA);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(meniuGramatica.this,gradpartikeln.class));


            }
        });
        Button button2 = (Button)findViewById(R.id.nDekl);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(meniuGramatica.this,nDekl.class));


            }
        });

        Button button3 = (Button)findViewById(R.id.wkk);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(meniuGramatica.this,wissenKennenKonnen.class));


            }
        });

        Button button4 = (Button)findViewById(R.id.relativPron);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(meniuGramatica.this,RelativPronomen.class));


            }
        });

        Button button5 = (Button)findViewById(R.id.conjunctiiVbLoc2);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(meniuGramatica.this,VbLoc2.class));


            }
        });

        Button button6 = (Button)findViewById(R.id.conjunctiiVbFinal);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(meniuGramatica.this,VbFinal.class));


            }
        });

        Button button7 = (Button)findViewById(R.id.nachdem);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(meniuGramatica.this,NachdemSatze.class));


            }
        });

        Button button8 = (Button)findViewById(R.id.pasiv);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(meniuGramatica.this,diatezaPasiva.class));


            }
        });

        Button button9 = (Button)findViewById(R.id.hinher);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(meniuGramatica.this,HinHer.class));


            }
        });

        Button button10 = (Button)findViewById(R.id.declAdj);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(meniuGramatica.this,DeclAdj.class));


            }
        });

        Button button11 = (Button)findViewById(R.id.pronume);
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(meniuGramatica.this,Pronume.class));


            }
        });

        Button button12 = (Button)findViewById(R.id.Fehlere);
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(meniuGramatica.this,Fehlerere.class));


            }
        });

        Button button13 = (Button)findViewById(R.id.prepozitii);
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(meniuGramatica.this,Prepozitii.class));


            }
        });
    }
}
