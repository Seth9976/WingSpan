package com.google.android.gms.location;

import android.content.Intent;
import android.location.Location;
import android.os.Parcel;
import com.google.android.gms.internal.location.zzbe;
import java.util.ArrayList;
import java.util.List;

public class GeofencingEvent {
    private final int zza;
    private final int zzb;
    private final List zzc;
    private final Location zzd;

    private GeofencingEvent(int v, int v1, List list0, Location location0) {
        this.zza = v;
        this.zzb = v1;
        this.zzc = list0;
        this.zzd = location0;
    }

    public static GeofencingEvent fromIntent(Intent intent0) {
        ArrayList arrayList0 = null;
        if(intent0 == null) {
            return null;
        }
        int v = -1;
        int v1 = intent0.getIntExtra("gms_error_code", -1);
        int v2 = intent0.getIntExtra("com.google.android.location.intent.extra.transition", -1);
        switch(v2) {
            case 1: 
            case 2: {
                v = v2;
                break;
            }
            case 4: {
                v = 4;
            }
        }
        ArrayList arrayList1 = (ArrayList)intent0.getSerializableExtra("com.google.android.location.intent.extra.geofence_list");
        if(arrayList1 != null) {
            arrayList0 = new ArrayList(arrayList1.size());
            int v3 = arrayList1.size();
            for(int v4 = 0; v4 < v3; ++v4) {
                byte[] arr_b = (byte[])arrayList1.get(v4);
                Parcel parcel0 = Parcel.obtain();
                parcel0.unmarshall(arr_b, 0, arr_b.length);
                parcel0.setDataPosition(0);
                zzbe zzbe0 = (zzbe)zzbe.CREATOR.createFromParcel(parcel0);
                parcel0.recycle();
                arrayList0.add(zzbe0);
            }
        }
        return new GeofencingEvent(v1, v, arrayList0, ((Location)intent0.getParcelableExtra("com.google.android.location.intent.extra.triggering_location")));
    }

    public int getErrorCode() {
        return this.zza;
    }

    public int getGeofenceTransition() {
        return this.zzb;
    }

    public List getTriggeringGeofences() {
        return this.zzc;
    }

    public Location getTriggeringLocation() {
        return this.zzd;
    }

    public boolean hasError() {
        return this.zza != -1;
    }
}

