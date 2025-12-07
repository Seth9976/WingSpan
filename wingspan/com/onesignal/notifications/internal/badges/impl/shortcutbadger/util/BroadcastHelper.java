package com.onesignal.notifications.internal.badges.impl.shortcutbadger.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.ShortcutBadgeException;
import java.util.Collections;
import java.util.List;

public class BroadcastHelper {
    public static boolean canResolveBroadcast(Context context0, Intent intent0) {
        List list0 = context0.getPackageManager().queryBroadcastReceivers(intent0, 0);
        return list0 != null && list0.size() > 0;
    }

    public static List resolveBroadcast(Context context0, Intent intent0) {
        List list0 = context0.getPackageManager().queryBroadcastReceivers(intent0, 0);
        return list0 == null ? Collections.emptyList() : list0;
    }

    public static void sendIntentExplicitly(Context context0, Intent intent0) throws ShortcutBadgeException {
        List list0 = BroadcastHelper.resolveBroadcast(context0, intent0);
        if(list0.size() == 0) {
            throw new ShortcutBadgeException("unable to resolve intent: " + intent0.toString());
        }
        for(Object object0: list0) {
            ResolveInfo resolveInfo0 = (ResolveInfo)object0;
            Intent intent1 = new Intent(intent0);
            if(resolveInfo0 != null) {
                intent1.setPackage(resolveInfo0.resolvePackageName);
                context0.sendBroadcast(intent1);
            }
        }
    }
}

