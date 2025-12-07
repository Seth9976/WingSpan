package com.unity.androidnotifications;

import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

class UnityNotificationUtilities {
    private static final int INTENT_SERIALIZATION_VERSION = 0;
    private static final int NOTIFICATION_SERIALIZATION_VERSION = 3;
    static final String SAVED_NOTIFICATION_FALLBACK_KEY = "fallback.data";
    static final String SAVED_NOTIFICATION_PRIMARY_KEY = "data";
    static final byte[] UNITY_MAGIC_NUMBER;
    private static final byte[] UNITY_MAGIC_NUMBER_PARCELLED;

    static {
        UnityNotificationUtilities.UNITY_MAGIC_NUMBER = new byte[]{85, 77, 78, 78};
        UnityNotificationUtilities.UNITY_MAGIC_NUMBER_PARCELLED = new byte[]{85, 77, 78, 80};
    }

    protected static Object deserializeNotification(Context context0, SharedPreferences sharedPreferences0) {
        String s = sharedPreferences0.getString("data", "");
        if(s != null && s.length() > 0) {
            Object object0 = UnityNotificationUtilities.deserializeNotification(context0, Base64.decode(s, 0));
            if(object0 != null) {
                return object0;
            }
            String s1 = sharedPreferences0.getString("fallback.data", "");
            return s1 == null || s1.length() <= 0 ? null : UnityNotificationUtilities.deserializeNotification(context0, Base64.decode(s1, 0));
        }
        return null;
    }

    private static Object deserializeNotification(Context context0, byte[] arr_b) {
        ByteArrayInputStream byteArrayInputStream0 = new ByteArrayInputStream(arr_b);
        DataInputStream dataInputStream0 = new DataInputStream(byteArrayInputStream0);
        Notification notification0 = UnityNotificationUtilities.deserializeNotificationParcelable(dataInputStream0);
        if(notification0 != null) {
            return notification0;
        }
        byteArrayInputStream0.reset();
        Notification.Builder notification$Builder0 = UnityNotificationUtilities.deserializeNotificationCustom(context0, dataInputStream0);
        return notification$Builder0 == null ? UnityNotificationUtilities.deserializedFromOldIntent(context0, arr_b) : notification$Builder0;
    }

