package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.zza;

public abstract class zzer extends zzb implements zzeq {
    public zzer() {
        super("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
    }

    @Override  // com.google.android.gms.internal.drive.zzb
    protected final boolean dispatchTransaction(int v, Parcel parcel0, Parcel parcel1, int v1) throws RemoteException {
        switch(v) {
            case 1: {
                this.zza(((zzfl)zzc.zza(parcel0, zzfl.CREATOR)));
                break;
            }
            case 2: {
                this.zza(((zzft)zzc.zza(parcel0, zzft.CREATOR)));
                break;
            }
            case 3: {
                this.zza(((zzfn)zzc.zza(parcel0, zzfn.CREATOR)));
                break;
            }
            case 4: {
                this.zza(((zzfy)zzc.zza(parcel0, zzfy.CREATOR)));
                break;
            }
            case 5: {
                this.zza(((zzfh)zzc.zza(parcel0, zzfh.CREATOR)));
                break;
            }
            case 6: {
                this.zza(((Status)zzc.zza(parcel0, Status.CREATOR)));
                break;
            }
            case 7: {
                this.onSuccess();
                break;
            }
            case 8: {
                this.zza(((zzfv)zzc.zza(parcel0, zzfv.CREATOR)));
                break;
            }
            case 9: {
                this.zza(((zzgh)zzc.zza(parcel0, zzgh.CREATOR)));
                break;
            }
            case 11: {
                this.zza(((zzfx)zzc.zza(parcel0, zzfx.CREATOR)), zzip.zzb(parcel0.readStrongBinder()));
                break;
            }
            case 12: {
                this.zza(((zzgd)zzc.zza(parcel0, zzgd.CREATOR)));
                break;
            }
            case 13: {
                this.zza(((zzga)zzc.zza(parcel0, zzga.CREATOR)));
                break;
            }
            case 14: {
                this.zza(((zzfj)zzc.zza(parcel0, zzfj.CREATOR)));
                break;
            }
            case 15: {
                this.zzb(zzc.zza(parcel0));
                break;
            }
            case 16: {
                this.zza(((zzfr)zzc.zza(parcel0, zzfr.CREATOR)));
                break;
            }
            case 17: {
                this.zza(((zza)zzc.zza(parcel0, zza.CREATOR)));
                break;
            }
            case 18: {
                this.zza(((zzff)zzc.zza(parcel0, zzff.CREATOR)));
                break;
            }
            case 20: {
                this.zza(((zzem)zzc.zza(parcel0, zzem.CREATOR)));
                break;
            }
            case 21: {
                this.zza(((zzgz)zzc.zza(parcel0, zzgz.CREATOR)));
                break;
            }
            case 22: {
                this.zza(((zzgf)zzc.zza(parcel0, zzgf.CREATOR)));
                break;
            }
            default: {
                return false;
            }
        }
        parcel1.writeNoException();
        return true;
    }
}

