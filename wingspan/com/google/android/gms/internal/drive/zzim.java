package com.google.android.gms.internal.drive;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.zzm;
import java.util.Arrays;

public final class zzim extends zzm {
    public static final zzim zzlj;

    static {
        zzim.zzlj = new zzim();
    }

    private zzim() {
        super("driveId", Arrays.asList(new String[]{"sqlId", "resourceId", "mimeType"}), Arrays.asList(new String[]{"dbInstanceId"}), 4100000);
    }

    @Override  // com.google.android.gms.drive.metadata.zza
    protected final boolean zzb(DataHolder dataHolder0, int v, int v1) {
        for(Object object0: this.zzaz()) {
            if(!dataHolder0.hasColumn(((String)object0))) {
                return false;
            }
            if(false) {
                break;
            }
        }
        return true;
    }

    @Override  // com.google.android.gms.drive.metadata.zza
    protected final Object zzc(DataHolder dataHolder0, int v, int v1) {
        long v2 = dataHolder0.getMetadata().getLong("dbInstanceId");
        boolean z = "application/vnd.google-apps.folder".equals(dataHolder0.getString("mimeType", v, v1));
        String s = dataHolder0.getString("resourceId", v, v1);
        Long long0 = dataHolder0.getLong("sqlId", v, v1);
        return "generated-android-null".equals(s) ? new DriveId(null, ((long)long0), v2, ((int)z)) : new DriveId(s, ((long)long0), v2, ((int)z));
    }
}

