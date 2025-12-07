package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.internal.zzc;
import com.google.android.gms.internal.games.zzft;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public final class SnapshotContentsEntity extends zzc implements SnapshotContents {
    public static final Parcelable.Creator CREATOR;
    private static final Object zza;
    private Contents zzb;

    static {
        SnapshotContentsEntity.zza = new Object();
        SnapshotContentsEntity.CREATOR = new zza();
    }

    public SnapshotContentsEntity(Contents contents0) {
        this.zzb = contents0;
    }

    @Override  // com.google.android.gms.games.snapshot.SnapshotContents
    public final ParcelFileDescriptor getParcelFileDescriptor() {
        Preconditions.checkState(!this.isClosed(), "Cannot mutate closed contents!");
        return this.zzb.getParcelFileDescriptor();
    }

    @Override  // com.google.android.gms.games.snapshot.SnapshotContents
    public final boolean isClosed() {
        return this.zzb == null;
    }

    @Override  // com.google.android.gms.games.snapshot.SnapshotContents
    public final boolean modifyBytes(int v, byte[] arr_b, int v1, int v2) {
        return this.zzc(v, arr_b, v1, arr_b.length, false);
    }

    @Override  // com.google.android.gms.games.snapshot.SnapshotContents
    public final byte[] readFully() throws IOException {
        byte[] arr_b;
        Preconditions.checkState(!this.isClosed(), "Must provide a previously opened Snapshot");
        synchronized(SnapshotContentsEntity.zza) {
            FileInputStream fileInputStream0 = new FileInputStream(this.zzb.getParcelFileDescriptor().getFileDescriptor());
            BufferedInputStream bufferedInputStream0 = new BufferedInputStream(fileInputStream0);
            try {
                fileInputStream0.getChannel().position(0L);
                arr_b = IOUtils.readInputStreamFully(bufferedInputStream0, false);
                fileInputStream0.getChannel().position(0L);
                return arr_b;
            }
            catch(IOException iOException0) {
                zzft.zze("SnapshotContentsEntity", "Failed to read snapshot data", iOException0);
                throw iOException0;
            }
        }
    }

    @Override  // com.google.android.gms.games.snapshot.SnapshotContents
    public final boolean writeBytes(byte[] arr_b) {
        return this.zzc(0, arr_b, 0, arr_b.length, true);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 1, this.zzb, v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    @Override  // com.google.android.gms.games.snapshot.SnapshotContents
    public final Contents zza() {
        return this.zzb;
    }

    @Override  // com.google.android.gms.games.snapshot.SnapshotContents
    public final void zzb() {
        this.zzb = null;
    }

    private final boolean zzc(int v, byte[] arr_b, int v1, int v2, boolean z) {
        Preconditions.checkState(!this.isClosed(), "Must provide a previously opened SnapshotContents");
        synchronized(SnapshotContentsEntity.zza) {
            FileOutputStream fileOutputStream0 = new FileOutputStream(this.zzb.getParcelFileDescriptor().getFileDescriptor());
            BufferedOutputStream bufferedOutputStream0 = new BufferedOutputStream(fileOutputStream0);
            try {
                FileChannel fileChannel0 = fileOutputStream0.getChannel();
                fileChannel0.position(((long)v));
                bufferedOutputStream0.write(arr_b, v1, v2);
                if(z) {
                    fileChannel0.truncate(((long)arr_b.length));
                }
                bufferedOutputStream0.flush();
                return true;
            }
            catch(IOException iOException0) {
                zzft.zzc("SnapshotContentsEntity", "Failed to write snapshot data", iOException0);
                return false;
            }
        }
    }
}

