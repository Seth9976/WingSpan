package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.drive.zzbn;
import com.google.android.gms.internal.drive.zzbs;
import com.google.android.gms.internal.drive.zzdp;
import com.google.android.gms.internal.drive.zzfb;
import com.google.android.gms.internal.drive.zzfd;
import com.google.android.gms.internal.drive.zzjx;
import com.google.android.gms.internal.drive.zzkk;
import com.google.android.gms.internal.drive.zzkq;

public class DriveId extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator CREATOR = null;
    public static final int RESOURCE_TYPE_FILE = 0;
    public static final int RESOURCE_TYPE_FOLDER = 1;
    public static final int RESOURCE_TYPE_UNKNOWN = -1;
    private final String zzad;
    private final long zzae;
    private final int zzaf;
    private volatile String zzag;
    private final long zzf;
    private volatile String zzh;

    static {
        DriveId.CREATOR = new zzk();
    }

    public DriveId(String s, long v, long v1, int v2) {
        this.zzh = null;
        this.zzag = null;
        this.zzad = s;
        boolean z = true;
        Preconditions.checkArgument(!"".equals(s));
        if(s == null && v == -1L) {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.zzae = v;
        this.zzf = v1;
        this.zzaf = v2;
    }

    public DriveFile asDriveFile() {
        if(this.zzaf == 1) {
            throw new IllegalStateException("This DriveId corresponds to a folder. Call asDriveFolder instead.");
        }
        return new zzbn(this);
    }

    public DriveFolder asDriveFolder() {
        if(this.zzaf == 0) {
            throw new IllegalStateException("This DriveId corresponds to a file. Call asDriveFile instead.");
        }
        return new zzbs(this);
    }

    public DriveResource asDriveResource() {
        int v = this.zzaf;
        if(v == 1) {
            return this.asDriveFolder();
        }
        return v == 0 ? this.asDriveFile() : new zzdp(this);
    }

    public static DriveId decodeFromString(String s) {
        String s1 = String.valueOf(s);
        Preconditions.checkArgument(s.startsWith("DriveId:"), (s1.length() == 0 ? new String("Invalid DriveId: ") : "Invalid DriveId: " + s1));
        return DriveId.zza(Base64.decode(s.substring(8), 10));
    }

    public final String encodeToString() {
        if(this.zzh == null) {
            String s = Base64.encodeToString(((zzfb)(((zzkk)zzfb.zzan().zzm(1).zze((this.zzad == null ? "" : this.zzad)).zzg(this.zzae).zzh(this.zzf).zzn(this.zzaf).zzdf()))).toByteArray(), 10);
            this.zzh = s.length() == 0 ? new String("DriveId:") : "DriveId:" + s;
        }
        return this.zzh;
    }

    @Override
    public boolean equals(Object object0) {
        if(object0 == null || object0.getClass() != DriveId.class || ((DriveId)object0).zzf != this.zzf) {
            return false;
        }
        long v = ((DriveId)object0).zzae;
        if(v == -1L && this.zzae == -1L) {
            return ((DriveId)object0).zzad.equals(this.zzad);
        }
        String s = this.zzad;
        if(s != null) {
            String s1 = ((DriveId)object0).zzad;
            return s1 == null ? v == this.zzae : v == this.zzae && s1.equals(s);
        }
        return v == this.zzae;
    }

    public String getResourceId() {
        return this.zzad;
    }

    public int getResourceType() {
        return this.zzaf;
    }

    @Override
    public int hashCode() {
        if(this.zzae == -1L) {
            return this.zzad.hashCode();
        }
        String s = String.valueOf(this.zzf);
        String s1 = String.valueOf(this.zzae);
        return s1.length() == 0 ? new String(s).hashCode() : (s + s1).hashCode();
    }

    public final String toInvariantString() {
        if(this.zzag == null) {
            this.zzag = Base64.encodeToString(((zzfd)(((zzkk)zzfd.zzap().zzi(this.zzae).zzj(this.zzf).zzdf()))).toByteArray(), 10);
        }
        return this.zzag;
    }

    @Override
    public String toString() {
        return this.encodeToString();
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 2, this.zzad, false);
        SafeParcelWriter.writeLong(parcel0, 3, this.zzae);
        SafeParcelWriter.writeLong(parcel0, 4, this.zzf);
        SafeParcelWriter.writeInt(parcel0, 5, this.zzaf);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public static DriveId zza(String s) {
        Preconditions.checkNotNull(s);
        return new DriveId(s, -1L, -1L, -1);
    }

    // 去混淆评级： 低(20)
    private static DriveId zza(byte[] arr_b) {
        try {
            zzfb zzfb0 = zzfb.zza(arr_b, zzjx.zzcj());
            return new DriveId(null, zzfb0.zzal(), zzfb0.zzam(), zzfb0.getResourceType());
        }
        catch(zzkq unused_ex) {
            throw new IllegalArgumentException();
        }
    }
}

