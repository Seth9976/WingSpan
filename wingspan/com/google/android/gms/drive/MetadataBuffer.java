package com.google.android.gms.drive;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.metadata.internal.zzf;
import com.google.android.gms.internal.drive.zzaa;
import com.google.android.gms.internal.drive.zzhs;

public final class MetadataBuffer extends AbstractDataBuffer {
    static final class zza extends Metadata {
        private final int row;
        private final DataHolder zzav;
        private final int zzaw;

        public zza(DataHolder dataHolder0, int v) {
            this.zzav = dataHolder0;
            this.row = v;
            this.zzaw = dataHolder0.getWindowIndex(v);
        }

        @Override  // com.google.android.gms.common.data.Freezable
        public final Object freeze() {
            MetadataBundle metadataBundle0 = MetadataBundle.zzbe();
            for(Object object0: zzf.zzbc()) {
                MetadataField metadataField0 = (MetadataField)object0;
                if(metadataField0 != zzhs.zzkq) {
                    metadataField0.zza(this.zzav, metadataBundle0, this.row, this.zzaw);
                }
            }
            return new zzaa(metadataBundle0);
        }

        @Override  // com.google.android.gms.common.data.Freezable
        public final boolean isDataValid() {
            return !this.zzav.isClosed();
        }

        @Override  // com.google.android.gms.drive.Metadata
        public final Object zza(MetadataField metadataField0) {
            return metadataField0.zza(this.zzav, this.row, this.zzaw);
        }
    }

    private zza zzau;

    public MetadataBuffer(DataHolder dataHolder0) {
        super(dataHolder0);
        dataHolder0.getMetadata().setClassLoader(MetadataBuffer.class.getClassLoader());
    }

    public final Metadata get(int v) {
        zza metadataBuffer$zza0 = this.zzau;
        if(metadataBuffer$zza0 == null || metadataBuffer$zza0.row != v) {
            metadataBuffer$zza0 = new zza(this.mDataHolder, v);
            this.zzau = metadataBuffer$zza0;
        }
        return metadataBuffer$zza0;
    }

    @Override  // com.google.android.gms.common.data.AbstractDataBuffer
    public final Object get(int v) {
        return this.get(v);
    }

    @Deprecated
    public final String getNextPageToken() {
        return null;
    }

    @Override  // com.google.android.gms.common.data.AbstractDataBuffer
    public final void release() {
        if(this.mDataHolder != null) {
            zzf.zza(this.mDataHolder);
        }
        super.release();
    }
}

