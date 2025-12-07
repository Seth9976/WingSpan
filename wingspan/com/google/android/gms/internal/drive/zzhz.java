package com.google.android.gms.internal.drive;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.metadata.internal.zzl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class zzhz extends zzl {
    public zzhz(int v) {
        super("spaces", Arrays.asList(new String[]{"inDriveSpace", "isAppData", "inGooglePhotosSpace"}), Collections.emptySet(), 7000000);
    }

    @Override  // com.google.android.gms.drive.metadata.zzb
    protected final Object zzc(DataHolder dataHolder0, int v, int v1) {
        return this.zzd(dataHolder0, v, v1);
    }

    @Override  // com.google.android.gms.drive.metadata.zzb
    protected final Collection zzd(DataHolder dataHolder0, int v, int v1) {
        Collection collection0 = new ArrayList();
        if(dataHolder0.getBoolean("inDriveSpace", v, v1)) {
            ((List)collection0).add(DriveSpace.zzah);
        }
        if(dataHolder0.getBoolean("isAppData", v, v1)) {
            ((List)collection0).add(DriveSpace.zzai);
        }
        if(dataHolder0.getBoolean("inGooglePhotosSpace", v, v1)) {
            ((List)collection0).add(DriveSpace.zzaj);
        }
        return collection0;
    }
}

