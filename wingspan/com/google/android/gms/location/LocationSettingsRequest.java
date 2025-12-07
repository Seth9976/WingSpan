package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class LocationSettingsRequest extends AbstractSafeParcelable {
    public static final class Builder {
        private final ArrayList zza;
        private boolean zzb;
        private boolean zzc;

        public Builder() {
            this.zza = new ArrayList();
            this.zzb = false;
            this.zzc = false;
        }

        public Builder addAllLocationRequests(Collection collection0) {
            for(Object object0: collection0) {
                LocationRequest locationRequest0 = (LocationRequest)object0;
                if(locationRequest0 != null) {
                    this.zza.add(locationRequest0);
                }
            }
            return this;
        }

        public Builder addLocationRequest(LocationRequest locationRequest0) {
            if(locationRequest0 != null) {
                this.zza.add(locationRequest0);
            }
            return this;
        }

        public LocationSettingsRequest build() {
            return new LocationSettingsRequest(this.zza, this.zzb, this.zzc, null);
        }

        public Builder setAlwaysShow(boolean z) {
            this.zzb = z;
            return this;
        }

        public Builder setNeedBle(boolean z) {
            this.zzc = z;
            return this;
        }
    }

    public static final Parcelable.Creator CREATOR;
    private final List zza;
    private final boolean zzb;
    private final boolean zzc;
    private zzbj zzd;

    static {
        LocationSettingsRequest.CREATOR = new zzbl();
    }

    LocationSettingsRequest(List list0, boolean z, boolean z1, zzbj zzbj0) {
        this.zza = list0;
        this.zzb = z;
        this.zzc = z1;
        this.zzd = zzbj0;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeTypedList(parcel0, 1, Collections.unmodifiableList(this.zza), false);
        SafeParcelWriter.writeBoolean(parcel0, 2, this.zzb);
        SafeParcelWriter.writeBoolean(parcel0, 3, this.zzc);
        SafeParcelWriter.writeParcelable(parcel0, 5, this.zzd, v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

