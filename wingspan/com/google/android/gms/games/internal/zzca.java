package com.google.android.gms.games.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.internal.player.zze;
import com.google.android.gms.games.video.VideoCapabilities;
import com.google.android.gms.internal.games.zzb;
import com.google.android.gms.internal.games.zzc;

public abstract class zzca extends zzb implements zzcb {
    public zzca() {
        super("com.google.android.gms.games.internal.IGamesCallbacks");
    }

    @Override  // com.google.android.gms.internal.games.zzb
    protected final boolean zza(int v, Parcel parcel0, Parcel parcel1, int v1) throws RemoteException {
        switch(v) {
            case 5001: {
                parcel0.readInt();
                parcel0.readString();
                zzc.zzb(parcel0);
                break;
            }
            case 5002: {
                DataHolder dataHolder0 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                this.zzc(dataHolder0);
                break;
            }
            case 5003: {
                int v2 = parcel0.readInt();
                String s = parcel0.readString();
                zzc.zzb(parcel0);
                this.zzb(v2, s);
                break;
            }
            case 5004: {
                DataHolder dataHolder1 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                this.zzj(dataHolder1);
                break;
            }
            case 5005: {
                DataHolder dataHolder2 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                DataHolder dataHolder3 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                this.zzi(dataHolder2, dataHolder3);
                break;
            }
            case 5006: {
                DataHolder dataHolder4 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                this.zzn(dataHolder4);
                break;
            }
            case 5007: {
                DataHolder dataHolder5 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                this.zzm(dataHolder5);
                break;
            }
            case 5008: {
                DataHolder dataHolder6 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                this.zzg(dataHolder6);
                break;
            }
            case 5009: {
                DataHolder dataHolder7 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                this.zzh(dataHolder7);
                break;
            }
            case 5010: {
                DataHolder dataHolder8 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                break;
            }
            case 5011: {
                DataHolder dataHolder9 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                break;
            }
            case 5016: {
                this.zzo();
                break;
            }
            case 5017: {
                DataHolder dataHolder10 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                break;
            }
            case 5018: {
                DataHolder dataHolder11 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                break;
            }
            case 5019: {
                DataHolder dataHolder12 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                break;
            }
            case 5020: {
                parcel0.readInt();
                parcel0.readString();
                zzc.zzb(parcel0);
                break;
            }
            case 5021: {
                DataHolder dataHolder13 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                break;
            }
            case 5022: {
                DataHolder dataHolder14 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                break;
            }
            case 5023: {
                DataHolder dataHolder15 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                break;
            }
            case 5024: {
                DataHolder dataHolder16 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                break;
            }
            case 5025: {
                DataHolder dataHolder17 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                break;
            }
            case 5026: {
                DataHolder dataHolder18 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                parcel0.createStringArray();
                zzc.zzb(parcel0);
                break;
            }
            case 5027: {
                DataHolder dataHolder19 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                parcel0.createStringArray();
                zzc.zzb(parcel0);
                break;
            }
            case 5028: {
                DataHolder dataHolder20 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                parcel0.createStringArray();
                zzc.zzb(parcel0);
                break;
            }
            case 5029: {
                DataHolder dataHolder21 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                parcel0.createStringArray();
                zzc.zzb(parcel0);
                break;
            }
            case 5030: {
                DataHolder dataHolder22 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                parcel0.createStringArray();
                zzc.zzb(parcel0);
                break;
            }
            case 5031: {
                DataHolder dataHolder23 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                parcel0.createStringArray();
                zzc.zzb(parcel0);
                break;
            }
            case 5032: {
                com.google.android.gms.games.multiplayer.realtime.zzb zzb0 = (com.google.android.gms.games.multiplayer.realtime.zzb)zzc.zza(parcel0, com.google.android.gms.games.multiplayer.realtime.zzb.CREATOR);
                zzc.zzb(parcel0);
                break;
            }
            case 5033: {
                parcel0.readInt();
                parcel0.readInt();
                parcel0.readString();
                zzc.zzb(parcel0);
                break;
            }
            case 5034: {
                parcel0.readInt();
                parcel0.readString();
                zzc.zzg(parcel0);
                zzc.zzb(parcel0);
                break;
            }
            case 5035: {
                DataHolder dataHolder24 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                break;
            }
            case 5036: {
                parcel0.readInt();
                zzc.zzb(parcel0);
                break;
            }
            case 5037: {
                DataHolder dataHolder25 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                break;
            }
            case 5038: {
                DataHolder dataHolder26 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                break;
            }
            case 5039: {
                DataHolder dataHolder27 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                break;
            }
            case 5040: {
                parcel0.readInt();
                zzc.zzb(parcel0);
                break;
            }
            case 6001: {
                parcel0.readString();
                zzc.zzb(parcel0);
                break;
            }
            case 6002: {
                parcel0.readString();
                zzc.zzb(parcel0);
                break;
            }
            case 8001: {
                DataHolder dataHolder28 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                this.zzk(dataHolder28);
                break;
            }
            case 8002: {
                parcel0.readInt();
                Bundle bundle0 = (Bundle)zzc.zza(parcel0, Bundle.CREATOR);
                zzc.zzb(parcel0);
                break;
            }
            case 8003: {
                DataHolder dataHolder29 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                break;
            }
            case 8004: {
                DataHolder dataHolder30 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                break;
            }
            case 8005: {
                DataHolder dataHolder31 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                break;
            }
            case 8006: {
                DataHolder dataHolder32 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                break;
            }
            case 8007: {
                parcel0.readInt();
                parcel0.readString();
                zzc.zzb(parcel0);
                break;
            }
            case 8008: {
                DataHolder dataHolder33 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                break;
            }
            case 8009: {
                parcel0.readString();
                zzc.zzb(parcel0);
                break;
            }
            case 8010: {
                parcel0.readString();
                zzc.zzb(parcel0);
                break;
            }
            case 9001: {
                DataHolder dataHolder34 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                break;
            }
            case 10001: {
                DataHolder dataHolder35 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                break;
            }
            case 10002: {
                parcel0.readString();
                zzc.zzb(parcel0);
                break;
            }
            case 10003: {
                DataHolder dataHolder36 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                break;
            }
            case 10004: {
                DataHolder dataHolder37 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                break;
            }
            case 10005: {
                parcel0.readInt();
                Bundle bundle1 = (Bundle)zzc.zza(parcel0, Bundle.CREATOR);
                zzc.zzb(parcel0);
                break;
            }
            case 10006: {
                DataHolder dataHolder38 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                break;
            }
            case 11001: {
                parcel0.readInt();
                Bundle bundle2 = (Bundle)zzc.zza(parcel0, Bundle.CREATOR);
                zzc.zzb(parcel0);
                break;
            }
            case 12001: {
                DataHolder dataHolder39 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                this.zzt(dataHolder39);
                break;
            }
            case 12004: {
                DataHolder dataHolder40 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                Contents contents0 = (Contents)zzc.zza(parcel0, Contents.CREATOR);
                zzc.zzb(parcel0);
                this.zzs(dataHolder40, contents0);
                break;
            }
            case 12005: {
                DataHolder dataHolder41 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                this.zzp(dataHolder41);
                break;
            }
            case 12006: {
                DataHolder dataHolder42 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                break;
            }
            case 12007: {
                DataHolder dataHolder43 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                break;
            }
            case 12008: {
                DataHolder dataHolder44 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                break;
            }
            case 12011: {
                DataHolder dataHolder45 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                this.zzf(dataHolder45);
                break;
            }
            case 12012: {
                int v3 = parcel0.readInt();
                String s1 = parcel0.readString();
                zzc.zzb(parcel0);
                this.zzr(v3, s1);
                break;
            }
            case 12014: {
                DataHolder dataHolder46 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                break;
            }
            case 0x2EEF: {
                parcel0.readInt();
                Bundle bundle3 = (Bundle)zzc.zza(parcel0, Bundle.CREATOR);
                zzc.zzb(parcel0);
                break;
            }
            case 0x2EF0: {
                DataHolder dataHolder47 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                break;
            }
            case 0x2EF1: {
                Parcelable parcelable0 = zzc.zza(parcel0, DataHolder.CREATOR);
                String s2 = parcel0.readString();
                Parcelable parcelable1 = zzc.zza(parcel0, Contents.CREATOR);
                Parcelable parcelable2 = zzc.zza(parcel0, Contents.CREATOR);
                Parcelable parcelable3 = zzc.zza(parcel0, Contents.CREATOR);
                zzc.zzb(parcel0);
                this.zzq(((DataHolder)parcelable0), s2, ((Contents)parcelable1), ((Contents)parcelable2), ((Contents)parcelable3));
                break;
            }
            case 13001: {
                DataHolder dataHolder48 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                break;
            }
            case 13002: {
                parcel0.readInt();
                zzc.zzb(parcel0);
                break;
            }
            case 14001: {
                DataHolder[] arr_dataHolder = (DataHolder[])parcel0.createTypedArray(DataHolder.CREATOR);
                zzc.zzb(parcel0);
                break;
            }
            case 15001: {
                DataHolder dataHolder49 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                this.zzl(dataHolder49);
                break;
            }
            case 17002: {
                parcel0.readInt();
                zzc.zzb(parcel0);
                break;
            }
            case 19001: {
                int v4 = parcel0.readInt();
                VideoCapabilities videoCapabilities0 = (VideoCapabilities)zzc.zza(parcel0, VideoCapabilities.CREATOR);
                zzc.zzb(parcel0);
                this.zzv(v4, videoCapabilities0);
                break;
            }
            case 19002: {
                int v5 = parcel0.readInt();
                boolean z = zzc.zzg(parcel0);
                zzc.zzb(parcel0);
                this.zzu(v5, z);
                break;
            }
            case 19008: {
                parcel0.readInt();
                zzc.zzb(parcel0);
                break;
            }
            case 19009: {
                parcel0.readInt();
                zzc.zzb(parcel0);
                break;
            }
            case 19010: {
                parcel0.readInt();
                zzc.zzb(parcel0);
                break;
            }
            case 20001: {
                DataHolder dataHolder50 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                break;
            }
            case 20002: {
                DataHolder dataHolder51 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                break;
            }
            case 20003: {
                DataHolder dataHolder52 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                break;
            }
            case 20004: {
                DataHolder dataHolder53 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                break;
            }
            case 20005: {
                DataHolder dataHolder54 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                break;
            }
            case 20006: {
                DataHolder dataHolder55 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                break;
            }
            case 20007: {
                DataHolder dataHolder56 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                break;
            }
            case 20008: {
                DataHolder dataHolder57 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                break;
            }
            case 20009: {
                DataHolder dataHolder58 = (DataHolder)zzc.zza(parcel0, DataHolder.CREATOR);
                zzc.zzb(parcel0);
                break;
            }
            case 20012: {
                Status status0 = (Status)zzc.zza(parcel0, Status.CREATOR);
                zzc.zzb(parcel0);
                break;
            }
            case 20019: {
                int v6 = parcel0.readInt();
                zzc.zzb(parcel0);
                this.zzd(v6);
                break;
            }
            case 20020: {
                int v7 = parcel0.readInt();
                Bundle bundle4 = (Bundle)zzc.zza(parcel0, Bundle.CREATOR);
                zzc.zzb(parcel0);
                this.zze(v7, bundle4);
                break;
            }
            case 23001: {
                parcel0.readInt();
                zzc.zzb(parcel0);
                break;
            }
            case 23002: {
                parcel0.readInt();
                zzc.zzb(parcel0);
                break;
            }
            case 23003: {
                parcel0.readInt();
                zzc.zzb(parcel0);
                break;
            }
            case 23004: {
                parcel0.readInt();
                zzc.zzb(parcel0);
                break;
            }
            case 23005: {
                parcel0.readInt();
                zzc.zzb(parcel0);
                break;
            }
            case 24002: {
                zzc.zzg(parcel0);
                zzc.zzb(parcel0);
                break;
            }
            case 25002: {
                parcel0.readString();
                zzc.zzb(parcel0);
                break;
            }
            case 25003: {
                Status status1 = (Status)zzc.zza(parcel0, Status.CREATOR);
                parcel0.readString();
                zzc.zzb(parcel0);
                break;
            }
            case 25004: {
                Status status2 = (Status)zzc.zza(parcel0, Status.CREATOR);
                zzc.zzb(parcel0);
                break;
            }
            case 25005: {
                parcel0.readInt();
                zze zze0 = (zze)zzc.zza(parcel0, zze.CREATOR);
                zzc.zzb(parcel0);
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

