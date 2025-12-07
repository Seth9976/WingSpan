package com.google.android.gms.games;

import com.google.android.gms.tasks.Task;

public interface AchievementsClient {
    Task getAchievementsIntent();

    void increment(String arg1, int arg2);

    Task incrementImmediate(String arg1, int arg2);

    Task load(boolean arg1);

    void reveal(String arg1);

    Task revealImmediate(String arg1);

    void setSteps(String arg1, int arg2);

    Task setStepsImmediate(String arg1, int arg2);

    void unlock(String arg1);

    Task unlockImmediate(String arg1);
}

