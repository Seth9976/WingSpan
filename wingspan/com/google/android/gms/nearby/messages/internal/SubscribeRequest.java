package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.Strategy;

public final class SubscribeRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator CREATOR;
    private final int versionCode;
    @Deprecated
    private final String zzff;
    @Deprecated
    private final boolean zzfg;
    @Deprecated
    private final String zzfj;
    private final boolean zzgb;
    private final int zzgc;
    private final int zzhf;
    private final zzp zzhh;
    @Deprecated
    private final ClientAppContext zzhi;
    private final Strategy zzit;
    @Deprecated
    private final boolean zziu;
    private final zzm zziy;
    private final MessageFilter zziz;
    private final PendingIntent zzja;
    @Deprecated
    private final int zzjb;
    private final byte[] zzjc;
    private final zzaa zzjd;

    static {
        SubscribeRequest.CREATOR = new zzcd();
    }

    public SubscribeRequest(int v, IBinder iBinder0, Strategy strategy0, IBinder iBinder1, MessageFilter messageFilter0, PendingIntent pendingIntent0, int v1, String s, String s1, byte[] arr_b, boolean z, IBinder iBinder2, boolean z1, ClientAppContext clientAppContext0, boolean z2, int v2, int v3) {
        zzp zzp0;
        zzm zzm0;
        this.versionCode = v;
        zzaa zzaa0 = null;
        if(iBinder0 == null) {
            zzm0 = null;
        }
        else {
            IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IMessageListener");
            zzm0 = iInterface0 instanceof zzm ? ((zzm)iInterface0) : new zzo(iBinder0);
        }
        this.zziy = zzm0;
        this.zzit = strategy0;
        if(iBinder1 == null) {
            zzp0 = null;
        }
        else {
            IInterface iInterface1 = iBinder1.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
            zzp0 = iInterface1 instanceof zzp ? ((zzp)iInterface1) : new zzr(iBinder1);
        }
        this.zzhh = zzp0;
        this.zziz = messageFilter0;
        this.zzja = pendingIntent0;
        this.zzjb = v1;
        this.zzff = s;
        this.zzfj = s1;
        this.zzjc = arr_b;
        this.zziu = z;
        if(iBinder2 != null) {
            IInterface iInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.messages.internal.ISubscribeCallback");
            zzaa0 = iInterface2 instanceof zzaa ? ((zzaa)iInterface2) : new zzac(iBinder2);
        }
        this.zzjd = zzaa0;
        this.zzfg = z1;
        this.zzhi = ClientAppContext.zza(clientAppContext0, s1, s, z1);
        this.zzgb = z2;
        this.zzgc = v2;
        this.zzhf = v3;
    }

    public SubscribeRequest(IBinder iBinder0, Strategy strategy0, IBinder iBinder1, MessageFilter messageFilter0, PendingIntent pendingIntent0, byte[] arr_b, IBinder iBinder2, boolean z, int v) {
        this(iBinder0, strategy0, iBinder1, messageFilter0, null, arr_b, iBinder2, z, 0, v);
    }

    public SubscribeRequest(IBinder iBinder0, Strategy strategy0, IBinder iBinder1, MessageFilter messageFilter0, PendingIntent pendingIntent0, byte[] arr_b, IBinder iBinder2, boolean z, int v, int v1) {
        this(3, iBinder0, strategy0, iBinder1, messageFilter0, pendingIntent0, 0, null, null, arr_b, false, iBinder2, false, null, z, v, v1);
    }

    @Override
    public final String toString() {
        String s = String.valueOf(this.zziy);
        String s1 = String.valueOf(this.zzit);
        String s2 = String.valueOf(this.zzhh);
        String s3 = String.valueOf(this.zziz);
        String s4 = String.valueOf(this.zzja);
        return this.zzjc == null ? "SubscribeRequest{messageListener=" + s + ", strategy=" + s1 + ", callback=" + s2 + ", filter=" + s3 + ", pendingIntent=" + s4 + ", hint=" + null + ", subscribeCallback=" + this.zzjd + ", useRealClientApiKey=" + this.zzfg + ", clientAppContext=" + this.zzhi + ", isDiscardPendingIntent=" + this.zzgb + ", zeroPartyPackageName=" + this.zzff + ", realClientPackageName=" + this.zzfj + ", isIgnoreNearbyPermission=" + this.zziu + ", callingContext=" + this.zzhf + "}" : "SubscribeRequest{messageListener=" + s + ", strategy=" + s1 + ", callback=" + s2 + ", filter=" + s3 + ", pendingIntent=" + s4 + ", hint=" + ("<" + this.zzjc.length + " bytes>") + ", subscribeCallback=" + this.zzjd + ", useRealClientApiKey=" + this.zzfg + ", clientAppContext=" + this.zzhi + ", isDiscardPendingIntent=" + this.zzgb + ", zeroPartyPackageName=" + this.zzff + ", realClientPackageName=" + this.zzfj + ", isIgnoreNearbyPermission=" + this.zziu + ", callingContext=" + this.zzhf + "}";
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.versionCode);
        IBinder iBinder0 = null;
        SafeParcelWriter.writeIBinder(parcel0, 2, (this.zziy == null ? null : this.zziy.asBinder()), false);
        SafeParcelWriter.writeParcelable(parcel0, 3, this.zzit, v, false);
        SafeParcelWriter.writeIBinder(parcel0, 4, (this.zzhh == null ? null : this.zzhh.asBinder()), false);
        SafeParcelWriter.writeParcelable(parcel0, 5, this.zziz, v, false);
        SafeParcelWriter.writeParcelable(parcel0, 6, this.zzja, v, false);
        SafeParcelWriter.writeInt(parcel0, 7, this.zzjb);
        SafeParcelWriter.writeString(parcel0, 8, this.zzff, false);
        SafeParcelWriter.writeString(parcel0, 9, this.zzfj, false);
        SafeParcelWriter.writeByteArray(parcel0, 10, this.zzjc, false);
        SafeParcelWriter.writeBoolean(parcel0, 11, this.zziu);
        zzaa zzaa0 = this.zzjd;
        if(zzaa0 != null) {
            iBinder0 = zzaa0.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel0, 12, iBinder0, false);
        SafeParcelWriter.writeBoolean(parcel0, 13, this.zzfg);
        SafeParcelWriter.writeParcelable(parcel0, 14, this.zzhi, v, false);
        SafeParcelWriter.writeBoolean(parcel0, 15, this.zzgb);
        SafeParcelWriter.writeInt(parcel0, 16, this.zzgc);
        SafeParcelWriter.writeInt(parcel0, 17, this.zzhf);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

