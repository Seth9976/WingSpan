package com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.Badger;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.ShortcutBadgeException;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.util.BroadcastHelper;
import java.util.Collections;
import java.util.List;

public class OPPOHomeBader implements Badger {
    private static final String INTENT_ACTION = "com.oppo.unsettledevent";
    private static final String INTENT_EXTRA_BADGEUPGRADE_COUNT = "app_badge_count";
    private static final String INTENT_EXTRA_BADGE_COUNT = "number";
    private static final String INTENT_EXTRA_BADGE_UPGRADENUMBER = "upgradeNumber";
    private static final String INTENT_EXTRA_PACKAGENAME = "pakeageName";
    private static final String PROVIDER_CONTENT_URI = "content://com.android.badge/badge";
    private int mCurrentTotalCount;

    public OPPOHomeBader() {
        this.mCurrentTotalCount = -1;
    }

    @Override  // com.onesignal.notifications.internal.badges.impl.shortcutbadger.Badger
    public void executeBadge(Context context0, ComponentName componentName0, int v) throws ShortcutBadgeException {
        if(this.mCurrentTotalCount == v) {
            return;
        }
        this.mCurrentTotalCount = v;
        this.executeBadgeByContentProvider(context0, v);
    }

    private void executeBadgeByBroadcast(Context context0, ComponentName componentName0, int v) throws ShortcutBadgeException {
        if(v == 0) {
            v = -1;
        }
        Intent intent0 = new Intent("com.oppo.unsettledevent");
        intent0.putExtra("pakeageName", componentName0.getPackageName());
        intent0.putExtra("number", v);
        intent0.putExtra("upgradeNumber", v);
        BroadcastHelper.sendIntentExplicitly(context0, intent0);
    }

    private void executeBadgeByContentProvider(Context context0, int v) throws ShortcutBadgeException {
        try {
            Bundle bundle0 = new Bundle();
            bundle0.putInt("app_badge_count", v);
            context0.getContentResolver().call(Uri.parse("content://com.android.badge/badge"), "setAppBadgeCount", null, bundle0);
        }
        catch(Throwable unused_ex) {
            throw new ShortcutBadgeException("Unable to execute Badge By Content Provider");
        }
    }

    @Override  // com.onesignal.notifications.internal.badges.impl.shortcutbadger.Badger
    public List getSupportLaunchers() {
        return Collections.singletonList("com.oppo.launcher");
    }
}

