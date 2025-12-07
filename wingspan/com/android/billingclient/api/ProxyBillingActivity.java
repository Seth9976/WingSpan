package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.google.android.gms.internal.play_billing.zzai;
import com.google.android.gms.internal.play_billing.zzb;

public class ProxyBillingActivity extends Activity {
    static final String KEY_IN_APP_MESSAGE_RESULT_RECEIVER = "in_app_message_result_receiver";
    static final String KEY_PRICE_CHANGE_RESULT_RECEIVER = "result_receiver";
    private static final String KEY_SEND_CANCELLED_BROADCAST_IF_FINISHED = "send_cancelled_broadcast_if_finished";
    private static final int REQUEST_CODE_FIRST_PARTY_PURCHASE_FLOW = 110;
    private static final int REQUEST_CODE_IN_APP_MESSAGE_FLOW = 101;
    private static final int REQUEST_CODE_LAUNCH_ACTIVITY = 100;
    private static final String TAG = "ProxyBillingActivity";
    private ResultReceiver inAppMessageResultReceiver;
    private boolean isFlowFromFirstPartyClient;
    private ResultReceiver priceChangeResultReceiver;
    private boolean sendCancelledBroadcastIfFinished;

    private Intent makeAlternativeBillingIntent(String s) {
        Intent intent0 = new Intent("com.android.vending.billing.ALTERNATIVE_BILLING");
        intent0.setPackage("com.MonsterCouch.Wingspan");
        intent0.putExtra("ALTERNATIVE_BILLING_USER_CHOICE_DATA", s);
        intent0.putExtra("BROADCAST_RECEIVER_LOGGING_PAYLOAD", zzbx.zze(3, zzai.zzl(zzbx.zza(intent0.getAction()))).zzd());
        return intent0;
    }

    private Intent makePurchasesUpdatedIntent() {
        Intent intent0 = new Intent("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED");
        intent0.setPackage("com.MonsterCouch.Wingspan");
        intent0.putExtra("BROADCAST_RECEIVER_LOGGING_PAYLOAD", zzbx.zze(3, zzai.zzl(zzbx.zza(intent0.getAction()))).zzd());
        return intent0;
    }

    @Override  // android.app.Activity
    protected void onActivityResult(int v, int v1, Intent intent0) {
        Intent intent1;
        super.onActivityResult(v, v1, intent0);
        Bundle bundle0 = null;
        if(v == 100 || v == 110) {
            int v3 = zzb.zze(intent0, "ProxyBillingActivity").getResponseCode();
            if(v1 != -1) {
                zzb.zzk("ProxyBillingActivity", "Activity finished with resultCode " + v1 + " and billing\'s responseCode: " + v3);
            }
            else if(v3 != 0) {
                zzb.zzk("ProxyBillingActivity", "Activity finished with resultCode " + -1 + " and billing\'s responseCode: " + v3);
            }
            else {
                v3 = 0;
            }
            ResultReceiver resultReceiver1 = this.priceChangeResultReceiver;
            if(resultReceiver1 == null) {
                if(intent0 == null) {
                    intent1 = this.makePurchasesUpdatedIntent();
                }
                else if(intent0.getExtras() != null) {
                    String s = intent0.getExtras().getString("ALTERNATIVE_BILLING_USER_CHOICE_DATA");
                    if(s == null) {
                        intent1 = this.makePurchasesUpdatedIntent();
                        intent1.putExtras(intent0.getExtras());
                    }
                    else {
                        intent1 = this.makeAlternativeBillingIntent(s);
                    }
                    intent1.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
                }
                else {
                    intent1 = this.makePurchasesUpdatedIntent();
                    zzb.zzk("ProxyBillingActivity", "Got null bundle!");
                    intent1.putExtra("RESPONSE_CODE", 6);
                    intent1.putExtra("DEBUG_MESSAGE", "An internal error occurred.");
                    Builder billingResult$Builder0 = BillingResult.newBuilder();
                    billingResult$Builder0.setResponseCode(6);
                    billingResult$Builder0.setDebugMessage("An internal error occurred.");
                    intent1.putExtra("FAILURE_LOGGING_PAYLOAD", zzbx.zzb(22, 2, billingResult$Builder0.build()).zzd());
                    intent1.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
                }
                if(v == 110) {
                    intent1.putExtra("IS_FIRST_PARTY_PURCHASE", true);
                }
                this.sendBroadcast(intent1);
            }
            else {
                if(intent0 != null) {
                    bundle0 = intent0.getExtras();
                }
                resultReceiver1.send(v3, bundle0);
            }
        }
        else if(v == 101) {
            int v2 = zzb.zza(intent0, "ProxyBillingActivity");
            ResultReceiver resultReceiver0 = this.inAppMessageResultReceiver;
            if(resultReceiver0 != null) {
                if(intent0 != null) {
                    bundle0 = intent0.getExtras();
                }
                resultReceiver0.send(v2, bundle0);
            }
        }
        else {
            zzb.zzk("ProxyBillingActivity", "Got onActivityResult with wrong requestCode: " + v + "; skipping...");
        }
        this.sendCancelledBroadcastIfFinished = false;
        this.finish();
    }

