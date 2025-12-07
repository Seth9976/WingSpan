package com.onesignal.core.internal.application;

import android.app.Activity;
import android.content.Context;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u0016H&J\u0010\u0010\u0017\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u0018H&J\u0010\u0010\u0019\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u0016H&J\u0010\u0010\u001A\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u0018H&J\u0011\u0010\u001B\u001A\u00020\u0011H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001CJ\u0011\u0010\u001D\u001A\u00020\u0011H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001CR\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001A\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\tR\u0018\u0010\n\u001A\u00020\u000BX¦\u000E¢\u0006\f\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u0012\u0010\u0010\u001A\u00020\u0011X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001E"}, d2 = {"Lcom/onesignal/core/internal/application/IApplicationService;", "", "appContext", "Landroid/content/Context;", "getAppContext", "()Landroid/content/Context;", "current", "Landroid/app/Activity;", "getCurrent", "()Landroid/app/Activity;", "entryState", "Lcom/onesignal/core/internal/application/AppEntryAction;", "getEntryState", "()Lcom/onesignal/core/internal/application/AppEntryAction;", "setEntryState", "(Lcom/onesignal/core/internal/application/AppEntryAction;)V", "isInForeground", "", "()Z", "addActivityLifecycleHandler", "", "handler", "Lcom/onesignal/core/internal/application/IActivityLifecycleHandler;", "addApplicationLifecycleHandler", "Lcom/onesignal/core/internal/application/IApplicationLifecycleHandler;", "removeActivityLifecycleHandler", "removeApplicationLifecycleHandler", "waitUntilActivityReady", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitUntilSystemConditionsAvailable", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface IApplicationService {
    void addActivityLifecycleHandler(IActivityLifecycleHandler arg1);

    void addApplicationLifecycleHandler(IApplicationLifecycleHandler arg1);

    Context getAppContext();

    Activity getCurrent();

    AppEntryAction getEntryState();

    boolean isInForeground();

    void removeActivityLifecycleHandler(IActivityLifecycleHandler arg1);

    void removeApplicationLifecycleHandler(IApplicationLifecycleHandler arg1);

    void setEntryState(AppEntryAction arg1);

    Object waitUntilActivityReady(Continuation arg1);

    Object waitUntilSystemConditionsAvailable(Continuation arg1);
}

