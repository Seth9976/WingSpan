package com.unity3d.plugin.downloader.c;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.IBinder;
import android.os.Messenger;
import android.os.SystemClock;
import android.util.Log;
import com.unity3d.plugin.downloader.b.b;
import com.unity3d.plugin.downloader.b.i;
import com.unity3d.plugin.downloader.b.m;
import com.unity3d.plugin.downloader.b.o;
import com.unity3d.plugin.downloader.b.p;
import java.io.File;

public abstract class j extends a implements o {
    public static final String ACTION_DOWNLOADS_CHANGED = "downloadsChanged";
    public static final String ACTION_DOWNLOAD_COMPLETE = "lvldownloader.intent.action.DOWNLOAD_COMPLETE";
    public static final String ACTION_DOWNLOAD_STATUS = "lvldownloader.intent.action.DOWNLOAD_STATUS";
    public static final int CONTROL_PAUSED = 1;
    public static final int CONTROL_RUN = 0;
    public static final int DOWNLOAD_REQUIRED = 2;
    public static final String EXTRA_FILE_NAME = "downloadId";
    public static final String EXTRA_IS_WIFI_REQUIRED = "isWifiRequired";
    public static final String EXTRA_MESSAGE_HANDLER = "EMH";
    public static final String EXTRA_PACKAGE_NAME = "EPN";
    public static final String EXTRA_PENDING_INTENT = "EPI";
    public static final String EXTRA_STATUS_CURRENT_FILE_SIZE = "CFS";
    public static final String EXTRA_STATUS_CURRENT_PROGRESS = "CFP";
    public static final String EXTRA_STATUS_STATE = "ESS";
    public static final String EXTRA_STATUS_TOTAL_PROGRESS = "TFP";
    public static final String EXTRA_STATUS_TOTAL_SIZE = "ETS";
    private static final String LOG_TAG = "LVLDL";
    public static final int LVL_CHECK_REQUIRED = 1;
    public static final int NETWORK_CANNOT_USE_ROAMING = 5;
    public static final int NETWORK_MOBILE = 1;
    public static final int NETWORK_NO_CONNECTION = 2;
    public static final int NETWORK_OK = 1;
    public static final int NETWORK_RECOMMENDED_UNUSABLE_DUE_TO_SIZE = 4;
    public static final int NETWORK_TYPE_DISALLOWED_BY_REQUESTOR = 6;
    public static final int NETWORK_UNUSABLE_DUE_TO_SIZE = 3;
    public static final int NETWORK_WIFI = 2;
    public static final int NO_DOWNLOAD_REQUIRED = 0;
    private static final float SMOOTHING_FACTOR = 0.005f;
    public static final int STATUS_CANCELED = 490;
    public static final int STATUS_CANNOT_RESUME = 489;
    public static final int STATUS_DEVICE_NOT_FOUND_ERROR = 0x1F3;
    public static final int STATUS_FILE_ALREADY_EXISTS_ERROR = 488;
    public static final int STATUS_FILE_DELIVERED_INCORRECTLY = 487;
    public static final int STATUS_FILE_ERROR = 492;
    public static final int STATUS_FORBIDDEN = 403;
    public static final int STATUS_HTTP_DATA_ERROR = 0x1EF;
    public static final int STATUS_HTTP_EXCEPTION = 0x1F0;
    public static final int STATUS_INSUFFICIENT_SPACE_ERROR = 0x1F2;
    public static final int STATUS_PAUSED_BY_APP = 0xC1;
    public static final int STATUS_PENDING = 190;
    public static final int STATUS_QUEUED_FOR_WIFI = 0xC5;
    public static final int STATUS_QUEUED_FOR_WIFI_OR_CELLULAR_PERMISSION = 0xC4;
    public static final int STATUS_RUNNING = 0xC0;
    public static final int STATUS_SUCCESS = 200;
    public static final int STATUS_TOO_MANY_REDIRECTS = 0x1F1;
    public static final int STATUS_UNHANDLED_HTTP_CODE = 494;
    public static final int STATUS_UNHANDLED_REDIRECT = 493;
    public static final int STATUS_UNKNOWN_ERROR = 491;
    public static final int STATUS_WAITING_FOR_NETWORK = 0xC3;
    public static final int STATUS_WAITING_TO_RETRY = 0xC2;
    private static final String TEMP_EXT = ".tmp";
    public static final int VISIBILITY_HIDDEN = 2;
    public static final int VISIBILITY_VISIBLE = 0;
    public static final int VISIBILITY_VISIBLE_NOTIFY_COMPLETED = 1;
    private PendingIntent mAlarmIntent;
    float mAverageDownloadSpeed;
    long mBytesAtSample;
    long mBytesSoFar;
    private Messenger mClientMessenger;
    private BroadcastReceiver mConnReceiver;
    private ConnectivityManager mConnectivityManager;
    private int mControl;
    int mFileCount;
    private boolean mIsAtLeast3G;
    private boolean mIsAtLeast4G;
    private boolean mIsCellularConnection;
    private boolean mIsConnected;
    private boolean mIsFailover;
    private boolean mIsRoaming;
    long mMillisecondsAtSample;
    private d mNotification;
    private PackageInfo mPackageInfo;
    private PendingIntent mPendingIntent;
    private final Messenger mServiceMessenger;
    private final p mServiceStub;
    private boolean mStateChanged;
    private int mStatus;
    long mTotalLength;
    private WifiManager mWifiManager;
    private static boolean sIsRunning;

