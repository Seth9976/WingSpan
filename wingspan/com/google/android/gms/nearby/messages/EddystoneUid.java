package com.google.android.gms.nearby.messages;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.nearby.messages.internal.zzc;
import com.google.android.gms.nearby.messages.internal.zzg;
import java.util.Arrays;

public class EddystoneUid {
    public static final int INSTANCE_LENGTH = 6;
    public static final int LENGTH = 16;
    public static final int NAMESPACE_LENGTH = 10;
    private final zzg zzes;

    public EddystoneUid(String s) {
        this(zzc.zzm(s));
    }

    public EddystoneUid(String s, String s1) {
        this.zzes = new zzg(s, s1);
    }

    private EddystoneUid(byte[] arr_b) {
        Preconditions.checkArgument(arr_b.length == 16, "Bytes must be a namespace plus instance (16 bytes).");
        this.zzes = new zzg(arr_b);
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof EddystoneUid ? Objects.equal(this.zzes, ((EddystoneUid)object0).zzes) : false;
    }

    public static EddystoneUid from(Message message0) {
        Preconditions.checkArgument(message0.zzl("__eddystone_uid"), "Message type \'" + message0.getType() + "\' is not Message.MESSAGE_TYPE_EDDYSTONE_UID.");
        return new EddystoneUid(message0.getContent());
    }

    public String getHex() {
        return this.zzes.getHex();
    }

    public String getInstance() {
        byte[] arr_b = this.zzes.getBytes();
        return arr_b.length >= 16 ? zzc.zzf(Arrays.copyOfRange(arr_b, 10, 16)) : null;
    }

    public String getNamespace() {
        return zzc.zzf(Arrays.copyOfRange(this.zzes.getBytes(), 0, 10));
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zzes});
    }

    @Override
    public String toString() {
        return "EddystoneUid{id=" + this.getHex() + '}';
    }
}

