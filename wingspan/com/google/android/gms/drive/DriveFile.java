package com.google.android.gms.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface DriveFile extends DriveResource {
    @Deprecated
    public interface DownloadProgressListener {
        void onProgress(long arg1, long arg2);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface OpenMode {
    }

    public static final int MODE_READ_ONLY = 0x10000000;
    public static final int MODE_READ_WRITE = 0x30000000;
    public static final int MODE_WRITE_ONLY = 0x20000000;

    @Deprecated
    PendingResult open(GoogleApiClient arg1, int arg2, DownloadProgressListener arg3);
}

