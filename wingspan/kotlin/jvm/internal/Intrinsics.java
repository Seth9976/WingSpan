package kotlin.jvm.internal;

import com.unity3d.player.UnityPlayerActivity;
import java.util.Arrays;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;

public class Intrinsics {
    public static class Kotlin {
    }

    public static boolean areEqual(double f, Double double0) {
        return double0 != null && f == ((double)double0);
    }

    public static boolean areEqual(float f, Float float0) {
        return float0 != null && f == ((float)float0);
    }

    public static boolean areEqual(Double double0, double f) {
        return double0 != null && ((double)double0) == f;
    }

    // 去混淆评级： 低(20)
    public static boolean areEqual(Double double0, Double double1) {
        return double0 == null ? double1 == null : double1 != null && ((double)double0) == ((double)double1);
    }

    public static boolean areEqual(Float float0, float f) {
        return float0 != null && ((float)float0) == f;
    }

    // 去混淆评级： 低(20)
    public static boolean areEqual(Float float0, Float float1) {
        return float0 == null ? float1 == null : float1 != null && ((float)float0) == ((float)float1);
    }

    public static boolean areEqual(Object object0, Object object1) {
        return object0 == null ? object1 == null : object0.equals(object1);
    }

    public static void checkExpressionValueIsNotNull(Object object0, String s) {
        if(object0 == null) {
            throw (IllegalStateException)Intrinsics.sanitizeStackTrace(new IllegalStateException(s + UnityPlayerActivity.adjustValue("4E1D18121A41090A064E12084100140B09")));
        }
    }

    public static void checkFieldIsNotNull(Object object0, String s) {
        if(object0 == null) {
            throw (IllegalStateException)Intrinsics.sanitizeStackTrace(new IllegalStateException(s));
        }
    }

    public static void checkFieldIsNotNull(Object object0, String s, String s1) {
        if(object0 == null) {
            throw (IllegalStateException)Intrinsics.sanitizeStackTrace(new IllegalStateException(UnityPlayerActivity.adjustValue("2819080D0A411415170D190B080B054704014E1E020F430F12091E4E191E4100140B09484E") + s + UnityPlayerActivity.adjustValue("40") + s1));
        }
    }

    public static void checkHasClass(String s) throws ClassNotFoundException {
        String s1 = s.replace('/', '.');
        try {
            Class.forName(s1);
        }
        catch(ClassNotFoundException classNotFoundException0) {
            throw (ClassNotFoundException)Intrinsics.sanitizeStackTrace(new ClassNotFoundException(UnityPlayerActivity.adjustValue("2D1C0C121D41") + s1 + UnityPlayerActivity.adjustValue("4E191E41000E1345140105030540413709170F0308411B110304060B5019090B412C0A06021903411C1409111B03154D150141130D174E1C0C150B121345040B021E08010F"), classNotFoundException0));
        }
    }

    public static void checkHasClass(String s, String s1) throws ClassNotFoundException {
        String s2 = s.replace('/', '.');
        try {
            Class.forName(s2);
        }
        catch(ClassNotFoundException classNotFoundException0) {
            throw (ClassNotFoundException)Intrinsics.sanitizeStackTrace(new ClassNotFoundException(UnityPlayerActivity.adjustValue("2D1C0C121D41") + s2 + UnityPlayerActivity.adjustValue("4E191E41000E134514010503055441130D1B1D500E0E0A044717171F0504130B1247111A0B50260E1A0D0E0B521C050315070C02451D08501B041C120E0A1C4E11194102040616064E") + s1, classNotFoundException0));
        }
    }

    public static void checkNotNull(Object object0) [...] // 潜在的解密器

    public static void checkNotNull(Object object0, String s) {
        if(object0 == null) {
            Intrinsics.throwJavaNpe(s);
        }
    }

    public static void checkNotNullExpressionValue(Object object0, String s) [...] // 潜在的解密器

    public static void checkNotNullParameter(Object object0, String s) {
        if(object0 == null) {
            Intrinsics.throwParameterIsNullNPE(s);
        }
    }

    public static void checkParameterIsNotNull(Object object0, String s) {
        if(object0 == null) {
            Intrinsics.throwParameterIsNullIAE(s);
        }
    }

    public static void checkReturnedValueIsNotNull(Object object0, String s) {
        if(object0 == null) {
            throw (IllegalStateException)Intrinsics.sanitizeStackTrace(new IllegalStateException(s));
        }
    }

    public static void checkReturnedValueIsNotNull(Object object0, String s, String s1) {
        if(object0 == null) {
            throw (IllegalStateException)Intrinsics.sanitizeStackTrace(new IllegalStateException(UnityPlayerActivity.adjustValue("2315190901054716020B13040707040345131D50030E004C09101E02501F041A14150B170A500314020D5D45") + s + UnityPlayerActivity.adjustValue("40") + s1));
        }
    }

    public static int compare(int v, int v1) {
        if(v < v1) {
            return -1;
        }
        return v == v1 ? 0 : 1;
    }

