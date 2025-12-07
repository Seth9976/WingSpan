package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Contents extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final int mode;
    private final ParcelFileDescriptor zzi;
    final int zzj;
    private final DriveId zzk;
    private final boolean zzl;
    private final String zzm;

    static {
        Contents.CREATOR = new zzc();
    }

    public Contents(ParcelFileDescriptor parcelFileDescriptor0, int v, int v1, DriveId driveId0, boolean z, String s) {
        this.zzi = parcelFileDescriptor0;
        this.zzj = v;
        this.mode = v1;
        this.zzk = driveId0;
        this.zzl = z;
        this.zzm = s;
    }

    public final DriveId getDriveId() {
        return this.zzk;
    }

    public final InputStream getInputStream() {
        return new FileInputStream(this.zzi.getFileDescriptor());
    }

    public final int getMode() {
        return this.mode;
    }

    public final OutputStream getOutputStream() {
        return new FileOutputStream(this.zzi.getFileDescriptor());
    }

    public ParcelFileDescriptor getParcelFileDescriptor() {
        return this.zzi;
    }

    public final int getRequestId() {
        return this.zzj;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.zzi, v, false);
        SafeParcelWriter.writeInt(parcel0, 3, this.zzj);
        SafeParcelWriter.writeInt(parcel0, 4, this.mode);
        SafeParcelWriter.writeParcelable(parcel0, 5, this.zzk, v, false);
        SafeParcelWriter.writeBoolean(parcel0, 7, this.zzl);
        SafeParcelWriter.writeString(parcel0, 8, this.zzm, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final boolean zzb() {
        return this.zzl;
    }
}

