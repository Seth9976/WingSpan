package com.unity3d.plugin.downloader.c;

import android.content.Context;
import android.database.sqlite.SQLiteStatement;
import android.os.Build.VERSION;
import android.os.Build;
import android.os.PowerManager.WakeLock;
import android.os.PowerManager;
import android.os.Process;
import android.util.Log;
import com.unity3d.plugin.downloader.b.m;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SyncFailedException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;

public final class e {
    private Context a;
    private c b;
    private j c;
    private final o d;
    private final d e;
    private String f;

    public e(c c0, j j0, d d0) {
        this.a = j0;
        this.b = c0;
        this.c = j0;
        this.e = d0;
        this.d = o.a(j0);
        this.f = "APKXDL (Linux; U; Android " + Build.VERSION.RELEASE + ";" + Locale.getDefault().toString() + "; " + Build.DEVICE + "/" + Build.ID + ")" + "com.MonsterCouch.Wingspan";
    }

    private InputStream a(h h0, HttpURLConnection httpURLConnection0) {
        try {
            return httpURLConnection0.getInputStream();
        }
        catch(IOException iOException0) {
            this.d();
            throw new i(this, this.b(h0), "while getting entity: " + iOException0.toString(), iOException0);
        }
    }

    private void a(int v, boolean z, int v1, int v2, boolean z1) {
        this.b.h = v;
        this.b.k = v1;
        this.b.l = v2;
        this.b.g = System.currentTimeMillis();
        if(z) {
            c c0 = this.b;
            if(z1) {
                c0.j = 1;
            }
            else {
                ++c0.j;
            }
        }
        else {
            this.b.j = 0;
        }
        this.d.a(this.b);
    }

    private static void a(h h0) {
        try {
            if(h0.b != null) {
                h0.b.close();
                h0.b = null;
            }
        }
        catch(IOException unused_ex) {
        }
    }

    private static void a(h h0, int v) {
        e.a(h0);
        if(h0.a != null && j.b(v)) {
            new File(h0.a).delete();
            h0.a = null;
        }
    }

    private void a(h h0, f f0, byte[] arr_b, InputStream inputStream0) {
        long v1;
        while(true) {
            int v = this.b(h0, f0, arr_b, inputStream0);
            if(v == -1) {
                this.b.f = (long)f0.a;
                this.d.a(this.b);
                if(f0.e != null && f0.a != Integer.parseInt(f0.e)) {
                    throw e.a(f0) ? new i(this, 489, "mismatched content length") : new i(this, this.b(h0), "closed socket before end of file");
                }
                return;
            }
            try {
                h0.f = true;
                if(h0.b == null) {
                    h0.b = new FileOutputStream(h0.a, true);
                }
                h0.b.write(arr_b, 0, v);
                e.a(h0);
                f0.a += v;
                f0.b += v;
                v1 = System.currentTimeMillis();
            }
            catch(IOException iOException0) {
                if(!m.a()) {
                    throw new i(this, 0x1F3, "external media not mounted while writing destination file");
                }
                throw m.a(m.a(h0.a)) >= ((long)v) ? new i(this, 492, "while writing destination file: " + iOException0.toString(), iOException0) : new i(this, 0x1F2, "insufficient space while writing destination file", iOException0);
            }
            if(f0.a - f0.h > 0x1000 && v1 - f0.i > 1000L) {
                this.b.f = (long)f0.a;
                o o0 = this.d;
                c c0 = this.b;
                if(o0.d == null) {
                    o0.d = o0.b.getReadableDatabase().compileStatement("UPDATE DownloadColumns SET CURRENTBYTES = ? WHERE FILEIDX = ?");
                }
                SQLiteStatement sQLiteStatement0 = o0.d;
                sQLiteStatement0.clearBindings();
                sQLiteStatement0.bindLong(1, c0.f);
                sQLiteStatement0.bindLong(2, ((long)c0.b));
                sQLiteStatement0.execute();
                f0.h = f0.a;
                f0.i = v1;
                this.c.a(((long)f0.b) + this.c.mBytesSoFar);
            }
            this.c();
        }
    }

