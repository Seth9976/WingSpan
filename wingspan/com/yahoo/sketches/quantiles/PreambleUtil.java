package com.yahoo.sketches.quantiles;

import com.yahoo.memory.Memory;
import com.yahoo.memory.WritableMemory;
import com.yahoo.sketches.Family;
import java.nio.ByteOrder;

final class PreambleUtil {
    static final int BIG_ENDIAN_FLAG_MASK = 1;
    static final int COMBINED_BUFFER = 0x20;
    static final int COMPACT_FLAG_MASK = 8;
    static final int DEFAULT_K = 0x80;
    static final int EMPTY_FLAG_MASK = 4;
    static final int FAMILY_BYTE = 2;
    static final int FLAGS_BYTE = 3;
    static final int K_SHORT = 4;
    static final int MAX_DOUBLE = 24;
    static final int MIN_DOUBLE = 16;
    static final boolean NATIVE_ORDER_IS_BIG_ENDIAN = false;
    static final int N_LONG = 8;
    static final int ORDERED_FLAG_MASK = 16;
    static final int PREAMBLE_LONGS_BYTE = 0;
    static final int READ_ONLY_FLAG_MASK = 2;
    static final int SER_VER_BYTE = 1;

    static {
        PreambleUtil.NATIVE_ORDER_IS_BIG_ENDIAN = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    static int extractFamilyID(Memory mem) {
        return mem.getByte(2L) & 0xFF;
    }

    static int extractFlags(Memory mem) {
        return mem.getByte(3L) & 0xFF;
    }

    static int extractK(Memory mem) {
        return mem.getShort(4L) & 0xFFFF;
    }

    static double extractMaxDouble(Memory mem) {
        return mem.getDouble(24L);
    }

    static double extractMinDouble(Memory mem) {
        return mem.getDouble(16L);
    }

    static long extractN(Memory mem) {
        return mem.getLong(8L);
    }

    static int extractPreLongs(Memory mem) {
        return mem.getByte(0L) & 0xFF;
    }

    static int extractSerVer(Memory mem) {
        return mem.getByte(1L) & 0xFF;
    }

    static void insertFamilyID(WritableMemory wmem, int value) {
        wmem.putByte(2L, ((byte)value));
    }

    static void insertFlags(WritableMemory wmem, int value) {
        wmem.putByte(3L, ((byte)value));
    }

    static void insertK(WritableMemory wmem, int value) {
        wmem.putShort(4L, ((short)value));
    }

    static void insertMaxDouble(WritableMemory wmem, double value) {
        wmem.putDouble(24L, value);
    }

    static void insertMinDouble(WritableMemory wmem, double value) {
        wmem.putDouble(16L, value);
    }

    static void insertN(WritableMemory wmem, long value) {
        wmem.putLong(8L, value);
    }

    static void insertPreLongs(WritableMemory wmem, int value) {
        wmem.putByte(0L, ((byte)value));
    }

    static void insertSerVer(WritableMemory wmem, int value) {
        wmem.putByte(1L, ((byte)value));
    }

    private static String memoryToString(Memory srcMem, boolean isDoublesSketch) {
        double f1;
        double f;
        int v = PreambleUtil.extractPreLongs(srcMem);
        int v1 = PreambleUtil.extractSerVer(srcMem);
        String s = Family.idToFamily(PreambleUtil.extractFamilyID(srcMem)).toString();
        int v2 = PreambleUtil.extractFlags(srcMem);
        int v3 = PreambleUtil.extractK(srcMem);
        long v4 = v == 1 ? 0L : PreambleUtil.extractN(srcMem);
        if(v <= 1 || !isDoublesSketch) {
            f = NaN;
            f1 = NaN;
        }
        else {
            f = PreambleUtil.extractMinDouble(srcMem);
            f1 = PreambleUtil.extractMaxDouble(srcMem);
        }
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append("\n");
        stringBuilder0.append("### QUANTILES SKETCH PREAMBLE SUMMARY:");
        stringBuilder0.append("\n");
        stringBuilder0.append("Byte  0: Preamble Longs       : ");
        stringBuilder0.append(v);
        stringBuilder0.append("\n");
        stringBuilder0.append("Byte  1: Serialization Version: ");
        stringBuilder0.append(v1);
        stringBuilder0.append("\n");
        stringBuilder0.append("Byte  2: Family               : ");
        stringBuilder0.append(s);
        stringBuilder0.append("\n");
        stringBuilder0.append("Byte  3: Flags Field          : ");
        stringBuilder0.append(String.format("%02o", v2));
        stringBuilder0.append("\n");
        stringBuilder0.append("  BIG ENDIAN                  : ");
        stringBuilder0.append((v2 & 1) > 0);
        stringBuilder0.append("\n");
        stringBuilder0.append("  (Native Byte Order)         : ");
        stringBuilder0.append("LITTLE_ENDIAN");
        stringBuilder0.append("\n");
        stringBuilder0.append("  READ ONLY                   : ");
        stringBuilder0.append((v2 & 2) > 0);
        stringBuilder0.append("\n");
        stringBuilder0.append("  EMPTY                       : ");
        stringBuilder0.append((v2 & 4) > 0);
        stringBuilder0.append("\n");
        stringBuilder0.append("  COMPACT                     : ");
        stringBuilder0.append((v2 & 8) > 0);
        stringBuilder0.append("\n");
        stringBuilder0.append("  ORDERED                     : ");
        stringBuilder0.append((v2 & 16) > 0);
        stringBuilder0.append("\n");
        stringBuilder0.append("Bytes  4-5  : K               : ");
        stringBuilder0.append(v3);
        stringBuilder0.append("\n");
        if(v == 1) {
            stringBuilder0.append(" --ABSENT, ASSUMED:");
            stringBuilder0.append("\n");
        }
        stringBuilder0.append("Bytes  8-15 : N                : ");
        stringBuilder0.append(v4);
        stringBuilder0.append("\n");
        if(isDoublesSketch) {
            stringBuilder0.append("MinDouble                      : ");
            stringBuilder0.append(f);
            stringBuilder0.append("\n");
            stringBuilder0.append("MaxDouble                      : ");
            stringBuilder0.append(f1);
            stringBuilder0.append("\n");
        }
        stringBuilder0.append("Retained Items                 : ");
        stringBuilder0.append(Util.computeRetainedItems(v3, v4));
        stringBuilder0.append("\n");
        stringBuilder0.append("Total Bytes                    : ");
        stringBuilder0.append(srcMem.getCapacity());
        stringBuilder0.append("\n");
        stringBuilder0.append("### END SKETCH PREAMBLE SUMMARY");
        stringBuilder0.append("\n");
        return stringBuilder0.toString();
    }

    static String toString(Memory mem, boolean isDoublesSketch) {
        return PreambleUtil.memoryToString(mem, isDoublesSketch);
    }

    static String toString(byte[] byteArr, boolean isDoublesSketch) {
        return PreambleUtil.toString(Memory.wrap(byteArr), isDoublesSketch);
    }
}

