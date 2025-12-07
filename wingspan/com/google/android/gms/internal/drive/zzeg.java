package com.google.android.gms.internal.drive;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.CompletionListener;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.zzb;
import com.google.android.gms.drive.events.zzd;
import com.google.android.gms.drive.events.zzi;
import com.google.android.gms.drive.events.zzl;
import com.google.android.gms.drive.events.zzo;
import com.google.android.gms.drive.events.zzq;
import com.google.android.gms.drive.events.zzr;

final class zzeg extends zzir {
    private final Context zzgw;

    private zzeg(Looper looper0, Context context0) {
        super(looper0);
        this.zzgw = context0;
    }

    zzeg(Looper looper0, Context context0, zzef zzef0) {
        this(looper0, context0);
    }

    @Override  // android.os.Handler
    public final void handleMessage(Message message0) {
        if(message0.what != 1) {
            zzee.zzbz.efmt("EventCallback", "Don\'t know how to handle this event in context %s", new Object[]{this.zzgw});
            return;
        }
        Pair pair0 = (Pair)message0.obj;
        zzi zzi0 = (zzi)pair0.first;
        DriveEvent driveEvent0 = (DriveEvent)pair0.second;
        switch(driveEvent0.getType()) {
            case 1: {
                ((ChangeListener)zzi0).onChange(((ChangeEvent)driveEvent0));
                return;
            }
            case 2: {
                ((CompletionListener)zzi0).onCompletion(((CompletionEvent)driveEvent0));
                return;
            }
            case 3: {
                DataHolder dataHolder0 = ((zzo)driveEvent0).zzz();
                if(dataHolder0 != null) {
                    ((zzq)zzi0).zza(new zzeh(new MetadataBuffer(dataHolder0)));
                }
                if(((zzo)driveEvent0).zzaa()) {
                    ((zzq)zzi0).zzc(((zzo)driveEvent0).zzab());
                }
                return;
            }
            case 4: {
                ((zzd)zzi0).zza(((zzb)driveEvent0));
                return;
            }
            case 8: {
                ((zzl)zzi0).zza(new zze(((zzr)driveEvent0).zzac()));
                return;
            }
            default: {
                zzee.zzbz.wfmt("EventCallback", "Unexpected event: %s", new Object[]{driveEvent0});
            }
        }
    }
}

