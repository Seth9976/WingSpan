package androidx.browser.trusted;

import android.content.pm.PackageManager;
import android.util.Log;
import java.io.IOException;
import java.util.List;

public final class Token {
    private static final String TAG = "Token";
    private final TokenContents mContents;

    private Token(TokenContents contents) {
        this.mContents = contents;
    }

    public static Token create(String packageName, PackageManager packageManager) {
        List list0 = PackageIdentityUtils.getFingerprintsForPackage(packageName, packageManager);
        if(list0 == null) {
            return null;
        }
        try {
            return new Token(TokenContents.create(packageName, list0));
        }
        catch(IOException iOException0) {
            Log.e("Token", "Exception when creating token.", iOException0);
            return null;
        }
    }

    public static Token deserialize(byte[] serialized) {
        return new Token(TokenContents.deserialize(serialized));
    }

    public boolean matches(String packageName, PackageManager packageManager) {
        return PackageIdentityUtils.packageMatchesToken(packageName, packageManager, this.mContents);
    }

    public byte[] serialize() {
        return this.mContents.serialize();
    }
}

