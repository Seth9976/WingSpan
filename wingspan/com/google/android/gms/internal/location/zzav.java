package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import java.util.HashMap;
import java.util.Map;

public final class zzav {
    private final zzbg zza;
    private final Context zzb;
    private boolean zzc;
    private final Map zzd;
    private final Map zze;
    private final Map zzf;

    public zzav(Context context0, zzbg zzbg0) {
        this.zzc = false;
        this.zzd = new HashMap();
        this.zze = new HashMap();
        this.zzf = new HashMap();
        this.zzb = context0;
        this.zza = zzbg0;
    }

    public final Location zza(String s) throws RemoteException {
        ((zzh)this.zza).zza.checkConnected();
        return ((zzh)this.zza).zza().zzn(s);
    }

    @Deprecated
    public final Location zzb() throws RemoteException {
        ((zzh)this.zza).zza.checkConnected();
        return ((zzh)this.zza).zza().zzm();
    }

    public final LocationAvailability zzc() throws RemoteException {
        ((zzh)this.zza).zza.checkConnected();
        return ((zzh)this.zza).zza().zzs("com.MonsterCouch.Wingspan");
    }

    public final void zzd(LocationRequest locationRequest0, ListenerHolder listenerHolder0, zzai zzai0) throws RemoteException {
        zzau zzau0;
        IBinder iBinder0;
        ((zzh)this.zza).zza.checkConnected();
        ListenerKey listenerHolder$ListenerKey0 = listenerHolder0.getListenerKey();
        if(listenerHolder$ListenerKey0 == null) {
            iBinder0 = null;
        }
        else {
            synchronized(this.zzd) {
                zzau0 = (zzau)this.zzd.get(listenerHolder$ListenerKey0);
                if(zzau0 == null) {
                    zzau0 = new zzau(listenerHolder0);
                }
                this.zzd.put(listenerHolder$ListenerKey0, zzau0);
            }
            iBinder0 = zzau0;
        }
        if(iBinder0 == null) {
            return;
        }
        ((zzh)this.zza).zza().zzo(new zzbc(1, zzba.zza(null, locationRequest0), iBinder0, null, null, ((IBinder)zzai0)));
    }

    public final void zze(zzba zzba0, ListenerHolder listenerHolder0, zzai zzai0) throws RemoteException {
        zzar zzar0;
        ((zzh)this.zza).zza.checkConnected();
        ListenerKey listenerHolder$ListenerKey0 = listenerHolder0.getListenerKey();
        if(listenerHolder$ListenerKey0 == null) {
            zzar0 = null;
        }
        else {
            synchronized(this.zzf) {
                zzar zzar1 = (zzar)this.zzf.get(listenerHolder$ListenerKey0);
                if(zzar1 == null) {
                    zzar1 = new zzar(listenerHolder0);
                }
                zzar0 = zzar1;
                this.zzf.put(listenerHolder$ListenerKey0, zzar0);
            }
        }
        if(zzar0 == null) {
            return;
        }
        ((zzh)this.zza).zza().zzo(new zzbc(1, zzba0, null, null, zzar0, ((IBinder)zzai0)));
    }

    public final void zzf(zzba zzba0, PendingIntent pendingIntent0, zzai zzai0) throws RemoteException {
        ((zzh)this.zza).zza.checkConnected();
        ((zzh)this.zza).zza().zzo(zzbc.zzb(zzba0, pendingIntent0, zzai0));
    }

    public final void zzg(LocationRequest locationRequest0, PendingIntent pendingIntent0, zzai zzai0) throws RemoteException {
        ((zzh)this.zza).zza.checkConnected();
        ((zzh)this.zza).zza().zzo(zzbc.zzb(zzba.zza(null, locationRequest0), pendingIntent0, zzai0));
    }

    public final void zzh(ListenerKey listenerHolder$ListenerKey0, zzai zzai0) throws RemoteException {
        ((zzh)this.zza).zza.checkConnected();
        Preconditions.checkNotNull(listenerHolder$ListenerKey0, "Invalid null listener key");
        synchronized(this.zzd) {
            zzau zzau0 = (zzau)this.zzd.remove(listenerHolder$ListenerKey0);
            if(zzau0 != null) {
                zzau0.zzc();
                ((zzh)this.zza).zza().zzo(zzbc.zza(zzau0, zzai0));
            }
        }
    }

    public final void zzi(ListenerKey listenerHolder$ListenerKey0, zzai zzai0) throws RemoteException {
        ((zzh)this.zza).zza.checkConnected();
        Preconditions.checkNotNull(listenerHolder$ListenerKey0, "Invalid null listener key");
        synchronized(this.zzf) {
            zzar zzar0 = (zzar)this.zzf.remove(listenerHolder$ListenerKey0);
            if(zzar0 != null) {
                zzar0.zzc();
                ((zzh)this.zza).zza().zzo(zzbc.zzc(zzar0, zzai0));
            }
        }
    }

    public final void zzj(PendingIntent pendingIntent0, zzai zzai0) throws RemoteException {
        ((zzh)this.zza).zza.checkConnected();
        ((zzh)this.zza).zza().zzo(new zzbc(2, null, null, pendingIntent0, null, ((IBinder)zzai0)));
    }

    public final void zzk(boolean z) throws RemoteException {
        ((zzh)this.zza).zza.checkConnected();
        ((zzh)this.zza).zza().zzp(z);
        this.zzc = z;
    }

    public final void zzl(Location location0) throws RemoteException {
        ((zzh)this.zza).zza.checkConnected();
        ((zzh)this.zza).zza().zzq(location0);
    }

    public final void zzm(zzai zzai0) throws RemoteException {
        ((zzh)this.zza).zza.checkConnected();
        ((zzh)this.zza).zza().zzr(zzai0);
    }

    public final void zzn() throws RemoteException {
        synchronized(this.zzd) {
            for(Object object0: this.zzd.values()) {
                zzau zzau0 = (zzau)object0;
                if(zzau0 != null) {
                    ((zzh)this.zza).zza().zzo(zzbc.zza(zzau0, null));
                }
            }
            this.zzd.clear();
        }
        synchronized(this.zzf) {
            for(Object object1: this.zzf.values()) {
                zzar zzar0 = (zzar)object1;
                if(zzar0 != null) {
                    ((zzh)this.zza).zza().zzo(zzbc.zzc(zzar0, null));
                }
            }
            this.zzf.clear();
        }
        synchronized(this.zze) {
            for(Object object2: this.zze.values()) {
                zzas zzas0 = (zzas)object2;
                if(zzas0 != null) {
                    ((zzh)this.zza).zza().zzu(new zzl(2, null, zzas0, null));
                }
            }
            this.zze.clear();
        }
    }

    public final void zzo() throws RemoteException {
        if(this.zzc) {
            this.zzk(false);
        }
    }
}

