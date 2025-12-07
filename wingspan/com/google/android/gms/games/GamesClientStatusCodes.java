package com.google.android.gms.games;

import android.app.PendingIntent;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Status;

public final class GamesClientStatusCodes extends CommonStatusCodes {
    public static final int ACHIEVEMENT_NOT_INCREMENTAL = 0x67C2;
    public static final int ACHIEVEMENT_UNKNOWN = 0x67C1;
    public static final int ACHIEVEMENT_UNLOCKED = 0x67C3;
    public static final int ACHIEVEMENT_UNLOCK_FAILURE = 0x67C0;
    public static final int APP_MISCONFIGURED = 26508;
    public static final int CONSENT_REQUIRED = 0x684F;
    public static final int GAME_NOT_FOUND = 26509;
    public static final int LICENSE_CHECK_FAILED = 26507;
    public static final int NETWORK_ERROR_NO_DATA = 26504;
    public static final int NETWORK_ERROR_OPERATION_FAILED = 26506;
    public static final int OPERATION_IN_FLIGHT = 0x67EF;
    public static final int SNAPSHOT_COMMIT_FAILED = 0x67CD;
    public static final int SNAPSHOT_CONFLICT_MISSING = 0x67D0;
    public static final int SNAPSHOT_CONTENTS_UNAVAILABLE = 0x67CC;
    public static final int SNAPSHOT_CREATION_FAILED = 0x67CB;
    public static final int SNAPSHOT_FOLDER_UNAVAILABLE = 0x67CF;
    public static final int SNAPSHOT_NOT_FOUND = 26570;
    public static final int VIDEO_ALREADY_CAPTURING = 0x6801;
    public static final int VIDEO_NOT_ACTIVE = 0x67FC;
    public static final int VIDEO_OUT_OF_DISK_SPACE = 0x6802;
    public static final int VIDEO_PERMISSION_ERROR = 0x67FE;
    public static final int VIDEO_STORAGE_ERROR = 0x67FF;
    public static final int VIDEO_UNEXPECTED_CAPTURE_ERROR = 0x6800;
    public static final int VIDEO_UNSUPPORTED = 0x67FD;

    @Override  // com.google.android.gms.common.api.CommonStatusCodes
    public static String getStatusCodeString(int v) [...] // 潜在的解密器

    // 去混淆评级： 低(20)
    public static Status zza(int v) {
        return new Status(4, "SIGN_IN_REQUIRED");
    }

    public static Status zzb(int v, PendingIntent pendingIntent0) {
        return new Status(v, GamesClientStatusCodes.getStatusCodeString(v), pendingIntent0);
    }
}

