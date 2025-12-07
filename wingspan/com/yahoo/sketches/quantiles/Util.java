package com.yahoo.sketches.quantiles;

import com.yahoo.memory.Memory;
import com.yahoo.sketches.Family;
import com.yahoo.sketches.SketchesArgumentException;

final class Util {
    static class EpsilonFromK {
        static final boolean $assertionsDisabled = false;
        private static final double adjustKForEps = 1.333333;
        private static final double bracketedBinarySearchForEpsTol = 1.000000E-15;
        private static final double deltaForEps = 0.01;

        static {
        }

        private static double bracketedBinarySearchForEps(double kf, double lo, double hi) {
            if((hi - lo) / lo < 1.000000E-15) {
                return lo;
            }
            double f3 = (lo + hi) / 2.0;
            return EpsilonFromK.epsForKPredicate(f3, kf) ? EpsilonFromK.bracketedBinarySearchForEps(kf, f3, hi) : EpsilonFromK.bracketedBinarySearchForEps(kf, lo, f3);
        }

        private static boolean epsForKPredicate(double eps, double kf) {
            return EpsilonFromK.kOfEpsFormula(eps) >= kf;
        }

        static double getAdjustedEpsilon(int k) {
            return EpsilonFromK.getTheoreticalEpsilon(k, 1.333333);
        }

        private static double getTheoreticalEpsilon(int k, double ff) {
            if(k < 2) {
                throw new SketchesArgumentException("K must be greater than one.");
            }
            return EpsilonFromK.bracketedBinarySearchForEps(((double)k) * ff, 1.000000E-16, 1.0);
        }

        private static double kOfEpsFormula(double eps) {
            return 1.0 / eps * Math.sqrt(Math.log(1.0 / (eps * 0.01)));
        }
    }

    static final String LS = null;
    static final char TAB = '\t';

    static {
        Util.LS = "\n";
    }

    static void checkFamilyID(int familyID) {
        Family family0 = Family.idToFamily(familyID);
        if(!family0.equals(Family.QUANTILES)) {
            throw new SketchesArgumentException("Possible corruption: Invalid Family: " + family0.toString());
        }
    }

    static void checkHeapFlags(int flags) {
        if((flags & 0xFFFFFFE1) > 0) {
            throw new SketchesArgumentException("Possible corruption: Invalid flags field: " + Integer.toBinaryString(flags));
        }
    }

    static boolean checkIsCompactMemory(Memory srcMem) {
        return (PreambleUtil.extractFlags(srcMem) & 10) > 0;
    }

    static void checkK(int k) {
        if(k < 2 || k >= 0x10000 || !com.yahoo.sketches.Util.isPowerOf2(k)) {
            throw new SketchesArgumentException("K must be > 1 and < 65536 and Power of 2: " + k);
        }
    }

    static boolean checkPreLongsFlagsCap(int preambleLongs, int flags, long memCapBytes) {
        boolean z = (flags & 4) > 0;
        if((preambleLongs != Family.QUANTILES.getMinPreLongs() || !z) && (preambleLongs != Family.QUANTILES.getMaxPreLongs() || z)) {
            throw new SketchesArgumentException("Possible corruption: PreambleLongs inconsistent with empty state: " + preambleLongs);
        }
        Util.checkHeapFlags(flags);
        if(memCapBytes < ((long)(preambleLongs << 3))) {
            throw new SketchesArgumentException("Possible corruption: Insufficient capacity for preamble: " + memCapBytes);
        }
        return z;
    }

    static int computeBaseBufferItems(int k, long n) [...] // Inlined contents

    static long computeBitPattern(int k, long n) [...] // Inlined contents

    static int computeCombinedBufferItemCapacity(int k, long n) {
        int v2 = Util.computeNumLevelsNeeded(k, n);
        return v2 == 0 ? Math.max(4, com.yahoo.sketches.Util.ceilingPowerOf2(((int)(n % (((long)k) * 2L))))) : (v2 + 2) * k;
    }

    static int computeNumLevelsNeeded(int k, long n) {
        return Util.hiBitPos(n / (((long)k) * 2L)) + 1;
    }

    static int computeRetainedItems(int k, long n) {
        return ((int)(n % (((long)k) * 2L))) + Util.computeValidLevels(n / (((long)k) * 2L)) * k;
    }

    static int computeTotalLevels(long bitPattern) {
        return Util.hiBitPos(bitPattern) + 1;
    }

    static int computeValidLevels(long bitPattern) {
        return Long.bitCount(bitPattern);
    }

    static int hiBitPos(long num) {
        return 0x3F - Long.numberOfLeadingZeros(num);
    }

    static double lg(double x) {
        return Math.log(x) / 0.693147;
    }

    static int lowestZeroBitStartingAt(long bits, int startingBit) {
        int v2 = startingBit & 0x3F;
        long v3 = bits >>> v2;
        while((1L & v3) != 0L) {
            v3 >>>= 1;
            ++v2;
        }
        return v2;
    }

    static final void validateFractions(double[] fractions) {
        if(fractions == null) {
            throw new SketchesArgumentException("Fractions cannot be null.");
        }
        if(fractions.length == 0) {
            return;
        }
        if(fractions[0] < 0.0 || fractions[fractions.length - 1] > 1.0) {
            throw new SketchesArgumentException("A fraction cannot be less than zero or greater than 1.0");
        }
        Util.validateValues(fractions);
    }

    static final void validateValues(double[] values) {
        if(values == null) {
            throw new SketchesArgumentException("Values cannot be null.");
        }
        int v = values.length - 1;
        int v1 = 0;
        while(v1 < v) {
            double f = values[v1];
            ++v1;
            if(f >= values[v1]) {
                throw new SketchesArgumentException("Values must be unique, monotonically increasing and not NaN.");
            }
            if(false) {
                break;
            }
        }
    }
}

