package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.RandomAccess;
import sun.misc.Unsafe;

final class zzen implements zzev {
    private static final int[] zza;
    private static final Unsafe zzb;
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzek zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzdy zzl;
    private final zzfm zzm;
    private final zzcq zzn;
    private final zzep zzo;
    private final zzef zzp;

    static {
        zzen.zza = new int[0];
        zzen.zzb = zzfw.zzg();
    }

    private zzen(int[] arr_v, Object[] arr_object, int v, int v1, zzek zzek0, int v2, boolean z, int[] arr_v1, int v3, int v4, zzep zzep0, zzdy zzdy0, zzfm zzfm0, zzcq zzcq0, zzef zzef0) {
        this.zzc = arr_v;
        this.zzd = arr_object;
        this.zze = v;
        this.zzf = v1;
        this.zzh = zzcq0 != null && zzcq0.zzc(zzek0);
        this.zzi = arr_v1;
        this.zzj = v3;
        this.zzk = v4;
        this.zzo = zzep0;
        this.zzl = zzdy0;
        this.zzm = zzfm0;
        this.zzn = zzcq0;
        this.zzg = zzek0;
        this.zzp = zzef0;
    }

    private static void zzA(Object object0) {
        if(!zzen.zzL(object0)) {
            throw new IllegalArgumentException("Mutating immutable message: " + object0);
        }
    }

    private final void zzB(Object object0, Object object1, int v) {
        if(!this.zzI(object1, v)) {
            return;
        }
        int v1 = this.zzs(v);
        Unsafe unsafe0 = zzen.zzb;
        Object object2 = unsafe0.getObject(object1, ((long)(v1 & 0xFFFFF)));
        if(object2 == null) {
            throw new IllegalStateException("Source subfield " + this.zzc[v] + " is present but null: " + object1.toString());
        }
        zzev zzev0 = this.zzv(v);
        if(!this.zzI(object0, v)) {
            if(zzen.zzL(object2)) {
                Object object3 = zzev0.zze();
                zzev0.zzg(object3, object2);
                unsafe0.putObject(object0, ((long)(v1 & 0xFFFFF)), object3);
            }
            else {
                unsafe0.putObject(object0, ((long)(v1 & 0xFFFFF)), object2);
            }
            this.zzD(object0, v);
            return;
        }
        Object object4 = unsafe0.getObject(object0, ((long)(v1 & 0xFFFFF)));
        if(!zzen.zzL(object4)) {
            Object object5 = zzev0.zze();
            zzev0.zzg(object5, object4);
            unsafe0.putObject(object0, ((long)(v1 & 0xFFFFF)), object5);
            object4 = object5;
        }
        zzev0.zzg(object4, object2);
    }

    private final void zzC(Object object0, Object object1, int v) {
        int v1 = this.zzc[v];
        if(!this.zzM(object1, v1, v)) {
            return;
        }
        int v2 = this.zzs(v);
        Unsafe unsafe0 = zzen.zzb;
        Object object2 = unsafe0.getObject(object1, ((long)(v2 & 0xFFFFF)));
        if(object2 == null) {
            throw new IllegalStateException("Source subfield " + this.zzc[v] + " is present but null: " + object1.toString());
        }
        zzev zzev0 = this.zzv(v);
        if(!this.zzM(object0, v1, v)) {
            if(zzen.zzL(object2)) {
                Object object3 = zzev0.zze();
                zzev0.zzg(object3, object2);
                unsafe0.putObject(object0, ((long)(v2 & 0xFFFFF)), object3);
            }
            else {
                unsafe0.putObject(object0, ((long)(v2 & 0xFFFFF)), object2);
            }
            this.zzE(object0, v1, v);
            return;
        }
        Object object4 = unsafe0.getObject(object0, ((long)(v2 & 0xFFFFF)));
        if(!zzen.zzL(object4)) {
            Object object5 = zzev0.zze();
            zzev0.zzg(object5, object4);
            unsafe0.putObject(object0, ((long)(v2 & 0xFFFFF)), object5);
            object4 = object5;
        }
        zzev0.zzg(object4, object2);
    }

    private final void zzD(Object object0, int v) {
        int v1 = this.zzp(v);
        if(((long)(0xFFFFF & v1)) == 0xFFFFFL) {
            return;
        }
        zzfw.zzq(object0, ((long)(0xFFFFF & v1)), 1 << (v1 >>> 20) | zzfw.zzc(object0, ((long)(0xFFFFF & v1))));
    }

    private final void zzE(Object object0, int v, int v1) {
        zzfw.zzq(object0, ((long)(this.zzp(v1) & 0xFFFFF)), v);
    }

    private final void zzF(Object object0, int v, Object object1) {
        int v1 = this.zzs(v);
        zzen.zzb.putObject(object0, ((long)(v1 & 0xFFFFF)), object1);
        this.zzD(object0, v);
    }

    private final void zzG(Object object0, int v, int v1, Object object1) {
        int v2 = this.zzs(v1);
        zzen.zzb.putObject(object0, ((long)(v2 & 0xFFFFF)), object1);
        this.zzE(object0, v, v1);
    }

    private final boolean zzH(Object object0, Object object1, int v) {
        return this.zzI(object0, v) == this.zzI(object1, v);
    }

