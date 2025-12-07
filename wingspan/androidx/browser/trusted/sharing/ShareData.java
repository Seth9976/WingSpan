package androidx.browser.trusted.sharing;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public final class ShareData {
    public static final String KEY_TEXT = "androidx.browser.trusted.sharing.KEY_TEXT";
    public static final String KEY_TITLE = "androidx.browser.trusted.sharing.KEY_TITLE";
    public static final String KEY_URIS = "androidx.browser.trusted.sharing.KEY_URIS";
    public final String text;
    public final String title;
    public final List uris;

    public ShareData(String title, String text, List uris) {
        this.title = title;
        this.text = text;
        this.uris = uris;
    }

    public static ShareData fromBundle(Bundle bundle) {
        return new ShareData(bundle.getString("androidx.browser.trusted.sharing.KEY_TITLE"), bundle.getString("androidx.browser.trusted.sharing.KEY_TEXT"), bundle.getParcelableArrayList("androidx.browser.trusted.sharing.KEY_URIS"));
    }

    public Bundle toBundle() {
        Bundle bundle0 = new Bundle();
        bundle0.putString("androidx.browser.trusted.sharing.KEY_TITLE", this.title);
        bundle0.putString("androidx.browser.trusted.sharing.KEY_TEXT", this.text);
        if(this.uris != null) {
            bundle0.putParcelableArrayList("androidx.browser.trusted.sharing.KEY_URIS", new ArrayList(this.uris));
        }
        return bundle0;
    }
}

