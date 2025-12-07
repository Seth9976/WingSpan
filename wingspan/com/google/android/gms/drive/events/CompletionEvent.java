package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.drive.zzev;
import com.google.android.gms.internal.drive.zzhs;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class CompletionEvent extends AbstractSafeParcelable implements ResourceEvent {
    public static final Parcelable.Creator CREATOR = null;
    public static final int STATUS_CANCELED = 3;
    public static final int STATUS_CONFLICT = 2;
    public static final int STATUS_FAILURE = 1;
    public static final int STATUS_SUCCESS;
    private final int status;
    private static final GmsLogger zzbz;
    private final String zzca;
    private final ParcelFileDescriptor zzcb;
    private final ParcelFileDescriptor zzcc;
    private final MetadataBundle zzcd;
    private final List zzce;
    private final IBinder zzcf;
    private boolean zzcg;
    private boolean zzch;
    private boolean zzci;
    private final DriveId zzk;

    static {
        CompletionEvent.zzbz = new GmsLogger("CompletionEvent", "");
        CompletionEvent.CREATOR = new zzg();
    }

    CompletionEvent(DriveId driveId0, String s, ParcelFileDescriptor parcelFileDescriptor0, ParcelFileDescriptor parcelFileDescriptor1, MetadataBundle metadataBundle0, List list0, int v, IBinder iBinder0) {
        this.zzcg = false;
        this.zzch = false;
        this.zzci = false;
        this.zzk = driveId0;
        this.zzca = s;
        this.zzcb = parcelFileDescriptor0;
        this.zzcc = parcelFileDescriptor1;
        this.zzcd = metadataBundle0;
        this.zzce = list0;
        this.status = v;
        this.zzcf = iBinder0;
    }

    public final void dismiss() {
        this.zza(false);
    }

    public final String getAccountName() {
        this.zzv();
        return this.zzca;
    }

    public final InputStream getBaseContentsInputStream() {
        this.zzv();
        if(this.zzcb == null) {
            return null;
        }
        if(this.zzcg) {
            throw new IllegalStateException("getBaseInputStream() can only be called once per CompletionEvent instance.");
        }
        this.zzcg = true;
        return new FileInputStream(this.zzcb.getFileDescriptor());
    }

    @Override  // com.google.android.gms.drive.events.ResourceEvent
    public final DriveId getDriveId() {
        this.zzv();
        return this.zzk;
    }

    public final InputStream getModifiedContentsInputStream() {
        this.zzv();
        if(this.zzcc == null) {
            return null;
        }
        if(this.zzch) {
            throw new IllegalStateException("getModifiedInputStream() can only be called once per CompletionEvent instance.");
        }
        this.zzch = true;
        return new FileInputStream(this.zzcc.getFileDescriptor());
    }

    public final MetadataChangeSet getModifiedMetadataChangeSet() {
        this.zzv();
        return this.zzcd == null ? null : new MetadataChangeSet(this.zzcd);
    }

    public final int getStatus() {
        this.zzv();
        return this.status;
    }

    public final List getTrackingTags() {
        this.zzv();
        return new ArrayList(this.zzce);
    }

    @Override  // com.google.android.gms.drive.events.DriveEvent
    public final int getType() {
        return 2;
    }

    public final void snooze() {
        this.zza(true);
    }

    @Override
    public final String toString() {
        List list0 = this.zzce;
        if(list0 == null) {
            return String.format(Locale.US, "CompletionEvent [id=%s, status=%s, trackingTag=%s]", this.zzk, this.status, "<null>");
        }
        String s = "\'" + TextUtils.join("\',\'", list0) + "\'";
        return String.format(Locale.US, "CompletionEvent [id=%s, status=%s, trackingTag=%s]", this.zzk, this.status, s);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.zzk, v | 1, false);
        SafeParcelWriter.writeString(parcel0, 3, this.zzca, false);
        SafeParcelWriter.writeParcelable(parcel0, 4, this.zzcb, v | 1, false);
        SafeParcelWriter.writeParcelable(parcel0, 5, this.zzcc, v | 1, false);
        SafeParcelWriter.writeParcelable(parcel0, 6, this.zzcd, v | 1, false);
        SafeParcelWriter.writeStringList(parcel0, 7, this.zzce, false);
        SafeParcelWriter.writeInt(parcel0, 8, this.status);
        SafeParcelWriter.writeIBinder(parcel0, 9, this.zzcf, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    private final void zza(boolean z) {
        this.zzv();
        this.zzci = true;
        IOUtils.closeQuietly(this.zzcb);
        IOUtils.closeQuietly(this.zzcc);
        if(this.zzcd != null && this.zzcd.zzd(zzhs.zzkq)) {
            ((BitmapTeleporter)this.zzcd.zza(zzhs.zzkq)).release();
        }
        IBinder iBinder0 = this.zzcf;
        String s = "snooze";
        if(iBinder0 == null) {
            if(!z) {
                s = "dismiss";
            }
            CompletionEvent.zzbz.efmt("CompletionEvent", "No callback on %s", new Object[]{s});
            return;
        }
        try {
            zzev.zza(iBinder0).zza(z);
        }
        catch(RemoteException remoteException0) {
            if(!z) {
                s = "dismiss";
            }
            CompletionEvent.zzbz.e("CompletionEvent", String.format("RemoteException on %s", s), remoteException0);
        }
    }

    private final void zzv() {
        if(this.zzci) {
            throw new IllegalStateException("Event has already been dismissed or snoozed.");
        }
    }
}

