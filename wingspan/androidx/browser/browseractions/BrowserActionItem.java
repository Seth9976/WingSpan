package androidx.browser.browseractions;

import android.app.PendingIntent;
import android.net.Uri;

@Deprecated
public class BrowserActionItem {
    private final PendingIntent mAction;
    private int mIconId;
    private Uri mIconUri;
    private Runnable mRunnableAction;
    private final String mTitle;

    public BrowserActionItem(String title, PendingIntent action) {
        this(title, action, 0);
    }

    public BrowserActionItem(String title, PendingIntent action, int iconId) {
        this.mTitle = title;
        this.mAction = action;
        this.mIconId = iconId;
    }

    public BrowserActionItem(String title, PendingIntent action, Uri iconUri) {
        this.mTitle = title;
        this.mAction = action;
        this.mIconUri = iconUri;
    }

    BrowserActionItem(String title, Runnable action) {
        this.mTitle = title;
        this.mAction = null;
        this.mRunnableAction = action;
    }

    public PendingIntent getAction() {
        PendingIntent pendingIntent0 = this.mAction;
        if(pendingIntent0 == null) {
            throw new IllegalStateException("Can\'t call getAction on BrowserActionItem with null action.");
        }
        return pendingIntent0;
    }

    public int getIconId() {
        return this.mIconId;
    }

    public Uri getIconUri() {
        return this.mIconUri;
    }

    Runnable getRunnableAction() {
        return this.mRunnableAction;
    }

    public String getTitle() {
        return this.mTitle;
    }
}

