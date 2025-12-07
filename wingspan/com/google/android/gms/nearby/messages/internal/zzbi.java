package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.content.Intent;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.nearby.zzgw;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.Messages;
import com.google.android.gms.nearby.messages.PublishOptions;
import com.google.android.gms.nearby.messages.StatusCallback;
import com.google.android.gms.nearby.messages.SubscribeOptions;

public final class zzbi implements Messages {
    public static final AbstractClientBuilder CLIENT_BUILDER;
    public static final ClientKey CLIENT_KEY;
    public static final zzbi zzij;

    static {
        zzbi.zzij = new zzbi();
        zzbi.CLIENT_KEY = new ClientKey();
        zzbi.CLIENT_BUILDER = new zzbj();
    }

    @Override  // com.google.android.gms.nearby.messages.Messages
    public final PendingResult getPermissionStatus(GoogleApiClient googleApiClient0) {
        return googleApiClient0.execute(new zzbr(this, googleApiClient0));
    }

    @Override  // com.google.android.gms.nearby.messages.Messages
    public final void handleIntent(Intent intent0, MessageListener messageListener0) {
        zzgw.zza(intent0, messageListener0);
    }

    @Override  // com.google.android.gms.nearby.messages.Messages
    public final PendingResult publish(GoogleApiClient googleApiClient0, Message message0) {
        return this.publish(googleApiClient0, message0, PublishOptions.DEFAULT);
    }

    @Override  // com.google.android.gms.nearby.messages.Messages
    public final PendingResult publish(GoogleApiClient googleApiClient0, Message message0, PublishOptions publishOptions0) {
        Preconditions.checkNotNull(message0);
        Preconditions.checkNotNull(publishOptions0);
        zzbt zzbt0 = null;
        ListenerHolder listenerHolder0 = publishOptions0.getCallback() == null ? null : googleApiClient0.registerListener(publishOptions0.getCallback());
        if(listenerHolder0 != null) {
            zzbt0 = new zzbt(listenerHolder0);
        }
        return googleApiClient0.execute(new zzbl(this, googleApiClient0, message0, zzbt0, publishOptions0));
    }

    @Override  // com.google.android.gms.nearby.messages.Messages
    public final PendingResult registerStatusCallback(GoogleApiClient googleApiClient0, StatusCallback statusCallback0) {
        Preconditions.checkNotNull(statusCallback0);
        return googleApiClient0.execute(new zzbs(this, googleApiClient0, googleApiClient0.registerListener(statusCallback0)));
    }

    @Override  // com.google.android.gms.nearby.messages.Messages
    public final PendingResult subscribe(GoogleApiClient googleApiClient0, PendingIntent pendingIntent0) {
        return this.subscribe(googleApiClient0, pendingIntent0, SubscribeOptions.DEFAULT);
    }

    @Override  // com.google.android.gms.nearby.messages.Messages
    public final PendingResult subscribe(GoogleApiClient googleApiClient0, PendingIntent pendingIntent0, SubscribeOptions subscribeOptions0) {
        Preconditions.checkNotNull(pendingIntent0);
        Preconditions.checkNotNull(subscribeOptions0);
        zzbw zzbw0 = null;
        ListenerHolder listenerHolder0 = subscribeOptions0.getCallback() == null ? null : googleApiClient0.registerListener(subscribeOptions0.getCallback());
        if(listenerHolder0 != null) {
            zzbw0 = new zzbw(listenerHolder0);
        }
        return googleApiClient0.execute(new zzbo(this, googleApiClient0, pendingIntent0, zzbw0, subscribeOptions0));
    }

    @Override  // com.google.android.gms.nearby.messages.Messages
    public final PendingResult subscribe(GoogleApiClient googleApiClient0, MessageListener messageListener0) {
        return this.subscribe(googleApiClient0, messageListener0, SubscribeOptions.DEFAULT);
    }

    @Override  // com.google.android.gms.nearby.messages.Messages
    public final PendingResult subscribe(GoogleApiClient googleApiClient0, MessageListener messageListener0, SubscribeOptions subscribeOptions0) {
        Preconditions.checkNotNull(messageListener0);
        Preconditions.checkNotNull(subscribeOptions0);
        Preconditions.checkArgument(subscribeOptions0.getStrategy().zzae() == 0, "Strategy.setBackgroundScanMode() is only supported by background subscribe (the version which takes a PendingIntent).");
        ListenerHolder listenerHolder0 = googleApiClient0.registerListener(messageListener0);
        zzbw zzbw0 = null;
        ListenerHolder listenerHolder1 = subscribeOptions0.getCallback() == null ? null : googleApiClient0.registerListener(subscribeOptions0.getCallback());
        if(listenerHolder1 != null) {
            zzbw0 = new zzbw(listenerHolder1);
        }
        return googleApiClient0.execute(new zzbn(this, googleApiClient0, listenerHolder0, zzbw0, subscribeOptions0));
    }

    @Override  // com.google.android.gms.nearby.messages.Messages
    public final PendingResult unpublish(GoogleApiClient googleApiClient0, Message message0) {
        Preconditions.checkNotNull(message0);
        return googleApiClient0.execute(new zzbm(this, googleApiClient0, message0));
    }

    @Override  // com.google.android.gms.nearby.messages.Messages
    public final PendingResult unregisterStatusCallback(GoogleApiClient googleApiClient0, StatusCallback statusCallback0) {
        Preconditions.checkNotNull(statusCallback0);
        return googleApiClient0.execute(new zzbk(this, googleApiClient0, googleApiClient0.registerListener(statusCallback0)));
    }

    @Override  // com.google.android.gms.nearby.messages.Messages
    public final PendingResult unsubscribe(GoogleApiClient googleApiClient0, PendingIntent pendingIntent0) {
        Preconditions.checkNotNull(pendingIntent0);
        return googleApiClient0.execute(new zzbq(this, googleApiClient0, pendingIntent0));
    }

    @Override  // com.google.android.gms.nearby.messages.Messages
    public final PendingResult unsubscribe(GoogleApiClient googleApiClient0, MessageListener messageListener0) {
        Preconditions.checkNotNull(messageListener0);
        return googleApiClient0.execute(new zzbp(this, googleApiClient0, googleApiClient0.registerListener(messageListener0)));
    }
}

