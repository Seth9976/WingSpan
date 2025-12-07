package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Locale;

public final class zzk {
    private String zzji;

    private zzk(String s) {
        this.zzji = s.toLowerCase(Locale.US);
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        return object0 == null || object0.getClass() != this.getClass() ? false : this.zzji.equals(((zzk)object0).zzji);
    }

    @Override
    public final int hashCode() {
        return this.zzji.hashCode();
    }

    public final boolean isFolder() {
        return this.zzji.equals("application/vnd.google-apps.folder");
    }

    @Override
    public final String toString() {
        return this.zzji;
    }

    public final boolean zzbh() {
        return this.zzji.startsWith("application/vnd.google-apps");
    }

    public static zzk zzg(String s) {
        Preconditions.checkArgument(s == null || !s.isEmpty());
        return s == null ? null : new zzk(s);
    }
}

