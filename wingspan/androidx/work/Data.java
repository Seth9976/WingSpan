package androidx.work;

import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;

public final class Data {
    public static final class Builder {
        private Map mValues;

        public Builder() {
            this.mValues = new HashMap();
        }

        public Data build() {
            Data data0 = new Data(this.mValues);
            Data.toByteArrayInternal(data0);
            return data0;
        }

        public Builder put(String key, Object value) {
            if(value == null) {
                this.mValues.put(key, null);
                return this;
            }
            Class class0 = value.getClass();
            if(class0 != Boolean.class && class0 != Byte.class && class0 != Integer.class && class0 != Long.class && class0 != Float.class && class0 != Double.class && class0 != String.class && class0 != Boolean[].class && class0 != Byte[].class && class0 != Integer[].class && class0 != Long[].class && class0 != Float[].class && class0 != Double[].class && class0 != String[].class) {
                if(class0 == boolean[].class) {
                    this.mValues.put(key, Data.convertPrimitiveBooleanArray(((boolean[])value)));
                    return this;
                }
                if(class0 == byte[].class) {
                    this.mValues.put(key, Data.convertPrimitiveByteArray(((byte[])value)));
                    return this;
                }
                if(class0 == int[].class) {
                    this.mValues.put(key, Data.convertPrimitiveIntArray(((int[])value)));
                    return this;
                }
                if(class0 == long[].class) {
                    this.mValues.put(key, Data.convertPrimitiveLongArray(((long[])value)));
                    return this;
                }
                if(class0 == float[].class) {
                    this.mValues.put(key, Data.convertPrimitiveFloatArray(((float[])value)));
                    return this;
                }
                if(class0 != double[].class) {
                    throw new IllegalArgumentException("Key " + key + "has invalid type " + class0);
                }
                this.mValues.put(key, Data.convertPrimitiveDoubleArray(((double[])value)));
                return this;
            }
            this.mValues.put(key, value);
            return this;
        }

        public Builder putAll(Data data) {
            this.putAll(data.mValues);
            return this;
        }

        public Builder putAll(Map values) {
            for(Object object0: values.entrySet()) {
                this.put(((String)((Map.Entry)object0).getKey()), ((Map.Entry)object0).getValue());
            }
            return this;
        }

        public Builder putBoolean(String key, boolean value) {
            this.mValues.put(key, Boolean.valueOf(value));
            return this;
        }

        public Builder putBooleanArray(String key, boolean[] value) {
            this.mValues.put(key, Data.convertPrimitiveBooleanArray(value));
            return this;
        }

        public Builder putByte(String key, byte value) {
            this.mValues.put(key, value);
            return this;
        }

        public Builder putByteArray(String key, byte[] value) {
            this.mValues.put(key, Data.convertPrimitiveByteArray(value));
            return this;
        }

        public Builder putDouble(String key, double value) {
            this.mValues.put(key, value);
            return this;
        }

        public Builder putDoubleArray(String key, double[] value) {
            this.mValues.put(key, Data.convertPrimitiveDoubleArray(value));
            return this;
        }

        public Builder putFloat(String key, float value) {
            this.mValues.put(key, value);
            return this;
        }

        public Builder putFloatArray(String key, float[] value) {
            this.mValues.put(key, Data.convertPrimitiveFloatArray(value));
            return this;
        }

        public Builder putInt(String key, int value) {
            this.mValues.put(key, value);
            return this;
        }

        public Builder putIntArray(String key, int[] value) {
            this.mValues.put(key, Data.convertPrimitiveIntArray(value));
            return this;
        }

        public Builder putLong(String key, long value) {
            this.mValues.put(key, value);
            return this;
        }

        public Builder putLongArray(String key, long[] value) {
            this.mValues.put(key, Data.convertPrimitiveLongArray(value));
            return this;
        }

        public Builder putString(String key, String value) {
            this.mValues.put(key, value);
            return this;
        }

        public Builder putStringArray(String key, String[] value) {
            this.mValues.put(key, value);
            return this;
        }
    }

    public static final Data EMPTY = null;
    public static final int MAX_DATA_BYTES = 0x2800;
    private static final String TAG;
    Map mValues;

    static {
        Data.TAG = "WM-Data";
        Data.EMPTY = new Builder().build();
    }

    Data() {
    }

