package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;

public class Strategy extends AbstractSafeParcelable {
    public static class Builder {
        private int zzfu;
        private int zzfv;
        private int zzfw;
        private int zzfx;
        private int zzfy;

        public Builder() {
            this.zzfu = 3;
            this.zzfv = 300;
            this.zzfw = 0;
            this.zzfx = -1;
            this.zzfy = 0;
        }

        public Strategy build() {
            if(this.zzfx == 2 && this.zzfw == 1) {
                throw new IllegalStateException("Cannot set EARSHOT with BLE only mode.");
            }
            return new Strategy(2, 0, this.zzfv, this.zzfw, false, this.zzfx, this.zzfu, 0);
        }

        public Builder setDiscoveryMode(int v) {
            this.zzfu = v;
            return this;
        }

        public Builder setDistanceType(int v) {
            this.zzfw = v;
            return this;
        }

        public Builder setTtlSeconds(int v) {
            Preconditions.checkArgument(v == 0x7FFFFFFF || v > 0 && v <= 86400, "mTtlSeconds(%d) must either be TTL_SECONDS_INFINITE, or it must be between 1 and TTL_SECONDS_MAX(%d) inclusive", new Object[]{v, 86400});
            this.zzfv = v;
            return this;
        }

        public final Builder zze(int v) {
            this.zzfx = 2;
            return this;
        }
    }

    public static final Strategy BLE_ONLY = null;
    public static final Parcelable.Creator CREATOR = null;
    public static final Strategy DEFAULT = null;
    public static final int DISCOVERY_MODE_BROADCAST = 1;
    public static final int DISCOVERY_MODE_DEFAULT = 3;
    public static final int DISCOVERY_MODE_SCAN = 2;
    public static final int DISTANCE_TYPE_DEFAULT = 0;
    public static final int DISTANCE_TYPE_EARSHOT = 1;
    public static final int TTL_SECONDS_DEFAULT = 300;
    public static final int TTL_SECONDS_INFINITE = 0x7FFFFFFF;
    public static final int TTL_SECONDS_MAX = 86400;
    private final int zzex;
    @Deprecated
    private static final Strategy zzfm;
    @Deprecated
    private final int zzfn;
    private final int zzfo;
    private final int zzfp;
    @Deprecated
    private final boolean zzfq;
    private final int zzfr;
    private final int zzfs;
    private final int zzft;

    static {
        Strategy.CREATOR = new zzg();
        Strategy.DEFAULT = new Builder().build();
        Strategy strategy0 = new Builder().zze(2).setTtlSeconds(0x7FFFFFFF).build();
        Strategy.BLE_ONLY = strategy0;
        Strategy.zzfm = strategy0;
    }

    Strategy(int v, int v1, int v2, int v3, boolean z, int v4, int v5, int v6) {
        this.zzex = v;
        this.zzfn = v1;
        if(v1 == 0) {
            this.zzfs = v5;
        }
        else {
            switch(v1) {
                case 2: {
                    this.zzfs = 1;
                    break;
                }
                case 3: {
                    this.zzfs = 2;
                    break;
                }
                default: {
                    this.zzfs = 3;
                }
            }
        }
        this.zzfp = v3;
        this.zzfq = z;
        if(z) {
            this.zzfr = 2;
            this.zzfo = 0x7FFFFFFF;
        }
        else {
            this.zzfo = v2;
            this.zzfr = v4 == -1 || v4 == 0 || v4 == 1 || v4 == 6 ? -1 : v4;
        }
        this.zzft = v6;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof Strategy ? this.zzex == ((Strategy)object0).zzex && this.zzfs == ((Strategy)object0).zzfs && this.zzfo == ((Strategy)object0).zzfo && this.zzfp == ((Strategy)object0).zzfp && this.zzfr == ((Strategy)object0).zzfr && this.zzft == ((Strategy)object0).zzft : false;
    }

    @Override
    public int hashCode() {
        return ((((this.zzex * 0x1F + this.zzfs) * 0x1F + this.zzfo) * 0x1F + this.zzfp) * 0x1F + this.zzfr) * 0x1F + this.zzft;
    }

    @Override
    public String toString() {
        String s3;
        String s2;
        String s1;
        int v = this.zzfo;
        int v1 = this.zzfp;
        String s = "DEFAULT";
        switch(v1) {
            case 0: {
                s1 = "DEFAULT";
                break;
            }
            case 1: {
                s1 = "EARSHOT";
                break;
            }
            default: {
                s1 = "UNKNOWN:" + v1;
            }
        }
        int v2 = this.zzfr;
        if(v2 == -1) {
            s2 = "DEFAULT";
        }
        else {
            ArrayList arrayList0 = new ArrayList();
            if((v2 & 4) > 0) {
                arrayList0.add("ULTRASOUND");
            }
            if((v2 & 2) > 0) {
                arrayList0.add("BLE");
            }
            s2 = arrayList0.isEmpty() ? "UNKNOWN:" + v2 : arrayList0.toString();
        }
        int v3 = this.zzfs;
        if(v3 == 3) {
            s3 = "DEFAULT";
        }
        else {
            ArrayList arrayList1 = new ArrayList();
            if((v3 & 1) > 0) {
                arrayList1.add("BROADCAST");
            }
            if((v3 & 2) > 0) {
                arrayList1.add("SCAN");
            }
            s3 = arrayList1.isEmpty() ? "UNKNOWN:" + v3 : arrayList1.toString();
        }
        int v4 = this.zzft;
        if(v4 != 0) {
            if(v4 != 1) {
                return "Strategy{ttlSeconds=" + v + ", distanceType=" + s1 + ", discoveryMedium=" + s2 + ", discoveryMode=" + s3 + ", backgroundScanMode=" + ("UNKNOWN: " + v4) + '}';
            }
            s = "ALWAYS_ON";
        }
        return "Strategy{ttlSeconds=" + v + ", distanceType=" + s1 + ", discoveryMedium=" + s2 + ", discoveryMode=" + s3 + ", backgroundScanMode=" + s + '}';
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.zzfn);
        SafeParcelWriter.writeInt(parcel0, 2, this.zzfo);
        SafeParcelWriter.writeInt(parcel0, 3, this.zzfp);
        SafeParcelWriter.writeBoolean(parcel0, 4, this.zzfq);
        SafeParcelWriter.writeInt(parcel0, 5, this.zzfr);
        SafeParcelWriter.writeInt(parcel0, 6, this.zzfs);
        SafeParcelWriter.writeInt(parcel0, 7, this.zzft);
        SafeParcelWriter.writeInt(parcel0, 1000, this.zzex);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final int zzae() {
        return this.zzft;
    }
}

