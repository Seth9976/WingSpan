package com.google.android.gms.drive;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import java.io.InputStream;
import java.io.OutputStream;

public interface DriveContents {
    @Deprecated
    PendingResult commit(GoogleApiClient arg1, MetadataChangeSet arg2);

    @Deprecated
    PendingResult commit(GoogleApiClient arg1, MetadataChangeSet arg2, ExecutionOptions arg3);

    @Deprecated
    void discard(GoogleApiClient arg1);

    DriveId getDriveId();

    InputStream getInputStream();

    int getMode();

    OutputStream getOutputStream();

    ParcelFileDescriptor getParcelFileDescriptor();

    @Deprecated
    PendingResult reopenForWrite(GoogleApiClient arg1);

    Contents zzi();

    void zzj();

    boolean zzk();
}

