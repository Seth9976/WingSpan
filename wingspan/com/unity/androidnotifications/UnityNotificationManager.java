package com.unity.androidnotifications;

import android.app.Activity;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.Notification.BigPictureStyle;
import android.app.Notification.Builder;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import com.unity3d.player.UnityPlayer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class UnityNotificationManager extends BroadcastReceiver {
    public static final String KEY_BIG_CONTENT_DESCRIPTION = "com.unity.BigContentDescription";
    public static final String KEY_BIG_CONTENT_TITLE = "com.unity.BigContentTytle";
    public static final String KEY_BIG_LARGE_ICON = "com.unity.BigLargeIcon";
    public static final String KEY_BIG_PICTURE = "com.unity.BigPicture";
    public static final String KEY_BIG_SHOW_WHEN_COLLAPSED = "com.unity.BigShowWhenCollapsed";
    public static final String KEY_BIG_SUMMARY_TEXT = "com.unity.BigSummaryText";
    public static final String KEY_CHANNEL_ID = "channelID";
    public static final String KEY_FIRE_TIME = "fireTime";
    public static final String KEY_ID = "id";
    public static final String KEY_INTENT_DATA = "data";
    public static final String KEY_LARGE_ICON = "largeIcon";
    public static final String KEY_NOTIFICATION = "unityNotification";
    public static final String KEY_NOTIFICATION_DISMISSED = "com.unity.NotificationDismissed";
    public static final String KEY_NOTIFICATION_ID = "com.unity.NotificationID";
    public static final String KEY_REPEAT_INTERVAL = "repeatInterval";
    public static final String KEY_SHOW_IN_FOREGROUND = "com.unity.showInForeground";
    public static final String KEY_SMALL_ICON = "smallIcon";
    static final String NOTIFICATION_CHANNELS_SHARED_PREFS = "UNITY_NOTIFICATIONS";
    static final String NOTIFICATION_CHANNELS_SHARED_PREFS_KEY = "ChannelIDs";
    static final String NOTIFICATION_IDS_SHARED_PREFS = "UNITY_STORED_NOTIFICATION_IDS";
    static final String NOTIFICATION_IDS_SHARED_PREFS_KEY = "UNITY_NOTIFICATION_IDS";
    private static final int PERMISSION_STATUS_ALLOWED = 1;
    private static final int PERMISSION_STATUS_DENIED = 2;
    private static final int PERMISSION_STATUS_NOTIFICATIONS_BLOCKED_FOR_APP = 5;
    static final String TAG_UNITY = "UnityNotifications";
    private Activity mActivity;
    private UnityNotificationBackgroundThread mBackgroundThread;
    private Context mContext;
    private int mExactSchedulingSetting;
    private NotificationCallback mNotificationCallback;
    private Class mOpenActivity;
    private Random mRandom;
    private ConcurrentHashMap mScheduledNotifications;
    static UnityNotificationManager mUnityNotificationManager;
    private HashSet mVisibleNotifications;

    public UnityNotificationManager() {
        this.mContext = null;
        this.mActivity = null;
        this.mOpenActivity = null;
        this.mExactSchedulingSetting = -1;
    }

    public int areNotificationsEnabled() {
        boolean z = Build.VERSION.SDK_INT < 33 || this.mContext.checkCallingOrSelfPermission("android.permission.POST_NOTIFICATIONS") == 0;
        boolean z1 = this.getNotificationManager().areNotificationsEnabled();
        if(z) {
            return z1 ? 1 : 5;
        }
        return 2;
    }

    private Notification buildNotificationForSending(Class class0, Notification.Builder notification$Builder0) {
        int v = notification$Builder0.getExtras().getInt("id", -1);
        Intent intent0 = new Intent(this.mContext, class0);
        intent0.addFlags(0x30000000);
        intent0.putExtra("com.unity.NotificationID", v);
        notification$Builder0.setContentIntent(this.getActivityPendingIntent(v, intent0, 0));
        this.finalizeNotificationForDisplay(notification$Builder0);
        return notification$Builder0.build();
    }

    private Intent buildNotificationIntent() {
        Intent intent0 = new Intent(this.mContext, UnityNotificationManager.class);
        intent0.setFlags(0x10008000);
        return intent0;
    }

    private boolean canScheduleExactAlarms(AlarmManager alarmManager0) {
        if(this.mExactSchedulingSetting < 0) {
            Bundle bundle0 = this.getAppMetadata();
            if(bundle0 != null) {
                this.mExactSchedulingSetting = bundle0.getInt("com.unity.androidnotifications.exact_scheduling", 1);
            }
        }
        if(this.mExactSchedulingSetting == 0) {
            return false;
        }
        return Build.VERSION.SDK_INT >= 0x1F ? alarmManager0.canScheduleExactAlarms() : true;
    }

    public boolean canScheduleExactAlarms() {
        return this.canScheduleExactAlarms(((AlarmManager)this.mContext.getSystemService("alarm")));
    }

    public void cancelAllNotifications() {
        this.getNotificationManager().cancelAll();
    }

    public void cancelAllPendingNotificationIntents() {
        this.mBackgroundThread.enqueueCancelAllNotifications();
    }

    public void cancelDisplayedNotification(int v) {
        this.getNotificationManager().cancel(v);
    }

    public void cancelPendingNotification(int v) {
        this.mBackgroundThread.enqueueCancelNotification(v);
    }

    void cancelPendingNotificationIntent(int v) {
        PendingIntent pendingIntent0 = this.getBroadcastPendingIntent(v, new Intent(this.mContext, UnityNotificationManager.class), 0x20000000);
        if(pendingIntent0 != null) {
            ((AlarmManager)this.mContext.getSystemService("alarm")).cancel(pendingIntent0);
            pendingIntent0.cancel();
        }
    }

    public boolean checkIfPendingNotificationIsRegistered(int v) {
        return this.getBroadcastPendingIntent(v, new Intent(this.mActivity, UnityNotificationManager.class), 0x20000000) != null;
    }

    public int checkNotificationStatus(int v) {
        StatusBarNotification[] arr_statusBarNotification = this.getNotificationManager().getActiveNotifications();
        for(int v1 = 0; v1 < arr_statusBarNotification.length; ++v1) {
            if(v == arr_statusBarNotification[v1].getId()) {
                return 2;
            }
        }
        if(this.mScheduledNotifications.containsKey(v)) {
            return 1;
        }
        return this.checkIfPendingNotificationIsRegistered(v) ? 1 : 0;
    }

    public Notification.Builder createNotificationBuilder(String s) {
        if(Build.VERSION.SDK_INT < 26) {
            Notification.Builder notification$Builder0 = new Notification.Builder(this.mContext);
            NotificationChannelWrapper notificationChannelWrapper0 = this.getNotificationChannel(s);
            int v = -1;
            if(notificationChannelWrapper0.vibrationPattern == null || notificationChannelWrapper0.vibrationPattern.length <= 0) {
                notification$Builder0.setDefaults(-1);
            }
            else {
                notification$Builder0.setDefaults(5);
                notification$Builder0.setVibrate(notificationChannelWrapper0.vibrationPattern);
            }
            notification$Builder0.setVisibility(notificationChannelWrapper0.lockscreenVisibility);
            switch(notificationChannelWrapper0.importance) {
                case 0: {
                    v = -2;
                    break;
                }
                case 2: {
                    break;
                }
                case 4: {
                    v = 2;
                    break;
                }
                default: {
                    v = 0;
                }
            }
            notification$Builder0.setPriority(v);
            notification$Builder0.getExtras().putString("channelID", s);
            return notification$Builder0;
        }
        return new Notification.Builder(this.mContext, s);
    }

    void deleteExpiredNotificationIntent(String s) {
        synchronized(this) {
            this.mContext.getSharedPreferences(UnityNotificationManager.getSharedPrefsNameByNotificationId(s), 0).edit().clear().apply();
        }
    }

    public void deleteNotificationChannel(String s) {
        if(Build.VERSION.SDK_INT >= 26) {
            this.getNotificationManager().deleteNotificationChannel(s);
            return;
        }
        SharedPreferences sharedPreferences0 = this.mContext.getSharedPreferences("UNITY_NOTIFICATIONS", 0);
        Set set0 = sharedPreferences0.getStringSet("ChannelIDs", new HashSet());
        if(!set0.contains(s)) {
            return;
        }
        HashSet hashSet0 = new HashSet(set0);
        hashSet0.remove(s);
        SharedPreferences.Editor sharedPreferences$Editor0 = sharedPreferences0.edit().clear();
        sharedPreferences$Editor0.putStringSet("ChannelIDs", hashSet0);
        sharedPreferences$Editor0.apply();
        this.mContext.getSharedPreferences(UnityNotificationManager.getSharedPrefsNameByChannelId(s), 0).edit().clear().apply();
    }

    public void deleteNotificationChannelGroup(String s) {
        if(s == null) {
            return;
        }
        if(Build.VERSION.SDK_INT >= 26) {
            this.getNotificationManager().deleteNotificationChannelGroup(s);
            return;
        }
        NotificationChannelWrapper[] arr_notificationChannelWrapper = this.getNotificationChannels();
        for(int v = 0; v < arr_notificationChannelWrapper.length; ++v) {
            NotificationChannelWrapper notificationChannelWrapper0 = arr_notificationChannelWrapper[v];
            if(s.equals(notificationChannelWrapper0.group)) {
                this.deleteNotificationChannel(notificationChannelWrapper0.id);
            }
        }
    }

    private Notification.Builder deserializeNotificationBuilder(Integer integer0) {
        SharedPreferences sharedPreferences0 = this.mContext.getSharedPreferences(UnityNotificationManager.getSharedPrefsNameByNotificationId(integer0.toString()), 0);
        Object object0 = UnityNotificationUtilities.deserializeNotification(this.mContext, sharedPreferences0);
        if(object0 == null) {
            return null;
        }
        return object0 instanceof Notification ? UnityNotificationUtilities.recoverBuilder(this.mContext, ((Notification)object0)) : ((Notification.Builder)object0);
    }

    private void finalizeNotificationForDisplay(Notification.Builder notification$Builder0) {
        String s = notification$Builder0.getExtras().getString("smallIcon");
        Object object0 = this.getIconForUri(s);
        if(object0 == null) {
            int v = UnityNotificationUtilities.findResourceIdInContextByName(this.mContext, s);
            if(v == 0) {
                v = this.mContext.getApplicationInfo().icon;
            }
            notification$Builder0.setSmallIcon(v);
        }
        else {
            notification$Builder0.setSmallIcon(((Icon)object0));
        }
        Object object1 = this.getIcon(notification$Builder0.getExtras().getString("largeIcon"));
        if(object1 != null) {
            if(object1 instanceof Icon) {
                notification$Builder0.setLargeIcon(((Icon)object1));
            }
            else {
                notification$Builder0.setLargeIcon(((Bitmap)object1));
            }
        }
        this.setupBigPictureStyle(notification$Builder0);
    }

    private Set findInvalidNotificationIds(Set set0) {
        Intent intent0 = this.buildNotificationIntent();
        Set set1 = new HashSet();
        for(Object object0: set0) {
            String s = (String)object0;
            if(this.getBroadcastPendingIntent(((int)Integer.valueOf(s)), intent0, 0x20000000) == null) {
                ((HashSet)set1).add(s);
            }
        }
        StatusBarNotification[] arr_statusBarNotification = this.getNotificationManager().getActiveNotifications();
        for(int v = 0; v < arr_statusBarNotification.length; ++v) {
            ((HashSet)set1).remove(String.valueOf(arr_statusBarNotification[v].getId()));
        }
        if(UnityPlayer.currentActivity != null) {
            Intent intent1 = UnityPlayer.currentActivity.getIntent();
            if(intent1.hasExtra("com.unity.NotificationID")) {
                ((HashSet)set1).remove(String.valueOf(intent1.getExtras().getInt("com.unity.NotificationID")));
            }
        }
        return set1;
    }

    private int generateUniqueId() {
        int v = 0;
        do {
            v += this.mRandom.nextInt(1000);
        }
        while(this.mScheduledNotifications.containsKey(v));
        return v;
    }

    private PendingIntent getActivityPendingIntent(int v, Intent intent0, int v1) {
        return PendingIntent.getActivity(this.mContext, v, intent0, v1 | 0x4000000);
    }

    private Bundle getAppMetadata() {
        try {
            return this.mContext.getPackageManager().getApplicationInfo("com.MonsterCouch.Wingspan", 0x80).metaData;
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
            return null;
        }
    }

    private PendingIntent getBroadcastPendingIntent(int v, Intent intent0, int v1) {
        return PendingIntent.getBroadcast(this.mContext, v, intent0, v1 | 0x4000000);
    }

    private Object getIcon(String s) {
        if(s != null && s.length() != 0) {
            if(s.charAt(0) == 0x2F) {
                return BitmapFactory.decodeFile(s);
            }
            Object object0 = this.getIconForUri(s);
            return object0 == null ? this.getIconFromResources(s, false) : object0;
        }
        return null;
    }

    private Object getIconForUri(String s) {
        return s != null && s.length() != 0 && s.indexOf("://") > 0 ? Icon.createWithContentUri(s) : null;
    }

    private Object getIconFromResources(String s, boolean z) {
        int v = UnityNotificationUtilities.findResourceIdInContextByName(this.mContext, s);
        if(v != 0) {
            return !z ? Icon.createWithResource(this.mContext, v) : BitmapFactory.decodeResource(this.mContext.getResources(), v);
        }
        return null;
    }

    public NotificationChannelWrapper getNotificationChannel(String s) {
        long[] arr_v = null;
        if(Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel0 = UnityNotificationManager.getNotificationManagerImpl(this.mContext).getNotificationManager().getNotificationChannel(s);
            return notificationChannel0 == null ? null : UnityNotificationManager.notificationChannelToWrapper(notificationChannel0);
        }
        SharedPreferences sharedPreferences0 = this.mContext.getSharedPreferences(UnityNotificationManager.getSharedPrefsNameByChannelId(s), 0);
        NotificationChannelWrapper notificationChannelWrapper0 = new NotificationChannelWrapper();
        notificationChannelWrapper0.id = s;
        notificationChannelWrapper0.name = sharedPreferences0.getString("title", "undefined");
        notificationChannelWrapper0.importance = sharedPreferences0.getInt("importance", 3);
        notificationChannelWrapper0.description = sharedPreferences0.getString("description", "undefined");
        notificationChannelWrapper0.enableLights = sharedPreferences0.getBoolean("enableLights", false);
        notificationChannelWrapper0.enableVibration = sharedPreferences0.getBoolean("enableVibration", false);
        notificationChannelWrapper0.canBypassDnd = sharedPreferences0.getBoolean("canBypassDnd", false);
        notificationChannelWrapper0.canShowBadge = sharedPreferences0.getBoolean("canShowBadge", false);
        notificationChannelWrapper0.lockscreenVisibility = sharedPreferences0.getInt("lockscreenVisibility", 1);
        notificationChannelWrapper0.group = sharedPreferences0.getString("group", null);
        String[] arr_s = sharedPreferences0.getString("vibrationPattern", "[]").split(",");
        long[] arr_v1 = new long[arr_s.length];
        if(arr_s.length > 1) {
            for(int v = 0; v < arr_s.length; ++v) {
                try {
                    arr_v1[v] = Long.parseLong(arr_s[v]);
                }
                catch(NumberFormatException unused_ex) {
                    arr_v1[v] = 1L;
                }
            }
        }
        if(arr_s.length > 1) {
            arr_v = arr_v1;
        }
        notificationChannelWrapper0.vibrationPattern = arr_v;
        return notificationChannelWrapper0;
    }

    public static String getNotificationChannelId(Notification notification0) {
        return Build.VERSION.SDK_INT < 26 ? null : notification0.getChannelId();
    }

    public NotificationChannelWrapper[] getNotificationChannels() {
        int v = 0;
        if(Build.VERSION.SDK_INT >= 26) {
            List list0 = this.getNotificationManager().getNotificationChannels();
            if(list0.size() == 0) {
                return null;
            }
            NotificationChannelWrapper[] arr_notificationChannelWrapper = new NotificationChannelWrapper[list0.size()];
            for(Object object0: list0) {
                arr_notificationChannelWrapper[v] = UnityNotificationManager.notificationChannelToWrapper(((NotificationChannel)object0));
                ++v;
            }
            return arr_notificationChannelWrapper;
        }
        Set set0 = this.mContext.getSharedPreferences("UNITY_NOTIFICATIONS", 0).getStringSet("ChannelIDs", new HashSet());
        if(set0.size() == 0) {
            return null;
        }
        NotificationChannelWrapper[] arr_notificationChannelWrapper1 = new NotificationChannelWrapper[set0.size()];
        for(Object object1: set0) {
            arr_notificationChannelWrapper1[v] = this.getNotificationChannel(((String)object1));
            ++v;
        }
        return arr_notificationChannelWrapper1;
    }

    public static Integer getNotificationColor(Notification notification0) {
        return Build.VERSION.SDK_INT < 26 || notification0.extras.containsKey("android.colorized") ? notification0.color : null;
    }

    public Notification getNotificationFromIntent(Intent intent0) {
        if(intent0.hasExtra("com.unity.NotificationID")) {
            int v = intent0.getExtras().getInt("com.unity.NotificationID");
            StatusBarNotification[] arr_statusBarNotification = this.getNotificationManager().getActiveNotifications();
            for(int v1 = 0; v1 < arr_statusBarNotification.length; ++v1) {
                StatusBarNotification statusBarNotification0 = arr_statusBarNotification[v1];
                if(statusBarNotification0.getId() == v) {
                    return statusBarNotification0.getNotification();
                }
            }
        }
        Object object0 = this.getNotificationOrBuilderForIntent(intent0);
        if(object0 == null) {
            return null;
        }
        return object0 instanceof Notification ? ((Notification)object0) : ((Notification.Builder)object0).build();
    }

    public static int getNotificationGroupAlertBehavior(Notification notification0) {
        return Build.VERSION.SDK_INT < 26 ? 0 : notification0.getGroupAlertBehavior();
    }

    public NotificationManager getNotificationManager() {
        return (NotificationManager)this.mContext.getSystemService("notification");
    }

    public static UnityNotificationManager getNotificationManagerImpl(Activity activity0, NotificationCallback notificationCallback0) {
        synchronized(UnityNotificationManager.class) {
            if(UnityNotificationManager.mUnityNotificationManager == null) {
                UnityNotificationManager.mUnityNotificationManager = new UnityNotificationManager();
            }
            UnityNotificationManager.mUnityNotificationManager.initialize(activity0, notificationCallback0);
            return UnityNotificationManager.mUnityNotificationManager;
        }
    }

    static UnityNotificationManager getNotificationManagerImpl(Context context0) {
        synchronized(UnityNotificationManager.class) {
            if(UnityNotificationManager.mUnityNotificationManager == null) {
                UnityNotificationManager unityNotificationManager0 = new UnityNotificationManager();
                UnityNotificationManager.mUnityNotificationManager = unityNotificationManager0;
                unityNotificationManager0.mVisibleNotifications = new HashSet();
                UnityNotificationManager unityNotificationManager1 = UnityNotificationManager.mUnityNotificationManager;
                unityNotificationManager1.mScheduledNotifications = new ConcurrentHashMap();
            }
            UnityNotificationManager unityNotificationManager2 = UnityNotificationManager.mUnityNotificationManager;
            unityNotificationManager2.mContext = context0.getApplicationContext();
            return UnityNotificationManager.mUnityNotificationManager;
        }
    }

    private Object getNotificationOrBuilderForIntent(Intent intent0) {
        Object object0 = this.getNotificationOrIdForIntent(intent0);
        if(object0 instanceof Integer) {
            Object object1 = this.mScheduledNotifications.get(((Integer)object0));
            return object1 == null ? this.deserializeNotificationBuilder(((Integer)object0)) : object1;
        }
        return object0;
    }

    private Object getNotificationOrIdForIntent(Intent intent0) {
        if(intent0.hasExtra("com.unity.NotificationID")) {
            return intent0.getExtras().getInt("com.unity.NotificationID");
        }
        return intent0.hasExtra("unityNotification") ? intent0.getParcelableExtra("unityNotification") : null;
    }

    private Set getScheduledNotificationIDs() {
        synchronized(this) {
            return this.mContext.getSharedPreferences("UNITY_STORED_NOTIFICATION_IDS", 0).getStringSet("UNITY_NOTIFICATION_IDS", new HashSet());
        }
    }

    private static String getSharedPrefsNameByChannelId(String s) {
        return String.format("unity_notification_channel_%s", s);
    }

    static String getSharedPrefsNameByNotificationId(String s) {
        return String.format("u_notification_data_%s", s);
    }

    public int getTargetSdk() {
        return 34;
    }

    private void initialize(Activity activity0, NotificationCallback notificationCallback0) {
        this.mContext = activity0.getApplicationContext();
        this.mActivity = activity0;
        this.mNotificationCallback = notificationCallback0;
        if(this.mScheduledNotifications == null) {
            this.mScheduledNotifications = new ConcurrentHashMap();
        }
        if(this.mBackgroundThread == null || !this.mBackgroundThread.isAlive()) {
            this.mBackgroundThread = new UnityNotificationBackgroundThread(this, this.mScheduledNotifications);
        }
        if(this.mRandom == null) {
            this.mRandom = new Random();
        }
        if(this.mVisibleNotifications == null) {
            this.mVisibleNotifications = new HashSet();
        }
        Bundle bundle0 = this.getAppMetadata();
        if((bundle0 == null ? Boolean.FALSE : Boolean.valueOf(bundle0.getBoolean("reschedule_notifications_on_restart", false))).booleanValue()) {
            ComponentName componentName0 = new ComponentName(this.mContext, UnityNotificationRestartReceiver.class);
            this.mContext.getPackageManager().setComponentEnabledSetting(componentName0, 1, 1);
        }
        Class class0 = UnityNotificationUtilities.getOpenAppActivity(this.mContext);
        this.mOpenActivity = class0;
        if(class0 == null) {
            throw new RuntimeException("Failed to determine Activity to be opened when tapping notification");
        }
        if(!this.mBackgroundThread.isAlive()) {
            this.mBackgroundThread.start();
        }
    }

    private static boolean isInForeground() {
        ActivityManager.RunningAppProcessInfo activityManager$RunningAppProcessInfo0 = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(activityManager$RunningAppProcessInfo0);
        return activityManager$RunningAppProcessInfo0.importance == 100 || activityManager$RunningAppProcessInfo0.importance == 200;
    }

    // 检测为 Lambda 实现
    void lambda$showNotification$0$com-unity-androidnotifications-UnityNotificationManager(Integer integer0) [...]

    private Bitmap loadBitmap(String s) {
        try {
            return BitmapFactory.decodeStream(this.mContext.getContentResolver().openInputStream(Uri.parse(s)));
        }
        catch(Exception exception0) {
            Log.e("UnityNotifications", "Failed to load image " + s, exception0);
            return null;
        }
    }

    List loadSavedNotifications() {
        Notification.Builder notification$Builder0;
        synchronized(this) {
            Set set0 = this.getScheduledNotificationIDs();
            List list0 = new ArrayList();
            HashSet hashSet0 = new HashSet();
            for(Object object0: set0) {
                String s = (String)object0;
                SharedPreferences sharedPreferences0 = this.mContext.getSharedPreferences(UnityNotificationManager.getSharedPrefsNameByNotificationId(s), 0);
                Object object1 = UnityNotificationUtilities.deserializeNotification(this.mContext, sharedPreferences0);
                if(object1 == null) {
                    notification$Builder0 = null;
                }
                else if(object1 instanceof Notification.Builder) {
                    notification$Builder0 = (Notification.Builder)object1;
                }
                else {
                    notification$Builder0 = UnityNotificationUtilities.recoverBuilder(this.mContext, ((Notification)object1));
                }
                if(notification$Builder0 == null) {
                    hashSet0.add(s);
                }
                else {
                    list0.add(notification$Builder0);
                }
            }
            if(hashSet0.size() > 0) {
                HashSet hashSet1 = new HashSet(set0);
                for(Object object2: hashSet0) {
                    hashSet1.remove(((String)object2));
                    this.deleteExpiredNotificationIntent(((String)object2));
                }
                this.saveScheduledNotificationIDs(hashSet1);
            }
            return list0;
        }
    }

    private static NotificationChannelWrapper notificationChannelToWrapper(Object object0) {
        NotificationChannelWrapper notificationChannelWrapper0 = new NotificationChannelWrapper();
        notificationChannelWrapper0.id = ((NotificationChannel)object0).getId();
        notificationChannelWrapper0.name = ((NotificationChannel)object0).getName().toString();
        notificationChannelWrapper0.importance = ((NotificationChannel)object0).getImportance();
        notificationChannelWrapper0.description = ((NotificationChannel)object0).getDescription();
        notificationChannelWrapper0.enableLights = ((NotificationChannel)object0).shouldShowLights();
        notificationChannelWrapper0.enableVibration = ((NotificationChannel)object0).shouldVibrate();
        notificationChannelWrapper0.canBypassDnd = ((NotificationChannel)object0).canBypassDnd();
        notificationChannelWrapper0.canShowBadge = ((NotificationChannel)object0).canShowBadge();
        notificationChannelWrapper0.vibrationPattern = ((NotificationChannel)object0).getVibrationPattern();
        notificationChannelWrapper0.lockscreenVisibility = ((NotificationChannel)object0).getLockscreenVisibility();
        notificationChannelWrapper0.group = ((NotificationChannel)object0).getGroup();
        return notificationChannelWrapper0;
    }

    private void notify(int v, Notification notification0) {
        boolean z = notification0.extras.getBoolean("com.unity.showInForeground", true);
        if(!UnityNotificationManager.isInForeground() || z) {
            this.getNotificationManager().notify(v, notification0);
        }
        if(notification0.extras.getLong("repeatInterval", -1L) <= 0L) {
            this.mScheduledNotifications.remove(v);
            this.cancelPendingNotificationIntent(v);
        }
        NotificationCallback notificationCallback0 = this.mNotificationCallback;
        if(notificationCallback0 != null) {
            try {
                notificationCallback0.onSentNotification(notification0);
            }
            catch(RuntimeException unused_ex) {
                Log.w("UnityNotifications", "Can not invoke OnNotificationReceived event when the app is not running!");
            }
        }
    }

    void notify(int v, Notification.Builder notification$Builder0) {
        Class class0 = this.mOpenActivity;
        if(class0 == null) {
            class0 = UnityNotificationUtilities.getOpenAppActivity(this.mContext);
            if(class0 == null) {
                Log.e("UnityNotifications", "Activity not found, cannot show notification");
                return;
            }
        }
        Notification notification0 = this.buildNotificationForSending(class0, notification$Builder0);
        if(notification0 != null) {
            this.notify(v, notification0);
        }
    }

    @Override  // android.content.BroadcastReceiver
    public void onReceive(Context context0, Intent intent0) {
        UnityNotificationManager.getNotificationManagerImpl(context0).onReceive(intent0);
    }

    public void onReceive(Intent intent0) {
        this.showNotification(intent0);
    }

    void performNotificationHousekeeping(Set set0) {
        Log.d("UnityNotifications", "Checking for invalid notification IDs still hanging around");
        Set set1 = this.findInvalidNotificationIds(set0);
        HashSet hashSet0 = new HashSet(set0);
        for(Object object0: set1) {
            hashSet0.remove(((String)object0));
            this.mScheduledNotifications.remove(((String)object0));
        }
        for(Object object1: set1) {
            this.deleteExpiredNotificationIntent(((String)object1));
        }
    }

    void performNotificationScheduling(int v, Notification.Builder notification$Builder0, boolean z) {
        Bundle bundle0 = notification$Builder0.getExtras();
        long v1 = bundle0.getLong("repeatInterval", -1L);
        long v2 = bundle0.getLong("fireTime", -1L);
        boolean z1 = v2 - Calendar.getInstance().getTime().getTime() < 1000L;
        if(!z1 || v1 > 0L) {
            if(z1) {
                v2 += v1;
            }
            Intent intent0 = this.buildNotificationIntent();
            if(intent0 != null) {
                this.saveNotification(notification$Builder0.build(), z);
                this.scheduleAlarmWithNotification(notification$Builder0, intent0, v2);
            }
        }
        if(z1) {
            this.notify(v, this.buildNotificationForSending(this.mOpenActivity, notification$Builder0));
        }
    }

    public void registerNotificationChannel(String s, String s1, int v, String s2, boolean z, boolean z1, boolean z2, boolean z3, long[] arr_v, int v1, String s3) {
        if(Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel0 = new NotificationChannel(s, s1, v);
            notificationChannel0.setDescription(s2);
            notificationChannel0.enableLights(z);
            notificationChannel0.enableVibration(z1);
            notificationChannel0.setBypassDnd(z2);
            notificationChannel0.setShowBadge(z3);
            notificationChannel0.setVibrationPattern(arr_v);
            notificationChannel0.setLockscreenVisibility(v1);
            notificationChannel0.setGroup(s3);
            this.getNotificationManager().createNotificationChannel(notificationChannel0);
            return;
        }
        SharedPreferences sharedPreferences0 = this.mContext.getSharedPreferences("UNITY_NOTIFICATIONS", 0);
        HashSet hashSet0 = new HashSet(sharedPreferences0.getStringSet("ChannelIDs", new HashSet()));
        hashSet0.add(s);
        SharedPreferences.Editor sharedPreferences$Editor0 = sharedPreferences0.edit().clear();
        sharedPreferences$Editor0.putStringSet("ChannelIDs", hashSet0);
        sharedPreferences$Editor0.apply();
        SharedPreferences.Editor sharedPreferences$Editor1 = this.mContext.getSharedPreferences(UnityNotificationManager.getSharedPrefsNameByChannelId(s), 0).edit();
        sharedPreferences$Editor1.putString("title", s1);
        sharedPreferences$Editor1.putInt("importance", v);
        sharedPreferences$Editor1.putString("description", s2);
        sharedPreferences$Editor1.putBoolean("enableLights", z);
        sharedPreferences$Editor1.putBoolean("enableVibration", z1);
        sharedPreferences$Editor1.putBoolean("canBypassDnd", z2);
        sharedPreferences$Editor1.putBoolean("canShowBadge", z3);
        sharedPreferences$Editor1.putString("vibrationPattern", Arrays.toString(arr_v));
        sharedPreferences$Editor1.putInt("lockscreenVisibility", v1);
        sharedPreferences$Editor1.putString("group", s3);
        sharedPreferences$Editor1.apply();
    }

    public void registerNotificationChannelGroup(String s, String s1, String s2) {
        if(Build.VERSION.SDK_INT >= 26) {
            NotificationChannelGroup notificationChannelGroup0 = new NotificationChannelGroup(s, s1);
            if(Build.VERSION.SDK_INT >= 28) {
                notificationChannelGroup0.setDescription(s2);
            }
            this.getNotificationManager().createNotificationChannelGroup(notificationChannelGroup0);
        }
    }

    void saveNotification(Notification notification0, boolean z) {
        synchronized(this) {
            String s = UnityNotificationManager.getSharedPrefsNameByNotificationId(Integer.toString(notification0.extras.getInt("id", -1)));
            UnityNotificationUtilities.serializeNotification(this.mContext.getSharedPreferences(s, 0), notification0, z);
        }
    }

    void saveScheduledNotificationIDs(Set set0) {
        synchronized(this) {
            SharedPreferences.Editor sharedPreferences$Editor0 = this.mContext.getSharedPreferences("UNITY_STORED_NOTIFICATION_IDS", 0).edit().clear();
            sharedPreferences$Editor0.putStringSet("UNITY_NOTIFICATION_IDS", set0);
            sharedPreferences$Editor0.apply();
        }
    }

    void scheduleAlarmWithNotification(Notification.Builder notification$Builder0) {
        long v = notification$Builder0.getExtras().getLong("fireTime", 0L);
        this.scheduleAlarmWithNotification(notification$Builder0, this.buildNotificationIntent(), v);
    }

    void scheduleAlarmWithNotification(Notification.Builder notification$Builder0, Intent intent0, long v) {
        Bundle bundle0 = notification$Builder0.getExtras();
        int v1 = bundle0.getInt("id", -1);
        long v2 = bundle0.getLong("repeatInterval", -1L);
        this.mScheduledNotifications.put(v1, notification$Builder0);
        intent0.putExtra("com.unity.NotificationID", v1);
        this.scheduleNotificationIntentAlarm(v2, v, this.getBroadcastPendingIntent(v1, intent0, 0x8000000));
    }

    public int scheduleNotification(Notification.Builder notification$Builder0, boolean z) {
        int v;
        Bundle bundle0 = notification$Builder0.getExtras();
        if(bundle0.containsKey("id")) {
            v = notification$Builder0.getExtras().getInt("id", -1);
        }
        else {
            int v1 = this.generateUniqueId();
            bundle0.putInt("id", v1);
            v = v1;
        }
        boolean z1 = this.mScheduledNotifications.putIfAbsent(v, notification$Builder0) == null;
        this.mBackgroundThread.enqueueNotification(v, notification$Builder0, z, z1);
        return v;
    }

    private void scheduleNotificationIntentAlarm(long v, long v1, PendingIntent pendingIntent0) {
        Object object0 = this.mContext.getSystemService("alarm");
        if(v <= 0L) {
            if(this.canScheduleExactAlarms(((AlarmManager)object0))) {
                ((AlarmManager)object0).setExactAndAllowWhileIdle(0, v1, pendingIntent0);
                return;
            }
            ((AlarmManager)object0).set(0, v1, pendingIntent0);
            return;
        }
        ((AlarmManager)object0).setInexactRepeating(0, v1, v, pendingIntent0);
    }

    public static void setNotificationColor(Notification.Builder notification$Builder0, int v) {
        if(v != 0) {
            notification$Builder0.setColor(v);
            if(Build.VERSION.SDK_INT >= 26) {
                notification$Builder0.setColorized(true);
            }
        }
    }

    public static void setNotificationGroupAlertBehavior(Notification.Builder notification$Builder0, int v) {
        if(Build.VERSION.SDK_INT >= 26) {
            notification$Builder0.setGroupAlertBehavior(v);
        }
    }

    public static void setNotificationIcon(Notification.Builder notification$Builder0, String s, String s1) {
        if(s1 != null && (s1.length() != 0 || notification$Builder0.getExtras().getString(s) == null)) {
            notification$Builder0.getExtras().putString(s, s1);
            return;
        }
        notification$Builder0.getExtras().remove(s);
    }

    public static void setNotificationUsesChronometer(Notification.Builder notification$Builder0, boolean z) {
        notification$Builder0.setUsesChronometer(z);
    }

    private void setupBigPictureStyle(Notification.Builder notification$Builder0) {
        Bundle bundle0 = notification$Builder0.getExtras();
        String s = bundle0.getString("com.unity.BigPicture");
        if(s == null) {
            return;
        }
        Notification.BigPictureStyle notification$BigPictureStyle0 = new Notification.BigPictureStyle();
        Object object0 = this.getIcon(bundle0.getString("com.unity.BigLargeIcon"));
        if(object0 != null) {
            if(object0 instanceof Icon) {
                notification$BigPictureStyle0.bigLargeIcon(((Icon)object0));
            }
            else {
                notification$BigPictureStyle0.bigLargeIcon(((Bitmap)object0));
            }
        }
        if(s.charAt(0) == 0x2F) {
            notification$BigPictureStyle0.bigPicture(BitmapFactory.decodeFile(s));
        }
        else if(s.indexOf("://") <= 0) {
            Object object1 = this.getIconFromResources(s, Build.VERSION.SDK_INT < 0x1F);
            if(Build.VERSION.SDK_INT >= 0x1F && object1 instanceof Icon) {
                notification$BigPictureStyle0.bigPicture(((Icon)object1));
            }
            else if(object1 instanceof Bitmap) {
                notification$BigPictureStyle0.bigPicture(((Bitmap)object1));
            }
        }
        else if(Build.VERSION.SDK_INT >= 0x1F) {
            notification$BigPictureStyle0.bigPicture(Icon.createWithContentUri(s));
        }
        else {
            Bitmap bitmap0 = this.loadBitmap(s);
            if(bitmap0 != null) {
                notification$BigPictureStyle0.bigPicture(bitmap0);
            }
        }
        notification$BigPictureStyle0.setBigContentTitle(bundle0.getString("com.unity.BigContentTytle"));
        notification$BigPictureStyle0.setSummaryText(bundle0.getString("com.unity.BigSummaryText"));
        if(Build.VERSION.SDK_INT >= 0x1F) {
            notification$BigPictureStyle0.setContentDescription(bundle0.getString("com.unity.BigContentDescription"));
            notification$BigPictureStyle0.showBigPictureWhenCollapsed(bundle0.getBoolean("com.unity.BigShowWhenCollapsed", false));
        }
        notification$Builder0.setStyle(notification$BigPictureStyle0);
    }

    public void setupBigPictureStyle(Notification.Builder notification$Builder0, String s, String s1, String s2, String s3, String s4, boolean z) {
        Bundle bundle0 = notification$Builder0.getExtras();
        if(s1 != null && s1.length() != 0) {
            bundle0.putString("com.unity.BigLargeIcon", s);
            bundle0.putString("com.unity.BigPicture", s1);
            bundle0.putString("com.unity.BigContentTytle", s2);
            bundle0.putString("com.unity.BigSummaryText", s4);
            bundle0.putString("com.unity.BigContentDescription", s3);
            bundle0.putBoolean("com.unity.BigShowWhenCollapsed", z);
        }
    }

    private void showNotification(Intent intent0) {
        Object object0 = this.getNotificationOrIdForIntent(intent0);
        if(object0 == null) {
            return;
        }
        if(object0 instanceof Notification) {
            this.notify(((Notification)object0).extras.getInt("id", -1), ((Notification)object0));
            return;
        }
        Notification.Builder notification$Builder0 = (Notification.Builder)this.mScheduledNotifications.get(((Integer)object0));
        if(notification$Builder0 != null) {
            this.notify(((int)(((Integer)object0))), notification$Builder0);
            return;
        }
        AsyncTask.execute(() -> {
            Notification.Builder notification$Builder0 = this.deserializeNotificationBuilder(((Integer)object0));
            if(notification$Builder0 == null) {
                Log.e("UnityNotifications", "Failed to recover builder, can\'t send notification");
                return;
            }
            this.notify(((int)((Integer)object0)), notification$Builder0);
        });
    }

    public void showNotificationSettings(String s) {
        Intent intent0;
        if(Build.VERSION.SDK_INT < 26) {
            intent0 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent0.setData(Uri.fromParts("package", "com.MonsterCouch.Wingspan", null));
        }
        else {
            if(s == null || s.length() <= 0) {
                intent0 = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
            }
            else {
                Intent intent1 = new Intent("android.settings.CHANNEL_NOTIFICATION_SETTINGS");
                intent1.putExtra("android.provider.extra.CHANNEL_ID", s);
                intent0 = intent1;
            }
            intent0.putExtra("android.provider.extra.APP_PACKAGE", "com.MonsterCouch.Wingspan");
        }
        intent0.addFlags(0x10000000);
        this.mActivity.startActivity(intent0);
    }
}

