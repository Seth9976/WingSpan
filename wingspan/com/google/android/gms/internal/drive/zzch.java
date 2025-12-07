package com.google.android.gms.internal.drive;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.Drive.zza;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.DriveResourceClient;
import com.google.android.gms.drive.ExecutionOptions.Builder;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.events.ListenerToken;
import com.google.android.gms.drive.events.OnChangeListener;
import com.google.android.gms.drive.events.OpenFileCallback;
import com.google.android.gms.drive.events.zzj;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.drive.zzn;
import com.google.android.gms.drive.zzp;
import com.google.android.gms.tasks.Task;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzch extends DriveResourceClient {
    private static final AtomicInteger zzfn;

    static {
        zzch.zzfn = new AtomicInteger();
    }

    public zzch(Activity activity0, zza drive$zza0) {
        super(activity0, drive$zza0);
    }

    public zzch(Context context0, zza drive$zza0) {
        super(context0, drive$zza0);
    }

    @Override  // com.google.android.gms.drive.DriveResourceClient
    public final Task addChangeListener(DriveResource driveResource0, OnChangeListener onChangeListener0) {
        Preconditions.checkNotNull(driveResource0.getDriveId());
        Preconditions.checkNotNull(onChangeListener0, "listener");
        zzdi zzdi0 = new zzdi(this, onChangeListener0, driveResource0.getDriveId());
        ListenerHolder listenerHolder0 = this.registerListener(zzdi0, "OnChangeListener" + zzch.zzfn.incrementAndGet());
        return this.doRegisterEventListener(new zzcp(this, listenerHolder0, driveResource0, zzdi0), new zzcq(this, listenerHolder0.getListenerKey(), driveResource0, zzdi0)).continueWith((Task task0) -> {
            if(!task0.isSuccessful()) {
                throw task0.getException();
            }
            return new zzg(listenerHolder0.getListenerKey());
        });
    }

    @Override  // com.google.android.gms.drive.DriveResourceClient
    public final Task addChangeSubscription(DriveResource driveResource0) {
        Preconditions.checkNotNull(driveResource0.getDriveId());
        Preconditions.checkArgument(zzj.zza(1, driveResource0.getDriveId()));
        return this.doWrite(new zzcr(this, driveResource0));
    }

    @Override  // com.google.android.gms.drive.DriveResourceClient
    public final Task cancelOpenFileCallback(ListenerToken listenerToken0) {
        if(!(listenerToken0 instanceof zzg)) {
            throw new IllegalArgumentException("Unrecognized ListenerToken");
        }
        return this.doUnregisterEventListener(((zzg)listenerToken0).zzad());
    }

    @Override  // com.google.android.gms.drive.DriveResourceClient
    public final Task commitContents(DriveContents driveContents0, MetadataChangeSet metadataChangeSet0) {
        return this.commitContents(driveContents0, metadataChangeSet0, ((zzn)new zzp().build()));
    }

    @Override  // com.google.android.gms.drive.DriveResourceClient
    public final Task commitContents(DriveContents driveContents0, MetadataChangeSet metadataChangeSet0, ExecutionOptions executionOptions0) {
        Preconditions.checkNotNull(executionOptions0, "Execution options cannot be null.");
        boolean z = true;
        Preconditions.checkArgument(!driveContents0.zzk(), "DriveContents is already closed");
        if(driveContents0.getMode() == 0x10000000) {
            z = false;
        }
        Preconditions.checkArgument(z, "Cannot commit contents opened in MODE_READ_ONLY.");
        Preconditions.checkNotNull(driveContents0.getDriveId(), "Only DriveContents obtained through DriveFile.open can be committed.");
        zzn zzn0 = zzn.zza(executionOptions0);
        if(ExecutionOptions.zza(zzn0.zzn()) && !driveContents0.zzi().zzb()) {
            throw new IllegalStateException("DriveContents must be valid for conflict detection.");
        }
        if(metadataChangeSet0 == null) {
            metadataChangeSet0 = MetadataChangeSet.zzax;
        }
        return this.doWrite(new zzcy(this, zzn0, driveContents0, metadataChangeSet0));
    }

    @Override  // com.google.android.gms.drive.DriveResourceClient
    public final Task createContents() {
        Preconditions.checkArgument(true, "Contents can only be created in MODE_WRITE_ONLY or MODE_READ_WRITE.");
        return this.doWrite(new zzcw(this, 0x20000000));
    }

    @Override  // com.google.android.gms.drive.DriveResourceClient
    public final Task createFile(DriveFolder driveFolder0, MetadataChangeSet metadataChangeSet0, DriveContents driveContents0) {
        return this.createFile(driveFolder0, metadataChangeSet0, driveContents0, new Builder().build());
    }

    @Override  // com.google.android.gms.drive.DriveResourceClient
    public final Task createFile(DriveFolder driveFolder0, MetadataChangeSet metadataChangeSet0, DriveContents driveContents0, ExecutionOptions executionOptions0) {
        zzbs.zzb(metadataChangeSet0);
        return this.doWrite(new zzdh(driveFolder0, metadataChangeSet0, driveContents0, executionOptions0, null));
    }

    @Override  // com.google.android.gms.drive.DriveResourceClient
    public final Task createFolder(DriveFolder driveFolder0, MetadataChangeSet metadataChangeSet0) {
        Preconditions.checkNotNull(metadataChangeSet0, "MetadataChangeSet must be provided.");
        if(metadataChangeSet0.getMimeType() != null && !metadataChangeSet0.getMimeType().equals("application/vnd.google-apps.folder")) {
            throw new IllegalArgumentException("The mimetype must be of type application/vnd.google-apps.folder");
        }
        return this.doWrite(new zzdb(this, metadataChangeSet0, driveFolder0));
    }

    @Override  // com.google.android.gms.drive.DriveResourceClient
    public final Task delete(DriveResource driveResource0) {
        Preconditions.checkNotNull(driveResource0.getDriveId());
        return this.doWrite(new zzcl(this, driveResource0));
    }

    @Override  // com.google.android.gms.drive.DriveResourceClient
    public final Task discardContents(DriveContents driveContents0) {
        Preconditions.checkArgument(!driveContents0.zzk(), "DriveContents is already closed");
        driveContents0.zzj();
        return this.doWrite(new zzda(this, driveContents0));
    }

    @Override  // com.google.android.gms.drive.DriveResourceClient
    public final Task getAppFolder() {
        return this.doRead(new zzco(this));
    }

    @Override  // com.google.android.gms.drive.DriveResourceClient
    public final Task getMetadata(DriveResource driveResource0) {
        Preconditions.checkNotNull(driveResource0, "DriveResource must not be null");
        Preconditions.checkNotNull(driveResource0.getDriveId(), "Resource\'s DriveId must not be null");
        return this.doRead(new zzdc(this, driveResource0, false));
    }

    @Override  // com.google.android.gms.drive.DriveResourceClient
    public final Task getRootFolder() {
        return this.doRead(new zzck(this));
    }

    @Override  // com.google.android.gms.drive.DriveResourceClient
    public final Task listChildren(DriveFolder driveFolder0) {
        Preconditions.checkNotNull(driveFolder0, "folder cannot be null.");
        return this.query(zzbs.zza(null, driveFolder0.getDriveId()));
    }

    @Override  // com.google.android.gms.drive.DriveResourceClient
    public final Task listParents(DriveResource driveResource0) {
        Preconditions.checkNotNull(driveResource0.getDriveId());
        return this.doRead(new zzde(this, driveResource0));
    }

    @Override  // com.google.android.gms.drive.DriveResourceClient
    public final Task openFile(DriveFile driveFile0, int v) {
        zzch.zze(v);
        return this.doRead(new zzct(this, driveFile0, v));
    }

    @Override  // com.google.android.gms.drive.DriveResourceClient
    public final Task openFile(DriveFile driveFile0, int v, OpenFileCallback openFileCallback0) {
        zzch.zze(v);
        ListenerHolder listenerHolder0 = this.registerListener(openFileCallback0, "OpenFileCallback" + zzch.zzfn.incrementAndGet());
        ListenerKey listenerHolder$ListenerKey0 = listenerHolder0.getListenerKey();
        zzg zzg0 = new zzg(listenerHolder$ListenerKey0);
        return this.doRegisterEventListener(new zzcu(this, listenerHolder0, driveFile0, v, zzg0, listenerHolder0), new zzcv(this, listenerHolder$ListenerKey0, zzg0)).continueWith((Task task0) -> {
            if(!task0.isSuccessful()) {
                throw task0.getException();
            }
            return zzg0;
        });
    }

    @Override  // com.google.android.gms.drive.DriveResourceClient
    public final Task query(Query query0) {
        Preconditions.checkNotNull(query0, "query cannot be null.");
        return this.doRead(new zzcz(this, query0));
    }

    @Override  // com.google.android.gms.drive.DriveResourceClient
    public final Task queryChildren(DriveFolder driveFolder0, Query query0) {
        Preconditions.checkNotNull(driveFolder0, "folder cannot be null.");
        Preconditions.checkNotNull(query0, "query cannot be null.");
        return this.query(zzbs.zza(query0, driveFolder0.getDriveId()));
    }

    @Override  // com.google.android.gms.drive.DriveResourceClient
    public final Task removeChangeListener(ListenerToken listenerToken0) {
        Preconditions.checkNotNull(listenerToken0, "Token is required to unregister listener.");
        if(!(listenerToken0 instanceof zzg)) {
            throw new IllegalStateException("Could not recover key from ListenerToken");
        }
        return this.doUnregisterEventListener(((zzg)listenerToken0).zzad());
    }

    @Override  // com.google.android.gms.drive.DriveResourceClient
    public final Task removeChangeSubscription(DriveResource driveResource0) {
        Preconditions.checkNotNull(driveResource0.getDriveId());
        Preconditions.checkArgument(zzj.zza(1, driveResource0.getDriveId()));
        return this.doWrite(new zzcs(this, driveResource0));
    }

    @Override  // com.google.android.gms.drive.DriveResourceClient
    public final Task reopenContentsForWrite(DriveContents driveContents0) {
        boolean z = true;
        Preconditions.checkArgument(!driveContents0.zzk(), "DriveContents is already closed");
        if(driveContents0.getMode() != 0x10000000) {
            z = false;
        }
        Preconditions.checkArgument(z, "This method can only be called on contents that are currently opened in MODE_READ_ONLY.");
        driveContents0.zzj();
        return this.doRead(new zzcx(this, driveContents0));
    }

    @Override  // com.google.android.gms.drive.DriveResourceClient
    public final Task setParents(DriveResource driveResource0, Set set0) {
        Preconditions.checkNotNull(driveResource0.getDriveId());
        Preconditions.checkNotNull(set0);
        return this.doWrite(new zzdf(this, driveResource0, new ArrayList(set0)));
    }

    @Override  // com.google.android.gms.drive.DriveResourceClient
    public final Task trash(DriveResource driveResource0) {
        Preconditions.checkNotNull(driveResource0.getDriveId());
        return this.doWrite(new zzcm(this, driveResource0));
    }

    @Override  // com.google.android.gms.drive.DriveResourceClient
    public final Task untrash(DriveResource driveResource0) {
        Preconditions.checkNotNull(driveResource0.getDriveId());
        return this.doWrite(new zzcn(this, driveResource0));
    }

    @Override  // com.google.android.gms.drive.DriveResourceClient
    public final Task updateMetadata(DriveResource driveResource0, MetadataChangeSet metadataChangeSet0) {
        Preconditions.checkNotNull(driveResource0.getDriveId());
        Preconditions.checkNotNull(metadataChangeSet0);
        return this.doWrite(new zzdd(this, metadataChangeSet0, driveResource0));
    }

    // 检测为 Lambda 实现
    static final ListenerToken zza(ListenerHolder listenerHolder0, Task task0) throws Exception [...]

    // 检测为 Lambda 实现
    static final ListenerToken zza(zzg zzg0, Task task0) throws Exception [...]

    private static void zze(int v) {
        if(v != 0x10000000 && v != 0x20000000 && v != 0x30000000) {
            throw new IllegalArgumentException("Invalid openMode provided");
        }
    }
}

