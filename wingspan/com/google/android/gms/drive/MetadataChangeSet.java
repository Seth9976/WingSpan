package com.google.android.gms.drive;

import android.graphics.Bitmap;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties.zza;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.drive.zzhs;
import com.google.android.gms.internal.drive.zzif;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public final class MetadataChangeSet {
    public static class Builder {
        private final MetadataBundle zzay;
        private zza zzaz;

        public Builder() {
            this.zzay = MetadataBundle.zzbe();
        }

        public MetadataChangeSet build() {
            if(this.zzaz != null) {
                AppVisibleCustomProperties appVisibleCustomProperties0 = this.zzaz.zzbb();
                this.zzay.zzb(zzhs.zzjn, appVisibleCustomProperties0);
            }
            return new MetadataChangeSet(this.zzay);
        }

        public Builder deleteCustomProperty(CustomPropertyKey customPropertyKey0) {
            Preconditions.checkNotNull(customPropertyKey0, "key");
            this.zzr().zza(customPropertyKey0, null);
            return this;
        }

        public Builder setCustomProperty(CustomPropertyKey customPropertyKey0, String s) {
            Preconditions.checkNotNull(customPropertyKey0, "key");
            Preconditions.checkNotNull(s, "value");
            Builder.zza("The total size of key string and value string of a custom property", 0x7C, Builder.zzb(customPropertyKey0.getKey()) + Builder.zzb(s));
            this.zzr().zza(customPropertyKey0, s);
            return this;
        }

        public Builder setDescription(String s) {
            this.zzay.zzb(zzhs.zzjo, s);
            return this;
        }

        public Builder setIndexableText(String s) {
            Builder.zza("Indexable text size", 0x20000, Builder.zzb(s));
            this.zzay.zzb(zzhs.zzju, s);
            return this;
        }

        public Builder setLastViewedByMeDate(Date date0) {
            this.zzay.zzb(zzif.zzle, date0);
            return this;
        }

        public Builder setMimeType(String s) {
            Preconditions.checkNotNull(s);
            this.zzay.zzb(zzhs.zzki, s);
            return this;
        }

        public Builder setPinned(boolean z) {
            this.zzay.zzb(zzhs.zzka, Boolean.valueOf(z));
            return this;
        }

        public Builder setStarred(boolean z) {
            this.zzay.zzb(zzhs.zzkp, Boolean.valueOf(z));
            return this;
        }

        public Builder setTitle(String s) {
            Preconditions.checkNotNull(s, "Title cannot be null.");
            this.zzay.zzb(zzhs.zzkr, s);
            return this;
        }

        public Builder setViewed() {
            this.zzay.zzb(zzhs.zzkh, Boolean.TRUE);
            return this;
        }

        @Deprecated
        public Builder setViewed(boolean z) {
            if(z) {
                this.zzay.zzb(zzhs.zzkh, Boolean.TRUE);
                return this;
            }
            if(this.zzay.zzd(zzhs.zzkh)) {
                this.zzay.zzc(zzhs.zzkh);
            }
            return this;
        }

        private static void zza(String s, int v, int v1) {
            Preconditions.checkArgument(v1 <= v, String.format(Locale.US, "%s must be no more than %d bytes, but is %d bytes.", s, v, v1));
        }

        private static int zzb(String s) {
            return s == null ? 0 : s.getBytes().length;
        }

        private final zza zzr() {
            if(this.zzaz == null) {
                this.zzaz = new zza();
            }
            return this.zzaz;
        }
    }

    public static final int CUSTOM_PROPERTY_SIZE_LIMIT_BYTES = 0x7C;
    public static final int INDEXABLE_TEXT_SIZE_LIMIT_BYTES = 0x20000;
    public static final int MAX_PRIVATE_PROPERTIES_PER_RESOURCE_PER_APP = 30;
    public static final int MAX_PUBLIC_PROPERTIES_PER_RESOURCE = 30;
    public static final int MAX_TOTAL_PROPERTIES_PER_RESOURCE = 100;
    public static final MetadataChangeSet zzax;
    private final MetadataBundle zzay;

    static {
        MetadataChangeSet.zzax = new MetadataChangeSet(MetadataBundle.zzbe());
    }

    public MetadataChangeSet(MetadataBundle metadataBundle0) {
        this.zzay = metadataBundle0.zzbf();
    }

    public final Map getCustomPropertyChangeMap() {
        AppVisibleCustomProperties appVisibleCustomProperties0 = (AppVisibleCustomProperties)this.zzay.zza(zzhs.zzjn);
        return appVisibleCustomProperties0 == null ? Collections.emptyMap() : appVisibleCustomProperties0.zzba();
    }

    public final String getDescription() {
        return (String)this.zzay.zza(zzhs.zzjo);
    }

    public final String getIndexableText() {
        return (String)this.zzay.zza(zzhs.zzju);
    }

    public final Date getLastViewedByMeDate() {
        return (Date)this.zzay.zza(zzif.zzle);
    }

    public final String getMimeType() {
        return (String)this.zzay.zza(zzhs.zzki);
    }

    public final Bitmap getThumbnail() {
        BitmapTeleporter bitmapTeleporter0 = (BitmapTeleporter)this.zzay.zza(zzhs.zzkq);
        return bitmapTeleporter0 == null ? null : bitmapTeleporter0.get();
    }

    public final String getTitle() {
        return (String)this.zzay.zza(zzhs.zzkr);
    }

    public final Boolean isPinned() {
        return (Boolean)this.zzay.zza(zzhs.zzka);
    }

    public final Boolean isStarred() {
        return (Boolean)this.zzay.zza(zzhs.zzkp);
    }

    public final Boolean isViewed() {
        return (Boolean)this.zzay.zza(zzhs.zzkh);
    }

    public final MetadataBundle zzq() {
        return this.zzay;
    }
}

