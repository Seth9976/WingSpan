package com.gameanalytics.sdk;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.gameanalytics.sdk.device.GADevice;
import com.gameanalytics.sdk.errorreporter.ExceptionReporter;
import com.gameanalytics.sdk.logging.GALogger;
import com.gameanalytics.sdk.state.GAState;
import com.gameanalytics.sdk.utilities.Reflection;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GAPlatform {
    public static class FunctionInfo {
        static final int UNKNOWN_LINE = -1;
        public boolean appendModuleClassToMethodName;
        public String javaClass;
        public int line;
        public String method;
        public String module;

        public FunctionInfo() {
            this.module = "";
            this.method = "";
            this.javaClass = "";
            this.line = -1;
            this.appendModuleClassToMethodName = true;
            try {
                StackTraceElement[] arr_stackTraceElement = Thread.currentThread().getStackTrace();
                int v;
                for(v = 3; v < arr_stackTraceElement.length && arr_stackTraceElement[v].toString().contains("com.gameanalytics.sdk"); ++v) {
                }
                this.method = arr_stackTraceElement[v].getMethodName();
                this.line = arr_stackTraceElement[v].getLineNumber();
                this.javaClass = arr_stackTraceElement[v].getClassName();
                this.module = Class.forName(arr_stackTraceElement[v].getClassName()).getPackage().getName();
                if(this.appendModuleClassToMethodName && this.method != null && this.javaClass != null) {
                    this.method = this.javaClass + '.' + this.method;
                }
            }
            catch(ClassNotFoundException classNotFoundException0) {
                classNotFoundException0.printStackTrace();
            }
            catch(Throwable throwable0) {
                throwable0.printStackTrace();
            }
        }
    }

    private static String activityId = "";
    private static WeakReference activityRef;
    private static Context appContext;
    private static boolean initialized;
    private static boolean registered;
    private static boolean usedResumed;
    private static boolean usedStopped;

    static {
    }

    static boolean access$100() [...] // 潜在的解密器

    static boolean access$200() [...] // 潜在的解密器

    static void access$300(Activity activity0) {
        GAPlatform.onActivityResumed(activity0);
    }

    // 去混淆评级： 低(20)
    static String access$500() [...] // 潜在的解密器

    static boolean access$600() [...] // 潜在的解密器

    static boolean access$602(boolean z) {
        GAPlatform.registered = z;
        return z;
    }

    static Context access$700() {
        return GAPlatform.appContext;
    }

    private static String bytesToHex(byte[] bytes) {
        if(bytes.length == 0) {
            return "";
        }
        StringBuilder stringBuilder0 = new StringBuilder(String.format("%02x", ((byte)bytes[0])));
        for(int v = 1; v < bytes.length; ++v) {
            stringBuilder0.append(String.format("%02x", ((byte)bytes[v])));
        }
        return stringBuilder0.toString();
    }

    public static boolean checkReadAndWriteExternalPermission(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0 && context.checkCallingOrSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0;
    }

    private static boolean checkReadPhoneStatePermission() {
        return GAPlatform.appContext.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0;
    }

    private static boolean checkRootMethod1() [...] // 潜在的解密器

    private static boolean checkRootMethod2() {
        return new File("/system/app/Superuser.apk").exists();
    }

    private static boolean checkRootMethod3() {
        for(int v = 0; v < 8; ++v) {
            if(new File(new String[]{"/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su"}[v]).exists()) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkRootMethod4() {
        Process process0 = null;
        try {
            process0 = Runtime.getRuntime().exec(new String[]{"/system/xbin/which", "su"});
            if(new BufferedReader(new InputStreamReader(process0.getInputStream())).readLine() != null) {
                goto label_7;
            }
            goto label_9;
        }
        catch(Throwable unused_ex) {
            if(process0 != null) {
                process0.destroy();
            }
            return false;
        }
    label_7:
        process0.destroy();
        return true;
    label_9:
        process0.destroy();
        return false;
    }

    private static int getAppBuild() {
        try {
            return GAPlatform.getVersionCode(GAPlatform.appContext.getPackageManager().getPackageInfo("com.MonsterCouch.Wingspan", 0));
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
            return 0;
        }
    }

    private static String getAppVersion() {
        try {
            return GAPlatform.appContext.getPackageManager().getPackageInfo("com.MonsterCouch.Wingspan", 0).versionName;
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
            return null;
        }
    }

    public static Context getApplicationContext() {
        return GAPlatform.appContext;
    }

    // 去混淆评级： 低(20)
    private static String getBundleIdentifier() {
        return "com.MonsterCouch.Wingspan";
    }

    private static String getConnectionType() {
        return Build.VERSION.SDK_INT < 28 ? GAPlatform.getConnectionType23AndAbove() : GAPlatform.getConnectionType28AndAbove();
    }

    private static String getConnectionType22AndBelow() {
        ConnectivityManager connectivityManager0 = (ConnectivityManager)GAPlatform.appContext.getSystemService("connectivity");
        if(connectivityManager0 != null) {
            NetworkInfo networkInfo0 = connectivityManager0.getNetworkInfo(1);
            NetworkInfo networkInfo1 = connectivityManager0.getNetworkInfo(0);
            if(networkInfo0 != null && networkInfo0.isConnected()) {
                return "wifi";
            }
            return networkInfo1 == null || !networkInfo1.isConnected() ? "offline" : "wwan";
        }
        return "offline";
    }

    private static String getConnectionType23AndAbove() {
        ConnectivityManager connectivityManager0 = (ConnectivityManager)GAPlatform.appContext.getSystemService("connectivity");
        if(connectivityManager0 != null) {
            Network[] arr_network = connectivityManager0.getAllNetworks();
            for(int v = 0; v < arr_network.length; ++v) {
                NetworkCapabilities networkCapabilities0 = connectivityManager0.getNetworkCapabilities(arr_network[v]);
                if(networkCapabilities0 != null && networkCapabilities0.hasTransport(1)) {
                    return "wifi";
                }
                if(networkCapabilities0 != null && networkCapabilities0.hasTransport(0)) {
                    return "wwan";
                }
            }
        }
        return "offline";
    }

    private static String getConnectionType28AndAbove() {
        ConnectivityManager connectivityManager0 = (ConnectivityManager)GAPlatform.appContext.getSystemService("connectivity");
        if(connectivityManager0 != null) {
            Network[] arr_network = connectivityManager0.getAllNetworks();
            for(int v = 0; v < arr_network.length; ++v) {
                NetworkCapabilities networkCapabilities0 = connectivityManager0.getNetworkCapabilities(arr_network[v]);
                if(networkCapabilities0 != null && networkCapabilities0.hasTransport(1)) {
                    return "wifi";
                }
                if(networkCapabilities0 != null && networkCapabilities0.hasTransport(0)) {
                    return "wwan";
                }
            }
        }
        return "offline";
    }

    private static int getVersionCode(PackageInfo info) {
        return Build.VERSION.SDK_INT < 28 ? GAPlatform.getVersionCode27AndBelow(info) : GAPlatform.getVersionCode28AndAbove(info);
    }

    private static int getVersionCode27AndBelow(PackageInfo info) {
        return info.versionCode;
    }

    private static int getVersionCode28AndAbove(PackageInfo info) {
        return (int)info.getLongVersionCode();
    }

    public static void initialize(Activity activity) {
        String s;
        if(GAPlatform.initialized) {
            return;
        }
        if(activity == null) {
            GALogger.w("Cannot initialize as activity is null");
            return;
        }
        GAPlatform.initialized = true;
        GAPlatform.activityId = activity.getClass().getCanonicalName();
        Context context0 = activity.getApplicationContext();
        GAPlatform.appContext = context0;
        GAPlatform.checkReadAndWriteExternalPermission(context0);
        if(GAPlatform.appContext.getExternalCacheDir() != null && !GAPlatform.isInstantApp(GAPlatform.appContext)) {
            GALogger.d("Using getExternalCacheDir()");
            s = GAPlatform.appContext.getExternalCacheDir().getPath();
        }
        else if(GAPlatform.appContext.getCacheDir() == null) {
            GALogger.d("Using getFilesDir()");
            s = GAPlatform.appContext.getFilesDir().getPath();
        }
        else {
            GALogger.d("Using getCacheDir()");
            s = GAPlatform.appContext.getCacheDir().getPath();
        }
        GameAnalytics.configureWritableFilePath(s);
        GameAnalytics.configureIsHacked(GAPlatform.isDeviceRooted());
        GAPlatform.updateAppSignature();
        GAPlatform.updateChannelId();
        GameAnalytics.setConnectionType(GAPlatform.getConnectionType());
        com.gameanalytics.sdk.GAPlatform.1 gAPlatform$10 = new BroadcastReceiver() {
            @Override  // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                GameAnalytics.setConnectionType(GAPlatform.getConnectionType());
            }
        };
        if(!GAPlatform.registered) {
            GAPlatform.appContext.registerReceiver(gAPlatform$10, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            GAPlatform.registered = true;
        }
        activity.getApplication().registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override  // android.app.Application$ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            }

            @Override  // android.app.Application$ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                String s = activity.getClass().getCanonicalName();
                GALogger.d(("onActivityDestroyed: " + s + " -- " + ""));
                if(s.equals("")) {
                    GALogger.d(("onActivityDestroyed: " + activity));
                    GAPlatform.onActivityStopped(activity);
                }
            }

            @Override  // android.app.Application$ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                GALogger.d(("onActivityPaused: " + activity.getClass().getCanonicalName()));
                GAPlatform.usedResumed = false;
                GAPlatform.usedStopped = false;
            }

            @Override  // android.app.Application$ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                String s = activity.getClass().getCanonicalName();
                GAPlatform.usedResumed = true;
                GALogger.d(("onActivityResumed: " + s + ", usedResumed=" + false + ", usedStopped=" + false));
                GAPlatform.usedStopped = false;
            }

            @Override  // android.app.Application$ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            }

            @Override  // android.app.Application$ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
            }

            @Override  // android.app.Application$ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                String s = activity.getClass().getCanonicalName();
                GAPlatform.usedStopped = true;
                GALogger.d(("onActivityStopped: " + s + ", usedResumed=" + false + ", usedStopped=" + false));
                GAPlatform.onActivityStopped(activity);
            }
        });
        GameAnalytics.setBundleIdentifier(GAPlatform.getBundleIdentifier());
        GameAnalytics.setAppVersion(GAPlatform.getAppVersion());
        GameAnalytics.setAppBuild(GAPlatform.getAppBuild());
        if(GAState.useErrorReporting()) {
            ExceptionReporter.register(GAPlatform.appContext);
        }
        GAPlatform.activityRef = new WeakReference(activity);
    }

    // 去混淆评级： 中等(60)
    private static boolean isDeviceRooted() {
        return GAPlatform.checkRootMethod2() || GAPlatform.checkRootMethod3() || GAPlatform.checkRootMethod4();
    }

    static boolean isInitialized() [...] // 潜在的解密器

    private static boolean isInstantApp(Context context) {
        Boolean boolean0 = Reflection.isInstantApp(context);
        return boolean0 != null && boolean0.booleanValue();
    }

    public static boolean isReadPhoneStatePermissionPresentInManifest(Context context) {
        int v;
        try {
            PackageInfo packageInfo0 = context.getPackageManager().getPackageInfo("com.MonsterCouch.Wingspan", 0x1000);
            String[] arr_s = packageInfo0 == null ? null : packageInfo0.requestedPermissions;
            if(arr_s != null && arr_s.length > 0) {
                for(v = 0; true; ++v) {
                    if(v >= arr_s.length) {
                        break;
                    }
                    if(arr_s[v].equals("android.permission.READ_PHONE_STATE")) {
                        return true;
                    }
                }
            }
        }
        catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
            packageManager$NameNotFoundException0.printStackTrace();
        }
        return false;
    }

    private static void onActivityResumed(Activity activity) {
        if(GAState.useManualSessionHandling()) {
            GALogger.i("onActivityResumed: Not calling GameAnalytics.onResume() as using manual session handling");
        }
        else {
            GameAnalytics.onResume();
        }
        GAState.setInForeground(true);
    }

    private static void onActivityStopped(Activity activity) {
        if(GAState.useManualSessionHandling()) {
            GALogger.i("onActivityStopped: Not calling GameAnalytics.onStop() as using manual session handling");
        }
        else {
            GameAnalytics.onStop();
        }
        GAState.setInForeground(false);
    }

    static void setLimitAdTrackingEnabled(boolean limitedAdTracking) {
        GameAnalytics.configureIsLimitedAdTracking(limitedAdTracking);
    }

    private static void updateAppSignature() {
        if(Build.VERSION.SDK_INT >= 28) {
            GAPlatform.updateAppSignature28AndAbove();
            return;
        }
        GAPlatform.updateAppSignature27AndBelow();
    }

    private static void updateAppSignature27AndBelow() {
        try {
            PackageInfo packageInfo0 = GAPlatform.appContext.getPackageManager().getPackageInfo("com.MonsterCouch.Wingspan", 0x40);
            MessageDigest messageDigest0 = MessageDigest.getInstance("SHA");
            Signature[] arr_signature = packageInfo0.signatures;
            if(arr_signature.length > 0) {
                messageDigest0.update(arr_signature[0].toByteArray());
                GADevice.setAppSignature(new String(GAPlatform.bytesToHex(messageDigest0.digest())));
            }
        }
        catch(PackageManager.NameNotFoundException | NoSuchAlgorithmException | Exception unused_ex) {
        }
    }

    private static void updateAppSignature28AndAbove() {
        try {
            Signature[] arr_signature = GAPlatform.appContext.getPackageManager().getPackageInfo("com.MonsterCouch.Wingspan", 0x8000000).signingInfo.getApkContentsSigners();
            MessageDigest messageDigest0 = MessageDigest.getInstance("SHA");
            if(arr_signature.length > 0) {
                messageDigest0.update(arr_signature[0].toByteArray());
                GADevice.setAppSignature(new String(GAPlatform.bytesToHex(messageDigest0.digest())));
            }
        }
        catch(PackageManager.NameNotFoundException | NoSuchAlgorithmException | Exception unused_ex) {
        }
    }

    private static void updateChannelId() {
        PackageManager packageManager0 = GAPlatform.appContext.getPackageManager();
        try {
            GADevice.setChannelId(packageManager0.getInstallerPackageName(packageManager0.getApplicationInfo("com.MonsterCouch.Wingspan", 0).packageName));
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
        }
    }
}

