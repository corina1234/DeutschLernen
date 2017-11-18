package com.example.corina.deutschlernen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Corina on 03.06.2017.
 */

public class StructuraSingletone {
    private static StructuraSingletone instance = null;
    private ArrayList<Structura> listaCuvinte = new ArrayList<>();

    private StructuraSingletone(){}

    public static StructuraSingletone getInstance(){
        if(instance == null){
            instance = new StructuraSingletone();
        }
        return  instance;
    }

    public void adaugaStructura(Structura structura){
        listaCuvinte.add(structura);
    }

    public ArrayList<Structura> getListaCuvinte() {

        Collections.sort(listaCuvinte, new Comparator<Structura>() {
            @Override
            public int compare(Structura structura, Structura t1) {
                return structura.getStructuraGermana().compareTo(t1.getStructuraGermana());
            }
        });
        return listaCuvinte;
    }

    public Structura getCuvant(int index){
        return listaCuvinte.get(index);
    }
}
