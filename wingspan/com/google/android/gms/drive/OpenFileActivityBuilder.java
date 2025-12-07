package com.google.android.gms.drive;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.internal.FilterHolder;
import com.google.android.gms.drive.query.internal.zzk;
import com.google.android.gms.internal.drive.zzaw;
import com.google.android.gms.internal.drive.zzeo;
import com.google.android.gms.internal.drive.zzgm;

@Deprecated
public class OpenFileActivityBuilder {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    private String zzba;
    private String[] zzbb;
    private Filter zzbc;
    private DriveId zzbd;

    public IntentSender build(GoogleApiClient googleApiClient0) {
        Preconditions.checkState(googleApiClient0.isConnected(), "Client must be connected");
        this.zzg();
        FilterHolder filterHolder0 = this.zzbc == null ? null : new FilterHolder(this.zzbc);
        try {
            return ((zzeo)((zzaw)googleApiClient0.getClient(Drive.CLIENT_KEY)).getService()).zza(new zzgm(this.zzba, this.zzbb, this.zzbd, filterHolder0));
        }
        catch(RemoteException remoteException0) {
            throw new RuntimeException("Unable to connect Drive Play Service", remoteException0);
        }
    }

    final String getTitle() {
        return this.zzba;
    }

    public OpenFileActivityBuilder setActivityStartFolder(DriveId driveId0) {
        this.zzbd = (DriveId)Preconditions.checkNotNull(driveId0);
        return this;
    }

    public OpenFileActivityBuilder setActivityTitle(String s) {
        this.zzba = (String)Preconditions.checkNotNull(s);
        return this;
    }

    public OpenFileActivityBuilder setMimeType(String[] arr_s) {
        Preconditions.checkArgument(arr_s != null, "mimeTypes may not be null");
        this.zzbb = arr_s;
        return this;
    }

    public OpenFileActivityBuilder setSelectionFilter(Filter filter0) {
        Preconditions.checkArgument(filter0 != null, "filter may not be null");
        Preconditions.checkArgument(((boolean)(true ^ zzk.zza(filter0))), "FullTextSearchFilter cannot be used as a selection filter");
        this.zzbc = filter0;
        return this;
    }

    final void zzg() {
        if(this.zzbb == null) {
            this.zzbb = new String[0];
        }
        if(this.zzbb.length > 0 && this.zzbc != null) {
            throw new IllegalStateException("Cannot use a selection filter and set mimetypes simultaneously");
        }
    }

    final String[] zzs() {
        return this.zzbb;
    }

    final Filter zzt() {
        return this.zzbc;
    }

    final DriveId zzu() {
        return this.zzbd;
    }
}

