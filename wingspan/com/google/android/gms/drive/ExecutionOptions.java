package com.google.android.gms.drive;

import android.text.TextUtils;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.internal.drive.zzaw;

public class ExecutionOptions {
    public static class Builder {
        protected String zzaq;
        protected boolean zzar;
        protected int zzas;

        public Builder() {
            this.zzas = 0;
        }

        public ExecutionOptions build() {
            this.zzo();
            return new ExecutionOptions(this.zzaq, this.zzar, this.zzas);
        }

        public Builder setConflictStrategy(int v) {
            if(v != 0 && v != 1) {
                throw new IllegalArgumentException("Unrecognized value for conflict strategy: " + v);
            }
            this.zzas = v;
            return this;
        }

        public Builder setNotifyOnCompletion(boolean z) {
            this.zzar = z;
            return this;
        }

        public Builder setTrackingTag(String s) {
            if(TextUtils.isEmpty(s) || s.length() > 0x10000) {
                throw new IllegalArgumentException("trackingTag must not be null nor empty, and the length must be <= the maximum length (65536)");
            }
            this.zzaq = s;
            return this;
        }

        protected final void zzo() {
            if(this.zzas == 1 && !this.zzar) {
                throw new IllegalStateException("Cannot use CONFLICT_STRATEGY_KEEP_REMOTE without requesting completion notifications");
            }
        }
    }

    public static final int CONFLICT_STRATEGY_KEEP_REMOTE = 1;
    public static final int CONFLICT_STRATEGY_OVERWRITE_REMOTE = 0;
    public static final int MAX_TRACKING_TAG_STRING_LENGTH = 0x10000;
    private final String zzan;
    private final boolean zzao;
    private final int zzap;

    public ExecutionOptions(String s, boolean z, int v) {
        this.zzan = s;
        this.zzao = z;
        this.zzap = v;
    }

    @Override
    public boolean equals(Object object0) {
        if(object0 != null && object0.getClass() == this.getClass()) {
            return object0 == this ? true : Objects.equal(this.zzan, ((ExecutionOptions)object0).zzan) && this.zzap == ((ExecutionOptions)object0).zzap && this.zzao == ((ExecutionOptions)object0).zzao;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zzan, this.zzap, Boolean.valueOf(this.zzao)});
    }

    public static boolean zza(int v) {
        return v == 1;
    }

    @Deprecated
    public final void zza(GoogleApiClient googleApiClient0) {
        this.zza(((zzaw)googleApiClient0.getClient(Drive.CLIENT_KEY)));
    }

    public final void zza(zzaw zzaw0) {
        if(this.zzao && !zzaw0.zzah()) {
            throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to be notified on completion");
        }
    }

    public final String zzl() {
        return this.zzan;
    }

    public final boolean zzm() {
        return this.zzao;
    }

    public final int zzn() {
        return this.zzap;
    }
}