    @Override  // android.app.Activity
    protected void onCreate(Bundle bundle0) {
        int v;
        PendingIntent pendingIntent0;
        super.onCreate(bundle0);
        if(bundle0 == null) {
            zzb.zzj("ProxyBillingActivity", "Launching Play Store billing flow");
            if(this.getIntent().hasExtra("BUY_INTENT")) {
                pendingIntent0 = (PendingIntent)this.getIntent().getParcelableExtra("BUY_INTENT");
                if(!this.getIntent().hasExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT") || !this.getIntent().getBooleanExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false)) {
                    v = 100;
                }
                else {
                    this.isFlowFromFirstPartyClient = true;
                    v = 110;
                }
            }
            else if(this.getIntent().hasExtra("SUBS_MANAGEMENT_INTENT")) {
                pendingIntent0 = (PendingIntent)this.getIntent().getParcelableExtra("SUBS_MANAGEMENT_INTENT");
                this.priceChangeResultReceiver = (ResultReceiver)this.getIntent().getParcelableExtra("result_receiver");
                v = 100;
            }
            else if(this.getIntent().hasExtra("IN_APP_MESSAGE_INTENT")) {
                pendingIntent0 = (PendingIntent)this.getIntent().getParcelableExtra("IN_APP_MESSAGE_INTENT");
                this.inAppMessageResultReceiver = (ResultReceiver)this.getIntent().getParcelableExtra("in_app_message_result_receiver");
                v = 101;
            }
            else {
                v = 100;
                pendingIntent0 = null;
            }
            try {
                this.sendCancelledBroadcastIfFinished = true;
                this.startIntentSenderForResult(pendingIntent0.getIntentSender(), v, new Intent(), 0, 0, 0);
            }
            catch(IntentSender.SendIntentException intentSender$SendIntentException0) {
                zzb.zzl("ProxyBillingActivity", "Got exception while trying to start a purchase flow.", intentSender$SendIntentException0);
                ResultReceiver resultReceiver0 = this.priceChangeResultReceiver;
                if(resultReceiver0 == null) {
                    ResultReceiver resultReceiver1 = this.inAppMessageResultReceiver;
                    if(resultReceiver1 == null) {
                        Intent intent0 = this.makePurchasesUpdatedIntent();
                        if(this.isFlowFromFirstPartyClient) {
                            intent0.putExtra("IS_FIRST_PARTY_PURCHASE", true);
                        }
                        intent0.putExtra("RESPONSE_CODE", 6);
                        intent0.putExtra("DEBUG_MESSAGE", "An internal error occurred.");
                        this.sendBroadcast(intent0);
                    }
                    else {
                        resultReceiver1.send(0, null);
                    }
                }
                else {
                    resultReceiver0.send(6, null);
                }
                this.sendCancelledBroadcastIfFinished = false;
                this.finish();
            }
            return;
        }
        zzb.zzj("ProxyBillingActivity", "Launching Play Store billing flow from savedInstanceState");
        this.sendCancelledBroadcastIfFinished = bundle0.getBoolean("send_cancelled_broadcast_if_finished", false);
        if(bundle0.containsKey("result_receiver")) {
            this.priceChangeResultReceiver = (ResultReceiver)bundle0.getParcelable("result_receiver");
        }
        else if(bundle0.containsKey("in_app_message_result_receiver")) {
            this.inAppMessageResultReceiver = (ResultReceiver)bundle0.getParcelable("in_app_message_result_receiver");
        }
        this.isFlowFromFirstPartyClient = bundle0.getBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false);
    }

    @Override  // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if(this.isFinishing() && this.sendCancelledBroadcastIfFinished) {
            Intent intent0 = this.makePurchasesUpdatedIntent();
            intent0.putExtra("RESPONSE_CODE", 1);
            intent0.putExtra("DEBUG_MESSAGE", "Billing dialog closed.");
            this.sendBroadcast(intent0);
        }
    }

    @Override  // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle0) {
        super.onSaveInstanceState(bundle0);
        ResultReceiver resultReceiver0 = this.priceChangeResultReceiver;
        if(resultReceiver0 != null) {
            bundle0.putParcelable("result_receiver", resultReceiver0);
        }
        ResultReceiver resultReceiver1 = this.inAppMessageResultReceiver;
        if(resultReceiver1 != null) {
            bundle0.putParcelable("in_app_message_result_receiver", resultReceiver1);
        }
        bundle0.putBoolean("send_cancelled_broadcast_if_finished", this.sendCancelledBroadcastIfFinished);
        bundle0.putBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", this.isFlowFromFirstPartyClient);
    }
}

