package com.google.android.gms.internal.appset;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.appset.zze;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;

public final class zzd extends GmsClient {
    protected zzd(Context context0, Looper looper0, ClientSettings clientSettings0, ConnectionCallbacks connectionCallbacks0, OnConnectionFailedListener onConnectionFailedListener0) {
        super(context0, looper0, 300, clientSettings0, connectionCallbacks0, onConnectionFailedListener0);
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    protected final IInterface createServiceInterface(IBinder iBinder0) {
        if(iBinder0 == null) {
            return null;
        }
        IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.appset.internal.IAppSetService");
        return iInterface0 instanceof zzg ? ((zzg)iInterface0) : new zzg(iBinder0);
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    public final Feature[] getApiFeatures() {
        return zze.zzb;
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api$Client
    public final int getMinApkVersion() {
        return 212800000;
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getServiceDescriptor() {
        return "com.google.android.gms.appset.internal.IAppSetService";
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getStartServiceAction() {
        return "com.google.android.gms.appset.service.START";
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    protected final boolean getUseDynamicLookup() {
        return true;
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    public final boolean usesClientTelemetry() {
        return true;
    }
}

