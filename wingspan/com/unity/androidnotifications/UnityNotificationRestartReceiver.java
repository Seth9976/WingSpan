package com.unity.androidnotifications;

import android.app.Notification.Builder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class UnityNotificationRestartReceiver extends BroadcastReceiver {
    private static final long EXPIRATION_TRESHOLD = 600000L;

    // 检测为 Lambda 实现
    static void lambda$onReceive$0(Context context0) [...]

    @Override  // android.content.BroadcastReceiver
    public void onReceive(Context context0, Intent intent0) {
        Log.d("UnityNotifications", "Rescheduling notifications after restart");
        if("android.intent.action.BOOT_COMPLETED".equals(intent0.getAction())) {
            AsyncTask.execute(() -> UnityNotificationRestartReceiver.rescheduleSavedNotifications(context0));
        }
    }

    private static boolean rescheduleNotification(UnityNotificationManager unityNotificationManager0, Date date0, Notification.Builder notification$Builder0) {
        try {
            Bundle bundle0 = notification$Builder0.getExtras();
            long v = bundle0.getLong("repeatInterval", 0L);
            long v1 = bundle0.getLong("fireTime", 0L);
            if(!new Date(v1).after(date0) && Long.compare(v, 0L) <= 0) {
                if(Long.compare(date0.getTime() - v1, 600000L) < 0) {
                    unityNotificationManager0.notify(bundle0.getInt("id"), notification$Builder0);
                    return true;
                }
                Log.d("UnityNotifications", "Notification expired, not rescheduling, ID: " + bundle0.getInt("id", -1));
                return false;
            }
            unityNotificationManager0.scheduleAlarmWithNotification(notification$Builder0);
            return true;
        }
        catch(Exception exception0) {
            Log.e("UnityNotifications", "Failed to reschedule notification", exception0);
            return false;
        }
    }

    private static void rescheduleSavedNotifications(Context context0) {
        UnityNotificationManager unityNotificationManager0 = UnityNotificationManager.getNotificationManagerImpl(context0);
        List list0 = unityNotificationManager0.loadSavedNotifications();
        Date date0 = Calendar.getInstance().getTime();
        for(Object object0: list0) {
            UnityNotificationRestartReceiver.rescheduleNotification(unityNotificationManager0, date0, ((Notification.Builder)object0));
        }
    }
}

