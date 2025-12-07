package androidx.browser.trusted;

import android.app.Notification.Builder;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;

class NotificationApiHelperForO {
    static Notification copyNotificationOntoChannel(Context context, NotificationManager manager, Notification notification, String channelId, String channelName) {
        manager.createNotificationChannel(new NotificationChannel(channelId, channelName, 3));
        if(manager.getNotificationChannel(channelId).getImportance() == 0) {
            return null;
        }
        Notification.Builder notification$Builder0 = Notification.Builder.recoverBuilder(context, notification);
        notification$Builder0.setChannelId(channelId);
        return notification$Builder0.build();
    }

    static boolean isChannelEnabled(NotificationManager manager, String channelId) {
        NotificationChannel notificationChannel0 = manager.getNotificationChannel(channelId);
        return notificationChannel0 == null || notificationChannel0.getImportance() != 0;
    }
}

