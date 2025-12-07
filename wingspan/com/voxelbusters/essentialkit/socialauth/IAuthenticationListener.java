package com.voxelbusters.essentialkit.socialauth;

import com.google.android.gms.games.Player;

public interface IAuthenticationListener {
    void onFailure(String arg1);

    void onSuccess(Player arg1);
}

