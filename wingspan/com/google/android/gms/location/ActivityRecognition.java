package com.google.android.gms.location;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.location.zzg;

public class ActivityRecognition {
    public static final Api API = null;
    @Deprecated
    public static final ActivityRecognitionApi ActivityRecognitionApi = null;
    public static final String CLIENT_NAME = "activity_recognition";
    private static final ClientKey zza;
    private static final AbstractClientBuilder zzb;

    static {
        ClientKey api$ClientKey0 = new ClientKey();
        ActivityRecognition.zza = api$ClientKey0;
        zza zza0 = new zza();
        ActivityRecognition.zzb = zza0;
        ActivityRecognition.API = new Api("ActivityRecognition.API", zza0, api$ClientKey0);
        ActivityRecognition.ActivityRecognitionApi = new zzg();
    }

    public static ActivityRecognitionClient getClient(Activity activity0) {
        return new ActivityRecognitionClient(activity0);
    }

    public static ActivityRecognitionClient getClient(Context context0) {
        return new ActivityRecognitionClient(context0);
    }
}

