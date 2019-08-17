package com.gamze.livetv.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
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


public class EkleActivity extends AppCompatActivity {

        private Toolbar toolbar2;
        private EditText editTextAd, editTextUrl;
        private Button buttonEkle;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_ekle);
            buttonEkle = findViewById(R.id.buttonEkle);
            editTextAd = findViewById(R.id.editTextAd);
            editTextUrl = findViewById(R.id.editTextUrl);


            toolbar2 = findViewById(R.id.toolbar2);
            toolbar2.setTitle("Kanal Ekle");
            toolbar2.setTitleTextColor(Color.WHITE);

            setSupportActionBar(toolbar2);




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
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()){
                case R.id.action_geri:
                    Intent intent = new Intent(this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
            }


        }

        @Override
        public void onBackPressed() {
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
            super.onBackPressed();
        }


    }


