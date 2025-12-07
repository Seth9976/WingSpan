package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import androidx.appcompat.view.ActionMode.Callback;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.collection.ArraySet;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.Iterator;

public abstract class AppCompatDelegate {
    @Retention(RetentionPolicy.SOURCE)
    public @interface NightMode {
    }

    static final boolean DEBUG = false;
    public static final int FEATURE_ACTION_MODE_OVERLAY = 10;
    public static final int FEATURE_SUPPORT_ACTION_BAR = 108;
    public static final int FEATURE_SUPPORT_ACTION_BAR_OVERLAY = 109;
    @Deprecated
    public static final int MODE_NIGHT_AUTO = 0;
    public static final int MODE_NIGHT_AUTO_BATTERY = 3;
    @Deprecated
    public static final int MODE_NIGHT_AUTO_TIME = 0;
    public static final int MODE_NIGHT_FOLLOW_SYSTEM = -1;
    public static final int MODE_NIGHT_NO = 1;
    public static final int MODE_NIGHT_UNSPECIFIED = -100;
    public static final int MODE_NIGHT_YES = 2;
    static final String TAG = "AppCompatDelegate";
    private static final ArraySet sActivityDelegates = null;
    private static final Object sActivityDelegatesLock = null;
    private static int sDefaultNightMode = -100;

    static {
        AppCompatDelegate.sActivityDelegates = new ArraySet();
        AppCompatDelegate.sActivityDelegatesLock = new Object();
    }

    static void addActiveDelegate(AppCompatDelegate appCompatDelegate0) {
        synchronized(AppCompatDelegate.sActivityDelegatesLock) {
            AppCompatDelegate.removeDelegateFromActives(appCompatDelegate0);
            WeakReference weakReference0 = new WeakReference(appCompatDelegate0);
            AppCompatDelegate.sActivityDelegates.add(weakReference0);
        }
    }

    public abstract void addContentView(View arg1, ViewGroup.LayoutParams arg2);

    public abstract boolean applyDayNight();

    private static void applyDayNightToActiveDelegates() {
        synchronized(AppCompatDelegate.sActivityDelegatesLock) {
            for(Object object1: AppCompatDelegate.sActivityDelegates) {
                AppCompatDelegate appCompatDelegate0 = (AppCompatDelegate)((WeakReference)object1).get();
                if(appCompatDelegate0 != null) {
                    appCompatDelegate0.applyDayNight();
                }
            }
        }
    }

    @Deprecated
    public void attachBaseContext(Context context0) {
    }

    public Context attachBaseContext2(Context context0) {
        return context0;
    }

    public static AppCompatDelegate create(Activity activity0, AppCompatCallback appCompatCallback0) {
        return new AppCompatDelegateImpl(activity0, appCompatCallback0);
    }

    public static AppCompatDelegate create(Dialog dialog0, AppCompatCallback appCompatCallback0) {
        return new AppCompatDelegateImpl(dialog0, appCompatCallback0);
    }

    public static AppCompatDelegate create(Context context0, Activity activity0, AppCompatCallback appCompatCallback0) {
        return new AppCompatDelegateImpl(context0, activity0, appCompatCallback0);
    }

    public static AppCompatDelegate create(Context context0, Window window0, AppCompatCallback appCompatCallback0) {
        return new AppCompatDelegateImpl(context0, window0, appCompatCallback0);
    }

    public abstract View createView(View arg1, String arg2, Context arg3, AttributeSet arg4);

    public abstract View findViewById(int arg1);

    public static int getDefaultNightMode() {
        return AppCompatDelegate.sDefaultNightMode;
    }

    public abstract Delegate getDrawerToggleDelegate();

    public int getLocalNightMode() {
        return -100;
    }

    public abstract MenuInflater getMenuInflater();

    public abstract ActionBar getSupportActionBar();

    public abstract boolean hasWindowFeature(int arg1);

    public abstract void installViewFactory();

    public abstract void invalidateOptionsMenu();

    // 去混淆评级： 低(20)
    public static boolean isCompatVectorFromResourcesEnabled() {
        return false;
    }

    public abstract boolean isHandleNativeActionModesEnabled();

    public abstract void onConfigurationChanged(Configuration arg1);

    public abstract void onCreate(Bundle arg1);

    public abstract void onDestroy();

    public abstract void onPostCreate(Bundle arg1);

    public abstract void onPostResume();

    public abstract void onSaveInstanceState(Bundle arg1);

    public abstract void onStart();

    public abstract void onStop();

    static void removeActivityDelegate(AppCompatDelegate appCompatDelegate0) {
        synchronized(AppCompatDelegate.sActivityDelegatesLock) {
            AppCompatDelegate.removeDelegateFromActives(appCompatDelegate0);
        }
    }

    private static void removeDelegateFromActives(AppCompatDelegate appCompatDelegate0) {
        synchronized(AppCompatDelegate.sActivityDelegatesLock) {
            Iterator iterator0 = AppCompatDelegate.sActivityDelegates.iterator();
            while(iterator0.hasNext()) {
                Object object1 = iterator0.next();
                AppCompatDelegate appCompatDelegate1 = (AppCompatDelegate)((WeakReference)object1).get();
                if(appCompatDelegate1 == appCompatDelegate0 || appCompatDelegate1 == null) {
                    iterator0.remove();
                }
            }
        }
    }

    public abstract boolean requestWindowFeature(int arg1);

    public static void setCompatVectorFromResourcesEnabled(boolean z) {
        VectorEnabledTintResources.setCompatVectorFromResourcesEnabled(z);
    }

    public abstract void setContentView(int arg1);

    public abstract void setContentView(View arg1);

    public abstract void setContentView(View arg1, ViewGroup.LayoutParams arg2);

    public static void setDefaultNightMode(int v) {
        if(v != -1 && v != 0 && (v != 1 && v != 2 && v != 3)) {
            Log.d("AppCompatDelegate", "setDefaultNightMode() called with an unknown mode");
            return;
        }
        if(AppCompatDelegate.sDefaultNightMode != v) {
            AppCompatDelegate.sDefaultNightMode = v;
            AppCompatDelegate.applyDayNightToActiveDelegates();
        }
    }

    public abstract void setHandleNativeActionModesEnabled(boolean arg1);

    public abstract void setLocalNightMode(int arg1);

    public abstract void setSupportActionBar(Toolbar arg1);

    public void setTheme(int v) {
    }

    public abstract void setTitle(CharSequence arg1);

    public abstract ActionMode startSupportActionMode(Callback arg1);
}

