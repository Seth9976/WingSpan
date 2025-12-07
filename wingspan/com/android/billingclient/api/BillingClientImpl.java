package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.View;
import androidx.core.app.BundleCompat;
import com.google.android.gms.internal.play_billing.zzaa;
import com.google.android.gms.internal.play_billing.zzai;
import com.google.android.gms.internal.play_billing.zzan;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzgg;
import com.google.android.gms.internal.play_billing.zzgh;
import com.google.android.gms.internal.play_billing.zzgk;
import com.google.android.gms.internal.play_billing.zzgl;
import com.google.android.gms.internal.play_billing.zzgn;
import com.google.android.gms.internal.play_billing.zzgr;
import com.google.android.gms.internal.play_billing.zzha;
import com.google.android.gms.internal.play_billing.zzhb;
import com.google.android.gms.internal.play_billing.zzhg;
import com.google.android.gms.internal.play_billing.zzhi;
import com.google.android.gms.internal.play_billing.zzs;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;

class BillingClientImpl extends BillingClient {
    private boolean zzA;
    private ExecutorService zzB;
    private volatile int zza;
    private final String zzb;
    private final Handler zzc;
    private volatile zzk zzd;
    private Context zze;
    private zzby zzf;
    private volatile zzs zzg;
    private volatile zzay zzh;
    private boolean zzi;
    private boolean zzj;
    private int zzk;
    private boolean zzl;
    private boolean zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private boolean zzt;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private boolean zzx;
    private boolean zzy;
    private zzcn zzz;

    private BillingClientImpl(Activity activity0, zzcn zzcn0, String s) {
        this(activity0.getApplicationContext(), zzcn0, new zzbq(), s, null, null, null, null);
    }

    private BillingClientImpl(Context context0, zzcn zzcn0, PurchasesUpdatedListener purchasesUpdatedListener0, String s, String s1, UserChoiceBillingListener userChoiceBillingListener0, zzby zzby0, ExecutorService executorService0) {
        this.zza = 0;
        this.zzc = new Handler(Looper.getMainLooper());
        this.zzk = 0;
        this.zzb = s;
        this.initialize(context0, purchasesUpdatedListener0, zzcn0, userChoiceBillingListener0, s, null);
    }

    private BillingClientImpl(String s) {
        this.zza = 0;
        this.zzc = new Handler(Looper.getMainLooper());
        this.zzk = 0;
        this.zzb = s;
    }

    BillingClientImpl(String s, Context context0, zzby zzby0, ExecutorService executorService0) {
        this.zza = 0;
        this.zzc = new Handler(Looper.getMainLooper());
        this.zzk = 0;
        this.zzb = "6.2.1";
        this.zze = context0.getApplicationContext();
        zzha zzha0 = zzhb.zzz();
        zzha0.zzj("6.2.1");
        zzha0.zzi("com.MonsterCouch.Wingspan");
        this.zzf = new zzcd(this.zze, ((zzhb)zzha0.zzc()));
        this.zze.getPackageName();
    }

    BillingClientImpl(String s, zzcn zzcn0, Context context0, PurchasesUpdatedListener purchasesUpdatedListener0, AlternativeBillingListener alternativeBillingListener0, zzby zzby0, ExecutorService executorService0) {
        this.zza = 0;
        this.zzc = new Handler(Looper.getMainLooper());
        this.zzk = 0;
        this.zzb = "6.2.1";
        this.initialize(context0, purchasesUpdatedListener0, zzcn0, alternativeBillingListener0, "6.2.1", null);
    }

    BillingClientImpl(String s, zzcn zzcn0, Context context0, PurchasesUpdatedListener purchasesUpdatedListener0, UserChoiceBillingListener userChoiceBillingListener0, zzby zzby0, ExecutorService executorService0) {
        this(context0, zzcn0, purchasesUpdatedListener0, "6.2.1", null, userChoiceBillingListener0, null, null);
    }

    BillingClientImpl(String s, zzcn zzcn0, Context context0, zzcg zzcg0, zzby zzby0, ExecutorService executorService0) {
        this.zza = 0;
        this.zzc = new Handler(Looper.getMainLooper());
        this.zzk = 0;
        this.zzb = "6.2.1";
        this.zze = context0.getApplicationContext();
        zzha zzha0 = zzhb.zzz();
        zzha0.zzj("6.2.1");
        zzha0.zzi("com.MonsterCouch.Wingspan");
        this.zzf = new zzcd(this.zze, ((zzhb)zzha0.zzc()));
        zzb.zzk("BillingClient", "Billing client should have a valid listener but the provided is null.");
        this.zzd = new zzk(this.zze, null, null, null, null, this.zzf);
        this.zzz = zzcn0;
        this.zze.getPackageName();
    }

    @Override  // com.android.billingclient.api.BillingClient
    public final void acknowledgePurchase(AcknowledgePurchaseParams acknowledgePurchaseParams0, AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener0) {
        if(!this.isReady()) {
            this.zzf.zza(zzbx.zzb(2, 3, zzca.zzm));
            acknowledgePurchaseResponseListener0.onAcknowledgePurchaseResponse(zzca.zzm);
            return;
        }
        if(TextUtils.isEmpty(acknowledgePurchaseParams0.getPurchaseToken())) {
            zzb.zzk("BillingClient", "Please provide a valid purchase token.");
            this.zzf.zza(zzbx.zzb(26, 3, zzca.zzi));
            acknowledgePurchaseResponseListener0.onAcknowledgePurchaseResponse(zzca.zzi);
            return;
        }
        if(!this.zzn) {
            this.zzf.zza(zzbx.zzb(27, 3, zzca.zzb));
            acknowledgePurchaseResponseListener0.onAcknowledgePurchaseResponse(zzca.zzb);
            return;
        }
        if(this.zzak(new zzq(this, acknowledgePurchaseParams0, acknowledgePurchaseResponseListener0), 30000L, () -> {
            this.zzf.zza(zzbx.zzb(24, 3, zzca.zzn));
            acknowledgePurchaseResponseListener0.onAcknowledgePurchaseResponse(zzca.zzn);
        }, this.zzag()) == null) {
            BillingResult billingResult0 = this.zzai();
            this.zzf.zza(zzbx.zzb(25, 3, billingResult0));
            acknowledgePurchaseResponseListener0.onAcknowledgePurchaseResponse(billingResult0);
        }
    }

    @Override  // com.android.billingclient.api.BillingClient
    public final void consumeAsync(ConsumeParams consumeParams0, ConsumeResponseListener consumeResponseListener0) {
        if(!this.isReady()) {
            this.zzf.zza(zzbx.zzb(2, 4, zzca.zzm));
            consumeResponseListener0.onConsumeResponse(zzca.zzm, consumeParams0.getPurchaseToken());
            return;
        }
        if(this.zzak(new zzad(this, consumeParams0, consumeResponseListener0), 30000L, () -> {
            this.zzf.zza(zzbx.zzb(24, 4, zzca.zzn));
            consumeResponseListener0.onConsumeResponse(zzca.zzn, consumeParams0.getPurchaseToken());
        }, this.zzag()) == null) {
            BillingResult billingResult0 = this.zzai();
            this.zzf.zza(zzbx.zzb(25, 4, billingResult0));
            consumeResponseListener0.onConsumeResponse(billingResult0, consumeParams0.getPurchaseToken());
        }
    }

    @Override  // com.android.billingclient.api.BillingClient
    public void createAlternativeBillingOnlyReportingDetailsAsync(AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener0) {
        if(!this.isReady()) {
            this.zzf.zza(zzbx.zzb(2, 15, zzca.zzm));
            alternativeBillingOnlyReportingDetailsListener0.onAlternativeBillingOnlyTokenResponse(zzca.zzm, null);
            return;
        }
        if(!this.zzx) {
            zzb.zzk("BillingClient", "Current client doesn\'t support alternative billing only.");
            this.zzf.zza(zzbx.zzb(66, 15, zzca.zzE));
            alternativeBillingOnlyReportingDetailsListener0.onAlternativeBillingOnlyTokenResponse(zzca.zzE, null);
            return;
        }
        if(this.zzak(new zzv(this, alternativeBillingOnlyReportingDetailsListener0), 30000L, () -> {
            this.zzf.zza(zzbx.zzb(24, 15, zzca.zzn));
            alternativeBillingOnlyReportingDetailsListener0.onAlternativeBillingOnlyTokenResponse(zzca.zzn, null);
        }, this.zzag()) == null) {
            BillingResult billingResult0 = this.zzai();
            this.zzf.zza(zzbx.zzb(25, 15, billingResult0));
            alternativeBillingOnlyReportingDetailsListener0.onAlternativeBillingOnlyTokenResponse(billingResult0, null);
        }
    }

    @Override  // com.android.billingclient.api.BillingClient
    public void createExternalOfferReportingDetailsAsync(ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener0) {
        if(!this.isReady()) {
            this.zzf.zza(zzbx.zzb(2, 24, zzca.zzm));
            externalOfferReportingDetailsListener0.onExternalOfferReportingDetailsResponse(zzca.zzm, null);
            return;
        }
        if(!this.zzy) {
            zzb.zzk("BillingClient", "Current client doesn\'t support external offer.");
            this.zzf.zza(zzbx.zzb(103, 24, zzca.zzy));
            externalOfferReportingDetailsListener0.onExternalOfferReportingDetailsResponse(zzca.zzy, null);
            return;
        }
        if(this.zzak(new zzx(this, externalOfferReportingDetailsListener0), 30000L, () -> {
            this.zzf.zza(zzbx.zzb(24, 24, zzca.zzn));
            externalOfferReportingDetailsListener0.onExternalOfferReportingDetailsResponse(zzca.zzn, null);
        }, this.zzag()) == null) {
            BillingResult billingResult0 = this.zzai();
            this.zzf.zza(zzbx.zzb(25, 24, billingResult0));
            externalOfferReportingDetailsListener0.onExternalOfferReportingDetailsResponse(billingResult0, null);
        }
    }

