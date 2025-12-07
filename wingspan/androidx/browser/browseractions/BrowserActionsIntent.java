package androidx.browser.browseractions;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Deprecated
public class BrowserActionsIntent {
    interface BrowserActionsFallDialogListener {
        void onDialogShown();
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface BrowserActionsItemId {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface BrowserActionsUrlType {
    }

    public static final class Builder {
        private Context mContext;
        private List mImageUris;
        private final Intent mIntent;
        private ArrayList mMenuItems;
        private PendingIntent mOnItemSelectedPendingIntent;
        private int mType;
        private Uri mUri;

        public Builder(Context context, Uri uri) {
            this.mIntent = new Intent("androidx.browser.browseractions.browser_action_open");
            this.mType = 0;
            this.mMenuItems = new ArrayList();
            this.mOnItemSelectedPendingIntent = null;
            this.mImageUris = new ArrayList();
            this.mContext = context;
            this.mUri = uri;
        }

        public BrowserActionsIntent build() {
            this.mIntent.setData(this.mUri);
            this.mIntent.putExtra("androidx.browser.browseractions.extra.TYPE", this.mType);
            this.mIntent.putParcelableArrayListExtra("androidx.browser.browseractions.extra.MENU_ITEMS", this.mMenuItems);
            PendingIntent pendingIntent0 = PendingIntent.getActivity(this.mContext, 0, new Intent(), 0);
            this.mIntent.putExtra("androidx.browser.browseractions.APP_ID", pendingIntent0);
            PendingIntent pendingIntent1 = this.mOnItemSelectedPendingIntent;
            if(pendingIntent1 != null) {
                this.mIntent.putExtra("androidx.browser.browseractions.extra.SELECTED_ACTION_PENDING_INTENT", pendingIntent1);
            }
            BrowserServiceFileProvider.grantReadPermission(this.mIntent, this.mImageUris, this.mContext);
            return new BrowserActionsIntent(this.mIntent);
        }

        private Bundle getBundleFromItem(BrowserActionItem item) {
            Bundle bundle0 = new Bundle();
            bundle0.putString("androidx.browser.browseractions.TITLE", item.getTitle());
            bundle0.putParcelable("androidx.browser.browseractions.ACTION", item.getAction());
            if(item.getIconId() != 0) {
                bundle0.putInt("androidx.browser.browseractions.ICON_ID", item.getIconId());
            }
            if(item.getIconUri() != null) {
                bundle0.putParcelable("androidx.browser.browseractions.ICON_URI", item.getIconUri());
            }
            return bundle0;
        }

        public Builder setCustomItems(ArrayList items) {
            if(items.size() > 5) {
                throw new IllegalStateException("Exceeded maximum toolbar item count of 5");
            }
            for(int v = 0; v < items.size(); ++v) {
                if(TextUtils.isEmpty(((BrowserActionItem)items.get(v)).getTitle()) || ((BrowserActionItem)items.get(v)).getAction() == null) {
                    throw new IllegalArgumentException("Custom item should contain a non-empty title and non-null intent.");
                }
                this.mMenuItems.add(this.getBundleFromItem(((BrowserActionItem)items.get(v))));
                if(((BrowserActionItem)items.get(v)).getIconUri() != null) {
                    this.mImageUris.add(((BrowserActionItem)items.get(v)).getIconUri());
                }
            }
            return this;
        }

        public Builder setCustomItems(BrowserActionItem[] items) {
            return this.setCustomItems(new ArrayList(Arrays.asList(items)));
        }

        public Builder setOnItemSelectedAction(PendingIntent onItemSelectedPendingIntent) {
            this.mOnItemSelectedPendingIntent = onItemSelectedPendingIntent;
            return this;
        }

        public Builder setUrlType(int type) {
            this.mType = type;
            return this;
        }
    }

    public static final String ACTION_BROWSER_ACTIONS_OPEN = "androidx.browser.browseractions.browser_action_open";
    public static final String EXTRA_APP_ID = "androidx.browser.browseractions.APP_ID";
    public static final String EXTRA_MENU_ITEMS = "androidx.browser.browseractions.extra.MENU_ITEMS";
    public static final String EXTRA_SELECTED_ACTION_PENDING_INTENT = "androidx.browser.browseractions.extra.SELECTED_ACTION_PENDING_INTENT";
    public static final String EXTRA_TYPE = "androidx.browser.browseractions.extra.TYPE";
    public static final int ITEM_COPY = 3;
    public static final int ITEM_DOWNLOAD = 2;
    public static final int ITEM_INVALID_ITEM = -1;
    public static final int ITEM_OPEN_IN_INCOGNITO = 1;
    public static final int ITEM_OPEN_IN_NEW_TAB = 0;
    public static final int ITEM_SHARE = 4;
    public static final String KEY_ACTION = "androidx.browser.browseractions.ACTION";
    public static final String KEY_ICON_ID = "androidx.browser.browseractions.ICON_ID";
    private static final String KEY_ICON_URI = "androidx.browser.browseractions.ICON_URI";
    public static final String KEY_TITLE = "androidx.browser.browseractions.TITLE";
    public static final int MAX_CUSTOM_ITEMS = 5;
    private static final String TAG = "BrowserActions";
    private static final String TEST_URL = "https://www.example.com";
    public static final int URL_TYPE_AUDIO = 3;
    public static final int URL_TYPE_FILE = 4;
    public static final int URL_TYPE_IMAGE = 1;
    public static final int URL_TYPE_NONE = 0;
    public static final int URL_TYPE_PLUGIN = 5;
    public static final int URL_TYPE_VIDEO = 2;
    private final Intent mIntent;
    private static BrowserActionsFallDialogListener sDialogListenter;

    BrowserActionsIntent(Intent intent) {
        this.mIntent = intent;
    }

    public static List getBrowserActionsIntentHandlers(Context context) {
        Intent intent0 = new Intent("androidx.browser.browseractions.browser_action_open", Uri.parse("https://www.example.com"));
        return context.getPackageManager().queryIntentActivities(intent0, 0x20000);
    }

    @Deprecated
    public static String getCreatorPackageName(Intent intent) {
        return BrowserActionsIntent.getUntrustedCreatorPackageName(intent);
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    public static String getUntrustedCreatorPackageName(Intent intent) {
        PendingIntent pendingIntent0 = (PendingIntent)intent.getParcelableExtra("androidx.browser.browseractions.APP_ID");
        return pendingIntent0 == null ? null : pendingIntent0.getCreatorPackage();
    }

    public static void launchIntent(Context context, Intent intent) {
        BrowserActionsIntent.launchIntent(context, intent, BrowserActionsIntent.getBrowserActionsIntentHandlers(context));
    }

    static void launchIntent(Context context, Intent intent, List handlers) {
        if(handlers != null) {
            switch(handlers.size()) {
                case 0: {
                    break;
                }
                case 1: {
                    intent.setPackage(((ResolveInfo)handlers.get(0)).activityInfo.packageName);
                    ContextCompat.startActivity(context, intent, null);
                    return;
                }
                default: {
                    Intent intent1 = new Intent("android.intent.action.VIEW", Uri.parse("https://www.example.com"));
                    ResolveInfo resolveInfo0 = context.getPackageManager().resolveActivity(intent1, 0x10000);
                    if(resolveInfo0 != null) {
                        String s = resolveInfo0.activityInfo.packageName;
                        for(int v = 0; v < handlers.size(); ++v) {
                            if(s.equals(((ResolveInfo)handlers.get(v)).activityInfo.packageName)) {
                                intent.setPackage(s);
                                break;
                            }
                        }
                    }
                    ContextCompat.startActivity(context, intent, null);
                    return;
                }
            }
        }
        BrowserActionsIntent.openFallbackBrowserActionsMenu(context, intent);
    }

    public static void openBrowserAction(Context context, Uri uri) {
        BrowserActionsIntent.launchIntent(context, new Builder(context, uri).build().getIntent());
    }

    public static void openBrowserAction(Context context, Uri uri, int type, ArrayList items, PendingIntent pendingIntent) {
        BrowserActionsIntent.launchIntent(context, new Builder(context, uri).setUrlType(type).setCustomItems(items).setOnItemSelectedAction(pendingIntent).build().getIntent());
    }

    private static void openFallbackBrowserActionsMenu(Context context, Intent intent) {
        Uri uri0 = intent.getData();
        ArrayList arrayList0 = intent.getParcelableArrayListExtra("androidx.browser.browseractions.extra.MENU_ITEMS");
        BrowserActionsIntent.openFallbackBrowserActionsMenu(context, uri0, (arrayList0 == null ? null : BrowserActionsIntent.parseBrowserActionItems(arrayList0)));
    }

    private static void openFallbackBrowserActionsMenu(Context context, Uri uri, List menuItems) {
        new BrowserActionsFallbackMenuUi(context, uri, menuItems).displayMenu();
        BrowserActionsFallDialogListener browserActionsIntent$BrowserActionsFallDialogListener0 = BrowserActionsIntent.sDialogListenter;
        if(browserActionsIntent$BrowserActionsFallDialogListener0 != null) {
            browserActionsIntent$BrowserActionsFallDialogListener0.onDialogShown();
        }
    }

    public static List parseBrowserActionItems(ArrayList bundles) {
        List list0 = new ArrayList();
        for(int v = 0; v < bundles.size(); ++v) {
            Bundle bundle0 = (Bundle)bundles.get(v);
            String s = bundle0.getString("androidx.browser.browseractions.TITLE");
            PendingIntent pendingIntent0 = (PendingIntent)bundle0.getParcelable("androidx.browser.browseractions.ACTION");
            int v1 = bundle0.getInt("androidx.browser.browseractions.ICON_ID");
            Uri uri0 = (Uri)bundle0.getParcelable("androidx.browser.browseractions.ICON_URI");
            if(TextUtils.isEmpty(s) || pendingIntent0 == null) {
                throw new IllegalArgumentException("Custom item should contain a non-empty title and non-null intent.");
            }
            list0.add((v1 == 0 ? new BrowserActionItem(s, pendingIntent0, uri0) : new BrowserActionItem(s, pendingIntent0, v1)));
        }
        return list0;
    }

    static void setDialogShownListenter(BrowserActionsFallDialogListener dialogListener) {
        BrowserActionsIntent.sDialogListenter = dialogListener;
    }
}

