package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.query.internal.zzr;
import com.google.android.gms.drive.query.internal.zzt;
import com.google.android.gms.drive.query.internal.zzx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class Query extends AbstractSafeParcelable {
    public static class Builder {
        private String zzln;
        private SortOrder zzlo;
        private List zzlp;
        private boolean zzlq;
        private boolean zzlr;
        private final List zzls;
        private Set zzlt;

        public Builder() {
            this.zzls = new ArrayList();
            this.zzlp = Collections.emptyList();
            this.zzlt = Collections.emptySet();
        }

        public Builder(Query query0) {
            ArrayList arrayList0 = new ArrayList();
            this.zzls = arrayList0;
            this.zzlp = Collections.emptyList();
            this.zzlt = Collections.emptySet();
            arrayList0.add(query0.getFilter());
            this.zzln = query0.getPageToken();
            this.zzlo = query0.getSortOrder();
            this.zzlp = query0.zzlp;
            this.zzlq = query0.zzlq;
            query0.zzbi();
            this.zzlt = query0.zzbi();
            this.zzlr = query0.zzlr;
        }

        public Builder addFilter(Filter filter0) {
            Preconditions.checkNotNull(filter0, "Filter may not be null.");
            if(!(filter0 instanceof zzt)) {
                this.zzls.add(filter0);
            }
            return this;
        }

        public Query build() {
            return new Query(new zzr(zzx.zzmv, this.zzls), this.zzln, this.zzlo, this.zzlp, this.zzlq, this.zzlt, this.zzlr, null);
        }

        @Deprecated
        public Builder setPageToken(String s) {
            this.zzln = s;
            return this;
        }

        public Builder setSortOrder(SortOrder sortOrder0) {
            this.zzlo = sortOrder0;
            return this;
        }
    }

    public static final Parcelable.Creator CREATOR;
    private final List zzby;
    private final zzr zzlm;
    private final String zzln;
    private final SortOrder zzlo;
    final List zzlp;
    final boolean zzlq;
    final boolean zzlr;

    static {
        Query.CREATOR = new zzb();
    }

    Query(zzr zzr0, String s, SortOrder sortOrder0, List list0, boolean z, List list1, boolean z1) {
        this.zzlm = zzr0;
        this.zzln = s;
        this.zzlo = sortOrder0;
        this.zzlp = list0;
        this.zzlq = z;
        this.zzby = list1;
        this.zzlr = z1;
    }

    private Query(zzr zzr0, String s, SortOrder sortOrder0, List list0, boolean z, Set set0, boolean z1) {
        this(zzr0, s, sortOrder0, list0, z, new ArrayList(set0), z1);
    }

    Query(zzr zzr0, String s, SortOrder sortOrder0, List list0, boolean z, Set set0, boolean z1, zza zza0) {
        this(zzr0, s, sortOrder0, list0, z, set0, z1);
    }

    public Filter getFilter() {
        return this.zzlm;
    }

    @Deprecated
    public String getPageToken() {
        return this.zzln;
    }

    public SortOrder getSortOrder() {
        return this.zzlo;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "Query[%s,%s,PageToken=%s,Spaces=%s]", this.zzlm, this.zzlo, this.zzln, this.zzby);
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 1, this.zzlm, v, false);
        SafeParcelWriter.writeString(parcel0, 3, this.zzln, false);
        SafeParcelWriter.writeParcelable(parcel0, 4, this.zzlo, v, false);
        SafeParcelWriter.writeStringList(parcel0, 5, this.zzlp, false);
        SafeParcelWriter.writeBoolean(parcel0, 6, this.zzlq);
        SafeParcelWriter.writeTypedList(parcel0, 7, this.zzby, false);
        SafeParcelWriter.writeBoolean(parcel0, 8, this.zzlr);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final Set zzbi() {
        return this.zzby == null ? new HashSet() : new HashSet(this.zzby);
    }
}

