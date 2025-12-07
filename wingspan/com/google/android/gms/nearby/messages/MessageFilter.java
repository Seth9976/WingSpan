package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.nearby.zzgu;
import com.google.android.gms.nearby.messages.internal.zzad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class MessageFilter extends AbstractSafeParcelable {
    public static final class Builder {
        private final List zzez;
        private boolean zzfa;
        private int zzfc;
        private final Set zzfd;
        private final Set zzfe;

        public Builder() {
            this.zzfd = new HashSet();
            this.zzez = new ArrayList();
            this.zzfe = new HashSet();
            this.zzfc = 0;
        }

        public final MessageFilter build() {
            Preconditions.checkState(this.zzfa || !this.zzfd.isEmpty(), "At least one of the include methods must be called.");
            ArrayList arrayList0 = new ArrayList(this.zzfd);
            boolean z = this.zzfa;
            ArrayList arrayList1 = new ArrayList(this.zzfe);
            return new MessageFilter(arrayList0, this.zzez, z, arrayList1, this.zzfc, null);
        }

        public final Builder includeAllMyTypes() {
            this.zzfa = true;
            return this;
        }

        public final Builder includeAudioBytes(int v) {
            boolean z = true;
            Preconditions.checkArgument(this.zzfc == 0, "includeAudioBytes() can only be called once per MessageFilter instance.");
            Preconditions.checkArgument(v > 0, "Invalid value for numAudioBytes: " + v);
            if(v > 10) {
                z = false;
            }
            Preconditions.checkArgument(z, "numAudioBytes is capped by AudioBytes.MAX_SIZE = 10");
            this.zza("__reserved_namespace", "__audio_bytes");
            this.zzfc = v;
            return this;
        }

        public final Builder includeEddystoneUids(String s, String s1) {
            this.zza("__reserved_namespace", "__eddystone_uid");
            zzgu zzgu0 = zzgu.zzb(s, s1);
            this.zzez.add(zzgu0);
            return this;
        }

        public final Builder includeFilter(MessageFilter messageFilter0) {
            this.zzfd.addAll(messageFilter0.zzaa());
            this.zzez.addAll(messageFilter0.zzac());
            this.zzfe.addAll(messageFilter0.zzad());
            this.zzfa |= messageFilter0.zzab();
            return this;
        }

        public final Builder includeIBeaconIds(UUID uUID0, Short short0, Short short1) {
            this.zza("__reserved_namespace", "__i_beacon_id");
            zzgu zzgu0 = zzgu.zza(uUID0, short0, short1);
            this.zzez.add(zzgu0);
            return this;
        }

        public final Builder includeNamespacedType(String s, String s1) {
            Preconditions.checkArgument(s != null && !s.isEmpty() && !s.contains("*"), "namespace(%s) cannot be null, empty or contain (*).", new Object[]{s});
            Preconditions.checkArgument(s1 != null && !s1.contains("*"), "type(%s) cannot be null or contain (*).", new Object[]{s1});
            return this.zza(s, s1);
        }

        private final Builder zza(String s, String s1) {
            zzad zzad0 = new zzad(s, s1);
            this.zzfd.add(zzad0);
            return this;
        }
    }

    public static final Parcelable.Creator CREATOR;
    public static final MessageFilter INCLUDE_ALL_MY_TYPES;
    private final int zzex;
    private final List zzey;
    private final List zzez;
    private final boolean zzfa;
    private final List zzfb;
    private final int zzfc;

    static {
        MessageFilter.CREATOR = new zzc();
        MessageFilter.INCLUDE_ALL_MY_TYPES = new Builder().includeAllMyTypes().build();
    }

    MessageFilter(int v, List list0, List list1, boolean z, List list2, int v1) {
        this.zzex = v;
        this.zzey = Collections.unmodifiableList(((List)Preconditions.checkNotNull(list0)));
        this.zzfa = z;
        if(list1 == null) {
            list1 = Collections.emptyList();
        }
        this.zzez = Collections.unmodifiableList(list1);
        if(list2 == null) {
            list2 = Collections.emptyList();
        }
        this.zzfb = Collections.unmodifiableList(list2);
        this.zzfc = v1;
    }

    private MessageFilter(List list0, List list1, boolean z, List list2, int v) {
        this(2, list0, list1, z, list2, v);
    }

    MessageFilter(List list0, List list1, boolean z, List list2, int v, zzb zzb0) {
        this(list0, list1, z, list2, v);
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof MessageFilter ? this.zzfa == ((MessageFilter)object0).zzfa && Objects.equal(this.zzey, ((MessageFilter)object0).zzey) && Objects.equal(this.zzez, ((MessageFilter)object0).zzez) && Objects.equal(this.zzfb, ((MessageFilter)object0).zzfb) : false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zzey, this.zzez, Boolean.valueOf(this.zzfa), this.zzfb});
    }

    @Override
    public String toString() {
        return "MessageFilter{includeAllMyTypes=" + this.zzfa + ", messageTypes=" + this.zzey + "}";
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeTypedList(parcel0, 1, this.zzey, false);
        SafeParcelWriter.writeTypedList(parcel0, 2, this.zzez, false);
        SafeParcelWriter.writeBoolean(parcel0, 3, this.zzfa);
        SafeParcelWriter.writeTypedList(parcel0, 4, this.zzfb, false);
        SafeParcelWriter.writeInt(parcel0, 5, this.zzfc);
        SafeParcelWriter.writeInt(parcel0, 1000, this.zzex);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final List zzaa() {
        return this.zzey;
    }

    public final boolean zzab() {
        return this.zzfa;
    }

    final List zzac() {
        return this.zzez;
    }

    public final List zzad() {
        return this.zzfb;
    }
}

