package com.google.android.gms.nearby.messages;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.nearby.messages.internal.zzl;
import java.util.UUID;

public class IBeaconId {
    public static final int LENGTH = 20;
    private final zzl zzet;

    public IBeaconId(UUID uUID0, short v, short v1) {
        this.zzet = new zzl(uUID0, v, v1);
    }

    private IBeaconId(byte[] arr_b) {
        Preconditions.checkArgument(arr_b.length == 20, "iBeacon ID must be a UUID, a major, and a minor (20 total bytes).");
        this.zzet = new zzl(arr_b);
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof IBeaconId ? Objects.equal(this.zzet, ((IBeaconId)object0).zzet) : false;
    }

    public static IBeaconId from(Message message0) {
        Preconditions.checkArgument(message0.zzl("__i_beacon_id"), "Message type \'" + message0.getType() + "\' is not Message.MESSAGE_TYPE_I_BEACON_ID");
        return new IBeaconId(message0.getContent());
    }

    public short getMajor() {
        return (short)this.zzet.zzaf();
    }

    public short getMinor() {
        return (short)this.zzet.zzag();
    }

    public UUID getProximityUuid() {
        return this.zzet.getProximityUuid();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zzet});
    }

    @Override
    public String toString() {
        return "IBeaconId{proximityUuid=" + this.getProximityUuid() + ", major=" + this.getMajor() + ", minor=" + this.getMinor() + '}';
    }
}

