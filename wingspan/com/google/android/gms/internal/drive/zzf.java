package com.google.android.gms.internal.drive;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.drive.DriveId;

public final class zzf {
    private final int status;
    private final int zzct;
    private final DriveId zzk;

    public zzf(zzh zzh0) {
        this.zzk = zzh0.zzk;
        this.zzct = zzh0.zzct;
        this.status = zzh0.status;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 != null && object0.getClass() == this.getClass()) {
            return object0 == this ? true : Objects.equal(this.zzk, ((zzf)object0).zzk) && this.zzct == ((zzf)object0).zzct && this.status == ((zzf)object0).status;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zzk, this.zzct, this.status});
    }

    @Override
    public final String toString() {
        return String.format("FileTransferState[TransferType: %d, DriveId: %s, status: %d]", this.zzct, this.zzk, this.status);
    }
}

