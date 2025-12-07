package com.google.android.gms.nearby.messages;

import android.app.PendingIntent;
import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;

@Deprecated
public interface Messages {
    @Deprecated
    PendingResult getPermissionStatus(GoogleApiClient arg1);

    void handleIntent(Intent arg1, MessageListener arg2);

    PendingResult publish(GoogleApiClient arg1, Message arg2);

    PendingResult publish(GoogleApiClient arg1, Message arg2, PublishOptions arg3);

    PendingResult registerStatusCallback(GoogleApiClient arg1, StatusCallback arg2);

    PendingResult subscribe(GoogleApiClient arg1, PendingIntent arg2);

    PendingResult subscribe(GoogleApiClient arg1, PendingIntent arg2, SubscribeOptions arg3);

    PendingResult subscribe(GoogleApiClient arg1, MessageListener arg2);

    PendingResult subscribe(GoogleApiClient arg1, MessageListener arg2, SubscribeOptions arg3);

    PendingResult unpublish(GoogleApiClient arg1, Message arg2);

    PendingResult unregisterStatusCallback(GoogleApiClient arg1, StatusCallback arg2);

    PendingResult unsubscribe(GoogleApiClient arg1, PendingIntent arg2);

    PendingResult unsubscribe(GoogleApiClient arg1, MessageListener arg2);
}

