package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
import androidx.appcompat.R.attr;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.TintableCompoundButton;

public class AppCompatRadioButton extends RadioButton implements TintableBackgroundView, TintableCompoundButton {
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private final AppCompatCompoundButtonHelper mCompoundButtonHelper;
    private final AppCompatTextHelper mTextHelper;

    public AppCompatRadioButton(Context context0) {
        this(context0, null);
    }

    public AppCompatRadioButton(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, attr.radioButtonStyle);
    }

    public AppCompatRadioButton(Context context0, AttributeSet attributeSet0, int v) {
        super(TintContextWrapper.wrap(context0), attributeSet0, v);
        ThemeUtils.checkAppCompatTheme(this, this.getContext());
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper0 = new AppCompatCompoundButtonHelper(this);
        this.mCompoundButtonHelper = appCompatCompoundButtonHelper0;
        appCompatCompoundButtonHelper0.loadFromAttributes(attributeSet0, v);
        AppCompatBackgroundHelper appCompatBackgroundHelper0 = new AppCompatBackgroundHelper(this);
        this.mBackgroundTintHelper = appCompatBackgroundHelper0;
        appCompatBackgroundHelper0.loadFromAttributes(attributeSet0, v);
        AppCompatTextHelper appCompatTextHelper0 = new AppCompatTextHelper(this);
        this.mTextHelper = appCompatTextHelper0;
        appCompatTextHelper0.loadFromAttributes(attributeSet0, v);
    }

    @Override  // android.widget.CompoundButton
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

    @Override  // android.widget.CompoundButton
    public int getCompoundPaddingLeft() {
        return super.getCompoundPaddingLeft();
    }

    @Override  // androidx.core.view.TintableBackgroundView
    public ColorStateList getSupportBackgroundTintList() {
        return this.mBackgroundTintHelper == null ? null : this.mBackgroundTintHelper.getSupportBackgroundTintList();
    }

    @Override  // androidx.core.view.TintableBackgroundView
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return this.mBackgroundTintHelper == null ? null : this.mBackgroundTintHelper.getSupportBackgroundTintMode();
    }

    @Override  // androidx.core.widget.TintableCompoundButton
    public ColorStateList getSupportButtonTintList() {
        return this.mCompoundButtonHelper == null ? null : this.mCompoundButtonHelper.getSupportButtonTintList();
    }

    @Override  // androidx.core.widget.TintableCompoundButton
    public PorterDuff.Mode getSupportButtonTintMode() {
        return this.mCompoundButtonHelper == null ? null : this.mCompoundButtonHelper.getSupportButtonTintMode();
    }

    @Override  // android.view.View
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

    @Override  // android.widget.CompoundButton
    public void setButtonDrawable(int v) {
        this.setButtonDrawable(AppCompatResources.getDrawable(this.getContext(), v));
    }

    @Override  // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable0) {
        super.setButtonDrawable(drawable0);
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper0 = this.mCompoundButtonHelper;
        if(appCompatCompoundButtonHelper0 != null) {
            appCompatCompoundButtonHelper0.onSetButtonDrawable();
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

    @Override  // androidx.core.widget.TintableCompoundButton
    public void setSupportButtonTintList(ColorStateList colorStateList0) {
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper0 = this.mCompoundButtonHelper;
        if(appCompatCompoundButtonHelper0 != null) {
            appCompatCompoundButtonHelper0.setSupportButtonTintList(colorStateList0);
        }
    }

    @Override  // androidx.core.widget.TintableCompoundButton
    public void setSupportButtonTintMode(PorterDuff.Mode porterDuff$Mode0) {
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper0 = this.mCompoundButtonHelper;
        if(appCompatCompoundButtonHelper0 != null) {
            appCompatCompoundButtonHelper0.setSupportButtonTintMode(porterDuff$Mode0);
        }
    }
}

