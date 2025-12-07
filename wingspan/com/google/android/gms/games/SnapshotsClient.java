package com.google.android.gms.games;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.tasks.Task;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface SnapshotsClient {
    public static final class DataOrConflict {
        private final Object zza;
        private final SnapshotConflict zzb;

        public DataOrConflict(Object object0, SnapshotConflict snapshotsClient$SnapshotConflict0) {
            this.zza = object0;
            this.zzb = snapshotsClient$SnapshotConflict0;
        }

        public SnapshotConflict getConflict() {
            if(!this.isConflict()) {
                throw new IllegalStateException("getConflict called when there is no conflict.");
            }
            return this.zzb;
        }

        public Object getData() {
            if(this.isConflict()) {
                throw new IllegalStateException("getData called when there is a conflict.");
            }
            return this.zza;
        }

        public boolean isConflict() {
            return this.zzb != null;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ResolutionPolicy {
    }

    public static final class SnapshotConflict {
        private final Snapshot zza;
        private final String zzb;
        private final Snapshot zzc;
        private final SnapshotContents zzd;

        public SnapshotConflict(Snapshot snapshot0, String s, Snapshot snapshot1, SnapshotContents snapshotContents0) {
            this.zza = snapshot0;
            this.zzb = s;
            this.zzc = snapshot1;
            this.zzd = snapshotContents0;
        }

        public String getConflictId() {
            return this.zzb;
        }

        public Snapshot getConflictingSnapshot() {
            return this.zzc;
        }

        public SnapshotContents getResolutionSnapshotContents() {
            return this.zzd;
        }

        public Snapshot getSnapshot() {
            return this.zza;
        }
    }

    public static final class SnapshotContentUnavailableApiException extends ApiException {
        protected final SnapshotMetadata metadata;

        public SnapshotContentUnavailableApiException(Status status0, SnapshotMetadata snapshotMetadata0) {
            super(status0);
            this.metadata = snapshotMetadata0;
        }

        public SnapshotMetadata getSnapshotMetadata() {
            return this.metadata;
        }
    }

    public static final int DISPLAY_LIMIT_NONE = -1;
    public static final String EXTRA_SNAPSHOT_METADATA = "com.google.android.gms.games.SNAPSHOT_METADATA";
    public static final String EXTRA_SNAPSHOT_NEW = "com.google.android.gms.games.SNAPSHOT_NEW";
    public static final int RESOLUTION_POLICY_HIGHEST_PROGRESS = 4;
    public static final int RESOLUTION_POLICY_LAST_KNOWN_GOOD = 2;
    public static final int RESOLUTION_POLICY_LONGEST_PLAYTIME = 1;
    public static final int RESOLUTION_POLICY_MANUAL = -1;
    public static final int RESOLUTION_POLICY_MOST_RECENTLY_MODIFIED = 3;

    Task commitAndClose(Snapshot arg1, SnapshotMetadataChange arg2);

    Task delete(SnapshotMetadata arg1);

    Task discardAndClose(Snapshot arg1);

    Task getMaxCoverImageSize();

    Task getMaxDataSize();

    Task getSelectSnapshotIntent(String arg1, boolean arg2, boolean arg3, int arg4);

    Task load(boolean arg1);

    Task open(SnapshotMetadata arg1);

    Task open(SnapshotMetadata arg1, int arg2);

    Task open(String arg1, boolean arg2);

    Task open(String arg1, boolean arg2, int arg3);

    Task resolveConflict(String arg1, Snapshot arg2);

    Task resolveConflict(String arg1, String arg2, SnapshotMetadataChange arg3, SnapshotContents arg4);
}

