package com.example.corina.deutschlernen.cuvinteAfisare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import com.example.corina.deutschlernen.R;
import com.example.corina.deutschlernen.structuraSchelet.Structura;
import com.example.corina.deutschlernen.structuraSchelet.StructuraSingletone;

import java.util.ArrayList;
import java.util.Locale;

public class ListaCuvinte extends AppCompatActivity {
    ListView list;
    ListaVerbeAdaptor adapter;
    ArrayList<Structura> lista;
    EditText editsearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verbe);
        lista = new ArrayList<>();

        StructuraSingletone listaCuvinte = StructuraSingletone.getInstance();

        Intent intent = getIntent();
        String tip = intent.getStringExtra("structura");

           list=(ListView)findViewById(R.id.listaCuvinte);
            for (Structura a: listaCuvinte.getListaCuvinte())
            {
                if(a.getTipStructura().name().equals(tip))
                    lista.add(a);

            }


            adapter = new ListaVerbeAdaptor(this, lista);
            list.setAdapter(adapter);



            editsearch = (EditText) findViewById(R.id.myFilter);
                editsearch.addTextChangedListener(new TextWatcher() {

                    @Override
                    public void afterTextChanged(Editable arg0) {
                        // TODO Auto-generated method stub
                        String text = editsearch.getText().toString().toLowerCase(Locale.getDefault());
                        adapter.filter(text);
                    }

                    @Override
                    public void beforeTextChanged(CharSequence arg0, int arg1,
                                                  int arg2, int arg3) {
                        // TODO Auto-generated method stub
                    }

                    @Override
                    public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                              int arg3) {
                        // TODO Auto-generated method stub
                    }
                });



    }

}
