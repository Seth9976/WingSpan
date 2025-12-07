package com.google.android.gms.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;

@Deprecated
public interface DrivePreferencesApi {
    @Deprecated
    public interface FileUploadPreferencesResult extends Result {
        FileUploadPreferences getFileUploadPreferences();
    }

    @Deprecated
    PendingResult getFileUploadPreferences(GoogleApiClient arg1);

    @Deprecated
    PendingResult setFileUploadPreferences(GoogleApiClient arg1, FileUploadPreferences arg2);
}