    public j() {
        super("LVLDownloadService");
        p p0 = i.a(this);
        this.mServiceStub = p0;
        this.mServiceMessenger = p0.a();
    }

    public static int a(Context context0, PendingIntent pendingIntent0, Class class0) {
        String s = class0.getName();
        PackageInfo packageInfo0 = context0.getPackageManager().getPackageInfo("com.MonsterCouch.Wingspan", 0);
        com.unity3d.plugin.downloader.c.o o0 = com.unity3d.plugin.downloader.c.o.a(context0);
        int v1 = j.a(o0, packageInfo0);
        if(o0.g == 0) {
            c[] arr_c = o0.a();
            if(arr_c != null) {
                for(int v = 0; v < arr_c.length; ++v) {
                    c c0 = arr_c[v];
                    if(!m.a(context0, c0.c, c0.e)) {
                        if(o0.g != -1) {
                            ContentValues contentValues0 = new ContentValues();
                            contentValues0.put("DOWNLOADSTATUS", -1);
                            if(o0.a(contentValues0)) {
                                o0.g = -1;
                            }
                        }
                        v1 = 2;
                        break;
                    }
                }
            }
        }
        else {
            v1 = 2;
        }
        if(v1 == 1 || v1 == 2) {
            Intent intent0 = new Intent();
            intent0.setClassName("com.MonsterCouch.Wingspan", s);
            intent0.putExtra("EPI", pendingIntent0);
            context0.startService(intent0);
        }
        return v1;
    }

    public static int a(Context context0, Intent intent0, Class class0) {
        return j.a(context0, ((PendingIntent)intent0.getParcelableExtra("EPI")), class0);
    }

    private void a(int v, int v1) {
        switch(v) {
            case 0: {
                this.mIsCellularConnection = true;
                switch(v1) {
                    case 3: 
                    case 5: 
                    case 6: 
                    case 8: 
                    case 9: 
                    case 10: {
                        this.mIsAtLeast3G = true;
                        this.mIsAtLeast4G = false;
                        return;
                    }
                    case 1: 
                    case 2: 
                    case 4: 
                    case 7: 
                    case 11: {
                        this.mIsAtLeast3G = false;
                        this.mIsAtLeast4G = false;
                        return;
                    }
                    case 13: 
                    case 14: 
                    case 15: {
                        this.mIsAtLeast3G = true;
                        this.mIsAtLeast4G = true;
                        return;
                    }
                    default: {
                        this.mIsCellularConnection = false;
                        this.mIsAtLeast3G = false;
                        this.mIsAtLeast4G = false;
                        return;
                    }
                }
            }
            case 6: {
                this.mIsCellularConnection = true;
                this.mIsAtLeast3G = true;
                this.mIsAtLeast4G = true;
                return;
            }
            case 1: 
            case 7: 
            case 9: {
                this.mIsCellularConnection = false;
                this.mIsAtLeast3G = false;
                this.mIsAtLeast4G = false;
            }
        }
    }