    @Override  // com.android.billingclient.api.BillingClient
    public final void endConnection() {
        this.zzf.zzb(zzbx.zzd(12));
        try {
            if(this.zzd != null) {
                this.zzd.zzf();
            }
            if(this.zzh != null) {
                this.zzh.zzc();
            }
            if(this.zzh != null && this.zzg != null) {
                zzb.zzj("BillingClient", "Unbinding from service.");
                this.zze.unbindService(this.zzh);
                this.zzh = null;
            }
            this.zzg = null;
            ExecutorService executorService0 = this.zzB;
            if(executorService0 != null) {
                executorService0.shutdownNow();
                this.zzB = null;
            }
        }
        catch(Exception exception0) {
            zzb.zzl("BillingClient", "There was an exception while ending connection!", exception0);
        }
        finally {
            this.zza = 3;
        }
    }

    @Override  // com.android.billingclient.api.BillingClient
    public void getBillingConfigAsync(GetBillingConfigParams getBillingConfigParams0, BillingConfigResponseListener billingConfigResponseListener0) {
        if(!this.isReady()) {
            zzb.zzk("BillingClient", "Service disconnected.");
            this.zzf.zza(zzbx.zzb(2, 13, zzca.zzm));
            billingConfigResponseListener0.onBillingConfigResponse(zzca.zzm, null);
            return;
        }
        if(!this.zzu) {
            zzb.zzk("BillingClient", "Current client doesn\'t support get billing config.");
            this.zzf.zza(zzbx.zzb(0x20, 13, zzca.zzA));
            billingConfigResponseListener0.onBillingConfigResponse(zzca.zzA, null);
            return;
        }
        Bundle bundle0 = new Bundle();
        bundle0.putString("playBillingLibraryVersion", this.zzb);
        if(this.zzak(new com.android.billingclient.api.zzs(this, bundle0, billingConfigResponseListener0), 30000L, () -> {
            this.zzf.zza(zzbx.zzb(24, 13, zzca.zzn));
            billingConfigResponseListener0.onBillingConfigResponse(zzca.zzn, null);
        }, this.zzag()) == null) {
            BillingResult billingResult0 = this.zzai();
            this.zzf.zza(zzbx.zzb(25, 13, billingResult0));
            billingConfigResponseListener0.onBillingConfigResponse(billingResult0, null);
        }
    }

    @Override  // com.android.billingclient.api.BillingClient
    public final int getConnectionState() {
        return this.zza;
    }

