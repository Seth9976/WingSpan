package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Locale;

public final class Strategy extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    public static final Strategy P2P_CLUSTER;
    public static final Strategy P2P_POINT_TO_POINT;
    public static final Strategy P2P_STAR;
    private final int zzaj;
    private final int zzak;

    static {
        Strategy.CREATOR = new zzj();
        Strategy.P2P_CLUSTER = new Strategy(1, 3);
        Strategy.P2P_STAR = new Strategy(1, 2);
        Strategy.P2P_POINT_TO_POINT = new Strategy(1, 1);
    }

    Strategy(int v, int v1) {
        this.zzaj = v;
        this.zzak = v1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof Strategy ? this.zzaj == ((Strategy)object0).zzaj && this.zzak == ((Strategy)object0).zzak : false;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zzaj, this.zzak});
    }

    @Override
    public final String toString() {
        String s;
        Locale locale0 = Locale.US;
        Object[] arr_object = new Object[3];
        if(Strategy.P2P_CLUSTER.equals(this)) {
            s = "P2P_CLUSTER";
        }
        else if(Strategy.P2P_STAR.equals(this)) {
            s = "P2P_STAR";
        }
        else {
            s = Strategy.P2P_POINT_TO_POINT.equals(this) ? "P2P_POINT_TO_POINT" : "UNKNOWN";
        }
        arr_object[0] = s;
        arr_object[1] = this.zzaj;
        arr_object[2] = this.zzak;
        return String.format(locale0, "Strategy(%s){connectionType=%d, topology=%d}", arr_object);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 3, this.zzaj);
        SafeParcelWriter.writeInt(parcel0, 4, this.zzak);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

