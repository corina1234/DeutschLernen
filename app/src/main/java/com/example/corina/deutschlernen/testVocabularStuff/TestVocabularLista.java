package com.example.corina.deutschlernen.testVocabularStuff;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.corina.deutschlernen.R;
import com.example.corina.deutschlernen.structuraSchelet.Structura;
import com.example.corina.deutschlernen.structuraSchelet.StructuraSingletone;

import java.util.ArrayList;

public class TestVocabularLista extends AppCompatActivity {
    ListView list;
    ArrayAdapter<String> adapterString;
    ArrayList<String> lista=new ArrayList<>();
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_vocabular_lista);
        mContext = this;

        StructuraSingletone listaCuvinte = StructuraSingletone.getInstance();

        list=(ListView)findViewById(R.id.listaCuvinte);
        for (Structura a: listaCuvinte.getListaCuvinte())
        {
                lista.add(a.getTraducere());

        }
        adapterString = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        list.setAdapter(adapterString);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(mContext, DetaliiStructuraRomanaGermana.class);
                intent.putExtra("nume",(String)adapterView.getItemAtPosition(i));
                mContext.startActivity(intent);
            }
        });

    }
}
