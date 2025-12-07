package com.google.android.gms.internal.nearby;

import android.util.Log;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class zzff {
    private final ExecutorService zzdo;
    private volatile InputStream zzdp;
    private volatile boolean zzdq;

    public zzff() {
        this.zzdo = Executors.newSingleThreadExecutor();
        this.zzdp = null;
        this.zzdq = false;
    }

    final void shutdown() {
        this.zzdq = true;
        this.zzdo.shutdownNow();
        IOUtils.closeQuietly(this.zzdp);
    }

    static void zza(zzff zzff0, OutputStream outputStream0, boolean z, long v) {
        zzff.zza(outputStream0, z, v);
    }

    private static void zza(OutputStream outputStream0, boolean z, long v) {
        try {
            outputStream0.write((z ? 1 : 0));
        }
        catch(IOException iOException0) {
            Log.w("NearbyConnections", String.format("Unable to deliver status for Payload %d", v), iOException0);
        }
        finally {
            IOUtils.closeQuietly(outputStream0);
        }
    }

    final void zza(InputStream inputStream0, OutputStream outputStream0, OutputStream outputStream1, long v) {
        zzfg zzfg0 = new zzfg(this, inputStream0, outputStream0, v, outputStream1);
        this.zzdo.execute(zzfg0);
    }
}

