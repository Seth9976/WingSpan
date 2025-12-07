package kotlin.jvm.internal;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;

public abstract class PropertyReference extends CallableReference implements KProperty {
    public PropertyReference() {
    }

    public PropertyReference(Object object0) {
        super(object0);
    }

    public PropertyReference(Object object0, Class class0, String s, String s1, int v) {
        super(object0, class0, s, s1, (v & 1) == 1);
    }

    @Override
    public boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(object0 instanceof PropertyReference) {
            return this.getOwner().equals(((PropertyReference)object0).getOwner()) && this.getName().equals(((PropertyReference)object0).getName()) && this.getSignature().equals(((PropertyReference)object0).getSignature()) && Intrinsics.areEqual(this.getBoundReceiver(), ((PropertyReference)object0).getBoundReceiver());
        }
        return object0 instanceof KProperty ? object0.equals(this.compute()) : false;
    }

    @Override  // kotlin.jvm.internal.CallableReference
    protected KCallable getReflected() {
        return this.getReflected();
    }

    protected KProperty getReflected() {
        return (KProperty)super.getReflected();
    }

    @Override
    public int hashCode() {
        return (this.getOwner().hashCode() * 0x1F + this.getName().hashCode()) * 0x1F + this.getSignature().hashCode();
    }

    @Override  // kotlin.reflect.KProperty
    public boolean isConst() {
        return this.getReflected().isConst();
    }

    @Override  // kotlin.reflect.KProperty
    public boolean isLateinit() {
        return this.getReflected().isLateinit();
    }

    @Override
    public String toString() {
        KCallable kCallable0 = this.compute();
        return kCallable0 == this ? UnityPlayerActivity.adjustValue("1E0202110B13131C52") + this.getName() + UnityPlayerActivity.adjustValue("4E58260E1A0D0E0B521C150B0D0B02130C1D005004124E0F0811520F060C08020005091747") : kCallable0.toString();
    }
}

