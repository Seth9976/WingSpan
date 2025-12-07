package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.app.BundleCompat;
import androidx.core.content.FileProvider;
import java.io.File;

public class TrustedWebUtils {
    public static final String ACTION_MANAGE_TRUSTED_WEB_ACTIVITY_DATA = "android.support.customtabs.action.ACTION_MANAGE_TRUSTED_WEB_ACTIVITY_DATA";
    public static final String EXTRA_LAUNCH_AS_TRUSTED_WEB_ACTIVITY = "android.support.customtabs.extra.LAUNCH_AS_TRUSTED_WEB_ACTIVITY";

    public static boolean areSplashScreensSupported(Context context, String packageName, String version) {
        Intent intent0 = new Intent().setAction("android.support.customtabs.action.CustomTabsService").setPackage(packageName);
        ResolveInfo resolveInfo0 = context.getPackageManager().resolveService(intent0, 0x40);
        return resolveInfo0 == null || resolveInfo0.filter == null ? false : resolveInfo0.filter.hasCategory(version);
    }

    @Deprecated
    public static void launchAsTrustedWebActivity(Context context, CustomTabsIntent customTabsIntent, Uri uri) {
        if(BundleCompat.getBinder(customTabsIntent.intent.getExtras(), "android.support.customtabs.extra.SESSION") == null) {
            throw new IllegalArgumentException("Given CustomTabsIntent should be associated with a valid CustomTabsSession");
        }
        customTabsIntent.intent.putExtra("android.support.customtabs.extra.LAUNCH_AS_TRUSTED_WEB_ACTIVITY", true);
        customTabsIntent.launchUrl(context, uri);
    }

    public static void launchBrowserSiteSettings(Context context, CustomTabsSession session, Uri uri) {
        Intent intent0 = new Intent("android.support.customtabs.action.ACTION_MANAGE_TRUSTED_WEB_ACTIVITY_DATA");
        intent0.setPackage(session.getComponentName().getPackageName());
        intent0.setData(uri);
        Bundle bundle0 = new Bundle();
        BundleCompat.putBinder(bundle0, "android.support.customtabs.extra.SESSION", session.getBinder());
        intent0.putExtras(bundle0);
        PendingIntent pendingIntent0 = session.getId();
        if(pendingIntent0 != null) {
            intent0.putExtra("android.support.customtabs.extra.SESSION_ID", pendingIntent0);
        }
        context.startActivity(intent0);
    }

    public static boolean transferSplashImage(Context context, File file, String fileProviderAuthority, String packageName, CustomTabsSession session) {
        Uri uri0 = FileProvider.getUriForFile(context, fileProviderAuthority, file);
        context.grantUriPermission(packageName, uri0, 1);
        return session.receiveFile(uri0, 1, null);
    }
}

