package kotlin.jvm.internal;

import com.unity3d.player.UnityPlayerActivity;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.reflect.KClass;
import kotlin.reflect.KVisibility;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001B\n\u0002\b\u0003\n\u0002\u0010\u001E\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 O2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001OB\u0011\u0012\n\u0010\u0004\u001A\u0006\u0012\u0002\b\u00030\u0005\u00A2\u0006\u0002\u0010\u0006J\u0013\u0010F\u001A\u00020\u00122\b\u0010G\u001A\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010H\u001A\u00020IH\u0002J\b\u0010J\u001A\u00020KH\u0016J\u0012\u0010L\u001A\u00020\u00122\b\u0010M\u001A\u0004\u0018\u00010\u0002H\u0017J\b\u0010N\u001A\u000201H\u0016R\u001A\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b\n\u0010\u000BR \u0010\f\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000E0\r8VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010R\u001A\u0010\u0011\u001A\u00020\u00128VX\u0097\u0004\u00A2\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001A\u0004\b\u0011\u0010\u0015R\u001A\u0010\u0016\u001A\u00020\u00128VX\u0097\u0004\u00A2\u0006\f\u0012\u0004\b\u0017\u0010\u0014\u001A\u0004\b\u0016\u0010\u0015R\u001A\u0010\u0018\u001A\u00020\u00128VX\u0097\u0004\u00A2\u0006\f\u0012\u0004\b\u0019\u0010\u0014\u001A\u0004\b\u0018\u0010\u0015R\u001A\u0010\u001A\u001A\u00020\u00128VX\u0097\u0004\u00A2\u0006\f\u0012\u0004\b\u001B\u0010\u0014\u001A\u0004\b\u001A\u0010\u0015R\u001A\u0010\u001C\u001A\u00020\u00128VX\u0097\u0004\u00A2\u0006\f\u0012\u0004\b\u001D\u0010\u0014\u001A\u0004\b\u001C\u0010\u0015R\u001A\u0010\u001E\u001A\u00020\u00128VX\u0097\u0004\u00A2\u0006\f\u0012\u0004\b\u001F\u0010\u0014\u001A\u0004\b\u001E\u0010\u0015R\u001A\u0010 \u001A\u00020\u00128VX\u0097\u0004\u00A2\u0006\f\u0012\u0004\b!\u0010\u0014\u001A\u0004\b \u0010\u0015R\u001A\u0010\"\u001A\u00020\u00128VX\u0097\u0004\u00A2\u0006\f\u0012\u0004\b#\u0010\u0014\u001A\u0004\b\"\u0010\u0015R\u001A\u0010$\u001A\u00020\u00128VX\u0097\u0004\u00A2\u0006\f\u0012\u0004\b%\u0010\u0014\u001A\u0004\b$\u0010\u0015R\u0018\u0010\u0004\u001A\u0006\u0012\u0002\b\u00030\u0005X\u0096\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b&\u0010\'R\u001E\u0010(\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030)0\r8VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b*\u0010\u0010R\u001E\u0010+\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\r8VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b,\u0010\u0010R\u0016\u0010-\u001A\u0004\u0018\u00010\u00028VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b.\u0010/R\u0016\u00100\u001A\u0004\u0018\u0001018VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b2\u00103R(\u00104\u001A\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00010\b8VX\u0097\u0004\u00A2\u0006\f\u0012\u0004\b5\u0010\u0014\u001A\u0004\b6\u0010\u000BR\u0016\u00107\u001A\u0004\u0018\u0001018VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b8\u00103R \u00109\u001A\b\u0012\u0004\u0012\u00020:0\b8VX\u0097\u0004\u00A2\u0006\f\u0012\u0004\b;\u0010\u0014\u001A\u0004\b<\u0010\u000BR \u0010=\u001A\b\u0012\u0004\u0012\u00020>0\b8VX\u0097\u0004\u00A2\u0006\f\u0012\u0004\b?\u0010\u0014\u001A\u0004\b@\u0010\u000BR\u001C\u0010A\u001A\u0004\u0018\u00010B8VX\u0097\u0004\u00A2\u0006\f\u0012\u0004\bC\u0010\u0014\u001A\u0004\bD\u0010E\u00A8\u0006P"}, d2 = {"Lkotlin/jvm/internal/ClassReference;", "Lkotlin/reflect/KClass;", "", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "constructors", "", "Lkotlin/reflect/KFunction;", "getConstructors", "()Ljava/util/Collection;", "isAbstract", "", "isAbstract$annotations", "()V", "()Z", "isCompanion", "isCompanion$annotations", "isData", "isData$annotations", "isFinal", "isFinal$annotations", "isFun", "isFun$annotations", "isInner", "isInner$annotations", "isOpen", "isOpen$annotations", "isSealed", "isSealed$annotations", "isValue", "isValue$annotations", "getJClass", "()Ljava/lang/Class;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "sealedSubclasses", "getSealedSubclasses$annotations", "getSealedSubclasses", "simpleName", "getSimpleName", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes$annotations", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters$annotations", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility$annotations", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", "other", "error", "", "hashCode", "", "isInstance", "value", "toString", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class ClassReference implements ClassBasedDeclarationContainer, KClass {
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000F\u001A\u0004\u0018\u00010\n2\n\u0010\u0010\u001A\u0006\u0012\u0002\b\u00030\u0005J\u0014\u0010\u0011\u001A\u0004\u0018\u00010\n2\n\u0010\u0010\u001A\u0006\u0012\u0002\b\u00030\u0005J\u001C\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u00012\n\u0010\u0010\u001A\u0006\u0012\u0002\b\u00030\u0005R&\u0010\u0003\u001A\u001A\u0012\u0010\u0012\u000E\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\b\u001A\u001E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\f\u001A\u001E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\r\u001A\u001E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lkotlin/jvm/internal/ClassReference$Companion;", "", "()V", "FUNCTION_CLASSES", "", "Ljava/lang/Class;", "Lkotlin/Function;", "", "classFqNames", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "primitiveFqNames", "primitiveWrapperFqNames", "simpleNames", "getClassQualifiedName", "jClass", "getClassSimpleName", "isInstance", "", "value", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public final String getClassQualifiedName(Class class0) {
            Intrinsics.checkNotNullParameter(class0, UnityPlayerActivity.adjustValue("043301001D12"));
            String s = null;
            if(!class0.isAnonymousClass() && !class0.isLocalClass()) {
                if(class0.isArray()) {
                    Class class1 = class0.getComponentType();
                    if(class1.isPrimitive()) {
                        String s1 = (String)ClassReference.classFqNames.get(class1.getName());
                        if(s1 != null) {
                            s = s1 + UnityPlayerActivity.adjustValue("2F021F0017");
                        }
                    }
                    return s == null ? UnityPlayerActivity.adjustValue("051F190D070F4924001C1114") : s;
                }
                s = (String)ClassReference.classFqNames.get(class0.getName());
                return s == null ? class0.getCanonicalName() : s;
            }
            return null;
        }

        public final String getClassSimpleName(Class class0) {
            String s3;
            Intrinsics.checkNotNullParameter(class0, UnityPlayerActivity.adjustValue("043301001D12"));
            String s = null;
            if(!class0.isAnonymousClass()) {
                if(class0.isLocalClass()) {
                    String s1 = class0.getSimpleName();
                    Method method0 = class0.getEnclosingMethod();
                    String s2 = UnityPlayerActivity.adjustValue("00110004");
                    if(method0 != null) {
                        Intrinsics.checkNotNullExpressionValue(s1, s2);
                        s3 = StringsKt.substringAfter$default(s1, method0.getName() + '$', null, 2, null);
                        if(s3 != null) {
                            return s3;
                        }
                    }
                    Constructor constructor0 = class0.getEnclosingConstructor();
                    if(constructor0 != null) {
                        Intrinsics.checkNotNullExpressionValue(s1, s2);
                        return StringsKt.substringAfter$default(s1, constructor0.getName() + '$', null, 2, null);
                    }
                    Intrinsics.checkNotNullExpressionValue(s1, s2);
                    return StringsKt.substringAfter$default(s1, '$', null, 2, null);
                }
                if(class0.isArray()) {
                    Class class1 = class0.getComponentType();
                    s3 = UnityPlayerActivity.adjustValue("2F021F0017");
                    if(class1.isPrimitive()) {
                        String s4 = (String)ClassReference.simpleNames.get(class1.getName());
                        if(s4 != null) {
                            s = s4 + s3;
                        }
                    }
                    return s == null ? s3 : s;
                }
                s = (String)ClassReference.simpleNames.get(class0.getName());
                return s == null ? class0.getSimpleName() : s;
            }
            return null;
        }

        public final boolean isInstance(Object object0, Class class0) {
            Intrinsics.checkNotNullParameter(class0, UnityPlayerActivity.adjustValue("043301001D12"));
            Map map0 = ClassReference.FUNCTION_CLASSES;
            Intrinsics.checkNotNull(map0, UnityPlayerActivity.adjustValue("0005010D4E02060B1C01044D030B410404011A50190E4E0F080B5F0005010D4E151E15174E1B02150208094B11011C01040D150E0A1C1D5E20001E5D2C451D0850060E1A0D0E0B5C0D1F010D0B02130C1D0003432C0F11142E06312F20001E122C115C0915194D4E37470A144E1B02150208094B11011C01040D150E0A1C1D5E20001E122C112D313D0C111D2A134B150B0453"));
            Integer integer0 = (Integer)map0.get(class0);
            if(integer0 != null) {
                return TypeIntrinsics.isFunctionOfArity(object0, integer0.intValue());
            }
            if(class0.isPrimitive()) {
                class0 = JvmClassMappingKt.getJavaObjectType(JvmClassMappingKt.getKotlinClass(class0));
            }
            return class0.isInstance(object0);
        }
    }

    public static final Companion Companion;
    private static final Map FUNCTION_CLASSES;
    private static final HashMap classFqNames;
    private final Class jClass;
    private static final HashMap primitiveFqNames;
    private static final HashMap primitiveWrapperFqNames;
    private static final Map simpleNames;

    static {
        ClassReference.Companion = new Companion(null);
        int v = 0;
        Iterable iterable0 = CollectionsKt.listOf(new Class[]{Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class});
        ArrayList arrayList0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable0, 10));
        for(Object object0: iterable0) {
            if(v < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            arrayList0.add(TuplesKt.to(((Class)object0), v));
            ++v;
        }
        ClassReference.FUNCTION_CLASSES = MapsKt.toMap(arrayList0);
        HashMap hashMap0 = new HashMap();
        hashMap0.put(UnityPlayerActivity.adjustValue("0C1F020D0B0009"), "kotlin.Boolean");
        hashMap0.put(UnityPlayerActivity.adjustValue("0D180C13"), "kotlin.Char");
        hashMap0.put(UnityPlayerActivity.adjustValue("0C091904"), "kotlin.Byte");
        hashMap0.put(UnityPlayerActivity.adjustValue("1D1802131A"), "kotlin.Short");
        hashMap0.put(UnityPlayerActivity.adjustValue("071E19"), "kotlin.Int");
        hashMap0.put(UnityPlayerActivity.adjustValue("081C02001A"), "kotlin.Float");
        hashMap0.put(UnityPlayerActivity.adjustValue("021F0306"), "kotlin.Long");
        hashMap0.put(UnityPlayerActivity.adjustValue("0A1F18030204"), "kotlin.Double");
        ClassReference.primitiveFqNames = hashMap0;
        HashMap hashMap1 = new HashMap();
        hashMap1.put(UnityPlayerActivity.adjustValue("04111B00400D060B154032020E0204060B"), "kotlin.Boolean");
        hashMap1.put(UnityPlayerActivity.adjustValue("04111B00400D060B15403305001C000411171C"), "kotlin.Char");
        hashMap1.put(UnityPlayerActivity.adjustValue("04111B00400D060B15403214150B"), "kotlin.Byte");
        hashMap1.put(UnityPlayerActivity.adjustValue("04111B00400D060B154023050E1C15"), "kotlin.Short");
        hashMap1.put(UnityPlayerActivity.adjustValue("04111B00400D060B15403903150B060217"), "kotlin.Int");
        hashMap1.put(UnityPlayerActivity.adjustValue("04111B00400D060B154036010E0F15"), "kotlin.Float");
        hashMap1.put(UnityPlayerActivity.adjustValue("04111B00400D060B15403C020F09"), "kotlin.Long");
        hashMap1.put(UnityPlayerActivity.adjustValue("04111B00400D060B15403402140C0D02"), "kotlin.Double");
        ClassReference.primitiveWrapperFqNames = hashMap1;
        HashMap hashMap2 = new HashMap();
        hashMap2.put(UnityPlayerActivity.adjustValue("04111B00400D060B15403F0F0B0B0213"), "kotlin.Any");
        hashMap2.put(UnityPlayerActivity.adjustValue("04111B00400D060B1540231913070F00"), "kotlin.String");
        hashMap2.put(UnityPlayerActivity.adjustValue("04111B00400D060B15403305001C320214070B1E0E04"), "kotlin.CharSequence");
        hashMap2.put(UnityPlayerActivity.adjustValue("04111B00400D060B1540240513011606071E0B"), "kotlin.Throwable");
        hashMap2.put(UnityPlayerActivity.adjustValue("04111B00400D060B154033010E000406071E0B"), "kotlin.Cloneable");
        hashMap2.put(UnityPlayerActivity.adjustValue("04111B00400D060B15403E180C0C0415"), "kotlin.Number");
        hashMap2.put(UnityPlayerActivity.adjustValue("04111B00400D060B154033020C1E001504100215"), "kotlin.Comparable");
        hashMap2.put(UnityPlayerActivity.adjustValue("04111B00400D060B154035031403"), "kotlin.Enum");
        hashMap2.put(UnityPlayerActivity.adjustValue("04111B00400D060B154011030F011506111B011E4320000F0811131A19020F"), "kotlin.Annotation");
        hashMap2.put(UnityPlayerActivity.adjustValue("04111B00400D060B15403919041C00050917"), "kotlin.collections.Iterable");
        hashMap2.put(UnityPlayerActivity.adjustValue("04111B004014130C1E403919041C00130A00"), "kotlin.collections.Iterator");
        hashMap2.put(UnityPlayerActivity.adjustValue("04111B004014130C1E4033020D020404111B011E"), "kotlin.collections.Collection");
        hashMap2.put(UnityPlayerActivity.adjustValue("04111B004014130C1E403C04121A"), "kotlin.collections.List");
        hashMap2.put(UnityPlayerActivity.adjustValue("04111B004014130C1E40230815"), "kotlin.collections.Set");
        hashMap2.put(UnityPlayerActivity.adjustValue("04111B004014130C1E403C04121A281300000F040213"), "kotlin.collections.ListIterator");
        hashMap2.put(UnityPlayerActivity.adjustValue("04111B004014130C1E403D0C11"), "kotlin.collections.Map");
        hashMap2.put(UnityPlayerActivity.adjustValue("04111B004014130C1E403D0C114A2409110017"), "kotlin.collections.Map.Entry");
        hashMap2.put(UnityPlayerActivity.adjustValue("051F190D070F490F04035E040F1A04150B13025E3E151C08090231011D1D000008080B3D0C1A08021A"), "kotlin.String.Companion");
        hashMap2.put(UnityPlayerActivity.adjustValue("051F190D070F490F04035E040F1A04150B13025E280F1B0C240A1F1E110308010F2807180B1319"), "kotlin.Enum.Companion");
        hashMap2.putAll(hashMap0);
        hashMap2.putAll(hashMap1);
        Collection collection0 = hashMap0.values();
        Intrinsics.checkNotNullExpressionValue(collection0, UnityPlayerActivity.adjustValue("1E02040C07150E1317280123000304144B040F1C18041D"));
        for(Object object1: collection0) {
            Intrinsics.checkNotNullExpressionValue(((String)object1), UnityPlayerActivity.adjustValue("051F190D070F29041F0B"));
            Pair pair0 = TuplesKt.to((UnityPlayerActivity.adjustValue("051F190D070F490F04035E040F1A04150B13025E") + StringsKt.substringAfterLast$default(((String)object1), '.', null, 2, null) + UnityPlayerActivity.adjustValue("2D1F00110F0F0E0A1C211207040D15")), ((String)object1) + UnityPlayerActivity.adjustValue("4033020C1E00090C1D00"));
            hashMap2.put(pair0.getFirst(), pair0.getSecond());
        }
        for(Object object2: ClassReference.FUNCTION_CLASSES.entrySet()) {
            Class class0 = (Class)((Map.Entry)object2).getKey();
            int v1 = ((Number)((Map.Entry)object2).getValue()).intValue();
            hashMap2.put(class0.getName(), UnityPlayerActivity.adjustValue("051F190D070F49230700131908010F") + v1);
        }
        ClassReference.classFqNames = hashMap2;
        LinkedHashMap linkedHashMap0 = new LinkedHashMap(MapsKt.mapCapacity(hashMap2.size()));
        for(Object object3: hashMap2.entrySet()) {
            linkedHashMap0.put(((Map.Entry)object3).getKey(), StringsKt.substringAfterLast$default(((String)((Map.Entry)object3).getValue()), '.', null, 2, null));
        }
        ClassReference.simpleNames = linkedHashMap0;
    }

    public ClassReference(Class class0) {
        Intrinsics.checkNotNullParameter(class0, UnityPlayerActivity.adjustValue("043301001D12"));
        super();
        this.jClass = class0;
    }

    // 去混淆评级： 低(20)
    @Override  // kotlin.reflect.KClass
    public boolean equals(Object object0) {
        return object0 instanceof ClassReference && Intrinsics.areEqual(JvmClassMappingKt.getJavaObjectType(this), JvmClassMappingKt.getJavaObjectType(((KClass)object0)));
    }

    private final Void error() {
        throw new KotlinReflectionNotSupportedError();
    }

    @Override  // kotlin.reflect.KAnnotatedElement
    public List getAnnotations() {
        this.error();
        throw new KotlinNothingValueException();
    }

    @Override  // kotlin.reflect.KClass
    public Collection getConstructors() {
        this.error();
        throw new KotlinNothingValueException();
    }

    @Override  // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public Class getJClass() {
        return this.jClass;
    }

    @Override  // kotlin.reflect.KClass, kotlin.reflect.KDeclarationContainer
    public Collection getMembers() {
        this.error();
        throw new KotlinNothingValueException();
    }

    @Override  // kotlin.reflect.KClass
    public Collection getNestedClasses() {
        this.error();
        throw new KotlinNothingValueException();
    }

    @Override  // kotlin.reflect.KClass
    public Object getObjectInstance() {
        this.error();
        throw new KotlinNothingValueException();
    }

    @Override  // kotlin.reflect.KClass
    public String getQualifiedName() {
        return ClassReference.Companion.getClassQualifiedName(this.getJClass());
    }

    @Override  // kotlin.reflect.KClass
    public List getSealedSubclasses() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public static void getSealedSubclasses$annotations() {
    }

    @Override  // kotlin.reflect.KClass
    public String getSimpleName() {
        return ClassReference.Companion.getClassSimpleName(this.getJClass());
    }

    @Override  // kotlin.reflect.KClass
    public List getSupertypes() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public static void getSupertypes$annotations() {
    }

    @Override  // kotlin.reflect.KClass
    public List getTypeParameters() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public static void getTypeParameters$annotations() {
    }

    @Override  // kotlin.reflect.KClass
    public KVisibility getVisibility() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public static void getVisibility$annotations() {
    }

    @Override  // kotlin.reflect.KClass
    public int hashCode() {
        return JvmClassMappingKt.getJavaObjectType(this).hashCode();
    }

    @Override  // kotlin.reflect.KClass
    public boolean isAbstract() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public static void isAbstract$annotations() {
    }

    @Override  // kotlin.reflect.KClass
    public boolean isCompanion() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public static void isCompanion$annotations() {
    }

    @Override  // kotlin.reflect.KClass
    public boolean isData() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public static void isData$annotations() {
    }

    @Override  // kotlin.reflect.KClass
    public boolean isFinal() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public static void isFinal$annotations() {
    }

    @Override  // kotlin.reflect.KClass
    public boolean isFun() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public static void isFun$annotations() {
    }

    @Override  // kotlin.reflect.KClass
    public boolean isInner() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public static void isInner$annotations() {
    }

    @Override  // kotlin.reflect.KClass
    public boolean isInstance(Object object0) {
        return ClassReference.Companion.isInstance(object0, this.getJClass());
    }

    @Override  // kotlin.reflect.KClass
    public boolean isOpen() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public static void isOpen$annotations() {
    }

    @Override  // kotlin.reflect.KClass
    public boolean isSealed() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public static void isSealed$annotations() {
    }

    @Override  // kotlin.reflect.KClass
    public boolean isValue() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public static void isValue$annotations() {
    }

    @Override
    public String toString() {
        return this.getJClass().toString() + UnityPlayerActivity.adjustValue("4E58260E1A0D0E0B521C150B0D0B02130C1D005004124E0F0811520F060C08020005091747");
    }
}

