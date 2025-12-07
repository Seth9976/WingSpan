package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.zzb;
import com.google.android.gms.drive.events.zzo;
import com.google.android.gms.drive.events.zzr;
import com.google.android.gms.drive.events.zzv;

public final class zzfq implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        int v1 = 0;
        ChangeEvent changeEvent0 = null;
        CompletionEvent completionEvent0 = null;
        zzo zzo0 = null;
        zzb zzb0 = null;
        zzv zzv0 = null;
        zzr zzr0 = null;
        while(parcel0.dataPosition() < v) {
            int v2 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v2)) {
                case 2: {
                    v1 = SafeParcelReader.readInt(parcel0, v2);
                    break;
                }
                case 3: {
                    changeEvent0 = (ChangeEvent)SafeParcelReader.createParcelable(parcel0, v2, ChangeEvent.CREATOR);
                    break;
                }
                case 5: {
                    completionEvent0 = (CompletionEvent)SafeParcelReader.createParcelable(parcel0, v2, CompletionEvent.CREATOR);
                    break;
                }
                case 6: {
                    zzo0 = (zzo)SafeParcelReader.createParcelable(parcel0, v2, zzo.CREATOR);
                    break;
                }
                case 7: {
                    zzb0 = (zzb)SafeParcelReader.createParcelable(parcel0, v2, zzb.CREATOR);
                    break;
                }
                case 9: {
                    zzv0 = (zzv)SafeParcelReader.createParcelable(parcel0, v2, zzv.CREATOR);
                    break;
                }
                case 10: {
                    zzr0 = (zzr)SafeParcelReader.createParcelable(parcel0, v2, zzr.CREATOR);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v2);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzfp(v1, changeEvent0, completionEvent0, zzo0, zzb0, zzv0, zzr0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzfp[v];
    }
}

