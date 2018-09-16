package com.example.corina.deutschlernen.administrare;

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

public class ListViewToateCuvinte extends AppCompatActivity {
    ListView list;
    ListaCuvinteModificareAdaptor adapter;
    ArrayList<Structura> lista=new ArrayList<>();
    EditText editsearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_toate_cuvinte);
        StructuraSingletone listaCuvinte = StructuraSingletone.getInstance();

        list=(ListView)findViewById(R.id.listaToateCuvinte);
        for (Structura a: listaCuvinte.getListaCuvinte())
        {
                lista.add(a);

        }


        adapter = new ListaCuvinteModificareAdaptor(this, lista);
        list.setAdapter(adapter);

        editsearch = (EditText) findViewById(R.id.myFilter);
        editsearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable arg0) {
                String text = editsearch.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {
            }

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
            }
        });
    }
}
