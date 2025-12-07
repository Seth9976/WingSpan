package com.voxelbusters.essentialkit.notificationservices;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.voxelbusters.essentialkit.notificationservices.datatypes.Notification;
import com.voxelbusters.essentialkit.notificationservices.datatypes.NotificationTrigger;
import com.voxelbusters.essentialkit.notificationservices.datatypes.TimeIntervalNotificationTrigger;
import com.voxelbusters.essentialkit.utilities.Logger;

public class AlarmBroadcastReceiver extends BroadcastReceiver {
    @Override  // android.content.BroadcastReceiver
    public void onReceive(Context context0, Intent intent0) {
        try {
            Bundle bundle0 = intent0.getBundleExtra("bundle");
            String s = bundle0.getString("EVENT_TYPE");
            Logger.debug("Received Alarm event ");
            if(s.equals("EVENT_FOR_NOTIFICATION")) {
                Notification notification0 = (Notification)bundle0.getParcelable("DATA");
                new NotificationDispatcher(context0, notification0).dispatch();
                NotificationStore.deleteScheduledNotification(context0, notification0);
                NotificationTrigger notificationTrigger0 = notification0.trigger;
                if(notificationTrigger0 != null && notificationTrigger0.repeat) {
                    if(notificationTrigger0 instanceof TimeIntervalNotificationTrigger) {
                        ((TimeIntervalNotificationTrigger)notificationTrigger0).updateStartTimestamp(System.currentTimeMillis());
                    }
                    new AlarmScheduler(context0).schedule(notification0, null);
                }
            }
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
            Logger.error(("Error on receiving Alarm notification : " + exception0));
        }
    }
}

