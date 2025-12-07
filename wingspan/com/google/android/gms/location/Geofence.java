package com.google.android.gms.location;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.location.zzbe;

public interface Geofence {
    public static final class Builder {
        private String zza;
        private int zzb;
        private long zzc;
        private short zzd;
        private double zze;
        private double zzf;
        private float zzg;
        private int zzh;
        private int zzi;

        public Builder() {
            this.zza = null;
            this.zzb = 0;
            this.zzc = 0x8000000000000000L;
            this.zzd = -1;
            this.zzh = 0;
            this.zzi = -1;
        }

        public Geofence build() {
            String s = this.zza;
            if(s == null) {
                throw new IllegalArgumentException("Request ID not set.");
            }
            int v = this.zzb;
            if(v == 0) {
                throw new IllegalArgumentException("Transitions types not set.");
            }
            if((v & 4) != 0 && this.zzi < 0) {
                throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
            }
            long v1 = this.zzc;
            if(v1 == 0x8000000000000000L) {
                throw new IllegalArgumentException("Expiration not set.");
            }
            if(this.zzd == -1) {
                throw new IllegalArgumentException("Geofence region not set.");
            }
            int v2 = this.zzh;
            if(v2 < 0) {
                throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
            }
            return new zzbe(s, v, 1, this.zze, this.zzf, this.zzg, v1, v2, this.zzi);
        }

        public Builder setCircularRegion(double f, double f1, float f2) {
            boolean z = false;
            Preconditions.checkArgument(Double.compare(f, -90.0) >= 0 && f <= 90.0, "Invalid latitude: " + f);
            Preconditions.checkArgument(f1 >= -180.0 && f1 <= 180.0, "Invalid longitude: " + f1);
            if(f2 > 0.0f) {
                z = true;
            }
            Preconditions.checkArgument(z, "Invalid radius: " + f2);
            this.zzd = 1;
            this.zze = f;
            this.zzf = f1;
            this.zzg = f2;
            return this;
        }

        public Builder setExpirationDuration(long v) {
            if(v < 0L) {
                this.zzc = -1L;
                return this;
            }
            this.zzc = DefaultClock.getInstance().elapsedRealtime() + v;
            return this;
        }

        public Builder setLoiteringDelay(int v) {
            this.zzi = v;
            return this;
        }

        public Builder setNotificationResponsiveness(int v) {
            this.zzh = v;
            return this;
        }

        public Builder setRequestId(String s) {
            this.zza = (String)Preconditions.checkNotNull(s, "Request ID can\'t be set to null");
            return this;
        }

        public Builder setTransitionTypes(int v) {
            this.zzb = v;
            return this;
        }
    }

    public @interface GeofenceTransition {
    }

    public @interface TransitionTypes {
    }

    public static final int GEOFENCE_TRANSITION_DWELL = 4;
    public static final int GEOFENCE_TRANSITION_ENTER = 1;
    public static final int GEOFENCE_TRANSITION_EXIT = 2;
    public static final long NEVER_EXPIRE = -1L;

    String getRequestId();
}

