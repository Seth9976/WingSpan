package com.unity3d.player;

public interface IPermissionRequestCallbacks {
    void onPermissionDenied(String arg1);

    void onPermissionDeniedAndDontAskAgain(String arg1);

    void onPermissionGranted(String arg1);
}

