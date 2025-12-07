package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.nearby.zzgs;
import java.util.Arrays;

public class Message extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator CREATOR = null;
    public static final int MAX_CONTENT_SIZE_BYTES = 0x19000;
    public static final int MAX_TYPE_LENGTH = 0x20;
    public static final String MESSAGE_NAMESPACE_RESERVED = "__reserved_namespace";
    public static final String MESSAGE_TYPE_AUDIO_BYTES = "__audio_bytes";
    public static final String MESSAGE_TYPE_EDDYSTONE_UID = "__eddystone_uid";
    public static final String MESSAGE_TYPE_I_BEACON_ID = "__i_beacon_id";
    private final byte[] content;
    private final String namespace;
    private final String type;
    private final int versionCode;
    private static final zzgs[] zzeu;
    @Deprecated
    private final zzgs[] zzev;
    private final long zzew;

    static {
        Message.CREATOR = new zza();
        Message.zzeu = new zzgs[]{zzgs.zzgv};
    }

    Message(int v, byte[] arr_b, String s, String s1, zzgs[] arr_zzgs, long v1) {
        this.versionCode = v;
        this.type = (String)Preconditions.checkNotNull(s1);
        if(s == null) {
            s = "";
        }
        this.namespace = s;
        this.zzew = v1;
        Preconditions.checkNotNull(arr_b);
        Preconditions.checkArgument(arr_b.length <= 0x19000, "Content length(%d) must not exceed MAX_CONTENT_SIZE_BYTES(%d)", new Object[]{((int)arr_b.length), 0x19000});
        this.content = arr_b;
        if(arr_zzgs == null || arr_zzgs.length == 0) {
            arr_zzgs = Message.zzeu;
        }
        this.zzev = arr_zzgs;
        Preconditions.checkArgument(s1.length() <= 0x20, "Type length(%d) must not exceed MAX_TYPE_LENGTH(%d)", new Object[]{s1.length(), 0x20});
    }

    public Message(byte[] arr_b) {
        this(arr_b, "", "");
    }

    public Message(byte[] arr_b, String s) {
        this(arr_b, "", s);
    }

    public Message(byte[] arr_b, String s, String s1) {
        this(arr_b, s, s1, Message.zzeu);
    }

    private Message(byte[] arr_b, String s, String s1, zzgs[] arr_zzgs) {
        this(arr_b, s, s1, arr_zzgs, 0L);
    }

    private Message(byte[] arr_b, String s, String s1, zzgs[] arr_zzgs, long v) {
        this(2, arr_b, s, s1, arr_zzgs, 0L);
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof Message ? TextUtils.equals(this.namespace, ((Message)object0).namespace) && TextUtils.equals(this.type, ((Message)object0).type) && Arrays.equals(this.content, ((Message)object0).content) && this.zzew == ((Message)object0).zzew : false;
    }

    public byte[] getContent() {
        return this.content;
    }

    public String getNamespace() {
        return this.namespace;
    }

    public String getType() {
        return this.type;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.namespace, this.type, Arrays.hashCode(this.content), this.zzew});
    }

    @Override
    public String toString() {
        return this.content == null ? "Message{namespace=\'" + this.namespace + "\', type=\'" + this.type + "\', content=[" + 0 + " bytes]}" : "Message{namespace=\'" + this.namespace + "\', type=\'" + this.type + "\', content=[" + this.content.length + " bytes]}";
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeByteArray(parcel0, 1, this.getContent(), false);
        SafeParcelWriter.writeString(parcel0, 2, this.getType(), false);
        SafeParcelWriter.writeString(parcel0, 3, this.getNamespace(), false);
        SafeParcelWriter.writeTypedArray(parcel0, 4, this.zzev, v, false);
        SafeParcelWriter.writeLong(parcel0, 5, this.zzew);
        SafeParcelWriter.writeInt(parcel0, 1000, this.versionCode);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    // 去混淆评级： 低(20)
    public final boolean zzl(String s) {
        return "__reserved_namespace".equals(this.getNamespace()) && s.equals(this.getType());
    }
}

