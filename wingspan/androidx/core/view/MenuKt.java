package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010)\n\u0002\b\u0002\u001A\u0015\u0010\n\u001A\u00020\u000B*\u00020\u00032\u0006\u0010\f\u001A\u00020\u0002H\u0086\u0002\u001A0\u0010\r\u001A\u00020\u000E*\u00020\u00032!\u0010\u000F\u001A\u001D\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000E0\u0010H\u0086\b\u001AE\u0010\u0013\u001A\u00020\u000E*\u00020\u000326\u0010\u000F\u001A2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000E0\u0014H\u0086\b\u001A\u0015\u0010\u0016\u001A\u00020\u0002*\u00020\u00032\u0006\u0010\u0015\u001A\u00020\u0007H\u0086\n\u001A\r\u0010\u0017\u001A\u00020\u000B*\u00020\u0003H\u0086\b\u001A\r\u0010\u0018\u001A\u00020\u000B*\u00020\u0003H\u0086\b\u001A\u0013\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00020\u001A*\u00020\u0003H\u0086\u0002\u001A\u0015\u0010\u001B\u001A\u00020\u000E*\u00020\u00032\u0006\u0010\f\u001A\u00020\u0002H\u0086\n\"\u001B\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0006\u001A\u00020\u0007*\u00020\u00038Æ\u0002¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006\u001C"}, d2 = {"children", "Lkotlin/sequences/Sequence;", "Landroid/view/MenuItem;", "Landroid/view/Menu;", "getChildren", "(Landroid/view/Menu;)Lkotlin/sequences/Sequence;", "size", "", "getSize", "(Landroid/view/Menu;)I", "contains", "", "item", "forEach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "forEachIndexed", "Lkotlin/Function2;", "index", "get", "isEmpty", "isNotEmpty", "iterator", "", "minusAssign", "core-ktx_release"}, k = 2, mv = {1, 1, 15})
public final class MenuKt {
    public static final boolean contains(Menu menu0, MenuItem menuItem0) {
        Intrinsics.checkParameterIsNotNull(menu0, "$this$contains");
        Intrinsics.checkParameterIsNotNull(menuItem0, "item");
        int v = menu0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            if(Intrinsics.areEqual(menu0.getItem(v1), menuItem0)) {
                return true;
            }
        }
        return false;
    }

    public static final void forEach(Menu menu0, Function1 function10) {
        Intrinsics.checkParameterIsNotNull(menu0, "$this$forEach");
        Intrinsics.checkParameterIsNotNull(function10, "action");
        int v = menu0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            MenuItem menuItem0 = menu0.getItem(v1);
            Intrinsics.checkExpressionValueIsNotNull(menuItem0, "getItem(index)");
            function10.invoke(menuItem0);
        }
    }

    public static final void forEachIndexed(Menu menu0, Function2 function20) {
        Intrinsics.checkParameterIsNotNull(menu0, "$this$forEachIndexed");
        Intrinsics.checkParameterIsNotNull(function20, "action");
        int v = menu0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            MenuItem menuItem0 = menu0.getItem(v1);
            Intrinsics.checkExpressionValueIsNotNull(menuItem0, "getItem(index)");
            function20.invoke(v1, menuItem0);
        }
    }

    public static final MenuItem get(Menu menu0, int v) {
        Intrinsics.checkParameterIsNotNull(menu0, "$this$get");
        MenuItem menuItem0 = menu0.getItem(v);
        Intrinsics.checkExpressionValueIsNotNull(menuItem0, "getItem(index)");
        return menuItem0;
    }

    public static final Sequence getChildren(Menu menu0) {
        Intrinsics.checkParameterIsNotNull(menu0, "$this$children");
        return () -> {
            Intrinsics.checkParameterIsNotNull(this.$this_children, "$this$iterator");
            return new Object() {
                private int index;

                @Override
                public boolean hasNext() {
                    return this.index < this.$this_children.size();
                }

                public MenuItem next() {
                    int v = this.index;
                    this.index = v + 1;
                    MenuItem menuItem0 = this.$this_children.getItem(v);
                    if(menuItem0 == null) {
                        throw new IndexOutOfBoundsException();
                    }
                    return menuItem0;
                }

                @Override
                public Object next() {
                    return this.next();
                }

                @Override
                public void remove() {
                    int v = this.index - 1;
                    this.index = v;
                    this.$this_children.removeItem(v);
                }
            };
        };

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000F\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0096\u0002¨\u0006\u0005"}, d2 = {"androidx/core/view/MenuKt$children$1", "Lkotlin/sequences/Sequence;", "Landroid/view/MenuItem;", "iterator", "", "core-ktx_release"}, k = 1, mv = {1, 1, 15})
        public final class androidx.core.view.MenuKt.children.1 implements Sequence {
            androidx.core.view.MenuKt.children.1(Menu menu0) {
            }

            @Override  // kotlin.sequences.Sequence
            public Iterator iterator() {
                return MenuKt.iterator(this.$this_children);
            }
        }

    }

    public static final int getSize(Menu menu0) {
        Intrinsics.checkParameterIsNotNull(menu0, "$this$size");
        return menu0.size();
    }

    public static final boolean isEmpty(Menu menu0) {
        Intrinsics.checkParameterIsNotNull(menu0, "$this$isEmpty");
        return menu0.size() == 0;
    }

    public static final boolean isNotEmpty(Menu menu0) {
        Intrinsics.checkParameterIsNotNull(menu0, "$this$isNotEmpty");
        return menu0.size() != 0;
    }

    // 检测为 Lambda 实现
    public static final Iterator iterator(Menu menu0) [...]

    public static final void minusAssign(Menu menu0, MenuItem menuItem0) {
        Intrinsics.checkParameterIsNotNull(menu0, "$this$minusAssign");
        Intrinsics.checkParameterIsNotNull(menuItem0, "item");
        menu0.removeItem(menuItem0.getItemId());
    }
}

