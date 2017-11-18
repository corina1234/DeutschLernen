package com.example.corina.deutschlernen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Meniu2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meniu2);
        Button verbe = (Button)findViewById(R.id.verbe);
        verbe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Meniu2.this,ListaCuvinte.class);
                i.putExtra("structura","Verb");
                startActivity(i);
            }
        });

        Button subs = (Button)findViewById(R.id.subs);
        subs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Meniu2.this,ListaCuvinte.class);
                i.putExtra("structura","Substantiv");
                startActivity(i);
            }
        });




        Button adverbe = (Button)findViewById(R.id.adverbe);
        adverbe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Meniu2.this,ListaCuvinte.class);
                i.putExtra("structura","Adverb");
                startActivity(i);
            }
        });


        Button prepozitii = (Button)findViewById(R.id.prep);
        prepozitii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Meniu2.this,ListaCuvinte.class);
                i.putExtra("structura","Prepozitie");
                startActivity(i);
            }
        });

        Button constructii = (Button)findViewById(R.id.constructii);
        constructii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Meniu2.this,ListaCuvinte.class);
                i.putExtra("structura","Constructii");
                startActivity(i);
            }
        });
    }

}