    private void initialize(Context context0, PurchasesUpdatedListener purchasesUpdatedListener0, zzcn zzcn0, AlternativeBillingListener alternativeBillingListener0, String s, zzby zzby0) {
        this.zze = context0.getApplicationContext();
        zzha zzha0 = zzhb.zzz();
        zzha0.zzj(s);
        zzha0.zzi("com.MonsterCouch.Wingspan");
        this.zzf = zzby0 == null ? new zzcd(this.zze, ((zzhb)zzha0.zzc())) : zzby0;
        if(purchasesUpdatedListener0 == null) {
            zzb.zzk("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.zzd = new zzk(this.zze, purchasesUpdatedListener0, null, alternativeBillingListener0, null, this.zzf);
        this.zzz = zzcn0;
        this.zzA = alternativeBillingListener0 != null;
        this.zze.getPackageName();
    }

    private void initialize(Context context0, PurchasesUpdatedListener purchasesUpdatedListener0, zzcn zzcn0, UserChoiceBillingListener userChoiceBillingListener0, String s, zzby zzby0) {
        this.zze = context0.getApplicationContext();
        zzha zzha0 = zzhb.zzz();
        zzha0.zzj(s);
        zzha0.zzi("com.MonsterCouch.Wingspan");
        this.zzf = zzby0 == null ? new zzcd(this.zze, ((zzhb)zzha0.zzc())) : zzby0;
        if(purchasesUpdatedListener0 == null) {
            zzb.zzk("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.zzd = new zzk(this.zze, purchasesUpdatedListener0, null, null, userChoiceBillingListener0, this.zzf);
        this.zzz = zzcn0;
        this.zzA = userChoiceBillingListener0 != null;
    }

    @Override  // com.android.billingclient.api.BillingClient
    public void isAlternativeBillingOnlyAvailableAsync(AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener0) {
        if(!this.isReady()) {
            this.zzf.zza(zzbx.zzb(2, 14, zzca.zzm));
            alternativeBillingOnlyAvailabilityListener0.onAlternativeBillingOnlyAvailabilityResponse(zzca.zzm);
            return;
        }
        if(!this.zzx) {
            zzb.zzk("BillingClient", "Current client doesn\'t support alternative billing only.");
            this.zzf.zza(zzbx.zzb(66, 14, zzca.zzE));
            alternativeBillingOnlyAvailabilityListener0.onAlternativeBillingOnlyAvailabilityResponse(zzca.zzE);
            return;
        }
        if(this.zzak(new zzab(this, alternativeBillingOnlyAvailabilityListener0), 30000L, () -> {
            this.zzf.zza(zzbx.zzb(24, 14, zzca.zzn));
            alternativeBillingOnlyAvailabilityListener0.onAlternativeBillingOnlyAvailabilityResponse(zzca.zzn);
        }, this.zzag()) == null) {
            BillingResult billingResult0 = this.zzai();
            this.zzf.zza(zzbx.zzb(25, 14, billingResult0));
            alternativeBillingOnlyAvailabilityListener0.onAlternativeBillingOnlyAvailabilityResponse(billingResult0);
        }
    }

    @Override  // com.android.billingclient.api.BillingClient
    public void isExternalOfferAvailableAsync(ExternalOfferAvailabilityListener externalOfferAvailabilityListener0) {
        if(!this.isReady()) {
            this.zzf.zza(zzbx.zzb(2, 23, zzca.zzm));
            externalOfferAvailabilityListener0.onExternalOfferAvailabilityResponse(zzca.zzm);
            return;
        }
        if(!this.zzy) {
            zzb.zzk("BillingClient", "Current client doesn\'t support external offer.");
            this.zzf.zza(zzbx.zzb(103, 23, zzca.zzy));
            externalOfferAvailabilityListener0.onExternalOfferAvailabilityResponse(zzca.zzy);
            return;
        }
        if(this.zzak(new zzam(this, externalOfferAvailabilityListener0), 30000L, () -> {
            this.zzf.zza(zzbx.zzb(24, 23, zzca.zzn));
            externalOfferAvailabilityListener0.onExternalOfferAvailabilityResponse(zzca.zzn);
        }, this.zzag()) == null) {
            BillingResult billingResult0 = this.zzai();
            this.zzf.zza(zzbx.zzb(25, 23, billingResult0));
            externalOfferAvailabilityListener0.onExternalOfferAvailabilityResponse(billingResult0);
        }
    }

    @Override  // com.android.billingclient.api.BillingClient
    public final BillingResult isFeatureSupported(String s) {
        if(!this.isReady()) {
            BillingResult billingResult0 = zzca.zzm;
            if(billingResult0.getResponseCode() != 0) {
                this.zzf.zza(zzbx.zzb(2, 5, billingResult0));
                return zzca.zzm;
            }
            this.zzf.zzb(zzbx.zzd(5));
            return zzca.zzm;
        }
        switch(s) {
            case "aaa": {
                BillingResult billingResult2 = this.zzr ? zzca.zzl : zzca.zzs;
                this.zzan(billingResult2, 0x1F, 6);
                return billingResult2;
            }
            case "bbb": {
                BillingResult billingResult3 = this.zzp ? zzca.zzl : zzca.zzw;
                this.zzan(billingResult3, 30, 5);
                return billingResult3;
            }
            case "ccc": {
                BillingResult billingResult4 = this.zzs ? zzca.zzl : zzca.zzt;
                this.zzan(billingResult4, 19, 8);
                return billingResult4;
            }
            case "ddd": {
                BillingResult billingResult5 = this.zzq ? zzca.zzl : zzca.zzu;
                this.zzan(billingResult5, 21, 7);
                return billingResult5;
            }
            case "eee": {
                BillingResult billingResult6 = this.zzs ? zzca.zzl : zzca.zzt;
                this.zzan(billingResult6, 61, 9);
                return billingResult6;
            }
            case "fff": {
                BillingResult billingResult7 = this.zzt ? zzca.zzl : zzca.zzv;
                this.zzan(billingResult7, 20, 10);
                return billingResult7;
            }
            case "ggg": {
                BillingResult billingResult8 = this.zzu ? zzca.zzl : zzca.zzA;
                this.zzan(billingResult8, 0x20, 11);
                return billingResult8;
            }
            case "hhh": {
                BillingResult billingResult9 = this.zzu ? zzca.zzl : zzca.zzB;
                this.zzan(billingResult9, 33, 12);
                return billingResult9;
            }
            case "iii": {
                BillingResult billingResult10 = this.zzw ? zzca.zzl : zzca.zzD;
                this.zzan(billingResult10, 60, 13);
                return billingResult10;
            }
            case "jjj": {
                BillingResult billingResult11 = this.zzx ? zzca.zzl : zzca.zzE;
                this.zzan(billingResult11, 66, 14);
                return billingResult11;
            }
            case "kkk": {
                BillingResult billingResult12 = this.zzy ? zzca.zzl : zzca.zzy;
                this.zzan(billingResult12, 103, 18);
                return billingResult12;
            }
            case "priceChangeConfirmation": {
                BillingResult billingResult13 = this.zzm ? zzca.zzl : zzca.zzr;
                this.zzan(billingResult13, 35, 4);
                return billingResult13;
            }
            case "subscriptions": {
                BillingResult billingResult14 = this.zzi ? zzca.zzl : zzca.zzo;
                this.zzan(billingResult14, 9, 2);
                return billingResult14;
            }
            case "subscriptionsUpdate": {
                BillingResult billingResult1 = this.zzj ? zzca.zzl : zzca.zzp;
                this.zzan(billingResult1, 10, 3);
                return billingResult1;
            }
            default: {
                zzb.zzk("BillingClient", "Unsupported feature: " + s);
                this.zzan(zzca.zzz, 34, 1);
                return zzca.zzz;
            }
        }
    }

    @Override  // com.android.billingclient.api.BillingClient
    public final boolean isReady() {
        return this.zza == 2 && this.zzg != null && this.zzh != null;
    }

    @Override  // com.android.billingclient.api.BillingClient
    public final BillingResult launchBillingFlow(Activity activity0, BillingFlowParams billingFlowParams0) {
        int v9;
        Future future0;
        int v8;
        int v7;
        boolean z2;
        ProductDetailsParams billingFlowParams$ProductDetailsParams2;
        SkuDetails skuDetails2;
        ProductDetailsParams billingFlowParams$ProductDetailsParams1;
        String s2;
        String s1;
        String s;
        if(this.zzd != null && this.zzd.zzd() != null) {
            if(!this.isReady()) {
                this.zzf.zza(zzbx.zzb(2, 2, zzca.zzm));
                this.zzah(zzca.zzm);
                return zzca.zzm;
            }
            ArrayList arrayList0 = billingFlowParams0.zzg();
            List list0 = billingFlowParams0.zzh();
            SkuDetails skuDetails0 = (SkuDetails)zzan.zza(arrayList0, null);
            ProductDetailsParams billingFlowParams$ProductDetailsParams0 = (ProductDetailsParams)zzan.zza(list0, null);
            if(skuDetails0 == null) {
                s = billingFlowParams$ProductDetailsParams0.zza().getProductId();
                s1 = billingFlowParams$ProductDetailsParams0.zza().getProductType();
            }
            else {
                s = skuDetails0.getSku();
                s1 = skuDetails0.getType();
            }
            if(s1.equals("subs") && !this.zzi) {
                zzb.zzk("BillingClient", "Current client doesn\'t support subscriptions.");
                this.zzf.zza(zzbx.zzb(9, 2, zzca.zzo));
                this.zzah(zzca.zzo);
                return zzca.zzo;
            }
            if(billingFlowParams0.zzq() && !this.zzl) {
                zzb.zzk("BillingClient", "Current client doesn\'t support extra params for buy intent.");
                this.zzf.zza(zzbx.zzb(18, 2, zzca.zzh));
                this.zzah(zzca.zzh);
                return zzca.zzh;
            }
            if(arrayList0.size() > 1 && !this.zzs) {
                zzb.zzk("BillingClient", "Current client doesn\'t support multi-item purchases.");
                this.zzf.zza(zzbx.zzb(19, 2, zzca.zzt));
                this.zzah(zzca.zzt);
                return zzca.zzt;
            }
            if(!list0.isEmpty() && !this.zzt) {
                zzb.zzk("BillingClient", "Current client doesn\'t support purchases with ProductDetails.");
                this.zzf.zza(zzbx.zzb(20, 2, zzca.zzv));
                this.zzah(zzca.zzv);
                return zzca.zzv;
            }
            if(this.zzl) {
                boolean z = this.zzn;
                boolean z1 = this.zzA;
                Bundle bundle0 = new Bundle();
                bundle0.putString("playBillingLibraryVersion", this.zzb);
                if(billingFlowParams0.zzb() != 0) {
                    bundle0.putInt("prorationMode", billingFlowParams0.zzb());
                }
                else if(billingFlowParams0.zza() != 0) {
                    bundle0.putInt("prorationMode", billingFlowParams0.zza());
                }
                if(!TextUtils.isEmpty(billingFlowParams0.zzc())) {
                    bundle0.putString("accountId", billingFlowParams0.zzc());
                }
                if(!TextUtils.isEmpty(billingFlowParams0.zzd())) {
                    bundle0.putString("obfuscatedProfileId", billingFlowParams0.zzd());
                }
                if(billingFlowParams0.zzp()) {
                    bundle0.putBoolean("isOfferPersonalizedByDeveloper", true);
                }
                if(!TextUtils.isEmpty(null)) {
                    bundle0.putStringArrayList("skusToReplace", new ArrayList(Arrays.asList(new String[]{0})));
                }
                if(!TextUtils.isEmpty(billingFlowParams0.zze())) {
                    bundle0.putString("oldSkuPurchaseToken", billingFlowParams0.zze());
                }
                if(!TextUtils.isEmpty(null)) {
                    bundle0.putString("oldSkuPurchaseId", null);
                }
                if(!TextUtils.isEmpty(billingFlowParams0.zzf())) {
                    bundle0.putString("originalExternalTransactionId", billingFlowParams0.zzf());
                }
                if(!TextUtils.isEmpty(null)) {
                    bundle0.putString("paymentsPurchaseParams", null);
                }
                if(z) {
                    bundle0.putBoolean("enablePendingPurchases", true);
                }
                if(z1) {
                    bundle0.putBoolean("enableAlternativeBilling", true);
                }
                if(arrayList0.isEmpty()) {
                    skuDetails2 = skuDetails0;
                    billingFlowParams$ProductDetailsParams2 = billingFlowParams$ProductDetailsParams0;
                    s2 = s;
                    ArrayList arrayList8 = new ArrayList(list0.size() - 1);
                    ArrayList arrayList9 = new ArrayList(list0.size() - 1);
                    ArrayList arrayList10 = new ArrayList();
                    ArrayList arrayList11 = new ArrayList();
                    ArrayList arrayList12 = new ArrayList();
                    for(int v6 = 0; v6 < list0.size(); ++v6) {
                        ProductDetailsParams billingFlowParams$ProductDetailsParams3 = (ProductDetailsParams)list0.get(v6);
                        ProductDetails productDetails0 = billingFlowParams$ProductDetailsParams3.zza();
                        if(!productDetails0.zzb().isEmpty()) {
                            arrayList10.add(productDetails0.zzb());
                        }
                        arrayList11.add(billingFlowParams$ProductDetailsParams3.zzb());
                        if(!TextUtils.isEmpty(productDetails0.zzc())) {
                            arrayList12.add(productDetails0.zzc());
                        }
                        if(v6 > 0) {
                            arrayList8.add(((ProductDetailsParams)list0.get(v6)).zza().getProductId());
                            arrayList9.add(((ProductDetailsParams)list0.get(v6)).zza().getProductType());
                        }
                    }
                    bundle0.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList11);
                    if(!arrayList10.isEmpty()) {
                        bundle0.putStringArrayList("skuDetailsTokens", arrayList10);
                    }
                    if(!arrayList12.isEmpty()) {
                        bundle0.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList12);
                    }
                    if(!arrayList8.isEmpty()) {
                        bundle0.putStringArrayList("additionalSkus", arrayList8);
                        bundle0.putStringArrayList("additionalSkuTypes", arrayList9);
                    }
                }
                else {
                    ArrayList arrayList1 = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    s2 = s;
                    ArrayList arrayList3 = new ArrayList();
                    ArrayList arrayList4 = new ArrayList();
                    ArrayList arrayList5 = new ArrayList();
                    int v = 0;
                    int v1 = 0;
                    int v2 = 0;
                    int v3 = 0;
                    for(Object object0: arrayList0) {
                        SkuDetails skuDetails1 = (SkuDetails)object0;
                        if(skuDetails1.zzf().isEmpty()) {
                            billingFlowParams$ProductDetailsParams1 = billingFlowParams$ProductDetailsParams0;
                        }
                        else {
                            billingFlowParams$ProductDetailsParams1 = billingFlowParams$ProductDetailsParams0;
                            arrayList1.add(skuDetails1.zzf());
                        }
                        String s3 = skuDetails1.zzc();
                        String s4 = skuDetails1.zzb();
                        int v4 = skuDetails1.zza();
                        String s5 = skuDetails1.zze();
                        arrayList2.add(s3);
                        v |= !TextUtils.isEmpty(s3);
                        arrayList3.add(s4);
                        v1 |= !TextUtils.isEmpty(s4);
                        arrayList4.add(v4);
                        v2 |= (v4 == 0 ? 0 : 1);
                        v3 |= !TextUtils.isEmpty(s5);
                        arrayList5.add(s5);
                        billingFlowParams$ProductDetailsParams0 = billingFlowParams$ProductDetailsParams1;
                    }
                    skuDetails2 = skuDetails0;
                    billingFlowParams$ProductDetailsParams2 = billingFlowParams$ProductDetailsParams0;
                    if(!arrayList1.isEmpty()) {
                        bundle0.putStringArrayList("skuDetailsTokens", arrayList1);
                    }
                    if(v != 0) {
                        bundle0.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList2);
                    }
                    if(v1 != 0) {
                        bundle0.putStringArrayList("SKU_OFFER_ID_LIST", arrayList3);
                    }
                    if(v2 != 0) {
                        bundle0.putIntegerArrayList("SKU_OFFER_TYPE_LIST", arrayList4);
                    }
                    if(v3 != 0) {
                        bundle0.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList5);
                    }
                    if(arrayList0.size() > 1) {
                        ArrayList arrayList6 = new ArrayList(arrayList0.size() - 1);
                        ArrayList arrayList7 = new ArrayList(arrayList0.size() - 1);
                        for(int v5 = 1; v5 < arrayList0.size(); ++v5) {
                            arrayList6.add(((SkuDetails)arrayList0.get(v5)).getSku());
                            arrayList7.add(((SkuDetails)arrayList0.get(v5)).getType());
                        }
                        bundle0.putStringArrayList("additionalSkus", arrayList6);
                        bundle0.putStringArrayList("additionalSkuTypes", arrayList7);
                    }
                }
                if(bundle0.containsKey("SKU_OFFER_ID_TOKEN_LIST") && !this.zzq) {
                    this.zzf.zza(zzbx.zzb(21, 2, zzca.zzu));
                    this.zzah(zzca.zzu);
                    return zzca.zzu;
                }
                if(skuDetails2 != null && !TextUtils.isEmpty(skuDetails2.zzd())) {
                    bundle0.putString("skuPackageName", skuDetails2.zzd());
                    z2 = true;
                }
                else if(billingFlowParams$ProductDetailsParams2 == null || TextUtils.isEmpty(billingFlowParams$ProductDetailsParams2.zza().zza())) {
                    z2 = false;
                }
                else {
                    bundle0.putString("skuPackageName", billingFlowParams$ProductDetailsParams2.zza().zza());
                    z2 = true;
                }
                if(!TextUtils.isEmpty(null)) {
                    bundle0.putString("accountName", null);
                }
                Intent intent0 = activity0.getIntent();
                if(intent0 == null) {
                    zzb.zzk("BillingClient", "Activity\'s intent is null.");
                }
                else if(!TextUtils.isEmpty(intent0.getStringExtra("PROXY_PACKAGE"))) {
                    String s6 = intent0.getStringExtra("PROXY_PACKAGE");
                    bundle0.putString("proxyPackage", s6);
                    try {
                        bundle0.putString("proxyPackageVersion", this.zze.getPackageManager().getPackageInfo(s6, 0).versionName);
                    }
                    catch(PackageManager.NameNotFoundException unused_ex) {
                        bundle0.putString("proxyPackageVersion", "package not found");
                    }
                }
                if(this.zzt && !list0.isEmpty()) {
                    v7 = 17;
                    goto label_183;
                }
                else if(!this.zzr || !z2) {
                    v8 = this.zzn ? 9 : 6;
                }
                else {
                    v7 = 15;
                label_183:
                    v8 = v7;
                }
                future0 = this.zzak(() -> this.zzg.zzg(v8, "com.MonsterCouch.Wingspan", s2, s1, null, bundle0), 5000L, null, this.zzc);
                v9 = 78;
            }
            else {
                future0 = this.zzak(() -> this.zzg.zzf(3, "com.MonsterCouch.Wingspan", s, s1, null), 5000L, null, this.zzc);
                v9 = 80;
            }
            try {
                if(future0 == null) {
                    this.zzf.zza(zzbx.zzb(25, 2, zzca.zzm));
                    this.zzah(zzca.zzm);
                    return zzca.zzm;
                }
                Bundle bundle1 = (Bundle)future0.get(5000L, TimeUnit.MILLISECONDS);
                int v10 = zzb.zzb(bundle1, "BillingClient");
                String s7 = zzb.zzg(bundle1, "BillingClient");
                if(v10 != 0) {
                    zzb.zzk("BillingClient", "Unable to buy item, Error response code: " + v10);
                    BillingResult billingResult0 = zzca.zza(v10, s7);
                    zzby zzby0 = this.zzf;
                    if(bundle1 != null) {
                        v9 = 23;
                    }
                    zzby0.zza(zzbx.zzb(v9, 2, billingResult0));
                    this.zzah(billingResult0);
                    return billingResult0;
                }
                Intent intent1 = new Intent(activity0, ProxyBillingActivity.class);
                intent1.putExtra("BUY_INTENT", ((PendingIntent)bundle1.getParcelable("BUY_INTENT")));
                activity0.startActivity(intent1);
                return zzca.zzl;
            }
            catch(TimeoutException | CancellationException timeoutException0) {
                zzb.zzl("BillingClient", "Time out while launching billing flow. Try to reconnect", timeoutException0);
                this.zzf.zza(zzbx.zzb(4, 2, zzca.zzn));
                this.zzah(zzca.zzn);
                return zzca.zzn;
            }
            catch(Exception exception0) {
                zzb.zzl("BillingClient", "Exception while launching billing flow. Try to reconnect", exception0);
                this.zzf.zza(zzbx.zzb(5, 2, zzca.zzm));
                this.zzah(zzca.zzm);
                return zzca.zzm;
            }
        }
        this.zzf.zza(zzbx.zzb(12, 2, zzca.zzF));
        return zzca.zzF;
    }

