package com.unity3d.player;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

public class UnityPermissions {
    public static class ModalWaitForPermissionResponse implements IPermissionRequestCallbacks {
        private boolean haveResponse;

        public ModalWaitForPermissionResponse() {
            this.haveResponse = false;
        }

        @Override  // com.unity3d.player.IPermissionRequestCallbacks
        public void onPermissionDenied(String s) {
            synchronized(this) {
                this.haveResponse = true;
                this.notify();
            }
        }

        @Override  // com.unity3d.player.IPermissionRequestCallbacks
        public void onPermissionDeniedAndDontAskAgain(String s) {
            synchronized(this) {
                this.haveResponse = true;
                this.notify();
            }
        }

        @Override  // com.unity3d.player.IPermissionRequestCallbacks
        public void onPermissionGranted(String s) {
            synchronized(this) {
                this.haveResponse = true;
                this.notify();
            }
        }

        public void waitForResponse() {
            synchronized(this) {
                if(this.haveResponse) {
                    return;
                }
                try {
                    this.wait();
                }
                catch(InterruptedException unused_ex) {
                }
            }
        }
    }

    private static final String SKIP_DIALOG_METADATA_NAME = "unityplayer.SkipPermissionsDialog";

    private static boolean checkInfoForMetadata(PackageItemInfo packageItemInfo0) {
        try {
            return packageItemInfo0.metaData.getBoolean("unityplayer.SkipPermissionsDialog");
        }
        catch(Exception unused_ex) {
            return false;
        }
    }

    public static boolean hasUserAuthorizedPermission(Context context0, String s) {
        return context0.checkCallingOrSelfPermission(s) == 0;
    }

    public static void requestUserPermissions(Activity activity0, String[] arr_s, IPermissionRequestCallbacks iPermissionRequestCallbacks0) {
        if(!PlatformSupport.MARSHMALLOW_SUPPORT) {
            return;
        }
        if(activity0 != null && arr_s != null) {
            FragmentManager fragmentManager0 = activity0.getFragmentManager();
            if(fragmentManager0.findFragmentByTag("96489") == null) {
                PermissionFragment permissionFragment0 = new PermissionFragment(activity0, iPermissionRequestCallbacks0);
                Bundle bundle0 = new Bundle();
                bundle0.putStringArray("PermissionNames", arr_s);
                permissionFragment0.setArguments(bundle0);
                FragmentTransaction fragmentTransaction0 = fragmentManager0.beginTransaction();
                fragmentTransaction0.add(0, permissionFragment0, "96489");
                fragmentTransaction0.commit();
            }
        }
    }

    public static boolean skipPermissionsDialog(Activity activity0) {
        if(!PlatformSupport.MARSHMALLOW_SUPPORT) {
            return false;
        }
        try {
            PackageManager packageManager0 = activity0.getPackageManager();
            ActivityInfo activityInfo0 = packageManager0.getActivityInfo(activity0.getComponentName(), 0x80);
            ApplicationInfo applicationInfo0 = packageManager0.getApplicationInfo("com.MonsterCouch.Wingspan", 0x80);
            if(UnityPermissions.checkInfoForMetadata(activityInfo0) || UnityPermissions.checkInfoForMetadata(applicationInfo0)) {
                return true;
            }
        }
        catch(Exception unused_ex) {
        }
        return false;
    }
}

