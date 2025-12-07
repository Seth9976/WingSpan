package com.onesignal.user.internal.operations.impl.executors;

import com.onesignal.user.internal.backend.PropertiesObject;
import com.onesignal.user.internal.operations.DeleteTagOperation;
import com.onesignal.user.internal.operations.SetPropertyOperation;
import com.onesignal.user.internal.operations.SetTagOperation;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u0004J\u0016\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0004J\u0016\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\t2\u0006\u0010\u0007\u001A\u00020\u0004¨\u0006\n"}, d2 = {"Lcom/onesignal/user/internal/operations/impl/executors/PropertyOperationHelper;", "", "()V", "createPropertiesFromOperation", "Lcom/onesignal/user/internal/backend/PropertiesObject;", "operation", "Lcom/onesignal/user/internal/operations/DeleteTagOperation;", "propertiesObject", "Lcom/onesignal/user/internal/operations/SetPropertyOperation;", "Lcom/onesignal/user/internal/operations/SetTagOperation;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class PropertyOperationHelper {
    public static final PropertyOperationHelper INSTANCE;

    static {
        PropertyOperationHelper.INSTANCE = new PropertyOperationHelper();
    }

    public final PropertiesObject createPropertiesFromOperation(DeleteTagOperation deleteTagOperation0, PropertiesObject propertiesObject0) {
        Intrinsics.checkNotNullParameter(deleteTagOperation0, "operation");
        Intrinsics.checkNotNullParameter(propertiesObject0, "propertiesObject");
        Map map0 = propertiesObject0.getTags();
        Map map1 = map0 == null ? null : MapsKt.toMutableMap(map0);
        if(map1 == null) {
            map1 = new LinkedHashMap();
        }
        map1.put(deleteTagOperation0.getKey(), null);
        return new PropertiesObject(map1, propertiesObject0.getLanguage(), propertiesObject0.getTimezoneId(), propertiesObject0.getCountry(), propertiesObject0.getLatitude(), propertiesObject0.getLongitude());
    }

    public final PropertiesObject createPropertiesFromOperation(SetPropertyOperation setPropertyOperation0, PropertiesObject propertiesObject0) {
        Intrinsics.checkNotNullParameter(setPropertyOperation0, "operation");
        Intrinsics.checkNotNullParameter(propertiesObject0, "propertiesObject");
        String s = setPropertyOperation0.getProperty();
        String s1 = null;
        if(Intrinsics.areEqual(s, "language")) {
            Map map0 = propertiesObject0.getTags();
            Object object0 = setPropertyOperation0.getValue();
            if(object0 != null) {
                s1 = object0.toString();
            }
            return new PropertiesObject(map0, s1, propertiesObject0.getTimezoneId(), propertiesObject0.getCountry(), propertiesObject0.getLatitude(), propertiesObject0.getLongitude());
        }
        if(Intrinsics.areEqual(s, "timezone")) {
            Map map1 = propertiesObject0.getTags();
            String s2 = propertiesObject0.getLanguage();
            Object object1 = setPropertyOperation0.getValue();
            if(object1 != null) {
                s1 = object1.toString();
            }
            return new PropertiesObject(map1, s2, s1, propertiesObject0.getCountry(), propertiesObject0.getLatitude(), propertiesObject0.getLongitude());
        }
        if(Intrinsics.areEqual(s, "country")) {
            Map map2 = propertiesObject0.getTags();
            String s3 = propertiesObject0.getLanguage();
            String s4 = propertiesObject0.getTimezoneId();
            Object object2 = setPropertyOperation0.getValue();
            if(object2 != null) {
                s1 = object2.toString();
            }
            return new PropertiesObject(map2, s3, s4, s1, propertiesObject0.getLatitude(), propertiesObject0.getLongitude());
        }
        if(Intrinsics.areEqual(s, "locationLatitude")) {
            Map map3 = propertiesObject0.getTags();
            String s5 = propertiesObject0.getLanguage();
            String s6 = propertiesObject0.getTimezoneId();
            String s7 = propertiesObject0.getCountry();
            Object object3 = setPropertyOperation0.getValue();
            if(object3 != null) {
                String s8 = object3.toString();
                if(s8 != null) {
                    s1 = Double.parseDouble(s8);
                }
            }
            return new PropertiesObject(map3, s5, s6, s7, ((Double)s1), propertiesObject0.getLongitude());
        }
        if(Intrinsics.areEqual(s, "locationLongitude")) {
            Map map4 = propertiesObject0.getTags();
            String s9 = propertiesObject0.getLanguage();
            String s10 = propertiesObject0.getTimezoneId();
            String s11 = propertiesObject0.getCountry();
            Double double0 = propertiesObject0.getLatitude();
            Object object4 = setPropertyOperation0.getValue();
            if(object4 != null) {
                String s12 = object4.toString();
                if(s12 != null) {
                    s1 = Double.parseDouble(s12);
                }
            }
            return new PropertiesObject(map4, s9, s10, s11, double0, ((Double)s1));
        }
        return new PropertiesObject(propertiesObject0.getTags(), propertiesObject0.getLanguage(), propertiesObject0.getTimezoneId(), propertiesObject0.getCountry(), propertiesObject0.getLatitude(), propertiesObject0.getLongitude());
    }

    public final PropertiesObject createPropertiesFromOperation(SetTagOperation setTagOperation0, PropertiesObject propertiesObject0) {
        Intrinsics.checkNotNullParameter(setTagOperation0, "operation");
        Intrinsics.checkNotNullParameter(propertiesObject0, "propertiesObject");
        Map map0 = propertiesObject0.getTags();
        Map map1 = map0 == null ? null : MapsKt.toMutableMap(map0);
        if(map1 == null) {
            map1 = new LinkedHashMap();
        }
        map1.put(setTagOperation0.getKey(), setTagOperation0.getValue());
        return new PropertiesObject(map1, propertiesObject0.getLanguage(), propertiesObject0.getTimezoneId(), propertiesObject0.getCountry(), propertiesObject0.getLatitude(), propertiesObject0.getLongitude());
    }
}

