package com.voxelbusters.essentialkit.gameservices;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.google.android.gms.games.Player;
import com.voxelbusters.essentialkit.utilities.common.interfaces.ILoadAssetListener;

public class GamePlayer {
    public static class Builder {
        private Context context;
        private Player player;

        public Builder(Context context0) {
            this.context = context0;
        }

        public GamePlayer build() {
            return new GamePlayer(this.context, this.player, null);
        }

        public Builder withPlayer(Player player0) {
            this.player = player0;
            return this;
        }
    }

    public static final class a {
    }

    public Context context;
    public Player player;

    private GamePlayer(Context context0, Player player0) {
        this.context = context0;
        this.player = player0;
    }

    public GamePlayer(Context context0, Player player0, a gamePlayer$a0) {
        this(context0, player0);
    }

    public void LoadProfileImage(boolean z, ILoadAssetListener iLoadAssetListener0) {
        Uri uri0 = z ? this.player.getHiResImageUri() : this.player.getIconImageUri();
        ImageManagerUtility.loadImage(((Activity)this.context), uri0, iLoadAssetListener0);
    }

    public String getDisplayName() {
        return this.player.getDisplayName();
    }

    public String getId() {
        return this.player.getPlayerId();
    }

    public String getName() {
        return this.getDisplayName();
    }

    public String getTitle() {
        return this.player.getTitle();
    }
}

