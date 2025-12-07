package com.google.android.gms.internal.drive;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.drive.events.zzk;
import com.google.android.gms.drive.events.zzm;
import java.util.Locale;

public final class zze implements zzk {
    private final zzm zzcv;
    private final long zzcw;
    private final long zzcx;

    public zze(zzh zzh0) {
        this.zzcv = new zzf(zzh0);
        this.zzcw = zzh0.zzcw;
        this.zzcx = zzh0.zzcx;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 != null && object0.getClass() == this.getClass()) {
            return object0 == this ? true : Objects.equal(this.zzcv, ((zze)object0).zzcv) && this.zzcw == ((zze)object0).zzcw && this.zzcx == ((zze)object0).zzcx;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zzcx, this.zzcw, this.zzcx});
    }

    @Override
    public final String toString() {
        return String.format(Locale.US, "FileTransferProgress[FileTransferState: %s, BytesTransferred: %d, TotalBytes: %d]", this.zzcv.toString(), this.zzcw, this.zzcx);
    }
}

