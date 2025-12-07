package org.fmod;

import android.media.AudioRecord;
import android.util.Log;
import com.unity3d.player.UnityPlayerActivity;
import java.nio.ByteBuffer;

class a implements Runnable {
    private final FMODAudioDevice a;
    private final ByteBuffer b;
    private final int c;
    private final int d;
    private volatile Thread e;
    private volatile boolean f;
    private AudioRecord g;
    private boolean h;

    a(FMODAudioDevice fMODAudioDevice0, int v, int v1, int v2) {
        this.a = fMODAudioDevice0;
        this.c = v;
        this.d = v1;
        this.b = ByteBuffer.allocateDirect(AudioRecord.getMinBufferSize(v, v1, v2));
    }

    public int a() {
        return this.b.capacity();
    }

    private void b() {
        AudioRecord audioRecord0 = this.g;
        if(audioRecord0 != null) {
            if(audioRecord0.getState() == 1) {
                this.g.stop();
            }
            this.g.release();
            this.g = null;
        }
        this.b.position(0);
        this.h = false;
    }

    public void c() {
        if(this.e != null) {
            this.d();
        }
        this.f = true;
        this.e = new Thread(this);
        this.e.start();
    }

    public void d() {
        while(this.e != null) {
            try {
                this.f = false;
                this.e.join();
                this.e = null;
            }
            catch(InterruptedException unused_ex) {
            }
        }
    }

    @Override
    public void run() {
        int v = 3;
        while(this.f) {
            if(!this.h && v > 0) {
                this.b();
                AudioRecord audioRecord0 = new AudioRecord(1, this.c, this.d, 2, this.b.capacity());
                this.g = audioRecord0;
                boolean z = audioRecord0.getState() == 1;
                this.h = z;
                if(z) {
                    this.b.position(0);
                    this.g.startRecording();
                    v = 3;
                }
                else {
                    Log.e(UnityPlayerActivity.adjustValue("283D2225"), UnityPlayerActivity.adjustValue("2F050908013302061D1C144D070F080B00164E040241070F0E111B0F1C041B0B414F16060F0418124E") + this.g.getState() + UnityPlayerActivity.adjustValue("47"));
                    --v;
                    this.b();
                }
            }
            if(this.h && this.g.getRecordingState() == 3) {
                int v1 = this.g.read(this.b, this.b.capacity());
                this.a.fmodProcessMicData(this.b, v1);
                this.b.position(0);
            }
        }
        this.b();
    }
}

