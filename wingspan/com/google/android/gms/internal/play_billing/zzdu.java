package com.google.android.gms.internal.play_billing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class zzdu extends zzdy {
    private static final Class zza;

    static {
        zzdu.zza = Collections.unmodifiableList(Collections.emptyList()).getClass();
    }

    private zzdu() {
        super(null);
    }

    zzdu(zzdt zzdt0) {
        super(null);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzdy
    final void zza(Object object0, long v) {
        List list1;
        List list0 = (List)zzfw.zzf(object0, v);
        if(list0 instanceof zzds) {
            list1 = ((zzds)list0).zze();
            zzfw.zzs(object0, v, list1);
            return;
        }
        Class class0 = list0.getClass();
        if(!zzdu.zza.isAssignableFrom(class0)) {
            if(!(list0 instanceof zzer) || !(list0 instanceof zzdk)) {
                list1 = Collections.unmodifiableList(list0);
                zzfw.zzs(object0, v, list1);
            }
            else if(((zzdk)list0).zzc()) {
                ((zzdk)list0).zzb();
            }
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.zzdy
    final void zzb(Object object0, Object object1, long v) {
        ArrayList arrayList0;
        List list0 = (List)zzfw.zzf(object1, v);
        int v1 = list0.size();
        List list1 = (List)zzfw.zzf(object0, v);
        if(list1.isEmpty()) {
            if(list1 instanceof zzds) {
                list1 = new zzdr(v1);
            }
            else if(!(list1 instanceof zzer) || !(list1 instanceof zzdk)) {
                list1 = new ArrayList(v1);
            }
            else {
                list1 = ((zzdk)list1).zzd(v1);
            }
            zzfw.zzs(object0, v, list1);
        }
        else {
            Class class0 = list1.getClass();
            if(zzdu.zza.isAssignableFrom(class0)) {
                arrayList0 = new ArrayList(list1.size() + v1);
                arrayList0.addAll(list1);
                zzfw.zzs(object0, v, arrayList0);
                list1 = arrayList0;
            }
            else if(list1 instanceof zzfr) {
                arrayList0 = new zzdr(list1.size() + v1);
                ((zzbn)arrayList0).addAll(((zzdr)arrayList0).size(), ((zzfr)list1));
                zzfw.zzs(object0, v, arrayList0);
                list1 = arrayList0;
            }
            else if(list1 instanceof zzer && list1 instanceof zzdk && !((zzdk)list1).zzc()) {
                list1 = ((zzdk)list1).zzd(list1.size() + v1);
                zzfw.zzs(object0, v, list1);
            }
        }
        int v2 = list1.size();
        if(v2 > 0 && list0.size() > 0) {
            list1.addAll(list0);
        }
        if(v2 > 0) {
            list0 = list1;
        }
        zzfw.zzs(object0, v, list0);
    }
}

