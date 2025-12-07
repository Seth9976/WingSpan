package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.SleepSegmentRequest;
import com.google.android.gms.location.zzbq;

public interface zzam extends IInterface {
    void zzd(GeofencingRequest arg1, PendingIntent arg2, zzak arg3) throws RemoteException;

    void zze(PendingIntent arg1, zzak arg2, String arg3) throws RemoteException;

    void zzf(String[] arg1, zzak arg2, String arg3) throws RemoteException;

    void zzg(zzbq arg1, zzak arg2) throws RemoteException;

    void zzh(long arg1, boolean arg2, PendingIntent arg3) throws RemoteException;

    void zzi(ActivityTransitionRequest arg1, PendingIntent arg2, IStatusCallback arg3) throws RemoteException;

    void zzj(PendingIntent arg1, IStatusCallback arg2) throws RemoteException;

    void zzk(PendingIntent arg1) throws RemoteException;

    void zzl(PendingIntent arg1, IStatusCallback arg2) throws RemoteException;

    @Deprecated
    Location zzm() throws RemoteException;

    Location zzn(String arg1) throws RemoteException;

    void zzo(zzbc arg1) throws RemoteException;

    void zzp(boolean arg1) throws RemoteException;

    void zzq(Location arg1) throws RemoteException;

    void zzr(zzai arg1) throws RemoteException;

    LocationAvailability zzs(String arg1) throws RemoteException;

    void zzt(LocationSettingsRequest arg1, zzao arg2, String arg3) throws RemoteException;

    void zzu(zzl arg1) throws RemoteException;

    void zzv(PendingIntent arg1, SleepSegmentRequest arg2, IStatusCallback arg3) throws RemoteException;
}

