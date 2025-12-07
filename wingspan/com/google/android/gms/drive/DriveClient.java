package com.google.android.gms.drive;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.tasks.Task;

@Deprecated
public abstract class DriveClient extends GoogleApi {
    public DriveClient(Activity activity0, zza drive$zza0) {
        super(activity0, Drive.zzw, drive$zza0, Settings.DEFAULT_SETTINGS);
    }

    public DriveClient(Context context0, zza drive$zza0) {
        super(context0, Drive.zzw, drive$zza0, Settings.DEFAULT_SETTINGS);
    }

    @Deprecated
    public abstract Task getDriveId(String arg1);

    @Deprecated
    public abstract Task getUploadPreferences();

    @Deprecated
    public abstract Task newCreateFileActivityIntentSender(CreateFileActivityOptions arg1);

    @Deprecated
    public abstract Task newOpenFileActivityIntentSender(OpenFileActivityOptions arg1);

    @Deprecated
    public abstract Task requestSync();

    @Deprecated
    public abstract Task setUploadPreferences(TransferPreferences arg1);
}

