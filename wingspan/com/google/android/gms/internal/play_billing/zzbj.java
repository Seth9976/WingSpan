package com.google.android.gms.internal.play_billing;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

final class zzbj extends zzaz implements Serializable {
    private final MessageDigest zza;
    private final int zzb;
    private final boolean zzc;
    private final String zzd;

    zzbj(String s, String s1) {
        MessageDigest messageDigest0 = zzbj.zzc("SHA-256");
        this.zza = messageDigest0;
        this.zzb = messageDigest0.getDigestLength();
        this.zzd = "Hashing.sha256()";
        this.zzc = zzbj.zzd(messageDigest0);
    }

    @Override
    public final String toString() {
        return this.zzd;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzbd
    public final zzbe zzb() {
        if(this.zzc) {
            try {
                return new zzbi(((MessageDigest)this.zza.clone()), this.zzb, null);
            }
            catch(CloneNotSupportedException unused_ex) {
            }
        }
        return new zzbi(zzbj.zzc(this.zza.getAlgorithm()), this.zzb, null);
    }

    private static MessageDigest zzc(String s) {
        try {
            return MessageDigest.getInstance(s);
        }
        catch(NoSuchAlgorithmException noSuchAlgorithmException0) {
            throw new AssertionError(noSuchAlgorithmException0);
        }
    }

    private static boolean zzd(MessageDigest messageDigest0) {
        try {
            messageDigest0.clone();
            return true;
        }
        catch(CloneNotSupportedException unused_ex) {
            return false;
        }
    }
}

