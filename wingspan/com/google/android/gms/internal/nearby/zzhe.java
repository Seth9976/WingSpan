package com.google.android.gms.internal.nearby;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import jeb.synthetic.TWR;

public class zzhe {
    private static final Uri CONTENT_URI;
    private static final Uri zzjn;
    private static final Pattern zzjo;
    private static final Pattern zzjp;
    private static final AtomicBoolean zzjq;
    private static HashMap zzjr;
    private static final HashMap zzjs;
    private static final HashMap zzjt;
    private static final HashMap zzju;
    private static final HashMap zzjv;
    private static Object zzjw;
    private static boolean zzjx;
    private static String[] zzjy;

    static {
        zzhe.CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
        zzhe.zzjn = Uri.parse("content://com.google.android.gsf.gservices/prefix");
        zzhe.zzjo = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
        zzhe.zzjp = Pattern.compile("^(0|false|f|off|no|n)$", 2);
        zzhe.zzjq = new AtomicBoolean();
        zzhe.zzjs = new HashMap();
        zzhe.zzjt = new HashMap();
        zzhe.zzju = new HashMap();
        zzhe.zzjv = new HashMap();
        zzhe.zzjy = new String[0];
    }

    private static Object zza(HashMap hashMap0, String s, Object object0) {
        synchronized(zzhe.class) {
            if(hashMap0.containsKey(s)) {
                Object object1 = hashMap0.get(s);
                if(object1 != null) {
                    object0 = object1;
                }
                return object0;
            }
            return null;
        }
    }

    private static String zza(ContentResolver contentResolver0, String s, String s1) {
        String s2;
        Object object0;
        String s5;
        synchronized(zzhe.class) {
            zzhe.zza(contentResolver0);
            object0 = zzhe.zzjw;
            s2 = null;
            if(zzhe.zzjr.containsKey(s)) {
                String s3 = (String)zzhe.zzjr.get(s);
                if(s3 != null) {
                    s2 = s3;
                }
                return s2;
            }
            String[] arr_s = zzhe.zzjy;
            for(int v1 = 0; v1 < arr_s.length; ++v1) {
                if(s.startsWith(arr_s[v1])) {
                    if(!zzhe.zzjx || zzhe.zzjr.isEmpty()) {
                        zzhe.zzjr.putAll(zzhe.zza(contentResolver0, zzhe.zzjy));
                        zzhe.zzjx = true;
                        if(zzhe.zzjr.containsKey(s)) {
                            String s4 = (String)zzhe.zzjr.get(s);
                            if(s4 != null) {
                                s2 = s4;
                            }
                            return s2;
                        }
                    }
                    return null;
                }
            }
        }
        Cursor cursor0 = contentResolver0.query(zzhe.CONTENT_URI, null, null, new String[]{s}, null);
        try {
            if(cursor0 != null && cursor0.moveToFirst()) {
                s5 = cursor0.getString(1);
                if(s5 != null && s5.equals(null)) {
                    s5 = null;
                }
                zzhe.zza(object0, s, s5);
                if(s5 != null) {
                    goto label_39;
                }
                goto label_40;
            }
            goto label_42;
        }
        catch(Throwable throwable0) {
            goto label_45;
        }
    label_39:
        s2 = s5;
    label_40:
        cursor0.close();
        return s2;
        try {
        label_42:
            zzhe.zza(object0, s, null);
        }
        catch(Throwable throwable0) {
        label_45:
            TWR.safeClose$NT(cursor0, throwable0);
            throw throwable0;
        }
        if(cursor0 != null) {
            cursor0.close();
        }
        return null;
    }

    private static Map zza(ContentResolver contentResolver0, String[] arr_s) {
        Cursor cursor0 = contentResolver0.query(zzhe.zzjn, null, null, arr_s, null);
        Map map0 = new TreeMap();
        if(cursor0 == null) {
            return map0;
        }
        while(true) {
            try {
                if(!cursor0.moveToNext()) {
                    break;
                }
                ((TreeMap)map0).put(cursor0.getString(0), cursor0.getString(1));
            }
            catch(Throwable throwable0) {
                TWR.safeClose$NT(cursor0, throwable0);
                throw throwable0;
            }
        }
        cursor0.close();
        return map0;
    }

    private static void zza(ContentResolver contentResolver0) {
        if(zzhe.zzjr == null) {
            zzhe.zzjq.set(false);
            zzhe.zzjr = new HashMap();
            zzhe.zzjw = new Object();
            zzhe.zzjx = false;
            zzhf zzhf0 = new zzhf(null);
            contentResolver0.registerContentObserver(zzhe.CONTENT_URI, true, zzhf0);
            return;
        }
        if(zzhe.zzjq.getAndSet(false)) {
            zzhe.zzjr.clear();
            zzhe.zzjs.clear();
            zzhe.zzjt.clear();
            zzhe.zzju.clear();
            zzhe.zzjv.clear();
            zzhe.zzjw = new Object();
            zzhe.zzjx = false;
        }
    }

    private static void zza(Object object0, String s, String s1) {
        synchronized(zzhe.class) {
            if(object0 == zzhe.zzjw) {
                zzhe.zzjr.put(s, s1);
            }
        }
    }

    public static boolean zza(ContentResolver contentResolver0, String s, boolean z) {
        Object object0 = zzhe.zzb(contentResolver0);
        HashMap hashMap0 = zzhe.zzjs;
        boolean z1 = true;
        Boolean boolean0 = Boolean.TRUE;
        Boolean boolean1 = (Boolean)zzhe.zza(hashMap0, s, Boolean.TRUE);
        if(boolean1 != null) {
            return boolean1.booleanValue();
        }
        String s1 = zzhe.zza(contentResolver0, s, null);
        if(s1 == null || s1.equals("")) {
            boolean0 = null;
        }
        else if(!zzhe.zzjo.matcher(s1).matches()) {
            if(zzhe.zzjp.matcher(s1).matches()) {
                z1 = false;
                boolean0 = Boolean.FALSE;
            }
            else {
                Log.w("Gservices", "attempt to read gservices key " + s + " (value \"" + s1 + "\") as boolean");
                boolean0 = null;
            }
        }
        synchronized(zzhe.class) {
            if(object0 == zzhe.zzjw) {
                hashMap0.put(s, boolean0);
                zzhe.zzjr.remove(s);
            }
            return z1;
        }
    }

    private static Object zzb(ContentResolver contentResolver0) {
        synchronized(zzhe.class) {
            zzhe.zza(contentResolver0);
            return zzhe.zzjw;
        }
    }
}

