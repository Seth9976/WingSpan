package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class zza implements MetadataField {
    private final String fieldName;
    private final Set zziw;
    private final Set zzix;
    private final int zziy;

    protected zza(String s, int v) {
        this.fieldName = (String)Preconditions.checkNotNull(s, "fieldName");
        this.zziw = Collections.singleton(s);
        this.zzix = Collections.emptySet();
        this.zziy = v;
    }

    protected zza(String s, Collection collection0, Collection collection1, int v) {
        this.fieldName = (String)Preconditions.checkNotNull(s, "fieldName");
        this.zziw = Collections.unmodifiableSet(new HashSet(collection0));
        this.zzix = Collections.unmodifiableSet(new HashSet(collection1));
        this.zziy = v;
    }

    @Override  // com.google.android.gms.drive.metadata.MetadataField
    public final String getName() {
        return this.fieldName;
    }

    @Override
    public String toString() {
        return this.fieldName;
    }

    @Override  // com.google.android.gms.drive.metadata.MetadataField
    public final Object zza(Bundle bundle0) {
        Preconditions.checkNotNull(bundle0, "bundle");
        return bundle0.get(this.fieldName) == null ? null : this.zzb(bundle0);
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.gms.drive.metadata.MetadataField
    public final Object zza(DataHolder dataHolder0, int v, int v1) {
        return this.zzb(dataHolder0, v, v1) ? this.zzc(dataHolder0, v, v1) : null;
    }

    protected abstract void zza(Bundle arg1, Object arg2);

    @Override  // com.google.android.gms.drive.metadata.MetadataField
    public final void zza(DataHolder dataHolder0, MetadataBundle metadataBundle0, int v, int v1) {
        Preconditions.checkNotNull(dataHolder0, "dataHolder");
        Preconditions.checkNotNull(metadataBundle0, "bundle");
        if(this.zzb(dataHolder0, v, v1)) {
            metadataBundle0.zzb(this, this.zzc(dataHolder0, v, v1));
        }
    }

    @Override  // com.google.android.gms.drive.metadata.MetadataField
    public final void zza(Object object0, Bundle bundle0) {
        Preconditions.checkNotNull(bundle0, "bundle");
        if(object0 == null) {
            bundle0.putString(this.fieldName, null);
            return;
        }
        this.zza(bundle0, object0);
    }

    public final Collection zzaz() {
        return this.zziw;
    }

    protected abstract Object zzb(Bundle arg1);

    protected boolean zzb(DataHolder dataHolder0, int v, int v1) {
        for(Object object0: this.zziw) {
            if(dataHolder0.isClosed() || !dataHolder0.hasColumn(((String)object0)) || dataHolder0.hasNull(((String)object0), v, v1)) {
                return false;
            }
            if(false) {
                break;
            }
        }
        return true;
    }

    protected abstract Object zzc(DataHolder arg1, int arg2, int arg3);
}

