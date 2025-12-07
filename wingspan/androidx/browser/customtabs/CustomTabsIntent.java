package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.app.BundleCompat;
import androidx.core.content.ContextCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

public final class CustomTabsIntent {
    public static final class Builder {
        private ArrayList mActionButtons;
        private SparseArray mColorSchemeParamBundles;
        private final androidx.browser.customtabs.CustomTabColorSchemeParams.Builder mDefaultColorSchemeBuilder;
        private Bundle mDefaultColorSchemeBundle;
        private boolean mInstantAppsEnabled;
        private final Intent mIntent;
        private ArrayList mMenuItems;
        private int mShareState;
        private Bundle mStartAnimationBundle;

        public Builder() {
            this.mIntent = new Intent("android.intent.action.VIEW");
            this.mDefaultColorSchemeBuilder = new androidx.browser.customtabs.CustomTabColorSchemeParams.Builder();
            this.mShareState = 0;
            this.mInstantAppsEnabled = true;
        }

        public Builder(CustomTabsSession session) {
            this.mIntent = new Intent("android.intent.action.VIEW");
            this.mDefaultColorSchemeBuilder = new androidx.browser.customtabs.CustomTabColorSchemeParams.Builder();
            this.mShareState = 0;
            this.mInstantAppsEnabled = true;
            if(session != null) {
                this.setSession(session);
            }
        }

        @Deprecated
        public Builder addDefaultShareMenuItem() {
            this.setShareState(1);
            return this;
        }

        public Builder addMenuItem(String label, PendingIntent pendingIntent) {
            if(this.mMenuItems == null) {
                this.mMenuItems = new ArrayList();
            }
            Bundle bundle0 = new Bundle();
            bundle0.putString("android.support.customtabs.customaction.MENU_ITEM_TITLE", label);
            bundle0.putParcelable("android.support.customtabs.customaction.PENDING_INTENT", pendingIntent);
            this.mMenuItems.add(bundle0);
            return this;
        }

        @Deprecated
        public Builder addToolbarItem(int id, Bitmap icon, String description, PendingIntent pendingIntent) throws IllegalStateException {
            if(this.mActionButtons == null) {
                this.mActionButtons = new ArrayList();
            }
            if(this.mActionButtons.size() >= 5) {
                throw new IllegalStateException("Exceeded maximum toolbar item count of 5");
            }
            Bundle bundle0 = new Bundle();
            bundle0.putInt("android.support.customtabs.customaction.ID", id);
            bundle0.putParcelable("android.support.customtabs.customaction.ICON", icon);
            bundle0.putString("android.support.customtabs.customaction.DESCRIPTION", description);
            bundle0.putParcelable("android.support.customtabs.customaction.PENDING_INTENT", pendingIntent);
            this.mActionButtons.add(bundle0);
            return this;
        }

