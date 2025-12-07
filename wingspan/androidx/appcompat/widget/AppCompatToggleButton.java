package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ToggleButton;
import androidx.core.view.TintableBackgroundView;

public class AppCompatToggleButton extends ToggleButton implements TintableBackgroundView {
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private final AppCompatTextHelper mTextHelper;

    public AppCompatToggleButton(Context context0) {
        this(context0, null);
    }

    public AppCompatToggleButton(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x101004B);
    }

    public AppCompatToggleButton(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        ThemeUtils.checkAppCompatTheme(this, this.getContext());
        AppCompatBackgroundHelper appCompatBackgroundHelper0 = new AppCompatBackgroundHelper(this);
        this.mBackgroundTintHelper = appCompatBackgroundHelper0;
        appCompatBackgroundHelper0.loadFromAttributes(attributeSet0, v);
        AppCompatTextHelper appCompatTextHelper0 = new AppCompatTextHelper(this);
        this.mTextHelper = appCompatTextHelper0;
        appCompatTextHelper0.loadFromAttributes(attributeSet0, v);
    }

    @Override  // android.widget.ToggleButton
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper appCompatBackgroundHelper0 = this.mBackgroundTintHelper;
        if(appCompatBackgroundHelper0 != null) {
            appCompatBackgroundHelper0.applySupportBackgroundTint();
        }
        AppCompatTextHelper appCompatTextHelper0 = this.mTextHelper;
        if(appCompatTextHelper0 != null) {
            appCompatTextHelper0.applyCompoundDrawablesTints();
        }
    }

    @Override  // androidx.core.view.TintableBackgroundView
    public ColorStateList getSupportBackgroundTintList() {
        return this.mBackgroundTintHelper == null ? null : this.mBackgroundTintHelper.getSupportBackgroundTintList();
    }

    @Override  // androidx.core.view.TintableBackgroundView
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return this.mBackgroundTintHelper == null ? null : this.mBackgroundTintHelper.getSupportBackgroundTintMode();
    }

    @Override  // android.widget.ToggleButton
    public void setBackgroundDrawable(Drawable drawable0) {
        super.setBackgroundDrawable(drawable0);
        AppCompatBackgroundHelper appCompatBackgroundHelper0 = this.mBackgroundTintHelper;
        if(appCompatBackgroundHelper0 != null) {
            appCompatBackgroundHelper0.onSetBackgroundDrawable(drawable0);
        }
    }

    @Override  // android.view.View
    public void setBackgroundResource(int v) {
        super.setBackgroundResource(v);
        AppCompatBackgroundHelper appCompatBackgroundHelper0 = this.mBackgroundTintHelper;
        if(appCompatBackgroundHelper0 != null) {
            appCompatBackgroundHelper0.onSetBackgroundResource(v);
        }
    }

    @Override  // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintList(ColorStateList colorStateList0) {
        AppCompatBackgroundHelper appCompatBackgroundHelper0 = this.mBackgroundTintHelper;
        if(appCompatBackgroundHelper0 != null) {
            appCompatBackgroundHelper0.setSupportBackgroundTintList(colorStateList0);
        }
    }

    @Override  // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(PorterDuff.Mode porterDuff$Mode0) {
        AppCompatBackgroundHelper appCompatBackgroundHelper0 = this.mBackgroundTintHelper;
        if(appCompatBackgroundHelper0 != null) {
            appCompatBackgroundHelper0.setSupportBackgroundTintMode(porterDuff$Mode0);
        }
    }
}

