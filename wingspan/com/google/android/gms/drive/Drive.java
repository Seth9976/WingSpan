package com.google.android.gms.drive;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.drive.zzaf;
import com.google.android.gms.internal.drive.zzbb;
import com.google.android.gms.internal.drive.zzbr;
import com.google.android.gms.internal.drive.zzcb;
import com.google.android.gms.internal.drive.zzch;
import com.google.android.gms.internal.drive.zzeb;
import java.util.Set;

@Deprecated
public final class Drive {
    public static final class zza implements HasGoogleSignInAccountOptions {
        private final GoogleSignInAccount zzaa;
        private final Bundle zzz;

        public zza(GoogleSignInAccount googleSignInAccount0) {
            this.zzz = new Bundle();
            this.zzaa = googleSignInAccount0;
        }

        @Override
        public final boolean equals(Object object0) {
            if(object0 == this) {
                return true;
            }
            if(object0 != null && object0.getClass() == this.getClass()) {
                GoogleSignInAccount googleSignInAccount0 = ((zza)object0).getGoogleSignInAccount();
                if(!Objects.equal(this.zzaa, googleSignInAccount0)) {
                    return false;
                }
                String s = this.zzz.getString("method_trace_filename");
                String s1 = ((zza)object0).zzz.getString("method_trace_filename");
                return (s == null && s1 == null || s != null && s1 != null && s.equals(s1)) && this.zzz.getBoolean("bypass_initial_sync") == ((zza)object0).zzz.getBoolean("bypass_initial_sync") && this.zzz.getInt("proxy_type") == ((zza)object0).zzz.getInt("proxy_type");
            }
            return false;
        }

        @Override  // com.google.android.gms.common.api.Api$ApiOptions$HasGoogleSignInAccountOptions
        public final GoogleSignInAccount getGoogleSignInAccount() {
            return this.zzaa;
        }

        @Override
        public final int hashCode() {
            String s = this.zzz.getString("method_trace_filename", "");
            int v = this.zzz.getInt("proxy_type");
            boolean z = this.zzz.getBoolean("bypass_initial_sync");
            return Objects.hashCode(new Object[]{this.zzaa, s, v, Boolean.valueOf(z)});
        }

        public final Bundle zzh() {
            return this.zzz;
        }
    }

    public static final class zzb implements Optional {
    }

    @Deprecated
    public static final Api API;
    public static final ClientKey CLIENT_KEY;
    @Deprecated
    public static final DriveApi DriveApi;
    @Deprecated
    public static final DrivePreferencesApi DrivePreferencesApi;
    public static final Scope SCOPE_APPFOLDER;
    public static final Scope SCOPE_FILE;
    private static final AbstractClientBuilder zzq;
    private static final AbstractClientBuilder zzr;
    private static final AbstractClientBuilder zzs;
    private static final Scope zzt;
    private static final Scope zzu;
    private static final Api zzv;
    public static final Api zzw;
    @Deprecated
    private static final zzj zzx;
    private static final zzl zzy;

    static {
        ClientKey api$ClientKey0 = new ClientKey();
        Drive.CLIENT_KEY = api$ClientKey0;
        zze zze0 = new zze();
        Drive.zzq = zze0;
        zzf zzf0 = new zzf();
        Drive.zzr = zzf0;
        zzg zzg0 = new zzg();
        Drive.zzs = zzg0;
        Drive.SCOPE_FILE = new Scope("https://www.googleapis.com/auth/drive.file");
        Drive.SCOPE_APPFOLDER = new Scope("https://www.googleapis.com/auth/drive.appdata");
        Drive.zzt = new Scope("https://www.googleapis.com/auth/drive");
        Drive.zzu = new Scope("https://www.googleapis.com/auth/drive.apps");
        Drive.API = new Api("Drive.API", zze0, api$ClientKey0);
        Drive.zzv = new Api("Drive.INTERNAL_API", zzf0, api$ClientKey0);
        Drive.zzw = new Api("Drive.API_CONNECTIONLESS", zzg0, api$ClientKey0);
        Drive.DriveApi = new zzaf();
        Drive.zzx = new zzbr();
        Drive.zzy = new zzeb();
        Drive.DrivePreferencesApi = new zzcb();
    }

    @Deprecated
    public static DriveClient getDriveClient(Activity activity0, GoogleSignInAccount googleSignInAccount0) {
        Drive.zza(googleSignInAccount0);
        return new zzbb(activity0, new zza(googleSignInAccount0));
    }

    @Deprecated
    public static DriveClient getDriveClient(Context context0, GoogleSignInAccount googleSignInAccount0) {
        Drive.zza(googleSignInAccount0);
        return new zzbb(context0, new zza(googleSignInAccount0));
    }

    @Deprecated
    public static DriveResourceClient getDriveResourceClient(Activity activity0, GoogleSignInAccount googleSignInAccount0) {
        Drive.zza(googleSignInAccount0);
        return new zzch(activity0, new zza(googleSignInAccount0));
    }

    @Deprecated
    public static DriveResourceClient getDriveResourceClient(Context context0, GoogleSignInAccount googleSignInAccount0) {
        Drive.zza(googleSignInAccount0);
        return new zzch(context0, new zza(googleSignInAccount0));
    }

    private static void zza(GoogleSignInAccount googleSignInAccount0) {
        Preconditions.checkNotNull(googleSignInAccount0);
        Set set0 = googleSignInAccount0.getRequestedScopes();
        Preconditions.checkArgument(set0.contains(Drive.SCOPE_FILE) || set0.contains(Drive.SCOPE_APPFOLDER) || set0.contains(Drive.zzt) || set0.contains(Drive.zzu), "You must request a Drive scope in order to interact with the Drive API.");
    }
}

