package com.example.corina.deutschlernen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;

public class TestVocabular extends AppCompatActivity {
    StructuraSingletone structuraSingletone;
    TextView cuvantRandom;
    int random;
    Random random1;
    EditText cuvantClient;
    TextView raspunsFinal;
    TextView raspunsCorect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_vocabular);

         structuraSingletone = StructuraSingletone.getInstance();
        cuvantRandom=(TextView)findViewById(R.id.cuvantRandom);
       random1 = new Random();

        cuvantClient = (EditText)findViewById(R.id.editTextSolutie);
        raspunsFinal =(TextView)findViewById(R.id.raspuns);
        raspunsCorect = (TextView)findViewById(R.id.cuvantCorectTextView);

        Button button = (Button)findViewById(R.id.generareCuvant);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cuvantClient.setText("");
                raspunsFinal.setText("");
                cuvantRandom.setText("");
                raspunsCorect.setText("");
                random = random1.nextInt(structuraSingletone.getListaCuvinte().size());
                cuvantRandom.setText(structuraSingletone.getCuvant(random).getTraducere());

            }
        });
        Button button2 = (Button)findViewById(R.id.solutie);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String cuvantClientString =  cuvantClient.getText().toString().trim();
                for(Structura s: structuraSingletone.getListaCuvinte()) {
                    if(s.getTraducere().equals(cuvantRandom.getText())){
                        if (s.getStructuraGermana().toLowerCase(Locale.getDefault()).equalsIgnoreCase(cuvantClientString)) {
                         raspunsFinal.setText("Richtig!");
                            break;
                    }
                    else {
                        raspunsFinal.setText("Falsch");
                            raspunsCorect.setText(s.getStructuraGermana());
                        }
                    }
                }
            }
        });

    }

}
