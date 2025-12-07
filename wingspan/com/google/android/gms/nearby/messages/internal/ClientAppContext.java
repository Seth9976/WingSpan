package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Locale;

public final class ClientAppContext extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator CREATOR;
    private final int versionCode;
    private final boolean zzfg;
    private final String zzfi;
    private final String zzfj;
    private final String zzhe;
    @Deprecated
    public final int zzhf;

    static {
        ClientAppContext.CREATOR = new zzd();
    }

    ClientAppContext(int v, String s, String s1, boolean z, int v1, String s2) {
        this.versionCode = v;
        this.zzfj = (String)Preconditions.checkNotNull(s);
        if(s1 != null && !s1.isEmpty() && !s1.startsWith("0p:")) {
            Log.w("NearbyMessages", String.format(Locale.US, "ClientAppContext: 0P identifier(%s) without 0P prefix(%s)", s1, "0p:"));
            String s3 = String.valueOf(s1);
            s1 = s3.length() == 0 ? new String("0p:") : "0p:" + s3;
        }
        this.zzhe = s1;
        this.zzfg = z;
        this.zzhf = v1;
        this.zzfi = s2;
    }

    public ClientAppContext(String s, String s1, boolean z, String s2, int v) {
        this(1, s, s1, z, v, s2);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof ClientAppContext ? ClientAppContext.zzc(this.zzfj, ((ClientAppContext)object0).zzfj) && ClientAppContext.zzc(this.zzhe, ((ClientAppContext)object0).zzhe) && this.zzfg == ((ClientAppContext)object0).zzfg && ClientAppContext.zzc(this.zzfi, ((ClientAppContext)object0).zzfi) && this.zzhf == ((ClientAppContext)object0).zzhf : false;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zzfj, this.zzhe, Boolean.valueOf(this.zzfg), this.zzfi, this.zzhf});
    }

    @Override
    public final String toString() {
        return String.format(Locale.US, "{realClientPackageName: %s, zeroPartyIdentifier: %s, useRealClientApiKey: %b, apiKey: %s, callingContext: %d}", this.zzfj, this.zzhe, Boolean.valueOf(this.zzfg), this.zzfi, this.zzhf);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.versionCode);
        SafeParcelWriter.writeString(parcel0, 2, this.zzfj, false);
        SafeParcelWriter.writeString(parcel0, 3, this.zzhe, false);
        SafeParcelWriter.writeBoolean(parcel0, 4, this.zzfg);
        SafeParcelWriter.writeInt(parcel0, 5, this.zzhf);
        SafeParcelWriter.writeString(parcel0, 6, this.zzfi, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    static final ClientAppContext zza(ClientAppContext clientAppContext0, String s, String s1, boolean z) {
        if(clientAppContext0 != null) {
            return clientAppContext0;
        }
        return s != null || s1 != null ? new ClientAppContext(s, s1, z, null, 0) : null;
    }

    // 去混淆评级： 低(20)
    private static boolean zzc(String s, String s1) {
        return TextUtils.isEmpty(s) ? TextUtils.isEmpty(s1) : s.equals(s1);
    }
}

