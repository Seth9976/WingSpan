package com.google.android.gms.drive.events;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.internal.drive.zzet;
import com.google.android.gms.internal.drive.zzfp;
import com.google.android.gms.internal.drive.zzir;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class DriveEventService extends Service implements ChangeListener, CompletionListener, zzd, zzi {
    static final class zza extends zzir {
        private final WeakReference zzcp;

        private zza(DriveEventService driveEventService0) {
            this.zzcp = new WeakReference(driveEventService0);
        }

        zza(DriveEventService driveEventService0, zzh zzh0) {
            this(driveEventService0);
        }

        @Override  // android.os.Handler
        public final void handleMessage(Message message0) {
            switch(message0.what) {
                case 1: {
                    DriveEventService driveEventService0 = (DriveEventService)this.zzcp.get();
                    if(driveEventService0 != null) {
                        driveEventService0.zza(((zzfp)message0.obj));
                        return;
                    }
                    this.getLooper().quit();
                    return;
                }
                case 2: {
                    this.getLooper().quit();
                    return;
                }
                default: {
                    DriveEventService.zzbz.wfmt("DriveEventService", "Unexpected message type: %s", new Object[]{message0.what});
                }
            }
        }

        private final Message zzb(zzfp zzfp0) {
            return this.obtainMessage(1, zzfp0);
        }

        private final Message zzy() {
            return this.obtainMessage(2);
        }
    }

    final class zzb extends zzet {
        private final DriveEventService zzco;

        private zzb() {
        }

        zzb(zzh zzh0) {
        }

        @Override  // com.google.android.gms.internal.drive.zzes
        public final void zzc(zzfp zzfp0) throws RemoteException {
            synchronized(DriveEventService.this) {
                DriveEventService.this.zzw();
                if(DriveEventService.this.zzck == null) {
                    DriveEventService.zzbz.e("DriveEventService", "Receiving event before initialize is completed.");
                }
                else {
                    Message message0 = DriveEventService.this.zzck.zzb(zzfp0);
                    DriveEventService.this.zzck.sendMessage(message0);
                }
            }
        }
    }

    public static final String ACTION_HANDLE_EVENT = "com.google.android.gms.drive.events.HANDLE_EVENT";
    private final String name;
    private static final GmsLogger zzbz;
    private CountDownLatch zzcj;
    zza zzck;
    boolean zzcl;
    private int zzcm;

    static {
        DriveEventService.zzbz = new GmsLogger("DriveEventService", "");
    }

    protected DriveEventService() {
        this("DriveEventService");
    }

    protected DriveEventService(String s) {
        this.zzcl = false;
        this.zzcm = -1;
        this.name = s;
    }

    protected int getCallingUid() {
        return Binder.getCallingUid();
    }

    @Override  // android.app.Service
    public final IBinder onBind(Intent intent0) {
        synchronized(this) {
            if("com.google.android.gms.drive.events.HANDLE_EVENT".equals(intent0.getAction())) {
                if(this.zzck == null && !this.zzcl) {
                    this.zzcl = true;
                    CountDownLatch countDownLatch0 = new CountDownLatch(1);
                    this.zzcj = new CountDownLatch(1);
                    new zzh(this, countDownLatch0).start();
                    try {
                        if(!countDownLatch0.await(5000L, TimeUnit.MILLISECONDS)) {
                            DriveEventService.zzbz.e("DriveEventService", "Failed to synchronously initialize event handler.");
                        }
                    }
                    catch(InterruptedException interruptedException0) {
                        throw new RuntimeException("Unable to start event handler", interruptedException0);
                    }
                }
                return new zzb(this, null).asBinder();
            }
            return null;
        }
    }

    @Override  // com.google.android.gms.drive.events.ChangeListener
    public void onChange(ChangeEvent changeEvent0) {
        DriveEventService.zzbz.wfmt("DriveEventService", "Unhandled change event in %s: %s", new Object[]{this.name, changeEvent0});
    }

    @Override  // com.google.android.gms.drive.events.CompletionListener
    public void onCompletion(CompletionEvent completionEvent0) {
        DriveEventService.zzbz.wfmt("DriveEventService", "Unhandled completion event in %s: %s", new Object[]{this.name, completionEvent0});
    }

    @Override  // android.app.Service
    public void onDestroy() {
        synchronized(this) {
            zza driveEventService$zza0 = this.zzck;
            if(driveEventService$zza0 != null) {
                Message message0 = driveEventService$zza0.zzy();
                this.zzck.sendMessage(message0);
                this.zzck = null;
                try {
                    if(!this.zzcj.await(5000L, TimeUnit.MILLISECONDS)) {
                        DriveEventService.zzbz.w("DriveEventService", "Failed to synchronously quit event handler. Will quit itself");
                    }
                label_9:
                    this.zzcj = null;
                }
                catch(InterruptedException unused_ex) {
                    goto label_9;
                }
            }
            super.onDestroy();
        }
    }

    @Override  // android.app.Service
    public boolean onUnbind(Intent intent0) {
        return true;
    }

    private final void zza(zzfp zzfp0) {
        DriveEvent driveEvent0 = zzfp0.zzat();
        try {
            switch(driveEvent0.getType()) {
                case 1: {
                    this.onChange(((ChangeEvent)driveEvent0));
                    return;
                }
                case 2: {
                    this.onCompletion(((CompletionEvent)driveEvent0));
                    return;
                }
                case 4: {
                    this.zza(((com.google.android.gms.drive.events.zzb)driveEvent0));
                    return;
                }
                case 7: {
                    DriveEventService.zzbz.wfmt("DriveEventService", "Unhandled transfer state event in %s: %s", new Object[]{this.name, ((zzv)driveEvent0)});
                    return;
                }
                default: {
                    DriveEventService.zzbz.wfmt("DriveEventService", "Unhandled event: %s", new Object[]{driveEvent0});
                }
            }
        }
        catch(Exception exception0) {
            DriveEventService.zzbz.e("DriveEventService", String.format("Error handling event in %s", this.name), exception0);
        }
    }

    @Override  // com.google.android.gms.drive.events.zzd
    public final void zza(com.google.android.gms.drive.events.zzb zzb0) {
        DriveEventService.zzbz.wfmt("DriveEventService", "Unhandled changes available event in %s: %s", new Object[]{this.name, zzb0});
    }

    private final void zzw() throws SecurityException {
        int v = this.getCallingUid();
        if(v == this.zzcm) {
            return;
        }
        if(!UidVerifier.isGooglePlayServicesUid(this, v)) {
            throw new SecurityException("Caller is not GooglePlayServices");
        }
        this.zzcm = v;
    }
}

