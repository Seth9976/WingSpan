package com.onesignal.notifications.internal.badges.impl.shortcutbadger;

import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.util.Log;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.AdwHomeBadger;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.ApexHomeBadger;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.AsusHomeBadger;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.DefaultBadger;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.EverythingMeHomeBadger;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.HuaweiHomeBadger;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.NewHtcHomeBadger;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.NovaHomeBadger;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.OPPOHomeBader;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.SamsungHomeBadger;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.SonyHomeBadger;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.VivoHomeBadger;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.ZukHomeBadger;
import java.util.LinkedList;
import java.util.List;

public final class ShortcutBadger {
    private static final List BADGERS = null;
    private static final String LOG_TAG = "ShortcutBadger";
    private static final int SUPPORTED_CHECK_ATTEMPTS = 3;
    private static ComponentName sComponentName;
    private static final Object sCounterSupportedLock;
    private static volatile Boolean sIsBadgeCounterSupported;
    private static Badger sShortcutBadger;

    static {
        LinkedList linkedList0 = new LinkedList();
        ShortcutBadger.BADGERS = linkedList0;
        ShortcutBadger.sCounterSupportedLock = new Object();
        linkedList0.add(AdwHomeBadger.class);
        linkedList0.add(ApexHomeBadger.class);
        linkedList0.add(NewHtcHomeBadger.class);
        linkedList0.add(NovaHomeBadger.class);
        linkedList0.add(SonyHomeBadger.class);
        linkedList0.add(AsusHomeBadger.class);
        linkedList0.add(HuaweiHomeBadger.class);
        linkedList0.add(OPPOHomeBader.class);
        linkedList0.add(SamsungHomeBadger.class);
        linkedList0.add(ZukHomeBadger.class);
        linkedList0.add(VivoHomeBadger.class);
        linkedList0.add(EverythingMeHomeBadger.class);
    }

    public static boolean applyCount(Context context0, int v) {
        try {
            ShortcutBadger.applyCountOrThrow(context0, v);
            return true;
        }
        catch(ShortcutBadgeException shortcutBadgeException0) {
            if(Log.isLoggable("ShortcutBadger", 3)) {
                Log.d("ShortcutBadger", "Unable to execute badge", shortcutBadgeException0);
            }
            return false;
        }
    }

    public static void applyCountOrThrow(Context context0, int v) throws ShortcutBadgeException {
        if(ShortcutBadger.sShortcutBadger == null && !ShortcutBadger.initBadger(context0)) {
            throw new ShortcutBadgeException("No default launcher available");
        }
        try {
            ShortcutBadger.sShortcutBadger.executeBadge(context0, ShortcutBadger.sComponentName, v);
        }
        catch(Exception exception0) {
            throw new ShortcutBadgeException("Unable to execute badge", exception0);
        }
    }

    public static void applyNotification(Context context0, Notification notification0, int v) {
        if(Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) {
            try {
                Object object0 = notification0.getClass().getDeclaredField("extraNotification").get(notification0);
                object0.getClass().getDeclaredMethod("setMessageCount", Integer.TYPE).invoke(object0, v);
            }
            catch(Exception exception0) {
                if(Log.isLoggable("ShortcutBadger", 3)) {
                    Log.d("ShortcutBadger", "Unable to execute badge", exception0);
                }
            }
        }
    }

    private static boolean initBadger(Context context0) {
        Badger badger0;
        Intent intent0 = context0.getPackageManager().getLaunchIntentForPackage("com.MonsterCouch.Wingspan");
        if(intent0 == null) {
            Log.e("ShortcutBadger", "Unable to find launch intent for package com.MonsterCouch.Wingspan");
            return false;
        }
        ShortcutBadger.sComponentName = intent0.getComponent();
        Intent intent1 = new Intent("android.intent.action.MAIN");
        intent1.addCategory("android.intent.category.HOME");
        ResolveInfo resolveInfo0 = context0.getPackageManager().resolveActivity(intent1, 0x10000);
        if(resolveInfo0 != null && !resolveInfo0.activityInfo.name.toLowerCase().contains("resolver")) {
            String s = resolveInfo0.activityInfo.packageName;
            for(Object object0: ShortcutBadger.BADGERS) {
                Class class0 = (Class)object0;
                try {
                    badger0 = null;
                    badger0 = (Badger)class0.newInstance();
                }
                catch(Exception unused_ex) {
                }
                if(badger0 != null && badger0.getSupportLaunchers().contains(s)) {
                    ShortcutBadger.sShortcutBadger = badger0;
                    break;
                }
                if(false) {
                    break;
                }
            }
            if(ShortcutBadger.sShortcutBadger == null) {
                if(Build.MANUFACTURER.equalsIgnoreCase("ZUK")) {
                    ShortcutBadger.sShortcutBadger = new ZukHomeBadger();
                    return true;
                }
                if(Build.MANUFACTURER.equalsIgnoreCase("OPPO")) {
                    ShortcutBadger.sShortcutBadger = new OPPOHomeBader();
                    return true;
                }
                if(Build.MANUFACTURER.equalsIgnoreCase("VIVO")) {
                    ShortcutBadger.sShortcutBadger = new VivoHomeBadger();
                    return true;
                }
                ShortcutBadger.sShortcutBadger = new DefaultBadger();
            }
            return true;
        }
        return false;
    }

    public static boolean isBadgeCounterSupported(Context context0) {
        if(ShortcutBadger.sIsBadgeCounterSupported == null) {
            Object object0 = ShortcutBadger.sCounterSupportedLock;
            __monitor_enter(object0);
            if(ShortcutBadger.sIsBadgeCounterSupported == null) {
                String s = null;
                int v = 0;
                while(true) {
                    if(v >= 3) {
                        goto label_19;
                    }
                    try {
                        try {
                            Log.i("ShortcutBadger", "Checking if platform supports badge counters, attempt " + String.format("%d/%d.", ((int)(v + 1)), 3));
                            if(ShortcutBadger.initBadger(context0)) {
                                ShortcutBadger.sShortcutBadger.executeBadge(context0, ShortcutBadger.sComponentName, 0);
                                ShortcutBadger.sIsBadgeCounterSupported = Boolean.TRUE;
                                Log.i("ShortcutBadger", "Badge counter is supported in this platform.");
                                goto label_19;
                            }
                            s = "Failed to initialize the badge counter.";
                        }
                        catch(Exception exception0) {
                            s = exception0.getMessage();
                        }
                        ++v;
                        continue;
                    label_19:
                        if(ShortcutBadger.sIsBadgeCounterSupported == null) {
                            Log.w("ShortcutBadger", "Badge counter seems not supported for this platform: " + s);
                            ShortcutBadger.sIsBadgeCounterSupported = Boolean.FALSE;
                        }
                        goto label_26;
                    }
                    catch(Throwable throwable0) {
                        break;
                    }
                }
                __monitor_exit(object0);
                throw throwable0;
            }
        label_26:
            __monitor_exit(object0);
            return ShortcutBadger.sIsBadgeCounterSupported.booleanValue();
        }
        return ShortcutBadger.sIsBadgeCounterSupported.booleanValue();
    }

    public static boolean removeCount(Context context0) {
        return ShortcutBadger.applyCount(context0, 0);
    }

    public static void removeCountOrThrow(Context context0) throws ShortcutBadgeException {
        ShortcutBadger.applyCountOrThrow(context0, 0);
    }
}

