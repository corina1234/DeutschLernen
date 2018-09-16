package com.example.corina.deutschlernen.administrare;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.corina.deutschlernen.R;
import com.example.corina.deutschlernen.dbStuff.DBAdapter;
import com.example.corina.deutschlernen.structuraSchelet.Structura;
import com.example.corina.deutschlernen.structuraSchelet.StructuraSingletone;
import com.example.corina.deutschlernen.structuraSchelet.TipStructura;

public class AdaugaStructuriiView extends AppCompatActivity {

    private Structura structura;
    private static final String ADAUGA = "adauga";
    private static final String MODIFICA = "modificare";
    private Structura structuraVeche;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adauga_structurii_view);

        Intent intent = getIntent();
      final String nume = intent.getStringExtra("tip");

       final EditText denumire = (EditText) findViewById(R.id.cuvantGermana);
       final EditText traducere = (EditText) findViewById(R.id.traducere);
       final EditText cuvinteAsemanatoare = (EditText) findViewById(R.id.cuvinteAsemanatoare);
       final EditText cuvinteLexic = (EditText) findViewById(R.id.cuvinteLexic);
       final EditText formeCuvinte = (EditText) findViewById(R.id.formeCuvinte);
      final  Spinner categorie = (Spinner) findViewById(R.id.spinnerAdaugaCuvant);
       final Context currentContext = this;

        Button button = (Button)findViewById(R.id.adaugaBtn);

        if(nume.equals(ADAUGA)){
            structura = new Structura();
            button.setText("Hinzufügen");

        } else if(nume.equals(MODIFICA)){
            Intent in = getIntent();
            structura = (Structura)in.getSerializableExtra("nume");
            button.setText("Modifizieren");

            categorie.setSelection(structura.getTipStructura().ordinal());
            denumire.setText(structura.getStructuraGermana());
            traducere.setText(structura.getTraducere());
            cuvinteLexic.setText(structura.getListaAlteStructuriAsemanatoare());
            cuvinteAsemanatoare.setText(structura.getListacuvinteAsemanatoare());


            if(structura.getTipStructura().ordinal() == (TipStructura.Verb.ordinal()) || structura.getTipStructura().ordinal() == (TipStructura.Substantiv.ordinal())) {
                formeCuvinte.setText(structura.getForma());
            } else formeCuvinte.setEnabled(false);


            structuraVeche = new Structura();
            structuraVeche.creareCopieStructura(structura);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (categorie.getSelectedItem().toString()){
                    case "Substantiv": structura.setTipStructura(TipStructura.Substantiv);
                        break;
                    case "Verb": structura.setTipStructura(TipStructura.Verb);
                        break;
                    case "Adjectiv/Adverb": structura.setTipStructura(TipStructura.Adverb);
                        break;
                    case "Prepozitie/Conjunctie": structura.setTipStructura(TipStructura.Prepozitie);
                        break;
                    case "Constructie": structura.setTipStructura(TipStructura.Constructii);
                        break;
                }
                structura.setStructuraGermana(denumire.getText().toString());
                structura.setTraducere(traducere.getText().toString());
                structura.setListaAlteStructuriAsemanatoare(cuvinteLexic.getText().toString());
                structura.setListacuvinteAsemanatoare(cuvinteAsemanatoare.getText().toString());

                if(structura.getTipStructura().ordinal() == (TipStructura.Verb.ordinal()) || structura.getTipStructura().ordinal() == (TipStructura.Substantiv.ordinal())) {
                    structura.setForma(formeCuvinte.getText().toString());
                } else structura.setForma("");


                DBAdapter adapter=new DBAdapter(currentContext);
                adapter.openConnection();
                if(nume.equals(ADAUGA)) {
                    adapter.inserare(structura);
                    StructuraSingletone.getInstance().getListaCuvinte().add(structura);
                    Toast.makeText(getApplicationContext(),"Cuvant adaugat cu succes!",Toast.LENGTH_SHORT).show();
                } else if(nume.equals(MODIFICA)){
                    adapter.modificare(structura);
                   // StructuraSingletone.getInstance().getListaCuvinte().remove(structuraVeche);
                   // StructuraSingletone.getInstance().getListaCuvinte().add(structura);
                    Toast.makeText(getApplicationContext(),"Cuvant modificat cu succes!",Toast.LENGTH_SHORT).show();
                    //TODO refresh lista



                }
                adapter.closeConnection();
                finish();


            }
        });
    }
}
