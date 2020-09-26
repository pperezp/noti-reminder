package org.prezdev.notireminder.notification.listener;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;

import org.prezdev.notireminder.MainActivity;
import org.prezdev.notireminder.R;
import org.prezdev.notireminder.ui.gallery.GalleryFragment;
import org.prezdev.notireminder.ui.slideshow.SlideshowFragment;

// https://developer.android.com/training/notify-user/build-notification#java
// https://developer.android.com/guide/topics/ui/notifiers/notifications#Templates
public class NotificationTestOnClickListener implements View.OnClickListener {

    private Context context;
    private int id;

    public NotificationTestOnClickListener(Context context) {
        this.context = context;
        this.id = 0;
    }

    @Override
    public void onClick(View v) {
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.logo);

        String bigText =
            "Lorem Ipsum is simply dummy text of the " +
            "printing and typesetting industry. " +
            "Lorem Ipsum has been the industry's standard dummy " +
            "text ever since the 1500s, when an unknown printer " +
            "took a galley of type and scrambled it to make a type " +
            "specimen book. It has survived not only five centuries, " +
            "but also the leap into electronic typesetting, " +
            "remaining essentially unchanged. It was popularised " +
            "in the 1960s with the release of Letraset sheets " +
            "containing Lorem Ipsum passages, and more recently " +
            "with desktop publishing software like Aldus PageMaker " +
            "including versions of Lorem Ipsum";

        Intent intent = new Intent(context, MainActivity.class);

        intent.putExtra("option", 1);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

        /*
        Intent snoozeIntent = new Intent(context, MainActivity.class);

        snoozeIntent.setAction("ACTION_SNOOZE");
        snoozeIntent.putExtra("infoExtra", 0);

        PendingIntent snoozePendingIntent =
                PendingIntent.getBroadcast(context, 0, snoozeIntent, 0);
                */

        NotificationCompat.Builder builder = (NotificationCompat.Builder)
            new NotificationCompat.Builder(context, "channel1")
                .setSmallIcon(android.R.drawable.ic_lock_idle_alarm)
                .setLargeIcon(bitmap)
                .setContentTitle("Título de la notificación")
                .setContentText("Texto de la notificación")
                .setStyle(new NotificationCompat.BigTextStyle().bigText(bigText))
                // .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap).bigLargeIcon(null))
                .setContentInfo("4")
                //.setOngoing(true) // Notificación permanente*/
                //.setAutoCancel(true) // cuando haga click se cierra;
                .setContentIntent(pendingIntent);
                //.addAction(R.drawable.ic_menu_camera, "Cambiar wea", contIntent);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

        notificationManager.notify(++id, builder.build());
    }


}