    private static boolean a(f f0) {
        return f0.a > 0 && f0.c == null;
    }

    public final void a() {
        int v5;
        RuntimeException runtimeException6;
        IOException iOException6;
        RuntimeException runtimeException2;
        IOException iOException2;
        Throwable throwable3;
        FileOutputStream fileOutputStream1;
        FileOutputStream fileOutputStream0;
        int v2;
        File file0;
        f f0;
        PowerManager.WakeLock powerManager$WakeLock2;
        HttpURLConnection httpURLConnection0;
        boolean z;
        PowerManager.WakeLock powerManager$WakeLock1;
        PowerManager.WakeLock powerManager$WakeLock0;
        Process.setThreadPriority(10);
        h h0 = new h(this.b, this.c);
        try {
            powerManager$WakeLock0 = ((PowerManager)this.a.getSystemService("power")).newWakeLock(1, "LVLDL");
        }
        catch(i i0) {
            powerManager$WakeLock1 = null;
            goto label_278;
        }
        catch(Throwable throwable0) {
            powerManager$WakeLock1 = null;
            goto label_287;
        }
        try {
            powerManager$WakeLock0.acquire();
            z = false;
            while(true) {
            label_12:
                if(z) {
                    goto label_168;
                }
                httpURLConnection0 = (HttpURLConnection)new URL(h0.g).openConnection();
                httpURLConnection0.setRequestProperty("User-Agent", this.f);
                break;
            }
        }
        catch(i i0) {
            powerManager$WakeLock2 = powerManager$WakeLock0;
            goto label_277;
        }
        catch(Throwable throwable0) {
            powerManager$WakeLock2 = powerManager$WakeLock0;
            goto label_286;
        }
        try {
            f0 = new f(0);
            goto label_26;
        }
        catch(g unused_ex) {
            try {
                powerManager$WakeLock2 = powerManager$WakeLock0;
                goto label_162;
            }
            catch(i i0) {
                goto label_277;
            }
            catch(Throwable throwable0) {
                goto label_286;
            }
            try {
            label_26:
                this.c();
                goto label_30;
            }
            catch(g unused_ex) {
            }
            catch(Throwable throwable1) {
                powerManager$WakeLock2 = powerManager$WakeLock0;
                goto label_166;
            }
            try {
                powerManager$WakeLock2 = powerManager$WakeLock0;
                goto label_162;
            }
            catch(i i0) {
                goto label_277;
            }
            catch(Throwable throwable0) {
                goto label_286;
            }
        label_30:
            if(h0.a != null) {
                try {
                    if(!m.b(h0.a)) {
                        powerManager$WakeLock2 = powerManager$WakeLock0;
                        throw new i(this, 492, "found invalid internal destination filename");
                    }
                    file0 = new File(h0.a);
                    if(file0.exists()) {
                        goto label_40;
                    }
                    goto label_61;
                }
                catch(g unused_ex) {
                }
                catch(Throwable throwable1) {
                    powerManager$WakeLock2 = powerManager$WakeLock0;
                    goto label_166;
                }
                try {
                    powerManager$WakeLock2 = powerManager$WakeLock0;
                    goto label_162;
                }
                catch(g unused_ex) {
                    goto label_162;
                }
                catch(Throwable throwable1) {
                    goto label_166;
                }
            }
            goto label_61;
        }
        catch(Throwable throwable1) {
            try {
                powerManager$WakeLock2 = powerManager$WakeLock0;
                goto label_166;
            }
            catch(i i0) {
                goto label_277;
            }
            catch(Throwable throwable0) {
                goto label_286;
            }
        }
        try {
        label_40:
            powerManager$WakeLock2 = powerManager$WakeLock0;
            long v = file0.length();
            if(v == 0L) {
                file0.delete();
                h0.a = null;
            }
            else {
                if(this.b.d == null) {
                    file0.delete();
                    throw new i(this, 489, "Trying to resume a download that can\'t be resumed");
                }
                try {
                    h0.b = new FileOutputStream(h0.a, true);
                }
                catch(FileNotFoundException fileNotFoundException0) {
                    throw new i(this, 492, "while opening destination for resuming: " + fileNotFoundException0.toString(), fileNotFoundException0);
                }
                f0.a = (int)v;
                if(this.b.e != -1L) {
                    f0.e = Long.toString(this.b.e);
                }
                f0.c = this.b.d;
                f0.d = true;
            }
            goto label_62;
        label_61:
            powerManager$WakeLock2 = powerManager$WakeLock0;
        label_62:
            if(h0.b != null) {
                e.a(h0);
            }
            if(f0.d) {
                if(f0.c != null) {
                    httpURLConnection0.setRequestProperty("If-Match", f0.c);
                }
                httpURLConnection0.setRequestProperty("Range", "bytes=" + f0.a + "-");
            }
            this.b();
            this.e.a(3);
            int v1 = this.b(h0, httpURLConnection0);
            if(v1 != 503 || this.b.j >= 5) {
                if(v1 != (f0.d ? 206 : 200)) {
                    if(j.b(v1)) {
                        v2 = v1;
                    }
                    else if(v1 >= 300 && v1 < 400) {
                        v2 = 493;
                    }
                    else if(!f0.d || v1 != 200) {
                        v2 = 494;
                    }
                    else {
                        v2 = 489;
                    }
                    throw new i(this, v2, "http error " + v1);
                }
                h0.e = 0;
                if(!f0.d) {
                    String s = httpURLConnection0.getHeaderField("Content-Disposition");
                    if(s != null) {
                        f0.f = s;
                    }
                    String s1 = httpURLConnection0.getHeaderField("Content-Location");
                    if(s1 != null) {
                        f0.g = s1;
                    }
                    String s2 = httpURLConnection0.getHeaderField("ETag");
                    if(s2 != null) {
                        f0.c = s2;
                    }
                    String s3 = httpURLConnection0.getHeaderField("Transfer-Encoding");
                    if(s3 == null) {
                        s3 = null;
                    }
                    String s4 = httpURLConnection0.getHeaderField("Content-Type");
                    if(s4 != null && !s4.equals("application/vnd.android.obb")) {
                        throw new i(this, 487, "file delivered with incorrect Mime type");
                    }
                    if(s3 == null) {
                        int v3 = httpURLConnection0.getContentLength();
                        if(s4 != null) {
                            if(((long)v3) == -1L || ((long)v3) == this.b.e) {
                                f0.e = Long.toString(v3);
                            }
                            else {
                                Log.e("LVLDL", "Incorrect file size delivered.");
                            }
                        }
                    }
                    boolean z1 = f0.e != null || s3 != null && s3.equalsIgnoreCase("chunked") ? false : true;
                    if(z1) {
                        throw new i(this, 0x1EF, "can\'t know size of download, giving up");
                    }
                    try {
                        long v4 = this.b.e;
                        String s5 = this.c.a(this.b.c);
                        File file1 = new File(s5);
                        if(!m.a()) {
                            Log.d("LVLDL", "External media not mounted: " + s5);
                            throw new k(0x1F3, "external media is not yet mounted");
                        }
                        if(file1.exists()) {
                            Log.d("LVLDL", "File already exists: " + s5);
                            throw new k(488, "requested destination file already exists");
                        }
                        if(m.a(m.a(s5)) < v4) {
                            throw new k(0x1F2, "insufficient space on external storage");
                        }
                        h0.a = s5;
                    }
                    catch(k k0) {
                        throw new i(this, k0.a, k0.b);
                    }
                    try {
                        h0.b = new FileOutputStream(h0.a);
                    }
                    catch(FileNotFoundException fileNotFoundException1) {
                        File file2 = new File(m.a(this.c));
                        try {
                            if(file2.mkdirs()) {
                                h0.b = new FileOutputStream(h0.a);
                            }
                        }
                        catch(Exception unused_ex) {
                            throw new i(this, 492, "while opening destination file: " + fileNotFoundException1.toString(), fileNotFoundException1);
                        }
                    }
                    this.b.d = f0.c;
                    this.d.a(this.b);
                    this.b();
                }
                InputStream inputStream0 = this.a(h0, httpURLConnection0);
                this.e.a(4);
                this.a(h0, f0, new byte[0x1000], inputStream0);
                goto label_143;
            }
            goto label_147;
        }
        catch(g unused_ex) {
            goto label_162;
        }
        catch(Throwable throwable1) {
            goto label_166;
        }
        try {
        label_143:
            httpURLConnection0.disconnect();
            powerManager$WakeLock0 = powerManager$WakeLock2;
            z = true;
            goto label_12;
        }
        catch(i i0) {
            goto label_277;
        }
        catch(Throwable throwable0) {
            goto label_286;
        }
        try {
        label_147:
            h0.c = true;
            String s6 = httpURLConnection0.getHeaderField("Retry-After");
            if(s6 != null) {
                try {
                    h0.d = Integer.parseInt(s6);
                    if(h0.d >= 0) {
                        if(h0.d < 30) {
                            h0.d = 30;
                        }
                        else if(h0.d > 86400) {
                            h0.d = 86400;
                        }
                        m.a.nextInt(0x1F);
                        h0.d *= 1000;
                    }
                    else {
                        h0.d = 0;
                    }
                }
                catch(NumberFormatException unused_ex) {
                }
            }
            throw new i(this, 0xC2, "got 503 Service Unavailable, will retry later");
        }
        catch(g unused_ex) {
        }
        catch(Throwable throwable1) {
            goto label_166;
        }
        try {
        label_162:
            httpURLConnection0.disconnect();
            powerManager$WakeLock0 = powerManager$WakeLock2;
            goto label_12;
        label_166:
            httpURLConnection0.disconnect();
            throw throwable1;
        }
        catch(i i0) {
            goto label_277;
        }
        catch(Throwable throwable0) {
            goto label_286;
        }
        try {
        label_168:
            powerManager$WakeLock2 = powerManager$WakeLock0;
            fileOutputStream0 = new FileOutputStream(h0.a, true);
        }
        catch(FileNotFoundException fileNotFoundException2) {
            fileOutputStream1 = null;
            goto label_191;
        }
        catch(SyncFailedException syncFailedException0) {
            fileOutputStream1 = null;
            goto label_203;
        }
        catch(IOException iOException0) {
            fileOutputStream1 = null;
            goto label_215;
        }
        catch(RuntimeException runtimeException0) {
            fileOutputStream1 = null;
            goto label_232;
        }
        catch(Throwable throwable2) {
            throwable3 = throwable2;
            fileOutputStream1 = null;
            goto label_249;
        }
        try {
            fileOutputStream0.getFD().sync();
            goto label_258;
        }
        catch(FileNotFoundException fileNotFoundException2) {
            fileOutputStream1 = fileOutputStream0;
            try {
            label_191:
                Log.w("LVLDL", "file " + h0.a + " not found: " + fileNotFoundException2);
                if(fileOutputStream1 != null) {
                    goto label_193;
                }
                goto label_267;
            }
            catch(Throwable throwable4) {
                goto label_248;
            }
            try {
            label_193:
                fileOutputStream1.close();
                goto label_267;
            }
            catch(IOException iOException1) {
            }
            catch(RuntimeException runtimeException1) {
                runtimeException2 = runtimeException1;
                goto label_228;
            }
            catch(i i0) {
                goto label_277;
            }
            catch(Throwable throwable0) {
                goto label_286;
            }
            iOException2 = iOException1;
            goto label_224;
        }
        catch(SyncFailedException syncFailedException0) {
            fileOutputStream1 = fileOutputStream0;
            try {
            label_203:
                Log.w("LVLDL", "file " + h0.a + " sync failed: " + syncFailedException0);
                if(fileOutputStream1 != null) {
                    goto label_205;
                }
                goto label_267;
            }
            catch(Throwable throwable4) {
                goto label_248;
            }
            try {
            label_205:
                fileOutputStream1.close();
                goto label_267;
            }
            catch(IOException iOException3) {
            }
            catch(RuntimeException runtimeException3) {
                runtimeException2 = runtimeException3;
                goto label_228;
            }
            catch(i i0) {
                goto label_277;
            }
            catch(Throwable throwable0) {
                goto label_286;
            }
            iOException2 = iOException3;
            goto label_224;
        }
        catch(IOException iOException0) {
            fileOutputStream1 = fileOutputStream0;
            try {
            label_215:
                Log.w("LVLDL", "IOException trying to sync " + h0.a + ": " + iOException0);
            }
            catch(Throwable throwable4) {
                goto label_248;
            }
            if(fileOutputStream1 != null) {
                try {
                    try {
                        fileOutputStream1.close();
                        goto label_267;
                    }
                    catch(IOException iOException4) {
                        iOException2 = iOException4;
                    label_224:
                        Log.w("LVLDL", "IOException while closing synced file: ", iOException2);
                        goto label_267;
                    }
                    catch(RuntimeException runtimeException4) {
                        runtimeException2 = runtimeException4;
                    }
                label_228:
                    Log.w("LVLDL", "exception while closing file: ", runtimeException2);
                }
                catch(i i0) {
                    goto label_277;
                }
                catch(Throwable throwable0) {
                    goto label_286;
                }
            }
            goto label_267;
        }
        catch(RuntimeException runtimeException0) {
            fileOutputStream1 = fileOutputStream0;
            try {
            label_232:
                Log.w("LVLDL", "exception while syncing file: ", runtimeException0);
            }
            catch(Throwable throwable5) {
                throwable3 = throwable5;
                goto label_249;
            }
            if(fileOutputStream1 != null) {
                try {
                    fileOutputStream1.close();
                    goto label_267;
                }
                catch(IOException iOException5) {
                }
                catch(RuntimeException runtimeException5) {
                    runtimeException6 = runtimeException5;
                    goto label_266;
                }
                catch(i i0) {
                    goto label_277;
                }
                catch(Throwable throwable0) {
                    goto label_286;
                }
                iOException6 = iOException5;
                goto label_262;
            }
            goto label_267;
        }
        catch(Throwable throwable4) {
            fileOutputStream1 = fileOutputStream0;
        }
    label_248:
        throwable3 = throwable4;
    label_249:
        if(fileOutputStream1 != null) {
            try {
                try {
                    fileOutputStream1.close();
                }
                catch(IOException iOException7) {
                    Log.w("LVLDL", "IOException while closing synced file: ", iOException7);
                }
                catch(RuntimeException runtimeException7) {
                    Log.w("LVLDL", "exception while closing file: ", runtimeException7);
                }
                throw throwable3;
                try {
                label_258:
                    fileOutputStream0.close();
                    goto label_267;
                }
                catch(IOException iOException8) {
                    iOException6 = iOException8;
                label_262:
                    Log.w("LVLDL", "IOException while closing synced file: ", iOException6);
                    goto label_267;
                }
                catch(RuntimeException runtimeException8) {
                    runtimeException6 = runtimeException8;
                }
            label_266:
                Log.w("LVLDL", "exception while closing file: ", runtimeException6);
            label_267:
                String s7 = h0.a;
                String s8 = m.a(this.c, this.b.c);
                if(!h0.a.equals(s8)) {
                    File file3 = new File(s7);
                    File file4 = new File(s8);
                    if(this.b.e == -1L || this.b.f != this.b.e) {
                        throw new i(this, 487, "file delivered with incorrect size. probably due to network not browser configured");
                    }
                    if(!file3.renameTo(file4)) {
                        throw new i(this, 492, "unable to finalize destination file");
                    }
                }
                goto label_300;
            }
            catch(i i0) {
                goto label_277;
            }
            catch(Throwable throwable0) {
                goto label_286;
            }
        }
        throw throwable3;
    label_277:
        powerManager$WakeLock1 = powerManager$WakeLock2;
        try {
        label_278:
            Log.w("LVLDL", "Aborting request for download " + this.b.c + ": " + i0.getMessage());
            i0.printStackTrace();
            v5 = i0.a;
            if(powerManager$WakeLock1 != null) {
                goto label_282;
            }
            goto label_283;
        }
        catch(Throwable throwable6) {
            goto label_290;
        }
    label_282:
        powerManager$WakeLock1.release();
    label_283:
        e.a(h0, v5);
        this.a(v5, h0.c, h0.d, h0.e, h0.f);
        return;
    label_286:
        powerManager$WakeLock1 = powerManager$WakeLock2;
        try {
        label_287:
            Log.w("LVLDL", "Exception for " + this.b.c + ": " + throwable0);
        }
        catch(Throwable throwable6) {
        label_290:
            if(powerManager$WakeLock1 != null) {
                powerManager$WakeLock1.release();
            }
            e.a(h0, 491);
            this.a(491, h0.c, h0.d, h0.e, h0.f);
            throw throwable6;
        }
        if(powerManager$WakeLock1 != null) {
            powerManager$WakeLock1.release();
        }
        e.a(h0, 491);
        v5 = 491;
        this.a(v5, h0.c, h0.d, h0.e, h0.f);
        return;
    label_300:
        if(powerManager$WakeLock2 != null) {
            powerManager$WakeLock2.release();
        }
        e.a(h0, 200);
        v5 = 200;
        this.a(v5, h0.c, h0.d, h0.e, h0.f);
    }

