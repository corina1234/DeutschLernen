package com.example.corina.deutschlernen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class ListaCuvinte extends AppCompatActivity {
    ListView list;
    ListaVerbeAdaptor adapter;
    ArrayList<Structura> lista=new ArrayList<>();
    EditText editsearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verbe);

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
