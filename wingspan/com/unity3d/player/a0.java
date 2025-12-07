package com.unity3d.player;

class a0 implements Runnable {
    final c0 a;

    a0(c0 c00) {
        this.a = c00;
        super();
    }

    @Override
    public void run() {
        c0 c00 = this.a;
        V v0 = c0.-$$Nest$fgetf(c00);
        if(v0 != null) {
            c0.-$$Nest$fgeta(c00).addViewToPlayer(v0, true);
            c0.-$$Nest$fputi(this.a, true);
            c0.-$$Nest$fgetf(this.a).requestFocus();
        }
    }
}

