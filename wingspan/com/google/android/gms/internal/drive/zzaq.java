package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.MetadataBuffer;

public final class zzaq implements MetadataBufferResult {
    private final Status zzdy;
    private final MetadataBuffer zzdz;
    private final boolean zzea;

    public zzaq(Status status0, MetadataBuffer metadataBuffer0, boolean z) {
        this.zzdy = status0;
        this.zzdz = metadataBuffer0;
        this.zzea = z;
    }

    @Override  // com.google.android.gms.drive.DriveApi$MetadataBufferResult
    public final MetadataBuffer getMetadataBuffer() {
        return this.zzdz;
    }

    @Override  // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zzdy;
    }

    @Override  // com.google.android.gms.common.api.Releasable
    public final void release() {
        MetadataBuffer metadataBuffer0 = this.zzdz;
        if(metadataBuffer0 != null) {
            metadataBuffer0.release();
        }
    }
}

