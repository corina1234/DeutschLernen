package com.example.corina.deutschlernen.dbStuff;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.corina.deutschlernen.structuraSchelet.Structura;
import com.example.corina.deutschlernen.structuraSchelet.TipStructura;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Corina on 25.02.2018.
 */

public class DBAdapter {
    private Context context;
    private SQLiteDatabase db;
    private DBHelper helper;

    public DBAdapter(Context context) {
        this.context = context;
        helper=new DBHelper(context,"cuvinte",null,1);
    }
    public void openConnection(){db=helper.getWritableDatabase();}
    public void closeConnection(){helper.close();}

    public void inserare(Structura s){
        ContentValues cv=new ContentValues();
        cv.put("cuvantGermana",s.getStructuraGermana());
        cv.put("cuvantRomana",s.getTraducere());
        cv.put("cuvinteAsem",s.getListacuvinteAsemanatoare());
        cv.put("structAsem",s.getListaAlteStructuriAsemanatoare());
        cv.put("forma",s.getForma());
        cv.put("tipStruct",s.getTipStructuraString());
        db.insert("cuvinte",null,cv);
    }

    public void modificare(Structura s){
        ContentValues cv=new ContentValues();
        cv.put("cuvantGermana",s.getStructuraGermana());
        cv.put("cuvantRomana",s.getTraducere());
        cv.put("cuvinteAsem",s.getListacuvinteAsemanatoare());
        cv.put("structAsem",s.getListaAlteStructuriAsemanatoare());
        cv.put("forma",s.getForma());
        cv.put("tipStruct",s.getTipStructuraString());
        db.update("cuvinte",cv ,"id=" + s.getId(), null);
    }

    public List<Structura> afisare(){
        List<Structura> lista=new ArrayList<>();
        Cursor c=db.query("cuvinte",new String[]{"cuvantGermana","cuvantRomana","cuvinteAsem","structAsem","forma","tipStruct","id"},null,null,null,null,null,null);
        c.moveToFirst();
        if(c!=null){
            do{
                Structura l=new Structura(c.getString(0),c.getString(4),c.getString(1),c.getString(2),c.getString(3), TipStructura.valueOf(c.getString(5)));
                l.setId(c.getInt(6));
                lista.add(l);
            }while(c.moveToNext());
        }

        return lista;
    }
}
