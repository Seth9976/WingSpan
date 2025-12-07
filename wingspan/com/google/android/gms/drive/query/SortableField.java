package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.internal.drive.zzhs;
import com.google.android.gms.internal.drive.zzif;

public class SortableField {
    public static final SortableMetadataField CREATED_DATE;
    public static final SortableMetadataField LAST_VIEWED_BY_ME;
    public static final SortableMetadataField MODIFIED_BY_ME_DATE;
    public static final SortableMetadataField MODIFIED_DATE;
    public static final SortableMetadataField QUOTA_USED;
    public static final SortableMetadataField SHARED_WITH_ME_DATE;
    public static final SortableMetadataField TITLE;
    private static final SortableMetadataField zzly;

    static {
        SortableField.TITLE = zzhs.zzkr;
        SortableField.CREATED_DATE = zzif.zzld;
        SortableField.MODIFIED_DATE = zzif.zzlf;
        SortableField.MODIFIED_BY_ME_DATE = zzif.zzlg;
        SortableField.LAST_VIEWED_BY_ME = zzif.zzle;
        SortableField.SHARED_WITH_ME_DATE = zzif.zzlh;
        SortableField.QUOTA_USED = zzhs.zzko;
        SortableField.zzly = zzif.zzli;
    }
}

