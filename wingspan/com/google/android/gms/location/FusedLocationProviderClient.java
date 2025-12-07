package com.google.android.gms.location;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.internal.location.zzaz;
import com.google.android.gms.internal.location.zzba;
import com.google.android.gms.internal.location.zzbj;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public class FusedLocationProviderClient extends GoogleApi {
    public static final String KEY_MOCK_LOCATION = "mockLocation";
    public static final String KEY_VERTICAL_ACCURACY = "verticalAccuracy";

    public FusedLocationProviderClient(Activity activity0) {
        ApiExceptionMapper apiExceptionMapper0 = new ApiExceptionMapper();
        super(activity0, LocationServices.API, ApiOptions.NO_OPTIONS, apiExceptionMapper0);
    }

    public FusedLocationProviderClient(Context context0) {
        ApiExceptionMapper apiExceptionMapper0 = new ApiExceptionMapper();
        super(context0, LocationServices.API, ApiOptions.NO_OPTIONS, apiExceptionMapper0);
    }

    public Task flushLocations() {
        return this.doWrite(TaskApiCall.builder().run(zzw.zza).setMethodKey(0x976).build());
    }

    public Task getCurrentLocation(int v, CancellationToken cancellationToken0) {
        LocationRequest locationRequest0 = LocationRequest.create();
        locationRequest0.setPriority(v);
        locationRequest0.setInterval(0L);
        locationRequest0.setFastestInterval(0L);
        locationRequest0.setExpirationDuration(30000L);
        zzba zzba0 = zzba.zza(null, locationRequest0);
        zzba0.zzd(true);
        zzba0.zzb(10000L);
        zzab zzab0 = new zzab(this, cancellationToken0, zzba0);
        Task task0 = this.doRead(TaskApiCall.builder().run(zzab0).setFeatures(new Feature[]{zzu.zzd}).setMethodKey(0x96F).build());
        if(cancellationToken0 != null) {
            TaskCompletionSource taskCompletionSource0 = new TaskCompletionSource(cancellationToken0);
            task0.continueWithTask(new zzac(taskCompletionSource0));
            return taskCompletionSource0.getTask();
        }
        return task0;
    }

    public Task getLastLocation() {
        return this.doRead(TaskApiCall.builder().run(new zzv(this)).setMethodKey(0x96E).build());
    }

    public Task getLocationAvailability() {
        return this.doRead(TaskApiCall.builder().run(zzad.zza).setMethodKey(0x970).build());
    }

    public Task removeLocationUpdates(PendingIntent pendingIntent0) {
        return this.doWrite(TaskApiCall.builder().run(new zzag(pendingIntent0)).setMethodKey(0x972).build());
    }

    public Task removeLocationUpdates(LocationCallback locationCallback0) {
        return TaskUtil.toVoidTaskThatFailsOnFalse(this.doUnregisterEventListener(ListenerHolders.createListenerKey(locationCallback0, "LocationCallback")));
    }

    public Task requestLocationUpdates(LocationRequest locationRequest0, PendingIntent pendingIntent0) {
        zzba zzba0 = zzba.zza(null, locationRequest0);
        return this.doWrite(TaskApiCall.builder().run(new zzaf(this, zzba0, pendingIntent0)).setMethodKey(0x971).build());
    }

    public Task requestLocationUpdates(LocationRequest locationRequest0, LocationCallback locationCallback0, Looper looper0) {
        return this.zze(zzba.zza(null, locationRequest0), locationCallback0, looper0, null, 0x984);
    }

    public Task setMockLocation(Location location0) {
        return this.doWrite(TaskApiCall.builder().run(new zzai(location0)).setMethodKey(0x975).build());
    }

    public Task setMockMode(boolean z) {
        return this.doWrite(TaskApiCall.builder().run(new zzah(z)).setMethodKey(2420).build());
    }

    final void zza(zzba zzba0, PendingIntent pendingIntent0, zzaz zzaz0, TaskCompletionSource taskCompletionSource0) throws RemoteException {
        zzao zzao0 = new zzao(taskCompletionSource0);
        zzba0.zzc(this.getContextAttributionTag());
        zzaz0.zzD(zzba0, pendingIntent0, zzao0);
    }

    final void zzb(zzap zzap0, LocationCallback locationCallback0, zzan zzan0, zzba zzba0, ListenerHolder listenerHolder0, zzaz zzaz0, TaskCompletionSource taskCompletionSource0) throws RemoteException {
        zzam zzam0 = new zzam(taskCompletionSource0, new zzx(this, zzap0, locationCallback0, zzan0));
        zzba0.zzc(this.getContextAttributionTag());
        zzaz0.zzB(zzba0, listenerHolder0, zzam0);
    }

    final void zzc(CancellationToken cancellationToken0, zzba zzba0, zzaz zzaz0, TaskCompletionSource taskCompletionSource0) throws RemoteException {
        zzaj zzaj0 = new zzaj(this, taskCompletionSource0);
        if(cancellationToken0 != null) {
            cancellationToken0.onCanceledRequested(new zzy(this, zzaj0));
        }
        this.zze(zzba0, zzaj0, Looper.getMainLooper(), new zzz(taskCompletionSource0), 0x985).continueWithTask(new zzaa(taskCompletionSource0));
    }

    final void zzd(zzaz zzaz0, TaskCompletionSource taskCompletionSource0) throws RemoteException {
        taskCompletionSource0.setResult(zzaz0.zzz(this.getContextAttributionTag()));
    }

    private final Task zze(zzba zzba0, LocationCallback locationCallback0, Looper looper0, zzan zzan0, int v) {
        ListenerHolder listenerHolder0 = ListenerHolders.createListenerHolder(locationCallback0, zzbj.zza(looper0), "LocationCallback");
        zzak zzak0 = new zzak(this, listenerHolder0);
        zzae zzae0 = new zzae(this, zzak0, locationCallback0, zzan0, zzba0, listenerHolder0);
        return this.doRegisterEventListener(RegistrationMethods.builder().register(zzae0).unregister(zzak0).withHolder(listenerHolder0).setMethodKey(v).build());
    }
}

