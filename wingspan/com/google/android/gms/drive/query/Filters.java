package com.google.android.gms.drive.query;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties.zza;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.query.internal.zzb;
import com.google.android.gms.drive.query.internal.zzd;
import com.google.android.gms.drive.query.internal.zzn;
import com.google.android.gms.drive.query.internal.zzp;
import com.google.android.gms.drive.query.internal.zzr;
import com.google.android.gms.drive.query.internal.zzv;
import com.google.android.gms.drive.query.internal.zzx;
import com.google.android.gms.drive.query.internal.zzz;

public class Filters {
    public static Filter and(Filter filter0, Filter[] arr_filter) {
        Preconditions.checkNotNull(filter0, "Filter may not be null.");
        Preconditions.checkNotNull(arr_filter, "Additional filters may not be null.");
        return new zzr(zzx.zzmv, filter0, arr_filter);
    }

    public static Filter and(Iterable iterable0) {
        Preconditions.checkNotNull(iterable0, "Filters may not be null");
        return new zzr(zzx.zzmv, iterable0);
    }

    public static Filter contains(SearchableMetadataField searchableMetadataField0, String s) {
        Preconditions.checkNotNull(searchableMetadataField0, "Field may not be null.");
        Preconditions.checkNotNull(s, "Value may not be null.");
        return new zzb(zzx.zzmy, searchableMetadataField0, s);
    }

    public static Filter eq(CustomPropertyKey customPropertyKey0, String s) {
        Preconditions.checkNotNull(customPropertyKey0, "Custom property key may not be null.");
        Preconditions.checkNotNull(s, "Custom property value may not be null.");
        AppVisibleCustomProperties appVisibleCustomProperties0 = new zza().zza(customPropertyKey0, s).zzbb();
        return new zzn(SearchableField.zzlv, appVisibleCustomProperties0);
    }

    public static Filter eq(SearchableMetadataField searchableMetadataField0, Object object0) {
        Preconditions.checkNotNull(searchableMetadataField0, "Field may not be null.");
        Preconditions.checkNotNull(object0, "Value may not be null.");
        return new zzb(zzx.zzmq, searchableMetadataField0, object0);
    }

    public static Filter greaterThan(SearchableOrderedMetadataField searchableOrderedMetadataField0, Comparable comparable0) {
        Preconditions.checkNotNull(searchableOrderedMetadataField0, "Field may not be null.");
        Preconditions.checkNotNull(comparable0, "Value may not be null.");
        return new zzb(zzx.zzmt, searchableOrderedMetadataField0, comparable0);
    }

    public static Filter greaterThanEquals(SearchableOrderedMetadataField searchableOrderedMetadataField0, Comparable comparable0) {
        Preconditions.checkNotNull(searchableOrderedMetadataField0, "Field may not be null.");
        Preconditions.checkNotNull(comparable0, "Value may not be null.");
        return new zzb(zzx.zzmu, searchableOrderedMetadataField0, comparable0);
    }

    public static Filter in(SearchableCollectionMetadataField searchableCollectionMetadataField0, Object object0) {
        Preconditions.checkNotNull(searchableCollectionMetadataField0, "Field may not be null.");
        Preconditions.checkNotNull(object0, "Value may not be null.");
        return new zzp(searchableCollectionMetadataField0, object0);
    }

    public static Filter lessThan(SearchableOrderedMetadataField searchableOrderedMetadataField0, Comparable comparable0) {
        Preconditions.checkNotNull(searchableOrderedMetadataField0, "Field may not be null.");
        Preconditions.checkNotNull(comparable0, "Value may not be null.");
        return new zzb(zzx.zzmr, searchableOrderedMetadataField0, comparable0);
    }

    public static Filter lessThanEquals(SearchableOrderedMetadataField searchableOrderedMetadataField0, Comparable comparable0) {
        Preconditions.checkNotNull(searchableOrderedMetadataField0, "Field may not be null.");
        Preconditions.checkNotNull(comparable0, "Value may not be null.");
        return new zzb(zzx.zzms, searchableOrderedMetadataField0, comparable0);
    }

    public static Filter not(Filter filter0) {
        Preconditions.checkNotNull(filter0, "Filter may not be null");
        return new zzv(filter0);
    }

    public static Filter openedByMe() {
        return new zzd(SearchableField.LAST_VIEWED_BY_ME);
    }

    public static Filter or(Filter filter0, Filter[] arr_filter) {
        Preconditions.checkNotNull(filter0, "Filter may not be null.");
        Preconditions.checkNotNull(arr_filter, "Additional filters may not be null.");
        return new zzr(zzx.zzmw, filter0, arr_filter);
    }

    public static Filter or(Iterable iterable0) {
        Preconditions.checkNotNull(iterable0, "Filters may not be null");
        return new zzr(zzx.zzmw, iterable0);
    }

    public static Filter ownedByMe() {
        return new zzz();
    }

    public static Filter sharedWithMe() {
        return new zzd(SearchableField.zzlu);
    }
}

