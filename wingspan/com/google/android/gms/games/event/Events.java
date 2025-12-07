package com.google.android.gms.games.event;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;

@Deprecated
public interface Events {
    @Deprecated
    public interface LoadEventsResult extends Releasable, Result {
        EventBuffer getEvents();
    }

    void increment(GoogleApiClient arg1, String arg2, int arg3);

    PendingResult load(GoogleApiClient arg1, boolean arg2);

    PendingResult loadByIds(GoogleApiClient arg1, boolean arg2, String[] arg3);
}

