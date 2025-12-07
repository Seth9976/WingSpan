package androidx.collection;

public final class CircularArray {
    private int mCapacityBitmask;
    private Object[] mElements;
    private int mHead;
    private int mTail;

    public CircularArray() {
        this(8);
    }

    public CircularArray(int v) {
        if(v < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }
        if(v > 0x40000000) {
            throw new IllegalArgumentException("capacity must be <= 2^30");
        }
        if(Integer.bitCount(v) != 1) {
            v = Integer.highestOneBit(v - 1) << 1;
        }
        this.mCapacityBitmask = v - 1;
        this.mElements = new Object[v];
    }

    public void addFirst(Object object0) {
        int v = this.mHead - 1 & this.mCapacityBitmask;
        this.mHead = v;
        this.mElements[v] = object0;
        if(v == this.mTail) {
            this.doubleCapacity();
        }
    }

    public void addLast(Object object0) {
        int v = this.mTail;
        this.mElements[v] = object0;
        int v1 = this.mCapacityBitmask & v + 1;
        this.mTail = v1;
        if(v1 == this.mHead) {
            this.doubleCapacity();
        }
    }

    public void clear() {
        this.removeFromStart(this.size());
    }

    private void doubleCapacity() {
        Object[] arr_object = this.mElements;
        int v = this.mHead;
        int v1 = arr_object.length - v;
        int v2 = arr_object.length << 1;
        if(v2 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }
        Object[] arr_object1 = new Object[v2];
        System.arraycopy(arr_object, v, arr_object1, 0, v1);
        System.arraycopy(this.mElements, 0, arr_object1, v1, this.mHead);
        this.mElements = arr_object1;
        this.mHead = 0;
        this.mTail = arr_object.length;
        this.mCapacityBitmask = v2 - 1;
    }

    public Object get(int v) {
        if(v < 0 || v >= this.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.mElements[this.mCapacityBitmask & this.mHead + v];
    }

    public Object getFirst() {
        int v = this.mHead;
        if(v == this.mTail) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.mElements[v];
    }

    public Object getLast() {
        int v = this.mTail;
        if(this.mHead == v) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.mElements[v - 1 & this.mCapacityBitmask];
    }

    public boolean isEmpty() {
        return this.mHead == this.mTail;
    }

    public Object popFirst() {
        int v = this.mHead;
        if(v == this.mTail) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Object[] arr_object = this.mElements;
        Object object0 = arr_object[v];
        arr_object[v] = null;
        this.mHead = v + 1 & this.mCapacityBitmask;
        return object0;
    }

    public Object popLast() {
        int v = this.mTail;
        if(this.mHead == v) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int v1 = this.mCapacityBitmask & v - 1;
        Object[] arr_object = this.mElements;
        Object object0 = arr_object[v1];
        arr_object[v1] = null;
        this.mTail = v1;
        return object0;
    }

    public void removeFromEnd(int v) {
        int v3;
        if(v <= 0) {
            return;
        }
        if(v > this.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int v1 = v >= this.mTail ? 0 : this.mTail - v;
        for(int v2 = v1; true; ++v2) {
            v3 = this.mTail;
            if(v2 >= v3) {
                break;
            }
            this.mElements[v2] = null;
        }
        int v4 = v3 - v1;
        int v5 = v - v4;
        this.mTail = v3 - v4;
        if(v5 > 0) {
            this.mTail = this.mElements.length;
            int v6 = this.mElements.length - v5;
            for(int v7 = v6; v7 < this.mTail; ++v7) {
                this.mElements[v7] = null;
            }
            this.mTail = v6;
        }
    }

    public void removeFromStart(int v) {
        if(v <= 0) {
            return;
        }
        if(v > this.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int v1 = this.mElements.length;
        int v2 = this.mHead;
        if(v < v1 - v2) {
            v1 = v2 + v;
        }
        while(v2 < v1) {
            this.mElements[v2] = null;
            ++v2;
        }
        int v3 = v1 - this.mHead;
        int v4 = v - v3;
        this.mHead = this.mCapacityBitmask & this.mHead + v3;
        if(v4 > 0) {
            for(int v5 = 0; v5 < v4; ++v5) {
                this.mElements[v5] = null;
            }
            this.mHead = v4;
        }
    }

    public int size() {
        return this.mTail - this.mHead & this.mCapacityBitmask;
    }
}

