package com.voxelbusters.essentialkit.billingservices.common;

import android.text.TextUtils;
import android.util.Base64;
import com.voxelbusters.essentialkit.utilities.Logger;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

public class Security {
    private static final String KEY_FACTORY_ALGORITHM = "RSA";
    private static final String SIGNATURE_ALGORITHM = "SHA1withRSA";
    private static final String TAG = "IABUtil/Security";

    public static PublicKey generatePublicKey(String s) {
        try {
            byte[] arr_b = Base64.decode(s, 0);
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(arr_b));
        }
        catch(NoSuchAlgorithmException noSuchAlgorithmException0) {
            throw new RuntimeException(noSuchAlgorithmException0);
        }
        catch(InvalidKeySpecException invalidKeySpecException0) {
            Logger.warning(("Invalid key specification: " + invalidKeySpecException0));
            throw new IOException("Invalid key specification: " + invalidKeySpecException0);
        }
    }

    public static boolean verify(PublicKey publicKey0, String s, String s1) {
        String s2;
        try {
            byte[] arr_b = Base64.decode(s1, 0);
        }
        catch(IllegalArgumentException unused_ex) {
            Logger.warning("Base64 decoding failed.");
            return false;
        }
        try {
            Signature signature0 = Signature.getInstance("SHA1withRSA");
            signature0.initVerify(publicKey0);
            signature0.update(s.getBytes());
            if(!signature0.verify(arr_b)) {
                Logger.warning("Signature verification failed.");
                return false;
            }
            return true;
        }
        catch(NoSuchAlgorithmException noSuchAlgorithmException0) {
            throw new RuntimeException(noSuchAlgorithmException0);
        }
        catch(InvalidKeyException unused_ex) {
            s2 = "Invalid key specification.";
        }
        catch(SignatureException unused_ex) {
            s2 = "Signature exception.";
        }
        Logger.warning(s2);
        return false;
    }

    public static boolean verifyPurchase(String s, String s1, String s2) {
        if(!TextUtils.isEmpty(s1) && !TextUtils.isEmpty(s) && !TextUtils.isEmpty(s2)) {
            return Security.verify(Security.generatePublicKey(s), s1, s2);
        }
        Logger.warning("Purchase verification failed: missing data.");
        return false;
    }
}