    private final boolean zzI(Object object0, int v) {
        int v1 = this.zzp(v);
        if(Long.compare(v1 & 0xFFFFF, 0xFFFFFL) == 0) {
            int v2 = this.zzs(v);
            switch(v2 >>> 20 & 0xFF) {
                case 0: {
                    return Double.doubleToRawLongBits(zzfw.zza(object0, ((long)(v2 & 0xFFFFF)))) != 0L;
                }
                case 1: {
                    return Float.floatToRawIntBits(zzfw.zzb(object0, ((long)(v2 & 0xFFFFF)))) != 0;
                }
                case 2: {
                    return zzfw.zzd(object0, ((long)(v2 & 0xFFFFF))) != 0L;
                }
                case 3: {
                    return zzfw.zzd(object0, ((long)(v2 & 0xFFFFF))) != 0L;
                }
                case 4: {
                    return zzfw.zzc(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 5: {
                    return zzfw.zzd(object0, ((long)(v2 & 0xFFFFF))) != 0L;
                }
                case 6: {
                    return zzfw.zzc(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 7: {
                    return zzfw.zzw(object0, ((long)(v2 & 0xFFFFF)));
                }
                case 8: {
                    Object object1 = zzfw.zzf(object0, ((long)(v2 & 0xFFFFF)));
                    if(object1 instanceof String) {
                        return !((String)object1).isEmpty();
                    }
                    if(!(object1 instanceof zzcc)) {
                        throw new IllegalArgumentException();
                    }
                    return !zzcc.zzb.equals(object1);
                }
                case 9: {
                    return zzfw.zzf(object0, ((long)(v2 & 0xFFFFF))) != null;
                }
                case 10: {
                    Object object2 = zzfw.zzf(object0, ((long)(v2 & 0xFFFFF)));
                    return !zzcc.zzb.equals(object2);
                }
                case 11: {
                    return zzfw.zzc(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 12: {
                    return zzfw.zzc(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 13: {
                    return zzfw.zzc(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 14: {
                    return zzfw.zzd(object0, ((long)(v2 & 0xFFFFF))) != 0L;
                }
                case 15: {
                    return zzfw.zzc(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 16: {
                    return zzfw.zzd(object0, ((long)(v2 & 0xFFFFF))) != 0L;
                }
                case 17: {
                    return zzfw.zzf(object0, ((long)(v2 & 0xFFFFF))) != null;
                }
                default: {
                    throw new IllegalArgumentException();
                }
            }
        }
        return (zzfw.zzc(object0, ((long)(v1 & 0xFFFFF))) & 1 << (v1 >>> 20)) != 0;
    }

    private final boolean zzJ(Object object0, int v, int v1, int v2, int v3) {
        return v1 == 0xFFFFF ? this.zzI(object0, v) : (v2 & v3) != 0;
    }

    private static boolean zzK(Object object0, int v, zzev zzev0) {
        return zzev0.zzk(zzfw.zzf(object0, ((long)(v & 0xFFFFF))));
    }

    private static boolean zzL(Object object0) {
        if(object0 == null) {
            return false;
        }
        return object0 instanceof zzdd ? ((zzdd)object0).zzx() : true;
    }

    private final boolean zzM(Object object0, int v, int v1) {
        return zzfw.zzc(object0, ((long)(this.zzp(v1) & 0xFFFFF))) == v;
    }

    private static boolean zzN(Object object0, long v) {
        return ((Boolean)zzfw.zzf(object0, v)).booleanValue();
    }

    private static final void zzO(int v, Object object0, zzge zzge0) throws IOException {
        if(object0 instanceof String) {
            zzge0.zzF(v, ((String)object0));
            return;
        }
        zzge0.zzd(v, ((zzcc)object0));
    }

    @Override  // com.google.android.gms.internal.play_billing.zzev
    public final int zza(Object object0) {
        int v44;
        int v42;
        int v41;
        int v40;
        int v37;
        int v33;
        int v25;
        int v24;
        int v23;
        int v20;
        int v19;
        int v18;
        int v17;
        int v16;
        int v15;
        int v14;
        int v13;
        int v11;
        int v10;
        int v9;
        Unsafe unsafe0 = zzen.zzb;
        int v = 0;
        int v1 = 0;
        int v2 = 0;
        int v3 = 0xFFFFF;
        while(v1 < this.zzc.length) {
            int v4 = this.zzs(v1);
            int v5 = v4 >>> 20 & 0xFF;
            int v6 = this.zzc[v1];
            int v7 = this.zzc[v1 + 2];
            int v8 = v7 & 0xFFFFF;
            if(v5 <= 17) {
                if(v8 != v3) {
                    v = v8 == 0xFFFFF ? 0 : unsafe0.getInt(object0, ((long)v8));
                    v3 = v8;
                }
                v9 = 1 << (v7 >>> 20);
                v10 = v3;
                v11 = v;
            }
            else {
                v10 = v3;
                v11 = v;
                v9 = 0;
            }
            boolean z = v5 < zzcv.zzJ.zza();
            long v12 = (long)(v4 & 0xFFFFF);
            switch(v5) {
                case 0: {
                    if(this.zzJ(object0, v1, v10, v11, v9)) {
                        v13 = zzck.zzw(v6 << 3);
                        v17 = v13 + 8;
                        v2 += v17;
                        break;
                    }
                    break;
                }
                case 1: {
                    if(this.zzJ(object0, v1, v10, v11, v9)) {
                        v14 = zzck.zzw(v6 << 3);
                        v17 = v14 + 4;
                        v2 += v17;
                        break;
                    }
                    break;
                }
                case 2: {
                    if(this.zzJ(object0, v1, v10, v11, v9)) {
                        v15 = zzck.zzw(v6 << 3);
                        v16 = zzck.zzx(unsafe0.getLong(object0, v12));
                        goto label_385;
                    }
                    break;
                }
                case 3: {
                    if(this.zzJ(object0, v1, v10, v11, v9)) {
                        v15 = zzck.zzw(v6 << 3);
                        v16 = zzck.zzx(unsafe0.getLong(object0, v12));
                        goto label_385;
                    }
                    break;
                }
                case 4: {
                    if(this.zzJ(object0, v1, v10, v11, v9)) {
                        v15 = zzck.zzw(v6 << 3);
                        v16 = zzck.zzx(unsafe0.getInt(object0, v12));
                        goto label_385;
                    }
                    break;
                }
                case 5: {
                    if(this.zzJ(object0, v1, v10, v11, v9)) {
                        v13 = zzck.zzw(v6 << 3);
                        v17 = v13 + 8;
                        v2 += v17;
                        break;
                    }
                    break;
                }
                case 6: {
                    if(this.zzJ(object0, v1, v10, v11, v9)) {
                        v14 = zzck.zzw(v6 << 3);
                        v17 = v14 + 4;
                        v2 += v17;
                        break;
                    }
                    break;
                }
                case 7: {
                    if(this.zzJ(object0, v1, v10, v11, v9)) {
                        v17 = zzck.zzw(v6 << 3) + 1;
                        v2 += v17;
                        break;
                    }
                    break;
                }
                case 8: {
                    if(this.zzJ(object0, v1, v10, v11, v9)) {
                        Object object1 = unsafe0.getObject(object0, v12);
                        if(object1 instanceof zzcc) {
                            v18 = zzck.zzw(v6 << 3);
                            v19 = ((zzcc)object1).zzd();
                            v20 = zzck.zzw(v19);
                            goto label_355;
                        }
                        else {
                            v15 = zzck.zzw(v6 << 3);
                            v16 = zzck.zzv(((String)object1));
                            goto label_385;
                        }
                        goto label_63;
                    }
                    break;
                }
                case 9: {
                label_63:
                    if(this.zzJ(object0, v1, v10, v11, v9)) {
                        v17 = zzex.zzh(v6, unsafe0.getObject(object0, v12), this.zzv(v1));
                        v2 += v17;
                        break;
                    }
                    break;
                }
                case 10: {
                    if(this.zzJ(object0, v1, v10, v11, v9)) {
                        v18 = zzck.zzw(v6 << 3);
                        v19 = ((zzcc)unsafe0.getObject(object0, v12)).zzd();
                        v20 = zzck.zzw(v19);
                        goto label_355;
                    }
                    break;
                }
                case 11: {
                    if(this.zzJ(object0, v1, v10, v11, v9)) {
                        v15 = zzck.zzw(v6 << 3);
                        v16 = zzck.zzw(unsafe0.getInt(object0, v12));
                        goto label_385;
                    }
                    break;
                }
                case 12: {
                    if(this.zzJ(object0, v1, v10, v11, v9)) {
                        v15 = zzck.zzw(v6 << 3);
                        v16 = zzck.zzx(unsafe0.getInt(object0, v12));
                        goto label_385;
                    }
                    break;
                }
                case 13: {
                    if(this.zzJ(object0, v1, v10, v11, v9)) {
                        v14 = zzck.zzw(v6 << 3);
                        v17 = v14 + 4;
                        v2 += v17;
                        break;
                    }
                    break;
                }
                case 14: {
                    if(this.zzJ(object0, v1, v10, v11, v9)) {
                        v13 = zzck.zzw(v6 << 3);
                        v17 = v13 + 8;
                        v2 += v17;
                        break;
                    }
                    break;
                }
                case 15: {
                    if(this.zzJ(object0, v1, v10, v11, v9)) {
                        int v21 = unsafe0.getInt(object0, v12);
                        v15 = zzck.zzw(v6 << 3);
                        v16 = zzck.zzw(v21 >> 0x1F ^ v21 + v21);
                        goto label_385;
                    }
                    break;
                }
                case 16: {
                    if(this.zzJ(object0, v1, v10, v11, v9)) {
                        long v22 = unsafe0.getLong(object0, v12);
                        v15 = zzck.zzw(v6 << 3);
                        v16 = zzck.zzx(v22 >> 0x3F ^ v22 + v22);
                        goto label_385;
                    }
                    break;
                }
                case 17: {
                    if(this.zzJ(object0, v1, v10, v11, v9)) {
                        v17 = zzck.zzt(v6, ((zzek)unsafe0.getObject(object0, v12)), this.zzv(v1));
                        v2 += v17;
                        break;
                    }
                    break;
                }
                case 18: {
                    v17 = zzex.zzd(v6, ((List)unsafe0.getObject(object0, v12)), false);
                    v2 += v17;
                    break;
                }
                case 19: {
                    v17 = zzex.zzb(v6, ((List)unsafe0.getObject(object0, v12)), false);
                    v2 += v17;
                    break;
                }
                case 20: {
                    List list0 = (List)unsafe0.getObject(object0, v12);
                    v23 = list0.size() == 0 ? 0 : zzex.zzg(list0) + list0.size() * zzck.zzw(v6 << 3);
                    v2 += v23;
                    break;
                }
                case 21: {
                    List list1 = (List)unsafe0.getObject(object0, v12);
                    v24 = list1.size();
                    if(v24 != 0) {
                        v15 = zzex.zzl(list1);
                        v25 = zzck.zzw(v6 << 3);
                        v16 = v24 * v25;
                        goto label_385;
                    }
                    v17 = 0;
                    v2 += v17;
                    break;
                }
                case 22: {
                    List list2 = (List)unsafe0.getObject(object0, v12);
                    v24 = list2.size();
                    if(v24 != 0) {
                        v15 = zzex.zzf(list2);
                        v25 = zzck.zzw(v6 << 3);
                        v16 = v24 * v25;
                        goto label_385;
                    }
                    v17 = 0;
                    v2 += v17;
                    break;
                }
                case 23: {
                    v17 = zzex.zzd(v6, ((List)unsafe0.getObject(object0, v12)), false);
                    v2 += v17;
                    break;
                }
                case 24: {
                    v17 = zzex.zzb(v6, ((List)unsafe0.getObject(object0, v12)), false);
                    v2 += v17;
                    break;
                }
                case 25: {
                    int v26 = ((List)unsafe0.getObject(object0, v12)).size();
                    if(v26 != 0) {
                        v17 = v26 * (zzck.zzw(v6 << 3) + 1);
                        v2 += v17;
                        break;
                    }
                    v17 = 0;
                    v2 += v17;
                    break;
                }
                case 26: {
                    List list3 = (List)unsafe0.getObject(object0, v12);
                    int v27 = list3.size();
                    if(v27 == 0) {
                        v23 = 0;
                    }
                    else {
                        v23 = zzck.zzw(v6 << 3) * v27;
                        if(list3 instanceof zzds) {
                            zzds zzds0 = (zzds)list3;
                            for(int v28 = 0; v28 < v27; ++v28) {
                                Object object2 = zzds0.zzf(v28);
                                if(object2 instanceof zzcc) {
                                    int v29 = ((zzcc)object2).zzd();
                                    v23 += zzck.zzw(v29) + v29;
                                }
                                else {
                                    v23 += zzck.zzv(((String)object2));
                                }
                            }
                        }
                        else {
                            for(int v30 = 0; v30 < v27; ++v30) {
                                Object object3 = list3.get(v30);
                                if(object3 instanceof zzcc) {
                                    int v31 = ((zzcc)object3).zzd();
                                    v23 += zzck.zzw(v31) + v31;
                                }
                                else {
                                    v23 += zzck.zzv(((String)object3));
                                }
                            }
                        }
                    }
                    v2 += v23;
                    break;
                }
                case 27: {
                    List list4 = (List)unsafe0.getObject(object0, v12);
                    zzev zzev0 = this.zzv(v1);
                    int v32 = list4.size();
                    if(v32 == 0) {
                        v33 = 0;
                    }
                    else {
                        v33 = zzck.zzw(v6 << 3) * v32;
                        for(int v34 = 0; v34 < v32; ++v34) {
                            Object object4 = list4.get(v34);
                            if(object4 instanceof zzdq) {
                                int v35 = ((zzdq)object4).zza();
                                v33 += zzck.zzw(v35) + v35;
                            }
                            else {
                                v33 += zzck.zzu(((zzek)object4), zzev0);
                            }
                        }
                    }
                    v2 += v33;
                    break;
                }
                case 28: {
                    List list5 = (List)unsafe0.getObject(object0, v12);
                    int v36 = list5.size();
                    if(v36 == 0) {
                        v37 = 0;
                    }
                    else {
                        v37 = v36 * zzck.zzw(v6 << 3);
                        for(int v38 = 0; v38 < list5.size(); ++v38) {
                            int v39 = ((zzcc)list5.get(v38)).zzd();
                            v37 += zzck.zzw(v39) + v39;
                        }
                    }
                    v2 += v37;
                    break;
                }
                case 29: {
                    List list6 = (List)unsafe0.getObject(object0, v12);
                    v24 = list6.size();
                    if(v24 != 0) {
                        v15 = zzex.zzk(list6);
                        v25 = zzck.zzw(v6 << 3);
                        v16 = v24 * v25;
                        goto label_385;
                    }
                    v17 = 0;
                    v2 += v17;
                    break;
                }
                case 30: {
                    List list7 = (List)unsafe0.getObject(object0, v12);
                    v24 = list7.size();
                    if(v24 != 0) {
                        v15 = zzex.zza(list7);
                        v25 = zzck.zzw(v6 << 3);
                        v16 = v24 * v25;
                        goto label_385;
                    }
                    v17 = 0;
                    v2 += v17;
                    break;
                }
                case 0x1F: {
                    v17 = zzex.zzb(v6, ((List)unsafe0.getObject(object0, v12)), false);
                    v2 += v17;
                    break;
                }
                case 0x20: {
                    v17 = zzex.zzd(v6, ((List)unsafe0.getObject(object0, v12)), false);
                    v2 += v17;
                    break;
                }
                case 33: {
                    List list8 = (List)unsafe0.getObject(object0, v12);
                    v24 = list8.size();
                    if(v24 != 0) {
                        v15 = zzex.zzi(list8);
                        v25 = zzck.zzw(v6 << 3);
                        v16 = v24 * v25;
                        goto label_385;
                    }
                    v17 = 0;
                    v2 += v17;
                    break;
                }
                case 34: {
                    List list9 = (List)unsafe0.getObject(object0, v12);
                    v24 = list9.size();
                    if(v24 == 0) {
                        v17 = 0;
                        v2 += v17;
                        break;
                    }
                    else {
                        v15 = zzex.zzj(list9);
                        v16 = v24 * zzck.zzw(v6 << 3);
                        goto label_385;
                    }
                    goto label_224;
                }
                case 35: {
                label_224:
                    v40 = zzex.zze(((List)unsafe0.getObject(object0, v12)));
                    if(v40 > 0) {
                        v41 = zzck.zzw(v6 << 3);
                        v42 = zzck.zzw(v40);
                        v37 = v41 + v42 + v40;
                        v2 += v37;
                        break;
                    }
                    break;
                }
                case 36: {
                    v40 = zzex.zzc(((List)unsafe0.getObject(object0, v12)));
                    if(v40 > 0) {
                        v41 = zzck.zzw(v6 << 3);
                        v42 = zzck.zzw(v40);
                        v37 = v41 + v42 + v40;
                        v2 += v37;
                        break;
                    }
                    break;
                }
                case 37: {
                    v40 = zzex.zzg(((List)unsafe0.getObject(object0, v12)));
                    if(v40 > 0) {
                        v41 = zzck.zzw(v6 << 3);
                        v42 = zzck.zzw(v40);
                        v37 = v41 + v42 + v40;
                        v2 += v37;
                        break;
                    }
                    break;
                }
                case 38: {
                    v40 = zzex.zzl(((List)unsafe0.getObject(object0, v12)));
                    if(v40 > 0) {
                        v41 = zzck.zzw(v6 << 3);
                        v42 = zzck.zzw(v40);
                        v37 = v41 + v42 + v40;
                        v2 += v37;
                        break;
                    }
                    break;
                }
                case 39: {
                    v40 = zzex.zzf(((List)unsafe0.getObject(object0, v12)));
                    if(v40 > 0) {
                        v41 = zzck.zzw(v6 << 3);
                        v42 = zzck.zzw(v40);
                        v37 = v41 + v42 + v40;
                        v2 += v37;
                        break;
                    }
                    break;
                }
                case 40: {
                    v40 = zzex.zze(((List)unsafe0.getObject(object0, v12)));
                    if(v40 > 0) {
                        v41 = zzck.zzw(v6 << 3);
                        v42 = zzck.zzw(v40);
                        v37 = v41 + v42 + v40;
                        v2 += v37;
                        break;
                    }
                    break;
                }
                case 41: {
                    v40 = zzex.zzc(((List)unsafe0.getObject(object0, v12)));
                    if(v40 > 0) {
                        v41 = zzck.zzw(v6 << 3);
                        v42 = zzck.zzw(v40);
                        v37 = v41 + v42 + v40;
                        v2 += v37;
                        break;
                    }
                    break;
                }
                case 42: {
                    v40 = ((List)unsafe0.getObject(object0, v12)).size();
                    if(v40 > 0) {
                        v41 = zzck.zzw(v6 << 3);
                        v42 = zzck.zzw(v40);
                        v37 = v41 + v42 + v40;
                        v2 += v37;
                        break;
                    }
                    break;
                }
                case 43: {
                    v40 = zzex.zzk(((List)unsafe0.getObject(object0, v12)));
                    if(v40 > 0) {
                        v41 = zzck.zzw(v6 << 3);
                        v42 = zzck.zzw(v40);
                        v37 = v41 + v42 + v40;
                        v2 += v37;
                        break;
                    }
                    break;
                }
                case 44: {
                    v40 = zzex.zza(((List)unsafe0.getObject(object0, v12)));
                    if(v40 > 0) {
                        v41 = zzck.zzw(v6 << 3);
                        v42 = zzck.zzw(v40);
                        v37 = v41 + v42 + v40;
                        v2 += v37;
                        break;
                    }
                    break;
                }
                case 45: {
                    v40 = zzex.zzc(((List)unsafe0.getObject(object0, v12)));
                    if(v40 > 0) {
                        v41 = zzck.zzw(v6 << 3);
                        v42 = zzck.zzw(v40);
                        v37 = v41 + v42 + v40;
                        v2 += v37;
                        break;
                    }
                    break;
                }
                case 46: {
                    v40 = zzex.zze(((List)unsafe0.getObject(object0, v12)));
                    if(v40 > 0) {
                        v41 = zzck.zzw(v6 << 3);
                        v42 = zzck.zzw(v40);
                        v37 = v41 + v42 + v40;
                        v2 += v37;
                        break;
                    }
                    break;
                }
                case 0x2F: {
                    v40 = zzex.zzi(((List)unsafe0.getObject(object0, v12)));
                    if(v40 > 0) {
                        v41 = zzck.zzw(v6 << 3);
                        v42 = zzck.zzw(v40);
                        v37 = v41 + v42 + v40;
                        v2 += v37;
                    }
                    break;
                }
                case 0x30: {
                    v40 = zzex.zzj(((List)unsafe0.getObject(object0, v12)));
                    if(v40 > 0) {
                        v2 += zzck.zzw(v6 << 3) + zzck.zzw(v40) + v40;
                    }
                    break;
                }
                case 49: {
                    List list10 = (List)unsafe0.getObject(object0, v12);
                    zzev zzev1 = this.zzv(v1);
                    int v43 = list10.size();
                    if(v43 == 0) {
                        v44 = 0;
                    }
                    else {
                        v44 = 0;
                        for(int v45 = 0; v45 < v43; ++v45) {
                            v44 += zzck.zzt(v6, ((zzek)list10.get(v45)), zzev1);
                        }
                    }
                    v2 += v44;
                    break;
                }
                case 50: {
                    Object object5 = unsafe0.getObject(object0, v12);
                    Object object6 = this.zzw(v1);
                    zzee zzee0 = (zzee)object5;
                    zzed zzed0 = (zzed)object6;
                    if(!zzee0.isEmpty()) {
                        Iterator iterator0 = zzee0.entrySet().iterator();
                        if(iterator0.hasNext()) {
                            Object object7 = iterator0.next();
                            ((Map.Entry)object7).getKey();
                            ((Map.Entry)object7).getValue();
                            throw null;
                        }
                    }
                    break;
                }
                case 51: {
                    if(this.zzM(object0, v6, v1)) {
                        v13 = zzck.zzw(v6 << 3);
                        v17 = v13 + 8;
                        v2 += v17;
                        break;
                    }
                    break;
                }
                case 52: {
                    if(this.zzM(object0, v6, v1)) {
                        v14 = zzck.zzw(v6 << 3);
                        v17 = v14 + 4;
                        v2 += v17;
                        break;
                    }
                    break;
                }
                case 53: {
                    if(this.zzM(object0, v6, v1)) {
                        v15 = zzck.zzw(v6 << 3);
                        v16 = zzck.zzx(zzen.zzt(object0, v12));
                        goto label_385;
                    }
                    break;
                }
                case 54: {
                    if(this.zzM(object0, v6, v1)) {
                        v15 = zzck.zzw(v6 << 3);
                        v16 = zzck.zzx(zzen.zzt(object0, v12));
                        goto label_385;
                    }
                    break;
                }
                case 55: {
                    if(this.zzM(object0, v6, v1)) {
                        v15 = zzck.zzw(v6 << 3);
                        v16 = zzck.zzx(zzen.zzo(object0, v12));
                        goto label_385;
                    }
                    break;
                }
                case 56: {
                    if(this.zzM(object0, v6, v1)) {
                        v13 = zzck.zzw(v6 << 3);
                        v17 = v13 + 8;
                        v2 += v17;
                        break;
                    }
                    break;
                }
                case 57: {
                    if(this.zzM(object0, v6, v1)) {
                        v14 = zzck.zzw(v6 << 3);
                        v17 = v14 + 4;
                        v2 += v17;
                        break;
                    }
                    break;
                }
                case 58: {
                    if(this.zzM(object0, v6, v1)) {
                        v17 = zzck.zzw(v6 << 3) + 1;
                        v2 += v17;
                        break;
                    }
                    break;
                }
                case 59: {
                    if(this.zzM(object0, v6, v1)) {
                        Object object8 = unsafe0.getObject(object0, v12);
                        if(object8 instanceof zzcc) {
                            v18 = zzck.zzw(v6 << 3);
                            v19 = ((zzcc)object8).zzd();
                            v20 = zzck.zzw(v19);
                        label_355:
                            v17 = v18 + (v20 + v19);
                            v2 += v17;
                            break;
                        }
                        else {
                            v15 = zzck.zzw(v6 << 3);
                            v16 = zzck.zzv(((String)object8));
                            goto label_385;
                        }
                        goto label_360;
                    }
                    break;
                }
                case 60: {
                label_360:
                    if(this.zzM(object0, v6, v1)) {
                        v17 = zzex.zzh(v6, unsafe0.getObject(object0, v12), this.zzv(v1));
                        v2 += v17;
                        break;
                    }
                    break;
                }
                case 61: {
                    if(this.zzM(object0, v6, v1)) {
                        v19 = ((zzcc)unsafe0.getObject(object0, v12)).zzd();
                        v17 = zzck.zzw(v6 << 3) + (zzck.zzw(v19) + v19);
                        v2 += v17;
                        break;
                    }
                    break;
                }
                case 62: {
                    if(this.zzM(object0, v6, v1)) {
                        v15 = zzck.zzw(v6 << 3);
                        v16 = zzck.zzw(zzen.zzo(object0, v12));
                        goto label_385;
                    }
                    break;
                }
                case 0x3F: {
                    if(this.zzM(object0, v6, v1)) {
                        v15 = zzck.zzw(v6 << 3);
                        v16 = zzck.zzx(zzen.zzo(object0, v12));
                        goto label_385;
                    }
                    break;
                }
                case 0x40: {
                    if(this.zzM(object0, v6, v1)) {
                        v17 = zzck.zzw(v6 << 3) + 4;
                        v2 += v17;
                        break;
                    }
                    break;
                }
                case 65: {
                    if(this.zzM(object0, v6, v1)) {
                        v17 = zzck.zzw(v6 << 3) + 8;
                        v2 += v17;
                        break;
                    }
                    break;
                }
                case 66: {
                    if(this.zzM(object0, v6, v1)) {
                        int v46 = zzen.zzo(object0, v12);
                        v15 = zzck.zzw(v6 << 3);
                        v16 = zzck.zzw(v46 >> 0x1F ^ v46 + v46);
                    label_385:
                        v17 = v15 + v16;
                        v2 += v17;
                        break;
                    }
                    break;
                }
                case 67: {
                    if(this.zzM(object0, v6, v1)) {
                        long v47 = zzen.zzt(object0, v12);
                        v17 = zzck.zzw(v6 << 3) + zzck.zzx(v47 >> 0x3F ^ v47 + v47);
                        v2 += v17;
                    }
                    break;
                }
                case 68: {
                    if(this.zzM(object0, v6, v1)) {
                        v2 += zzck.zzt(v6, ((zzek)unsafe0.getObject(object0, v12)), this.zzv(v1));
                    }
                }
            }
            v1 += 3;
            v3 = v10;
            v = v11;
        }
        Object object9 = this.zzm.zzd(object0);
        int v48 = this.zzm.zza(object9);
        if(!this.zzh) {
            return v2 + v48;
        }
        this.zzn.zza(object0);
        throw null;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzev
    public final int zzb(Object object0) {
        int v8;
        long v7;
        int v6;
        int v1 = 0;
        for(int v = 0; v < this.zzc.length; v += 3) {
            int v2 = this.zzs(v);
            int v3 = this.zzc[v];
            long v4 = (long)(0xFFFFF & v2);
            int v5 = 37;
            switch(v2 >>> 20 & 0xFF) {
                case 0: {
                    v6 = v1 * 53;
                    v7 = Double.doubleToLongBits(zzfw.zza(object0, v4));
                    v8 = (int)(v7 ^ v7 >>> 0x20);
                    v1 = v6 + v8;
                    break;
                }
                case 1: {
                    v6 = v1 * 53;
                    v8 = Float.floatToIntBits(zzfw.zzb(object0, v4));
                    v1 = v6 + v8;
                    break;
                }
                case 2: {
                    v6 = v1 * 53;
                    v7 = zzfw.zzd(object0, v4);
                    v8 = (int)(v7 ^ v7 >>> 0x20);
                    v1 = v6 + v8;
                    break;
                }
                case 3: {
                    v6 = v1 * 53;
                    v7 = zzfw.zzd(object0, v4);
                    v8 = (int)(v7 ^ v7 >>> 0x20);
                    v1 = v6 + v8;
                    break;
                }
                case 4: {
                    v6 = v1 * 53;
                    v8 = zzfw.zzc(object0, v4);
                    v1 = v6 + v8;
                    break;
                }
                case 5: {
                    v6 = v1 * 53;
                    v7 = zzfw.zzd(object0, v4);
                    v8 = (int)(v7 ^ v7 >>> 0x20);
                    v1 = v6 + v8;
                    break;
                }
                case 6: {
                    v6 = v1 * 53;
                    v8 = zzfw.zzc(object0, v4);
                    v1 = v6 + v8;
                    break;
                }
                case 7: {
                    v6 = v1 * 53;
                    v8 = zzdl.zza(zzfw.zzw(object0, v4));
                    v1 = v6 + v8;
                    break;
                }
                case 8: {
                    v6 = v1 * 53;
                    v8 = ((String)zzfw.zzf(object0, v4)).hashCode();
                    v1 = v6 + v8;
                    break;
                }
                case 9: {
                    Object object1 = zzfw.zzf(object0, v4);
                    if(object1 != null) {
                        v5 = object1.hashCode();
                    }
                    v1 = v1 * 53 + v5;
                    break;
                }
                case 10: {
                    v6 = v1 * 53;
                    v8 = zzfw.zzf(object0, v4).hashCode();
                    v1 = v6 + v8;
                    break;
                }
                case 11: {
                    v6 = v1 * 53;
                    v8 = zzfw.zzc(object0, v4);
                    v1 = v6 + v8;
                    break;
                }
                case 12: {
                    v6 = v1 * 53;
                    v8 = zzfw.zzc(object0, v4);
                    v1 = v6 + v8;
                    break;
                }
                case 13: {
                    v6 = v1 * 53;
                    v8 = zzfw.zzc(object0, v4);
                    v1 = v6 + v8;
                    break;
                }
                case 14: {
                    v6 = v1 * 53;
                    v7 = zzfw.zzd(object0, v4);
                    v8 = (int)(v7 ^ v7 >>> 0x20);
                    v1 = v6 + v8;
                    break;
                }
                case 15: {
                    v6 = v1 * 53;
                    v8 = zzfw.zzc(object0, v4);
                    v1 = v6 + v8;
                    break;
                }
                case 16: {
                    v6 = v1 * 53;
                    v7 = zzfw.zzd(object0, v4);
                    v8 = (int)(v7 ^ v7 >>> 0x20);
                    v1 = v6 + v8;
                    break;
                }
                case 17: {
                    Object object2 = zzfw.zzf(object0, v4);
                    if(object2 != null) {
                        v5 = object2.hashCode();
                    }
                    v1 = v1 * 53 + v5;
                    break;
                }
                case 18: 
                case 19: 
                case 20: 
                case 21: 
                case 22: 
                case 23: 
                case 24: 
                case 25: 
                case 26: 
                case 27: 
                case 28: 
                case 29: 
                case 30: 
                case 0x1F: 
                case 0x20: 
                case 33: 
                case 34: 
                case 35: 
                case 36: 
                case 37: 
                case 38: 
                case 39: 
                case 40: 
                case 41: 
                case 42: 
                case 43: 
                case 44: 
                case 45: 
                case 46: 
                case 0x2F: 
                case 0x30: 
                case 49: {
                    v1 = v1 * 53 + zzfw.zzf(object0, v4).hashCode();
                    break;
                }
                case 50: {
                    v1 = v1 * 53 + zzfw.zzf(object0, v4).hashCode();
                    break;
                }
                case 51: {
                    if(this.zzM(object0, v3, v)) {
                        v7 = Double.doubleToLongBits(zzen.zzm(object0, v4));
                        v1 = v1 * 53 + ((int)(v7 ^ v7 >>> 0x20));
                    }
                    break;
                }
                case 52: {
                    if(this.zzM(object0, v3, v)) {
                        v1 = v1 * 53 + Float.floatToIntBits(zzen.zzn(object0, v4));
                    }
                    break;
                }
                case 53: {
                    if(this.zzM(object0, v3, v)) {
                        v7 = zzen.zzt(object0, v4);
                        v1 = v1 * 53 + ((int)(v7 ^ v7 >>> 0x20));
                    }
                    break;
                }
                case 54: {
                    if(this.zzM(object0, v3, v)) {
                        v7 = zzen.zzt(object0, v4);
                        v1 = v1 * 53 + ((int)(v7 ^ v7 >>> 0x20));
                    }
                    break;
                }
                case 55: {
                    if(this.zzM(object0, v3, v)) {
                        v1 = v1 * 53 + zzen.zzo(object0, v4);
                    }
                    break;
                }
                case 56: {
                    if(this.zzM(object0, v3, v)) {
                        v7 = zzen.zzt(object0, v4);
                        v1 = v1 * 53 + ((int)(v7 ^ v7 >>> 0x20));
                    }
                    break;
                }
                case 57: {
                    if(this.zzM(object0, v3, v)) {
                        v1 = v1 * 53 + zzen.zzo(object0, v4);
                    }
                    break;
                }
                case 58: {
                    if(this.zzM(object0, v3, v)) {
                        v1 = v1 * 53 + zzdl.zza(zzen.zzN(object0, v4));
                    }
                    break;
                }
                case 59: {
                    if(this.zzM(object0, v3, v)) {
                        v1 = v1 * 53 + ((String)zzfw.zzf(object0, v4)).hashCode();
                    }
                    break;
                }
                case 60: {
                    if(this.zzM(object0, v3, v)) {
                        v1 = v1 * 53 + zzfw.zzf(object0, v4).hashCode();
                    }
                    break;
                }
                case 61: {
                    if(this.zzM(object0, v3, v)) {
                        v1 = v1 * 53 + zzfw.zzf(object0, v4).hashCode();
                    }
                    break;
                }
                case 62: {
                    if(this.zzM(object0, v3, v)) {
                        v1 = v1 * 53 + zzen.zzo(object0, v4);
                    }
                    break;
                }
                case 0x3F: {
                    if(this.zzM(object0, v3, v)) {
                        v1 = v1 * 53 + zzen.zzo(object0, v4);
                    }
                    break;
                }
                case 0x40: {
                    if(this.zzM(object0, v3, v)) {
                        v1 = v1 * 53 + zzen.zzo(object0, v4);
                    }
                    break;
                }
                case 65: {
                    if(this.zzM(object0, v3, v)) {
                        v7 = zzen.zzt(object0, v4);
                        v1 = v1 * 53 + ((int)(v7 ^ v7 >>> 0x20));
                    }
                    break;
                }
                case 66: {
                    if(this.zzM(object0, v3, v)) {
                        v1 = v1 * 53 + zzen.zzo(object0, v4);
                    }
                    break;
                }
                case 67: {
                    if(this.zzM(object0, v3, v)) {
                        v7 = zzen.zzt(object0, v4);
                        v1 = v1 * 53 + ((int)(v7 ^ v7 >>> 0x20));
                    }
                    break;
                }
                case 68: {
                    if(this.zzM(object0, v3, v)) {
                        v1 = v1 * 53 + zzfw.zzf(object0, v4).hashCode();
                    }
                }
            }
        }
        int v9 = this.zzm.zzd(object0).hashCode();
        if(!this.zzh) {
            return v1 * 53 + v9;
        }
        this.zzn.zza(object0);
        throw null;
    }

    final int zzc(Object object0, byte[] arr_b, int v, int v1, int v2, zzbp zzbp0) throws IOException {
        Unsafe unsafe7;
        Unsafe unsafe8;
        int v115;
        int v114;
        int v107;
        int v106;
        int v105;
        int v104;
        zzbp zzbp6;
        int v61;
        int v60;
        int v59;
        int v98;
        int v93;
        int v91;
        int v72;
        int v71;
        int v70;
        Unsafe unsafe4;
        int v87;
        int v86;
        int v85;
        zzbp zzbp7;
        int v58;
        int v56;
        int v55;
        zzbp zzbp5;
        int v54;
        int v29;
        int v28;
        int v27;
        int v48;
        int v47;
        int v45;
        int v36;
        int v35;
        int v34;
        zzbp zzbp3;
        Unsafe unsafe2;
        int v33;
        int v32;
        int v18;
        zzbp zzbp2;
        Unsafe unsafe1;
        int v17;
        int v16;
        int v15;
        int v14;
        int v13;
        int v12;
        int v3 = v2;
        zzbp zzbp1 = zzbp0;
        zzen.zzA(object0);
        Unsafe unsafe0 = zzen.zzb;
        int v4 = 0;
        int v5 = v;
        int v6 = 0;
        int v7 = 0;
        int v8 = 0;
        int v9 = -1;
        int v10 = 0xFFFFF;
        while(true) {
            if(v5 >= v1) {
                v18 = v3;
                unsafe7 = unsafe0;
                break;
            }
            int v11 = arr_b[v5];
            if(v11 < 0) {
                v12 = zzbq.zzi(v11, arr_b, v5 + 1, zzbp1);
                v7 = zzbp1.zza;
            }
            else {
                v7 = v11;
                v12 = v5 + 1;
            }
            if(v7 >>> 3 > v9) {
                v13 = v7 >>> 3 < this.zze || v7 >>> 3 > this.zzf ? -1 : this.zzq(v7 >>> 3, v6 / 3);
            }
            else {
                v13 = v7 >>> 3 < this.zze || v7 >>> 3 > this.zzf ? -1 : this.zzq(v7 >>> 3, 0);
            }
            if(v13 == -1) {
                v14 = v12;
                v15 = v8;
                v16 = v10;
                v17 = v7 >>> 3;
                unsafe1 = unsafe0;
                zzbp2 = zzbp1;
                v18 = v3;
            }
            else {
                int v19 = v7 & 7;
                int[] arr_v = this.zzc;
                int v20 = arr_v[v13 + 1];
                int v21 = v20 >>> 20 & 0xFF;
                long v22 = (long)(v20 & 0xFFFFF);
                int v23 = v7 >>> 3;
                if(v21 <= 17) {
                    int v24 = arr_v[v13 + 2];
                    int v25 = 1 << (v24 >>> 20);
                    int v26 = v24 & 0xFFFFF;
                    if(v26 == v10) {
                        v16 = v10;
                    }
                    else {
                        if(v10 != 0xFFFFF) {
                            unsafe0.putInt(object0, ((long)v10), v8);
                        }
                        v8 = v26 == 0xFFFFF ? 0 : unsafe0.getInt(object0, ((long)v26));
                        v16 = v26;
                    }
                    switch(v21) {
                        case 0: {
                            v27 = v12;
                            v28 = v13;
                            v29 = v7;
                            v4 = 0;
                            if(v19 == 1) {
                                v5 = v27 + 8;
                                v8 |= v25;
                                zzfw.zzo(object0, v22, Double.longBitsToDouble(zzbq.zzn(arr_b, v27)));
                                goto label_218;
                            }
                            goto label_131;
                        }
                        case 1: {
                            v27 = v12;
                            v28 = v13;
                            v29 = v7;
                            v4 = 0;
                            if(v19 == 5) {
                                v5 = v27 + 4;
                                v8 |= v25;
                                zzfw.zzp(object0, v22, Float.intBitsToFloat(zzbq.zzb(arr_b, v27)));
                                goto label_218;
                            }
                            goto label_131;
                        }
                        case 2: 
                        case 3: {
                            v27 = v12;
                            v28 = v13;
                            v29 = v7;
                            v4 = 0;
                            if(v19 == 0) {
                                int v31 = zzbq.zzk(arr_b, v27, zzbp1);
                                unsafe0.putLong(object0, v22, zzbp1.zzb);
                                v8 |= v25;
                                v5 = v31;
                                goto label_218;
                            }
                            goto label_131;
                        }
                        case 7: {
                            v27 = v12;
                            v28 = v13;
                            v29 = v7;
                            v4 = 0;
                            if(v19 == 0) {
                                v8 |= v25;
                                v5 = zzbq.zzk(arr_b, v27, zzbp1);
                                zzfw.zzm(object0, v22, zzbp1.zzb != 0L);
                                goto label_218;
                            }
                        label_131:
                            v32 = v8;
                            v33 = v27;
                            unsafe2 = unsafe0;
                            zzbp3 = zzbp1;
                            v34 = v29;
                            v35 = v28;
                            v36 = v23;
                            break;
                        }
                        case 8: {
                            v28 = v13;
                            v29 = v7;
                            if(v19 == 2) {
                                if((v20 & 0x20000000) == 0) {
                                    v4 = 0;
                                    v5 = zzbq.zzh(arr_b, v12, zzbp1);
                                    int v46 = zzbp1.zza;
                                    if(v46 >= 0) {
                                        v8 |= v25;
                                        if(v46 == 0) {
                                            zzbp1.zzc = "";
                                        }
                                        else {
                                            zzbp1.zzc = new String(arr_b, v5, v46, zzdl.zzb);
                                            v5 += v46;
                                        }
                                    label_217:
                                        unsafe0.putObject(object0, v22, zzbp1.zzc);
                                    label_218:
                                        v7 = v29;
                                        v6 = v28;
                                        v10 = v16;
                                        v9 = v23;
                                        v3 = v2;
                                        continue;
                                    }
                                }
                                else {
                                    v5 = zzbq.zzh(arr_b, v12, zzbp1);
                                    int v37 = zzbp1.zza;
                                    if(v37 >= 0) {
                                        int v38 = v8 | v25;
                                        if(v37 == 0) {
                                            zzbp1.zzc = "";
                                            v4 = 0;
                                        }
                                        else {
                                            if((arr_b.length - v5 - v37 | (v5 | v37)) < 0) {
                                                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", ((int)arr_b.length), v5, v37));
                                            }
                                            int v39 = v5 + v37;
                                            char[] arr_c = new char[v37];
                                            int v40;
                                            for(v40 = 0; v5 < v39; ++v40) {
                                                int v41 = arr_b[v5];
                                                if(!zzfx.zzd(((byte)v41))) {
                                                    break;
                                                }
                                                ++v5;
                                                arr_c[v40] = (char)v41;
                                            }
                                        label_163:
                                            while(v5 < v39) {
                                                int v42 = arr_b[v5];
                                                if(zzfx.zzd(((byte)v42))) {
                                                    int v43 = v40 + 1;
                                                    arr_c[v40] = (char)v42;
                                                    ++v5;
                                                    while(true) {
                                                        v40 = v43;
                                                        if(v5 >= v39) {
                                                            continue label_163;
                                                        }
                                                        int v44 = arr_b[v5];
                                                        if(!zzfx.zzd(((byte)v44))) {
                                                            continue label_163;
                                                        }
                                                        ++v5;
                                                        v43 = v40 + 1;
                                                        arr_c[v40] = (char)v44;
                                                    }
                                                }
                                                if(v42 >= 0xFFFFFFE0) {
                                                    if(v42 < -16) {
                                                        if(v5 + 1 >= v39 - 1) {
                                                            throw zzdn.zzc();
                                                        }
                                                        v45 = v38;
                                                        zzfx.zzb(((byte)v42), arr_b[v5 + 1], arr_b[v5 + 2], arr_c, v40);
                                                        ++v40;
                                                        v5 += 3;
                                                    }
                                                    else {
                                                        v45 = v38;
                                                        if(v5 + 1 >= v39 - 2) {
                                                            throw zzdn.zzc();
                                                        }
                                                        zzfx.zza(((byte)v42), arr_b[v5 + 1], arr_b[v5 + 2], arr_b[v5 + 3], arr_c, v40);
                                                        v40 += 2;
                                                        v5 += 4;
                                                    }
                                                    v38 = v45;
                                                    continue;
                                                }
                                                else if(v5 + 1 < v39) {
                                                    zzfx.zzc(((byte)v42), arr_b[v5 + 1], arr_c, v40);
                                                    ++v40;
                                                    v5 += 2;
                                                    continue;
                                                }
                                                throw zzdn.zzc();
                                            }
                                            v4 = 0;
                                            zzbp1.zzc = new String(arr_c, 0, v40);
                                            v5 = v39;
                                        }
                                        v8 = v38;
                                        goto label_217;
                                    }
                                }
                                throw zzdn.zzd();
                            }
                            else {
                                v32 = v8;
                                v33 = v12;
                                unsafe2 = unsafe0;
                                zzbp3 = zzbp1;
                                v34 = v29;
                                v35 = v28;
                                v36 = v23;
                                break;
                            }
                            goto label_232;
                        }
                        case 9: {
                        label_232:
                            v47 = v13;
                            v48 = v7;
                            if(v19 == 2) {
                                Object object2 = this.zzx(object0, v47);
                                v5 = zzbq.zzm(object2, this.zzv(v47), arr_b, v12, v1, zzbp0);
                                this.zzF(object0, v47, object2);
                                v8 |= v25;
                                goto label_280;
                            }
                            goto label_266;
                        }
                        case 10: {
                            v47 = v13;
                            v48 = v7;
                            if(v19 == 2) {
                                v8 |= v25;
                                v5 = zzbq.zza(arr_b, v12, zzbp1);
                                unsafe0.putObject(object0, v22, zzbp1.zzc);
                                goto label_280;
                            }
                            goto label_266;
                        }
                        case 4: 
                        case 11: {
                            v27 = v12;
                            v28 = v13;
                            v29 = v7;
                            v4 = 0;
                            if(v19 == 0) {
                                v8 |= v25;
                                v5 = zzbq.zzh(arr_b, v27, zzbp1);
                                unsafe0.putInt(object0, v22, zzbp1.zza);
                                goto label_218;
                            }
                            goto label_131;
                        }
                        case 12: {
                            v47 = v13;
                            v48 = v7;
                            if(v19 == 0) {
                                v5 = zzbq.zzh(arr_b, v12, zzbp1);
                                int v49 = zzbp1.zza;
                                zzdh zzdh0 = this.zzu(v47);
                                if((v20 & 0x80000000) == 0 || zzdh0 == null || zzdh0.zza(v49)) {
                                    v8 |= v25;
                                    unsafe0.putInt(object0, v22, v49);
                                }
                                else {
                                    zzen.zzd(object0).zzj(v48, ((long)v49));
                                }
                                goto label_280;
                            }
                            goto label_266;
                        }
                        case 6: 
                        case 13: {
                            v27 = v12;
                            v28 = v13;
                            v29 = v7;
                            v4 = 0;
                            if(v19 == 5) {
                                v5 = v27 + 4;
                                v8 |= v25;
                                unsafe0.putInt(object0, v22, zzbq.zzb(arr_b, v27));
                                goto label_218;
                            }
                            goto label_131;
                        }
                        case 5: 
                        case 14: {
                            v27 = v12;
                            v28 = v13;
                            v29 = v7;
                            v4 = 0;
                            if(v19 == 1) {
                                unsafe0.putLong(object0, v22, zzbq.zzn(arr_b, v27));
                                v5 = v27 + 8;
                                v8 |= v25;
                                goto label_218;
                            }
                            goto label_131;
                        }
                        case 15: {
                            v47 = v13;
                            v48 = v7;
                            if(v19 == 0) {
                                v8 |= v25;
                                v5 = zzbq.zzh(arr_b, v12, zzbp1);
                                unsafe0.putInt(object0, v22, zzbp1.zza >>> 1 ^ -(zzbp1.zza & 1));
                                goto label_280;
                            }
                        label_266:
                            v33 = v12;
                            v32 = v8;
                            unsafe2 = unsafe0;
                            zzbp3 = zzbp1;
                            v34 = v48;
                            v35 = v47;
                            v36 = v23;
                            break;
                        }
                        case 16: {
                            if(v19 == 0) {
                                int v50 = zzbq.zzk(arr_b, v12, zzbp1);
                                v47 = v13;
                                v48 = v7;
                                unsafe0.putLong(object0, v22, zzbp1.zzb >>> 1 ^ -(1L & zzbp1.zzb));
                                v8 |= v25;
                                v5 = v50;
                            label_280:
                                v7 = v48;
                                v6 = v47;
                                v10 = v16;
                                v9 = v23;
                                v4 = 0;
                                v3 = v2;
                                continue;
                            }
                            else {
                                v33 = v12;
                                v35 = v13;
                                v32 = v8;
                                unsafe2 = unsafe0;
                                zzbp3 = zzbp1;
                                v34 = v7;
                            }
                            v36 = v23;
                            break;
                        }
                        default: {
                            v27 = v12;
                            v28 = v13;
                            v29 = v7;
                            if(v19 == 3) {
                                Object object1 = this.zzx(object0, v28);
                                int v30 = zzbq.zzl(object1, this.zzv(v28), arr_b, v27, v1, v23 << 3 | 4, zzbp0);
                                this.zzF(object0, v28, object1);
                                v3 = v2;
                                zzbp1 = zzbp0;
                                v9 = v23;
                                v6 = v28;
                                v5 = v30;
                                v10 = v16;
                                v4 = 0;
                                v7 = v29;
                                v8 |= v25;
                                continue;
                            }
                            goto label_131;
                        }
                    }
                    unsafe1 = unsafe2;
                    v4 = v35;
                    v15 = v32;
                    v7 = v34;
                    v18 = v2;
                    zzbp2 = zzbp3;
                    v17 = v36;
                    v14 = v33;
                }
                else {
                    v16 = v10;
                    int v51 = v7;
                    v15 = v8;
                    zzbp zzbp4 = zzbp1;
                    int v52 = 10;
                    if(v21 == 27) {
                        if(v19 == 2) {
                            zzdk zzdk0 = (zzdk)unsafe0.getObject(object0, v22);
                            if(!zzdk0.zzc()) {
                                int v53 = zzdk0.size();
                                if(v53 != 0) {
                                    v52 = v53 + v53;
                                }
                                zzdk0 = zzdk0.zzd(v52);
                                unsafe0.putObject(object0, v22, zzdk0);
                            }
                            v3 = v2;
                            v9 = v23;
                            v6 = v13;
                            v5 = zzbq.zze(this.zzv(v13), v51, arr_b, v12, v1, zzdk0, zzbp0);
                            v10 = v16;
                            v4 = 0;
                            v7 = v51;
                            v8 = v15;
                            continue;
                        }
                        else {
                            unsafe1 = unsafe0;
                            v54 = v51;
                            zzbp5 = zzbp1;
                            v55 = v13;
                            v56 = v12;
                            goto label_797;
                        }
                        goto label_332;
                    }
                    else {
                    label_332:
                        if(v21 <= 49) {
                            Unsafe unsafe3 = zzen.zzb;
                            zzdk zzdk1 = (zzdk)unsafe3.getObject(object0, v22);
                            if(zzdk1.zzc()) {
                                v58 = v23;
                            }
                            else {
                                int v57 = zzdk1.size();
                                if(v57 != 0) {
                                    v52 = v57 + v57;
                                }
                                v58 = v23;
                                zzdk zzdk2 = zzdk1.zzd(v52);
                                unsafe3.putObject(object0, v22, zzdk2);
                                zzdk1 = zzdk2;
                            }
                        alab4:
                            switch(v21) {
                                case 26: {
                                    v59 = v12;
                                    v60 = v51;
                                    unsafe4 = unsafe0;
                                    v70 = v13;
                                    zzbp6 = zzbp1;
                                    v71 = v58;
                                    if(v19 == 2) {
                                        if((((long)v20) & 0x20000000L) == 0L) {
                                            v72 = zzbq.zzh(arr_b, v59, zzbp6);
                                            int v79 = zzbp6.zza;
                                            if(v79 >= 0) {
                                                if(v79 == 0) {
                                                    zzdk1.add("");
                                                    goto label_553;
                                                }
                                                else {
                                                    zzdk1.add(new String(arr_b, v72, v79, zzdl.zzb));
                                                }
                                            alab1:
                                                while(true) {
                                                    v72 += v79;
                                                    while(true) {
                                                    label_553:
                                                        if(v72 >= v1) {
                                                            goto label_591;
                                                        }
                                                        int v80 = zzbq.zzh(arr_b, v72, zzbp6);
                                                        if(v60 != zzbp6.zza) {
                                                            goto label_591;
                                                        }
                                                        v72 = zzbq.zzh(arr_b, v80, zzbp6);
                                                        v79 = zzbp6.zza;
                                                        if(v79 < 0) {
                                                            break alab1;
                                                        }
                                                        if(v79 != 0) {
                                                            zzdk1.add(new String(arr_b, v72, v79, zzdl.zzb));
                                                            break;
                                                        }
                                                        zzdk1.add("");
                                                    }
                                                }
                                                throw zzdn.zzd();
                                            }
                                        }
                                        else {
                                            v72 = zzbq.zzh(arr_b, v59, zzbp6);
                                            int v81 = zzbp6.zza;
                                            if(v81 >= 0) {
                                                if(v81 == 0) {
                                                    zzdk1.add("");
                                                    goto label_576;
                                                }
                                                else {
                                                    int v82 = v72 + v81;
                                                    if(!zzgb.zze(arr_b, v72, v82)) {
                                                        throw zzdn.zzc();
                                                    }
                                                    zzdk1.add(new String(arr_b, v72, v81, zzdl.zzb));
                                                alab2:
                                                    while(true) {
                                                        v72 = v82;
                                                        while(true) {
                                                        label_576:
                                                            if(v72 >= v1) {
                                                                goto label_591;
                                                            }
                                                            int v83 = zzbq.zzh(arr_b, v72, zzbp6);
                                                            if(v60 != zzbp6.zza) {
                                                                goto label_591;
                                                            }
                                                            v72 = zzbq.zzh(arr_b, v83, zzbp6);
                                                            int v84 = zzbp6.zza;
                                                            if(v84 < 0) {
                                                                throw zzdn.zzd();
                                                            }
                                                            if(v84 != 0) {
                                                                v82 = v72 + v84;
                                                                if(!zzgb.zze(arr_b, v72, v82)) {
                                                                    break alab2;
                                                                }
                                                                zzdk1.add(new String(arr_b, v72, v84, zzdl.zzb));
                                                                break;
                                                            }
                                                            zzdk1.add("");
                                                        }
                                                    }
                                                    throw zzdn.zzc();
                                                label_591:
                                                    v61 = v71;
                                                    v5 = v72;
                                                    v4 = v70;
                                                    unsafe0 = unsafe4;
                                                    goto label_763;
                                                }
                                            }
                                        }
                                        throw zzdn.zzd();
                                    }
                                label_598:
                                    v61 = v71;
                                    v4 = v70;
                                    unsafe0 = unsafe4;
                                    v5 = v59;
                                    goto label_763;
                                }
                                case 28: {
                                    zzbp7 = zzbp1;
                                    v85 = v51;
                                    v86 = v13;
                                    v87 = v58;
                                    if(v19 == 2) {
                                        int v88 = zzbq.zzh(arr_b, v12, zzbp7);
                                        int v89 = zzbp7.zza;
                                        if(v89 < 0) {
                                            throw zzdn.zzd();
                                        }
                                        if(v89 > arr_b.length - v88) {
                                            throw zzdn.zzg();
                                        }
                                        if(v89 == 0) {
                                            zzdk1.add(zzcc.zzb);
                                            goto label_616;
                                        }
                                        else {
                                            zzdk1.add(zzcc.zzl(arr_b, v88, v89));
                                        }
                                    alab3:
                                        while(true) {
                                            v88 += v89;
                                            while(true) {
                                            label_616:
                                                if(v88 >= v1) {
                                                    v5 = v88;
                                                    v59 = v12;
                                                    goto label_689;
                                                }
                                                int v90 = zzbq.zzh(arr_b, v88, zzbp7);
                                                if(v85 != zzbp7.zza) {
                                                    v5 = v88;
                                                    v59 = v12;
                                                    goto label_689;
                                                }
                                                v88 = zzbq.zzh(arr_b, v90, zzbp7);
                                                v89 = zzbp7.zza;
                                                if(v89 < 0) {
                                                    throw zzdn.zzd();
                                                }
                                                if(v89 > arr_b.length - v88) {
                                                    break alab3;
                                                }
                                                if(v89 != 0) {
                                                    zzdk1.add(zzcc.zzl(arr_b, v88, v89));
                                                    break;
                                                }
                                                zzdk1.add(zzcc.zzb);
                                            }
                                        }
                                        throw zzdn.zzg();
                                    }
                                    else {
                                        v59 = v12;
                                        zzbp6 = zzbp7;
                                        v4 = v86;
                                        v61 = v87;
                                        v60 = v85;
                                        v5 = v59;
                                        goto label_763;
                                    }
                                    goto label_641;
                                }
                                case 18: 
                                case 35: {
                                    v59 = v12;
                                    v60 = v51;
                                    v4 = v13;
                                    v61 = v58;
                                    zzbp6 = zzbp1;
                                    if(v19 == 2) {
                                        zzcm zzcm0 = (zzcm)zzdk1;
                                        v5 = zzbq.zzh(arr_b, v59, zzbp6);
                                        int v64 = zzbp6.zza + v5;
                                        while(v5 < v64) {
                                            zzcm0.zze(Double.longBitsToDouble(zzbq.zzn(arr_b, v5)));
                                            v5 += 8;
                                        }
                                        if(v5 != v64) {
                                            throw zzdn.zzg();
                                        }
                                    }
                                    else if(v19 == 1) {
                                        v5 = v59 + 8;
                                        zzcm zzcm1 = (zzcm)zzdk1;
                                        zzcm1.zze(Double.longBitsToDouble(zzbq.zzn(arr_b, v59)));
                                        while(v5 < v1) {
                                            int v65 = zzbq.zzh(arr_b, v5, zzbp6);
                                            if(v60 != zzbp6.zza) {
                                                break;
                                            }
                                            zzcm1.zze(Double.longBitsToDouble(zzbq.zzn(arr_b, v65)));
                                            v5 = v65 + 8;
                                        }
                                    }
                                    else {
                                        v5 = v59;
                                    }
                                    goto label_763;
                                }
                                case 19: 
                                case 36: {
                                    v59 = v12;
                                    v60 = v51;
                                    v4 = v13;
                                    v61 = v58;
                                    zzbp6 = zzbp1;
                                    if(v19 == 2) {
                                        zzcw zzcw0 = (zzcw)zzdk1;
                                        v5 = zzbq.zzh(arr_b, v59, zzbp6);
                                        int v66 = zzbp6.zza + v5;
                                        while(v5 < v66) {
                                            zzcw0.zze(Float.intBitsToFloat(zzbq.zzb(arr_b, v5)));
                                            v5 += 4;
                                        }
                                        if(v5 != v66) {
                                            throw zzdn.zzg();
                                        }
                                    }
                                    else if(v19 == 5) {
                                        v5 = v59 + 4;
                                        zzcw zzcw1 = (zzcw)zzdk1;
                                        zzcw1.zze(Float.intBitsToFloat(zzbq.zzb(arr_b, v59)));
                                        while(v5 < v1) {
                                            int v67 = zzbq.zzh(arr_b, v5, zzbp6);
                                            if(v60 != zzbp6.zza) {
                                                break;
                                            }
                                            zzcw1.zze(Float.intBitsToFloat(zzbq.zzb(arr_b, v67)));
                                            v5 = v67 + 4;
                                        }
                                    }
                                    else {
                                        v5 = v59;
                                    }
                                    goto label_763;
                                }
                                case 20: 
                                case 21: 
                                case 37: 
                                case 38: {
                                    v59 = v12;
                                    v60 = v51;
                                    v4 = v13;
                                    v61 = v58;
                                    zzbp6 = zzbp1;
                                    if(v19 == 2) {
                                        zzdz zzdz0 = (zzdz)zzdk1;
                                        v5 = zzbq.zzh(arr_b, v59, zzbp6);
                                        int v68 = zzbp6.zza + v5;
                                        while(v5 < v68) {
                                            v5 = zzbq.zzk(arr_b, v5, zzbp6);
                                            zzdz0.zzf(zzbp6.zzb);
                                        }
                                        if(v5 != v68) {
                                            throw zzdn.zzg();
                                        }
                                    }
                                    else if(v19 == 0) {
                                        zzdz zzdz1 = (zzdz)zzdk1;
                                        v5 = zzbq.zzk(arr_b, v59, zzbp6);
                                        zzdz1.zzf(zzbp6.zzb);
                                        while(v5 < v1) {
                                            int v69 = zzbq.zzh(arr_b, v5, zzbp6);
                                            if(v60 != zzbp6.zza) {
                                                break;
                                            }
                                            v5 = zzbq.zzk(arr_b, v69, zzbp6);
                                            zzdz1.zzf(zzbp6.zzb);
                                        }
                                    }
                                    else {
                                        v5 = v59;
                                    }
                                    goto label_763;
                                }
                                case 25: 
                                case 42: {
                                    v59 = v12;
                                    v60 = v51;
                                    unsafe4 = unsafe0;
                                    v70 = v13;
                                    zzbp6 = zzbp1;
                                    v71 = v58;
                                    if(v19 == 2) {
                                        zzbr zzbr0 = (zzbr)zzdk1;
                                        v72 = zzbq.zzh(arr_b, v59, zzbp6);
                                        int v77 = zzbp6.zza + v72;
                                        while(v72 < v77) {
                                            v72 = zzbq.zzk(arr_b, v72, zzbp6);
                                            zzbr0.zze(zzbp6.zzb != 0L);
                                        }
                                        if(v72 != v77) {
                                            throw zzdn.zzg();
                                        }
                                        goto label_591;
                                    }
                                    else if(v19 == 0) {
                                        zzbr zzbr1 = (zzbr)zzdk1;
                                        v72 = zzbq.zzk(arr_b, v59, zzbp6);
                                        zzbr1.zze(zzbp6.zzb != 0L);
                                        while(v72 < v1) {
                                            int v78 = zzbq.zzh(arr_b, v72, zzbp6);
                                            if(v60 != zzbp6.zza) {
                                                break;
                                            }
                                            v72 = zzbq.zzk(arr_b, v78, zzbp6);
                                            zzbr1.zze(zzbp6.zzb != 0L);
                                        }
                                        goto label_591;
                                    }
                                    goto label_598;
                                }
                                case 22: 
                                case 29: 
                                case 39: 
                                case 43: {
                                    v59 = v12;
                                    v60 = v51;
                                    unsafe4 = unsafe0;
                                    v70 = v13;
                                    zzbp6 = zzbp1;
                                    v71 = v58;
                                    if(v19 == 2) {
                                        v72 = zzbq.zzf(arr_b, v59, zzdk1, zzbp6);
                                        goto label_591;
                                    }
                                    else if(v19 == 0) {
                                        v61 = v71;
                                        v4 = v70;
                                        unsafe0 = unsafe4;
                                        v5 = zzbq.zzj(v60, arr_b, v59, v1, zzdk1, zzbp0);
                                        goto label_763;
                                    }
                                    goto label_598;
                                }
                                case 30: 
                                case 44: {
                                label_641:
                                    v85 = v51;
                                    if(v19 == 2) {
                                        v91 = zzbq.zzf(arr_b, v12, zzdk1, zzbp1);
                                        zzbp7 = zzbp1;
                                        v86 = v13;
                                        v87 = v58;
                                        goto label_653;
                                    }
                                    else if(v19 == 0) {
                                        zzbp7 = zzbp1;
                                        v87 = v58;
                                        v86 = v13;
                                        v91 = zzbq.zzj(v85, arr_b, v12, v1, zzdk1, zzbp0);
                                    label_653:
                                        zzdh zzdh1 = this.zzu(v86);
                                        zzfm zzfm0 = this.zzm;
                                        if(zzdh1 == null) {
                                            v93 = v91;
                                        }
                                        else if(zzdk1 instanceof RandomAccess) {
                                            int v92 = zzdk1.size();
                                            v93 = v91;
                                            Object object3 = null;
                                            int v95 = 0;
                                            for(int v94 = 0; v94 < v92; ++v94) {
                                                int v96 = (int)(((Integer)zzdk1.get(v94)));
                                                if(zzdh1.zza(v96)) {
                                                    if(v94 != v95) {
                                                        zzdk1.set(v95, v96);
                                                    }
                                                    ++v95;
                                                }
                                                else {
                                                    object3 = zzex.zzo(object0, v87, v96, object3, zzfm0);
                                                }
                                            }
                                            if(v95 != v92) {
                                                zzdk1.subList(v95, v92).clear();
                                            }
                                        }
                                        else {
                                            v93 = v91;
                                            Object object4 = null;
                                            Iterator iterator0 = zzdk1.iterator();
                                            while(iterator0.hasNext()) {
                                                Object object5 = iterator0.next();
                                                int v97 = (int)(((Integer)object5));
                                                if(!zzdh1.zza(v97)) {
                                                    object4 = zzex.zzo(object0, v87, v97, object4, zzfm0);
                                                    iterator0.remove();
                                                }
                                            }
                                        }
                                        v5 = v93;
                                        v59 = v12;
                                    label_689:
                                        zzbp6 = zzbp7;
                                        v4 = v86;
                                        v61 = v87;
                                        v60 = v85;
                                        goto label_763;
                                    }
                                    else {
                                        v60 = v85;
                                        v59 = v12;
                                        goto label_728;
                                    }
                                    goto label_697;
                                }
                                case 24: 
                                case 0x1F: 
                                case 41: 
                                case 45: {
                                    v59 = v12;
                                    v60 = v51;
                                    unsafe4 = unsafe0;
                                    v70 = v13;
                                    zzbp6 = zzbp1;
                                    v71 = v58;
                                    if(v19 == 2) {
                                        zzde zzde0 = (zzde)zzdk1;
                                        v72 = zzbq.zzh(arr_b, v59, zzbp6);
                                        int v75 = zzbp6.zza + v72;
                                        while(v72 < v75) {
                                            zzde0.zzh(zzbq.zzb(arr_b, v72));
                                            v72 += 4;
                                        }
                                        if(v72 != v75) {
                                            throw zzdn.zzg();
                                        }
                                        goto label_591;
                                    }
                                    else if(v19 == 5) {
                                        v72 = v59 + 4;
                                        zzde zzde1 = (zzde)zzdk1;
                                        zzde1.zzh(zzbq.zzb(arr_b, v59));
                                        while(v72 < v1) {
                                            int v76 = zzbq.zzh(arr_b, v72, zzbp6);
                                            if(v60 != zzbp6.zza) {
                                                break;
                                            }
                                            zzde1.zzh(zzbq.zzb(arr_b, v76));
                                            v72 = v76 + 4;
                                        }
                                        goto label_591;
                                    }
                                    goto label_598;
                                }
                                case 23: 
                                case 0x20: 
                                case 40: 
                                case 46: {
                                    v59 = v12;
                                    v60 = v51;
                                    unsafe4 = unsafe0;
                                    v70 = v13;
                                    zzbp6 = zzbp1;
                                    v71 = v58;
                                    if(v19 == 2) {
                                        zzdz zzdz2 = (zzdz)zzdk1;
                                        v72 = zzbq.zzh(arr_b, v59, zzbp6);
                                        int v73 = zzbp6.zza + v72;
                                        while(v72 < v73) {
                                            zzdz2.zzf(zzbq.zzn(arr_b, v72));
                                            v72 += 8;
                                        }
                                        if(v72 != v73) {
                                            throw zzdn.zzg();
                                        }
                                        goto label_591;
                                    }
                                    else if(v19 == 1) {
                                        v72 = v59 + 8;
                                        zzdz zzdz3 = (zzdz)zzdk1;
                                        zzdz3.zzf(zzbq.zzn(arr_b, v59));
                                        while(v72 < v1) {
                                            int v74 = zzbq.zzh(arr_b, v72, zzbp6);
                                            if(v60 != zzbp6.zza) {
                                                break;
                                            }
                                            zzdz3.zzf(zzbq.zzn(arr_b, v74));
                                            v72 = v74 + 8;
                                        }
                                        goto label_591;
                                    }
                                    goto label_598;
                                }
                                case 33: 
                                case 0x2F: {
                                label_697:
                                    v85 = v51;
                                    if(v19 == 2) {
                                        zzde zzde2 = (zzde)zzdk1;
                                        v98 = zzbq.zzh(arr_b, v12, zzbp1);
                                        int v99 = zzbp1.zza + v98;
                                        while(v98 < v99) {
                                            v98 = zzbq.zzh(arr_b, v98, zzbp4);
                                            zzde2.zzh(zzbp4.zza >>> 1 ^ -(zzbp4.zza & 1));
                                        }
                                        if(v98 != v99) {
                                            throw zzdn.zzg();
                                        }
                                        v60 = v85;
                                        v59 = v12;
                                        goto label_759;
                                    }
                                    else if(v19 == 0) {
                                        zzde zzde3 = (zzde)zzdk1;
                                        v98 = zzbq.zzh(arr_b, v12, zzbp1);
                                        zzde3.zzh(zzbp1.zza >>> 1 ^ -(zzbp1.zza & 1));
                                        while(v98 < v1) {
                                            int v100 = zzbq.zzh(arr_b, v98, zzbp4);
                                            if(v85 != zzbp4.zza) {
                                                break;
                                            }
                                            v98 = zzbq.zzh(arr_b, v100, zzbp4);
                                            zzde3.zzh(zzbp4.zza >>> 1 ^ -(zzbp4.zza & 1));
                                        }
                                        v60 = v85;
                                        v59 = v12;
                                        goto label_759;
                                    }
                                    else {
                                        v60 = v85;
                                        v59 = v12;
                                        goto label_728;
                                    }
                                    goto label_725;
                                }
                                case 34: 
                                case 0x30: {
                                label_725:
                                    switch(v19) {
                                        case 0: {
                                            zzdz zzdz4 = (zzdz)zzdk1;
                                            v98 = zzbq.zzk(arr_b, v12, zzbp1);
                                            zzdz4.zzf(zzbp1.zzb >>> 1 ^ -(1L & zzbp1.zzb));
                                            while(true) {
                                                if(v98 < v1) {
                                                    int v101 = zzbq.zzh(arr_b, v98, zzbp4);
                                                    v85 = v51;
                                                    if(v85 == zzbp4.zza) {
                                                        v98 = zzbq.zzk(arr_b, v101, zzbp4);
                                                        zzdz4.zzf(zzbp4.zzb >>> 1 ^ -(1L & zzbp4.zzb));
                                                        v51 = v85;
                                                        continue;
                                                    }
                                                    else {
                                                        break;
                                                    }
                                                }
                                                v85 = v51;
                                                break;
                                            }
                                            v60 = v85;
                                            v59 = v12;
                                            goto label_759;
                                        }
                                        case 2: {
                                            zzdz zzdz5 = (zzdz)zzdk1;
                                            v98 = zzbq.zzh(arr_b, v12, zzbp1);
                                            int v102 = zzbp1.zza + v98;
                                            while(v98 < v102) {
                                                v98 = zzbq.zzk(arr_b, v98, zzbp4);
                                                zzdz5.zzf(zzbp4.zzb >>> 1 ^ -(1L & zzbp4.zzb));
                                            }
                                            if(v98 == v102) {
                                                v59 = v12;
                                                v60 = v51;
                                            label_759:
                                                v4 = v13;
                                                v61 = v58;
                                                zzbp6 = zzbp1;
                                                v5 = v98;
                                            label_763:
                                                if(v5 == v59) {
                                                    v14 = v5;
                                                    v17 = v61;
                                                    v7 = v60;
                                                    unsafe1 = unsafe0;
                                                    zzbp2 = zzbp6;
                                                    v18 = v2;
                                                    break alab4;
                                                }
                                                else {
                                                    v9 = v61;
                                                    v7 = v60;
                                                    v6 = v4;
                                                    zzbp1 = zzbp6;
                                                    v10 = v16;
                                                    v4 = 0;
                                                    v8 = v15;
                                                    v3 = v2;
                                                    continue;
                                                }
                                            }
                                            throw zzdn.zzg();
                                        }
                                        default: {
                                            v59 = v12;
                                            v60 = v51;
                                        label_728:
                                            v4 = v13;
                                            v61 = v58;
                                            zzbp6 = zzbp1;
                                            v5 = v59;
                                            goto label_763;
                                        }
                                    }
                                }
                                default: {
                                    v59 = v12;
                                    v60 = v51;
                                    v4 = v13;
                                    v61 = v58;
                                    zzbp6 = zzbp1;
                                    if(v19 == 3) {
                                        int v62 = v60 & -8 | 4;
                                        zzev zzev0 = this.zzv(v4);
                                        v5 = zzbq.zzc(zzev0, arr_b, v59, v1, v62, zzbp0);
                                        zzdk1.add(zzbp6.zzc);
                                        while(v5 < v1) {
                                            int v63 = zzbq.zzh(arr_b, v5, zzbp6);
                                            if(v60 != zzbp6.zza) {
                                                break;
                                            }
                                            v5 = zzbq.zzc(zzev0, arr_b, v63, v1, v62, zzbp0);
                                            zzdk1.add(zzbp6.zzc);
                                        }
                                    }
                                    else {
                                        v5 = v59;
                                    }
                                    goto label_763;
                                }
                            }
                        }
                        else {
                            zzbp5 = zzbp1;
                            unsafe1 = unsafe0;
                            v55 = v13;
                            v54 = v51;
                            if(v21 == 50) {
                                if(v19 == 2) {
                                    Unsafe unsafe5 = zzen.zzb;
                                    Object object6 = this.zzw(v55);
                                    Object object7 = unsafe5.getObject(object0, v22);
                                    if(!((zzee)object7).zze()) {
                                        zzee zzee0 = zzee.zza().zzb();
                                        zzef.zza(zzee0, object7);
                                        unsafe5.putObject(object0, v22, zzee0);
                                    }
                                    zzed zzed0 = (zzed)object6;
                                    throw null;
                                }
                                v56 = v12;
                            label_797:
                                v18 = v2;
                                v4 = v55;
                                v17 = v23;
                                v7 = v54;
                                v14 = v56;
                                zzbp2 = zzbp5;
                            }
                            else {
                                Unsafe unsafe6 = zzen.zzb;
                                long v103 = (long)(arr_v[v55 + 2] & 0xFFFFF);
                                switch(v21) {
                                    case 51: {
                                        v104 = v55;
                                        v17 = v23;
                                        v7 = v54;
                                        v105 = v12;
                                        zzbp2 = zzbp0;
                                        if(v19 == 1) {
                                            v106 = v105 + 8;
                                            unsafe6.putObject(object0, v22, Double.longBitsToDouble(zzbq.zzn(arr_b, v105)));
                                            unsafe6.putInt(object0, v103, v17);
                                            break;
                                        }
                                        v106 = v105;
                                        break;
                                    }
                                    case 52: {
                                        v104 = v55;
                                        v17 = v23;
                                        v7 = v54;
                                        v105 = v12;
                                        zzbp2 = zzbp0;
                                        if(v19 == 5) {
                                            v106 = v105 + 4;
                                            unsafe6.putObject(object0, v22, Float.intBitsToFloat(zzbq.zzb(arr_b, v105)));
                                            unsafe6.putInt(object0, v103, v17);
                                            break;
                                        }
                                        v106 = v105;
                                        break;
                                    }
                                    case 53: 
                                    case 54: {
                                        v104 = v55;
                                        v17 = v23;
                                        v7 = v54;
                                        v105 = v12;
                                        zzbp2 = zzbp0;
                                        if(v19 == 0) {
                                            v107 = zzbq.zzk(arr_b, v105, zzbp2);
                                            unsafe6.putObject(object0, v22, zzbp2.zzb);
                                            unsafe6.putInt(object0, v103, v17);
                                            v106 = v107;
                                            break;
                                        }
                                        v106 = v105;
                                        break;
                                    }
                                    case 58: {
                                        v104 = v55;
                                        v17 = v23;
                                        v105 = v12;
                                        zzbp2 = zzbp0;
                                        if(v19 == 0) {
                                            v107 = zzbq.zzk(arr_b, v105, zzbp2);
                                            v7 = v54;
                                            unsafe6.putObject(object0, v22, Boolean.valueOf(zzbp2.zzb != 0L));
                                            unsafe6.putInt(object0, v103, v17);
                                            v106 = v107;
                                        }
                                        else {
                                            v7 = v54;
                                            v106 = v105;
                                        }
                                        break;
                                    }
                                    case 59: {
                                        v104 = v55;
                                        v17 = v23;
                                        v105 = v12;
                                        zzbp2 = zzbp0;
                                        if(v19 == 2) {
                                            v106 = zzbq.zzh(arr_b, v105, zzbp2);
                                            int v108 = zzbp2.zza;
                                            if(v108 == 0) {
                                                unsafe6.putObject(object0, v22, "");
                                            }
                                            else {
                                                int v109 = v106 + v108;
                                                if((v20 & 0x20000000) != 0 && !zzgb.zze(arr_b, v106, v109)) {
                                                    throw zzdn.zzc();
                                                }
                                                unsafe6.putObject(object0, v22, new String(arr_b, v106, v108, zzdl.zzb));
                                                v106 = v109;
                                            }
                                            unsafe6.putInt(object0, v103, v17);
                                            v7 = v54;
                                        }
                                        else {
                                            v7 = v54;
                                            v106 = v105;
                                        }
                                        break;
                                    }
                                    case 60: {
                                        if(v19 == 2) {
                                            Object object8 = this.zzy(object0, v23, v55);
                                            v105 = v12;
                                            int v110 = zzbq.zzm(object8, this.zzv(v55), arr_b, v12, v1, zzbp0);
                                            this.zzG(object0, v23, v55, object8);
                                            v106 = v110;
                                            v104 = v55;
                                            v17 = v23;
                                            zzbp2 = zzbp0;
                                            v7 = v54;
                                        }
                                        else {
                                            v105 = v12;
                                            v104 = v55;
                                            v17 = v23;
                                            zzbp2 = zzbp0;
                                            v7 = v54;
                                            v106 = v105;
                                        }
                                        break;
                                    }
                                    case 61: {
                                        if(v19 == 2) {
                                            v106 = zzbq.zza(arr_b, v12, zzbp0);
                                            unsafe6.putObject(object0, v22, zzbp0.zzc);
                                            unsafe6.putInt(object0, v103, v23);
                                            goto label_947;
                                        }
                                        goto label_939;
                                    }
                                    case 55: 
                                    case 62: {
                                        v104 = v55;
                                        v17 = v23;
                                        v7 = v54;
                                        v105 = v12;
                                        zzbp2 = zzbp0;
                                        if(v19 == 0) {
                                            v106 = zzbq.zzh(arr_b, v105, zzbp2);
                                            unsafe6.putObject(object0, v22, zzbp2.zza);
                                            unsafe6.putInt(object0, v103, v17);
                                            break;
                                        }
                                        v106 = v105;
                                        break;
                                    }
                                    case 0x3F: {
                                        if(v19 == 0) {
                                            int v111 = zzbq.zzh(arr_b, v12, zzbp0);
                                            int v112 = zzbp0.zza;
                                            zzdh zzdh2 = this.zzu(v55);
                                            if(zzdh2 == null || zzdh2.zza(v112)) {
                                                unsafe6.putObject(object0, v22, v112);
                                                unsafe6.putInt(object0, v103, v23);
                                            }
                                            else {
                                                zzen.zzd(object0).zzj(v54, ((long)v112));
                                            }
                                            v106 = v111;
                                            goto label_947;
                                        }
                                        goto label_939;
                                    }
                                    case 57: 
                                    case 0x40: {
                                        v104 = v55;
                                        v17 = v23;
                                        v7 = v54;
                                        v105 = v12;
                                        zzbp2 = zzbp0;
                                        if(v19 == 5) {
                                            v106 = v105 + 4;
                                            unsafe6.putObject(object0, v22, zzbq.zzb(arr_b, v105));
                                            unsafe6.putInt(object0, v103, v17);
                                            break;
                                        }
                                        v106 = v105;
                                        break;
                                    }
                                    case 56: 
                                    case 65: {
                                        v104 = v55;
                                        v17 = v23;
                                        v7 = v54;
                                        v105 = v12;
                                        zzbp2 = zzbp0;
                                        if(v19 == 1) {
                                            v106 = v105 + 8;
                                            unsafe6.putObject(object0, v22, zzbq.zzn(arr_b, v105));
                                            unsafe6.putInt(object0, v103, v17);
                                            break;
                                        }
                                        v106 = v105;
                                        break;
                                    }
                                    case 66: {
                                        if(v19 == 0) {
                                            v106 = zzbq.zzh(arr_b, v12, zzbp0);
                                            unsafe6.putObject(object0, v22, ((int)(zzbp0.zza >>> 1 ^ -(zzbp0.zza & 1))));
                                            unsafe6.putInt(object0, v103, v23);
                                            goto label_947;
                                        }
                                    label_939:
                                        v104 = v55;
                                        v17 = v23;
                                        v105 = v12;
                                        zzbp2 = zzbp0;
                                        v7 = v54;
                                        v106 = v105;
                                        break;
                                    }
                                    case 67: {
                                        if(v19 == 0) {
                                            v106 = zzbq.zzk(arr_b, v12, zzbp0);
                                            unsafe6.putObject(object0, v22, ((long)(zzbp0.zzb >>> 1 ^ -(1L & zzbp0.zzb))));
                                            unsafe6.putInt(object0, v103, v23);
                                        label_947:
                                            v104 = v55;
                                            v17 = v23;
                                            v105 = v12;
                                            zzbp2 = zzbp0;
                                            v7 = v54;
                                            break;
                                        }
                                        else {
                                            v104 = v55;
                                            v17 = v23;
                                            v105 = v12;
                                        }
                                        zzbp2 = zzbp0;
                                        v7 = v54;
                                        v106 = v105;
                                        break;
                                    }
                                    case 68: {
                                        if(v19 == 3) {
                                            Object object9 = this.zzy(object0, v23, v55);
                                            int v113 = zzbq.zzl(object9, this.zzv(v55), arr_b, v12, v1, v54 & -8 | 4, zzbp0);
                                            this.zzG(object0, v23, v55, object9);
                                            v104 = v55;
                                            v17 = v23;
                                            v105 = v12;
                                            v106 = v113;
                                            zzbp2 = zzbp0;
                                            v7 = v54;
                                            break;
                                        }
                                    label_970:
                                        v104 = v55;
                                        v17 = v23;
                                        v7 = v54;
                                        v105 = v12;
                                        zzbp2 = zzbp0;
                                        v106 = v105;
                                        break;
                                    }
                                    default: {
                                        goto label_970;
                                    }
                                }
                                if(v106 == v105) {
                                    v18 = v2;
                                    v14 = v106;
                                    v4 = v104;
                                }
                                else {
                                    v3 = v2;
                                    zzbp1 = zzbp2;
                                    v10 = v16;
                                    v4 = 0;
                                    v6 = v104;
                                    v8 = v15;
                                    unsafe0 = unsafe1;
                                    v9 = v17;
                                    v5 = v106;
                                    continue;
                                }
                            }
                        }
                    }
                }
            }
            if(v7 != v18 || v18 == 0) {
                if(this.zzh) {
                    zzcp zzcp0 = zzbp2.zzd;
                    if(zzcp0 != zzcp.zza) {
                        if(zzcp0.zzb(this.zzg, v17) == null) {
                            v114 = v17;
                            v115 = v7;
                            unsafe8 = unsafe1;
                            v5 = zzbq.zzg(v7, arr_b, v14, v1, zzen.zzd(object0), zzbp0);
                            goto label_1011;
                        }
                        zzda zzda0 = (zzda)object0;
                        throw null;
                    }
                }
                v114 = v17;
                v115 = v7;
                unsafe8 = unsafe1;
                v5 = zzbq.zzg(v115, arr_b, v14, v1, zzen.zzd(object0), zzbp0);
            label_1011:
                v6 = v4;
                v9 = v114;
                v7 = v115;
                unsafe0 = unsafe8;
                v10 = v16;
                v4 = 0;
                v8 = v15;
                zzbp1 = zzbp0;
                v3 = v18;
                continue;
            }
            else {
                v5 = v14;
                v10 = v16;
                v8 = v15;
                unsafe7 = unsafe1;
            }
            break;
        }
        if(v10 != 0xFFFFF) {
            unsafe7.putInt(object0, ((long)v10), v8);
        }
        int v116 = this.zzj;
        while(v116 < this.zzk) {
            int v117 = this.zzi[v116];
            int v118 = this.zzc[v117];
            Object object10 = zzfw.zzf(object0, ((long)(this.zzs(v117) & 0xFFFFF)));
            if(object10 == null || this.zzu(v117) == null) {
                ++v116;
                continue;
            }
            zzee zzee1 = (zzee)object10;
            zzed zzed1 = (zzed)this.zzw(v117);
            throw null;
        }
        if(v18 == 0) {
            if(v5 != v1) {
                throw zzdn.zze();
            }
            return v5;
        }
        if(v5 > v1 || v7 != v18) {
            throw zzdn.zze();
        }
        return v5;
    }

    static zzfn zzd(Object object0) {
        zzfn zzfn0 = ((zzdd)object0).zzc;
        if(zzfn0 == zzfn.zzc()) {
            zzfn0 = zzfn.zzf();
            ((zzdd)object0).zzc = zzfn0;
        }
        return zzfn0;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzev
    public final Object zze() {
        return ((zzdd)this.zzg).zzj();
    }

    @Override  // com.google.android.gms.internal.play_billing.zzev
    public final void zzf(Object object0) {
        if(zzen.zzL(object0)) {
            if(object0 instanceof zzdd) {
                ((zzdd)object0).zzu(0x7FFFFFFF);
                ((zzdd)object0).zza = 0;
                ((zzdd)object0).zzs();
            }
            int[] arr_v = this.zzc;
            for(int v = 0; v < arr_v.length; v += 3) {
                int v1 = this.zzs(v);
                long v2 = (long)(0xFFFFF & v1);
                switch(v1 >>> 20 & 0xFF) {
                    case 9: 
                    case 17: {
                        if(this.zzI(object0, v)) {
                            this.zzv(v).zzf(zzen.zzb.getObject(object0, v2));
                        }
                        break;
                    }
                    case 18: 
                    case 19: 
                    case 20: 
                    case 21: 
                    case 22: 
                    case 23: 
                    case 24: 
                    case 25: 
                    case 26: 
                    case 27: 
                    case 28: 
                    case 29: 
                    case 30: 
                    case 0x1F: 
                    case 0x20: 
                    case 33: 
                    case 34: 
                    case 35: 
                    case 36: 
                    case 37: 
                    case 38: 
                    case 39: 
                    case 40: 
                    case 41: 
                    case 42: 
                    case 43: 
                    case 44: 
                    case 45: 
                    case 46: 
                    case 0x2F: 
                    case 0x30: 
                    case 49: {
                        this.zzl.zza(object0, v2);
                        break;
                    }
                    case 50: {
                        Unsafe unsafe0 = zzen.zzb;
                        Object object1 = unsafe0.getObject(object0, v2);
                        if(object1 != null) {
                            ((zzee)object1).zzc();
                            unsafe0.putObject(object0, v2, object1);
                        }
                        break;
                    }
                    case 60: 
                    case 68: {
                        if(this.zzM(object0, this.zzc[v], v)) {
                            this.zzv(v).zzf(zzen.zzb.getObject(object0, v2));
                        }
                    }
                }
            }
            this.zzm.zzg(object0);
            if(this.zzh) {
                this.zzn.zzb(object0);
            }
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.zzev
    public final void zzg(Object object0, Object object1) {
        zzen.zzA(object0);
        object1.getClass();
        for(int v = 0; v < this.zzc.length; v += 3) {
            int v1 = this.zzs(v);
            int v2 = this.zzc[v];
            long v3 = (long)(0xFFFFF & v1);
            switch(v1 >>> 20 & 0xFF) {
                case 0: {
                    if(this.zzI(object1, v)) {
                        zzfw.zzo(object0, v3, zzfw.zza(object1, v3));
                        this.zzD(object0, v);
                    }
                    break;
                }
                case 1: {
                    if(this.zzI(object1, v)) {
                        zzfw.zzp(object0, v3, zzfw.zzb(object1, v3));
                        this.zzD(object0, v);
                    }
                    break;
                }
                case 2: {
                    if(this.zzI(object1, v)) {
                        zzfw.zzr(object0, v3, zzfw.zzd(object1, v3));
                        this.zzD(object0, v);
                    }
                    break;
                }
                case 3: {
                    if(this.zzI(object1, v)) {
                        zzfw.zzr(object0, v3, zzfw.zzd(object1, v3));
                        this.zzD(object0, v);
                    }
                    break;
                }
                case 4: {
                    if(this.zzI(object1, v)) {
                        zzfw.zzq(object0, v3, zzfw.zzc(object1, v3));
                        this.zzD(object0, v);
                    }
                    break;
                }
                case 5: {
                    if(this.zzI(object1, v)) {
                        zzfw.zzr(object0, v3, zzfw.zzd(object1, v3));
                        this.zzD(object0, v);
                    }
                    break;
                }
                case 6: {
                    if(this.zzI(object1, v)) {
                        zzfw.zzq(object0, v3, zzfw.zzc(object1, v3));
                        this.zzD(object0, v);
                    }
                    break;
                }
                case 7: {
                    if(this.zzI(object1, v)) {
                        zzfw.zzm(object0, v3, zzfw.zzw(object1, v3));
                        this.zzD(object0, v);
                    }
                    break;
                }
                case 8: {
                    if(this.zzI(object1, v)) {
                        zzfw.zzs(object0, v3, zzfw.zzf(object1, v3));
                        this.zzD(object0, v);
                    }
                    break;
                }
                case 9: {
                    this.zzB(object0, object1, v);
                    break;
                }
                case 10: {
                    if(this.zzI(object1, v)) {
                        zzfw.zzs(object0, v3, zzfw.zzf(object1, v3));
                        this.zzD(object0, v);
                    }
                    break;
                }
                case 11: {
                    if(this.zzI(object1, v)) {
                        zzfw.zzq(object0, v3, zzfw.zzc(object1, v3));
                        this.zzD(object0, v);
                    }
                    break;
                }
                case 12: {
                    if(this.zzI(object1, v)) {
                        zzfw.zzq(object0, v3, zzfw.zzc(object1, v3));
                        this.zzD(object0, v);
                    }
                    break;
                }
                case 13: {
                    if(this.zzI(object1, v)) {
                        zzfw.zzq(object0, v3, zzfw.zzc(object1, v3));
                        this.zzD(object0, v);
                    }
                    break;
                }
                case 14: {
                    if(this.zzI(object1, v)) {
                        zzfw.zzr(object0, v3, zzfw.zzd(object1, v3));
                        this.zzD(object0, v);
                    }
                    break;
                }
                case 15: {
                    if(this.zzI(object1, v)) {
                        zzfw.zzq(object0, v3, zzfw.zzc(object1, v3));
                        this.zzD(object0, v);
                    }
                    break;
                }
                case 16: {
                    if(this.zzI(object1, v)) {
                        zzfw.zzr(object0, v3, zzfw.zzd(object1, v3));
                        this.zzD(object0, v);
                    }
                    break;
                }
                case 17: {
                    this.zzB(object0, object1, v);
                    break;
                }
                case 18: 
                case 19: 
                case 20: 
                case 21: 
                case 22: 
                case 23: 
                case 24: 
                case 25: 
                case 26: 
                case 27: 
                case 28: 
                case 29: 
                case 30: 
                case 0x1F: 
                case 0x20: 
                case 33: 
                case 34: 
                case 35: 
                case 36: 
                case 37: 
                case 38: 
                case 39: 
                case 40: 
                case 41: 
                case 42: 
                case 43: 
                case 44: 
                case 45: 
                case 46: 
                case 0x2F: 
                case 0x30: 
                case 49: {
                    this.zzl.zzb(object0, object1, v3);
                    break;
                }
                case 50: {
                    zzfw.zzs(object0, v3, zzef.zza(zzfw.zzf(object0, v3), zzfw.zzf(object1, v3)));
                    break;
                }
                case 51: 
                case 52: 
                case 53: 
                case 54: 
                case 55: 
                case 56: 
                case 57: 
                case 58: 
                case 59: {
                    if(this.zzM(object1, v2, v)) {
                        zzfw.zzs(object0, v3, zzfw.zzf(object1, v3));
                        this.zzE(object0, v2, v);
                    }
                    break;
                }
                case 60: {
                    this.zzC(object0, object1, v);
                    break;
                }
                case 61: 
                case 62: 
                case 0x3F: 
                case 0x40: 
                case 65: 
                case 66: 
                case 67: {
                    if(this.zzM(object1, v2, v)) {
                        zzfw.zzs(object0, v3, zzfw.zzf(object1, v3));
                        this.zzE(object0, v2, v);
                    }
                    break;
                }
                case 68: {
                    this.zzC(object0, object1, v);
                }
            }
        }
        zzex.zzp(this.zzm, object0, object1);
        if(!this.zzh) {
            return;
        }
        this.zzn.zza(object1);
        throw null;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzev
    public final void zzh(Object object0, byte[] arr_b, int v, int v1, zzbp zzbp0) throws IOException {
        this.zzc(object0, arr_b, v, v1, 0, zzbp0);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzev
    public final void zzi(Object object0, zzge zzge0) throws IOException {
        int v10;
        int v9;
        int v8;
        if(!this.zzh) {
            int[] arr_v = this.zzc;
            Unsafe unsafe0 = zzen.zzb;
            int v = 0xFFFFF;
            int v2 = 0;
            for(int v1 = 0; v2 < arr_v.length; v1 = v9) {
                int v3 = this.zzs(v2);
                int[] arr_v1 = this.zzc;
                int v4 = v3 >>> 20 & 0xFF;
                int v5 = arr_v1[v2];
                if(v4 <= 17) {
                    int v6 = arr_v1[v2 + 2];
                    int v7 = v6 & 0xFFFFF;
                    if(v7 != v) {
                        v1 = v7 == 0xFFFFF ? 0 : unsafe0.getInt(object0, ((long)v7));
                        v = v7;
                    }
                    v8 = v;
                    v9 = v1;
                    v10 = 1 << (v6 >>> 20);
                }
                else {
                    v8 = v;
                    v9 = v1;
                    v10 = 0;
                }
                long v11 = (long)(v3 & 0xFFFFF);
                switch(v4) {
                    case 0: {
                        if(this.zzJ(object0, v2, v8, v9, v10)) {
                            zzge0.zzf(v5, zzfw.zza(object0, v11));
                        }
                        break;
                    }
                    case 1: {
                        if(this.zzJ(object0, v2, v8, v9, v10)) {
                            zzge0.zzo(v5, zzfw.zzb(object0, v11));
                        }
                        break;
                    }
                    case 2: {
                        if(this.zzJ(object0, v2, v8, v9, v10)) {
                            zzge0.zzt(v5, unsafe0.getLong(object0, v11));
                        }
                        break;
                    }
                    case 3: {
                        if(this.zzJ(object0, v2, v8, v9, v10)) {
                            zzge0.zzJ(v5, unsafe0.getLong(object0, v11));
                        }
                        break;
                    }
                    case 4: {
                        if(this.zzJ(object0, v2, v8, v9, v10)) {
                            zzge0.zzr(v5, unsafe0.getInt(object0, v11));
                        }
                        break;
                    }
                    case 5: {
                        if(this.zzJ(object0, v2, v8, v9, v10)) {
                            zzge0.zzm(v5, unsafe0.getLong(object0, v11));
                        }
                        break;
                    }
                    case 6: {
                        if(this.zzJ(object0, v2, v8, v9, v10)) {
                            zzge0.zzk(v5, unsafe0.getInt(object0, v11));
                        }
                        break;
                    }
                    case 7: {
                        if(this.zzJ(object0, v2, v8, v9, v10)) {
                            zzge0.zzb(v5, zzfw.zzw(object0, v11));
                        }
                        break;
                    }
                    case 8: {
                        if(this.zzJ(object0, v2, v8, v9, v10)) {
                            zzen.zzO(v5, unsafe0.getObject(object0, v11), zzge0);
                        }
                        break;
                    }
                    case 9: {
                        if(this.zzJ(object0, v2, v8, v9, v10)) {
                            zzge0.zzv(v5, unsafe0.getObject(object0, v11), this.zzv(v2));
                        }
                        break;
                    }
                    case 10: {
                        if(this.zzJ(object0, v2, v8, v9, v10)) {
                            zzge0.zzd(v5, ((zzcc)unsafe0.getObject(object0, v11)));
                        }
                        break;
                    }
                    case 11: {
                        if(this.zzJ(object0, v2, v8, v9, v10)) {
                            zzge0.zzH(v5, unsafe0.getInt(object0, v11));
                        }
                        break;
                    }
                    case 12: {
                        if(this.zzJ(object0, v2, v8, v9, v10)) {
                            zzge0.zzi(v5, unsafe0.getInt(object0, v11));
                        }
                        break;
                    }
                    case 13: {
                        if(this.zzJ(object0, v2, v8, v9, v10)) {
                            zzge0.zzw(v5, unsafe0.getInt(object0, v11));
                        }
                        break;
                    }
                    case 14: {
                        if(this.zzJ(object0, v2, v8, v9, v10)) {
                            zzge0.zzy(v5, unsafe0.getLong(object0, v11));
                        }
                        break;
                    }
                    case 15: {
                        if(this.zzJ(object0, v2, v8, v9, v10)) {
                            zzge0.zzA(v5, unsafe0.getInt(object0, v11));
                        }
                        break;
                    }
                    case 16: {
                        if(this.zzJ(object0, v2, v8, v9, v10)) {
                            zzge0.zzC(v5, unsafe0.getLong(object0, v11));
                        }
                        break;
                    }
                    case 17: {
                        if(this.zzJ(object0, v2, v8, v9, v10)) {
                            zzge0.zzq(v5, unsafe0.getObject(object0, v11), this.zzv(v2));
                        }
                        break;
                    }
                    case 18: {
                        zzex.zzs(this.zzc[v2], ((List)unsafe0.getObject(object0, v11)), zzge0, false);
                        break;
                    }
                    case 19: {
                        zzex.zzw(this.zzc[v2], ((List)unsafe0.getObject(object0, v11)), zzge0, false);
                        break;
                    }
                    case 20: {
                        zzex.zzy(this.zzc[v2], ((List)unsafe0.getObject(object0, v11)), zzge0, false);
                        break;
                    }
                    case 21: {
                        zzex.zzE(this.zzc[v2], ((List)unsafe0.getObject(object0, v11)), zzge0, false);
                        break;
                    }
                    case 22: {
                        zzex.zzx(this.zzc[v2], ((List)unsafe0.getObject(object0, v11)), zzge0, false);
                        break;
                    }
                    case 23: {
                        zzex.zzv(this.zzc[v2], ((List)unsafe0.getObject(object0, v11)), zzge0, false);
                        break;
                    }
                    case 24: {
                        zzex.zzu(this.zzc[v2], ((List)unsafe0.getObject(object0, v11)), zzge0, false);
                        break;
                    }
                    case 25: {
                        zzex.zzr(this.zzc[v2], ((List)unsafe0.getObject(object0, v11)), zzge0, false);
                        break;
                    }
                    case 26: {
                        int v12 = this.zzc[v2];
                        List list0 = (List)unsafe0.getObject(object0, v11);
                        if(list0 != null && !list0.isEmpty()) {
                            zzge0.zzG(v12, list0);
                        }
                        break;
                    }
                    case 27: {
                        int v13 = this.zzc[v2];
                        List list1 = (List)unsafe0.getObject(object0, v11);
                        zzev zzev0 = this.zzv(v2);
                        if(list1 != null && !list1.isEmpty()) {
                            for(int v14 = 0; v14 < list1.size(); ++v14) {
                                ((zzcl)zzge0).zzv(v13, list1.get(v14), zzev0);
                            }
                        }
                        break;
                    }
                    case 28: {
                        int v15 = this.zzc[v2];
                        List list2 = (List)unsafe0.getObject(object0, v11);
                        if(list2 != null && !list2.isEmpty()) {
                            zzge0.zze(v15, list2);
                        }
                        break;
                    }
                    case 29: {
                        zzex.zzD(this.zzc[v2], ((List)unsafe0.getObject(object0, v11)), zzge0, false);
                        break;
                    }
                    case 30: {
                        zzex.zzt(this.zzc[v2], ((List)unsafe0.getObject(object0, v11)), zzge0, false);
                        break;
                    }
                    case 0x1F: {
                        zzex.zzz(this.zzc[v2], ((List)unsafe0.getObject(object0, v11)), zzge0, false);
                        break;
                    }
                    case 0x20: {
                        zzex.zzA(this.zzc[v2], ((List)unsafe0.getObject(object0, v11)), zzge0, false);
                        break;
                    }
                    case 33: {
                        zzex.zzB(this.zzc[v2], ((List)unsafe0.getObject(object0, v11)), zzge0, false);
                        break;
                    }
                    case 34: {
                        zzex.zzC(this.zzc[v2], ((List)unsafe0.getObject(object0, v11)), zzge0, false);
                        break;
                    }
                    case 35: {
                        zzex.zzs(this.zzc[v2], ((List)unsafe0.getObject(object0, v11)), zzge0, true);
                        break;
                    }
                    case 36: {
                        zzex.zzw(this.zzc[v2], ((List)unsafe0.getObject(object0, v11)), zzge0, true);
                        break;
                    }
                    case 37: {
                        zzex.zzy(this.zzc[v2], ((List)unsafe0.getObject(object0, v11)), zzge0, true);
                        break;
                    }
                    case 38: {
                        zzex.zzE(this.zzc[v2], ((List)unsafe0.getObject(object0, v11)), zzge0, true);
                        break;
                    }
                    case 39: {
                        zzex.zzx(this.zzc[v2], ((List)unsafe0.getObject(object0, v11)), zzge0, true);
                        break;
                    }
                    case 40: {
                        zzex.zzv(this.zzc[v2], ((List)unsafe0.getObject(object0, v11)), zzge0, true);
                        break;
                    }
                    case 41: {
                        zzex.zzu(this.zzc[v2], ((List)unsafe0.getObject(object0, v11)), zzge0, true);
                        break;
                    }
                    case 42: {
                        zzex.zzr(this.zzc[v2], ((List)unsafe0.getObject(object0, v11)), zzge0, true);
                        break;
                    }
                    case 43: {
                        zzex.zzD(this.zzc[v2], ((List)unsafe0.getObject(object0, v11)), zzge0, true);
                        break;
                    }
                    case 44: {
                        zzex.zzt(this.zzc[v2], ((List)unsafe0.getObject(object0, v11)), zzge0, true);
                        break;
                    }
                    case 45: {
                        zzex.zzz(this.zzc[v2], ((List)unsafe0.getObject(object0, v11)), zzge0, true);
                        break;
                    }
                    case 46: {
                        zzex.zzA(this.zzc[v2], ((List)unsafe0.getObject(object0, v11)), zzge0, true);
                        break;
                    }
                    case 0x2F: {
                        zzex.zzB(this.zzc[v2], ((List)unsafe0.getObject(object0, v11)), zzge0, true);
                        break;
                    }
                    case 0x30: {
                        zzex.zzC(this.zzc[v2], ((List)unsafe0.getObject(object0, v11)), zzge0, true);
                        break;
                    }
                    case 49: {
                        int v16 = this.zzc[v2];
                        List list3 = (List)unsafe0.getObject(object0, v11);
                        zzev zzev1 = this.zzv(v2);
                        if(list3 != null && !list3.isEmpty()) {
                            for(int v17 = 0; v17 < list3.size(); ++v17) {
                                ((zzcl)zzge0).zzq(v16, list3.get(v17), zzev1);
                            }
                        }
                        break;
                    }
                    case 50: {
                        if(unsafe0.getObject(object0, v11) != null) {
                            zzed zzed0 = (zzed)this.zzw(v2);
                            throw null;
                        }
                        break;
                    }
                    case 51: {
                        if(this.zzM(object0, v5, v2)) {
                            zzge0.zzf(v5, zzen.zzm(object0, v11));
                        }
                        break;
                    }
                    case 52: {
                        if(this.zzM(object0, v5, v2)) {
                            zzge0.zzo(v5, zzen.zzn(object0, v11));
                        }
                        break;
                    }
                    case 53: {
                        if(this.zzM(object0, v5, v2)) {
                            zzge0.zzt(v5, zzen.zzt(object0, v11));
                        }
                        break;
                    }
                    case 54: {
                        if(this.zzM(object0, v5, v2)) {
                            zzge0.zzJ(v5, zzen.zzt(object0, v11));
                        }
                        break;
                    }
                    case 55: {
                        if(this.zzM(object0, v5, v2)) {
                            zzge0.zzr(v5, zzen.zzo(object0, v11));
                        }
                        break;
                    }
                    case 56: {
                        if(this.zzM(object0, v5, v2)) {
                            zzge0.zzm(v5, zzen.zzt(object0, v11));
                        }
                        break;
                    }
                    case 57: {
                        if(this.zzM(object0, v5, v2)) {
                            zzge0.zzk(v5, zzen.zzo(object0, v11));
                        }
                        break;
                    }
                    case 58: {
                        if(this.zzM(object0, v5, v2)) {
                            zzge0.zzb(v5, zzen.zzN(object0, v11));
                        }
                        break;
                    }
                    case 59: {
                        if(this.zzM(object0, v5, v2)) {
                            zzen.zzO(v5, unsafe0.getObject(object0, v11), zzge0);
                        }
                        break;
                    }
                    case 60: {
                        if(this.zzM(object0, v5, v2)) {
                            zzge0.zzv(v5, unsafe0.getObject(object0, v11), this.zzv(v2));
                        }
                        break;
                    }
                    case 61: {
                        if(this.zzM(object0, v5, v2)) {
                            zzge0.zzd(v5, ((zzcc)unsafe0.getObject(object0, v11)));
                        }
                        break;
                    }
                    case 62: {
                        if(this.zzM(object0, v5, v2)) {
                            zzge0.zzH(v5, zzen.zzo(object0, v11));
                        }
                        break;
                    }
                    case 0x3F: {
                        if(this.zzM(object0, v5, v2)) {
                            zzge0.zzi(v5, zzen.zzo(object0, v11));
                        }
                        break;
                    }
                    case 0x40: {
                        if(this.zzM(object0, v5, v2)) {
                            zzge0.zzw(v5, zzen.zzo(object0, v11));
                        }
                        break;
                    }
                    case 65: {
                        if(this.zzM(object0, v5, v2)) {
                            zzge0.zzy(v5, zzen.zzt(object0, v11));
                        }
                        break;
                    }
                    case 66: {
                        if(this.zzM(object0, v5, v2)) {
                            zzge0.zzA(v5, zzen.zzo(object0, v11));
                        }
                        break;
                    }
                    case 67: {
                        if(this.zzM(object0, v5, v2)) {
                            zzge0.zzC(v5, zzen.zzt(object0, v11));
                        }
                        break;
                    }
                    case 68: {
                        if(this.zzM(object0, v5, v2)) {
                            zzge0.zzq(v5, unsafe0.getObject(object0, v11), this.zzv(v2));
                        }
                    }
                }
                v2 += 3;
                v = v8;
            }
            Object object1 = this.zzm.zzd(object0);
            this.zzm.zzi(object1, zzge0);
            return;
        }
        this.zzn.zza(object0);
        throw null;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzev
    public final boolean zzj(Object object0, Object object1) {
        boolean z;
        int v = 0;
        while(v < this.zzc.length) {
            int v1 = this.zzs(v);
            long v2 = (long)(v1 & 0xFFFFF);
            switch(v1 >>> 20 & 0xFF) {
                case 0: {
                    if(!this.zzH(object0, object1, v) || Double.doubleToLongBits(zzfw.zza(object0, v2)) != Double.doubleToLongBits(zzfw.zza(object1, v2))) {
                        return false;
                    }
                    break;
                }
                case 1: {
                    if(this.zzH(object0, object1, v) && Float.floatToIntBits(zzfw.zzb(object0, v2)) == Float.floatToIntBits(zzfw.zzb(object1, v2))) {
                        break;
                    }
                    return false;
                }
                case 2: {
                    if(this.zzH(object0, object1, v) && zzfw.zzd(object0, v2) == zzfw.zzd(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 3: {
                    if(this.zzH(object0, object1, v) && zzfw.zzd(object0, v2) == zzfw.zzd(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 4: {
                    if(this.zzH(object0, object1, v) && zzfw.zzc(object0, v2) == zzfw.zzc(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 5: {
                    if(this.zzH(object0, object1, v) && zzfw.zzd(object0, v2) == zzfw.zzd(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 6: {
                    if(this.zzH(object0, object1, v) && zzfw.zzc(object0, v2) == zzfw.zzc(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 7: {
                    if(this.zzH(object0, object1, v) && zzfw.zzw(object0, v2) == zzfw.zzw(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 8: {
                    if(this.zzH(object0, object1, v) && zzex.zzF(zzfw.zzf(object0, v2), zzfw.zzf(object1, v2))) {
                        break;
                    }
                    return false;
                }
                case 9: {
                    if(this.zzH(object0, object1, v) && zzex.zzF(zzfw.zzf(object0, v2), zzfw.zzf(object1, v2))) {
                        break;
                    }
                    return false;
                }
                case 10: {
                    if(this.zzH(object0, object1, v) && zzex.zzF(zzfw.zzf(object0, v2), zzfw.zzf(object1, v2))) {
                        break;
                    }
                    return false;
                }
                case 11: {
                    if(this.zzH(object0, object1, v) && zzfw.zzc(object0, v2) == zzfw.zzc(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 12: {
                    if(this.zzH(object0, object1, v) && zzfw.zzc(object0, v2) == zzfw.zzc(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 13: {
                    if(this.zzH(object0, object1, v) && zzfw.zzc(object0, v2) == zzfw.zzc(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 14: {
                    if(this.zzH(object0, object1, v) && zzfw.zzd(object0, v2) == zzfw.zzd(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 15: {
                    if(this.zzH(object0, object1, v) && zzfw.zzc(object0, v2) == zzfw.zzc(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 16: {
                    if(this.zzH(object0, object1, v) && zzfw.zzd(object0, v2) == zzfw.zzd(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 17: {
                    if(this.zzH(object0, object1, v) && zzex.zzF(zzfw.zzf(object0, v2), zzfw.zzf(object1, v2))) {
                        break;
                    }
                    return false;
                }
                case 18: 
                case 19: 
                case 20: 
                case 21: 
                case 22: 
                case 23: 
                case 24: 
                case 25: 
                case 26: 
                case 27: 
                case 28: 
                case 29: 
                case 30: 
                case 0x1F: 
                case 0x20: 
                case 33: 
                case 34: 
                case 35: 
                case 36: 
                case 37: 
                case 38: 
                case 39: 
                case 40: 
                case 41: 
                case 42: 
                case 43: 
                case 44: 
                case 45: 
                case 46: 
                case 0x2F: 
                case 0x30: 
                case 49: {
                    z = zzex.zzF(zzfw.zzf(object0, v2), zzfw.zzf(object1, v2));
                    goto label_45;
                }
                case 50: {
                    z = zzex.zzF(zzfw.zzf(object0, v2), zzfw.zzf(object1, v2));
                label_45:
                    if(!z) {
                        return false;
                    }
                    break;
                }
                case 51: 
                case 52: 
                case 53: 
                case 54: 
                case 55: 
                case 56: 
                case 57: 
                case 58: 
                case 59: 
                case 60: 
                case 61: 
                case 62: 
                case 0x3F: 
                case 0x40: 
                case 65: 
                case 66: 
                case 67: 
                case 68: {
                    int v3 = this.zzp(v);
                    if(zzfw.zzc(object0, ((long)(v3 & 0xFFFFF))) != zzfw.zzc(object1, ((long)(v3 & 0xFFFFF))) || !zzex.zzF(zzfw.zzf(object0, v2), zzfw.zzf(object1, v2))) {
                        return false;
                    }
                }
            }
            v += 3;
        }
        if(!this.zzm.zzd(object0).equals(this.zzm.zzd(object1))) {
            return false;
        }
        if(!this.zzh) {
            return true;
        }
        this.zzn.zza(object0);
        this.zzn.zza(object1);
        throw null;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzev
    public final boolean zzk(Object object0) {
        int v10;
        int v9;
        int v1 = 0;
        int v2 = 0xFFFFF;
        for(int v = 0; v1 < this.zzj; v = v9) {
            int v3 = this.zzi[v1];
            int v4 = this.zzc[v3];
            int v5 = this.zzs(v3);
            int v6 = this.zzc[v3 + 2];
            int v7 = v6 & 0xFFFFF;
            int v8 = 1 << (v6 >>> 20);
            if(v7 == v2) {
                v10 = v2;
                v9 = v;
            }
            else {
                if(v7 != 0xFFFFF) {
                    v = zzen.zzb.getInt(object0, ((long)v7));
                }
                v9 = v;
                v10 = v7;
            }
            if((0x10000000 & v5) != 0 && !this.zzJ(object0, v3, v10, v9, v8)) {
                return false;
            }
            switch(v5 >>> 20 & 0xFF) {
                case 9: 
                case 17: {
                    if(this.zzJ(object0, v3, v10, v9, v8) && !zzen.zzK(object0, v5, this.zzv(v3))) {
                        return false;
                    }
                    break;
                }
                case 27: 
                case 49: {
                    List list0 = (List)zzfw.zzf(object0, ((long)(v5 & 0xFFFFF)));
                    if(!list0.isEmpty()) {
                        zzev zzev0 = this.zzv(v3);
                        for(int v11 = 0; v11 < list0.size(); ++v11) {
                            if(!zzev0.zzk(list0.get(v11))) {
                                return false;
                            }
                        }
                    }
                    break;
                }
                case 50: {
                    if(!((zzee)zzfw.zzf(object0, ((long)(v5 & 0xFFFFF)))).isEmpty()) {
                        zzed zzed0 = (zzed)this.zzw(v3);
                        throw null;
                    }
                    break;
                }
                case 60: 
                case 68: {
                    if(this.zzM(object0, v4, v3) && !zzen.zzK(object0, v5, this.zzv(v3))) {
                        return false;
                    }
                }
            }
            ++v1;
            v2 = v10;
        }
        if(!this.zzh) {
            return true;
        }
        this.zzn.zza(object0);
        throw null;
    }

    static zzen zzl(Class class0, zzeh zzeh0, zzep zzep0, zzdy zzdy0, zzfm zzfm0, zzcq zzcq0, zzef zzef0) {
        Field field3;
        int v93;
        int v85;
        zzeu zzeu1;
        int v83;
        int v82;
        int v81;
        String s1;
        Field field1;
        int v80;
        int v79;
        Field field0;
        int v77;
        int v76;
        int v69;
        int v63;
        int v14;
        int[] arr_v;
        int v13;
        int v12;
        int v11;
        int v10;
        int v9;
        int v8;
        int v2;
        if(zzeh0 instanceof zzeu) {
            zzeu zzeu0 = (zzeu)zzeh0;
            String s = zzeu0.zzd();
            int v = s.length();
            if(s.charAt(0) >= 0xD800) {
                for(int v1 = 1; true; v1 = v2) {
                    v2 = v1 + 1;
                    if(s.charAt(v1) < 0xD800) {
                        break;
                    }
                }
            }
            else {
                v2 = 1;
            }
            int v3 = v2 + 1;
            int v4 = s.charAt(v2);
            if(v4 >= 0xD800) {
                int v5 = v4 & 0x1FFF;
                int v6 = 13;
                int v7;
                while((v7 = s.charAt(v3)) >= 0xD800) {
                    v5 |= (v7 & 0x1FFF) << v6;
                    v6 += 13;
                    ++v3;
                }
                v4 = v5 | v7 << v6;
                ++v3;
            }
            if(v4 == 0) {
                v8 = 0;
                v9 = 0;
                v10 = 0;
                v11 = 0;
                v12 = 0;
                v13 = 0;
                arr_v = zzen.zza;
                v14 = 0;
            }
            else {
                int v15 = v3 + 1;
                int v16 = s.charAt(v3);
                if(v16 >= 0xD800) {
                    int v17 = v16 & 0x1FFF;
                    int v18 = 13;
                    int v19;
                    while((v19 = s.charAt(v15)) >= 0xD800) {
                        v17 |= (v19 & 0x1FFF) << v18;
                        v18 += 13;
                        ++v15;
                    }
                    v16 = v17 | v19 << v18;
                    ++v15;
                }
                int v20 = v15 + 1;
                int v21 = s.charAt(v15);
                if(v21 >= 0xD800) {
                    int v22 = v21 & 0x1FFF;
                    int v23 = 13;
                    int v24;
                    while((v24 = s.charAt(v20)) >= 0xD800) {
                        v22 |= (v24 & 0x1FFF) << v23;
                        v23 += 13;
                        ++v20;
                    }
                    v21 = v22 | v24 << v23;
                    ++v20;
                }
                int v25 = v20 + 1;
                int v26 = s.charAt(v20);
                if(v26 >= 0xD800) {
                    int v27 = v26 & 0x1FFF;
                    int v28 = 13;
                    int v29;
                    while((v29 = s.charAt(v25)) >= 0xD800) {
                        v27 |= (v29 & 0x1FFF) << v28;
                        v28 += 13;
                        ++v25;
                    }
                    v26 = v27 | v29 << v28;
                    ++v25;
                }
                int v30 = v25 + 1;
                int v31 = s.charAt(v25);
                if(v31 >= 0xD800) {
                    int v32 = v31 & 0x1FFF;
                    int v33 = 13;
                    int v34;
                    while((v34 = s.charAt(v30)) >= 0xD800) {
                        v32 |= (v34 & 0x1FFF) << v33;
                        v33 += 13;
                        ++v30;
                    }
                    v31 = v32 | v34 << v33;
                    ++v30;
                }
                int v35 = v30 + 1;
                v8 = s.charAt(v30);
                if(v8 >= 0xD800) {
                    int v36 = v8 & 0x1FFF;
                    int v37 = 13;
                    int v38;
                    while((v38 = s.charAt(v35)) >= 0xD800) {
                        v36 |= (v38 & 0x1FFF) << v37;
                        v37 += 13;
                        ++v35;
                    }
                    v8 = v36 | v38 << v37;
                    ++v35;
                }
                int v39 = v35 + 1;
                v9 = s.charAt(v35);
                if(v9 >= 0xD800) {
                    int v40 = v9 & 0x1FFF;
                    int v41 = 13;
                    int v42;
                    while((v42 = s.charAt(v39)) >= 0xD800) {
                        v40 |= (v42 & 0x1FFF) << v41;
                        v41 += 13;
                        ++v39;
                    }
                    v9 = v40 | v42 << v41;
                    ++v39;
                }
                int v43 = v39 + 1;
                int v44 = s.charAt(v39);
                if(v44 >= 0xD800) {
                    int v45 = v44 & 0x1FFF;
                    int v46 = 13;
                    int v47;
                    while((v47 = s.charAt(v43)) >= 0xD800) {
                        v45 |= (v47 & 0x1FFF) << v46;
                        v46 += 13;
                        ++v43;
                    }
                    v44 = v45 | v47 << v46;
                    ++v43;
                }
                int v48 = v43 + 1;
                int v49 = s.charAt(v43);
                if(v49 >= 0xD800) {
                    int v50 = v49 & 0x1FFF;
                    int v51 = 13;
                    int v52;
                    while((v52 = s.charAt(v48)) >= 0xD800) {
                        v50 |= (v52 & 0x1FFF) << v51;
                        v51 += 13;
                        ++v48;
                    }
                    v49 = v50 | v52 << v51;
                    ++v48;
                }
                v12 = v16 * 2 + v21;
                arr_v = new int[v49 + v9 + v44];
                v10 = v26;
                v13 = v49;
                v14 = v16;
                v11 = v31;
                v3 = v48;
            }
            Unsafe unsafe0 = zzen.zzb;
            Object[] arr_object = zzeu0.zze();
            Class class1 = zzeu0.zza().getClass();
            int v53 = v13 + v9;
            int[] arr_v1 = new int[v8 * 3];
            Object[] arr_object1 = new Object[v8 + v8];
            int v54 = 0;
            int v55 = 0;
            int v56 = v13;
            int v57 = v53;
            while(v3 < v) {
                int v58 = s.charAt(v3);
                if(v58 >= 0xD800) {
                    int v59 = v58 & 0x1FFF;
                    int v60 = v3 + 1;
                    int v61 = 13;
                    int v62;
                    while((v62 = s.charAt(v60)) >= 0xD800) {
                        v59 |= (v62 & 0x1FFF) << v61;
                        v61 += 13;
                        ++v60;
                    }
                    v58 = v59 | v62 << v61;
                    v63 = v60 + 1;
                }
                else {
                    v63 = v3 + 1;
                }
                int v64 = s.charAt(v63);
                if(v64 >= 0xD800) {
                    int v65 = v64 & 0x1FFF;
                    int v66 = v63 + 1;
                    int v67 = 13;
                    int v68;
                    while((v68 = s.charAt(v66)) >= 0xD800) {
                        v65 |= (v68 & 0x1FFF) << v67;
                        v67 += 13;
                        ++v66;
                    }
                    v64 = v65 | v68 << v67;
                    v69 = v66 + 1;
                }
                else {
                    v69 = v63 + 1;
                }
                if((v64 & 0x400) != 0) {
                    arr_v[v54] = v55;
                    ++v54;
                }
                int v70 = v64 & 0x800;
                if((v64 & 0xFF) >= 51) {
                    int v71 = s.charAt(v69);
                    if(v71 >= 0xD800) {
                        int v72 = 13;
                        int v73 = v71 & 0x1FFF;
                        int v74 = v69 + 1;
                        int v75;
                        while((v75 = s.charAt(v74)) >= 0xD800) {
                            v73 |= (v75 & 0x1FFF) << v72;
                            v72 += 13;
                            ++v74;
                        }
                        v71 = v73 | v75 << v72;
                        v76 = v74 + 1;
                    }
                    else {
                        v76 = v69 + 1;
                    }
                    v77 = v11;
                    switch((v64 & 0xFF) - 51) {
                        case 12: {
                            if(zzeu0.zzc() == 1 || v70 != 0) {
                                arr_object1[v55 / 3 + v55 / 3 + 1] = arr_object[v12];
                                ++v12;
                            }
                            else {
                                v70 = 0;
                            }
                            break;
                        }
                        case 9: 
                        case 17: {
                            arr_object1[v55 / 3 + v55 / 3 + 1] = arr_object[v12];
                            ++v12;
                        }
                    }
                    int v78 = v71 + v71;
                    Object object0 = arr_object[v78];
                    if(object0 instanceof Field) {
                        field0 = (Field)object0;
                    }
                    else {
                        field0 = zzen.zzz(class1, ((String)object0));
                        arr_object[v78] = field0;
                    }
                    v79 = v10;
                    v80 = (int)unsafe0.objectFieldOffset(field0);
                    Object object1 = arr_object[v78 + 1];
                    if(object1 instanceof Field) {
                        field1 = (Field)object1;
                    }
                    else {
                        field1 = zzen.zzz(class1, ((String)object1));
                        arr_object[v78 + 1] = field1;
                    }
                    s1 = s;
                    v81 = (int)unsafe0.objectFieldOffset(field1);
                    v82 = v76;
                    v83 = 0;
                    zzeu1 = zzeu0;
                }
                else {
                    v79 = v10;
                    v77 = v11;
                    int v84 = v12 + 1;
                    Field field2 = zzen.zzz(class1, ((String)arr_object[v12]));
                    switch(v64 & 0xFF) {
                        case 9: 
                        case 17: {
                            zzeu1 = zzeu0;
                            arr_object1[v55 / 3 + v55 / 3 + 1] = field2.getType();
                            break;
                        }
                        case 27: {
                            zzeu1 = zzeu0;
                            v85 = v84 + 1;
                            arr_object1[v55 / 3 + v55 / 3 + 1] = arr_object[v84];
                            v84 = v85;
                            break;
                        }
                        case 12: 
                        case 30: 
                        case 44: {
                            zzeu1 = zzeu0;
                            if(zzeu0.zzc() == 1 || v70 != 0) {
                                v85 = v84 + 1;
                                arr_object1[v55 / 3 + v55 / 3 + 1] = arr_object[v84];
                                v84 = v85;
                            }
                            else {
                                v70 = 0;
                            }
                            break;
                        }
                        case 49: {
                            zzeu1 = zzeu0;
                            arr_object1[v55 / 3 + v55 / 3 + 1] = arr_object[v84];
                            ++v84;
                            break;
                        }
                        case 50: {
                            int v86 = v84 + 1;
                            arr_v[v56] = v55;
                            int v87 = v55 / 3 + v55 / 3;
                            arr_object1[v87] = arr_object[v84];
                            if(v70 == 0) {
                                v84 = v86;
                                ++v56;
                                v70 = 0;
                            }
                            else {
                                v84 = v86 + 1;
                                arr_object1[v87 + 1] = arr_object[v86];
                                ++v56;
                            }
                            zzeu1 = zzeu0;
                            break;
                        }
                        default: {
                            zzeu1 = zzeu0;
                            break;
                        }
                    }
                    int v88 = (int)unsafe0.objectFieldOffset(field2);
                    v81 = 0xFFFFF;
                    if((v64 & 0x1000) == 0 || (v64 & 0xFF) > 17) {
                        s1 = s;
                        v82 = v69;
                        v83 = 0;
                    }
                    else {
                        int v89 = v69 + 1;
                        int v90 = s.charAt(v69);
                        if(v90 >= 0xD800) {
                            int v91 = v90 & 0x1FFF;
                            int v92 = 13;
                            while(true) {
                                v82 = v89 + 1;
                                v93 = s.charAt(v89);
                                if(v93 < 0xD800) {
                                    break;
                                }
                                v91 |= (v93 & 0x1FFF) << v92;
                                v92 += 13;
                                v89 = v82;
                            }
                            v90 = v91 | v93 << v92;
                        }
                        else {
                            v82 = v89;
                        }
                        int v94 = v90 / 0x20 + v14 * 2;
                        Object object2 = arr_object[v94];
                        s1 = s;
                        if(object2 instanceof Field) {
                            field3 = (Field)object2;
                        }
                        else {
                            field3 = zzen.zzz(class1, ((String)object2));
                            arr_object[v94] = field3;
                        }
                        v83 = v90 % 0x20;
                        v81 = (int)unsafe0.objectFieldOffset(field3);
                    }
                    if((v64 & 0xFF) >= 18 && (v64 & 0xFF) <= 49) {
                        arr_v[v57] = v88;
                        ++v57;
                    }
                    v12 = v84;
                    v80 = v88;
                }
                arr_v1[v55] = v58;
                int v95 = v55 + 2;
                arr_v1[v55 + 1] = v80 | (((v64 & 0x100) == 0 ? 0 : 0x10000000) | ((v64 & 0x200) == 0 ? 0 : 0x20000000) | (v70 == 0 ? 0 : 0x80000000) | (v64 & 0xFF) << 20);
                v55 = v95 + 1;
                arr_v1[v95] = v83 << 20 | v81;
                v3 = v82;
                zzeu0 = zzeu1;
                s = s1;
                v11 = v77;
                v10 = v79;
            }
            return new zzen(arr_v1, arr_object1, v10, v11, zzeu0.zza(), zzeu0.zzc(), false, arr_v, v13, v53, zzep0, zzdy0, zzfm0, zzcq0, zzef0);
        }
        zzfj zzfj0 = (zzfj)zzeh0;
        throw null;
    }

    private static double zzm(Object object0, long v) {
        return (double)(((Double)zzfw.zzf(object0, v)));
    }

    private static float zzn(Object object0, long v) {
        return (float)(((Float)zzfw.zzf(object0, v)));
    }

    private static int zzo(Object object0, long v) {
        return (int)(((Integer)zzfw.zzf(object0, v)));
    }

    private final int zzp(int v) {
        return this.zzc[v + 2];
    }

    private final int zzq(int v, int v1) {
        int v2 = this.zzc.length / 3 - 1;
        while(v1 <= v2) {
            int v3 = v2 + v1 >>> 1;
            int v4 = v3 * 3;
            int v5 = this.zzc[v4];
            if(v == v5) {
                return v4;
            }
            if(v < v5) {
                v2 = v3 - 1;
            }
            else {
                v1 = v3 + 1;
            }
        }
        return -1;
    }

    private static int zzr(int v) [...] // Inlined contents

    private final int zzs(int v) {
        return this.zzc[v + 1];
    }

    private static long zzt(Object object0, long v) {
        return (long)(((Long)zzfw.zzf(object0, v)));
    }

    private final zzdh zzu(int v) {
        return (zzdh)this.zzd[v / 3 * 2 + 1];
    }

    private final zzev zzv(int v) {
        Object[] arr_object = this.zzd;
        int v1 = v / 3 + v / 3;
        zzev zzev0 = (zzev)arr_object[v1];
        if(zzev0 != null) {
            return zzev0;
        }
        zzev zzev1 = zzes.zza().zzb(((Class)arr_object[v1 + 1]));
        this.zzd[v1] = zzev1;
        return zzev1;
    }

    private final Object zzw(int v) {
        return this.zzd[v / 3 + v / 3];
    }

    private final Object zzx(Object object0, int v) {
        zzev zzev0 = this.zzv(v);
        int v1 = this.zzs(v);
        if(!this.zzI(object0, v)) {
            return zzev0.zze();
        }
        Object object1 = zzen.zzb.getObject(object0, ((long)(v1 & 0xFFFFF)));
        if(zzen.zzL(object1)) {
            return object1;
        }
        Object object2 = zzev0.zze();
        if(object1 != null) {
            zzev0.zzg(object2, object1);
        }
        return object2;
    }

    private final Object zzy(Object object0, int v, int v1) {
        zzev zzev0 = this.zzv(v1);
        if(!this.zzM(object0, v, v1)) {
            return zzev0.zze();
        }
        int v2 = this.zzs(v1);
        Object object1 = zzen.zzb.getObject(object0, ((long)(v2 & 0xFFFFF)));
        if(zzen.zzL(object1)) {
            return object1;
        }
        Object object2 = zzev0.zze();
        if(object1 != null) {
            zzev0.zzg(object2, object1);
        }
        return object2;
    }

    private static Field zzz(Class class0, String s) {
        try {
            return class0.getDeclaredField(s);
        }
        catch(NoSuchFieldException unused_ex) {
            Field[] arr_field = class0.getDeclaredFields();
            for(int v = 0; v < arr_field.length; ++v) {
                Field field0 = arr_field[v];
                if(s.equals(field0.getName())) {
                    return field0;
                }
            }
            throw new RuntimeException("Field " + s + " for " + class0.getName() + " not found. Known fields are " + Arrays.toString(arr_field));
        }
    }
}

