package kotlinx.coroutines.internal;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u001F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001A\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002j\u0002`\u00040\u0001J(\u0010\u0005\u001A\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002j\u0002`\u00042\f\u0010\u0006\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u0007H\u0014¨\u0006\b"}, d2 = {"kotlinx/coroutines/internal/ClassValueCtorCache$cache$1", "Ljava/lang/ClassValue;", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/Ctor;", "computeValue", "type", "Ljava/lang/Class;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
public final class ClassValueCtorCache.cache.1 extends ClassValue {
    @Override
    public Object computeValue(Class class0) {
        return this.computeValue(class0);
    }

    protected Function1 computeValue(Class class0) {
        if(class0 == null) {
            throw new NullPointerException(UnityPlayerActivity.adjustValue("0005010D4E02060B1C01044D030B410404011A50190E4E0F080B5F0005010D4E151E15174E1A0C170F4F0B041C095E2E0D0F1214591D1B044D0A01150B0C1C40240513011606071E0B4E"));
        }
        return ExceptionsConstructorKt.access$createConstructor(class0);
    }
}

