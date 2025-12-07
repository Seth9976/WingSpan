package com.voxelbusters.essentialkit.utilities.common;

import android.app.Activity;
import android.os.Bundle;

public class FullScreenActivity extends Activity {
    // 检测为 Lambda 实现
    void lambda$onCreate$0$com-voxelbusters-essentialkit-utilities-common-FullScreenActivity(int v) [...]

    @Override  // android.app.Activity
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        this.requestWindowFeature(1);
        this.setFullScreenMode();
        this.getWindow().getDecorView().setOnSystemUiVisibilityChangeListener((int v) -> if((v & 4) == 0) {
            this.setFullScreenMode();
        });
    }

    @Override  // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(null);
    }

    @Override  // android.app.Activity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if(z) {
            this.setFullScreenMode();
        }
    }

    private void setFullScreenMode() {
        this.getWindow().getDecorView().setSystemUiVisibility(0x1706);
    }
}

