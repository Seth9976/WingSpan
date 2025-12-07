package androidx.appcompat.widget;

import android.graphics.Insets;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build.VERSION;
import android.util.Log;
import androidx.appcompat.graphics.drawable.DrawableWrapper;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.WrappedDrawable;
import java.lang.reflect.Field;

public class DrawableUtils {
    private static final int[] CHECKED_STATE_SET = null;
    private static final int[] EMPTY_STATE_SET = null;
    public static final Rect INSETS_NONE = null;
    private static final String TAG = "DrawableUtils";
    private static final String VECTOR_DRAWABLE_CLAZZ_NAME = "android.graphics.drawable.VectorDrawable";
    private static Class sInsetsClazz;

    static {
        DrawableUtils.CHECKED_STATE_SET = new int[]{0x10100A0};
        DrawableUtils.EMPTY_STATE_SET = new int[0];
        DrawableUtils.INSETS_NONE = new Rect();
        DrawableUtils.sInsetsClazz = Insets.class;
    }

    public static boolean canSafelyMutateDrawable(Drawable drawable0) {
        if(drawable0 instanceof DrawableContainer) {
            Drawable.ConstantState drawable$ConstantState0 = drawable0.getConstantState();
            if(drawable$ConstantState0 instanceof DrawableContainer.DrawableContainerState) {
                Drawable[] arr_drawable = ((DrawableContainer.DrawableContainerState)drawable$ConstantState0).getChildren();
                for(int v = 0; v < arr_drawable.length; ++v) {
                    if(!DrawableUtils.canSafelyMutateDrawable(arr_drawable[v])) {
                        return false;
                    }
                }
            }
            return true;
        }
        if(drawable0 instanceof WrappedDrawable) {
            return DrawableUtils.canSafelyMutateDrawable(((WrappedDrawable)drawable0).getWrappedDrawable());
        }
        if(drawable0 instanceof DrawableWrapper) {
            return DrawableUtils.canSafelyMutateDrawable(((DrawableWrapper)drawable0).getWrappedDrawable());
        }
        return drawable0 instanceof ScaleDrawable ? DrawableUtils.canSafelyMutateDrawable(((ScaleDrawable)drawable0).getDrawable()) : true;
    }

    static void fixDrawable(Drawable drawable0) {
    }

    private static void fixVectorDrawableTinting(Drawable drawable0) {
        int[] arr_v = drawable0.getState();
        if(arr_v == null || arr_v.length == 0) {
            drawable0.setState(DrawableUtils.CHECKED_STATE_SET);
        }
        else {
            drawable0.setState(DrawableUtils.EMPTY_STATE_SET);
        }
        drawable0.setState(arr_v);
    }

    // This method was un-flattened
    public static Rect getOpticalBounds(Drawable drawable0) {
        if(Build.VERSION.SDK_INT >= 29) {
            Insets insets0 = drawable0.getOpticalInsets();
            Rect rect0 = new Rect();
            rect0.left = insets0.left;
            rect0.right = insets0.right;
            rect0.top = insets0.top;
            rect0.bottom = insets0.bottom;
            return rect0;
        }
        if(DrawableUtils.sInsetsClazz != null) {
            try {
                Drawable drawable1 = DrawableCompat.unwrap(drawable0);
                Object object0 = drawable1.getClass().getMethod("getOpticalInsets").invoke(drawable1);
                if(object0 != null) {
                    Rect rect1 = new Rect();
                    Field[] arr_field = DrawableUtils.sInsetsClazz.getFields();
                    for(int v = 0; v < arr_field.length; ++v) {
                        Field field0 = arr_field[v];
                        switch(field0.getName()) {
                            case "bottom": {
                                rect1.bottom = field0.getInt(object0);
                                break;
                            }
                            case "left": {
                                rect1.left = field0.getInt(object0);
                                break;
                            }
                            case "right": {
                                rect1.right = field0.getInt(object0);
                                break;
                            }
                            case "top": {
                                rect1.top = field0.getInt(object0);
                            }
                        }
                    }
                    return rect1;
                }
            }
            catch(Exception unused_ex) {
                Log.e("DrawableUtils", "Couldn\'t obtain the optical insets. Ignoring.");
            }
        }
        return DrawableUtils.INSETS_NONE;
    }

    public static PorterDuff.Mode parseTintMode(int v, PorterDuff.Mode porterDuff$Mode0) {
        switch(v) {
            case 3: {
                return PorterDuff.Mode.SRC_OVER;
            }
            case 5: {
                return PorterDuff.Mode.SRC_IN;
            }
            case 9: {
                return PorterDuff.Mode.SRC_ATOP;
            }
            case 14: {
                return PorterDuff.Mode.MULTIPLY;
            }
            case 15: {
                return PorterDuff.Mode.SCREEN;
            }
            case 16: {
                return PorterDuff.Mode.ADD;
            }
            default: {
                return porterDuff$Mode0;
            }
        }
    }
}

