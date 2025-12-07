package com.google.android.gms.drive;

import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.internal.FilterHolder;
import java.util.List;

public final class OpenFileActivityOptions {
    public static class Builder {
        private final OpenFileActivityBuilder zzbf;

        public Builder() {
            this.zzbf = new OpenFileActivityBuilder();
        }

        public OpenFileActivityOptions build() {
            this.zzbf.zzg();
            return new OpenFileActivityOptions(this.zzbf.getTitle(), this.zzbf.zzs(), this.zzbf.zzt(), this.zzbf.zzu(), null);
        }

        public Builder setActivityStartFolder(DriveId driveId0) {
            this.zzbf.setActivityStartFolder(driveId0);
            return this;
        }

        public Builder setActivityTitle(String s) {
            this.zzbf.setActivityTitle(s);
            return this;
        }

        public Builder setMimeType(List list0) {
            String[] arr_s = (String[])list0.toArray(new String[0]);
            this.zzbf.setMimeType(arr_s);
            return this;
        }

        public Builder setSelectionFilter(Filter filter0) {
            this.zzbf.setSelectionFilter(filter0);
            return this;
        }
    }

    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    public final String zzba;
    public final String[] zzbb;
    public final DriveId zzbd;
    public final FilterHolder zzbe;

    private OpenFileActivityOptions(String s, String[] arr_s, Filter filter0, DriveId driveId0) {
        this.zzba = s;
        this.zzbb = arr_s;
        this.zzbe = filter0 == null ? null : new FilterHolder(filter0);
        this.zzbd = driveId0;
    }

    OpenFileActivityOptions(String s, String[] arr_s, Filter filter0, DriveId driveId0, zzq zzq0) {
        this(s, arr_s, filter0, driveId0);
    }
}

