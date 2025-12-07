package androidx.legacy.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout.DrawerListener;
import androidx.drawerlayout.widget.DrawerLayout;
import java.lang.reflect.Method;

@Deprecated
public class ActionBarDrawerToggle implements DrawerListener {
    @Deprecated
    public interface Delegate {
        Drawable getThemeUpIndicator();

        void setActionBarDescription(int arg1);

        void setActionBarUpIndicator(Drawable arg1, int arg2);
    }

    @Deprecated
    public interface DelegateProvider {
        Delegate getDrawerToggleDelegate();
    }

    static class SetIndicatorInfo {
        Method mSetHomeActionContentDescription;
        Method mSetHomeAsUpIndicator;
        ImageView mUpIndicatorView;

        SetIndicatorInfo(Activity activity0) {
            try {
                this.mSetHomeAsUpIndicator = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", Drawable.class);
                this.mSetHomeActionContentDescription = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", Integer.TYPE);
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
                    this.mUpIndicatorView = (ImageView)view1;
                }
            }
        }
    }

    class SlideDrawable extends InsetDrawable implements Drawable.Callback {
        private final boolean mHasMirroring;
        private float mOffset;
        private float mPosition;
        private final Rect mTmpRect;

        SlideDrawable(Drawable drawable0) {
            super(drawable0, 0);
            this.mHasMirroring = true;
            this.mTmpRect = new Rect();
        }

        @Override  // android.graphics.drawable.DrawableWrapper
        public void draw(Canvas canvas0) {
            this.copyBounds(this.mTmpRect);
            canvas0.save();
            int v = 1;
            boolean z = ViewCompat.getLayoutDirection(ActionBarDrawerToggle.this.mActivity.getWindow().getDecorView()) == 1;
            if(z) {
                v = -1;
            }
            int v1 = this.mTmpRect.width();
            canvas0.translate(-this.mOffset * ((float)v1) * this.mPosition * ((float)v), 0.0f);
            if(z && !this.mHasMirroring) {
                canvas0.translate(((float)v1), 0.0f);
                canvas0.scale(-1.0f, 1.0f);
            }
            super.draw(canvas0);
            canvas0.restore();
        }

        public float getPosition() {
            return this.mPosition;
        }

        public void setOffset(float f) {
            this.mOffset = f;
            this.invalidateSelf();
        }

        public void setPosition(float f) {
            this.mPosition = f;
            this.invalidateSelf();
        }
    }

    private static final int ID_HOME = 0x102002C;
    private static final String TAG = "ActionBarDrawerToggle";
    private static final int[] THEME_ATTRS = null;
    private static final float TOGGLE_DRAWABLE_OFFSET = 0.333333f;
    final Activity mActivity;
    private final Delegate mActivityImpl;
    private final int mCloseDrawerContentDescRes;
    private Drawable mDrawerImage;
    private final int mDrawerImageResource;
    private boolean mDrawerIndicatorEnabled;
    private final DrawerLayout mDrawerLayout;
    private boolean mHasCustomUpIndicator;
    private Drawable mHomeAsUpIndicator;
    private final int mOpenDrawerContentDescRes;
    private SetIndicatorInfo mSetIndicatorInfo;
    private SlideDrawable mSlider;

    static {
        ActionBarDrawerToggle.THEME_ATTRS = new int[]{0x101030B};
    }

    public ActionBarDrawerToggle(Activity activity0, DrawerLayout drawerLayout0, int v, int v1, int v2) {
        this(activity0, drawerLayout0, !ActionBarDrawerToggle.assumeMaterial(activity0), v, v1, v2);
    }

    public ActionBarDrawerToggle(Activity activity0, DrawerLayout drawerLayout0, boolean z, int v, int v1, int v2) {
        this.mDrawerIndicatorEnabled = true;
        this.mActivity = activity0;
        this.mActivityImpl = activity0 instanceof DelegateProvider ? ((DelegateProvider)activity0).getDrawerToggleDelegate() : null;
        this.mDrawerLayout = drawerLayout0;
        this.mDrawerImageResource = v;
        this.mOpenDrawerContentDescRes = v1;
        this.mCloseDrawerContentDescRes = v2;
        this.mHomeAsUpIndicator = this.getThemeUpIndicator();
        this.mDrawerImage = ContextCompat.getDrawable(activity0, v);
        SlideDrawable actionBarDrawerToggle$SlideDrawable0 = new SlideDrawable(this, this.mDrawerImage);
        this.mSlider = actionBarDrawerToggle$SlideDrawable0;
        actionBarDrawerToggle$SlideDrawable0.setOffset((z ? 0.333333f : 0.0f));
    }

    private static boolean assumeMaterial(Context context0) {
        return true;
    }

    private Drawable getThemeUpIndicator() {
        Delegate actionBarDrawerToggle$Delegate0 = this.mActivityImpl;
        if(actionBarDrawerToggle$Delegate0 != null) {
            return actionBarDrawerToggle$Delegate0.getThemeUpIndicator();
        }
        ActionBar actionBar0 = this.mActivity.getActionBar();
        Context context0 = actionBar0 == null ? this.mActivity : actionBar0.getThemedContext();
        TypedArray typedArray0 = context0.obtainStyledAttributes(null, ActionBarDrawerToggle.THEME_ATTRS, 0x10102CE, 0);
        Drawable drawable0 = typedArray0.getDrawable(0);
        typedArray0.recycle();
        return drawable0;
    }

    public boolean isDrawerIndicatorEnabled() {
        return this.mDrawerIndicatorEnabled;
    }

    public void onConfigurationChanged(Configuration configuration0) {
        if(!this.mHasCustomUpIndicator) {
            this.mHomeAsUpIndicator = this.getThemeUpIndicator();
        }
        this.mDrawerImage = ContextCompat.getDrawable(this.mActivity, this.mDrawerImageResource);
        this.syncState();
    }

    @Override  // androidx.drawerlayout.widget.DrawerLayout$DrawerListener
    public void onDrawerClosed(View view0) {
        this.mSlider.setPosition(0.0f);
        if(this.mDrawerIndicatorEnabled) {
            this.setActionBarDescription(this.mOpenDrawerContentDescRes);
        }
    }

    @Override  // androidx.drawerlayout.widget.DrawerLayout$DrawerListener
    public void onDrawerOpened(View view0) {
        this.mSlider.setPosition(1.0f);
        if(this.mDrawerIndicatorEnabled) {
            this.setActionBarDescription(this.mCloseDrawerContentDescRes);
        }
    }

    @Override  // androidx.drawerlayout.widget.DrawerLayout$DrawerListener
    public void onDrawerSlide(View view0, float f) {
        float f1 = this.mSlider.getPosition();
        this.mSlider.setPosition((Float.compare(f, 0.5f) <= 0 ? Math.min(f1, f * 2.0f) : Math.max(f1, Math.max(0.0f, f - 0.5f) * 2.0f)));
    }

    @Override  // androidx.drawerlayout.widget.DrawerLayout$DrawerListener
    public void onDrawerStateChanged(int v) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem0) {
        if(menuItem0 != null && menuItem0.getItemId() == 0x102002C && this.mDrawerIndicatorEnabled) {
            if(this.mDrawerLayout.isDrawerVisible(0x800003)) {
                this.mDrawerLayout.closeDrawer(0x800003);
                return true;
            }
            this.mDrawerLayout.openDrawer(0x800003);
            return true;
        }
        return false;
    }

    private void setActionBarDescription(int v) {
        Delegate actionBarDrawerToggle$Delegate0 = this.mActivityImpl;
        if(actionBarDrawerToggle$Delegate0 != null) {
            actionBarDrawerToggle$Delegate0.setActionBarDescription(v);
            return;
        }
        ActionBar actionBar0 = this.mActivity.getActionBar();
        if(actionBar0 != null) {
            actionBar0.setHomeActionContentDescription(v);
        }
    }

    private void setActionBarUpIndicator(Drawable drawable0, int v) {
        Delegate actionBarDrawerToggle$Delegate0 = this.mActivityImpl;
        if(actionBarDrawerToggle$Delegate0 != null) {
            actionBarDrawerToggle$Delegate0.setActionBarUpIndicator(drawable0, v);
            return;
        }
        ActionBar actionBar0 = this.mActivity.getActionBar();
        if(actionBar0 != null) {
            actionBar0.setHomeAsUpIndicator(drawable0);
            actionBar0.setHomeActionContentDescription(v);
        }
    }

    public void setDrawerIndicatorEnabled(boolean z) {
        if(z != this.mDrawerIndicatorEnabled) {
            if(z) {
                this.setActionBarUpIndicator(this.mSlider, (this.mDrawerLayout.isDrawerOpen(0x800003) ? this.mCloseDrawerContentDescRes : this.mOpenDrawerContentDescRes));
            }
            else {
                this.setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
            }
            this.mDrawerIndicatorEnabled = z;
        }
    }

    public void setHomeAsUpIndicator(int v) {
        this.setHomeAsUpIndicator((v == 0 ? null : ContextCompat.getDrawable(this.mActivity, v)));
    }

    public void setHomeAsUpIndicator(Drawable drawable0) {
        if(drawable0 == null) {
            this.mHomeAsUpIndicator = this.getThemeUpIndicator();
            this.mHasCustomUpIndicator = false;
        }
        else {
            this.mHomeAsUpIndicator = drawable0;
            this.mHasCustomUpIndicator = true;
        }
        if(!this.mDrawerIndicatorEnabled) {
            this.setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
        }
    }

    public void syncState() {
        if(this.mDrawerLayout.isDrawerOpen(0x800003)) {
            this.mSlider.setPosition(1.0f);
        }
        else {
            this.mSlider.setPosition(0.0f);
        }
        if(this.mDrawerIndicatorEnabled) {
            this.setActionBarUpIndicator(this.mSlider, (this.mDrawerLayout.isDrawerOpen(0x800003) ? this.mCloseDrawerContentDescRes : this.mOpenDrawerContentDescRes));
        }
    }
}

