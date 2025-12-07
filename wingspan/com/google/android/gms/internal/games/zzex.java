package com.google.android.gms.internal.games;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.games.Games.GamesOptions;
import com.google.android.gms.games.VideosClient.OnCaptureOverlayStateListener;
import com.google.android.gms.games.VideosClient;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzex extends zzad implements VideosClient {
    public static final int zza;

    public zzex(Activity activity0, GamesOptions games$GamesOptions0) {
        super(activity0, games$GamesOptions0);
    }

    public zzex(Context context0, GamesOptions games$GamesOptions0) {
        super(context0, games$GamesOptions0);
    }

    @Override  // com.google.android.gms.games.VideosClient
    public final Task getCaptureCapabilities() {
        return this.doRead(TaskApiCall.builder().run((zzeu this, Object object0) -> ((zzbz)object0).zzV(((TaskCompletionSource)object1))).setMethodKey(6677).build());
    }

    @Override  // com.google.android.gms.games.VideosClient
    public final Task getCaptureOverlayIntent() {
        return this.doRead(TaskApiCall.builder().run((/* 缺少Lambda参数 */, zzer this) -> ((TaskCompletionSource)object1).setResult(((zzbz)object0).zzv())).setMethodKey(6678).build());
    }

    @Override  // com.google.android.gms.games.VideosClient
    public final Task getCaptureState() {
        return this.doRead(TaskApiCall.builder().run((zzew this, Object object0) -> ((zzbz)object0).zzX(((TaskCompletionSource)object1))).setMethodKey(6679).build());
    }

    @Override  // com.google.android.gms.games.VideosClient
    public final Task isCaptureAvailable(int v) {
        return this.doRead(TaskApiCall.builder().run(new zzev(v)).setMethodKey(6680).build());
    }

    @Override  // com.google.android.gms.games.VideosClient
    public final Task isCaptureSupported() {
        return this.doRead(TaskApiCall.builder().run((/* 缺少Lambda参数 */, zzeq this) -> ((TaskCompletionSource)object1).setResult(Boolean.valueOf(((zzbz)object0).zzbd()))).setMethodKey(6681).build());
    }

    @Override  // com.google.android.gms.games.VideosClient
    public final Task registerOnCaptureOverlayStateChangedListener(OnCaptureOverlayStateListener videosClient$OnCaptureOverlayStateListener0) {
        ListenerHolder listenerHolder0 = this.registerListener(videosClient$OnCaptureOverlayStateListener0, "VideosClient$OnCaptureOverlayStateListener");
        Preconditions.checkNotNull(listenerHolder0.getListenerKey(), "Key must not be null");
        zzes zzes0 = new zzes(listenerHolder0);
        return this.doRegisterEventListener(RegistrationMethods.builder().register(zzes0).unregister(zzet.zza).withHolder(listenerHolder0).setMethodKey(6682).build());
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.gms.games.VideosClient
    public final Task unregisterOnCaptureOverlayStateChangedListener(OnCaptureOverlayStateListener videosClient$OnCaptureOverlayStateListener0) {
        return this.doUnregisterEventListener(ListenerHolders.createListenerKey(videosClient$OnCaptureOverlayStateListener0, "VideosClient$OnCaptureOverlayStateListener"), 6683);
    }
}

