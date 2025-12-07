package com.voxelbusters.essentialkit.utilities;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import com.google.android.gms.common.GoogleApiAvailability;
import java.io.File;
import java.util.List;

public class ApplicationUtil {
    public static final int APP_STATE_BACKGROUND = 2;
    public static final int APP_STATE_FOREGROUND = 1;
    public static final int APP_STATE_NOT_RUNNING = 3;

    public static int getAppState(Context context0) {
        List list0 = ((ActivityManager)context0.getSystemService("activity")).getRunningAppProcesses();
        if(list0 != null) {
            String s = ApplicationUtil.getApplicationInfo(context0).packageName;
            for(Object object0: list0) {
                ActivityManager.RunningAppProcessInfo activityManager$RunningAppProcessInfo0 = (ActivityManager.RunningAppProcessInfo)object0;
                if(activityManager$RunningAppProcessInfo0.processName.equals(s)) {
                    int v = activityManager$RunningAppProcessInfo0.importance;
                    if(v == 100) {
                        return 1;
                    }
                    if(v == 400) {
                        return 2;
                    }
                    if(false) {
                        break;
                    }
                }
            }
        }
        return 3;
    }

    public static ApplicationInfo getApplicationInfo(Context context0) {
        PackageManager packageManager0 = context0.getPackageManager();
        try {
            return packageManager0.getApplicationInfo("com.MonsterCouch.Wingspan", 0);
        }
        catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
            packageManager$NameNotFoundException0.printStackTrace();
            return null;
        }
    }

    public static String getApplicationName(Context context0) {
        ApplicationInfo applicationInfo0 = ApplicationUtil.getApplicationInfo(context0);
        return context0.getPackageManager().getApplicationLabel(applicationInfo0).toString();
    }

    private static File getDirectory(String s, File file0) {
        File file1 = new File(file0, s);
        file1.mkdirs();
        return file1;
    }

    // 去混淆评级： 低(20)
    public static String getFileProviderAuthorityName(Context context0) {
        return "com.MonsterCouch.Wingspan.essentialkit.fileprovider";
    }

    public static File getLocalCacheDirectory(Context context0, String s) {
        return ApplicationUtil.getDirectory(s, context0.getApplicationContext().getCacheDir());
    }

    public static Class getMainLauncherActivity(Context context0) {
        String s = context0.getPackageManager().getLaunchIntentForPackage("com.MonsterCouch.Wingspan").getComponent().getClassName();
        try {
            return Class.forName(s);
        }
        catch(ClassNotFoundException classNotFoundException0) {
            classNotFoundException0.printStackTrace();
            return null;
        }
    }

    public static boolean hasPermission(Context context0, String s) {
        return context0.getPackageManager().checkPermission(s, "com.MonsterCouch.Wingspan") == 0;
    }

    public static boolean isDebugBuild(Context context0) {
        return (ApplicationUtil.getApplicationInfo(context0).flags & 2) != 0;
    }

    public static boolean isGooglePlayServicesAvailable(Context context0) {
        return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context0) == 0;
    }

    public static boolean isPackageInstalled(Context context0, String s) {
        PackageManager packageManager0 = context0.getPackageManager();
        if(!StringUtil.isNullOrEmpty(s)) {
            try {
                if(packageManager0.getPackageInfo(s, 0x80) != null) {
                    return true;
                }
            }
            catch(PackageManager.NameNotFoundException unused_ex) {
            }
        }
        return false;
    }
}

