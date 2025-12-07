package com.gameanalytics.sdk.utilities;

import android.content.Context;
import com.gameanalytics.sdk.device.GADevice;
import com.gameanalytics.sdk.logging.GALogger;
import java.lang.reflect.Method;

public class Reflection {
    public static String getAdId(String packageName, Context context) {
        if(GADevice.doTrackGAID) {
            try {
                return (String)Reflection.invokeInstanceMethod(Reflection.getAdvertisingInfoObject(packageName, context), "getId", null, new Object[0]);
            }
            catch(Throwable throwable0) {
                throwable0.printStackTrace();
            }
        }
        return null;
    }

    private static Object getAdvertisingInfoObject(String packageName, Context context) throws Exception {
        return Reflection.invokeStaticMethod((packageName + ".AdvertisingIdClient"), "getAdvertisingIdInfo", new Class[]{Context.class}, new Object[]{context});
    }

    public static Object invokeInstanceMethod(Object instance, String methodName, Class[] cArgs, Object[] args) throws Exception {
        return Reflection.invokeMethod(instance.getClass(), methodName, instance, cArgs, args);
    }

    public static Object invokeMethod(Class classObject, String methodName, Object instance, Class[] cArgs, Object[] args) throws Exception {
        Method method0 = classObject.getMethod(methodName, cArgs);
        return method0 == null ? null : method0.invoke(instance, args);
    }

    public static Object invokeStaticMethod(String className, String methodName, Class[] cArgs, Object[] args) throws Exception {
        return Reflection.invokeMethod(Class.forName(className), methodName, null, cArgs, args);
    }

    public static Boolean isInstantApp(Context context) {
        try {
            return (Boolean)Reflection.invokeStaticMethod("com.google.android.instantapps.InstantApps", "isInstantApp", new Class[]{Context.class}, new Object[]{context});
        }
        catch(Throwable throwable0) {
            GALogger.d(("Could not find \'com.google.android.instantapps.InstantApps\' class with \'isInstantApp\' method: " + throwable0.toString()));
            return null;
        }
    }

    public static Boolean isLimitAdTrackingEnabled(String packageName, Context context) {
        try {
            return (Boolean)Reflection.invokeInstanceMethod(Reflection.getAdvertisingInfoObject(packageName, context), "isLimitAdTrackingEnabled", null, new Object[0]);
        }
        catch(Throwable unused_ex) {
            return null;
        }
    }
}

