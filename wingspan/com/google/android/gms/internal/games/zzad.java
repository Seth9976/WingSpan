package com.google.android.gms.internal.games;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.ClientSettings.Builder;
import com.google.android.gms.games.Games.GamesOptions;
import com.google.android.gms.games.Games;

public class zzad extends GoogleApi {
    public zzad(Activity activity0, GamesOptions games$GamesOptions0) {
        super(activity0, Games.API, games$GamesOptions0, Settings.DEFAULT_SETTINGS);
    }

    public zzad(Context context0, GamesOptions games$GamesOptions0) {
        super(context0, Games.API, games$GamesOptions0, Settings.DEFAULT_SETTINGS);
    }

    @Override  // com.google.android.gms.common.api.GoogleApi
    protected final Builder createClientSettingsBuilder() {
        Builder clientSettings$Builder0 = super.createClientSettingsBuilder();
        if(this.getApiOptions() != null) {
            GamesOptions games$GamesOptions0 = (GamesOptions)this.getApiOptions();
        }
        return clientSettings$Builder0;
    }
}

