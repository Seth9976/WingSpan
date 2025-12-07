package com.google.android.gms.games;

import com.google.android.gms.tasks.Task;

public interface PlayersClient {
    public static final String EXTRA_PLAYER_SEARCH_RESULTS = "player_search_results";

    Task getCompareProfileIntent(Player arg1);

    Task getCompareProfileIntent(String arg1);

    Task getCompareProfileIntentWithAlternativeNameHints(String arg1, String arg2, String arg3);

    Task getCurrentPlayer();

    Task getCurrentPlayer(boolean arg1);

    Task getCurrentPlayerId();

    Task getPlayerSearchIntent();

    Task loadFriends(int arg1, boolean arg2);

    Task loadMoreFriends(int arg1);

    @Deprecated
    Task loadMoreRecentlyPlayedWithPlayers(int arg1);

    Task loadPlayer(String arg1);

    Task loadPlayer(String arg1, boolean arg2);

    @Deprecated
    Task loadRecentlyPlayedWithPlayers(int arg1, boolean arg2);
}

