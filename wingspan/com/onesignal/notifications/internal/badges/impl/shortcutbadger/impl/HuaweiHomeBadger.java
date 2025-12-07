package com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.Badger;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.ShortcutBadgeException;
import java.util.Arrays;
import java.util.List;

public class HuaweiHomeBadger implements Badger {
    @Override  // com.onesignal.notifications.internal.badges.impl.shortcutbadger.Badger
    public void executeBadge(Context context0, ComponentName componentName0, int v) throws ShortcutBadgeException {
        Bundle bundle0 = new Bundle();
        bundle0.putString("package", "com.MonsterCouch.Wingspan");
        bundle0.putString("class", componentName0.getClassName());
        bundle0.putInt("badgenumber", v);
        context0.getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", null, bundle0);
    }

    @Override  // com.onesignal.notifications.internal.badges.impl.shortcutbadger.Badger
    public List getSupportLaunchers() {
        return Arrays.asList(new String[]{"com.huawei.android.launcher"});
    }
}