    private static Notification.Builder deserializeNotificationCustom(Context context0, DataInputStream dataInputStream0) {
        boolean z10;
        boolean z5;
        String s17;
        boolean z4;
        String s16;
        long v5;
        String s15;
        String s14;
        String s13;
        String s12;
        int v4;
        boolean z3;
        String s11;
        String s10;
        long v6;
        String s8;
        String s7;
        String s6;
        boolean z1;
        long v2;
        try {
            if(!UnityNotificationUtilities.readAndCheckMagicNumber(dataInputStream0, UnityNotificationUtilities.UNITY_MAGIC_NUMBER)) {
                return null;
            }
            int v = dataInputStream0.readInt();
            if(v >= 0 && v <= 3) {
                Bundle bundle0 = v >= 2 ? null : ((Bundle)UnityNotificationUtilities.deserializeParcelable(dataInputStream0));
                if(bundle0 == null) {
                    int v1 = dataInputStream0.readInt();
                    String s = UnityNotificationUtilities.deserializeString(dataInputStream0);
                    String s1 = UnityNotificationUtilities.deserializeString(dataInputStream0);
                    String s2 = UnityNotificationUtilities.deserializeString(dataInputStream0);
                    String s3 = UnityNotificationUtilities.deserializeString(dataInputStream0);
                    v2 = dataInputStream0.readLong();
                    long v3 = dataInputStream0.readLong();
                    String s4 = UnityNotificationUtilities.deserializeString(dataInputStream0);
                    boolean z = dataInputStream0.readBoolean();
                    z1 = dataInputStream0.readBoolean();
                    String s5 = UnityNotificationUtilities.deserializeString(dataInputStream0);
                    boolean z2 = v <= 0 ? true : dataInputStream0.readBoolean();
                    if(v < 3) {
                        s6 = null;
                        s7 = null;
                        s8 = null;
                        goto label_28;
                    }
                    else {
                        String s9 = UnityNotificationUtilities.deserializeString(dataInputStream0);
                        if(s9 != null && s9.length() > 0) {
                            String s18 = UnityNotificationUtilities.deserializeString(dataInputStream0);
                            String s19 = UnityNotificationUtilities.deserializeString(dataInputStream0);
                            s13 = s1;
                            s14 = s2;
                            s15 = s3;
                            v5 = v3;
                            s16 = s4;
                            z4 = z;
                            s17 = s5;
                            z5 = z2;
                            s10 = UnityNotificationUtilities.deserializeString(dataInputStream0);
                            s11 = UnityNotificationUtilities.deserializeString(dataInputStream0);
                            z3 = dataInputStream0.readBoolean();
                            s7 = s9;
                            s6 = s18;
                            v4 = v1;
                            s12 = s;
                            v6 = v2;
                            s8 = s19;
                        }
                        else {
                            s7 = s9;
                            s6 = null;
                            s8 = null;
                        label_28:
                            s10 = null;
                            s11 = null;
                            z3 = false;
                            v4 = v1;
                            s12 = s;
                            s13 = s1;
                            s14 = s2;
                            s15 = s3;
                            v5 = v3;
                            s16 = s4;
                            z4 = z;
                            s17 = s5;
                            z5 = z2;
                            v6 = v2;
                        }
                    }
                }
                else {
                    String s20 = bundle0.getString("android.title");
                    String s21 = bundle0.getString("android.text");
                    String s22 = bundle0.getString("smallIcon");
                    String s23 = bundle0.getString("largeIcon");
                    v2 = bundle0.getLong("fireTime", -1L);
                    long v7 = bundle0.getLong("repeatInterval", -1L);
                    String s24 = bundle0.getString("android.bigText");
                    boolean z6 = bundle0.getBoolean("android.showChronometer", false);
                    z1 = bundle0.getBoolean("android.showWhen", false);
                    s6 = null;
                    s7 = null;
                    s8 = null;
                    s10 = null;
                    s11 = null;
                    v4 = 0;
                    z3 = false;
                    s12 = s20;
                    s13 = s21;
                    s14 = s22;
                    s15 = s23;
                    v5 = v7;
                    s16 = s24;
                    z4 = z6;
                    s17 = bundle0.getString("data");
                    z5 = true;
                    v6 = v2;
                }
                String s25 = UnityNotificationUtilities.deserializeString(dataInputStream0);
                boolean z7 = dataInputStream0.readBoolean();
                int v8 = z7 ? dataInputStream0.readInt() : 0;
                int v9 = dataInputStream0.readInt();
                boolean z8 = dataInputStream0.readBoolean();
                String s26 = UnityNotificationUtilities.deserializeString(dataInputStream0);
                boolean z9 = dataInputStream0.readBoolean();
                int v10 = dataInputStream0.readInt();
                String s27 = UnityNotificationUtilities.deserializeString(dataInputStream0);
                long v11 = z1 ? dataInputStream0.readLong() : 0L;
                UnityNotificationManager unityNotificationManager0 = UnityNotificationManager.getNotificationManagerImpl(context0);
                Notification.Builder notification$Builder0 = unityNotificationManager0.createNotificationBuilder(s25);
                if(bundle0 == null) {
                    z10 = z7;
                    notification$Builder0.getExtras().putInt("id", v4);
                    UnityNotificationManager.setNotificationIcon(notification$Builder0, "smallIcon", s14);
                    UnityNotificationManager.setNotificationIcon(notification$Builder0, "largeIcon", s15);
                    if(v6 != -1L) {
                        notification$Builder0.getExtras().putLong("fireTime", v6);
                    }
                    if(v5 != -1L) {
                        notification$Builder0.getExtras().putLong("repeatInterval", v5);
                    }
                    if(s17 != null) {
                        notification$Builder0.getExtras().putString("data", s17);
                    }
                    notification$Builder0.getExtras().putBoolean("com.unity.showInForeground", z5);
                }
                else {
                    notification$Builder0.setExtras(bundle0);
                    z10 = z7;
                }
                if(s12 != null) {
                    notification$Builder0.setContentTitle(s12);
                }
                if(s13 != null) {
                    notification$Builder0.setContentText(s13);
                }
                if(s16 != null) {
                    notification$Builder0.setStyle(new Notification.BigTextStyle().bigText(s16));
                }
                else if(s7 != null) {
                    unityNotificationManager0.setupBigPictureStyle(notification$Builder0, s6, s7, s8, s10, s11, z3);
                }
                if(z10) {
                    UnityNotificationManager.setNotificationColor(notification$Builder0, v8);
                }
                if(v9 >= 0) {
                    notification$Builder0.setNumber(v9);
                }
                notification$Builder0.setAutoCancel(z8);
                UnityNotificationManager.setNotificationUsesChronometer(notification$Builder0, z4);
                if(s26 != null && s26.length() > 0) {
                    notification$Builder0.setGroup(s26);
                }
                notification$Builder0.setGroupSummary(z9);
                UnityNotificationManager.setNotificationGroupAlertBehavior(notification$Builder0, v10);
                if(s27 != null && s27.length() > 0) {
                    notification$Builder0.setSortKey(s27);
                }
                if(z1) {
                    notification$Builder0.setShowWhen(true);
                    notification$Builder0.setWhen(v11);
                }
                return notification$Builder0;
            }
        }
        catch(Exception exception0) {
            Log.e("UnityNotifications", "Failed to deserialize notification", exception0);
        }
        catch(OutOfMemoryError outOfMemoryError0) {
            Log.e("UnityNotifications", "Failed to deserialize notification", outOfMemoryError0);
        }
        return null;
    }

