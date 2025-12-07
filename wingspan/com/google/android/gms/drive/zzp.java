package com.google.android.gms.drive;

public final class zzp extends Builder {
    private boolean zzat;

    public zzp() {
        this.zzat = true;
    }

    @Override  // com.google.android.gms.drive.ExecutionOptions$Builder
    public final ExecutionOptions build() {
        this.zzo();
        return new zzn(this.zzaq, this.zzar, this.zzas, this.zzat, null);
    }

    @Override  // com.google.android.gms.drive.ExecutionOptions$Builder
    public final Builder setConflictStrategy(int v) {
        super.setConflictStrategy(v);
        return this;
    }

    @Override  // com.google.android.gms.drive.ExecutionOptions$Builder
    public final Builder setNotifyOnCompletion(boolean z) {
        super.setNotifyOnCompletion(z);
        return this;
    }

    @Override  // com.google.android.gms.drive.ExecutionOptions$Builder
    public final Builder setTrackingTag(String s) {
        super.setTrackingTag(s);
        return this;
    }
}

