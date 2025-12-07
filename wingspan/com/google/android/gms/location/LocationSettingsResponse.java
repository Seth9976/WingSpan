package com.google.android.gms.location;

import com.google.android.gms.common.api.Response;

public class LocationSettingsResponse extends Response {
    public LocationSettingsResponse() {
    }

    public LocationSettingsResponse(LocationSettingsResult locationSettingsResult0) {
        super(locationSettingsResult0);
    }

    public LocationSettingsStates getLocationSettingsStates() {
        return ((LocationSettingsResult)this.getResult()).getLocationSettingsStates();
    }
}

