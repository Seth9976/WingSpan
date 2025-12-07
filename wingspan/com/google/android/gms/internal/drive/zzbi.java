package com.google.android.gms.internal.drive;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.zzn;
import com.google.android.gms.drive.zzp;
import java.io.InputStream;
import java.io.OutputStream;

public final class zzbi implements DriveContents {
    private boolean closed;
    private static final GmsLogger zzbz;
    private final Contents zzes;
    private boolean zzet;
    private boolean zzeu;

    static {
        zzbi.zzbz = new GmsLogger("DriveContentsImpl", "");
    }

    public zzbi(Contents contents0) {
        this.closed = false;
        this.zzet = false;
        this.zzeu = false;
        this.zzes = (Contents)Preconditions.checkNotNull(contents0);
    }

    @Override  // com.google.android.gms.drive.DriveContents
    public final PendingResult commit(GoogleApiClient googleApiClient0, MetadataChangeSet metadataChangeSet0) {
        return this.zza(googleApiClient0, metadataChangeSet0, null);
    }

    @Override  // com.google.android.gms.drive.DriveContents
    public final PendingResult commit(GoogleApiClient googleApiClient0, MetadataChangeSet metadataChangeSet0, ExecutionOptions executionOptions0) {
        return executionOptions0 == null ? this.zza(googleApiClient0, metadataChangeSet0, null) : this.zza(googleApiClient0, metadataChangeSet0, zzn.zza(executionOptions0));
    }

    @Override  // com.google.android.gms.drive.DriveContents
    public final void discard(GoogleApiClient googleApiClient0) {
        if(this.closed) {
            throw new IllegalStateException("DriveContents already closed.");
        }
        this.zzj();
        ((zzbm)googleApiClient0.execute(new zzbm(this, googleApiClient0))).setResultCallback(new zzbl(this));
    }

    @Override  // com.google.android.gms.drive.DriveContents
    public final DriveId getDriveId() {
        return this.zzes.getDriveId();
    }

    @Override  // com.google.android.gms.drive.DriveContents
    public final InputStream getInputStream() {
        if(this.closed) {
            throw new IllegalStateException("Contents have been closed, cannot access the input stream.");
        }
        if(this.zzes.getMode() != 0x10000000) {
            throw new IllegalStateException("getInputStream() can only be used with contents opened with MODE_READ_ONLY.");
        }
        if(this.zzet) {
            throw new IllegalStateException("getInputStream() can only be called once per Contents instance.");
        }
        this.zzet = true;
        return this.zzes.getInputStream();
    }

    @Override  // com.google.android.gms.drive.DriveContents
    public final int getMode() {
        return this.zzes.getMode();
    }

    @Override  // com.google.android.gms.drive.DriveContents
    public final OutputStream getOutputStream() {
        if(this.closed) {
            throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
        }
        if(this.zzes.getMode() != 0x20000000) {
            throw new IllegalStateException("getOutputStream() can only be used with contents opened with MODE_WRITE_ONLY.");
        }
        if(this.zzeu) {
            throw new IllegalStateException("getOutputStream() can only be called once per Contents instance.");
        }
        this.zzeu = true;
        return this.zzes.getOutputStream();
    }

    @Override  // com.google.android.gms.drive.DriveContents
    public final ParcelFileDescriptor getParcelFileDescriptor() {
        if(this.closed) {
            throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
        }
        return this.zzes.getParcelFileDescriptor();
    }

    @Override  // com.google.android.gms.drive.DriveContents
    public final PendingResult reopenForWrite(GoogleApiClient googleApiClient0) {
        if(this.closed) {
            throw new IllegalStateException("DriveContents already closed.");
        }
        if(this.zzes.getMode() != 0x10000000) {
            throw new IllegalStateException("reopenForWrite can only be used with DriveContents opened with MODE_READ_ONLY.");
        }
        this.zzj();
        return googleApiClient0.enqueue(new zzbj(this, googleApiClient0));
    }

    private final PendingResult zza(GoogleApiClient googleApiClient0, MetadataChangeSet metadataChangeSet0, zzn zzn0) {
        if(zzn0 == null) {
            zzn0 = (zzn)new zzp().build();
        }
        if(this.zzes.getMode() == 0x10000000) {
            throw new IllegalStateException("Cannot commit contents opened with MODE_READ_ONLY");
        }
        if(ExecutionOptions.zza(zzn0.zzn()) && !this.zzes.zzb()) {
            throw new IllegalStateException("DriveContents must be valid for conflict detection.");
        }
        zzn0.zza(googleApiClient0);
        if(this.closed) {
            throw new IllegalStateException("DriveContents already closed.");
        }
        if(this.getDriveId() == null) {
            throw new IllegalStateException("Only DriveContents obtained through DriveFile.open can be committed.");
        }
        if(metadataChangeSet0 == null) {
            metadataChangeSet0 = MetadataChangeSet.zzax;
        }
        this.zzj();
        return googleApiClient0.execute(new zzbk(this, googleApiClient0, metadataChangeSet0, zzn0));
    }

    @Override  // com.google.android.gms.drive.DriveContents
    public final Contents zzi() {
        return this.zzes;
    }

    @Override  // com.google.android.gms.drive.DriveContents
    public final void zzj() {
        IOUtils.closeQuietly(this.zzes.getParcelFileDescriptor());
        this.closed = true;
    }

    @Override  // com.google.android.gms.drive.DriveContents
    public final boolean zzk() {
        return this.closed;
    }
}

