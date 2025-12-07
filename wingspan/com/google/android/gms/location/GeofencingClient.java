package com.google.android.gms.location;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;
import java.util.List;

public class GeofencingClient extends GoogleApi {
    public static final int zza;

    public GeofencingClient(Activity activity0) {
        super(activity0, LocationServices.API, ApiOptions.NO_OPTIONS, Settings.DEFAULT_SETTINGS);
    }

    public GeofencingClient(Context context0) {
        super(context0, LocationServices.API, ApiOptions.NO_OPTIONS, Settings.DEFAULT_SETTINGS);
    }

    public Task addGeofences(GeofencingRequest geofencingRequest0, PendingIntent pendingIntent0) {
        GeofencingRequest geofencingRequest1 = geofencingRequest0.zza(this.getContextAttributionTag());
        return this.doWrite(TaskApiCall.builder().run(new zzaq(geofencingRequest1, pendingIntent0)).setMethodKey(0x978).build());
    }

    public Task removeGeofences(PendingIntent pendingIntent0) {
        return this.doWrite(TaskApiCall.builder().run(new zzar(pendingIntent0)).setMethodKey(0x979).build());
    }

    public Task removeGeofences(List list0) {
        return this.doWrite(TaskApiCall.builder().run(new zzas(list0)).setMethodKey(0x979).build());
    }
}

