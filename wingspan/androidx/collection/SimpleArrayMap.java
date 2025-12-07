package androidx.collection;

import java.util.ConcurrentModificationException;
import java.util.Map;

public class SimpleArrayMap {
    private static final int BASE_SIZE = 4;
    private static final int CACHE_SIZE = 10;
    private static final boolean CONCURRENT_MODIFICATION_EXCEPTIONS = true;
    private static final boolean DEBUG = false;
    private static final String TAG = "ArrayMap";
    Object[] mArray;
    static Object[] mBaseCache;
    static int mBaseCacheSize;
    int[] mHashes;
    int mSize;
    static Object[] mTwiceBaseCache;
    static int mTwiceBaseCacheSize;

    public SimpleArrayMap() {
        this.mHashes = ContainerHelpers.EMPTY_INTS;
        this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        this.mSize = 0;
    }

    public SimpleArrayMap(int v) {
        if(v == 0) {
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        }
        else {
            this.allocArrays(v);
        }
        this.mSize = 0;
    }

    public SimpleArrayMap(SimpleArrayMap simpleArrayMap0) {
        if(simpleArrayMap0 != null) {
            this.putAll(simpleArrayMap0);
        }
    }

    private void allocArrays(int v) {
        switch(v) {
            case 4: {
                Class class0 = SimpleArrayMap.class;
                synchronized(class0) {
                    Object[] arr_object = SimpleArrayMap.mBaseCache;
                    if(arr_object != null) {
                        this.mArray = arr_object;
                        SimpleArrayMap.mBaseCache = (Object[])arr_object[0];
                        this.mHashes = (int[])arr_object[1];
                        arr_object[1] = null;
                        arr_object[0] = null;
                        --SimpleArrayMap.mBaseCacheSize;
                        return;
                    }
                }
                break;
            }
            case 8: {
                Class class1 = SimpleArrayMap.class;
                synchronized(class1) {
                    Object[] arr_object1 = SimpleArrayMap.mTwiceBaseCache;
                    if(arr_object1 != null) {
                        this.mArray = arr_object1;
                        SimpleArrayMap.mTwiceBaseCache = (Object[])arr_object1[0];
                        this.mHashes = (int[])arr_object1[1];
                        arr_object1[1] = null;
                        arr_object1[0] = null;
                        --SimpleArrayMap.mTwiceBaseCacheSize;
                        return;
                    }
                }
            }
        }
        this.mHashes = new int[v];
        this.mArray = new Object[v << 1];
    }

    private static int binarySearchHashes(int[] arr_v, int v, int v1) {
        try {
            return ContainerHelpers.binarySearch(arr_v, v, v1);
        }
        catch(ArrayIndexOutOfBoundsException unused_ex) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        int v = this.mSize;
        if(v > 0) {
            int[] arr_v = this.mHashes;
            Object[] arr_object = this.mArray;
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
            this.mSize = 0;
            SimpleArrayMap.freeArrays(arr_v, arr_object, v);
        }
        if(this.mSize > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object object0) {
        return this.indexOfKey(object0) >= 0;
    }

    public boolean containsValue(Object object0) {
        return this.indexOfValue(object0) >= 0;
    }

    public void ensureCapacity(int v) {
        int v1 = this.mSize;
        int[] arr_v = this.mHashes;
        if(arr_v.length < v) {
            Object[] arr_object = this.mArray;
            this.allocArrays(v);
            if(this.mSize > 0) {
                System.arraycopy(arr_v, 0, this.mHashes, 0, v1);
                System.arraycopy(arr_object, 0, this.mArray, 0, v1 << 1);
            }
            SimpleArrayMap.freeArrays(arr_v, arr_object, v1);
        }
        if(this.mSize != v1) {
            throw new ConcurrentModificationException();
        }
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 instanceof SimpleArrayMap) {
            SimpleArrayMap simpleArrayMap0 = (SimpleArrayMap)object0;
            if(this.size() != simpleArrayMap0.size()) {
                return false;
            }
            try {
                for(int v = 0; true; ++v) {
                    if(v >= this.mSize) {
                        return true;
                    }
                    Object object1 = this.keyAt(v);
                    Object object2 = this.valueAt(v);
                    Object object3 = simpleArrayMap0.get(object1);
                    if(object2 != null) {
                        if(object2.equals(object3)) {
                            continue;
                        }
                        break;
                    }
                    else if(object3 != null || !simpleArrayMap0.containsKey(object1)) {
                        return false;
                    }
                }
            }
            catch(NullPointerException | ClassCastException unused_ex) {
            }
            return false;
        }
        if(object0 instanceof Map) {
            Map map0 = (Map)object0;
            if(this.size() != map0.size()) {
                return false;
            }
            try {
                for(int v1 = 0; v1 < this.mSize; ++v1) {
                    Object object4 = this.keyAt(v1);
                    Object object5 = this.valueAt(v1);
                    Object object6 = map0.get(object4);
                    if(object5 == null) {
                        if(object6 != null || !map0.containsKey(object4)) {
                            return false;
                        }
                    }
                    else if(!object5.equals(object6)) {
                        return false;
                    }
                }
                return true;
            }
            catch(NullPointerException | ClassCastException unused_ex) {
            }
        }
        return false;
    }