    public static int compare(long v, long v1) {
        int v2 = Long.compare(v, v1);
        if(v2 < 0) {
            return -1;
        }
        return v2 == 0 ? 0 : 1;
    }

    private static String createParameterIsNullExceptionMessage(String s) {
        StackTraceElement stackTraceElement0 = Thread.currentThread().getStackTrace()[4];
        String s1 = stackTraceElement0.getClassName();
        String s2 = stackTraceElement0.getMethodName();
        return UnityPlayerActivity.adjustValue("3E111F0003041300004E031D040D08010C170A500C124E0F080B5F0005010D4E0814451C1B1C015B4E0C02111A01144D") + s1 + UnityPlayerActivity.adjustValue("40") + s2 + UnityPlayerActivity.adjustValue("42501D001C000A00060B024D") + s;
    }

    public static void needClassReification() {
        Intrinsics.throwUndefinedForReified();
    }

    public static void needClassReification(String s) {
        Intrinsics.throwUndefinedForReified(s);
    }

    public static void reifiedOperationMarker(int v, String s) {
        Intrinsics.throwUndefinedForReified();
    }

    public static void reifiedOperationMarker(int v, String s, String s1) {
        Intrinsics.throwUndefinedForReified(s1);
    }

    private static Throwable sanitizeStackTrace(Throwable throwable0) {
        return Intrinsics.sanitizeStackTrace(throwable0, Intrinsics.class.getName());
    }

    static Throwable sanitizeStackTrace(Throwable throwable0, String s) {
        StackTraceElement[] arr_stackTraceElement = throwable0.getStackTrace();
        int v = -1;
        for(int v1 = 0; v1 < arr_stackTraceElement.length; ++v1) {
            if(s.equals(arr_stackTraceElement[v1].getClassName())) {
                v = v1;
            }
        }
        throwable0.setStackTrace(((StackTraceElement[])Arrays.copyOfRange(arr_stackTraceElement, v + 1, arr_stackTraceElement.length)));
        return throwable0;
    }

    public static String stringPlus(String s, Object object0) {
        return s + object0;
    }

    public static void throwAssert() {
        throw (AssertionError)Intrinsics.sanitizeStackTrace(new AssertionError());
    }

    public static void throwAssert(String s) {
        throw (AssertionError)Intrinsics.sanitizeStackTrace(new AssertionError(s));
    }

    public static void throwIllegalArgument() {
        throw (IllegalArgumentException)Intrinsics.sanitizeStackTrace(new IllegalArgumentException());
    }

    public static void throwIllegalArgument(String s) {
        throw (IllegalArgumentException)Intrinsics.sanitizeStackTrace(new IllegalArgumentException(s));
    }

    public static void throwIllegalState() {
        throw (IllegalStateException)Intrinsics.sanitizeStackTrace(new IllegalStateException());
    }

    public static void throwIllegalState(String s) {
        throw (IllegalStateException)Intrinsics.sanitizeStackTrace(new IllegalStateException(s));
    }

    public static void throwJavaNpe() {
        throw (NullPointerException)Intrinsics.sanitizeStackTrace(new NullPointerException());
    }

    public static void throwJavaNpe(String s) {
        throw (NullPointerException)Intrinsics.sanitizeStackTrace(new NullPointerException(s));
    }

    public static void throwNpe() {
        throw (KotlinNullPointerException)Intrinsics.sanitizeStackTrace(new KotlinNullPointerException());
    }

    public static void throwNpe(String s) {
        throw (KotlinNullPointerException)Intrinsics.sanitizeStackTrace(new KotlinNullPointerException(s));
    }

    private static void throwParameterIsNullIAE(String s) {
        throw (IllegalArgumentException)Intrinsics.sanitizeStackTrace(new IllegalArgumentException(Intrinsics.createParameterIsNullExceptionMessage(s)));
    }

    private static void throwParameterIsNullNPE(String s) {
        throw (NullPointerException)Intrinsics.sanitizeStackTrace(new NullPointerException(Intrinsics.createParameterIsNullExceptionMessage(s)));
    }

    public static void throwUndefinedForReified() {
        Intrinsics.throwUndefinedForReified(UnityPlayerActivity.adjustValue("3A1804124E07120B111A19020F4E090616520F501F0407070E00164E0414110B411704000F1D08150B1347041C0A5019091B124706130050020F02184707174E19030D070F0201520F044D02010C170C1E0F04040E0041130C1F0B5C4D0F0115470613021C08054E050E17170D04011840"));
    }

    public static void throwUndefinedForReified(String s) {
        throw new UnsupportedOperationException(s);
    }

    public static void throwUninitializedProperty(String s) {
        throw (UninitializedPropertyAccessException)Intrinsics.sanitizeStackTrace(new UninitializedPropertyAccessException(s));
    }

    public static void throwUninitializedPropertyAccessException(String s) {
        Intrinsics.throwUninitializedProperty((UnityPlayerActivity.adjustValue("02111904070F0E11521E0202110B13131C52") + s + UnityPlayerActivity.adjustValue("4E180C124E0F0811520C15080F4E08090C0607110108140403")));
    }
}

