package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.Set;
import java.util.regex.Pattern;

public class DriveSpace extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator CREATOR;
    private final String name;
    public static final DriveSpace zzah;
    public static final DriveSpace zzai;
    public static final DriveSpace zzaj;
    private static final Set zzak;
    private static final String zzal;
    private static final Pattern zzam;

    static {
        DriveSpace.CREATOR = new zzm();
        DriveSpace driveSpace0 = new DriveSpace("DRIVE");
        DriveSpace.zzah = driveSpace0;
        DriveSpace driveSpace1 = new DriveSpace("APP_DATA_FOLDER");
        DriveSpace.zzai = driveSpace1;
        DriveSpace driveSpace2 = new DriveSpace("PHOTOS");
        DriveSpace.zzaj = driveSpace2;
        Set set0 = CollectionUtils.setOf(driveSpace0, driveSpace1, driveSpace2);
        DriveSpace.zzak = set0;
        DriveSpace.zzal = TextUtils.join(",", set0.toArray());
        DriveSpace.zzam = Pattern.compile("[A-Z0-9_]*");
    }

    DriveSpace(String s) {
        this.name = (String)Preconditions.checkNotNull(s);
    }

    @Override
    public boolean equals(Object object0) {
        return object0 == null || object0.getClass() != DriveSpace.class ? false : this.name.equals(((DriveSpace)object0).name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() ^ 0x4A54C0DE;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 2, this.name, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

