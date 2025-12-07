package com.voxelbusters.essentialkit.extras;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import com.voxelbusters.essentialkit.utilities.ApplicationUtil;
import com.voxelbusters.essentialkit.utilities.common.annotations.RunOnUiThread;
import com.voxelbusters.essentialkit.utilities.common.interfaces.IFeature;

public class ApplicationUtility implements IFeature {
    private Context context;

    public ApplicationUtility(Context context0) {
        this.context = context0;
    }

    @Override  // com.voxelbusters.essentialkit.utilities.common.interfaces.IFeature
    public String getFeatureName() {
        return "Application Utility";
    }

    @RunOnUiThread
    public void openApplicationSettings() {
        Intent intent0 = new Intent();
        intent0.addFlags(0x10000000);
        intent0.setData(Uri.parse("package:com.MonsterCouch.Wingspan"));
        int v = Build.VERSION.SDK_INT;
        intent0.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        if(v < 26) {
            intent0.putExtra("app_package", "com.MonsterCouch.Wingspan");
            intent0.putExtra("app_uid", ApplicationUtil.getApplicationInfo(this.context).uid);
        }
        this.context.startActivity(intent0);
    }

    @RunOnUiThread
    public void openGooglePlayStoreLink(String s) {
        try {
            this.context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(("market://details?id=" + s))));
        }
        catch(Exception unused_ex) {
            this.context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(("https://play.google.com/store/apps/details?id=" + s))));
        }
    }
}