    private int launchBillingFlowCpp(Activity activity0, BillingFlowParams billingFlowParams0) {
        return this.launchBillingFlow(activity0, billingFlowParams0).getResponseCode();
    }

    @Override  // com.android.billingclient.api.BillingClient
    public final void queryProductDetailsAsync(QueryProductDetailsParams queryProductDetailsParams0, ProductDetailsResponseListener productDetailsResponseListener0) {
        if(!this.isReady()) {
            this.zzf.zza(zzbx.zzb(2, 7, zzca.zzm));
            ArrayList arrayList0 = new ArrayList();
            productDetailsResponseListener0.onProductDetailsResponse(zzca.zzm, arrayList0);
            return;
        }
        if(!this.zzt) {
            zzb.zzk("BillingClient", "Querying product details is not supported.");
            this.zzf.zza(zzbx.zzb(20, 7, zzca.zzv));
            ArrayList arrayList1 = new ArrayList();
            productDetailsResponseListener0.onProductDetailsResponse(zzca.zzv, arrayList1);
            return;
        }
        if(this.zzak(new zzaj(this, queryProductDetailsParams0, productDetailsResponseListener0), 30000L, () -> {
            this.zzf.zza(zzbx.zzb(24, 7, zzca.zzn));
            ArrayList arrayList0 = new ArrayList();
            productDetailsResponseListener0.onProductDetailsResponse(zzca.zzn, arrayList0);
        }, this.zzag()) == null) {
            BillingResult billingResult0 = this.zzai();
            this.zzf.zza(zzbx.zzb(25, 7, billingResult0));
            productDetailsResponseListener0.onProductDetailsResponse(billingResult0, new ArrayList());
        }
    }

    @Override  // com.android.billingclient.api.BillingClient
    public final void queryPurchaseHistoryAsync(QueryPurchaseHistoryParams queryPurchaseHistoryParams0, PurchaseHistoryResponseListener purchaseHistoryResponseListener0) {
        this.zzal(queryPurchaseHistoryParams0.zza(), purchaseHistoryResponseListener0);
    }

    @Override  // com.android.billingclient.api.BillingClient
    public final void queryPurchaseHistoryAsync(String s, PurchaseHistoryResponseListener purchaseHistoryResponseListener0) {
        this.zzal(s, purchaseHistoryResponseListener0);
    }

    @Override  // com.android.billingclient.api.BillingClient
    public final void queryPurchasesAsync(QueryPurchasesParams queryPurchasesParams0, PurchasesResponseListener purchasesResponseListener0) {
        this.zzam(queryPurchasesParams0.zza(), purchasesResponseListener0);
    }

    @Override  // com.android.billingclient.api.BillingClient
    public final void queryPurchasesAsync(String s, PurchasesResponseListener purchasesResponseListener0) {
        this.zzam(s, purchasesResponseListener0);
    }

    @Override  // com.android.billingclient.api.BillingClient
    public final void querySkuDetailsAsync(SkuDetailsParams skuDetailsParams0, SkuDetailsResponseListener skuDetailsResponseListener0) {
        if(!this.isReady()) {
            this.zzf.zza(zzbx.zzb(2, 8, zzca.zzm));
            skuDetailsResponseListener0.onSkuDetailsResponse(zzca.zzm, null);
            return;
        }
        String s = skuDetailsParams0.getSkuType();
        List list0 = skuDetailsParams0.getSkusList();
        if(TextUtils.isEmpty(s)) {
            zzb.zzk("BillingClient", "Please fix the input params. SKU type can\'t be empty.");
            this.zzf.zza(zzbx.zzb(49, 8, zzca.zzf));
            skuDetailsResponseListener0.onSkuDetailsResponse(zzca.zzf, null);
            return;
        }
        if(list0 == null) {
            zzb.zzk("BillingClient", "Please fix the input params. The list of SKUs can\'t be empty.");
            this.zzf.zza(zzbx.zzb(0x30, 8, zzca.zze));
            skuDetailsResponseListener0.onSkuDetailsResponse(zzca.zze, null);
            return;
        }
        if(this.zzak(new zzy(this, s, list0, null, skuDetailsResponseListener0), 30000L, () -> {
            this.zzf.zza(zzbx.zzb(24, 8, zzca.zzn));
            skuDetailsResponseListener0.onSkuDetailsResponse(zzca.zzn, null);
        }, this.zzag()) == null) {
            BillingResult billingResult0 = this.zzai();
            this.zzf.zza(zzbx.zzb(25, 8, billingResult0));
            skuDetailsResponseListener0.onSkuDetailsResponse(billingResult0, null);
        }
    }

    @Override  // com.android.billingclient.api.BillingClient
    public BillingResult showAlternativeBillingOnlyInformationDialog(Activity activity0, AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener0) {
        if(activity0 == null) {
            throw new IllegalArgumentException("Please provide a valid activity.");
        }
        if(!this.isReady()) {
            this.zzf.zza(zzbx.zzb(2, 16, zzca.zzm));
            return zzca.zzm;
        }
        if(!this.zzx) {
            zzb.zzk("BillingClient", "Current Play Store version doesn\'t support alternative billing only.");
            this.zzf.zza(zzbx.zzb(66, 16, zzca.zzE));
            return zzca.zzE;
        }
        if(this.zzak(new zzo(this, activity0, new zzat(this, this.zzc, alternativeBillingOnlyInformationDialogListener0), alternativeBillingOnlyInformationDialogListener0), 30000L, () -> {
            this.zzf.zza(zzbx.zzb(24, 16, zzca.zzn));
            alternativeBillingOnlyInformationDialogListener0.onAlternativeBillingOnlyInformationDialogResponse(zzca.zzn);
        }, this.zzc) == null) {
            BillingResult billingResult0 = this.zzai();
            this.zzf.zza(zzbx.zzb(25, 16, billingResult0));
            return billingResult0;
        }
        return zzca.zzl;
    }

