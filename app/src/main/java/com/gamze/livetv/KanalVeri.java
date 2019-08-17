package com.gamze.livetv;

public class KanalVeri {
    private int kanal_id;
    private String kanal_ad;
    private String kanal_url;

    public KanalVeri(){
    }

    public KanalVeri(int  kanal_id, String kanal_ad, String kanal_url){
        this.kanal_id = kanal_id;
        this.kanal_ad = kanal_ad;
        this.kanal_url = kanal_url;
    }

    public int getKanal_id(){
        return kanal_id;
    }
    public void setKanal_id(int kanal_id){
        this.kanal_id = kanal_id;
    }
    public String getKanal_ad(){
        return kanal_ad;
    }
    public void setKanal_ad(String kanal_ad){
        this.kanal_ad = kanal_ad;
    }
    public String getKanal_url(){
        return kanal_url;
    }
    public void setKanal_url(String kanal_url){
        this.kanal_url = kanal_url;
    }

}
