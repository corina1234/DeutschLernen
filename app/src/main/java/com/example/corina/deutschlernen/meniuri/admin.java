package com.example.corina.deutschlernen.meniuri;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.corina.deutschlernen.administrare.ListViewToateCuvinte;
import com.example.corina.deutschlernen.R;
import com.example.corina.deutschlernen.administrare.AdaugaStructuriiView;

public class admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        final Context mContext = this;

        Button button = (Button)findViewById(R.id.adauga);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, AdaugaStructuriiView.class);
                intent.putExtra("tip", "adauga");
                startActivity(intent);


            }
        });

        Button button2 = (Button)findViewById(R.id.schimba);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(admin.this,ListViewToateCuvinte.class));


            }
        });
    }
}
