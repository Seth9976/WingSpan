package com.yahoo.sketches;

public final class Util {
    static final boolean $assertionsDisabled = false;
    public static final double LOG2 = 0.0;
    public static final String LS = null;
    public static final char TAB = '\t';

    static {
        Util.LS = "\n";
        Util.LOG2 = 0.693147;
    }

    public static int bytesToInt(byte[] arr) {
        int v = 0;
        for(int v1 = 0; v1 < 4; ++v1) {
            v |= (arr[v1] & 0xFF) << v1 * 8;
        }
        return v;
    }

    public static long bytesToLong(byte[] arr) {
        long v = 0L;
        for(int v1 = 0; v1 < 8; ++v1) {
            v |= (((long)arr[v1]) & 0xFFL) << v1 * 8;
        }
        return v;
    }

    public static String bytesToString(byte[] arr, boolean signed, boolean littleEndian, String sep) {
        StringBuilder stringBuilder0 = new StringBuilder();
        int v = arr.length;
        if(littleEndian) {
            for(int v1 = 0; v1 < v - 1; ++v1) {
                stringBuilder0.append(arr[v1] & (signed ? -1 : 0xFF));
                stringBuilder0.append(sep);
            }
            stringBuilder0.append(arr[v - 1] & (signed ? -1 : 0xFF));
            return stringBuilder0.toString();
        }
        while(v > 1) {
            stringBuilder0.append(arr[v - 1] & (signed ? -1 : 0xFF));
            stringBuilder0.append(sep);
            --v;
        }
        stringBuilder0.append(arr[0] & (signed ? -1 : 0xFF));
        return stringBuilder0.toString();
    }

    public static int ceilingPowerOf2(int n) {
        if(n <= 1) {
            return 1;
        }
        return n >= 0x40000000 ? 0x40000000 : Integer.highestOneBit(n - 1 << 1);
    }

    public static final String characterPad(String s, int fieldLength, char padChar, boolean postpend) {
        char[] arr_c = s.toCharArray();
        int v1 = arr_c.length;
        if(v1 < fieldLength) {
            char[] arr_c1 = new char[fieldLength];
            int v2 = fieldLength - v1;
            int v3 = 0;
            if(postpend) {
                while(v3 < v1) {
                    arr_c1[v3] = arr_c[v3];
                    ++v3;
                }
                while(v1 < fieldLength) {
                    arr_c1[v1] = padChar;
                    ++v1;
                }
                return String.valueOf(arr_c1);
            }
            while(v3 < v2) {
                arr_c1[v3] = padChar;
                ++v3;
            }
            for(int v4 = v2; v4 < fieldLength; ++v4) {
                arr_c1[v4] = arr_c[v4 - v2];
            }
            return String.valueOf(arr_c1);
        }
        return s;
    }

    public static void checkIfMultipleOf8AndGT0(long v, String argName) {
        if((7L & v) != 0L || v <= 0L) {
            throw new SketchesArgumentException("The value of the parameter \"" + argName + "\" must be a positive multiple of 8 and greater than zero: " + v);
        }
    }

    public static void checkIfPowerOf2(int v, String argName) {
        if(v <= 0 || (v - 1 & v) != 0) {
            throw new SketchesArgumentException("The value of the parameter \"" + argName + "\" must be a positive integer-power of 2 and greater than 0: " + v);
        }
    }

    public static void checkProbability(double p, String argName) {
        if(p < 0.0 || p > 1.0) {
            throw new SketchesArgumentException("The value of the parameter \"" + argName + "\" must be between 0.0 inclusive and 1.0 inclusive: " + p);
        }
    }

    public static final short checkSeedHashes(short seedHashA, short seedHashB) {
        if(seedHashA != seedHashB) {
            throw new SketchesArgumentException("Incompatible Seed Hashes. " + ((int)seedHashA) + ", " + ((int)seedHashB));
        }
        return seedHashA;
    }

    public static int[] evenlyLgSpaced(int lgStart, int lgEnd, int points) {
        if(points <= 0) {
            throw new SketchesArgumentException("points must be > 0");
        }
        if(lgEnd < 0 || lgStart < 0) {
            throw new SketchesArgumentException("lgStart and lgEnd must be >= 0.");
        }
        int[] arr_v = new int[points];
        arr_v[0] = 1 << lgStart;
        if(points == 1) {
            return arr_v;
        }
        for(int v3 = 1; v3 < points; ++v3) {
            arr_v[v3] = (int)Math.round(Math.pow(2.0, ((double)v3) * (((double)(lgEnd - lgStart)) / (((double)points) - 1.0)) + ((double)lgStart)));
        }
        return arr_v;
    }

