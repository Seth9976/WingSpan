package com.onesignal.inAppMessages.internal.common;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent.Builder;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001A\u00020\u0004H\u0002J%\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00042\u0006\u0010\t\u001A\u00020\nH\u0000¢\u0006\u0002\b\u000B¨\u0006\r"}, d2 = {"Lcom/onesignal/inAppMessages/internal/common/OneSignalChromeTab;", "", "()V", "hasChromeTabLibrary", "", "open", "url", "", "openActivity", "context", "Landroid/content/Context;", "open$com_onesignal_inAppMessages", "OneSignalCustomTabsServiceConnection", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class OneSignalChromeTab {
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001F\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EH\u0016J\u0010\u0010\u000F\u001A\u00020\n2\u0006\u0010\u0010\u001A\u00020\fH\u0016R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/onesignal/inAppMessages/internal/common/OneSignalChromeTab$OneSignalCustomTabsServiceConnection;", "Landroidx/browser/customtabs/CustomTabsServiceConnection;", "url", "", "openActivity", "", "context", "Landroid/content/Context;", "(Ljava/lang/String;ZLandroid/content/Context;)V", "onCustomTabsServiceConnected", "", "componentName", "Landroid/content/ComponentName;", "customTabsClient", "Landroidx/browser/customtabs/CustomTabsClient;", "onServiceDisconnected", "name", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    static final class OneSignalCustomTabsServiceConnection extends CustomTabsServiceConnection {
        private final Context context;
        private final boolean openActivity;
        private final String url;

        public OneSignalCustomTabsServiceConnection(String s, boolean z, Context context0) {
            Intrinsics.checkNotNullParameter(s, "url");
            Intrinsics.checkNotNullParameter(context0, "context");
            super();
            this.url = s;
            this.openActivity = z;
            this.context = context0;
        }

        @Override  // androidx.browser.customtabs.CustomTabsServiceConnection
        public void onCustomTabsServiceConnected(ComponentName componentName0, CustomTabsClient customTabsClient0) {
            Intrinsics.checkNotNullParameter(componentName0, "componentName");
            Intrinsics.checkNotNullParameter(customTabsClient0, "customTabsClient");
            customTabsClient0.warmup(0L);
            CustomTabsSession customTabsSession0 = customTabsClient0.newSession(null);
            if(customTabsSession0 == null) {
                return;
            }
            Uri uri0 = Uri.parse(this.url);
            customTabsSession0.mayLaunchUrl(uri0, null, null);
            if(this.openActivity) {
                CustomTabsIntent customTabsIntent0 = new Builder(customTabsSession0).build();
                Intrinsics.checkNotNullExpressionValue(customTabsIntent0, "mBuilder.build()");
                customTabsIntent0.intent.setData(uri0);
                customTabsIntent0.intent.addFlags(0x10000000);
                this.context.startActivity(customTabsIntent0.intent, customTabsIntent0.startAnimationBundle);
            }
        }

        @Override  // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName0) {
            Intrinsics.checkNotNullParameter(componentName0, "name");
        }
    }

    public static final OneSignalChromeTab INSTANCE;

    static {
        OneSignalChromeTab.INSTANCE = new OneSignalChromeTab();
    }

    private final boolean hasChromeTabLibrary() [...] // Inlined contents

    public final boolean open$com_onesignal_inAppMessages(String s, boolean z, Context context0) {
        Intrinsics.checkNotNullParameter(s, "url");
        Intrinsics.checkNotNullParameter(context0, "context");
        return CustomTabsClient.bindCustomTabsService(context0, "com.android.chrome", new OneSignalCustomTabsServiceConnection(s, z, context0));
    }
}

