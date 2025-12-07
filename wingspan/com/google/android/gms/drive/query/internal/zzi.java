package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Set;

final class zzi {
    static MetadataField zza(MetadataBundle metadataBundle0) {
        Set set0 = metadataBundle0.zzbg();
        if(set0.size() != 1) {
            throw new IllegalArgumentException("bundle should have exactly 1 populated field");
        }
        return set0.iterator().next();
    }
}

