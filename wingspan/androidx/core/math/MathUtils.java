package androidx.core.math;

public class MathUtils {
    public static int addExact(int v, int v1) {
        int v2 = v + v1;
        if(((v ^ v2) & (v1 ^ v2)) < 0) {
            throw new ArithmeticException("integer overflow");
        }
        return v2;
    }

    public static long addExact(long v, long v1) {
        long v2 = v + v1;
        if(((v ^ v2) & (v1 ^ v2)) < 0L) {
            throw new ArithmeticException("long overflow");
        }
        return v2;
    }

    public static double clamp(double f, double f1, double f2) {
        if(f < f1) {
            return f1;
        }
        return f > f2 ? f2 : f;
    }

    public static float clamp(float f, float f1, float f2) {
        if(f < f1) {
            return f1;
        }
        return f > f2 ? f2 : f;
    }

    public static int clamp(int v, int v1, int v2) {
        if(v < v1) {
            return v1;
        }
        return v <= v2 ? v : v2;
    }

    public static long clamp(long v, long v1, long v2) {
        if(v < v1) {
            return v1;
        }
        return v <= v2 ? v : v2;
    }

    public static int decrementExact(int v) {
        if(v == 0x80000000) {
            throw new ArithmeticException("integer overflow");
        }
        return v - 1;
    }

    public static long decrementExact(long v) {
        if(v == 0x8000000000000000L) {
            throw new ArithmeticException("long overflow");
        }
        return v - 1L;
    }

    public static int incrementExact(int v) {
        if(v == 0x7FFFFFFF) {
            throw new ArithmeticException("integer overflow");
        }
        return v + 1;
    }

    public static long incrementExact(long v) {
        if(v == 0x7FFFFFFFFFFFFFFFL) {
            throw new ArithmeticException("long overflow");
        }
        return v + 1L;
    }

    public static int multiplyExact(int v, int v1) {
        long v2 = ((long)v) * ((long)v1);
        if(((long)(((int)v2))) != v2) {
            throw new ArithmeticException("integer overflow");
        }
        return (int)v2;
    }

    public static long multiplyExact(long v, long v1) {
        long v2 = v * v1;
        if((Math.abs(v) | Math.abs(v1)) >>> 0x1F != 0L && (v1 != 0L && v2 / v1 != v || v == 0x8000000000000000L && v1 == -1L)) {
            throw new ArithmeticException("long overflow");
        }
        return v2;
    }

    public static int negateExact(int v) {
        if(v == 0x80000000) {
            throw new ArithmeticException("integer overflow");
        }
        return -v;
    }

    public static long negateExact(long v) {
        if(v == 0x8000000000000000L) {
            throw new ArithmeticException("long overflow");
        }
        return -v;
    }

    public static int subtractExact(int v, int v1) {
        int v2 = v - v1;
        if(((v ^ v2) & (v1 ^ v)) < 0) {
            throw new ArithmeticException("integer overflow");
        }
        return v2;
    }

    public static long subtractExact(long v, long v1) {
        long v2 = v - v1;
        if(((v ^ v2) & (v1 ^ v)) < 0L) {
            throw new ArithmeticException("long overflow");
        }
        return v2;
    }

    public static int toIntExact(long v) {
        if(((long)(((int)v))) != v) {
            throw new ArithmeticException("integer overflow");
        }
        return (int)v;
    }
}