    private static void freeArrays(int[] arr_v, Object[] arr_object, int v) {
        switch(arr_v.length) {
            case 4: {
                Class class0 = SimpleArrayMap.class;
                synchronized(class0) {
                    if(SimpleArrayMap.mBaseCacheSize < 10) {
                        arr_object[0] = SimpleArrayMap.mBaseCache;
                        arr_object[1] = arr_v;
                        for(int v2 = (v << 1) - 1; v2 >= 2; --v2) {
                            arr_object[v2] = null;
                        }
                        SimpleArrayMap.mBaseCache = arr_object;
                        ++SimpleArrayMap.mBaseCacheSize;
                    }
                }
                return;
            }
            case 8: {
                Class class1 = SimpleArrayMap.class;
                synchronized(class1) {
                    if(SimpleArrayMap.mTwiceBaseCacheSize < 10) {
                        arr_object[0] = SimpleArrayMap.mTwiceBaseCache;
                        arr_object[1] = arr_v;
                        for(int v4 = (v << 1) - 1; v4 >= 2; --v4) {
                            arr_object[v4] = null;
                        }
                        SimpleArrayMap.mTwiceBaseCache = arr_object;
                        ++SimpleArrayMap.mTwiceBaseCacheSize;
                    }
                }
            }
        }
    }

    public Object get(Object object0) {
        return this.getOrDefault(object0, null);
    }

    public Object getOrDefault(Object object0, Object object1) {
        int v = this.indexOfKey(object0);
        return v < 0 ? object1 : this.mArray[(v << 1) + 1];
    }

    @Override
    public int hashCode() {
        int[] arr_v = this.mHashes;
        Object[] arr_object = this.mArray;
        int v = this.mSize;
        int v2 = 0;
        int v3 = 0;
        for(int v1 = 1; v2 < v; v1 += 2) {
            Object object0 = arr_object[v1];
            v3 += (object0 == null ? 0 : object0.hashCode()) ^ arr_v[v2];
            ++v2;
        }
        return v3;
    }

    int indexOf(Object object0, int v) {
        int v1 = this.mSize;
        if(v1 == 0) {
            return -1;
        }
        int v2 = SimpleArrayMap.binarySearchHashes(this.mHashes, v1, v);
        if(v2 < 0) {
            return v2;
        }
        if(object0.equals(this.mArray[v2 << 1])) {
            return v2;
        }
        int v3;
        for(v3 = v2 + 1; v3 < v1 && this.mHashes[v3] == v; ++v3) {
            if(object0.equals(this.mArray[v3 << 1])) {
                return v3;
            }
        }
        for(int v4 = v2 - 1; v4 >= 0 && this.mHashes[v4] == v; --v4) {
            if(object0.equals(this.mArray[v4 << 1])) {
                return v4;
            }
        }
        return ~v3;
    }

