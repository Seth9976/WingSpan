package kotlin.jvm;

import com.unity3d.player.UnityPlayerActivity;
import java.lang.annotation.Annotation;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0002\u0010\u0011\n\u0002\b\u0002\u001A\u001F\u0010\u001F\u001A\u00020 \"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0014*\u0006\u0012\u0002\b\u00030!¢\u0006\u0002\u0010\"\"\'\u0010\u0000\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00028F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005\"5\u0010\u0006\u001A\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u000E\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\t*\u0002H\b8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000B\u001A\u0004\b\f\u0010\r\"-\u0010\u000E\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00018G¢\u0006\f\u0012\u0004\b\u000F\u0010\u0010\u001A\u0004\b\u0011\u0010\u0012\"&\u0010\u0013\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\u0014*\u0002H\u00028Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0015\";\u0010\u0013\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0007\"\b\b\u0000\u0010\u0002*\u00020\u0014*\b\u0012\u0004\u0012\u0002H\u00020\u00018Ç\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0010\u001A\u0004\b\u0017\u0010\u0012\"+\u0010\u0018\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\u0014*\b\u0012\u0004\u0012\u0002H\u00020\u00018F¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u0012\"-\u0010\u001A\u001A\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0007\"\b\b\u0000\u0010\u0002*\u00020\u0014*\b\u0012\u0004\u0012\u0002H\u00020\u00018F¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u0012\"+\u0010\u001C\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0014*\b\u0012\u0004\u0012\u0002H\u00020\u00078G¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u001E¨\u0006#"}, d2 = {"annotationClass", "Lkotlin/reflect/KClass;", "T", "", "getAnnotationClass", "(Ljava/lang/annotation/Annotation;)Lkotlin/reflect/KClass;", "declaringJavaClass", "Ljava/lang/Class;", "E", "", "getDeclaringJavaClass$annotations", "(Ljava/lang/Enum;)V", "getDeclaringJavaClass", "(Ljava/lang/Enum;)Ljava/lang/Class;", "java", "getJavaClass$annotations", "(Lkotlin/reflect/KClass;)V", "getJavaClass", "(Lkotlin/reflect/KClass;)Ljava/lang/Class;", "javaClass", "", "(Ljava/lang/Object;)Ljava/lang/Class;", "getRuntimeClassOfKClassInstance$annotations", "getRuntimeClassOfKClassInstance", "javaObjectType", "getJavaObjectType", "javaPrimitiveType", "getJavaPrimitiveType", "kotlin", "getKotlinClass", "(Ljava/lang/Class;)Lkotlin/reflect/KClass;", "isArrayOf", "", "", "([Ljava/lang/Object;)Z", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 0x30)
public final class JvmClassMappingKt {
    public static final KClass getAnnotationClass(Annotation annotation0) {
        Intrinsics.checkNotNullParameter(annotation0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Class class0 = annotation0.annotationType();
        Intrinsics.checkNotNullExpressionValue(class0, UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C0F1E030E1A0085E5D401040C15070E094C5C0F1E030E1A00130C1D002414110B494E"));
        KClass kClass0 = JvmClassMappingKt.getKotlinClass(class0);
        Intrinsics.checkNotNull(kClass0, UnityPlayerActivity.adjustValue("0005010D4E02060B1C01044D030B410404011A50190E4E0F080B5F0005010D4E151E15174E1B02150208094B000B1601040D15492E3102111E12520E1211523A5002074E0A08111E071E430B180C492F04033301001D122A04021E19030625154959150B044000000F0811131A19020F2D0D061601504E"));
        return kClass0;
    }

    private static final Class getDeclaringJavaClass(Enum enum0) {
        Intrinsics.checkNotNullParameter(enum0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Class class0 = enum0.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(class0, UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C2B1E180C5224594C5C0A150E0D0F130E0B152D1C0C121D"));
        return class0;
    }

    public static void getDeclaringJavaClass$annotations(Enum enum0) {
    }

    public static final Class getJavaClass(Object object0) {
        Intrinsics.checkNotNullParameter(object0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Class class0 = object0.getClass();
        Intrinsics.checkNotNull(class0, UnityPlayerActivity.adjustValue("0005010D4E02060B1C01044D030B410404011A50190E4E0F080B5F0005010D4E151E15174E1A0C170F4F0B041C095E2E0D0F121459264E1F0B41050E13091B005E0717034F2D131F2D1C0C121D2C061502071E0A2A1A4F5B02171A5D070018002409131D03535F"));
        return class0;
    }

    public static final Class getJavaClass(KClass kClass0) {
        Intrinsics.checkNotNullParameter(kClass0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Class class0 = ((ClassBasedDeclarationContainer)kClass0).getJClass();
        Intrinsics.checkNotNull(class0, UnityPlayerActivity.adjustValue("0005010D4E02060B1C01044D030B410404011A50190E4E0F080B5F0005010D4E151E15174E1A0C170F4F0B041C095E2E0D0F121459264E1F0B41050E13091B005E0717034F2D131F2D1C0C121D2C061502071E0A2A1A4F5B02171A5D07001800595B"));
        return class0;
    }

    public static void getJavaClass$annotations(KClass kClass0) {
    }

    public static final Class getJavaObjectType(KClass kClass0) {
        Intrinsics.checkNotNullParameter(kClass0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Class class0 = ((ClassBasedDeclarationContainer)kClass0).getJClass();
        String s = UnityPlayerActivity.adjustValue("0005010D4E02060B1C01044D030B410404011A50190E4E0F080B5F0005010D4E151E15174E1A0C170F4F0B041C095E2E0D0F121459264E1F0B41050E13091B005E0717034F2D131F2D1C0C121D2C061502071E0A2A1A4F5B02171A5D070018002807180B1319351711025B4C");
        if(!class0.isPrimitive()) {
            Intrinsics.checkNotNull(class0, s);
            return class0;
        }
        String s1 = class0.getName();
        if(s1 != null) {
            switch(s1.hashCode()) {
                case 0xB0F77BD1: {
                    if(s1.equals(UnityPlayerActivity.adjustValue("0A1F18030204"))) {
                        class0 = Double.class;
                    }
                    break;
                }
                case 0x197EF: {
                    if(s1.equals(UnityPlayerActivity.adjustValue("071E19"))) {
                        class0 = Integer.class;
                    }
                    break;
                }
                case 0x2E6108: {
                    if(s1.equals(UnityPlayerActivity.adjustValue("0C091904"))) {
                        class0 = Byte.class;
                    }
                    break;
                }
                case 3052374: {
                    if(s1.equals(UnityPlayerActivity.adjustValue("0D180C13"))) {
                        class0 = Character.class;
                    }
                    break;
                }
                case 0x32C67C: {
                    if(s1.equals(UnityPlayerActivity.adjustValue("021F0306"))) {
                        class0 = Long.class;
                    }
                    break;
                }
                case 0x375194: {
                    if(s1.equals(UnityPlayerActivity.adjustValue("181F0405"))) {
                        class0 = Void.class;
                    }
                    break;
                }
                case 64711720: {
                    if(s1.equals(UnityPlayerActivity.adjustValue("0C1F020D0B0009"))) {
                        class0 = Boolean.class;
                    }
                    break;
                }
                case 0x5D0225C: {
                    if(s1.equals(UnityPlayerActivity.adjustValue("081C02001A"))) {
                        class0 = Float.class;
                    }
                    break;
                }
                case 109413500: {
                    if(s1.equals(UnityPlayerActivity.adjustValue("1D1802131A"))) {
                        class0 = Short.class;
                    }
                }
            }
        }
        Intrinsics.checkNotNull(class0, s);
        return class0;
    }

    public static final Class getJavaPrimitiveType(KClass kClass0) {
        Intrinsics.checkNotNullParameter(kClass0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Class class0 = ((ClassBasedDeclarationContainer)kClass0).getJClass();
        if(class0.isPrimitive()) {
            Intrinsics.checkNotNull(class0, UnityPlayerActivity.adjustValue("0005010D4E02060B1C01044D030B410404011A50190E4E0F080B5F0005010D4E151E15174E1A0C170F4F0B041C095E2E0D0F121459264E1F0B41050E13091B005E0717034F2D131F2D1C0C121D2C061502071E0A2A1A4F5B02171A5D0700180037171B031919081804331C020B4E53"));
            return class0;
        }
        String s = class0.getName();
        if(s != null) {
            switch(s.hashCode()) {
                case -2056817302: {
                    return s.equals(UnityPlayerActivity.adjustValue("04111B00400D060B15403903150B060217")) ? Integer.TYPE : null;
                }
                case -527879800: {
                    return s.equals(UnityPlayerActivity.adjustValue("04111B00400D060B154036010E0F15")) ? Float.TYPE : null;
                }
                case 0xE13E93A8: {
                    return s.equals(UnityPlayerActivity.adjustValue("04111B00400D060B154023050E1C15")) ? Short.TYPE : null;
                }
                case 0x9415455: {
                    return s.equals(UnityPlayerActivity.adjustValue("04111B00400D060B15403305001C000411171C")) ? Character.TYPE : null;
                }
                case 0x148D6054: {
                    return s.equals(UnityPlayerActivity.adjustValue("04111B00400D060B154032020E0204060B")) ? Boolean.TYPE : null;
                }
                case 398507100: {
                    return s.equals(UnityPlayerActivity.adjustValue("04111B00400D060B15403214150B")) ? Byte.TYPE : null;
                }
                case 0x17C521D0: {
                    return s.equals(UnityPlayerActivity.adjustValue("04111B00400D060B15403C020F09")) ? Long.TYPE : null;
                }
                case 399092968: {
                    return s.equals(UnityPlayerActivity.adjustValue("04111B00400D060B15402602080A")) ? Void.TYPE : null;
                }
                case 0x2D605225: {
                    return s.equals(UnityPlayerActivity.adjustValue("04111B00400D060B15403402140C0D02")) ? Double.TYPE : null;
                }
                default: {
                    return null;
                }
            }
        }
        return null;
    }

    public static final KClass getKotlinClass(Class class0) {
        Intrinsics.checkNotNullParameter(class0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return Reflection.getOrCreateKotlinClass(class0);
    }

    public static final Class getRuntimeClassOfKClassInstance(KClass kClass0) {
        Intrinsics.checkNotNullParameter(kClass0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Class class0 = kClass0.getClass();
        Intrinsics.checkNotNull(class0, UnityPlayerActivity.adjustValue("0005010D4E02060B1C01044D030B410404011A50190E4E0F080B5F0005010D4E151E15174E1A0C170F4F0B041C095E2E0D0F1214591901040108004F15001402150E15402A2409131D0351354E0E01451901040108004F0D131F403A1B0C2D0D06160123111D11070F002E06404C0A041A4C0D04040F3301001D12595B4C"));
        return class0;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use \'java\' property to get Java class corresponding to this Kotlin class or cast this instance to Any if you really want to get the runtime Java class of this implementation of KClass.", replaceWith = @ReplaceWith(expression = "(this as Any).javaClass", imports = {}))
    public static void getRuntimeClassOfKClassInstance$annotations(KClass kClass0) {
    }

    public static final boolean isArrayOf(Object[] arr_object) {
        Intrinsics.checkNotNullParameter(arr_object, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.reifiedOperationMarker(4, UnityPlayerActivity.adjustValue("3A"));
        Class class0 = arr_object.getClass();
        return Object.class.isAssignableFrom(class0.getComponentType());
    }
}

