package com.google.android.gms.internal.drive;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.zzi;
import java.util.ArrayList;
import java.util.List;

public final class zzee extends zzet {
    private static final GmsLogger zzbz;
    private final int zzda;
    private final zzi zzgt;
    private final zzeg zzgu;
    private final List zzgv;

    static {
        zzee.zzbz = new GmsLogger("EventCallback", "");
    }

    public zzee(Looper looper0, Context context0, int v, zzi zzi0) {
        this.zzgv = new ArrayList();
        this.zzda = 1;
        this.zzgt = zzi0;
        this.zzgu = new zzeg(looper0, context0, null);
    }

    @Override  // com.google.android.gms.internal.drive.zzes
    public final void zzc(zzfp zzfp0) throws RemoteException {
        DriveEvent driveEvent0 = zzfp0.zzat();
        int v = driveEvent0.getType();
        Preconditions.checkState(this.zzda == v);
        Integer integer0 = driveEvent0.getType();
        Preconditions.checkState(this.zzgv.contains(integer0));
        Pair pair0 = new Pair(this.zzgt, driveEvent0);
        Message message0 = this.zzgu.obtainMessage(1, pair0);
        this.zzgu.sendMessage(message0);
    }

    public final void zzf(int v) {
        this.zzgv.add(1);
    }

    public final boolean zzg(int v) {
        return this.zzgv.contains(1);
    }
}

