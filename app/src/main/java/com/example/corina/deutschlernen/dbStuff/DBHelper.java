package com.example.corina.deutschlernen.dbStuff;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Corina on 25.02.2018.
 */

public class DBHelper extends SQLiteOpenHelper {
    private String nume;

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.nume=name;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+nume+" (id integer primary key autoincrement, cuvantGermana text,cuvantRomana text, cuvinteAsem text, structAsem text, forma text, tipStruct text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+nume);
        onCreate(sqLiteDatabase);
    }
}
