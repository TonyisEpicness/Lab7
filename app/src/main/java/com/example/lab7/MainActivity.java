package com.example.lab7;

import static com.example.lab7.App.CHANNEL_1_ID;
import static com.example.lab7.App.CHANNEL_2_ID;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManager;
    private EditText title;
    private EditText message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = findViewById(R.id.notiTitle);
        message = findViewById(R.id.notiMessage);
        notificationManager = NotificationManagerCompat.from(this);
    }

    public void channel1(View v) {
        String t = title.getText().toString();
        String m = message.getText().toString();

        Intent activityIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this,
                0, activityIntent, 0);

        Intent broadcast = new Intent(this, NotiReceiver.class);
        broadcast.putExtra("toastMessage", m);
        PendingIntent action = PendingIntent.getBroadcast(this,
                0, broadcast, PendingIntent.FLAG_UPDATE_CURRENT);


        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_baseline_chat_24)
                .setContentTitle(t)
                .setContentText(m)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setColor(Color.BLUE)
                .setContentIntent(contentIntent)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .addAction(R.mipmap.ic_launcher, "Toast", action)
                .build();
        notificationManager.notify(1, notification);
    }

    public void channel2(View v) {
        String t = title.getText().toString();
        String m = message.getText().toString();

        Intent activityIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this,
                0, activityIntent, 0);

        Intent broadcast = new Intent(this, NotiReceiver.class);
        broadcast.putExtra("toastMessage", m);
        PendingIntent action = PendingIntent.getBroadcast(this,
                0, broadcast, PendingIntent.FLAG_UPDATE_CURRENT);


        Notification notification = new NotificationCompat.Builder(this, CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_baseline_chat_24)
                .setContentTitle(t)
                .setContentText(m)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setColor(Color.BLUE)
                .setContentIntent(contentIntent)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .addAction(R.mipmap.ic_launcher, "Toast", action)
                .build();
        notificationManager.notify(1, notification);
    }
}