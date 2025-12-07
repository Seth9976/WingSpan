package com.google.android.instantapps;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri.Builder;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class InstantApps {
    static class PackageManagerWrapper {
        private static Method isInstantAppMethod;
        private final PackageManager packageManager;

        PackageManagerWrapper(PackageManager packageManager) {
            this.packageManager = packageManager;
        }

        Boolean isInstantApp() {
            if(PackageManagerWrapper.isInstantAppMethod == null) {
                try {
                    PackageManagerWrapper.isInstantAppMethod = PackageManager.class.getDeclaredMethod("isInstantApp");
                }
                catch(NoSuchMethodException unused_ex) {
                    return null;
                }
            }
            try {
                return (Boolean)PackageManagerWrapper.isInstantAppMethod.invoke(this.packageManager);
            }
            catch(InvocationTargetException | IllegalAccessException unused_ex) {
                return null;
            }
        }
    }

    static final String ACTION_QUICK_INSTALL = "com.google.android.finsky.action.IA_INSTALL";
    private static final String EXTRA_POST_INSTALL_INTENT = "postInstallIntent";
    private static Boolean isInstantApp;
    private static Context lastApplicationContext;
    private static PackageManagerWrapper packageManagerWrapper;

    static {
    }

    // 去混淆评级： 低(20)
    static boolean access$000() [...] // 潜在的解密器

    private static boolean isAtLeastO() [...] // 潜在的解密器

    public static boolean isInstantApp(Context context) {
        if(context == null) {
            throw new IllegalArgumentException("Context must be non-null");
        }
        Context context1 = context.getApplicationContext();
        if(context1 != null) {
            if(InstantApps.isInstantApp != null && context1.equals(InstantApps.lastApplicationContext)) {
                return InstantApps.isInstantApp.booleanValue();
            }
            InstantApps.isInstantApp = null;
            if(InstantApps.packageManagerWrapper == null || !context1.equals(InstantApps.lastApplicationContext)) {
                InstantApps.packageManagerWrapper = new PackageManagerWrapper(context1.getPackageManager());
            }
            Boolean boolean0 = InstantApps.packageManagerWrapper.isInstantApp();
            InstantApps.lastApplicationContext = context1;
            if(boolean0 != null) {
                InstantApps.isInstantApp = boolean0;
                return InstantApps.isInstantApp.booleanValue();
            }
            try {
                context1.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                InstantApps.isInstantApp = Boolean.TRUE;
                return InstantApps.isInstantApp.booleanValue();
            }
            catch(ClassNotFoundException unused_ex) {
                InstantApps.isInstantApp = Boolean.FALSE;
                return false;
            }
        }
        throw new IllegalStateException("Application context is null!");
    }

    @Deprecated
    public static boolean showInstallPrompt(Activity activity, int requestCode, String referrer) {
        return InstantApps.showInstallPromptImpl(activity, null, requestCode, referrer);
    }

    public static boolean showInstallPrompt(Activity activity, Intent postInstallIntent, int requestCode, String referrer) {
        return InstantApps.showInstallPromptImpl(activity, postInstallIntent, requestCode, referrer);
    }

    private static boolean showInstallPromptFallback(Activity activity, int requestCode, String referrer) {
        Intent intent0 = new Intent("android.intent.action.VIEW").setPackage("com.android.vending").addCategory("android.intent.category.DEFAULT").putExtra("callerId", "com.MonsterCouch.Wingspan").putExtra("overlay", true);
        Uri.Builder uri$Builder0 = new Uri.Builder().scheme("market").authority("details").appendQueryParameter("id", "com.MonsterCouch.Wingspan");
        if(!TextUtils.isEmpty(referrer)) {
            uri$Builder0.appendQueryParameter("referrer", referrer);
        }
        intent0.setData(uri$Builder0.build());
        activity.startActivityForResult(intent0, requestCode);
        return true;
    }

    private static boolean showInstallPromptImpl(Activity activity, Intent postInstallIntent, int requestCode, String referrer) {
        if(activity == null) {
            throw new IllegalArgumentException("Activity must not be null");
        }
        if(!InstantApps.isInstantApp(activity)) {
            return false;
        }
        Uri.Builder uri$Builder0 = new Uri.Builder().scheme("market").authority("details").appendQueryParameter("id", "com.MonsterCouch.Wingspan");
        if(!TextUtils.isEmpty(referrer)) {
            uri$Builder0.appendQueryParameter("referrer", referrer);
        }
        Intent intent1 = new Intent("com.google.android.finsky.action.IA_INSTALL").setData(uri$Builder0.build()).setPackage("com.android.vending");
        intent1.putExtra("postInstallIntent", postInstallIntent);
        return postInstallIntent == null || !InstantApps.storeSupportsQuickInstall(activity, intent1) ? InstantApps.showInstallPromptFallback(activity, requestCode, referrer) : InstantApps.showInstallPromptImplWithIntent(activity, intent1, requestCode);
    }

    private static boolean showInstallPromptImplWithIntent(Activity activity, Intent intent, int requestCode) {
        activity.startActivityForResult(intent, requestCode);
        return true;
    }

    private static boolean storeSupportsQuickInstall(Context context, Intent intent) {
        return context.getPackageManager().resolveActivity(intent, 0) != null;
    }
}

