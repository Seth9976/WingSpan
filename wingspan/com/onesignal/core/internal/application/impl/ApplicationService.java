package com.onesignal.core.internal.application.impl;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks;
import androidx.fragment.app.FragmentManager;
import com.onesignal.common.AndroidUtils;
import com.onesignal.common.DeviceUtils;
import com.onesignal.common.events.EventProducer;
import com.onesignal.common.threading.Waiter;
import com.onesignal.core.internal.application.ActivityLifecycleHandlerBase;
import com.onesignal.core.internal.application.AppEntryAction;
import com.onesignal.core.internal.application.IActivityLifecycleHandler;
import com.onesignal.core.internal.application.IApplicationLifecycleHandler;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.debug.internal.logging.Logging;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.DelayKt;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00A2\u0006\u0002\u0010\u0004J\u0010\u0010&\u001A\u00020\'2\u0006\u0010(\u001A\u00020\u000BH\u0016J\u0010\u0010)\u001A\u00020\'2\u0006\u0010(\u001A\u00020\u0012H\u0016J\u0016\u0010*\u001A\u00020\'2\u0006\u0010+\u001A\u00020\b2\u0006\u0010,\u001A\u00020-J\b\u0010.\u001A\u00020\'H\u0002J\b\u0010/\u001A\u00020\'H\u0002J\u001A\u00100\u001A\u00020\'2\u0006\u0010+\u001A\u00020\b2\b\u00101\u001A\u0004\u0018\u000102H\u0016J\u0010\u00103\u001A\u00020\'2\u0006\u0010+\u001A\u00020\bH\u0016J\u0010\u00104\u001A\u00020\'2\u0006\u0010+\u001A\u00020\bH\u0016J\u0010\u00105\u001A\u00020\'2\u0006\u0010+\u001A\u00020\bH\u0016J\u0018\u00106\u001A\u00020\'2\u0006\u00107\u001A\u00020\b2\u0006\u00108\u001A\u000202H\u0016J\u0010\u00109\u001A\u00020\'2\u0006\u0010+\u001A\u00020\bH\u0016J\u0010\u0010:\u001A\u00020\'2\u0006\u0010+\u001A\u00020\bH\u0016J\b\u0010;\u001A\u00020\'H\u0016J\u0018\u0010<\u001A\u00020\'2\u0006\u0010=\u001A\u00020\r2\u0006\u0010+\u001A\u00020\bH\u0002J\u0010\u0010>\u001A\u00020\'2\u0006\u0010(\u001A\u00020\u000BH\u0016J\u0010\u0010?\u001A\u00020\'2\u0006\u0010(\u001A\u00020\u0012H\u0016J\u000E\u0010@\u001A\u00020\'2\u0006\u0010A\u001A\u00020\u0006J\u0011\u0010B\u001A\u00020 H\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010CJ\u0011\u0010D\u001A\u00020 H\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010CR\u0010\u0010\u0005\u001A\u0004\u0018\u00010\u0006X\u0082\u000E\u00A2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001A\u0004\u0018\u00010\bX\u0082\u000E\u00A2\u0006\u0002\n\u0000R\u0014\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\nX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u000E\u00A2\u0006\u0002\n\u0000R\u0014\u0010\u000E\u001A\u00020\u00068VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010R\u0014\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00120\nX\u0082\u0004\u00A2\u0006\u0002\n\u0000R(\u0010\u0014\u001A\u0004\u0018\u00010\b2\b\u0010\u0013\u001A\u0004\u0018\u00010\b8V@VX\u0096\u000E\u00A2\u0006\f\u001A\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001A\u0010\u0019\u001A\u00020\u001AX\u0096\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u001B\u0010\u001C\"\u0004\b\u001D\u0010\u001ER\u000E\u0010\u001F\u001A\u00020 X\u0082\u000E\u00A2\u0006\u0002\n\u0000R\u0014\u0010!\u001A\u00020 8VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b!\u0010\"R\u000E\u0010#\u001A\u00020 X\u0082\u000E\u00A2\u0006\u0002\n\u0000R\u0014\u0010$\u001A\b\u0012\u0004\u0012\u00020%0\nX\u0082\u0004\u00A2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00A8\u0006E"}, d2 = {"Lcom/onesignal/core/internal/application/impl/ApplicationService;", "Lcom/onesignal/core/internal/application/IApplicationService;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "()V", "_appContext", "Landroid/content/Context;", "_current", "Landroid/app/Activity;", "activityLifecycleNotifier", "Lcom/onesignal/common/events/EventProducer;", "Lcom/onesignal/core/internal/application/IActivityLifecycleHandler;", "activityReferences", "", "appContext", "getAppContext", "()Landroid/content/Context;", "applicationLifecycleNotifier", "Lcom/onesignal/core/internal/application/IApplicationLifecycleHandler;", "value", "current", "getCurrent", "()Landroid/app/Activity;", "setCurrent", "(Landroid/app/Activity;)V", "entryState", "Lcom/onesignal/core/internal/application/AppEntryAction;", "getEntryState", "()Lcom/onesignal/core/internal/application/AppEntryAction;", "setEntryState", "(Lcom/onesignal/core/internal/application/AppEntryAction;)V", "isActivityChangingConfigurations", "", "isInForeground", "()Z", "nextResumeIsFirstActivity", "systemConditionNotifier", "Lcom/onesignal/core/internal/application/impl/ISystemConditionHandler;", "addActivityLifecycleHandler", "", "handler", "addApplicationLifecycleHandler", "decorViewReady", "activity", "runnable", "Ljava/lang/Runnable;", "handleFocus", "handleLostFocus", "onActivityCreated", "bundle", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "p0", "p1", "onActivityStarted", "onActivityStopped", "onGlobalLayout", "onOrientationChanged", "orientation", "removeActivityLifecycleHandler", "removeApplicationLifecycleHandler", "start", "context", "waitUntilActivityReady", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitUntilSystemConditionsAvailable", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class ApplicationService implements Application.ActivityLifecycleCallbacks, ViewTreeObserver.OnGlobalLayoutListener, IApplicationService {
    private Context _appContext;
    private Activity _current;
    private final EventProducer activityLifecycleNotifier;
    private int activityReferences;
    private final EventProducer applicationLifecycleNotifier;
    private AppEntryAction entryState;
    private boolean isActivityChangingConfigurations;
    private boolean nextResumeIsFirstActivity;
    private final EventProducer systemConditionNotifier;

    // 检测为 Lambda 实现
    public static void $r8$lambda$3_wFwGTTduupfuETXMbN0cB43h4(Waiter waiter0) [...]

    // 检测为 Lambda 实现
    public static void $r8$lambda$lnqbWsVqU7gDeXEkdraXukK_I5o(ApplicationService applicationService0, Runnable runnable0, ApplicationService applicationService1) [...]

    public ApplicationService() {
        this.activityLifecycleNotifier = new EventProducer();
        this.applicationLifecycleNotifier = new EventProducer();
        this.systemConditionNotifier = new EventProducer();
        this.entryState = AppEntryAction.APP_CLOSE;
    }

    @Override  // com.onesignal.core.internal.application.IApplicationService
    public void addActivityLifecycleHandler(IActivityLifecycleHandler iActivityLifecycleHandler0) {
        Intrinsics.checkNotNullParameter(iActivityLifecycleHandler0, "handler");
        this.activityLifecycleNotifier.subscribe(iActivityLifecycleHandler0);
        if(this.getCurrent() != null) {
            Activity activity0 = this.getCurrent();
            Intrinsics.checkNotNull(activity0);
            iActivityLifecycleHandler0.onActivityAvailable(activity0);
        }
    }

    @Override  // com.onesignal.core.internal.application.IApplicationService
    public void addApplicationLifecycleHandler(IApplicationLifecycleHandler iApplicationLifecycleHandler0) {
        Intrinsics.checkNotNullParameter(iApplicationLifecycleHandler0, "handler");
        this.applicationLifecycleNotifier.subscribe(iApplicationLifecycleHandler0);
    }

    public final void decorViewReady(Activity activity0, Runnable runnable0) {
        Intrinsics.checkNotNullParameter(activity0, "activity");
        Intrinsics.checkNotNullParameter(runnable0, "runnable");
        Objects.toString(runnable0);
        activity0.getWindow().getDecorView().post(() -> ApplicationService.decorViewReady$lambda-1(this, runnable0, this));
    }

    private static final void decorViewReady$lambda-1(ApplicationService applicationService0, Runnable runnable0, ApplicationService applicationService1) {
        Intrinsics.checkNotNullParameter(applicationService0, "$self");
        Intrinsics.checkNotNullParameter(runnable0, "$runnable");
        Intrinsics.checkNotNullParameter(applicationService1, "this$0");
        applicationService0.addActivityLifecycleHandler(new ActivityLifecycleHandlerBase() {
            @Override  // com.onesignal.core.internal.application.ActivityLifecycleHandlerBase
            public void onActivityAvailable(Activity activity0) {
                Intrinsics.checkNotNullParameter(activity0, "currentActivity");
                applicationService0.removeActivityLifecycleHandler(this);
                if(AndroidUtils.INSTANCE.isActivityFullyReady(activity0)) {
                    runnable0.run();
                    return;
                }
                applicationService1.decorViewReady(activity0, runnable0);
            }
        });
    }

    @Override  // com.onesignal.core.internal.application.IApplicationService
    public Context getAppContext() {
        Context context0 = this._appContext;
        Intrinsics.checkNotNull(context0);
        return context0;
    }

    @Override  // com.onesignal.core.internal.application.IApplicationService
    public Activity getCurrent() {
        return this._current;
    }

    @Override  // com.onesignal.core.internal.application.IApplicationService
    public AppEntryAction getEntryState() {
        return this.entryState;
    }

    private final void handleFocus() {
        if(this.isInForeground() && !this.nextResumeIsFirstActivity) {
            Logging.debug$default("ApplicationService.handleFocus: application never lost focus", null, 2, null);
            return;
        }
        Logging.debug$default(("ApplicationService.handleFocus: application is now in focus, nextResumeIsFirstActivity=" + this.nextResumeIsFirstActivity), null, 2, null);
        this.nextResumeIsFirstActivity = false;
        if(this.getEntryState() != AppEntryAction.NOTIFICATION_CLICK) {
            this.setEntryState(AppEntryAction.APP_OPEN);
        }
        this.applicationLifecycleNotifier.fire(com.onesignal.core.internal.application.impl.ApplicationService.handleFocus.1.INSTANCE);

        @Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/onesignal/core/internal/application/IApplicationLifecycleHandler;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.core.internal.application.impl.ApplicationService.handleFocus.1 extends Lambda implements Function1 {
            public static final com.onesignal.core.internal.application.impl.ApplicationService.handleFocus.1 INSTANCE;

            static {
                com.onesignal.core.internal.application.impl.ApplicationService.handleFocus.1.INSTANCE = new com.onesignal.core.internal.application.impl.ApplicationService.handleFocus.1();
            }

            com.onesignal.core.internal.application.impl.ApplicationService.handleFocus.1() {
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                this.invoke(((IApplicationLifecycleHandler)object0));
                return Unit.INSTANCE;
            }

            public final void invoke(IApplicationLifecycleHandler iApplicationLifecycleHandler0) {
                Intrinsics.checkNotNullParameter(iApplicationLifecycleHandler0, "it");
                iApplicationLifecycleHandler0.onFocus();
            }
        }

    }

    private final void handleLostFocus() {
        if(this.isInForeground()) {
            Logging.debug$default("ApplicationService.handleLostFocus: application is now out of focus", null, 2, null);
            this.setEntryState(AppEntryAction.APP_CLOSE);
            this.applicationLifecycleNotifier.fire(com.onesignal.core.internal.application.impl.ApplicationService.handleLostFocus.1.INSTANCE);
            return;
        }
        Logging.debug$default("ApplicationService.handleLostFocus: application already out of focus", null, 2, null);

        @Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/onesignal/core/internal/application/IApplicationLifecycleHandler;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.core.internal.application.impl.ApplicationService.handleLostFocus.1 extends Lambda implements Function1 {
            public static final com.onesignal.core.internal.application.impl.ApplicationService.handleLostFocus.1 INSTANCE;

            static {
                com.onesignal.core.internal.application.impl.ApplicationService.handleLostFocus.1.INSTANCE = new com.onesignal.core.internal.application.impl.ApplicationService.handleLostFocus.1();
            }

            com.onesignal.core.internal.application.impl.ApplicationService.handleLostFocus.1() {
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                this.invoke(((IApplicationLifecycleHandler)object0));
                return Unit.INSTANCE;
            }

            public final void invoke(IApplicationLifecycleHandler iApplicationLifecycleHandler0) {
                Intrinsics.checkNotNullParameter(iApplicationLifecycleHandler0, "it");
                iApplicationLifecycleHandler0.onUnfocused();
            }
        }

    }

    // 去混淆评级： 中等(60)
    @Override  // com.onesignal.core.internal.application.IApplicationService
    public boolean isInForeground() {
        return false;
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity0, Bundle bundle0) {
        Intrinsics.checkNotNullParameter(activity0, "activity");
        Logging.debug$default(("ApplicationService.onActivityCreated(" + this.activityReferences + ',' + this.getEntryState() + "): " + activity0), null, 2, null);
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity0) {
        Intrinsics.checkNotNullParameter(activity0, "activity");
        Logging.debug$default(("ApplicationService.onActivityDestroyed(" + this.activityReferences + ',' + this.getEntryState() + "): " + activity0), null, 2, null);
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity0) {
        Intrinsics.checkNotNullParameter(activity0, "activity");
        Logging.debug$default(("ApplicationService.onActivityPaused(" + this.activityReferences + ',' + this.getEntryState() + "): " + activity0), null, 2, null);
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity0) {
        Intrinsics.checkNotNullParameter(activity0, "activity");
        Logging.debug$default(("ApplicationService.onActivityResumed(" + this.activityReferences + ',' + this.getEntryState() + "): " + activity0), null, 2, null);
        if(!Intrinsics.areEqual(this.getCurrent(), activity0)) {
            this.setCurrent(activity0);
        }
        if((!this.isInForeground() || this.nextResumeIsFirstActivity) && !this.isActivityChangingConfigurations) {
            this.activityReferences = 1;
            this.handleFocus();
        }
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity0, Bundle bundle0) {
        Intrinsics.checkNotNullParameter(activity0, "p0");
        Intrinsics.checkNotNullParameter(bundle0, "p1");
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity0) {
        Intrinsics.checkNotNullParameter(activity0, "activity");
        Logging.debug$default(("ApplicationService.onActivityStarted(" + this.activityReferences + ',' + this.getEntryState() + "): " + activity0), null, 2, null);
        if(Intrinsics.areEqual(this.getCurrent(), activity0)) {
            return;
        }
        this.setCurrent(activity0);
        if((!this.isInForeground() || this.nextResumeIsFirstActivity) && !this.isActivityChangingConfigurations) {
            this.activityReferences = 1;
            this.handleFocus();
            return;
        }
        ++this.activityReferences;
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity0) {
        Intrinsics.checkNotNullParameter(activity0, "activity");
        Logging.debug$default(("ApplicationService.onActivityStopped(" + this.activityReferences + ',' + this.getEntryState() + "): " + activity0), null, 2, null);
        boolean z = activity0.isChangingConfigurations();
        this.isActivityChangingConfigurations = z;
        if(!z) {
            int v = this.activityReferences - 1;
            this.activityReferences = v;
            if(v <= 0) {
                this.setCurrent(null);
                this.activityReferences = 0;
                this.handleLostFocus();
            }
        }
        Function1 function10 = new Function1() {
            final Activity $activity;

            {
                this.$activity = activity0;
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                this.invoke(((IActivityLifecycleHandler)object0));
                return Unit.INSTANCE;
            }

            public final void invoke(IActivityLifecycleHandler iActivityLifecycleHandler0) {
                Intrinsics.checkNotNullParameter(iActivityLifecycleHandler0, "it");
                iActivityLifecycleHandler0.onActivityStopped(this.$activity);
            }
        };
        this.activityLifecycleNotifier.fire(function10);
    }

    @Override  // android.view.ViewTreeObserver$OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.systemConditionNotifier.fire(com.onesignal.core.internal.application.impl.ApplicationService.onGlobalLayout.1.INSTANCE);

        @Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/onesignal/core/internal/application/impl/ISystemConditionHandler;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.core.internal.application.impl.ApplicationService.onGlobalLayout.1 extends Lambda implements Function1 {
            public static final com.onesignal.core.internal.application.impl.ApplicationService.onGlobalLayout.1 INSTANCE;

            static {
                com.onesignal.core.internal.application.impl.ApplicationService.onGlobalLayout.1.INSTANCE = new com.onesignal.core.internal.application.impl.ApplicationService.onGlobalLayout.1();
            }

            com.onesignal.core.internal.application.impl.ApplicationService.onGlobalLayout.1() {
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                this.invoke(((ISystemConditionHandler)object0));
                return Unit.INSTANCE;
            }

            public final void invoke(ISystemConditionHandler iSystemConditionHandler0) {
                Intrinsics.checkNotNullParameter(iSystemConditionHandler0, "it");
                iSystemConditionHandler0.systemConditionChanged();
            }
        }

    }

    private final void onOrientationChanged(int v, Activity activity0) {
        switch(v) {
            case 1: {
                Logging.debug$default(("ApplicationService.onOrientationChanged: Configuration Orientation Change: PORTRAIT (" + 1 + ") on activity: " + activity0), null, 2, null);
                break;
            }
            case 2: {
                Logging.debug$default(("ApplicationService.onOrientationChanged: Configuration Orientation Change: LANDSCAPE (" + 2 + ") on activity: " + activity0), null, 2, null);
            }
        }
        this.handleLostFocus();
        Function1 function10 = new Function1() {
            final Activity $activity;

            {
                this.$activity = activity0;
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                this.invoke(((IActivityLifecycleHandler)object0));
                return Unit.INSTANCE;
            }

            public final void invoke(IActivityLifecycleHandler iActivityLifecycleHandler0) {
                Intrinsics.checkNotNullParameter(iActivityLifecycleHandler0, "it");
                iActivityLifecycleHandler0.onActivityStopped(this.$activity);
            }
        };
        this.activityLifecycleNotifier.fire(function10);
        Function1 function11 = new Function1() {
            final Activity $activity;

            {
                this.$activity = activity0;
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                this.invoke(((IActivityLifecycleHandler)object0));
                return Unit.INSTANCE;
            }

            public final void invoke(IActivityLifecycleHandler iActivityLifecycleHandler0) {
                Intrinsics.checkNotNullParameter(iActivityLifecycleHandler0, "it");
                iActivityLifecycleHandler0.onActivityAvailable(this.$activity);
            }
        };
        this.activityLifecycleNotifier.fire(function11);
        activity0.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.handleFocus();
    }

    @Override  // com.onesignal.core.internal.application.IApplicationService
    public void removeActivityLifecycleHandler(IActivityLifecycleHandler iActivityLifecycleHandler0) {
        Intrinsics.checkNotNullParameter(iActivityLifecycleHandler0, "handler");
        this.activityLifecycleNotifier.unsubscribe(iActivityLifecycleHandler0);
    }

    @Override  // com.onesignal.core.internal.application.IApplicationService
    public void removeApplicationLifecycleHandler(IApplicationLifecycleHandler iApplicationLifecycleHandler0) {
        Intrinsics.checkNotNullParameter(iApplicationLifecycleHandler0, "handler");
        this.applicationLifecycleNotifier.unsubscribe(iApplicationLifecycleHandler0);
    }

    public void setCurrent(Activity activity0) {
        this._current = activity0;
        Logging.debug$default(("ApplicationService: current activity=" + this.getCurrent()), null, 2, null);
        if(activity0 != null) {
            Function1 function10 = new Function1() {
                final Activity $value;

                {
                    this.$value = activity0;
                    super(1);
                }

                @Override  // kotlin.jvm.functions.Function1
                public Object invoke(Object object0) {
                    this.invoke(((IActivityLifecycleHandler)object0));
                    return Unit.INSTANCE;
                }

                public final void invoke(IActivityLifecycleHandler iActivityLifecycleHandler0) {
                    Intrinsics.checkNotNullParameter(iActivityLifecycleHandler0, "it");
                    iActivityLifecycleHandler0.onActivityAvailable(this.$value);
                }
            };
            this.activityLifecycleNotifier.fire(function10);
            try {
                activity0.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this);
            }
            catch(RuntimeException runtimeException0) {
                runtimeException0.printStackTrace();
            }
        }
    }

    @Override  // com.onesignal.core.internal.application.IApplicationService
    public void setEntryState(AppEntryAction appEntryAction0) {
        Intrinsics.checkNotNullParameter(appEntryAction0, "<set-?>");
        this.entryState = appEntryAction0;
    }

    public final void start(Context context0) {
        Intrinsics.checkNotNullParameter(context0, "context");
        this._appContext = context0;
        Context context1 = context0.getApplicationContext();
        Intrinsics.checkNotNull(context1, "null cannot be cast to non-null type android.app.Application");
        ((Application)context1).registerActivityLifecycleCallbacks(this);
        ((Application)context1).registerComponentCallbacks(new ComponentCallbacks() {
            @Override  // android.content.ComponentCallbacks
            public void onConfigurationChanged(Configuration configuration0) {
                Intrinsics.checkNotNullParameter(configuration0, "newConfig");
                if(ApplicationService.this.getCurrent() != null) {
                    Activity activity0 = ApplicationService.this.getCurrent();
                    Intrinsics.checkNotNull(activity0);
                    if(AndroidUtils.INSTANCE.hasConfigChangeFlag(activity0, 0x80)) {
                        int v = configuration0.orientation;
                        Activity activity1 = ApplicationService.this.getCurrent();
                        Intrinsics.checkNotNull(activity1);
                        ApplicationService.this.onOrientationChanged(v, activity1);
                    }
                }
            }

            @Override  // android.content.ComponentCallbacks
            public void onLowMemory() {
            }
        });
        boolean z = this.getCurrent() == null;
        if(!z || context0 instanceof Activity) {
            this.setEntryState(AppEntryAction.APP_OPEN);
            if(z && context0 instanceof Activity) {
                this.setCurrent(((Activity)context0));
                this.activityReferences = 1;
                this.nextResumeIsFirstActivity = false;
            }
        }
        else {
            this.nextResumeIsFirstActivity = true;
            this.setEntryState(AppEntryAction.APP_CLOSE);
        }
        Logging.debug$default(("ApplicationService.init: entryState=" + this.getEntryState()), null, 2, null);
    }

    @Override  // com.onesignal.core.internal.application.IApplicationService
    public Object waitUntilActivityReady(Continuation continuation0) {
        com.onesignal.core.internal.application.impl.ApplicationService.waitUntilActivityReady.1 applicationService$waitUntilActivityReady$10;
        if(continuation0 instanceof com.onesignal.core.internal.application.impl.ApplicationService.waitUntilActivityReady.1) {
            applicationService$waitUntilActivityReady$10 = (com.onesignal.core.internal.application.impl.ApplicationService.waitUntilActivityReady.1)continuation0;
            if((applicationService$waitUntilActivityReady$10.label & 0x80000000) == 0) {
                applicationService$waitUntilActivityReady$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.waitUntilActivityReady(this);
                    }
                };
            }
            else {
                applicationService$waitUntilActivityReady$10.label ^= 0x80000000;
            }
        }
        else {
            applicationService$waitUntilActivityReady$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.waitUntilActivityReady(this);
                }
            };
        }
        Object object0 = applicationService$waitUntilActivityReady$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(applicationService$waitUntilActivityReady$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                Activity activity0 = this.getCurrent();
                if(activity0 == null) {
                    return Boxing.boxBoolean(false);
                }
                Waiter waiter0 = new Waiter();
                this.decorViewReady(activity0, () -> ApplicationService.waitUntilActivityReady$lambda-0(waiter0));
                applicationService$waitUntilActivityReady$10.label = 1;
                return waiter0.waitForWake(applicationService$waitUntilActivityReady$10) == object1 ? object1 : Boxing.boxBoolean(true);
            }
            case 1: {
                ResultKt.throwOnFailure(object0);
                return Boxing.boxBoolean(true);
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    private static final void waitUntilActivityReady$lambda-0(Waiter waiter0) {
        Intrinsics.checkNotNullParameter(waiter0, "$waiter");
        waiter0.wake();
    }

    @Override  // com.onesignal.core.internal.application.IApplicationService
    public Object waitUntilSystemConditionsAvailable(Continuation continuation0) {
        com.onesignal.core.internal.application.impl.ApplicationService.waitUntilSystemConditionsAvailable.systemConditionHandler.1 applicationService$waitUntilSystemConditionsAvailable$systemConditionHandler$11;
        com.onesignal.core.internal.application.impl.ApplicationService.waitUntilSystemConditionsAvailable.systemConditionHandler.1 applicationService$waitUntilSystemConditionsAvailable$systemConditionHandler$10;
        ApplicationService applicationService1;
        ApplicationService applicationService2;
        com.onesignal.core.internal.application.impl.ApplicationService.waitUntilSystemConditionsAvailable.1 applicationService$waitUntilSystemConditionsAvailable$11;
        int v;
        Activity activity0;
        ApplicationService applicationService0;
        com.onesignal.core.internal.application.impl.ApplicationService.waitUntilSystemConditionsAvailable.1 applicationService$waitUntilSystemConditionsAvailable$10;
        if(continuation0 instanceof com.onesignal.core.internal.application.impl.ApplicationService.waitUntilSystemConditionsAvailable.1) {
            applicationService$waitUntilSystemConditionsAvailable$10 = (com.onesignal.core.internal.application.impl.ApplicationService.waitUntilSystemConditionsAvailable.1)continuation0;
            if((applicationService$waitUntilSystemConditionsAvailable$10.label & 0x80000000) == 0) {
                applicationService$waitUntilSystemConditionsAvailable$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.waitUntilSystemConditionsAvailable(this);
                    }
                };
            }
            else {
                applicationService$waitUntilSystemConditionsAvailable$10.label ^= 0x80000000;
            }
        }
        else {
            applicationService$waitUntilSystemConditionsAvailable$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                int I$0;
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.waitUntilSystemConditionsAvailable(this);
                }
            };
        }
        Object object0 = applicationService$waitUntilSystemConditionsAvailable$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(applicationService$waitUntilSystemConditionsAvailable$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                applicationService0 = this;
                activity0 = this.getCurrent();
                v = AndroidUtils.INSTANCE.isRunningOnMainThread() ? 50 : 0;
                goto label_22;
            }
            case 1: {
                int v1 = applicationService$waitUntilSystemConditionsAvailable$10.I$0;
                applicationService0 = (ApplicationService)applicationService$waitUntilSystemConditionsAvailable$10.L$0;
                ResultKt.throwOnFailure(object0);
                while(true) {
                    v = v1;
                    activity0 = applicationService0.getCurrent();
                label_22:
                    if(activity0 != null) {
                        break;
                    }
                    v1 = v + 1;
                    if(v1 > 50) {
                        Logging.warn$default("ApplicationService.waitUntilSystemConditionsAvailable: current is null", null, 2, null);
                        return Boxing.boxBoolean(false);
                    }
                    applicationService$waitUntilSystemConditionsAvailable$10.L$0 = applicationService0;
                    applicationService$waitUntilSystemConditionsAvailable$10.I$0 = v1;
                    applicationService$waitUntilSystemConditionsAvailable$10.label = 1;
                    if(DelayKt.delay(100L, applicationService$waitUntilSystemConditionsAvailable$10) != object1) {
                        continue;
                    }
                    return object1;
                }
                try {
                    if(activity0 instanceof AppCompatActivity) {
                        FragmentManager fragmentManager0 = ((AppCompatActivity)activity0).getSupportFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(fragmentManager0, "currentActivity.supportFragmentManager");
                        List list0 = fragmentManager0.getFragments();
                        Intrinsics.checkNotNullExpressionValue(list0, "manager.fragments");
                        Fragment fragment0 = (Fragment)CollectionsKt.lastOrNull(list0);
                        if(fragment0 == null || !fragment0.isVisible() || !(fragment0 instanceof DialogFragment)) {
                            applicationService$waitUntilSystemConditionsAvailable$11 = applicationService$waitUntilSystemConditionsAvailable$10;
                            applicationService2 = applicationService0;
                        }
                        else {
                            Waiter waiter0 = new Waiter();
                            fragmentManager0.registerFragmentLifecycleCallbacks(new FragmentLifecycleCallbacks() {
                                @Override  // androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks
                                public void onFragmentDetached(FragmentManager fragmentManager0, Fragment fragment0) {
                                    Intrinsics.checkNotNullParameter(fragmentManager0, "fm");
                                    Intrinsics.checkNotNullParameter(fragment0, "fragmentDetached");
                                    super.onFragmentDetached(fragmentManager0, fragment0);
                                    if(fragment0 instanceof DialogFragment) {
                                        waiter0.unregisterFragmentLifecycleCallbacks(this);
                                        this.$waiter.wake();
                                    }
                                }
                            }, true);
                            applicationService$waitUntilSystemConditionsAvailable$10.L$0 = applicationService0;
                            applicationService$waitUntilSystemConditionsAvailable$10.L$1 = activity0;
                            applicationService$waitUntilSystemConditionsAvailable$10.label = 2;
                            if(waiter0.waitForWake(applicationService$waitUntilSystemConditionsAvailable$10) == object1) {
                                return object1;
                            }
                            applicationService1 = applicationService0;
                            goto label_63;
                        }
                    }
                    else {
                        applicationService$waitUntilSystemConditionsAvailable$11 = applicationService$waitUntilSystemConditionsAvailable$10;
                        applicationService2 = applicationService0;
                    }
                    goto label_65;
                }
                catch(NoClassDefFoundError noClassDefFoundError0) {
                    applicationService1 = applicationService0;
                    goto label_62;
                }
            }
            case 2: {
                activity0 = (Activity)applicationService$waitUntilSystemConditionsAvailable$10.L$1;
                applicationService1 = (ApplicationService)applicationService$waitUntilSystemConditionsAvailable$10.L$0;
                try {
                    ResultKt.throwOnFailure(object0);
                    goto label_63;
                }
                catch(NoClassDefFoundError noClassDefFoundError0) {
                }
            label_62:
                Logging.info$default(("ApplicationService.waitUntilSystemConditionsAvailable: AppCompatActivity is not used in this app, skipping \'isDialogFragmentShowing\' check: " + noClassDefFoundError0), null, 2, null);
            label_63:
                applicationService$waitUntilSystemConditionsAvailable$11 = applicationService$waitUntilSystemConditionsAvailable$10;
                applicationService2 = applicationService1;
            label_65:
                Waiter waiter1 = new Waiter();
                applicationService$waitUntilSystemConditionsAvailable$systemConditionHandler$10 = new ISystemConditionHandler() {
                    @Override  // com.onesignal.core.internal.application.impl.ISystemConditionHandler
                    public void systemConditionChanged() {
                        WeakReference weakReference0 = new WeakReference(waiter1.getCurrent());
                        if(!DeviceUtils.INSTANCE.isKeyboardUp(weakReference0)) {
                            this.$waiter.wake();
                        }
                    }
                };
                applicationService2.systemConditionNotifier.subscribe(applicationService$waitUntilSystemConditionsAvailable$systemConditionHandler$10);
                WeakReference weakReference0 = new WeakReference(activity0);
                if(DeviceUtils.INSTANCE.isKeyboardUp(weakReference0)) {
                    Logging.warn$default("ApplicationService.waitUntilSystemConditionsAvailable: keyboard up detected", null, 2, null);
                    applicationService$waitUntilSystemConditionsAvailable$11.L$0 = applicationService2;
                    applicationService$waitUntilSystemConditionsAvailable$11.L$1 = applicationService$waitUntilSystemConditionsAvailable$systemConditionHandler$10;
                    applicationService$waitUntilSystemConditionsAvailable$11.label = 3;
                    if(waiter1.waitForWake(applicationService$waitUntilSystemConditionsAvailable$11) == object1) {
                        return object1;
                    }
                    applicationService$waitUntilSystemConditionsAvailable$systemConditionHandler$11 = applicationService$waitUntilSystemConditionsAvailable$systemConditionHandler$10;
                    applicationService$waitUntilSystemConditionsAvailable$systemConditionHandler$10 = applicationService$waitUntilSystemConditionsAvailable$systemConditionHandler$11;
                    applicationService2.systemConditionNotifier.unsubscribe(applicationService$waitUntilSystemConditionsAvailable$systemConditionHandler$10);
                    return Boxing.boxBoolean(true);
                }
                applicationService2.systemConditionNotifier.unsubscribe(applicationService$waitUntilSystemConditionsAvailable$systemConditionHandler$10);
                return Boxing.boxBoolean(true);
            }
            case 3: {
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        applicationService$waitUntilSystemConditionsAvailable$systemConditionHandler$11 = (com.onesignal.core.internal.application.impl.ApplicationService.waitUntilSystemConditionsAvailable.systemConditionHandler.1)applicationService$waitUntilSystemConditionsAvailable$10.L$1;
        applicationService2 = (ApplicationService)applicationService$waitUntilSystemConditionsAvailable$10.L$0;
        ResultKt.throwOnFailure(object0);
        applicationService$waitUntilSystemConditionsAvailable$systemConditionHandler$10 = applicationService$waitUntilSystemConditionsAvailable$systemConditionHandler$11;
        applicationService2.systemConditionNotifier.unsubscribe(applicationService$waitUntilSystemConditionsAvailable$systemConditionHandler$10);
        return Boxing.boxBoolean(true);
    }
}

