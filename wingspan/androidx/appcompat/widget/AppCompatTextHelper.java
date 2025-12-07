package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.appcompat.R.styleable;
import androidx.core.content.res.ResourcesCompat.FontCallback;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.core.widget.AutoSizeableTextView;
import androidx.core.widget.TextViewCompat;
import java.lang.ref.WeakReference;
import java.util.Locale;

class AppCompatTextHelper {
    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    private static final int TEXT_FONT_WEIGHT_UNSPECIFIED = -1;
    private boolean mAsyncFontPending;
    private final AppCompatTextViewAutoSizeHelper mAutoSizeTextHelper;
    private TintInfo mDrawableBottomTint;
    private TintInfo mDrawableEndTint;
    private TintInfo mDrawableLeftTint;
    private TintInfo mDrawableRightTint;
    private TintInfo mDrawableStartTint;
    private TintInfo mDrawableTint;
    private TintInfo mDrawableTopTint;
    private Typeface mFontTypeface;
    private int mFontWeight;
    private int mStyle;
    private final TextView mView;

    AppCompatTextHelper(TextView textView0) {
        this.mStyle = 0;
        this.mFontWeight = -1;
        this.mView = textView0;
        this.mAutoSizeTextHelper = new AppCompatTextViewAutoSizeHelper(textView0);
    }

    private void applyCompoundDrawableTint(Drawable drawable0, TintInfo tintInfo0) {
        if(drawable0 != null && tintInfo0 != null) {
            AppCompatDrawableManager.tintDrawable(drawable0, tintInfo0, this.mView.getDrawableState());
        }
    }

    void applyCompoundDrawablesTints() {
        if(this.mDrawableLeftTint != null || this.mDrawableTopTint != null || this.mDrawableRightTint != null || this.mDrawableBottomTint != null) {
            Drawable[] arr_drawable = this.mView.getCompoundDrawables();
            this.applyCompoundDrawableTint(arr_drawable[0], this.mDrawableLeftTint);
            this.applyCompoundDrawableTint(arr_drawable[1], this.mDrawableTopTint);
            this.applyCompoundDrawableTint(arr_drawable[2], this.mDrawableRightTint);
            this.applyCompoundDrawableTint(arr_drawable[3], this.mDrawableBottomTint);
        }
        if(this.mDrawableStartTint != null || this.mDrawableEndTint != null) {
            Drawable[] arr_drawable1 = this.mView.getCompoundDrawablesRelative();
            this.applyCompoundDrawableTint(arr_drawable1[0], this.mDrawableStartTint);
            this.applyCompoundDrawableTint(arr_drawable1[2], this.mDrawableEndTint);
        }
    }

    void autoSizeText() {
        this.mAutoSizeTextHelper.autoSizeText();
    }

    private static TintInfo createTintInfo(Context context0, AppCompatDrawableManager appCompatDrawableManager0, int v) {
        ColorStateList colorStateList0 = appCompatDrawableManager0.getTintList(context0, v);
        if(colorStateList0 != null) {
            TintInfo tintInfo0 = new TintInfo();
            tintInfo0.mHasTintList = true;
            tintInfo0.mTintList = colorStateList0;
            return tintInfo0;
        }
        return null;
    }

    int getAutoSizeMaxTextSize() {
        return this.mAutoSizeTextHelper.getAutoSizeMaxTextSize();
    }

    int getAutoSizeMinTextSize() {
        return this.mAutoSizeTextHelper.getAutoSizeMinTextSize();
    }

    int getAutoSizeStepGranularity() {
        return this.mAutoSizeTextHelper.getAutoSizeStepGranularity();
    }

    int[] getAutoSizeTextAvailableSizes() {
        return this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
    }

    int getAutoSizeTextType() {
        return this.mAutoSizeTextHelper.getAutoSizeTextType();
    }

    ColorStateList getCompoundDrawableTintList() {
        return this.mDrawableTint == null ? null : this.mDrawableTint.mTintList;
    }

    PorterDuff.Mode getCompoundDrawableTintMode() {
        return this.mDrawableTint == null ? null : this.mDrawableTint.mTintMode;
    }

