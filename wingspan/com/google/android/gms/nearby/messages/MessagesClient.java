package com.google.android.gms.nearby.messages;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.tasks.Task;

public abstract class MessagesClient extends GoogleApi {
    protected MessagesClient(Activity activity0, Api api0, MessagesOptions messagesOptions0, Settings googleApi$Settings0) {
        super(activity0, api0, messagesOptions0, googleApi$Settings0);
    }

    protected MessagesClient(Context context0, Api api0, MessagesOptions messagesOptions0, Settings googleApi$Settings0) {
        super(context0, api0, messagesOptions0, googleApi$Settings0);
    }

    public abstract void handleIntent(Intent arg1, MessageListener arg2);

    public abstract Task publish(Message arg1);

    public abstract Task publish(Message arg1, PublishOptions arg2);

    public abstract Task registerStatusCallback(StatusCallback arg1);

    public abstract Task subscribe(PendingIntent arg1);

    public abstract Task subscribe(PendingIntent arg1, SubscribeOptions arg2);

    public abstract Task subscribe(MessageListener arg1);

    public abstract Task subscribe(MessageListener arg1, SubscribeOptions arg2);

    public abstract Task unpublish(Message arg1);

    public abstract Task unregisterStatusCallback(StatusCallback arg1);

    public abstract Task unsubscribe(PendingIntent arg1);

    public abstract Task unsubscribe(MessageListener arg1);
}

