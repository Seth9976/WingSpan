package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.nio.ByteBuffer;
import java.util.UUID;

public final class zzl extends zzc {
    public zzl(UUID uUID0, Short short0, Short short1) {
        ByteBuffer byteBuffer0 = ByteBuffer.allocate((short0 == null ? 0 : 2) + 16 + (short1 == null ? 0 : 2));
        byteBuffer0.putLong(uUID0.getMostSignificantBits()).putLong(uUID0.getLeastSignificantBits());
        if(short0 != null) {
            byteBuffer0.putShort(((short)short0));
        }
        if(short1 != null) {
            byteBuffer0.putShort(((short)short1));
        }
        this(byteBuffer0.array());
    }

    public zzl(byte[] arr_b) {
        Preconditions.checkArgument(arr_b.length == 16 || arr_b.length == 18 || arr_b.length == 20, "Prefix must be a UUID, a UUID and a major, or a UUID, a major, and a minor.");
        super(arr_b);
    }

    public final UUID getProximityUuid() {
        ByteBuffer byteBuffer0 = ByteBuffer.wrap(this.getBytes());
        return new UUID(byteBuffer0.getLong(), byteBuffer0.getLong());
    }

    @Override  // com.google.android.gms.nearby.messages.internal.zzc
    public final String toString() {
        return "IBeaconIdPrefix{proximityUuid=" + this.getProximityUuid() + ", major=" + this.zzaf() + ", minor=" + this.zzag() + '}';
    }

    public final Short zzaf() {
        byte[] arr_b = this.getBytes();
        return arr_b.length < 18 ? null : ByteBuffer.wrap(arr_b).getShort(16);
    }

    public final Short zzag() {
        byte[] arr_b = this.getBytes();
        return arr_b.length == 20 ? ByteBuffer.wrap(arr_b).getShort(18) : null;
    }
}