    private static Notification deserializeNotificationParcelable(DataInputStream dataInputStream0) {
        try {
            if(!UnityNotificationUtilities.readAndCheckMagicNumber(dataInputStream0, UnityNotificationUtilities.UNITY_MAGIC_NUMBER_PARCELLED)) {
                return null;
            }
            int v = dataInputStream0.readInt();
            return v < 0 || v > 0 ? null : ((Notification)((Intent)UnityNotificationUtilities.deserializeParcelable(dataInputStream0)).getParcelableExtra("unityNotification"));
        }
        catch(Exception exception0) {
            Log.e("UnityNotifications", "Failed to deserialize notification intent", exception0);
            return null;
        }
        catch(OutOfMemoryError outOfMemoryError0) {
            Log.e("UnityNotifications", "Failed to deserialize notification intent", outOfMemoryError0);
            return null;
        }
    }

    private static Parcelable deserializeParcelable(DataInputStream dataInputStream0) throws IOException {
        int v = dataInputStream0.readInt();
        if(v <= 0) {
            return null;
        }
        byte[] arr_b = new byte[v];
        if(dataInputStream0.read(arr_b) != v) {
            throw new IOException("Insufficient amount of bytes read");
        }
        try {
            Parcel parcel0 = Parcel.obtain();
            parcel0.unmarshall(arr_b, 0, v);
            parcel0.setDataPosition(0);
            Bundle bundle0 = (Bundle)parcel0.readParcelable(UnityNotificationUtilities.class.getClassLoader());
            parcel0.recycle();
            if(bundle0 != null) {
                return bundle0.getParcelable("obj");
            }
        }
        catch(Exception exception0) {
            Log.e("UnityNotifications", "Failed to deserialize parcelable", exception0);
        }
        catch(OutOfMemoryError outOfMemoryError0) {
            Log.e("UnityNotifications", "Failed to deserialize parcelable", outOfMemoryError0);
        }
        return null;
    }

    private static String deserializeString(DataInputStream dataInputStream0) throws IOException {
        int v = dataInputStream0.readInt();
        if(v <= 0) {
            return null;
        }
        byte[] arr_b = new byte[v];
        if(dataInputStream0.read(arr_b) != v) {
            throw new IOException("Insufficient amount of bytes read");
        }
        return new String(arr_b, StandardCharsets.UTF_8);
    }

