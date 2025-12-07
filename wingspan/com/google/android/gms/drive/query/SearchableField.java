package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.internal.drive.zzhs;
import com.google.android.gms.internal.drive.zzif;

public class SearchableField {
    public static final SearchableMetadataField IS_PINNED;
    public static final SearchableOrderedMetadataField LAST_VIEWED_BY_ME;
    public static final SearchableMetadataField MIME_TYPE;
    public static final SearchableOrderedMetadataField MODIFIED_DATE;
    public static final SearchableCollectionMetadataField PARENTS;
    public static final SearchableMetadataField STARRED;
    public static final SearchableMetadataField TITLE;
    public static final SearchableMetadataField TRASHED;
    public static final SearchableOrderedMetadataField zzlu;
    public static final SearchableMetadataField zzlv;

    static {
        SearchableField.TITLE = zzhs.zzkr;
        SearchableField.MIME_TYPE = zzhs.zzki;
        SearchableField.TRASHED = zzhs.zzks;
        SearchableField.PARENTS = zzhs.zzkn;
        SearchableField.zzlu = zzif.zzlh;
        SearchableField.STARRED = zzhs.zzkp;
        SearchableField.MODIFIED_DATE = zzif.zzlf;
        SearchableField.LAST_VIEWED_BY_ME = zzif.zzle;
        SearchableField.IS_PINNED = zzhs.zzka;
        SearchableField.zzlv = zzhs.zzjn;
    }
}

