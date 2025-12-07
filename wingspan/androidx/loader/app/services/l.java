package androidx.loader.app.services;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Outline;
import android.os.Handler;
import android.text.Spanned;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.LinearLayout.LayoutParams;
import java.io.InputStream;
import np.dcc.protect.EntryPoint;
import org.json.JSONObject;

public abstract class l {
    public static Handler a;
    public static boolean b;
    public static Object c;
    private static final short[] short;

    static {
        EntryPoint.stub(0x1F);
        l.short = new short[]{902, 913, 900, 936, 937, 929, 942, 0x3A0, 1001, 941, 948, 936, 937, 2078, 2050, 2050, 0x806, 0x805, 0x84C, 0x859, 0x859, 2071, 0x806, 2077, 0x800, 0x81F, 0x805, 0x81F, 2073, 2072, 0x858, 2073, 0x804, 2065, 0x859, 0x801, 0x859, 2071, 0x806, 0x81F, 2065, 2067, 2050, 0x858, 0x806, 2078, 0x806, 0x849, 0x806, 2071, 2069, 2077, 2071, 2065, 2067, 0x84B, 1370, 1309, 0x50C, 1301, 0x523, 1303, 1305, 0x505, 0x541, 0x549, 0x544, 1307, 0x529, 0x535, 0x52B, 0x52C, 0x512, 0x54D, 0x544, 0x53E, 0x52F, 0x50A, 0x506, 0x53D, 0x50A, 0x54C, 1300, 1320, 0x54F, 0x53E, 0x510, 1310, 1303, 0x53A, 0x536, 1310, 0x513, 1300, 0x511, 0x53A, 0x509, 0x53B, 0x52B, 0x545, 0x534, 0x525, 1300, 0x513, 0x549, 0x50C, 1305, 0x52C, 0x510, 0x50A, 0x525, 0x50B, 1300, 0xABC, 0xA9B, 0xA83, 2708, 0xA99, 0xA9C, 2705, 0xAD5, 2707, 0xA99, 2708, 2706, 0xAD5, 0x5FC, 0x5F3, 0x5F9, 0x5EF, 0x5F2, 0x5F4, 0x5F9, 0x5B3, 0x5F4, 0x5F3, 0x5E9, 0x5F8, 0x5F3, 0x5E9, 0x5B3, 0x5FC, 0x5FE, 0x5E9, 0x5F4, 0x5F2, 0x5F3, 0x5B3, 0x5CB, 0x5D4, 0x5D8, 0x5CA, 2050, 2067, 2065, 2073, 2067, 2069, 2071, 0x7F4, 0x7FF, 2023, 0x7FE, 0x7FC, 0x7FF, 0x7F1, 0x7F4, 0x7CF, 0x7FC, 0x7F9, 0x7FE, 0x7FB, 0x552, 0x541, 0x556, 0x557, 0x54D, 0x54B, 0x54A, 1403, 0x54A, 0x545, 0x549, 0x541, 0x944, 2409, 2401, 0x96C, 0x96F, 2407, 0x920, 0x977, 2409, 0x96C, 0x96C, 0x920, 2402, 2405, 0x920, 0x973, 2408, 0x96F, 0x977, 0x96E, 0x869, 0x85F, 0x845, 0x842, 0x810, 0x87D, 0x87F, 0x874, 0x810, 0x846, 0x855, 0x842, 0x843, 0x859, 0x85F, 0x85E, 0x810, 2060, 2130, 0x80E, 0xC47, 0xC54, 3097, 0xC45, 0xC5B, 3090, 3080, 0xC5B, 3092, 0xC0E, 0xC0F, 0xC1F, 3098, 0xC0F, 3102, 0xC1F, 0xC55, 0xC47, 3097, 0xC09, 0xC45, 0xC47, 3097, 0xC09, 0xC45, 0xC2B, 3095, 3102, 3098, 3080, 3102, 0xC5B, 0xC0E, 0xC0B, 0xC1F, 3098, 0xC0F, 3102, 0xC5B, 0xC0F, 3092, 0xC5B, 0xC0F, 3091, 3102, 0xC5B, 3095, 3098, 0xC0F, 3102, 3080, 0xC0F, 0xC5B, 0xC0D, 3102, 0xC09, 3080, 3090, 3092, 3093, 0xC5B, 0xC47, 3097, 0xC45, 0x96D, 2430, 0x933, 0x96F, 0x971, 0x925, 0x93E, 0x971, 0x932, 0x93E, 0x93F, 0x925, 2360, 0x93F, 2340, 0x934, 0x97F, 0xB26, 0xB03, 0xB17, 0xB12, 0xB07, 0xB16, 0xB52, 2502, 0x9E3, 0x9F7, 0x9F2, 0x9E7, 0x9F6, 0x6F5, 0x6D7, 0x6D8, 0x6D5, 0x6D3, 0x6DA, 0xB0D, 0xB3A, 0xB3A, 0xB27, 0xB3A, 663, 696, 699, 679, 689};
        l.a = new Handler(۠۟ۤ۟.ۨۧۦ۠());
        l.b = false;
    }