    private static Notification.Builder deserializedFromOldIntent(Context context0, byte[] arr_b) {
        try {
            Parcel parcel0 = Parcel.obtain();
            parcel0.unmarshall(arr_b, 0, arr_b.length);
            parcel0.setDataPosition(0);
            Bundle bundle0 = new Bundle();
            bundle0.readFromParcel(parcel0);
            int v = bundle0.getInt("id", -1);
            String s = bundle0.getString("channelID");
            String s1 = bundle0.getString("textTitle");
            String s2 = bundle0.getString("textContent");
            String s3 = bundle0.getString("smallIconStr");
            boolean z = bundle0.getBoolean("autoCancel", false);
            boolean z1 = bundle0.getBoolean("usesChronometer", false);
            long v1 = bundle0.getLong("fireTime", -1L);
            long v2 = bundle0.getLong("repeatInterval", -1L);
            String s4 = bundle0.getString("largeIconStr");
            int v3 = bundle0.getInt("style", -1);
            int v4 = bundle0.getInt("color", 0);
            int v5 = bundle0.getInt("number", 0);
            String s5 = bundle0.getString("data");
            String s6 = bundle0.getString("group");
            boolean z2 = bundle0.getBoolean("groupSummary", false);
            String s7 = bundle0.getString("sortKey");
            int v6 = bundle0.getInt("groupAlertBehaviour", -1);
            boolean z3 = bundle0.getBoolean("showTimestamp", false);
            Notification.Builder notification$Builder0 = UnityNotificationManager.getNotificationManagerImpl(context0).createNotificationBuilder(s);
            notification$Builder0.getExtras().putInt("id", v);
            notification$Builder0.setContentTitle(s1);
            notification$Builder0.setContentText(s2);
            UnityNotificationManager.setNotificationIcon(notification$Builder0, "smallIcon", s3);
            notification$Builder0.setAutoCancel(z);
            notification$Builder0.setUsesChronometer(z1);
            notification$Builder0.getExtras().putLong("fireTime", v1);
            notification$Builder0.getExtras().putLong("repeatInterval", v2);
            UnityNotificationManager.setNotificationIcon(notification$Builder0, "largeIcon", s4);
            if(v3 == 2) {
                notification$Builder0.setStyle(new Notification.BigTextStyle().bigText(s2));
            }
            if(v4 != 0) {
                UnityNotificationManager.setNotificationColor(notification$Builder0, v4);
            }
            if(v5 >= 0) {
                notification$Builder0.setNumber(v5);
            }
            if(s5 != null) {
                notification$Builder0.getExtras().putString("data", s5);
            }
            if(s6 != null && s6.length() > 0) {
                notification$Builder0.setGroup(s6);
            }
            notification$Builder0.setGroupSummary(z2);
            if(s7 != null && s7.length() > 0) {
                notification$Builder0.setSortKey(s7);
            }
            UnityNotificationManager.setNotificationGroupAlertBehavior(notification$Builder0, v6);
            notification$Builder0.setShowWhen(z3);
            return notification$Builder0;
        }
        catch(Exception exception0) {
            Log.e("UnityNotifications", "Failed to deserialize old style notification", exception0);
            return null;
        }
        catch(OutOfMemoryError outOfMemoryError0) {
            Log.e("UnityNotifications", "Failed to deserialize old style notification", outOfMemoryError0);
            return null;
        }
    }

    protected static int findResourceIdInContextByName(Context context0, String s) {
        if(s == null) {
            return 0;
        }
        try {
            Resources resources0 = context0.getResources();
            if(resources0 != null) {
                int v = resources0.getIdentifier(s, "mipmap", "com.MonsterCouch.Wingspan");
                return v == 0 ? resources0.getIdentifier(s, "drawable", "com.MonsterCouch.Wingspan") : v;
            }
        }
        catch(Resources.NotFoundException unused_ex) {
        }
        return 0;
    }