    public static int floorPowerOf2(int n) {
        return n > 1 ? Integer.highestOneBit(n) : 1;
    }

    public static byte[] intToBytes(int v, byte[] arr) {
        for(int v1 = 0; v1 < 4; ++v1) {
            arr[v1] = (byte)(v & 0xFF);
            v >>>= 8;
        }
        return arr;
    }

    public static double invPow2(int e) {
        return Double.longBitsToDouble(0x3FFL - ((long)e) << 52);
    }

    public static boolean isLessThanUnsigned(long n1, long n2) {
        int v2 = 1;
        int v3 = Long.compare(n1, n2) >= 0 ? 0 : 1;
        if((n1 >= 0L ? 0 : 1) == (n2 >= 0L ? 0 : 1)) {
            v2 = 0;
        }
        return v3 ^ v2;
    }

    public static boolean isMultipleOf8AndGT0(long v) {
        return (7L & v) == 0L && v > 0L;
    }

    public static boolean isPowerOf2(int v) {
        return v > 0 && (v & v - 1) == 0;
    }

    public static final double log2(double value) {
        return Math.log(value) / Util.LOG2;
    }

    public static byte[] longToBytes(long v, byte[] arr) {
        for(int v1 = 0; v1 < 8; ++v1) {
            arr[v1] = (byte)(((int)(0xFFL & v)));
            v >>>= 8;
        }
        return arr;
    }

    public static String longToHexBytes(long v) {
        StringBuilder stringBuilder0 = new StringBuilder();
        for(int v1 = 8; v1 > 0; --v1) {
            stringBuilder0.append(Util.zeroPad(Long.toHexString(v >>> (v1 - 1) * 8 & 0xFFL), 2));
            stringBuilder0.append(" ");
        }
        return stringBuilder0.toString();
    }

    public static String milliSecToString(long mS) {
        String s = Util.zeroPad(Long.toString(((long)(((double)mS) % 1000.0))), 3);
        String s1 = Util.zeroPad(Long.toString(((long)(((double)mS) / 1000.0 % 60.0))), 2);
        return String.format("%d:%2s:%2s.%3s", ((long)(((double)mS) / 3600000.0)), Util.zeroPad(Long.toString(((long)(((double)mS) / 60000.0 % 60.0))), 2), s1, s);
    }

    public static String nanoSecToString(long nS) {
        String s = Util.zeroPad(Long.toString(((long)(((double)nS) % 1000.0))), 3);
        String s1 = Util.zeroPad(Long.toString(((long)(((double)nS) / 1000.0 % 1000.0))), 3);
        return String.format("%d.%3s %3s %3s", ((long)(((double)nS) / 1000000000.0)), Util.zeroPad(Long.toString(((long)(((double)nS) / 1000000.0 % 1000.0))), 3), s1, s);
    }

    public static final int pwr2LawNext(int ppo, int curPoint) {
        int v3;
        int v2 = (int)Math.round(Util.log2((curPoint >= 1 ? curPoint : 1)) * ((double)ppo));
        do {
            ++v2;
            v3 = (int)Math.round(Math.pow(2.0, ((double)v2) / ((double)ppo)));
        }
        while(v3 <= curPoint);
        return v3;
    }

    public static final int pwr2LawPrev(int ppo, int curPoint) {
        int v3;
        if(curPoint <= 1) {
            return 0;
        }
        int v2 = (int)Math.round(Util.log2(curPoint) * ((double)ppo));
        do {
            --v2;
            v3 = (int)Math.round(Math.pow(2.0, ((double)v2) / ((double)ppo)));
        }
        while(v3 >= curPoint && v3 > 1);
        return v3;
    }

    public static int simpleIntLog2(int x) {
        return Integer.numberOfTrailingZeros(x);
    }

    public static final int startingSubMultiple(int lgTarget, ResizeFactor rf, int lgMin) {
        int v2 = rf.lg();
        if(lgTarget <= lgMin) {
            return lgMin;
        }
        return v2 == 0 ? lgTarget : (lgTarget - lgMin) % v2 + lgMin;
    }

    public static int toLog2(int value, String argName) {
        Util.checkIfPowerOf2(value, argName);
        return Integer.numberOfTrailingZeros(value);
    }

    public static final String zeroPad(String s, int fieldLength) {
        return Util.characterPad(s, fieldLength, '0', false);
    }
}

