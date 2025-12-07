package com.google.android.gms.drive.metadata.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.drive.zzhs;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class MetadataBundle extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator CREATOR;
    private static final GmsLogger zzbz;
    private final Bundle zzjh;

    static {
        MetadataBundle.zzbz = new GmsLogger("MetadataBundle", "");
        MetadataBundle.CREATOR = new zzj();
    }

    MetadataBundle(Bundle bundle0) {
        int v;
        Bundle bundle1 = (Bundle)Preconditions.checkNotNull(bundle0);
        this.zzjh = bundle1;
        bundle1.setClassLoader(this.getClass().getClassLoader());
        ArrayList arrayList0 = new ArrayList();
        Iterator iterator0 = bundle1.keySet().iterator();
        while(true) {
            v = 0;
            if(!iterator0.hasNext()) {
                break;
            }
            Object object0 = iterator0.next();
            String s = (String)object0;
            if(zzf.zzf(s) == null) {
                arrayList0.add(s);
                MetadataBundle.zzbz.wfmt("MetadataBundle", "Ignored unknown metadata field in bundle: %s", new Object[]{s});
            }
        }
        int v1 = arrayList0.size();
        while(v < v1) {
            Object object1 = arrayList0.get(v);
            ++v;
            this.zzjh.remove(((String)object1));
        }
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null && object0.getClass() == this.getClass()) {
            Set set0 = this.zzjh.keySet();
            if(!set0.equals(((MetadataBundle)object0).zzjh.keySet())) {
                return false;
            }
            for(Object object1: set0) {
                if(!Objects.equal(this.zzjh.get(((String)object1)), ((MetadataBundle)object0).zzjh.get(((String)object1)))) {
                    return false;
                }
                if(false) {
                    break;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int v = 1;
        for(Object object0: this.zzjh.keySet()) {
            v = v * 0x1F + this.zzjh.get(((String)object0)).hashCode();
        }
        return v;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeBundle(parcel0, 2, this.zzjh, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public static MetadataBundle zza(MetadataField metadataField0, Object object0) {
        MetadataBundle metadataBundle0 = MetadataBundle.zzbe();
        metadataBundle0.zzb(metadataField0, object0);
        return metadataBundle0;
    }

    public final Object zza(MetadataField metadataField0) {
        return metadataField0.zza(this.zzjh);
    }

    public final void zza(Context context0) {
        BitmapTeleporter bitmapTeleporter0 = (BitmapTeleporter)this.zza(zzhs.zzkq);
        if(bitmapTeleporter0 != null) {
            bitmapTeleporter0.setTempDir(context0.getCacheDir());
        }
    }

    public final void zzb(MetadataField metadataField0, Object object0) {
        if(zzf.zzf(metadataField0.getName()) == null) {
            String s = metadataField0.getName();
            throw new IllegalArgumentException((s.length() == 0 ? new String("Unregistered field: ") : "Unregistered field: " + s));
        }
        metadataField0.zza(object0, this.zzjh);
    }

    public static MetadataBundle zzbe() {
        return new MetadataBundle(new Bundle());
    }

    public final MetadataBundle zzbf() {
        return new MetadataBundle(new Bundle(this.zzjh));
    }

    public final Set zzbg() {
        Set set0 = new HashSet();
        for(Object object0: this.zzjh.keySet()) {
            set0.add(zzf.zzf(((String)object0)));
        }
        return set0;
    }

    public final Object zzc(MetadataField metadataField0) {
        Object object0 = this.zza(metadataField0);
        String s = metadataField0.getName();
        this.zzjh.remove(s);
        return object0;
    }

    public final boolean zzd(MetadataField metadataField0) {
        String s = metadataField0.getName();
        return this.zzjh.containsKey(s);
    }
}

