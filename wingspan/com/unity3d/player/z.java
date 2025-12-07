package com.unity3d.player;

class Z implements Runnable {
    final c0 a;

    Z(c0 c00) {
        this.a = c00;
        super();
    }

    @Override
    public void run() {
        c0.-$$Nest$fgeta(this.a).onPause();
    }
}

