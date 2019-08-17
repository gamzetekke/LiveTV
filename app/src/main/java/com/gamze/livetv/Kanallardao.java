package com.gamze.livetv;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class Kanallardao {
    private Kanallar kanal_id;
    private  Kanallar kanal_ad;
    private Kanallar kanal_url;


    public void kanalEkle(Kanallar kanallar,VeriTabaniYardimcisi vt){
        SQLiteDatabase dbx = vt.getWritableDatabase();
        ContentValues degerler = new ContentValues();

        degerler.put("kanal_ad", kanallar.getKanal_ad());
        degerler.put("kanal_url", kanallar.getKanal_url());

        dbx.insert("kanallar",null,degerler);

        dbx.close();
    }


    public void kanalSil(VeriTabaniYardimcisi vt, int kanal_id){
        SQLiteDatabase dbx = vt.getWritableDatabase();
        dbx.delete("kanallar","kanal_id = ?",new String[]{String.valueOf(kanal_id)});
        dbx.close();

    }




    public ArrayList<Kanallar> tumKanallar(VeriTabaniYardimcisi vt){
        ArrayList<Kanallar> kanallarArrayList = new ArrayList<>();
        SQLiteDatabase dbx = vt.getReadableDatabase();

        Cursor c = dbx.rawQuery("SELECT * FROM kanallar", null);
        if(c.moveToFirst()){
            while (c.moveToNext()){
                Kanallar kanallar = new Kanallar(c.getString(c.getColumnIndex("kanal_ad")), c.getString(c.getColumnIndex("kanal_url")));
                kanallar.setKanal_id(c.getInt(c.getColumnIndex("kanal_id")));
                kanallarArrayList.add(kanallar);
            }
        }
        c.close();
        dbx.close();
        return kanallarArrayList;

    }






}
