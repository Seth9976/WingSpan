package com.yahoo.memory;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class Memory {
    public abstract void checkBounds(long arg1, long arg2);

    public abstract int compareTo(long arg1, long arg2, Memory arg3, long arg4, long arg5);

    public abstract void copyTo(long arg1, WritableMemory arg2, long arg3, long arg4);

    public abstract boolean getBoolean(long arg1);

    public abstract void getBooleanArray(long arg1, boolean[] arg2, int arg3, int arg4);

    public abstract byte getByte(long arg1);

    public abstract void getByteArray(long arg1, byte[] arg2, int arg3, int arg4);

    public abstract long getCapacity();

    public abstract char getChar(long arg1);

    public abstract void getCharArray(long arg1, char[] arg2, int arg3, int arg4);

    public abstract double getDouble(long arg1);

    public abstract void getDoubleArray(long arg1, double[] arg2, int arg3, int arg4);

    public abstract float getFloat(long arg1);

    public abstract void getFloatArray(long arg1, float[] arg2, int arg3, int arg4);

    public abstract int getInt(long arg1);

    public abstract void getIntArray(long arg1, int[] arg2, int arg3, int arg4);

    public abstract long getLong(long arg1);

    public abstract void getLongArray(long arg1, long[] arg2, int arg3, int arg4);

    public abstract ByteOrder getResourceOrder();

    public abstract short getShort(long arg1);

    public abstract void getShortArray(long arg1, short[] arg2, int arg3, int arg4);

    public abstract boolean hasArray();

    public abstract boolean hasByteBuffer();

    public abstract boolean isDirect();

    public abstract boolean isResourceReadOnly();

    public abstract boolean isSameResource(Memory arg1);

    public abstract Memory region(long arg1, long arg2);

    public abstract boolean swapBytes();

    static String toHex(String preamble, long offsetBytes, int lengthBytes, Memory mem) {
        return WritableMemoryImpl.toHex(preamble, offsetBytes, lengthBytes, mem);
    }

    public abstract String toHexString(String arg1, long arg2, int arg3);

    public static Memory wrap(ByteBuffer byteBuf) {
        return byteBuf == null || byteBuf.capacity() != 0 ? new WritableMemoryImpl(byteBuf, ByteOrder.nativeOrder()) : WritableMemoryImpl.ZERO_SIZE_MEMORY;
    }

    public static Memory wrap(byte[] arr) {
        ByteOrder byteOrder0 = ByteOrder.nativeOrder();
        return Memory.wrap(arr, 0, arr.length, byteOrder0);
    }

    public static Memory wrap(byte[] arr, int offset, int length, ByteOrder byteOrder) {
        Util.nullCheck(arr);
        Util.nullCheck(byteOrder);
        Util.checkBounds(offset, length, arr.length);
        return length == 0 ? WritableMemoryImpl.ZERO_SIZE_MEMORY : new WritableMemoryImpl(ByteBuffer.wrap(arr), byteOrder);
    }

    public static Memory wrap(byte[] arr, ByteOrder byteOrder) {
        return Memory.wrap(arr, 0, arr.length, byteOrder);
    }
}

