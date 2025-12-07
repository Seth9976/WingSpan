package com.onesignal.core.internal.purchases.impl;

import com.amazon.device.iap.PurchasingListener;
import com.amazon.device.iap.PurchasingService;
import com.amazon.device.iap.model.Product;
import com.amazon.device.iap.model.ProductDataResponse.RequestStatus;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.PurchaseResponse.RequestStatus;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.RequestId;
import com.amazon.device.iap.model.UserDataResponse;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.internal.application.IApplicationLifecycleHandler;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.operations.IOperationRepo.DefaultImpls;
import com.onesignal.core.internal.operations.IOperationRepo;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.user.internal.identity.IdentityModel;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.operations.PurchaseInfo;
import com.onesignal.user.internal.operations.TrackPurchaseOperation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u001E2\u00020\u00012\u00020\u0002:\u0002\u001E\u001FB%\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n¢\u0006\u0002\u0010\u000BJ\u0014\u0010\u0015\u001A\u00020\u00162\n\u0010\u0017\u001A\u00060\u0018j\u0002`\u0019H\u0002J\b\u0010\u001A\u001A\u00020\u0016H\u0016J\b\u0010\u001B\u001A\u00020\u0016H\u0016J\b\u0010\u001C\u001A\u00020\u0016H\u0002J\b\u0010\u001D\u001A\u00020\u0016H\u0016R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000E\u001A\u0004\u0018\u00010\u000FX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001A\u0004\u0018\u00010\u0011X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001A\b\u0018\u00010\u0013R\u00020\u0000X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/onesignal/core/internal/purchases/impl/TrackAmazonPurchase;", "Lcom/onesignal/core/internal/startup/IStartableService;", "Lcom/onesignal/core/internal/application/IApplicationLifecycleHandler;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_operationRepo", "Lcom/onesignal/core/internal/operations/IOperationRepo;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_identityModelStore", "Lcom/onesignal/user/internal/identity/IdentityModelStore;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/core/internal/operations/IOperationRepo;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/user/internal/identity/IdentityModelStore;)V", "canTrack", "", "listenerHandlerField", "Ljava/lang/reflect/Field;", "listenerHandlerObject", "", "osPurchasingListener", "Lcom/onesignal/core/internal/purchases/impl/TrackAmazonPurchase$OSPurchasingListener;", "registerListenerOnMainThread", "logAmazonIAPListenerError", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onFocus", "onUnfocused", "setListener", "start", "Companion", "OSPurchasingListener", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class TrackAmazonPurchase implements IApplicationLifecycleHandler, IStartableService {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001A\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/onesignal/core/internal/purchases/impl/TrackAmazonPurchase$Companion;", "", "()V", "canTrack", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public final boolean canTrack() {
            try {
                Class.forName("com.amazon.device.iap.PurchasingListener");
                return true;
            }
            catch(ClassNotFoundException unused_ex) {
                return false;
            }
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u0012\u001A\u00020\n2\b\u0010\u0013\u001A\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0017H\u0016J\u0010\u0010\u0018\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0019H\u0016J\u0010\u0010\u001A\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u001BH\u0016J\u0010\u0010\u001C\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u001DH\u0016R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001A\u0004\u0018\u00010\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000B\u001A\u0004\u0018\u00010\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u001C\u0010\r\u001A\u0004\u0018\u00010\u0001X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011¨\u0006\u001E"}, d2 = {"Lcom/onesignal/core/internal/purchases/impl/TrackAmazonPurchase$OSPurchasingListener;", "Lcom/amazon/device/iap/PurchasingListener;", "_operationRepo", "Lcom/onesignal/core/internal/operations/IOperationRepo;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_identityModelStore", "Lcom/onesignal/user/internal/identity/IdentityModelStore;", "(Lcom/onesignal/core/internal/purchases/impl/TrackAmazonPurchase;Lcom/onesignal/core/internal/operations/IOperationRepo;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/user/internal/identity/IdentityModelStore;)V", "currentMarket", "", "lastRequestId", "Lcom/amazon/device/iap/model/RequestId;", "orgPurchasingListener", "getOrgPurchasingListener", "()Lcom/amazon/device/iap/PurchasingListener;", "setOrgPurchasingListener", "(Lcom/amazon/device/iap/PurchasingListener;)V", "marketToCurrencyCode", "market", "onProductDataResponse", "", "response", "Lcom/amazon/device/iap/model/ProductDataResponse;", "onPurchaseResponse", "Lcom/amazon/device/iap/model/PurchaseResponse;", "onPurchaseUpdatesResponse", "Lcom/amazon/device/iap/model/PurchaseUpdatesResponse;", "onUserDataResponse", "Lcom/amazon/device/iap/model/UserDataResponse;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    final class OSPurchasingListener implements PurchasingListener {
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 0x30)
        public final class WhenMappings {
            public static final int[] $EnumSwitchMapping$0;

            static {
                int[] arr_v = new int[ProductDataResponse.RequestStatus.values().length];
                arr_v[ProductDataResponse.RequestStatus.SUCCESSFUL.ordinal()] = 1;
                WhenMappings.$EnumSwitchMapping$0 = arr_v;
            }
        }

        private final ConfigModelStore _configModelStore;
        private final IdentityModelStore _identityModelStore;
        private final IOperationRepo _operationRepo;
        private String currentMarket;
        private RequestId lastRequestId;
        private PurchasingListener orgPurchasingListener;

        public OSPurchasingListener(IOperationRepo iOperationRepo0, ConfigModelStore configModelStore0, IdentityModelStore identityModelStore0) {
            Intrinsics.checkNotNullParameter(iOperationRepo0, "_operationRepo");
            Intrinsics.checkNotNullParameter(configModelStore0, "_configModelStore");
            Intrinsics.checkNotNullParameter(identityModelStore0, "_identityModelStore");
            TrackAmazonPurchase.this = trackAmazonPurchase0;
            super();
            this._operationRepo = iOperationRepo0;
            this._configModelStore = configModelStore0;
            this._identityModelStore = identityModelStore0;
        }

        public final PurchasingListener getOrgPurchasingListener() {
            return this.orgPurchasingListener;
        }

        private final String marketToCurrencyCode(String s) {
            if(s != null) {
                switch(s) {
                    case "AU": {
                        return "AUD";
                    }
                    case "BR": {
                        return "BRL";
                    }
                    case "CA": {
                        return "CDN";
                    }
                    case "DE": 
                    case "ES": 
                    case "FR": 
                    case "IT": {
                        return "EUR";
                    }
                    case "GB": {
                        return "GBP";
                    }
                    case "JP": {
                        return "JPY";
                    }
                    case "US": {
                        return "USD";
                    }
                    default: {
                        return "";
                    }
                }
            }
            return "";
        }

        public void onProductDataResponse(ProductDataResponse productDataResponse0) {
            Intrinsics.checkNotNullParameter(productDataResponse0, "response");
            if(this.lastRequestId == null || !Intrinsics.areEqual(String.valueOf(this.lastRequestId), productDataResponse0.getRequestId().toString())) {
                PurchasingListener purchasingListener0 = this.orgPurchasingListener;
                if(purchasingListener0 != null) {
                    Intrinsics.checkNotNull(purchasingListener0);
                    purchasingListener0.onProductDataResponse(productDataResponse0);
                }
            }
            else {
                ProductDataResponse.RequestStatus productDataResponse$RequestStatus0 = productDataResponse0.getRequestStatus();
                if((productDataResponse$RequestStatus0 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[productDataResponse$RequestStatus0.ordinal()]) == 1) {
                    ArrayList arrayList0 = new ArrayList();
                    Map map0 = productDataResponse0.getProductData();
                    BigDecimal bigDecimal0 = new BigDecimal(0);
                    for(Object object0: map0.keySet()) {
                        Product product0 = (Product)map0.get(((String)object0));
                        Intrinsics.checkNotNull(product0);
                        String s = product0.getSku();
                        String s1 = this.marketToCurrencyCode(this.currentMarket);
                        String s2 = product0.getPrice();
                        Intrinsics.checkNotNullExpressionValue(s2, "priceStr");
                        if(!new Regex("^[0-9]").matches(s2)) {
                            Intrinsics.checkNotNullExpressionValue(s2, "priceStr");
                            s2 = s2.substring(1);
                            Intrinsics.checkNotNullExpressionValue(s2, "this as java.lang.String).substring(startIndex)");
                        }
                        BigDecimal bigDecimal1 = new BigDecimal(s2);
                        bigDecimal0 = bigDecimal0.add(bigDecimal1);
                        Intrinsics.checkNotNullExpressionValue(bigDecimal0, "this.add(other)");
                        Intrinsics.checkNotNullExpressionValue(s, "sku");
                        arrayList0.add(new PurchaseInfo(s, s1, bigDecimal1));
                    }
                    TrackPurchaseOperation trackPurchaseOperation0 = new TrackPurchaseOperation(((ConfigModel)this._configModelStore.getModel()).getAppId(), ((IdentityModel)this._identityModelStore.getModel()).getOnesignalId(), false, bigDecimal0, arrayList0);
                    DefaultImpls.enqueue$default(this._operationRepo, trackPurchaseOperation0, false, 2, null);
                }
            }
        }

        public void onPurchaseResponse(PurchaseResponse purchaseResponse0) {
            Intrinsics.checkNotNullParameter(purchaseResponse0, "response");
            if(purchaseResponse0.getRequestStatus() == PurchaseResponse.RequestStatus.SUCCESSFUL) {
                this.currentMarket = purchaseResponse0.getUserData().getMarketplace();
                Set set0 = new HashSet();
                String s = purchaseResponse0.getReceipt().getSku();
                Intrinsics.checkNotNullExpressionValue(s, "response.receipt.sku");
                set0.add(s);
                this.lastRequestId = PurchasingService.getProductData(set0);
            }
            PurchasingListener purchasingListener0 = this.orgPurchasingListener;
            if(purchasingListener0 != null) {
                Intrinsics.checkNotNull(purchasingListener0);
                purchasingListener0.onPurchaseResponse(purchaseResponse0);
            }
        }

        public void onPurchaseUpdatesResponse(PurchaseUpdatesResponse purchaseUpdatesResponse0) {
            Intrinsics.checkNotNullParameter(purchaseUpdatesResponse0, "response");
            PurchasingListener purchasingListener0 = this.orgPurchasingListener;
            if(purchasingListener0 != null) {
                Intrinsics.checkNotNull(purchasingListener0);
                purchasingListener0.onPurchaseUpdatesResponse(purchaseUpdatesResponse0);
            }
        }

        public void onUserDataResponse(UserDataResponse userDataResponse0) {
            Intrinsics.checkNotNullParameter(userDataResponse0, "response");
            PurchasingListener purchasingListener0 = this.orgPurchasingListener;
            if(purchasingListener0 != null) {
                Intrinsics.checkNotNull(purchasingListener0);
                purchasingListener0.onUserDataResponse(userDataResponse0);
            }
        }

        public final void setOrgPurchasingListener(PurchasingListener purchasingListener0) {
            this.orgPurchasingListener = purchasingListener0;
        }
    }

    public static final Companion Companion;
    private final IApplicationService _applicationService;
    private final ConfigModelStore _configModelStore;
    private final IdentityModelStore _identityModelStore;
    private final IOperationRepo _operationRepo;
    private boolean canTrack;
    private Field listenerHandlerField;
    private Object listenerHandlerObject;
    private OSPurchasingListener osPurchasingListener;
    private boolean registerListenerOnMainThread;

    static {
        TrackAmazonPurchase.Companion = new Companion(null);
    }

    public TrackAmazonPurchase(IApplicationService iApplicationService0, IOperationRepo iOperationRepo0, ConfigModelStore configModelStore0, IdentityModelStore identityModelStore0) {
        Intrinsics.checkNotNullParameter(iApplicationService0, "_applicationService");
        Intrinsics.checkNotNullParameter(iOperationRepo0, "_operationRepo");
        Intrinsics.checkNotNullParameter(configModelStore0, "_configModelStore");
        Intrinsics.checkNotNullParameter(identityModelStore0, "_identityModelStore");
        super();
        this._applicationService = iApplicationService0;
        this._operationRepo = iOperationRepo0;
        this._configModelStore = configModelStore0;
        this._identityModelStore = identityModelStore0;
    }

    private final void logAmazonIAPListenerError(Exception exception0) {
        Logging.error("Error adding Amazon IAP listener.", exception0);
        exception0.printStackTrace();
    }

    @Override  // com.onesignal.core.internal.application.IApplicationLifecycleHandler
    public void onFocus() {
    }

    @Override  // com.onesignal.core.internal.application.IApplicationLifecycleHandler
    public void onUnfocused() {
        try {
            if(!this.canTrack) {
                return;
            }
            Field field0 = this.listenerHandlerField;
            Intrinsics.checkNotNull(field0);
            PurchasingListener purchasingListener0 = (PurchasingListener)field0.get(this.listenerHandlerObject);
            OSPurchasingListener trackAmazonPurchase$OSPurchasingListener0 = this.osPurchasingListener;
            if(purchasingListener0 != trackAmazonPurchase$OSPurchasingListener0) {
                Intrinsics.checkNotNull(trackAmazonPurchase$OSPurchasingListener0);
                trackAmazonPurchase$OSPurchasingListener0.setOrgPurchasingListener(purchasingListener0);
                this.setListener();
            }
        }
        catch(IllegalAccessException illegalAccessException0) {
            illegalAccessException0.printStackTrace();
        }
    }

    private final void setListener() {
        if(this.registerListenerOnMainThread) {
            ThreadUtilsKt.suspendifyOnMain(new Function1(null) {
                int label;

                {
                    TrackAmazonPurchase.this = trackAmazonPurchase0;
                    super(1, continuation0);
                }

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Continuation continuation0) {
                    return new com.onesignal.core.internal.purchases.impl.TrackAmazonPurchase.setListener.1(TrackAmazonPurchase.this, continuation0);
                }

                @Override  // kotlin.jvm.functions.Function1
                public Object invoke(Object object0) {
                    return this.invoke(((Continuation)object0));
                }

                public final Object invoke(Continuation continuation0) {
                    return ((com.onesignal.core.internal.purchases.impl.TrackAmazonPurchase.setListener.1)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
                }

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    if(this.label != 0) {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                    ResultKt.throwOnFailure(object0);
                    PurchasingService.registerListener(TrackAmazonPurchase.this._applicationService.getAppContext(), TrackAmazonPurchase.this.osPurchasingListener);
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        PurchasingService.registerListener(this._applicationService.getAppContext(), this.osPurchasingListener);
    }

    @Override  // com.onesignal.core.internal.startup.IStartableService
    public void start() {
        if(!TrackAmazonPurchase.Companion.canTrack()) {
            return;
        }
        try {
            Class class0 = Class.forName("com.amazon.device.iap.internal.d");
            try {
                this.listenerHandlerObject = class0.getMethod("d").invoke(null);
            }
            catch(NullPointerException unused_ex) {
                try {
                    this.listenerHandlerObject = class0.getMethod("e").invoke(null);
                }
                catch(NullPointerException unused_ex) {
                    this.listenerHandlerObject = class0.getMethod("g").invoke(null);
                }
                this.registerListenerOnMainThread = true;
            }
            Field field0 = class0.getDeclaredField("f");
            field0.setAccessible(true);
            OSPurchasingListener trackAmazonPurchase$OSPurchasingListener0 = new OSPurchasingListener(this, this._operationRepo, this._configModelStore, this._identityModelStore);
            this.osPurchasingListener = trackAmazonPurchase$OSPurchasingListener0;
            Intrinsics.checkNotNull(trackAmazonPurchase$OSPurchasingListener0);
            trackAmazonPurchase$OSPurchasingListener0.setOrgPurchasingListener(((PurchasingListener)field0.get(this.listenerHandlerObject)));
            this.listenerHandlerField = field0;
            this.canTrack = true;
            this.setListener();
        }
        catch(ClassNotFoundException classNotFoundException0) {
            this.logAmazonIAPListenerError(classNotFoundException0);
        }
        catch(IllegalAccessException illegalAccessException0) {
            this.logAmazonIAPListenerError(illegalAccessException0);
        }
        catch(InvocationTargetException invocationTargetException0) {
            this.logAmazonIAPListenerError(invocationTargetException0);
        }
        catch(NoSuchMethodException noSuchMethodException0) {
            this.logAmazonIAPListenerError(noSuchMethodException0);
        }
        catch(NoSuchFieldException noSuchFieldException0) {
            this.logAmazonIAPListenerError(noSuchFieldException0);
        }
        catch(ClassCastException classCastException0) {
            this.logAmazonIAPListenerError(classCastException0);
        }
        this._applicationService.addApplicationLifecycleHandler(this);
    }
}

