package com.onesignal.location.internal.controller.impl;

import android.location.Location;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.onesignal.debug.internal.logging.Logging;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0016J\u0012\u0010\t\u001A\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001A\u00020\u0006H\u0016J \u0010\u000B\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u0007\u001A\u00020\bH\u0016¨\u0006\u000E"}, d2 = {"Lcom/onesignal/location/internal/controller/impl/FusedLocationApiWrapperImpl;", "Lcom/onesignal/location/internal/controller/impl/IFusedLocationApiWrapper;", "()V", "cancelLocationUpdates", "", "googleApiClient", "Lcom/google/android/gms/common/api/GoogleApiClient;", "locationListener", "Lcom/google/android/gms/location/LocationListener;", "getLastLocation", "Landroid/location/Location;", "requestLocationUpdates", "locationRequest", "Lcom/google/android/gms/location/LocationRequest;", "com.onesignal.location"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class FusedLocationApiWrapperImpl implements IFusedLocationApiWrapper {
    @Override  // com.onesignal.location.internal.controller.impl.IFusedLocationApiWrapper
    public void cancelLocationUpdates(GoogleApiClient googleApiClient0, LocationListener locationListener0) {
        Intrinsics.checkNotNullParameter(googleApiClient0, "googleApiClient");
        Intrinsics.checkNotNullParameter(locationListener0, "locationListener");
        if(googleApiClient0.isConnected()) {
            LocationServices.FusedLocationApi.removeLocationUpdates(googleApiClient0, locationListener0);
            return;
        }
        Logging.warn$default("GoogleApiClient is not connected. Unable to cancel location updates.", null, 2, null);
    }

    @Override  // com.onesignal.location.internal.controller.impl.IFusedLocationApiWrapper
    public Location getLastLocation(GoogleApiClient googleApiClient0) {
        Intrinsics.checkNotNullParameter(googleApiClient0, "googleApiClient");
        return googleApiClient0.isConnected() ? LocationServices.FusedLocationApi.getLastLocation(googleApiClient0) : null;
    }

    @Override  // com.onesignal.location.internal.controller.impl.IFusedLocationApiWrapper
    public void requestLocationUpdates(GoogleApiClient googleApiClient0, LocationRequest locationRequest0, LocationListener locationListener0) {
        Intrinsics.checkNotNullParameter(googleApiClient0, "googleApiClient");
        Intrinsics.checkNotNullParameter(locationRequest0, "locationRequest");
        Intrinsics.checkNotNullParameter(locationListener0, "locationListener");
        try {
            if(Looper.myLooper() == null) {
                Looper.prepare();
            }
            if(googleApiClient0.isConnected()) {
                LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient0, locationRequest0, locationListener0);
            }
        }
        catch(Throwable throwable0) {
            Logging.warn("FusedLocationApi.requestLocationUpdates failed!", throwable0);
        }
    }
}

