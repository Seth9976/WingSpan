package com.google.android.play.core.common;

import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.content.IntentSender;
import android.os.Bundle;

public interface IntentSenderForResultStarter {
    void startIntentSenderForResult(IntentSender arg1, int arg2, Intent arg3, int arg4, int arg5, int arg6, Bundle arg7) throws IntentSender.SendIntentException;
}

