package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.tasks.Task;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class zzk {
    private static zzk zzal;
    private final Map zzam;
    private final Set zzan;
    private final Map zzao;

    private zzk() {
        this.zzam = new HashMap();
        this.zzan = new HashSet();
        this.zzao = new HashMap();
    }

    public static zzk zza() {
        synchronized(zzk.class) {
            if(zzk.zzal == null) {
                zzk.zzal = new zzk();
            }
            return zzk.zzal;
        }
    }

    private final void zza(String s, ListenerKey listenerHolder$ListenerKey0) {
        Set set0 = (Set)this.zzam.get(s);
        if(set0 == null) {
            set0 = new HashSet();
            this.zzam.put(s, set0);
        }
        set0.add(listenerHolder$ListenerKey0);
    }

    public final ListenerHolder zza(GoogleApi googleApi0, Object object0, String s) {
        synchronized(this) {
            ListenerHolder listenerHolder0 = googleApi0.registerListener(object0, s);
            this.zza(s, listenerHolder0.getListenerKey());
            return listenerHolder0;
        }
    }

    public final ListenerHolder zza(GoogleApi googleApi0, String s, String s1) {
        synchronized(this) {
            if(this.zzao.containsKey(s) && ((ListenerHolder)this.zzao.get(s)).hasListener()) {
                return (ListenerHolder)this.zzao.get(s);
            }
            ListenerHolder listenerHolder1 = googleApi0.registerListener(s, s1);
            this.zza(s1, listenerHolder1.getListenerKey());
            this.zzao.put(s, listenerHolder1);
            return listenerHolder1;
        }
    }

    public final Task zza(GoogleApi googleApi0, ListenerKey listenerHolder$ListenerKey0) {
        synchronized(this) {
            this.zzan.remove(listenerHolder$ListenerKey0);
            return googleApi0.doUnregisterEventListener(listenerHolder$ListenerKey0);
        }
    }

    public final Task zza(GoogleApi googleApi0, RegisterListenerMethod registerListenerMethod0, UnregisterListenerMethod unregisterListenerMethod0) {
        synchronized(this) {
            ListenerKey listenerHolder$ListenerKey0 = registerListenerMethod0.getListenerKey();
            this.zzan.add(listenerHolder$ListenerKey0);
            return googleApi0.doRegisterEventListener(registerListenerMethod0, unregisterListenerMethod0).addOnFailureListener(new zzl(this, registerListenerMethod0));
        }
    }

    public final void zza(GoogleApi googleApi0, String s) {
        synchronized(this) {
            Set set0 = (Set)this.zzam.get(s);
            if(set0 == null) {
                return;
            }
            for(Object object0: set0) {
                ListenerKey listenerHolder$ListenerKey0 = (ListenerKey)object0;
                if(this.zzan.contains(listenerHolder$ListenerKey0)) {
                    this.zza(googleApi0, listenerHolder$ListenerKey0);
                }
            }
            this.zzam.remove(s);
        }
    }

    public final ListenerKey zzb(GoogleApi googleApi0, Object object0, String s) {
        synchronized(this) {
            return object0 instanceof String ? this.zza(googleApi0, ((String)object0), s).getListenerKey() : ListenerHolders.createListenerKey(object0, s);
        }
    }
}

