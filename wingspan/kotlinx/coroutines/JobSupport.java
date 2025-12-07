package kotlinx.coroutines;

import androidx.work.impl.model.WorkSpec..ExternalSyntheticBackport0;
import com.unity3d.player.UnityPlayerActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode.CondAddOp;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause0;
import kotlinx.coroutines.selects.SelectInstance;

@Deprecated(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
@Metadata(d1 = {"\u0000\u00E8\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0001\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0017\u0018\u00002\u00020X2\u00020\u00172\u00020\u007F2\u00030\u00C3\u0001:\u0006\u00D2\u0001\u00D3\u0001\u00D4\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0001\u00A2\u0006\u0004\b\u0003\u0010\u0004J\'\u0010\u000B\u001A\u00020\u00012\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\tH\u0002\u00A2\u0006\u0004\b\u000B\u0010\fJ%\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u000E\u001A\u00020\r2\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\r0\u000FH\u0002\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0015\u001A\u00020\u00112\b\u0010\u0014\u001A\u0004\u0018\u00010\u0005H\u0014\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u001A\u001A\u00020\u00192\u0006\u0010\u0018\u001A\u00020\u0017\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u0015\u0010\u001E\u001A\u0004\u0018\u00010\u0005H\u0080@\u00F8\u0001\u0000\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u0015\u0010\u001F\u001A\u0004\u0018\u00010\u0005H\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0004\b\u001F\u0010\u001DJ\u0019\u0010!\u001A\u00020\u00012\b\u0010 \u001A\u0004\u0018\u00010\rH\u0017\u00A2\u0006\u0004\b!\u0010\"J\u001F\u0010!\u001A\u00020\u00112\u000E\u0010 \u001A\n\u0018\u00010#j\u0004\u0018\u0001`$H\u0016\u00A2\u0006\u0004\b!\u0010%J\u0017\u0010&\u001A\u00020\u00012\b\u0010 \u001A\u0004\u0018\u00010\r\u00A2\u0006\u0004\b&\u0010\"J\u0019\u0010)\u001A\u00020\u00012\b\u0010 \u001A\u0004\u0018\u00010\u0005H\u0000\u00A2\u0006\u0004\b\'\u0010(J\u0017\u0010*\u001A\u00020\u00112\u0006\u0010 \u001A\u00020\rH\u0016\u00A2\u0006\u0004\b*\u0010+J\u001B\u0010,\u001A\u0004\u0018\u00010\u00052\b\u0010 \u001A\u0004\u0018\u00010\u0005H\u0002\u00A2\u0006\u0004\b,\u0010-J\u0017\u0010.\u001A\u00020\u00012\u0006\u0010 \u001A\u00020\rH\u0002\u00A2\u0006\u0004\b.\u0010\"J\u000F\u00100\u001A\u00020/H\u0014\u00A2\u0006\u0004\b0\u00101J\u0017\u00102\u001A\u00020\u00012\u0006\u0010 \u001A\u00020\rH\u0016\u00A2\u0006\u0004\b2\u0010\"J!\u00105\u001A\u00020\u00112\u0006\u0010\u0014\u001A\u0002032\b\u00104\u001A\u0004\u0018\u00010\u0005H\u0002\u00A2\u0006\u0004\b5\u00106J)\u0010;\u001A\u00020\u00112\u0006\u0010\u0014\u001A\u0002072\u0006\u00109\u001A\u0002082\b\u0010:\u001A\u0004\u0018\u00010\u0005H\u0002\u00A2\u0006\u0004\b;\u0010<J\u0019\u0010=\u001A\u00020\r2\b\u0010 \u001A\u0004\u0018\u00010\u0005H\u0002\u00A2\u0006\u0004\b=\u0010>J(\u0010C\u001A\u00020@2\n\b\u0002\u0010?\u001A\u0004\u0018\u00010/2\n\b\u0002\u0010 \u001A\u0004\u0018\u00010\rH\u0080\b\u00A2\u0006\u0004\bA\u0010BJ#\u0010D\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001A\u0002072\b\u0010:\u001A\u0004\u0018\u00010\u0005H\u0002\u00A2\u0006\u0004\bD\u0010EJ\u0019\u0010F\u001A\u0004\u0018\u0001082\u0006\u0010\u0014\u001A\u000203H\u0002\u00A2\u0006\u0004\bF\u0010GJ\u0011\u0010H\u001A\u00060#j\u0002`$\u00A2\u0006\u0004\bH\u0010IJ\u0013\u0010J\u001A\u00060#j\u0002`$H\u0016\u00A2\u0006\u0004\bJ\u0010IJ\u0011\u0010M\u001A\u0004\u0018\u00010\u0005H\u0000\u00A2\u0006\u0004\bK\u0010LJ\u000F\u0010N\u001A\u0004\u0018\u00010\r\u00A2\u0006\u0004\bN\u0010OJ\'\u0010P\u001A\u0004\u0018\u00010\r2\u0006\u0010\u0014\u001A\u0002072\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\r0\u000FH\u0002\u00A2\u0006\u0004\bP\u0010QJ\u0019\u0010R\u001A\u0004\u0018\u00010\u00072\u0006\u0010\u0014\u001A\u000203H\u0002\u00A2\u0006\u0004\bR\u0010SJ\u0017\u0010U\u001A\u00020\u00012\u0006\u0010T\u001A\u00020\rH\u0014\u00A2\u0006\u0004\bU\u0010\"J\u0017\u0010W\u001A\u00020\u00112\u0006\u0010T\u001A\u00020\rH\u0010\u00A2\u0006\u0004\bV\u0010+J\u0019\u0010Z\u001A\u00020\u00112\b\u0010Y\u001A\u0004\u0018\u00010XH\u0004\u00A2\u0006\u0004\bZ\u0010[JF\u0010d\u001A\u00020c2\u0006\u0010\\\u001A\u00020\u00012\u0006\u0010]\u001A\u00020\u00012\'\u0010b\u001A#\u0012\u0015\u0012\u0013\u0018\u00010\r\u00A2\u0006\f\b_\u0012\b\b`\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00110^j\u0002`a\u00A2\u0006\u0004\bd\u0010eJ6\u0010d\u001A\u00020c2\'\u0010b\u001A#\u0012\u0015\u0012\u0013\u0018\u00010\r\u00A2\u0006\f\b_\u0012\b\b`\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00110^j\u0002`a\u00A2\u0006\u0004\bd\u0010fJ\u0013\u0010g\u001A\u00020\u0011H\u0086@\u00F8\u0001\u0000\u00A2\u0006\u0004\bg\u0010\u001DJ\u000F\u0010h\u001A\u00020\u0001H\u0002\u00A2\u0006\u0004\bh\u0010iJ\u0013\u0010j\u001A\u00020\u0011H\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0004\bj\u0010\u001DJ&\u0010m\u001A\u00020l2\u0014\u0010k\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00110^H\u0082\b\u00A2\u0006\u0004\bm\u0010nJ\u001B\u0010o\u001A\u0004\u0018\u00010\u00052\b\u0010 \u001A\u0004\u0018\u00010\u0005H\u0002\u00A2\u0006\u0004\bo\u0010-J\u0019\u0010q\u001A\u00020\u00012\b\u0010:\u001A\u0004\u0018\u00010\u0005H\u0000\u00A2\u0006\u0004\bp\u0010(J\u001B\u0010s\u001A\u0004\u0018\u00010\u00052\b\u0010:\u001A\u0004\u0018\u00010\u0005H\u0000\u00A2\u0006\u0004\br\u0010-J@\u0010t\u001A\u00020\t2\'\u0010b\u001A#\u0012\u0015\u0012\u0013\u0018\u00010\r\u00A2\u0006\f\b_\u0012\b\b`\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00110^j\u0002`a2\u0006\u0010\\\u001A\u00020\u0001H\u0002\u00A2\u0006\u0004\bt\u0010uJ\u000F\u0010w\u001A\u00020/H\u0010\u00A2\u0006\u0004\bv\u00101J\u001F\u0010x\u001A\u00020\u00112\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010 \u001A\u00020\rH\u0002\u00A2\u0006\u0004\bx\u0010yJ.\u0010{\u001A\u00020\u0011\"\n\b\u0000\u0010z\u0018\u0001*\u00020\t2\u0006\u0010\b\u001A\u00020\u00072\b\u0010 \u001A\u0004\u0018\u00010\rH\u0082\b\u00A2\u0006\u0004\b{\u0010yJ\u0019\u0010\\\u001A\u00020\u00112\b\u0010 \u001A\u0004\u0018\u00010\rH\u0014\u00A2\u0006\u0004\b\\\u0010+J\u0019\u0010|\u001A\u00020\u00112\b\u0010\u0014\u001A\u0004\u0018\u00010\u0005H\u0014\u00A2\u0006\u0004\b|\u0010\u0016J\u000F\u0010}\u001A\u00020\u0011H\u0014\u00A2\u0006\u0004\b}\u0010~J\u0019\u0010\u0081\u0001\u001A\u00020\u00112\u0007\u0010\u0080\u0001\u001A\u00020\u007F\u00A2\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u001B\u0010\u0084\u0001\u001A\u00020\u00112\u0007\u0010\u0014\u001A\u00030\u0083\u0001H\u0002\u00A2\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u001A\u0010\u0086\u0001\u001A\u00020\u00112\u0006\u0010\u0014\u001A\u00020\tH\u0002\u00A2\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001JI\u0010\u008C\u0001\u001A\u00020\u0011\"\u0005\b\u0000\u0010\u0088\u00012\u000E\u0010\u008A\u0001\u001A\t\u0012\u0004\u0012\u00028\u00000\u0089\u00012\u001D\u0010k\u001A\u0019\b\u0001\u0012\u000B\u0012\t\u0012\u0004\u0012\u00028\u00000\u008B\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00050^\u00F8\u0001\u0000\u00A2\u0006\u0006\b\u008C\u0001\u0010\u008D\u0001JX\u0010\u0091\u0001\u001A\u00020\u0011\"\u0004\b\u0000\u0010z\"\u0005\b\u0001\u0010\u0088\u00012\u000E\u0010\u008A\u0001\u001A\t\u0012\u0004\u0012\u00028\u00010\u0089\u00012$\u0010k\u001A \b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u000B\u0012\t\u0012\u0004\u0012\u00028\u00010\u008B\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u008E\u0001H\u0000\u00F8\u0001\u0000\u00A2\u0006\u0006\b\u008F\u0001\u0010\u0090\u0001J\u001A\u0010\u0093\u0001\u001A\u00020\u00112\u0006\u0010\n\u001A\u00020\tH\u0000\u00A2\u0006\u0006\b\u0092\u0001\u0010\u0087\u0001JX\u0010\u0095\u0001\u001A\u00020\u0011\"\u0004\b\u0000\u0010z\"\u0005\b\u0001\u0010\u0088\u00012\u000E\u0010\u008A\u0001\u001A\t\u0012\u0004\u0012\u00028\u00010\u0089\u00012$\u0010k\u001A \b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u000B\u0012\t\u0012\u0004\u0012\u00028\u00010\u008B\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u008E\u0001H\u0000\u00F8\u0001\u0000\u00A2\u0006\u0006\b\u0094\u0001\u0010\u0090\u0001J\u000F\u0010\u0096\u0001\u001A\u00020\u0001\u00A2\u0006\u0005\b\u0096\u0001\u0010iJ\u001D\u0010\u0098\u0001\u001A\u00030\u0097\u00012\b\u0010\u0014\u001A\u0004\u0018\u00010\u0005H\u0002\u00A2\u0006\u0006\b\u0098\u0001\u0010\u0099\u0001J\u001C\u0010\u009A\u0001\u001A\u00020/2\b\u0010\u0014\u001A\u0004\u0018\u00010\u0005H\u0002\u00A2\u0006\u0006\b\u009A\u0001\u0010\u009B\u0001J\u0011\u0010\u009C\u0001\u001A\u00020/H\u0007\u00A2\u0006\u0005\b\u009C\u0001\u00101J\u0011\u0010\u009D\u0001\u001A\u00020/H\u0016\u00A2\u0006\u0005\b\u009D\u0001\u00101J$\u0010\u009E\u0001\u001A\u00020\u00012\u0006\u0010\u0014\u001A\u0002032\b\u00104\u001A\u0004\u0018\u00010\u0005H\u0002\u00A2\u0006\u0006\b\u009E\u0001\u0010\u009F\u0001J\"\u0010\u00A0\u0001\u001A\u00020\u00012\u0006\u0010\u0014\u001A\u0002032\u0006\u0010\u000E\u001A\u00020\rH\u0002\u00A2\u0006\u0006\b\u00A0\u0001\u0010\u00A1\u0001J(\u0010\u00A2\u0001\u001A\u0004\u0018\u00010\u00052\b\u0010\u0014\u001A\u0004\u0018\u00010\u00052\b\u0010:\u001A\u0004\u0018\u00010\u0005H\u0002\u00A2\u0006\u0006\b\u00A2\u0001\u0010\u00A3\u0001J&\u0010\u00A4\u0001\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001A\u0002032\b\u0010:\u001A\u0004\u0018\u00010\u0005H\u0002\u00A2\u0006\u0006\b\u00A4\u0001\u0010\u00A5\u0001J-\u0010\u00A6\u0001\u001A\u00020\u00012\u0006\u0010\u0014\u001A\u0002072\u0006\u0010\u0018\u001A\u0002082\b\u0010:\u001A\u0004\u0018\u00010\u0005H\u0082\u0010\u00A2\u0006\u0006\b\u00A6\u0001\u0010\u00A7\u0001J\u0019\u0010\u00A9\u0001\u001A\u0004\u0018\u000108*\u00030\u00A8\u0001H\u0002\u00A2\u0006\u0006\b\u00A9\u0001\u0010\u00AA\u0001J\u001F\u0010\u00AB\u0001\u001A\u00020\u0011*\u00020\u00072\b\u0010 \u001A\u0004\u0018\u00010\rH\u0002\u00A2\u0006\u0005\b\u00AB\u0001\u0010yJ&\u0010\u00AC\u0001\u001A\u00060#j\u0002`$*\u00020\r2\n\b\u0002\u0010?\u001A\u0004\u0018\u00010/H\u0004\u00A2\u0006\u0006\b\u00AC\u0001\u0010\u00AD\u0001R\u001B\u0010\u00B1\u0001\u001A\t\u0012\u0004\u0012\u00020X0\u00AE\u00018F\u00A2\u0006\b\u001A\u0006\b\u00AF\u0001\u0010\u00B0\u0001R\u0018\u0010\u00B3\u0001\u001A\u0004\u0018\u00010\r8DX\u0084\u0004\u00A2\u0006\u0007\u001A\u0005\b\u00B2\u0001\u0010OR\u0016\u0010\u00B5\u0001\u001A\u00020\u00018DX\u0084\u0004\u00A2\u0006\u0007\u001A\u0005\b\u00B4\u0001\u0010iR\u0016\u0010\u00B7\u0001\u001A\u00020\u00018PX\u0090\u0004\u00A2\u0006\u0007\u001A\u0005\b\u00B6\u0001\u0010iR\u0016\u0010\u00B8\u0001\u001A\u00020\u00018VX\u0096\u0004\u00A2\u0006\u0007\u001A\u0005\b\u00B8\u0001\u0010iR\u0013\u0010\u00B9\u0001\u001A\u00020\u00018F\u00A2\u0006\u0007\u001A\u0005\b\u00B9\u0001\u0010iR\u0013\u0010\u00BA\u0001\u001A\u00020\u00018F\u00A2\u0006\u0007\u001A\u0005\b\u00BA\u0001\u0010iR\u0013\u0010\u00BB\u0001\u001A\u00020\u00018F\u00A2\u0006\u0007\u001A\u0005\b\u00BB\u0001\u0010iR\u0016\u0010\u00BC\u0001\u001A\u00020\u00018TX\u0094\u0004\u00A2\u0006\u0007\u001A\u0005\b\u00BC\u0001\u0010iR\u0019\u0010\u00C0\u0001\u001A\u0007\u0012\u0002\b\u00030\u00BD\u00018F\u00A2\u0006\b\u001A\u0006\b\u00BE\u0001\u0010\u00BF\u0001R\u0016\u0010\u00C2\u0001\u001A\u00020\u00018PX\u0090\u0004\u00A2\u0006\u0007\u001A\u0005\b\u00C1\u0001\u0010iR\u0015\u0010\u00C6\u0001\u001A\u00030\u00C3\u00018F\u00A2\u0006\b\u001A\u0006\b\u00C4\u0001\u0010\u00C5\u0001R.\u0010\u00CC\u0001\u001A\u0004\u0018\u00010\u00192\t\u0010\u00C7\u0001\u001A\u0004\u0018\u00010\u00198@@@X\u0080\u000E\u00A2\u0006\u0010\u001A\u0006\b\u00C8\u0001\u0010\u00C9\u0001\"\u0006\b\u00CA\u0001\u0010\u00CB\u0001R\u0017\u0010\u0014\u001A\u0004\u0018\u00010\u00058@X\u0080\u0004\u00A2\u0006\u0007\u001A\u0005\b\u00CD\u0001\u0010LR\u001E\u0010\u00CF\u0001\u001A\u0004\u0018\u00010\r*\u0004\u0018\u00010\u00058BX\u0082\u0004\u00A2\u0006\u0007\u001A\u0005\b\u00CE\u0001\u0010>R\u001B\u0010\u00D0\u0001\u001A\u00020\u0001*\u0002038BX\u0082\u0004\u00A2\u0006\b\u001A\u0006\b\u00D0\u0001\u0010\u00D1\u0001\u0082\u0002\u0004\n\u0002\b\u0019\u00A8\u0006\u00D5\u0001"}, d2 = {"Lkotlinx/coroutines/JobSupport;", "", "active", "<init>", "(Z)V", "", "expect", "Lkotlinx/coroutines/NodeList;", "list", "Lkotlinx/coroutines/JobNode;", "node", "addLastAtomic", "(Ljava/lang/Object;Lkotlinx/coroutines/NodeList;Lkotlinx/coroutines/JobNode;)Z", "", "rootCause", "", "exceptions", "", "addSuppressedExceptions", "(Ljava/lang/Throwable;Ljava/util/List;)V", "state", "afterCompletion", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/ChildJob;", "child", "Lkotlinx/coroutines/ChildHandle;", "attachChild", "(Lkotlinx/coroutines/ChildJob;)Lkotlinx/coroutines/ChildHandle;", "awaitInternal$kotlinx_coroutines_core", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitInternal", "awaitSuspend", "cause", "cancel", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Ljava/util/concurrent/CancellationException;)V", "cancelCoroutine", "cancelImpl$kotlinx_coroutines_core", "(Ljava/lang/Object;)Z", "cancelImpl", "cancelInternal", "(Ljava/lang/Throwable;)V", "cancelMakeCompleting", "(Ljava/lang/Object;)Ljava/lang/Object;", "cancelParent", "", "cancellationExceptionMessage", "()Ljava/lang/String;", "childCancelled", "Lkotlinx/coroutines/Incomplete;", "update", "completeStateFinalization", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)V", "Lkotlinx/coroutines/JobSupport$Finishing;", "Lkotlinx/coroutines/ChildHandleNode;", "lastChild", "proposedUpdate", "continueCompleting", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "createCauseException", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "message", "Lkotlinx/coroutines/JobCancellationException;", "defaultCancellationException$kotlinx_coroutines_core", "(Ljava/lang/String;Ljava/lang/Throwable;)Lkotlinx/coroutines/JobCancellationException;", "defaultCancellationException", "finalizeFinishingState", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/lang/Object;)Ljava/lang/Object;", "firstChild", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/ChildHandleNode;", "getCancellationException", "()Ljava/util/concurrent/CancellationException;", "getChildJobCancellationCause", "getCompletedInternal$kotlinx_coroutines_core", "()Ljava/lang/Object;", "getCompletedInternal", "getCompletionExceptionOrNull", "()Ljava/lang/Throwable;", "getFinalRootCause", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/util/List;)Ljava/lang/Throwable;", "getOrPromoteCancellingList", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/NodeList;", "exception", "handleJobException", "handleOnCompletionException$kotlinx_coroutines_core", "handleOnCompletionException", "Lkotlinx/coroutines/Job;", "parent", "initParentJob", "(Lkotlinx/coroutines/Job;)V", "onCancelling", "invokeImmediately", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCompletion", "(ZZLkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "join", "joinInternal", "()Z", "joinSuspend", "block", "", "loopOnState", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Void;", "makeCancelling", "makeCompleting$kotlinx_coroutines_core", "makeCompleting", "makeCompletingOnce$kotlinx_coroutines_core", "makeCompletingOnce", "makeNode", "(Lkotlin/jvm/functions/Function1;Z)Lkotlinx/coroutines/JobNode;", "nameString$kotlinx_coroutines_core", "nameString", "notifyCancelling", "(Lkotlinx/coroutines/NodeList;Ljava/lang/Throwable;)V", "T", "notifyHandlers", "onCompletionInternal", "onStart", "()V", "Lkotlinx/coroutines/ParentJob;", "parentJob", "parentCancelled", "(Lkotlinx/coroutines/ParentJob;)V", "Lkotlinx/coroutines/Empty;", "promoteEmptyToNodeList", "(Lkotlinx/coroutines/Empty;)V", "promoteSingleToNodeList", "(Lkotlinx/coroutines/JobNode;)V", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/coroutines/Continuation;", "registerSelectClause0", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function2;", "registerSelectClause1Internal$kotlinx_coroutines_core", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "registerSelectClause1Internal", "removeNode$kotlinx_coroutines_core", "removeNode", "selectAwaitCompletion$kotlinx_coroutines_core", "selectAwaitCompletion", "start", "", "startInternal", "(Ljava/lang/Object;)I", "stateString", "(Ljava/lang/Object;)Ljava/lang/String;", "toDebugString", "toString", "tryFinalizeSimpleState", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Z", "tryMakeCancelling", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Throwable;)Z", "tryMakeCompleting", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "tryMakeCompletingSlowPath", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Ljava/lang/Object;", "tryWaitForChild", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "nextChild", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/ChildHandleNode;", "notifyCompletion", "toCancellationException", "(Ljava/lang/Throwable;Ljava/lang/String;)Ljava/util/concurrent/CancellationException;", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "children", "getCompletionCause", "completionCause", "getCompletionCauseHandled", "completionCauseHandled", "getHandlesException$kotlinx_coroutines_core", "handlesException", "isActive", "isCancelled", "isCompleted", "isCompletedExceptionally", "isScopedCoroutine", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "key", "getOnCancelComplete$kotlinx_coroutines_core", "onCancelComplete", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "onJoin", "value", "getParentHandle$kotlinx_coroutines_core", "()Lkotlinx/coroutines/ChildHandle;", "setParentHandle$kotlinx_coroutines_core", "(Lkotlinx/coroutines/ChildHandle;)V", "parentHandle", "getState$kotlinx_coroutines_core", "getExceptionOrNull", "exceptionOrNull", "isCancelling", "(Lkotlinx/coroutines/Incomplete;)Z", "AwaitContinuation", "ChildCompletion", "Finishing", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
public class JobSupport implements ChildJob, Job, ParentJob, SelectClause0 {
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001B\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0016J\b\u0010\f\u001A\u00020\rH\u0014R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2 = {"Lkotlinx/coroutines/JobSupport$AwaitContinuation;", "T", "Lkotlinx/coroutines/CancellableContinuationImpl;", "delegate", "Lkotlin/coroutines/Continuation;", "job", "Lkotlinx/coroutines/JobSupport;", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/JobSupport;)V", "getContinuationCancellationCause", "", "parent", "Lkotlinx/coroutines/Job;", "nameString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    static final class AwaitContinuation extends CancellableContinuationImpl {
        private final JobSupport job;

        public AwaitContinuation(Continuation continuation0, JobSupport jobSupport0) {
            super(continuation0, 1);
            this.job = jobSupport0;
        }

        @Override  // kotlinx.coroutines.CancellableContinuationImpl
        public Throwable getContinuationCancellationCause(Job job0) {
            Object object0 = this.job.getState$kotlinx_coroutines_core();
            if(object0 instanceof Finishing) {
                Throwable throwable0 = ((Finishing)object0).getRootCause();
                if(throwable0 != null) {
                    return throwable0;
                }
            }
            return object0 instanceof CompletedExceptionally ? ((CompletedExceptionally)object0).cause : job0.getCancellationException();
        }

        @Override  // kotlinx.coroutines.CancellableContinuationImpl
        protected String nameString() {
            return UnityPlayerActivity.adjustValue("2F070C081A22080B06071E18001A08080B");
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\b\u0010\b\u001A\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u000EH\u0096\u0002R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001A\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2 = {"Lkotlinx/coroutines/JobSupport$ChildCompletion;", "Lkotlinx/coroutines/JobNode;", "parent", "Lkotlinx/coroutines/JobSupport;", "state", "Lkotlinx/coroutines/JobSupport$Finishing;", "child", "Lkotlinx/coroutines/ChildHandleNode;", "proposedUpdate", "", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    static final class ChildCompletion extends JobNode {
        private final ChildHandleNode child;
        private final JobSupport parent;
        private final Object proposedUpdate;
        private final Finishing state;

        public ChildCompletion(JobSupport jobSupport0, Finishing jobSupport$Finishing0, ChildHandleNode childHandleNode0, Object object0) {
            this.parent = jobSupport0;
            this.state = jobSupport$Finishing0;
            this.child = childHandleNode0;
            this.proposedUpdate = object0;
        }

        @Override  // kotlin.jvm.functions.Function1
        public Object invoke(Object object0) {
            this.invoke(((Throwable)object0));
            return Unit.INSTANCE;
        }

        @Override  // kotlinx.coroutines.CompletionHandlerBase
        public void invoke(Throwable throwable0) {
            this.parent.continueCompleting(this.state, this.child, this.proposedUpdate);
        }
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0002\u0018\u00002\u00060\u0018j\u0002`,2\u00020-B!\u0012\u0006\u0010\u0002\u001A\u00020\u0001\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\u0005¢\u0006\u0004\b\u000B\u0010\fJ\u001F\u0010\u000F\u001A\u0012\u0012\u0004\u0012\u00020\u00050\rj\b\u0012\u0004\u0012\u00020\u0005`\u000EH\u0002¢\u0006\u0004\b\u000F\u0010\u0010J\u001D\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00050\u00122\b\u0010\u0011\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0016\u001A\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R(\u0010\u001E\u001A\u0004\u0018\u00010\u00182\b\u0010\u0019\u001A\u0004\u0018\u00010\u00188B@BX\u0082\u000E¢\u0006\f\u001A\u0004\b\u001A\u0010\u001B\"\u0004\b\u001C\u0010\u001DR\u0014\u0010\u001F\u001A\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001F\u0010 R\u0011\u0010!\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b!\u0010 R$\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0019\u001A\u00020\u00038F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u0004\u0010 \"\u0004\b\"\u0010#R\u0011\u0010$\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b$\u0010 R\u001A\u0010\u0002\u001A\u00020\u00018\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0002\u0010%\u001A\u0004\b&\u0010\'R(\u0010\u0006\u001A\u0004\u0018\u00010\u00052\b\u0010\u0019\u001A\u0004\u0018\u00010\u00058F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b(\u0010)\"\u0004\b*\u0010\f¨\u0006+"}, d2 = {"Lkotlinx/coroutines/JobSupport$Finishing;", "Lkotlinx/coroutines/NodeList;", "list", "", "isCompleting", "", "rootCause", "<init>", "(Lkotlinx/coroutines/NodeList;ZLjava/lang/Throwable;)V", "exception", "", "addExceptionLocked", "(Ljava/lang/Throwable;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "allocateList", "()Ljava/util/ArrayList;", "proposedException", "", "sealLocked", "(Ljava/lang/Throwable;)Ljava/util/List;", "", "toString", "()Ljava/lang/String;", "", "value", "getExceptionsHolder", "()Ljava/lang/Object;", "setExceptionsHolder", "(Ljava/lang/Object;)V", "exceptionsHolder", "isActive", "()Z", "isCancelling", "setCompleting", "(Z)V", "isSealed", "Lkotlinx/coroutines/NodeList;", "getList", "()Lkotlinx/coroutines/NodeList;", "getRootCause", "()Ljava/lang/Throwable;", "setRootCause", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Lkotlinx/coroutines/Incomplete;"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    static final class Finishing implements Incomplete {
        private volatile Object _exceptionsHolder;
        private volatile int _isCompleting;
        private volatile Object _rootCause;
        private final NodeList list;

        public Finishing(NodeList nodeList0, boolean z, Throwable throwable0) {
            this.list = nodeList0;
            this._isCompleting = z;
            this._rootCause = throwable0;
            this._exceptionsHolder = null;
        }

        public final void addExceptionLocked(Throwable throwable0) {
            Throwable throwable1 = this.getRootCause();
            if(throwable1 == null) {
                this.setRootCause(throwable0);
                return;
            }
            if(throwable0 == throwable1) {
                return;
            }
            Object object0 = this.getExceptionsHolder();
            if(object0 == null) {
                this.setExceptionsHolder(throwable0);
                return;
            }
            if(object0 instanceof Throwable) {
                if(throwable0 == object0) {
                    return;
                }
                ArrayList arrayList0 = this.allocateList();
                arrayList0.add(object0);
                arrayList0.add(throwable0);
                this.setExceptionsHolder(arrayList0);
                return;
            }
            if(!(object0 instanceof ArrayList)) {
                throw new IllegalStateException((UnityPlayerActivity.adjustValue("3D040C150B410E1652") + object0).toString());
            }
            ((ArrayList)object0).add(throwable0);
        }

        private final ArrayList allocateList() {
            return new ArrayList(4);
        }

        private final Object getExceptionsHolder() {
            return this._exceptionsHolder;
        }

        @Override  // kotlinx.coroutines.Incomplete
        public NodeList getList() {
            return this.list;
        }

        public final Throwable getRootCause() {
            return (Throwable)this._rootCause;
        }

        @Override  // kotlinx.coroutines.Incomplete
        public boolean isActive() {
            return this.getRootCause() == null;
        }

        public final boolean isCancelling() {
            return this.getRootCause() != null;
        }

        public final boolean isCompleting() {
            return this._isCompleting;
        }

        public final boolean isSealed() {
            return this.getExceptionsHolder() == JobSupportKt.access$getSEALED$p();
        }

        public final List sealLocked(Throwable throwable0) {
            ArrayList arrayList0;
            Object object0 = this.getExceptionsHolder();
            if(object0 == null) {
                arrayList0 = this.allocateList();
            }
            else if(object0 instanceof Throwable) {
                ArrayList arrayList1 = this.allocateList();
                arrayList1.add(object0);
                arrayList0 = arrayList1;
            }
            else if(object0 instanceof ArrayList) {
                arrayList0 = (ArrayList)object0;
            }
            else {
                throw new IllegalStateException((UnityPlayerActivity.adjustValue("3D040C150B410E1652") + object0).toString());
            }
            Throwable throwable1 = this.getRootCause();
            if(throwable1 != null) {
                arrayList0.add(0, throwable1);
            }
            if(throwable0 != null && !Intrinsics.areEqual(throwable0, throwable1)) {
                arrayList0.add(throwable0);
            }
            this.setExceptionsHolder(JobSupportKt.access$getSEALED$p());
            return arrayList0;
        }

        public final void setCompleting(boolean z) {
            this._isCompleting = z;
        }

        private final void setExceptionsHolder(Object object0) {
            this._exceptionsHolder = object0;
        }

        public final void setRootCause(Throwable throwable0) {
            this._rootCause = throwable0;
        }

        @Override
        public String toString() {
            return UnityPlayerActivity.adjustValue("281903081D090E0B1535130C0F0D040B091B001750") + this.isCancelling() + UnityPlayerActivity.adjustValue("42500E0E03110B0006071E0A5C") + this.isCompleting() + UnityPlayerActivity.adjustValue("42501F0E01152404071D1550") + this.getRootCause() + UnityPlayerActivity.adjustValue("425008190D0417111B011E1E5C") + this.getExceptionsHolder() + UnityPlayerActivity.adjustValue("425001081D155A") + this.getList() + ']';
        }
    }

    private volatile Object _parentHandle;
    private volatile Object _state;
    private static final AtomicReferenceFieldUpdater _state$FU;

    static {
        String s = UnityPlayerActivity.adjustValue("310319001A04");
        JobSupport._state$FU = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, s);
    }

    public JobSupport(boolean z) {
        this._state = z ? JobSupportKt.access$getEMPTY_ACTIVE$p() : JobSupportKt.access$getEMPTY_NEW$p();
        this._parentHandle = null;
    }

    public static final Object access$awaitSuspend(JobSupport jobSupport0, Continuation continuation0) {
        return jobSupport0.awaitSuspend(continuation0);
    }

    public static final Object access$joinSuspend(JobSupport jobSupport0, Continuation continuation0) {
        return jobSupport0.joinSuspend(continuation0);
    }

    private final boolean addLastAtomic(Object object0, NodeList nodeList0, JobNode jobNode0) {
        kotlinx.coroutines.JobSupport.addLastAtomic..inlined.addLastIf.1 jobSupport$addLastAtomic$$inlined$addLastIf$10 = new CondAddOp(this) {
            @Override  // kotlinx.coroutines.internal.AtomicOp
            public Object prepare(Object object0) {
                return this.prepare(((LockFreeLinkedListNode)object0));
            }

            // 去混淆评级： 低(30)
            public Object prepare(LockFreeLinkedListNode lockFreeLinkedListNode0) {
                return object0.getState$kotlinx_coroutines_core() == this.$expect$inlined ? LockFreeLinkedListKt.getCONDITION_FALSE() : null;
            }
        };
    alab1:
        while(true) {
            switch(nodeList0.getPrevNode().tryCondAddNext(jobNode0, nodeList0, jobSupport$addLastAtomic$$inlined$addLastIf$10)) {
                case 1: {
                    return true;
                }
                case 2: {
                    break alab1;
                }
            }
        }
        return false;
    }

    private final void addSuppressedExceptions(Throwable throwable0, List list0) {
        if(list0.size() <= 1) {
            return;
        }
        Set set0 = Collections.newSetFromMap(new IdentityHashMap(list0.size()));
        for(Object object0: list0) {
            Throwable throwable1 = (Throwable)object0;
            if(throwable1 != throwable0 && !(throwable1 instanceof CancellationException) && set0.add(throwable1)) {
                ExceptionsKt.addSuppressed(throwable0, throwable1);
            }
        }
    }

    protected void afterCompletion(Object object0) {
    }

    @Override  // kotlinx.coroutines.Job
    public final ChildHandle attachChild(ChildJob childJob0) {
        return (ChildHandle)DefaultImpls.invokeOnCompletion$default(this, true, false, new ChildHandleNode(childJob0), 2, null);
    }

    public final Object awaitInternal$kotlinx_coroutines_core(Continuation continuation0) {
        do {
            Object object0 = this.getState$kotlinx_coroutines_core();
            if(!(object0 instanceof Incomplete)) {
                if(object0 instanceof CompletedExceptionally) {
                    throw ((CompletedExceptionally)object0).cause;
                }
                return JobSupportKt.unboxState(object0);
            }
        }
        while(this.startInternal(object0) < 0);
        return this.awaitSuspend(continuation0);
    }

    private final Object awaitSuspend(Continuation continuation0) {
        AwaitContinuation jobSupport$AwaitContinuation0 = new AwaitContinuation(IntrinsicsKt.intercepted(continuation0), this);
        jobSupport$AwaitContinuation0.initCancellability();
        CancellableContinuationKt.disposeOnCancellation(jobSupport$AwaitContinuation0, this.invokeOnCompletion(new ResumeAwaitOnCompletion(jobSupport$AwaitContinuation0)));
        Object object0 = jobSupport$AwaitContinuation0.getResult();
        if(object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation0);
        }
        return object0;
    }

    @Override  // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public void cancel() {
        DefaultImpls.cancel(this);
    }

    @Override  // kotlinx.coroutines.Job
    public void cancel(CancellationException cancellationException0) {
        if(cancellationException0 == null) {
            cancellationException0 = new JobCancellationException(this.cancellationExceptionMessage(), null, this);
        }
        this.cancelInternal(cancellationException0);
    }

    @Override  // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Added since 1.2.0 for binary compatibility with versions <= 1.1.x")
    public boolean cancel(Throwable throwable0) {
        CancellationException cancellationException0;
        if(throwable0 == null) {
            cancellationException0 = new JobCancellationException(this.cancellationExceptionMessage(), null, this);
        }
        else {
            cancellationException0 = JobSupport.toCancellationException$default(this, throwable0, null, 1, null);
            if(cancellationException0 == null) {
                cancellationException0 = new JobCancellationException(this.cancellationExceptionMessage(), null, this);
            }
        }
        this.cancelInternal(cancellationException0);
        return true;
    }

    public final boolean cancelCoroutine(Throwable throwable0) {
        return this.cancelImpl$kotlinx_coroutines_core(throwable0);
    }

    public final boolean cancelImpl$kotlinx_coroutines_core(Object object0) {
        Symbol symbol0 = JobSupportKt.access$getCOMPLETING_ALREADY$p();
        if(this.getOnCancelComplete$kotlinx_coroutines_core()) {
            symbol0 = this.cancelMakeCompleting(object0);
            if(symbol0 == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
                return true;
            }
        }
        if(symbol0 == JobSupportKt.access$getCOMPLETING_ALREADY$p()) {
            symbol0 = this.makeCancelling(object0);
        }
        if(symbol0 != JobSupportKt.access$getCOMPLETING_ALREADY$p() && symbol0 != JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            if(symbol0 == JobSupportKt.access$getTOO_LATE_TO_CANCEL$p()) {
                return false;
            }
            this.afterCompletion(symbol0);
        }
        return true;
    }

    public void cancelInternal(Throwable throwable0) {
        this.cancelImpl$kotlinx_coroutines_core(throwable0);
    }

    private final Object cancelMakeCompleting(Object object0) {
        while(true) {
            Object object1 = this.getState$kotlinx_coroutines_core();
            if(!(object1 instanceof Incomplete) || object1 instanceof Finishing && ((Finishing)object1).isCompleting()) {
                break;
            }
            Object object2 = this.tryMakeCompleting(object1, new CompletedExceptionally(this.createCauseException(object0), false, 2, null));
            if(object2 != JobSupportKt.access$getCOMPLETING_RETRY$p()) {
                return object2;
            }
        }
        return JobSupportKt.access$getCOMPLETING_ALREADY$p();
    }

    private final boolean cancelParent(Throwable throwable0) {
        if(this.isScopedCoroutine()) {
            return true;
        }
        ChildHandle childHandle0 = this.getParentHandle$kotlinx_coroutines_core();
        return childHandle0 == null || childHandle0 == NonDisposableHandle.INSTANCE ? throwable0 instanceof CancellationException : childHandle0.childCancelled(throwable0) || throwable0 instanceof CancellationException;
    }

    protected String cancellationExceptionMessage() {
        return UnityPlayerActivity.adjustValue("241F0F4119001445110F1E0E04020D0201");
    }

    // 去混淆评级： 低(40)
    public boolean childCancelled(Throwable throwable0) {
        return throwable0 instanceof CancellationException ? true : this.cancelImpl$kotlinx_coroutines_core(throwable0) && this.getHandlesException$kotlinx_coroutines_core();
    }

    private final void completeStateFinalization(Incomplete incomplete0, Object object0) {
        ChildHandle childHandle0 = this.getParentHandle$kotlinx_coroutines_core();
        if(childHandle0 != null) {
            childHandle0.dispose();
            this.setParentHandle$kotlinx_coroutines_core(NonDisposableHandle.INSTANCE);
        }
        Throwable throwable0 = null;
        CompletedExceptionally completedExceptionally0 = object0 instanceof CompletedExceptionally ? ((CompletedExceptionally)object0) : null;
        if(completedExceptionally0 != null) {
            throwable0 = completedExceptionally0.cause;
        }
        if(incomplete0 instanceof JobNode) {
            try {
                ((JobNode)incomplete0).invoke(throwable0);
            }
            catch(Throwable throwable1) {
                this.handleOnCompletionException$kotlinx_coroutines_core(new CompletionHandlerException(UnityPlayerActivity.adjustValue("2B080E041E150E0A1C4E1903410D0E0A151E0B04040E00410F041C0A1C08134E") + incomplete0 + UnityPlayerActivity.adjustValue("4E1602134E") + this, throwable1));
            }
            return;
        }
        NodeList nodeList0 = incomplete0.getList();
        if(nodeList0 != null) {
            this.notifyCompletion(nodeList0, throwable0);
        }
    }

    private final void continueCompleting(Finishing jobSupport$Finishing0, ChildHandleNode childHandleNode0, Object object0) {
        ChildHandleNode childHandleNode1 = this.nextChild(childHandleNode0);
        if(childHandleNode1 != null && this.tryWaitForChild(jobSupport$Finishing0, childHandleNode1, object0)) {
            return;
        }
        this.afterCompletion(this.finalizeFinishingState(jobSupport$Finishing0, object0));
    }

    private final Throwable createCauseException(Object object0) {
        if((object0 == null ? true : object0 instanceof Throwable)) {
            return ((Throwable)object0) == null ? new JobCancellationException(this.cancellationExceptionMessage(), null, this) : ((Throwable)object0);
        }
        if(object0 == null) {
            throw new NullPointerException(UnityPlayerActivity.adjustValue("0005010D4E02060B1C01044D030B410404011A50190E4E0F080B5F0005010D4E151E15174E1B02150208091D5C0D1F1F0E1B150E0B171D5E3D001C040911380112"));
        }
        return ((ParentJob)object0).getChildJobCancellationCause();
    }

    public final JobCancellationException defaultCancellationException$kotlinx_coroutines_core(String s, Throwable throwable0) {
        if(s == null) {
            s = this.cancellationExceptionMessage();
        }
        return new JobCancellationException(s, throwable0, this);
    }

    public static JobCancellationException defaultCancellationException$kotlinx_coroutines_core$default(JobSupport jobSupport0, String s, Throwable throwable0, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException(UnityPlayerActivity.adjustValue("3D051D041C4104041E02034D1607150F45160B160C14021547040009050004001514451C01044D121B11170A001A150941070F47111A07034D150F1300000642500B140002130C1D004A4D050B0706101E1A330C0F0D040B09131A19020F2B190400021A19020F"));
        }
        if((v & 1) != 0) {
            s = null;
        }
        if((v & 2) != 0) {
            throwable0 = null;
        }
        if(s == null) {
            s = jobSupport0.cancellationExceptionMessage();
        }
        return new JobCancellationException(s, throwable0, jobSupport0);
    }

    private final Object finalizeFinishingState(Finishing jobSupport$Finishing0, Object object0) {
        Throwable throwable1;
        CompletedExceptionally completedExceptionally0 = object0 instanceof CompletedExceptionally ? ((CompletedExceptionally)object0) : null;
        Throwable throwable0 = completedExceptionally0 == null ? null : completedExceptionally0.cause;
        synchronized(jobSupport$Finishing0) {
            boolean z = jobSupport$Finishing0.isCancelling();
            List list0 = jobSupport$Finishing0.sealLocked(throwable0);
            throwable1 = this.getFinalRootCause(jobSupport$Finishing0, list0);
            if(throwable1 != null) {
                this.addSuppressedExceptions(throwable1, list0);
            }
        }
        if(throwable1 != null && throwable1 != throwable0) {
            object0 = new CompletedExceptionally(throwable1, false, 2, null);
        }
        if(throwable1 != null && (this.cancelParent(throwable1) || this.handleJobException(throwable1))) {
            if(object0 == null) {
                throw new NullPointerException(UnityPlayerActivity.adjustValue("0005010D4E02060B1C01044D030B410404011A50190E4E0F080B5F0005010D4E151E15174E1B02150208091D5C0D1F1F0E1B150E0B171D5E2E0E03110B00060B1428190D0417111B011E0C0D0218"));
            }
            ((CompletedExceptionally)object0).makeHandled();
        }
        if(!z) {
            this.onCancelling(throwable1);
        }
        this.onCompletionInternal(object0);
        JobSupportKt.boxIncomplete(object0);
        this.completeStateFinalization(jobSupport$Finishing0, object0);
        return object0;
    }

    private final ChildHandleNode firstChild(Incomplete incomplete0) {
        ChildHandleNode childHandleNode0 = incomplete0 instanceof ChildHandleNode ? ((ChildHandleNode)incomplete0) : null;
        if(childHandleNode0 == null) {
            NodeList nodeList0 = incomplete0.getList();
            return nodeList0 == null ? null : this.nextChild(nodeList0);
        }
        return childHandleNode0;
    }

    @Override  // kotlin.coroutines.CoroutineContext$Element
    public Object fold(Object object0, Function2 function20) {
        return DefaultImpls.fold(this, object0, function20);
    }

    @Override  // kotlin.coroutines.CoroutineContext$Element
    public Element get(Key coroutineContext$Key0) {
        return DefaultImpls.get(this, coroutineContext$Key0);
    }

    @Override  // kotlinx.coroutines.Job
    public final CancellationException getCancellationException() {
        Object object0 = this.getState$kotlinx_coroutines_core();
        String s = UnityPlayerActivity.adjustValue("241F0F410712471606071C0141000410451D1C500C021A081100484E");
        if(object0 instanceof Finishing) {
            Throwable throwable0 = ((Finishing)object0).getRootCause();
            if(throwable0 != null) {
                CancellationException cancellationException0 = this.toCancellationException(throwable0, DebugStringsKt.getClassSimpleName(this) + UnityPlayerActivity.adjustValue("4E191E410D00090617021C040F09"));
                if(cancellationException0 != null) {
                    return cancellationException0;
                }
            }
            throw new IllegalStateException((s + this).toString());
        }
        if(object0 instanceof Incomplete) {
            throw new IllegalStateException((s + this).toString());
        }
        return object0 instanceof CompletedExceptionally ? JobSupport.toCancellationException$default(this, ((CompletedExceptionally)object0).cause, null, 1, null) : new JobCancellationException(DebugStringsKt.getClassSimpleName(this) + UnityPlayerActivity.adjustValue("4E180C124E02080802021519040A41090A000311010D17"), null, this);
    }

    @Override  // kotlinx.coroutines.ParentJob
    public CancellationException getChildJobCancellationCause() {
        Throwable throwable0;
        Object object0 = this.getState$kotlinx_coroutines_core();
        CancellationException cancellationException0 = null;
        if(object0 instanceof Finishing) {
            throwable0 = ((Finishing)object0).getRootCause();
        }
        else if(object0 instanceof CompletedExceptionally) {
            throwable0 = ((CompletedExceptionally)object0).cause;
        }
        else if(!(object0 instanceof Incomplete)) {
            throwable0 = null;
        }
        else {
            throw new IllegalStateException((UnityPlayerActivity.adjustValue("2D11030F01154707174E130C0F0D040B091B00174D0206080B0152071E4D1506081445011A1119045441") + object0).toString());
        }
        if(throwable0 instanceof CancellationException) {
            cancellationException0 = (CancellationException)throwable0;
        }
        return cancellationException0 == null ? new JobCancellationException(UnityPlayerActivity.adjustValue("3E111F040015470F1D0C5004124E") + this.stateString(object0), throwable0, this) : cancellationException0;
    }

    @Override  // kotlinx.coroutines.Job
    public final Sequence getChildren() {
        return SequencesKt.sequence(new Function2(null) {
            private Object L$0;
            Object L$1;
            Object L$2;
            int label;

            {
                JobSupport.this = jobSupport0;
                super(2, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object object0, Continuation continuation0) {
                kotlinx.coroutines.JobSupport.children.1 jobSupport$children$10 = new kotlinx.coroutines.JobSupport.children.1(JobSupport.this, continuation0);
                jobSupport$children$10.L$0 = object0;
                return jobSupport$children$10;
            }

            @Override  // kotlin.jvm.functions.Function2
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((SequenceScope)object0), ((Continuation)object1));
            }

            public final Object invoke(SequenceScope sequenceScope0, Continuation continuation0) {
                return ((kotlinx.coroutines.JobSupport.children.1)this.create(sequenceScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                LockFreeLinkedListNode lockFreeLinkedListNode0;
                LockFreeLinkedListHead lockFreeLinkedListHead0;
                SequenceScope sequenceScope1;
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            alab1:
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        SequenceScope sequenceScope0 = (SequenceScope)this.L$0;
                        Object object2 = JobSupport.this.getState$kotlinx_coroutines_core();
                        if(object2 instanceof ChildHandleNode) {
                            this.label = 1;
                            if(sequenceScope0.yield(((ChildHandleNode)object2).childJob, this) == object1) {
                                return object1;
                            }
                        }
                        else if(object2 instanceof Incomplete) {
                            NodeList nodeList0 = ((Incomplete)object2).getList();
                            if(nodeList0 != null) {
                                sequenceScope1 = sequenceScope0;
                                lockFreeLinkedListHead0 = nodeList0;
                                lockFreeLinkedListNode0 = (LockFreeLinkedListNode)nodeList0.getNext();
                                goto label_24;
                            }
                        }
                        break;
                    }
                    case 1: {
                        ResultKt.throwOnFailure(object0);
                        return Unit.INSTANCE;
                    }
                    case 2: {
                        lockFreeLinkedListNode0 = (LockFreeLinkedListNode)this.L$2;
                        lockFreeLinkedListHead0 = (LockFreeLinkedListHead)this.L$1;
                        sequenceScope1 = (SequenceScope)this.L$0;
                        ResultKt.throwOnFailure(object0);
                        while(true) {
                            while(true) {
                                lockFreeLinkedListNode0 = lockFreeLinkedListNode0.getNextNode();
                            label_24:
                                if(Intrinsics.areEqual(lockFreeLinkedListNode0, lockFreeLinkedListHead0)) {
                                    break alab1;
                                }
                                if(!(lockFreeLinkedListNode0 instanceof ChildHandleNode)) {
                                    break;
                                }
                                this.L$0 = sequenceScope1;
                                this.L$1 = lockFreeLinkedListHead0;
                                this.L$2 = lockFreeLinkedListNode0;
                                this.label = 2;
                                if(sequenceScope1.yield(((ChildHandleNode)lockFreeLinkedListNode0).childJob, this) != object1) {
                                    break;
                                }
                                return object1;
                            }
                        }
                    }
                    default: {
                        throw new IllegalStateException(UnityPlayerActivity.adjustValue("0D11010D4E150845551C151E1403044045100B1602130B41400C1C181F06044941100C0606500E0E1C0E12111B0015"));
                    }
                }
                return Unit.INSTANCE;
            }
        });
    }

