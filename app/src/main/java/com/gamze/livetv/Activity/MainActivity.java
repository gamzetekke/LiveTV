package com.gamze.livetv.Activity;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.gamze.livetv.DatabaseCopyHelper;
import com.gamze.livetv.Kanallar;
import com.gamze.livetv.Kanallardao;
import com.gamze.livetv.Adapter.MyAdapter;
import com.gamze.livetv.R;
import com.gamze.livetv.VeriTabaniYardimcisi;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AdView banner;

    private ImageButton imageButtonSil;

    private Toolbar toolbar;

    private VeriTabaniYardimcisi vt;

    private RecyclerView rv;
    private MyAdapter adapter;
    private ArrayList<Kanallar> kanallarArrayList;
    /*private String videoUrl = "http://dreamstariptv.live:25461/lKeq2jQpvc/GN1xw5o4bt/3807";

    private ProgressDialog pd;
    VideoView videoView; */



    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {    //Toolbar ekle
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this,"ca-app-pub-8525746773990389~1660514575");

        banner = findViewById(R.id.banner);

        AdRequest adRequest = new AdRequest.Builder().build();

        banner.loadAd(adRequest);

        banner.setAdListener(new AdListener() {

            @Override public void onAdLoaded(){
                Log.e("Banner", "onAdLoaded çalıştı");
            }

            @Override public void onAdFailedToLoad(int i){
                Log.e("Banner","onAdFailedToLoad çalıştı");
            }

            @Override
            public void onAdOpened() {
                Log.e("Banner","onAdOpen çalıştı");
            }

            @Override public void onAdLeftApplication(){
                Log.e("Banner","onAdLeftApplication çalıştı");
            }

            @Override public void onAdClosed(){
                Log.e("Banner","onAdClosed çaıştı");

            }

        });









        kopyala();
        vt = new VeriTabaniYardimcisi(this);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitle("Live Tv");

        toolbar.setTitleTextColor(Color.WHITE);

        setSupportActionBar(toolbar);

        kanallarArrayList = new Kanallardao().tumKanallar(vt);

        rv =findViewById(R.id.rv);    //recyclerView
        rv.setHasFixedSize(true);
        //rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setLayoutManager(new

                LinearLayoutManager(this));
        adapter =new MyAdapter(this,kanallarArrayList);
        rv.setAdapter(adapter);
    }



    @Override //Menu ekleme
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar_menu,menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){     //menu item islev ekleme

        switch (item.getItemId()){
            case R.id.action_ekle:
                Intent yeniIntent = new Intent(MainActivity.this, EkleActivity.class);
                startActivity(yeniIntent);
                // Toast.makeText(getApplicationContext(), "Ekle Tıklandı", Toast.LENGTH_SHORT).show();
                return true;



            default:
                return super.onOptionsItemSelected(item);

        }

    }







    public void kopyala() {    //sqLite verileri kopyalama
        DatabaseCopyHelper helper = new DatabaseCopyHelper(this);
        try {
            helper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        helper.openDataBase();






        /*Kanallar k1 = new Kanallar("ATV","http://trkvz-m.ercdn.net/trkvz-temp/atvhdm.m3u8", "atv");
        Kanallar k2 = new Kanallar("ShowTv", "http://dreamstariptv.live:25461/lKeq2jQpvc/GN1xw5o4bt/61", "showtv");
        Kanallar k3 = new Kanallar("StavrTv","http://lcgid8xu.rocketcdn.com/startvhd.stream_360p/chunklist.m3u8", "star");
        Kanallar k4 = new Kanallar("KanalD","http://185102219109.dogannet.tv/S1/HLS_LIVE/kanald/1000/prog_index.m3u8", "kanald");
        Kanallar k5 = new Kanallar("FOX","http://dreamstariptv.live:25461/lKeq2jQpvc/GN1xw5o4bt/25", "fox");
        Kanallar k6= new Kanallar("TV8","http://dreamstariptv.live:25461/lKeq2jQpvc/GN1xw5o4bt/3838","tv8");
        Kanallar k7= new Kanallar("Kanal7","http://dreamstariptv.live:25461/lKeq2jQpvc/GN1xw5o4bt/79","kanal7");
        Kanallar k8 = new Kanallar("Cine5","http://dreamstariptv.live:25461/lKeq2jQpvc/GN1xw5o4bt/7213","cine5");




        kanallarArrayList =new ArrayList<>();

        kanallarArrayList.add(k1);
        kanallarArrayList.add(k2);
        kanallarArrayList.add(k3);
        kanallarArrayList.add(k4);
        kanallarArrayList.add(k5);
        kanallarArrayList.add(k6);
        kanallarArrayList.add(k7);
        kanallarArrayList.add(k8);*/




    }


      /*  vt = new VeriTabaniYardimcisi(this);

        new Kanallardao().kanalEkle(vt,"ATV","http://trkvz-m.ercdn.net/trkvz-temp/atvhdm.m3u8");
        new Kanallardao().kanalEkle(vt,"ShowTv","http://dreamstariptv.live:25461/lKeq2jQpvc/GN1xw5o4bt/3807");
        new Kanallardao().kanalEkle(vt,"Star","<uses-permission android:name="android.permission.CAMERA" />
<uses-permission android:name="android.permission.CAMERA" />
");
        new Kanallardao().kanalEkle(vt,"KanalD","https://soledge20.dogannet.tv//S2/HLS_LIVE/kanaldnp/track_4_1000/playlist.m3u8");
        new Kanallardao().kanalEkle(vt,"FOX","http://dreamstariptv.live:25461/lKeq2jQpvc/GN1xw5o4bt/25");
        new Kanallardao().kanalEkle(vt,"TV8","http://dreamstariptv.live:25461/lKeq2jQpvc/GN1xw5o4bt/3838");
        new Kanallardao().kanalEkle(vt,"Kanal7","http://dreamstariptv.live:25461/lKeq2jQpvc/GN1xw5o4bt/79");
        new Kanallardao().kanalEkle(vt,"Cine5","http://dreamstariptv.live:25461/lKeq2jQpvc/GN1xw5o4bt/7213");

        ArrayList<Kanallar> gelenKanallarListesi = new Kanallardao().tumKanallar(vt);

        for(Kanallar k : gelenKanallarListesi){

        }  */






       /* videoView =  findViewById(R.id.videoView);
        pd = new ProgressDialog(this);
        pd.setMessage("Buffering...");
        pd.setCancelable(true);

        playVideo();


    }

    private void playVideo() {

        try{
            getWindow().setFormat(PixelFormat.TRANSLUCENT);
            MediaController mediaController = new MediaController(this);
            mediaController.setAnchorView(videoView);

            Uri videoUri = Uri.parse(videoUrl);

            videoView.setMediaController(mediaController);

            videoView.setVideoURI(videoUri);
            videoView.requestFocus();
            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    pd.dismiss();
                    videoView.start();

                }
            });


        }
        catch (Exception e){
            pd.dismiss();
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        }
*/

}

