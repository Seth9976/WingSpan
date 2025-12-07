package com.onesignal.notifications.internal.permissions.impl;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000E\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/onesignal/notifications/internal/permissions/impl/NavigateToAndroidSettingsForNotifications;", "", "()V", "show", "", "context", "Landroid/content/Context;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class NavigateToAndroidSettingsForNotifications {
    public static final NavigateToAndroidSettingsForNotifications INSTANCE;

    static {
        NavigateToAndroidSettingsForNotifications.INSTANCE = new NavigateToAndroidSettingsForNotifications();
    }

    public final void show(Context context0) {
        Intrinsics.checkNotNullParameter(context0, "context");
        Intent intent0 = new Intent();
        intent0.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
        intent0.addFlags(0x10000000);
        intent0.putExtra("app_package", "com.MonsterCouch.Wingspan");
        intent0.putExtra("app_uid", context0.getApplicationInfo().uid);
        intent0.putExtra("android.provider.extra.APP_PACKAGE", "com.MonsterCouch.Wingspan");
        context0.startActivity(intent0);
    }
}

