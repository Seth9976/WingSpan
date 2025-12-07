package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.lang.reflect.Field;

final class ImmLeaksCleaner implements LifecycleEventObserver {
    private static final int INIT_FAILED = 2;
    private static final int INIT_SUCCESS = 1;
    private static final int NOT_INITIALIAZED;
    private Activity mActivity;
    private static Field sHField;
    private static Field sNextServedViewField;
    private static int sReflectedFieldsInitialized;
    private static Field sServedViewField;

    static {
    }

    ImmLeaksCleaner(Activity activity0) {
        this.mActivity = activity0;
    }

    private static void initializeReflectiveFields() {
        try {
            ImmLeaksCleaner.sReflectedFieldsInitialized = 2;
            Field field0 = InputMethodManager.class.getDeclaredField("mServedView");
            ImmLeaksCleaner.sServedViewField = field0;
            field0.setAccessible(true);
            Field field1 = InputMethodManager.class.getDeclaredField("mNextServedView");
            ImmLeaksCleaner.sNextServedViewField = field1;
            field1.setAccessible(true);
            Field field2 = InputMethodManager.class.getDeclaredField("mH");
            ImmLeaksCleaner.sHField = field2;
            field2.setAccessible(true);
            ImmLeaksCleaner.sReflectedFieldsInitialized = 1;
        }
        catch(NoSuchFieldException unused_ex) {
        }
    }

    @Override  // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner lifecycleOwner0, Event lifecycle$Event0) {
        Object object0;
        if(lifecycle$Event0 != Event.ON_DESTROY) {
            return;
        }
        if(ImmLeaksCleaner.sReflectedFieldsInitialized == 0) {
            ImmLeaksCleaner.initializeReflectiveFields();
        }
        if(ImmLeaksCleaner.sReflectedFieldsInitialized == 1) {
            InputMethodManager inputMethodManager0 = (InputMethodManager)this.mActivity.getSystemService("input_method");
            try {
                object0 = ImmLeaksCleaner.sHField.get(inputMethodManager0);
                if(object0 == null) {
                    return;
                }
            }
            catch(IllegalAccessException unused_ex) {
                return;
            }
            synchronized(object0) {
                try {
                    View view0 = (View)ImmLeaksCleaner.sServedViewField.get(inputMethodManager0);
                }
                catch(IllegalAccessException unused_ex) {
                    return;
                }
                catch(ClassCastException unused_ex) {
                    return;
                }
            }
            if(view0 == null) {
                return;
            }
            if(view0.isAttachedToWindow()) {
                return;
            }
            try {
                ImmLeaksCleaner.sNextServedViewField.set(inputMethodManager0, null);
            }
            catch(IllegalAccessException unused_ex) {
                return;
            }
            inputMethodManager0.isActive();
        }
    }
}