    boolean isAutoSizeEnabled() {
        return this.mAutoSizeTextHelper.isAutoSizeEnabled();
    }

    void loadFromAttributes(AttributeSet attributeSet0, int v) {
        int v3;
        String s1;
        String s;
        int v2;
        boolean z;
        Context context0 = this.mView.getContext();
        AppCompatDrawableManager appCompatDrawableManager0 = AppCompatDrawableManager.get();
        TintTypedArray tintTypedArray0 = TintTypedArray.obtainStyledAttributes(context0, attributeSet0, styleable.AppCompatTextHelper, v, 0);
        Context context1 = this.mView.getContext();
        ViewCompat.saveAttributeDataForStyleable(this.mView, context1, styleable.AppCompatTextHelper, attributeSet0, tintTypedArray0.getWrappedTypeArray(), v, 0);
        int v1 = tintTypedArray0.getResourceId(styleable.AppCompatTextHelper_android_textAppearance, -1);
        if(tintTypedArray0.hasValue(styleable.AppCompatTextHelper_android_drawableLeft)) {
            this.mDrawableLeftTint = AppCompatTextHelper.createTintInfo(context0, appCompatDrawableManager0, tintTypedArray0.getResourceId(styleable.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if(tintTypedArray0.hasValue(styleable.AppCompatTextHelper_android_drawableTop)) {
            this.mDrawableTopTint = AppCompatTextHelper.createTintInfo(context0, appCompatDrawableManager0, tintTypedArray0.getResourceId(styleable.AppCompatTextHelper_android_drawableTop, 0));
        }
        if(tintTypedArray0.hasValue(styleable.AppCompatTextHelper_android_drawableRight)) {
            this.mDrawableRightTint = AppCompatTextHelper.createTintInfo(context0, appCompatDrawableManager0, tintTypedArray0.getResourceId(styleable.AppCompatTextHelper_android_drawableRight, 0));
        }
        if(tintTypedArray0.hasValue(styleable.AppCompatTextHelper_android_drawableBottom)) {
            this.mDrawableBottomTint = AppCompatTextHelper.createTintInfo(context0, appCompatDrawableManager0, tintTypedArray0.getResourceId(styleable.AppCompatTextHelper_android_drawableBottom, 0));
        }
        if(tintTypedArray0.hasValue(styleable.AppCompatTextHelper_android_drawableStart)) {
            this.mDrawableStartTint = AppCompatTextHelper.createTintInfo(context0, appCompatDrawableManager0, tintTypedArray0.getResourceId(styleable.AppCompatTextHelper_android_drawableStart, 0));
        }
        if(tintTypedArray0.hasValue(styleable.AppCompatTextHelper_android_drawableEnd)) {
            this.mDrawableEndTint = AppCompatTextHelper.createTintInfo(context0, appCompatDrawableManager0, tintTypedArray0.getResourceId(styleable.AppCompatTextHelper_android_drawableEnd, 0));
        }
        tintTypedArray0.recycle();
        TransformationMethod transformationMethod0 = this.mView.getTransformationMethod();
        if(v1 == -1) {
            z = false;
            v2 = 0;
            s = null;
            s1 = null;
        }
        else {
            TintTypedArray tintTypedArray1 = TintTypedArray.obtainStyledAttributes(context0, v1, styleable.TextAppearance);
            if(transformationMethod0 instanceof PasswordTransformationMethod || !tintTypedArray1.hasValue(styleable.TextAppearance_textAllCaps)) {
                z = false;
                v2 = 0;
            }
            else {
                z = tintTypedArray1.getBoolean(styleable.TextAppearance_textAllCaps, false);
                v2 = 1;
            }
            this.updateTypefaceAndStyle(context0, tintTypedArray1);
            s = tintTypedArray1.hasValue(styleable.TextAppearance_textLocale) ? tintTypedArray1.getString(styleable.TextAppearance_textLocale) : null;
            s1 = Build.VERSION.SDK_INT < 26 || !tintTypedArray1.hasValue(styleable.TextAppearance_fontVariationSettings) ? null : tintTypedArray1.getString(styleable.TextAppearance_fontVariationSettings);
            tintTypedArray1.recycle();
        }
        TintTypedArray tintTypedArray2 = TintTypedArray.obtainStyledAttributes(context0, attributeSet0, styleable.TextAppearance, v, 0);
        if(transformationMethod0 instanceof PasswordTransformationMethod || !tintTypedArray2.hasValue(styleable.TextAppearance_textAllCaps)) {
            v3 = v2;
        }
        else {
            z = tintTypedArray2.getBoolean(styleable.TextAppearance_textAllCaps, false);
            v3 = 1;
        }
        if(tintTypedArray2.hasValue(styleable.TextAppearance_textLocale)) {
            s = tintTypedArray2.getString(styleable.TextAppearance_textLocale);
        }
        if(Build.VERSION.SDK_INT >= 26 && tintTypedArray2.hasValue(styleable.TextAppearance_fontVariationSettings)) {
            s1 = tintTypedArray2.getString(styleable.TextAppearance_fontVariationSettings);
        }
        if(Build.VERSION.SDK_INT >= 28 && tintTypedArray2.hasValue(styleable.TextAppearance_android_textSize) && tintTypedArray2.getDimensionPixelSize(styleable.TextAppearance_android_textSize, -1) == 0) {
            this.mView.setTextSize(0, 0.0f);
        }
        this.updateTypefaceAndStyle(context0, tintTypedArray2);
        tintTypedArray2.recycle();
        if(!(transformationMethod0 instanceof PasswordTransformationMethod) && v3 != 0) {
            this.setAllCaps(z);
        }
        Typeface typeface0 = this.mFontTypeface;
        if(typeface0 != null) {
            if(this.mFontWeight == -1) {
                this.mView.setTypeface(typeface0, this.mStyle);
            }
            else {
                this.mView.setTypeface(typeface0);
            }
        }
        if(s1 != null) {
            this.mView.setFontVariationSettings(s1);
        }
        if(s != null) {
            if(Build.VERSION.SDK_INT >= 24) {
                LocaleList localeList0 = LocaleList.forLanguageTags(s);
                this.mView.setTextLocales(localeList0);
            }
            else {
                Locale locale0 = Locale.forLanguageTag(s.substring(0, s.indexOf(44)));
                this.mView.setTextLocale(locale0);
            }
        }
        this.mAutoSizeTextHelper.loadFromAttributes(attributeSet0, v);
        if(AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE && this.mAutoSizeTextHelper.getAutoSizeTextType() != 0) {
            int[] arr_v = this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
            if(arr_v.length > 0) {
                if(((float)this.mView.getAutoSizeStepGranularity()) == -1.0f) {
                    this.mView.setAutoSizeTextTypeUniformWithPresetSizes(arr_v, 0);
                }
                else {
                    this.mView.setAutoSizeTextTypeUniformWithConfiguration(this.mAutoSizeTextHelper.getAutoSizeMinTextSize(), this.mAutoSizeTextHelper.getAutoSizeMaxTextSize(), this.mAutoSizeTextHelper.getAutoSizeStepGranularity(), 0);
                }
            }
        }
        TintTypedArray tintTypedArray3 = TintTypedArray.obtainStyledAttributes(context0, attributeSet0, styleable.AppCompatTextView);
        int v4 = tintTypedArray3.getResourceId(styleable.AppCompatTextView_drawableLeftCompat, -1);
        Drawable drawable0 = v4 == -1 ? null : appCompatDrawableManager0.getDrawable(context0, v4);
        int v5 = tintTypedArray3.getResourceId(styleable.AppCompatTextView_drawableTopCompat, -1);
        Drawable drawable1 = v5 == -1 ? null : appCompatDrawableManager0.getDrawable(context0, v5);
        int v6 = tintTypedArray3.getResourceId(styleable.AppCompatTextView_drawableRightCompat, -1);
        Drawable drawable2 = v6 == -1 ? null : appCompatDrawableManager0.getDrawable(context0, v6);
        int v7 = tintTypedArray3.getResourceId(styleable.AppCompatTextView_drawableBottomCompat, -1);
        Drawable drawable3 = v7 == -1 ? null : appCompatDrawableManager0.getDrawable(context0, v7);
        int v8 = tintTypedArray3.getResourceId(styleable.AppCompatTextView_drawableStartCompat, -1);
        Drawable drawable4 = v8 == -1 ? null : appCompatDrawableManager0.getDrawable(context0, v8);
        int v9 = tintTypedArray3.getResourceId(styleable.AppCompatTextView_drawableEndCompat, -1);
        this.setCompoundDrawables(drawable0, drawable1, drawable2, drawable3, drawable4, (v9 == -1 ? null : appCompatDrawableManager0.getDrawable(context0, v9)));
        if(tintTypedArray3.hasValue(styleable.AppCompatTextView_drawableTint)) {
            ColorStateList colorStateList0 = tintTypedArray3.getColorStateList(styleable.AppCompatTextView_drawableTint);
            TextViewCompat.setCompoundDrawableTintList(this.mView, colorStateList0);
        }
        if(tintTypedArray3.hasValue(styleable.AppCompatTextView_drawableTintMode)) {
            PorterDuff.Mode porterDuff$Mode0 = DrawableUtils.parseTintMode(tintTypedArray3.getInt(styleable.AppCompatTextView_drawableTintMode, -1), null);
            TextViewCompat.setCompoundDrawableTintMode(this.mView, porterDuff$Mode0);
        }
        int v10 = tintTypedArray3.getDimensionPixelSize(styleable.AppCompatTextView_firstBaselineToTopHeight, -1);
        int v11 = tintTypedArray3.getDimensionPixelSize(styleable.AppCompatTextView_lastBaselineToBottomHeight, -1);
        int v12 = tintTypedArray3.getDimensionPixelSize(styleable.AppCompatTextView_lineHeight, -1);
        tintTypedArray3.recycle();
        if(v10 != -1) {
            TextViewCompat.setFirstBaselineToTopHeight(this.mView, v10);
        }
        if(v11 != -1) {
            TextViewCompat.setLastBaselineToBottomHeight(this.mView, v11);
        }
        if(v12 != -1) {
            TextViewCompat.setLineHeight(this.mView, v12);
        }
    }

    void onAsyncTypefaceReceived(WeakReference weakReference0, Typeface typeface0) {
        if(this.mAsyncFontPending) {
            this.mFontTypeface = typeface0;
            TextView textView0 = (TextView)weakReference0.get();
            if(textView0 != null) {
                if(ViewCompat.isAttachedToWindow(textView0)) {
                    textView0.post(new Runnable() {
                        @Override
                        public void run() {
                            textView0.setTypeface(typeface0, this.mStyle);
                        }
                    });
                    return;
                }
                textView0.setTypeface(typeface0, this.mStyle);
            }
        }
    }

    void onLayout(boolean z, int v, int v1, int v2, int v3) {
        if(!AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
            this.autoSizeText();
        }
    }

    void onSetCompoundDrawables() {
        this.applyCompoundDrawablesTints();
    }

    void onSetTextAppearance(Context context0, int v) {
        TintTypedArray tintTypedArray0 = TintTypedArray.obtainStyledAttributes(context0, v, styleable.TextAppearance);
        if(tintTypedArray0.hasValue(styleable.TextAppearance_textAllCaps)) {
            this.setAllCaps(tintTypedArray0.getBoolean(styleable.TextAppearance_textAllCaps, false));
        }
        if(tintTypedArray0.hasValue(styleable.TextAppearance_android_textSize) && tintTypedArray0.getDimensionPixelSize(styleable.TextAppearance_android_textSize, -1) == 0) {
            this.mView.setTextSize(0, 0.0f);
        }
        this.updateTypefaceAndStyle(context0, tintTypedArray0);
        if(Build.VERSION.SDK_INT >= 26 && tintTypedArray0.hasValue(styleable.TextAppearance_fontVariationSettings)) {
            String s = tintTypedArray0.getString(styleable.TextAppearance_fontVariationSettings);
            if(s != null) {
                this.mView.setFontVariationSettings(s);
            }
        }
        tintTypedArray0.recycle();
        Typeface typeface0 = this.mFontTypeface;
        if(typeface0 != null) {
            this.mView.setTypeface(typeface0, this.mStyle);
        }
    }

    void populateSurroundingTextIfNeeded(TextView textView0, InputConnection inputConnection0, EditorInfo editorInfo0) {
        if(Build.VERSION.SDK_INT < 30 && inputConnection0 != null) {
            EditorInfoCompat.setInitialSurroundingText(editorInfo0, textView0.getText());
        }
    }

    void setAllCaps(boolean z) {
        this.mView.setAllCaps(z);
    }

    void setAutoSizeTextTypeUniformWithConfiguration(int v, int v1, int v2, int v3) throws IllegalArgumentException {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithConfiguration(v, v1, v2, v3);
    }

    void setAutoSizeTextTypeUniformWithPresetSizes(int[] arr_v, int v) throws IllegalArgumentException {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithPresetSizes(arr_v, v);
    }

    void setAutoSizeTextTypeWithDefaults(int v) {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeWithDefaults(v);
    }

    void setCompoundDrawableTintList(ColorStateList colorStateList0) {
        if(this.mDrawableTint == null) {
            this.mDrawableTint = new TintInfo();
        }
        this.mDrawableTint.mTintList = colorStateList0;
        this.mDrawableTint.mHasTintList = colorStateList0 != null;
        this.setCompoundTints();
    }

    void setCompoundDrawableTintMode(PorterDuff.Mode porterDuff$Mode0) {
        if(this.mDrawableTint == null) {
            this.mDrawableTint = new TintInfo();
        }
        this.mDrawableTint.mTintMode = porterDuff$Mode0;
        this.mDrawableTint.mHasTintMode = porterDuff$Mode0 != null;
        this.setCompoundTints();
    }

    private void setCompoundDrawables(Drawable drawable0, Drawable drawable1, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5) {
        if(drawable4 != null || drawable5 != null) {
            Drawable[] arr_drawable2 = this.mView.getCompoundDrawablesRelative();
            TextView textView2 = this.mView;
            if(drawable4 == null) {
                drawable4 = arr_drawable2[0];
            }
            if(drawable1 == null) {
                drawable1 = arr_drawable2[1];
            }
            if(drawable5 == null) {
                drawable5 = arr_drawable2[2];
            }
            if(drawable3 == null) {
                drawable3 = arr_drawable2[3];
            }
            textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable4, drawable1, drawable5, drawable3);
        }
        else if(drawable0 != null || drawable1 != null || drawable2 != null || drawable3 != null) {
            Drawable[] arr_drawable = this.mView.getCompoundDrawablesRelative();
            Drawable drawable6 = arr_drawable[0];
            if(drawable6 == null && arr_drawable[2] == null) {
                Drawable[] arr_drawable1 = this.mView.getCompoundDrawables();
                TextView textView0 = this.mView;
                if(drawable0 == null) {
                    drawable0 = arr_drawable1[0];
                }
                if(drawable1 == null) {
                    drawable1 = arr_drawable1[1];
                }
                if(drawable2 == null) {
                    drawable2 = arr_drawable1[2];
                }
                if(drawable3 == null) {
                    drawable3 = arr_drawable1[3];
                }
                textView0.setCompoundDrawablesWithIntrinsicBounds(drawable0, drawable1, drawable2, drawable3);
                return;
            }
            TextView textView1 = this.mView;
            if(drawable1 == null) {
                drawable1 = arr_drawable[1];
            }
            Drawable drawable7 = arr_drawable[2];
            if(drawable3 == null) {
                drawable3 = arr_drawable[3];
            }
            textView1.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable6, drawable1, drawable7, drawable3);
        }
    }

    private void setCompoundTints() {
        this.mDrawableLeftTint = this.mDrawableTint;
        this.mDrawableTopTint = this.mDrawableTint;
        this.mDrawableRightTint = this.mDrawableTint;
        this.mDrawableBottomTint = this.mDrawableTint;
        this.mDrawableStartTint = this.mDrawableTint;
        this.mDrawableEndTint = this.mDrawableTint;
    }

    void setTextSize(int v, float f) {
        if(!AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE && !this.isAutoSizeEnabled()) {
            this.setTextSizeInternal(v, f);
        }
    }

    private void setTextSizeInternal(int v, float f) {
        this.mAutoSizeTextHelper.setTextSizeInternal(v, f);
    }

    private void updateTypefaceAndStyle(Context context0, TintTypedArray tintTypedArray0) {
        this.mStyle = tintTypedArray0.getInt(styleable.TextAppearance_android_textStyle, this.mStyle);
        boolean z = false;
        if(Build.VERSION.SDK_INT >= 28) {
            int v = tintTypedArray0.getInt(styleable.TextAppearance_android_textFontWeight, -1);
            this.mFontWeight = v;
            if(v != -1) {
                this.mStyle &= 2;
            }
        }
        if(!tintTypedArray0.hasValue(styleable.TextAppearance_android_fontFamily) && !tintTypedArray0.hasValue(styleable.TextAppearance_fontFamily)) {
            if(tintTypedArray0.hasValue(styleable.TextAppearance_android_typeface)) {
                this.mAsyncFontPending = false;
                int v1 = tintTypedArray0.getInt(styleable.TextAppearance_android_typeface, 1);
                switch(v1) {
                    case 1: {
                        this.mFontTypeface = Typeface.SANS_SERIF;
                        break;
                    }
                    case 2: {
                        this.mFontTypeface = Typeface.SERIF;
                        return;
                    label_15:
                        if(v1 == 3) {
                            this.mFontTypeface = Typeface.MONOSPACE;
                            return;
                        }
                        break;
                    }
                    default: {
                        goto label_15;
                    }
                }
            }
            return;
        }
        this.mFontTypeface = null;
        int v2 = tintTypedArray0.hasValue(styleable.TextAppearance_fontFamily) ? styleable.TextAppearance_fontFamily : styleable.TextAppearance_android_fontFamily;
        int v3 = this.mFontWeight;
        int v4 = this.mStyle;
        if(!context0.isRestricted()) {
            androidx.appcompat.widget.AppCompatTextHelper.1 appCompatTextHelper$10 = new FontCallback() {
                @Override  // androidx.core.content.res.ResourcesCompat$FontCallback
                public void onFontRetrievalFailed(int v) {
                }

                @Override  // androidx.core.content.res.ResourcesCompat$FontCallback
                public void onFontRetrieved(Typeface typeface0) {
                    if(Build.VERSION.SDK_INT >= 28) {
                        int v = v3;
                        if(v != -1) {
                            typeface0 = Typeface.create(typeface0, v, (v4 & 2) != 0);
                        }
                    }
                    AppCompatTextHelper.this.onAsyncTypefaceReceived(new WeakReference(this.mView), typeface0);
                }
            };
            try {
                Typeface typeface0 = tintTypedArray0.getFont(v2, this.mStyle, appCompatTextHelper$10);
                if(typeface0 != null) {
                    this.mFontTypeface = Build.VERSION.SDK_INT < 28 || this.mFontWeight == -1 ? typeface0 : Typeface.create(Typeface.create(typeface0, 0), this.mFontWeight, (this.mStyle & 2) != 0);
                }
                this.mAsyncFontPending = this.mFontTypeface == null;
            }
            catch(UnsupportedOperationException | Resources.NotFoundException unused_ex) {
            }
        }
        if(this.mFontTypeface == null) {
            String s = tintTypedArray0.getString(v2);
            if(s != null) {
                if(Build.VERSION.SDK_INT >= 28 && this.mFontWeight != -1) {
                    Typeface typeface1 = Typeface.create(s, 0);
                    int v5 = this.mFontWeight;
                    if((this.mStyle & 2) != 0) {
                        z = true;
                    }
                    this.mFontTypeface = Typeface.create(typeface1, v5, z);
                    return;
                }
                this.mFontTypeface = Typeface.create(s, this.mStyle);
            }
        }
    }
}

