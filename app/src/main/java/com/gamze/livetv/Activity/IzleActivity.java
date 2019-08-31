package com.gamze.livetv.Activity;

import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.gamze.livetv.R;
import com.gamze.livetv.VeriTabaniYardimcisi;


public class IzleActivity extends AppCompatActivity {
  //private String videoUrl = "http://dreamstariptv.live:25461/lKeq2jQpvc/GN1xw5o4bt/3807";
  private VeriTabaniYardimcisi vt;
  private ProgressDialog pd;
  VideoView videoView;
  String url = "";

  public static void cancelNotification(Context ctx, int notifyId) {
    String ns = Context.NOTIFICATION_SERVICE;
    NotificationManager nMgr = (NotificationManager) ctx.getSystemService(ns);
    nMgr.cancel(notifyId);
  }


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_izle);



    videoView =  findViewById(R.id.videoView);
    pd = new ProgressDialog(this);
    pd.setMessage("Buffering...");
    pd.setCancelable(true);

    if(this.getIntent() != null){
      url = this.getIntent().getStringExtra("link");
    }

    playVideo();

  }

  private void playVideo() {

    try{
      getWindow().setFormat(PixelFormat.TRANSLUCENT);
      MediaController mediaController = new MediaController(this);
      mediaController.setAnchorView(videoView);

      Uri videoUri = Uri.parse(url);

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
  }

}
