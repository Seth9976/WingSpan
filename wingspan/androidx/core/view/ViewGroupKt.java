package androidx.core.view;

import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010)\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001A\u0015\u0010\n\u001A\u00020\u000B*\u00020\u00032\u0006\u0010\f\u001A\u00020\u0002H\u0086\n\u001A0\u0010\r\u001A\u00020\u000E*\u00020\u00032!\u0010\u000F\u001A\u001D\u0012\u0013\u0012\u00110\u0002\u00A2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000E0\u0010H\u0086\b\u001AE\u0010\u0013\u001A\u00020\u000E*\u00020\u000326\u0010\u000F\u001A2\u0012\u0013\u0012\u00110\u0007\u00A2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0002\u00A2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000E0\u0014H\u0086\b\u001A\u0015\u0010\u0016\u001A\u00020\u0002*\u00020\u00032\u0006\u0010\u0015\u001A\u00020\u0007H\u0086\u0002\u001A\r\u0010\u0017\u001A\u00020\u000B*\u00020\u0003H\u0086\b\u001A\r\u0010\u0018\u001A\u00020\u000B*\u00020\u0003H\u0086\b\u001A\u0013\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00020\u001A*\u00020\u0003H\u0086\u0002\u001A\u0015\u0010\u001B\u001A\u00020\u000E*\u00020\u00032\u0006\u0010\f\u001A\u00020\u0002H\u0086\n\u001A\u0015\u0010\u001C\u001A\u00020\u000E*\u00020\u00032\u0006\u0010\f\u001A\u00020\u0002H\u0086\n\u001A\u0017\u0010\u001D\u001A\u00020\u000E*\u00020\u001E2\b\b\u0001\u0010\u0006\u001A\u00020\u0007H\u0086\b\u001A5\u0010\u001F\u001A\u00020\u000E*\u00020\u001E2\b\b\u0003\u0010 \u001A\u00020\u00072\b\b\u0003\u0010!\u001A\u00020\u00072\b\b\u0003\u0010\"\u001A\u00020\u00072\b\b\u0003\u0010#\u001A\u00020\u0007H\u0086\b\u001A5\u0010$\u001A\u00020\u000E*\u00020\u001E2\b\b\u0003\u0010%\u001A\u00020\u00072\b\b\u0003\u0010!\u001A\u00020\u00072\b\b\u0003\u0010&\u001A\u00020\u00072\b\b\u0003\u0010#\u001A\u00020\u0007H\u0087\b\"\u001B\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F\u00A2\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0006\u001A\u00020\u0007*\u00020\u00038\u00C6\u0002\u00A2\u0006\u0006\u001A\u0004\b\b\u0010\t\u00A8\u0006\'"}, d2 = {"children", "Lkotlin/sequences/Sequence;", "Landroid/view/View;", "Landroid/view/ViewGroup;", "getChildren", "(Landroid/view/ViewGroup;)Lkotlin/sequences/Sequence;", "size", "", "getSize", "(Landroid/view/ViewGroup;)I", "contains", "", "view", "forEach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "forEachIndexed", "Lkotlin/Function2;", "index", "get", "isEmpty", "isNotEmpty", "iterator", "", "minusAssign", "plusAssign", "setMargins", "Landroid/view/ViewGroup$MarginLayoutParams;", "updateMargins", "left", "top", "right", "bottom", "updateMarginsRelative", "start", "end", "core-ktx_release"}, k = 2, mv = {1, 1, 15})
public final class ViewGroupKt {
    public static final boolean contains(ViewGroup viewGroup0, View view0) {
        Intrinsics.checkParameterIsNotNull(viewGroup0, "$this$contains");
        Intrinsics.checkParameterIsNotNull(view0, "view");
        return viewGroup0.indexOfChild(view0) != -1;
    }

    public static final void forEach(ViewGroup viewGroup0, Function1 function10) {
        Intrinsics.checkParameterIsNotNull(viewGroup0, "$this$forEach");
        Intrinsics.checkParameterIsNotNull(function10, "action");
        int v = viewGroup0.getChildCount();
        for(int v1 = 0; v1 < v; ++v1) {
            View view0 = viewGroup0.getChildAt(v1);
            Intrinsics.checkExpressionValueIsNotNull(view0, "getChildAt(index)");
            function10.invoke(view0);
        }
    }

    public static final void forEachIndexed(ViewGroup viewGroup0, Function2 function20) {
        Intrinsics.checkParameterIsNotNull(viewGroup0, "$this$forEachIndexed");
        Intrinsics.checkParameterIsNotNull(function20, "action");
        int v = viewGroup0.getChildCount();
        for(int v1 = 0; v1 < v; ++v1) {
            View view0 = viewGroup0.getChildAt(v1);
            Intrinsics.checkExpressionValueIsNotNull(view0, "getChildAt(index)");
            function20.invoke(v1, view0);
        }
    }

    public static final View get(ViewGroup viewGroup0, int v) {
        Intrinsics.checkParameterIsNotNull(viewGroup0, "$this$get");
        View view0 = viewGroup0.getChildAt(v);
        if(view0 == null) {
            throw new IndexOutOfBoundsException("Index: " + v + ", Size: " + viewGroup0.getChildCount());
        }
        return view0;
    }

    public static final Sequence getChildren(ViewGroup viewGroup0) {
        Intrinsics.checkParameterIsNotNull(viewGroup0, "$this$children");
        return () -> {
            Intrinsics.checkParameterIsNotNull(this.$this_children, "$this$iterator");
            return new Object() {
                private int index;

                @Override
                public boolean hasNext() {
                    return this.index < this.$this_children.getChildCount();
                }

                public View next() {
                    int v = this.index;
                    this.index = v + 1;
                    View view0 = this.$this_children.getChildAt(v);
                    if(view0 == null) {
                        throw new IndexOutOfBoundsException();
                    }
                    return view0;
                }

                @Override
                public Object next() {
                    return this.next();
                }

                @Override
                public void remove() {
                    int v = this.index - 1;
                    this.index = v;
                    this.$this_children.removeViewAt(v);
                }
            };
        };

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000F\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0096\u0002¨\u0006\u0005"}, d2 = {"androidx/core/view/ViewGroupKt$children$1", "Lkotlin/sequences/Sequence;", "Landroid/view/View;", "iterator", "", "core-ktx_release"}, k = 1, mv = {1, 1, 15})
        public final class androidx.core.view.ViewGroupKt.children.1 implements Sequence {
            androidx.core.view.ViewGroupKt.children.1(ViewGroup viewGroup0) {
            }

            @Override  // kotlin.sequences.Sequence
            public Iterator iterator() {
                return ViewGroupKt.iterator(this.$this_children);
            }
        }

    }

    public static final int getSize(ViewGroup viewGroup0) {
        Intrinsics.checkParameterIsNotNull(viewGroup0, "$this$size");
        return viewGroup0.getChildCount();
    }

    public static final boolean isEmpty(ViewGroup viewGroup0) {
        Intrinsics.checkParameterIsNotNull(viewGroup0, "$this$isEmpty");
        return viewGroup0.getChildCount() == 0;
    }

    public static final boolean isNotEmpty(ViewGroup viewGroup0) {
        Intrinsics.checkParameterIsNotNull(viewGroup0, "$this$isNotEmpty");
        return viewGroup0.getChildCount() != 0;
    }

    // 检测为 Lambda 实现
    public static final Iterator iterator(ViewGroup viewGroup0) [...]

    public static final void minusAssign(ViewGroup viewGroup0, View view0) {
        Intrinsics.checkParameterIsNotNull(viewGroup0, "$this$minusAssign");
        Intrinsics.checkParameterIsNotNull(view0, "view");
        viewGroup0.removeView(view0);
    }

    public static final void plusAssign(ViewGroup viewGroup0, View view0) {
        Intrinsics.checkParameterIsNotNull(viewGroup0, "$this$plusAssign");
        Intrinsics.checkParameterIsNotNull(view0, "view");
        viewGroup0.addView(view0);
    }

    public static final void setMargins(ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0, int v) {
        Intrinsics.checkParameterIsNotNull(viewGroup$MarginLayoutParams0, "$this$setMargins");
        viewGroup$MarginLayoutParams0.setMargins(v, v, v, v);
    }

    public static final void updateMargins(ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0, int v, int v1, int v2, int v3) {
        Intrinsics.checkParameterIsNotNull(viewGroup$MarginLayoutParams0, "$this$updateMargins");
        viewGroup$MarginLayoutParams0.setMargins(v, v1, v2, v3);
    }

    public static void updateMargins$default(ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0, int v, int v1, int v2, int v3, int v4, Object object0) {
        if((v4 & 1) != 0) {
            v = viewGroup$MarginLayoutParams0.leftMargin;
        }
        if((v4 & 2) != 0) {
            v1 = viewGroup$MarginLayoutParams0.topMargin;
        }
        if((v4 & 4) != 0) {
            v2 = viewGroup$MarginLayoutParams0.rightMargin;
        }
        if((v4 & 8) != 0) {
            v3 = viewGroup$MarginLayoutParams0.bottomMargin;
        }
        Intrinsics.checkParameterIsNotNull(viewGroup$MarginLayoutParams0, "$this$updateMargins");
        viewGroup$MarginLayoutParams0.setMargins(v, v1, v2, v3);
    }

    public static final void updateMarginsRelative(ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0, int v, int v1, int v2, int v3) {
        Intrinsics.checkParameterIsNotNull(viewGroup$MarginLayoutParams0, "$this$updateMarginsRelative");
        viewGroup$MarginLayoutParams0.setMarginStart(v);
        viewGroup$MarginLayoutParams0.topMargin = v1;
        viewGroup$MarginLayoutParams0.setMarginEnd(v2);
        viewGroup$MarginLayoutParams0.bottomMargin = v3;
    }

    public static void updateMarginsRelative$default(ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0, int v, int v1, int v2, int v3, int v4, Object object0) {
        if((v4 & 1) != 0) {
            v = viewGroup$MarginLayoutParams0.getMarginStart();
        }
        if((v4 & 2) != 0) {
            v1 = viewGroup$MarginLayoutParams0.topMargin;
        }
        if((v4 & 4) != 0) {
            v2 = viewGroup$MarginLayoutParams0.getMarginEnd();
        }
        if((v4 & 8) != 0) {
            v3 = viewGroup$MarginLayoutParams0.bottomMargin;
        }
        Intrinsics.checkParameterIsNotNull(viewGroup$MarginLayoutParams0, "$this$updateMarginsRelative");
        viewGroup$MarginLayoutParams0.setMarginStart(v);
        viewGroup$MarginLayoutParams0.topMargin = v1;
        viewGroup$MarginLayoutParams0.setMarginEnd(v2);
        viewGroup$MarginLayoutParams0.bottomMargin = v3;
    }
}

