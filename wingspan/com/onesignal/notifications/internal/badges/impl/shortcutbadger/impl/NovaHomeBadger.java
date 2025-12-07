package com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.Badger;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.ShortcutBadgeException;
import java.util.Arrays;
import java.util.List;

public class NovaHomeBadger implements Badger {
    private static final String CONTENT_URI = "content://com.teslacoilsw.notifier/unread_count";
    private static final String COUNT = "count";
    private static final String TAG = "tag";

    @Override  // com.onesignal.notifications.internal.badges.impl.shortcutbadger.Badger
    public void executeBadge(Context context0, ComponentName componentName0, int v) throws ShortcutBadgeException {
        ContentValues contentValues0 = new ContentValues();
        contentValues0.put("tag", componentName0.getPackageName() + "/" + componentName0.getClassName());
        contentValues0.put("count", v);
        context0.getContentResolver().insert(Uri.parse("content://com.teslacoilsw.notifier/unread_count"), contentValues0);
    }

    @Override  // com.onesignal.notifications.internal.badges.impl.shortcutbadger.Badger
    public List getSupportLaunchers() {
        return Arrays.asList(new String[]{"com.teslacoilsw.launcher"});
    }
}

