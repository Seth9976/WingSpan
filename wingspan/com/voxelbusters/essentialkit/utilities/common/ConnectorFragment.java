package com.voxelbusters.essentialkit.utilities.common;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.voxelbusters.essentialkit.utilities.Logger;
import com.voxelbusters.essentialkit.utilities.common.interfaces.IFragmentResultListener;

public class ConnectorFragment extends Fragment {
    public final int RequestCode;
    public Intent intentToLaunch;
    public IFragmentResultListener listener;

    public ConnectorFragment() {
        this.RequestCode = 0x6F;
    }

    private void close() {
        FragmentTransaction fragmentTransaction0 = this.getFragmentManager().beginTransaction();
        fragmentTransaction0.remove(this);
        fragmentTransaction0.commitAllowingStateLoss();
    }

    public static void launchIntent(Intent intent0, Activity activity0, IFragmentResultListener iFragmentResultListener0) {
        if(intent0 != null) {
            System.out.println("Launching intent : " + intent0);
            ConnectorFragment connectorFragment0 = new ConnectorFragment();
            connectorFragment0.setListener(iFragmentResultListener0);
            connectorFragment0.setIntentToLaunch(intent0);
            FragmentTransaction fragmentTransaction0 = activity0.getFragmentManager().beginTransaction();
            fragmentTransaction0.add(0, connectorFragment0);
            fragmentTransaction0.commitAllowingStateLoss();
            return;
        }
        Logger.error("Cannot launch an empty intent!");
    }

    @Override  // android.app.Fragment
    public void onActivityResult(int v, int v1, Intent intent0) {
        super.onActivityResult(v, v1, intent0);
        IFragmentResultListener iFragmentResultListener0 = this.listener;
        if(iFragmentResultListener0 != null) {
            iFragmentResultListener0.onResult(v1, intent0, true);
        }
        this.close();
    }

    @Override  // android.app.Fragment
    public void onAttach(Activity activity0) {
        super.onAttach(activity0);
        this.onContextAttached(activity0);
    }

    private void onContextAttached(Context context0) {
        PackageManager packageManager0 = context0.getPackageManager();
        if(this.intentToLaunch == null) {
            Logger.error("Intent to launch is null which is unexpected. Closing this fragment");
        }
        if(this.intentToLaunch != null && this.intentToLaunch.resolveActivity(packageManager0) != null) {
            this.startActivityForResult(this.intentToLaunch, 0x6F);
            return;
        }
        IFragmentResultListener iFragmentResultListener0 = this.listener;
        if(iFragmentResultListener0 != null) {
            iFragmentResultListener0.onResult(0, null, false);
        }
        this.close();
    }

    private void setIntentToLaunch(Intent intent0) {
        this.intentToLaunch = intent0;
    }

    private void setListener(IFragmentResultListener iFragmentResultListener0) {
        this.listener = iFragmentResultListener0;
    }
}

