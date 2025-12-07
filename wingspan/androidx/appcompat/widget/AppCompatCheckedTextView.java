package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.widget.TextViewCompat;

public class AppCompatCheckedTextView extends CheckedTextView {
    private static final int[] TINT_ATTRS;
    private final AppCompatTextHelper mTextHelper;

    static {
        AppCompatCheckedTextView.TINT_ATTRS = new int[]{0x1010108};
    }

    public AppCompatCheckedTextView(Context context0) {
        this(context0, null);
    }

    public AppCompatCheckedTextView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x10103C8);
    }

    public AppCompatCheckedTextView(Context context0, AttributeSet attributeSet0, int v) {
        super(TintContextWrapper.wrap(context0), attributeSet0, v);
        ThemeUtils.checkAppCompatTheme(this, this.getContext());
        AppCompatTextHelper appCompatTextHelper0 = new AppCompatTextHelper(this);
        this.mTextHelper = appCompatTextHelper0;
        appCompatTextHelper0.loadFromAttributes(attributeSet0, v);
        appCompatTextHelper0.applyCompoundDrawablesTints();
        TintTypedArray tintTypedArray0 = TintTypedArray.obtainStyledAttributes(this.getContext(), attributeSet0, AppCompatCheckedTextView.TINT_ATTRS, v, 0);
        this.setCheckMarkDrawable(tintTypedArray0.getDrawable(0));
        tintTypedArray0.recycle();
    }

    @Override  // android.widget.CheckedTextView
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatTextHelper appCompatTextHelper0 = this.mTextHelper;
        if(appCompatTextHelper0 != null) {
            appCompatTextHelper0.applyCompoundDrawablesTints();
        }
    }

    @Override  // android.widget.TextView
    public InputConnection onCreateInputConnection(EditorInfo editorInfo0) {
        return AppCompatHintHelper.onCreateInputConnection(super.onCreateInputConnection(editorInfo0), editorInfo0, this);
    }

    @Override  // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int v) {
        this.setCheckMarkDrawable(AppCompatResources.getDrawable(this.getContext(), v));
    }

    @Override  // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback actionMode$Callback0) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, actionMode$Callback0));
    }

    @Override  // android.widget.TextView
    public void setTextAppearance(Context context0, int v) {
        super.setTextAppearance(context0, v);
        AppCompatTextHelper appCompatTextHelper0 = this.mTextHelper;
        if(appCompatTextHelper0 != null) {
            appCompatTextHelper0.onSetTextAppearance(context0, v);
        }
    }
}

