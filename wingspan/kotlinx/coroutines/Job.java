package kotlinx.coroutines;

import com.unity3d.player.UnityPlayerActivity;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.selects.SelectClause0;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000 (2\u00020\u0001:\u0001(J\u0010\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0012H\'J\b\u0010\u0013\u001A\u00020\u0014H\u0017J\u0014\u0010\u0013\u001A\u00020\u00072\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u0016H\'J\u001A\u0010\u0013\u001A\u00020\u00142\u0010\b\u0002\u0010\u0015\u001A\n\u0018\u00010\u0017j\u0004\u0018\u0001`\u0018H&J\f\u0010\u0019\u001A\u00060\u0017j\u0002`\u0018H\'JE\u0010\u001A\u001A\u00020\u001B2\b\b\u0002\u0010\u001C\u001A\u00020\u00072\b\b\u0002\u0010\u001D\u001A\u00020\u00072\'\u0010\u001E\u001A#\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00140\u001Fj\u0002`\"H\'J1\u0010\u001A\u001A\u00020\u001B2\'\u0010\u001E\u001A#\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00140\u001Fj\u0002`\"H&J\u0011\u0010#\u001A\u00020\u0014H¦@ø\u0001\u0000¢\u0006\u0002\u0010$J\u0011\u0010%\u001A\u00020\u00002\u0006\u0010&\u001A\u00020\u0000H\u0097\u0002J\b\u0010\'\u001A\u00020\u0007H&R\u0018\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00000\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001A\u00020\u0007X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0006\u0010\bR\u0012\u0010\t\u001A\u00020\u0007X¦\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\bR\u0012\u0010\n\u001A\u00020\u0007X¦\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\bR\u0012\u0010\u000B\u001A\u00020\fX¦\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000E\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/CoroutineContext$Element;", "children", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "isActive", "", "()Z", "isCancelled", "isCompleted", "onJoin", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "attachChild", "Lkotlinx/coroutines/ChildHandle;", "child", "Lkotlinx/coroutines/ChildJob;", "cancel", "", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "getCancellationException", "invokeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "onCancelling", "invokeImmediately", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "join", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plus", "other", "start", "Key", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
public interface Job extends Element {
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 0x30)
    public static final class DefaultImpls {
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
        public static void cancel(Job job0) {
            job0.cancel(null);
        }

        public static void cancel$default(Job job0, CancellationException cancellationException0, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException(UnityPlayerActivity.adjustValue("3D051D041C4104041E02034D1607150F45160B160C14021547040009050004001514451C01044D121B11170A001A150941070F47111A07034D150F1300000642500B140002130C1D004A4D020F0F04001E"));
            }
            if((v & 1) != 0) {
                cancellationException0 = null;
            }
            job0.cancel(cancellationException0);
        }

        public static boolean cancel$default(Job job0, Throwable throwable0, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException(UnityPlayerActivity.adjustValue("3D051D041C4104041E02034D1607150F45160B160C14021547040009050004001514451C01044D121B11170A001A150941070F47111A07034D150F1300000642500B140002130C1D004A4D020F0F04001E"));
            }
            if((v & 1) != 0) {
                throwable0 = null;
            }
            return job0.cancel(throwable0);
        }

        public static Object fold(Job job0, Object object0, Function2 function20) {
            return kotlin.coroutines.CoroutineContext.Element.DefaultImpls.fold(job0, object0, function20);
        }

        public static Element get(Job job0, Key coroutineContext$Key0) {
            return kotlin.coroutines.CoroutineContext.Element.DefaultImpls.get(job0, coroutineContext$Key0);
        }

        public static DisposableHandle invokeOnCompletion$default(Job job0, boolean z, boolean z1, Function1 function10, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException(UnityPlayerActivity.adjustValue("3D051D041C4104041E02034D1607150F45160B160C14021547040009050004001514451C01044D121B11170A001A150941070F47111A07034D150F1300000642500B140002130C1D004A4D080017080E17211E2E0E03110B0006071F03"));
            }
            if((v & 1) != 0) {
                z = false;
            }
            if((v & 2) != 0) {
                z1 = true;
            }
            return job0.invokeOnCompletion(z, z1, function10);
        }

        public static CoroutineContext minusKey(Job job0, Key coroutineContext$Key0) {
            return kotlin.coroutines.CoroutineContext.Element.DefaultImpls.minusKey(job0, coroutineContext$Key0);
        }

        public static CoroutineContext plus(Job job0, CoroutineContext coroutineContext0) {
            return kotlin.coroutines.CoroutineContext.Element.DefaultImpls.plus(job0, coroutineContext0);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Operator \'+\' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        public static Job plus(Job job0, Job job1) [...] // Inlined contents
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlinx/coroutines/Job$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/Job;", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    public static final class kotlinx.coroutines.Job.Key implements Key {
        static final kotlinx.coroutines.Job.Key $$INSTANCE;

        static {
            kotlinx.coroutines.Job.Key.$$INSTANCE = new kotlinx.coroutines.Job.Key();
        }
    }

    public static final kotlinx.coroutines.Job.Key Key;

    static {
        Job.Key = kotlinx.coroutines.Job.Key.$$INSTANCE;
    }

    ChildHandle attachChild(ChildJob arg1);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    void cancel();

    void cancel(CancellationException arg1);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    boolean cancel(Throwable arg1);

    CancellationException getCancellationException();

    Sequence getChildren();

    SelectClause0 getOnJoin();

    DisposableHandle invokeOnCompletion(Function1 arg1);

    DisposableHandle invokeOnCompletion(boolean arg1, boolean arg2, Function1 arg3);

    boolean isActive();

    boolean isCancelled();

    boolean isCompleted();

    Object join(Continuation arg1);

    @Deprecated(level = DeprecationLevel.ERROR, message = "Operator \'+\' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    Job plus(Job arg1);

    boolean start();
}