    private void a(Context context0) {
        Context context1 = context0.getApplicationContext();
        new Handler(context1.getMainLooper()).post(new com.unity3d.plugin.downloader.c.m(this, context1, this.mPendingIntent));
    }

    private static boolean a(com.unity3d.plugin.downloader.c.o o0, PackageInfo packageInfo0) {
        return o0.f != packageInfo0.versionCode;
    }

    public final int a(com.unity3d.plugin.downloader.c.o o0) {
        if(this.mIsConnected) {
            if(!this.mIsCellularConnection) {
                return 1;
            }
            int v = o0.h;
            if(this.mIsRoaming) {
                return 5;
            }
            return (v & 1) == 0 ? 6 : 1;
        }
        return 2;
    }

    // 去混淆评级： 低(20)
    public final String a(String s) {
        return m.a(this) + "/" + s + ".tmp";
    }

    @Override  // com.unity3d.plugin.downloader.b.o
    public final void a() {
        this.mControl = 1;
        this.mStatus = 490;
    }

    @Override  // com.unity3d.plugin.downloader.b.o
    public final void a(int v) {
        com.unity3d.plugin.downloader.c.o o0 = com.unity3d.plugin.downloader.c.o.a(this);
        if(o0.h != v) {
            ContentValues contentValues0 = new ContentValues();
            contentValues0.put("DOWNLOADFLAGS", v);
            if(o0.a(contentValues0)) {
                o0.h = v;
            }
        }
    }

    public final void a(long v) {
        long v3;
        long v1 = SystemClock.uptimeMillis();
        long v2 = this.mMillisecondsAtSample;
        if(0L == v2) {
            v3 = -1L;
        }
        else {
            float f = ((float)(v - this.mBytesAtSample)) / ((float)(v1 - v2));
            float f1 = this.mAverageDownloadSpeed;
            if(0.0f != f1) {
                f = f * 0.005f + f1 * 0.995f;
            }
            this.mAverageDownloadSpeed = f;
            v3 = (long)(((float)(this.mTotalLength - v)) / this.mAverageDownloadSpeed);
        }
        this.mMillisecondsAtSample = v1;
        this.mBytesAtSample = v;
        this.mNotification.a(new b(this.mTotalLength, v, v3, this.mAverageDownloadSpeed));
    }

