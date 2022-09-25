package com.myappgensatsun;

import static android.app.NotificationManager.IMPORTANCE_HIGH;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;

public class NotificationActivity extends AppCompatActivity {

    Button btnNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        btnNotification = findViewById(R.id.btn_notification);
        btnNotification.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {

                Intent i = new Intent(NotificationActivity.this, CustomGridViewActivity.class);
                PendingIntent pendingIntent =
                        PendingIntent.getActivity(NotificationActivity.this, 1, i, PendingIntent.FLAG_ONE_SHOT);

                NotificationChannel notificationChannel =
                        new NotificationChannel("Channel_ID", "Channel_NAME", IMPORTANCE_HIGH);
                NotificationCompat.Builder builder = new NotificationCompat.Builder(NotificationActivity.this);
                builder.setSmallIcon(R.drawable.dolphin_icon);
                builder.setContentTitle("MyAPPGEN_SAT_SUN");
                builder.setContentText("Today Lecture time is 12 PM");
                builder.setContentIntent(pendingIntent);
                builder.setChannelId("Channel_ID");

                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.createNotificationChannel(notificationChannel);
                notificationManager.notify(1,builder.build());

            }
        });
    }
}