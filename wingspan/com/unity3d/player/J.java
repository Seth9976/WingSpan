package com.unity3d.player;

import android.database.ContentObserver;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;

class j extends ContentObserver {
    private final k a;
    private final AudioManager b;
    private final int c;
    private int d;

    public j(l l0, Handler handler0, AudioManager audioManager0, int v, k k0) {
        super(handler0);
        this.b = audioManager0;
        this.c = v;
        this.a = k0;
        this.d = audioManager0.getStreamVolume(v);
    }

    @Override  // android.database.ContentObserver
    public boolean deliverSelfNotifications() {
        return super.deliverSelfNotifications();
    }

    @Override  // android.database.ContentObserver
    public void onChange(boolean z, Uri uri0) {
        AudioManager audioManager0 = this.b;
        if(audioManager0 != null && this.a != null) {
            int v = audioManager0.getStreamVolume(this.c);
            if(v != this.d) {
                this.d = v;
                ((AudioVolumeHandler)this.a).onAudioVolumeChanged(v);
            }
        }
    }
}