    @Override  // com.android.billingclient.api.BillingClient
    public BillingResult showExternalOfferInformationDialog(Activity activity0, ExternalOfferInformationDialogListener externalOfferInformationDialogListener0) {
        if(activity0 == null) {
            throw new IllegalArgumentException("Please provide a valid activity.");
        }
        if(!this.isReady()) {
            this.zzf.zza(zzbx.zzb(2, 25, zzca.zzm));
            return zzca.zzm;
        }
        if(!this.zzy) {
            zzb.zzk("BillingClient", "Current Play Store version doesn\'t support external offer.");
            this.zzf.zza(zzbx.zzb(103, 25, zzca.zzy));
            return zzca.zzy;
        }
        if(this.zzak(new zzaf(this, activity0, new zzau(this, this.zzc, externalOfferInformationDialogListener0), externalOfferInformationDialogListener0), 30000L, () -> {
            this.zzf.zza(zzbx.zzb(24, 25, zzca.zzn));
            externalOfferInformationDialogListener0.onExternalOfferInformationDialogResponse(zzca.zzn);
        }, this.zzc) == null) {
            BillingResult billingResult0 = this.zzai();
            this.zzf.zza(zzbx.zzb(25, 25, billingResult0));
            return billingResult0;
        }
        return zzca.zzl;
    }

    @Override  // com.android.billingclient.api.BillingClient
    public final BillingResult showInAppMessages(Activity activity0, InAppMessageParams inAppMessageParams0, InAppMessageResponseListener inAppMessageResponseListener0) {
        if(!this.isReady()) {
            zzb.zzk("BillingClient", "Service disconnected.");
            return zzca.zzm;
        }
        if(!this.zzp) {
            zzb.zzk("BillingClient", "Current client doesn\'t support showing in-app messages.");
            return zzca.zzw;
        }
        View view0 = activity0.findViewById(0x1020002);
        IBinder iBinder0 = view0.getWindowToken();
        Rect rect0 = new Rect();
        view0.getGlobalVisibleRect(rect0);
        Bundle bundle0 = new Bundle();
        BundleCompat.putBinder(bundle0, "KEY_WINDOW_TOKEN", iBinder0);
        bundle0.putInt("KEY_DIMEN_LEFT", rect0.left);
        bundle0.putInt("KEY_DIMEN_TOP", rect0.top);
        bundle0.putInt("KEY_DIMEN_RIGHT", rect0.right);
        bundle0.putInt("KEY_DIMEN_BOTTOM", rect0.bottom);
        bundle0.putString("playBillingLibraryVersion", this.zzb);
        bundle0.putIntegerArrayList("KEY_CATEGORY_IDS", inAppMessageParams0.zza());
        this.zzak(new zzal(this, bundle0, activity0, new zzas(this, this.zzc, inAppMessageResponseListener0)), 5000L, null, this.zzc);
        return zzca.zzl;
    }

    private void startConnection(long v) {
        int v1 = 1;
        zzbq zzbq0 = new zzbq(v);
        if(this.isReady()) {
            zzb.zzj("BillingClient", "Service connection is valid. No need to re-initialize.");
            this.zzf.zzb(zzbx.zzd(6));
            zzbq0.onBillingSetupFinished(zzca.zzl);
            return;
        }
        switch(this.zza) {
            case 1: {
                zzb.zzk("BillingClient", "Client is already in the process of connecting to billing service.");
                this.zzf.zza(zzbx.zzb(37, 6, zzca.zzd));
                zzbq0.onBillingSetupFinished(zzca.zzd);
                return;
            }
            case 3: {
                zzb.zzk("BillingClient", "Client was already closed and can\'t be reused. Please create another instance.");
                this.zzf.zza(zzbx.zzb(38, 6, zzca.zzm));
                zzbq0.onBillingSetupFinished(zzca.zzm);
                return;
            }
            default: {
                this.zza = 1;
                zzb.zzj("BillingClient", "Starting in-app billing setup.");
                this.zzh = new zzay(this, zzbq0, null);
                Intent intent0 = new Intent("com.android.vending.billing.InAppBillingService.BIND");
                intent0.setPackage("com.android.vending");
                List list0 = this.zze.getPackageManager().queryIntentServices(intent0, 0);
                if(list0 == null || list0.isEmpty()) {
                    v1 = 41;
                }
                else {
                    ResolveInfo resolveInfo0 = (ResolveInfo)list0.get(0);
                    if(resolveInfo0.serviceInfo != null) {
                        String s = resolveInfo0.serviceInfo.packageName;
                        String s1 = resolveInfo0.serviceInfo.name;
                        if(!"com.android.vending".equals(s) || s1 == null) {
                            zzb.zzk("BillingClient", "The device doesn\'t have valid Play Store.");
                            v1 = 40;
                        }
                        else {
                            ComponentName componentName0 = new ComponentName(s, s1);
                            Intent intent1 = new Intent(intent0);
                            intent1.setComponent(componentName0);
                            intent1.putExtra("playBillingLibraryVersion", this.zzb);
                            if(this.zze.bindService(intent1, this.zzh, 1)) {
                                zzb.zzj("BillingClient", "Service was bonded successfully.");
                                return;
                            }
                            zzb.zzk("BillingClient", "Connection to Billing service is blocked.");
                            v1 = 39;
                        }
                    }
                }
                this.zza = 0;
                zzb.zzj("BillingClient", "Billing service unavailable on device.");
                this.zzf.zza(zzbx.zzb(v1, 6, zzca.zzc));
                zzbq0.onBillingSetupFinished(zzca.zzc);
            }
        }
    }

    @Override  // com.android.billingclient.api.BillingClient
    public final void startConnection(BillingClientStateListener billingClientStateListener0) {
        int v = 1;
        if(this.isReady()) {
            zzb.zzj("BillingClient", "Service connection is valid. No need to re-initialize.");
            this.zzf.zzb(zzbx.zzd(6));
            billingClientStateListener0.onBillingSetupFinished(zzca.zzl);
            return;
        }
        switch(this.zza) {
            case 1: {
                zzb.zzk("BillingClient", "Client is already in the process of connecting to billing service.");
                this.zzf.zza(zzbx.zzb(37, 6, zzca.zzd));
                billingClientStateListener0.onBillingSetupFinished(zzca.zzd);
                return;
            }
            case 3: {
                zzb.zzk("BillingClient", "Client was already closed and can\'t be reused. Please create another instance.");
                this.zzf.zza(zzbx.zzb(38, 6, zzca.zzm));
                billingClientStateListener0.onBillingSetupFinished(zzca.zzm);
                return;
            }
            default: {
                this.zza = 1;
                zzb.zzj("BillingClient", "Starting in-app billing setup.");
                this.zzh = new zzay(this, billingClientStateListener0, null);
                Intent intent0 = new Intent("com.android.vending.billing.InAppBillingService.BIND");
                intent0.setPackage("com.android.vending");
                List list0 = this.zze.getPackageManager().queryIntentServices(intent0, 0);
                if(list0 == null || list0.isEmpty()) {
                    v = 41;
                }
                else {
                    ResolveInfo resolveInfo0 = (ResolveInfo)list0.get(0);
                    if(resolveInfo0.serviceInfo != null) {
                        String s = resolveInfo0.serviceInfo.packageName;
                        String s1 = resolveInfo0.serviceInfo.name;
                        if(!"com.android.vending".equals(s) || s1 == null) {
                            zzb.zzk("BillingClient", "The device doesn\'t have valid Play Store.");
                            v = 40;
                        }
                        else {
                            ComponentName componentName0 = new ComponentName(s, s1);
                            Intent intent1 = new Intent(intent0);
                            intent1.setComponent(componentName0);
                            intent1.putExtra("playBillingLibraryVersion", this.zzb);
                            if(this.zze.bindService(intent1, this.zzh, 1)) {
                                zzb.zzj("BillingClient", "Service was bonded successfully.");
                                return;
                            }
                            zzb.zzk("BillingClient", "Connection to Billing service is blocked.");
                            v = 39;
                        }
                    }
                }
                this.zza = 0;
                zzb.zzj("BillingClient", "Billing service unavailable on device.");
                this.zzf.zza(zzbx.zzb(v, 6, zzca.zzc));
                billingClientStateListener0.onBillingSetupFinished(zzca.zzc);
            }
        }
    }

    // 检测为 Lambda 实现
    final void zzQ(AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener0) [...]

    // 检测为 Lambda 实现
    final void zzR(BillingResult billingResult0) [...]

    // 检测为 Lambda 实现
    final void zzS(ConsumeResponseListener consumeResponseListener0, ConsumeParams consumeParams0) [...]

    // 检测为 Lambda 实现
    final void zzT(AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener0) [...]

    // 检测为 Lambda 实现
    final void zzU(ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener0) [...]

    // 检测为 Lambda 实现
    final void zzV(BillingConfigResponseListener billingConfigResponseListener0) [...]

    // 检测为 Lambda 实现
    final void zzW(AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener0) [...]

    // 检测为 Lambda 实现
    final void zzX(ExternalOfferAvailabilityListener externalOfferAvailabilityListener0) [...]

    // 检测为 Lambda 实现
    final void zzY(ProductDetailsResponseListener productDetailsResponseListener0) [...]

    // 检测为 Lambda 实现
    final void zzZ(PurchaseHistoryResponseListener purchaseHistoryResponseListener0) [...]

    // 检测为 Lambda 实现
    final void zzaa(PurchasesResponseListener purchasesResponseListener0) [...]