    private int b(h h0) {
        if(this.c.a(this.d) != 1) {
            return 0xC3;
        }
        if(this.b.j < 5) {
            h0.c = true;
            return 0xC2;
        }
        Log.w("LVLDL", "reached max retries for " + this.b.j);
        return 0x1EF;
    }

    private int b(h h0, f f0, byte[] arr_b, InputStream inputStream0) {
        try {
            return inputStream0.read(arr_b);
        }
        catch(IOException iOException0) {
            this.d();
            this.b.f = (long)f0.a;
            this.d.a(this.b);
            throw e.a(f0) ? new i(this, 489, "while reading response: " + iOException0.toString() + ", can\'t resume interrupted download with no ETag", iOException0) : new i(this, this.b(h0), "while reading response: " + iOException0.toString(), iOException0);
        }
    }

    private int b(h h0, HttpURLConnection httpURLConnection0) {
        try {
            return httpURLConnection0.getResponseCode();
        }
        catch(IllegalArgumentException illegalArgumentException0) {
            throw new i(this, 0x1EF, "while trying to execute request: " + illegalArgumentException0.toString(), illegalArgumentException0);
        }
        catch(IOException iOException0) {
            this.d();
            throw new i(this, this.b(h0), "while trying to execute request: " + iOException0.toString(), iOException0);
        }
    }

    private void b() {
        switch(this.c.a(this.d)) {
            case 2: {
                throw new i(this, 0xC3, "waiting for network to return");
            }
            case 3: {
                throw new i(this, 0xC5, "waiting for wifi");
            }
            case 5: {
                throw new i(this, 0xC3, "roaming is not allowed");
            }
            case 6: {
                throw new i(this, 0xC4, "waiting for wifi or for download over cellular to be authorized");
            }
        }
    }

    private void c() {
        if(this.c.j() == 1 && this.c.k() == 0xC1) {
            throw new i(this, this.c.k(), "download paused");
        }
    }

    private void d() {
        Log.i("LVLDL", "Net " + (this.c.a(this.d) == 1 ? "Up" : "Down"));
    }
}

