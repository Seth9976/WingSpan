package com.unity3d.player;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public class PermissionFragment extends Fragment {
    class b implements Runnable {
        private IPermissionRequestCallbacks a;
        private String b;
        private int c;
        private boolean d;

        b(IPermissionRequestCallbacks iPermissionRequestCallbacks0, String s, int v, boolean z) {
            this.a = iPermissionRequestCallbacks0;
            this.b = s;
            this.c = v;
            this.d = z;
        }

        @Override
        public void run() {
            int v = this.c;
            if(v == -1) {
                if(Build.VERSION.SDK_INT < 30 && !this.d) {
                    this.a.onPermissionDeniedAndDontAskAgain(this.b);
                    return;
                }
                this.a.onPermissionDenied(this.b);
                return;
            }
            if(v == 0) {
                this.a.onPermissionGranted(this.b);
            }
        }
    }

    public static final String PERMISSION_NAMES = "PermissionNames";
    public static final int UNITY_PERMISSION_REQUEST_CODE = 96489;
    private final Activity m_Activity;
    private final Looper m_Looper;
    private final IPermissionRequestCallbacks m_ResultCallbacks;

    public PermissionFragment() {
        this.m_ResultCallbacks = null;
        this.m_Activity = null;
        this.m_Looper = null;
    }

    public PermissionFragment(Activity activity0, IPermissionRequestCallbacks iPermissionRequestCallbacks0) {
        this.m_ResultCallbacks = iPermissionRequestCallbacks0;
        this.m_Activity = activity0;
        this.m_Looper = Looper.myLooper();
    }

    @Override  // android.app.Fragment
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        this.requestPermissions(this.getArguments().getStringArray("PermissionNames"), 96489);
    }

    @Override  // android.app.Fragment
    public void onRequestPermissionsResult(int v, String[] arr_s, int[] arr_v) {
        class a implements Runnable {
            final String[] a;
            final PermissionFragment b;

            a(String[] arr_s) {
                this.a = arr_s;
                super();
            }

            @Override
            public void run() {
                PermissionFragment.this.reportAllDenied(this.a);
            }
        }

        if(v != 96489) {
            return;
        }
        if(arr_s.length != 0) {
            for(int v1 = 0; v1 < arr_s.length && v1 < arr_v.length; ++v1) {
                int v2 = arr_v[v1];
                IPermissionRequestCallbacks iPermissionRequestCallbacks0 = this.m_ResultCallbacks;
                if(iPermissionRequestCallbacks0 != null && this.m_Activity != null && this.m_Looper != null) {
                    if(iPermissionRequestCallbacks0 instanceof ModalWaitForPermissionResponse) {
                        iPermissionRequestCallbacks0.onPermissionGranted(arr_s[v1]);
                    }
                    else {
                        String s = arr_s[v1];
                        if(s == null) {
                            s = "<null>";
                        }
                        Handler handler0 = new Handler(this.m_Looper);
                        int v3 = arr_v[v1];
                        boolean z = this.m_Activity.shouldShowRequestPermissionRationale(s);
                        handler0.post(new b(this, this.m_ResultCallbacks, s, v3, z));
                    }
                }
            }
        }
        else if(this.m_ResultCallbacks != null && this.m_Activity != null && this.m_Looper != null) {
            String[] arr_s1 = this.getArguments().getStringArray("PermissionNames");
            if(this.m_ResultCallbacks instanceof ModalWaitForPermissionResponse) {
                this.reportAllDenied(arr_s1);
            }
            else {
                new Handler(this.m_Looper).post(new a(this, arr_s1));
            }
        }
        FragmentTransaction fragmentTransaction0 = this.getActivity().getFragmentManager().beginTransaction();
        fragmentTransaction0.remove(this);
        fragmentTransaction0.commit();
    }

    private void reportAllDenied(String[] arr_s) {
        for(int v = 0; v < arr_s.length; ++v) {
            this.m_ResultCallbacks.onPermissionDenied(arr_s[v]);
        }
    }
}

