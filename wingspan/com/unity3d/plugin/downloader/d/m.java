package com.unity3d.plugin.downloader.d;

import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;
import android.util.Log;

public final class m {
    private final SharedPreferences a;
    private final k b;
    private SharedPreferences.Editor c;

    public m(SharedPreferences sharedPreferences0, k k0) {
        this.a = sharedPreferences0;
        this.b = k0;
        this.c = null;
    }

    public final void a() {
        SharedPreferences.Editor sharedPreferences$Editor0 = this.c;
        if(sharedPreferences$Editor0 != null) {
            sharedPreferences$Editor0.commit();
            this.c = null;
        }
    }

    public final void a(String s, String s1) {
        if(this.c == null) {
            this.c = this.a.edit();
        }
        String s2 = this.b.a(s1, s);
        this.c.putString(s, s2);
    }

    public final String b(String s, String s1) {
        String s2 = this.a.getString(s, null);
        if(s2 != null) {
            try {
                return this.b.b(s2, s);
            }
            catch(o unused_ex) {
                Log.w("PreferenceObfuscator", "Validation error while reading preference: " + s);
            }
        }
        return s1;
    }
}

