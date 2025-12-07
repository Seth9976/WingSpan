package com.unity3d.plugin.downloader.b;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import java.util.regex.Pattern;

public final class m {
    public static Random a;
    private static final Pattern b;

    static {
        m.a = new Random(SystemClock.uptimeMillis());
        m.b = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
    }

    public static int a(Context context0, int v) {
        switch(v) {
            case 1: {
                return m.b(context0, "state_idle");
            }
            case 2: {
                return m.b(context0, "state_fetching_url");
            }
            case 3: {
                return m.b(context0, "state_connecting");
            }
            case 4: {
                return m.b(context0, "state_downloading");
            }
            case 5: {
                return m.b(context0, "state_completed");
            }
            case 6: {
                return m.b(context0, "state_paused_network_unavailable");
            }
            case 7: {
                return m.b(context0, "state_paused_by_request");
            }
            case 8: {
                return m.b(context0, "state_paused_wifi_disabled");
            }
            case 9: {
                return m.b(context0, "state_paused_wifi_unavailable");
            }
            case 10: {
                return m.b(context0, "state_paused_wifi_disabled");
            }
            case 11: {
                return m.b(context0, "state_paused_wifi_unavailable");
            }
            case 12: {
                return m.b(context0, "state_paused_roaming");
            }
            case 13: {
                return m.b(context0, "state_paused_network_setup_failure");
            }
            case 14: {
                return m.b(context0, "state_paused_sdcard_unavailable");
            }
            case 15: {
                return m.b(context0, "state_failed_unlicensed");
            }
            case 16: {
                return m.b(context0, "state_failed_fetching_url");
            }
            case 17: {
                return m.b(context0, "state_failed_sdcard_full");
            }
            case 18: {
                return m.b(context0, "state_failed_cancelled");
            }
            default: {
                return m.b(context0, "state_unknown");
            }
        }
    }

    public static long a(File file0) {
        StatFs statFs0 = new StatFs(file0.getPath());
        long v = ((long)statFs0.getAvailableBlocks()) - 4L;
        return ((long)statFs0.getBlockSize()) * v;
    }

    public static File a(String s) {
        File file0 = Environment.getDownloadCacheDirectory();
        if(s.startsWith(file0.getPath())) {
            return file0;
        }
        File file1 = Environment.getExternalStorageDirectory();
        if(!s.startsWith(file1.getPath())) {
            throw new IllegalArgumentException("Cannot determine filesystem root for " + s);
        }
        return file1;
    }

    public static String a(float f) {
        return String.format("%.2f", ((float)(f * 1000.0f / 1024.0f)));
    }

    public static String a(long v) {
        return v <= 3600000L ? new SimpleDateFormat("mm:ss", Locale.getDefault()).format(new Date(v - ((long)TimeZone.getDefault().getRawOffset()))) : new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date(v - ((long)TimeZone.getDefault().getRawOffset())));
    }

    public static String a(long v, long v1) {
        return v1 == 0L ? "" : String.format("%.2f", ((float)(((float)v) / 1048576.0f))) + "MB /" + String.format("%.2f", ((float)(((float)v1) / 1048576.0f))) + "MB";
    }

    public static String a(Context context0) {
        return context0.getObbDir().toString();
    }

    // 去混淆评级： 低(20)
    public static String a(Context context0, String s) {
        return m.a(context0) + "/" + s;
    }

    public static boolean a() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static boolean a(Context context0, String s, long v) {
        File file0 = new File(m.a(context0, s));
        if(file0.exists()) {
            if(file0.length() == v) {
                return true;
            }
            file0.delete();
        }
        return false;
    }

    public static int b(Context context0, String s) {
        return context0.getResources().getIdentifier(s, "string", "com.MonsterCouch.Wingspan");
    }

    public static boolean b(String s) {
        String s1 = s.replaceFirst("/+", "/");
        return s1.startsWith(Environment.getDownloadCacheDirectory().toString()) || s1.startsWith(Environment.getExternalStorageDirectory().toString());
    }

    public static int c(Context context0, String s) {
        return context0.getResources().getIdentifier(s, "layout", "com.MonsterCouch.Wingspan");
    }

    public static int d(Context context0, String s) {
        return context0.getResources().getIdentifier(s, "id", "com.MonsterCouch.Wingspan");
    }
}