    public final Object getCompletedInternal$kotlinx_coroutines_core() {
        Object object0 = this.getState$kotlinx_coroutines_core();
        if(!(object0 instanceof Incomplete) == 0) {
            throw new IllegalStateException(UnityPlayerActivity.adjustValue("3A1804124E0B08075206111E41000E134511011D1D0D0B15020152171519").toString());
        }
        if(object0 instanceof CompletedExceptionally) {
            throw ((CompletedExceptionally)object0).cause;
        }
        return JobSupportKt.unboxState(object0);
    }

    protected final Throwable getCompletionCause() {
        Object object0 = this.getState$kotlinx_coroutines_core();
        String s = UnityPlayerActivity.adjustValue("241F0F410712471606071C0141000410451D1C500C021A081100484E");
        if(object0 instanceof Finishing) {
            Throwable throwable0 = ((Finishing)object0).getRootCause();
            if(throwable0 == null) {
                throw new IllegalStateException((s + this).toString());
            }
            return throwable0;
        }
        if(object0 instanceof Incomplete) {
            throw new IllegalStateException((s + this).toString());
        }
        return object0 instanceof CompletedExceptionally ? ((CompletedExceptionally)object0).cause : null;
    }

    protected final boolean getCompletionCauseHandled() {
        Object object0 = this.getState$kotlinx_coroutines_core();
        return object0 instanceof CompletedExceptionally && ((CompletedExceptionally)object0).getHandled();
    }

