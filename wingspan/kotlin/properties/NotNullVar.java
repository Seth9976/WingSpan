package kotlin.properties;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J$\u0010\u0007\u001A\u00028\u00002\b\u0010\b\u001A\u0004\u0018\u00010\u00022\n\u0010\t\u001A\u0006\u0012\u0002\b\u00030\nH\u0096\u0002¢\u0006\u0002\u0010\u000BJ,\u0010\f\u001A\u00020\r2\b\u0010\b\u001A\u0004\u0018\u00010\u00022\n\u0010\t\u001A\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u0005\u001A\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u000ER\u0012\u0010\u0005\u001A\u0004\u0018\u00018\u0000X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u000F"}, d2 = {"Lkotlin/properties/NotNullVar;", "T", "", "Lkotlin/properties/ReadWriteProperty;", "()V", "value", "Ljava/lang/Object;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
final class NotNullVar implements ReadWriteProperty {
    private Object value;

    @Override  // kotlin.properties.ReadWriteProperty
    public Object getValue(Object object0, KProperty kProperty0) {
        Intrinsics.checkNotNullParameter(kProperty0, UnityPlayerActivity.adjustValue("1E0202110B13131C"));
        Object object1 = this.value;
        if(object1 == null) {
            throw new IllegalStateException(UnityPlayerActivity.adjustValue("3E0202110B13131C52") + kProperty0.getName() + UnityPlayerActivity.adjustValue("4E03050E1B0D0345100B50040F07150E041E070A08054E0302031D1C154D060B1549"));
        }
        return object1;
    }

    @Override  // kotlin.properties.ReadWriteProperty
    public void setValue(Object object0, KProperty kProperty0, Object object1) {
        Intrinsics.checkNotNullParameter(kProperty0, UnityPlayerActivity.adjustValue("1E0202110B13131C"));
        Intrinsics.checkNotNullParameter(object1, UnityPlayerActivity.adjustValue("181101140B"));
        this.value = object1;
    }
}

