package androidx.browser.trusted;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.content.ContextCompat;
import java.util.List;

public final class TrustedWebActivityIntent {
    private final Intent mIntent;
    private final List mSharedFileUris;

    TrustedWebActivityIntent(Intent intent, List sharedFileUris) {
        this.mIntent = intent;
        this.mSharedFileUris = sharedFileUris;
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    private void grantUriPermissionToProvider(Context context) {
        for(Object object0: this.mSharedFileUris) {
            context.grantUriPermission(this.mIntent.getPackage(), ((Uri)object0), 1);
        }
    }

    public void launchTrustedWebActivity(Context context) {
        this.grantUriPermissionToProvider(context);
        ContextCompat.startActivity(context, this.mIntent, null);
    }
}

