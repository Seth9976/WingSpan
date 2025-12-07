package kotlin.jvm.internal;

import com.unity3d.player.UnityPlayerActivity;
import java.io.Serializable;
import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;

public class FunInterfaceConstructorReference extends FunctionReference implements Serializable {
    private final Class funInterface;

    public FunInterfaceConstructorReference(Class class0) {
        super(1);
        this.funInterface = class0;
    }

    @Override  // kotlin.jvm.internal.FunctionReference
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof FunInterfaceConstructorReference ? this.funInterface.equals(((FunInterfaceConstructorReference)object0).funInterface) : false;
    }

    @Override  // kotlin.jvm.internal.FunctionReference
    protected KCallable getReflected() {
        return this.getReflected();
    }

    @Override  // kotlin.jvm.internal.FunctionReference
    protected KFunction getReflected() {
        throw new UnsupportedOperationException(UnityPlayerActivity.adjustValue("280503021A08080B130250040F1A041503130D154D02010F1411001B13190E1C41030A171D50030E1A411410021E1F1F154E1302031E0B131908010F"));
    }

    @Override  // kotlin.jvm.internal.FunctionReference
    public int hashCode() {
        return this.funInterface.hashCode();
    }

    @Override  // kotlin.jvm.internal.FunctionReference
    public String toString() {
        return UnityPlayerActivity.adjustValue("08050341070F13000008110E044E") + this.funInterface.getName();
    }
}

