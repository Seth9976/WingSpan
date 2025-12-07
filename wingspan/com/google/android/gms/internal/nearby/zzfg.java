package com.google.android.gms.internal.nearby;

import android.util.Log;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

final class zzfg implements Runnable {
    private final long zzcx;
    private final InputStream zzdr;
    private final OutputStream zzds;
    private final OutputStream zzdt;
    private final zzff zzdu;

    zzfg(zzff zzff0, InputStream inputStream0, OutputStream outputStream0, long v, OutputStream outputStream1) {
        this.zzdu = zzff0;
        this.zzdr = inputStream0;
        this.zzds = outputStream0;
        this.zzcx = v;
        this.zzdt = outputStream1;
        super();
    }

    @Override
    public final void run() {
        this.zzdu.zzdp = this.zzdr;
        boolean z = false;
        try {
            IOUtils.copyStream(this.zzdr, this.zzds, false, 0x10000);
            goto label_22;
        }
        catch(IOException iOException0) {
            try {
                if(this.zzdu.zzdq) {
                    Log.d("NearbyConnections", String.format("Terminating copying stream for Payload %d due to shutdown of OutgoingPayloadStreamer.", this.zzcx));
                }
                else {
                    Log.w("NearbyConnections", String.format("Exception copying stream for Payload %d", this.zzcx), iOException0);
                }
            }
            catch(Throwable throwable0) {
                z = true;
                goto label_17;
            }
            IOUtils.closeQuietly(this.zzdr);
            zzff.zza(this.zzdu, this.zzdt, true, this.zzcx);
            IOUtils.closeQuietly(this.zzds);
            this.zzdu.zzdp = null;
            return;
        }
        catch(Throwable throwable0) {
        }
    label_17:
        IOUtils.closeQuietly(this.zzdr);
        zzff.zza(this.zzdu, this.zzdt, z, this.zzcx);
        IOUtils.closeQuietly(this.zzds);
        this.zzdu.zzdp = null;
        throw throwable0;
    label_22:
        IOUtils.closeQuietly(this.zzdr);
        zzff.zza(this.zzdu, this.zzdt, false, this.zzcx);
        IOUtils.closeQuietly(this.zzds);
        this.zzdu.zzdp = null;
    }
}

