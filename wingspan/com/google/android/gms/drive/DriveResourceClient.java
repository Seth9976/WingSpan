package com.google.android.gms.drive;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.drive.events.ListenerToken;
import com.google.android.gms.drive.events.OnChangeListener;
import com.google.android.gms.drive.events.OpenFileCallback;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.tasks.Task;
import java.util.Set;

@Deprecated
public abstract class DriveResourceClient extends GoogleApi {
    public DriveResourceClient(Activity activity0, zza drive$zza0) {
        super(activity0, Drive.zzw, drive$zza0, Settings.DEFAULT_SETTINGS);
    }

    public DriveResourceClient(Context context0, zza drive$zza0) {
        super(context0, Drive.zzw, drive$zza0, Settings.DEFAULT_SETTINGS);
    }

    @Deprecated
    public abstract Task addChangeListener(DriveResource arg1, OnChangeListener arg2);

    @Deprecated
    public abstract Task addChangeSubscription(DriveResource arg1);

    @Deprecated
    public abstract Task cancelOpenFileCallback(ListenerToken arg1);

    @Deprecated
    public abstract Task commitContents(DriveContents arg1, MetadataChangeSet arg2);

    @Deprecated
    public abstract Task commitContents(DriveContents arg1, MetadataChangeSet arg2, ExecutionOptions arg3);

    @Deprecated
    public abstract Task createContents();

    @Deprecated
    public abstract Task createFile(DriveFolder arg1, MetadataChangeSet arg2, DriveContents arg3);

    @Deprecated
    public abstract Task createFile(DriveFolder arg1, MetadataChangeSet arg2, DriveContents arg3, ExecutionOptions arg4);

    @Deprecated
    public abstract Task createFolder(DriveFolder arg1, MetadataChangeSet arg2);

    @Deprecated
    public abstract Task delete(DriveResource arg1);

    @Deprecated
    public abstract Task discardContents(DriveContents arg1);

    @Deprecated
    public abstract Task getAppFolder();

    @Deprecated
    public abstract Task getMetadata(DriveResource arg1);

    @Deprecated
    public abstract Task getRootFolder();

    @Deprecated
    public abstract Task listChildren(DriveFolder arg1);

    @Deprecated
    public abstract Task listParents(DriveResource arg1);

    @Deprecated
    public abstract Task openFile(DriveFile arg1, int arg2);

    @Deprecated
    public abstract Task openFile(DriveFile arg1, int arg2, OpenFileCallback arg3);

    @Deprecated
    public abstract Task query(Query arg1);

    @Deprecated
    public abstract Task queryChildren(DriveFolder arg1, Query arg2);

    @Deprecated
    public abstract Task removeChangeListener(ListenerToken arg1);

    @Deprecated
    public abstract Task removeChangeSubscription(DriveResource arg1);

    @Deprecated
    public abstract Task reopenContentsForWrite(DriveContents arg1);

    @Deprecated
    public abstract Task setParents(DriveResource arg1, Set arg2);

    @Deprecated
    public abstract Task trash(DriveResource arg1);

    @Deprecated
    public abstract Task untrash(DriveResource arg1);

    @Deprecated
    public abstract Task updateMetadata(DriveResource arg1, MetadataChangeSet arg2);
}

