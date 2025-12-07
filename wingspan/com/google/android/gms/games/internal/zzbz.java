package com.google.android.gms.games.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.SignOutCallbacks;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.FriendsResolutionRequiredException;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Games.GamesOptions;
import com.google.android.gms.games.GamesClientStatusCodes;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.google.android.gms.games.zzd;
import com.google.android.gms.internal.games.zzfo;
import com.google.android.gms.internal.games.zzfr;
import com.google.android.gms.internal.games.zzft;
import com.google.android.gms.signin.internal.SignInClientImpl;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Set;

public final class zzbz extends GmsClient {
    public static final int zze;
    private final zzfo zzf;
    private final String zzg;
    private PlayerEntity zzh;
    private GameEntity zzi;
    private final zzcf zzj;
    private boolean zzk;
    private final long zzl;
    private final GamesOptions zzm;
    private final zzcg zzn;

    public zzbz(Context context0, Looper looper0, ClientSettings clientSettings0, GamesOptions games$GamesOptions0, ConnectionCallbacks connectionCallbacks0, OnConnectionFailedListener onConnectionFailedListener0, zzcg zzcg0) {
        super(context0, looper0, 1, clientSettings0, connectionCallbacks0, onConnectionFailedListener0);
        this.zzf = new zzq(this);
        this.zzk = false;
        this.zzg = clientSettings0.getRealClientPackageName();
        this.zzn = (zzcg)Preconditions.checkNotNull(zzcg0);
        zzcf zzcf0 = zzcf.zzc(this, clientSettings0.getGravityForPopups());
        this.zzj = zzcf0;
        this.zzl = (long)this.hashCode();
        this.zzm = games$GamesOptions0;
        if(clientSettings0.getViewForPopups() == null && !(context0 instanceof Activity)) {
            return;
        }
        zzcf0.zze(clientSettings0.getViewForPopups());
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api$Client
    public final void connect(ConnectionProgressReportCallbacks baseGmsClient$ConnectionProgressReportCallbacks0) {
        this.zzh = null;
        this.zzi = null;
        super.connect(baseGmsClient$ConnectionProgressReportCallbacks0);
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    protected final IInterface createServiceInterface(IBinder iBinder0) {
        if(iBinder0 == null) {
            return null;
        }
        IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.games.internal.IGamesService");
        return iInterface0 instanceof zzce ? ((zzce)iInterface0) : new zzce(iBinder0);
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api$Client
    public final void disconnect() {
        this.zzk = false;
        if(this.isConnected()) {
            try {
                this.zzf.zzb();
                ((zzce)this.getService()).zzv(this.zzl);
            }
            catch(RemoteException unused_ex) {
                zzft.zzd("GamesGmsClientImpl", "Failed to notify client disconnect.");
            }
        }
        super.disconnect();
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    public final Feature[] getApiFeatures() {
        return zzd.zzf;
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    public final Bundle getConnectionHint() {
        return null;
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    protected final Bundle getGetServiceRequestExtraArgs() {
        String s = this.getContext().getResources().getConfiguration().locale.toString();
        Bundle bundle0 = this.zzm.zza();
        bundle0.putString("com.google.android.gms.games.key.gamePackageName", this.zzg);
        bundle0.putString("com.google.android.gms.games.key.desiredLocale", s);
        bundle0.putParcelable("com.google.android.gms.games.key.popupWindowToken", new BinderWrapper(this.zzj.zzb()));
        if(!bundle0.containsKey("com.google.android.gms.games.key.API_VERSION")) {
            bundle0.putInt("com.google.android.gms.games.key.API_VERSION", 9);
        }
        bundle0.putBundle("com.google.android.gms.games.key.signInOptions", SignInClientImpl.createBundleFromClientSettings(this.getClientSettings()));
        return bundle0;
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api$Client
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override  // com.google.android.gms.common.internal.GmsClient
    public final Set getScopesForConnectionlessNonSignIn() {
        return this.getScopes();
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getServiceDescriptor() {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getStartServiceAction() {
        return "com.google.android.gms.games.service.START";
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    public final void onConnectedLocked(IInterface iInterface0) {
        zzce zzce0 = (zzce)iInterface0;
        super.onConnectedLocked(zzce0);
        if(this.zzk) {
            this.zzj.zzg();
            this.zzk = false;
        }
        try {
            zzce0.zzW(new zzs(new zzfr(this.zzj.zzd())), this.zzl);
        }
        catch(RemoteException remoteException0) {
            zzbz.zzbf(remoteException0);
        }
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    public final void onConnectionFailed(ConnectionResult connectionResult0) {
        super.onConnectionFailed(connectionResult0);
        this.zzk = false;
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    protected final void onPostInitHandler(int v, IBinder iBinder0, Bundle bundle0, int v1) {
        if(v == 0) {
            v = 0;
            if(bundle0 != null) {
                bundle0.setClassLoader(zzbz.class.getClassLoader());
                this.zzk = bundle0.getBoolean("show_welcome_popup");
                this.zzh = (PlayerEntity)bundle0.getParcelable("com.google.android.gms.games.current_player");
                this.zzi = (GameEntity)bundle0.getParcelable("com.google.android.gms.games.current_game");
            }
        }
        super.onPostInitHandler(v, iBinder0, bundle0, v1);
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api$Client
    public final void onUserSignOut(SignOutCallbacks baseGmsClient$SignOutCallbacks0) {
        try {
            this.zzaV(new zzx(baseGmsClient$SignOutCallbacks0));
        }
        catch(RemoteException unused_ex) {
            baseGmsClient$SignOutCallbacks0.onSignOutComplete();
        }
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api$Client
    public final boolean requiresAccount() {
        return true;
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api$Client
    public final boolean requiresSignIn() {
        return true;
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    public final boolean usesClientTelemetry() {
        return true;
    }

    public final Intent zzA() {
        try {
            return this.zzz();
        }
        catch(RemoteException remoteException0) {
            zzbz.zzbf(remoteException0);
            return null;
        }
    }

    public final Intent zzB(String s, boolean z, boolean z1, int v) throws RemoteException {
        return ((zzce)this.getService()).zzm(s, z, z1, v);
    }

    public final Intent zzC(String s, boolean z, boolean z1, int v) {
        try {
            return this.zzB(s, z, z1, v);
        }
        catch(RemoteException remoteException0) {
            zzbz.zzbf(remoteException0);
            return null;
        }
    }

    public final Game zzD() throws RemoteException {
        this.checkConnected();
        synchronized(this) {
            if(this.zzi == null) {
                GameBuffer gameBuffer0 = new GameBuffer(((zzce)this.getService()).zzp());
                try {
                    if(gameBuffer0.getCount() > 0) {
                        this.zzi = new GameEntity(gameBuffer0.get(0));
                    }
                }
                finally {
                    gameBuffer0.release();
                }
            }
            return this.zzi;
        }
    }

    public final Game zzE() {
        try {
            return this.zzD();
        }
        catch(RemoteException remoteException0) {
            zzbz.zzbf(remoteException0);
            return null;
        }
    }

    public final Player zzF() throws RemoteException {
        this.checkConnected();
        synchronized(this) {
            if(this.zzh == null) {
                PlayerBuffer playerBuffer0 = new PlayerBuffer(((zzce)this.getService()).zzq());
                try {
                    if(playerBuffer0.getCount() > 0) {
                        this.zzh = new PlayerEntity(playerBuffer0.get(0));
                    }
                }
                finally {
                    playerBuffer0.release();
                }
            }
            return this.zzh;
        }
    }

    public final Player zzG() {
        try {
            return this.zzF();
        }
        catch(RemoteException remoteException0) {
            zzbz.zzbf(remoteException0);
            return null;
        }
    }

    public final String zzH() throws RemoteException {
        return ((zzce)this.getService()).zzs();
    }

    public final String zzI() {
        try {
            return this.zzH();
        }
        catch(RemoteException remoteException0) {
            zzbz.zzbf(remoteException0);
            return null;
        }
    }

    public final String zzJ(boolean z) throws RemoteException {
        PlayerEntity playerEntity0 = this.zzh;
        return playerEntity0 == null ? ((zzce)this.getService()).zzt() : playerEntity0.getPlayerId();
    }

    public final String zzK(boolean z) {
        try {
            return this.zzJ(true);
        }
        catch(RemoteException remoteException0) {
            zzbz.zzbf(remoteException0);
            return null;
        }
    }

    static void zzL(zzbz zzbz0, TaskCompletionSource taskCompletionSource0) {
        try {
            taskCompletionSource0.setException(FriendsResolutionRequiredException.zza(GamesClientStatusCodes.zzb(0x684F, ((zzce)zzbz0.getService()).zzf())));
        }
        catch(RemoteException remoteException0) {
            taskCompletionSource0.setException(remoteException0);
        }
    }

    final void zzN() {
        if(this.isConnected()) {
            try {
                ((zzce)this.getService()).zzu();
            }
            catch(RemoteException remoteException0) {
                zzbz.zzbf(remoteException0);
            }
        }
    }

    public final void zzO(ResultHolder baseImplementation$ResultHolder0, Snapshot snapshot0, SnapshotMetadataChange snapshotMetadataChange0) throws RemoteException {
        SnapshotContents snapshotContents0 = snapshot0.getSnapshotContents();
        Preconditions.checkState(!snapshotContents0.isClosed(), "Snapshot already closed");
        BitmapTeleporter bitmapTeleporter0 = snapshotMetadataChange0.zza();
        if(bitmapTeleporter0 != null) {
            bitmapTeleporter0.setTempDir(this.getContext().getCacheDir());
        }
        Contents contents0 = snapshotContents0.zza();
        snapshotContents0.zzb();
        try {
            ((zzce)this.getService()).zzw(new zzh(baseImplementation$ResultHolder0), snapshot0.getMetadata().getSnapshotId(), ((SnapshotMetadataChangeEntity)snapshotMetadataChange0), contents0);
        }
        catch(SecurityException securityException0) {
            zzbz.zzbg(baseImplementation$ResultHolder0, securityException0);
        }
    }

    public final void zzP(TaskCompletionSource taskCompletionSource0, Snapshot snapshot0, SnapshotMetadataChange snapshotMetadataChange0) throws RemoteException {
        SnapshotContents snapshotContents0 = snapshot0.getSnapshotContents();
        Preconditions.checkState(!snapshotContents0.isClosed(), "Snapshot already closed");
        BitmapTeleporter bitmapTeleporter0 = snapshotMetadataChange0.zza();
        if(bitmapTeleporter0 != null) {
            bitmapTeleporter0.setTempDir(this.getContext().getCacheDir());
        }
        Contents contents0 = snapshotContents0.zza();
        snapshotContents0.zzb();
        try {
            ((zzce)this.getService()).zzw(new zzag(taskCompletionSource0), snapshot0.getMetadata().getSnapshotId(), ((SnapshotMetadataChangeEntity)snapshotMetadataChange0), contents0);
        }
        catch(SecurityException securityException0) {
            GamesStatusUtils.zzb(taskCompletionSource0, securityException0);
        }
    }

    public final void zzQ(ResultHolder baseImplementation$ResultHolder0, String s) throws RemoteException {
        try {
            ((zzce)this.getService()).zzx(new zzi(baseImplementation$ResultHolder0), s);
        }
        catch(SecurityException securityException0) {
            zzbz.zzbg(baseImplementation$ResultHolder0, securityException0);
        }
    }

    public final void zzR(TaskCompletionSource taskCompletionSource0, String s) throws RemoteException {
        try {
            ((zzce)this.getService()).zzx(new zzai(taskCompletionSource0), s);
        }
        catch(SecurityException securityException0) {
            GamesStatusUtils.zzb(taskCompletionSource0, securityException0);
        }
    }

    public final void zzS(Snapshot snapshot0) throws RemoteException {
        SnapshotContents snapshotContents0 = snapshot0.getSnapshotContents();
        Preconditions.checkState(!snapshotContents0.isClosed(), "Snapshot already closed");
        Contents contents0 = snapshotContents0.zza();
        snapshotContents0.zzb();
        ((zzce)this.getService()).zzy(contents0);
    }

    public final void zzT(Snapshot snapshot0) {
        try {
            this.zzS(snapshot0);
        }
        catch(RemoteException remoteException0) {
            zzbz.zzbf(remoteException0);
        }
    }

    public final void zzU(ResultHolder baseImplementation$ResultHolder0) throws RemoteException {
        try {
            ((zzce)this.getService()).zzB(new zzj(baseImplementation$ResultHolder0));
        }
        catch(SecurityException securityException0) {
            zzbz.zzbg(baseImplementation$ResultHolder0, securityException0);
        }
    }

    public final void zzV(TaskCompletionSource taskCompletionSource0) throws RemoteException {
        try {
            ((zzce)this.getService()).zzB(new zzbk(taskCompletionSource0));
        }
        catch(SecurityException securityException0) {
            GamesStatusUtils.zzb(taskCompletionSource0, securityException0);
        }
    }

    public final void zzW(ResultHolder baseImplementation$ResultHolder0) throws RemoteException {
        try {
            ((zzce)this.getService()).zzz(new zzk(baseImplementation$ResultHolder0));
        }
        catch(SecurityException securityException0) {
            zzbz.zzbg(baseImplementation$ResultHolder0, securityException0);
        }
    }

    public final void zzX(TaskCompletionSource taskCompletionSource0) throws RemoteException {
        try {
            ((zzce)this.getService()).zzz(new zzbh(taskCompletionSource0));
        }
        catch(SecurityException securityException0) {
            GamesStatusUtils.zzb(taskCompletionSource0, securityException0);
        }
    }

    public final void zzY(TaskCompletionSource taskCompletionSource0, boolean z) throws RemoteException {
        try {
            ((zzce)this.getService()).zzQ(new zzbp(taskCompletionSource0), null, z);
        }
        catch(SecurityException securityException0) {
            GamesStatusUtils.zzb(taskCompletionSource0, securityException0);
        }
    }

    public final void zzZ(ResultHolder baseImplementation$ResultHolder0, String s, int v) throws RemoteException {
        zzz zzz0 = baseImplementation$ResultHolder0 == null ? null : new zzz(baseImplementation$ResultHolder0);
        try {
            IInterface iInterface0 = this.getService();
            Bundle bundle0 = this.zzj.zza();
            ((zzce)iInterface0).zzC(zzz0, s, v, this.zzj.zzb(), bundle0);
        }
        catch(SecurityException securityException0) {
            zzbz.zzbg(baseImplementation$ResultHolder0, securityException0);
        }
    }

    public final void zzaA(ResultHolder baseImplementation$ResultHolder0, boolean z) throws RemoteException {
        try {
            ((zzce)this.getService()).zzP(new zzg(baseImplementation$ResultHolder0), z);
        }
        catch(SecurityException securityException0) {
            zzbz.zzbg(baseImplementation$ResultHolder0, securityException0);
        }
    }

    public final void zzaB(TaskCompletionSource taskCompletionSource0, boolean z) throws RemoteException {
        try {
            ((zzce)this.getService()).zzP(new zzbm(taskCompletionSource0), z);
        }
        catch(SecurityException securityException0) {
            GamesStatusUtils.zzb(taskCompletionSource0, securityException0);
        }
    }

    public final void zzaC(ResultHolder baseImplementation$ResultHolder0, String s, int v, boolean z, boolean z1) throws RemoteException {
        try {
            ((zzce)this.getService()).zzR(new zzbn(baseImplementation$ResultHolder0), "played_with", v, z, z1);
        }
        catch(SecurityException securityException0) {
            zzbz.zzbg(baseImplementation$ResultHolder0, securityException0);
        }
    }

    public final void zzaD(TaskCompletionSource taskCompletionSource0, String s, int v, boolean z, boolean z1) throws RemoteException {
        if(!s.equals("played_with") && !s.equals("friends_all")) {
            throw new IllegalArgumentException("Invalid player collection: " + s);
        }
        try {
            ((zzce)this.getService()).zzR(new zzbo(this, taskCompletionSource0), s, v, z, z1);
        }
        catch(SecurityException securityException0) {
            GamesStatusUtils.zzb(taskCompletionSource0, securityException0);
        }
    }

    public final void zzaE(ResultHolder baseImplementation$ResultHolder0, boolean z) throws RemoteException {
        try {
            ((zzce)this.getService()).zzS(new zzbw(baseImplementation$ResultHolder0), z);
        }
        catch(SecurityException securityException0) {
            zzbz.zzbg(baseImplementation$ResultHolder0, securityException0);
        }
    }

    public final void zzaF(TaskCompletionSource taskCompletionSource0, boolean z) throws RemoteException {
        try {
            ((zzce)this.getService()).zzS(new zzbi(taskCompletionSource0), z);
        }
        catch(SecurityException securityException0) {
            GamesStatusUtils.zzb(taskCompletionSource0, securityException0);
        }
    }

    public final void zzaG(ResultHolder baseImplementation$ResultHolder0, String s, int v, int v1, int v2, boolean z) throws RemoteException {
        try {
            ((zzce)this.getService()).zzT(new zzas(baseImplementation$ResultHolder0), s, v, v1, v2, z);
        }
        catch(SecurityException securityException0) {
            zzbz.zzbg(baseImplementation$ResultHolder0, securityException0);
        }
    }

    public final void zzaH(TaskCompletionSource taskCompletionSource0, String s, int v, int v1, int v2, boolean z) throws RemoteException {
        try {
            ((zzce)this.getService()).zzT(new zzat(this, taskCompletionSource0), s, v, v1, v2, z);
        }
        catch(SecurityException securityException0) {
            GamesStatusUtils.zzb(taskCompletionSource0, securityException0);
        }
    }

    public final void zzaI(ResultHolder baseImplementation$ResultHolder0, String s, boolean z, int v) throws RemoteException {
        try {
            ((zzce)this.getService()).zzU(new zzbt(baseImplementation$ResultHolder0), s, z, v);
        }
        catch(SecurityException securityException0) {
            zzbz.zzbg(baseImplementation$ResultHolder0, securityException0);
        }
    }

    public final void zzaJ(TaskCompletionSource taskCompletionSource0, String s, boolean z, int v) throws RemoteException {
        try {
            ((zzce)this.getService()).zzU(new zzbv(taskCompletionSource0), s, z, v);
        }
        catch(SecurityException securityException0) {
            GamesStatusUtils.zzb(taskCompletionSource0, securityException0);
        }
    }

    public final void zzaK(ListenerHolder listenerHolder0) {
        try {
            ((zzce)this.getService()).zzV(new zzp(listenerHolder0), this.zzl);
        }
        catch(RemoteException remoteException0) {
            zzbz.zzbf(remoteException0);
        }
    }

    public final void zzaL(ListenerHolder listenerHolder0) throws RemoteException {
        ((zzce)this.getService()).zzV(new zzn(listenerHolder0), this.zzl);
    }

    public final void zzaM(ResultHolder baseImplementation$ResultHolder0, String s, String s1, SnapshotMetadataChange snapshotMetadataChange0, SnapshotContents snapshotContents0) throws RemoteException {
        Preconditions.checkState(!snapshotContents0.isClosed(), "SnapshotContents already closed");
        BitmapTeleporter bitmapTeleporter0 = snapshotMetadataChange0.zza();
        if(bitmapTeleporter0 != null) {
            bitmapTeleporter0.setTempDir(this.getContext().getCacheDir());
        }
        Contents contents0 = snapshotContents0.zza();
        snapshotContents0.zzb();
        try {
            ((zzce)this.getService()).zzX(new zzbt(baseImplementation$ResultHolder0), s, s1, ((SnapshotMetadataChangeEntity)snapshotMetadataChange0), contents0);
        }
        catch(SecurityException securityException0) {
            zzbz.zzbg(baseImplementation$ResultHolder0, securityException0);
        }
    }

    public final void zzaN(TaskCompletionSource taskCompletionSource0, String s, String s1, SnapshotMetadataChange snapshotMetadataChange0, SnapshotContents snapshotContents0) throws RemoteException {
        Preconditions.checkState(!snapshotContents0.isClosed(), "SnapshotContents already closed");
        BitmapTeleporter bitmapTeleporter0 = snapshotMetadataChange0.zza();
        if(bitmapTeleporter0 != null) {
            bitmapTeleporter0.setTempDir(this.getContext().getCacheDir());
        }
        Contents contents0 = snapshotContents0.zza();
        snapshotContents0.zzb();
        try {
            ((zzce)this.getService()).zzX(new zzbv(taskCompletionSource0), s, s1, ((SnapshotMetadataChangeEntity)snapshotMetadataChange0), contents0);
        }
        catch(SecurityException securityException0) {
            GamesStatusUtils.zzb(taskCompletionSource0, securityException0);
        }
    }

    public final void zzaO(ResultHolder baseImplementation$ResultHolder0, String s) throws RemoteException {
        zzz zzz0 = baseImplementation$ResultHolder0 == null ? null : new zzz(baseImplementation$ResultHolder0);
        try {
            zzce zzce0 = (zzce)this.getService();
            Bundle bundle0 = this.zzj.zza();
            zzce0.zzY(zzz0, s, this.zzj.zzb(), bundle0);
        }
        catch(SecurityException securityException0) {
            zzbz.zzbg(baseImplementation$ResultHolder0, securityException0);
        }
    }

    public final void zzaP(TaskCompletionSource taskCompletionSource0, String s) throws RemoteException {
        zzab zzab0 = taskCompletionSource0 == null ? null : new zzab(taskCompletionSource0);
        try {
            zzce zzce0 = (zzce)this.getService();
            Bundle bundle0 = this.zzj.zza();
            zzce0.zzY(zzab0, s, this.zzj.zzb(), bundle0);
        }
        catch(SecurityException securityException0) {
            GamesStatusUtils.zzb(taskCompletionSource0, securityException0);
        }
    }

    public final void zzaQ(ResultHolder baseImplementation$ResultHolder0, String s, int v) throws RemoteException {
        zzz zzz0 = baseImplementation$ResultHolder0 == null ? null : new zzz(baseImplementation$ResultHolder0);
        try {
            IInterface iInterface0 = this.getService();
            Bundle bundle0 = this.zzj.zza();
            ((zzce)iInterface0).zzZ(zzz0, s, v, this.zzj.zzb(), bundle0);
        }
        catch(SecurityException securityException0) {
            zzbz.zzbg(baseImplementation$ResultHolder0, securityException0);
        }
    }

    public final void zzaR(TaskCompletionSource taskCompletionSource0, String s, int v) throws RemoteException {
        zzaa zzaa0 = taskCompletionSource0 == null ? null : new zzaa(taskCompletionSource0);
        try {
            IInterface iInterface0 = this.getService();
            Bundle bundle0 = this.zzj.zza();
            ((zzce)iInterface0).zzZ(zzaa0, s, v, this.zzj.zzb(), bundle0);
        }
        catch(SecurityException securityException0) {
            GamesStatusUtils.zzb(taskCompletionSource0, securityException0);
        }
    }

    public final void zzaS(int v) {
        this.zzj.zzf(v);
    }

    public final void zzaT(View view0) {
        this.zzj.zze(view0);
    }

    final void zzaU(IBinder iBinder0, Bundle bundle0) {
        if(this.isConnected()) {
            try {
                ((zzce)this.getService()).zzaa(iBinder0, bundle0);
                this.zzn.zzb();
            }
            catch(RemoteException remoteException0) {
                zzbz.zzbf(remoteException0);
            }
        }
    }

    public final void zzaV(ResultHolder baseImplementation$ResultHolder0) throws RemoteException {
        this.zzf.zzb();
        try {
            ((zzce)this.getService()).zzab(new zzy(baseImplementation$ResultHolder0));
        }
        catch(SecurityException securityException0) {
            zzbz.zzbg(baseImplementation$ResultHolder0, securityException0);
        }
    }

    public final void zzaW(String s, long v, String s1) throws RemoteException {
        try {
            ((zzce)this.getService()).zzac(null, s, v, s1);
        }
        catch(SecurityException unused_ex) {
        }
    }

    public final void zzaX(ResultHolder baseImplementation$ResultHolder0, String s, long v, String s1) throws RemoteException {
        zzu zzu0 = baseImplementation$ResultHolder0 == null ? null : new zzu(baseImplementation$ResultHolder0);
        try {
            ((zzce)this.getService()).zzac(zzu0, s, v, s1);
        }
        catch(SecurityException securityException0) {
            zzbz.zzbg(baseImplementation$ResultHolder0, securityException0);
        }
    }

    public final void zzaY(TaskCompletionSource taskCompletionSource0, String s, long v, String s1) throws RemoteException {
        try {
            ((zzce)this.getService()).zzac(new zzbs(taskCompletionSource0), s, v, s1);
        }
        catch(SecurityException securityException0) {
            GamesStatusUtils.zzb(taskCompletionSource0, securityException0);
        }
    }

    public final void zzaZ(ResultHolder baseImplementation$ResultHolder0, String s) throws RemoteException {
        zzz zzz0 = baseImplementation$ResultHolder0 == null ? null : new zzz(baseImplementation$ResultHolder0);
        try {
            zzce zzce0 = (zzce)this.getService();
            Bundle bundle0 = this.zzj.zza();
            zzce0.zzad(zzz0, s, this.zzj.zzb(), bundle0);
        }
        catch(SecurityException securityException0) {
            zzbz.zzbg(baseImplementation$ResultHolder0, securityException0);
        }
    }

    public final void zzaa(TaskCompletionSource taskCompletionSource0, String s, int v) throws RemoteException {
        zzaa zzaa0 = taskCompletionSource0 == null ? null : new zzaa(taskCompletionSource0);
        try {
            IInterface iInterface0 = this.getService();
            Bundle bundle0 = this.zzj.zza();
            ((zzce)iInterface0).zzC(zzaa0, s, v, this.zzj.zzb(), bundle0);
        }
        catch(SecurityException securityException0) {
            GamesStatusUtils.zzb(taskCompletionSource0, securityException0);
        }
    }

    public final void zzab(String s, int v) {
        this.zzf.zzc(s, v);
    }

    public final void zzac(ResultHolder baseImplementation$ResultHolder0, int v) throws RemoteException {
        try {
            ((zzce)this.getService()).zzE(new zzl(baseImplementation$ResultHolder0), v);
        }
        catch(SecurityException securityException0) {
            zzbz.zzbg(baseImplementation$ResultHolder0, securityException0);
        }
    }

    public final void zzad(TaskCompletionSource taskCompletionSource0, int v) throws RemoteException {
        try {
            ((zzce)this.getService()).zzE(new zzbj(taskCompletionSource0), v);
        }
        catch(SecurityException securityException0) {
            GamesStatusUtils.zzb(taskCompletionSource0, securityException0);
        }
    }

    public final void zzae(ResultHolder baseImplementation$ResultHolder0, boolean z) throws RemoteException {
        try {
            ((zzce)this.getService()).zzF(new zzv(baseImplementation$ResultHolder0), z);
        }
        catch(SecurityException securityException0) {
            zzbz.zzbg(baseImplementation$ResultHolder0, securityException0);
        }
    }

    public final void zzaf(TaskCompletionSource taskCompletionSource0, boolean z) throws RemoteException {
        try {
            ((zzce)this.getService()).zzF(new zzac(taskCompletionSource0), z);
        }
        catch(SecurityException securityException0) {
            GamesStatusUtils.zzb(taskCompletionSource0, securityException0);
        }
    }

    public final void zzag(ResultHolder baseImplementation$ResultHolder0, boolean z) throws RemoteException {
        try {
            ((zzce)this.getService()).zzG(new zzbn(baseImplementation$ResultHolder0), z);
        }
        catch(SecurityException securityException0) {
            zzbz.zzbg(baseImplementation$ResultHolder0, securityException0);
        }
    }

    public final void zzah(TaskCompletionSource taskCompletionSource0, String s, int v, int v1) throws RemoteException {
        try {
            ((zzce)this.getService()).zzA(new zzar(this, taskCompletionSource0), null, s, v, v1);
        }
        catch(SecurityException securityException0) {
            GamesStatusUtils.zzb(taskCompletionSource0, securityException0);
        }
    }

    public final void zzai(ResultHolder baseImplementation$ResultHolder0, boolean z) throws RemoteException {
        this.zzf.zzb();
        try {
            ((zzce)this.getService()).zzH(new zzak(baseImplementation$ResultHolder0), z);
        }
        catch(SecurityException securityException0) {
            zzbz.zzbg(baseImplementation$ResultHolder0, securityException0);
        }
    }

    public final void zzaj(TaskCompletionSource taskCompletionSource0, boolean z) throws RemoteException {
        this.zzf.zzb();
        try {
            ((zzce)this.getService()).zzH(new zzal(taskCompletionSource0), z);
        }
        catch(SecurityException securityException0) {
            GamesStatusUtils.zzb(taskCompletionSource0, securityException0);
        }
    }

    public final void zzak(ResultHolder baseImplementation$ResultHolder0, boolean z, String[] arr_s) throws RemoteException {
        this.zzf.zzb();
        try {
            ((zzce)this.getService()).zzI(new zzak(baseImplementation$ResultHolder0), z, arr_s);
        }
        catch(SecurityException securityException0) {
            zzbz.zzbg(baseImplementation$ResultHolder0, securityException0);
        }
    }

    public final void zzal(TaskCompletionSource taskCompletionSource0, boolean z, String[] arr_s) throws RemoteException {
        this.zzf.zzb();
        try {
            ((zzce)this.getService()).zzI(new zzal(taskCompletionSource0), z, arr_s);
        }
        catch(SecurityException securityException0) {
            GamesStatusUtils.zzb(taskCompletionSource0, securityException0);
        }
    }

    public final void zzam(ResultHolder baseImplementation$ResultHolder0) throws RemoteException {
        try {
            ((zzce)this.getService()).zzJ(new zzw(baseImplementation$ResultHolder0));
        }
        catch(SecurityException securityException0) {
            zzbz.zzbg(baseImplementation$ResultHolder0, securityException0);
        }
    }

    public final void zzan(TaskCompletionSource taskCompletionSource0) throws RemoteException {
        try {
            ((zzce)this.getService()).zzJ(new zzan(taskCompletionSource0));
        }
        catch(SecurityException securityException0) {
            GamesStatusUtils.zzb(taskCompletionSource0, securityException0);
        }
    }

    public final void zzao(ResultHolder baseImplementation$ResultHolder0, int v, boolean z, boolean z1) throws RemoteException {
        try {
            ((zzce)this.getService()).zzK(new zzbn(baseImplementation$ResultHolder0), v, z, z1);
        }
        catch(SecurityException securityException0) {
            zzbz.zzbg(baseImplementation$ResultHolder0, securityException0);
        }
    }

    public final void zzap(ResultHolder baseImplementation$ResultHolder0, boolean z) throws RemoteException {
        try {
            ((zzce)this.getService()).zzM(new zzau(baseImplementation$ResultHolder0), z);
        }
        catch(SecurityException securityException0) {
            zzbz.zzbg(baseImplementation$ResultHolder0, securityException0);
        }
    }

    public final void zzaq(ResultHolder baseImplementation$ResultHolder0, String s, boolean z) throws RemoteException {
        try {
            ((zzce)this.getService()).zzL(new zzau(baseImplementation$ResultHolder0), s, z);
        }
        catch(SecurityException securityException0) {
            zzbz.zzbg(baseImplementation$ResultHolder0, securityException0);
        }
    }

    public final void zzar(TaskCompletionSource taskCompletionSource0, String s, boolean z) throws RemoteException {
        try {
            ((zzce)this.getService()).zzL(new zzap(taskCompletionSource0), s, z);
        }
        catch(SecurityException securityException0) {
            GamesStatusUtils.zzb(taskCompletionSource0, securityException0);
        }
    }

    public final void zzas(TaskCompletionSource taskCompletionSource0, boolean z) throws RemoteException {
        try {
            ((zzce)this.getService()).zzM(new zzav(taskCompletionSource0), z);
        }
        catch(SecurityException securityException0) {
            GamesStatusUtils.zzb(taskCompletionSource0, securityException0);
        }
    }

    public final void zzat(ResultHolder baseImplementation$ResultHolder0, LeaderboardScoreBuffer leaderboardScoreBuffer0, int v, int v1) throws RemoteException {
        try {
            ((zzce)this.getService()).zzN(new zzas(baseImplementation$ResultHolder0), leaderboardScoreBuffer0.zza().zza(), v, v1);
        }
        catch(SecurityException securityException0) {
            zzbz.zzbg(baseImplementation$ResultHolder0, securityException0);
        }
    }

    public final void zzau(TaskCompletionSource taskCompletionSource0, LeaderboardScoreBuffer leaderboardScoreBuffer0, int v, int v1) throws RemoteException {
        try {
            ((zzce)this.getService()).zzN(new zzat(this, taskCompletionSource0), leaderboardScoreBuffer0.zza().zza(), v, v1);
        }
        catch(SecurityException securityException0) {
            GamesStatusUtils.zzb(taskCompletionSource0, securityException0);
        }
    }

    public final void zzav(ResultHolder baseImplementation$ResultHolder0, String s, boolean z) throws RemoteException {
        try {
            ((zzce)this.getService()).zzQ(new zzbn(baseImplementation$ResultHolder0), s, z);
        }
        catch(SecurityException securityException0) {
            zzbz.zzbg(baseImplementation$ResultHolder0, securityException0);
        }
    }

    public final void zzaw(TaskCompletionSource taskCompletionSource0, String s, boolean z) throws RemoteException {
        try {
            ((zzce)this.getService()).zzQ(new zzbp(taskCompletionSource0), s, z);
        }
        catch(SecurityException securityException0) {
            GamesStatusUtils.zzb(taskCompletionSource0, securityException0);
        }
    }

    public final void zzax(ResultHolder baseImplementation$ResultHolder0, String s, int v, int v1, int v2, boolean z) throws RemoteException {
        try {
            ((zzce)this.getService()).zzO(new zzas(baseImplementation$ResultHolder0), s, v, v1, v2, z);
        }
        catch(SecurityException securityException0) {
            zzbz.zzbg(baseImplementation$ResultHolder0, securityException0);
        }
    }

    public final void zzay(TaskCompletionSource taskCompletionSource0, String s, int v, int v1, int v2, boolean z) throws RemoteException {
        try {
            ((zzce)this.getService()).zzO(new zzat(this, taskCompletionSource0), s, v, v1, v2, z);
        }
        catch(SecurityException securityException0) {
            GamesStatusUtils.zzb(taskCompletionSource0, securityException0);
        }
    }

    public final void zzaz(ResultHolder baseImplementation$ResultHolder0, String s, String s1, int v, int v1) throws RemoteException {
        try {
            ((zzce)this.getService()).zzA(new zzt(baseImplementation$ResultHolder0), null, s1, v, v1);
        }
        catch(SecurityException securityException0) {
            zzbz.zzbg(baseImplementation$ResultHolder0, securityException0);
        }
    }

    public final void zzba(TaskCompletionSource taskCompletionSource0, String s) throws RemoteException {
        zzab zzab0 = taskCompletionSource0 == null ? null : new zzab(taskCompletionSource0);
        try {
            zzce zzce0 = (zzce)this.getService();
            Bundle bundle0 = this.zzj.zza();
            zzce0.zzad(zzab0, s, this.zzj.zzb(), bundle0);
        }
        catch(SecurityException securityException0) {
            GamesStatusUtils.zzb(taskCompletionSource0, securityException0);
        }
    }

    public final void zzbb() throws RemoteException {
        ((zzce)this.getService()).zzae(this.zzl);
    }

    public final void zzbc() {
        try {
            this.zzbb();
        }
        catch(RemoteException remoteException0) {
            zzbz.zzbf(remoteException0);
        }
    }

    public final boolean zzbd() throws RemoteException {
        return ((zzce)this.getService()).zzaf();
    }

    public final boolean zzbe() {
        try {
            return this.zzbd();
        }
        catch(RemoteException remoteException0) {
            zzbz.zzbf(remoteException0);
            return false;
        }
    }

    private static void zzbf(RemoteException remoteException0) {
        zzft.zze("GamesGmsClientImpl", "service died", remoteException0);
    }

    private static void zzbg(ResultHolder baseImplementation$ResultHolder0, SecurityException securityException0) {
        if(baseImplementation$ResultHolder0 != null) {
            baseImplementation$ResultHolder0.setFailedResult(GamesClientStatusCodes.zza(4));
        }
    }

    public final int zzp() throws RemoteException {
        return ((zzce)this.getService()).zzd();
    }

    public final int zzq() {
        try {
            return this.zzp();
        }
        catch(RemoteException remoteException0) {
            zzbz.zzbf(remoteException0);
            return -1;
        }
    }

    public final int zzr() throws RemoteException {
        return ((zzce)this.getService()).zze();
    }

    public final int zzs() {
        try {
            return this.zzr();
        }
        catch(RemoteException remoteException0) {
            zzbz.zzbf(remoteException0);
            return -1;
        }
    }

    public final Intent zzt() {
        try {
            return ((zzce)this.getService()).zzg();
        }
        catch(RemoteException remoteException0) {
            zzbz.zzbf(remoteException0);
            return null;
        }
    }

    public final Intent zzu() {
        try {
            return ((zzce)this.getService()).zzh();
        }
        catch(RemoteException remoteException0) {
            zzbz.zzbf(remoteException0);
            return null;
        }
    }

    public final Intent zzv() throws RemoteException {
        return ((zzce)this.getService()).zzo();
    }

    public final Intent zzw() {
        try {
            return this.zzv();
        }
        catch(RemoteException remoteException0) {
            zzbz.zzbf(remoteException0);
            return null;
        }
    }

    public final Intent zzx(PlayerEntity playerEntity0) {
        try {
            return ((zzce)this.getService()).zzi(playerEntity0);
        }
        catch(RemoteException remoteException0) {
            zzbz.zzbf(remoteException0);
            return null;
        }
    }

    public final Intent zzy(String s, int v, int v1) {
        try {
            return ((zzce)this.getService()).zzk(s, v, v1);
        }
        catch(RemoteException remoteException0) {
            zzbz.zzbf(remoteException0);
            return null;
        }
    }

    public final Intent zzz() throws RemoteException {
        return ((zzce)this.getService()).zzl();
    }
}

