package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.location.GeofencingApi;
import com.google.android.gms.location.GeofencingRequest.Builder;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.zzbq;
import java.util.List;

public final class zzaf implements GeofencingApi {
    @Override  // com.google.android.gms.location.GeofencingApi
    public final PendingResult addGeofences(GoogleApiClient googleApiClient0, GeofencingRequest geofencingRequest0, PendingIntent pendingIntent0) {
        return googleApiClient0.execute(new zzac(this, googleApiClient0, geofencingRequest0, pendingIntent0));
    }

    @Override  // com.google.android.gms.location.GeofencingApi
    @Deprecated
    public final PendingResult addGeofences(GoogleApiClient googleApiClient0, List list0, PendingIntent pendingIntent0) {
        Builder geofencingRequest$Builder0 = new Builder();
        geofencingRequest$Builder0.addGeofences(list0);
        geofencingRequest$Builder0.setInitialTrigger(5);
        return googleApiClient0.execute(new zzac(this, googleApiClient0, geofencingRequest$Builder0.build(), pendingIntent0));
    }

    @Override  // com.google.android.gms.location.GeofencingApi
    public final PendingResult removeGeofences(GoogleApiClient googleApiClient0, PendingIntent pendingIntent0) {
        return this.zza(googleApiClient0, zzbq.zzb(pendingIntent0));
    }

    @Override  // com.google.android.gms.location.GeofencingApi
    public final PendingResult removeGeofences(GoogleApiClient googleApiClient0, List list0) {
        return this.zza(googleApiClient0, zzbq.zza(list0));
    }

    public final PendingResult zza(GoogleApiClient googleApiClient0, zzbq zzbq0) {
        return googleApiClient0.execute(new zzad(this, googleApiClient0, zzbq0));
    }
}

