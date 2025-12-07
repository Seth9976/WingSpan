package kotlinx.coroutines;

import androidx.work.impl.model.WorkSpec..ExternalSyntheticBackport0;
import com.unity3d.player.UnityPlayerActivity;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0081\b\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0018B\r\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\t\u001A\u00020\u0005HÆ\u0003J\u0013\u0010\n\u001A\u00020\u00002\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u000EHÖ\u0003J\t\u0010\u000F\u001A\u00020\u0010HÖ\u0001J\u0018\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u0002H\u0016J\b\u0010\u0016\u001A\u00020\u0002H\u0016J\u0010\u0010\u0017\u001A\u00020\u00022\u0006\u0010\u0013\u001A\u00020\u0014H\u0016R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/CoroutineId;", "Lkotlinx/coroutines/ThreadContextElement;", "", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "id", "", "(J)V", "getId", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "restoreThreadContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "oldState", "toString", "updateThreadContext", "Key", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
public final class CoroutineId extends AbstractCoroutineContextElement implements ThreadContextElement {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlinx/coroutines/CoroutineId$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/CoroutineId;", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    public static final class Key implements kotlin.coroutines.CoroutineContext.Key {
        private Key() {
        }

        public Key(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final Key Key;
    private final long id;

    static {
        CoroutineId.Key = new Key(null);
    }

    public CoroutineId(long v) {
        super(CoroutineId.Key);
        this.id = v;
    }

    public final long component1() {
        return this.id;
    }

    public final CoroutineId copy(long v) {
        return new CoroutineId(v);
    }

    public static CoroutineId copy$default(CoroutineId coroutineId0, long v, int v1, Object object0) {
        if((v1 & 1) != 0) {
            v = coroutineId0.id;
        }
        return coroutineId0.copy(v);
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof CoroutineId ? this.id == ((CoroutineId)object0).id : false;
    }

    public final long getId() {
        return this.id;
    }

    @Override
    public int hashCode() {
        return WorkSpec..ExternalSyntheticBackport0.m(this.id);
    }

    @Override  // kotlinx.coroutines.ThreadContextElement
    public void restoreThreadContext(CoroutineContext coroutineContext0, Object object0) {
        this.restoreThreadContext(coroutineContext0, ((String)object0));
    }

    public void restoreThreadContext(CoroutineContext coroutineContext0, String s) {
        Thread.currentThread().setName(s);
    }

    @Override
    public String toString() {
        return UnityPlayerActivity.adjustValue("2D1F1F0E1B150E0B17271445") + this.id + ')';
    }

    @Override  // kotlinx.coroutines.ThreadContextElement
    public Object updateThreadContext(CoroutineContext coroutineContext0) {
        return this.updateThreadContext(coroutineContext0);
    }

    public String updateThreadContext(CoroutineContext coroutineContext0) {
        String s;
        CoroutineName coroutineName0 = (CoroutineName)coroutineContext0.get(CoroutineName.Key);
        if(coroutineName0 == null) {
            s = UnityPlayerActivity.adjustValue("0D1F1F0E1B150E0B17");
        }
        else {
            s = coroutineName0.getName();
            if(s == null) {
                s = UnityPlayerActivity.adjustValue("0D1F1F0E1B150E0B17");
            }
        }
        Thread thread0 = Thread.currentThread();
        String s1 = thread0.getName();
        int v = StringsKt.lastIndexOf$default(s1, UnityPlayerActivity.adjustValue("4E30"), 0, false, 6, null);
        if(v < 0) {
            v = s1.length();
        }
        String s2 = s1.substring(0, v);
        Intrinsics.checkNotNullExpressionValue(s2, UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C3D041F08000685E5D4071E0A491D15061706271E0904164D47001C0A3903050B194E"));
        String s3 = s2 + UnityPlayerActivity.adjustValue("4E30") + s + '#' + this.id;
        Intrinsics.checkNotNullExpressionValue(s3, UnityPlayerActivity.adjustValue("3D041F08000625101B0214081346020615130D191918474F85E5D40C05040D0A041524111A19020F474F130A211A02040F09494E"));
        thread0.setName(s3);
        return s1;
    }
}

