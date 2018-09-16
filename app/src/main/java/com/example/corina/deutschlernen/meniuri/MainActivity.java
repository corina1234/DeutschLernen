package com.example.corina.deutschlernen.meniuri;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.corina.deutschlernen.R;
import com.example.corina.deutschlernen.dbStuff.DBAdapter;
import com.example.corina.deutschlernen.structuraSchelet.Structura;
import com.example.corina.deutschlernen.structuraSchelet.StructuraSingletone;
import com.example.corina.deutschlernen.testVocabularStuff.TestVocabular;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StructuraSingletone nou=StructuraSingletone.getInstance();

        DBAdapter adapter=new DBAdapter(this);
        adapter.openConnection();
        nou.getListaCuvinte().clear();
        for(Structura struct: adapter.afisare()){

            nou.adaugaStructura(struct);

        }
        adapter.closeConnection();



/*
        try
        {
            BufferedReader in=new BufferedReader(new InputStreamReader(getAssets().open("cuvinte.txt")));
            String line;
            while( (line=in.readLine())!=null ){
                String[] t=line.split(",");
                Structura s = new Structura();
                s.setStructuraGermana(t[0].trim());
                s.setForma(t[1].trim());
                s.setTraducere(t[2].trim());
               s.setListacuvinteAsemanatoare(t[3].trim());
                s.setListaAlteStructuriAsemanatoare(t[4].trim());
                s.setTipStructura(TipStructura.Conjunctie);
               // s.setTipStructura(TipStructura.valueOf(t[5].trim()));
                structuraSingletone.adaugaStructura(s);
            }
            in.close();
            } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

*/




        Button button = (Button)findViewById(R.id.dictionar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Meniu2.class));



            }
        });

        Button button2 = (Button)findViewById(R.id.gramatica);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,meniuGramatica.class));


            }
        });

        Button button3 = (Button)findViewById(R.id.testV);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,TestVocabular.class));


            }
        });
/*
        Button button4 = (Button)findViewById(R.id.testV2);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,TestVocabularLista.class));


            }
        });*/

        Button button5 = (Button)findViewById(R.id.admin);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,admin.class));


            }
        });
    }
}
