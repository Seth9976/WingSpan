package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.query.internal.zzf;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SortOrder extends AbstractSafeParcelable {
    public static class Builder {
        private final List zzlw;
        private boolean zzlx;

        public Builder() {
            this.zzlw = new ArrayList();
            this.zzlx = false;
        }

        public Builder addSortAscending(SortableMetadataField sortableMetadataField0) {
            zzf zzf0 = new zzf(sortableMetadataField0.getName(), true);
            this.zzlw.add(zzf0);
            return this;
        }

        public Builder addSortDescending(SortableMetadataField sortableMetadataField0) {
            zzf zzf0 = new zzf(sortableMetadataField0.getName(), false);
            this.zzlw.add(zzf0);
            return this;
        }

        public SortOrder build() {
            return new SortOrder(this.zzlw, false);
        }
    }

    public static final Parcelable.Creator CREATOR;
    private final List zzlw;
    private final boolean zzlx;

    static {
        SortOrder.CREATOR = new zzc();
    }

    SortOrder(List list0, boolean z) {
        this.zzlw = list0;
        this.zzlx = z;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "SortOrder[%s, %s]", TextUtils.join(",", this.zzlw), Boolean.valueOf(this.zzlx));
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeTypedList(parcel0, 1, this.zzlw, false);
        SafeParcelWriter.writeBoolean(parcel0, 2, this.zzlx);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

