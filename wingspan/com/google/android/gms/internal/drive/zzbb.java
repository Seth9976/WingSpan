package com.google.android.gms.internal.drive;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.CreateFileActivityOptions;
import com.google.android.gms.drive.Drive.zza;
import com.google.android.gms.drive.DriveClient;
import com.google.android.gms.drive.OpenFileActivityOptions;
import com.google.android.gms.drive.TransferPreferences;
import com.google.android.gms.tasks.Task;

public final class zzbb extends DriveClient {
    public zzbb(Activity activity0, zza drive$zza0) {
        super(activity0, drive$zza0);
    }

    public zzbb(Context context0, zza drive$zza0) {
        super(context0, drive$zza0);
    }

    @Override  // com.google.android.gms.drive.DriveClient
    public final Task getDriveId(String s) {
        Preconditions.checkNotNull(s, "resourceId must not be null");
        return this.doRead(new zzbc(this, s));
    }

    @Override  // com.google.android.gms.drive.DriveClient
    public final Task getUploadPreferences() {
        return this.doRead(new zzbd(this));
    }

    @Override  // com.google.android.gms.drive.DriveClient
    public final Task newCreateFileActivityIntentSender(CreateFileActivityOptions createFileActivityOptions0) {
        return this.doRead(new zzbg(this, createFileActivityOptions0));
    }

    @Override  // com.google.android.gms.drive.DriveClient
    public final Task newOpenFileActivityIntentSender(OpenFileActivityOptions openFileActivityOptions0) {
        return this.doRead(new zzbf(this, openFileActivityOptions0));
    }

    @Override  // com.google.android.gms.drive.DriveClient
    public final Task requestSync() {
        return this.doWrite(new zzbh(this));
    }

    @Override  // com.google.android.gms.drive.DriveClient
    public final Task setUploadPreferences(TransferPreferences transferPreferences0) {
        Preconditions.checkNotNull(transferPreferences0, "transferPreferences cannot be null.");
        return this.doWrite(new zzbe(this, transferPreferences0));
    }
}

