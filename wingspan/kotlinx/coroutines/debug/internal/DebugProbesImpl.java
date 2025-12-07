package kotlinx.coroutines.debug.internal;

import com.unity3d.player.UnityPlayerActivity;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import jeb.synthetic.FIN;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.concurrent.ThreadsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineId;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;

@Metadata(d1 = {"\u0000\u00D6\u0001\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001B\b\u00C0\u0002\u0018\u00002\u00020\u0014:\u0002\u0095\u0001B\t\b\u0002\u00A2\u0006\u0004\b\u0001\u0010\u0002J3\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00032\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0002\u00A2\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\n\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0013\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00100\u000F\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00140\u0013\u00A2\u0006\u0004\b\u0015\u0010\u0016J@\u0010\u001C\u001A\b\u0012\u0004\u0012\u00028\u00000\u000F\"\b\b\u0000\u0010\u0017*\u00020\u00142\u001E\b\u0004\u0010\u001B\u001A\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0019\u0012\u0004\u0012\u00020\u001A\u0012\u0004\u0012\u00028\u00000\u0018H\u0082\b\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u0017\u0010\u001E\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\nH\u0002\u00A2\u0006\u0004\b\u001E\u0010\u000EJ\u0013\u0010 \u001A\b\u0012\u0004\u0012\u00020\u001F0\u000F\u00A2\u0006\u0004\b \u0010\u0012J)\u0010$\u001A\b\u0012\u0004\u0012\u00020\"0\u000F2\u0006\u0010!\u001A\u00020\u00102\f\u0010#\u001A\b\u0012\u0004\u0012\u00020\"0\u000F\u00A2\u0006\u0004\b$\u0010%J\u0015\u0010\'\u001A\u00020&2\u0006\u0010!\u001A\u00020\u0010\u00A2\u0006\u0004\b\'\u0010(J5\u0010,\u001A\b\u0012\u0004\u0012\u00020\"0\u000F2\u0006\u0010)\u001A\u00020&2\b\u0010+\u001A\u0004\u0018\u00010*2\f\u0010#\u001A\b\u0012\u0004\u0012\u00020\"0\u000FH\u0002\u00A2\u0006\u0004\b,\u0010-J?\u00102\u001A\u000E\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020.012\u0006\u0010/\u001A\u00020.2\f\u00100\u001A\b\u0012\u0004\u0012\u00020\"0\u00132\f\u0010#\u001A\b\u0012\u0004\u0012\u00020\"0\u000FH\u0002\u00A2\u0006\u0004\b2\u00103J3\u00105\u001A\u00020.2\u0006\u00104\u001A\u00020.2\f\u00100\u001A\b\u0012\u0004\u0012\u00020\"0\u00132\f\u0010#\u001A\b\u0012\u0004\u0012\u00020\"0\u000FH\u0002\u00A2\u0006\u0004\b5\u00106J\u001D\u00109\u001A\u0010\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\f\u0018\u000107H\u0002\u00A2\u0006\u0004\b9\u0010:J\u0015\u0010=\u001A\u00020&2\u0006\u0010<\u001A\u00020;\u00A2\u0006\u0004\b=\u0010>J\r\u0010?\u001A\u00020\f\u00A2\u0006\u0004\b?\u0010\u0002J%\u0010A\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\n2\f\u0010@\u001A\b\u0012\u0004\u0012\u00020\"0\u000FH\u0002\u00A2\u0006\u0004\bA\u0010BJ\u001B\u0010D\u001A\u00020\f2\n\u0010C\u001A\u0006\u0012\u0002\b\u00030\u0019H\u0002\u00A2\u0006\u0004\bD\u0010EJ)\u0010H\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00032\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0000\u00A2\u0006\u0004\bF\u0010GJ\u001B\u0010K\u001A\u00020\f2\n\u0010\u0007\u001A\u0006\u0012\u0002\b\u00030\u0004H\u0000\u00A2\u0006\u0004\bI\u0010JJ\u001B\u0010M\u001A\u00020\f2\n\u0010\u0007\u001A\u0006\u0012\u0002\b\u00030\u0004H\u0000\u00A2\u0006\u0004\bL\u0010JJ\'\u0010P\u001A\b\u0012\u0004\u0012\u00020\"0\u000F\"\b\b\u0000\u0010\u0003*\u00020N2\u0006\u0010O\u001A\u00028\u0000H\u0002\u00A2\u0006\u0004\bP\u0010QJ\u000F\u0010R\u001A\u00020\fH\u0002\u00A2\u0006\u0004\bR\u0010\u0002J\u000F\u0010S\u001A\u00020\fH\u0002\u00A2\u0006\u0004\bS\u0010\u0002J\r\u0010T\u001A\u00020\f\u00A2\u0006\u0004\bT\u0010\u0002J\u001F\u0010V\u001A\u00020\f2\u0006\u0010\u0007\u001A\u00020U2\u0006\u0010)\u001A\u00020&H\u0002\u00A2\u0006\u0004\bV\u0010WJ#\u0010X\u001A\u00020\f2\n\u0010\u0007\u001A\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010)\u001A\u00020&H\u0002\u00A2\u0006\u0004\bX\u0010YJ/\u0010X\u001A\u00020\f2\n\u0010C\u001A\u0006\u0012\u0002\b\u00030\u00192\n\u0010\u0007\u001A\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010)\u001A\u00020&H\u0002\u00A2\u0006\u0004\bX\u0010ZJ;\u0010b\u001A\u00020\f*\u00020;2\u0012\u0010]\u001A\u000E\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\\0[2\n\u0010`\u001A\u00060^j\u0002`_2\u0006\u0010a\u001A\u00020&H\u0002\u00A2\u0006\u0004\bb\u0010cJ\u0017\u0010d\u001A\u000208*\u0006\u0012\u0002\b\u00030\u0019H\u0002\u00A2\u0006\u0004\bd\u0010eJ\u001D\u0010C\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u0019*\u0006\u0012\u0002\b\u00030\u0004H\u0002\u00A2\u0006\u0004\bC\u0010fJ\u001A\u0010C\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u0019*\u00020UH\u0082\u0010\u00A2\u0006\u0004\bC\u0010gJ\u0016\u0010h\u001A\u0004\u0018\u00010U*\u00020UH\u0082\u0010\u00A2\u0006\u0004\bh\u0010iJ\u001B\u0010j\u001A\u0004\u0018\u00010\u0006*\b\u0012\u0004\u0012\u00020\"0\u000FH\u0002\u00A2\u0006\u0004\bj\u0010kJ\u0013\u0010l\u001A\u00020&*\u00020\u0014H\u0002\u00A2\u0006\u0004\bl\u0010mR\u0014\u0010n\u001A\u00020&8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bn\u0010oR \u0010q\u001A\u000E\u0012\u0004\u0012\u00020U\u0012\u0004\u0012\u00020\\0p8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bq\u0010rR\u001E\u0010v\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00190s8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\bt\u0010uR$\u0010w\u001A\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0019\u0012\u0004\u0012\u0002080p8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bw\u0010rR\u0014\u0010y\u001A\u00020x8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\by\u0010zR\u0014\u0010|\u001A\u00020{8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b|\u0010}R\"\u0010~\u001A\u0010\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\f\u0018\u0001078\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b~\u0010\u007FR)\u0010\u0080\u0001\u001A\u0002088\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0018\n\u0006\b\u0080\u0001\u0010\u0081\u0001\u001A\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0019\u0010\u0086\u0001\u001A\u00020.8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0017\u0010\u0089\u0001\u001A\u0002088@X\u0080\u0004\u00A2\u0006\b\u001A\u0006\b\u0088\u0001\u0010\u0083\u0001R)\u0010\u008A\u0001\u001A\u0002088\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0018\n\u0006\b\u008A\u0001\u0010\u0081\u0001\u001A\u0006\b\u008B\u0001\u0010\u0083\u0001\"\u0006\b\u008C\u0001\u0010\u0085\u0001R\u001B\u0010\u008D\u0001\u001A\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u008D\u0001\u0010\u008E\u0001R\"\u0010\u0092\u0001\u001A\u00020&*\u00020;8BX\u0082\u0004\u00A2\u0006\u000F\u0012\u0006\b\u0090\u0001\u0010\u0091\u0001\u001A\u0005\b\u008F\u0001\u0010>R\u001B\u0010\u0093\u0001\u001A\u000208*\u00020\"8BX\u0082\u0004\u00A2\u0006\b\u001A\u0006\b\u0093\u0001\u0010\u0094\u0001\u00A8\u0006\u0096\u0001"}, d2 = {"Lkotlinx/coroutines/debug/internal/DebugProbesImpl;", "<init>", "()V", "T", "Lkotlin/coroutines/Continuation;", "completion", "Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "frame", "createOwner", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/debug/internal/StackTraceFrame;)Lkotlin/coroutines/Continuation;", "Ljava/io/PrintStream;", "out", "", "dumpCoroutines", "(Ljava/io/PrintStream;)V", "", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;", "dumpCoroutinesInfo", "()Ljava/util/List;", "", "", "dumpCoroutinesInfoAsJsonAndReferences", "()[Ljava/lang/Object;", "R", "Lkotlin/Function2;", "Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "Lkotlin/coroutines/CoroutineContext;", "create", "dumpCoroutinesInfoImpl", "(Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "dumpCoroutinesSynchronized", "Lkotlinx/coroutines/debug/internal/DebuggerInfo;", "dumpDebuggerInfo", "info", "Ljava/lang/StackTraceElement;", "coroutineTrace", "enhanceStackTraceWithThreadDump", "(Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;Ljava/util/List;)Ljava/util/List;", "", "enhanceStackTraceWithThreadDumpAsJson", "(Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;)Ljava/lang/String;", "state", "Ljava/lang/Thread;", "thread", "enhanceStackTraceWithThreadDumpImpl", "(Ljava/lang/String;Ljava/lang/Thread;Ljava/util/List;)Ljava/util/List;", "", "indexOfResumeWith", "actualTrace", "Lkotlin/Pair;", "findContinuationStartIndex", "(I[Ljava/lang/StackTraceElement;Ljava/util/List;)Lkotlin/Pair;", "frameIndex", "findIndexOfFrame", "(I[Ljava/lang/StackTraceElement;Ljava/util/List;)I", "Lkotlin/Function1;", "", "getDynamicAttach", "()Lkotlin/jvm/functions/Function1;", "Lkotlinx/coroutines/Job;", "job", "hierarchyToString", "(Lkotlinx/coroutines/Job;)Ljava/lang/String;", "install", "frames", "printStackTrace", "(Ljava/io/PrintStream;Ljava/util/List;)V", "owner", "probeCoroutineCompleted", "(Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;)V", "probeCoroutineCreated$kotlinx_coroutines_core", "(Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "probeCoroutineCreated", "probeCoroutineResumed$kotlinx_coroutines_core", "(Lkotlin/coroutines/Continuation;)V", "probeCoroutineResumed", "probeCoroutineSuspended$kotlinx_coroutines_core", "probeCoroutineSuspended", "", "throwable", "sanitizeStackTrace", "(Ljava/lang/Throwable;)Ljava/util/List;", "startWeakRefCleanerThread", "stopWeakRefCleanerThread", "uninstall", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "updateRunningState", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;Ljava/lang/String;)V", "updateState", "(Lkotlin/coroutines/Continuation;Ljava/lang/String;)V", "(Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;Lkotlin/coroutines/Continuation;Ljava/lang/String;)V", "", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "map", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "builder", "indent", "build", "(Lkotlinx/coroutines/Job;Ljava/util/Map;Ljava/lang/StringBuilder;Ljava/lang/String;)V", "isFinished", "(Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;)Z", "(Lkotlin/coroutines/Continuation;)Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "realCaller", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "toStackTraceFrame", "(Ljava/util/List;)Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "toStringWithQuotes", "(Ljava/lang/Object;)Ljava/lang/String;", "ARTIFICIAL_FRAME_MESSAGE", "Ljava/lang/String;", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "callerInfoCache", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "", "getCapturedCoroutines", "()Ljava/util/Set;", "capturedCoroutines", "capturedCoroutinesMap", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "coroutineStateLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "Ljava/text/SimpleDateFormat;", "dateFormat", "Ljava/text/SimpleDateFormat;", "dynamicAttach", "Lkotlin/jvm/functions/Function1;", "enableCreationStackTraces", "Z", "getEnableCreationStackTraces", "()Z", "setEnableCreationStackTraces", "(Z)V", "installations", "I", "isInstalled$kotlinx_coroutines_core", "isInstalled", "sanitizeStackTraces", "getSanitizeStackTraces", "setSanitizeStackTraces", "weakRefCleanerThread", "Ljava/lang/Thread;", "getDebugString", "getDebugString$annotations", "(Lkotlinx/coroutines/Job;)V", "debugString", "isInternalMethod", "(Ljava/lang/StackTraceElement;)Z", "CoroutineOwner", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
public final class DebugProbesImpl {
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B%\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\n\u0010\u0010\u001A\u0004\u0018\u00010\u0011H\u0016J\u001E\u0010\u0012\u001A\u00020\u00132\f\u0010\u0014\u001A\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001A\u00020\u0018H\u0016R\u0016\u0010\t\u001A\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0012\u0010\f\u001A\u00020\rX\u0096\u0005¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0016\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u00028\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001A\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001A\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "T", "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "delegate", "info", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "frame", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "resumeWith", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    static final class CoroutineOwner implements Continuation, CoroutineStackFrame {
        public final Continuation delegate;
        private final CoroutineStackFrame frame;
        public final DebugCoroutineInfoImpl info;

        public CoroutineOwner(Continuation continuation0, DebugCoroutineInfoImpl debugCoroutineInfoImpl0, CoroutineStackFrame coroutineStackFrame0) {
            this.delegate = continuation0;
            this.info = debugCoroutineInfoImpl0;
            this.frame = coroutineStackFrame0;
        }

        @Override  // kotlin.coroutines.jvm.internal.CoroutineStackFrame
        public CoroutineStackFrame getCallerFrame() {
            return this.frame == null ? null : this.frame.getCallerFrame();
        }

        @Override  // kotlin.coroutines.Continuation
        public CoroutineContext getContext() {
            return this.delegate.getContext();
        }

        @Override  // kotlin.coroutines.jvm.internal.CoroutineStackFrame
        public StackTraceElement getStackTraceElement() {
            return this.frame == null ? null : this.frame.getStackTraceElement();
        }

        @Override  // kotlin.coroutines.Continuation
        public void resumeWith(Object object0) {
            DebugProbesImpl.INSTANCE.probeCoroutineCompleted(this);
            this.delegate.resumeWith(object0);
        }

        @Override
        public String toString() {
            return this.delegate.toString();
        }
    }

    private static final String ARTIFICIAL_FRAME_MESSAGE = "Coroutine creation stacktrace";
    public static final DebugProbesImpl INSTANCE;
    private static final ConcurrentWeakMap callerInfoCache;
    private static final ConcurrentWeakMap capturedCoroutinesMap;
    private static final ReentrantReadWriteLock coroutineStateLock;
    private static final SimpleDateFormat dateFormat;
    private static final DebugProbesImpl.SequenceNumberRefVolatile debugProbesImpl$SequenceNumberRefVolatile;
    private static final Function1 dynamicAttach;
    private static boolean enableCreationStackTraces;
    private static volatile int installations;
    private static boolean sanitizeStackTraces;
    private static final AtomicLongFieldUpdater sequenceNumber$FU;
    private static Thread weakRefCleanerThread;

    static {
        DebugProbesImpl debugProbesImpl0 = new DebugProbesImpl();
        DebugProbesImpl.INSTANCE = debugProbesImpl0;
        DebugProbesImpl.dateFormat = new SimpleDateFormat(UnityPlayerActivity.adjustValue("17091418412C2A4A160A502529540C0A5F011D"));
        DebugProbesImpl.capturedCoroutinesMap = new ConcurrentWeakMap(false, 1, null);
        DebugProbesImpl.debugProbesImpl$SequenceNumberRefVolatile = new DebugProbesImpl.SequenceNumberRefVolatile(0L);
        DebugProbesImpl.coroutineStateLock = new ReentrantReadWriteLock();
        DebugProbesImpl.sanitizeStackTraces = true;
        DebugProbesImpl.enableCreationStackTraces = true;
        DebugProbesImpl.dynamicAttach = debugProbesImpl0.getDynamicAttach();
        DebugProbesImpl.callerInfoCache = new ConcurrentWeakMap(true);
        String s = UnityPlayerActivity.adjustValue("1D151C140B0F04003C1B1D0F041C");
        DebugProbesImpl.sequenceNumber$FU = AtomicLongFieldUpdater.newUpdater(DebugProbesImpl.SequenceNumberRefVolatile.class, s);
    }

    private final void build(Job job0, Map map0, StringBuilder stringBuilder0, String s) {
        DebugCoroutineInfoImpl debugCoroutineInfoImpl0 = (DebugCoroutineInfoImpl)map0.get(job0);
        if(debugCoroutineInfoImpl0 != null) {
            StackTraceElement stackTraceElement0 = (StackTraceElement)CollectionsKt.firstOrNull(debugCoroutineInfoImpl0.lastObservedStackTrace());
            stringBuilder0.append(s + this.getDebugString(job0) + UnityPlayerActivity.adjustValue("42500E0E00150E0B070F04040E00410E1652") + debugCoroutineInfoImpl0.getState() + UnityPlayerActivity.adjustValue("4E1119410208090052") + stackTraceElement0 + '\n');
            s = s + '\t';
        }
        else if(!(job0 instanceof ScopeCoroutine)) {
            stringBuilder0.append(s + this.getDebugString(job0) + '\n');
            s = s + '\t';
        }
        for(Object object0: job0.getChildren()) {
            this.build(((Job)object0), map0, stringBuilder0, s);
        }
    }

    // 去混淆评级： 中等(60)
    private final Continuation createOwner(Continuation continuation0, StackTraceFrame stackTraceFrame0) {
        return continuation0;
    }

    public final void dumpCoroutines(PrintStream printStream0) {
        synchronized(printStream0) {
            DebugProbesImpl.INSTANCE.dumpCoroutinesSynchronized(printStream0);
        }
    }

    public final List dumpCoroutinesInfo() {
        ReentrantReadWriteLock reentrantReadWriteLock0 = DebugProbesImpl.coroutineStateLock;
        ReentrantReadWriteLock.ReadLock reentrantReadWriteLock$ReadLock0 = reentrantReadWriteLock0.readLock();
        int v = reentrantReadWriteLock0.getWriteHoldCount() == 0 ? reentrantReadWriteLock0.getReadHoldCount() : 0;
        for(int v1 = 0; v1 < v; ++v1) {
            reentrantReadWriteLock$ReadLock0.unlock();
        }
        reentrantReadWriteLock0.writeLock().lock();
        FIN.finallyExec$NT(FIN.finallyOpen$NT());
        throw new IllegalStateException(UnityPlayerActivity.adjustValue("2A150F14094117171D0C151E410F1302451C01044D08001213041E021509").toString());

        @Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001A\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\n\u0010\u0003\u001A\u0006\u0012\u0002\b\u00030\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "R", "", "owner", "Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "invoke", "(Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;)Ljava/lang/Object;", "kotlinx/coroutines/debug/internal/DebugProbesImpl$dumpCoroutinesInfoImpl$1$3"}, k = 3, mv = {1, 6, 0}, xi = 0x30)
        public final class kotlinx.coroutines.debug.internal.DebugProbesImpl.dumpCoroutinesInfo..inlined.dumpCoroutinesInfoImpl.1 extends Lambda implements Function1 {
            public kotlinx.coroutines.debug.internal.DebugProbesImpl.dumpCoroutinesInfo..inlined.dumpCoroutinesInfoImpl.1() {
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((CoroutineOwner)object0));
            }

            public final Object invoke(CoroutineOwner debugProbesImpl$CoroutineOwner0) {
                if(!DebugProbesImpl.INSTANCE.isFinished(debugProbesImpl$CoroutineOwner0)) {
                    CoroutineContext coroutineContext0 = debugProbesImpl$CoroutineOwner0.info.getContext();
                    return coroutineContext0 == null ? null : new DebugCoroutineInfo(debugProbesImpl$CoroutineOwner0.info, coroutineContext0);
                }
                return null;
            }
        }

    }

    public final Object[] dumpCoroutinesInfoAsJsonAndReferences() {
        String s1;
        List list0 = this.dumpCoroutinesInfo();
        int v = list0.size();
        ArrayList arrayList0 = new ArrayList(v);
        ArrayList arrayList1 = new ArrayList(v);
        ArrayList arrayList2 = new ArrayList(v);
        for(Object object0: list0) {
            CoroutineContext coroutineContext0 = ((DebugCoroutineInfo)object0).getContext();
            CoroutineName coroutineName0 = (CoroutineName)coroutineContext0.get(CoroutineName.Key);
            Long long0 = null;
            if(coroutineName0 == null) {
                s1 = null;
            }
            else {
                String s = coroutineName0.getName();
                if(s != null) {
                    s1 = this.toStringWithQuotes(s);
                }
            }
            CoroutineDispatcher coroutineDispatcher0 = (CoroutineDispatcher)coroutineContext0.get(CoroutineDispatcher.Key);
            String s2 = coroutineDispatcher0 == null ? null : this.toStringWithQuotes(coroutineDispatcher0);
            StringBuilder stringBuilder0 = new StringBuilder(UnityPlayerActivity.adjustValue("64504D414E414745524E504D414E4147450964504D414E414745524E504D414E414745524E504D4300000A00505450"));
            stringBuilder0.append(s1);
            stringBuilder0.append(UnityPlayerActivity.adjustValue("427A4D414E414745524E504D414E414745524E504D414C080347484E"));
            CoroutineId coroutineId0 = (CoroutineId)coroutineContext0.get(CoroutineId.Key);
            if(coroutineId0 != null) {
                long0 = coroutineId0.getId();
            }
            stringBuilder0.append(long0);
            stringBuilder0.append(UnityPlayerActivity.adjustValue("427A4D414E414745524E504D414E414745524E504D414C050E16020F040E090B13455F52"));
            stringBuilder0.append(s2);
            stringBuilder0.append(UnityPlayerActivity.adjustValue("427A4D414E414745524E504D414E414745524E504D414C120214070B1E0E0420140A07171C525741"));
            stringBuilder0.append(((DebugCoroutineInfo)object0).getSequenceNumber());
            stringBuilder0.append(UnityPlayerActivity.adjustValue("427A4D414E414745524E504D414E414745524E504D414C121304060B5257414C"));
            stringBuilder0.append(((DebugCoroutineInfo)object0).getState());
            stringBuilder0.append(UnityPlayerActivity.adjustValue("4C7A4D414E414745524E504D414E41474552135067414E414745524E504D414E414745524E"));
            arrayList2.add(StringsKt.trimIndent(stringBuilder0.toString()));
            arrayList1.add(((DebugCoroutineInfo)object0).getLastObservedFrame());
            arrayList0.add(((DebugCoroutineInfo)object0).getLastObservedThread());
        }
        Object[] arr_object = new Object[4];
        arr_object[0] = UnityPlayerActivity.adjustValue("35") + CollectionsKt.joinToString$default(arrayList2, null, null, null, 0, null, null, 0x3F, null) + ']';
        Object[] arr_object1 = arrayList0.toArray(new Thread[0]);
        String s3 = UnityPlayerActivity.adjustValue("0005010D4E02060B1C01044D030B410404011A50190E4E0F080B5F0005010D4E151E15174E1B02150208094B331C020C185235470A144E1B02150208094B11011C01040D150E0A1C1D5E2C131C001E16391A2F32201C13061C012426202A1A4F130A26170008052F1315040B50");
        if(arr_object1 == null) {
            throw new NullPointerException(s3);
        }
        arr_object[1] = arr_object1;
        Object[] arr_object2 = arrayList1.toArray(new CoroutineStackFrame[0]);
        if(arr_object2 == null) {
            throw new NullPointerException(s3);
        }
        arr_object[2] = arr_object2;
        Object[] arr_object3 = list0.toArray(new DebugCoroutineInfo[0]);
        if(arr_object3 == null) {
            throw new NullPointerException(s3);
        }
        arr_object[3] = arr_object3;
        return arr_object;
    }

    private final List dumpCoroutinesInfoImpl(Function2 function20) {
        ReentrantReadWriteLock reentrantReadWriteLock0 = DebugProbesImpl.coroutineStateLock;
        ReentrantReadWriteLock.ReadLock reentrantReadWriteLock$ReadLock0 = reentrantReadWriteLock0.readLock();
        int v = reentrantReadWriteLock0.getWriteHoldCount() == 0 ? reentrantReadWriteLock0.getReadHoldCount() : 0;
        for(int v1 = 0; v1 < v; ++v1) {
            reentrantReadWriteLock$ReadLock0.unlock();
        }
        reentrantReadWriteLock0.writeLock().lock();
        FIN.finallyExec$NT(FIN.finallyOpen$NT());
        throw new IllegalStateException(UnityPlayerActivity.adjustValue("2A150F14094117171D0C151E410F1302451C01044D08001213041E021509").toString());

        @Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001A\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\n\u0010\u0003\u001A\u0006\u0012\u0002\b\u00030\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "R", "", "owner", "Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "invoke", "(Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 0x30)
        public final class kotlinx.coroutines.debug.internal.DebugProbesImpl.dumpCoroutinesInfoImpl.1.3 extends Lambda implements Function1 {
            final Function2 $create;

            public kotlinx.coroutines.debug.internal.DebugProbesImpl.dumpCoroutinesInfoImpl.1.3(Function2 function20) {
                this.$create = function20;
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((CoroutineOwner)object0));
            }

            public final Object invoke(CoroutineOwner debugProbesImpl$CoroutineOwner0) {
                if(!DebugProbesImpl.INSTANCE.isFinished(debugProbesImpl$CoroutineOwner0)) {
                    CoroutineContext coroutineContext0 = debugProbesImpl$CoroutineOwner0.info.getContext();
                    return coroutineContext0 == null ? null : this.$create.invoke(debugProbesImpl$CoroutineOwner0, coroutineContext0);
                }
                return null;
            }
        }


        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000E\u0010\u0003\u001A\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000E\u0010\u0005\u001A\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 6, 0}, xi = 0x30)
        public final class kotlinx.coroutines.debug.internal.DebugProbesImpl.dumpCoroutinesInfoImpl.lambda-12..inlined.sortedBy.1 implements Comparator {
            @Override
            public final int compare(Object object0, Object object1) {
                return ComparisonsKt.compareValues(((CoroutineOwner)object0).info.sequenceNumber, ((CoroutineOwner)object1).info.sequenceNumber);
            }
        }

    }

    private final void dumpCoroutinesSynchronized(PrintStream printStream0) {
        ReentrantReadWriteLock reentrantReadWriteLock0 = DebugProbesImpl.coroutineStateLock;
        ReentrantReadWriteLock.ReadLock reentrantReadWriteLock$ReadLock0 = reentrantReadWriteLock0.readLock();
        int v = reentrantReadWriteLock0.getWriteHoldCount() == 0 ? reentrantReadWriteLock0.getReadHoldCount() : 0;
        for(int v1 = 0; v1 < v; ++v1) {
            reentrantReadWriteLock$ReadLock0.unlock();
        }
        reentrantReadWriteLock0.writeLock().lock();
        FIN.finallyExec$NT(FIN.finallyOpen$NT());
        throw new IllegalStateException(UnityPlayerActivity.adjustValue("2A150F14094117171D0C151E410F1302451C01044D08001213041E021509").toString());

        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u00012\n\u0010\u0002\u001A\u0006\u0012\u0002\b\u00030\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "invoke", "(Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 0x30)
        final class kotlinx.coroutines.debug.internal.DebugProbesImpl.dumpCoroutinesSynchronized.1.2 extends Lambda implements Function1 {
            public static final kotlinx.coroutines.debug.internal.DebugProbesImpl.dumpCoroutinesSynchronized.1.2 INSTANCE;

            static {
                kotlinx.coroutines.debug.internal.DebugProbesImpl.dumpCoroutinesSynchronized.1.2.INSTANCE = new kotlinx.coroutines.debug.internal.DebugProbesImpl.dumpCoroutinesSynchronized.1.2();
            }

            kotlinx.coroutines.debug.internal.DebugProbesImpl.dumpCoroutinesSynchronized.1.2() {
                super(1);
            }

            public final Boolean invoke(CoroutineOwner debugProbesImpl$CoroutineOwner0) {
                return Boolean.valueOf(!DebugProbesImpl.INSTANCE.isFinished(debugProbesImpl$CoroutineOwner0));
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((CoroutineOwner)object0));
            }
        }


        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000E\u0010\u0003\u001A\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000E\u0010\u0005\u001A\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 6, 0}, xi = 0x30)
        public final class kotlinx.coroutines.debug.internal.DebugProbesImpl.dumpCoroutinesSynchronized.lambda-19..inlined.sortedBy.1 implements Comparator {
            @Override
            public final int compare(Object object0, Object object1) {
                return ComparisonsKt.compareValues(((CoroutineOwner)object0).info.sequenceNumber, ((CoroutineOwner)object1).info.sequenceNumber);
            }
        }

    }

    public final List dumpDebuggerInfo() {
        ReentrantReadWriteLock reentrantReadWriteLock0 = DebugProbesImpl.coroutineStateLock;
        ReentrantReadWriteLock.ReadLock reentrantReadWriteLock$ReadLock0 = reentrantReadWriteLock0.readLock();
        int v1 = reentrantReadWriteLock0.getWriteHoldCount() == 0 ? reentrantReadWriteLock0.getReadHoldCount() : 0;
        for(int v2 = 0; v2 < v1; ++v2) {
            reentrantReadWriteLock$ReadLock0.unlock();
        }
        ReentrantReadWriteLock.WriteLock reentrantReadWriteLock$WriteLock0 = reentrantReadWriteLock0.writeLock();
        reentrantReadWriteLock$WriteLock0.lock();
        try {
            throw new IllegalStateException(UnityPlayerActivity.adjustValue("2A150F14094117171D0C151E410F1302451C01044D08001213041E021509").toString());
        }
        catch(Throwable throwable0) {
            for(int v = 0; v < v1; ++v) {
                reentrantReadWriteLock$ReadLock0.lock();
            }
            reentrantReadWriteLock$WriteLock0.unlock();
            throw throwable0;
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001A\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\n\u0010\u0003\u001A\u0006\u0012\u0002\b\u00030\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "R", "", "owner", "Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "invoke", "(Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;)Ljava/lang/Object;", "kotlinx/coroutines/debug/internal/DebugProbesImpl$dumpCoroutinesInfoImpl$1$3"}, k = 3, mv = {1, 6, 0}, xi = 0x30)
        public final class kotlinx.coroutines.debug.internal.DebugProbesImpl.dumpDebuggerInfo..inlined.dumpCoroutinesInfoImpl.1 extends Lambda implements Function1 {
            public kotlinx.coroutines.debug.internal.DebugProbesImpl.dumpDebuggerInfo..inlined.dumpCoroutinesInfoImpl.1() {
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((CoroutineOwner)object0));
            }

            public final Object invoke(CoroutineOwner debugProbesImpl$CoroutineOwner0) {
                if(!DebugProbesImpl.INSTANCE.isFinished(debugProbesImpl$CoroutineOwner0)) {
                    CoroutineContext coroutineContext0 = debugProbesImpl$CoroutineOwner0.info.getContext();
                    return coroutineContext0 == null ? null : new DebuggerInfo(debugProbesImpl$CoroutineOwner0.info, coroutineContext0);
                }
                return null;
            }
        }

    }

    public final List enhanceStackTraceWithThreadDump(DebugCoroutineInfo debugCoroutineInfo0, List list0) {
        return this.enhanceStackTraceWithThreadDumpImpl(debugCoroutineInfo0.getState(), debugCoroutineInfo0.getLastObservedThread(), list0);
    }

    public final String enhanceStackTraceWithThreadDumpAsJson(DebugCoroutineInfo debugCoroutineInfo0) {
        List list0 = this.enhanceStackTraceWithThreadDump(debugCoroutineInfo0, debugCoroutineInfo0.lastObservedStackTrace());
        List list1 = new ArrayList();
        for(Object object0: list0) {
            String s = ((StackTraceElement)object0).getFileName();
            list1.add(StringsKt.trimIndent((UnityPlayerActivity.adjustValue("64504D414E414745524E504D414E4147450964504D414E414745524E504D414E414745524E504D430A040409131C1903062D0D0616014C4A4D43") + ((StackTraceElement)object0).getClassName() + UnityPlayerActivity.adjustValue("4C5C67414E414745524E504D414E414745524E504D414E430A0006061F092F0F0C0247484E52") + ((StackTraceElement)object0).getMethodName() + UnityPlayerActivity.adjustValue("4C5C67414E414745524E504D414E414745524E504D414E43010C1E0B3E0C0C0B435D45") + (s == null ? null : this.toStringWithQuotes(s)) + UnityPlayerActivity.adjustValue("427A4D414E414745524E504D414E414745524E504D414C0D0E0B17200500030B13455F52") + ((StackTraceElement)object0).getLineNumber() + UnityPlayerActivity.adjustValue("64504D414E414745524E504D414E4147450F64504D414E414745524E504D414E414745"))));
        }
        return UnityPlayerActivity.adjustValue("35") + CollectionsKt.joinToString$default(list1, null, null, null, 0, null, null, 0x3F, null) + ']';
    }

    private final List enhanceStackTraceWithThreadDumpImpl(String s, Thread thread0, List list0) {
        Object object0;
        if(Intrinsics.areEqual(s, UnityPlayerActivity.adjustValue("3C25232F272F20")) && thread0 != null) {
            try {
                object0 = Result.constructor-impl(thread0.getStackTrace());
            }
            catch(Throwable throwable0) {
                object0 = Result.constructor-impl(ResultKt.createFailure(throwable0));
            }
            if(Result.isFailure-impl(object0)) {
                object0 = null;
            }
            if(((StackTraceElement[])object0) == null) {
                return list0;
            }
            int v1;
            for(v1 = 0; true; ++v1) {
                if(v1 >= ((StackTraceElement[])object0).length) {
                    v1 = -1;
                    break;
                }
                StackTraceElement stackTraceElement0 = ((StackTraceElement[])object0)[v1];
                if(Intrinsics.areEqual(stackTraceElement0.getClassName(), UnityPlayerActivity.adjustValue("051F190D070F49061D1C1F1815070F02165C0406004F070F1300000011014F2C00140031011E1908001406111B011E240C1E0D")) && Intrinsics.areEqual(stackTraceElement0.getMethodName(), UnityPlayerActivity.adjustValue("1C151E140304300C0606")) && Intrinsics.areEqual(stackTraceElement0.getFileName(), UnityPlayerActivity.adjustValue("2D1F0315070F120406071F032803110B4B191A"))) {
                    break;
                }
            }
            Pair pair0 = this.findContinuationStartIndex(v1, ((StackTraceElement[])object0), list0);
            int v2 = ((Number)pair0.component1()).intValue();
            int v3 = ((Number)pair0.component2()).intValue();
            if(v2 == -1) {
                return list0;
            }
            ArrayList arrayList0 = new ArrayList(list0.size() + v1 - v2 - 1 - v3);
            for(int v = 0; v < v1 - v3; ++v) {
                arrayList0.add(((StackTraceElement[])object0)[v]);
            }
            int v4 = v2 + 1;
            int v5 = list0.size();
            while(v4 < v5) {
                arrayList0.add(list0.get(v4));
                ++v4;
            }
            return arrayList0;
        }
        return list0;
    }

    private final Pair findContinuationStartIndex(int v, StackTraceElement[] arr_stackTraceElement, List list0) {
        for(int v1 = 0; v1 < 3; ++v1) {
            int v2 = DebugProbesImpl.INSTANCE.findIndexOfFrame(v - 1 - v1, arr_stackTraceElement, list0);
            if(v2 != -1) {
                return TuplesKt.to(v2, v1);
            }
        }
        return TuplesKt.to(-1, 0);
    }

    private final int findIndexOfFrame(int v, StackTraceElement[] arr_stackTraceElement, List list0) {
        StackTraceElement stackTraceElement0 = (StackTraceElement)ArraysKt.getOrNull(arr_stackTraceElement, v);
        if(stackTraceElement0 == null) {
            return -1;
        }
        int v1 = 0;
        for(Object object0: list0) {
            StackTraceElement stackTraceElement1 = (StackTraceElement)object0;
            if(Intrinsics.areEqual(stackTraceElement1.getFileName(), stackTraceElement0.getFileName()) && Intrinsics.areEqual(stackTraceElement1.getClassName(), stackTraceElement0.getClassName()) && Intrinsics.areEqual(stackTraceElement1.getMethodName(), stackTraceElement0.getMethodName())) {
                return v1;
            }
            ++v1;
        }
        return -1;
    }

    private final Set getCapturedCoroutines() {
        return DebugProbesImpl.capturedCoroutinesMap.keySet();
    }

    // 去混淆评级： 低(20)
    private final String getDebugString(Job job0) {
        return job0 instanceof JobSupport ? ((JobSupport)job0).toDebugString() : job0.toString();
    }

    private static void getDebugString$annotations(Job job0) {
    }

    private final Function1 getDynamicAttach() {
        Object object1;
        try {
            Object object0 = Class.forName(UnityPlayerActivity.adjustValue("051F190D070F1F4B11010202141A08090001401408031B06490C1C1A151F0F0F0D49270B1A152F140A051E210B001100080D201311130D18")).getConstructors()[0].newInstance();
            if(object0 == null) {
                throw new NullPointerException(UnityPlayerActivity.adjustValue("0005010D4E02060B1C01044D030B410404011A50190E4E0F080B5F0005010D4E151E15174E1B02150208094B341B1E0E15070E09544E051F190D070F49271D011C0800004D470E1D1A1C040F4034090C0650"));
            }
            object1 = Result.constructor-impl(((Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity(object0, 1)));
        }
        catch(Throwable throwable0) {
            object1 = Result.constructor-impl(ResultKt.createFailure(throwable0));
        }
        if(Result.isFailure-impl(object1)) {
            object1 = null;
        }
        return (Function1)object1;
    }

    public final boolean getEnableCreationStackTraces() [...] // 潜在的解密器

    public final boolean getSanitizeStackTraces() {
        return DebugProbesImpl.sanitizeStackTraces;
    }

    public final String hierarchyToString(Job job0) {
        ReentrantReadWriteLock reentrantReadWriteLock0 = DebugProbesImpl.coroutineStateLock;
        ReentrantReadWriteLock.ReadLock reentrantReadWriteLock$ReadLock0 = reentrantReadWriteLock0.readLock();
        int v1 = reentrantReadWriteLock0.getWriteHoldCount() == 0 ? reentrantReadWriteLock0.getReadHoldCount() : 0;
        for(int v2 = 0; v2 < v1; ++v2) {
            reentrantReadWriteLock$ReadLock0.unlock();
        }
        ReentrantReadWriteLock.WriteLock reentrantReadWriteLock$WriteLock0 = reentrantReadWriteLock0.writeLock();
        reentrantReadWriteLock$WriteLock0.lock();
        try {
            throw new IllegalStateException(UnityPlayerActivity.adjustValue("2A150F14094117171D0C151E410F1302451C01044D08001213041E021509").toString());
        }
        catch(Throwable throwable0) {
            for(int v = 0; v < v1; ++v) {
                reentrantReadWriteLock$ReadLock0.lock();
            }
            reentrantReadWriteLock$WriteLock0.unlock();
            throw throwable0;
        }
    }

    public final void install() {
        ReentrantReadWriteLock reentrantReadWriteLock0 = DebugProbesImpl.coroutineStateLock;
        ReentrantReadWriteLock.ReadLock reentrantReadWriteLock$ReadLock0 = reentrantReadWriteLock0.readLock();
        int v1 = reentrantReadWriteLock0.getWriteHoldCount() == 0 ? reentrantReadWriteLock0.getReadHoldCount() : 0;
        for(int v2 = 0; v2 < v1; ++v2) {
            reentrantReadWriteLock$ReadLock0.unlock();
        }
        ReentrantReadWriteLock.WriteLock reentrantReadWriteLock$WriteLock0 = reentrantReadWriteLock0.writeLock();
        reentrantReadWriteLock$WriteLock0.lock();
        try {
            DebugProbesImpl.installations = 1;
            DebugProbesImpl.INSTANCE.startWeakRefCleanerThread();
            Function1 function10 = DebugProbesImpl.dynamicAttach;
            if(function10 != null) {
                function10.invoke(Boolean.TRUE);
            }
        }
        finally {
            for(int v = 0; v < v1; ++v) {
                reentrantReadWriteLock$ReadLock0.lock();
            }
            reentrantReadWriteLock$WriteLock0.unlock();
        }
    }

    private final boolean isFinished(CoroutineOwner debugProbesImpl$CoroutineOwner0) {
        CoroutineContext coroutineContext0 = debugProbesImpl$CoroutineOwner0.info.getContext();
        if(coroutineContext0 != null) {
            Job job0 = (Job)coroutineContext0.get(Job.Key);
            if(job0 == null || !job0.isCompleted()) {
                return false;
            }
            DebugProbesImpl.capturedCoroutinesMap.remove(debugProbesImpl$CoroutineOwner0);
            return true;
        }
        return false;
    }

    public final boolean isInstalled$kotlinx_coroutines_core() [...] // 潜在的解密器

    private final boolean isInternalMethod(StackTraceElement stackTraceElement0) {
        return StringsKt.startsWith$default(stackTraceElement0.getClassName(), UnityPlayerActivity.adjustValue("051F190D070F1F4B11010202141A08090001"), false, 2, null);
    }

    private final CoroutineOwner owner(Continuation continuation0) {
        CoroutineStackFrame coroutineStackFrame0 = continuation0 instanceof CoroutineStackFrame ? ((CoroutineStackFrame)continuation0) : null;
        return coroutineStackFrame0 == null ? null : this.owner(coroutineStackFrame0);
    }

    private final CoroutineOwner owner(CoroutineStackFrame coroutineStackFrame0) {
        do {
            if(coroutineStackFrame0 instanceof CoroutineOwner) {
                return (CoroutineOwner)coroutineStackFrame0;
            }
            coroutineStackFrame0 = coroutineStackFrame0.getCallerFrame();
        }
        while(coroutineStackFrame0 != null);
        return null;
    }

    private final void printStackTrace(PrintStream printStream0, List list0) {
        for(Object object0: list0) {
            printStream0.print(UnityPlayerActivity.adjustValue("64790C154E") + ((StackTraceElement)object0));
        }
    }

    private final void probeCoroutineCompleted(CoroutineOwner debugProbesImpl$CoroutineOwner0) {
        DebugProbesImpl.capturedCoroutinesMap.remove(debugProbesImpl$CoroutineOwner0);
        CoroutineStackFrame coroutineStackFrame0 = debugProbesImpl$CoroutineOwner0.info.getLastObservedFrame$kotlinx_coroutines_core();
        if(coroutineStackFrame0 != null) {
            CoroutineStackFrame coroutineStackFrame1 = this.realCaller(coroutineStackFrame0);
            if(coroutineStackFrame1 != null) {
                DebugProbesImpl.callerInfoCache.remove(coroutineStackFrame1);
            }
        }
    }

    // 去混淆评级： 中等(50)
    public final Continuation probeCoroutineCreated$kotlinx_coroutines_core(Continuation continuation0) {
        return continuation0;
    }

    public final void probeCoroutineResumed$kotlinx_coroutines_core(Continuation continuation0) {
        this.updateState(continuation0, UnityPlayerActivity.adjustValue("3C25232F272F20"));
    }

    public final void probeCoroutineSuspended$kotlinx_coroutines_core(Continuation continuation0) {
        this.updateState(continuation0, UnityPlayerActivity.adjustValue("3D253E312B2F232036"));
    }

    private final CoroutineStackFrame realCaller(CoroutineStackFrame coroutineStackFrame0) {
        do {
            coroutineStackFrame0 = coroutineStackFrame0.getCallerFrame();
            if(coroutineStackFrame0 == null) {
                return null;
            }
        }
        while(coroutineStackFrame0.getStackTraceElement() == null);
        return coroutineStackFrame0;
    }

    private final List sanitizeStackTrace(Throwable throwable0) {
        StackTraceElement[] arr_stackTraceElement = throwable0.getStackTrace();
        int v = -1;
        int v1 = arr_stackTraceElement.length - 1;
        if(v1 >= 0) {
            while(true) {
                if(Intrinsics.areEqual(arr_stackTraceElement[v1].getClassName(), UnityPlayerActivity.adjustValue("051F190D070F49061D1C1F1815070F02165C0406004F070F1300000011014F2A040510153E0202030B122C11"))) {
                    v = v1;
                    break;
                }
                if(v1 - 1 < 0) {
                    break;
                }
                --v1;
            }
        }
        boolean z = DebugProbesImpl.sanitizeStackTraces;
        String s = UnityPlayerActivity.adjustValue("2D1F1F0E1B150E0B174E131F040F150E0A1C4E0319000D0A1317130D15");
        if(!z) {
            int v2 = arr_stackTraceElement.length - v;
            ArrayList arrayList0 = new ArrayList(v2);
            for(int v3 = 0; v3 < v2; ++v3) {
                arrayList0.add((v3 == 0 ? StackTraceRecoveryKt.artificialFrame(s) : arr_stackTraceElement[v3 + v]));
            }
            return arrayList0;
        }
        ArrayList arrayList1 = new ArrayList(arr_stackTraceElement.length - v + 1);
        arrayList1.add(StackTraceRecoveryKt.artificialFrame(s));
    alab1:
        while(true) {
            ++v;
            while(true) {
                if(v >= arr_stackTraceElement.length) {
                    break alab1;
                }
                if(!this.isInternalMethod(arr_stackTraceElement[v])) {
                    arrayList1.add(arr_stackTraceElement[v]);
                    break;
                }
                arrayList1.add(arr_stackTraceElement[v]);
                int v4;
                for(v4 = v + 1; v4 < arr_stackTraceElement.length && this.isInternalMethod(arr_stackTraceElement[v4]); ++v4) {
                }
                int v5;
                for(v5 = v4 - 1; v5 > v && arr_stackTraceElement[v5].getFileName() == null; --v5) {
                }
                if(v5 > v && v5 < v4 - 1) {
                    arrayList1.add(arr_stackTraceElement[v5]);
                }
                arrayList1.add(arr_stackTraceElement[v4 - 1]);
                v = v4;
            }
        }
        return arrayList1;
    }

    public final void setEnableCreationStackTraces(boolean z) {
        DebugProbesImpl.enableCreationStackTraces = z;
    }

    public final void setSanitizeStackTraces(boolean z) {
        DebugProbesImpl.sanitizeStackTraces = z;
    }

    private final void startWeakRefCleanerThread() {
        DebugProbesImpl.weakRefCleanerThread = ThreadsKt.thread$default(false, true, null, UnityPlayerActivity.adjustValue("2D1F1F0E1B150E0B171D5029040C140002171C502E0D0B00090000"), 0, kotlinx.coroutines.debug.internal.DebugProbesImpl.startWeakRefCleanerThread.1.INSTANCE, 21, null);

        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 0x30)
        final class kotlinx.coroutines.debug.internal.DebugProbesImpl.startWeakRefCleanerThread.1 extends Lambda implements Function0 {
            public static final kotlinx.coroutines.debug.internal.DebugProbesImpl.startWeakRefCleanerThread.1 INSTANCE;

            static {
                kotlinx.coroutines.debug.internal.DebugProbesImpl.startWeakRefCleanerThread.1.INSTANCE = new kotlinx.coroutines.debug.internal.DebugProbesImpl.startWeakRefCleanerThread.1();
            }

            kotlinx.coroutines.debug.internal.DebugProbesImpl.startWeakRefCleanerThread.1() {
                super(0);
            }

            @Override  // kotlin.jvm.functions.Function0
            public Object invoke() {
                this.invoke();
                return Unit.INSTANCE;
            }

            public final void invoke() {
                DebugProbesImpl.callerInfoCache.runWeakRefQueueCleaningLoopUntilInterrupted();
            }
        }

    }

    private final void stopWeakRefCleanerThread() {
        Thread thread0 = DebugProbesImpl.weakRefCleanerThread;
        if(thread0 == null) {
            return;
        }
        DebugProbesImpl.weakRefCleanerThread = null;
        thread0.interrupt();
        thread0.join();
    }

    private final StackTraceFrame toStackTraceFrame(List list0) {
        StackTraceFrame stackTraceFrame0 = null;
        if(!list0.isEmpty()) {
            ListIterator listIterator0 = list0.listIterator(list0.size());
            while(listIterator0.hasPrevious()) {
                stackTraceFrame0 = new StackTraceFrame(stackTraceFrame0, ((StackTraceElement)listIterator0.previous()));
            }
        }
        return stackTraceFrame0;
    }

    private final String toStringWithQuotes(Object object0) {
        return UnityPlayerActivity.adjustValue("4C") + object0 + '\"';
    }

    public final void uninstall() {
        ReentrantReadWriteLock reentrantReadWriteLock0 = DebugProbesImpl.coroutineStateLock;
        ReentrantReadWriteLock.ReadLock reentrantReadWriteLock$ReadLock0 = reentrantReadWriteLock0.readLock();
        int v1 = reentrantReadWriteLock0.getWriteHoldCount() == 0 ? reentrantReadWriteLock0.getReadHoldCount() : 0;
        for(int v2 = 0; v2 < v1; ++v2) {
            reentrantReadWriteLock$ReadLock0.unlock();
        }
        ReentrantReadWriteLock.WriteLock reentrantReadWriteLock$WriteLock0 = reentrantReadWriteLock0.writeLock();
        reentrantReadWriteLock$WriteLock0.lock();
        try {
            throw new IllegalStateException(UnityPlayerActivity.adjustValue("2F17080F1A411004014E1E02154E080916060F1C01040A").toString());
        }
        catch(Throwable throwable0) {
            for(int v = 0; v < v1; ++v) {
                reentrantReadWriteLock$ReadLock0.lock();
            }
            reentrantReadWriteLock$WriteLock0.unlock();
            throw throwable0;
        }
    }

    private final void updateRunningState(CoroutineStackFrame coroutineStackFrame0, String s) {
        ReentrantReadWriteLock.ReadLock reentrantReadWriteLock$ReadLock0 = DebugProbesImpl.coroutineStateLock.readLock();
        reentrantReadWriteLock$ReadLock0.lock();
        reentrantReadWriteLock$ReadLock0.unlock();
    }

    // 去混淆评级： 中等(70)
    private final void updateState(Continuation continuation0, String s) {
    }

    private final void updateState(CoroutineOwner debugProbesImpl$CoroutineOwner0, Continuation continuation0, String s) {
        ReentrantReadWriteLock.ReadLock reentrantReadWriteLock$ReadLock0 = DebugProbesImpl.coroutineStateLock.readLock();
        reentrantReadWriteLock$ReadLock0.lock();
        reentrantReadWriteLock$ReadLock0.unlock();
    }
}

