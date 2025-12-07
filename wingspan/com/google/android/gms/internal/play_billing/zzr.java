package com.google.android.gms.internal.play_billing;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzr extends zzw implements zzs {
    public static zzs zzu(IBinder iBinder0) {
        if(iBinder0 == null) {
            return null;
        }
        IInterface iInterface0 = iBinder0.queryLocalInterface("com.android.vending.billing.IInAppBillingService");
        return iInterface0 instanceof zzs ? ((zzs)iInterface0) : new zzq(iBinder0);
    }
}

