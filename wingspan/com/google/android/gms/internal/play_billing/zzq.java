package com.google.android.gms.internal.play_billing;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzq extends zzv implements zzs {
    zzq(IBinder iBinder0) {
        super(iBinder0, "com.android.vending.billing.IInAppBillingService");
    }

    @Override  // com.google.android.gms.internal.play_billing.zzs
    public final int zza(int v, String s, String s1) throws RemoteException {
        Parcel parcel0 = this.zzu();
        parcel0.writeInt(3);
        parcel0.writeString(s);
        parcel0.writeString(s1);
        Parcel parcel1 = this.zzv(5, parcel0);
        int v1 = parcel1.readInt();
        parcel1.recycle();
        return v1;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzs
    public final int zzc(int v, String s, String s1, Bundle bundle0) throws RemoteException {
        Parcel parcel0 = this.zzu();
        parcel0.writeInt(v);
        parcel0.writeString(s);
        parcel0.writeString(s1);
        zzx.zzc(parcel0, bundle0);
        Parcel parcel1 = this.zzv(10, parcel0);
        int v1 = parcel1.readInt();
        parcel1.recycle();
        return v1;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzs
    public final Bundle zzd(int v, String s, String s1, Bundle bundle0) throws RemoteException {
        Parcel parcel0 = this.zzu();
        parcel0.writeInt(9);
        parcel0.writeString(s);
        parcel0.writeString(s1);
        zzx.zzc(parcel0, bundle0);
        Parcel parcel1 = this.zzv(902, parcel0);
        Bundle bundle1 = (Bundle)zzx.zza(parcel1, Bundle.CREATOR);
        parcel1.recycle();
        return bundle1;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzs
    public final Bundle zze(int v, String s, String s1, Bundle bundle0) throws RemoteException {
        Parcel parcel0 = this.zzu();
        parcel0.writeInt(9);
        parcel0.writeString(s);
        parcel0.writeString(s1);
        zzx.zzc(parcel0, bundle0);
        Parcel parcel1 = this.zzv(12, parcel0);
        Bundle bundle1 = (Bundle)zzx.zza(parcel1, Bundle.CREATOR);
        parcel1.recycle();
        return bundle1;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzs
    public final Bundle zzf(int v, String s, String s1, String s2, String s3) throws RemoteException {
        Parcel parcel0 = this.zzu();
        parcel0.writeInt(3);
        parcel0.writeString(s);
        parcel0.writeString(s1);
        parcel0.writeString(s2);
        parcel0.writeString(null);
        Parcel parcel1 = this.zzv(3, parcel0);
        Bundle bundle0 = (Bundle)zzx.zza(parcel1, Bundle.CREATOR);
        parcel1.recycle();
        return bundle0;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzs
    public final Bundle zzg(int v, String s, String s1, String s2, String s3, Bundle bundle0) throws RemoteException {
        Parcel parcel0 = this.zzu();
        parcel0.writeInt(v);
        parcel0.writeString(s);
        parcel0.writeString(s1);
        parcel0.writeString(s2);
        parcel0.writeString(null);
        zzx.zzc(parcel0, bundle0);
        Parcel parcel1 = this.zzv(8, parcel0);
        Bundle bundle1 = (Bundle)zzx.zza(parcel1, Bundle.CREATOR);
        parcel1.recycle();
        return bundle1;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzs
    public final Bundle zzh(int v, String s, String s1, String s2, Bundle bundle0) throws RemoteException {
        Parcel parcel0 = this.zzu();
        parcel0.writeInt(6);
        parcel0.writeString(s);
        parcel0.writeString(s1);
        parcel0.writeString(s2);
        zzx.zzc(parcel0, bundle0);
        Parcel parcel1 = this.zzv(9, parcel0);
        Bundle bundle1 = (Bundle)zzx.zza(parcel1, Bundle.CREATOR);
        parcel1.recycle();
        return bundle1;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzs
    public final Bundle zzi(int v, String s, String s1, String s2) throws RemoteException {
        Parcel parcel0 = this.zzu();
        parcel0.writeInt(3);
        parcel0.writeString(s);
        parcel0.writeString(s1);
        parcel0.writeString(s2);
        Parcel parcel1 = this.zzv(4, parcel0);
        Bundle bundle0 = (Bundle)zzx.zza(parcel1, Bundle.CREATOR);
        parcel1.recycle();
        return bundle0;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzs
    public final Bundle zzj(int v, String s, String s1, String s2, Bundle bundle0) throws RemoteException {
        Parcel parcel0 = this.zzu();
        parcel0.writeInt(v);
        parcel0.writeString(s);
        parcel0.writeString(s1);
        parcel0.writeString(s2);
        zzx.zzc(parcel0, bundle0);
        Parcel parcel1 = this.zzv(11, parcel0);
        Bundle bundle1 = (Bundle)zzx.zza(parcel1, Bundle.CREATOR);
        parcel1.recycle();
        return bundle1;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzs
    public final Bundle zzk(int v, String s, String s1, Bundle bundle0) throws RemoteException {
        Parcel parcel0 = this.zzu();
        parcel0.writeInt(3);
        parcel0.writeString(s);
        parcel0.writeString(s1);
        zzx.zzc(parcel0, bundle0);
        Parcel parcel1 = this.zzv(2, parcel0);
        Bundle bundle1 = (Bundle)zzx.zza(parcel1, Bundle.CREATOR);
        parcel1.recycle();
        return bundle1;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzs
    public final Bundle zzl(int v, String s, String s1, Bundle bundle0, Bundle bundle1) throws RemoteException {
        Parcel parcel0 = this.zzu();
        parcel0.writeInt(v);
        parcel0.writeString(s);
        parcel0.writeString(s1);
        zzx.zzc(parcel0, bundle0);
        zzx.zzc(parcel0, bundle1);
        Parcel parcel1 = this.zzv(901, parcel0);
        Bundle bundle2 = (Bundle)zzx.zza(parcel1, Bundle.CREATOR);
        parcel1.recycle();
        return bundle2;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzs
    public final void zzm(int v, String s, Bundle bundle0, zzd zzd0) throws RemoteException {
        Parcel parcel0 = this.zzu();
        parcel0.writeInt(21);
        parcel0.writeString(s);
        zzx.zzc(parcel0, bundle0);
        parcel0.writeStrongBinder(((IBinder)zzd0));
        this.zzx(1501, parcel0);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzs
    public final void zzn(int v, String s, Bundle bundle0, zzf zzf0) throws RemoteException {
        Parcel parcel0 = this.zzu();
        parcel0.writeInt(22);
        parcel0.writeString(s);
        zzx.zzc(parcel0, bundle0);
        parcel0.writeStrongBinder(((IBinder)zzf0));
        this.zzx(0x709, parcel0);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzs
    public final void zzo(int v, String s, Bundle bundle0, zzh zzh0) throws RemoteException {
        Parcel parcel0 = this.zzu();
        parcel0.writeInt(21);
        parcel0.writeString(s);
        zzx.zzc(parcel0, bundle0);
        parcel0.writeStrongBinder(((IBinder)zzh0));
        this.zzx(1601, parcel0);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzs
    public final void zzp(int v, String s, Bundle bundle0, zzj zzj0) throws RemoteException {
        Parcel parcel0 = this.zzu();
        parcel0.writeInt(18);
        parcel0.writeString(s);
        zzx.zzc(parcel0, bundle0);
        parcel0.writeStrongBinder(((IBinder)zzj0));
        this.zzw(1301, parcel0);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzs
    public final void zzq(int v, String s, Bundle bundle0, zzl zzl0) throws RemoteException {
        Parcel parcel0 = this.zzu();
        parcel0.writeInt(22);
        parcel0.writeString(s);
        zzx.zzc(parcel0, bundle0);
        parcel0.writeStrongBinder(((IBinder)zzl0));
        this.zzx(1901, parcel0);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzs
    public final void zzr(int v, String s, Bundle bundle0, zzn zzn0) throws RemoteException {
        Parcel parcel0 = this.zzu();
        parcel0.writeInt(21);
        parcel0.writeString(s);
        zzx.zzc(parcel0, bundle0);
        parcel0.writeStrongBinder(((IBinder)zzn0));
        this.zzx(1401, parcel0);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzs
    public final void zzs(int v, String s, Bundle bundle0, zzp zzp0) throws RemoteException {
        Parcel parcel0 = this.zzu();
        parcel0.writeInt(22);
        parcel0.writeString(s);
        zzx.zzc(parcel0, bundle0);
        parcel0.writeStrongBinder(((IBinder)zzp0));
        this.zzx(1701, parcel0);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzs
    public final void zzt(int v, String s, Bundle bundle0, zzu zzu0) throws RemoteException {
        Parcel parcel0 = this.zzu();
        parcel0.writeInt(12);
        parcel0.writeString(s);
        zzx.zzc(parcel0, bundle0);
        parcel0.writeStrongBinder(((IBinder)zzu0));
        this.zzw(1201, parcel0);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzs
    public final int zzy(int v, String s, String s1) throws RemoteException {
        Parcel parcel0 = this.zzu();
        parcel0.writeInt(v);
        parcel0.writeString(s);
        parcel0.writeString(s1);
        Parcel parcel1 = this.zzv(1, parcel0);
        int v1 = parcel1.readInt();
        parcel1.recycle();
        return v1;
    }
}