    // 检测为 Lambda 实现
    final void zzab(SkuDetailsResponseListener skuDetailsResponseListener0) [...]

    // 检测为 Lambda 实现
    final void zzac(AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener0) [...]

    // 检测为 Lambda 实现
    final void zzad(ExternalOfferInformationDialogListener externalOfferInformationDialogListener0) [...]

    static zzcx zzaf(BillingClientImpl billingClientImpl0, String s, int v) {
        Purchase purchase0;
        Bundle bundle1;
        zzb.zzj("BillingClient", "Querying owned items, item type: " + s);
        ArrayList arrayList0 = new ArrayList();
        Bundle bundle0 = zzb.zzc(billingClientImpl0.zzn, billingClientImpl0.zzv, true, false, billingClientImpl0.zzb);
        String s1 = null;
        do {
            try {
                bundle1 = billingClientImpl0.zzn ? billingClientImpl0.zzg.zzj((billingClientImpl0.zzv ? 19 : 9), "com.MonsterCouch.Wingspan", s, s1, bundle0) : billingClientImpl0.zzg.zzi(3, "com.MonsterCouch.Wingspan", s, s1);
            }
            catch(Exception exception0) {
                billingClientImpl0.zzf.zza(zzbx.zzb(52, 9, zzca.zzm));
                zzb.zzl("BillingClient", "Got exception trying to get purchasesm try to reconnect", exception0);
                return new zzcx(zzca.zzm, null);
            }
            zzcy zzcy0 = zzcz.zza(bundle1, "BillingClient", "getPurchase()");
            BillingResult billingResult0 = zzcy0.zza();
            if(billingResult0 != zzca.zzl) {
                billingClientImpl0.zzf.zza(zzbx.zzb(zzcy0.zzb(), 9, billingResult0));
                return new zzcx(billingResult0, null);
            }
            ArrayList arrayList1 = bundle1.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
            ArrayList arrayList2 = bundle1.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
            ArrayList arrayList3 = bundle1.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
            boolean z = false;
            for(int v1 = 0; v1 < arrayList2.size(); ++v1) {
                String s2 = (String)arrayList2.get(v1);
                String s3 = (String)arrayList3.get(v1);
                zzb.zzj("BillingClient", "Sku is owned: " + ((String)arrayList1.get(v1)));
                try {
                    purchase0 = new Purchase(s2, s3);
                }
                catch(JSONException jSONException0) {
                    zzb.zzl("BillingClient", "Got an exception trying to decode the purchase!", jSONException0);
                    billingClientImpl0.zzf.zza(zzbx.zzb(51, 9, zzca.zzj));
                    return new zzcx(zzca.zzj, null);
                }
                if(TextUtils.isEmpty(purchase0.getPurchaseToken())) {
                    zzb.zzk("BillingClient", "BUG: empty/null token!");
                    z = true;
                }
                arrayList0.add(purchase0);
            }
            if(z) {
                billingClientImpl0.zzf.zza(zzbx.zzb(26, 9, zzca.zzj));
            }
            s1 = bundle1.getString("INAPP_CONTINUATION_TOKEN");
            zzb.zzj("BillingClient", "Continuation token: " + s1);
        }
        while(!TextUtils.isEmpty(s1));
        return new zzcx(zzca.zzl, arrayList0);
    }

    private final Handler zzag() {
        return Looper.myLooper() == null ? this.zzc : new Handler(Looper.myLooper());
    }

    private final BillingResult zzah(BillingResult billingResult0) {
        if(Thread.interrupted()) {
            return billingResult0;
        }
        zzm zzm0 = () -> {
            if(this.zzd.zzd() != null) {
                this.zzd.zzd().onPurchasesUpdated(billingResult0, null);
                return;
            }
            zzb.zzk("BillingClient", "No valid listener is set in BroadcastManager");
        };
        this.zzc.post(zzm0);
        return billingResult0;
    }

    private final BillingResult zzai() {
        return this.zza == 0 || this.zza == 3 ? zzca.zzm : zzca.zzj;
    }

    private static String zzaj() [...] // 潜在的解密器

    private final Future zzak(Callable callable0, long v, Runnable runnable0, Handler handler0) {
        Future future0;
        if(this.zzB == null) {
            zzap zzap0 = new zzap(this);
            this.zzB = Executors.newFixedThreadPool(zzb.zza, zzap0);
        }
        try {
            future0 = this.zzB.submit(callable0);
        }
        catch(Exception exception0) {
            zzb.zzl("BillingClient", "Async task throws exception!", exception0);
            return null;
        }
        handler0.postDelayed(new zzu(future0, runnable0), ((long)(((double)v) * 0.95)));
        return future0;
    }

    private final void zzal(String s, PurchaseHistoryResponseListener purchaseHistoryResponseListener0) {
        if(!this.isReady()) {
            this.zzf.zza(zzbx.zzb(2, 11, zzca.zzm));
            purchaseHistoryResponseListener0.onPurchaseHistoryResponse(zzca.zzm, null);
            return;
        }
        if(this.zzak(new zzar(this, s, purchaseHistoryResponseListener0), 30000L, () -> {
            this.zzf.zza(zzbx.zzb(24, 11, zzca.zzn));
            purchaseHistoryResponseListener0.onPurchaseHistoryResponse(zzca.zzn, null);
        }, this.zzag()) == null) {
            BillingResult billingResult0 = this.zzai();
            this.zzf.zza(zzbx.zzb(25, 11, billingResult0));
            purchaseHistoryResponseListener0.onPurchaseHistoryResponse(billingResult0, null);
        }
    }

    private final void zzam(String s, PurchasesResponseListener purchasesResponseListener0) {
        if(!this.isReady()) {
            this.zzf.zza(zzbx.zzb(2, 9, zzca.zzm));
            purchasesResponseListener0.onQueryPurchasesResponse(zzca.zzm, zzai.zzk());
            return;
        }
        if(TextUtils.isEmpty(s)) {
            zzb.zzk("BillingClient", "Please provide a valid product type.");
            this.zzf.zza(zzbx.zzb(50, 9, zzca.zzg));
            purchasesResponseListener0.onQueryPurchasesResponse(zzca.zzg, zzai.zzk());
            return;
        }
        if(this.zzak(new zzaq(this, s, purchasesResponseListener0), 30000L, () -> {
            this.zzf.zza(zzbx.zzb(24, 9, zzca.zzn));
            purchasesResponseListener0.onQueryPurchasesResponse(zzca.zzn, zzai.zzk());
        }, this.zzag()) == null) {
            BillingResult billingResult0 = this.zzai();
            this.zzf.zza(zzbx.zzb(25, 9, billingResult0));
            purchasesResponseListener0.onQueryPurchasesResponse(billingResult0, zzai.zzk());
        }
    }

    private final void zzan(BillingResult billingResult0, int v, int v1) {
        zzby zzby1;
        zzby zzby0;
        zzgh zzgh0 = null;
        if(billingResult0.getResponseCode() != 0) {
            try {
                zzby0 = this.zzf;
                zzgg zzgg0 = zzgh.zzz();
                zzgn zzgn0 = zzgr.zzz();
                zzgn0.zzk(billingResult0.getResponseCode());
                zzgn0.zzj(billingResult0.getDebugMessage());
                zzgn0.zzl(v);
                zzgg0.zzi(zzgn0);
                zzgg0.zzk(5);
                zzhg zzhg0 = zzhi.zzz();
                zzhg0.zzi(v1);
                zzgg0.zzj(((zzhi)zzhg0.zzc()));
                zzgh0 = (zzgh)zzgg0.zzc();
            }
            catch(Exception exception0) {
                zzb.zzl("BillingLogger", "Unable to create logging payload", exception0);
            }
            zzby0.zza(zzgh0);
            return;
        }
        try {
            zzby1 = this.zzf;
            zzgk zzgk0 = zzgl.zzz();
            zzgk0.zzj(5);
            zzhg zzhg1 = zzhi.zzz();
            zzhg1.zzi(v1);
            zzgk0.zzi(((zzhi)zzhg1.zzc()));
            zzgh0 = (zzgl)zzgk0.zzc();
        }
        catch(Exception exception1) {
            zzb.zzl("BillingLogger", "Unable to create logging payload", exception1);
        }
        zzby1.zzb(((zzgl)zzgh0));
    }

    static Context zzb(BillingClientImpl billingClientImpl0) {
        return billingClientImpl0.zze;
    }

    // 检测为 Lambda 实现
    final Bundle zzc(int v, String s, String s1, BillingFlowParams billingFlowParams0, Bundle bundle0) throws Exception [...]

    // 检测为 Lambda 实现
    final Bundle zzd(String s, String s1) throws Exception [...]

