package androidx.appcompat.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import androidx.core.view.ViewCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ViewUtils {
    private static final String TAG = "ViewUtils";
    private static Method sComputeFitSystemWindowsMethod;

    static {
        try {
            Method method0 = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
            ViewUtils.sComputeFitSystemWindowsMethod = method0;
            if(!method0.isAccessible()) {
                ViewUtils.sComputeFitSystemWindowsMethod.setAccessible(true);
            }
        }
        catch(NoSuchMethodException unused_ex) {
            Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
        }
    }

    public static void computeFitSystemWindows(View view0, Rect rect0, Rect rect1) {
        Method method0 = ViewUtils.sComputeFitSystemWindowsMethod;
        if(method0 != null) {
            try {
                method0.invoke(view0, rect0, rect1);
            }
            catch(Exception exception0) {
                Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", exception0);
            }
        }
    }

    public static boolean isLayoutRtl(View view0) {
        return ViewCompat.getLayoutDirection(view0) == 1;
    }

    public static void makeOptionalFitsSystemWindows(View view0) {
        try {
            Method method0 = view0.getClass().getMethod("makeOptionalFitsSystemWindows");
            if(!method0.isAccessible()) {
                method0.setAccessible(true);
            }
            method0.invoke(view0);
        }
        catch(NoSuchMethodException unused_ex) {
            Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
        }
        catch(InvocationTargetException invocationTargetException0) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", invocationTargetException0);
        }
        catch(IllegalAccessException illegalAccessException0) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", illegalAccessException0);
        }
    }
}

