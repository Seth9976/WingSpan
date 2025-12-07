package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.StatusCallback;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.zzbq;
import com.google.android.gms.location.zzu;
import java.util.List;

public final class zzaz extends zzi {
    private final zzav zzf;

    public zzaz(Context context0, Looper looper0, ConnectionCallbacks googleApiClient$ConnectionCallbacks0, OnConnectionFailedListener googleApiClient$OnConnectionFailedListener0, String s, ClientSettings clientSettings0) {
        super(context0, looper0, googleApiClient$ConnectionCallbacks0, googleApiClient$OnConnectionFailedListener0, s, clientSettings0);
        this.zzf = new zzav(context0, this.zze);
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api$Client
    public final void disconnect() {
        synchronized(this.zzf) {
            if(this.isConnected()) {
                try {
                    this.zzf.zzn();
                    this.zzf.zzo();
                }
                catch(Exception exception0) {
                    Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", exception0);
                }
            }
            super.disconnect();
        }
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    public final boolean usesClientTelemetry() {
        return true;
    }

    public final LocationAvailability zzA() throws RemoteException {
        return this.zzf.zzc();
    }

    public final void zzB(zzba zzba0, ListenerHolder listenerHolder0, zzai zzai0) throws RemoteException {
        synchronized(this.zzf) {
            this.zzf.zze(zzba0, listenerHolder0, zzai0);
        }
    }

    public final void zzC(LocationRequest locationRequest0, ListenerHolder listenerHolder0, zzai zzai0) throws RemoteException {
        synchronized(this.zzf) {
            this.zzf.zzd(locationRequest0, listenerHolder0, zzai0);
        }
    }

    public final void zzD(zzba zzba0, PendingIntent pendingIntent0, zzai zzai0) throws RemoteException {
        this.zzf.zzf(zzba0, pendingIntent0, zzai0);
    }

    public final void zzE(LocationRequest locationRequest0, PendingIntent pendingIntent0, zzai zzai0) throws RemoteException {
        this.zzf.zzg(locationRequest0, pendingIntent0, zzai0);
    }

    public final void zzF(ListenerKey listenerHolder$ListenerKey0, zzai zzai0) throws RemoteException {
        this.zzf.zzh(listenerHolder$ListenerKey0, zzai0);
    }

    public final void zzG(PendingIntent pendingIntent0, zzai zzai0) throws RemoteException {
        this.zzf.zzj(pendingIntent0, zzai0);
    }

    public final void zzH(ListenerKey listenerHolder$ListenerKey0, zzai zzai0) throws RemoteException {
        this.zzf.zzi(listenerHolder$ListenerKey0, zzai0);
    }

    public final void zzI(boolean z) throws RemoteException {
        this.zzf.zzk(z);
    }

    public final void zzJ(Location location0) throws RemoteException {
        this.zzf.zzl(location0);
    }

    public final void zzK(zzai zzai0) throws RemoteException {
        this.zzf.zzm(zzai0);
    }

    public final void zzL(LocationSettingsRequest locationSettingsRequest0, ResultHolder baseImplementation$ResultHolder0, String s) throws RemoteException {
        this.checkConnected();
        boolean z = true;
        Preconditions.checkArgument(locationSettingsRequest0 != null, "locationSettingsRequest can\'t be null nor empty.");
        if(baseImplementation$ResultHolder0 == null) {
            z = false;
        }
        Preconditions.checkArgument(z, "listener can\'t be null.");
        zzay zzay0 = new zzay(baseImplementation$ResultHolder0);
        ((zzam)this.getService()).zzt(locationSettingsRequest0, zzay0, null);
    }

    public final void zzq(long v, PendingIntent pendingIntent0) throws RemoteException {
        this.checkConnected();
        Preconditions.checkNotNull(pendingIntent0);
        Preconditions.checkArgument(Long.compare(v, 0L) >= 0, "detectionIntervalMillis must be >= 0");
        ((zzam)this.getService()).zzh(v, true, pendingIntent0);
    }

    public final void zzr(ActivityTransitionRequest activityTransitionRequest0, PendingIntent pendingIntent0, ResultHolder baseImplementation$ResultHolder0) throws RemoteException {
        this.checkConnected();
        Preconditions.checkNotNull(activityTransitionRequest0, "activityTransitionRequest must be specified.");
        Preconditions.checkNotNull(pendingIntent0, "PendingIntent must be specified.");
        Preconditions.checkNotNull(baseImplementation$ResultHolder0, "ResultHolder not provided.");
        StatusCallback statusCallback0 = new StatusCallback(baseImplementation$ResultHolder0);
        ((zzam)this.getService()).zzi(activityTransitionRequest0, pendingIntent0, statusCallback0);
    }

    public final void zzs(PendingIntent pendingIntent0, ResultHolder baseImplementation$ResultHolder0) throws RemoteException {
        this.checkConnected();
        Preconditions.checkNotNull(baseImplementation$ResultHolder0, "ResultHolder not provided.");
        StatusCallback statusCallback0 = new StatusCallback(baseImplementation$ResultHolder0);
        ((zzam)this.getService()).zzj(pendingIntent0, statusCallback0);
    }

    public final void zzt(PendingIntent pendingIntent0) throws RemoteException {
        this.checkConnected();
        Preconditions.checkNotNull(pendingIntent0);
        ((zzam)this.getService()).zzk(pendingIntent0);
    }

    public final void zzu(PendingIntent pendingIntent0, ResultHolder baseImplementation$ResultHolder0) throws RemoteException {
        this.checkConnected();
        Preconditions.checkNotNull(pendingIntent0, "PendingIntent must be specified.");
        Preconditions.checkNotNull(baseImplementation$ResultHolder0, "ResultHolder not provided.");
        StatusCallback statusCallback0 = new StatusCallback(baseImplementation$ResultHolder0);
        ((zzam)this.getService()).zzl(pendingIntent0, statusCallback0);
    }

    public final void zzv(GeofencingRequest geofencingRequest0, PendingIntent pendingIntent0, ResultHolder baseImplementation$ResultHolder0) throws RemoteException {
        this.checkConnected();
        Preconditions.checkNotNull(geofencingRequest0, "geofencingRequest can\'t be null.");
        Preconditions.checkNotNull(pendingIntent0, "PendingIntent must be specified.");
        Preconditions.checkNotNull(baseImplementation$ResultHolder0, "ResultHolder not provided.");
        zzaw zzaw0 = new zzaw(baseImplementation$ResultHolder0);
        ((zzam)this.getService()).zzd(geofencingRequest0, pendingIntent0, zzaw0);
    }

    public final void zzw(zzbq zzbq0, ResultHolder baseImplementation$ResultHolder0) throws RemoteException {
        this.checkConnected();
        Preconditions.checkNotNull(zzbq0, "removeGeofencingRequest can\'t be null.");
        Preconditions.checkNotNull(baseImplementation$ResultHolder0, "ResultHolder not provided.");
        zzax zzax0 = new zzax(baseImplementation$ResultHolder0);
        ((zzam)this.getService()).zzg(zzbq0, zzax0);
    }

    public final void zzx(PendingIntent pendingIntent0, ResultHolder baseImplementation$ResultHolder0) throws RemoteException {
        this.checkConnected();
        Preconditions.checkNotNull(pendingIntent0, "PendingIntent must be specified.");
        Preconditions.checkNotNull(baseImplementation$ResultHolder0, "ResultHolder not provided.");
        zzax zzax0 = new zzax(baseImplementation$ResultHolder0);
        ((zzam)this.getService()).zze(pendingIntent0, zzax0, "com.MonsterCouch.Wingspan");
    }

    public final void zzy(List list0, ResultHolder baseImplementation$ResultHolder0) throws RemoteException {
        this.checkConnected();
        Preconditions.checkArgument(list0 != null && list0.size() > 0, "geofenceRequestIds can\'t be null nor empty.");
        Preconditions.checkNotNull(baseImplementation$ResultHolder0, "ResultHolder not provided.");
        String[] arr_s = (String[])list0.toArray(new String[0]);
        zzax zzax0 = new zzax(baseImplementation$ResultHolder0);
        ((zzam)this.getService()).zzf(arr_s, zzax0, "com.MonsterCouch.Wingspan");
    }

    // 去混淆评级： 低(20)
    public final Location zzz(String s) throws RemoteException {
        return ArrayUtils.contains(this.getAvailableFeatures(), zzu.zzc) ? this.zzf.zza(s) : this.zzf.zzb();
    }
}

