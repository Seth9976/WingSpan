package androidx.browser.trusted;

import android.os.Bundle;

public final class TrustedWebActivityDisplayMode.-CC {
    public static TrustedWebActivityDisplayMode fromBundle(Bundle bundle) {
        return bundle.getInt("androidx.browser.trusted.displaymode.KEY_ID") != 1 ? new DefaultMode() : ImmersiveMode.fromBundle(bundle);
    }
}

