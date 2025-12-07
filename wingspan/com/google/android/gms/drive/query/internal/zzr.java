package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.query.Filter;
import java.util.ArrayList;
import java.util.List;

public final class zzr extends zza {
    public static final Parcelable.Creator CREATOR;
    private List zzls;
    private final zzx zzlz;
    private final List zzmo;

    static {
        zzr.CREATOR = new zzs();
    }

    public zzr(zzx zzx0, Filter filter0, Filter[] arr_filter) {
        this.zzlz = zzx0;
        ArrayList arrayList0 = new ArrayList(arr_filter.length + 1);
        this.zzmo = arrayList0;
        arrayList0.add(new FilterHolder(filter0));
        ArrayList arrayList1 = new ArrayList(arr_filter.length + 1);
        this.zzls = arrayList1;
        arrayList1.add(filter0);
        for(int v = 0; v < arr_filter.length; ++v) {
            Filter filter1 = arr_filter[v];
            FilterHolder filterHolder0 = new FilterHolder(filter1);
            this.zzmo.add(filterHolder0);
            this.zzls.add(filter1);
        }
    }

    public zzr(zzx zzx0, Iterable iterable0) {
        this.zzlz = zzx0;
        this.zzls = new ArrayList();
        this.zzmo = new ArrayList();
        for(Object object0: iterable0) {
            this.zzls.add(((Filter)object0));
            FilterHolder filterHolder0 = new FilterHolder(((Filter)object0));
            this.zzmo.add(filterHolder0);
        }
    }

    zzr(zzx zzx0, List list0) {
        this.zzlz = zzx0;
        this.zzmo = list0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 1, this.zzlz, v, false);
        SafeParcelWriter.writeTypedList(parcel0, 2, this.zzmo, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    @Override  // com.google.android.gms.drive.query.Filter
    public final Object zza(zzj zzj0) {
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: this.zzmo) {
            arrayList0.add(((FilterHolder)object0).getFilter().zza(zzj0));
        }
        return zzj0.zza(this.zzlz, arrayList0);
    }
}

