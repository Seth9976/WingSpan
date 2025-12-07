package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.messages.Message;

public final class zzaf extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final int versionCode;
    private final Message zzhk;

    static {
        zzaf.CREATOR = new zzag();
    }

    zzaf(int v, Message message0) {
        this.versionCode = v;
        this.zzhk = (Message)Preconditions.checkNotNull(message0);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof zzaf ? Objects.equal(this.zzhk, ((zzaf)object0).zzhk) : false;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zzhk});
    }

    @Override
    public final String toString() {
        return "MessageWrapper{message=" + this.zzhk.toString() + "}";
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 1, this.zzhk, v, false);
        SafeParcelWriter.writeInt(parcel0, 1000, this.versionCode);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public static final zzaf zza(Message message0) {
        return new zzaf(1, message0);
    }
}

