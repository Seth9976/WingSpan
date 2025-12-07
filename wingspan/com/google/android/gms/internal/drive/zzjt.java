package com.google.android.gms.internal.drive;

import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;

final class zzjt implements zzns {
    private final zzjr zznx;

    private zzjt(zzjr zzjr0) {
        zzjr zzjr1 = (zzjr)zzkm.zza(zzjr0, "output");
        this.zznx = zzjr1;
        zzjr1.zzoh = this;
    }

    public static zzjt zza(zzjr zzjr0) {
        return zzjr0.zzoh == null ? new zzjt(zzjr0) : zzjr0.zzoh;
    }

    @Override  // com.google.android.gms.internal.drive.zzns
    public final void zza(int v, double f) throws IOException {
        this.zznx.zza(v, f);
    }

    @Override  // com.google.android.gms.internal.drive.zzns
    public final void zza(int v, float f) throws IOException {
        this.zznx.zza(v, f);
    }

    @Override  // com.google.android.gms.internal.drive.zzns
    public final void zza(int v, long v1) throws IOException {
        this.zznx.zza(v, v1);
    }

    @Override  // com.google.android.gms.internal.drive.zzns
    public final void zza(int v, zzjc zzjc0) throws IOException {
        this.zznx.zza(v, zzjc0);
    }

    @Override  // com.google.android.gms.internal.drive.zzns
    public final void zza(int v, zzlj zzlj0, Map map0) throws IOException {
        for(Object object0: map0.entrySet()) {
            this.zznx.zzb(v, 2);
            int v1 = zzli.zza(zzlj0, ((Map.Entry)object0).getKey(), ((Map.Entry)object0).getValue());
            this.zznx.zzy(v1);
            Object object1 = ((Map.Entry)object0).getKey();
            Object object2 = ((Map.Entry)object0).getValue();
            zzli.zza(this.zznx, zzlj0, object1, object2);
        }
    }

    @Override  // com.google.android.gms.internal.drive.zzns
    public final void zza(int v, Object object0) throws IOException {
        if(object0 instanceof zzjc) {
            this.zznx.zzb(v, ((zzjc)object0));
            return;
        }
        this.zznx.zza(v, ((zzlq)object0));
    }

    @Override  // com.google.android.gms.internal.drive.zzns
    public final void zza(int v, Object object0, zzmf zzmf0) throws IOException {
        this.zznx.zza(v, ((zzlq)object0), zzmf0);
    }

    @Override  // com.google.android.gms.internal.drive.zzns
    public final void zza(int v, String s) throws IOException {
        this.zznx.zza(v, s);
    }