    public int indexOfKey(Object object0) {
        return object0 == null ? this.indexOfNull() : this.indexOf(object0, object0.hashCode());
    }

    int indexOfNull() {
        int v = this.mSize;
        if(v == 0) {
            return -1;
        }
        int v1 = SimpleArrayMap.binarySearchHashes(this.mHashes, v, 0);
        if(v1 < 0) {
            return v1;
        }
        if(this.mArray[v1 << 1] == null) {
            return v1;
        }
        int v2;
        for(v2 = v1 + 1; v2 < v && this.mHashes[v2] == 0; ++v2) {
            if(this.mArray[v2 << 1] == null) {
                return v2;
            }
        }
        for(int v3 = v1 - 1; v3 >= 0 && this.mHashes[v3] == 0; --v3) {
            if(this.mArray[v3 << 1] == null) {
                return v3;
            }
        }
        return ~v2;
    }

    int indexOfValue(Object object0) {
        int v = this.mSize * 2;
        Object[] arr_object = this.mArray;
        if(object0 == null) {
            for(int v1 = 1; v1 < v; v1 += 2) {
                if(arr_object[v1] == null) {
                    return v1 >> 1;
                }
            }
            return -1;
        }
        for(int v2 = 1; v2 < v; v2 += 2) {
            if(object0.equals(arr_object[v2])) {
                return v2 >> 1;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.mSize <= 0;
    }

    public Object keyAt(int v) {
        return this.mArray[v << 1];
    }

    public Object put(Object object0, Object object1) {
        int v2;
        int v1;
        int v = this.mSize;
        if(object0 == null) {
            v1 = this.indexOfNull();
            v2 = 0;
        }
        else {
            int v3 = object0.hashCode();
            v2 = v3;
            v1 = this.indexOf(object0, v3);
        }
        if(v1 >= 0) {
            int v4 = (v1 << 1) + 1;
            Object[] arr_object = this.mArray;
            Object object2 = arr_object[v4];
            arr_object[v4] = object1;
            return object2;
        }
        int v5 = 8;
        int[] arr_v = this.mHashes;
        if(v >= arr_v.length) {
            if(v >= 8) {
                v5 = (v >> 1) + v;
            }
            else if(v < 4) {
                v5 = 4;
            }
            Object[] arr_object1 = this.mArray;
            this.allocArrays(v5);
            if(v != this.mSize) {
                throw new ConcurrentModificationException();
            }
            int[] arr_v1 = this.mHashes;
            if(arr_v1.length > 0) {
                System.arraycopy(arr_v, 0, arr_v1, 0, arr_v.length);
                System.arraycopy(arr_object1, 0, this.mArray, 0, arr_object1.length);
            }
            SimpleArrayMap.freeArrays(arr_v, arr_object1, v);
        }
        if(~v1 < v) {
            System.arraycopy(this.mHashes, ~v1, this.mHashes, -v1, v - ~v1);
            System.arraycopy(this.mArray, ~v1 << 1, this.mArray, -v1 << 1, this.mSize - ~v1 << 1);
        }
        int v6 = this.mSize;
        if(v == v6) {
            int[] arr_v2 = this.mHashes;
            if(~v1 < arr_v2.length) {
                arr_v2[~v1] = v2;
                Object[] arr_object2 = this.mArray;
                arr_object2[~v1 << 1] = object0;
                arr_object2[(~v1 << 1) + 1] = object1;
                this.mSize = v6 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public void putAll(SimpleArrayMap simpleArrayMap0) {
        int v = simpleArrayMap0.mSize;
        this.ensureCapacity(this.mSize + v);
        if(this.mSize != 0) {
            for(int v1 = 0; v1 < v; ++v1) {
                this.put(simpleArrayMap0.keyAt(v1), simpleArrayMap0.valueAt(v1));
            }
        }
        else if(v > 0) {
            System.arraycopy(simpleArrayMap0.mHashes, 0, this.mHashes, 0, v);
            System.arraycopy(simpleArrayMap0.mArray, 0, this.mArray, 0, v << 1);
            this.mSize = v;
        }
    }

    public Object putIfAbsent(Object object0, Object object1) {
        Object object2 = this.get(object0);
        return object2 == null ? this.put(object0, object1) : object2;
    }

    public Object remove(Object object0) {
        int v = this.indexOfKey(object0);
        return v < 0 ? null : this.removeAt(v);
    }

    public boolean remove(Object object0, Object object1) {
        int v = this.indexOfKey(object0);
        if(v >= 0) {
            Object object2 = this.valueAt(v);
            if(object1 == object2 || object1 != null && object1.equals(object2)) {
                this.removeAt(v);
                return true;
            }
        }
        return false;
    }

    public Object removeAt(int v) {
        Object[] arr_object = this.mArray;
        Object object0 = arr_object[(v << 1) + 1];
        int v1 = this.mSize;
        int v2 = 0;
        if(v1 <= 1) {
            SimpleArrayMap.freeArrays(this.mHashes, arr_object, v1);
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        }
        else {
            int[] arr_v = this.mHashes;
            int v3 = 8;
            if(arr_v.length <= 8 || v1 >= arr_v.length / 3) {
                if(v < v1 - 1) {
                    int v5 = v1 - 1 - v;
                    System.arraycopy(arr_v, v + 1, arr_v, v, v5);
                    System.arraycopy(this.mArray, v + 1 << 1, this.mArray, v << 1, v5 << 1);
                }
                Object[] arr_object1 = this.mArray;
                int v6 = v1 - 1 << 1;
                arr_object1[v6] = null;
                arr_object1[v6 + 1] = null;
            }
            else {
                if(v1 > 8) {
                    v3 = v1 + (v1 >> 1);
                }
                this.allocArrays(v3);
                if(v1 != this.mSize) {
                    throw new ConcurrentModificationException();
                }
                if(v > 0) {
                    System.arraycopy(arr_v, 0, this.mHashes, 0, v);
                    System.arraycopy(arr_object, 0, this.mArray, 0, v << 1);
                }
                if(v < v1 - 1) {
                    int v4 = v1 - 1 - v;
                    System.arraycopy(arr_v, v + 1, this.mHashes, v, v4);
                    System.arraycopy(arr_object, v + 1 << 1, this.mArray, v << 1, v4 << 1);
                }
            }
            v2 = v1 - 1;
        }
        if(v1 != this.mSize) {
            throw new ConcurrentModificationException();
        }
        this.mSize = v2;
        return object0;
    }

    public Object replace(Object object0, Object object1) {
        int v = this.indexOfKey(object0);
        return v < 0 ? null : this.setValueAt(v, object1);
    }

    public boolean replace(Object object0, Object object1, Object object2) {
        int v = this.indexOfKey(object0);
        if(v >= 0) {
            Object object3 = this.valueAt(v);
            if(object3 == object1 || object1 != null && object1.equals(object3)) {
                this.setValueAt(v, object2);
                return true;
            }
        }
        return false;
    }

    public Object setValueAt(int v, Object object0) {
        int v1 = (v << 1) + 1;
        Object[] arr_object = this.mArray;
        Object object1 = arr_object[v1];
        arr_object[v1] = object0;
        return object1;
    }

    public int size() {
        return this.mSize;
    }

    @Override
    public String toString() {
        if(this.isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder0 = new StringBuilder(this.mSize * 28);
        stringBuilder0.append('{');
        for(int v = 0; v < this.mSize; ++v) {
            if(v > 0) {
                stringBuilder0.append(", ");
            }
            Object object0 = this.keyAt(v);
            if(object0 == this) {
                stringBuilder0.append("(this Map)");
            }
            else {
                stringBuilder0.append(object0);
            }
            stringBuilder0.append('=');
            Object object1 = this.valueAt(v);
            if(object1 == this) {
                stringBuilder0.append("(this Map)");
            }
            else {
                stringBuilder0.append(object1);
            }
        }
        stringBuilder0.append('}');
        return stringBuilder0.toString();
    }

    public Object valueAt(int v) {
        return this.mArray[(v << 1) + 1];
    }
}

