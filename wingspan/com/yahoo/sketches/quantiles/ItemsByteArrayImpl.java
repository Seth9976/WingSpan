package com.yahoo.sketches.quantiles;

import com.yahoo.memory.WritableMemory;
import com.yahoo.sketches.ArrayOfItemsSerDe;
import com.yahoo.sketches.Family;
import java.lang.reflect.Array;
import java.util.Arrays;

final class ItemsByteArrayImpl {
    private static Object[] combinedBufferToItemsArray(ItemsSketch sketch, boolean ordered) {
        int v = sketch.getRetainedItems();
        Object object0 = sketch.getMinValue();
        Object[] arr_object = (Object[])Array.newInstance(object0.getClass(), v + 2);
        int v1 = 0;
        arr_object[0] = object0;
        arr_object[1] = sketch.getMaxValue();
        int v2 = sketch.getBaseBufferCount();
        Object[] arr_object1 = sketch.getCombinedBuffer();
        System.arraycopy(arr_object1, 0, arr_object, 2, v2);
        long v3 = sketch.getBitPattern();
        if(v3 > 0L) {
            int v4 = sketch.getK();
            int v5 = v2 + 2;
            while(v3 != 0L) {
                if((1L & v3) > 0L) {
                    System.arraycopy(arr_object1, (v1 + 2) * v4, arr_object, v5, v4);
                    v5 += v4;
                }
                ++v1;
                v3 >>>= 1;
            }
        }
        if(ordered) {
            Arrays.sort(arr_object, 2, v2 + 2, sketch.getComparator());
        }
        return arr_object;
    }

    private static void insertPre0(WritableMemory wmem, int preLongs, int flags, int k) {
        PreambleUtil.insertPreLongs(wmem, preLongs);
        PreambleUtil.insertSerVer(wmem, 3);
        PreambleUtil.insertFamilyID(wmem, Family.QUANTILES.getID());
        PreambleUtil.insertFlags(wmem, flags);
        PreambleUtil.insertK(wmem, k);
    }

    static byte[] toByteArray(ItemsSketch sketch, boolean ordered, ArrayOfItemsSerDe serDe) {
        boolean z1 = sketch.isEmpty();
        int v = (ordered ? 16 : 0) | (z1 ? 4 : 0) | 8;
        if(z1) {
            byte[] arr_b = new byte[8];
            ItemsByteArrayImpl.insertPre0(WritableMemory.wrap(arr_b), 1, v, sketch.getK());
            return arr_b;
        }
        byte[] arr_b1 = serDe.serializeToByteArray(ItemsByteArrayImpl.combinedBufferToItemsArray(sketch, ordered));
        byte[] arr_b2 = new byte[arr_b1.length + 16];
        WritableMemory writableMemory0 = WritableMemory.wrap(arr_b2);
        ItemsByteArrayImpl.insertPre0(writableMemory0, 2, v, sketch.getK());
        PreambleUtil.insertN(writableMemory0, sketch.getN());
        writableMemory0.putByteArray(16L, arr_b1, 0, arr_b1.length);
        return arr_b2;
    }
}

