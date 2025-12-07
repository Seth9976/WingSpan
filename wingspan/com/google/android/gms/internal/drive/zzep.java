package com.google.android.gms.internal.drive;

import android.content.IntentSender;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzep extends zza implements zzeo {
    zzep(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.drive.internal.IDriveService");
    }

    @Override  // com.google.android.gms.internal.drive.zzeo
    public final IntentSender zza(zzgm zzgm0) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zza(parcel0, zzgm0);
        Parcel parcel1 = this.zza(10, parcel0);
        IntentSender intentSender0 = (IntentSender)zzc.zza(parcel1, IntentSender.CREATOR);
        parcel1.recycle();
        return intentSender0;
    }

    @Override  // com.google.android.gms.internal.drive.zzeo
    public final IntentSender zza(zzu zzu0) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zza(parcel0, zzu0);
        Parcel parcel1 = this.zza(11, parcel0);
        IntentSender intentSender0 = (IntentSender)zzc.zza(parcel1, IntentSender.CREATOR);
        parcel1.recycle();
        return intentSender0;
    }

    @Override  // com.google.android.gms.internal.drive.zzeo
    public final zzec zza(zzgj zzgj0, zzeq zzeq0) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zza(parcel0, zzgj0);
        zzc.zza(parcel0, zzeq0);
        Parcel parcel1 = this.zza(7, parcel0);
        zzec zzec0 = (zzec)zzc.zza(parcel1, zzec.CREATOR);
        parcel1.recycle();
        return zzec0;
    }

    @Override  // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzab zzab0, zzeq zzeq0) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zza(parcel0, zzab0);
        zzc.zza(parcel0, zzeq0);
        this.zzb(24, parcel0);
    }

    @Override  // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzad zzad0) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zza(parcel0, zzad0);
        this.zzb(16, parcel0);
    }

    @Override  // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzek zzek0, zzeq zzeq0) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zza(parcel0, zzek0);
        zzc.zza(parcel0, zzeq0);
        this.zzb(1, parcel0);
    }

    @Override  // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzeq zzeq0) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zza(parcel0, zzeq0);
        this.zzb(9, parcel0);
    }

    @Override  // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzex zzex0, zzeq zzeq0) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zza(parcel0, zzex0);
        zzc.zza(parcel0, zzeq0);
        this.zzb(13, parcel0);
    }

    @Override  // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzgq zzgq0, zzeq zzeq0) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zza(parcel0, zzgq0);
        zzc.zza(parcel0, zzeq0);
        this.zzb(2, parcel0);
    }

    @Override  // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzgs zzgs0, zzes zzes0, String s, zzeq zzeq0) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zza(parcel0, zzgs0);
        zzc.zza(parcel0, zzes0);
        parcel0.writeString(null);
        zzc.zza(parcel0, zzeq0);
        this.zzb(15, parcel0);
    }

    @Override  // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzgu zzgu0, zzeq zzeq0) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zza(parcel0, zzgu0);
        zzc.zza(parcel0, zzeq0);
        this.zzb(36, parcel0);
    }

    @Override  // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzgw zzgw0, zzeq zzeq0) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zza(parcel0, zzgw0);
        zzc.zza(parcel0, zzeq0);
        this.zzb(28, parcel0);
    }

    @Override  // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzhb zzhb0, zzeq zzeq0) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zza(parcel0, zzhb0);
        zzc.zza(parcel0, zzeq0);
        this.zzb(17, parcel0);
    }

    @Override  // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzhd zzhd0, zzeq zzeq0) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zza(parcel0, zzhd0);
        zzc.zza(parcel0, zzeq0);
        this.zzb(38, parcel0);
    }

    @Override  // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzhf zzhf0, zzeq zzeq0) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zza(parcel0, zzhf0);
        zzc.zza(parcel0, zzeq0);
        this.zzb(3, parcel0);
    }

    @Override  // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzj zzj0, zzes zzes0, String s, zzeq zzeq0) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zza(parcel0, zzj0);
        zzc.zza(parcel0, zzes0);
        parcel0.writeString(null);
        zzc.zza(parcel0, zzeq0);
        this.zzb(14, parcel0);
    }

    @Override  // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzm zzm0, zzeq zzeq0) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zza(parcel0, zzm0);
        zzc.zza(parcel0, zzeq0);
        this.zzb(18, parcel0);
    }

    @Override  // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzo zzo0, zzeq zzeq0) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zza(parcel0, zzo0);
        zzc.zza(parcel0, zzeq0);
        this.zzb(8, parcel0);
    }

    @Override  // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzr zzr0, zzeq zzeq0) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zza(parcel0, zzr0);
        zzc.zza(parcel0, zzeq0);
        this.zzb(4, parcel0);
    }

    @Override  // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzw zzw0, zzeq zzeq0) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zza(parcel0, zzw0);
        zzc.zza(parcel0, zzeq0);
        this.zzb(5, parcel0);
    }

    @Override  // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzy zzy0, zzeq zzeq0) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zza(parcel0, zzy0);
        zzc.zza(parcel0, zzeq0);
        this.zzb(6, parcel0);
    }

    @Override  // com.google.android.gms.internal.drive.zzeo
    public final void zzb(zzeq zzeq0) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zza(parcel0, zzeq0);
        this.zzb(35, parcel0);
    }
}

