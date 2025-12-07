package com.voxelbusters.essentialkit.utilities.common;

public class ArrayBuffer {
    public Object[] data;

    public ArrayBuffer(Object[] arr_object) {
        this.data = arr_object;
    }

    public Object get(int v) {
        return this.data == null ? null : this.data[v];
    }

    public int size() {
        return this.data == null ? 0 : this.data.length;
    }
}

