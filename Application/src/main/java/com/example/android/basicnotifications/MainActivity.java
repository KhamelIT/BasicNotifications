package com.example.android.basicnotifications;

import android.app.Activity;
import android.app.Notification;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.view.View;

/**
 * The entry point to the BasicNotification sample.
 */
public class MainActivity extends Activity {
    /**
     * A numeric value that identifies the notification that we'll be sending.
     * This value needs to be unique within this app, but it doesn't need to be
     * unique system-wide.
     */
    public static final int NOTIFICATION_ID = 1;

    public static final String EXTRA_VOICE_REPLY = "extra_voice_reply";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_layout);

    }

    /**
     * Send a sample notification using the NotificationCompat API.
     */
    public void sendNotification(View view) {

       // String replyLabel = getResources().getString(R.string.reply_label);
//
       // RemoteInput remoteInput = new RemoteInput.Builder(EXTRA_VOICE_REPLY)
       //         .setLabel(replyLabel)
       //         .build();
//
       // //pending intent
       // Intent replyIntent = new Intent(this, ReplyActivity.class);
       // PendingIntent replyPendingIntent = PendingIntent.getActivity(this, 0 , replyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
//
       // //action
       // NotificationCompat.Action action = new NotificationCompat.Action.Builder(R.drawable.reply,
       //         getString(R.string.label), replyPendingIntent)
       //         .addRemoteInput(remoteInput)
       //         .build();
//
       // //bitmap
       // Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
       //         R.drawable.pappagallo);
//
       // //style for second notif
       // NotificationCompat.BigTextStyle secondPageStyle = new NotificationCompat.BigTextStyle();
       // secondPageStyle.setBigContentTitle("Page 2")
       //         .bigText("A lot of text...");
//
       // //notif 1
       // NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
       //         .setContentTitle("New mail from me")
       //         .setContentText("hola")
       //         .setSmallIcon(R.drawable.pappagallo)
       //         .extend(new NotificationCompat.WearableExtender()
       //                 .setBackground(bitmap).addAction(action));
       // //notif 2
       // Notification secondPageNotification = new NotificationCompat.Builder(this)
       //         .setStyle(secondPageStyle)
       //         .build();
//
       // Notification notification = builder.extend(new NotificationCompat.WearableExtender()
       // .addPage(secondPageNotification))
       //         .build();
//
//
       // NotificationManagerCompat notificationManager =
       //         NotificationManagerCompat.from(this);
       // notificationManager.notify(42, notification);

        // Create builder for the main notification
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setContentTitle("Page 1")
                        .setContentText("Short message");

// Create a big text style for the second page
        NotificationCompat.BigTextStyle secondPageStyle = new NotificationCompat.BigTextStyle();
        secondPageStyle.setBigContentTitle("Page 2")
                .bigText("A lot of text...");

// Create second page notification
        Notification secondPageNotification =
                new NotificationCompat.Builder(this)
                        .setStyle(secondPageStyle)
                        .build();

// Extend the notification builder with the second page
        Notification notification = notificationBuilder
                .extend(new NotificationCompat.WearableExtender()
                        .addPage(secondPageNotification))
                .build();

// Issue the notification
        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(this);
        notificationManager.notify(1000, notification);
    }
}
