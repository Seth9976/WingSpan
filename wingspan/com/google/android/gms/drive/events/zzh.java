package com.google.android.gms.drive.events;

import android.os.Looper;
import java.util.concurrent.CountDownLatch;

final class zzh extends Thread {
    private final CountDownLatch zzcn;
    private final DriveEventService zzco;

    zzh(DriveEventService driveEventService0, CountDownLatch countDownLatch0) {
        this.zzco = driveEventService0;
        this.zzcn = countDownLatch0;
        super();
    }

    @Override
    public final void run() {
        try {
            Looper.prepare();
            this.zzco.zzck = new zza(this.zzco, null);
            this.zzco.zzcl = false;
            this.zzcn.countDown();
            Looper.loop();
        }
        catch(Throwable throwable0) {
            if(this.zzco.zzcj != null) {
                this.zzco.zzcj.countDown();
            }
            throw throwable0;
        }
        if(this.zzco.zzcj != null) {
            this.zzco.zzcj.countDown();
        }
    }
}