    @Override  // com.unity3d.plugin.downloader.c.a
    protected final void a(Intent intent0) {
        int v4;
        int v5;
        boolean z = true;
        j.b(true);
        try {
            com.unity3d.plugin.downloader.c.o o0 = com.unity3d.plugin.downloader.c.o.a(this);
            PendingIntent pendingIntent0 = (PendingIntent)intent0.getParcelableExtra("EPI");
            if(pendingIntent0 != null) {
                this.mNotification.a(pendingIntent0);
                this.mPendingIntent = pendingIntent0;
                goto label_12;
            }
            PendingIntent pendingIntent1 = this.mPendingIntent;
            if(pendingIntent1 != null) {
                this.mNotification.a(pendingIntent1);
            label_12:
                if(j.a(o0, this.mPackageInfo)) {
                    this.a(this);
                    return;
                }
                c[] arr_c = o0.a();
                this.mBytesSoFar = 0L;
                this.mTotalLength = 0L;
                this.mFileCount = arr_c.length;
                for(int v1 = 0; v1 < arr_c.length; ++v1) {
                    c c0 = arr_c[v1];
                    if(c0.h == 200 && !m.a(this, c0.c, c0.e)) {
                        c0.h = 0;
                        c0.f = 0L;
                    }
                    this.mTotalLength += c0.e;
                    this.mBytesSoFar += c0.f;
                }
                this.f();
                if(this.mConnReceiver == null) {
                    this.mConnReceiver = new l(this, this);
                    IntentFilter intentFilter0 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                    intentFilter0.addAction("android.net.wifi.WIFI_STATE_CHANGED");
                    this.registerReceiver(this.mConnReceiver, intentFilter0);
                }
                int v2 = 0;
                while(v2 < arr_c.length) {
                    c c1 = arr_c[v2];
                    long v3 = c1.f;
                    if(c1.h != 200) {
                        e e0 = new e(c1, this, this.mNotification);
                        this.n();
                        this.b(5000L);
                        e0.a();
                        this.n();
                    }
                    o0.b(c1);
                    switch(c1.h) {
                        case 0xC1: {
                            v4 = 7;
                            v5 = v4;
                            z = false;
                            goto label_78;
                        }
                        case 0xC2: 
                        case 0xC3: {
                            v5 = 6;
                            goto label_78;
                        }
                        case 0xC4: 
                        case 0xC5: {
                            if(this.mWifiManager != null && !this.mWifiManager.isWifiEnabled()) {
                                v5 = 8;
                                goto label_78;
                            }
                            v5 = 9;
                            goto label_78;
                        }
                        case 200: {
                            this.mBytesSoFar += c1.f - v3;
                            o0.a(this.mPackageInfo.versionCode, 0);
                            ++v2;
                            continue;
                        }
                        case 403: {
                            this.a(this);
                            return;
                        }
                        case 487: {
                            c1.f = 0L;
                            o0.a(c1);
                            v5 = 13;
                            goto label_78;
                        }
                        case 490: {
                            v5 = 18;
                            goto label_78;
                        }
                        case 0x1F2: {
                            v5 = 17;
                            goto label_78;
                        }
                        case 0x1F3: {
                            break;
                        }
                        default: {
                            v4 = 19;
                            v5 = v4;
                            z = false;
                            goto label_78;
                        }
                    }
                    v5 = 14;
                label_78:
                    if(z) {
                        this.b(60000L);
                    }
                    else {
                        this.n();
                    }
                    this.mNotification.a(v5);
                    return;
                }
                this.mNotification.a(5);
                return;
            }
            Log.e("LVLDL", "Downloader started in bad state without notification intent.");
        }
        finally {
            j.b(false);
        }
    }

    @Override  // com.unity3d.plugin.downloader.b.o
    public final void a(Messenger messenger0) {
        this.mClientMessenger = messenger0;
        this.mNotification.b(messenger0);
    }

    public final boolean a(com.unity3d.plugin.downloader.c.o o0, String s, long v) {
        c c0 = o0.a(s);
        if(c0 != null) {
            String s1 = c0.c;
            if(s1 != null) {
                if(s.equals(s1)) {
                    return false;
                }
                File file0 = new File(m.a(this, s1));
                if(file0.exists()) {
                    file0.delete();
                }
            }
        }
        return !m.a(this, s, v);
    }

    private void b(long v) {
        AlarmManager alarmManager0 = (AlarmManager)this.getSystemService("alarm");
        if(alarmManager0 == null) {
            Log.e("LVLDL", "couldn\'t get alarm manager");
            return;
        }
        String s = this.i();
        Intent intent0 = new Intent("android.intent.action.DOWNLOAD_WAKEUP");
        intent0.putExtra("EPI", this.mPendingIntent);
        intent0.setClassName("com.MonsterCouch.Wingspan", s);
        this.mAlarmIntent = PendingIntent.getBroadcast(this, 0, intent0, 0x40000000);
        alarmManager0.set(0, System.currentTimeMillis() + v, this.mAlarmIntent);
    }

    private static void b(boolean z) {
        synchronized(j.class) {
            j.sIsRunning = z;
        }
    }

    public static boolean b(int v) {
        return v >= 400 && v < 600;
    }

    @Override  // com.unity3d.plugin.downloader.b.o
    public final void b() {
        this.mControl = 1;
        this.mStatus = 0xC1;
    }

