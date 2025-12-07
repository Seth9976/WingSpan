package com.onesignal.location.internal.permissions;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000E\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/onesignal/location/internal/permissions/NavigateToAndroidSettingsForLocation;", "", "()V", "show", "", "context", "Landroid/content/Context;", "com.onesignal.location"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class NavigateToAndroidSettingsForLocation {
    public static final NavigateToAndroidSettingsForLocation INSTANCE;

    static {
        NavigateToAndroidSettingsForLocation.INSTANCE = new NavigateToAndroidSettingsForLocation();
    }

    public final void show(Context context0) {
        Intrinsics.checkNotNullParameter(context0, "context");
        Intent intent0 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent0.setData(Uri.parse("package:com.MonsterCouch.Wingspan"));
        context0.startActivity(intent0);
    }
}

