package com.google.android.gms.games.snapshot;

import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.drive.Contents;
import java.io.IOException;

public interface SnapshotContents extends Parcelable {
    ParcelFileDescriptor getParcelFileDescriptor();

    boolean isClosed();

    boolean modifyBytes(int arg1, byte[] arg2, int arg3, int arg4);

    byte[] readFully() throws IOException;

    boolean writeBytes(byte[] arg1);

    Contents zza();

    void zzb();
}

