package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.text.PrecomputedTextCompat.Params;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.AutoSizeableTextView;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TintableCompoundDrawablesView;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AppCompatTextView extends TextView implements TintableBackgroundView, AutoSizeableTextView, TintableCompoundDrawablesView {
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private boolean mIsSetTypefaceProcessing;
    private Future mPrecomputedTextFuture;
    private final AppCompatTextClassifierHelper mTextClassifierHelper;
    private final AppCompatTextHelper mTextHelper;

    public AppCompatTextView(Context context0) {
        this(context0, null);
    }

    public AppCompatTextView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x1010084);
    }

    public AppCompatTextView(Context context0, AttributeSet attributeSet0, int v) {
        super(TintContextWrapper.wrap(context0), attributeSet0, v);
        this.mIsSetTypefaceProcessing = false;
        ThemeUtils.checkAppCompatTheme(this, this.getContext());
        AppCompatBackgroundHelper appCompatBackgroundHelper0 = new AppCompatBackgroundHelper(this);
        this.mBackgroundTintHelper = appCompatBackgroundHelper0;
        appCompatBackgroundHelper0.loadFromAttributes(attributeSet0, v);
        AppCompatTextHelper appCompatTextHelper0 = new AppCompatTextHelper(this);
        this.mTextHelper = appCompatTextHelper0;
        appCompatTextHelper0.loadFromAttributes(attributeSet0, v);
        appCompatTextHelper0.applyCompoundDrawablesTints();
        this.mTextClassifierHelper = new AppCompatTextClassifierHelper(this);
    }

    private void consumeTextFutureAndSetBlocking() {
        Future future0 = this.mPrecomputedTextFuture;
        if(future0 != null) {
            try {
                this.mPrecomputedTextFuture = null;
                TextViewCompat.setPrecomputedText(this, ((PrecomputedTextCompat)future0.get()));
            }
            catch(InterruptedException | ExecutionException unused_ex) {
            }
        }
    }

    @Override  // android.widget.TextView
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

    @Override  // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    public int getAutoSizeMaxTextSize() {
        if(AppCompatTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
            return super.getAutoSizeMaxTextSize();
        }
        return this.mTextHelper == null ? -1 : this.mTextHelper.getAutoSizeMaxTextSize();
    }

    @Override  // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    public int getAutoSizeMinTextSize() {
        if(AppCompatTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
            return super.getAutoSizeMinTextSize();
        }
        return this.mTextHelper == null ? -1 : this.mTextHelper.getAutoSizeMinTextSize();
    }

    @Override  // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    public int getAutoSizeStepGranularity() {
        if(AppCompatTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
            return super.getAutoSizeStepGranularity();
        }
        return this.mTextHelper == null ? -1 : this.mTextHelper.getAutoSizeStepGranularity();
    }

    @Override  // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    public int[] getAutoSizeTextAvailableSizes() {
        if(AppCompatTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
            return super.getAutoSizeTextAvailableSizes();
        }
        return this.mTextHelper == null ? new int[0] : this.mTextHelper.getAutoSizeTextAvailableSizes();
    }

    @Override  // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    public int getAutoSizeTextType() {
        if(AppCompatTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        return this.mTextHelper == null ? 0 : this.mTextHelper.getAutoSizeTextType();
    }

    @Override  // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return TextViewCompat.getFirstBaselineToTopHeight(this);
    }

    @Override  // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return TextViewCompat.getLastBaselineToBottomHeight(this);
    }

    @Override  // androidx.core.view.TintableBackgroundView
    public ColorStateList getSupportBackgroundTintList() {
        return this.mBackgroundTintHelper == null ? null : this.mBackgroundTintHelper.getSupportBackgroundTintList();
    }

    @Override  // androidx.core.view.TintableBackgroundView
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return this.mBackgroundTintHelper == null ? null : this.mBackgroundTintHelper.getSupportBackgroundTintMode();
    }

    @Override  // androidx.core.widget.TintableCompoundDrawablesView
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.mTextHelper.getCompoundDrawableTintList();
    }

    @Override  // androidx.core.widget.TintableCompoundDrawablesView
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.mTextHelper.getCompoundDrawableTintMode();
    }

    @Override  // android.widget.TextView
    public CharSequence getText() {
        this.consumeTextFutureAndSetBlocking();
        return super.getText();
    }

    @Override  // android.widget.TextView
    public TextClassifier getTextClassifier() {
        if(Build.VERSION.SDK_INT < 28) {
            return this.mTextClassifierHelper == null ? super.getTextClassifier() : this.mTextClassifierHelper.getTextClassifier();
        }
        return super.getTextClassifier();
    }

    public Params getTextMetricsParamsCompat() {
        return TextViewCompat.getTextMetricsParams(this);
    }

    @Override  // android.widget.TextView
    public InputConnection onCreateInputConnection(EditorInfo editorInfo0) {
        InputConnection inputConnection0 = super.onCreateInputConnection(editorInfo0);
        this.mTextHelper.populateSurroundingTextIfNeeded(this, inputConnection0, editorInfo0);
        return AppCompatHintHelper.onCreateInputConnection(inputConnection0, editorInfo0, this);
    }

    @Override  // android.widget.TextView
    protected void onLayout(boolean z, int v, int v1, int v2, int v3) {
        super.onLayout(z, v, v1, v2, v3);
        AppCompatTextHelper appCompatTextHelper0 = this.mTextHelper;
        if(appCompatTextHelper0 != null) {
            appCompatTextHelper0.onLayout(z, v, v1, v2, v3);
        }
    }

    @Override  // android.widget.TextView
    protected void onMeasure(int v, int v1) {
        this.consumeTextFutureAndSetBlocking();
        super.onMeasure(v, v1);
    }

    @Override  // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
        super.onTextChanged(charSequence0, v, v1, v2);
        if(this.mTextHelper != null && !AppCompatTextView.PLATFORM_SUPPORTS_AUTOSIZE && this.mTextHelper.isAutoSizeEnabled()) {
            this.mTextHelper.autoSizeText();
        }
    }

    @Override  // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int v, int v1, int v2, int v3) throws IllegalArgumentException {
        if(AppCompatTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
            super.setAutoSizeTextTypeUniformWithConfiguration(v, v1, v2, v3);
            return;
        }
        AppCompatTextHelper appCompatTextHelper0 = this.mTextHelper;
        if(appCompatTextHelper0 != null) {
            appCompatTextHelper0.setAutoSizeTextTypeUniformWithConfiguration(v, v1, v2, v3);
        }
    }

    @Override  // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] arr_v, int v) throws IllegalArgumentException {
        if(AppCompatTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(arr_v, v);
            return;
        }
        AppCompatTextHelper appCompatTextHelper0 = this.mTextHelper;
        if(appCompatTextHelper0 != null) {
            appCompatTextHelper0.setAutoSizeTextTypeUniformWithPresetSizes(arr_v, v);
        }
    }

    @Override  // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    public void setAutoSizeTextTypeWithDefaults(int v) {
        if(AppCompatTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
            super.setAutoSizeTextTypeWithDefaults(v);
            return;
        }
        AppCompatTextHelper appCompatTextHelper0 = this.mTextHelper;
        if(appCompatTextHelper0 != null) {
            appCompatTextHelper0.setAutoSizeTextTypeWithDefaults(v);
        }
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

    @Override  // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable0, Drawable drawable1, Drawable drawable2, Drawable drawable3) {
        super.setCompoundDrawables(drawable0, drawable1, drawable2, drawable3);
        AppCompatTextHelper appCompatTextHelper0 = this.mTextHelper;
        if(appCompatTextHelper0 != null) {
            appCompatTextHelper0.onSetCompoundDrawables();
        }
    }

    @Override  // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable0, Drawable drawable1, Drawable drawable2, Drawable drawable3) {
        super.setCompoundDrawablesRelative(drawable0, drawable1, drawable2, drawable3);
        AppCompatTextHelper appCompatTextHelper0 = this.mTextHelper;
        if(appCompatTextHelper0 != null) {
            appCompatTextHelper0.onSetCompoundDrawables();
        }
    }

    @Override  // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int v, int v1, int v2, int v3) {
        Context context0 = this.getContext();
        Drawable drawable0 = null;
        Drawable drawable1 = v == 0 ? null : AppCompatResources.getDrawable(context0, v);
        Drawable drawable2 = v1 == 0 ? null : AppCompatResources.getDrawable(context0, v1);
        Drawable drawable3 = v2 == 0 ? null : AppCompatResources.getDrawable(context0, v2);
        if(v3 != 0) {
            drawable0 = AppCompatResources.getDrawable(context0, v3);
        }
        this.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable1, drawable2, drawable3, drawable0);
        AppCompatTextHelper appCompatTextHelper0 = this.mTextHelper;
        if(appCompatTextHelper0 != null) {
            appCompatTextHelper0.onSetCompoundDrawables();
        }
    }

    @Override  // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable0, Drawable drawable1, Drawable drawable2, Drawable drawable3) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable0, drawable1, drawable2, drawable3);
        AppCompatTextHelper appCompatTextHelper0 = this.mTextHelper;
        if(appCompatTextHelper0 != null) {
            appCompatTextHelper0.onSetCompoundDrawables();
        }
    }

    @Override  // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int v, int v1, int v2, int v3) {
        Context context0 = this.getContext();
        Drawable drawable0 = null;
        Drawable drawable1 = v == 0 ? null : AppCompatResources.getDrawable(context0, v);
        Drawable drawable2 = v1 == 0 ? null : AppCompatResources.getDrawable(context0, v1);
        Drawable drawable3 = v2 == 0 ? null : AppCompatResources.getDrawable(context0, v2);
        if(v3 != 0) {
            drawable0 = AppCompatResources.getDrawable(context0, v3);
        }
        this.setCompoundDrawablesWithIntrinsicBounds(drawable1, drawable2, drawable3, drawable0);
        AppCompatTextHelper appCompatTextHelper0 = this.mTextHelper;
        if(appCompatTextHelper0 != null) {
            appCompatTextHelper0.onSetCompoundDrawables();
        }
    }

    @Override  // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable0, Drawable drawable1, Drawable drawable2, Drawable drawable3) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable0, drawable1, drawable2, drawable3);
        AppCompatTextHelper appCompatTextHelper0 = this.mTextHelper;
        if(appCompatTextHelper0 != null) {
            appCompatTextHelper0.onSetCompoundDrawables();
        }
    }

    @Override  // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback actionMode$Callback0) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, actionMode$Callback0));
    }

    @Override  // android.widget.TextView
    public void setFirstBaselineToTopHeight(int v) {
        if(Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(v);
            return;
        }
        TextViewCompat.setFirstBaselineToTopHeight(this, v);
    }

    @Override  // android.widget.TextView
    public void setLastBaselineToBottomHeight(int v) {
        if(Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(v);
            return;
        }
        TextViewCompat.setLastBaselineToBottomHeight(this, v);
    }

    @Override  // android.widget.TextView
    public void setLineHeight(int v) {
        TextViewCompat.setLineHeight(this, v);
    }

    public void setPrecomputedText(PrecomputedTextCompat precomputedTextCompat0) {
        TextViewCompat.setPrecomputedText(this, precomputedTextCompat0);
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

    @Override  // androidx.core.widget.TintableCompoundDrawablesView
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList0) {
        this.mTextHelper.setCompoundDrawableTintList(colorStateList0);
        this.mTextHelper.applyCompoundDrawablesTints();
    }

    @Override  // androidx.core.widget.TintableCompoundDrawablesView
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode porterDuff$Mode0) {
        this.mTextHelper.setCompoundDrawableTintMode(porterDuff$Mode0);
        this.mTextHelper.applyCompoundDrawablesTints();
    }

    @Override  // android.widget.TextView
    public void setTextAppearance(Context context0, int v) {
        super.setTextAppearance(context0, v);
        AppCompatTextHelper appCompatTextHelper0 = this.mTextHelper;
        if(appCompatTextHelper0 != null) {
            appCompatTextHelper0.onSetTextAppearance(context0, v);
        }
    }

    @Override  // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier0) {
        if(Build.VERSION.SDK_INT < 28) {
            AppCompatTextClassifierHelper appCompatTextClassifierHelper0 = this.mTextClassifierHelper;
            if(appCompatTextClassifierHelper0 != null) {
                appCompatTextClassifierHelper0.setTextClassifier(textClassifier0);
                return;
            }
        }
        super.setTextClassifier(textClassifier0);
    }

    public void setTextFuture(Future future0) {
        this.mPrecomputedTextFuture = future0;
        if(future0 != null) {
            this.requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(Params precomputedTextCompat$Params0) {
        TextViewCompat.setTextMetricsParams(this, precomputedTextCompat$Params0);
    }

    @Override  // android.widget.TextView
    public void setTextSize(int v, float f) {
        if(AppCompatTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
            super.setTextSize(v, f);
            return;
        }
        AppCompatTextHelper appCompatTextHelper0 = this.mTextHelper;
        if(appCompatTextHelper0 != null) {
            appCompatTextHelper0.setTextSize(v, f);
        }
    }

    @Override  // android.widget.TextView
    public void setTypeface(Typeface typeface0, int v) {
        if(this.mIsSetTypefaceProcessing) {
            return;
        }
        Typeface typeface1 = typeface0 == null || v <= 0 ? null : TypefaceCompat.create(this.getContext(), typeface0, v);
        this.mIsSetTypefaceProcessing = true;
        if(typeface1 != null) {
            typeface0 = typeface1;
        }
        try {
            super.setTypeface(typeface0, v);
            this.mIsSetTypefaceProcessing = false;
        }
        catch(Throwable throwable0) {
            this.mIsSetTypefaceProcessing = false;
            throw throwable0;
        }
    }
}

