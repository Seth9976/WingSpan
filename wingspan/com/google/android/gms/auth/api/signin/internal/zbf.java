package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.Status;

final class zbf extends zba {
    final zbg zba;

    zbf(zbg zbg0) {
        this.zba = zbg0;
        super();
    }

    @Override  // com.google.android.gms.auth.api.signin.internal.zba
    public final void zbd(GoogleSignInAccount googleSignInAccount0, Status status0) throws RemoteException {
        if(googleSignInAccount0 != null) {
            zbn.zbc(this.zba.zba).zbe(this.zba.zbb, googleSignInAccount0);
        }
        GoogleSignInResult googleSignInResult0 = new GoogleSignInResult(googleSignInAccount0, status0);
        this.zba.setResult(googleSignInResult0);
    }
}

