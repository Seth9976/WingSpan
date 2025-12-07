package com.google.android.gms.internal.drive;

public enum zzks {
    VOID(Void.class, Void.class, null),
    INT(Integer.TYPE, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, 0.0f),
    DOUBLE(Double.TYPE, Double.class, 0.0),
    BOOLEAN(Boolean.TYPE, Boolean.class, Boolean.FALSE),
    STRING(String.class, String.class, ""),
    BYTE_STRING(zzjc.class, zzjc.class, zzjc.zznq),
    ENUM(Integer.TYPE, Integer.class, null),
    MESSAGE(Object.class, Object.class, null);

    private final Class zztb;
    private final Class zztc;
    private final Object zztd;

    private zzks(Class class0, Class class1, Object object0) {
        this.zztb = class0;
        this.zztc = class1;
        this.zztd = object0;
    }

    public final Class zzdo() {
        return this.zztc;
    }
}

