package com.android.billingclient.api;

public final class AccountIdentifiers {
    private final String zza;
    private final String zzb;

    AccountIdentifiers(String s, String s1) {
        this.zza = s;
        this.zzb = s1;
    }

    public String getObfuscatedAccountId() {
        return this.zza;
    }

    public String getObfuscatedProfileId() {
        return this.zzb;
    }
}

