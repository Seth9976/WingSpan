package com.yahoo.memory;

public final class Util {
    static final boolean $assertionsDisabled = false;
    public static final int BOOLEAN_SHIFT = 0;
    public static final int BYTE_SHIFT = 0;
    public static final int CHAR_SHIFT = 1;
    public static final int DOUBLE_SHIFT = 3;
    public static final int FLOAT_SHIFT = 2;
    public static final int INT_SHIFT = 2;
    public static final int LONG_SHIFT = 3;
    static final String LS = null;
    public static final int SHORT_SHIFT = 1;

    static {
        Util.LS = "\n";
    }

    public static void assertBounds(long reqOff, long reqLen, long allocSize) {
    }

    public static void checkBounds(long reqOff, long reqLen, long allocSize) {
        long v3 = reqLen + reqOff;
        if((reqOff | reqLen | v3 | allocSize - v3) < 0L) {
            throw new IllegalArgumentException("reqOffset: " + reqOff + ", reqLength: , (reqOff + reqLen): " + v3 + ", allocSize: " + allocSize);
        }
    }

    public static boolean checkOverlap(long srcOff, long dstOff, long length) {
        return Math.min(srcOff, dstOff) + length <= Math.max(srcOff, dstOff);
    }

    static final void nullCheck(Object obj) {
        if(obj == null) {
            throw new IllegalArgumentException("An input argument is null.");
        }
    }
}

