package com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl;

import android.app.Notification.Builder;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Build;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.Badger;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.ShortcutBadgeException;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.util.BroadcastHelper;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

@Deprecated
public class XiaomiHomeBadger implements Badger {
    public static final String EXTRA_UPDATE_APP_COMPONENT_NAME = "android.intent.extra.update_application_component_name";
    public static final String EXTRA_UPDATE_APP_MSG_TEXT = "android.intent.extra.update_application_message_text";
    public static final String INTENT_ACTION = "android.intent.action.APPLICATION_MESSAGE_UPDATE";
    private ResolveInfo resolveInfo;

    @Override  // com.onesignal.notifications.internal.badges.impl.shortcutbadger.Badger
    public void executeBadge(Context context0, ComponentName componentName0, int v) throws ShortcutBadgeException {
        String s1;
        String s = "";
        try {
            Object object0 = Class.forName("android.app.MiuiNotification").newInstance();
            Field field0 = object0.getClass().getDeclaredField("messageCount");
            field0.setAccessible(true);
            if(v == 0) {
                s1 = "";
            }
            else {
                try {
                    s1 = v;
                label_8:
                    field0.set(object0, String.valueOf(s1));
                    goto label_19;
                }
                catch(Exception unused_ex) {
                }
                goto label_10;
            }
            goto label_8;
        label_10:
            field0.set(object0, v);
        }
        catch(Exception unused_ex) {
            Intent intent0 = new Intent("android.intent.action.APPLICATION_MESSAGE_UPDATE");
            intent0.putExtra("android.intent.extra.update_application_component_name", componentName0.getPackageName() + "/" + componentName0.getClassName());
            if(v != 0) {
                s = v;
            }
            intent0.putExtra("android.intent.extra.update_application_message_text", String.valueOf(s));
            if(BroadcastHelper.canResolveBroadcast(context0, intent0)) {
                context0.sendBroadcast(intent0);
            }
        }
    label_19:
        if(Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) {
            this.tryNewMiuiBadge(context0, v);
        }
    }

    @Override  // com.onesignal.notifications.internal.badges.impl.shortcutbadger.Badger
    public List getSupportLaunchers() {
        return Arrays.asList(new String[]{"com.miui.miuilite", "com.miui.home", "com.miui.miuihome", "com.miui.miuihome2", "com.miui.mihome", "com.miui.mihome2", "com.i.miui.launcher"});
    }

    private void tryNewMiuiBadge(Context context0, int v) throws ShortcutBadgeException {
        if(this.resolveInfo == null) {
            Intent intent0 = new Intent("android.intent.action.MAIN");
            intent0.addCategory("android.intent.category.HOME");
            this.resolveInfo = context0.getPackageManager().resolveActivity(intent0, 0x10000);
        }
        if(this.resolveInfo != null) {
            NotificationManager notificationManager0 = (NotificationManager)context0.getSystemService("notification");
            Notification notification0 = new Notification.Builder(context0).setContentTitle("").setContentText("").setSmallIcon(this.resolveInfo.getIconResource()).build();
            try {
                Object object0 = notification0.getClass().getDeclaredField("extraNotification").get(notification0);
                object0.getClass().getDeclaredMethod("setMessageCount", Integer.TYPE).invoke(object0, v);
                notificationManager0.notify(0, notification0);
            }
            catch(Exception exception0) {
                throw new ShortcutBadgeException("not able to set badge", exception0);
            }
        }
    }
}

