package com.unity3d.plugin.downloader.d;

import android.text.TextUtils;
import android.util.Log;
import com.unity3d.plugin.downloader.e.a;
import com.unity3d.plugin.downloader.e.b;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;

final class i {
    private final l a;
    private final h b;
    private final int c;
    private final String d;
    private final String e;
    private final c f;

    i(l l0, c c0, h h0, int v, String s, String s1) {
        this.a = l0;
        this.f = c0;
        this.b = h0;
        this.c = v;
        this.d = s;
        this.e = s1;
    }

    private void a(int v, n n0) {
        this.a.a(v, n0);
        if(this.a.c()) {
            this.b.a();
            return;
        }
        this.b.a(v);
    }

    public final h a() {
        return this.b;
    }

    public final void a(PublicKey publicKey0, int v, String s, String s1) {
        n n0;
        n n1;
        if(v == 0 || v == 1 || v == 2) {
            try {
                if(TextUtils.isEmpty(s)) {
                    Log.e("LicenseValidator", "Signature verification failed: signedData is empty. (Device not signed-in to any Google accounts?)");
                    this.e();
                    return;
                }
                Signature signature0 = Signature.getInstance("SHA1withRSA");
                signature0.initVerify(publicKey0);
                signature0.update(s.getBytes());
                if(!signature0.verify(a.a(s1))) {
                    Log.e("LicenseValidator", "Signature verification failed.");
                    this.e();
                    return;
                }
            }
            catch(NoSuchAlgorithmException noSuchAlgorithmException0) {
                throw new RuntimeException(noSuchAlgorithmException0);
            }
            catch(InvalidKeyException unused_ex) {
                this.d();
                return;
            }
            catch(SignatureException signatureException0) {
                throw new RuntimeException(signatureException0);
            }
            catch(b unused_ex) {
                Log.e("LicenseValidator", "Could not Base64-decode signature.");
                this.e();
                return;
            }
            try {
                String s2 = "";
                int v1 = s.indexOf(58);
                if(-1 != v1) {
                    String s3 = s.substring(0, v1);
                    if(v1 < s.length()) {
                        s2 = s.substring(v1 + 1);
                    }
                    s = s3;
                }
                String[] arr_s = TextUtils.split(s, "\\Q|\\E");
                if(arr_s.length >= 6) {
                    n1 = new n();
                    n1.g = s2;
                    n1.a = Integer.parseInt(arr_s[0]);
                    n1.b = Integer.parseInt(arr_s[1]);
                    n1.c = arr_s[2];
                    n1.d = arr_s[3];
                    n1.e = arr_s[4];
                    n1.f = Long.parseLong(arr_s[5]);
                    if(n1.a != v) {
                        goto label_41;
                    }
                    goto label_44;
                }
            }
            catch(IllegalArgumentException unused_ex) {
            }
            Log.e("LicenseValidator", "Could not parse response.");
            this.e();
            return;
        label_41:
            Log.e("LicenseValidator", "Response codes don\'t match.");
            this.e();
            return;
        label_44:
            if(n1.b != this.c) {
                Log.e("LicenseValidator", "Nonce doesn\'t match.");
                this.e();
                return;
            }
            if(!n1.c.equals(this.d)) {
                Log.e("LicenseValidator", "Package name doesn\'t match.");
                this.e();
                return;
            }
            if(!n1.d.equals(this.e)) {
                Log.e("LicenseValidator", "Version codes don\'t match.");
                this.e();
                return;
            }
            if(TextUtils.isEmpty(n1.e)) {
                Log.e("LicenseValidator", "User identifier is empty.");
                this.e();
                return;
            }
            n0 = n1;
        }
        else {
            n0 = null;
        }
        switch(v) {
            case 1: {
                this.a(561, n0);
                return;
            }
            case 0: 
            case 2: {
                this.a(0x100, n0);
                return;
            }
            case 3: {
                this.d();
                return;
            }
            case 4: {
                Log.w("LicenseValidator", "An error has occurred on the licensing server.");
                this.a(291, n0);
                return;
            }
            case 5: {
                Log.w("LicenseValidator", "Licensing server is refusing to talk to this device, over quota.");
                this.a(291, n0);
                return;
            }
            case 0x101: {
                Log.w("LicenseValidator", "Error contacting licensing server.");
                this.a(291, n0);
                return;
            }
            case 0x102: {
                this.d();
                return;
            }
            case 0x103: {
                this.d();
                return;
            }
            default: {
                Log.e("LicenseValidator", "Unknown response code for license check.");
                this.e();
            }
        }
    }

    public final int b() {
        return this.c;
    }

    public final String c() {
        return this.d;
    }

    private void d() {
        this.b.b();
    }

    private void e() {
        this.b.a(561);
    }
}

