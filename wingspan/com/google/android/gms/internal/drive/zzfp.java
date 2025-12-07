package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.zzb;
import com.google.android.gms.drive.events.zzo;
import com.google.android.gms.drive.events.zzr;
import com.google.android.gms.drive.events.zzv;

public final class zzfp extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final int zzda;
    private final ChangeEvent zzib;
    private final CompletionEvent zzic;
    private final zzo zzid;
    private final zzb zzie;
    private final zzv zzif;
    private final zzr zzig;

    static {
        zzfp.CREATOR = new zzfq();
    }

    zzfp(int v, ChangeEvent changeEvent0, CompletionEvent completionEvent0, zzo zzo0, zzb zzb0, zzv zzv0, zzr zzr0) {
        this.zzda = v;
        this.zzib = changeEvent0;
        this.zzic = completionEvent0;
        this.zzid = zzo0;
        this.zzie = zzb0;
        this.zzif = zzv0;
        this.zzig = zzr0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 2, this.zzda);
        SafeParcelWriter.writeParcelable(parcel0, 3, this.zzib, v, false);
        SafeParcelWriter.writeParcelable(parcel0, 5, this.zzic, v, false);
        SafeParcelWriter.writeParcelable(parcel0, 6, this.zzid, v, false);
        SafeParcelWriter.writeParcelable(parcel0, 7, this.zzie, v, false);
        SafeParcelWriter.writeParcelable(parcel0, 9, this.zzif, v, false);
        SafeParcelWriter.writeParcelable(parcel0, 10, this.zzig, v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final DriveEvent zzat() {
        switch(this.zzda) {
            case 1: {
                return this.zzib;
            }
            case 2: {
                return this.zzic;
            }
            case 3: {
                return this.zzid;
            }
            case 4: {
                return this.zzie;
            }
            case 7: {
                return this.zzif;
            }
            case 8: {
                return this.zzig;
            }
            default: {
                throw new IllegalStateException("Unexpected event type " + this.zzda);
            }
        }
    }
}