    public final Throwable getCompletionExceptionOrNull() {
        Object object0 = this.getState$kotlinx_coroutines_core();
        if(!(object0 instanceof Incomplete) == 0) {
            throw new IllegalStateException(UnityPlayerActivity.adjustValue("3A1804124E0B08075206111E41000E134511011D1D0D0B15020152171519").toString());
        }
        return this.getExceptionOrNull(object0);
    }

    private final Throwable getExceptionOrNull(Object object0) {
        CompletedExceptionally completedExceptionally0 = object0 instanceof CompletedExceptionally ? ((CompletedExceptionally)object0) : null;
        return completedExceptionally0 == null ? null : completedExceptionally0.cause;
    }

    private final Throwable getFinalRootCause(Finishing jobSupport$Finishing0, List list0) {
        if(list0.isEmpty()) {
            return jobSupport$Finishing0.isCancelling() ? new JobCancellationException(this.cancellationExceptionMessage(), null, this) : null;
        }
        Object object0 = null;
        for(Object object1: list0) {
            if(!(((Throwable)object1) instanceof CancellationException) != 0) {
                object0 = object1;
                break;
            }
        }
        if(((Throwable)object0) != null) {
            return (Throwable)object0;
        }
        Throwable throwable0 = (Throwable)list0.get(0);
        if(throwable0 instanceof TimeoutCancellationException) {
            for(Object object2: list0) {
                if(((Throwable)object2) != throwable0 && ((Throwable)object2) instanceof TimeoutCancellationException) {
                    return ((Throwable)object2) == null ? throwable0 : ((Throwable)object2);
                }
                if(false) {
                    break;
                }
            }
            return throwable0;
        }
        return throwable0;
    }

