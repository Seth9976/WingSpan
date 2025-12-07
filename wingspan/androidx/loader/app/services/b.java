package androidx.loader.app.services;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import np.dcc.Dex2C;
import np.dcc.protect.EntryPoint;

public class b {
    public interface a {
        static {
        }

        @Dex2C
        void a(Throwable arg1);

        @Dex2C
        void b(InputStream arg1);
    }

    public HttpURLConnection a;
    public final a b;
    private static final short[] short;

    static {
        EntryPoint.stub(21);
        b.short = new short[]{0xC10, 3090, 0xC03, 0xB09, 0xB35, 0xB37, 0xB3F, 0xB2E, 0xB32, 0xB33, 0xB34, 0xB3D, 0xB7A, 0xB2D, 0xB3F, 0xB34, 0xB2E, 0xB7A, 0xB2D, 0xB28, 0xB35, 0xB34, 0xB3D};
    }

    public b(String s, a b$a0) {
        this.a = null;
        this.b = b$a0;
        try {
            HttpURLConnection httpURLConnection0 = (HttpURLConnection)۠۟ۤ۟.ۣ۟ۢۥۢ(new URL(s));
            this.a = httpURLConnection0;
            ۥۥۢۡ.۟۟۠۠ۧ(httpURLConnection0, ۠۟ۤ۟.۟ۦۧۢۡ(b.۟۠ۦۦۢ(), 0, 3, 0xC57));
        }
        catch(Throwable throwable0) {
            ۣ۟ۢۧۤ.۟ۥ۟ۥ۟(b$a0, throwable0);
        }
    }

    public final native boolean a() {
    }

    public native void b() {
    }

    public static native short[] ۟۠ۦۦۢ() {
    }
}