    protected static Class getOpenAppActivity(Context context0) {
        Bundle bundle0;
        PackageManager packageManager0;
        try {
            packageManager0 = context0.getPackageManager();
            bundle0 = packageManager0.getApplicationInfo("com.MonsterCouch.Wingspan", 0x80).metaData;
            if(bundle0.containsKey("custom_notification_android_activity")) {
                return Class.forName(bundle0.getString("custom_notification_android_activity"));
            }
            goto label_6;
        }
        catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
            packageManager$NameNotFoundException0.printStackTrace();
            return null;
        }
        catch(ClassNotFoundException classNotFoundException0) {
            Log.e("UnityNotifications", "Failed to find activity class: " + classNotFoundException0.getMessage());
            return null;
        }
        try {
            return Class.forName(bundle0.getString("custom_notification_android_activity"));
        }
        catch(ClassNotFoundException classNotFoundException1) {
            try {
                Log.e("UnityNotifications", "Specified activity class for notifications not found: " + classNotFoundException1.getMessage());
            label_6:
                Log.w("UnityNotifications", "No custom_notification_android_activity found, attempting to find app activity class");
                int v = 1;
                ActivityInfo[] arr_activityInfo = packageManager0.getPackageInfo("com.MonsterCouch.Wingspan", 1).activities;
                if(arr_activityInfo == null) {
                    Log.e("UnityNotifications", "Could not get package activities");
                    return null;
                }
                String s = null;
                boolean z = false;
                int v2 = 0;
                for(int v1 = 0; true; ++v1) {
                    if(v1 >= arr_activityInfo.length) {
                        v = v2;
                        break;
                    }
                    ActivityInfo activityInfo0 = arr_activityInfo[v1];
                    if(activityInfo0.enabled && activityInfo0.targetActivity == null) {
                        boolean z1 = UnityNotificationUtilities.isUnityActivity(activityInfo0.name);
                        if(s == null) {
                            s = activityInfo0.name;
                            z = z1;
                        }
                        else if(z == z1) {
                            if(z && z1) {
                                break;
                            }
                            v2 = 1;
                        }
                        else if(z1) {
                            s = activityInfo0.name;
                            v2 = 0;
                            z = true;
                        }
                    }
                }
                if(v != 0) {
                    Log.e("UnityNotifications", "Multiple choices for activity for notifications, set activity explicitly in Notification Settings");
                    return null;
                }
                if(s == null) {
                    Log.e("UnityNotifications", "Activity class for notifications not found");
                    return null;
                }
                return Class.forName(s);
            }
            catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
                packageManager$NameNotFoundException0.printStackTrace();
                return null;
            }
            catch(ClassNotFoundException classNotFoundException0) {
            }
            Log.e("UnityNotifications", "Failed to find activity class: " + classNotFoundException0.getMessage());
            return null;
        }
        catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
            packageManager$NameNotFoundException0.printStackTrace();
            return null;
        }
    }

    // 去混淆评级： 低(20)
    private static boolean isUnityActivity(String s) {
        return s.endsWith(".UnityPlayerActivity") || s.endsWith(".UnityPlayerGameActivity");
    }

    private static boolean readAndCheckMagicNumber(DataInputStream dataInputStream0, byte[] arr_b) {
        try {
            for(int v = 0; true; ++v) {
                if(v >= arr_b.length) {
                    return true;
                }
                if(dataInputStream0.readByte() != arr_b[v]) {
                    break;
                }
            }
        }
        catch(Exception unused_ex) {
        }
        return false;
    }

    protected static Notification.Builder recoverBuilder(Context context0, Notification notification0) {
        if(Build.VERSION.SDK_INT >= 24) {
            try {
                Notification.Builder notification$Builder0 = Notification.Builder.recoverBuilder(context0, notification0);
                notification$Builder0.setExtras(notification0.extras);
                return notification$Builder0;
            }
            catch(Exception exception0) {
                Log.e("UnityNotifications", "Failed to recover builder for notification!", exception0);
                return UnityNotificationUtilities.recoverBuilderCustom(context0, notification0);
            }
            catch(OutOfMemoryError outOfMemoryError0) {
                Log.e("UnityNotifications", "Failed to recover builder for notification!", outOfMemoryError0);
                return UnityNotificationUtilities.recoverBuilderCustom(context0, notification0);
            }
        }
        return UnityNotificationUtilities.recoverBuilderCustom(context0, notification0);
    }

    private static Notification.Builder recoverBuilderCustom(Context context0, Notification notification0) {
        String s = notification0.extras.getString("channelID");
        Notification.Builder notification$Builder0 = UnityNotificationManager.getNotificationManagerImpl(context0).createNotificationBuilder(s);
        UnityNotificationManager.setNotificationIcon(notification$Builder0, "smallIcon", notification0.extras.getString("smallIcon"));
        String s1 = notification0.extras.getString("largeIcon");
        if(s1 != null && !s1.isEmpty()) {
            UnityNotificationManager.setNotificationIcon(notification$Builder0, "largeIcon", s1);
        }
        notification$Builder0.setContentTitle(notification0.extras.getString("android.title"));
        notification$Builder0.setContentText(notification0.extras.getString("android.text"));
        boolean z = true;
        notification$Builder0.setAutoCancel((notification0.flags & 16) != 0);
        if(notification0.number >= 0) {
            notification$Builder0.setNumber(notification0.number);
        }
        String s2 = notification0.extras.getString("android.bigText");
        if(s2 != null) {
            notification$Builder0.setStyle(new Notification.BigTextStyle().bigText(s2));
        }
        notification$Builder0.setWhen(notification0.when);
        String s3 = notification0.getGroup();
        if(s3 != null && !s3.isEmpty()) {
            notification$Builder0.setGroup(s3);
        }
        if((notification0.flags & 0x200) == 0) {
            z = false;
        }
        notification$Builder0.setGroupSummary(z);
        String s4 = notification0.getSortKey();
        if(s4 != null && !s4.isEmpty()) {
            notification$Builder0.setSortKey(s4);
        }
        notification$Builder0.setShowWhen(notification0.extras.getBoolean("android.showWhen", false));
        Integer integer0 = UnityNotificationManager.getNotificationColor(notification0);
        if(integer0 != null) {
            UnityNotificationManager.setNotificationColor(notification$Builder0, ((int)integer0));
        }
        UnityNotificationManager.setNotificationUsesChronometer(notification$Builder0, notification0.extras.getBoolean("android.showChronometer", false));
        UnityNotificationManager.setNotificationGroupAlertBehavior(notification$Builder0, UnityNotificationManager.getNotificationGroupAlertBehavior(notification0));
        notification$Builder0.getExtras().putInt("id", notification0.extras.getInt("id", 0));
        notification$Builder0.getExtras().putLong("repeatInterval", notification0.extras.getLong("repeatInterval", 0L));
        notification$Builder0.getExtras().putLong("fireTime", notification0.extras.getLong("fireTime", 0L));
        String s5 = notification0.extras.getString("data");
        if(s5 != null && !s5.isEmpty()) {
            notification$Builder0.getExtras().putString("data", s5);
        }
        return notification$Builder0;
    }

    protected static void serializeNotification(SharedPreferences sharedPreferences0, Notification notification0, boolean z) {
        String s;
        try {
            ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream0 = new DataOutputStream(byteArrayOutputStream0);
            if(z) {
                Intent intent0 = new Intent();
                intent0.putExtra("unityNotification", notification0);
                if(UnityNotificationUtilities.serializeNotificationParcel(intent0, dataOutputStream0)) {
                    dataOutputStream0.close();
                    byte[] arr_b = byteArrayOutputStream0.toByteArray();
                    s = Base64.encodeToString(arr_b, 0, arr_b.length, 0);
                    goto label_15;
                }
                return;
            }
            if(UnityNotificationUtilities.serializeNotificationCustom(notification0, dataOutputStream0)) {
                dataOutputStream0.flush();
                byte[] arr_b1 = byteArrayOutputStream0.toByteArray();
                s = Base64.encodeToString(arr_b1, 0, arr_b1.length, 0);
            label_15:
                SharedPreferences.Editor sharedPreferences$Editor0 = sharedPreferences0.edit().clear();
                sharedPreferences$Editor0.putString("data", s);
                sharedPreferences$Editor0.apply();
            }
        }
        catch(Exception exception0) {
            Log.e("UnityNotifications", "Failed to serialize notification", exception0);
        }
    }

    private static boolean serializeNotificationCustom(Notification notification0, DataOutputStream dataOutputStream0) {
        try {
            dataOutputStream0.write(UnityNotificationUtilities.UNITY_MAGIC_NUMBER);
            dataOutputStream0.writeInt(3);
            boolean z = notification0.extras.getBoolean("android.showWhen", false);
            dataOutputStream0.writeInt(notification0.extras.getInt("id"));
            UnityNotificationUtilities.serializeString(dataOutputStream0, notification0.extras.getString("android.title"));
            UnityNotificationUtilities.serializeString(dataOutputStream0, notification0.extras.getString("android.text"));
            UnityNotificationUtilities.serializeString(dataOutputStream0, notification0.extras.getString("smallIcon"));
            UnityNotificationUtilities.serializeString(dataOutputStream0, notification0.extras.getString("largeIcon"));
            dataOutputStream0.writeLong(notification0.extras.getLong("fireTime", -1L));
            dataOutputStream0.writeLong(notification0.extras.getLong("repeatInterval", -1L));
            UnityNotificationUtilities.serializeString(dataOutputStream0, notification0.extras.getString("android.bigText"));
            dataOutputStream0.writeBoolean(notification0.extras.getBoolean("android.showChronometer", false));
            dataOutputStream0.writeBoolean(z);
            UnityNotificationUtilities.serializeString(dataOutputStream0, notification0.extras.getString("data"));
            dataOutputStream0.writeBoolean(notification0.extras.getBoolean("com.unity.showInForeground", true));
            String s = notification0.extras.getString("com.unity.BigPicture");
            UnityNotificationUtilities.serializeString(dataOutputStream0, s);
            if(s != null && s.length() > 0) {
                UnityNotificationUtilities.serializeString(dataOutputStream0, notification0.extras.getString("com.unity.BigLargeIcon"));
                UnityNotificationUtilities.serializeString(dataOutputStream0, notification0.extras.getString("com.unity.BigContentTytle"));
                UnityNotificationUtilities.serializeString(dataOutputStream0, notification0.extras.getString("com.unity.BigContentDescription"));
                UnityNotificationUtilities.serializeString(dataOutputStream0, notification0.extras.getString("com.unity.BigSummaryText"));
                dataOutputStream0.writeBoolean(notification0.extras.getBoolean("com.unity.BigShowWhenCollapsed", false));
            }
            UnityNotificationUtilities.serializeString(dataOutputStream0, (Build.VERSION.SDK_INT >= 26 ? notification0.getChannelId() : null));
            Integer integer0 = UnityNotificationManager.getNotificationColor(notification0);
            dataOutputStream0.writeBoolean(integer0 != null);
            if(integer0 != null) {
                dataOutputStream0.writeInt(((int)integer0));
            }
            dataOutputStream0.writeInt(notification0.number);
            dataOutputStream0.writeBoolean((notification0.flags & 16) != 0);
            UnityNotificationUtilities.serializeString(dataOutputStream0, notification0.getGroup());
            dataOutputStream0.writeBoolean((notification0.flags & 0x200) != 0);
            dataOutputStream0.writeInt(UnityNotificationManager.getNotificationGroupAlertBehavior(notification0));
            UnityNotificationUtilities.serializeString(dataOutputStream0, notification0.getSortKey());
            if(z) {
                dataOutputStream0.writeLong(notification0.when);
            }
            return true;
        }
        catch(Exception exception0) {
            Log.e("UnityNotifications", "Failed to serialize notification", exception0);
            return false;
        }
    }

    static boolean serializeNotificationParcel(Intent intent0, DataOutputStream dataOutputStream0) {
        try {
            byte[] arr_b = UnityNotificationUtilities.serializeParcelable(intent0);
            if(arr_b != null && arr_b.length != 0) {
                dataOutputStream0.write(UnityNotificationUtilities.UNITY_MAGIC_NUMBER_PARCELLED);
                dataOutputStream0.writeInt(0);
                dataOutputStream0.writeInt(arr_b.length);
                dataOutputStream0.write(arr_b);
                return true;
            }
        }
        catch(Exception exception0) {
            Log.e("UnityNotifications", "Failed to serialize notification as Parcel", exception0);
        }
        catch(OutOfMemoryError outOfMemoryError0) {
            Log.e("UnityNotifications", "Failed to serialize notification as Parcel", outOfMemoryError0);
        }
        return false;
    }

    static byte[] serializeParcelable(Parcelable parcelable0) {
        try {
            Parcel parcel0 = Parcel.obtain();
            Bundle bundle0 = new Bundle();
            bundle0.putParcelable("obj", parcelable0);
            parcel0.writeParcelable(bundle0, 0);
            byte[] arr_b = parcel0.marshall();
            parcel0.recycle();
            return arr_b;
        }
        catch(Exception exception0) {
            Log.e("UnityNotifications", "Failed to serialize Parcelable", exception0);
            return null;
        }
        catch(OutOfMemoryError outOfMemoryError0) {
            Log.e("UnityNotifications", "Failed to serialize Parcelable", outOfMemoryError0);
            return null;
        }
    }

    static void serializeString(DataOutputStream dataOutputStream0, String s) throws IOException {
        if(s != null && s.length() != 0) {
            byte[] arr_b = s.getBytes(StandardCharsets.UTF_8);
            dataOutputStream0.writeInt(arr_b.length);
            dataOutputStream0.write(arr_b);
            return;
        }
        dataOutputStream0.writeInt(0);
    }
}

