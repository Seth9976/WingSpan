package com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.Badger;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.ShortcutBadgeException;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.util.BroadcastHelper;
import java.util.Arrays;
import java.util.List;

public class NewHtcHomeBadger implements Badger {
    public static final String COUNT = "count";
    public static final String EXTRA_COMPONENT = "com.htc.launcher.extra.COMPONENT";
    public static final String EXTRA_COUNT = "com.htc.launcher.extra.COUNT";
    public static final String INTENT_SET_NOTIFICATION = "com.htc.launcher.action.SET_NOTIFICATION";
    public static final String INTENT_UPDATE_SHORTCUT = "com.htc.launcher.action.UPDATE_SHORTCUT";
    public static final String PACKAGENAME = "packagename";

    @Override  // com.onesignal.notifications.internal.badges.impl.shortcutbadger.Badger
    public void executeBadge(Context context0, ComponentName componentName0, int v) throws ShortcutBadgeException {
        Intent intent0 = new Intent("com.htc.launcher.action.SET_NOTIFICATION");
        intent0.putExtra("com.htc.launcher.extra.COMPONENT", componentName0.flattenToShortString());
        intent0.putExtra("com.htc.launcher.extra.COUNT", v);
        Intent intent1 = new Intent("com.htc.launcher.action.UPDATE_SHORTCUT");
        intent1.putExtra("packagename", componentName0.getPackageName());
        intent1.putExtra("count", v);
        if(!BroadcastHelper.canResolveBroadcast(context0, intent0) && !BroadcastHelper.canResolveBroadcast(context0, intent1)) {
            throw new ShortcutBadgeException("unable to resolve intent: " + intent1.toString());
        }
        context0.sendBroadcast(intent0);
        context0.sendBroadcast(intent1);
    }

    @Override  // com.onesignal.notifications.internal.badges.impl.shortcutbadger.Badger
    public List getSupportLaunchers() {
        return Arrays.asList(new String[]{"com.htc.launcher"});
    }
}

