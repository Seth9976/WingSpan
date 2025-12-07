package com.google.android.gms.internal.drive;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;

@Deprecated
public final class zzt {
    private String zzba;
    private DriveId zzbd;
    private Integer zzdk;
    private final int zzdl;
    private MetadataChangeSet zzdm;

    public zzt(int v) {
        this.zzdl = 0;
    }

    public final IntentSender build(GoogleApiClient googleApiClient0) {
        Preconditions.checkState(googleApiClient0.isConnected(), "Client must be connected");
        this.zzg();
        zzaw zzaw0 = (zzaw)googleApiClient0.getClient(Drive.CLIENT_KEY);
        this.zzdm.zzq().zza(zzaw0.getContext());
        try {
            return ((zzeo)zzaw0.getService()).zza(new zzu(this.zzdm.zzq(), ((int)this.zzdk), this.zzba, this.zzbd, 0));
        }
        catch(RemoteException remoteException0) {
            throw new RuntimeException("Unable to connect Drive Play Service", remoteException0);
        }
    }

    public final int getRequestId() {
        return (int)this.zzdk;
    }

    public final void zza(DriveId driveId0) {
        this.zzbd = (DriveId)Preconditions.checkNotNull(driveId0);
    }

    public final void zza(MetadataChangeSet metadataChangeSet0) {
        this.zzdm = (MetadataChangeSet)Preconditions.checkNotNull(metadataChangeSet0);
    }

    public final MetadataChangeSet zzc() {
        return this.zzdm;
    }

    public final void zzc(String s) {
        this.zzba = (String)Preconditions.checkNotNull(s);
    }

    public final DriveId zzd() {
        return this.zzbd;
    }

    public final void zzd(int v) {
        this.zzdk = v;
    }

    public final String zze() {
        return this.zzba;
    }

    public final void zzg() {
        Preconditions.checkNotNull(this.zzdm, "Must provide initial metadata via setInitialMetadata.");
        this.zzdk = (int)(this.zzdk == null ? 0 : ((int)this.zzdk));
    }
}

