package com.google.android.play.core.review.internal;

import android.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class zzv {
    public static String zza(byte[] arr_b) {
        MessageDigest messageDigest0;
        try {
            messageDigest0 = MessageDigest.getInstance("SHA-256");
        }
        catch(NoSuchAlgorithmException unused_ex) {
            return "";
        }
        messageDigest0.update(arr_b);
        return Base64.encodeToString(messageDigest0.digest(), 11);
    }
}

