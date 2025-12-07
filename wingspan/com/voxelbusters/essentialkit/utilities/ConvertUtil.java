package com.voxelbusters.essentialkit.utilities;

public class ConvertUtil {
    public static boolean ToBoolean(Object object0) {
        if(object0 instanceof Boolean) {
            return ((Boolean)object0).booleanValue();
        }
        if(object0 instanceof Number) {
            return ((Number)object0).longValue() != 0L;
        }
        try {
            return Boolean.parseBoolean(object0.toString());
        }
        catch(Exception unused_ex) {
            return false;
        }
    }

    public static double ToDouble(Object object0) {
        if(object0 instanceof Number) {
            return ((Number)object0).doubleValue();
        }
        if(object0 instanceof Boolean) {
            return ((Boolean)object0).booleanValue() ? 1.0 : 0.0;
        }
        try {
            return Double.parseDouble(object0.toString());
        }
        catch(Exception unused_ex) {
            return 0.0;
        }
    }

    public static float ToFloat(Object object0) {
        if(object0 instanceof Number) {
            return ((Number)object0).floatValue();
        }
        if(object0 instanceof Boolean) {
            return ((Boolean)object0).booleanValue() ? 1.0f : 0.0f;
        }
        try {
            return Float.parseFloat(object0.toString());
        }
        catch(Exception unused_ex) {
            return 0.0f;
        }
    }

    public static int ToInt(Object object0) {
        if(object0 instanceof Number) {
            return ((Number)object0).intValue();
        }
        if(object0 instanceof Boolean) {
            return ((Boolean)object0).booleanValue();
        }
        try {
            return Integer.parseInt(object0.toString());
        }
        catch(Exception unused_ex) {
            return 0;
        }
    }

    public static long ToLong(Object object0) {
        if(object0 instanceof Number) {
            return ((Number)object0).longValue();
        }
        if(object0 instanceof Boolean) {
            return ((Boolean)object0).booleanValue() ? 1L : 0L;
        }
        try {
            return Long.parseLong(object0.toString());
        }
        catch(Exception unused_ex) {
            return 0L;
        }
    }
}

