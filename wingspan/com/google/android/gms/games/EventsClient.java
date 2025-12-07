package com.google.android.gms.games;

import com.google.android.gms.tasks.Task;

public interface EventsClient {
    void increment(String arg1, int arg2);

    Task load(boolean arg1);

    Task loadByIds(boolean arg1, String[] arg2);
}

