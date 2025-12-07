package androidx.browser.browseractions;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import androidx.browser.R.dimen;

@Deprecated
public class BrowserActionsFallbackMenuView extends LinearLayout {
    private final int mBrowserActionsMenuMaxWidthPx;
    private final int mBrowserActionsMenuMinPaddingPx;

    public BrowserActionsFallbackMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mBrowserActionsMenuMinPaddingPx = this.getResources().getDimensionPixelOffset(dimen.browser_actions_context_menu_min_padding);
        this.mBrowserActionsMenuMaxWidthPx = this.getResources().getDimensionPixelOffset(dimen.browser_actions_context_menu_max_width);
    }

    @Override  // android.widget.LinearLayout
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min(this.getResources().getDisplayMetrics().widthPixels - this.mBrowserActionsMenuMinPaddingPx * 2, this.mBrowserActionsMenuMaxWidthPx), 0x40000000), heightMeasureSpec);
    }
}

