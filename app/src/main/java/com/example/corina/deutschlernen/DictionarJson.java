package com.example.corina.deutschlernen;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.corina.deutschlernen.cuvinteAfisare.ListaVerbeAdaptor;
import com.example.corina.deutschlernen.meniuri.MainActivity;
import com.example.corina.deutschlernen.meniuri.admin;
import com.example.corina.deutschlernen.structuraSchelet.Structura;

import java.util.ArrayList;
import java.util.List;

public class DictionarJson extends AppCompatActivity {
   private ListView list;
    private ArrayList<String> lista;
    private CuvinteRoEnAdaptor adapter;
    private EditText editsearch;
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionar_json);
        editsearch = (EditText) findViewById(R.id.myFilter);
        list=(ListView)findViewById(R.id.listaCuvinte);

        Button button = (Button)findViewById(R.id.dictExt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lista = new ArrayList<>();
                json(editsearch.getText().toString());

            }
        });



    }

    public void json(String cuvantCautat) {
        ParsareJSOn json = new ParsareJSOn() {
            @Override
            protected void onPostExecute(List<String> cuvinte) {
                if (cuvinte.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Nu exista cuvinte!", Toast.LENGTH_SHORT).show();

                }
                for (String cuvant : cuvinte) {
                    lista.add(cuvant);
                }
                adapter = new CuvinteRoEnAdaptor(context, lista);
                list.setAdapter(adapter);
            }
        };
        json.execute("https://dictionary.yandex.net/api/v1/dicservice.json/lookup?key=dict.1.1.20190406T085424Z.9d5594e57d328746.f3cb275713f16d1464b869dbfc65127788207ed6&lang=en-de&text=" + cuvantCautat);
    }
}