    static zzbp zzg(BillingClientImpl billingClientImpl0, String s) {
        PurchaseHistoryRecord purchaseHistoryRecord0;
        Bundle bundle1;
        zzb.zzj("BillingClient", "Querying purchase history, item type: " + s);
        ArrayList arrayList0 = new ArrayList();
        Bundle bundle0 = zzb.zzc(billingClientImpl0.zzn, billingClientImpl0.zzv, true, false, billingClientImpl0.zzb);
        String s1 = null;
        do {
            if(!billingClientImpl0.zzl) {
                zzb.zzk("BillingClient", "getPurchaseHistory is not supported on current device");
                return new zzbp(zzca.zzq, null);
            }
            try {
                bundle1 = billingClientImpl0.zzg.zzh(6, "com.MonsterCouch.Wingspan", s, s1, bundle0);
            }
            catch(RemoteException remoteException0) {
                zzb.zzl("BillingClient", "Got exception trying to get purchase history, try to reconnect", remoteException0);
                billingClientImpl0.zzf.zza(zzbx.zzb(59, 11, zzca.zzm));
                return new zzbp(zzca.zzm, null);
            }
            zzcy zzcy0 = zzcz.zza(bundle1, "BillingClient", "getPurchaseHistory()");
            BillingResult billingResult0 = zzcy0.zza();
            if(billingResult0 != zzca.zzl) {
                billingClientImpl0.zzf.zza(zzbx.zzb(zzcy0.zzb(), 11, billingResult0));
                return new zzbp(billingResult0, null);
            }
            ArrayList arrayList1 = bundle1.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
            ArrayList arrayList2 = bundle1.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
            ArrayList arrayList3 = bundle1.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
            boolean z = false;
            for(int v = 0; v < arrayList2.size(); ++v) {
                String s2 = (String)arrayList2.get(v);
                String s3 = (String)arrayList3.get(v);
                zzb.zzj("BillingClient", "Purchase record found for sku : " + ((String)arrayList1.get(v)));
                try {
                    purchaseHistoryRecord0 = new PurchaseHistoryRecord(s2, s3);
                }
                catch(JSONException jSONException0) {
                    zzb.zzl("BillingClient", "Got an exception trying to decode the purchase!", jSONException0);
                    billingClientImpl0.zzf.zza(zzbx.zzb(51, 11, zzca.zzj));
                    return new zzbp(zzca.zzj, null);
                }
                if(TextUtils.isEmpty(purchaseHistoryRecord0.getPurchaseToken())) {
                    zzb.zzk("BillingClient", "BUG: empty/null token!");
                    z = true;
                }
                arrayList0.add(purchaseHistoryRecord0);
            }
            if(z) {
                billingClientImpl0.zzf.zza(zzbx.zzb(26, 11, zzca.zzj));
            }
            s1 = bundle1.getString("INAPP_CONTINUATION_TOKEN");
            zzb.zzj("BillingClient", "Continuation token: " + s1);
        }
        while(!TextUtils.isEmpty(s1));
        return new zzbp(zzca.zzl, arrayList0);
    }

    final Object zzk(AcknowledgePurchaseParams acknowledgePurchaseParams0, AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener0) throws Exception {
        Bundle bundle1;
        try {
            zzs zzs0 = this.zzg;
            Bundle bundle0 = new Bundle();
            bundle0.putString("playBillingLibraryVersion", this.zzb);
            bundle1 = zzs0.zzd(9, "com.MonsterCouch.Wingspan", acknowledgePurchaseParams0.getPurchaseToken(), bundle0);
        }
        catch(Exception exception0) {
            zzb.zzl("BillingClient", "Error acknowledge purchase!", exception0);
            this.zzf.zza(zzbx.zzb(28, 3, zzca.zzm));
            acknowledgePurchaseResponseListener0.onAcknowledgePurchaseResponse(zzca.zzm);
            return null;
        }
        acknowledgePurchaseResponseListener0.onAcknowledgePurchaseResponse(zzca.zza(zzb.zzb(bundle1, "BillingClient"), zzb.zzg(bundle1, "BillingClient")));
        return null;
    }

    final Object zzl(ConsumeParams consumeParams0, ConsumeResponseListener consumeResponseListener0) throws Exception {
        String s2;
        int v;
        String s = consumeParams0.getPurchaseToken();
        try {
            zzb.zzj("BillingClient", "Consuming purchase with token: " + s);
            if(this.zzn) {
                zzs zzs0 = this.zzg;
                boolean z = this.zzn;
                String s1 = this.zzb;
                Bundle bundle0 = new Bundle();
                if(z) {
                    bundle0.putString("playBillingLibraryVersion", s1);
                }
                Bundle bundle1 = zzs0.zze(9, "com.MonsterCouch.Wingspan", s, bundle0);
                v = bundle1.getInt("RESPONSE_CODE");
                s2 = zzb.zzg(bundle1, "BillingClient");
            }
            else {
                v = this.zzg.zza(3, "com.MonsterCouch.Wingspan", s);
                s2 = "";
            }
            BillingResult billingResult0 = zzca.zza(v, s2);
            if(v == 0) {
                zzb.zzj("BillingClient", "Successfully consumed purchase.");
                consumeResponseListener0.onConsumeResponse(billingResult0, s);
                return null;
            }
            zzb.zzk("BillingClient", "Error consuming purchase with token. Response code: " + v);
            this.zzf.zza(zzbx.zzb(23, 4, billingResult0));
            consumeResponseListener0.onConsumeResponse(billingResult0, s);
        }
        catch(Exception exception0) {
            zzb.zzl("BillingClient", "Error consuming purchase!", exception0);
            this.zzf.zza(zzbx.zzb(29, 4, zzca.zzm));
            consumeResponseListener0.onConsumeResponse(zzca.zzm, s);
        }
        return null;
    }

    final Object zzm(Bundle bundle0, BillingConfigResponseListener billingConfigResponseListener0) throws Exception {
        try {
            this.zzg.zzp(18, "com.MonsterCouch.Wingspan", bundle0, new zzbg(billingConfigResponseListener0, this.zzf, null));
        }
        catch(DeadObjectException deadObjectException0) {
            zzb.zzl("BillingClient", "getBillingConfig got a dead object exception (try to reconnect).", deadObjectException0);
            this.zzf.zza(zzbx.zzb(62, 13, zzca.zzm));
            billingConfigResponseListener0.onBillingConfigResponse(zzca.zzm, null);
        }
        catch(Exception exception0) {
            zzb.zzl("BillingClient", "getBillingConfig got an exception.", exception0);
            this.zzf.zza(zzbx.zzb(62, 13, zzca.zzj));
            billingConfigResponseListener0.onBillingConfigResponse(zzca.zzj, null);
        }
        return null;
    }

