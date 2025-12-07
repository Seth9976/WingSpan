package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.UserMetadata;
import java.util.Arrays;
import java.util.Collections;

public final class zzu extends zzm {
    public zzu(String s, int v) {
        super(s, Arrays.asList(new String[]{zzu.zza(s, "permissionId"), zzu.zza(s, "displayName"), zzu.zza(s, "picture"), zzu.zza(s, "isAuthenticatedUser"), zzu.zza(s, "emailAddress")}), Collections.emptyList(), 6000000);
    }

    private static String zza(String s, String s1) [...] // Inlined contents

    // 去混淆评级： 低(20)
    @Override  // com.google.android.gms.drive.metadata.zza
    protected final boolean zzb(DataHolder dataHolder0, int v, int v1) {
        return dataHolder0.hasColumn(this.zzh("permissionId")) && !dataHolder0.hasNull(this.zzh("permissionId"), v, v1);
    }

    @Override  // com.google.android.gms.drive.metadata.zza
    protected final Object zzc(DataHolder dataHolder0, int v, int v1) {
        String s = dataHolder0.getString(this.zzh("permissionId"), v, v1);
        return s != null ? new UserMetadata(s, dataHolder0.getString(this.zzh("displayName"), v, v1), dataHolder0.getString(this.zzh("picture"), v, v1), dataHolder0.getBoolean(this.zzh("isAuthenticatedUser"), v, v1), dataHolder0.getString(this.zzh("emailAddress"), v, v1)) : null;
    }

    private final String zzh(String s) {
        return this.getName() + "." + s;
    }
}

