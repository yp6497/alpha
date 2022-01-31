package com.example.alpha;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

 class help extends Application {

    public static final String CHANNEL_ID = "channel";

    @Override
    public void onCreate() {
        super.onCreate();


        createNotificationChannels();
    }


    private void createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "Channel",
                    NotificationManager.IMPORTANCE_LOW
            );

            channel.setDescription("This is a notification");
            NotificationManager m = getSystemService(NotificationManager.class);
            m.createNotificationChannel(channel);
        }
    }
}