package com.onesignal.common.threading;

import com.onesignal.debug.internal.logging.Logging;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.concurrent.ThreadsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\u001A,\u0010\u0000\u001A\u00020\u00012\u001C\u0010\u0002\u001A\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001A,\u0010\u0007\u001A\u00020\u00012\u001C\u0010\u0002\u001A\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001A6\u0010\b\u001A\u00020\u00012\b\b\u0002\u0010\t\u001A\u00020\n2\u001C\u0010\u0002\u001A\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u000B\u001A>\u0010\b\u001A\u00020\u00012\u0006\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\t\u001A\u00020\n2\u001C\u0010\u0002\u001A\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u000E\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000F"}, d2 = {"suspendifyBlocking", "", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;)V", "suspendifyOnMain", "suspendifyOnThread", "priority", "", "(ILkotlin/jvm/functions/Function1;)V", "name", "", "(Ljava/lang/String;ILkotlin/jvm/functions/Function1;)V", "com.onesignal.core"}, k = 2, mv = {1, 7, 1}, xi = 0x30)
public final class ThreadUtilsKt {
    public static final void suspendifyBlocking(Function1 function10) {
        Intrinsics.checkNotNullParameter(function10, "block");
        BuildersKt.runBlocking$default(null, new Function2(function10, null) {
            final Function1 $block;
            int label;

            {
                this.$block = function10;
                super(2, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.onesignal.common.threading.ThreadUtilsKt.suspendifyBlocking.1(this.$block, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function2
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.onesignal.common.threading.ThreadUtilsKt.suspendifyBlocking.1)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        this.label = 1;
                        return this.$block.invoke(this) == object1 ? object1 : Unit.INSTANCE;
                    }
                    case 1: {
                        ResultKt.throwOnFailure(object0);
                        return Unit.INSTANCE;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 1, null);
    }

    public static final void suspendifyOnMain(Function1 function10) {
        Intrinsics.checkNotNullParameter(function10, "block");
        ThreadsKt.thread$default(false, false, null, null, 0, new Function0(function10) {
            final Function1 $block;

            {
                this.$block = function10;
                super(0);
            }

            @Override  // kotlin.jvm.functions.Function0
            public Object invoke() {
                this.invoke();
                return Unit.INSTANCE;
            }

            public final void invoke() {
                try {
                    BuildersKt.runBlocking$default(null, new Function2(null) {
                        final Function1 $block;
                        int label;

                        {
                            this.$block = function10;
                            super(2, continuation0);
                        }

                        @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.onesignal.common.threading.ThreadUtilsKt.suspendifyOnMain.1.1(this.$block, continuation0);
                        }

                        @Override  // kotlin.jvm.functions.Function2
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.onesignal.common.threading.ThreadUtilsKt.suspendifyOnMain.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object object0) {
                            Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch(this.label) {
                                case 0: {
                                    ResultKt.throwOnFailure(object0);
                                    com.onesignal.common.threading.ThreadUtilsKt.suspendifyOnMain.1.1.1 threadUtilsKt$suspendifyOnMain$1$1$10 = new Function2(null) {
                                        final Function1 $block;
                                        int label;

                                        {
                                            this.$block = function10;
                                            super(2, continuation0);
                                        }

                                        @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Continuation create(Object object0, Continuation continuation0) {
                                            return new com.onesignal.common.threading.ThreadUtilsKt.suspendifyOnMain.1.1.1(this.$block, continuation0);
                                        }

                                        @Override  // kotlin.jvm.functions.Function2
                                        public Object invoke(Object object0, Object object1) {
                                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                        }

                                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                            return ((com.onesignal.common.threading.ThreadUtilsKt.suspendifyOnMain.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
                                        }

                                        @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Object invokeSuspend(Object object0) {
                                            Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            switch(this.label) {
                                                case 0: {
                                                    ResultKt.throwOnFailure(object0);
                                                    this.label = 1;
                                                    return this.$block.invoke(this) == object1 ? object1 : Unit.INSTANCE;
                                                }
                                                case 1: {
                                                    ResultKt.throwOnFailure(object0);
                                                    return Unit.INSTANCE;
                                                }
                                                default: {
                                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                }
                                            }
                                        }
                                    };
                                    this.label = 1;
                                    return BuildersKt.withContext(Dispatchers.getMain(), threadUtilsKt$suspendifyOnMain$1$1$10, this) == object1 ? object1 : Unit.INSTANCE;
                                }
                                case 1: {
                                    ResultKt.throwOnFailure(object0);
                                    return Unit.INSTANCE;
                                }
                                default: {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                            }
                        }
                    }, 1, null);
                }
                catch(Exception exception0) {
                    Logging.error("Exception on thread with switch to main", exception0);
                }
            }
        }, 0x1F, null);
    }

    public static final void suspendifyOnThread(int v, Function1 function10) {
        Intrinsics.checkNotNullParameter(function10, "block");
        ThreadsKt.thread$default(false, false, null, null, v, new Function0(function10) {
            final Function1 $block;

            {
                this.$block = function10;
                super(0);
            }

            @Override  // kotlin.jvm.functions.Function0
            public Object invoke() {
                this.invoke();
                return Unit.INSTANCE;
            }

            public final void invoke() {
                try {
                    BuildersKt.runBlocking$default(null, new Function2(null) {
                        final Function1 $block;
                        int label;

                        {
                            this.$block = function10;
                            super(2, continuation0);
                        }

                        @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.onesignal.common.threading.ThreadUtilsKt.suspendifyOnThread.1.1(this.$block, continuation0);
                        }

                        @Override  // kotlin.jvm.functions.Function2
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.onesignal.common.threading.ThreadUtilsKt.suspendifyOnThread.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object object0) {
                            Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch(this.label) {
                                case 0: {
                                    ResultKt.throwOnFailure(object0);
                                    this.label = 1;
                                    return this.$block.invoke(this) == object1 ? object1 : Unit.INSTANCE;
                                }
                                case 1: {
                                    ResultKt.throwOnFailure(object0);
                                    return Unit.INSTANCE;
                                }
                                default: {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                            }
                        }
                    }, 1, null);
                }
                catch(Exception exception0) {
                    Logging.error("Exception on thread", exception0);
                }
            }
        }, 15, null);
    }

    public static final void suspendifyOnThread(String s, int v, Function1 function10) {
        Intrinsics.checkNotNullParameter(s, "name");
        Intrinsics.checkNotNullParameter(function10, "block");
        ThreadsKt.thread$default(false, false, null, s, v, new Function0(s, function10) {
            final Function1 $block;
            final String $name;

            {
                this.$name = s;
                this.$block = function10;
                super(0);
            }

            @Override  // kotlin.jvm.functions.Function0
            public Object invoke() {
                this.invoke();
                return Unit.INSTANCE;
            }

            public final void invoke() {
                try {
                    BuildersKt.runBlocking$default(null, new Function2(null) {
                        final Function1 $block;
                        int label;

                        {
                            this.$block = function10;
                            super(2, continuation0);
                        }

                        @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.onesignal.common.threading.ThreadUtilsKt.suspendifyOnThread.2.1(this.$block, continuation0);
                        }

                        @Override  // kotlin.jvm.functions.Function2
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.onesignal.common.threading.ThreadUtilsKt.suspendifyOnThread.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object object0) {
                            Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch(this.label) {
                                case 0: {
                                    ResultKt.throwOnFailure(object0);
                                    this.label = 1;
                                    return this.$block.invoke(this) == object1 ? object1 : Unit.INSTANCE;
                                }
                                case 1: {
                                    ResultKt.throwOnFailure(object0);
                                    return Unit.INSTANCE;
                                }
                                default: {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                            }
                        }
                    }, 1, null);
                }
                catch(Exception exception0) {
                    Logging.error(("Exception on thread \'" + this.$name + '\''), exception0);
                }
            }
        }, 7, null);
    }

    public static void suspendifyOnThread$default(int v, Function1 function10, int v1, Object object0) {
        if((v1 & 1) != 0) {
            v = -1;
        }
        ThreadUtilsKt.suspendifyOnThread(v, function10);
    }

    public static void suspendifyOnThread$default(String s, int v, Function1 function10, int v1, Object object0) {
        if((v1 & 2) != 0) {
            v = -1;
        }
        ThreadUtilsKt.suspendifyOnThread(s, v, function10);
    }
}

