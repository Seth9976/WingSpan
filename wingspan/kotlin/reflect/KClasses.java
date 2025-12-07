package kotlin.reflect;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A+\u0010\u0000\u001A\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0010\u0004\u001A\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0002\u0010\u0005\u001A-\u0010\u0006\u001A\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0010\u0004\u001A\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0007"}, d2 = {"cast", "T", "", "Lkotlin/reflect/KClass;", "value", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Ljava/lang/Object;", "safeCast", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 0x30)
public final class KClasses {
    public static final Object cast(KClass kClass0, Object object0) {
        Intrinsics.checkNotNullParameter(kClass0, UnityPlayerActivity.adjustValue("520405081D5F"));
        if(!kClass0.isInstance(object0)) {
            throw new ClassCastException(UnityPlayerActivity.adjustValue("381101140B4104041C001F19410C044706131D044D150141") + kClass0.getQualifiedName());
        }
        Intrinsics.checkNotNull(object0, UnityPlayerActivity.adjustValue("0005010D4E02060B1C01044D030B410404011A50190E4E0F080B5F0005010D4E151E15174E244D0E08410C0A060219034F1C040109170D04432A2D0D0616010B0343020F1213"));
        return object0;
    }

    public static final Object safeCast(KClass kClass0, Object object0) {
        Intrinsics.checkNotNullParameter(kClass0, UnityPlayerActivity.adjustValue("520405081D5F"));
        if(kClass0.isInstance(object0)) {
            Intrinsics.checkNotNull(object0, UnityPlayerActivity.adjustValue("0005010D4E02060B1C01044D030B410404011A50190E4E0F080B5F0005010D4E151E15174E244D0E08410C0A060219034F1C040109170D04432A2D0D0616010B0343120F070226131D04"));
            return object0;
        }
        return null;
    }
}

