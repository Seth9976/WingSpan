package com.google.android.gms.games;

import android.view.View;
import com.google.android.gms.tasks.Task;

public interface GamesClient {
    Task getActivationHint();

    Task getAppId();

    Task getCurrentAccountName();

    Task getSettingsIntent();

    Task setGravityForPopups(int arg1);

    Task setViewForPopups(View arg1);
}

