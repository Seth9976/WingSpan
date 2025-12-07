package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.DriveId;
import java.util.Locale;

public final class ChangeEvent extends AbstractSafeParcelable implements ResourceEvent {
    public static final Parcelable.Creator CREATOR;
    private final int zzbu;
    private final DriveId zzk;

    static {
        ChangeEvent.CREATOR = new zza();
    }

    public ChangeEvent(DriveId driveId0, int v) {
        this.zzk = driveId0;
        this.zzbu = v;
    }

    @Override  // com.google.android.gms.drive.events.ResourceEvent
    public final DriveId getDriveId() {
        return this.zzk;
    }

    @Override  // com.google.android.gms.drive.events.DriveEvent
    public final int getType() {
        return 1;
    }

    public final boolean hasBeenDeleted() {
        return (this.zzbu & 4) != 0;
    }

    public final boolean hasContentChanged() {
        return (this.zzbu & 2) != 0;
    }

    public final boolean hasMetadataChanged() {
        return (this.zzbu & 1) != 0;
    }

    @Override
    public final String toString() {
        return String.format(Locale.US, "ChangeEvent [id=%s,changeFlags=%x]", this.zzk, this.zzbu);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.zzk, v, false);
        SafeParcelWriter.writeInt(parcel0, 3, this.zzbu);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

