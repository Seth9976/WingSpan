package androidx.core.util;

import android.util.SparseLongArray;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.collections.LongIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001A\u0015\u0010\u0005\u001A\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001A\u00020\u0001H\u0087\n\u001A\u0015\u0010\b\u001A\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001A\u00020\u0001H\u0087\b\u001A\u0015\u0010\t\u001A\u00020\u0006*\u00020\u00022\u0006\u0010\n\u001A\u00020\u000BH\u0087\b\u001AE\u0010\f\u001A\u00020\r*\u00020\u000226\u0010\u000E\u001A2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u000B¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\r0\u000FH\u0087\b\u001A\u001D\u0010\u0012\u001A\u00020\u000B*\u00020\u00022\u0006\u0010\u0007\u001A\u00020\u00012\u0006\u0010\u0013\u001A\u00020\u000BH\u0087\b\u001A#\u0010\u0014\u001A\u00020\u000B*\u00020\u00022\u0006\u0010\u0007\u001A\u00020\u00012\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u000B0\u0015H\u0087\b\u001A\r\u0010\u0016\u001A\u00020\u0006*\u00020\u0002H\u0087\b\u001A\r\u0010\u0017\u001A\u00020\u0006*\u00020\u0002H\u0087\b\u001A\f\u0010\u0018\u001A\u00020\u0019*\u00020\u0002H\u0007\u001A\u0015\u0010\u001A\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\u001B\u001A\u00020\u0002H\u0087\u0002\u001A\u0014\u0010\u001C\u001A\u00020\r*\u00020\u00022\u0006\u0010\u001B\u001A\u00020\u0002H\u0007\u001A\u001C\u0010\u001D\u001A\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001A\u00020\u00012\u0006\u0010\n\u001A\u00020\u000BH\u0007\u001A\u001D\u0010\u001E\u001A\u00020\r*\u00020\u00022\u0006\u0010\u0007\u001A\u00020\u00012\u0006\u0010\n\u001A\u00020\u000BH\u0087\n\u001A\f\u0010\u001F\u001A\u00020 *\u00020\u0002H\u0007\"\u0016\u0010\u0000\u001A\u00020\u0001*\u00020\u00028Ç\u0002¢\u0006\u0006\u001A\u0004\b\u0003\u0010\u0004¨\u0006!"}, d2 = {"size", "", "Landroid/util/SparseLongArray;", "getSize", "(Landroid/util/SparseLongArray;)I", "contains", "", "key", "containsKey", "containsValue", "value", "", "forEach", "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "getOrDefault", "defaultValue", "getOrElse", "Lkotlin/Function0;", "isEmpty", "isNotEmpty", "keyIterator", "Lkotlin/collections/IntIterator;", "plus", "other", "putAll", "remove", "set", "valueIterator", "Lkotlin/collections/LongIterator;", "core-ktx_release"}, k = 2, mv = {1, 1, 15})
public final class SparseLongArrayKt {
    public static final boolean contains(SparseLongArray sparseLongArray0, int v) {
        Intrinsics.checkParameterIsNotNull(sparseLongArray0, "$this$contains");
        return sparseLongArray0.indexOfKey(v) >= 0;
    }

    public static final boolean containsKey(SparseLongArray sparseLongArray0, int v) {
        Intrinsics.checkParameterIsNotNull(sparseLongArray0, "$this$containsKey");
        return sparseLongArray0.indexOfKey(v) >= 0;
    }

    public static final boolean containsValue(SparseLongArray sparseLongArray0, long v) {
        Intrinsics.checkParameterIsNotNull(sparseLongArray0, "$this$containsValue");
        return sparseLongArray0.indexOfValue(v) != -1;
    }

