package com.google.android.gms.internal.drive;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.zzj;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzaw extends GmsClient {
    private final String zzeb;
    protected final boolean zzec;
    private volatile DriveId zzed;
    private volatile DriveId zzee;
    private volatile boolean zzef;
    private final Map zzeg;
    private final Map zzeh;
    private final Map zzei;
    private final Map zzej;
    private final Bundle zzz;

    public zzaw(Context context0, Looper looper0, ClientSettings clientSettings0, ConnectionCallbacks googleApiClient$ConnectionCallbacks0, OnConnectionFailedListener googleApiClient$OnConnectionFailedListener0, Bundle bundle0) {
        super(context0, looper0, 11, clientSettings0, googleApiClient$ConnectionCallbacks0, googleApiClient$OnConnectionFailedListener0);
        this.zzef = false;
        this.zzeg = new HashMap();
        this.zzeh = new HashMap();
        this.zzei = new HashMap();
        this.zzej = new HashMap();
        this.zzeb = clientSettings0.getRealClientPackageName();
        this.zzz = bundle0;
        Intent intent0 = new Intent("com.google.android.gms.drive.events.HANDLE_EVENT");
        intent0.setPackage("com.MonsterCouch.Wingspan");
        List list0 = context0.getPackageManager().queryIntentServices(intent0, 0);
        switch(list0.size()) {
            case 0: {
                this.zzec = false;
                return;
            }
            case 1: {
                ServiceInfo serviceInfo0 = ((ResolveInfo)list0.get(0)).serviceInfo;
                if(!serviceInfo0.exported) {
                    throw new IllegalStateException("Drive event service " + serviceInfo0.name + " must be exported in AndroidManifest.xml");
                }
                this.zzec = true;
                return;
            }
            default: {
                throw new IllegalStateException("AndroidManifest.xml can only define one service that handles the " + intent0.getAction() + " action");
            }
        }
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    protected final IInterface createServiceInterface(IBinder iBinder0) {
        if(iBinder0 == null) {
            return null;
        }
        IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.drive.internal.IDriveService");
        return iInterface0 instanceof zzeo ? ((zzeo)iInterface0) : new zzep(iBinder0);
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api$Client
    public final void disconnect() {
        if(this.isConnected()) {
            try {
                ((zzeo)this.getService()).zza(new zzad());
            }
            catch(RemoteException unused_ex) {
            }
        }
        super.disconnect();
        synchronized(this.zzeg) {
            this.zzeg.clear();
        }
        synchronized(this.zzeh) {
            this.zzeh.clear();
        }
        synchronized(this.zzei) {
            this.zzei.clear();
        }
        synchronized(this.zzej) {
            this.zzej.clear();
        }
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    protected final Bundle getGetServiceRequestExtraArgs() {
        Preconditions.checkNotNull("com.MonsterCouch.Wingspan");
        Preconditions.checkState(!this.getClientSettings().getAllRequestedScopes().isEmpty());
        Bundle bundle0 = new Bundle();
        if(!"com.MonsterCouch.Wingspan".equals(this.zzeb)) {
            bundle0.putString("proxy_package_name", this.zzeb);
        }
        bundle0.putAll(this.zzz);
        return bundle0;
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api$Client
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getServiceDescriptor() {
        return "com.google.android.gms.drive.internal.IDriveService";
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getStartServiceAction() {
        return "com.google.android.gms.drive.ApiService.START";
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    protected final void onPostInitHandler(int v, IBinder iBinder0, Bundle bundle0, int v1) {
        if(bundle0 != null) {
            bundle0.setClassLoader(this.getClass().getClassLoader());
            this.zzed = (DriveId)bundle0.getParcelable("com.google.android.gms.drive.root_id");
            this.zzee = (DriveId)bundle0.getParcelable("com.google.android.gms.drive.appdata_id");
            this.zzef = true;
        }
        super.onPostInitHandler(v, iBinder0, bundle0, v1);
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api$Client
    public final boolean requiresAccount() {
        return true;
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api$Client
    public final boolean requiresSignIn() {
        return !"com.MonsterCouch.Wingspan".equals(this.zzeb) || !UidVerifier.isGooglePlayServicesUid(this.getContext(), Process.myUid());
    }

    final PendingResult zza(GoogleApiClient googleApiClient0, DriveId driveId0, ChangeListener changeListener0) {
        zzee zzee0;
        Preconditions.checkArgument(zzj.zza(1, driveId0));
        Preconditions.checkNotNull(changeListener0, "listener");
        Preconditions.checkState(this.isConnected(), "Client must be connected");
        synchronized(this.zzeg) {
            Map map1 = (Map)this.zzeg.get(driveId0);
            if(map1 == null) {
                map1 = new HashMap();
                this.zzeg.put(driveId0, map1);
            }
            zzee0 = (zzee)map1.get(changeListener0);
            if(zzee0 == null) {
                zzee0 = new zzee(this.getLooper(), this.getContext(), 1, changeListener0);
                map1.put(changeListener0, zzee0);
            }
            else if(zzee0.zzg(1)) {
                return new zzat(googleApiClient0, Status.RESULT_SUCCESS);
            }
            zzee0.zzf(1);
        }
        return googleApiClient0.execute(new zzax(this, googleApiClient0, new com.google.android.gms.internal.drive.zzj(1, driveId0), zzee0));
    }

    public final DriveId zzae() {
        return this.zzed;
    }

    public final DriveId zzaf() {
        return this.zzee;
    }

    public final boolean zzag() {
        return this.zzef;
    }

    public final boolean zzah() {
        return this.zzec;
    }

    final PendingResult zzb(GoogleApiClient googleApiClient0, DriveId driveId0, ChangeListener changeListener0) {
        zzee zzee0;
        Preconditions.checkArgument(zzj.zza(1, driveId0));
        Preconditions.checkState(this.isConnected(), "Client must be connected");
        Preconditions.checkNotNull(changeListener0, "listener");
        synchronized(this.zzeg) {
            Map map1 = (Map)this.zzeg.get(driveId0);
            if(map1 == null) {
                return new zzat(googleApiClient0, Status.RESULT_SUCCESS);
            }
            zzee0 = (zzee)map1.remove(changeListener0);
            if(zzee0 == null) {
                return new zzat(googleApiClient0, Status.RESULT_SUCCESS);
            }
            if(map1.isEmpty()) {
                this.zzeg.remove(driveId0);
            }
        }
        return googleApiClient0.execute(new zzay(this, googleApiClient0, new zzgs(driveId0, 1), zzee0));
    }
}

