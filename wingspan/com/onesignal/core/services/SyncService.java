package com.onesignal.core.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.onesignal.OneSignal;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.internal.background.IBackgroundManager;
import com.onesignal.debug.internal.logging.Logging;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0016J \u0010\u0007\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\bH\u0016¨\u0006\u000B"}, d2 = {"Lcom/onesignal/core/services/SyncService;", "Landroid/app/Service;", "()V", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onStartCommand", "", "flags", "startId", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class SyncService extends Service {
    @Override  // android.app.Service
    public IBinder onBind(Intent intent0) {
        Intrinsics.checkNotNullParameter(intent0, "intent");
        return null;
    }

    @Override  // android.app.Service
    public int onStartCommand(Intent intent0, int v, int v1) {
        Intrinsics.checkNotNullParameter(intent0, "intent");
        if(!OneSignal.initWithContext(this)) {
            return 1;
        }
        ObjectRef ref$ObjectRef0 = new ObjectRef();
        ref$ObjectRef0.element = OneSignal.INSTANCE.getServices().getService(IBackgroundManager.class);
        ThreadUtilsKt.suspendifyOnThread$default(0, new Function1(this, null) {
            final ObjectRef $backgroundService;
            int label;

            {
                this.$backgroundService = ref$ObjectRef0;
                SyncService.this = syncService0;
                super(1, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation0) {
                return new com.onesignal.core.services.SyncService.onStartCommand.1(this.$backgroundService, SyncService.this, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((Continuation)object0));
            }

            public final Object invoke(Continuation continuation0) {
                return ((com.onesignal.core.services.SyncService.onStartCommand.1)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        this.label = 1;
                        if(((IBackgroundManager)this.$backgroundService.element).runBackgroundServices(this) == object1) {
                            return object1;
                        }
                        break;
                    }
                    case 1: {
                        ResultKt.throwOnFailure(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                Logging.debug$default("LegacySyncRunnable:Stopped", null, 2, null);
                SyncService.this.stopSelf();
                return Unit.INSTANCE;
            }
        }, 1, null);
        return 1;
    }
}

