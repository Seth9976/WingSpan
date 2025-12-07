package com.google.firebase;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.Build;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatController;
import com.google.firebase.platforminfo.DefaultUserAgentPublisher;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.ArrayList;
import java.util.List;

public class FirebaseCommonRegistrar implements ComponentRegistrar {
    private static final String ANDROID_INSTALLER = "android-installer";
    private static final String ANDROID_PLATFORM = "android-platform";
    private static final String DEVICE_BRAND = "device-brand";
    private static final String DEVICE_MODEL = "device-model";
    private static final String DEVICE_NAME = "device-name";
    private static final String FIREBASE_ANDROID = "fire-android";
    private static final String FIREBASE_COMMON = "fire-core";
    private static final String KOTLIN = "kotlin";
    private static final String MIN_SDK = "android-min-sdk";
    private static final String TARGET_SDK = "android-target-sdk";

    @Override  // com.google.firebase.components.ComponentRegistrar
    public List getComponents() {
        List list0 = new ArrayList();
        list0.add(DefaultUserAgentPublisher.component());
        list0.add(DefaultHeartBeatController.component());
        list0.add(LibraryVersionComponent.create("fire-android", "33"));
        list0.add(LibraryVersionComponent.create("fire-core", "20.2.0"));
        list0.add(LibraryVersionComponent.create("device-name", FirebaseCommonRegistrar.safeValue(Build.PRODUCT)));
        list0.add(LibraryVersionComponent.create("device-model", FirebaseCommonRegistrar.safeValue(Build.DEVICE)));
        list0.add(LibraryVersionComponent.create("device-brand", FirebaseCommonRegistrar.safeValue(Build.BRAND)));
        list0.add(LibraryVersionComponent.fromContext("android-target-sdk", (Context context0) -> (context0.getApplicationInfo() == null ? "" : "34")));
        list0.add(LibraryVersionComponent.fromContext("android-min-sdk", (Context context0) -> {
            ApplicationInfo applicationInfo0 = context0.getApplicationInfo();
            return applicationInfo0 == null || Build.VERSION.SDK_INT < 24 ? "" : String.valueOf(applicationInfo0.minSdkVersion);
        }));
        list0.add(LibraryVersionComponent.fromContext("android-platform", (Context context0) -> {
            if(context0.getPackageManager().hasSystemFeature("android.hardware.type.television")) {
                return "tv";
            }
            if(context0.getPackageManager().hasSystemFeature("android.hardware.type.watch")) {
                return "watch";
            }
            if(context0.getPackageManager().hasSystemFeature("android.hardware.type.automotive")) {
                return "auto";
            }
            return Build.VERSION.SDK_INT < 26 || !context0.getPackageManager().hasSystemFeature("android.hardware.type.embedded") ? "" : "embedded";
        }));
        list0.add(LibraryVersionComponent.fromContext("android-installer", (Context context0) -> {
            String s = context0.getPackageManager().getInstallerPackageName("com.MonsterCouch.Wingspan");
            return s == null ? "" : FirebaseCommonRegistrar.safeValue(s);
        }));
        list0.add(LibraryVersionComponent.create("kotlin", "1.7.21"));
        return list0;
    }

    // 检测为 Lambda 实现
    static String lambda$getComponents$0(Context context0) [...]

    // 检测为 Lambda 实现
    static String lambda$getComponents$1(Context context0) [...]

    // 检测为 Lambda 实现
    static String lambda$getComponents$2(Context context0) [...]

    // 检测为 Lambda 实现
    static String lambda$getComponents$3(Context context0) [...]

    private static String safeValue(String s) {
        return s.replace(' ', '_').replace('/', '_');
    }
}

