package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveResource.MetadataResult;
import com.google.android.gms.drive.Metadata;

final class zzdz implements MetadataResult {
    private final Status zzdy;
    private final Metadata zzgr;

    public zzdz(Status status0, Metadata metadata0) {
        this.zzdy = status0;
        this.zzgr = metadata0;
    }

    @Override  // com.google.android.gms.drive.DriveResource$MetadataResult
    public final Metadata getMetadata() {
        return this.zzgr;
    }

    @Override  // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zzdy;
    }
}