    public boolean getHandlesException$kotlinx_coroutines_core() {
        return true;
    }

    @Override  // kotlin.coroutines.CoroutineContext$Element
    public final Key getKey() {
        return Job.Key;
    }

    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return false;
    }

    @Override  // kotlinx.coroutines.Job
    public final SelectClause0 getOnJoin() {
        return this;
    }

    private final NodeList getOrPromoteCancellingList(Incomplete incomplete0) {
        NodeList nodeList0 = incomplete0.getList();
        if(nodeList0 == null) {
            if(incomplete0 instanceof Empty) {
                return new NodeList();
            }
            if(!(incomplete0 instanceof JobNode)) {
                throw new IllegalStateException((UnityPlayerActivity.adjustValue("3D040C150B41140D1D1B1C0941060011005202191E155441") + incomplete0).toString());
            }
            this.promoteSingleToNodeList(((JobNode)incomplete0));
            return null;
        }
        return nodeList0;
    }

    public final ChildHandle getParentHandle$kotlinx_coroutines_core() {
        return (ChildHandle)this._parentHandle;
    }

    public final Object getState$kotlinx_coroutines_core() {
        Object object0;
        while(true) {
            object0 = this._state;
            if(!(object0 instanceof OpDescriptor)) {
                break;
            }
            ((OpDescriptor)object0).perform(this);
        }
        return object0;
    }

    protected boolean handleJobException(Throwable throwable0) {
        return false;
    }

    public void handleOnCompletionException$kotlinx_coroutines_core(Throwable throwable0) {
        throw throwable0;
    }

    protected final void initParentJob(Job job0) {
        if(job0 == null) {
            this.setParentHandle$kotlinx_coroutines_core(NonDisposableHandle.INSTANCE);
            return;
        }
        job0.start();
        ChildHandle childHandle0 = job0.attachChild(this);
        this.setParentHandle$kotlinx_coroutines_core(childHandle0);
        if(this.isCompleted()) {
            childHandle0.dispose();
            this.setParentHandle$kotlinx_coroutines_core(NonDisposableHandle.INSTANCE);
        }
    }

    @Override  // kotlinx.coroutines.Job
    public final DisposableHandle invokeOnCompletion(Function1 function10) {
        return this.invokeOnCompletion(false, true, function10);
    }

    @Override  // kotlinx.coroutines.Job
    public final DisposableHandle invokeOnCompletion(boolean z, boolean z1, Function1 function10) {
        Object object0;
        Throwable throwable0;
        JobNode jobNode0 = this.makeNode(function10, z);
        while(true) {
            do {
            label_1:
                throwable0 = null;
                object0 = this.getState$kotlinx_coroutines_core();
                if(!(object0 instanceof Empty)) {
                    goto label_9;
                }
                if(!((Empty)object0).isActive()) {
                    this.promoteEmptyToNodeList(((Empty)object0));
                    goto label_1;
                }
            }
            while(!WorkSpec..ExternalSyntheticBackport0.m(JobSupport._state$FU, this, object0, jobNode0));
            return jobNode0;
        label_9:
            if(!(object0 instanceof Incomplete)) {
                break;
            }
            NodeList nodeList0 = ((Incomplete)object0).getList();
            if(nodeList0 == null) {
                if(object0 == null) {
                    throw new NullPointerException(UnityPlayerActivity.adjustValue("0005010D4E02060B1C01044D030B410404011A50190E4E0F080B5F0005010D4E151E15174E1B02150208091D5C0D1F1F0E1B150E0B171D5E270E0C2F080117"));
                }
                this.promoteSingleToNodeList(((JobNode)object0));
                goto label_1;
            }
            NonDisposableHandle nonDisposableHandle0 = NonDisposableHandle.INSTANCE;
            if(z && object0 instanceof Finishing) {
                synchronized(object0) {
                    throwable0 = ((Finishing)object0).getRootCause();
                    if(throwable0 == null || function10 instanceof ChildHandleNode && !((Finishing)object0).isCompleting()) {
                        if(this.addLastAtomic(object0, nodeList0, jobNode0)) {
                            if(throwable0 == null) {
                                return jobNode0;
                            }
                            nonDisposableHandle0 = jobNode0;
                        }
                        else {
                            goto label_1;
                        }
                    }
                }
            }
            if(throwable0 != null) {
                if(z1) {
                    function10.invoke(throwable0);
                }
                return nonDisposableHandle0;
            }
            if(this.addLastAtomic(object0, nodeList0, jobNode0)) {
                return jobNode0;
            }
        }
        if(z1) {
            CompletedExceptionally completedExceptionally0 = object0 instanceof CompletedExceptionally ? ((CompletedExceptionally)object0) : null;
            if(completedExceptionally0 != null) {
                throwable0 = completedExceptionally0.cause;
            }
            function10.invoke(throwable0);
        }
        return NonDisposableHandle.INSTANCE;
    }

    @Override  // kotlinx.coroutines.Job
    public boolean isActive() {
        Object object0 = this.getState$kotlinx_coroutines_core();
        return object0 instanceof Incomplete && ((Incomplete)object0).isActive();
    }

    @Override  // kotlinx.coroutines.Job
    public final boolean isCancelled() {
        Object object0 = this.getState$kotlinx_coroutines_core();
        return object0 instanceof CompletedExceptionally || object0 instanceof Finishing && ((Finishing)object0).isCancelling();
    }

    // 去混淆评级： 低(20)
    private final boolean isCancelling(Incomplete incomplete0) {
        return incomplete0 instanceof Finishing && ((Finishing)incomplete0).isCancelling();
    }

    @Override  // kotlinx.coroutines.Job
    public final boolean isCompleted() {
        return !(this.getState$kotlinx_coroutines_core() instanceof Incomplete);
    }

    public final boolean isCompletedExceptionally() {
        return this.getState$kotlinx_coroutines_core() instanceof CompletedExceptionally;
    }

    protected boolean isScopedCoroutine() {
        return false;
    }

    @Override  // kotlinx.coroutines.Job
    public final Object join(Continuation continuation0) {
        if(!this.joinInternal()) {
            JobKt.ensureActive(continuation0.getContext());
            return Unit.INSTANCE;
        }
        Object object0 = this.joinSuspend(continuation0);
        return object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object0 : Unit.INSTANCE;
    }

    private final boolean joinInternal() {
        do {
            Object object0 = this.getState$kotlinx_coroutines_core();
            if(!(object0 instanceof Incomplete)) {
                return false;
            }
        }
        while(this.startInternal(object0) < 0);
        return true;
    }

    private final Object joinSuspend(Continuation continuation0) {
        CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation0), 1);
        cancellableContinuationImpl0.initCancellability();
        CancellableContinuationKt.disposeOnCancellation(cancellableContinuationImpl0, this.invokeOnCompletion(new ResumeOnCompletion(cancellableContinuationImpl0)));
        Object object0 = cancellableContinuationImpl0.getResult();
        if(object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation0);
        }
        return object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object0 : Unit.INSTANCE;
    }

    private final Void loopOnState(Function1 function10) {
        while(true) {
            function10.invoke(this.getState$kotlinx_coroutines_core());
        }
    }

    private final Object makeCancelling(Object object0) {
        Object object2;
        Object object1;
        Throwable throwable0 = null;
        Throwable throwable1 = null;
        do {
            do {
                object1 = this.getState$kotlinx_coroutines_core();
                if(object1 instanceof Finishing) {
                    synchronized(object1) {
                        if(((Finishing)object1).isSealed()) {
                            return JobSupportKt.access$getTOO_LATE_TO_CANCEL$p();
                        }
                        boolean z = ((Finishing)object1).isCancelling();
                        if(object0 != null || !z) {
                            if(throwable1 == null) {
                                throwable1 = this.createCauseException(object0);
                            }
                            ((Finishing)object1).addExceptionLocked(throwable1);
                        }
                        Throwable throwable2 = ((Finishing)object1).getRootCause();
                        if(!z != 0) {
                            throwable0 = throwable2;
                        }
                    }
                    if(throwable0 != null) {
                        this.notifyCancelling(((Finishing)object1).getList(), throwable0);
                    }
                    return JobSupportKt.access$getCOMPLETING_ALREADY$p();
                }
                if(!(object1 instanceof Incomplete)) {
                    return JobSupportKt.access$getTOO_LATE_TO_CANCEL$p();
                }
                if(throwable1 == null) {
                    throwable1 = this.createCauseException(object0);
                }
                if(!((Incomplete)object1).isActive()) {
                    goto label_29;
                }
            }
            while(!this.tryMakeCancelling(((Incomplete)object1), throwable1));
            return JobSupportKt.access$getCOMPLETING_ALREADY$p();
        label_29:
            object2 = this.tryMakeCompleting(object1, new CompletedExceptionally(throwable1, false, 2, null));
            if(object2 == JobSupportKt.access$getCOMPLETING_ALREADY$p()) {
                throw new IllegalStateException((UnityPlayerActivity.adjustValue("2D11030F0115470D131E00080F4E080945") + object1).toString());
            }
        }
        while(object2 == JobSupportKt.access$getCOMPLETING_RETRY$p());
        return object2;
    }

    public final boolean makeCompleting$kotlinx_coroutines_core(Object object0) {
        Object object1;
        do {
            object1 = this.tryMakeCompleting(this.getState$kotlinx_coroutines_core(), object0);
            if(object1 == JobSupportKt.access$getCOMPLETING_ALREADY$p()) {
                return false;
            }
            if(object1 == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
                return true;
            }
        }
        while(object1 == JobSupportKt.access$getCOMPLETING_RETRY$p());
        this.afterCompletion(object1);
        return true;
    }

    public final Object makeCompletingOnce$kotlinx_coroutines_core(Object object0) {
        Object object1;
        while((object1 = this.tryMakeCompleting(this.getState$kotlinx_coroutines_core(), object0)) != JobSupportKt.access$getCOMPLETING_ALREADY$p()) {
            if(object1 != JobSupportKt.access$getCOMPLETING_RETRY$p()) {
                return object1;
            }
        }
        throw new IllegalStateException(UnityPlayerActivity.adjustValue("241F0F41") + this + UnityPlayerActivity.adjustValue("4E191E410F0D1500130A094D02010C1709171A154D0E1C41040A1F1E1C0815070F0049520C0519410712470717071E0A410D0E0A151E0B0408054E160E111A4E") + object0, this.getExceptionOrNull(object0));
    }

    private final JobNode makeNode(Function1 function10, boolean z) {
        JobNode jobNode0 = null;
        if(z) {
            if(function10 instanceof JobCancellingNode) {
                jobNode0 = (JobCancellingNode)function10;
            }
            if(jobNode0 == null) {
                jobNode0 = new InvokeOnCancelling(function10);
            }
        }
        else {
            if(function10 instanceof JobNode) {
                jobNode0 = (JobNode)function10;
            }
            if(jobNode0 == null) {
                jobNode0 = new InvokeOnCompletion(function10);
            }
        }
        jobNode0.setJob(this);
        return jobNode0;
    }

    @Override  // kotlin.coroutines.CoroutineContext$Element
    public CoroutineContext minusKey(Key coroutineContext$Key0) {
        return DefaultImpls.minusKey(this, coroutineContext$Key0);
    }

    public String nameString$kotlinx_coroutines_core() {
        return DebugStringsKt.getClassSimpleName(this);
    }

    private final ChildHandleNode nextChild(LockFreeLinkedListNode lockFreeLinkedListNode0) {
        while(lockFreeLinkedListNode0.isRemoved()) {
            lockFreeLinkedListNode0 = lockFreeLinkedListNode0.getPrevNode();
        }
        do {
            do {
                lockFreeLinkedListNode0 = lockFreeLinkedListNode0.getNextNode();
            }
            while(lockFreeLinkedListNode0.isRemoved());
            if(lockFreeLinkedListNode0 instanceof ChildHandleNode) {
                return (ChildHandleNode)lockFreeLinkedListNode0;
            }
        }
        while(!(lockFreeLinkedListNode0 instanceof NodeList));
        return null;
    }

    private final void notifyCancelling(NodeList nodeList0, Throwable throwable0) {
        this.onCancelling(throwable0);
        LockFreeLinkedListNode lockFreeLinkedListNode0 = (LockFreeLinkedListNode)nodeList0.getNext();
        CompletionHandlerException completionHandlerException0 = null;
        while(!Intrinsics.areEqual(lockFreeLinkedListNode0, nodeList0)) {
            if(lockFreeLinkedListNode0 instanceof JobCancellingNode) {
                JobNode jobNode0 = (JobNode)lockFreeLinkedListNode0;
                try {
                    jobNode0.invoke(throwable0);
                }
                catch(Throwable throwable1) {
                    if(completionHandlerException0 == null) {
                        completionHandlerException0 = new CompletionHandlerException(UnityPlayerActivity.adjustValue("2B080E041E150E0A1C4E1903410D0E0A151E0B04040E00410F041C0A1C08134E") + jobNode0 + UnityPlayerActivity.adjustValue("4E1602134E") + this, throwable1);
                    }
                    else {
                        ExceptionsKt.addSuppressed(completionHandlerException0, throwable1);
                        if(completionHandlerException0 == null) {
                            completionHandlerException0 = new CompletionHandlerException(UnityPlayerActivity.adjustValue("2B080E041E150E0A1C4E1903410D0E0A151E0B04040E00410F041C0A1C08134E") + jobNode0 + UnityPlayerActivity.adjustValue("4E1602134E") + this, throwable1);
                        }
                    }
                }
            }
            lockFreeLinkedListNode0 = lockFreeLinkedListNode0.getNextNode();
        }
        if(completionHandlerException0 != null) {
            this.handleOnCompletionException$kotlinx_coroutines_core(completionHandlerException0);
        }
        this.cancelParent(throwable0);
    }

    private final void notifyCompletion(NodeList nodeList0, Throwable throwable0) {
        LockFreeLinkedListNode lockFreeLinkedListNode0 = (LockFreeLinkedListNode)nodeList0.getNext();
        CompletionHandlerException completionHandlerException0 = null;
        while(!Intrinsics.areEqual(lockFreeLinkedListNode0, nodeList0)) {
            if(lockFreeLinkedListNode0 instanceof JobNode) {
                JobNode jobNode0 = (JobNode)lockFreeLinkedListNode0;
                try {
                    jobNode0.invoke(throwable0);
                }
                catch(Throwable throwable1) {
                    if(completionHandlerException0 == null) {
                        completionHandlerException0 = new CompletionHandlerException(UnityPlayerActivity.adjustValue("2B080E041E150E0A1C4E1903410D0E0A151E0B04040E00410F041C0A1C08134E") + jobNode0 + UnityPlayerActivity.adjustValue("4E1602134E") + this, throwable1);
                    }
                    else {
                        ExceptionsKt.addSuppressed(completionHandlerException0, throwable1);
                        if(completionHandlerException0 == null) {
                            completionHandlerException0 = new CompletionHandlerException(UnityPlayerActivity.adjustValue("2B080E041E150E0A1C4E1903410D0E0A151E0B04040E00410F041C0A1C08134E") + jobNode0 + UnityPlayerActivity.adjustValue("4E1602134E") + this, throwable1);
                        }
                    }
                }
            }
            lockFreeLinkedListNode0 = lockFreeLinkedListNode0.getNextNode();
        }
        if(completionHandlerException0 != null) {
            this.handleOnCompletionException$kotlinx_coroutines_core(completionHandlerException0);
        }
    }

    private final void notifyHandlers(NodeList nodeList0, Throwable throwable0) {
        LockFreeLinkedListNode lockFreeLinkedListNode0 = (LockFreeLinkedListNode)nodeList0.getNext();
        CompletionHandlerException completionHandlerException0 = null;
        while(!Intrinsics.areEqual(lockFreeLinkedListNode0, nodeList0)) {
            Intrinsics.reifiedOperationMarker(3, UnityPlayerActivity.adjustValue("3A"));
            if(lockFreeLinkedListNode0 instanceof LockFreeLinkedListNode) {
                JobNode jobNode0 = (JobNode)lockFreeLinkedListNode0;
                try {
                    jobNode0.invoke(throwable0);
                }
                catch(Throwable throwable1) {
                    if(completionHandlerException0 == null) {
                        completionHandlerException0 = new CompletionHandlerException(UnityPlayerActivity.adjustValue("2B080E041E150E0A1C4E1903410D0E0A151E0B04040E00410F041C0A1C08134E") + jobNode0 + UnityPlayerActivity.adjustValue("4E1602134E") + this, throwable1);
                    }
                    else {
                        ExceptionsKt.addSuppressed(completionHandlerException0, throwable1);
                        if(completionHandlerException0 == null) {
                            completionHandlerException0 = new CompletionHandlerException(UnityPlayerActivity.adjustValue("2B080E041E150E0A1C4E1903410D0E0A151E0B04040E00410F041C0A1C08134E") + jobNode0 + UnityPlayerActivity.adjustValue("4E1602134E") + this, throwable1);
                        }
                    }
                }
            }
            lockFreeLinkedListNode0 = lockFreeLinkedListNode0.getNextNode();
        }
        if(completionHandlerException0 != null) {
            this.handleOnCompletionException$kotlinx_coroutines_core(completionHandlerException0);
        }
    }

    protected void onCancelling(Throwable throwable0) {
    }

    protected void onCompletionInternal(Object object0) {
    }

    protected void onStart() {
    }

    @Override  // kotlinx.coroutines.ChildJob
    public final void parentCancelled(ParentJob parentJob0) {
        this.cancelImpl$kotlinx_coroutines_core(parentJob0);
    }

    @Override  // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext0) {
        return DefaultImpls.plus(this, coroutineContext0);
    }

    @Override  // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.ERROR, message = "Operator \'+\' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    public Job plus(Job job0) {
        return job0;
    }

    private final void promoteEmptyToNodeList(Empty empty0) {
        NodeList nodeList0 = new NodeList();
        Incomplete incomplete0 = empty0.isActive() ? nodeList0 : new InactiveNodeList(nodeList0);
        WorkSpec..ExternalSyntheticBackport0.m(JobSupport._state$FU, this, empty0, incomplete0);
    }

    private final void promoteSingleToNodeList(JobNode jobNode0) {
        jobNode0.addOneIfEmpty(new NodeList());
        LockFreeLinkedListNode lockFreeLinkedListNode0 = jobNode0.getNextNode();
        WorkSpec..ExternalSyntheticBackport0.m(JobSupport._state$FU, this, jobNode0, lockFreeLinkedListNode0);
    }

    @Override  // kotlinx.coroutines.selects.SelectClause0
    public final void registerSelectClause0(SelectInstance selectInstance0, Function1 function10) {
        do {
            Object object0 = this.getState$kotlinx_coroutines_core();
            if(selectInstance0.isSelected()) {
                return;
            }
            if(!(object0 instanceof Incomplete)) {
                if(selectInstance0.trySelect()) {
                    UndispatchedKt.startCoroutineUnintercepted(function10, selectInstance0.getCompletion());
                }
                return;
            }
        }
        while(this.startInternal(object0) != 0);
        selectInstance0.disposeOnSelect(this.invokeOnCompletion(new SelectJoinOnCompletion(selectInstance0, function10)));
    }

    public final void registerSelectClause1Internal$kotlinx_coroutines_core(SelectInstance selectInstance0, Function2 function20) {
        do {
            Object object0 = this.getState$kotlinx_coroutines_core();
            if(selectInstance0.isSelected()) {
                return;
            }
            if(!(object0 instanceof Incomplete)) {
                if(selectInstance0.trySelect()) {
                    if(object0 instanceof CompletedExceptionally) {
                        selectInstance0.resumeSelectWithException(((CompletedExceptionally)object0).cause);
                        return;
                    }
                    UndispatchedKt.startCoroutineUnintercepted(function20, JobSupportKt.unboxState(object0), selectInstance0.getCompletion());
                }
                return;
            }
        }
        while(this.startInternal(object0) != 0);
        selectInstance0.disposeOnSelect(this.invokeOnCompletion(new SelectAwaitOnCompletion(selectInstance0, function20)));
    }

    public final void removeNode$kotlinx_coroutines_core(JobNode jobNode0) {
        while(true) {
            Object object0 = this.getState$kotlinx_coroutines_core();
            if(!(object0 instanceof JobNode)) {
                break;
            }
            if(object0 != jobNode0) {
                return;
            }
            if(WorkSpec..ExternalSyntheticBackport0.m(JobSupport._state$FU, this, object0, JobSupportKt.access$getEMPTY_ACTIVE$p())) {
                return;
            }
        }
        if(object0 instanceof Incomplete && ((Incomplete)object0).getList() != null) {
            jobNode0.remove();
        }
    }

    public final void selectAwaitCompletion$kotlinx_coroutines_core(SelectInstance selectInstance0, Function2 function20) {
        Object object0 = this.getState$kotlinx_coroutines_core();
        if(object0 instanceof CompletedExceptionally) {
            selectInstance0.resumeSelectWithException(((CompletedExceptionally)object0).cause);
            return;
        }
        CancellableKt.startCoroutineCancellable$default(function20, JobSupportKt.unboxState(object0), selectInstance0.getCompletion(), null, 4, null);
    }

    public final void setParentHandle$kotlinx_coroutines_core(ChildHandle childHandle0) {
        this._parentHandle = childHandle0;
    }

    @Override  // kotlinx.coroutines.Job
    public final boolean start() {
    alab1:
        while(true) {
            switch(this.startInternal(this.getState$kotlinx_coroutines_core())) {
                case 0: {
                    return false;
                }
                case 1: {
                    break alab1;
                }
            }
        }
        return true;
    }

    private final int startInternal(Object object0) {
        if(object0 instanceof Empty) {
            if(((Empty)object0).isActive()) {
                return 0;
            }
            if(!WorkSpec..ExternalSyntheticBackport0.m(JobSupport._state$FU, this, object0, JobSupportKt.access$getEMPTY_ACTIVE$p())) {
                return -1;
            }
            this.onStart();
            return 1;
        }
        if(object0 instanceof InactiveNodeList) {
            NodeList nodeList0 = ((InactiveNodeList)object0).getList();
            if(!WorkSpec..ExternalSyntheticBackport0.m(JobSupport._state$FU, this, object0, nodeList0)) {
                return -1;
            }
            this.onStart();
            return 1;
        }
        return 0;
    }

    private final String stateString(Object object0) {
        String s = UnityPlayerActivity.adjustValue("2F1319081804");
        if(object0 instanceof Finishing) {
            if(((Finishing)object0).isCancelling()) {
                return UnityPlayerActivity.adjustValue("2D1103020B0D0B0C1C09");
            }
            return ((Finishing)object0).isCompleting() ? UnityPlayerActivity.adjustValue("2D1F00110204130C1C09") : s;
        }
        if(object0 instanceof Incomplete) {
            return ((Incomplete)object0).isActive() ? s : UnityPlayerActivity.adjustValue("20151A");
        }
        return object0 instanceof CompletedExceptionally ? UnityPlayerActivity.adjustValue("2D1103020B0D0B0016") : UnityPlayerActivity.adjustValue("2D1F00110204130016");
    }

    protected final CancellationException toCancellationException(Throwable throwable0, String s) {
        CancellationException cancellationException0 = throwable0 instanceof CancellationException ? ((CancellationException)throwable0) : null;
        if(cancellationException0 == null) {
            if(s == null) {
                s = this.cancellationExceptionMessage();
            }
            return new JobCancellationException(s, throwable0, this);
        }
        return cancellationException0;
    }

    public static CancellationException toCancellationException$default(JobSupport jobSupport0, Throwable throwable0, String s, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException(UnityPlayerActivity.adjustValue("3D051D041C4104041E02034D1607150F45160B160C14021547040009050004001514451C01044D121B11170A001A150941070F47111A07034D150F1300000642500B140002130C1D004A4D150122060B110B1C01001A08080B37161308111A08080B"));
        }
        if((v & 1) != 0) {
            s = null;
        }
        return jobSupport0.toCancellationException(throwable0, s);
    }

    public final String toDebugString() {
        return this.nameString$kotlinx_coroutines_core() + '{' + this.stateString(this.getState$kotlinx_coroutines_core()) + '}';
    }

    @Override
    public String toString() {
        return this.toDebugString() + '@' + DebugStringsKt.getHexAddress(this);
    }

    private final boolean tryFinalizeSimpleState(Incomplete incomplete0, Object object0) {
        Object object1 = JobSupportKt.boxIncomplete(object0);
        if(!WorkSpec..ExternalSyntheticBackport0.m(JobSupport._state$FU, this, incomplete0, object1)) {
            return false;
        }
        this.onCancelling(null);
        this.onCompletionInternal(object0);
        this.completeStateFinalization(incomplete0, object0);
        return true;
    }

    private final boolean tryMakeCancelling(Incomplete incomplete0, Throwable throwable0) {
        NodeList nodeList0 = this.getOrPromoteCancellingList(incomplete0);
        if(nodeList0 == null) {
            return false;
        }
        Finishing jobSupport$Finishing0 = new Finishing(nodeList0, false, throwable0);
        if(!WorkSpec..ExternalSyntheticBackport0.m(JobSupport._state$FU, this, incomplete0, jobSupport$Finishing0)) {
            return false;
        }
        this.notifyCancelling(nodeList0, throwable0);
        return true;
    }

    private final Object tryMakeCompleting(Object object0, Object object1) {
        if(!(object0 instanceof Incomplete)) {
            return JobSupportKt.access$getCOMPLETING_ALREADY$p();
        }
        if((object0 instanceof Empty || object0 instanceof JobNode) && !(object0 instanceof ChildHandleNode) && !(object1 instanceof CompletedExceptionally)) {
            return this.tryFinalizeSimpleState(((Incomplete)object0), object1) ? object1 : JobSupportKt.access$getCOMPLETING_RETRY$p();
        }
        return this.tryMakeCompletingSlowPath(((Incomplete)object0), object1);
    }

    private final Object tryMakeCompletingSlowPath(Incomplete incomplete0, Object object0) {
        Throwable throwable0 = null;
        NodeList nodeList0 = this.getOrPromoteCancellingList(incomplete0);
        if(nodeList0 == null) {
            return JobSupportKt.access$getCOMPLETING_RETRY$p();
        }
        Finishing jobSupport$Finishing0 = incomplete0 instanceof Finishing ? ((Finishing)incomplete0) : null;
        if(jobSupport$Finishing0 == null) {
            jobSupport$Finishing0 = new Finishing(nodeList0, false, null);
        }
        ObjectRef ref$ObjectRef0 = new ObjectRef();
        synchronized(jobSupport$Finishing0) {
            if(jobSupport$Finishing0.isCompleting()) {
                return JobSupportKt.access$getCOMPLETING_ALREADY$p();
            }
            jobSupport$Finishing0.setCompleting(true);
            if(jobSupport$Finishing0 != incomplete0 && !WorkSpec..ExternalSyntheticBackport0.m(JobSupport._state$FU, this, incomplete0, jobSupport$Finishing0)) {
                return JobSupportKt.access$getCOMPLETING_RETRY$p();
            }
            boolean z = jobSupport$Finishing0.isCancelling();
            CompletedExceptionally completedExceptionally0 = object0 instanceof CompletedExceptionally ? ((CompletedExceptionally)object0) : null;
            if(completedExceptionally0 != null) {
                jobSupport$Finishing0.addExceptionLocked(completedExceptionally0.cause);
            }
            Throwable throwable1 = jobSupport$Finishing0.getRootCause();
            if(!z) {
                throwable0 = throwable1;
            }
            ref$ObjectRef0.element = throwable0;
        }
        Throwable throwable2 = (Throwable)ref$ObjectRef0.element;
        if(throwable2 != null) {
            this.notifyCancelling(nodeList0, throwable2);
        }
        ChildHandleNode childHandleNode0 = this.firstChild(incomplete0);
        return childHandleNode0 != null && this.tryWaitForChild(jobSupport$Finishing0, childHandleNode0, object0) ? JobSupportKt.COMPLETING_WAITING_CHILDREN : this.finalizeFinishingState(jobSupport$Finishing0, object0);
    }

    private final boolean tryWaitForChild(Finishing jobSupport$Finishing0, ChildHandleNode childHandleNode0, Object object0) {
        do {
            Function1 function10 = new ChildCompletion(this, jobSupport$Finishing0, childHandleNode0, object0);
            if(DefaultImpls.invokeOnCompletion$default(childHandleNode0.childJob, false, false, function10, 1, null) != NonDisposableHandle.INSTANCE) {
                return true;
            }
            childHandleNode0 = this.nextChild(childHandleNode0);
        }
        while(childHandleNode0 != null);
        return false;
    }
}

