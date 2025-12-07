package com.onesignal.notifications.internal.common;

import android.content.Context;
import com.onesignal.common.AndroidUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000E\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006J\u000E\u0010\u0007\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006¨\u0006\b"}, d2 = {"Lcom/onesignal/notifications/internal/common/OSNotificationOpenAppSettings;", "", "()V", "getShouldOpenActivity", "", "context", "Landroid/content/Context;", "getSuppressLaunchURL", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class OSNotificationOpenAppSettings {
    public static final OSNotificationOpenAppSettings INSTANCE;

    static {
        OSNotificationOpenAppSettings.INSTANCE = new OSNotificationOpenAppSettings();
    }

    public final boolean getShouldOpenActivity(Context context0) {
        Intrinsics.checkNotNullParameter(context0, "context");
        return !Intrinsics.areEqual("DISABLE", AndroidUtils.INSTANCE.getManifestMeta(context0, "com.onesignal.NotificationOpened.DEFAULT"));
    }

    public final boolean getSuppressLaunchURL(Context context0) {
        Intrinsics.checkNotNullParameter(context0, "context");
        return AndroidUtils.INSTANCE.getManifestMetaBoolean(context0, "com.onesignal.suppressLaunchURLs");
    }
}

