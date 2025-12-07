package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.List;

public final class zzg implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        DriveId driveId0 = null;
        String s = null;
        ParcelFileDescriptor parcelFileDescriptor0 = null;
        ParcelFileDescriptor parcelFileDescriptor1 = null;
        MetadataBundle metadataBundle0 = null;
        List list0 = null;
        IBinder iBinder0 = null;
        int v1 = 0;
        while(parcel0.dataPosition() < v) {
            int v2 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v2)) {
                case 2: {
                    driveId0 = (DriveId)SafeParcelReader.createParcelable(parcel0, v2, DriveId.CREATOR);
                    break;
                }
                case 3: {
                    s = SafeParcelReader.createString(parcel0, v2);
                    break;
                }
                case 4: {
                    parcelFileDescriptor0 = (ParcelFileDescriptor)SafeParcelReader.createParcelable(parcel0, v2, ParcelFileDescriptor.CREATOR);
                    break;
                }
                case 5: {
                    parcelFileDescriptor1 = (ParcelFileDescriptor)SafeParcelReader.createParcelable(parcel0, v2, ParcelFileDescriptor.CREATOR);
                    break;
                }
                case 6: {
                    metadataBundle0 = (MetadataBundle)SafeParcelReader.createParcelable(parcel0, v2, MetadataBundle.CREATOR);
                    break;
                }
                case 7: {
                    list0 = SafeParcelReader.createStringList(parcel0, v2);
                    break;
                }
                case 8: {
                    v1 = SafeParcelReader.readInt(parcel0, v2);
                    break;
                }
                case 9: {
                    iBinder0 = SafeParcelReader.readIBinder(parcel0, v2);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v2);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new CompletionEvent(driveId0, s, parcelFileDescriptor0, parcelFileDescriptor1, metadataBundle0, list0, v1, iBinder0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new CompletionEvent[v];
    }
}

