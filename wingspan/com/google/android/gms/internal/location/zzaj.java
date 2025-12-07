package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzaj extends zzb implements zzak {
    public zzaj() {
        super("com.google.android.gms.location.internal.IGeofencerCallbacks");
    }

    @Override  // com.google.android.gms.internal.location.zzb
    protected final boolean zza(int v, Parcel parcel0, Parcel parcel1, int v1) throws RemoteException {
        switch(v) {
            case 1: {
                this.zzb(parcel0.readInt(), parcel0.createStringArray());
                return true;
            }
            case 2: {
                this.zzc(parcel0.readInt(), parcel0.createStringArray());
                return true;
            }
            case 3: {
                this.zzd(parcel0.readInt(), ((PendingIntent)zzc.zzb(parcel0, PendingIntent.CREATOR)));
                return true;
            }
            default: {
                return false;
            }
        }
    }
}

