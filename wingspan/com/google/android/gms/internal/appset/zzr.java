package com.google.android.gms.internal.appset;

import android.content.Context;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

public final class zzr implements AppSetIdClient {
    private final AppSetIdClient zza;
    private final AppSetIdClient zzb;

    public zzr(Context context0) {
        this.zza = new zzp(context0, GoogleApiAvailabilityLight.getInstance());
        this.zzb = zzl.zzc(context0);
    }

    @Override  // com.google.android.gms.appset.AppSetIdClient
    public final Task getAppSetIdInfo() {
        return this.zza.getAppSetIdInfo().continueWithTask((Task task0) -> {
            if(!task0.isSuccessful() && !task0.isCanceled()) {
                Exception exception0 = task0.getException();
                if(exception0 instanceof ApiException) {
                    switch(((ApiException)exception0).getStatusCode()) {
                        case 15: {
                            return Tasks.forException(new Exception("The operation to get app set ID timed out. Please try again later."));
                        }
                        case 43000: {
                            return Tasks.forException(new Exception("Failed to get app set ID due to an internal error. Please try again later."));
                        }
                        case 17: 
                        case 43001: 
                        case 43002: 
                        case 43003: {
                            return this.zzb.getAppSetIdInfo();
                        }
                        default: {
                            return task0;
                        }
                    }
                }
            }
            return task0;
        });
    }

    // 检测为 Lambda 实现
    public static Task zza(zzr zzr0, Task task0) [...]
}

