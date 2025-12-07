package androidx.browser.trusted;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build.VERSION;
import android.util.Log;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

class PackageIdentityUtils {
    static class Api28Implementation implements SignaturesCompat {
        @Override  // androidx.browser.trusted.PackageIdentityUtils$SignaturesCompat
        public List getFingerprintsForPackage(String name, PackageManager pm) throws PackageManager.NameNotFoundException {
            PackageInfo packageInfo0 = pm.getPackageInfo(name, 0x8000000);
            List list0 = new ArrayList();
            SigningInfo signingInfo0 = packageInfo0.signingInfo;
            if(signingInfo0.hasMultipleSigners()) {
                Signature[] arr_signature = signingInfo0.getApkContentsSigners();
                for(int v = 0; v < arr_signature.length; ++v) {
                    list0.add(PackageIdentityUtils.getCertificateSHA256Fingerprint(arr_signature[v]));
                }
                return list0;
            }
            list0.add(PackageIdentityUtils.getCertificateSHA256Fingerprint(signingInfo0.getSigningCertificateHistory()[0]));
            return list0;
        }

        @Override  // androidx.browser.trusted.PackageIdentityUtils$SignaturesCompat
        public boolean packageMatchesToken(String name, PackageManager pm, TokenContents token) throws PackageManager.NameNotFoundException, IOException {
            if(!token.getPackageName().equals(name)) {
                return false;
            }
            List list0 = this.getFingerprintsForPackage(name, pm);
            if(list0 == null) {
                return false;
            }
            return list0.size() == 1 ? pm.hasSigningCertificate(name, token.getFingerprint(0), 1) : token.equals(TokenContents.create(name, list0));
        }
    }

    static class Pre28Implementation implements SignaturesCompat {
        @Override  // androidx.browser.trusted.PackageIdentityUtils$SignaturesCompat
        public List getFingerprintsForPackage(String name, PackageManager pm) throws PackageManager.NameNotFoundException {
            PackageInfo packageInfo0 = pm.getPackageInfo(name, 0x40);
            List list0 = new ArrayList(packageInfo0.signatures.length);
            Signature[] arr_signature = packageInfo0.signatures;
            for(int v = 0; v < arr_signature.length; ++v) {
                byte[] arr_b = PackageIdentityUtils.getCertificateSHA256Fingerprint(arr_signature[v]);
                if(arr_b == null) {
                    return null;
                }
                list0.add(arr_b);
            }
            return list0;
        }

        @Override  // androidx.browser.trusted.PackageIdentityUtils$SignaturesCompat
        public boolean packageMatchesToken(String name, PackageManager pm, TokenContents token) throws IOException, PackageManager.NameNotFoundException {
            if(!name.equals(token.getPackageName())) {
                return false;
            }
            List list0 = this.getFingerprintsForPackage(name, pm);
            return list0 == null ? false : token.equals(TokenContents.create(name, list0));
        }
    }

    interface SignaturesCompat {
        List getFingerprintsForPackage(String arg1, PackageManager arg2) throws PackageManager.NameNotFoundException;

        boolean packageMatchesToken(String arg1, PackageManager arg2, TokenContents arg3) throws IOException, PackageManager.NameNotFoundException;
    }

    private static final String TAG = "PackageIdentity";

    static byte[] getCertificateSHA256Fingerprint(Signature signature) {
        try {
            return MessageDigest.getInstance("SHA256").digest(signature.toByteArray());
        }
        catch(NoSuchAlgorithmException unused_ex) {
            return null;
        }
    }

    static List getFingerprintsForPackage(String name, PackageManager pm) {
        try {
            return PackageIdentityUtils.getImpl().getFingerprintsForPackage(name, pm);
        }
        catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
            Log.e("PackageIdentity", "Could not get fingerprint for package.", packageManager$NameNotFoundException0);
            return null;
        }
    }

    private static SignaturesCompat getImpl() {
        return Build.VERSION.SDK_INT >= 28 ? new Api28Implementation() : new Pre28Implementation();
    }

    static boolean packageMatchesToken(String name, PackageManager pm, TokenContents token) {
        try {
            return PackageIdentityUtils.getImpl().packageMatchesToken(name, pm, token);
        }
        catch(IOException | PackageManager.NameNotFoundException iOException0) {
            Log.e("PackageIdentity", "Could not check if package matches token.", iOException0);
            return false;
        }
    }
}

