package com.onesignal.notifications.internal.common;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0002\u0010\bJ\n\u0010\t\u001A\u0004\u0018\u00010\u0005H\u0002J\b\u0010\n\u001A\u0004\u0018\u00010\u0005R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2 = {"Lcom/onesignal/notifications/internal/common/GenerateNotificationOpenIntent;", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "startApp", "", "(Landroid/content/Context;Landroid/content/Intent;Z)V", "getIntentAppOpen", "getIntentVisible", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public class GenerateNotificationOpenIntent {
    private final Context context;
    private final Intent intent;
    private final boolean startApp;

    public GenerateNotificationOpenIntent(Context context0, Intent intent0, boolean z) {
        Intrinsics.checkNotNullParameter(context0, "context");
        super();
        this.context = context0;
        this.intent = intent0;
        this.startApp = z;
    }

    private final Intent getIntentAppOpen() {
        if(!this.startApp) {
            return null;
        }
        Intent intent0 = this.context.getPackageManager().getLaunchIntentForPackage("com.MonsterCouch.Wingspan");
        if(intent0 == null) {
            return null;
        }
        intent0.setPackage(null);
        intent0.setFlags(0x10200000);
        return intent0;
    }

    public final Intent getIntentVisible() {
        return this.intent == null ? this.getIntentAppOpen() : this.intent;
    }
}

