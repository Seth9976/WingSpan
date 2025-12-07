package com.onesignal.inAppMessages.internal.lifecycle.impl;

import com.onesignal.common.events.EventProducer;
import com.onesignal.inAppMessages.internal.InAppMessage;
import com.onesignal.inAppMessages.internal.InAppMessageClickResult;
import com.onesignal.inAppMessages.internal.InAppMessagePage;
import com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleEventHandler;
import com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\nH\u0016J\u0018\u0010\u000B\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\nH\u0016J\u0018\u0010\f\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\r\u001A\u00020\u000EH\u0016J\u0010\u0010\u000F\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0016J\u0010\u0010\u0010\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0016J\u0010\u0010\u0011\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0016J\u0010\u0010\u0012\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0016¨\u0006\u0013"}, d2 = {"Lcom/onesignal/inAppMessages/internal/lifecycle/impl/IAMLifecycleService;", "Lcom/onesignal/common/events/EventProducer;", "Lcom/onesignal/inAppMessages/internal/lifecycle/IInAppLifecycleEventHandler;", "Lcom/onesignal/inAppMessages/internal/lifecycle/IInAppLifecycleService;", "()V", "messageActionOccurredOnMessage", "", "message", "Lcom/onesignal/inAppMessages/internal/InAppMessage;", "action", "Lcom/onesignal/inAppMessages/internal/InAppMessageClickResult;", "messageActionOccurredOnPreview", "messagePageChanged", "page", "Lcom/onesignal/inAppMessages/internal/InAppMessagePage;", "messageWasDismissed", "messageWasDisplayed", "messageWillDismiss", "messageWillDisplay", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class IAMLifecycleService extends EventProducer implements IInAppLifecycleService {
    @Override  // com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleService
    public void messageActionOccurredOnMessage(InAppMessage inAppMessage0, InAppMessageClickResult inAppMessageClickResult0) {
        Intrinsics.checkNotNullParameter(inAppMessage0, "message");
        Intrinsics.checkNotNullParameter(inAppMessageClickResult0, "action");
        this.fire(new Function1(inAppMessageClickResult0) {
            final InAppMessageClickResult $action;
            final InAppMessage $message;

            {
                this.$message = inAppMessage0;
                this.$action = inAppMessageClickResult0;
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                this.invoke(((IInAppLifecycleEventHandler)object0));
                return Unit.INSTANCE;
            }

            public final void invoke(IInAppLifecycleEventHandler iInAppLifecycleEventHandler0) {
                Intrinsics.checkNotNullParameter(iInAppLifecycleEventHandler0, "it");
                iInAppLifecycleEventHandler0.onMessageActionOccurredOnMessage(this.$message, this.$action);
            }
        });
    }

    @Override  // com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleService
    public void messageActionOccurredOnPreview(InAppMessage inAppMessage0, InAppMessageClickResult inAppMessageClickResult0) {
        Intrinsics.checkNotNullParameter(inAppMessage0, "message");
        Intrinsics.checkNotNullParameter(inAppMessageClickResult0, "action");
        this.fire(new Function1(inAppMessageClickResult0) {
            final InAppMessageClickResult $action;
            final InAppMessage $message;

            {
                this.$message = inAppMessage0;
                this.$action = inAppMessageClickResult0;
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                this.invoke(((IInAppLifecycleEventHandler)object0));
                return Unit.INSTANCE;
            }

            public final void invoke(IInAppLifecycleEventHandler iInAppLifecycleEventHandler0) {
                Intrinsics.checkNotNullParameter(iInAppLifecycleEventHandler0, "it");
                iInAppLifecycleEventHandler0.onMessageActionOccurredOnPreview(this.$message, this.$action);
            }
        });
    }

    @Override  // com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleService
    public void messagePageChanged(InAppMessage inAppMessage0, InAppMessagePage inAppMessagePage0) {
        Intrinsics.checkNotNullParameter(inAppMessage0, "message");
        Intrinsics.checkNotNullParameter(inAppMessagePage0, "page");
        this.fire(new Function1(inAppMessagePage0) {
            final InAppMessage $message;
            final InAppMessagePage $page;

            {
                this.$message = inAppMessage0;
                this.$page = inAppMessagePage0;
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                this.invoke(((IInAppLifecycleEventHandler)object0));
                return Unit.INSTANCE;
            }

            public final void invoke(IInAppLifecycleEventHandler iInAppLifecycleEventHandler0) {
                Intrinsics.checkNotNullParameter(iInAppLifecycleEventHandler0, "it");
                iInAppLifecycleEventHandler0.onMessagePageChanged(this.$message, this.$page);
            }
        });
    }

    @Override  // com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleService
    public void messageWasDismissed(InAppMessage inAppMessage0) {
        Intrinsics.checkNotNullParameter(inAppMessage0, "message");
        this.fire(new Function1() {
            final InAppMessage $message;

            {
                this.$message = inAppMessage0;
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                this.invoke(((IInAppLifecycleEventHandler)object0));
                return Unit.INSTANCE;
            }

            public final void invoke(IInAppLifecycleEventHandler iInAppLifecycleEventHandler0) {
                Intrinsics.checkNotNullParameter(iInAppLifecycleEventHandler0, "it");
                iInAppLifecycleEventHandler0.onMessageWasDismissed(this.$message);
            }
        });
    }

    @Override  // com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleService
    public void messageWasDisplayed(InAppMessage inAppMessage0) {
        Intrinsics.checkNotNullParameter(inAppMessage0, "message");
        this.fire(new Function1() {
            final InAppMessage $message;

            {
                this.$message = inAppMessage0;
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                this.invoke(((IInAppLifecycleEventHandler)object0));
                return Unit.INSTANCE;
            }

            public final void invoke(IInAppLifecycleEventHandler iInAppLifecycleEventHandler0) {
                Intrinsics.checkNotNullParameter(iInAppLifecycleEventHandler0, "it");
                iInAppLifecycleEventHandler0.onMessageWasDisplayed(this.$message);
            }
        });
    }

    @Override  // com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleService
    public void messageWillDismiss(InAppMessage inAppMessage0) {
        Intrinsics.checkNotNullParameter(inAppMessage0, "message");
        this.fire(new Function1() {
            final InAppMessage $message;

            {
                this.$message = inAppMessage0;
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                this.invoke(((IInAppLifecycleEventHandler)object0));
                return Unit.INSTANCE;
            }

            public final void invoke(IInAppLifecycleEventHandler iInAppLifecycleEventHandler0) {
                Intrinsics.checkNotNullParameter(iInAppLifecycleEventHandler0, "it");
                iInAppLifecycleEventHandler0.onMessageWillDismiss(this.$message);
            }
        });
    }

    @Override  // com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleService
    public void messageWillDisplay(InAppMessage inAppMessage0) {
        Intrinsics.checkNotNullParameter(inAppMessage0, "message");
        this.fire(new Function1() {
            final InAppMessage $message;

            {
                this.$message = inAppMessage0;
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                this.invoke(((IInAppLifecycleEventHandler)object0));
                return Unit.INSTANCE;
            }

            public final void invoke(IInAppLifecycleEventHandler iInAppLifecycleEventHandler0) {
                Intrinsics.checkNotNullParameter(iInAppLifecycleEventHandler0, "it");
                iInAppLifecycleEventHandler0.onMessageWillDisplay(this.$message);
            }
        });
    }
}

