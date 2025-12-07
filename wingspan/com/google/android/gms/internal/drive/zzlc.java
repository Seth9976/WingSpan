package com.google.android.gms.internal.drive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class zzlc extends zzla {
    private static final Class zzto;

    static {
        zzlc.zzto = Collections.unmodifiableList(Collections.emptyList()).getClass();
    }

    private zzlc() {
        super(null);
    }

    zzlc(zzlb zzlb0) {
    }

    @Override  // com.google.android.gms.internal.drive.zzla
    final void zza(Object object0, long v) {
        List list1;
        List list0 = (List)zznd.zzo(object0, v);
        if(list0 instanceof zzkz) {
            list1 = ((zzkz)list0).zzds();
        }
        else {
            Class class0 = list0.getClass();
            if(zzlc.zzto.isAssignableFrom(class0)) {
                return;
            }
            if(list0 instanceof zzmc && list0 instanceof zzkp) {
                if(((zzkp)list0).zzbo()) {
                    ((zzkp)list0).zzbp();
                }
                return;
            }
            list1 = Collections.unmodifiableList(list0);
        }
        zznd.zza(object0, v, list1);
    }

    @Override  // com.google.android.gms.internal.drive.zzla
    final void zza(Object object0, Object object1, long v) {
        ArrayList arrayList0;
        List list0 = zzlc.zzb(object1, v);
        int v1 = list0.size();
        List list1 = zzlc.zzb(object0, v);
        if(list1.isEmpty()) {
            if(list1 instanceof zzkz) {
                list1 = new zzky(v1);
            }
            else if(!(list1 instanceof zzmc) || !(list1 instanceof zzkp)) {
                list1 = new ArrayList(v1);
            }
            else {
                list1 = ((zzkp)list1).zzr(v1);
            }
            zznd.zza(object0, v, list1);
        }
        else {
            Class class0 = list1.getClass();
            if(zzlc.zzto.isAssignableFrom(class0)) {
                arrayList0 = new ArrayList(list1.size() + v1);
                arrayList0.addAll(list1);
                zznd.zza(object0, v, arrayList0);
                list1 = arrayList0;
            }
            else if(list1 instanceof zzna) {
                arrayList0 = new zzky(list1.size() + v1);
                ((zziw)arrayList0).addAll(((zzna)list1));
                zznd.zza(object0, v, arrayList0);
                list1 = arrayList0;
            }
            else if(list1 instanceof zzmc && list1 instanceof zzkp && !((zzkp)list1).zzbo()) {
                list1 = ((zzkp)list1).zzr(list1.size() + v1);
                zznd.zza(object0, v, list1);
            }
        }
        int v2 = list1.size();
        if(v2 > 0 && list0.size() > 0) {
            list1.addAll(list0);
        }
        if(v2 > 0) {
            list0 = list1;
        }
        zznd.zza(object0, v, list0);
    }

    private static List zzb(Object object0, long v) {
        return (List)zznd.zzo(object0, v);
    }
}