    public static final void forEach(SparseLongArray sparseLongArray0, Function2 function20) {
        Intrinsics.checkParameterIsNotNull(sparseLongArray0, "$this$forEach");
        Intrinsics.checkParameterIsNotNull(function20, "action");
        int v = sparseLongArray0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            function20.invoke(sparseLongArray0.keyAt(v1), sparseLongArray0.valueAt(v1));
        }
    }

    public static final long getOrDefault(SparseLongArray sparseLongArray0, int v, long v1) {
        Intrinsics.checkParameterIsNotNull(sparseLongArray0, "$this$getOrDefault");
        return sparseLongArray0.get(v, v1);
    }

    public static final long getOrElse(SparseLongArray sparseLongArray0, int v, Function0 function00) {
        Intrinsics.checkParameterIsNotNull(sparseLongArray0, "$this$getOrElse");
        Intrinsics.checkParameterIsNotNull(function00, "defaultValue");
        int v1 = sparseLongArray0.indexOfKey(v);
        return v1 == -1 ? ((Number)function00.invoke()).longValue() : sparseLongArray0.valueAt(v1);
    }

    public static final int getSize(SparseLongArray sparseLongArray0) {
        Intrinsics.checkParameterIsNotNull(sparseLongArray0, "$this$size");
        return sparseLongArray0.size();
    }

    public static final boolean isEmpty(SparseLongArray sparseLongArray0) {
        Intrinsics.checkParameterIsNotNull(sparseLongArray0, "$this$isEmpty");
        return sparseLongArray0.size() == 0;
    }

    public static final boolean isNotEmpty(SparseLongArray sparseLongArray0) {
        Intrinsics.checkParameterIsNotNull(sparseLongArray0, "$this$isNotEmpty");
        return sparseLongArray0.size() != 0;
    }

    public static final IntIterator keyIterator(SparseLongArray sparseLongArray0) {
        Intrinsics.checkParameterIsNotNull(sparseLongArray0, "$this$keyIterator");
        return new IntIterator() {
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override
            public boolean hasNext() {
                return this.index < sparseLongArray0.size();
            }

            @Override  // kotlin.collections.IntIterator
            public int nextInt() {
                int v = this.index;
                this.index = v + 1;
                return sparseLongArray0.keyAt(v);
            }

            public final void setIndex(int v) {
                this.index = v;
            }
        };
    }

    public static final SparseLongArray plus(SparseLongArray sparseLongArray0, SparseLongArray sparseLongArray1) {
        Intrinsics.checkParameterIsNotNull(sparseLongArray0, "$this$plus");
        Intrinsics.checkParameterIsNotNull(sparseLongArray1, "other");
        SparseLongArray sparseLongArray2 = new SparseLongArray(sparseLongArray0.size() + sparseLongArray1.size());
        SparseLongArrayKt.putAll(sparseLongArray2, sparseLongArray0);
        SparseLongArrayKt.putAll(sparseLongArray2, sparseLongArray1);
        return sparseLongArray2;
    }

    public static final void putAll(SparseLongArray sparseLongArray0, SparseLongArray sparseLongArray1) {
        Intrinsics.checkParameterIsNotNull(sparseLongArray0, "$this$putAll");
        Intrinsics.checkParameterIsNotNull(sparseLongArray1, "other");
        int v = sparseLongArray1.size();
        for(int v1 = 0; v1 < v; ++v1) {
            sparseLongArray0.put(sparseLongArray1.keyAt(v1), sparseLongArray1.valueAt(v1));
        }
    }

    public static final boolean remove(SparseLongArray sparseLongArray0, int v, long v1) {
        Intrinsics.checkParameterIsNotNull(sparseLongArray0, "$this$remove");
        int v2 = sparseLongArray0.indexOfKey(v);
        if(v2 != -1 && v1 == sparseLongArray0.valueAt(v2)) {
            sparseLongArray0.removeAt(v2);
            return true;
        }
        return false;
    }

    public static final void set(SparseLongArray sparseLongArray0, int v, long v1) {
        Intrinsics.checkParameterIsNotNull(sparseLongArray0, "$this$set");
        sparseLongArray0.put(v, v1);
    }

    public static final LongIterator valueIterator(SparseLongArray sparseLongArray0) {
        Intrinsics.checkParameterIsNotNull(sparseLongArray0, "$this$valueIterator");
        return new LongIterator() {
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override
            public boolean hasNext() {
                return this.index < sparseLongArray0.size();
            }

            @Override  // kotlin.collections.LongIterator
            public long nextLong() {
                int v = this.index;
                this.index = v + 1;
                return sparseLongArray0.valueAt(v);
            }

            public final void setIndex(int v) {
                this.index = v;
            }
        };
    }
}

