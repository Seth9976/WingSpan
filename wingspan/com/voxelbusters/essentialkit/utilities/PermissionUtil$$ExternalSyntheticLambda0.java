package com.voxelbusters.essentialkit.utilities;

import android.app.Activity;
import com.voxelbusters.essentialkit.utilities.helpers.PermissionRequestFragment;
import java.util.ArrayList;

public final class PermissionUtil..ExternalSyntheticLambda0 implements Runnable {
    public final ArrayList f$0;
    public final String f$1;
    public final PermissionRequestFragment f$2;
    public final Activity f$3;

    public PermissionUtil..ExternalSyntheticLambda0(ArrayList arrayList0, String s, PermissionRequestFragment permissionRequestFragment0, Activity activity0) {
        this.f$0 = arrayList0;
        this.f$1 = s;
        this.f$2 = permissionRequestFragment0;
        this.f$3 = activity0;
    }

    @Override
    public final void run() {
        PermissionUtil.lambda$requestPermissions$0(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}

