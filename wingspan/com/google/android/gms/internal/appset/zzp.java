package com.google.android.gms.internal.appset;

import android.content.Context;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.appset.zze;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

public final class zzp extends GoogleApi implements AppSetIdClient {
    private static final ClientKey zza;
    private static final AbstractClientBuilder zzb;
    private static final Api zzc;
    private final Context zzd;
    private final GoogleApiAvailabilityLight zze;

    static {
        ClientKey api$ClientKey0 = new ClientKey();
        zzp.zza = api$ClientKey0;
        zzn zzn0 = new zzn();
        zzp.zzb = zzn0;
        zzp.zzc = new Api("AppSet.API", zzn0, api$ClientKey0);
    }

    zzp(Context context0, GoogleApiAvailabilityLight googleApiAvailabilityLight0) {
        super(context0, zzp.zzc, ApiOptions.NO_OPTIONS, Settings.DEFAULT_SETTINGS);
        this.zzd = context0;
        this.zze = googleApiAvailabilityLight0;
    }

    @Override  // com.google.android.gms.appset.AppSetIdClient
    public final Task getAppSetIdInfo() {
        return this.zze.isGooglePlayServicesAvailable(this.zzd, 212800000) == 0 ? this.doRead(TaskApiCall.builder().setFeatures(new Feature[]{zze.zza}).run(new zzm(this)).setAutoResolveMissingFeatures(false).setMethodKey(27601).build()) : Tasks.forException(new ApiException(new Status(17)));
    }
}

