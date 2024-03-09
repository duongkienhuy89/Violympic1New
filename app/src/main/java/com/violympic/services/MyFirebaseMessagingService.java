package com.violympic.services;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.Keep;
import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import com.violympic.toanlop1.MainActivity;
import com.violympic.toanlop1.R;


@Keep
public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "MyFirebaseMsgService";



    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // Log.e(TAG, "From: " + remoteMessage.getFrom());
        // Log.e(TAG, "Notification Message Body: " + remoteMessage.getNotification().getBody());
        Notify(remoteMessage.getNotification().getBody(),""+remoteMessage.getNotification().getTitle());
    }

    private NotificationManager mNotificationManager;
    private void Notify(String notificationTitle, String notificationMessage)
    {

    try {
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this.getApplicationContext(), "toancap1");
        Intent ii = new Intent(this.getApplicationContext(), MainActivity.class);
        PendingIntent pendingIntent ;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
            pendingIntent = PendingIntent.getActivity(this, 0, ii, PendingIntent.FLAG_MUTABLE);
        }else
        {
            pendingIntent = PendingIntent.getActivity(this, 0, ii, 0);
        }

        NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();
        bigText.bigText(""+notificationTitle);
        bigText.setBigContentTitle(""+notificationMessage);
        bigText.setSummaryText("Toán tiểu học");

        mBuilder.setAutoCancel(true);
        mBuilder.setContentIntent(pendingIntent);
        mBuilder.setSmallIcon(R.drawable.avata);
        mBuilder.setContentTitle(""+notificationMessage);
        mBuilder.setContentText(""+notificationTitle);
        mBuilder.setPriority(NotificationCompat.DEFAULT_LIGHTS);
        mBuilder.setStyle(bigText);


        mNotificationManager =
                (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);

// === Removed some obsoletes
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            String channelId = "toancap1";
            NotificationChannel channel = new NotificationChannel(
                    channelId,
                    "Channel human readable title",
                    NotificationManager.IMPORTANCE_HIGH);
            mNotificationManager.createNotificationChannel(channel);
            mBuilder.setChannelId(channelId);
        }

        mNotificationManager.notify(0, mBuilder.build());
        stopSelf();
    }catch (Exception exception)
    {

    }
    }



}
