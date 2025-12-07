package com.voxelbusters.essentialkit.socialauth;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.games.Player;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.voxelbusters.essentialkit.utilities.Logger;
import com.voxelbusters.essentialkit.utilities.ResourcesUtil;
import com.voxelbusters.essentialkit.utilities.StringUtil;
import com.voxelbusters.essentialkit.utilities.common.ConnectorFragment;
import com.voxelbusters.essentialkit.utilities.common.interfaces.IFragmentResultListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GoogleAuth {
    public interface g {
        void a(GoogleSignInAccount arg1);

        void a(String arg1, int arg2);
    }

    public static final String SAVED_INFO_KEYS_FILE = "np-saved-game-services-keys-data";
    public static final String SERVER_AUTH_CODE_SAVE_KEY = "server-auth-code";
    private final String TAG;
    private boolean authConnectionInProgress;
    private List authenticationListeners;
    private Context context;
    private Player currentPlayer;
    private String idToken;
    private String serverAuthCode;
    private static GoogleAuth sharedInstance;
    private GoogleSignInClient signInClient;
    private boolean signedIn;

    private GoogleAuth(Context context0) {
        this.TAG = "GoogleSignIn";
        this.authenticationListeners = new ArrayList();
        this.context = context0;
    }

    public void Authenticate(boolean z) {
        public final class a implements g {
            public final GoogleAuth a;

            @Override  // com.voxelbusters.essentialkit.socialauth.GoogleAuth$g
            public final void a(GoogleSignInAccount googleSignInAccount0) {
                GoogleAuth.this.authConnectionInProgress = false;
                GoogleAuth.this.onConnectionSuccess(googleSignInAccount0);
            }

            @Override  // com.voxelbusters.essentialkit.socialauth.GoogleAuth$g
            public final void a(String s, int v) {
                public final class com.voxelbusters.essentialkit.socialauth.GoogleAuth.a.a implements DialogInterface.OnClickListener {
                    public final String a;
                    public final int b;
                    public final a c;

                    public com.voxelbusters.essentialkit.socialauth.GoogleAuth.a.a(String s, int v) {
                        this.a = s;
                        this.b = v;
                        super();
                    }

                    @Override  // android.content.DialogInterface$OnClickListener
                    public final void onClick(DialogInterface dialogInterface0, int v) {
                        dialogInterface0.dismiss();
                        GoogleAuth.this.onConnectionFailure(this.a, this.b);
                    }
                }

                GoogleAuth.this.authConnectionInProgress = false;
                if(ResourcesUtil.getBoolean(GoogleAuth.this.context, "GAME_SERVICES_SHOW_ERROR_DIALOGS") && !StringUtil.isNullOrEmpty(s)) {
                    new AlertDialog.Builder(GoogleAuth.this.context).setMessage(s).setNeutralButton(0x104000A, new com.voxelbusters.essentialkit.socialauth.GoogleAuth.a.a(this, s, v));
                    return;
                }
                GoogleAuth.this.onConnectionFailure(s, v);
            }
        }

        this.signedIn = false;
        if(this.authConnectionInProgress) {
            return;
        }
        this.authenticateInternal(this.createSigninOptions(false), z, new a(this));
    }

    public void addListener(IAuthenticationListener iAuthenticationListener0) {
        this.removeListener(iAuthenticationListener0);
        this.authenticationListeners.add(iAuthenticationListener0);
    }

    private void authenticateInternal(GoogleSignInOptions googleSignInOptions0, boolean z, g googleAuth$g0) {
        public final class b implements OnSuccessListener {
            public final g a;

            public b(g googleAuth$g0) {
            }

            @Override  // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object object0) {
                Logger.debug("Silent login successful!");
                this.a.a(((GoogleSignInAccount)object0));
            }
        }


        public final class c implements OnFailureListener {
            public final boolean a;
            public final g b;
            public final GoogleAuth c;

            public c(boolean z, g googleAuth$g0) {
                this.a = z;
                this.b = googleAuth$g0;
                super();
            }

            @Override  // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exception0) {
                public final class com.voxelbusters.essentialkit.socialauth.GoogleAuth.c.a implements IFragmentResultListener {
                    public final c a;

                    @Override  // com.voxelbusters.essentialkit.utilities.common.interfaces.IFragmentResultListener
                    public final void onResult(int v, Intent intent0, boolean z) {
                        if(intent0 == null) {
                            Log.e("GoogleAuth", "Unexpected error : Intent data null");
                        }
                        GoogleSignInResult googleSignInResult0 = Auth.GoogleSignInApi.getSignInResultFromIntent(intent0);
                        if(googleSignInResult0.isSuccess()) {
                            c.this.b.a(googleSignInResult0.getSignInAccount());
                            return;
                        }
                        String s = googleSignInResult0.getStatus().getStatusMessage();
                        int v1 = googleSignInResult0.getStatus().getStatusCode();
                        if(StringUtil.isNullOrEmpty(s)) {
                            s = ResourcesUtil.getString(GoogleAuth.this.context, "GAME_SERVICES_SIGN_IN_FAILED");
                        }
                        c.this.b.a(s, v1);
                    }
                }

                if(this.a) {
                    Logger.warning("Silent login failed. Halting sign-in as force silent mode only");
                    this.b.a("", -1);
                    return;
                }
                Logger.warning("Silent login failed. Attempting interactive signin...");
                ConnectorFragment.launchIntent(GoogleAuth.this.signInClient.getSignInIntent(), ((Activity)GoogleAuth.this.context), new com.voxelbusters.essentialkit.socialauth.GoogleAuth.c.a(this));
            }
        }

        this.authConnectionInProgress = true;
        this.signInClient = this.createSignInClient(googleSignInOptions0);
        if(StringUtil.isNullOrEmpty(googleSignInOptions0.getServerClientId())) {
            GoogleSignInAccount googleSignInAccount0 = GoogleSignIn.getLastSignedInAccount(this.context);
            Logger.debug(("Signin options scopes : " + Arrays.toString(googleSignInOptions0.getScopeArray())));
            if(GoogleSignIn.hasPermissions(googleSignInAccount0, googleSignInOptions0.getScopeArray())) {
                Logger.debug("Already have required details from last signin. Logging in with same details...");
                googleAuth$g0.a(googleSignInAccount0);
                return;
            }
        }
        Task task0 = this.signInClient.silentSignIn();
        if(task0.isSuccessful()) {
            Logger.debug("Silent login successful instantly!");
            googleAuth$g0.a(((GoogleSignInAccount)task0.getResult()));
            return;
        }
        task0.addOnSuccessListener(new b(googleAuth$g0));
        task0.addOnFailureListener(new c(this, z, googleAuth$g0));
    }

    private void cacheServerAuthCodeIfExists(String s) {
        this.serverAuthCode = s;
    }

    private void cleanupAuthentication() {
        this.signInClient = null;
        this.signedIn = false;
        this.currentPlayer = null;
        this.clearServerAuthCode();
    }

    private void clearServerAuthCode() {
        SharedPreferences.Editor sharedPreferences$Editor0 = this.context.getSharedPreferences("np-saved-game-services-keys-data", 0).edit();
        sharedPreferences$Editor0.remove("server-auth-code");
        sharedPreferences$Editor0.commit();
    }

    public GoogleSignInClient createSignInClient(GoogleSignInOptions googleSignInOptions0) {
        GoogleSignInClient googleSignInClient0 = GoogleSignIn.getClient(this.context, googleSignInOptions0);
        this.signInClient = googleSignInClient0;
        return googleSignInClient0;
    }

    public GoogleSignInOptions createSigninOptions(boolean z) {
        Builder googleSignInOptions$Builder0 = new Builder(GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN);
        String s = ResourcesUtil.getString(this.context, "GAME_SERVICES_SERVER_CLIENT_ID");
        Boolean boolean0 = Boolean.valueOf(ResourcesUtil.getBoolean(this.context, "GAME_SERVICES_NEEDS_PROFILE_SCOPE"));
        Boolean boolean1 = Boolean.valueOf(ResourcesUtil.getBoolean(this.context, "GAME_SERVICES_NEEDS_EMAIL_SCOPE"));
        Boolean boolean2 = Boolean.valueOf(ResourcesUtil.getBoolean(this.context, "USES_CLOUD_SERVICES"));
        if(!StringUtil.isNullOrEmpty(s)) {
            googleSignInOptions$Builder0 = googleSignInOptions$Builder0.requestServerAuthCode(s, z).requestIdToken(s);
        }
        if(boolean0.booleanValue()) {
            googleSignInOptions$Builder0 = googleSignInOptions$Builder0.requestProfile();
        }
        if(boolean1.booleanValue()) {
            googleSignInOptions$Builder0 = googleSignInOptions$Builder0.requestEmail();
        }
        if(boolean2.booleanValue()) {
            googleSignInOptions$Builder0 = googleSignInOptions$Builder0.requestScopes(new Scope("https://www.googleapis.com/auth/drive.appdata"), new Scope[0]);
        }
        return googleSignInOptions$Builder0.build();
    }

    public void fetchServerAuthCode(IFetchServerCredentials iSocialAuth$IFetchServerCredentials0) {
        public final class f implements g {
            public final IFetchServerCredentials a;

            public f(IFetchServerCredentials iSocialAuth$IFetchServerCredentials0) {
            }

            @Override  // com.voxelbusters.essentialkit.socialauth.GoogleAuth$g
            public final void a(GoogleSignInAccount googleSignInAccount0) {
                this.a.onSuccess(googleSignInAccount0.getServerAuthCode(), googleSignInAccount0.getIdToken(), googleSignInAccount0.getEmail());
            }

            @Override  // com.voxelbusters.essentialkit.socialauth.GoogleAuth$g
            public final void a(String s, int v) {
                this.a.onFailure(s);
            }
        }

        GoogleSignInAccount googleSignInAccount0 = GoogleSignIn.getLastSignedInAccount(this.context);
        if(this.isSignedIn() && googleSignInAccount0 != null) {
            String s = googleSignInAccount0.getServerAuthCode();
            String s1 = googleSignInAccount0.getIdToken();
            String s2 = googleSignInAccount0.getEmail();
            if(!StringUtil.isNullOrEmpty(s) || StringUtil.isNullOrEmpty(ResourcesUtil.getString(this.context, "GAME_SERVICES_SERVER_CLIENT_ID"))) {
                if(iSocialAuth$IFetchServerCredentials0 != null) {
                    iSocialAuth$IFetchServerCredentials0.onSuccess(s, s1, s2);
                }
                return;
            }
        }
        this.authenticateInternal(this.createSigninOptions(false), true, new f(iSocialAuth$IFetchServerCredentials0));
    }

    private String getCachedServerCode() {
        return this.serverAuthCode;
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getIdToken() {
        Logger.debug(("Get Id Token : " + GoogleSignIn.getLastSignedInAccount(this.context).getIdToken()));
        return StringUtil.getNonNull(this.idToken);
    }

    public static GoogleAuth getInstance(Context context0) {
        if(GoogleAuth.sharedInstance == null) {
            GoogleAuth.sharedInstance = new GoogleAuth(context0);
        }
        return GoogleAuth.sharedInstance;
    }

    public String getPlayerEmail() {
        GoogleSignInAccount googleSignInAccount0 = GoogleSignIn.getLastSignedInAccount(this.context);
        return googleSignInAccount0 == null || !this.isSignedIn() ? "" : StringUtil.getNonNull(googleSignInAccount0.getEmail());
    }

    public String getPlayerId() {
        return this.currentPlayer == null ? null : this.currentPlayer.getPlayerId();
    }

    public boolean hasLastSignedInAccount() {
        return GoogleSignIn.getLastSignedInAccount(this.context) != null && this.currentPlayer != null;
    }

    public boolean isSignedIn() {
        return this.signedIn;
    }

    private void notifyListeners(Player player0, String s) {
        for(Object object0: this.authenticationListeners) {
            IAuthenticationListener iAuthenticationListener0 = (IAuthenticationListener)object0;
            if(StringUtil.isNullOrEmpty(s)) {
                iAuthenticationListener0.onSuccess(player0);
            }
            else {
                iAuthenticationListener0.onFailure(s);
            }
        }
    }

    private void onConnectionFailure(String s, int v) {
        this.signedIn = false;
        this.notifyListeners(null, s);
    }

    private void onConnectionSuccess(GoogleSignInAccount googleSignInAccount0) {
        public final class e implements OnCompleteListener {
            public final GoogleAuth a;

            @Override  // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task0) {
                if(task0.isSuccessful()) {
                    Player player0 = (Player)task0.getResult();
                    GoogleAuth.this.currentPlayer = player0;
                    Logger.debug(("Player Id : " + GoogleAuth.this.currentPlayer.getPlayerId() + " Player Name : " + GoogleAuth.this.currentPlayer.getDisplayName()));
                    GoogleAuth.this.notifyListeners(GoogleAuth.this.currentPlayer, null);
                    return;
                }
                Logger.error(task0.getException().getMessage());
                GoogleAuth.this.notifyListeners(null, null);
            }
        }

        this.signedIn = true;
        String s = googleSignInAccount0.getServerAuthCode();
        this.idToken = googleSignInAccount0.getIdToken();
        this.cacheServerAuthCodeIfExists(s);
        Logger.debug(("Server Auth Code : " + s));
        Logger.debug(("Id Token : " + this.idToken));
        GamesClient gamesClient0 = Games.getGamesClient(this.context, googleSignInAccount0);
        gamesClient0.setGravityForPopups((ResourcesUtil.getBoolean(this.context, "GAME_SERVICES_NEEDS_POPUPS_AT_TOP") ? 49 : 81));
        gamesClient0.setViewForPopups(((Activity)this.context).getWindow().getDecorView().getRootView());
        Games.getPlayersClient(this.context, googleSignInAccount0).getCurrentPlayer().addOnCompleteListener(((Activity)this.context), new e(this));
    }

    public void removeListener(IAuthenticationListener iAuthenticationListener0) {
        this.authenticationListeners.remove(iAuthenticationListener0);
    }

    public void signOut(ISignoutCompleteListener iSignoutCompleteListener0) {
        public final class d implements OnCompleteListener {
            public final ISignoutCompleteListener a;
            public final GoogleAuth b;

            public d(ISignoutCompleteListener iSignoutCompleteListener0) {
                this.a = iSignoutCompleteListener0;
                super();
            }

            @Override  // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task0) {
                String s1;
                Player player0;
                GoogleAuth googleAuth0;
                Logger.debug("Signout successful");
                String s = null;
                if(task0.isSuccessful()) {
                    GoogleAuth.this.cleanupAuthentication();
                    GoogleAuth.this.notifyListeners(null, null);
                }
                else {
                    if(task0.getException() == null) {
                        googleAuth0 = GoogleAuth.this;
                        player0 = googleAuth0.currentPlayer;
                        s1 = "Unknown error";
                    }
                    else {
                        googleAuth0 = GoogleAuth.this;
                        player0 = googleAuth0.currentPlayer;
                        s1 = task0.getException().getMessage();
                    }
                    googleAuth0.notifyListeners(player0, s1);
                }
                ISignoutCompleteListener iSignoutCompleteListener0 = this.a;
                if(iSignoutCompleteListener0 != null) {
                    if(!task0.isSuccessful()) {
                        s = task0.getException().getMessage();
                    }
                    iSignoutCompleteListener0.onComplete(s);
                }
            }
        }

        Logger.debug(("Trying signout : " + this.signInClient));
        if(this.isSignedIn()) {
            GoogleSignInClient googleSignInClient0 = this.signInClient;
            if(googleSignInClient0 != null) {
                googleSignInClient0.signOut().addOnCompleteListener(((Activity)this.context), new d(this, iSignoutCompleteListener0));
            }
        }
        else {
            this.cleanupAuthentication();
            this.notifyListeners(null, null);
            if(iSignoutCompleteListener0 != null) {
                iSignoutCompleteListener0.onComplete(null);
            }
        }
    }
}

