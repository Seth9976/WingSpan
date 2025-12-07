package com.yahoo.memory;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class WritableMemory extends Memory {
    public static WritableMemory allocate(int capacityBytes) {
        return capacityBytes == 0 ? WritableMemoryImpl.ZERO_SIZE_MEMORY : new WritableMemoryImpl(ByteBuffer.wrap(new byte[capacityBytes]), ByteOrder.nativeOrder());
    }

    public abstract void clear();

    public abstract void clear(long arg1, long arg2);

    public abstract void clearBits(long arg1, byte arg2);

    public abstract void fill(byte arg1);

    public abstract void fill(long arg1, long arg2, byte arg3);

    public abstract Object getArray();

    public abstract ByteBuffer getByteBuffer();

    public abstract MemoryRequestServer getMemoryRequestServer();

    public abstract long getRegionOffset(long arg1);

    public abstract void putBoolean(long arg1, boolean arg2);

    public abstract void putBooleanArray(long arg1, boolean[] arg2, int arg3, int arg4);

    public abstract void putByte(long arg1, byte arg2);

    public abstract void putByteArray(long arg1, byte[] arg2, int arg3, int arg4);

    public abstract void putChar(long arg1, char arg2);

    public abstract void putCharArray(long arg1, char[] arg2, int arg3, int arg4);

    public abstract void putDouble(long arg1, double arg2);

    public abstract void putDoubleArray(long arg1, double[] arg2, int arg3, int arg4);

    public abstract void putFloat(long arg1, float arg2);

    public abstract void putFloatArray(long arg1, float[] arg2, int arg3, int arg4);

    public abstract void putInt(long arg1, int arg2);

    public abstract void putIntArray(long arg1, int[] arg2, int arg3, int arg4);

    public abstract void putLong(long arg1, long arg2);

    public abstract void putLongArray(long arg1, long[] arg2, int arg3, int arg4);

    public abstract void putShort(long arg1, short arg2);

    public abstract void putShortArray(long arg1, short[] arg2, int arg3, int arg4);

    public abstract void setBits(long arg1, byte arg2);

    public abstract void setMemoryRequest(MemoryRequestServer arg1);

    public static WritableMemory wrap(ByteBuffer byteBuf) {
        if(byteBuf.isReadOnly()) {
            throw new ReadOnlyException("ByteBuffer is read-only.");
        }
        return byteBuf.capacity() == 0 ? WritableMemoryImpl.ZERO_SIZE_MEMORY : new WritableMemoryImpl(byteBuf, ByteOrder.nativeOrder());
    }

    public static WritableMemory wrap(byte[] arr) {
        Util.nullCheck(arr);
        return arr.length == 0 ? WritableMemoryImpl.ZERO_SIZE_MEMORY : new WritableMemoryImpl(ByteBuffer.wrap(arr), ByteOrder.nativeOrder());
    }

    public static WritableMemory wrap(byte[] arr, ByteOrder byteOrder) {
        Util.nullCheck(arr);
        return arr.length == 0 ? WritableMemoryImpl.ZERO_SIZE_MEMORY : new WritableMemoryImpl(ByteBuffer.wrap(arr), byteOrder);
    }

    public abstract WritableMemory writableDuplicate();

    public abstract WritableMemory writableRegion(long arg1, long arg2);
}

