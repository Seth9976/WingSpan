package com.voxelbusters.essentialkit.utilities.interfaces;

public interface IAppLifeCycleListener {
    void onApplicationPause();

    void onApplicationQuit();

    void onApplicationResume();
}

