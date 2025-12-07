package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.drive.metadata.zzb;
import java.util.ArrayList;
import java.util.Collection;

public class zzl extends zzb {
    public zzl(String s, Collection collection0, Collection collection1, int v) {
        super(s, collection0, collection1, v);
    }

    @Override  // com.google.android.gms.drive.metadata.zza
    protected final void zza(Bundle bundle0, Object object0) {
        bundle0.putParcelableArrayList(this.getName(), (((Collection)object0) instanceof ArrayList ? ((ArrayList)(((Collection)object0))) : new ArrayList(((Collection)object0))));
    }

    @Override  // com.google.android.gms.drive.metadata.zza
    protected Object zzb(Bundle bundle0) {
        return this.zzc(bundle0);
    }

    protected Collection zzc(Bundle bundle0) {
        return bundle0.getParcelableArrayList(this.getName());
    }
}

