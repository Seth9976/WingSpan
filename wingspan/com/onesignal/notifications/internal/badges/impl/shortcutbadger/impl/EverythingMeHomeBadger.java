package com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.Badger;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.ShortcutBadgeException;
import java.util.Arrays;
import java.util.List;

public class EverythingMeHomeBadger implements Badger {
    private static final String COLUMN_ACTIVITY_NAME = "activity_name";
    private static final String COLUMN_COUNT = "count";
    private static final String COLUMN_PACKAGE_NAME = "package_name";
    private static final String CONTENT_URI = "content://me.everything.badger/apps";

    @Override  // com.onesignal.notifications.internal.badges.impl.shortcutbadger.Badger
    public void executeBadge(Context context0, ComponentName componentName0, int v) throws ShortcutBadgeException {
        ContentValues contentValues0 = new ContentValues();
        contentValues0.put("package_name", componentName0.getPackageName());
        contentValues0.put("activity_name", componentName0.getClassName());
        contentValues0.put("count", v);
        context0.getContentResolver().insert(Uri.parse("content://me.everything.badger/apps"), contentValues0);
    }

    @Override  // com.onesignal.notifications.internal.badges.impl.shortcutbadger.Badger
    public List getSupportLaunchers() {
        return Arrays.asList(new String[]{"me.everything.launcher"});
    }
}

