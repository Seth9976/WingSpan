package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;

public class AccountAccessor extends Stub {
    @Override
    public final boolean equals(Object object0) {
        throw null;
    }

    public static Account getAccountBinderSafe(IAccountAccessor iAccountAccessor0) {
        Account account0 = null;
        if(iAccountAccessor0 != null) {
            long v = Binder.clearCallingIdentity();
            try {
                account0 = iAccountAccessor0.zzb();
            }
            catch(RemoteException unused_ex) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            }
            finally {
                Binder.restoreCallingIdentity(v);
            }
            return account0;
        }
        return null;
    }

    @Override  // com.google.android.gms.common.internal.IAccountAccessor
    public final Account zzb() {
        throw null;
    }
}

