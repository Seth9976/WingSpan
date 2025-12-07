package com.google.android.gms.games;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class GamesStatusUtils {
    public static void zza(TaskCompletionSource taskCompletionSource0, int v) {
        int v2;
        Status status0 = GamesStatusCodes.zza(v);
        int v1 = status0.getStatusCode();
        switch(v1) {
            case 1: {
                v2 = 8;
                break;
            }
            case 2: {
                v2 = 26502;
                break;
            }
            case 3: {
                v2 = 26503;
                break;
            }
            case 4: {
                v2 = 26504;
                break;
            }
            case 5: {
                v2 = 26505;
                break;
            }
            case 6: {
                v2 = 26506;
                break;
            }
            case 7: {
                v2 = 26507;
                break;
            }
            case 8: {
                v2 = 26508;
                break;
            }
            case 9: {
                v2 = 26509;
                break;
            }
            case 500: {
                v2 = 26520;
                break;
            }
            case 1000: {
                v2 = 26530;
                break;
            }
            case 1001: {
                v2 = 0x67A3;
                break;
            }
            case 1002: {
                v2 = 0x67A4;
                break;
            }
            case 1003: {
                v2 = 0x67A5;
                break;
            }
            case 1004: {
                v2 = 0x67A6;
                break;
            }
            case 1005: {
                v2 = 0x67A7;
                break;
            }
            case 1006: {
                v2 = 0x67A8;
                break;
            }
            case 1500: {
                v2 = 26540;
                break;
            }
            case 1501: {
                v2 = 0x67AD;
                break;
            }
            case 2000: {
                v2 = 26550;
                break;
            }
            case 2001: {
                v2 = 0x67B7;
                break;
            }
            case 2002: {
                v2 = 0x67B8;
                break;
            }
            case 3000: {
                v2 = 0x67C0;
                break;
            }
            case 3001: {
                v2 = 0x67C1;
                break;
            }
            case 3002: {
                v2 = 0x67C2;
                break;
            }
            case 3003: {
                v2 = 0x67C3;
                break;
            }
            case 4000: {
                v2 = 26570;
                break;
            }
            case 4001: {
                v2 = 0x67CB;
                break;
            }
            case 4002: {
                v2 = 0x67CC;
                break;
            }
            case 4003: {
                v2 = 0x67CD;
                break;
            }
            case 4004: {
                v2 = 0x67CE;
                break;
            }
            case 4005: {
                v2 = 0x67CF;
                break;
            }
            case 4006: {
                v2 = 0x67D0;
                break;
            }
            case 6000: {
                v2 = 26580;
                break;
            }
            case 6001: {
                v2 = 0x67D5;
                break;
            }
            case 6002: {
                v2 = 0x67D6;
                break;
            }
            case 6003: {
                v2 = 0x67D7;
                break;
            }
            case 6004: {
                v2 = 0x67D8;
                break;
            }
            case 6500: {
                v2 = 26590;
                break;
            }
            case 6501: {
                v2 = 0x67DF;
                break;
            }
            case 6502: {
                v2 = 0x67E0;
                break;
            }
            case 6503: {
                v2 = 0x67E1;
                break;
            }
            case 6504: {
                v2 = 0x67E2;
                break;
            }
            case 6505: {
                v2 = 0x67E3;
                break;
            }
            case 6506: {
                v2 = 0x67E4;
                break;
            }
            case 6507: {
                v2 = 0x67E5;
                break;
            }
            case 7000: {
                v2 = 26600;
                break;
            }
            case 7001: {
                v2 = 26601;
                break;
            }
            case 7002: {
                v2 = 26602;
                break;
            }
            case 7003: {
                v2 = 26603;
                break;
            }
            case 7004: {
                v2 = 26604;
                break;
            }
            case 7005: {
                v2 = 26605;
                break;
            }
            case 7006: {
                v2 = 26606;
                break;
            }
            case 7007: {
                v2 = 0x67EF;
                break;
            }
            case 8000: {
                v2 = 0x67F2;
                break;
            }
            case 8001: {
                v2 = 0x67F3;
                break;
            }
            case 8002: {
                v2 = 0x67F4;
                break;
            }
            case 8003: {
                v2 = 0x67F5;
                break;
            }
            case 9000: {
                v2 = 0x67FC;
                break;
            }
            case 9001: {
                v2 = 0x67FD;
                break;
            }
            case 9002: {
                v2 = 0x67FE;
                break;
            }
            case 9003: {
                v2 = 0x67FF;
                break;
            }
            case 9004: {
                v2 = 0x6800;
                break;
            }
            case 9006: {
                v2 = 0x6801;
                break;
            }
            case 9009: {
                v2 = 0x6802;
                break;
            }
            case 9010: {
                v2 = 0x6803;
                break;
            }
            case 9011: {
                v2 = 0x6804;
                break;
            }
            case 9012: {
                v2 = 0x6805;
                break;
            }
            case 9016: {
                v2 = 0x6806;
                break;
            }
            case 9017: {
                v2 = 0x6807;
                break;
            }
            case 9018: {
                v2 = 0x6808;
                break;
            }
            case 9200: {
                v2 = 26650;
                break;
            }
            case 9202: {
                v2 = 0x681C;
                break;
            }
            case 10000: {
                v2 = 26700;
                break;
            }
            case 10001: {
                v2 = 26701;
                break;
            }
            case 10002: {
                v2 = 26702;
                break;
            }
            case 10003: {
                v2 = 0x684F;
                break;
            }
            case 10004: {
                v2 = 0x6850;
                break;
            }
            default: {
                v2 = v1;
            }
        }
        if(v2 != status0.getStatusCode()) {
            if(GamesStatusCodes.getStatusString(status0.getStatusCode()).equals(status0.getStatusMessage())) {
                status0 = GamesClientStatusCodes.zzb(v2, status0.getResolution());
            }
            else {
                switch(v1) {
                    case 2: 
                    case 3: 
                    case 4: 
                    case 5: 
                    case 6: 
                    case 7: 
                    case 8: 
                    case 10: {
                        break;
                    }
                    default: {
                        status0 = new Status(v2, status0.getStatusMessage(), status0.getResolution());
                    }
                }
            }
        }
        taskCompletionSource0.setException(ApiExceptionUtil.fromStatus(status0));
    }

    public static void zzb(TaskCompletionSource taskCompletionSource0, SecurityException securityException0) {
        if(taskCompletionSource0 != null) {
            taskCompletionSource0.trySetException(new ApiException(GamesClientStatusCodes.zza(4)));
        }
    }
}

