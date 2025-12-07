package com.google.android.gms.internal.appset;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzl implements AppSetIdClient {
    private static AppSetIdClient zza;
    private final Context zzb;
    private boolean zzc;
    private final ScheduledExecutorService zzd;
    private final ExecutorService zze;

    static {
    }

    zzl(Context context0) {
        this.zzc = false;
        ScheduledExecutorService scheduledExecutorService0 = Executors.newSingleThreadScheduledExecutor();
        this.zzd = scheduledExecutorService0;
        this.zze = Executors.newSingleThreadExecutor();
        this.zzb = context0;
        if(!this.zzc) {
            scheduledExecutorService0.scheduleAtFixedRate(new zzj(this, null), 0L, 86400L, TimeUnit.SECONDS);
            this.zzc = true;
        }
    }

    @Override  // com.google.android.gms.appset.AppSetIdClient
    public final Task getAppSetIdInfo() {
        TaskCompletionSource taskCompletionSource0 = new TaskCompletionSource();
        zzh zzh0 = () -> {
            String s = zzl.zzf(this.zzb).getString("app_set_id", null);
            long v = this.zza();
            if(s == null || DefaultClock.getInstance().currentTimeMillis() > v) {
                try {
                    s = "4ccb78c8-1ef3-4605-add4-4142d6791f57";
                    Context context0 = this.zzb;
                    if(!zzl.zzf(context0).edit().putString("app_set_id", "4ccb78c8-1ef3-4605-add4-4142d6791f57").commit()) {
                        Log.e("AppSet", "Failed to store app set ID generated for App com.MonsterCouch.Wingspan");
                        throw new zzk("Failed to store the app set ID.");
                    }
                    zzl.zzg(context0);
                    SharedPreferences sharedPreferences0 = zzl.zzf(this.zzb);
                    long v1 = DefaultClock.getInstance().currentTimeMillis();
                    if(!sharedPreferences0.edit().putLong("app_set_id_creation_time", v1).commit()) {
                        Log.e("AppSet", "Failed to store app set ID creation time for App com.MonsterCouch.Wingspan");
                        throw new zzk("Failed to store the app set ID creation time.");
                    }
                }
                catch(zzk zzk1) {
                    taskCompletionSource0.setException(zzk1);
                    return;
                }
            }
            else {
                try {
                    zzl.zzg(this.zzb);
                }
                catch(zzk zzk0) {
                    taskCompletionSource0.setException(zzk0);
                    return;
                }
            }
            taskCompletionSource0.setResult(new AppSetIdInfo(s, 1));
        };
        this.zze.execute(zzh0);
        return taskCompletionSource0.getTask();
    }

    protected final long zza() {
        long v = zzl.zzf(this.zzb).getLong("app_set_id_last_used_time", -1L);
        return v == -1L ? -1L : v + 33696000000L;
    }

    static AppSetIdClient zzc(Context context0) {
        synchronized(zzl.class) {
            Preconditions.checkNotNull(context0, "Context must not be null");
            if(zzl.zza == null) {
                zzl.zza = new zzl(context0.getApplicationContext());
            }
            return zzl.zza;
        }
    }

    // 检测为 Lambda 实现
    final void zzd(TaskCompletionSource taskCompletionSource0) [...]

    protected static final void zze(Context context0) {
        if(!zzl.zzf(context0).edit().remove("app_set_id").commit()) {
            Log.e("AppSet", "Failed to clear app set ID generated for App com.MonsterCouch.Wingspan");
        }
        if(!zzl.zzf(context0).edit().remove("app_set_id_last_used_time").commit()) {
            Log.e("AppSet", "Failed to clear app set ID last used time for App com.MonsterCouch.Wingspan");
        }
    }

    private static final SharedPreferences zzf(Context context0) {
        return context0.getSharedPreferences("app_set_id_storage", 0);
    }

    private static final void zzg(Context context0) throws zzk {
        SharedPreferences sharedPreferences0 = zzl.zzf(context0);
        long v = DefaultClock.getInstance().currentTimeMillis();
        if(!sharedPreferences0.edit().putLong("app_set_id_last_used_time", v).commit()) {
            Log.e("AppSet", "Failed to store app set ID last used time for App com.MonsterCouch.Wingspan");
            throw new zzk("Failed to store the app set ID last used time.");
        }
    }
}