    public Data(Data other) {
        this.mValues = new HashMap(other.mValues);
    }

    public Data(Map values) {
        this.mValues = new HashMap(values);
    }

    public static Boolean[] convertPrimitiveBooleanArray(boolean[] value) {
        Boolean[] arr_boolean = new Boolean[value.length];
        for(int v = 0; v < value.length; ++v) {
            arr_boolean[v] = Boolean.valueOf(value[v]);
        }
        return arr_boolean;
    }

    public static Byte[] convertPrimitiveByteArray(byte[] value) {
        Byte[] arr_byte = new Byte[value.length];
        for(int v = 0; v < value.length; ++v) {
            arr_byte[v] = (byte)value[v];
        }
        return arr_byte;
    }

    public static Double[] convertPrimitiveDoubleArray(double[] value) {
        Double[] arr_double = new Double[value.length];
        for(int v = 0; v < value.length; ++v) {
            arr_double[v] = (double)value[v];
        }
        return arr_double;
    }

    public static Float[] convertPrimitiveFloatArray(float[] value) {
        Float[] arr_float = new Float[value.length];
        for(int v = 0; v < value.length; ++v) {
            arr_float[v] = (float)value[v];
        }
        return arr_float;
    }

    public static Integer[] convertPrimitiveIntArray(int[] value) {
        Integer[] arr_integer = new Integer[value.length];
        for(int v = 0; v < value.length; ++v) {
            arr_integer[v] = (int)value[v];
        }
        return arr_integer;
    }

    public static Long[] convertPrimitiveLongArray(long[] value) {
        Long[] arr_long = new Long[value.length];
        for(int v = 0; v < value.length; ++v) {
            arr_long[v] = (long)value[v];
        }
        return arr_long;
    }

    public static byte[] convertToPrimitiveArray(Byte[] array) {
        byte[] arr_b = new byte[array.length];
        for(int v = 0; v < array.length; ++v) {
            arr_b[v] = (byte)array[v];
        }
        return arr_b;
    }

    public static double[] convertToPrimitiveArray(Double[] array) {
        double[] arr_f = new double[array.length];
        for(int v = 0; v < array.length; ++v) {
            arr_f[v] = (double)array[v];
        }
        return arr_f;
    }

    public static float[] convertToPrimitiveArray(Float[] array) {
        float[] arr_f = new float[array.length];
        for(int v = 0; v < array.length; ++v) {
            arr_f[v] = (float)array[v];
        }
        return arr_f;
    }

    public static int[] convertToPrimitiveArray(Integer[] array) {
        int[] arr_v = new int[array.length];
        for(int v = 0; v < array.length; ++v) {
            arr_v[v] = (int)array[v];
        }
        return arr_v;
    }

    public static long[] convertToPrimitiveArray(Long[] array) {
        long[] arr_v = new long[array.length];
        for(int v = 0; v < array.length; ++v) {
            arr_v[v] = (long)array[v];
        }
        return arr_v;
    }

    public static boolean[] convertToPrimitiveArray(Boolean[] array) {
        boolean[] arr_z = new boolean[array.length];
        for(int v = 0; v < array.length; ++v) {
            arr_z[v] = array[v].booleanValue();
        }
        return arr_z;
    }

    @Override
    public boolean equals(Object o) {
        boolean z;
        if(this == o) {
            return true;
        }
        if(o != null && this.getClass() == o.getClass()) {
            Set set0 = this.mValues.keySet();
            if(!set0.equals(((Data)o).mValues.keySet())) {
                return false;
            }
            for(Object object1: set0) {
                Object object2 = this.mValues.get(((String)object1));
                Object object3 = ((Data)o).mValues.get(((String)object1));
                if(object2 == null || object3 == null) {
                    z = object2 == object3;
                }
                else if(!(object2 instanceof Object[]) || !(object3 instanceof Object[])) {
                    z = object2.equals(object3);
                }
                else {
                    z = Arrays.deepEquals(((Object[])object2), ((Object[])object3));
                }
                if(!z) {
                    return false;
                }
                if(false) {
                    break;
                }
            }
            return true;
        }
        return false;
    }

