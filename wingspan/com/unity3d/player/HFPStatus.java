package com.unity3d.player;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;

public class HFPStatus {
    // 部分失败：枚举糖化
    // 枚举按原样呈现，而不是糖化为Java 5枚举。
    static final class a extends Enum {
        public static final enum a a;
        public static final enum a b;

        static {
            a.a = new a("DISCONNECTED", 0);
            a.b = new a("CONNECTED", 1);
        }

        private a(String s, int v) {
            super(s, v);
        }
    }

    private Context a;
    private BroadcastReceiver b;
    private boolean c;
    private AudioManager d;
    private boolean e;
    private a f;

    public HFPStatus(Context context0) {
        this.b = null;
        this.c = false;
        this.e = false;
        this.f = a.a;
        this.a = context0;
        this.d = (AudioManager)context0.getSystemService("audio");
        this.initHFPStatusJni();
    }

    public void a() {
        this.clearHFPStat();
        this.deinitHFPStatusJni();
    }

    protected void clearHFPStat() {
        BroadcastReceiver broadcastReceiver0 = this.b;
        if(broadcastReceiver0 != null) {
            this.a.unregisterReceiver(broadcastReceiver0);
            this.b = null;
        }
        this.f = a.a;
        if(this.e) {
            this.e = false;
            this.d.stopBluetoothSco();
        }
    }

    private final native void deinitHFPStatusJni() {
    }

    protected boolean getHFPStat() {
        return this.f == a.b;
    }

    private final native void initHFPStatusJni() {
    }

    protected void requestHFPStat() {
        this.clearHFPStat();
        com.unity3d.player.HFPStatus.1 hFPStatus$10 = new BroadcastReceiver() {
            final HFPStatus a;

            @Override  // android.content.BroadcastReceiver
            public void onReceive(Context context0, Intent intent0) {
                if(intent0.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1) == 1) {
                    HFPStatus hFPStatus0 = HFPStatus.this;
                    hFPStatus0.f = a.b;
                    if(hFPStatus0.e) {
                        hFPStatus0.e = false;
                        hFPStatus0.d.stopBluetoothSco();
                    }
                    HFPStatus hFPStatus1 = HFPStatus.this;
                    if(hFPStatus1.c) {
                        hFPStatus1.d.setMode(3);
                    }
                }
            }
        };
        this.b = hFPStatus$10;
        this.a.registerReceiver(hFPStatus$10, new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"));
        try {
            this.e = true;
            this.d.startBluetoothSco();
        }
        catch(NullPointerException unused_ex) {
            u.Log(5, "startBluetoothSco() failed. no bluetooth device connected.");
        }
    }

    protected void setHFPRecordingStat(boolean z) {
        this.c = z;
        if(!z) {
            this.d.setMode(0);
        }
    }
}

