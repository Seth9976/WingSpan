package com.unity3d.player;

import android.content.Context;

public class AudioVolumeHandler implements k {
    private l a;

    AudioVolumeHandler(Context context0) {
        l l0 = new l(context0);
        this.a = l0;
        l0.a(3, this);
    }

    public void a() {
        this.a.a();
        this.a = null;
    }

    public final native void onAudioVolumeChanged(int arg1) {
    }
}