    public static Data fromByteArray(byte[] bytes) {
        Throwable throwable1;
        IOException iOException1;
        ObjectInputStream objectInputStream0;
        if(bytes.length <= 0x2800) {
            HashMap hashMap0 = new HashMap();
            ByteArrayInputStream byteArrayInputStream0 = new ByteArrayInputStream(bytes);
            try {
                objectInputStream0 = null;
                objectInputStream0 = new ObjectInputStream(byteArrayInputStream0);
            }
            catch(IOException | ClassNotFoundException iOException0) {
                iOException1 = iOException0;
                goto label_18;
            }
            catch(Throwable throwable0) {
                throwable1 = throwable0;
                goto label_27;
            }
            try {
                int v = objectInputStream0.readInt();
                while(true) {
                    if(v <= 0) {
                        goto label_37;
                    }
                    hashMap0.put(objectInputStream0.readUTF(), objectInputStream0.readObject());
                    --v;
                }
            }
            catch(IOException | ClassNotFoundException iOException1) {
                try {
                label_18:
                    Log.e("WM-Data", "Error in Data#fromByteArray: ", iOException1);
                    if(objectInputStream0 != null) {
                        goto label_20;
                    }
                    goto label_24;
                }
                catch(Throwable throwable1) {
                    goto label_27;
                }
                try {
                label_20:
                    objectInputStream0.close();
                }
                catch(IOException iOException2) {
                    Log.e("WM-Data", "Error in Data#fromByteArray: ", iOException2);
                }
                try {
                label_24:
                    byteArrayInputStream0.close();
                }
                catch(IOException iOException3) {
                    Log.e("WM-Data", "Error in Data#fromByteArray: ", iOException3);
                    return new Data(hashMap0);
                }
                return new Data(hashMap0);
            }
            catch(Throwable throwable1) {
            }
        label_27:
            if(objectInputStream0 != null) {
                try {
                    objectInputStream0.close();
                }
                catch(IOException iOException4) {
                    Log.e("WM-Data", "Error in Data#fromByteArray: ", iOException4);
                }
            }
            try {
                byteArrayInputStream0.close();
            }
            catch(IOException iOException5) {
                Log.e("WM-Data", "Error in Data#fromByteArray: ", iOException5);
            }
            throw throwable1;
            try {
            label_37:
                objectInputStream0.close();
            }
            catch(IOException iOException6) {
                Log.e("WM-Data", "Error in Data#fromByteArray: ", iOException6);
            }
            try {
                byteArrayInputStream0.close();
                return new Data(hashMap0);
            }
            catch(IOException iOException3) {
                Log.e("WM-Data", "Error in Data#fromByteArray: ", iOException3);
                return new Data(hashMap0);
            }
        }
        throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        Object object0 = this.mValues.get(key);
        return object0 instanceof Boolean ? ((Boolean)object0).booleanValue() : defaultValue;
    }

    public boolean[] getBooleanArray(String key) {
        Object object0 = this.mValues.get(key);
        return object0 instanceof Boolean[] ? Data.convertToPrimitiveArray(((Boolean[])object0)) : null;
    }

    public byte getByte(String key, byte defaultValue) {
        Object object0 = this.mValues.get(key);
        return object0 instanceof Byte ? ((byte)(((Byte)object0))) : defaultValue;
    }

    public byte[] getByteArray(String key) {
        Object object0 = this.mValues.get(key);
        return object0 instanceof Byte[] ? Data.convertToPrimitiveArray(((Byte[])object0)) : null;
    }

    public double getDouble(String key, double defaultValue) {
        Object object0 = this.mValues.get(key);
        return object0 instanceof Double ? ((double)(((Double)object0))) : defaultValue;
    }

    public double[] getDoubleArray(String key) {
        Object object0 = this.mValues.get(key);
        return object0 instanceof Double[] ? Data.convertToPrimitiveArray(((Double[])object0)) : null;
    }

    public float getFloat(String key, float defaultValue) {
        Object object0 = this.mValues.get(key);
        return object0 instanceof Float ? ((float)(((Float)object0))) : defaultValue;
    }

    public float[] getFloatArray(String key) {
        Object object0 = this.mValues.get(key);
        return object0 instanceof Float[] ? Data.convertToPrimitiveArray(((Float[])object0)) : null;
    }

    public int getInt(String key, int defaultValue) {
        Object object0 = this.mValues.get(key);
        return object0 instanceof Integer ? ((int)(((Integer)object0))) : defaultValue;
    }

