package com.google.android.gms.drive;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.internal.drive.zzhs;
import com.google.android.gms.internal.drive.zzif;
import com.google.android.gms.internal.drive.zzin;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

public abstract class Metadata implements Freezable {
    public static final int CONTENT_AVAILABLE_LOCALLY = 1;
    public static final int CONTENT_NOT_AVAILABLE_LOCALLY;

    public String getAlternateLink() {
        return (String)this.zza(zzhs.zzjm);
    }

    public int getContentAvailability() {
        Integer integer0 = (Integer)this.zza(zzin.zzlk);
        return integer0 == null ? 0 : ((int)integer0);
    }

    public Date getCreatedDate() {
        return (Date)this.zza(zzif.zzld);
    }

    public Map getCustomProperties() {
        AppVisibleCustomProperties appVisibleCustomProperties0 = (AppVisibleCustomProperties)this.zza(zzhs.zzjn);
        return appVisibleCustomProperties0 == null ? Collections.emptyMap() : appVisibleCustomProperties0.zzba();
    }

    public String getDescription() {
        return (String)this.zza(zzhs.zzjo);
    }

    public DriveId getDriveId() {
        return (DriveId)this.zza(zzhs.zzjl);
    }

    public String getEmbedLink() {
        return (String)this.zza(zzhs.zzjp);
    }

    public String getFileExtension() {
        return (String)this.zza(zzhs.zzjq);
    }

    public long getFileSize() {
        return (long)(((Long)this.zza(zzhs.zzjr)));
    }

    public Date getLastViewedByMeDate() {
        return (Date)this.zza(zzif.zzle);
    }

    public String getMimeType() {
        return (String)this.zza(zzhs.zzki);
    }

    public Date getModifiedByMeDate() {
        return (Date)this.zza(zzif.zzlg);
    }

    public Date getModifiedDate() {
        return (Date)this.zza(zzif.zzlf);
    }

    public String getOriginalFilename() {
        return (String)this.zza(zzhs.zzkj);
    }

    public long getQuotaBytesUsed() {
        return (long)(((Long)this.zza(zzhs.zzko)));
    }

    public Date getSharedWithMeDate() {
        return (Date)this.zza(zzif.zzlh);
    }

    public String getTitle() {
        return (String)this.zza(zzhs.zzkr);
    }

    public String getWebContentLink() {
        return (String)this.zza(zzhs.zzkt);
    }

    public String getWebViewLink() {
        return (String)this.zza(zzhs.zzku);
    }

    public boolean isEditable() {
        Boolean boolean0 = (Boolean)this.zza(zzhs.zzjx);
        return boolean0 == null ? false : boolean0.booleanValue();
    }

    public boolean isExplicitlyTrashed() {
        Boolean boolean0 = (Boolean)this.zza(zzhs.zzjy);
        return boolean0 == null ? false : boolean0.booleanValue();
    }

    public boolean isFolder() {
        return "application/vnd.google-apps.folder".equals(this.getMimeType());
    }

    public boolean isInAppFolder() {
        Boolean boolean0 = (Boolean)this.zza(zzhs.zzjv);
        return boolean0 == null ? false : boolean0.booleanValue();
    }

    public boolean isPinnable() {
        Boolean boolean0 = (Boolean)this.zza(zzin.zzll);
        return boolean0 == null ? false : boolean0.booleanValue();
    }

    public boolean isPinned() {
        Boolean boolean0 = (Boolean)this.zza(zzhs.zzka);
        return boolean0 == null ? false : boolean0.booleanValue();
    }

    public boolean isRestricted() {
        Boolean boolean0 = (Boolean)this.zza(zzhs.zzkc);
        return boolean0 == null ? false : boolean0.booleanValue();
    }

    public boolean isShared() {
        Boolean boolean0 = (Boolean)this.zza(zzhs.zzkd);
        return boolean0 == null ? false : boolean0.booleanValue();
    }

    public boolean isStarred() {
        Boolean boolean0 = (Boolean)this.zza(zzhs.zzkp);
        return boolean0 == null ? false : boolean0.booleanValue();
    }

    public boolean isTrashable() {
        Boolean boolean0 = (Boolean)this.zza(zzhs.zzkg);
        return boolean0 == null || boolean0.booleanValue();
    }

    public boolean isTrashed() {
        Boolean boolean0 = (Boolean)this.zza(zzhs.zzks);
        return boolean0 == null ? false : boolean0.booleanValue();
    }

    public boolean isViewed() {
        Boolean boolean0 = (Boolean)this.zza(zzhs.zzkh);
        return boolean0 == null ? false : boolean0.booleanValue();
    }

    public abstract Object zza(MetadataField arg1);
}

