package com.android.billingclient.api;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest.Builder;
import androidx.activity.result.contract.ActivityResultContracts.StartIntentSenderForResult;
import com.google.android.gms.internal.play_billing.zzb;

public class ProxyBillingActivityV2 extends ComponentActivity {
    private ActivityResultLauncher zza;
    private ActivityResultLauncher zzb;
    private ResultReceiver zzc;
    private ResultReceiver zzd;

    @Override  // androidx.activity.ComponentActivity
    protected final void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        this.zza = this.registerForActivityResult(new StartIntentSenderForResult(), (ActivityResult activityResult0) -> {
            Intent intent0 = activityResult0.getData();
            int v = zzb.zze(intent0, "ProxyBillingActivityV2").getResponseCode();
            ResultReceiver resultReceiver0 = this.zzc;
            if(resultReceiver0 != null) {
                resultReceiver0.send(v, (intent0 == null ? null : intent0.getExtras()));
            }
            if(activityResult0.getResultCode() != -1 || v != 0) {
                zzb.zzk("ProxyBillingActivityV2", "Alternative billing only dialog finished with resultCode " + activityResult0.getResultCode() + " and billing\'s responseCode: " + v);
            }
            this.finish();
        });
        this.zzb = this.registerForActivityResult(new StartIntentSenderForResult(), (ActivityResult activityResult0) -> {
            Intent intent0 = activityResult0.getData();
            int v = zzb.zze(intent0, "ProxyBillingActivityV2").getResponseCode();
            ResultReceiver resultReceiver0 = this.zzd;
            if(resultReceiver0 != null) {
                resultReceiver0.send(v, (intent0 == null ? null : intent0.getExtras()));
            }
            if(activityResult0.getResultCode() != -1 || v != 0) {
                zzb.zzk("ProxyBillingActivityV2", String.format("External offer dialog finished with resultCode: %s and billing\'s responseCode: %s", activityResult0.getResultCode(), v));
            }
            this.finish();
        });
        if(bundle0 == null) {
            zzb.zzj("ProxyBillingActivityV2", "Launching Play Store billing dialog");
            if(this.getIntent().hasExtra("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT")) {
                PendingIntent pendingIntent0 = (PendingIntent)this.getIntent().getParcelableExtra("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT");
                this.zzc = (ResultReceiver)this.getIntent().getParcelableExtra("alternative_billing_only_dialog_result_receiver");
                this.zza.launch(new Builder(pendingIntent0).build());
                return;
            }
            if(this.getIntent().hasExtra("external_payment_dialog_pending_intent")) {
                PendingIntent pendingIntent1 = (PendingIntent)this.getIntent().getParcelableExtra("external_payment_dialog_pending_intent");
                this.zzd = (ResultReceiver)this.getIntent().getParcelableExtra("external_payment_dialog_result_receiver");
                this.zzb.launch(new Builder(pendingIntent1).build());
            }
        }
        else {
            if(bundle0.containsKey("alternative_billing_only_dialog_result_receiver")) {
                this.zzc = (ResultReceiver)bundle0.getParcelable("alternative_billing_only_dialog_result_receiver");
                return;
            }
            if(bundle0.containsKey("external_payment_dialog_result_receiver")) {
                this.zzd = (ResultReceiver)bundle0.getParcelable("external_payment_dialog_result_receiver");
            }
        }
    }

    @Override  // androidx.activity.ComponentActivity
    protected final void onSaveInstanceState(Bundle bundle0) {
        super.onSaveInstanceState(bundle0);
        ResultReceiver resultReceiver0 = this.zzc;
        if(resultReceiver0 != null) {
            bundle0.putParcelable("alternative_billing_only_dialog_result_receiver", resultReceiver0);
        }
        ResultReceiver resultReceiver1 = this.zzd;
        if(resultReceiver1 != null) {
            bundle0.putParcelable("external_payment_dialog_result_receiver", resultReceiver1);
        }
    }

    // 检测为 Lambda 实现
    final void zza(ActivityResult activityResult0) [...]

    // 检测为 Lambda 实现
    final void zzb(ActivityResult activityResult0) [...]
}

