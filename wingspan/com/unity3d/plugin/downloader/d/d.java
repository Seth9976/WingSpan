package com.unity3d.plugin.downloader.d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.unity3d.plugin.downloader.e.a;
import com.unity3d.plugin.downloader.e.b;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public final class d implements ServiceConnection {
    private static final SecureRandom a;
    private com.unity3d.plugin.downloader.a.d b;
    private PublicKey c;
    private final Context d;
    private final l e;
    private Handler f;
    private final String g;
    private final String h;
    private final Set i;
    private final Queue j;

    static {
        d.a = new SecureRandom();
    }

    public d(Context context0, l l0, String s) {
        this.i = new HashSet();
        this.j = new LinkedList();
        this.d = context0;
        this.e = l0;
        this.c = d.a(s);
        this.g = "com.MonsterCouch.Wingspan";
        this.h = d.a(context0, "com.MonsterCouch.Wingspan");
        HandlerThread handlerThread0 = new HandlerThread("background thread");
        handlerThread0.start();
        this.f = new Handler(handlerThread0.getLooper());
    }

    private static String a(Context context0, String s) {
        try {
            return String.valueOf(context0.getPackageManager().getPackageInfo(s, 0).versionCode);
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
            Log.e("LicenseChecker", "Package not found. could not get version code.");
            return "";
        }
    }

    private static PublicKey a(String s) {
        try {
            byte[] arr_b = a.a(s);
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(arr_b));
        }
        catch(NoSuchAlgorithmException noSuchAlgorithmException0) {
            throw new RuntimeException(noSuchAlgorithmException0);
        }
        catch(b b0) {
            Log.e("LicenseChecker", "Could not decode from Base64.");
            throw new IllegalArgumentException(b0);
        }
        catch(InvalidKeySpecException invalidKeySpecException0) {
            Log.e("LicenseChecker", "Invalid key specification.");
            throw new IllegalArgumentException(invalidKeySpecException0);
        }
    }

    private void a() {
        i i0;
        while((i0 = (i)this.j.poll()) != null) {
            try {
                Log.i("LicenseChecker", "Calling checkLicense on service for " + i0.c());
                this.b.a(((long)i0.b()), i0.c(), new e(this, i0));
                this.i.add(i0);
            }
            catch(RemoteException remoteException0) {
                Log.w("LicenseChecker", "RemoteException in checkLicense call.", remoteException0);
                this.b(i0);
            }
        }
    }

    private void a(i i0) {
        synchronized(this) {
            this.i.remove(i0);
            if(this.i.isEmpty() && this.b != null) {
                try {
                    this.d.unbindService(this);
                }
                catch(IllegalArgumentException unused_ex) {
                    Log.e("LicenseChecker", "Unable to unbind from licensing service (already unbound)");
                }
                this.b = null;
            }
        }
    }

    public final void a(h h0) {
        synchronized(this) {
            if(this.e.c()) {
                Log.i("LicenseChecker", "Using cached license response");
                h0.a();
                return;
            }
            j j0 = new j();
            int v1 = d.a.nextInt();
            i i0 = new i(this.e, j0, h0, v1, this.g, this.h);
            if(this.b == null) {
                Log.i("LicenseChecker", "Binding to licensing service.");
                try {
                    Intent intent0 = new Intent("com.android.vending.licensing.ILicensingService").setPackage("com.android.vending");
                    if(this.d.bindService(intent0, this, 1)) {
                        this.j.offer(i0);
                        return;
                    }
                    Log.e("LicenseChecker", "Could not bind to service.");
                    this.b(i0);
                }
                catch(SecurityException unused_ex) {
                    h0.b();
                }
                catch(b b0) {
                    b0.printStackTrace();
                }
                return;
            }
            this.j.offer(i0);
            this.a();
        }
    }

    private void b(i i0) {
        synchronized(this) {
            this.e.a(291, null);
            if(this.e.c()) {
                i0.a().a();
                return;
            }
            i0.a().a(291);
        }
    }

    @Override  // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName0, IBinder iBinder0) {
        synchronized(this) {
            this.b = com.unity3d.plugin.downloader.a.e.a(iBinder0);
            this.a();
        }
    }

    @Override  // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName0) {
        synchronized(this) {
            Log.w("LicenseChecker", "Service unexpectedly disconnected.");
            this.b = null;
        }
    }
}

