package com.gamze.livetv;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class VeriTabaniYardimcisi extends SQLiteOpenHelper {

    public VeriTabaniYardimcisi(Context context){
        super(context,"LiveTv.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS  \"kanallar\" (\n" +
                "\t\"kanal_id\"\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t\"kanal_ad\"\tTEXT,\n" +
                "\t\"kanal_url\"\tTEXT,\n" +
                "\t\"kanal_resim\"\tTEXT\n" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS kanallar");
        onCreate(db);
    }



}
