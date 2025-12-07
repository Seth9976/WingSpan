package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout.LayoutParams;
import androidx.appcompat.R.styleable;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class LinearLayoutCompat extends ViewGroup {
    @Retention(RetentionPolicy.SOURCE)
    public @interface DividerMode {
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {
        public LayoutParams(int v, int v1) {
            super(v, v1);
        }

        public LayoutParams(int v, int v1, float f) {
            super(v, v1, f);
        }

        public LayoutParams(Context context0, AttributeSet attributeSet0) {
            super(context0, attributeSet0);
        }

        public LayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
            super(viewGroup$LayoutParams0);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0) {
            super(viewGroup$MarginLayoutParams0);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface OrientationMode {
    }

    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.appcompat.widget.LinearLayoutCompat";
    public static final int HORIZONTAL = 0;
    private static final int INDEX_BOTTOM = 2;
    private static final int INDEX_CENTER_VERTICAL = 0;
    private static final int INDEX_FILL = 3;
    private static final int INDEX_TOP = 1;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_GRAVITY_COUNT = 4;
    private boolean mBaselineAligned;
    private int mBaselineAlignedChildIndex;
    private int mBaselineChildTop;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mGravity;
    private int[] mMaxAscent;
    private int[] mMaxDescent;
    private int mOrientation;
    private int mShowDividers;
    private int mTotalLength;
    private boolean mUseLargestChild;
    private float mWeightSum;

    public LinearLayoutCompat(Context context0) {
        this(context0, null);
    }

    public LinearLayoutCompat(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public LinearLayoutCompat(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = 0x800033;
        TintTypedArray tintTypedArray0 = TintTypedArray.obtainStyledAttributes(context0, attributeSet0, styleable.LinearLayoutCompat, v, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context0, styleable.LinearLayoutCompat, attributeSet0, tintTypedArray0.getWrappedTypeArray(), v, 0);
        int v1 = tintTypedArray0.getInt(styleable.LinearLayoutCompat_android_orientation, -1);
        if(v1 >= 0) {
            this.setOrientation(v1);
        }
        int v2 = tintTypedArray0.getInt(styleable.LinearLayoutCompat_android_gravity, -1);
        if(v2 >= 0) {
            this.setGravity(v2);
        }
        if(!tintTypedArray0.getBoolean(styleable.LinearLayoutCompat_android_baselineAligned, true)) {
            this.setBaselineAligned(false);
        }
        this.mWeightSum = tintTypedArray0.getFloat(styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.mBaselineAlignedChildIndex = tintTypedArray0.getInt(styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.mUseLargestChild = tintTypedArray0.getBoolean(styleable.LinearLayoutCompat_measureWithLargestChild, false);
        this.setDividerDrawable(tintTypedArray0.getDrawable(styleable.LinearLayoutCompat_divider));
        this.mShowDividers = tintTypedArray0.getInt(styleable.LinearLayoutCompat_showDividers, 0);
        this.mDividerPadding = tintTypedArray0.getDimensionPixelSize(styleable.LinearLayoutCompat_dividerPadding, 0);
        tintTypedArray0.recycle();
    }

    @Override  // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return viewGroup$LayoutParams0 instanceof LayoutParams;
    }

    void drawDividersHorizontal(Canvas canvas0) {
        int v2;
        int v = this.getVirtualChildCount();
        boolean z = ViewUtils.isLayoutRtl(this);
        for(int v1 = 0; v1 < v; ++v1) {
            View view0 = this.getVirtualChildAt(v1);
            if(view0 != null && view0.getVisibility() != 8 && this.hasDividerBeforeChildAt(v1)) {
                LayoutParams linearLayoutCompat$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
                this.drawVerticalDivider(canvas0, (z ? view0.getRight() + linearLayoutCompat$LayoutParams0.rightMargin : view0.getLeft() - linearLayoutCompat$LayoutParams0.leftMargin - this.mDividerWidth));
            }
        }
        if(this.hasDividerBeforeChildAt(v)) {
            View view1 = this.getVirtualChildAt(v - 1);
            if(view1 != null) {
                LayoutParams linearLayoutCompat$LayoutParams1 = (LayoutParams)view1.getLayoutParams();
                v2 = z ? view1.getLeft() - linearLayoutCompat$LayoutParams1.leftMargin - this.mDividerWidth : view1.getRight() + linearLayoutCompat$LayoutParams1.rightMargin;
            }
            else if(z) {
                v2 = this.getPaddingLeft();
            }
            else {
                v2 = this.getWidth() - this.getPaddingRight() - this.mDividerWidth;
            }
            this.drawVerticalDivider(canvas0, v2);
        }
    }

    void drawDividersVertical(Canvas canvas0) {
        int v2;
        int v = this.getVirtualChildCount();
        for(int v1 = 0; v1 < v; ++v1) {
            View view0 = this.getVirtualChildAt(v1);
            if(view0 != null && view0.getVisibility() != 8 && this.hasDividerBeforeChildAt(v1)) {
                LayoutParams linearLayoutCompat$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
                this.drawHorizontalDivider(canvas0, view0.getTop() - linearLayoutCompat$LayoutParams0.topMargin - this.mDividerHeight);
            }
        }
        if(this.hasDividerBeforeChildAt(v)) {
            View view1 = this.getVirtualChildAt(v - 1);
            if(view1 == null) {
                v2 = this.getHeight() - this.getPaddingBottom() - this.mDividerHeight;
            }
            else {
                LayoutParams linearLayoutCompat$LayoutParams1 = (LayoutParams)view1.getLayoutParams();
                v2 = view1.getBottom() + linearLayoutCompat$LayoutParams1.bottomMargin;
            }
            this.drawHorizontalDivider(canvas0, v2);
        }
    }

    void drawHorizontalDivider(Canvas canvas0, int v) {
        this.mDivider.setBounds(this.getPaddingLeft() + this.mDividerPadding, v, this.getWidth() - this.getPaddingRight() - this.mDividerPadding, this.mDividerHeight + v);
        this.mDivider.draw(canvas0);
    }

    void drawVerticalDivider(Canvas canvas0, int v) {
        this.mDivider.setBounds(v, this.getPaddingTop() + this.mDividerPadding, this.mDividerWidth + v, this.getHeight() - this.getPaddingBottom() - this.mDividerPadding);
        this.mDivider.draw(canvas0);
    }

    private void forceUniformHeight(int v, int v1) {
        int v2 = View.MeasureSpec.makeMeasureSpec(this.getMeasuredHeight(), 0x40000000);
        for(int v3 = 0; v3 < v; ++v3) {
            View view0 = this.getVirtualChildAt(v3);
            if(view0.getVisibility() != 8) {
                LayoutParams linearLayoutCompat$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
                if(linearLayoutCompat$LayoutParams0.height == -1) {
                    int v4 = linearLayoutCompat$LayoutParams0.width;
                    linearLayoutCompat$LayoutParams0.width = view0.getMeasuredWidth();
                    this.measureChildWithMargins(view0, v1, 0, v2, 0);
                    linearLayoutCompat$LayoutParams0.width = v4;
                }
            }
        }
    }

    private void forceUniformWidth(int v, int v1) {
        int v2 = View.MeasureSpec.makeMeasureSpec(this.getMeasuredWidth(), 0x40000000);
        for(int v3 = 0; v3 < v; ++v3) {
            View view0 = this.getVirtualChildAt(v3);
            if(view0.getVisibility() != 8) {
                LayoutParams linearLayoutCompat$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
                if(linearLayoutCompat$LayoutParams0.width == -1) {
                    int v4 = linearLayoutCompat$LayoutParams0.height;
                    linearLayoutCompat$LayoutParams0.height = view0.getMeasuredHeight();
                    this.measureChildWithMargins(view0, v2, 0, v1, 0);
                    linearLayoutCompat$LayoutParams0.height = v4;
                }
            }
        }
    }

    @Override  // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return this.generateDefaultLayoutParams();
    }

    protected LayoutParams generateDefaultLayoutParams() {
        int v = this.mOrientation;
        if(v == 0) {
            return new LayoutParams(-2, -2);
        }
        return v == 1 ? new LayoutParams(-1, -2) : null;
    }

    @Override  // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet0) {
        return this.generateLayoutParams(attributeSet0);
    }

    @Override  // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return this.generateLayoutParams(viewGroup$LayoutParams0);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet0) {
        return new LayoutParams(this.getContext(), attributeSet0);
    }

    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return new LayoutParams(viewGroup$LayoutParams0);
    }

    @Override  // android.view.View
    public int getBaseline() {
        if(this.mBaselineAlignedChildIndex < 0) {
            return super.getBaseline();
        }
        int v = this.getChildCount();
        int v1 = this.mBaselineAlignedChildIndex;
        if(v <= v1) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View view0 = this.getChildAt(v1);
        int v2 = view0.getBaseline();
        if(v2 == -1) {
            if(this.mBaselineAlignedChildIndex != 0) {
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn\'t know how to get its baseline.");
            }
            return -1;
        }
        int v3 = this.mBaselineChildTop;
        if(this.mOrientation == 1) {
            switch(this.mGravity & 0x70) {
                case 16: {
                    v3 += (this.getBottom() - this.getTop() - this.getPaddingTop() - this.getPaddingBottom() - this.mTotalLength) / 2;
                    break;
                }
                case 80: {
                    return this.getBottom() - this.getTop() - this.getPaddingBottom() - this.mTotalLength + ((LayoutParams)view0.getLayoutParams()).topMargin + v2;
                }
                default: {
                    return v3 + ((LayoutParams)view0.getLayoutParams()).topMargin + v2;
                }
            }
        }
        return v3 + ((LayoutParams)view0.getLayoutParams()).topMargin + v2;
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    int getChildrenSkipCount(View view0, int v) [...] // Inlined contents

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    public int getGravity() {
        return this.mGravity;
    }

    int getLocationOffset(View view0) [...] // Inlined contents

    int getNextLocationOffset(View view0) [...] // Inlined contents

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    View getVirtualChildAt(int v) {
        return this.getChildAt(v);
    }

    int getVirtualChildCount() {
        return this.getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    protected boolean hasDividerBeforeChildAt(int v) {
        if(v == 0) {
            return (this.mShowDividers & 1) != 0;
        }
        if(v == this.getChildCount()) {
            return (this.mShowDividers & 4) != 0;
        }
        if((this.mShowDividers & 2) != 0) {
            for(int v1 = v - 1; v1 >= 0; --v1) {
                if(this.getChildAt(v1).getVisibility() != 8) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isBaselineAligned() {
        return this.mBaselineAligned;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    void layoutHorizontal(int v, int v1, int v2, int v3) {
        int v18;
        int v12;
        int v11;
        int v10;
        boolean z = ViewUtils.isLayoutRtl(this);
        int v4 = this.getPaddingTop();
        int v5 = v3 - v1;
        int v6 = this.getPaddingBottom();
        int v7 = this.getPaddingBottom();
        int v8 = this.getVirtualChildCount();
        int v9 = this.mGravity & 0x70;
        boolean z1 = this.mBaselineAligned;
        int[] arr_v = this.mMaxAscent;
        int[] arr_v1 = this.mMaxDescent;
        switch(GravityCompat.getAbsoluteGravity(0x800007 & this.mGravity, ViewCompat.getLayoutDirection(this))) {
            case 1: {
                v10 = this.getPaddingLeft() + (v2 - v - this.mTotalLength) / 2;
                break;
            }
            case 5: {
                v10 = this.getPaddingLeft() + v2 - v - this.mTotalLength;
                break;
            }
            default: {
                v10 = this.getPaddingLeft();
            }
        }
        if(z) {
            v11 = v8 - 1;
            v12 = -1;
        }
        else {
            v11 = 0;
            v12 = 1;
        }
        for(int v13 = 0; v13 < v8; ++v13) {
            int v14 = v11 + v12 * v13;
            View view0 = this.getVirtualChildAt(v14);
            if(view0 != null && view0.getVisibility() != 8) {
                int v15 = view0.getMeasuredWidth();
                int v16 = view0.getMeasuredHeight();
                LayoutParams linearLayoutCompat$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
                int v17 = !z1 || linearLayoutCompat$LayoutParams0.height == -1 ? -1 : view0.getBaseline();
                switch((linearLayoutCompat$LayoutParams0.gravity >= 0 ? linearLayoutCompat$LayoutParams0.gravity : v9) & 0x70) {
                    case 16: {
                        v18 = (v5 - v4 - v7 - v16) / 2 + v4 + linearLayoutCompat$LayoutParams0.topMargin - linearLayoutCompat$LayoutParams0.bottomMargin;
                        break;
                    }
                    case 0x30: {
                        v18 = linearLayoutCompat$LayoutParams0.topMargin + v4;
                        if(v17 != -1) {
                            v18 += arr_v[1] - v17;
                        }
                        break;
                    }
                    case 80: {
                        v18 = v5 - v6 - v16 - linearLayoutCompat$LayoutParams0.bottomMargin;
                        if(v17 != -1) {
                            int v19 = view0.getMeasuredHeight();
                            v18 -= arr_v1[2] - (v19 - v17);
                        }
                        break;
                    }
                    default: {
                        v18 = v4;
                    }
                }
                if(this.hasDividerBeforeChildAt(v14)) {
                    v10 += this.mDividerWidth;
                }
                int v20 = linearLayoutCompat$LayoutParams0.leftMargin + v10;
                this.setChildFrame(view0, v20, v18, v15, v16);
                v10 = v20 + (v15 + linearLayoutCompat$LayoutParams0.rightMargin);
            }
        }
    }

    void layoutVertical(int v, int v1, int v2, int v3) {
        int v14;
        int v10;
        int v4 = this.getPaddingLeft();
        int v5 = v2 - v;
        int v6 = this.getPaddingRight();
        int v7 = this.getPaddingRight();
        int v8 = this.getVirtualChildCount();
        int v9 = this.mGravity & 0x800007;
        switch(this.mGravity & 0x70) {
            case 16: {
                v10 = this.getPaddingTop() + (v3 - v1 - this.mTotalLength) / 2;
                break;
            }
            case 80: {
                v10 = this.getPaddingTop() + v3 - v1 - this.mTotalLength;
                break;
            }
            default: {
                v10 = this.getPaddingTop();
            }
        }
        for(int v11 = 0; v11 < v8; ++v11) {
            View view0 = this.getVirtualChildAt(v11);
            if(view0 != null && view0.getVisibility() != 8) {
                int v12 = view0.getMeasuredWidth();
                int v13 = view0.getMeasuredHeight();
                LayoutParams linearLayoutCompat$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
                switch(GravityCompat.getAbsoluteGravity((linearLayoutCompat$LayoutParams0.gravity >= 0 ? linearLayoutCompat$LayoutParams0.gravity : v9), ViewCompat.getLayoutDirection(this)) & 7) {
                    case 1: {
                        v14 = (v5 - v4 - v7 - v12) / 2 + v4 + linearLayoutCompat$LayoutParams0.leftMargin - linearLayoutCompat$LayoutParams0.rightMargin;
                        break;
                    }
                    case 5: {
                        v14 = v5 - v6 - v12 - linearLayoutCompat$LayoutParams0.rightMargin;
                        break;
                    }
                    default: {
                        v14 = linearLayoutCompat$LayoutParams0.leftMargin + v4;
                    }
                }
                if(this.hasDividerBeforeChildAt(v11)) {
                    v10 += this.mDividerHeight;
                }
                int v15 = v10 + linearLayoutCompat$LayoutParams0.topMargin;
                this.setChildFrame(view0, v14, v15, v12, v13);
                v10 = v15 + (v13 + linearLayoutCompat$LayoutParams0.bottomMargin);
            }
        }
    }

    void measureChildBeforeLayout(View view0, int v, int v1, int v2, int v3, int v4) {
        this.measureChildWithMargins(view0, v1, v2, v3, v4);
    }

    void measureHorizontal(int v, int v1) {
        int v31;
        int v30;
        int v28;
        float f4;
        int v41;
        int v38;
        int v24;
        int v22;
        int v21;
        int v19;
        boolean z6;
        View view1;
        boolean z5;
        boolean z4;
        int v12;
        int v13;
        this.mTotalLength = 0;
        int v2 = this.getVirtualChildCount();
        int v3 = View.MeasureSpec.getMode(v);
        int v4 = View.MeasureSpec.getMode(v1);
        if(this.mMaxAscent == null || this.mMaxDescent == null) {
            this.mMaxAscent = new int[4];
            this.mMaxDescent = new int[4];
        }
        int[] arr_v = this.mMaxAscent;
        int[] arr_v1 = this.mMaxDescent;
        arr_v[3] = -1;
        arr_v[2] = -1;
        arr_v[1] = -1;
        arr_v[0] = -1;
        arr_v1[3] = -1;
        arr_v1[2] = -1;
        arr_v1[1] = -1;
        arr_v1[0] = -1;
        boolean z = this.mBaselineAligned;
        boolean z1 = this.mUseLargestChild;
        int v5 = 0;
        int v6 = 0;
        int v7 = 0;
        int v8 = 0;
        int v9 = 0;
        boolean z2 = false;
        int v10 = 0;
        boolean z3 = false;
        int v11 = 1;
        float f = 0.0f;
        while(v5 < v2) {
            View view0 = this.getVirtualChildAt(v5);
            if(view0 == null) {
                this.mTotalLength = this.mTotalLength;
            }
            else if(view0.getVisibility() != 8) {
                if(this.hasDividerBeforeChildAt(v5)) {
                    this.mTotalLength += this.mDividerWidth;
                }
                LayoutParams linearLayoutCompat$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
                float f1 = f + linearLayoutCompat$LayoutParams0.weight;
                if(v3 != 0x40000000 || linearLayoutCompat$LayoutParams0.width != 0 || linearLayoutCompat$LayoutParams0.weight <= 0.0f) {
                    if(linearLayoutCompat$LayoutParams0.width != 0 || linearLayoutCompat$LayoutParams0.weight <= 0.0f) {
                        v13 = 0x80000000;
                    }
                    else {
                        linearLayoutCompat$LayoutParams0.width = -2;
                        v13 = 0;
                    }
                    v12 = v5;
                    z4 = z1;
                    z5 = z;
                    this.measureChildBeforeLayout(view0, v12, v, (f1 == 0.0f ? this.mTotalLength : 0), v1, 0);
                    if(v13 != 0x80000000) {
                        linearLayoutCompat$LayoutParams0.width = v13;
                    }
                    int v14 = view0.getMeasuredWidth();
                    if(v3 == 0x40000000) {
                        view1 = view0;
                        this.mTotalLength += linearLayoutCompat$LayoutParams0.leftMargin + v14 + linearLayoutCompat$LayoutParams0.rightMargin;
                    }
                    else {
                        view1 = view0;
                        this.mTotalLength = Math.max(this.mTotalLength, this.mTotalLength + v14 + linearLayoutCompat$LayoutParams0.leftMargin + linearLayoutCompat$LayoutParams0.rightMargin);
                    }
                    if(z4) {
                        v6 = Math.max(v14, v6);
                    }
                }
                else {
                    if(v3 == 0x40000000) {
                        this.mTotalLength += linearLayoutCompat$LayoutParams0.leftMargin + linearLayoutCompat$LayoutParams0.rightMargin;
                    }
                    else {
                        this.mTotalLength = Math.max(this.mTotalLength, linearLayoutCompat$LayoutParams0.leftMargin + this.mTotalLength + linearLayoutCompat$LayoutParams0.rightMargin);
                    }
                    if(z) {
                        view0.measure(0, 0);
                        v12 = v5;
                        z4 = z1;
                        z5 = true;
                        view1 = view0;
                    }
                    else {
                        v12 = v5;
                        z4 = z1;
                        z5 = false;
                        view1 = view0;
                        z2 = true;
                    }
                }
                if(v4 == 0x40000000 || linearLayoutCompat$LayoutParams0.height != -1) {
                    z6 = false;
                }
                else {
                    z6 = true;
                    z3 = true;
                }
                int v15 = linearLayoutCompat$LayoutParams0.topMargin + linearLayoutCompat$LayoutParams0.bottomMargin;
                int v16 = view1.getMeasuredHeight() + v15;
                v10 = View.combineMeasuredStates(v10, view1.getMeasuredState());
                if(z5) {
                    int v17 = view1.getBaseline();
                    if(v17 != -1) {
                        int v18 = (((linearLayoutCompat$LayoutParams0.gravity >= 0 ? linearLayoutCompat$LayoutParams0.gravity : this.mGravity) & 0x70) >> 4 & -2) >> 1;
                        arr_v[v18] = Math.max(arr_v[v18], v17);
                        arr_v1[v18] = Math.max(arr_v1[v18], v16 - v17);
                    }
                }
                v7 = Math.max(v7, v16);
                v11 = v11 == 0 || linearLayoutCompat$LayoutParams0.height != -1 ? 0 : 1;
                if(linearLayoutCompat$LayoutParams0.weight > 0.0f) {
                    if(!z6) {
                        v15 = v16;
                    }
                    v9 = Math.max(v9, v15);
                }
                else {
                    if(!z6) {
                        v15 = v16;
                    }
                    v8 = Math.max(v8, v15);
                }
                v19 = v12;
                f = f1;
                goto label_107;
            }
            z4 = z1;
            z5 = z;
            v19 = v5;
        label_107:
            z1 = z4;
            z = z5;
            v5 = v19 + 1;
        }
        if(this.mTotalLength > 0 && this.hasDividerBeforeChildAt(v2)) {
            this.mTotalLength += this.mDividerWidth;
        }
        int v20 = arr_v[1];
        if(v20 != -1 || arr_v[0] != -1 || arr_v[2] != -1 || arr_v[3] != -1) {
            v22 = v10;
            v21 = Math.max(v7, Math.max(arr_v[3], Math.max(arr_v[0], Math.max(v20, arr_v[2]))) + Math.max(arr_v1[3], Math.max(arr_v1[0], Math.max(arr_v1[1], arr_v1[2]))));
        }
        else {
            v21 = v7;
            v22 = v10;
        }
        if(z1 && (v3 == 0x80000000 || v3 == 0)) {
            this.mTotalLength = 0;
            int v23 = 0;
            while(v23 < v2) {
                View view2 = this.getVirtualChildAt(v23);
                if(view2 == null) {
                    this.mTotalLength = this.mTotalLength;
                }
                else if(view2.getVisibility() != 8) {
                    LayoutParams linearLayoutCompat$LayoutParams1 = (LayoutParams)view2.getLayoutParams();
                    if(v3 == 0x40000000) {
                        this.mTotalLength += linearLayoutCompat$LayoutParams1.leftMargin + v6 + linearLayoutCompat$LayoutParams1.rightMargin;
                        v24 = v21;
                    }
                    else {
                        v24 = v21;
                        this.mTotalLength = Math.max(this.mTotalLength, this.mTotalLength + v6 + linearLayoutCompat$LayoutParams1.leftMargin + linearLayoutCompat$LayoutParams1.rightMargin);
                    }
                    goto label_138;
                }
                v24 = v21;
            label_138:
                ++v23;
                v21 = v24;
            }
        }
        int v25 = this.mTotalLength + (this.getPaddingLeft() + this.getPaddingRight());
        this.mTotalLength = v25;
        int v26 = View.resolveSizeAndState(Math.max(v25, this.getSuggestedMinimumWidth()), v, 0);
        int v27 = (0xFFFFFF & v26) - this.mTotalLength;
        if(z2 || v27 != 0 && f > 0.0f) {
            float f2 = this.mWeightSum;
            if(f2 > 0.0f) {
                f = f2;
            }
            arr_v[3] = -1;
            arr_v[2] = -1;
            arr_v[1] = -1;
            arr_v[0] = -1;
            arr_v1[3] = -1;
            arr_v1[2] = -1;
            arr_v1[1] = -1;
            arr_v1[0] = -1;
            this.mTotalLength = 0;
            int v32 = v8;
            int v33 = -1;
            int v34 = v22;
            int v35 = 0;
            while(v35 < v2) {
                View view4 = this.getVirtualChildAt(v35);
                if(view4 == null || view4.getVisibility() == 8) {
                    v41 = v27;
                    v38 = v2;
                }
                else {
                    LayoutParams linearLayoutCompat$LayoutParams2 = (LayoutParams)view4.getLayoutParams();
                    float f3 = linearLayoutCompat$LayoutParams2.weight;
                    if(f3 > 0.0f) {
                        int v36 = (int)(((float)v27) * f3 / f);
                        int v37 = v27 - v36;
                        v38 = v2;
                        int v39 = LinearLayoutCompat.getChildMeasureSpec(v1, this.getPaddingTop() + this.getPaddingBottom() + linearLayoutCompat$LayoutParams2.topMargin + linearLayoutCompat$LayoutParams2.bottomMargin, linearLayoutCompat$LayoutParams2.height);
                        if(linearLayoutCompat$LayoutParams2.width != 0 || v3 != 0x40000000) {
                            int v40 = view4.getMeasuredWidth() + v36;
                            if(v40 < 0) {
                                v40 = 0;
                            }
                            view4.measure(View.MeasureSpec.makeMeasureSpec(v40, 0x40000000), v39);
                        }
                        else {
                            if(v36 <= 0) {
                                v36 = 0;
                            }
                            view4.measure(View.MeasureSpec.makeMeasureSpec(v36, 0x40000000), v39);
                        }
                        v34 = View.combineMeasuredStates(v34, view4.getMeasuredState() & 0xFF000000);
                        f -= f3;
                        v41 = v37;
                    }
                    else {
                        v41 = v27;
                        v38 = v2;
                    }
                    if(v3 == 0x40000000) {
                        this.mTotalLength += view4.getMeasuredWidth() + linearLayoutCompat$LayoutParams2.leftMargin + linearLayoutCompat$LayoutParams2.rightMargin;
                        f4 = f;
                    }
                    else {
                        int v42 = this.mTotalLength;
                        f4 = f;
                        this.mTotalLength = Math.max(v42, view4.getMeasuredWidth() + v42 + linearLayoutCompat$LayoutParams2.leftMargin + linearLayoutCompat$LayoutParams2.rightMargin);
                    }
                    boolean z7 = v4 != 0x40000000 && linearLayoutCompat$LayoutParams2.height == -1;
                    int v43 = linearLayoutCompat$LayoutParams2.topMargin + linearLayoutCompat$LayoutParams2.bottomMargin;
                    int v44 = view4.getMeasuredHeight() + v43;
                    v33 = Math.max(v33, v44);
                    if(!z7) {
                        v43 = v44;
                    }
                    int v45 = Math.max(v32, v43);
                    int v46 = v11 == 0 || linearLayoutCompat$LayoutParams2.height != -1 ? 0 : 1;
                    if(z) {
                        int v47 = view4.getBaseline();
                        if(v47 != -1) {
                            int v48 = (((linearLayoutCompat$LayoutParams2.gravity >= 0 ? linearLayoutCompat$LayoutParams2.gravity : this.mGravity) & 0x70) >> 4 & -2) >> 1;
                            arr_v[v48] = Math.max(arr_v[v48], v47);
                            arr_v1[v48] = Math.max(arr_v1[v48], v44 - v47);
                        }
                    }
                    v11 = v46;
                    v32 = v45;
                    f = f4;
                }
                ++v35;
                v27 = v41;
                v2 = v38;
            }
            v30 = v2;
            this.mTotalLength += this.getPaddingLeft() + this.getPaddingRight();
            int v49 = arr_v[1];
            v31 = v49 != -1 || arr_v[0] != -1 || arr_v[2] != -1 || arr_v[3] != -1 ? Math.max(v33, Math.max(arr_v[3], Math.max(arr_v[0], Math.max(v49, arr_v[2]))) + Math.max(arr_v1[3], Math.max(arr_v1[0], Math.max(arr_v1[1], arr_v1[2])))) : v33;
            v28 = v32;
            v22 = v34;
        }
        else {
            v28 = Math.max(v8, v9);
            if(z1 && v3 != 0x40000000) {
                for(int v29 = 0; v29 < v2; ++v29) {
                    View view3 = this.getVirtualChildAt(v29);
                    if(view3 != null && view3.getVisibility() != 8 && ((LayoutParams)view3.getLayoutParams()).weight > 0.0f) {
                        view3.measure(View.MeasureSpec.makeMeasureSpec(v6, 0x40000000), View.MeasureSpec.makeMeasureSpec(view3.getMeasuredHeight(), 0x40000000));
                    }
                }
            }
            v30 = v2;
            v31 = v21;
        }
        if(v11 != 0 || v4 == 0x40000000) {
            v28 = v31;
        }
        this.setMeasuredDimension(v26 | v22 & 0xFF000000, View.resolveSizeAndState(Math.max(v28 + (this.getPaddingTop() + this.getPaddingBottom()), this.getSuggestedMinimumHeight()), v1, v22 << 16));
        if(z3) {
            this.forceUniformHeight(v30, v);
        }
    }

    int measureNullChild(int v) [...] // Inlined contents

    void measureVertical(int v, int v1) {
        int v35;
        int v33;
        boolean z4;
        int v45;
        int v39;
        int v28;
        int v26;
        boolean z3;
        int v19;
        int v18;
        int v17;
        int v16;
        int v15;
        View view1;
        int v14;
        int v20;
        int v13;
        this.mTotalLength = 0;
        int v2 = this.getVirtualChildCount();
        int v3 = View.MeasureSpec.getMode(v);
        int v4 = View.MeasureSpec.getMode(v1);
        int v5 = this.mBaselineAlignedChildIndex;
        boolean z = this.mUseLargestChild;
        int v6 = 0;
        int v7 = 0;
        int v8 = 0;
        int v9 = 0;
        int v10 = 0;
        int v11 = 0;
        boolean z1 = false;
        boolean z2 = false;
        int v12 = 1;
        float f = 0.0f;
        while(v11 < v2) {
            View view0 = this.getVirtualChildAt(v11);
            if(view0 == null) {
                this.mTotalLength = this.mTotalLength;
                v13 = v2;
            }
            else if(view0.getVisibility() == 8) {
                v13 = v2;
            }
            else {
                if(this.hasDividerBeforeChildAt(v11)) {
                    this.mTotalLength += this.mDividerHeight;
                }
                LayoutParams linearLayoutCompat$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
                float f1 = f + linearLayoutCompat$LayoutParams0.weight;
                if(v4 != 0x40000000 || linearLayoutCompat$LayoutParams0.height != 0 || linearLayoutCompat$LayoutParams0.weight <= 0.0f) {
                    if(linearLayoutCompat$LayoutParams0.height != 0 || linearLayoutCompat$LayoutParams0.weight <= 0.0f) {
                        v20 = 0x80000000;
                    }
                    else {
                        linearLayoutCompat$LayoutParams0.height = -2;
                        v20 = 0;
                    }
                    v16 = v6;
                    v17 = v7;
                    v19 = v9;
                    v13 = v2;
                    v15 = v10;
                    v18 = v11;
                    this.measureChildBeforeLayout(view0, v11, v, 0, v1, (f1 == 0.0f ? this.mTotalLength : 0));
                    if(v20 != 0x80000000) {
                        linearLayoutCompat$LayoutParams0.height = v20;
                    }
                    int v21 = view0.getMeasuredHeight();
                    view1 = view0;
                    this.mTotalLength = Math.max(this.mTotalLength, this.mTotalLength + v21 + linearLayoutCompat$LayoutParams0.topMargin + linearLayoutCompat$LayoutParams0.bottomMargin);
                    v14 = z ? Math.max(v21, v8) : v8;
                }
                else {
                    this.mTotalLength = Math.max(this.mTotalLength, linearLayoutCompat$LayoutParams0.topMargin + this.mTotalLength + linearLayoutCompat$LayoutParams0.bottomMargin);
                    v14 = v8;
                    view1 = view0;
                    v15 = v10;
                    v13 = v2;
                    z1 = true;
                    v16 = v6;
                    v17 = v7;
                    v18 = v11;
                    v19 = v9;
                }
                if(v5 >= 0 && v5 == v18 + 1) {
                    this.mBaselineChildTop = this.mTotalLength;
                }
                if(v18 < v5 && linearLayoutCompat$LayoutParams0.weight > 0.0f) {
                    throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won\'t work.  Either remove the weight, or don\'t set mBaselineAlignedChildIndex.");
                }
                if(v3 == 0x40000000 || linearLayoutCompat$LayoutParams0.width != -1) {
                    z3 = false;
                }
                else {
                    z3 = true;
                    z2 = true;
                }
                int v22 = linearLayoutCompat$LayoutParams0.leftMargin + linearLayoutCompat$LayoutParams0.rightMargin;
                int v23 = view1.getMeasuredWidth() + v22;
                int v24 = Math.max(v17, v23);
                int v25 = View.combineMeasuredStates(v16, view1.getMeasuredState());
                v12 = v12 == 0 || linearLayoutCompat$LayoutParams0.width != -1 ? 0 : 1;
                if(linearLayoutCompat$LayoutParams0.weight > 0.0f) {
                    if(!z3) {
                        v22 = v23;
                    }
                    v9 = Math.max(v19, v22);
                    v26 = v15;
                }
                else {
                    if(!z3) {
                        v22 = v23;
                    }
                    v26 = Math.max(v15, v22);
                    v9 = v19;
                }
                v8 = v14;
                f = f1;
                v10 = v26;
                v6 = v25;
                v11 = v18;
                v7 = v24;
            }
            ++v11;
            v2 = v13;
        }
        int v27 = v7;
        if(this.mTotalLength > 0) {
            v28 = v2;
            if(this.hasDividerBeforeChildAt(v28)) {
                this.mTotalLength += this.mDividerHeight;
            }
        }
        else {
            v28 = v2;
        }
        if(z && (v4 == 0x80000000 || v4 == 0)) {
            this.mTotalLength = 0;
            for(int v29 = 0; v29 < v28; ++v29) {
                View view2 = this.getVirtualChildAt(v29);
                if(view2 == null) {
                    this.mTotalLength = this.mTotalLength;
                }
                else if(view2.getVisibility() != 8) {
                    LayoutParams linearLayoutCompat$LayoutParams1 = (LayoutParams)view2.getLayoutParams();
                    this.mTotalLength = Math.max(this.mTotalLength, this.mTotalLength + v8 + linearLayoutCompat$LayoutParams1.topMargin + linearLayoutCompat$LayoutParams1.bottomMargin);
                }
            }
        }
        int v30 = this.mTotalLength + (this.getPaddingTop() + this.getPaddingBottom());
        this.mTotalLength = v30;
        int v31 = View.resolveSizeAndState(Math.max(v30, this.getSuggestedMinimumHeight()), v1, 0);
        int v32 = (0xFFFFFF & v31) - this.mTotalLength;
        if(z1 || v32 != 0 && f > 0.0f) {
            float f2 = this.mWeightSum;
            if(f2 > 0.0f) {
                f = f2;
            }
            this.mTotalLength = 0;
            int v36 = v32;
            int v37 = v10;
            v35 = v6;
            int v38 = 0;
            while(v38 < v28) {
                View view4 = this.getVirtualChildAt(v38);
                if(view4.getVisibility() == 8) {
                    v39 = v36;
                }
                else {
                    LayoutParams linearLayoutCompat$LayoutParams2 = (LayoutParams)view4.getLayoutParams();
                    float f3 = linearLayoutCompat$LayoutParams2.weight;
                    if(f3 > 0.0f) {
                        int v40 = (int)(((float)v36) * f3 / f);
                        v39 = v36 - v40;
                        int v41 = LinearLayoutCompat.getChildMeasureSpec(v, this.getPaddingLeft() + this.getPaddingRight() + linearLayoutCompat$LayoutParams2.leftMargin + linearLayoutCompat$LayoutParams2.rightMargin, linearLayoutCompat$LayoutParams2.width);
                        if(linearLayoutCompat$LayoutParams2.height != 0 || v4 != 0x40000000) {
                            int v42 = view4.getMeasuredHeight() + v40;
                            if(v42 < 0) {
                                v42 = 0;
                            }
                            view4.measure(v41, View.MeasureSpec.makeMeasureSpec(v42, 0x40000000));
                        }
                        else {
                            if(v40 <= 0) {
                                v40 = 0;
                            }
                            view4.measure(v41, View.MeasureSpec.makeMeasureSpec(v40, 0x40000000));
                        }
                        v35 = View.combineMeasuredStates(v35, view4.getMeasuredState() & 0xFFFFFF00);
                        f -= f3;
                    }
                    else {
                        v39 = v36;
                    }
                    int v43 = linearLayoutCompat$LayoutParams2.leftMargin + linearLayoutCompat$LayoutParams2.rightMargin;
                    int v44 = view4.getMeasuredWidth() + v43;
                    v27 = Math.max(v27, v44);
                    if(v3 == 0x40000000) {
                        v45 = v35;
                    }
                    else {
                        v45 = v35;
                        if(linearLayoutCompat$LayoutParams2.width == -1) {
                            z4 = true;
                            goto label_170;
                        }
                    }
                    z4 = false;
                label_170:
                    if(!z4) {
                        v43 = v44;
                    }
                    int v46 = v12 == 0 || linearLayoutCompat$LayoutParams2.width != -1 ? 0 : 1;
                    int v47 = this.mTotalLength;
                    this.mTotalLength = Math.max(v47, view4.getMeasuredHeight() + v47 + linearLayoutCompat$LayoutParams2.topMargin + linearLayoutCompat$LayoutParams2.bottomMargin);
                    v12 = v46;
                    v35 = v45;
                    v37 = Math.max(v37, v43);
                }
                ++v38;
                v36 = v39;
            }
            this.mTotalLength += this.getPaddingTop() + this.getPaddingBottom();
            v33 = v37;
        }
        else {
            v33 = Math.max(v10, v9);
            if(z && v4 != 0x40000000) {
                for(int v34 = 0; v34 < v28; ++v34) {
                    View view3 = this.getVirtualChildAt(v34);
                    if(view3 != null && view3.getVisibility() != 8 && ((LayoutParams)view3.getLayoutParams()).weight > 0.0f) {
                        view3.measure(View.MeasureSpec.makeMeasureSpec(view3.getMeasuredWidth(), 0x40000000), View.MeasureSpec.makeMeasureSpec(v8, 0x40000000));
                    }
                }
            }
            v35 = v6;
        }
        if(v12 != 0 || v3 == 0x40000000) {
            v33 = v27;
        }
        this.setMeasuredDimension(View.resolveSizeAndState(Math.max(v33 + (this.getPaddingLeft() + this.getPaddingRight()), this.getSuggestedMinimumWidth()), v, v35), v31);
        if(z2) {
            this.forceUniformWidth(v28, v1);
        }
    }

    @Override  // android.view.View
    protected void onDraw(Canvas canvas0) {
        if(this.mDivider == null) {
            return;
        }
        if(this.mOrientation == 1) {
            this.drawDividersVertical(canvas0);
            return;
        }
        this.drawDividersHorizontal(canvas0);
    }

    @Override  // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent0) {
        super.onInitializeAccessibilityEvent(accessibilityEvent0);
        accessibilityEvent0.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override  // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo0) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo0);
        accessibilityNodeInfo0.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override  // android.view.ViewGroup
    protected void onLayout(boolean z, int v, int v1, int v2, int v3) {
        if(this.mOrientation == 1) {
            this.layoutVertical(v, v1, v2, v3);
            return;
        }
        this.layoutHorizontal(v, v1, v2, v3);
    }

    @Override  // android.view.View
    protected void onMeasure(int v, int v1) {
        if(this.mOrientation == 1) {
            this.measureVertical(v, v1);
            return;
        }
        this.measureHorizontal(v, v1);
    }

    public void setBaselineAligned(boolean z) {
        this.mBaselineAligned = z;
    }

    public void setBaselineAlignedChildIndex(int v) {
        if(v < 0 || v >= this.getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + this.getChildCount() + ")");
        }
        this.mBaselineAlignedChildIndex = v;
    }

    private void setChildFrame(View view0, int v, int v1, int v2, int v3) {
        view0.layout(v, v1, v2 + v, v3 + v1);
    }

    public void setDividerDrawable(Drawable drawable0) {
        if(drawable0 == this.mDivider) {
            return;
        }
        this.mDivider = drawable0;
        boolean z = false;
        if(drawable0 == null) {
            this.mDividerWidth = 0;
            this.mDividerHeight = 0;
        }
        else {
            this.mDividerWidth = drawable0.getIntrinsicWidth();
            this.mDividerHeight = drawable0.getIntrinsicHeight();
        }
        if(drawable0 == null) {
            z = true;
        }
        this.setWillNotDraw(z);
        this.requestLayout();
    }

    public void setDividerPadding(int v) {
        this.mDividerPadding = v;
    }

    public void setGravity(int v) {
        if(this.mGravity != v) {
            if((0x800007 & v) == 0) {
                v |= 0x800003;
            }
            if((v & 0x70) == 0) {
                v |= 0x30;
            }
            this.mGravity = v;
            this.requestLayout();
        }
    }

    public void setHorizontalGravity(int v) {
        int v1 = this.mGravity;
        if((0x800007 & v1) != (v & 0x800007)) {
            this.mGravity = v & 0x800007 | 0xFF7FFFF8 & v1;
            this.requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.mUseLargestChild = z;
    }

    public void setOrientation(int v) {
        if(this.mOrientation != v) {
            this.mOrientation = v;
            this.requestLayout();
        }
    }

    public void setShowDividers(int v) {
        if(v != this.mShowDividers) {
            this.requestLayout();
        }
        this.mShowDividers = v;
    }

    public void setVerticalGravity(int v) {
        int v1 = this.mGravity;
        if((v1 & 0x70) != (v & 0x70)) {
            this.mGravity = v & 0x70 | v1 & 0xFFFFFF8F;
            this.requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.mWeightSum = Math.max(0.0f, f);
    }

    @Override  // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}

