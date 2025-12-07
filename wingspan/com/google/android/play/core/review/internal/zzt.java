package com.google.android.play.core.review.internal;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder.DeathRecipient;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.core.review.zze;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzt {
    private static final Map zza;
    private final Context zzb;
    private final zzi zzc;
    private final String zzd;
    private final List zze;
    private final Set zzf;
    private final Object zzg;
    private boolean zzh;
    private final Intent zzi;
    private final WeakReference zzj;
    private final IBinder.DeathRecipient zzk;
    private final AtomicInteger zzl;
    private ServiceConnection zzm;
    private IInterface zzn;
    private final zze zzo;

    static {
        zzt.zza = new HashMap();
    }

    public zzt(Context context0, zzi zzi0, String s, Intent intent0, zze zze0, zzo zzo0, byte[] arr_b) {
        this.zze = new ArrayList();
        this.zzf = new HashSet();
        this.zzg = new Object();
        this.zzk = () -> {
            this.zzc.zzd("reportBinderDeath", new Object[0]);
            zzo zzo0 = (zzo)this.zzj.get();
            if(zzo0 == null) {
                this.zzc.zzd("%s : Binder has died.", new Object[]{this.zzd});
                for(Object object0: this.zze) {
                    ((zzj)object0).zzc(this.zzs());
                }
                this.zze.clear();
            }
            else {
                this.zzc.zzd("calling onBinderDied", new Object[0]);
                zzo0.zza();
            }
            this.zzt();
        };
        this.zzl = new AtomicInteger(0);
        this.zzb = context0;
        this.zzc = zzi0;
        this.zzd = "com.google.android.finsky.inappreviewservice.InAppReviewService";
        this.zzi = intent0;
        this.zzo = zze0;
        this.zzj = new WeakReference(null);
    }

    static Context zza(zzt zzt0) {
        return zzt0.zzb;
    }

    static ServiceConnection zzb(zzt zzt0) {
        return zzt0.zzm;
    }

    public final Handler zzc() {
        Map map0 = zzt.zza;
        synchronized(map0) {
            if(!map0.containsKey(this.zzd)) {
                HandlerThread handlerThread0 = new HandlerThread(this.zzd, 10);
                handlerThread0.start();
                Handler handler0 = new Handler(handlerThread0.getLooper());
                map0.put(this.zzd, handler0);
            }
        }
        return (Handler)map0.get(this.zzd);
    }

    static IInterface zzd(zzt zzt0) {
        return zzt0.zzn;
    }

    public final IInterface zze() {
        return this.zzn;
    }

    static zzi zzf(zzt zzt0) {
        return zzt0.zzc;
    }

    static List zzg(zzt zzt0) {
        return zzt0.zze;
    }

    // 检测为 Lambda 实现
    public static void zzh(zzt zzt0) [...]

    static void zzi(zzt zzt0, ServiceConnection serviceConnection0) {
        zzt0.zzm = null;
    }

    static void zzj(zzt zzt0, boolean z) {
        zzt0.zzh = false;
    }

    static void zzk(zzt zzt0, IInterface iInterface0) {
        zzt0.zzn = iInterface0;
    }

    static void zzl(zzt zzt0) {
        zzt0.zzt();
    }

    static void zzm(zzt zzt0, zzj zzj0) {
        if(zzt0.zzn == null && !zzt0.zzh) {
            zzt0.zzc.zzd("Initiate binding to the service.", new Object[0]);
            zzt0.zze.add(zzj0);
            zzs zzs0 = new zzs(zzt0, null);
            zzt0.zzm = zzs0;
            zzt0.zzh = true;
            if(!zzt0.zzb.bindService(zzt0.zzi, zzs0, 1)) {
                zzt0.zzc.zzd("Failed to bind to the service.", new Object[0]);
                zzt0.zzh = false;
                for(Object object0: zzt0.zze) {
                    ((zzj)object0).zzc(new zzu());
                }
                zzt0.zze.clear();
            }
            return;
        }
        if(zzt0.zzh) {
            zzt0.zzc.zzd("Waiting to bind to the service.", new Object[0]);
            zzt0.zze.add(zzj0);
            return;
        }
        zzj0.run();
    }

    static void zzn(zzt zzt0) {
        zzt0.zzc.zzd("linkToDeath", new Object[0]);
        try {
            zzt0.zzn.asBinder().linkToDeath(zzt0.zzk, 0);
        }
        catch(RemoteException remoteException0) {
            zzt0.zzc.zzc(remoteException0, "linkToDeath failed", new Object[0]);
        }
    }

    static void zzo(zzt zzt0) {
        zzt0.zzc.zzd("unlinkToDeath", new Object[0]);
        zzt0.zzn.asBinder().unlinkToDeath(zzt0.zzk, 0);
    }

    public final void zzp(zzj zzj0, TaskCompletionSource taskCompletionSource0) {
        synchronized(this.zzg) {
            this.zzf.add(taskCompletionSource0);
            taskCompletionSource0.getTask().addOnCompleteListener((Task task0) -> synchronized(this.zzg) {
                this.zzf.remove(taskCompletionSource0);
            });
        }
        synchronized(this.zzg) {
            if(this.zzl.getAndIncrement() > 0) {
                this.zzc.zza("Already connected to the service.", new Object[0]);
            }
        }
        zzm zzm0 = new zzm(this, zzj0.zzb(), zzj0);
        this.zzc().post(zzm0);
    }

    // 检测为 Lambda 实现
    final void zzq(TaskCompletionSource taskCompletionSource0, Task task0) [...]

    public final void zzr(TaskCompletionSource taskCompletionSource0) {
        synchronized(this.zzg) {
            this.zzf.remove(taskCompletionSource0);
        }
        synchronized(this.zzg) {
            if(this.zzl.get() > 0 && this.zzl.decrementAndGet() > 0) {
                this.zzc.zzd("Leaving the connection open for other ongoing calls.", new Object[0]);
                return;
            }
        }
        zzn zzn0 = new zzn(this);
        this.zzc().post(zzn0);
    }

    private final RemoteException zzs() {
        return new RemoteException(this.zzd + " : Binder has died.");
    }

    private final void zzt() {
        synchronized(this.zzg) {
            for(Object object1: this.zzf) {
                ((TaskCompletionSource)object1).trySetException(this.zzs());
            }
            this.zzf.clear();
        }
    }
}

