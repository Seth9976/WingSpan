package androidx.appcompat.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.reflect.Method;

class ActionBarDrawerToggleHoneycomb {
    static class SetIndicatorInfo {
        public Method setHomeActionContentDescription;
        public Method setHomeAsUpIndicator;
        public ImageView upIndicatorView;

        SetIndicatorInfo(Activity activity0) {
            try {
                this.setHomeAsUpIndicator = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", Drawable.class);
                this.setHomeActionContentDescription = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", Integer.TYPE);
            }
            catch(NoSuchMethodException unused_ex) {
                View view0 = activity0.findViewById(0x102002C);
                if(view0 == null) {
                    return;
                }
                ViewGroup viewGroup0 = (ViewGroup)view0.getParent();
                if(viewGroup0.getChildCount() != 2) {
                    return;
                }
                View view1 = viewGroup0.getChildAt(0);
                View view2 = viewGroup0.getChildAt(1);
                if(view1.getId() == 0x102002C) {
                    view1 = view2;
                }
                if(view1 instanceof ImageView) {
                    this.upIndicatorView = (ImageView)view1;
                }
            }
        }
    }

    private static final String TAG = "ActionBarDrawerToggleHC";
    private static final int[] THEME_ATTRS;

    static {
        ActionBarDrawerToggleHoneycomb.THEME_ATTRS = new int[]{0x101030B};
    }

    public static Drawable getThemeUpIndicator(Activity activity0) {
        TypedArray typedArray0 = activity0.obtainStyledAttributes(ActionBarDrawerToggleHoneycomb.THEME_ATTRS);
        Drawable drawable0 = typedArray0.getDrawable(0);
        typedArray0.recycle();
        return drawable0;
    }

    public static SetIndicatorInfo setActionBarDescription(SetIndicatorInfo actionBarDrawerToggleHoneycomb$SetIndicatorInfo0, Activity activity0, int v) {
        if(actionBarDrawerToggleHoneycomb$SetIndicatorInfo0 == null) {
            actionBarDrawerToggleHoneycomb$SetIndicatorInfo0 = new SetIndicatorInfo(activity0);
        }
        if(actionBarDrawerToggleHoneycomb$SetIndicatorInfo0.setHomeAsUpIndicator != null) {
            try {
                ActionBar actionBar0 = activity0.getActionBar();
                actionBarDrawerToggleHoneycomb$SetIndicatorInfo0.setHomeActionContentDescription.invoke(actionBar0, v);
                return actionBarDrawerToggleHoneycomb$SetIndicatorInfo0;
            }
            catch(Exception exception0) {
                Log.w("ActionBarDrawerToggleHC", "Couldn\'t set content description via JB-MR2 API", exception0);
            }
        }
        return actionBarDrawerToggleHoneycomb$SetIndicatorInfo0;
    }

    public static SetIndicatorInfo setActionBarUpIndicator(Activity activity0, Drawable drawable0, int v) {
        SetIndicatorInfo actionBarDrawerToggleHoneycomb$SetIndicatorInfo0 = new SetIndicatorInfo(activity0);
        if(actionBarDrawerToggleHoneycomb$SetIndicatorInfo0.setHomeAsUpIndicator != null) {
            try {
                ActionBar actionBar0 = activity0.getActionBar();
                actionBarDrawerToggleHoneycomb$SetIndicatorInfo0.setHomeAsUpIndicator.invoke(actionBar0, drawable0);
                actionBarDrawerToggleHoneycomb$SetIndicatorInfo0.setHomeActionContentDescription.invoke(actionBar0, v);
            }
            catch(Exception exception0) {
                Log.w("ActionBarDrawerToggleHC", "Couldn\'t set home-as-up indicator via JB-MR2 API", exception0);
            }
            return actionBarDrawerToggleHoneycomb$SetIndicatorInfo0;
        }
        if(actionBarDrawerToggleHoneycomb$SetIndicatorInfo0.upIndicatorView != null) {
            actionBarDrawerToggleHoneycomb$SetIndicatorInfo0.upIndicatorView.setImageDrawable(drawable0);
            return actionBarDrawerToggleHoneycomb$SetIndicatorInfo0;
        }
        Log.w("ActionBarDrawerToggleHC", "Couldn\'t set home-as-up indicator");
        return actionBarDrawerToggleHoneycomb$SetIndicatorInfo0;
    }
}

