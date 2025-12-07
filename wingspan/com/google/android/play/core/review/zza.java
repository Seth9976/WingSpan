package com.google.android.play.core.review;

import android.app.PendingIntent;

final class zza extends ReviewInfo {
    private final PendingIntent zza;
    private final boolean zzb;

    zza(PendingIntent pendingIntent0, boolean z) {
        if(pendingIntent0 == null) {
            throw new NullPointerException("Null pendingIntent");
        }
        this.zza = pendingIntent0;
        this.zzb = z;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(object0 instanceof ReviewInfo) {
            PendingIntent pendingIntent0 = ((ReviewInfo)object0).zza();
            if(this.zza.equals(pendingIntent0)) {
                boolean z = ((ReviewInfo)object0).zzb();
                return this.zzb == z;
            }
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int v = this.zza.hashCode();
        return this.zzb ? (v ^ 1000003) * 1000003 ^ 0x4CF : (v ^ 1000003) * 1000003 ^ 0x4D5;
    }

    @Override
    public final String toString() {
        return "ReviewInfo{pendingIntent=" + this.zza.toString() + ", isNoOp=" + this.zzb + "}";
    }

    @Override  // com.google.android.play.core.review.ReviewInfo
    final PendingIntent zza() {
        return this.zza;
    }

    @Override  // com.google.android.play.core.review.ReviewInfo
    final boolean zzb() {
        return this.zzb;
    }
}

