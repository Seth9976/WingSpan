package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class AppVisibleCustomProperties extends AbstractSafeParcelable implements ReflectedParcelable, Iterable {
    public static final class zza {
        private final Map zzjd;

        public zza() {
            this.zzjd = new HashMap();
        }

        public final zza zza(CustomPropertyKey customPropertyKey0, String s) {
            Preconditions.checkNotNull(customPropertyKey0, "key");
            zzc zzc0 = new zzc(customPropertyKey0, s);
            this.zzjd.put(customPropertyKey0, zzc0);
            return this;
        }

        public final zza zza(zzc zzc0) {
            Preconditions.checkNotNull(zzc0, "property");
            this.zzjd.put(zzc0.zzje, zzc0);
            return this;
        }

        public final AppVisibleCustomProperties zzbb() {
            return new AppVisibleCustomProperties(this.zzjd.values());
        }
    }

    public static final Parcelable.Creator CREATOR;
    public static final AppVisibleCustomProperties zzjb;
    private final List zzjc;

    static {
        AppVisibleCustomProperties.CREATOR = new com.google.android.gms.drive.metadata.internal.zza();
        AppVisibleCustomProperties.zzjb = new zza().zzbb();
    }

    AppVisibleCustomProperties(Collection collection0) {
        Preconditions.checkNotNull(collection0);
        this.zzjc = new ArrayList(collection0);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 == null || object0.getClass() != this.getClass() ? false : this.zzba().equals(((AppVisibleCustomProperties)object0).zzba());
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zzjc});
    }

    @Override
    public final Iterator iterator() {
        return this.zzjc.iterator();
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeTypedList(parcel0, 2, this.zzjc, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final Map zzba() {
        HashMap hashMap0 = new HashMap(this.zzjc.size());
        for(Object object0: this.zzjc) {
            hashMap0.put(((zzc)object0).zzje, ((zzc)object0).value);
        }
        return Collections.unmodifiableMap(hashMap0);
    }
}

