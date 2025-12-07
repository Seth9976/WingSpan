package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.zzb;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONException;

public final class zzs extends zzb {
    public zzs(String s, int v) {
        super(s, Collections.singleton(s), Collections.emptySet(), 4300000);
    }

    @Override  // com.google.android.gms.drive.metadata.zza
    protected final void zza(Bundle bundle0, Object object0) {
        bundle0.putStringArrayList(this.getName(), new ArrayList(((Collection)object0)));
    }

    @Override  // com.google.android.gms.drive.metadata.zza
    protected final Object zzb(Bundle bundle0) {
        return bundle0.getStringArrayList(this.getName());
    }

    @Override  // com.google.android.gms.drive.metadata.zzb
    protected final Object zzc(DataHolder dataHolder0, int v, int v1) {
        return this.zzd(dataHolder0, v, v1);
    }

    @Override  // com.google.android.gms.drive.metadata.zzb
    protected final Collection zzd(DataHolder dataHolder0, int v, int v1) {
        try {
            String s = dataHolder0.getString(this.getName(), v, v1);
            if(s == null) {
                return null;
            }
            ArrayList arrayList0 = new ArrayList();
            JSONArray jSONArray0 = new JSONArray(s);
            for(int v2 = 0; v2 < jSONArray0.length(); ++v2) {
                arrayList0.add(jSONArray0.getString(v2));
            }
            return Collections.unmodifiableCollection(arrayList0);
        }
        catch(JSONException jSONException0) {
            throw new IllegalStateException("DataHolder supplied invalid JSON", jSONException0);
        }
    }
}

