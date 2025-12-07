package com.google.android.gms.location;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;

public class SettingsClient extends GoogleApi {
    public static final int zza;

    public SettingsClient(Activity activity0) {
        super(activity0, LocationServices.API, ApiOptions.NO_OPTIONS, Settings.DEFAULT_SETTINGS);
    }

    public SettingsClient(Context context0) {
        super(context0, LocationServices.API, ApiOptions.NO_OPTIONS, Settings.DEFAULT_SETTINGS);
    }

    public Task checkLocationSettings(LocationSettingsRequest locationSettingsRequest0) {
        return this.doRead(TaskApiCall.builder().run(new zzbs(locationSettingsRequest0)).setMethodKey(0x97A).build());
    }
}

