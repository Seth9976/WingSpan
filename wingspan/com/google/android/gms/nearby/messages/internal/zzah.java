package com.google.android.gms.nearby.messages.internal;

import android.app.Activity;
import android.app.Application;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.internal.nearby.zzgw;
import com.google.android.gms.internal.nearby.zzgy;
import com.google.android.gms.internal.nearby.zzhb;
import com.google.android.gms.internal.nearby.zzhd;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.PublishOptions;
import com.google.android.gms.nearby.messages.SubscribeOptions;

public final class zzah extends GmsClient {
    private final int zzfh;
    private final ClientAppContext zzhi;
    private final zzhd zzhl;

    zzah(Context context0, Looper looper0, ConnectionCallbacks googleApiClient$ConnectionCallbacks0, OnConnectionFailedListener googleApiClient$OnConnectionFailedListener0, ClientSettings clientSettings0, MessagesOptions messagesOptions0) {
        super(context0, looper0, 62, clientSettings0, googleApiClient$ConnectionCallbacks0, googleApiClient$OnConnectionFailedListener0);
        int v1;
        this.zzhl = new zzhd();
        String s = clientSettings0.getRealClientPackageName();
        int v = zzah.zzb(context0);
        if(messagesOptions0 == null) {
            this.zzhi = new ClientAppContext(s, null, false, null, v);
            v1 = -1;
        }
        else {
            this.zzhi = new ClientAppContext(s, null, false, null, v);
            v1 = messagesOptions0.zzfh;
        }
        this.zzfh = v1;
        if(v == 1) {
            if(Log.isLoggable("NearbyMessagesClient", 2)) {
                Log.v("NearbyMessagesClient", "Registering ClientLifecycleSafetyNet\'s ActivityLifecycleCallbacks for com.MonsterCouch.Wingspan");
            }
            ((Activity)context0).getApplication().registerActivityLifecycleCallbacks(new zzaj(((Activity)context0), this, null));
        }
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    protected final IInterface createServiceInterface(IBinder iBinder0) {
        if(iBinder0 == null) {
            return null;
        }
        IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
        return iInterface0 instanceof zzs ? ((zzs)iInterface0) : new zzt(iBinder0);
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api$Client
    public final void disconnect() {
        try {
            this.zzf(2);
        }
        catch(RemoteException remoteException0) {
            if(Log.isLoggable("NearbyMessagesClient", 2)) {
                Log.v("NearbyMessagesClient", String.format("Failed to emit CLIENT_DISCONNECTED from override of GmsClient#disconnect(): %s", remoteException0));
            }
        }
        this.zzhl.clear();
        super.disconnect();
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    protected final Bundle getGetServiceRequestExtraArgs() {
        Bundle bundle0 = super.getGetServiceRequestExtraArgs();
        bundle0.putInt("NearbyPermissions", this.zzfh);
        bundle0.putParcelable("ClientAppContext", this.zzhi);
        return bundle0;
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api$Client
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getServiceDescriptor() {
        return "com.google.android.gms.nearby.messages.internal.INearbyMessagesService";
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getStartServiceAction() {
        return "com.google.android.gms.nearby.messages.service.NearbyMessagesService.START";
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api$Client
    public final boolean requiresGooglePlayServices() {
        return Nearby.zza(this.getContext());
    }

    final void zza(ListenerHolder listenerHolder0, PendingIntent pendingIntent0) throws RemoteException {
        zzcg zzcg0 = new zzcg(null, new zzgy(listenerHolder0), pendingIntent0);
        ((zzs)this.getService()).zza(zzcg0);
    }

    @Deprecated
    final void zza(ListenerHolder listenerHolder0, PendingIntent pendingIntent0, zzab zzab0, SubscribeOptions subscribeOptions0) throws RemoteException {
        this.zza(listenerHolder0, pendingIntent0, zzab0, subscribeOptions0, this.zzhi.zzhf);
    }

    final void zza(ListenerHolder listenerHolder0, PendingIntent pendingIntent0, zzab zzab0, SubscribeOptions subscribeOptions0, int v) throws RemoteException {
        SubscribeRequest subscribeRequest0 = new SubscribeRequest(null, subscribeOptions0.getStrategy(), new zzgy(listenerHolder0), subscribeOptions0.getFilter(), pendingIntent0, null, zzab0, subscribeOptions0.zzgb, subscribeOptions0.zzgc, this.zzhi.zzhf);
        ((zzs)this.getService()).zza(subscribeRequest0);
    }

    final void zza(ListenerHolder listenerHolder0, ListenerHolder listenerHolder1) throws RemoteException {
        zzgy zzgy0 = new zzgy(listenerHolder0);
        if(!this.zzhl.containsKey(listenerHolder1.getListenerKey())) {
            zzgy0.zza(new Status(0));
            return;
        }
        zzcg zzcg0 = new zzcg(((IBinder)this.zzhl.get(listenerHolder1.getListenerKey())), zzgy0, null);
        ((zzs)this.getService()).zza(zzcg0);
        this.zzhl.remove(listenerHolder1.getListenerKey());
    }

    @Deprecated
    final void zza(ListenerHolder listenerHolder0, ListenerHolder listenerHolder1, zzab zzab0, SubscribeOptions subscribeOptions0, byte[] arr_b) throws RemoteException {
        this.zza(listenerHolder0, listenerHolder1, zzab0, subscribeOptions0, null, this.zzhi.zzhf);
    }

    final void zza(ListenerHolder listenerHolder0, ListenerHolder listenerHolder1, zzab zzab0, SubscribeOptions subscribeOptions0, byte[] arr_b, int v) throws RemoteException {
        if(!this.zzhl.containsKey(listenerHolder1.getListenerKey())) {
            zzgw zzgw0 = new zzgw(listenerHolder1);
            this.zzhl.zza(listenerHolder1.getListenerKey(), zzgw0);
        }
        SubscribeRequest subscribeRequest0 = new SubscribeRequest(((IBinder)this.zzhl.get(listenerHolder1.getListenerKey())), subscribeOptions0.getStrategy(), new zzgy(listenerHolder0), subscribeOptions0.getFilter(), null, null, zzab0, subscribeOptions0.zzgb, v);
        ((zzs)this.getService()).zza(subscribeRequest0);
    }

    final void zza(ListenerHolder listenerHolder0, zzaf zzaf0) throws RemoteException {
        zzce zzce0 = new zzce(zzaf0, new zzgy(listenerHolder0));
        ((zzs)this.getService()).zza(zzce0);
    }

    @Deprecated
    final void zza(ListenerHolder listenerHolder0, zzaf zzaf0, zzv zzv0, PublishOptions publishOptions0) throws RemoteException {
        this.zza(listenerHolder0, zzaf0, zzv0, publishOptions0, this.zzhi.zzhf);
    }

    final void zza(ListenerHolder listenerHolder0, zzaf zzaf0, zzv zzv0, PublishOptions publishOptions0, int v) throws RemoteException {
        zzbz zzbz0 = new zzbz(zzaf0, publishOptions0.getStrategy(), new zzgy(listenerHolder0), zzv0, v);
        ((zzs)this.getService()).zza(zzbz0);
    }

    static int zzb(Context context0) {
        if(context0 instanceof Activity) {
            return 1;
        }
        if(context0 instanceof Application) {
            return 2;
        }
        return context0 instanceof Service ? 3 : 0;
    }

    final void zzb(ListenerHolder listenerHolder0, ListenerHolder listenerHolder1) throws RemoteException {
        if(!this.zzhl.containsKey(listenerHolder1.getListenerKey())) {
            zzhb zzhb0 = new zzhb(listenerHolder1);
            this.zzhl.zza(listenerHolder1.getListenerKey(), zzhb0);
        }
        zzcb zzcb0 = new zzcb(new zzgy(listenerHolder0), ((IBinder)this.zzhl.get(listenerHolder1.getListenerKey())));
        zzcb0.zzix = true;
        ((zzs)this.getService()).zza(zzcb0);
    }

    final void zzc(ListenerHolder listenerHolder0, ListenerHolder listenerHolder1) throws RemoteException {
        zzgy zzgy0 = new zzgy(listenerHolder0);
        if(!this.zzhl.containsKey(listenerHolder1.getListenerKey())) {
            zzgy0.zza(new Status(0));
            return;
        }
        zzcb zzcb0 = new zzcb(zzgy0, ((IBinder)this.zzhl.get(listenerHolder1.getListenerKey())));
        zzcb0.zzix = false;
        ((zzs)this.getService()).zza(zzcb0);
        this.zzhl.remove(listenerHolder1.getListenerKey());
    }

    final void zzf(int v) throws RemoteException {
        String s;
        switch(v) {
            case 1: {
                s = "ACTIVITY_STOPPED";
                break;
            }
            case 2: {
                s = "CLIENT_DISCONNECTED";
                break;
            }
            default: {
                if(Log.isLoggable("NearbyMessagesClient", 5)) {
                    Log.w("NearbyMessagesClient", String.format("Received unknown/unforeseen client lifecycle event %d, can\'t do anything with it.", v));
                }
                return;
            }
        }
        if(this.isConnected()) {
            zzj zzj0 = new zzj(v);
            if(Log.isLoggable("NearbyMessagesClient", 3)) {
                Log.d("NearbyMessagesClient", String.format("Emitting client lifecycle event %s", s));
            }
            ((zzs)this.getService()).zza(zzj0);
            return;
        }
        if(Log.isLoggable("NearbyMessagesClient", 3)) {
            Log.d("NearbyMessagesClient", String.format("Failed to emit client lifecycle event %s due to GmsClient being disconnected", s));
        }
    }
}

