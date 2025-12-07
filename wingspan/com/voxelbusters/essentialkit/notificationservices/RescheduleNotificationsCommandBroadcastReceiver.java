package com.voxelbusters.essentialkit.notificationservices;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.voxelbusters.essentialkit.notificationservices.datatypes.Notification;
import com.voxelbusters.essentialkit.utilities.Logger;

public class RescheduleNotificationsCommandBroadcastReceiver extends BroadcastReceiver {
    @Override  // android.content.BroadcastReceiver
    public void onReceive(Context context0, Intent intent0) {
        try {
            Logger.debug(("Received request for rescheduling notifications..." + intent0.getAction()));
            for(Object object0: NotificationStore.getScheduledNotifications(context0)) {
                new AlarmScheduler(context0).schedule(((Notification)object0), null);
            }
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
            Logger.error("Error on Reschedule Notifications Command broadcast receiver");
        }
    }
}