        public CustomTabsIntent build() {
            if(!this.mIntent.hasExtra("android.support.customtabs.extra.SESSION")) {
                this.setSessionParameters(null, null);
            }
            ArrayList arrayList0 = this.mMenuItems;
            if(arrayList0 != null) {
                this.mIntent.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList0);
            }
            ArrayList arrayList1 = this.mActionButtons;
            if(arrayList1 != null) {
                this.mIntent.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", arrayList1);
            }
            this.mIntent.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.mInstantAppsEnabled);
            Bundle bundle0 = this.mDefaultColorSchemeBuilder.build().toBundle();
            this.mIntent.putExtras(bundle0);
            Bundle bundle1 = this.mDefaultColorSchemeBundle;
            if(bundle1 != null) {
                this.mIntent.putExtras(bundle1);
            }
            if(this.mColorSchemeParamBundles != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putSparseParcelableArray("androidx.browser.customtabs.extra.COLOR_SCHEME_PARAMS", this.mColorSchemeParamBundles);
                this.mIntent.putExtras(bundle2);
            }
            this.mIntent.putExtra("androidx.browser.customtabs.extra.SHARE_STATE", this.mShareState);
            return new CustomTabsIntent(this.mIntent, this.mStartAnimationBundle);
        }

        @Deprecated
        public Builder enableUrlBarHiding() {
            this.mIntent.putExtra("android.support.customtabs.extra.ENABLE_URLBAR_HIDING", true);
            return this;
        }

        public Builder setActionButton(Bitmap icon, String description, PendingIntent pendingIntent) {
            return this.setActionButton(icon, description, pendingIntent, false);
        }

        public Builder setActionButton(Bitmap icon, String description, PendingIntent pendingIntent, boolean shouldTint) {
            Bundle bundle0 = new Bundle();
            bundle0.putInt("android.support.customtabs.customaction.ID", 0);
            bundle0.putParcelable("android.support.customtabs.customaction.ICON", icon);
            bundle0.putString("android.support.customtabs.customaction.DESCRIPTION", description);
            bundle0.putParcelable("android.support.customtabs.customaction.PENDING_INTENT", pendingIntent);
            this.mIntent.putExtra("android.support.customtabs.extra.ACTION_BUTTON_BUNDLE", bundle0);
            this.mIntent.putExtra("android.support.customtabs.extra.TINT_ACTION_BUTTON", shouldTint);
            return this;
        }

        public Builder setCloseButtonIcon(Bitmap icon) {
            this.mIntent.putExtra("android.support.customtabs.extra.CLOSE_BUTTON_ICON", icon);
            return this;
        }

        public Builder setColorScheme(int colorScheme) {
            if(colorScheme < 0 || colorScheme > 2) {
                throw new IllegalArgumentException("Invalid value for the colorScheme argument");
            }
            this.mIntent.putExtra("androidx.browser.customtabs.extra.COLOR_SCHEME", colorScheme);
            return this;
        }

        public Builder setColorSchemeParams(int colorScheme, CustomTabColorSchemeParams params) {
            if(colorScheme < 0 || colorScheme > 2 || colorScheme == 0) {
                throw new IllegalArgumentException("Invalid colorScheme: " + colorScheme);
            }
            if(this.mColorSchemeParamBundles == null) {
                this.mColorSchemeParamBundles = new SparseArray();
            }
            this.mColorSchemeParamBundles.put(colorScheme, params.toBundle());
            return this;
        }

        public Builder setDefaultColorSchemeParams(CustomTabColorSchemeParams params) {
            this.mDefaultColorSchemeBundle = params.toBundle();
            return this;
        }

        @Deprecated
        public Builder setDefaultShareMenuItemEnabled(boolean enabled) {
            if(enabled) {
                this.setShareState(1);
                return this;
            }
            this.setShareState(2);
            return this;
        }

        public Builder setExitAnimations(Context context, int enterResId, int exitResId) {
            Bundle bundle0 = ActivityOptionsCompat.makeCustomAnimation(context, enterResId, exitResId).toBundle();
            this.mIntent.putExtra("android.support.customtabs.extra.EXIT_ANIMATION_BUNDLE", bundle0);
            return this;
        }

        public Builder setInstantAppsEnabled(boolean enabled) {
            this.mInstantAppsEnabled = enabled;
            return this;
        }

        @Deprecated
        public Builder setNavigationBarColor(int color) {
            this.mDefaultColorSchemeBuilder.setNavigationBarColor(color);
            return this;
        }

        @Deprecated
        public Builder setNavigationBarDividerColor(int color) {
            this.mDefaultColorSchemeBuilder.setNavigationBarDividerColor(color);
            return this;
        }

        public Builder setPendingSession(PendingSession session) {
            this.setSessionParameters(null, session.getId());
            return this;
        }

        @Deprecated
        public Builder setSecondaryToolbarColor(int color) {
            this.mDefaultColorSchemeBuilder.setSecondaryToolbarColor(color);
            return this;
        }

        public Builder setSecondaryToolbarViews(RemoteViews remoteViews, int[] clickableIDs, PendingIntent pendingIntent) {
            this.mIntent.putExtra("android.support.customtabs.extra.EXTRA_REMOTEVIEWS", remoteViews);
            this.mIntent.putExtra("android.support.customtabs.extra.EXTRA_REMOTEVIEWS_VIEW_IDS", clickableIDs);
            this.mIntent.putExtra("android.support.customtabs.extra.EXTRA_REMOTEVIEWS_PENDINGINTENT", pendingIntent);
            return this;
        }

        public Builder setSession(CustomTabsSession session) {
            String s = session.getComponentName().getPackageName();
            this.mIntent.setPackage(s);
            this.setSessionParameters(session.getBinder(), session.getId());
            return this;
        }

        private void setSessionParameters(IBinder binder, PendingIntent sessionId) {
            Bundle bundle0 = new Bundle();
            BundleCompat.putBinder(bundle0, "android.support.customtabs.extra.SESSION", binder);
            if(sessionId != null) {
                bundle0.putParcelable("android.support.customtabs.extra.SESSION_ID", sessionId);
            }
            this.mIntent.putExtras(bundle0);
        }

        public Builder setShareState(int shareState) {
            if(shareState < 0 || shareState > 2) {
                throw new IllegalArgumentException("Invalid value for the shareState argument");
            }
            this.mShareState = shareState;
            if(shareState == 1) {
                this.mIntent.putExtra("android.support.customtabs.extra.SHARE_MENU_ITEM", true);
                return this;
            }
            if(shareState == 2) {
                this.mIntent.putExtra("android.support.customtabs.extra.SHARE_MENU_ITEM", false);
                return this;
            }
            this.mIntent.removeExtra("android.support.customtabs.extra.SHARE_MENU_ITEM");
            return this;
        }

        public Builder setShowTitle(boolean showTitle) {
            this.mIntent.putExtra("android.support.customtabs.extra.TITLE_VISIBILITY", ((int)showTitle));
            return this;
        }

        public Builder setStartAnimations(Context context, int enterResId, int exitResId) {
            this.mStartAnimationBundle = ActivityOptionsCompat.makeCustomAnimation(context, enterResId, exitResId).toBundle();
            return this;
        }

        @Deprecated
        public Builder setToolbarColor(int color) {
            this.mDefaultColorSchemeBuilder.setToolbarColor(color);
            return this;
        }

        public Builder setUrlBarHidingEnabled(boolean enabled) {
            this.mIntent.putExtra("android.support.customtabs.extra.ENABLE_URLBAR_HIDING", enabled);
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ColorScheme {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ShareState {
    }

    public static final int COLOR_SCHEME_DARK = 2;
    public static final int COLOR_SCHEME_LIGHT = 1;
    private static final int COLOR_SCHEME_MAX = 2;
    public static final int COLOR_SCHEME_SYSTEM = 0;
    public static final String EXTRA_ACTION_BUTTON_BUNDLE = "android.support.customtabs.extra.ACTION_BUTTON_BUNDLE";
    public static final String EXTRA_CLOSE_BUTTON_ICON = "android.support.customtabs.extra.CLOSE_BUTTON_ICON";
    public static final String EXTRA_COLOR_SCHEME = "androidx.browser.customtabs.extra.COLOR_SCHEME";
    public static final String EXTRA_COLOR_SCHEME_PARAMS = "androidx.browser.customtabs.extra.COLOR_SCHEME_PARAMS";
    @Deprecated
    public static final String EXTRA_DEFAULT_SHARE_MENU_ITEM = "android.support.customtabs.extra.SHARE_MENU_ITEM";
    public static final String EXTRA_ENABLE_INSTANT_APPS = "android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS";
    public static final String EXTRA_ENABLE_URLBAR_HIDING = "android.support.customtabs.extra.ENABLE_URLBAR_HIDING";
    public static final String EXTRA_EXIT_ANIMATION_BUNDLE = "android.support.customtabs.extra.EXIT_ANIMATION_BUNDLE";
    public static final String EXTRA_MENU_ITEMS = "android.support.customtabs.extra.MENU_ITEMS";
    public static final String EXTRA_NAVIGATION_BAR_COLOR = "androidx.browser.customtabs.extra.NAVIGATION_BAR_COLOR";
    public static final String EXTRA_NAVIGATION_BAR_DIVIDER_COLOR = "androidx.browser.customtabs.extra.NAVIGATION_BAR_DIVIDER_COLOR";
    public static final String EXTRA_REMOTEVIEWS = "android.support.customtabs.extra.EXTRA_REMOTEVIEWS";
    public static final String EXTRA_REMOTEVIEWS_CLICKED_ID = "android.support.customtabs.extra.EXTRA_REMOTEVIEWS_CLICKED_ID";
    public static final String EXTRA_REMOTEVIEWS_PENDINGINTENT = "android.support.customtabs.extra.EXTRA_REMOTEVIEWS_PENDINGINTENT";
    public static final String EXTRA_REMOTEVIEWS_VIEW_IDS = "android.support.customtabs.extra.EXTRA_REMOTEVIEWS_VIEW_IDS";
    public static final String EXTRA_SECONDARY_TOOLBAR_COLOR = "android.support.customtabs.extra.SECONDARY_TOOLBAR_COLOR";
    public static final String EXTRA_SESSION = "android.support.customtabs.extra.SESSION";
    public static final String EXTRA_SESSION_ID = "android.support.customtabs.extra.SESSION_ID";
    public static final String EXTRA_SHARE_STATE = "androidx.browser.customtabs.extra.SHARE_STATE";
    public static final String EXTRA_TINT_ACTION_BUTTON = "android.support.customtabs.extra.TINT_ACTION_BUTTON";
    public static final String EXTRA_TITLE_VISIBILITY_STATE = "android.support.customtabs.extra.TITLE_VISIBILITY";
    public static final String EXTRA_TOOLBAR_COLOR = "android.support.customtabs.extra.TOOLBAR_COLOR";
    public static final String EXTRA_TOOLBAR_ITEMS = "android.support.customtabs.extra.TOOLBAR_ITEMS";
    private static final String EXTRA_USER_OPT_OUT_FROM_CUSTOM_TABS = "android.support.customtabs.extra.user_opt_out";
    public static final String KEY_DESCRIPTION = "android.support.customtabs.customaction.DESCRIPTION";
    public static final String KEY_ICON = "android.support.customtabs.customaction.ICON";
    public static final String KEY_ID = "android.support.customtabs.customaction.ID";
    public static final String KEY_MENU_ITEM_TITLE = "android.support.customtabs.customaction.MENU_ITEM_TITLE";
    public static final String KEY_PENDING_INTENT = "android.support.customtabs.customaction.PENDING_INTENT";
    private static final int MAX_TOOLBAR_ITEMS = 5;
    public static final int NO_TITLE = 0;
    public static final int SHARE_STATE_DEFAULT = 0;
    private static final int SHARE_STATE_MAX = 2;
    public static final int SHARE_STATE_OFF = 2;
    public static final int SHARE_STATE_ON = 1;
    public static final int SHOW_PAGE_TITLE = 1;
    public static final int TOOLBAR_ACTION_BUTTON_ID;
    public final Intent intent;
    public final Bundle startAnimationBundle;

    CustomTabsIntent(Intent intent, Bundle startAnimationBundle) {
        this.intent = intent;
        this.startAnimationBundle = startAnimationBundle;
    }

    public static CustomTabColorSchemeParams getColorSchemeParams(Intent intent, int colorScheme) {
        if(colorScheme < 0 || colorScheme > 2 || colorScheme == 0) {
            throw new IllegalArgumentException("Invalid colorScheme: " + colorScheme);
        }
        Bundle bundle0 = intent.getExtras();
        if(bundle0 == null) {
            return CustomTabColorSchemeParams.fromBundle(null);
        }
        CustomTabColorSchemeParams customTabColorSchemeParams0 = CustomTabColorSchemeParams.fromBundle(bundle0);
        SparseArray sparseArray0 = bundle0.getSparseParcelableArray("androidx.browser.customtabs.extra.COLOR_SCHEME_PARAMS");
        if(sparseArray0 != null) {
            Bundle bundle1 = (Bundle)sparseArray0.get(colorScheme);
            return bundle1 == null ? customTabColorSchemeParams0 : CustomTabColorSchemeParams.fromBundle(bundle1).withDefaults(customTabColorSchemeParams0);
        }
        return customTabColorSchemeParams0;
    }

    public static int getMaxToolbarItems() {
        return 5;
    }

    public void launchUrl(Context context, Uri url) {
        this.intent.setData(url);
        ContextCompat.startActivity(context, this.intent, this.startAnimationBundle);
    }

    public static Intent setAlwaysUseBrowserUI(Intent intent) {
        if(intent == null) {
            intent = new Intent("android.intent.action.VIEW");
        }
        intent.addFlags(0x10000000);
        intent.putExtra("android.support.customtabs.extra.user_opt_out", true);
        return intent;
    }

    public static boolean shouldAlwaysUseBrowserUI(Intent intent) {
        return intent.getBooleanExtra("android.support.customtabs.extra.user_opt_out", false) && (intent.getFlags() & 0x10000000) != 0;
    }
}

