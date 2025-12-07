package com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.Badger;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.ShortcutBadgeException;
import java.util.Collections;
import java.util.List;

public class ZukHomeBadger implements Badger {
    private final Uri CONTENT_URI;

    public ZukHomeBadger() {
        this.CONTENT_URI = Uri.parse("content://com.android.badge/badge");
    }

    @Override  // com.onesignal.notifications.internal.badges.impl.shortcutbadger.Badger
    public void executeBadge(Context context0, ComponentName componentName0, int v) throws ShortcutBadgeException {
        Bundle bundle0 = new Bundle();
        bundle0.putInt("app_badge_count", v);
        context0.getContentResolver().call(this.CONTENT_URI, "setAppBadgeCount", null, bundle0);
    }

    @Override  // com.onesignal.notifications.internal.badges.impl.shortcutbadger.Badger
    public List getSupportLaunchers() {
        return Collections.singletonList("com.zui.launcher");
    }
}

