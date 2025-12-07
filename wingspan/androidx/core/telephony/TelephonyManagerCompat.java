package androidx.core.telephony;

import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TelephonyManagerCompat {
    static class Api23Impl {
        static String getDeviceId(TelephonyManager telephonyManager0, int v) {
            return telephonyManager0.getDeviceId(v);
        }
    }

    static class Api26Impl {
        static String getImei(TelephonyManager telephonyManager0) {
            return telephonyManager0.getImei();
        }
    }

    static class Api30Impl {
        static int getSubscriptionId(TelephonyManager telephonyManager0) {
            return telephonyManager0.getSubscriptionId();
        }
    }

    private static Method sGetDeviceIdMethod;
    private static Method sGetSubIdMethod;

    public static String getImei(TelephonyManager telephonyManager0) {
        if(Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getImei(telephonyManager0);
        }
        int v = TelephonyManagerCompat.getSubscriptionId(telephonyManager0);
        return v == -1 || v == 0x7FFFFFFF ? telephonyManager0.getDeviceId() : Api23Impl.getDeviceId(telephonyManager0, SubscriptionManagerCompat.getSlotIndex(v));
    }

    public static int getSubscriptionId(TelephonyManager telephonyManager0) {
        if(Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.getSubscriptionId(telephonyManager0);
        }
        try {
            if(TelephonyManagerCompat.sGetSubIdMethod == null) {
                Method method0 = TelephonyManager.class.getDeclaredMethod("getSubId");
                TelephonyManagerCompat.sGetSubIdMethod = method0;
                method0.setAccessible(true);
            }
            Integer integer0 = (Integer)TelephonyManagerCompat.sGetSubIdMethod.invoke(telephonyManager0);
            if(integer0 != null && ((int)integer0) != -1) {
                return (int)integer0;
            }
        }
        catch(InvocationTargetException | IllegalAccessException | NoSuchMethodException unused_ex) {
        }
        return 0x7FFFFFFF;
    }
}

