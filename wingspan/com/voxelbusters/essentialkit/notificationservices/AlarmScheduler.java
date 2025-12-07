package com.voxelbusters.essentialkit.notificationservices;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.voxelbusters.essentialkit.notificationservices.datatypes.CalendarNotificationTrigger;
import com.voxelbusters.essentialkit.notificationservices.datatypes.Notification;
import com.voxelbusters.essentialkit.notificationservices.datatypes.NotificationTrigger;
import com.voxelbusters.essentialkit.notificationservices.datatypes.TimeIntervalNotificationTrigger;
import com.voxelbusters.essentialkit.utilities.Logger;
import com.voxelbusters.essentialkit.utilities.ResourcesUtil;
import java.util.Date;

public class AlarmScheduler {
    public static String ALARM_EVENT_FOR_NOTIFICATION = "EVENT_FOR_NOTIFICATION";
    public static String DATA = "DATA";
    public static String EVENT_TYPE = "EVENT_TYPE";
    public final String TAG;
    private Context context;

    public AlarmScheduler(Context context0) {
        this.TAG = "[Native Plugins : AlarmEventReceiver]";
        this.context = context0;
    }

    public void cancel(Notification notification0) {
        Intent intent0 = new Intent(this.context, AlarmBroadcastReceiver.class);
        String s = notification0.getPersistenceId();
        intent0.setData(Uri.parse(("custom://" + s)));
        intent0.setAction(s);
        PendingIntent pendingIntent0 = PendingIntent.getBroadcast(this.context, 0, intent0, (Build.VERSION.SDK_INT <= 30 ? 0x10000000 : 0x14000000));
        AlarmManager alarmManager0 = (AlarmManager)this.context.getSystemService("alarm");
        Logger.debug((pendingIntent0 + " " + Uri.parse(("custom://" + s))));
        if(pendingIntent0 != null) {
            alarmManager0.cancel(pendingIntent0);
        }
        pendingIntent0.cancel();
        NotificationStore.deleteScheduledNotification(this.context, notification0);
    }

    public void cancel(String s) {
        Notification notification0 = null;
        for(Object object0: NotificationStore.getScheduledNotifications(this.context)) {
            Notification notification1 = (Notification)object0;
            if(notification1.id.equals(s)) {
                notification0 = notification1;
                break;
            }
        }
        if(notification0 != null) {
            this.cancel(notification0);
            NotificationStore.deleteScheduledNotification(this.context, notification0);
        }
    }

    public void schedule(Notification notification0, IScheduleNotificationListener iNotificationServices$IScheduleNotificationListener0) {
        try {
            this.cancel(notification0.id);
            Intent intent0 = new Intent(this.context, AlarmBroadcastReceiver.class);
            intent0.setData(Uri.parse(("custom://" + notification0.getPersistenceId())));
            intent0.setAction(notification0.getPersistenceId());
            Bundle bundle0 = new Bundle();
            bundle0.putParcelable("DATA", notification0);
            bundle0.putString("EVENT_TYPE", "EVENT_FOR_NOTIFICATION");
            intent0.putExtra("bundle", bundle0);
            int v = Build.VERSION.SDK_INT;
            PendingIntent pendingIntent0 = PendingIntent.getBroadcast(this.context.getApplicationContext(), 0, intent0, (v <= 30 ? 0 : 0x4000000));
            AlarmManager alarmManager0 = (AlarmManager)this.context.getSystemService("alarm");
            Date date0 = new Date(System.currentTimeMillis());
            NotificationTrigger notificationTrigger0 = notification0.trigger;
            if(notificationTrigger0 != null) {
                if(notificationTrigger0 instanceof TimeIntervalNotificationTrigger) {
                    date0 = ((TimeIntervalNotificationTrigger)notificationTrigger0).getNextTriggerDate();
                }
                else if(notificationTrigger0 instanceof CalendarNotificationTrigger) {
                    date0 = ((CalendarNotificationTrigger)notificationTrigger0).getNextTriggerDate();
                }
            }
            System.out.println("Alarm scheduling in secs : " + ((float)(date0.getTime() - System.currentTimeMillis())) / 1000.0f);
            if(v < 0x1F || ResourcesUtil.getBoolean(this.context, "NOTIFICATION_SERVICES_ALLOW_IN_EXACT_TIME_SCHEDULING") || !alarmManager0.canScheduleExactAlarms()) {
                alarmManager0.setAndAllowWhileIdle(0, date0.getTime(), pendingIntent0);
            }
            else {
                alarmManager0.setExactAndAllowWhileIdle(0, date0.getTime(), pendingIntent0);
            }
            NotificationStore.saveScheduledNotification(this.context, notification0);
            if(iNotificationServices$IScheduleNotificationListener0 != null) {
                iNotificationServices$IScheduleNotificationListener0.onSuccess();
            }
        }
        catch(Exception exception0) {
            Logger.error(("Failed scheduling notification : " + exception0.getMessage()));
            if(iNotificationServices$IScheduleNotificationListener0 != null) {
                iNotificationServices$IScheduleNotificationListener0.onFailure("Failed scheduling notification");
            }
        }
    }
}

