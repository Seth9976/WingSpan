package com.onesignal.location.internal.controller.impl;

import android.location.Location;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H&J\u0012\u0010\b\u001A\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001A\u00020\u0005H&J \u0010\n\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\u0006\u001A\u00020\u0007H&¨\u0006\r"}, d2 = {"Lcom/onesignal/location/internal/controller/impl/IFusedLocationApiWrapper;", "", "cancelLocationUpdates", "", "googleApiClient", "Lcom/google/android/gms/common/api/GoogleApiClient;", "locationListener", "Lcom/google/android/gms/location/LocationListener;", "getLastLocation", "Landroid/location/Location;", "requestLocationUpdates", "locationRequest", "Lcom/google/android/gms/location/LocationRequest;", "com.onesignal.location"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface IFusedLocationApiWrapper {
    void cancelLocationUpdates(GoogleApiClient arg1, LocationListener arg2);

    Location getLastLocation(GoogleApiClient arg1);

    void requestLocationUpdates(GoogleApiClient arg1, LocationRequest arg2, LocationListener arg3);
}

