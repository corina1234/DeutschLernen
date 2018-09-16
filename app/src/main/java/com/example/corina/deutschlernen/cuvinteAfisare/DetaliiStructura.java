package com.example.corina.deutschlernen.cuvinteAfisare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.corina.deutschlernen.R;
import com.example.corina.deutschlernen.structuraSchelet.Structura;
import com.example.corina.deutschlernen.structuraSchelet.TipStructura;

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
            Structura struct = (Structura)in.getSerializableExtra("nume");
                    verbTraducere = (TextView) findViewById(R.id.verbTraducere);
                    verbTraducere.setText(struct.getStructuraGermana()+ " = " + struct.getTraducere());
                    forme2 = (TextView) findViewById(R.id.verbForme);
                    forme = (TextView)findViewById(R.id.formeStructura);
                    if(struct.getTipStructura().ordinal() == (TipStructura.Verb.ordinal())) {
                        forme.setText(">>>Forme timpuri verb:");
                        forme2.setText(struct.getStructuraGermana() + struct.getForma());
                    }
                    if(struct.getTipStructura().ordinal() == (TipStructura.Substantiv.ordinal())) {
                        forme.setText(">>>Forma plural:");
                        forme2.setText(struct.getForma());
                    }
                    structuriSimilare = (TextView) findViewById(R.id.verbeSimilare);
                    structuriSimilare.setText(struct.getListacuvinteAsemanatoare());

                    familieLexicala = (TextView) findViewById(R.id.cuvinteLexical);
                    familieLexicala.setText(struct.getListaAlteStructuriAsemanatoare());

    }
}
