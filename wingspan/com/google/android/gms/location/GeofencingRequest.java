package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.location.zzbe;
import java.util.ArrayList;
import java.util.List;

public class GeofencingRequest extends AbstractSafeParcelable {
    public static final class Builder {
        private final List zza;
        private int zzb;
        private String zzc;

        public Builder() {
            this.zza = new ArrayList();
            this.zzb = 5;
            this.zzc = "";
        }

        public Builder addGeofence(Geofence geofence0) {
            Preconditions.checkNotNull(geofence0, "geofence can\'t be null.");
            Preconditions.checkArgument(geofence0 instanceof zzbe, "Geofence must be created using Geofence.Builder.");
            this.zza.add(((zzbe)geofence0));
            return this;
        }

        public Builder addGeofences(List list0) {
            if(list0 != null && !list0.isEmpty()) {
                for(Object object0: list0) {
                    Geofence geofence0 = (Geofence)object0;
                    if(geofence0 != null) {
                        this.addGeofence(geofence0);
                    }
                }
            }
            return this;
        }

        public GeofencingRequest build() {
            Preconditions.checkArgument(!this.zza.isEmpty(), "No geofence has been added to this request.");
            return new GeofencingRequest(this.zza, this.zzb, this.zzc, null);
        }

        public Builder setInitialTrigger(int v) {
            this.zzb = v & 7;
            return this;
        }
    }

    public @interface InitialTrigger {
    }

    public static final Parcelable.Creator CREATOR = null;
    public static final int INITIAL_TRIGGER_DWELL = 4;
    public static final int INITIAL_TRIGGER_ENTER = 1;
    public static final int INITIAL_TRIGGER_EXIT = 2;
    private final List zza;
    private final int zzb;
    private final String zzc;
    private final String zzd;

    static {
        GeofencingRequest.CREATOR = new zzau();
    }

    GeofencingRequest(List list0, int v, String s, String s1) {
        this.zza = list0;
        this.zzb = v;
        this.zzc = s;
        this.zzd = s1;
    }

    public List getGeofences() {
        List list0 = new ArrayList();
        list0.addAll(this.zza);
        return list0;
    }

    public int getInitialTrigger() {
        return this.zzb;
    }

    @Override
    public String toString() {
        return "GeofencingRequest[geofences=" + this.zza + ", initialTrigger=" + this.zzb + ", tag=" + this.zzc + ", attributionTag=" + this.zzd + "]";
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeTypedList(parcel0, 1, this.zza, false);
        SafeParcelWriter.writeInt(parcel0, 2, this.getInitialTrigger());
        SafeParcelWriter.writeString(parcel0, 3, this.zzc, false);
        SafeParcelWriter.writeString(parcel0, 4, this.zzd, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final GeofencingRequest zza(String s) {
        return new GeofencingRequest(this.zza, this.zzb, this.zzc, s);
    }
}

