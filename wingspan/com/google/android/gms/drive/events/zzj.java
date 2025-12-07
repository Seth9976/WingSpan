package com.google.android.gms.drive.events;

import com.google.android.gms.drive.DriveId;

public final class zzj {
    public static boolean zza(int v, DriveId driveId0) {
        switch(v) {
            case 4: 
            case 7: {
                return driveId0 == null;
            }
            case 1: 
            case 8: {
                return driveId0 != null;
            }
            default: {
                return false;
            }
        }
    }
}

