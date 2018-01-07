package com.example.corina.deutschlernen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetaliiStructuraRomanaGermana extends AppCompatActivity {
    TextView verbTraducere;
    StringBuilder sb = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalii_structura_romana_germana);
        Intent in = getIntent();
        String nume = in.getStringExtra("nume");
        for (int i = 0; i < StructuraSingletone.getInstance().getListaCuvinte().size(); i++) {
            if (StructuraSingletone.getInstance().getListaCuvinte().get(i).getTraducere().equals(nume)) {
                sb.append(StructuraSingletone.getInstance().getListaCuvinte().get(i).getStructuraGermana()).append("\n");

            }
        }
        verbTraducere = (TextView) findViewById(R.id.verbTraducere);
        verbTraducere.setText(sb.toString());

    }
}