    final Object zzn(QueryProductDetailsParams queryProductDetailsParams0, ProductDetailsResponseListener productDetailsResponseListener0) throws Exception {
        ProductDetails productDetails0;
        ArrayList arrayList5;
        int v8;
        Bundle bundle2;
        String s2;
        ArrayList arrayList0 = new ArrayList();
        String s = queryProductDetailsParams0.zzb();
        zzai zzai0 = queryProductDetailsParams0.zza();
        int v = zzai0.size();
        int v1 = 0;
    alab1:
        while(true) {
            if(v1 >= v) {
                s2 = "";
                v8 = 0;
                break;
            }
            ArrayList arrayList1 = new ArrayList(zzai0.subList(v1, (v1 + 20 <= v ? v1 + 20 : v)));
            ArrayList arrayList2 = new ArrayList();
            int v2 = arrayList1.size();
            for(int v3 = 0; v3 < v2; ++v3) {
                arrayList2.add(((Product)arrayList1.get(v3)).zza());
            }
            Bundle bundle0 = new Bundle();
            bundle0.putStringArrayList("ITEM_ID_LIST", arrayList2);
            bundle0.putString("playBillingLibraryVersion", this.zzb);
            try {
                zzs zzs0 = this.zzg;
                int v4 = this.zzw ? 20 : 17;
                String s1 = this.zzb;
                if(TextUtils.isEmpty(null)) {
                    this.zze.getPackageName();
                }
                if(TextUtils.isEmpty(null)) {
                    this.zze.getPackageName();
                }
                Bundle bundle1 = new Bundle();
                bundle1.putString("playBillingLibraryVersion", s1);
                bundle1.putBoolean("enablePendingPurchases", true);
                bundle1.putString("SKU_DETAILS_RESPONSE_FORMAT", "PRODUCT_DETAILS");
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                int v5 = arrayList1.size();
                boolean z = false;
                int v7 = 0;
                for(int v6 = 0; v6 < v5; ++v6) {
                    Product queryProductDetailsParams$Product0 = (Product)arrayList1.get(v6);
                    arrayList3.add(null);
                    v7 |= !TextUtils.isEmpty(null);
                    if(queryProductDetailsParams$Product0.zzb().equals("first_party")) {
                        zzaa.zzc(null, "Serialized DocId is required for constructing ExtraParams to query ProductDetails for all first party products.");
                        arrayList4.add(null);
                        z = true;
                    }
                }
                if(v7 != 0) {
                    bundle1.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList3);
                }
                if(!arrayList4.isEmpty()) {
                    bundle1.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList4);
                }
                if(z && !TextUtils.isEmpty(null)) {
                    bundle1.putString("accountName", null);
                }
                s2 = "Item is unavailable for purchase.";
                bundle2 = zzs0.zzl(v4, "com.MonsterCouch.Wingspan", s, bundle0, bundle1);
            }
            catch(Exception exception0) {
                zzb.zzl("BillingClient", "queryProductDetailsAsync got a remote exception (try to reconnect).", exception0);
                this.zzf.zza(zzbx.zzb(43, 7, zzca.zzj));
                s2 = "An internal error occurred.";
                v8 = 6;
                break alab1;
            }
            if(bundle2 == null) {
                zzb.zzk("BillingClient", "queryProductDetailsAsync got empty product details response.");
                this.zzf.zza(zzbx.zzb(44, 7, zzca.zzC));
            }
            else {
                if(!bundle2.containsKey("DETAILS_LIST")) {
                    v8 = zzb.zzb(bundle2, "BillingClient");
                    s2 = zzb.zzg(bundle2, "BillingClient");
                    if(v8 != 0) {
                        zzb.zzk("BillingClient", "getSkuDetails() failed for queryProductDetailsAsync. Response code: " + v8);
                        this.zzf.zza(zzbx.zzb(23, 7, zzca.zza(v8, s2)));
                        break;
                    }
                    zzb.zzk("BillingClient", "getSkuDetails() returned a bundle with neither an error nor a product detail list for queryProductDetailsAsync.");
                    this.zzf.zza(zzbx.zzb(45, 7, zzca.zza(6, s2)));
                    v8 = 6;
                    break;
                }
                arrayList5 = bundle2.getStringArrayList("DETAILS_LIST");
                if(arrayList5 == null) {
                    zzb.zzk("BillingClient", "queryProductDetailsAsync got null response list");
                    this.zzf.zza(zzbx.zzb(46, 7, zzca.zzC));
                }
                else {
                    goto label_79;
                }
            }
            v8 = 4;
            break;
        label_79:
            for(int v9 = 0; v9 < arrayList5.size(); ++v9) {
                String s3 = (String)arrayList5.get(v9);
                try {
                    productDetails0 = new ProductDetails(s3);
                }
                catch(JSONException jSONException0) {
                    zzb.zzl("BillingClient", "Got a JSON exception trying to decode ProductDetails. \n Exception: ", jSONException0);
                    s2 = "Error trying to decode SkuDetails.";
                    this.zzf.zza(zzbx.zzb(0x2F, 7, zzca.zza(6, "Error trying to decode SkuDetails.")));
                    v8 = 6;
                    break alab1;
                }
                zzb.zzj("BillingClient", "Got product details: " + productDetails0.toString());
                arrayList0.add(productDetails0);
            }
            v1 += 20;
        }
        productDetailsResponseListener0.onProductDetailsResponse(zzca.zza(v8, s2), arrayList0);
        return null;
    }

    final Object zzo(String s, List list0, String s1, SkuDetailsResponseListener skuDetailsResponseListener0) throws Exception {
        SkuDetails skuDetails0;
        ArrayList arrayList2;
        int v3;
        String s3;
        Bundle bundle2;
        ArrayList arrayList0 = new ArrayList();
        int v = list0.size();
        int v1 = 0;
    alab1:
        while(true) {
            if(v1 >= v) {
                s3 = "";
                v3 = 0;
                break;
            }
            ArrayList arrayList1 = new ArrayList(list0.subList(v1, (v1 + 20 <= v ? v1 + 20 : v)));
            Bundle bundle0 = new Bundle();
            bundle0.putStringArrayList("ITEM_ID_LIST", arrayList1);
            bundle0.putString("playBillingLibraryVersion", this.zzb);
            try {
                if(this.zzo) {
                    zzs zzs0 = this.zzg;
                    int v2 = this.zzk;
                    String s2 = this.zzb;
                    Bundle bundle1 = new Bundle();
                    if(v2 >= 9) {
                        bundle1.putString("playBillingLibraryVersion", s2);
                    }
                    if(v2 >= 9) {
                        bundle1.putBoolean("enablePendingPurchases", true);
                    }
                    bundle2 = zzs0.zzl(10, "com.MonsterCouch.Wingspan", s, bundle0, bundle1);
                }
                else {
                    bundle2 = this.zzg.zzk(3, "com.MonsterCouch.Wingspan", s, bundle0);
                }
            }
            catch(Exception exception0) {
                zzb.zzl("BillingClient", "querySkuDetailsAsync got a remote exception (try to reconnect).", exception0);
                this.zzf.zza(zzbx.zzb(43, 8, zzca.zzm));
                s3 = "Service connection is disconnected.";
                v3 = -1;
                arrayList0 = null;
                break;
            }
            s3 = "Item is unavailable for purchase.";
            if(bundle2 == null) {
                zzb.zzk("BillingClient", "querySkuDetailsAsync got null sku details list");
                this.zzf.zza(zzbx.zzb(44, 8, zzca.zzC));
            }
            else {
                if(!bundle2.containsKey("DETAILS_LIST")) {
                    int v4 = zzb.zzb(bundle2, "BillingClient");
                    s3 = zzb.zzg(bundle2, "BillingClient");
                    if(v4 != 0) {
                        zzb.zzk("BillingClient", "getSkuDetails() failed. Response code: " + v4);
                        this.zzf.zza(zzbx.zzb(23, 8, zzca.zza(v4, s3)));
                        v3 = v4;
                        break;
                    }
                    zzb.zzk("BillingClient", "getSkuDetails() returned a bundle with neither an error nor a detail list.");
                    this.zzf.zza(zzbx.zzb(45, 8, zzca.zza(6, s3)));
                    v3 = 6;
                    break alab1;
                }
                arrayList2 = bundle2.getStringArrayList("DETAILS_LIST");
                if(arrayList2 == null) {
                    zzb.zzk("BillingClient", "querySkuDetailsAsync got null response list");
                    this.zzf.zza(zzbx.zzb(46, 8, zzca.zzC));
                }
                else {
                    goto label_51;
                }
            }
            arrayList0 = null;
            v3 = 4;
            break;
        label_51:
            for(int v5 = 0; v5 < arrayList2.size(); ++v5) {
                String s4 = (String)arrayList2.get(v5);
                try {
                    skuDetails0 = new SkuDetails(s4);
                }
                catch(JSONException jSONException0) {
                    zzb.zzl("BillingClient", "Got a JSON exception trying to decode SkuDetails.", jSONException0);
                    s3 = "Error trying to decode SkuDetails.";
                    this.zzf.zza(zzbx.zzb(0x2F, 8, zzca.zza(6, "Error trying to decode SkuDetails.")));
                    arrayList0 = null;
                    v3 = 6;
                    break alab1;
                }
                zzb.zzj("BillingClient", "Got sku details: " + skuDetails0.toString());
                arrayList0.add(skuDetails0);
            }
            v1 += 20;
        }
        skuDetailsResponseListener0.onSkuDetailsResponse(zzca.zza(v3, s3), arrayList0);
        return null;
    }

    final Object zzp(Bundle bundle0, Activity activity0, ResultReceiver resultReceiver0) throws Exception {
        this.zzg.zzt(12, "com.MonsterCouch.Wingspan", bundle0, new zzbo(new WeakReference(activity0), resultReceiver0, null));
        return null;
    }

    final Void zzq(AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener0) throws Exception {
        try {
            this.zzg.zzm(21, "com.MonsterCouch.Wingspan", zzb.zzd(this.zzb), new zzba(alternativeBillingOnlyReportingDetailsListener0, this.zzf, null));
        }
        catch(Exception unused_ex) {
            this.zzf.zza(zzbx.zzb(70, 15, zzca.zzj));
            alternativeBillingOnlyReportingDetailsListener0.onAlternativeBillingOnlyTokenResponse(zzca.zzj, null);
        }
        return null;
    }

    final Void zzr(ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener0) throws Exception {
        try {
            this.zzg.zzn(22, "com.MonsterCouch.Wingspan", zzb.zzd(this.zzb), new zzbc(externalOfferReportingDetailsListener0, this.zzf, null));
        }
        catch(Exception exception0) {
            zzby zzby0 = this.zzf;
            Object[] arr_object = {exception0.getClass().getName(), com.google.android.gms.internal.play_billing.zzab.zzb(exception0.getMessage())};
            zzby0.zza(zzbx.zzc(94, 24, zzca.zzj, String.format("%s: %s", arr_object)));
            externalOfferReportingDetailsListener0.onExternalOfferReportingDetailsResponse(zzca.zzj, null);
        }
        return null;
    }

    final Void zzs(AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener0) throws Exception {
        try {
            this.zzg.zzr(21, "com.MonsterCouch.Wingspan", zzb.zzd(this.zzb), new zzbk(alternativeBillingOnlyAvailabilityListener0, this.zzf, null));
        }
        catch(Exception unused_ex) {
            this.zzf.zza(zzbx.zzb(69, 14, zzca.zzj));
            alternativeBillingOnlyAvailabilityListener0.onAlternativeBillingOnlyAvailabilityResponse(zzca.zzj);
        }
        return null;
    }

    final Void zzt(ExternalOfferAvailabilityListener externalOfferAvailabilityListener0) throws Exception {
        try {
            this.zzg.zzs(22, "com.MonsterCouch.Wingspan", zzb.zzd(this.zzb), new zzbm(externalOfferAvailabilityListener0, this.zzf, null));
        }
        catch(Exception exception0) {
            zzby zzby0 = this.zzf;
            Object[] arr_object = {exception0.getClass().getName(), com.google.android.gms.internal.play_billing.zzab.zzb(exception0.getMessage())};
            zzby0.zza(zzbx.zzc(91, 23, zzca.zzj, String.format("%s: %s", arr_object)));
            externalOfferAvailabilityListener0.onExternalOfferAvailabilityResponse(zzca.zzj);
        }
        return null;
    }

    final Void zzu(Activity activity0, ResultReceiver resultReceiver0, AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener0) throws Exception {
        try {
            this.zzg.zzo(21, "com.MonsterCouch.Wingspan", zzb.zzd(this.zzb), new zzbe(new WeakReference(activity0), resultReceiver0, null));
        }
        catch(Exception unused_ex) {
            this.zzf.zza(zzbx.zzb(74, 16, zzca.zzj));
            alternativeBillingOnlyInformationDialogListener0.onAlternativeBillingOnlyInformationDialogResponse(zzca.zzj);
        }
        return null;
    }

    final Void zzv(Activity activity0, ResultReceiver resultReceiver0, ExternalOfferInformationDialogListener externalOfferInformationDialogListener0) throws Exception {
        try {
            this.zzg.zzq(22, "com.MonsterCouch.Wingspan", zzb.zzd(this.zzb), new zzbi(new WeakReference(activity0), resultReceiver0, null));
        }
        catch(Exception exception0) {
            zzby zzby0 = this.zzf;
            Object[] arr_object = {exception0.getClass().getName(), com.google.android.gms.internal.play_billing.zzab.zzb(exception0.getMessage())};
            zzby0.zza(zzbx.zzc(98, 25, zzca.zzj, String.format("%s: %s", arr_object)));
            externalOfferInformationDialogListener0.onExternalOfferInformationDialogResponse(zzca.zzj);
        }
        return null;
    }

    static Future zzw(BillingClientImpl billingClientImpl0, Callable callable0, long v, Runnable runnable0, Handler handler0) {
        return billingClientImpl0.zzak(callable0, 30000L, runnable0, handler0);
    }
}

