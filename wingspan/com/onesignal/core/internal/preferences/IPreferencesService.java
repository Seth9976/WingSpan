package com.onesignal.core.internal.preferences;

import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J+\u0010\u0002\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\bJ+\u0010\t\u001A\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010\u000BJ+\u0010\f\u001A\u0004\u0018\u00010\r2\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\rH&¢\u0006\u0002\u0010\u000EJ&\u0010\u000F\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u0005H&J2\u0010\u0010\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00112\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\u0010\b\u0002\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011H&J\'\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\b\u0010\u0014\u001A\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\u0015J\'\u0010\u0016\u001A\u00020\u00132\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\b\u0010\u0014\u001A\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010\u0017J\'\u0010\u0018\u001A\u00020\u00132\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\b\u0010\u0014\u001A\u0004\u0018\u00010\rH&¢\u0006\u0002\u0010\u0019J\"\u0010\u001A\u001A\u00020\u00132\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\b\u0010\u0014\u001A\u0004\u0018\u00010\u0005H&J(\u0010\u001B\u001A\u00020\u00132\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\u000E\u0010\u0014\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011H&¨\u0006\u001C"}, d2 = {"Lcom/onesignal/core/internal/preferences/IPreferencesService;", "", "getBool", "", "store", "", "key", "defValue", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Ljava/lang/Boolean;", "getInt", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/Integer;", "getLong", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Ljava/lang/Long;", "getString", "getStringSet", "", "saveBool", "", "value", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "saveInt", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "saveLong", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "saveString", "saveStringSet", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface IPreferencesService {
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 0x30)
    public static final class DefaultImpls {
        public static Boolean getBool$default(IPreferencesService iPreferencesService0, String s, String s1, Boolean boolean0, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBool");
            }
            if((v & 4) != 0) {
                boolean0 = null;
            }
            return iPreferencesService0.getBool(s, s1, boolean0);
        }

        public static Integer getInt$default(IPreferencesService iPreferencesService0, String s, String s1, Integer integer0, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getInt");
            }
            if((v & 4) != 0) {
                integer0 = null;
            }
            return iPreferencesService0.getInt(s, s1, integer0);
        }

        public static Long getLong$default(IPreferencesService iPreferencesService0, String s, String s1, Long long0, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLong");
            }
            if((v & 4) != 0) {
                long0 = null;
            }
            return iPreferencesService0.getLong(s, s1, long0);
        }

        public static String getString$default(IPreferencesService iPreferencesService0, String s, String s1, String s2, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getString");
            }
            if((v & 4) != 0) {
                s2 = null;
            }
            return iPreferencesService0.getString(s, s1, s2);
        }

        public static Set getStringSet$default(IPreferencesService iPreferencesService0, String s, String s1, Set set0, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getStringSet");
            }
            if((v & 4) != 0) {
                set0 = null;
            }
            return iPreferencesService0.getStringSet(s, s1, set0);
        }
    }

    Boolean getBool(String arg1, String arg2, Boolean arg3);

    Integer getInt(String arg1, String arg2, Integer arg3);

    Long getLong(String arg1, String arg2, Long arg3);

    String getString(String arg1, String arg2, String arg3);

    Set getStringSet(String arg1, String arg2, Set arg3);

    void saveBool(String arg1, String arg2, Boolean arg3);

    void saveInt(String arg1, String arg2, Integer arg3);

    void saveLong(String arg1, String arg2, Long arg3);

    void saveString(String arg1, String arg2, String arg3);

    void saveStringSet(String arg1, String arg2, Set arg3);
}

