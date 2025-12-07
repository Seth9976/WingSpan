package androidx.core.content;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import androidx.core.util.Preconditions;

public final class IntentCompat {
    static class Api15Impl {
        static Intent makeMainSelectorActivity(String s, String s1) {
            return Intent.makeMainSelectorActivity(s, s1);
        }
    }

    public static final String ACTION_CREATE_REMINDER = "android.intent.action.CREATE_REMINDER";
    public static final String CATEGORY_LEANBACK_LAUNCHER = "android.intent.category.LEANBACK_LAUNCHER";
    public static final String EXTRA_HTML_TEXT = "android.intent.extra.HTML_TEXT";
    public static final String EXTRA_START_PLAYBACK = "android.intent.extra.START_PLAYBACK";
    public static final String EXTRA_TIME = "android.intent.extra.TIME";

    public static Intent createManageUnusedAppRestrictionsIntent(Context context0, String s) {
        if(!PackageManagerCompat.areUnusedAppRestrictionsAvailable(context0.getPackageManager())) {
            throw new UnsupportedOperationException("Unused App Restriction features are not available on this device");
        }
        if(Build.VERSION.SDK_INT >= 0x1F) {
            return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS").setData(Uri.fromParts("package", s, null));
        }
        Intent intent0 = new Intent("android.intent.action.AUTO_REVOKE_PERMISSIONS").setData(Uri.fromParts("package", s, null));
        return Build.VERSION.SDK_INT < 30 ? intent0.setPackage(((String)Preconditions.checkNotNull(PackageManagerCompat.getPermissionRevocationVerifierApp(context0.getPackageManager())))) : intent0;
    }

    public static Intent makeMainSelectorActivity(String s, String s1) {
        return Api15Impl.makeMainSelectorActivity(s, s1);
    }
}

