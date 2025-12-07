package com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl;

import android.content.AsyncQueryHandler;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.Badger;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.ShortcutBadgeException;
import java.util.Arrays;
import java.util.List;

public class SonyHomeBadger implements Badger {
    private final Uri BADGE_CONTENT_URI;
    private static final String INTENT_ACTION = "com.sonyericsson.home.action.UPDATE_BADGE";
    private static final String INTENT_EXTRA_ACTIVITY_NAME = "com.sonyericsson.home.intent.extra.badge.ACTIVITY_NAME";
    private static final String INTENT_EXTRA_MESSAGE = "com.sonyericsson.home.intent.extra.badge.MESSAGE";
    private static final String INTENT_EXTRA_PACKAGE_NAME = "com.sonyericsson.home.intent.extra.badge.PACKAGE_NAME";
    private static final String INTENT_EXTRA_SHOW_MESSAGE = "com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE";
    private static final String PROVIDER_COLUMNS_ACTIVITY_NAME = "activity_name";
    private static final String PROVIDER_COLUMNS_BADGE_COUNT = "badge_count";
    private static final String PROVIDER_COLUMNS_PACKAGE_NAME = "package_name";
    private static final String PROVIDER_CONTENT_URI = "content://com.sonymobile.home.resourceprovider/badge";
    private static final String SONY_HOME_PROVIDER_NAME = "com.sonymobile.home.resourceprovider";
    private AsyncQueryHandler mQueryHandler;

    public SonyHomeBadger() {
        this.BADGE_CONTENT_URI = Uri.parse("content://com.sonymobile.home.resourceprovider/badge");
    }

    private ContentValues createContentValues(int v, ComponentName componentName0) {
        ContentValues contentValues0 = new ContentValues();
        contentValues0.put("badge_count", v);
        contentValues0.put("package_name", componentName0.getPackageName());
        contentValues0.put("activity_name", componentName0.getClassName());
        return contentValues0;
    }

    @Override  // com.onesignal.notifications.internal.badges.impl.shortcutbadger.Badger
    public void executeBadge(Context context0, ComponentName componentName0, int v) throws ShortcutBadgeException {
        if(SonyHomeBadger.sonyBadgeContentProviderExists(context0)) {
            this.executeBadgeByContentProvider(context0, componentName0, v);
            return;
        }
        SonyHomeBadger.executeBadgeByBroadcast(context0, componentName0, v);
    }

    private static void executeBadgeByBroadcast(Context context0, ComponentName componentName0, int v) {
        Intent intent0 = new Intent("com.sonyericsson.home.action.UPDATE_BADGE");
        intent0.putExtra("com.sonyericsson.home.intent.extra.badge.PACKAGE_NAME", componentName0.getPackageName());
        intent0.putExtra("com.sonyericsson.home.intent.extra.badge.ACTIVITY_NAME", componentName0.getClassName());
        intent0.putExtra("com.sonyericsson.home.intent.extra.badge.MESSAGE", String.valueOf(v));
        intent0.putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE", v > 0);
        context0.sendBroadcast(intent0);
    }

    private void executeBadgeByContentProvider(Context context0, ComponentName componentName0, int v) {
        if(v < 0) {
            return;
        }
        ContentValues contentValues0 = this.createContentValues(v, componentName0);
        if(Looper.myLooper() == Looper.getMainLooper()) {
            if(this.mQueryHandler == null) {
                this.mQueryHandler = new AsyncQueryHandler(context0.getApplicationContext().getContentResolver()) {
                };
            }
            this.insertBadgeAsync(contentValues0);
            return;
        }
        this.insertBadgeSync(context0, contentValues0);
    }

    @Override  // com.onesignal.notifications.internal.badges.impl.shortcutbadger.Badger
    public List getSupportLaunchers() {
        return Arrays.asList(new String[]{"com.sonyericsson.home", "com.sonymobile.home"});
    }

    private void insertBadgeAsync(ContentValues contentValues0) {
        this.mQueryHandler.startInsert(0, null, this.BADGE_CONTENT_URI, contentValues0);
    }

    private void insertBadgeSync(Context context0, ContentValues contentValues0) {
        context0.getApplicationContext().getContentResolver().insert(this.BADGE_CONTENT_URI, contentValues0);
    }

    private static boolean sonyBadgeContentProviderExists(Context context0) {
        return context0.getPackageManager().resolveContentProvider("com.sonymobile.home.resourceprovider", 0) != null;
    }
}

