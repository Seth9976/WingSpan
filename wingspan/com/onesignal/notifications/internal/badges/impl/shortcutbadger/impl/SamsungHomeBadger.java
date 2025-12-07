package com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.Badger;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.ShortcutBadgeException;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.util.CloseHelper;
import java.util.Arrays;
import java.util.List;

public class SamsungHomeBadger implements Badger {
    private static final String[] CONTENT_PROJECTION = null;
    private static final String CONTENT_URI = "content://com.sec.badge/apps?notify=true";
    private DefaultBadger defaultBadger;

    static {
        SamsungHomeBadger.CONTENT_PROJECTION = new String[]{"_id", "class"};
    }

    public SamsungHomeBadger() {
        this.defaultBadger = new DefaultBadger();
    }

    @Override  // com.onesignal.notifications.internal.badges.impl.shortcutbadger.Badger
    public void executeBadge(Context context0, ComponentName componentName0, int v) throws ShortcutBadgeException {
        Cursor cursor0;
        if(this.defaultBadger != null && this.defaultBadger.isSupported(context0)) {
            this.defaultBadger.executeBadge(context0, componentName0, v);
            return;
        }
        Uri uri0 = Uri.parse("content://com.sec.badge/apps?notify=true");
        ContentResolver contentResolver0 = context0.getContentResolver();
        try {
            String[] arr_s = {componentName0.getPackageName()};
            cursor0 = contentResolver0.query(uri0, SamsungHomeBadger.CONTENT_PROJECTION, "package=?", arr_s, null);
            if(cursor0 != null) {
                String s = componentName0.getClassName();
                boolean z = false;
                while(cursor0.moveToNext()) {
                    int v2 = cursor0.getInt(0);
                    contentResolver0.update(uri0, this.getContentValues(componentName0, v, false), "_id=?", new String[]{String.valueOf(v2)});
                    if(s.equals(cursor0.getString(cursor0.getColumnIndex("class")))) {
                        z = true;
                    }
                }
                if(!z) {
                    contentResolver0.insert(uri0, this.getContentValues(componentName0, v, true));
                }
            }
        }
        finally {
            CloseHelper.close(cursor0);
        }
    }

    private ContentValues getContentValues(ComponentName componentName0, int v, boolean z) {
        ContentValues contentValues0 = new ContentValues();
        if(z) {
            contentValues0.put("package", componentName0.getPackageName());
            contentValues0.put("class", componentName0.getClassName());
        }
        contentValues0.put("badgecount", v);
        return contentValues0;
    }

    @Override  // com.onesignal.notifications.internal.badges.impl.shortcutbadger.Badger
    public List getSupportLaunchers() {
        return Arrays.asList(new String[]{"com.sec.android.app.launcher", "com.sec.android.app.twlauncher"});
    }
}

