package com.onesignal.core.internal.purchases.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.onesignal.core.internal.application.IApplicationLifecycleHandler;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.operations.IOperationRepo.DefaultImpls;
import com.onesignal.core.internal.operations.IOperationRepo;
import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.user.internal.identity.IdentityModel;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.operations.PurchaseInfo;
import com.onesignal.user.internal.operations.TrackPurchaseOperation;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&B-\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u000B\u001A\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010\u001B\u001A\u00020\u001CH\u0016J\b\u0010\u001D\u001A\u00020\u001CH\u0016J\b\u0010\u001E\u001A\u00020\u001CH\u0002J8\u0010\u001F\u001A\u00020\u001C2\u0016\u0010 \u001A\u0012\u0012\u0004\u0012\u00020\u001A0!j\b\u0012\u0004\u0012\u00020\u001A`\"2\u0016\u0010#\u001A\u0012\u0012\u0004\u0012\u00020\u001A0!j\b\u0012\u0004\u0012\u00020\u001A`\"H\u0002J\b\u0010$\u001A\u00020\u001CH\u0016J\b\u0010%\u001A\u00020\u001CH\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000E\u001A\u0004\u0018\u00010\u000FX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001A\u0004\u0018\u00010\u000FX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0012X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001A\u0004\u0018\u00010\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001A\u0004\u0018\u00010\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0017\u001A\u00020\u0012X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u001A0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\'"}, d2 = {"Lcom/onesignal/core/internal/purchases/impl/TrackGooglePurchase;", "Lcom/onesignal/core/internal/startup/IStartableService;", "Lcom/onesignal/core/internal/application/IApplicationLifecycleHandler;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_prefs", "Lcom/onesignal/core/internal/preferences/IPreferencesService;", "_operationRepo", "Lcom/onesignal/core/internal/operations/IOperationRepo;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_identityModelStore", "Lcom/onesignal/user/internal/identity/IdentityModelStore;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/core/internal/preferences/IPreferencesService;Lcom/onesignal/core/internal/operations/IOperationRepo;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/user/internal/identity/IdentityModelStore;)V", "getPurchasesMethod", "Ljava/lang/reflect/Method;", "getSkuDetailsMethod", "isWaitingForPurchasesRequest", "", "mIInAppBillingService", "", "mServiceConn", "Landroid/content/ServiceConnection;", "newAsExisting", "purchaseTokens", "", "", "onFocus", "", "onUnfocused", "queryBoughtItems", "sendPurchases", "skusToAdd", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "newPurchaseTokens", "start", "trackIAP", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class TrackGooglePurchase implements IApplicationLifecycleHandler, IStartableService {
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000E\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\nJ\u0016\u0010\u000B\u001A\u0004\u0018\u00010\f2\n\u0010\r\u001A\u0006\u0012\u0002\b\u00030\u0004H\u0002J\u0018\u0010\u000E\u001A\u0004\u0018\u00010\f2\f\u0010\r\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u0004H\u0002J\u0018\u0010\u000F\u001A\u0004\u0018\u00010\f2\f\u0010\r\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u0004H\u0002R\u0014\u0010\u0003\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/onesignal/core/internal/purchases/impl/TrackGooglePurchase$Companion;", "", "()V", "iInAppBillingServiceClass", "Ljava/lang/Class;", "iapEnabled", "", "canTrack", "", "context", "Landroid/content/Context;", "getAsInterfaceMethod", "Ljava/lang/reflect/Method;", "clazz", "getGetPurchasesMethod", "getGetSkuDetailsMethod", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public static final Method access$getAsInterfaceMethod(Companion trackGooglePurchase$Companion0, Class class0) {
            return trackGooglePurchase$Companion0.getAsInterfaceMethod(class0);
        }

        public static final Method access$getGetPurchasesMethod(Companion trackGooglePurchase$Companion0, Class class0) {
            return trackGooglePurchase$Companion0.getGetPurchasesMethod(class0);
        }

        // 去混淆评级： 低(20)
        public final boolean canTrack(Context context0) {
            Intrinsics.checkNotNullParameter(context0, "context");
            TrackGooglePurchase.iapEnabled = context0.checkCallingOrSelfPermission("com.android.vending.BILLING");
            return false;
        }

        private final Method getAsInterfaceMethod(Class class0) {
            Method[] arr_method = class0.getMethods();
            Intrinsics.checkNotNullExpressionValue(arr_method, "clazz.methods");
            for(int v = 0; v < arr_method.length; ++v) {
                Method method0 = arr_method[v];
                Class[] arr_class = method0.getParameterTypes();
                if(arr_class.length == 1 && Intrinsics.areEqual(arr_class[0], IBinder.class)) {
                    return method0;
                }
            }
            return null;
        }

        private final Method getGetPurchasesMethod(Class class0) {
            Intrinsics.checkNotNull(class0);
            Method[] arr_method = class0.getMethods();
            Intrinsics.checkNotNullExpressionValue(arr_method, "clazz!!.methods");
            for(int v = 0; v < arr_method.length; ++v) {
                Method method0 = arr_method[v];
                Class[] arr_class = method0.getParameterTypes();
                if(arr_class.length == 4 && Intrinsics.areEqual(arr_class[0], Integer.TYPE) && Intrinsics.areEqual(arr_class[1], String.class) && Intrinsics.areEqual(arr_class[2], String.class) && Intrinsics.areEqual(arr_class[3], String.class)) {
                    return method0;
                }
            }
            return null;
        }

        private final Method getGetSkuDetailsMethod(Class class0) {
            Intrinsics.checkNotNull(class0);
            Method[] arr_method = class0.getMethods();
            Intrinsics.checkNotNullExpressionValue(arr_method, "clazz!!.methods");
            for(int v = 0; v < arr_method.length; ++v) {
                Method method0 = arr_method[v];
                Class[] arr_class = method0.getParameterTypes();
                Class class1 = method0.getReturnType();
                if(arr_class.length == 4 && Intrinsics.areEqual(arr_class[0], Integer.TYPE) && Intrinsics.areEqual(arr_class[1], String.class) && Intrinsics.areEqual(arr_class[2], String.class) && Intrinsics.areEqual(arr_class[3], Bundle.class) && Intrinsics.areEqual(class1, Bundle.class)) {
                    return method0;
                }
            }
            return null;
        }
    }

    public static final Companion Companion;
    private final IApplicationService _applicationService;
    private final ConfigModelStore _configModelStore;
    private final IdentityModelStore _identityModelStore;
    private final IOperationRepo _operationRepo;
    private final IPreferencesService _prefs;
    private Method getPurchasesMethod;
    private Method getSkuDetailsMethod;
    private static Class iInAppBillingServiceClass;
    private static int iapEnabled;
    private boolean isWaitingForPurchasesRequest;
    private Object mIInAppBillingService;
    private ServiceConnection mServiceConn;
    private boolean newAsExisting;
    private final List purchaseTokens;

    // 检测为 Lambda 实现
    public static void $r8$lambda$3s5fjJ2VPt5k6BkHMCH4I9-rBFc(TrackGooglePurchase trackGooglePurchase0) [...]

    static {
        TrackGooglePurchase.Companion = new Companion(null);
        TrackGooglePurchase.iapEnabled = -99;
    }

    public TrackGooglePurchase(IApplicationService iApplicationService0, IPreferencesService iPreferencesService0, IOperationRepo iOperationRepo0, ConfigModelStore configModelStore0, IdentityModelStore identityModelStore0) {
        Intrinsics.checkNotNullParameter(iApplicationService0, "_applicationService");
        Intrinsics.checkNotNullParameter(iPreferencesService0, "_prefs");
        Intrinsics.checkNotNullParameter(iOperationRepo0, "_operationRepo");
        Intrinsics.checkNotNullParameter(configModelStore0, "_configModelStore");
        Intrinsics.checkNotNullParameter(identityModelStore0, "_identityModelStore");
        super();
        this._applicationService = iApplicationService0;
        this._prefs = iPreferencesService0;
        this._operationRepo = iOperationRepo0;
        this._configModelStore = configModelStore0;
        this._identityModelStore = identityModelStore0;
        this.purchaseTokens = new ArrayList();
        this.newAsExisting = true;
    }

    public static final int access$getIapEnabled$cp() [...] // 潜在的解密器

    public static final void access$setIInAppBillingServiceClass$cp(Class class0) {
        TrackGooglePurchase.iInAppBillingServiceClass = class0;
    }

    @Override  // com.onesignal.core.internal.application.IApplicationLifecycleHandler
    public void onFocus() {
        this.trackIAP();
    }

    @Override  // com.onesignal.core.internal.application.IApplicationLifecycleHandler
    public void onUnfocused() {
    }

    private final void queryBoughtItems() {
        if(this.isWaitingForPurchasesRequest) {
            return;
        }
        new Thread(() -> TrackGooglePurchase.queryBoughtItems$lambda-0(this)).start();
    }

    private static final void queryBoughtItems$lambda-0(TrackGooglePurchase trackGooglePurchase0) {
        Intrinsics.checkNotNullParameter(trackGooglePurchase0, "this$0");
        trackGooglePurchase0.isWaitingForPurchasesRequest = true;
        try {
            if(trackGooglePurchase0.getPurchasesMethod == null) {
                Method method0 = Companion.access$getGetPurchasesMethod(TrackGooglePurchase.Companion, TrackGooglePurchase.iInAppBillingServiceClass);
                trackGooglePurchase0.getPurchasesMethod = method0;
                Intrinsics.checkNotNull(method0);
                method0.setAccessible(true);
            }
            Method method1 = trackGooglePurchase0.getPurchasesMethod;
            Intrinsics.checkNotNull(method1);
            Object object0 = method1.invoke(trackGooglePurchase0.mIInAppBillingService, 3, "com.MonsterCouch.Wingspan", "inapp", null);
            Intrinsics.checkNotNull(object0, "null cannot be cast to non-null type android.os.Bundle");
            if(((Bundle)object0).getInt("RESPONSE_CODE") == 0) {
                ArrayList arrayList0 = new ArrayList();
                ArrayList arrayList1 = new ArrayList();
                ArrayList arrayList2 = ((Bundle)object0).getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList arrayList3 = ((Bundle)object0).getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                Intrinsics.checkNotNull(arrayList3);
                int v = arrayList3.size();
                for(int v1 = 0; v1 < v; ++v1) {
                    String s = (String)arrayList3.get(v1);
                    Intrinsics.checkNotNull(arrayList2);
                    String s1 = (String)arrayList2.get(v1);
                    String s2 = new JSONObject(s).getString("purchaseToken");
                    if(!trackGooglePurchase0.purchaseTokens.contains(s2) && !arrayList1.contains(s2)) {
                        arrayList1.add(s2);
                        arrayList0.add(s1);
                    }
                }
                if(arrayList0.size() > 0) {
                    trackGooglePurchase0.sendPurchases(arrayList0, arrayList1);
                }
                else if(arrayList3.size() == 0) {
                    trackGooglePurchase0.newAsExisting = false;
                    trackGooglePurchase0._prefs.saveBool("GTPlayerPurchases", "ExistingPurchases", Boolean.FALSE);
                }
            }
        }
        catch(Throwable throwable0) {
            throwable0.printStackTrace();
        }
        trackGooglePurchase0.isWaitingForPurchasesRequest = false;
    }

    private final void sendPurchases(ArrayList arrayList0, ArrayList arrayList1) {
        try {
            if(this.getSkuDetailsMethod == null) {
                Method method0 = TrackGooglePurchase.Companion.getGetSkuDetailsMethod(TrackGooglePurchase.iInAppBillingServiceClass);
                this.getSkuDetailsMethod = method0;
                Intrinsics.checkNotNull(method0);
                method0.setAccessible(true);
            }
            Bundle bundle0 = new Bundle();
            bundle0.putStringArrayList("ITEM_ID_LIST", arrayList0);
            Method method1 = this.getSkuDetailsMethod;
            Intrinsics.checkNotNull(method1);
            Object object0 = method1.invoke(this.mIInAppBillingService, 3, "com.MonsterCouch.Wingspan", "inapp", bundle0);
            Intrinsics.checkNotNull(object0, "null cannot be cast to non-null type android.os.Bundle");
            if(((Bundle)object0).getInt("RESPONSE_CODE") == 0) {
                ArrayList arrayList2 = ((Bundle)object0).getStringArrayList("DETAILS_LIST");
                Map map0 = new LinkedHashMap();
                Intrinsics.checkNotNull(arrayList2);
                for(Object object1: arrayList2) {
                    JSONObject jSONObject0 = new JSONObject(((String)object1));
                    String s = jSONObject0.getString("productId");
                    String s1 = jSONObject0.getString("price_currency_code");
                    BigDecimal bigDecimal0 = new BigDecimal(jSONObject0.getString("price_amount_micros")).divide(new BigDecimal(1000000));
                    Intrinsics.checkNotNullExpressionValue(bigDecimal0, "price.divide(BigDecimal(1000000))");
                    Intrinsics.checkNotNullExpressionValue(s, "sku");
                    Intrinsics.checkNotNullExpressionValue(s1, "iso");
                    map0.put(s, new PurchaseInfo(s, s1, bigDecimal0));
                }
                List list0 = new ArrayList();
                for(Object object2: arrayList0) {
                    String s2 = (String)object2;
                    if(map0.containsKey(s2)) {
                        Object object3 = map0.get(s2);
                        Intrinsics.checkNotNull(object3);
                        list0.add(object3);
                    }
                }
                if(!list0.isEmpty() != 0) {
                    TrackPurchaseOperation trackPurchaseOperation0 = new TrackPurchaseOperation(((ConfigModel)this._configModelStore.getModel()).getAppId(), ((IdentityModel)this._identityModelStore.getModel()).getOnesignalId(), this.newAsExisting, new BigDecimal(0), list0);
                    DefaultImpls.enqueue$default(this._operationRepo, trackPurchaseOperation0, false, 2, null);
                    this.purchaseTokens.addAll(arrayList1);
                    this._prefs.saveString("GTPlayerPurchases", "purchaseTokens", this.purchaseTokens.toString());
                    this._prefs.saveBool("GTPlayerPurchases", "ExistingPurchases", Boolean.TRUE);
                    this.newAsExisting = false;
                    this.isWaitingForPurchasesRequest = false;
                }
            }
        }
        catch(Throwable throwable0) {
            Logging.warn("Failed to track IAP purchases", throwable0);
        }
    }

    @Override  // com.onesignal.core.internal.startup.IStartableService
    public void start() {
        Context context0 = this._applicationService.getAppContext();
        if(!TrackGooglePurchase.Companion.canTrack(context0)) {
            return;
        }
        try {
            JSONArray jSONArray0 = new JSONArray(this._prefs.getString("GTPlayerPurchases", "purchaseTokens", "[]"));
            int v = jSONArray0.length();
            boolean z = false;
            for(int v1 = 0; v1 < v; ++v1) {
                String s = jSONArray0.get(v1).toString();
                this.purchaseTokens.add(s);
            }
            if(jSONArray0.length() == 0) {
                z = true;
            }
            this.newAsExisting = z;
            if(z) {
                Boolean boolean0 = this._prefs.getBool("GTPlayerPurchases", "ExistingPurchases", Boolean.TRUE);
                Intrinsics.checkNotNull(boolean0);
                this.newAsExisting = boolean0.booleanValue();
            }
        }
        catch(JSONException jSONException0) {
            jSONException0.printStackTrace();
        }
        this._applicationService.addApplicationLifecycleHandler(this);
        this.trackIAP();
    }

    private final void trackIAP() {
        if(this.mServiceConn == null) {
            ServiceConnection serviceConnection0 = new ServiceConnection() {
                @Override  // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName0, IBinder iBinder0) {
                    Intrinsics.checkNotNullParameter(componentName0, "name");
                    Intrinsics.checkNotNullParameter(iBinder0, "service");
                    try {
                        Class class0 = Class.forName("com.android.vending.billing.IInAppBillingService$Stub");
                        Intrinsics.checkNotNullExpressionValue(class0, "stubClass");
                        Method method0 = Companion.access$getAsInterfaceMethod(TrackGooglePurchase.Companion, class0);
                        Intrinsics.checkNotNull(method0);
                        method0.setAccessible(true);
                        Object object0 = method0.invoke(null, iBinder0);
                        TrackGooglePurchase.this.mIInAppBillingService = object0;
                        TrackGooglePurchase.this.queryBoughtItems();
                    }
                    catch(Throwable throwable0) {
                        throwable0.printStackTrace();
                    }
                }

                @Override  // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName0) {
                    Intrinsics.checkNotNullParameter(componentName0, "name");
                    TrackGooglePurchase.iapEnabled = -99;
                    TrackGooglePurchase.this.mIInAppBillingService = null;
                }
            };
            this.mServiceConn = serviceConnection0;
            Intent intent0 = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent0.setPackage("com.android.vending");
            this._applicationService.getAppContext().getApplicationContext().bindService(intent0, serviceConnection0, 1);
            return;
        }
        if(this.mIInAppBillingService != null) {
            this.queryBoughtItems();
        }
    }
}

