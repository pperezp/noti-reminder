package org.prezdev.notireminder.notification.channel;

import android.app.NotificationChannel;

import java.util.List;

public interface NotificationChannelService{
    List<NotificationChannel> getNotificationChannels();
}
