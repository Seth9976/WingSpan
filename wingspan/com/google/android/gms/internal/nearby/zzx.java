package com.google.android.gms.internal.nearby;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import androidx.collection.ArraySet;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.connection.AdvertisingOptions;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.google.android.gms.nearby.connection.DiscoveryOptions;
import com.google.android.gms.nearby.connection.Payload;
import java.io.IOException;
import java.util.Set;

public final class zzx extends GmsClient {
    private final long zzaz;
    private final Set zzba;
    private final Set zzbb;
    private final Set zzbc;
    private zzff zzbd;

    public zzx(Context context0, Looper looper0, ClientSettings clientSettings0, ConnectionCallbacks googleApiClient$ConnectionCallbacks0, OnConnectionFailedListener googleApiClient$OnConnectionFailedListener0) {
        super(context0, looper0, 54, clientSettings0, googleApiClient$ConnectionCallbacks0, googleApiClient$OnConnectionFailedListener0);
        this.zzba = new ArraySet();
        this.zzbb = new ArraySet();
        this.zzbc = new ArraySet();
        this.zzaz = (long)this.hashCode();
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    protected final IInterface createServiceInterface(IBinder iBinder0) {
        if(iBinder0 == null) {
            return null;
        }
        IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
        return iInterface0 instanceof zzdu ? ((zzdu)iInterface0) : new zzdv(iBinder0);
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api$Client
    public final void disconnect() {
        if(this.isConnected()) {
            try {
                ((zzdu)this.getService()).zza(new zzv().zzd());
            }
            catch(RemoteException remoteException0) {
                Log.w("NearbyConnectionsClient", "Failed to notify client disconnect.", remoteException0);
            }
        }
        this.reset();
        super.disconnect();
    }

    public final void disconnectFromEndpoint(String s) throws RemoteException {
        ((zzdu)this.getService()).zza(new zzdb().zzd(s).zzf());
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    protected final Bundle getGetServiceRequestExtraArgs() {
        Bundle bundle0 = new Bundle();
        bundle0.putLong("clientId", this.zzaz);
        return bundle0;
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api$Client
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getServiceDescriptor() {
        return "com.google.android.gms.nearby.internal.connection.INearbyConnectionService";
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getStartServiceAction() {
        return "com.google.android.gms.nearby.connection.service.START";
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    protected final void onConnectedLocked(IInterface iInterface0) {
        super.onConnectedLocked(((zzdu)iInterface0));
        this.zzbd = new zzff();
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    public final void onConnectionSuspended(int v) {
        if(v == 1) {
            this.reset();
        }
        super.onConnectionSuspended(v);
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api$Client
    public final boolean requiresGooglePlayServices() {
        return Nearby.zza(this.getContext());
    }

    private final void reset() {
        for(Object object0: this.zzba) {
            ((zzak)object0).shutdown();
        }
        for(Object object1: this.zzbb) {
            ((zzav)object1).shutdown();
        }
        for(Object object2: this.zzbc) {
            ((zzz)object2).shutdown();
        }
        this.zzba.clear();
        this.zzbb.clear();
        this.zzbc.clear();
        zzff zzff0 = this.zzbd;
        if(zzff0 != null) {
            zzff0.shutdown();
            this.zzbd = null;
        }
    }

    public final void stopAdvertising() throws RemoteException {
        ((zzdu)this.getService()).zza(new zzgh().zzx());
    }

    public final void stopAllEndpoints() throws RemoteException {
        ((zzdu)this.getService()).zza(new zzgk().zzy());
    }

    public final void stopDiscovery() throws RemoteException {
        ((zzdu)this.getService()).zza(new zzgn().zzz());
    }

    private static Status zza(int v) {
        return new Status(v, ConnectionsStatusCodes.getStatusCodeString(v));
    }

    public final void zza(ResultHolder baseImplementation$ResultHolder0, long v) throws RemoteException {
        ((zzdu)this.getService()).zza(new zzs().zzb(new zzba(baseImplementation$ResultHolder0)).zza(v).zzc());
    }

    public final void zza(ResultHolder baseImplementation$ResultHolder0, String s) throws RemoteException {
        ((zzdu)this.getService()).zza(new zzfo().zzc(new zzba(baseImplementation$ResultHolder0)).zzf(s).zzs());
    }

    public final void zza(ResultHolder baseImplementation$ResultHolder0, String s, ListenerHolder listenerHolder0) throws RemoteException {
        zzav zzav0 = new zzav(listenerHolder0);
        this.zzbb.add(zzav0);
        ((zzdu)this.getService()).zza(new zzo().zza(new zzba(baseImplementation$ResultHolder0)).zza(s).zza(zzav0).zzb());
    }

    public final void zza(ResultHolder baseImplementation$ResultHolder0, String s, ListenerHolder listenerHolder0, DiscoveryOptions discoveryOptions0) throws RemoteException {
        zzak zzak0 = new zzak(listenerHolder0);
        this.zzba.add(zzak0);
        ((zzdu)this.getService()).zza(new zzge().zzf(new zzba(baseImplementation$ResultHolder0)).zzk(s).zze(discoveryOptions0).zza(zzak0).zzw());
    }

    public final void zza(ResultHolder baseImplementation$ResultHolder0, String s, String s1, ListenerHolder listenerHolder0) throws RemoteException {
        zzz zzz0 = new zzz(listenerHolder0);
        this.zzbc.add(zzz0);
        ((zzdu)this.getService()).zza(new zzfs().zzd(new zzba(baseImplementation$ResultHolder0)).zzg(s).zzh(s1).zza(zzz0).zzt());
    }

    public final void zza(ResultHolder baseImplementation$ResultHolder0, String s, String s1, ListenerHolder listenerHolder0, AdvertisingOptions advertisingOptions0) throws RemoteException {
        zzz zzz0 = new zzz(listenerHolder0);
        this.zzbc.add(zzz0);
        ((zzdu)this.getService()).zza(new zzga().zza(new zzbc(baseImplementation$ResultHolder0)).zzi(s).zzj(s1).zzg(advertisingOptions0).zzb(zzz0).zzv());
    }

    public final void zza(ResultHolder baseImplementation$ResultHolder0, String[] arr_s, Payload payload0, boolean z) throws RemoteException {
        Pair pair0;
        try {
            pair0 = zzfl.zza(payload0);
        }
        catch(IOException unused_ex) {
            baseImplementation$ResultHolder0.setResult(zzx.zza(8013));
            return;
        }
        ((zzdu)this.getService()).zza(new zzfw().zze(new zzba(baseImplementation$ResultHolder0)).zza(arr_s).zzb(((zzfh)pair0.first)).zzu());
        if(pair0.second != null) {
            Pair pair1 = (Pair)pair0.second;
            this.zzbd.zza(payload0.asStream().asInputStream(), new ParcelFileDescriptor.AutoCloseOutputStream(((ParcelFileDescriptor)pair1.first)), new ParcelFileDescriptor.AutoCloseOutputStream(((ParcelFileDescriptor)pair1.second)), payload0.getId());
        }
    }
}

