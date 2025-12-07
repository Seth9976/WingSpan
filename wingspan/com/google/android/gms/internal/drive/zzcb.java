package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.drive.DrivePreferencesApi;
import com.google.android.gms.drive.FileUploadPreferences;

@Deprecated
public final class zzcb implements DrivePreferencesApi {
    @Override  // com.google.android.gms.drive.DrivePreferencesApi
    public final PendingResult getFileUploadPreferences(GoogleApiClient googleApiClient0) {
        return googleApiClient0.enqueue(new zzcc(this, googleApiClient0));
    }

    @Override  // com.google.android.gms.drive.DrivePreferencesApi
    public final PendingResult setFileUploadPreferences(GoogleApiClient googleApiClient0, FileUploadPreferences fileUploadPreferences0) {
        if(!(fileUploadPreferences0 instanceof zzei)) {
            throw new IllegalArgumentException("Invalid preference value");
        }
        return googleApiClient0.execute(new zzcd(this, googleApiClient0, ((zzei)fileUploadPreferences0)));
    }
}

