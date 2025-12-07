package com.voxelbusters.essentialkit.gameservices;

import com.voxelbusters.essentialkit.utilities.common.ArrayBuffer;
import java.util.List;

public interface IGameServices {
    public interface ILoadAchievementsListener {
        void onFailure(String arg1);

        void onSuccess(ArrayBuffer arg1);
    }

    public interface ILoadLeaderboardsListener {
        void onFailure(String arg1);

        void onSuccess(List arg1);
    }

    public interface ILoadLocalPlayerScoreListener {
        void onFailure(String arg1);

        void onSuccess(GameLeaderboardScore arg1);
    }

    public interface ILoadPlayersListener {
        void onFailure(String arg1);

        void onSuccess(List arg1);
    }

    public interface ILoadScoresListener {
        void onFailure(String arg1);

        void onSuccess(List arg1);
    }

    public interface ILoadServerCredentials {
        void onFailure(String arg1);

        void onSuccess(String arg1, String arg2, String arg3);
    }

    public interface IPlayerAuthenticationListener {
        void onFailure(String arg1);

        void onSuccess(GamePlayer arg1);
    }

    public interface IReportProgressListener {
        void onFailure(String arg1);

        void onSuccess();
    }

    public interface ISubmitScoreListener {
        void onFailure(String arg1);

        void onSuccess();
    }

    public interface IViewListener {
        void onClose(String arg1);
    }

}