    @Override  // com.google.android.gms.internal.drive.zzns
    public final void zza(int v, List list0) throws IOException {
        int v1 = 0;
        if(list0 instanceof zzkz) {
            while(v1 < list0.size()) {
                Object object0 = ((zzkz)list0).zzao(v1);
                if(object0 instanceof String) {
                    this.zznx.zza(v, ((String)object0));
                }
                else {
                    this.zznx.zza(v, ((zzjc)object0));
                }
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            String s = (String)list0.get(v1);
            this.zznx.zza(v, s);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.drive.zzns
    public final void zza(int v, List list0, zzmf zzmf0) throws IOException {
        for(int v1 = 0; v1 < list0.size(); ++v1) {
            this.zza(v, list0.get(v1), zzmf0);
        }
    }

    @Override  // com.google.android.gms.internal.drive.zzns
    public final void zza(int v, List list0, boolean z) throws IOException {
        int v1 = 0;
        if(z) {
            this.zznx.zzb(v, 2);
            int v3 = 0;
            for(int v2 = 0; v2 < list0.size(); ++v2) {
                v3 += zzjr.zzac(((int)(((Integer)list0.get(v2)))));
            }
            this.zznx.zzy(v3);
            while(v1 < list0.size()) {
                int v4 = (int)(((Integer)list0.get(v1)));
                this.zznx.zzx(v4);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            int v5 = (int)(((Integer)list0.get(v1)));
            this.zznx.zzc(v, v5);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.drive.zzns
    public final void zzak(int v) throws IOException {
        this.zznx.zzb(v, 3);
    }

    @Override  // com.google.android.gms.internal.drive.zzns
    public final void zzal(int v) throws IOException {
        this.zznx.zzb(v, 4);
    }

    @Override  // com.google.android.gms.internal.drive.zzns
    public final void zzb(int v, long v1) throws IOException {
        this.zznx.zzb(v, v1);
    }

    @Override  // com.google.android.gms.internal.drive.zzns
    public final void zzb(int v, Object object0, zzmf zzmf0) throws IOException {
        this.zznx.zzb(v, 3);
        zzmf0.zza(((zzlq)object0), this.zznx.zzoh);
        this.zznx.zzb(v, 4);
    }

    @Override  // com.google.android.gms.internal.drive.zzns
    public final void zzb(int v, List list0) throws IOException {
        for(int v1 = 0; v1 < list0.size(); ++v1) {
            zzjc zzjc0 = (zzjc)list0.get(v1);
            this.zznx.zza(v, zzjc0);
        }
    }

    @Override  // com.google.android.gms.internal.drive.zzns
    public final void zzb(int v, List list0, zzmf zzmf0) throws IOException {
        for(int v1 = 0; v1 < list0.size(); ++v1) {
            this.zzb(v, list0.get(v1), zzmf0);
        }
    }

    @Override  // com.google.android.gms.internal.drive.zzns
    public final void zzb(int v, List list0, boolean z) throws IOException {
        int v1 = 0;
        if(z) {
            this.zznx.zzb(v, 2);
            int v3 = 0;
            for(int v2 = 0; v2 < list0.size(); ++v2) {
                v3 += zzjr.zzaf(((int)(((Integer)list0.get(v2)))));
            }
            this.zznx.zzy(v3);
            while(v1 < list0.size()) {
                int v4 = (int)(((Integer)list0.get(v1)));
                this.zznx.zzaa(v4);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            int v5 = (int)(((Integer)list0.get(v1)));
            this.zznx.zzf(v, v5);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.drive.zzns
    public final void zzb(int v, boolean z) throws IOException {
        this.zznx.zzb(v, z);
    }

    @Override  // com.google.android.gms.internal.drive.zzns
    public final void zzc(int v, int v1) throws IOException {
        this.zznx.zzc(v, v1);
    }

    @Override  // com.google.android.gms.internal.drive.zzns
    public final void zzc(int v, long v1) throws IOException {
        this.zznx.zzc(v, v1);
    }

    @Override  // com.google.android.gms.internal.drive.zzns
    public final void zzc(int v, List list0, boolean z) throws IOException {
        int v1 = 0;
        if(z) {
            this.zznx.zzb(v, 2);
            int v3 = 0;
            for(int v2 = 0; v2 < list0.size(); ++v2) {
                v3 += zzjr.zzo(((long)(((Long)list0.get(v2)))));
            }
            this.zznx.zzy(v3);
            while(v1 < list0.size()) {
                long v4 = (long)(((Long)list0.get(v1)));
                this.zznx.zzl(v4);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            long v5 = (long)(((Long)list0.get(v1)));
            this.zznx.zza(v, v5);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.drive.zzns
    public final int zzcd() {
        return zze.zzsi;
    }

    @Override  // com.google.android.gms.internal.drive.zzns
    public final void zzd(int v, int v1) throws IOException {
        this.zznx.zzd(v, v1);
    }

    @Override  // com.google.android.gms.internal.drive.zzns
    public final void zzd(int v, List list0, boolean z) throws IOException {
        int v1 = 0;
        if(z) {
            this.zznx.zzb(v, 2);
            int v3 = 0;
            for(int v2 = 0; v2 < list0.size(); ++v2) {
                v3 += zzjr.zzp(((long)(((Long)list0.get(v2)))));
            }
            this.zznx.zzy(v3);
            while(v1 < list0.size()) {
                long v4 = (long)(((Long)list0.get(v1)));
                this.zznx.zzl(v4);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            long v5 = (long)(((Long)list0.get(v1)));
            this.zznx.zza(v, v5);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.drive.zzns
    public final void zze(int v, int v1) throws IOException {
        this.zznx.zze(v, v1);
    }

    @Override  // com.google.android.gms.internal.drive.zzns
    public final void zze(int v, List list0, boolean z) throws IOException {
        int v1 = 0;
        if(z) {
            this.zznx.zzb(v, 2);
            int v3 = 0;
            for(int v2 = 0; v2 < list0.size(); ++v2) {
                v3 += zzjr.zzr(((long)(((Long)list0.get(v2)))));
            }
            this.zznx.zzy(v3);
            while(v1 < list0.size()) {
                long v4 = (long)(((Long)list0.get(v1)));
                this.zznx.zzn(v4);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            long v5 = (long)(((Long)list0.get(v1)));
            this.zznx.zzc(v, v5);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.drive.zzns
    public final void zzf(int v, int v1) throws IOException {
        this.zznx.zzf(v, v1);
    }

    @Override  // com.google.android.gms.internal.drive.zzns
    public final void zzf(int v, List list0, boolean z) throws IOException {
        int v1 = 0;
        if(z) {
            this.zznx.zzb(v, 2);
            int v3 = 0;
            for(int v2 = 0; v2 < list0.size(); ++v2) {
                v3 += zzjr.zzb(((float)(((Float)list0.get(v2)))));
            }
            this.zznx.zzy(v3);
            while(v1 < list0.size()) {
                float f = (float)(((Float)list0.get(v1)));
                this.zznx.zza(f);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            float f1 = (float)(((Float)list0.get(v1)));
            this.zznx.zza(v, f1);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.drive.zzns
    public final void zzg(int v, List list0, boolean z) throws IOException {
        int v1 = 0;
        if(z) {
            this.zznx.zzb(v, 2);
            int v3 = 0;
            for(int v2 = 0; v2 < list0.size(); ++v2) {
                v3 += zzjr.zzb(((double)(((Double)list0.get(v2)))));
            }
            this.zznx.zzy(v3);
            while(v1 < list0.size()) {
                double f = (double)(((Double)list0.get(v1)));
                this.zznx.zza(f);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            double f1 = (double)(((Double)list0.get(v1)));
            this.zznx.zza(v, f1);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.drive.zzns
    public final void zzh(int v, List list0, boolean z) throws IOException {
        int v1 = 0;
        if(z) {
            this.zznx.zzb(v, 2);
            int v3 = 0;
            for(int v2 = 0; v2 < list0.size(); ++v2) {
                v3 += zzjr.zzah(((int)(((Integer)list0.get(v2)))));
            }
            this.zznx.zzy(v3);
            while(v1 < list0.size()) {
                int v4 = (int)(((Integer)list0.get(v1)));
                this.zznx.zzx(v4);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            int v5 = (int)(((Integer)list0.get(v1)));
            this.zznx.zzc(v, v5);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.drive.zzns
    public final void zzi(int v, long v1) throws IOException {
        this.zznx.zza(v, v1);
    }

    @Override  // com.google.android.gms.internal.drive.zzns
    public final void zzi(int v, List list0, boolean z) throws IOException {
        int v1 = 0;
        if(z) {
            this.zznx.zzb(v, 2);
            int v3 = 0;
            for(int v2 = 0; v2 < list0.size(); ++v2) {
                v3 += zzjr.zzd(((Boolean)list0.get(v2)).booleanValue());
            }
            this.zznx.zzy(v3);
            while(v1 < list0.size()) {
                boolean z1 = ((Boolean)list0.get(v1)).booleanValue();
                this.zznx.zzc(z1);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            boolean z2 = ((Boolean)list0.get(v1)).booleanValue();
            this.zznx.zzb(v, z2);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.drive.zzns
    public final void zzj(int v, long v1) throws IOException {
        this.zznx.zzc(v, v1);
    }

    @Override  // com.google.android.gms.internal.drive.zzns
    public final void zzj(int v, List list0, boolean z) throws IOException {
        int v1 = 0;
        if(z) {
            this.zznx.zzb(v, 2);
            int v3 = 0;
            for(int v2 = 0; v2 < list0.size(); ++v2) {
                v3 += zzjr.zzad(((int)(((Integer)list0.get(v2)))));
            }
            this.zznx.zzy(v3);
            while(v1 < list0.size()) {
                int v4 = (int)(((Integer)list0.get(v1)));
                this.zznx.zzy(v4);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            int v5 = (int)(((Integer)list0.get(v1)));
            this.zznx.zzd(v, v5);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.drive.zzns
    public final void zzk(int v, List list0, boolean z) throws IOException {
        int v1 = 0;
        if(z) {
            this.zznx.zzb(v, 2);
            int v3 = 0;
            for(int v2 = 0; v2 < list0.size(); ++v2) {
                v3 += zzjr.zzag(((int)(((Integer)list0.get(v2)))));
            }
            this.zznx.zzy(v3);
            while(v1 < list0.size()) {
                int v4 = (int)(((Integer)list0.get(v1)));
                this.zznx.zzaa(v4);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            int v5 = (int)(((Integer)list0.get(v1)));
            this.zznx.zzf(v, v5);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.drive.zzns
    public final void zzl(int v, List list0, boolean z) throws IOException {
        int v1 = 0;
        if(z) {
            this.zznx.zzb(v, 2);
            int v3 = 0;
            for(int v2 = 0; v2 < list0.size(); ++v2) {
                v3 += zzjr.zzs(((long)(((Long)list0.get(v2)))));
            }
            this.zznx.zzy(v3);
            while(v1 < list0.size()) {
                long v4 = (long)(((Long)list0.get(v1)));
                this.zznx.zzn(v4);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            long v5 = (long)(((Long)list0.get(v1)));
            this.zznx.zzc(v, v5);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.drive.zzns
    public final void zzm(int v, int v1) throws IOException {
        this.zznx.zzf(v, v1);
    }

    @Override  // com.google.android.gms.internal.drive.zzns
    public final void zzm(int v, List list0, boolean z) throws IOException {
        int v1 = 0;
        if(z) {
            this.zznx.zzb(v, 2);
            int v3 = 0;
            for(int v2 = 0; v2 < list0.size(); ++v2) {
                v3 += zzjr.zzae(((int)(((Integer)list0.get(v2)))));
            }
            this.zznx.zzy(v3);
            while(v1 < list0.size()) {
                int v4 = (int)(((Integer)list0.get(v1)));
                this.zznx.zzz(v4);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            int v5 = (int)(((Integer)list0.get(v1)));
            this.zznx.zze(v, v5);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.drive.zzns
    public final void zzn(int v, int v1) throws IOException {
        this.zznx.zzc(v, v1);
    }

    @Override  // com.google.android.gms.internal.drive.zzns
    public final void zzn(int v, List list0, boolean z) throws IOException {
        int v1 = 0;
        if(z) {
            this.zznx.zzb(v, 2);
            int v3 = 0;
            for(int v2 = 0; v2 < list0.size(); ++v2) {
                v3 += zzjr.zzq(((long)(((Long)list0.get(v2)))));
            }
            this.zznx.zzy(v3);
            while(v1 < list0.size()) {
                long v4 = (long)(((Long)list0.get(v1)));
                this.zznx.zzm(v4);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            long v5 = (long)(((Long)list0.get(v1)));
            this.zznx.zzb(v, v5);
            ++v1;
        }
    }
}

