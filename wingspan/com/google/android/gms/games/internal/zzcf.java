package com.google.android.gms.games.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Display;
import android.view.View.OnAttachStateChangeListener;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.google.android.gms.internal.games.zzfq;
import com.google.android.gms.internal.games.zzft;
import java.lang.ref.WeakReference;

public final class zzcf implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {
    private final zzbz zza;
    private final zzfq zzb;
    private WeakReference zzc;
    private boolean zzd;

    private zzcf(zzbz zzbz0, int v) {
        this.zzd = false;
        this.zza = zzbz0;
        this.zzb = new zzfq(v, null);
    }

    @Override  // android.view.ViewTreeObserver$OnGlobalLayoutListener
    public final void onGlobalLayout() {
        WeakReference weakReference0 = this.zzc;
        if(weakReference0 == null) {
            return;
        }
        View view0 = (View)weakReference0.get();
        if(view0 == null) {
            return;
        }
        this.zzh(view0);
    }

    @Override  // android.view.View$OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view0) {
        this.zzh(view0);
    }

    @Override  // android.view.View$OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view0) {
        this.zza.zzN();
        view0.removeOnAttachStateChangeListener(this);
    }

    public final Bundle zza() {
        return this.zzb.zza();
    }

    public final IBinder zzb() {
        return this.zzb.zza;
    }

    public static zzcf zzc(zzbz zzbz0, int v) {
        return new zzcf(zzbz0, v);
    }

    public final zzfq zzd() {
        return this.zzb;
    }

    public final void zze(View view0) {
        this.zza.zzN();
        WeakReference weakReference0 = this.zzc;
        if(weakReference0 != null) {
            View view1 = (View)weakReference0.get();
            Context context0 = this.zza.getContext();
            if(view1 == null && context0 instanceof Activity) {
                view1 = ((Activity)context0).getWindow().getDecorView();
            }
            if(view1 != null) {
                view1.removeOnAttachStateChangeListener(this);
                view1.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        }
        this.zzc = null;
        Context context1 = this.zza.getContext();
        if(view0 == null && context1 instanceof Activity) {
            Activity activity0 = (Activity)context1;
            try {
                view0 = activity0.findViewById(0x1020002);
            }
            catch(IllegalStateException unused_ex) {
            }
            if(view0 == null) {
                view0 = activity0.getWindow().getDecorView();
            }
            zzft.zzd("PopupManager", "You have not specified a View to use as content view for popups. Falling back to the Activity content view. Note that this may not work as expected in multi-screen environments");
        }
        if(view0 != null) {
            this.zzh(view0);
            this.zzc = new WeakReference(view0);
            view0.addOnAttachStateChangeListener(this);
            view0.getViewTreeObserver().addOnGlobalLayoutListener(this);
            return;
        }
        zzft.zza("PopupManager", "No content view usable to display popups. Popups will not be displayed in response to this client\'s calls. Use setViewForPopups() to set your content view.");
    }

    public final void zzf(int v) {
        this.zzb.zzb = v;
    }

    public final void zzg() {
        boolean z;
        zzfq zzfq0 = this.zzb;
        IBinder iBinder0 = zzfq0.zza;
        if(iBinder0 == null) {
            z = true;
        }
        else {
            Bundle bundle0 = zzfq0.zza();
            this.zza.zzaU(iBinder0, bundle0);
            z = false;
        }
        this.zzd = z;
    }

    private final void zzh(View view0) {
        int v = -1;
        Display display0 = view0.getDisplay();
        if(display0 != null) {
            v = display0.getDisplayId();
        }
        IBinder iBinder0 = view0.getWindowToken();
        int[] arr_v = new int[2];
        view0.getLocationInWindow(arr_v);
        int v1 = view0.getWidth();
        int v2 = view0.getHeight();
        this.zzb.zzc = v;
        this.zzb.zza = iBinder0;
        this.zzb.zzd = arr_v[0];
        this.zzb.zze = arr_v[1];
        this.zzb.zzf = arr_v[0] + v1;
        this.zzb.zzg = arr_v[1] + v2;
        if(this.zzd) {
            this.zzg();
        }
    }
}

