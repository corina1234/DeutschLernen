package com.example.corina.deutschlernen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetaliiStructura extends AppCompatActivity {
    TextView verbTraducere;
    TextView forme;
    TextView forme2;
    TextView structuriSimilare;
    TextView familieLexicala;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalii_verbe);

            Intent in = getIntent();
            String nume = in.getStringExtra("nume");
            for (int i = 0; i < StructuraSingletone.getInstance().getListaCuvinte().size(); i++) {
                if (StructuraSingletone.getInstance().getListaCuvinte().get(i).getStructuraGermana().equals(nume)) {
                    verbTraducere = (TextView) findViewById(R.id.verbTraducere);
                    verbTraducere.setText(StructuraSingletone.getInstance().getListaCuvinte().get(i).getStructuraGermana()+ " = " + StructuraSingletone.getInstance().getListaCuvinte().get(i).getTraducere());
                    forme2 = (TextView) findViewById(R.id.verbForme);
                    forme = (TextView)findViewById(R.id.formeStructura);
                    if(StructuraSingletone.getInstance().getListaCuvinte().get(i).getTipStructura().equals(TipStructura.Verb)) {
                        forme.setText(">>>Forme timpuri verb:");
                        forme2.setText(nume + StructuraSingletone.getInstance().getListaCuvinte().get(i).getForma());
                    }
                    if(StructuraSingletone.getInstance().getListaCuvinte().get(i).getTipStructura().equals(TipStructura.Substantiv)) {
                        forme.setText(">>>Forma plural:");
                        forme2.setText(StructuraSingletone.getInstance().getListaCuvinte().get(i).getForma());
                    }
                    structuriSimilare = (TextView) findViewById(R.id.verbeSimilare);
                    structuriSimilare.setText(StructuraSingletone.getInstance().getListaCuvinte().get(i).getListacuvinteAsemanatoare());

                    familieLexicala = (TextView) findViewById(R.id.cuvinteLexical);
                    familieLexicala.setText(StructuraSingletone.getInstance().getListaCuvinte().get(i).getListaAlteStructuriAsemanatoare());

                }
            }
    }
}
