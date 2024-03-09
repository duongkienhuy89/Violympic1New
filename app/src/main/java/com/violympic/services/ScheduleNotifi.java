package com.violympic.services;



import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.Keep;
import androidx.core.app.NotificationCompat;

import com.violympic.toanlop1.MainActivity;
import com.violympic.toanlop1.R;


@Keep
public class ScheduleNotifi extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        // int sessionId = intent.getIntExtra("NOTIFIID",0);

        //Log.e("NOTIFIID:",""+sessionId);
        // ShowNotifi(context,sessionId);
        Notify(context);
    }


    private NotificationManager mNotificationManager;
    private void Notify(Context context){

        try {
            NotificationCompat.Builder mBuilder =
                    new NotificationCompat.Builder(context.getApplicationContext(), "toancap1");
            Intent ii = new Intent(context.getApplicationContext(), MainActivity.class);
            ii.putExtra("mc","xuanbacchimco");
            ii.setAction(Long.toString(System.currentTimeMillis()));
            PendingIntent pendingIntent ;

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
                pendingIntent = PendingIntent.getActivity(context, 0, ii,  PendingIntent.FLAG_MUTABLE);
            }else
            {
                pendingIntent = PendingIntent.getActivity(context, 0, ii, 0);
            }


            NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();
            bigText.bigText(context.getString(R.string.notifi_title));
            bigText.setBigContentTitle(context.getString(R.string.notifi_content));
            bigText.setSummaryText("Math KID");

            mBuilder.setAutoCancel(true);
            mBuilder.setContentIntent(pendingIntent);
            mBuilder.setSmallIcon(R.drawable.avata);
            mBuilder.setContentTitle(context.getString(R.string.notifi_content));
            mBuilder.setContentText(context.getString(R.string.notifi_title));
            mBuilder.setPriority(NotificationCompat.DEFAULT_LIGHTS);
            mBuilder.setStyle(bigText);


            mNotificationManager =
                    (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

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
        }catch (Exception exception)
        {

        }

    }

}
