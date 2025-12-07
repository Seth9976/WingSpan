package kotlin.jvm.internal;

import com.unity3d.player.UnityPlayerActivity;
import java.util.List;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KMutableProperty2;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty2;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVariance;

public class ReflectionFactory {
    private static final String KOTLIN_JVM_FUNCTIONS = "kotlin.jvm.functions.";

    public KClass createKotlinClass(Class class0) {
        return new ClassReference(class0);
    }

    public KClass createKotlinClass(Class class0, String s) {
        return new ClassReference(class0);
    }

    public KFunction function(FunctionReference functionReference0) [...] // Inlined contents

    public KClass getOrCreateKotlinClass(Class class0) {
        return new ClassReference(class0);
    }

    public KClass getOrCreateKotlinClass(Class class0, String s) {
        return new ClassReference(class0);
    }

    public KDeclarationContainer getOrCreateKotlinPackage(Class class0, String s) {
        return new PackageReference(class0, s);
    }

    public KType mutableCollectionType(KType kType0) {
        return new TypeReference(kType0.getClassifier(), kType0.getArguments(), ((TypeReference)kType0).getPlatformTypeUpperBound$kotlin_stdlib(), ((TypeReference)kType0).getFlags$kotlin_stdlib() | 2);
    }

    public KMutableProperty0 mutableProperty0(MutablePropertyReference0 mutablePropertyReference00) [...] // Inlined contents

    public KMutableProperty1 mutableProperty1(MutablePropertyReference1 mutablePropertyReference10) [...] // Inlined contents

    public KMutableProperty2 mutableProperty2(MutablePropertyReference2 mutablePropertyReference20) [...] // Inlined contents

    public KType nothingType(KType kType0) {
        return new TypeReference(kType0.getClassifier(), kType0.getArguments(), ((TypeReference)kType0).getPlatformTypeUpperBound$kotlin_stdlib(), ((TypeReference)kType0).getFlags$kotlin_stdlib() | 4);
    }

    public KType platformType(KType kType0, KType kType1) {
        return new TypeReference(kType0.getClassifier(), kType0.getArguments(), kType1, ((TypeReference)kType0).getFlags$kotlin_stdlib());
    }

    public KProperty0 property0(PropertyReference0 propertyReference00) [...] // Inlined contents

    public KProperty1 property1(PropertyReference1 propertyReference10) [...] // Inlined contents

    public KProperty2 property2(PropertyReference2 propertyReference20) [...] // Inlined contents

    public String renderLambdaToString(FunctionBase functionBase0) {
        String s = functionBase0.getClass().getGenericInterfaces()[0].toString();
        return s.startsWith(UnityPlayerActivity.adjustValue("051F190D070F490F04035E0B140002130C1D000343")) ? s.substring(21) : s;
    }

    public String renderLambdaToString(Lambda lambda0) {
        return this.renderLambdaToString(lambda0);
    }

    public void setUpperBounds(KTypeParameter kTypeParameter0, List list0) {
        ((TypeParameterReference)kTypeParameter0).setUpperBounds(list0);
    }

    public KType typeOf(KClassifier kClassifier0, List list0, boolean z) {
        return new TypeReference(kClassifier0, list0, z);
    }

    public KTypeParameter typeParameter(Object object0, String s, KVariance kVariance0, boolean z) {
        return new TypeParameterReference(object0, s, kVariance0, z);
    }
}

