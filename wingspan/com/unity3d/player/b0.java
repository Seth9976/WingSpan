package com.unity3d.player;

class b0 implements Runnable {
    final c0 a;

    b0(c0 c00) {
        this.a = c00;
        super();
    }

    @Override
    public void run() {
        c0.-$$Nest$ma(this.a);
        c0.-$$Nest$fgeta(this.a).onResume();
    }
}

