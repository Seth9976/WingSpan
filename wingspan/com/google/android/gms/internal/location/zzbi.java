package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.SettingsApi;

public final class zzbi implements SettingsApi {
    @Override  // com.google.android.gms.location.SettingsApi
    public final PendingResult checkLocationSettings(GoogleApiClient googleApiClient0, LocationSettingsRequest locationSettingsRequest0) {
        return googleApiClient0.enqueue(new zzbh(this, googleApiClient0, locationSettingsRequest0, null));
    }
}

