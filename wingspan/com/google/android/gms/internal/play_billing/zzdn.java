package com.google.android.gms.internal.play_billing;

import java.io.IOException;

public class zzdn extends IOException {
    private zzek zza;

    public zzdn(IOException iOException0) {
        super(iOException0.getMessage(), iOException0);
        this.zza = null;
    }

    public zzdn(String s) {
        super(s);
        this.zza = null;
    }

    static zzdm zza() {
        return new zzdm("Protocol message tag had invalid wire type.");
    }

    static zzdn zzb() {
        return new zzdn("Protocol message contained an invalid tag (zero).");
    }

    static zzdn zzc() {
        return new zzdn("Protocol message had invalid UTF-8.");
    }

    static zzdn zzd() {
        return new zzdn("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzdn zze() {
        return new zzdn("Failed to parse the message.");
    }

    public final zzdn zzf(zzek zzek0) {
        this.zza = zzek0;
        return this;
    }

    static zzdn zzg() {
        return new zzdn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }
}

