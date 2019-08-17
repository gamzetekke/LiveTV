package com.gamze.livetv.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.gamze.livetv.Activity.IzleActivity;
import com.gamze.livetv.Kanallar;
import com.gamze.livetv.Kanallardao;
import com.gamze.livetv.R;
import com.gamze.livetv.VeriTabaniYardimcisi;

import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CardTasarimTutucu> {
        private Context mContext;
        private List<Kanallar> kanallarListe;
        private Kanallardao dao;

        public MyAdapter(Context mContext, List<Kanallar> kanallarListe){
            this.mContext = mContext;
            this.kanallarListe = kanallarListe;
        }



        public class CardTasarimTutucu extends RecyclerView.ViewHolder {
            private CardView satirCard;
            private TextView textViewAd;
            private ImageButton imageButtonSil;

            public CardTasarimTutucu(View view){
                super(view);
                satirCard = view.findViewById(R.id.satirCard);
                textViewAd= view.findViewById(R.id.textViewAd);
                imageButtonSil = view.findViewById(R.id.imageButtonSil);

            }

        }


        @NonNull
        @Override
        public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_tasarim,parent,false);
            return new CardTasarimTutucu(v);
        }


        @Override
        public void onBindViewHolder(@NonNull CardTasarimTutucu holder, final int position) {
            final Kanallar kanal = kanallarListe.get(position);

            holder.textViewAd.setText(kanallarListe.get(position).getKanal_ad());

            //holder.kanal_resim.setImageResource(R.drawable.showtv);
            //  holder.kanal_ad.setImageResource(mContext.getResources().getIdentifier(kanal.getKanal_ad(),"drawable",mContext.getPackageName()));
            //Log.e("Kanal Resim",kanal.getKanal_ad());

            holder.satirCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(mContext, IzleActivity.class);
                    intent.putExtra("link",kanallarListe.get(position).getKanal_url());
                    mContext.startActivity(intent);


                    //Toast.makeText(mContext, "Tıklandı", Toast.LENGTH_SHORT).show();
                }
            });

            holder.imageButtonSil.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


        /*AlertDialog.Builder ao = new AlertDialog.Builder(mContext);
        ao.setIcon(R.drawable.ic_priority);
        ao.setTitle("Dikkat!");
        ao.setMessage("Kanal silinsin mi?");
        ao.setCancelable(false);
        ao.setPositiveButton("Sil", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

        VeriTabaniYardimcisi vt = new VeriTabaniYardimcisi(mContext);
        dao = new Kanallardao();
        dao.kanalSil(vt, kanallarListe.get(position).getKanal_id() );

        Toast.makeText(mContext, "Kanal Silindi", Toast.LENGTH_SHORT).show();

            }
        });

        ao.setNegativeButton("İptal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(mContext, "İşlem İptal Edildi", Toast.LENGTH_SHORT).show();

            }
        });
        ao.create().show();*/

                    new SweetAlertDialog(mContext, SweetAlertDialog.WARNING_TYPE)
                            .setTitleText("Kanalı Silmek İstediğinizden Emin Misiniz?")
                            .setConfirmText("Evet, Silinsin!")
                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sDialog) {
                                    VeriTabaniYardimcisi vt = new VeriTabaniYardimcisi(mContext);
                                    dao = new Kanallardao();
                                    dao.kanalSil(vt, kanallarListe.get(position).getKanal_id() );
                                    Toast.makeText(mContext, "Kanal Silindi", Toast.LENGTH_SHORT).show();
                                    sDialog.dismissWithAnimation();
                                    kanallarListe = dao.tumKanallar(vt);
                                    notifyDataSetChanged();
                                }
                            })
                            .setCancelButton("İptal", new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sDialog) {
                                    Toast.makeText(mContext, "İşlem İptal Edildi", Toast.LENGTH_SHORT).show();

                                    sDialog.dismissWithAnimation();
                                }
                            })
                            .show();
                }
            });


        }

        @Override
        public int getItemCount() {
            return kanallarListe.size();
        }


    }


