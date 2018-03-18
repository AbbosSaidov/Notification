package com.example.insigame.notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    NotificationCompat.Builder notifciation;
    private  static final int UniqeID=2131233;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notifciation =new NotificationCompat.Builder(this);
        notifciation.setAutoCancel(true);
    }

    public void Note(View view){
        Uri alarmSound = RingtoneManager.getActualDefaultRingtoneUri(this, RingtoneManager.TYPE_NOTIFICATION);
        notifciation.setSound(alarmSound);
        notifciation.setSmallIcon(R.drawable.ic_launcher_background);
        notifciation.setTicker("Nmadr1");
        notifciation.setWhen(System.currentTimeMillis());
        notifciation.setContentTitle("Nmadr2");
        notifciation.setContentText("Nmadr2");


        Intent intent =new Intent(this,MainActivity.class);
        PendingIntent pendingIntent =PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        notifciation.setContentIntent(pendingIntent);

        //
        NotificationManager notificationManager =(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (notificationManager != null) {
            notificationManager.notify(UniqeID,notifciation.build());
        }


    }
}
