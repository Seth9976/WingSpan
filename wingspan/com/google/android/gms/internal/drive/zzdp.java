package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.events.ChangeListener;
import java.util.ArrayList;
import java.util.Set;

public class zzdp implements DriveResource {
    protected final DriveId zzk;

    public zzdp(DriveId driveId0) {
        this.zzk = driveId0;
    }

    @Override  // com.google.android.gms.drive.DriveResource
    public PendingResult addChangeListener(GoogleApiClient googleApiClient0, ChangeListener changeListener0) {
        return ((zzaw)googleApiClient0.getClient(Drive.CLIENT_KEY)).zza(googleApiClient0, this.zzk, changeListener0);
    }

    @Override  // com.google.android.gms.drive.DriveResource
    public PendingResult addChangeSubscription(GoogleApiClient googleApiClient0) {
        zzaw zzaw0 = (zzaw)googleApiClient0.getClient(Drive.CLIENT_KEY);
        zzj zzj0 = new zzj(1, this.zzk);
        Preconditions.checkArgument(com.google.android.gms.drive.events.zzj.zza(zzj0.zzda, zzj0.zzk));
        Preconditions.checkState(zzaw0.isConnected(), "Client must be connected");
        if(!zzaw0.zzec) {
            throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to add event subscriptions");
        }
        return googleApiClient0.execute(new zzaz(zzaw0, googleApiClient0, zzj0));
    }

    @Override  // com.google.android.gms.drive.DriveResource
    public PendingResult delete(GoogleApiClient googleApiClient0) {
        return googleApiClient0.execute(new zzdu(this, googleApiClient0));
    }

    @Override  // com.google.android.gms.drive.DriveResource
    public DriveId getDriveId() {
        return this.zzk;
    }

    @Override  // com.google.android.gms.drive.DriveResource
    public PendingResult getMetadata(GoogleApiClient googleApiClient0) {
        return googleApiClient0.enqueue(new zzdq(this, googleApiClient0, false));
    }

    @Override  // com.google.android.gms.drive.DriveResource
    public PendingResult listParents(GoogleApiClient googleApiClient0) {
        return googleApiClient0.enqueue(new zzdr(this, googleApiClient0));
    }

    @Override  // com.google.android.gms.drive.DriveResource
    public PendingResult removeChangeListener(GoogleApiClient googleApiClient0, ChangeListener changeListener0) {
        return ((zzaw)googleApiClient0.getClient(Drive.CLIENT_KEY)).zzb(googleApiClient0, this.zzk, changeListener0);
    }

    @Override  // com.google.android.gms.drive.DriveResource
    public PendingResult removeChangeSubscription(GoogleApiClient googleApiClient0) {
        zzaw zzaw0 = (zzaw)googleApiClient0.getClient(Drive.CLIENT_KEY);
        Preconditions.checkArgument(com.google.android.gms.drive.events.zzj.zza(1, this.zzk));
        Preconditions.checkState(zzaw0.isConnected(), "Client must be connected");
        return googleApiClient0.execute(new zzba(zzaw0, googleApiClient0, this.zzk, 1));
    }

    @Override  // com.google.android.gms.drive.DriveResource
    public PendingResult setParents(GoogleApiClient googleApiClient0, Set set0) {
        if(set0 == null) {
            throw new IllegalArgumentException("ParentIds must be provided.");
        }
        return googleApiClient0.execute(new zzds(this, googleApiClient0, new ArrayList(set0)));
    }

    @Override  // com.google.android.gms.drive.DriveResource
    public PendingResult trash(GoogleApiClient googleApiClient0) {
        return googleApiClient0.execute(new zzdv(this, googleApiClient0));
    }

    @Override  // com.google.android.gms.drive.DriveResource
    public PendingResult untrash(GoogleApiClient googleApiClient0) {
        return googleApiClient0.execute(new zzdw(this, googleApiClient0));
    }

    @Override  // com.google.android.gms.drive.DriveResource
    public PendingResult updateMetadata(GoogleApiClient googleApiClient0, MetadataChangeSet metadataChangeSet0) {
        if(metadataChangeSet0 == null) {
            throw new IllegalArgumentException("ChangeSet must be provided.");
        }
        return googleApiClient0.execute(new zzdt(this, googleApiClient0, metadataChangeSet0));
    }
}