    public int[] getIntArray(String key) {
        Object object0 = this.mValues.get(key);
        return object0 instanceof Integer[] ? Data.convertToPrimitiveArray(((Integer[])object0)) : null;
    }

    public Map getKeyValueMap() {
        return Collections.unmodifiableMap(this.mValues);
    }

    public long getLong(String key, long defaultValue) {
        Object object0 = this.mValues.get(key);
        return object0 instanceof Long ? ((long)(((Long)object0))) : defaultValue;
    }

    public long[] getLongArray(String key) {
        Object object0 = this.mValues.get(key);
        return object0 instanceof Long[] ? Data.convertToPrimitiveArray(((Long[])object0)) : null;
    }

    public String getString(String key) {
        Object object0 = this.mValues.get(key);
        return object0 instanceof String ? ((String)object0) : null;
    }

    public String[] getStringArray(String key) {
        Object object0 = this.mValues.get(key);
        return object0 instanceof String[] ? ((String[])object0) : null;
    }

    public boolean hasKeyWithValueOfType(String key, Class klass) {
        Object object0 = this.mValues.get(key);
        return object0 != null && klass.isAssignableFrom(object0.getClass());
    }

    @Override
    public int hashCode() {
        return this.mValues.hashCode() * 0x1F;
    }

    public int size() {
        return this.mValues.size();
    }

    public byte[] toByteArray() {
        return Data.toByteArrayInternal(this);
    }

    public static byte[] toByteArrayInternal(Data data) {
        byte[] arr_b;
        ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream0 = null;
        try {
            try {
                objectOutputStream0 = new ObjectOutputStream(byteArrayOutputStream0);
                objectOutputStream0.writeInt(data.size());
                Iterator iterator0 = data.mValues.entrySet().iterator();
                while(true) {
                    if(!iterator0.hasNext()) {
                        goto label_34;
                    }
                    Object object0 = iterator0.next();
                    objectOutputStream0.writeUTF(((String)((Map.Entry)object0).getKey()));
                    objectOutputStream0.writeObject(((Map.Entry)object0).getValue());
                }
            }
            catch(IOException iOException0) {
            }
            Log.e("WM-Data", "Error in Data#toByteArray: ", iOException0);
            arr_b = byteArrayOutputStream0.toByteArray();
            if(objectOutputStream0 != null) {
                goto label_14;
            }
            goto label_18;
        }
        catch(Throwable throwable0) {
            goto label_24;
        }
        try {
        label_14:
            objectOutputStream0.close();
        }
        catch(IOException iOException1) {
            Log.e("WM-Data", "Error in Data#toByteArray: ", iOException1);
        }
        try {
        label_18:
            byteArrayOutputStream0.close();
        }
        catch(IOException iOException2) {
            Log.e("WM-Data", "Error in Data#toByteArray: ", iOException2);
        }
        return arr_b;
    label_24:
        if(objectOutputStream0 != null) {
            try {
                objectOutputStream0.close();
            }
            catch(IOException iOException3) {
                Log.e("WM-Data", "Error in Data#toByteArray: ", iOException3);
            }
        }
        try {
            byteArrayOutputStream0.close();
        }
        catch(IOException iOException4) {
            Log.e("WM-Data", "Error in Data#toByteArray: ", iOException4);
        }
        throw throwable0;
        try {
        label_34:
            objectOutputStream0.close();
        }
        catch(IOException iOException5) {
            Log.e("WM-Data", "Error in Data#toByteArray: ", iOException5);
        }
        try {
            byteArrayOutputStream0.close();
        }
        catch(IOException iOException6) {
            Log.e("WM-Data", "Error in Data#toByteArray: ", iOException6);
        }
        if(byteArrayOutputStream0.size() > 0x2800) {
            throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
        }
        return byteArrayOutputStream0.toByteArray();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("Data {");
        if(!this.mValues.isEmpty()) {
            for(Object object0: this.mValues.keySet()) {
                stringBuilder0.append(((String)object0));
                stringBuilder0.append(" : ");
                Object object1 = this.mValues.get(((String)object0));
                if(object1 instanceof Object[]) {
                    stringBuilder0.append(Arrays.toString(((Object[])object1)));
                }
                else {
                    stringBuilder0.append(object1);
                }
                stringBuilder0.append(", ");
            }
        }
        stringBuilder0.append("}");
        return stringBuilder0.toString();
    }
}

