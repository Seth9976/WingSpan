package com.google.android.gms.drive.events;

import com.google.android.gms.drive.DriveContents;

public abstract class OpenFileCallback {
    public abstract void onContents(DriveContents arg1);

    public abstract void onError(Exception arg1);

    public abstract void onProgress(long arg1, long arg2);
}