    public static void a(Context context0, String s, View view0) {
        ۣ۟ۢۧۤ.ۨ۠ۧ۟(context0, s, view0);
    }

    public static void b(AlertDialog alertDialog0, View view0) {
        ۣ۟ۡ۠ۥ.ۡۢۧ۟(alertDialog0, view0);
    }

    public static void c(String s, Context context0) {
        ۣ۟ۡ۠ۥ.ۤ۟ۤ۟(s, context0);
    }

    public static native int d(Resources arg0, int arg1) {
    }

    public static native String e(String arg0) {
    }

    public static native View f(Object arg0) {
        public class b extends ViewOutlineProvider {
            static {
                EntryPoint.stub(30);
            }

            public b() {
                super();
            }

            @Override  // android.view.ViewOutlineProvider
            public native void getOutline(View arg1, Outline arg2) {
            }
        }

    }

    public static native Spanned g(String arg0) {
    }

    public static native LinearLayout.LayoutParams h(int arg0) {
    }

    public static native LinearLayout.LayoutParams i(int arg0, float arg1) {
    }

    public static native void j(Object arg0) {
    }

    public static native void k(Object arg0, int arg1) {
        public class a implements androidx.loader.app.services.b.a {
            public final Context a;

            static {
                EntryPoint.stub(29);
            }

            public a(Context context0) {
            }

            @Override  // androidx.loader.app.services.b$a
            public native void a(Throwable arg1) {
            }

            @Override  // androidx.loader.app.services.b$a
            public native void b(InputStream arg1) {
            }

            public static void c(Context context0, JSONObject jSONObject0) {
                ۥۥۢۡ.۟ۡۧۡۤ(context0, jSONObject0);
            }

            public static void d(Context context0, Exception exception0) {
                ۣ۟ۡ۠ۥ.۟ۥۣۨ(context0, exception0);
            }

            public static void e(Context context0, Throwable throwable0) {
                ۣ۟ۡ۠ۥ.ۤ۟ۥۤ(context0, throwable0);
            }

            public static void f(Context context0, Throwable throwable0) {
                ۣ۟ۢۧۤ.ۤۦ(context0, throwable0);
            }

            public static void g(Context context0, JSONObject jSONObject0) {
                ۣ۟ۡ۠ۥ.ۣ۟ۧۥۤ(context0, jSONObject0);
            }

            public static void h(Context context0, Exception exception0) {
                ۣ۟ۢۧۤ.ۤۦ(context0, exception0);
            }
        }

    }

    public static void l(String s, Context context0) {
        ۣ۟ۡ۠ۥ.۟۟ۦۥ(new androidx.loader.app.services.b(s, new a(context0)));
    }

    public static void m(AlertDialog alertDialog0, View view0) {
        if(ۣ۟ۢۧۤ.ۣ۟ۤۡۢ(alertDialog0)) {
            ۣ۟ۢۧۤ.ۣۤۧ(alertDialog0);
        }
    }

    public static void n(Context context0, String s, View view0) {
        ۠۟ۤ۟.۠ۡۢۤ(context0, ۥۥۢۡ.ۦ۠ۦۥ(ۥۥۢۡ.۟ۤۨۤۥ(new Intent(ۣ۟ۡ۠ۥ.ۣ۟۠۟۟(l.۟ۢۤۢۦ(), 0x7E, 26, 0x59D)), 0x10000000), ۣ۟ۡ۠ۥ.۟۠ۢ۟ۤ(s)));
    }

    public static native void o(Context arg0, JSONObject arg1) {
    }

    public static native void p(Context arg0, Throwable arg1) {
    }

    public static native short[] ۟ۢۤۢۦ() {
    }
}