    @Override  // com.unity3d.plugin.downloader.b.o
    public final void c() {
        if(this.mControl == 1) {
            this.mControl = 0;
        }
        Intent intent0 = new Intent(this, this.getClass());
        intent0.putExtra("EPI", this.mPendingIntent);
        this.startService(intent0);
    }

    @Override  // com.unity3d.plugin.downloader.b.o
    public final void d() {
        this.mNotification.a();
    }

    @Override  // com.unity3d.plugin.downloader.c.a
    protected final boolean e() {
        return com.unity3d.plugin.downloader.c.o.a(this).g == 0;
    }

    final void f() {
        if(this.mConnectivityManager == null) {
            this.mConnectivityManager = (ConnectivityManager)this.getSystemService("connectivity");
        }
        if(this.mWifiManager == null) {
            this.mWifiManager = (WifiManager)this.getSystemService("wifi");
        }
        ConnectivityManager connectivityManager0 = this.mConnectivityManager;
        if(connectivityManager0 == null) {
            Log.w("LVLDL", "couldn\'t get connectivity manager to poll network state");
            return;
        }
        NetworkInfo networkInfo0 = connectivityManager0.getActiveNetworkInfo();
        boolean z = this.mIsConnected;
        boolean z1 = this.mIsFailover;
        boolean z2 = this.mIsCellularConnection;
        boolean z3 = this.mIsRoaming;
        boolean z4 = this.mIsAtLeast3G;
        boolean z5 = false;
        if(networkInfo0 == null) {
            this.mIsRoaming = false;
            this.mIsFailover = false;
            this.mIsConnected = false;
            this.a(-1, -1);
        }
        else {
            this.mIsRoaming = networkInfo0.isRoaming();
            this.mIsFailover = networkInfo0.isFailover();
            this.mIsConnected = networkInfo0.isConnected();
            this.a(networkInfo0.getType(), networkInfo0.getSubtype());
        }
        if(this.mStateChanged || z != this.mIsConnected || z1 != this.mIsFailover || z2 != this.mIsCellularConnection || z3 != this.mIsRoaming || z4 != this.mIsAtLeast3G) {
            z5 = true;
        }
        this.mStateChanged = z5;
    }

    public abstract String g();

    public abstract byte[] h();

    public abstract String i();

    public final int j() {
        return this.mControl;
    }

    public final int k() {
        return this.mStatus;
    }

    private static boolean m() {
        synchronized(j.class) {
        }
        return j.sIsRunning;
    }

    private void n() {
        if(this.mAlarmIntent != null) {
            AlarmManager alarmManager0 = (AlarmManager)this.getSystemService("alarm");
            if(alarmManager0 == null) {
                Log.e("LVLDL", "couldn\'t get alarm manager");
                return;
            }
            alarmManager0.cancel(this.mAlarmIntent);
            this.mAlarmIntent = null;
        }
    }

    @Override  // com.unity3d.plugin.downloader.c.a
    public IBinder onBind(Intent intent0) {
        Log.d("LVLDL", "Service Bound");
        return this.mServiceMessenger.getBinder();
    }

    @Override  // com.unity3d.plugin.downloader.c.a
    public void onCreate() {
        super.onCreate();
        try {
            this.mPackageInfo = this.getPackageManager().getPackageInfo("com.MonsterCouch.Wingspan", 0);
            ApplicationInfo applicationInfo0 = this.getApplicationInfo();
            this.mNotification = new d(this, this.getPackageManager().getApplicationLabel(applicationInfo0));
        }
        catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
            packageManager$NameNotFoundException0.printStackTrace();
        }
    }

    @Override  // com.unity3d.plugin.downloader.c.a
    public void onDestroy() {
        BroadcastReceiver broadcastReceiver0 = this.mConnReceiver;
        if(broadcastReceiver0 != null) {
            this.unregisterReceiver(broadcastReceiver0);
            this.mConnReceiver = null;
        }
        this.mServiceStub.b(this);
        super.onDestroy();
    }
}

