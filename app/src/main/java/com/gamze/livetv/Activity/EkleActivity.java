package com.gamze.livetv.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.gamze.livetv.Kanallar;
import com.gamze.livetv.Kanallardao;
import com.gamze.livetv.R;
import com.gamze.livetv.VeriTabaniYardimcisi;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class EkleActivity extends AppCompatActivity {
         private AdView banner1;

        private Toolbar toolbar2;
        private EditText editTextAd, editTextUrl;
        private Button buttonEkle;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_ekle);
             banner1 = findViewById(R.id.banner1);
            MobileAds.initialize(this,"ca-app-pub-8525746773990389~1660514575");
            AdRequest adRequest = new AdRequest.Builder().build();

            banner1.loadAd(adRequest);

            banner1.setAdListener(new AdListener() {

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


            banner1 = findViewById(R.id.banner);
            buttonEkle = findViewById(R.id.buttonEkle);
            editTextAd = findViewById(R.id.editTextAd);
            editTextUrl = findViewById(R.id.editTextUrl);


            toolbar2 = findViewById(R.id.toolbar2);
            toolbar2.setTitle("Kanal Ekle");
            toolbar2.setTitleTextColor(Color.WHITE);

            setSupportActionBar(toolbar2);

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);


            buttonEkle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String ad = editTextAd.getText().toString().trim();
                    String url = editTextUrl.getText().toString().trim();
                    //  String resim = imageViewResimekle.getText().toString().trim();

                    if(ad.isEmpty() || url.isEmpty()  ){
                        Toast.makeText(getApplicationContext(), "Alanları boş geçemezsiniz!", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    Kanallar kanallar = new Kanallar(ad,url);
                    VeriTabaniYardimcisi vt = new VeriTabaniYardimcisi(getApplicationContext());
                    Kanallardao dao = new Kanallardao();
                    dao.kanalEkle(kanallar,vt);

                    editTextAd.setText("");
                    editTextUrl.setText("");
                    // ImageViewResimekle.setText("");
                    kanallar.setKanal_ad(" Kanal adı: ");


                    Toast.makeText(getApplicationContext(),"Kanal eklendi", Toast.LENGTH_SHORT).show();


                    onBackPressed();

                }
            });



        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {

            getMenuInflater().inflate(R.menu.toolbar2_menu,menu);


            return true;
        }




        @Override
        public void onBackPressed() {
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
            super.onBackPressed();
        }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    }


