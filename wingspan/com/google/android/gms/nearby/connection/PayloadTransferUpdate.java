package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class PayloadTransferUpdate extends AbstractSafeParcelable {
    @Deprecated
    public static final class Builder {
        private final PayloadTransferUpdate zzai;

        public Builder() {
            this.zzai = new PayloadTransferUpdate(null);
        }

        public Builder(PayloadTransferUpdate payloadTransferUpdate0) {
            PayloadTransferUpdate payloadTransferUpdate1 = new PayloadTransferUpdate(null);
            this.zzai = payloadTransferUpdate1;
            payloadTransferUpdate1.zzaf = payloadTransferUpdate0.zzaf;
            payloadTransferUpdate1.status = payloadTransferUpdate0.status;
            payloadTransferUpdate1.zzag = payloadTransferUpdate0.zzag;
            payloadTransferUpdate1.zzah = payloadTransferUpdate0.zzah;
        }

        public final PayloadTransferUpdate build() {
            return this.zzai;
        }

        public final Builder setBytesTransferred(long v) {
            this.zzai.zzah = v;
            return this;
        }

        public final Builder setPayloadId(long v) {
            this.zzai.zzaf = v;
            return this;
        }

        public final Builder setStatus(int v) {
            this.zzai.status = v;
            return this;
        }

        public final Builder setTotalBytes(long v) {
            this.zzai.zzag = v;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Status {
        public static final int CANCELED = 4;
        public static final int FAILURE = 2;
        public static final int IN_PROGRESS = 3;
        public static final int SUCCESS = 1;

    }

    public static final Parcelable.Creator CREATOR;
    private int status;
    private long zzaf;
    private long zzag;
    private long zzah;

    static {
        PayloadTransferUpdate.CREATOR = new zzi();
    }

    private PayloadTransferUpdate() {
    }

    PayloadTransferUpdate(long v, int v1, long v2, long v3) {
        this.zzaf = v;
        this.status = v1;
        this.zzag = v2;
        this.zzah = v3;
    }

    PayloadTransferUpdate(zzh zzh0) {
    }

    // 去混淆评级： 中等(60)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof PayloadTransferUpdate && Objects.equal(this.zzaf, ((PayloadTransferUpdate)object0).zzaf) && Objects.equal(this.status, ((PayloadTransferUpdate)object0).status) && Objects.equal(this.zzag, ((PayloadTransferUpdate)object0).zzag) && Objects.equal(this.zzah, ((PayloadTransferUpdate)object0).zzah);
    }

    public final long getBytesTransferred() {
        return this.zzah;
    }

    public final long getPayloadId() {
        return this.zzaf;
    }

    public final int getStatus() {
        return this.status;
    }

    public final long getTotalBytes() {
        return this.zzag;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zzaf, this.status, this.zzag, this.zzah});
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeLong(parcel0, 1, this.getPayloadId());
        SafeParcelWriter.writeInt(parcel0, 2, this.getStatus());
        SafeParcelWriter.writeLong(parcel0, 3, this.getTotalBytes());
        SafeParcelWriter.writeLong(parcel0, 4, this.getBytesTransferred());
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

