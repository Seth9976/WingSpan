package com.google.android.gms.games.internal;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.google.android.gms.internal.games.zza;
import com.google.android.gms.internal.games.zzc;

public final class zzce extends zza implements IInterface {
    zzce(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.games.internal.IGamesService");
    }

    public final void zzA(zzcb zzcb0, String s, String s1, int v, int v1) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zzf(parcel0, zzcb0);
        parcel0.writeString(null);
        parcel0.writeString(s1);
        parcel0.writeInt(v);
        parcel0.writeInt(v1);
        this.zzc(8001, parcel0);
    }

    public final void zzB(zzcb zzcb0) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zzf(parcel0, zzcb0);
        this.zzc(0x520F, parcel0);
    }

    public final void zzC(zzcb zzcb0, String s, int v, IBinder iBinder0, Bundle bundle0) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zzf(parcel0, zzcb0);
        parcel0.writeString(s);
        parcel0.writeInt(v);
        parcel0.writeStrongBinder(iBinder0);
        zzc.zzd(parcel0, bundle0);
        this.zzc(5025, parcel0);
    }

    public final void zzD(String s, int v) throws RemoteException {
        Parcel parcel0 = this.zza();
        parcel0.writeString(s);
        parcel0.writeInt(v);
        this.zzc(0x2EF1, parcel0);
    }

    public final void zzE(zzcb zzcb0, int v) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zzf(parcel0, zzcb0);
        parcel0.writeInt(v);
        this.zzc(0x5600, parcel0);
    }

    public final void zzF(zzcb zzcb0, boolean z) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zzf(parcel0, zzcb0);
        zzc.zzc(parcel0, z);
        this.zzc(6001, parcel0);
    }

    public final void zzG(zzcb zzcb0, boolean z) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zzf(parcel0, zzcb0);
        zzc.zzc(parcel0, z);
        this.zzc(8027, parcel0);
    }

    public final void zzH(zzcb zzcb0, boolean z) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zzf(parcel0, zzcb0);
        zzc.zzc(parcel0, z);
        this.zzc(0x2EF0, parcel0);
    }

    public final void zzI(zzcb zzcb0, boolean z, String[] arr_s) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zzf(parcel0, zzcb0);
        zzc.zzc(parcel0, z);
        parcel0.writeStringArray(arr_s);
        this.zzc(0x2EFF, parcel0);
    }

    public final void zzJ(zzcb zzcb0) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zzf(parcel0, zzcb0);
        this.zzc(5026, parcel0);
    }

    public final void zzK(zzcb zzcb0, int v, boolean z, boolean z1) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zzf(parcel0, zzcb0);
        parcel0.writeInt(v);
        zzc.zzc(parcel0, z);
        zzc.zzc(parcel0, z1);
        this.zzc(5015, parcel0);
    }

    public final void zzL(zzcb zzcb0, String s, boolean z) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zzf(parcel0, zzcb0);
        parcel0.writeString(s);
        zzc.zzc(parcel0, z);
        this.zzc(6504, parcel0);
    }

    public final void zzM(zzcb zzcb0, boolean z) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zzf(parcel0, zzcb0);
        zzc.zzc(parcel0, z);
        this.zzc(6503, parcel0);
    }

    public final void zzN(zzcb zzcb0, Bundle bundle0, int v, int v1) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zzf(parcel0, zzcb0);
        zzc.zzd(parcel0, bundle0);
        parcel0.writeInt(v);
        parcel0.writeInt(v1);
        this.zzc(5021, parcel0);
    }

    public final void zzO(zzcb zzcb0, String s, int v, int v1, int v2, boolean z) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zzf(parcel0, zzcb0);
        parcel0.writeString(s);
        parcel0.writeInt(v);
        parcel0.writeInt(v1);
        parcel0.writeInt(v2);
        zzc.zzc(parcel0, z);
        this.zzc(5020, parcel0);
    }

    public final void zzP(zzcb zzcb0, boolean z) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zzf(parcel0, zzcb0);
        zzc.zzc(parcel0, z);
        this.zzc(17001, parcel0);
    }

    public final void zzQ(zzcb zzcb0, String s, boolean z) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zzf(parcel0, zzcb0);
        parcel0.writeString(s);
        zzc.zzc(parcel0, z);
        this.zzc(13006, parcel0);
    }

    public final void zzR(zzcb zzcb0, String s, int v, boolean z, boolean z1) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zzf(parcel0, zzcb0);
        parcel0.writeString(s);
        parcel0.writeInt(v);
        zzc.zzc(parcel0, z);
        zzc.zzc(parcel0, z1);
        this.zzc(9020, parcel0);
    }

    public final void zzS(zzcb zzcb0, boolean z) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zzf(parcel0, zzcb0);
        zzc.zzc(parcel0, z);
        this.zzc(12002, parcel0);
    }

    public final void zzT(zzcb zzcb0, String s, int v, int v1, int v2, boolean z) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zzf(parcel0, zzcb0);
        parcel0.writeString(s);
        parcel0.writeInt(v);
        parcel0.writeInt(v1);
        parcel0.writeInt(v2);
        zzc.zzc(parcel0, z);
        this.zzc(5019, parcel0);
    }

    public final void zzU(zzcb zzcb0, String s, boolean z, int v) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zzf(parcel0, zzcb0);
        parcel0.writeString(s);
        zzc.zzc(parcel0, z);
        parcel0.writeInt(v);
        this.zzc(15001, parcel0);
    }

    public final void zzV(zzcb zzcb0, long v) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zzf(parcel0, zzcb0);
        parcel0.writeLong(v);
        this.zzc(0x560A, parcel0);
    }

    public final void zzW(zzcd zzcd0, long v) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zzf(parcel0, zzcd0);
        parcel0.writeLong(v);
        this.zzc(15501, parcel0);
    }

    public final void zzX(zzcb zzcb0, String s, String s1, SnapshotMetadataChangeEntity snapshotMetadataChangeEntity0, Contents contents0) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zzf(parcel0, zzcb0);
        parcel0.writeString(s);
        parcel0.writeString(s1);
        zzc.zzd(parcel0, snapshotMetadataChangeEntity0);
        zzc.zzd(parcel0, contents0);
        this.zzc(0x2F01, parcel0);
    }

    public final void zzY(zzcb zzcb0, String s, IBinder iBinder0, Bundle bundle0) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zzf(parcel0, zzcb0);
        parcel0.writeString(s);
        parcel0.writeStrongBinder(iBinder0);
        zzc.zzd(parcel0, bundle0);
        this.zzc(5023, parcel0);
    }

    public final void zzZ(zzcb zzcb0, String s, int v, IBinder iBinder0, Bundle bundle0) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zzf(parcel0, zzcb0);
        parcel0.writeString(s);
        parcel0.writeInt(v);
        parcel0.writeStrongBinder(iBinder0);
        zzc.zzd(parcel0, bundle0);
        this.zzc(7003, parcel0);
    }

    public final void zzaa(IBinder iBinder0, Bundle bundle0) throws RemoteException {
        Parcel parcel0 = this.zza();
        parcel0.writeStrongBinder(iBinder0);
        zzc.zzd(parcel0, bundle0);
        this.zzc(5005, parcel0);
    }

    public final void zzab(zzcb zzcb0) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zzf(parcel0, zzcb0);
        this.zzc(5002, parcel0);
    }

    public final void zzac(zzcb zzcb0, String s, long v, String s1) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zzf(parcel0, zzcb0);
        parcel0.writeString(s);
        parcel0.writeLong(v);
        parcel0.writeString(s1);
        this.zzc(7002, parcel0);
    }

    public final void zzad(zzcb zzcb0, String s, IBinder iBinder0, Bundle bundle0) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zzf(parcel0, zzcb0);
        parcel0.writeString(s);
        parcel0.writeStrongBinder(iBinder0);
        zzc.zzd(parcel0, bundle0);
        this.zzc(5024, parcel0);
    }

    public final void zzae(long v) throws RemoteException {
        Parcel parcel0 = this.zza();
        parcel0.writeLong(v);
        this.zzc(0x560B, parcel0);
    }

    public final boolean zzaf() throws RemoteException {
        Parcel parcel0 = this.zzb(22030, this.zza());
        boolean z = zzc.zzg(parcel0);
        parcel0.recycle();
        return z;
    }

    public final int zzd() throws RemoteException {
        Parcel parcel0 = this.zzb(0x2F04, this.zza());
        int v = parcel0.readInt();
        parcel0.recycle();
        return v;
    }

    public final int zze() throws RemoteException {
        Parcel parcel0 = this.zzb(0x2F03, this.zza());
        int v = parcel0.readInt();
        parcel0.recycle();
        return v;
    }

    public final PendingIntent zzf() throws RemoteException {
        Parcel parcel0 = this.zzb(25015, this.zza());
        PendingIntent pendingIntent0 = (PendingIntent)zzc.zza(parcel0, PendingIntent.CREATOR);
        parcel0.recycle();
        return pendingIntent0;
    }

    public final Intent zzg() throws RemoteException {
        Parcel parcel0 = this.zzb(9005, this.zza());
        Intent intent0 = (Intent)zzc.zza(parcel0, Intent.CREATOR);
        parcel0.recycle();
        return intent0;
    }

    public final Intent zzh() throws RemoteException {
        Parcel parcel0 = this.zzb(9003, this.zza());
        Intent intent0 = (Intent)zzc.zza(parcel0, Intent.CREATOR);
        parcel0.recycle();
        return intent0;
    }

    public final Intent zzi(PlayerEntity playerEntity0) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zzd(parcel0, playerEntity0);
        Parcel parcel1 = this.zzb(0x3C8F, parcel0);
        Intent intent0 = (Intent)zzc.zza(parcel1, Intent.CREATOR);
        parcel1.recycle();
        return intent0;
    }

    public final Intent zzj(String s, String s1, String s2) throws RemoteException {
        Parcel parcel0 = this.zza();
        parcel0.writeString(s);
        parcel0.writeString(s1);
        parcel0.writeString(s2);
        Parcel parcel1 = this.zzb(25016, parcel0);
        Intent intent0 = (Intent)zzc.zza(parcel1, Intent.CREATOR);
        parcel1.recycle();
        return intent0;
    }

    public final Intent zzk(String s, int v, int v1) throws RemoteException {
        Parcel parcel0 = this.zza();
        parcel0.writeString(s);
        parcel0.writeInt(v);
        parcel0.writeInt(v1);
        Parcel parcel1 = this.zzb(18001, parcel0);
        Intent intent0 = (Intent)zzc.zza(parcel1, Intent.CREATOR);
        parcel1.recycle();
        return intent0;
    }

    public final Intent zzl() throws RemoteException {
        Parcel parcel0 = this.zzb(9010, this.zza());
        Intent intent0 = (Intent)zzc.zza(parcel0, Intent.CREATOR);
        parcel0.recycle();
        return intent0;
    }

    public final Intent zzm(String s, boolean z, boolean z1, int v) throws RemoteException {
        Parcel parcel0 = this.zza();
        parcel0.writeString(s);
        zzc.zzc(parcel0, z);
        zzc.zzc(parcel0, z1);
        parcel0.writeInt(v);
        Parcel parcel1 = this.zzb(12001, parcel0);
        Intent intent0 = (Intent)zzc.zza(parcel1, Intent.CREATOR);
        parcel1.recycle();
        return intent0;
    }

    public final Intent zzn() throws RemoteException {
        Parcel parcel0 = this.zzb(9012, this.zza());
        Intent intent0 = (Intent)zzc.zza(parcel0, Intent.CREATOR);
        parcel0.recycle();
        return intent0;
    }

    public final Intent zzo() throws RemoteException {
        Parcel parcel0 = this.zzb(19002, this.zza());
        Intent intent0 = (Intent)zzc.zza(parcel0, Intent.CREATOR);
        parcel0.recycle();
        return intent0;
    }

    public final DataHolder zzp() throws RemoteException {
        Parcel parcel0 = this.zzb(5502, this.zza());
        DataHolder dataHolder0 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
        parcel0.recycle();
        return dataHolder0;
    }

    public final DataHolder zzq() throws RemoteException {
        Parcel parcel0 = this.zzb(5013, this.zza());
        DataHolder dataHolder0 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
        parcel0.recycle();
        return dataHolder0;
    }

    public final String zzr() throws RemoteException {
        Parcel parcel0 = this.zzb(5003, this.zza());
        String s = parcel0.readString();
        parcel0.recycle();
        return s;
    }

    public final String zzs() throws RemoteException {
        Parcel parcel0 = this.zzb(5007, this.zza());
        String s = parcel0.readString();
        parcel0.recycle();
        return s;
    }

    public final String zzt() throws RemoteException {
        Parcel parcel0 = this.zzb(5012, this.zza());
        String s = parcel0.readString();
        parcel0.recycle();
        return s;
    }

    public final void zzu() throws RemoteException {
        this.zzc(5006, this.zza());
    }

    public final void zzv(long v) throws RemoteException {
        Parcel parcel0 = this.zza();
        parcel0.writeLong(v);
        this.zzc(5001, parcel0);
    }

    public final void zzw(zzcb zzcb0, String s, SnapshotMetadataChangeEntity snapshotMetadataChangeEntity0, Contents contents0) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zzf(parcel0, zzcb0);
        parcel0.writeString(s);
        zzc.zzd(parcel0, snapshotMetadataChangeEntity0);
        zzc.zzd(parcel0, contents0);
        this.zzc(12007, parcel0);
    }

    public final void zzx(zzcb zzcb0, String s) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zzf(parcel0, zzcb0);
        parcel0.writeString(s);
        this.zzc(12020, parcel0);
    }

    public final void zzy(Contents contents0) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zzd(parcel0, contents0);
        this.zzc(0x2EF3, parcel0);
    }

    public final void zzz(zzcb zzcb0) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zzf(parcel0, zzcb0);
        this.zzc(0x560C, parcel0);
    }
}

