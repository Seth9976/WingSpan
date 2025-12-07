package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public interface MetadataField {
    String getName();

    Object zza(Bundle arg1);

    Object zza(DataHolder arg1, int arg2, int arg3);

    void zza(DataHolder arg1, MetadataBundle arg2, int arg3, int arg4);

    void zza(Object arg1, Bundle arg2);
}

