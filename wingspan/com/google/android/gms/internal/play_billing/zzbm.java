package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class zzbm implements zzek {
    protected int zza;

    public zzbm() {
        this.zza = 0;
    }

    int zza(zzev zzev0) {
        throw null;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzek
    public final zzcc zzb() {
        try {
            int v = this.zzg();
            byte[] arr_b = new byte[v];
            zzck zzck0 = zzck.zzy(arr_b, 0, v);
            this.zzv(zzck0);
            zzck0.zzz();
            return new zzbz(arr_b);
        }
        catch(IOException iOException0) {
            throw new RuntimeException("Serializing " + this.getClass().getName() + " to a ByteString threw an IOException (should never happen).", iOException0);
        }
    }

    protected static void zzc(Iterable iterable0, List list0) {
        iterable0.getClass();
        if(iterable0 instanceof zzds) {
            List list1 = ((zzds)iterable0).zzh();
            int v = list0.size();
            for(Object object0: list1) {
                if(object0 == null) {
                    String s = "Element at index " + (((zzds)list0).size() - v) + " is null.";
                    int v1 = ((zzds)list0).size();
                    while(true) {
                        --v1;
                        if(v1 < v) {
                            break;
                        }
                        ((zzds)list0).remove(v1);
                    }
                    throw new NullPointerException(s);
                }
                if(object0 instanceof zzcc) {
                    ((zzds)list0).zzi(((zzcc)object0));
                }
                else {
                    ((zzds)list0).add(((String)object0));
                }
            }
            return;
        }
        if(!(iterable0 instanceof zzer)) {
            if(list0 instanceof ArrayList) {
                ((ArrayList)list0).ensureCapacity(list0.size() + ((Collection)iterable0).size());
            }
            int v2 = list0.size();
            for(Object object1: iterable0) {
                if(object1 == null) {
                    String s1 = "Element at index " + (list0.size() - v2) + " is null.";
                    int v3 = list0.size();
                    while(true) {
                        --v3;
                        if(v3 < v2) {
                            break;
                        }
                        list0.remove(v3);
                    }
                    throw new NullPointerException(s1);
                }
                list0.add(object1);
            }
            return;
        }
        list0.addAll(((Collection)iterable0));
    }

    public final byte[] zzd() {
        try {
            int v = this.zzg();
            byte[] arr_b = new byte[v];
            zzck zzck0 = zzck.zzy(arr_b, 0, v);
            this.zzv(zzck0);
            zzck0.zzz();
            return arr_b;
        }
        catch(IOException iOException0) {
            throw new RuntimeException("Serializing " + this.getClass().getName() + " to a byte array threw an IOException (should never happen).", iOException0);
        }
    }
}

