package com.google.android.gms.internal.location;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.location.zzu;

public class zzi extends GmsClient {
    protected final zzbg zze;
    private final String zzf;

    public zzi(Context context0, Looper looper0, ConnectionCallbacks googleApiClient$ConnectionCallbacks0, OnConnectionFailedListener googleApiClient$OnConnectionFailedListener0, String s, ClientSettings clientSettings0) {
        super(context0, looper0, 23, clientSettings0, googleApiClient$ConnectionCallbacks0, googleApiClient$OnConnectionFailedListener0);
        this.zze = new zzh(this);
        this.zzf = s;
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    protected final IInterface createServiceInterface(IBinder iBinder0) {
        if(iBinder0 == null) {
            return null;
        }
        IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        return iInterface0 instanceof zzam ? ((zzam)iInterface0) : new zzal(iBinder0);
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    public final Feature[] getApiFeatures() {
        return zzu.zzf;
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    protected final Bundle getGetServiceRequestExtraArgs() {
        Bundle bundle0 = new Bundle();
        bundle0.putString("client_name", this.zzf);
        return bundle0;
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api$Client
    public final int getMinApkVersion() {
        return 11717000;
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getServiceDescriptor() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getStartServiceAction() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }
}

