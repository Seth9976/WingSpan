package com.yahoo.sketches;

import com.yahoo.memory.Memory;
import com.yahoo.memory.Util;
import com.yahoo.memory.WritableMemory;

public class ArrayOfDoublesSerDe extends ArrayOfItemsSerDe {
    public Double[] deserializeFromMemory(Memory mem, int length) {
        Util.checkBounds(0L, 8L, mem.getCapacity());
        Double[] arr_double = new Double[length];
        long v1 = 0L;
        for(int v2 = 0; v2 < length; ++v2) {
            arr_double[v2] = mem.getDouble(v1);
            v1 += 8L;
        }
        return arr_double;
    }

    @Override  // com.yahoo.sketches.ArrayOfItemsSerDe
    public Object[] deserializeFromMemory(Memory mem, int length) {
        return this.deserializeFromMemory(mem, length);
    }

    public byte[] serializeToByteArray(Double[] items) {
        byte[] arr_b = new byte[items.length * 8];
        WritableMemory writableMemory0 = WritableMemory.wrap(arr_b);
        long v = 0L;
        for(int v1 = 0; v1 < items.length; ++v1) {
            writableMemory0.putDouble(v, ((double)items[v1]));
            v += 8L;
        }
        return arr_b;
    }

    @Override  // com.yahoo.sketches.ArrayOfItemsSerDe
    public byte[] serializeToByteArray(Object[] items) {
        return this.serializeToByteArray(((Double[])items));
    }
}

