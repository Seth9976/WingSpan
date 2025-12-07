package com.voxelbusters.essentialkit.utilities.helpers;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.Toast;
import com.voxelbusters.essentialkit.utilities.PermissionUtil;
import com.voxelbusters.essentialkit.utilities.helpers.interfaces.IPermissionRequestCallback;
import java.util.HashMap;

public class PermissionRequestFragment extends Fragment {
    public static final String MESSAGE_INFO = "MessageInfo";
    public final int PERMISSIONS_REQUEST_CODE;
    public static final String PERMISSION_LIST = "PermissionList";
    public HashMap afterRequestRationale;
    public HashMap beforeRequestRationale;
    private String infoMessage;
    private IPermissionRequestCallback m_callback;

    public PermissionRequestFragment() {
        this.PERMISSIONS_REQUEST_CODE = 0x6F;
        this.beforeRequestRationale = new HashMap();
        this.afterRequestRationale = new HashMap();
    }

    @Override  // android.app.Fragment
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        String[] arr_s = this.getArguments().getStringArray("PermissionList");
        this.infoMessage = this.getArguments().getString("MessageInfo");
        this.updateRequestRationaleStatus(this.beforeRequestRationale, arr_s);
        this.requestPermissions(arr_s, 0x6F);
        this.beforeRequestRationale.containsValue(Boolean.TRUE);
    }

    @Override  // android.app.Fragment
    public void onRequestPermissionsResult(int v, String[] arr_s, int[] arr_v) {
        if(v == 0x6F) {
            if(PermissionUtil.verifyPermissions(arr_v)) {
                IPermissionRequestCallback iPermissionRequestCallback1 = this.m_callback;
                if(iPermissionRequestCallback1 != null) {
                    iPermissionRequestCallback1.onPermissionGrant();
                }
            }
            else {
                this.updateRequestRationaleStatus(this.afterRequestRationale, arr_s);
                boolean z = false;
                for(int v1 = 0; v1 < arr_s.length; ++v1) {
                    String s = arr_s[v1];
                    boolean z1 = ((Boolean)this.beforeRequestRationale.get(s)).booleanValue();
                    boolean z2 = ((Boolean)this.afterRequestRationale.get(s)).booleanValue();
                    z = z1 && !z2 || !z1 && !z2;
                    if(z) {
                        break;
                    }
                }
                if(z && arr_s.length >= 1) {
                    Toast.makeText(this.getActivity(), "Please enable the permission from application settings.", 0).show();
                }
                IPermissionRequestCallback iPermissionRequestCallback0 = this.m_callback;
                if(iPermissionRequestCallback0 != null) {
                    iPermissionRequestCallback0.onPermissionDeny();
                }
            }
        }
        FragmentTransaction fragmentTransaction0 = this.getActivity().getFragmentManager().beginTransaction();
        fragmentTransaction0.remove(this);
        fragmentTransaction0.commit();
    }

    public void setCallback(IPermissionRequestCallback iPermissionRequestCallback0) {
        this.m_callback = iPermissionRequestCallback0;
    }

    public void updateRequestRationaleStatus(HashMap hashMap0, String[] arr_s) {
        for(int v = 0; v < arr_s.length; ++v) {
            Boolean boolean0 = Boolean.valueOf(this.shouldShowRequestPermissionRationale(arr_s[v]));
            hashMap0.put(arr_s[v], boolean0);
        }
    }
}

