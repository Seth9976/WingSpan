package androidx.core.os;

import android.os.PersistableBundle;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001C\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0010\u0000\n\u0002\b\u0002\u001A=\u0010\u0000\u001A\u00020\u00012.\u0010\u0002\u001A\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u0003\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"persistableBundleOf", "Landroid/os/PersistableBundle;", "pairs", "", "Lkotlin/Pair;", "", "", "([Lkotlin/Pair;)Landroid/os/PersistableBundle;", "core-ktx_release"}, k = 2, mv = {1, 1, 15})
public final class PersistableBundleKt {
    public static final PersistableBundle persistableBundleOf(Pair[] arr_pair) {
        Intrinsics.checkParameterIsNotNull(arr_pair, "pairs");
        PersistableBundle persistableBundle0 = new PersistableBundle(arr_pair.length);
        for(int v = 0; v < arr_pair.length; ++v) {
            Pair pair0 = arr_pair[v];
            String s = (String)pair0.component1();
            Object object0 = pair0.component2();
            if(object0 == null) {
                persistableBundle0.putString(s, null);
            }
            else if(object0 instanceof Boolean) {
                persistableBundle0.putBoolean(s, ((Boolean)object0).booleanValue());
            }
            else if(object0 instanceof Double) {
                persistableBundle0.putDouble(s, ((Number)object0).doubleValue());
            }
            else if(object0 instanceof Integer) {
                persistableBundle0.putInt(s, ((Number)object0).intValue());
            }
            else if(object0 instanceof Long) {
                persistableBundle0.putLong(s, ((Number)object0).longValue());
            }
            else if(object0 instanceof String) {
                persistableBundle0.putString(s, ((String)object0));
            }
            else if(object0 instanceof boolean[]) {
                persistableBundle0.putBooleanArray(s, ((boolean[])object0));
            }
            else if(object0 instanceof double[]) {
                persistableBundle0.putDoubleArray(s, ((double[])object0));
            }
            else if(object0 instanceof int[]) {
                persistableBundle0.putIntArray(s, ((int[])object0));
            }
            else if(object0 instanceof long[]) {
                persistableBundle0.putLongArray(s, ((long[])object0));
            }
            else {
                if(!(object0 instanceof Object[])) {
                    throw new IllegalArgumentException("Illegal value type " + object0.getClass().getCanonicalName() + " for key \"" + s + '\"');
                }
                Class class0 = object0.getClass().getComponentType();
                if(class0 == null) {
                    Intrinsics.throwNpe();
                }
                Intrinsics.checkExpressionValueIsNotNull(class0, "value::class.java.componentType!!");
                if(!String.class.isAssignableFrom(class0)) {
                    throw new IllegalArgumentException("Illegal value array type " + class0.getCanonicalName() + " for key \"" + s + '\"');
                }
                persistableBundle0.putStringArray(s, ((String[])object0));
            }
        }
        return persistableBundle0;
    }
}

