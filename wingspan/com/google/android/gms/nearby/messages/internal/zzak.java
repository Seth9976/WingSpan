package com.google.android.gms.nearby.messages.internal;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.internal.ClientSettings.Builder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.nearby.zzgw;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.MessagesClient;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.PublishOptions;
import com.google.android.gms.nearby.messages.StatusCallback;
import com.google.android.gms.nearby.messages.SubscribeOptions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzak extends MessagesClient {
    private static final AbstractClientBuilder CLIENT_BUILDER;
    private static final ClientKey CLIENT_KEY;
    private static final Api MESSAGES_API;
    private final int zzhf;

    static {
        ClientKey api$ClientKey0 = new ClientKey();
        zzak.CLIENT_KEY = api$ClientKey0;
        zzau zzau0 = new zzau();
        zzak.CLIENT_BUILDER = zzau0;
        zzak.MESSAGES_API = new Api("Nearby.MESSAGES_API", zzau0, api$ClientKey0);
    }

    public zzak(Activity activity0, MessagesOptions messagesOptions0) {
        super(activity0, zzak.MESSAGES_API, messagesOptions0, Settings.DEFAULT_SETTINGS);
        this.zzhf = 1;
        activity0.getApplication().registerActivityLifecycleCallbacks(new zzbc(activity0, this, null));
    }

    public zzak(Context context0, MessagesOptions messagesOptions0) {
        super(context0, zzak.MESSAGES_API, messagesOptions0, Settings.DEFAULT_SETTINGS);
        this.zzhf = zzah.zzb(context0);
    }

    @Override  // com.google.android.gms.common.api.GoogleApi
    protected final Builder createClientSettingsBuilder() {
        Builder clientSettings$Builder0 = super.createClientSettingsBuilder();
        boolean z = this.getApiOptions() == null;
        return clientSettings$Builder0;
    }

    @Override  // com.google.android.gms.nearby.messages.MessagesClient
    public final void handleIntent(Intent intent0, MessageListener messageListener0) {
        zzgw.zza(intent0, messageListener0);
    }

    @Override  // com.google.android.gms.nearby.messages.MessagesClient
    public final Task publish(Message message0) {
        return this.publish(message0, PublishOptions.DEFAULT);
    }

    @Override  // com.google.android.gms.nearby.messages.MessagesClient
    public final Task publish(Message message0, PublishOptions publishOptions0) {
        Preconditions.checkNotNull(message0);
        Preconditions.checkNotNull(publishOptions0);
        ListenerHolder listenerHolder0 = this.zzb(message0);
        return this.zza(listenerHolder0, (zzah zzah0, ListenerHolder listenerHolder0) -> zzah0.zza(listenerHolder0, zzaf.zza(message0), new zzav(this, this.zzb(publishOptions0.getCallback()), listenerHolder0), publishOptions0, this.zzhf), (zzah zzah0, ListenerHolder listenerHolder0) -> zzah0.zza(listenerHolder0, zzaf.zza(message0)));
    }

    @Override  // com.google.android.gms.nearby.messages.MessagesClient
    public final Task registerStatusCallback(StatusCallback statusCallback0) {
        Preconditions.checkNotNull(statusCallback0);
        ListenerHolder listenerHolder0 = this.zzb(statusCallback0);
        return this.zza(listenerHolder0, (zzah zzah0, ListenerHolder listenerHolder1) -> zzah0.zzb(listenerHolder1, listenerHolder0), (zzah zzah0, ListenerHolder listenerHolder1) -> zzah0.zzc(listenerHolder1, listenerHolder0));
    }

    @Override  // com.google.android.gms.nearby.messages.MessagesClient
    public final Task subscribe(PendingIntent pendingIntent0) {
        return this.subscribe(pendingIntent0, SubscribeOptions.DEFAULT);
    }

    @Override  // com.google.android.gms.nearby.messages.MessagesClient
    public final Task subscribe(PendingIntent pendingIntent0, SubscribeOptions subscribeOptions0) {
        Preconditions.checkNotNull(pendingIntent0);
        Preconditions.checkNotNull(subscribeOptions0);
        ListenerHolder listenerHolder0 = this.zzb(subscribeOptions0.getCallback());
        return listenerHolder0 == null ? this.zza((zzah zzah0, ListenerHolder listenerHolder0) -> zzah0.zza(listenerHolder0, pendingIntent0, null, subscribeOptions0, this.zzhf)) : this.zza((zzah zzah0, ListenerHolder listenerHolder0) -> zzah0.zza(listenerHolder0, pendingIntent0, new zzbg(listenerHolder0), subscribeOptions0, this.zzhf));
    }

    @Override  // com.google.android.gms.nearby.messages.MessagesClient
    public final Task subscribe(MessageListener messageListener0) {
        return this.subscribe(messageListener0, SubscribeOptions.DEFAULT);
    }

    @Override  // com.google.android.gms.nearby.messages.MessagesClient
    public final Task subscribe(MessageListener messageListener0, SubscribeOptions subscribeOptions0) {
        Preconditions.checkNotNull(messageListener0);
        Preconditions.checkNotNull(subscribeOptions0);
        Preconditions.checkArgument(subscribeOptions0.getStrategy().zzae() == 0, "Strategy.setBackgroundScanMode() is only supported by background subscribe (the version which takes a PendingIntent).");
        ListenerHolder listenerHolder0 = this.zzb(messageListener0);
        return this.zza(listenerHolder0, (zzah zzah0, ListenerHolder listenerHolder1) -> zzah0.zza(listenerHolder1, listenerHolder0, new zzaw(this, this.zzb(subscribeOptions0.getCallback()), listenerHolder0), subscribeOptions0, null, this.zzhf), (zzah zzah0, ListenerHolder listenerHolder1) -> zzah0.zza(listenerHolder1, listenerHolder0));
    }

    @Override  // com.google.android.gms.nearby.messages.MessagesClient
    public final Task unpublish(Message message0) {
        Preconditions.checkNotNull(message0);
        return this.zza(message0);
    }

    @Override  // com.google.android.gms.nearby.messages.MessagesClient
    public final Task unregisterStatusCallback(StatusCallback statusCallback0) {
        Preconditions.checkNotNull(statusCallback0);
        return this.zza(statusCallback0);
    }

    @Override  // com.google.android.gms.nearby.messages.MessagesClient
    public final Task unsubscribe(PendingIntent pendingIntent0) {
        Preconditions.checkNotNull(pendingIntent0);
        return this.zza((zzah zzah0, ListenerHolder listenerHolder0) -> zzah0.zza(listenerHolder0, pendingIntent0));
    }

    @Override  // com.google.android.gms.nearby.messages.MessagesClient
    public final Task unsubscribe(MessageListener messageListener0) {
        Preconditions.checkNotNull(messageListener0);
        return this.zza(messageListener0);
    }

    // 去混淆评级： 低(20)
    private final ListenerHolder zza(TaskCompletionSource taskCompletionSource0) {
        return this.registerListener(new zzax(this, taskCompletionSource0), "com.google.android.gms.common.api.Status");
    }

    private final Task zza(ListenerHolder listenerHolder0, zzbd zzbd0, zzbd zzbd1) {
        return this.doRegisterEventListener(new zzaz(this, listenerHolder0, zzbd0), new zzba(this, listenerHolder0.getListenerKey(), zzbd1));
    }

    private final Task zza(zzbd zzbd0) {
        return this.doWrite(new zzbb(this, zzbd0));
    }

    private final Task zza(Object object0) {
        TaskCompletionSource taskCompletionSource0 = new TaskCompletionSource();
        this.doUnregisterEventListener(ListenerHolders.createListenerKey(object0, object0.getClass().getName())).addOnCompleteListener(new zzay(this, taskCompletionSource0));
        return taskCompletionSource0.getTask();
    }

    // 检测为 Lambda 实现
    static final void zza(int v, zzah zzah0, ListenerHolder listenerHolder0) throws RemoteException [...]

    // 检测为 Lambda 实现
    static final void zza(PendingIntent pendingIntent0, zzah zzah0, ListenerHolder listenerHolder0) throws RemoteException [...]

    // 检测为 Lambda 实现
    static final void zza(ListenerHolder listenerHolder0, zzah zzah0, ListenerHolder listenerHolder1) throws RemoteException [...]

    // 检测为 Lambda 实现
    static final void zza(Message message0, zzah zzah0, ListenerHolder listenerHolder0) throws RemoteException [...]

    static void zza(zzak zzak0, int v) {
        zzak0.zzf(1);
    }

    // 检测为 Lambda 实现
    final void zza(PendingIntent pendingIntent0, zzbg zzbg0, SubscribeOptions subscribeOptions0, zzah zzah0, ListenerHolder listenerHolder0) throws RemoteException [...]

    // 检测为 Lambda 实现
    final void zza(ListenerHolder listenerHolder0, zzbg zzbg0, SubscribeOptions subscribeOptions0, zzah zzah0, ListenerHolder listenerHolder1) throws RemoteException [...]

    // 检测为 Lambda 实现
    final void zza(Message message0, zzbe zzbe0, PublishOptions publishOptions0, zzah zzah0, ListenerHolder listenerHolder0) throws RemoteException [...]

    private final ListenerHolder zzb(Object object0) {
        return object0 == null ? null : this.registerListener(object0, object0.getClass().getName());
    }

    // 检测为 Lambda 实现
    static final void zzb(ListenerHolder listenerHolder0, zzah zzah0, ListenerHolder listenerHolder1) throws RemoteException [...]

    // 检测为 Lambda 实现
    static final void zzc(ListenerHolder listenerHolder0, zzah zzah0, ListenerHolder listenerHolder1) throws RemoteException [...]

    private final void zzf(int v) {
        this.zza((zzah zzah0, ListenerHolder listenerHolder0) -> zzah0.zzf(1));
    }
}

