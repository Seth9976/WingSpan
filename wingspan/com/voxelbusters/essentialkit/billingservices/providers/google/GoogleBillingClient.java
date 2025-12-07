package com.voxelbusters.essentialkit.billingservices.providers.google;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.android.billingclient.api.AcknowledgePurchaseParams;
import com.android.billingclient.api.AcknowledgePurchaseResponseListener;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingFlowParams.ProductDetailsParams;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ConsumeParams;
import com.android.billingclient.api.ConsumeResponseListener;
import com.android.billingclient.api.ProductDetails;
import com.android.billingclient.api.ProductDetailsResponseListener;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesResponseListener;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.QueryProductDetailsParams.Product.Builder;
import com.android.billingclient.api.QueryProductDetailsParams.Product;
import com.android.billingclient.api.QueryProductDetailsParams;
import com.android.billingclient.api.QueryPurchasesParams;
import com.voxelbusters.essentialkit.billingservices.common.Security;
import com.voxelbusters.essentialkit.billingservices.common.interfaces.IConnectionListener;
import com.voxelbusters.essentialkit.billingservices.common.interfaces.IFetchBillingPurchaseListener;
import com.voxelbusters.essentialkit.billingservices.providers.google.interfaces.IAcknowledgePurchaseListener;
import com.voxelbusters.essentialkit.billingservices.providers.google.interfaces.IConsumePurchaseListener;
import com.voxelbusters.essentialkit.billingservices.providers.google.interfaces.IPurchasesStateListener;
import com.voxelbusters.essentialkit.billingservices.providers.google.interfaces.IQueryPurchasesListener;
import com.voxelbusters.essentialkit.billingservices.providers.google.interfaces.IQuerySkuDetailsListener;
import com.voxelbusters.essentialkit.billingservices.providers.google.interfaces.IStartProductPurchaseListener;
import com.voxelbusters.essentialkit.utilities.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class GoogleBillingClient implements PurchasesUpdatedListener {
    private HashMap allProductDetails;
    private BillingClient billingClient;
    private HashMap cachedPurchases;
    private List connectionListeners;
    private Context context;
    private String currentPurchaseProductId;
    private boolean isServiceConnected;
    private boolean isServiceConnecting;
    private IPurchasesStateListener purchasesStateListener;

    public GoogleBillingClient(Context context0, IPurchasesStateListener iPurchasesStateListener0) {
        public final class a implements IConnectionListener {
            public final GoogleBillingClient a;

            @Override  // com.voxelbusters.essentialkit.billingservices.common.interfaces.IConnectionListener
            public final void onConnect() {
                Logger.debug("Successfully connected to billing service. Do a initial purchases fetch");
                GoogleBillingClient.access$000(GoogleBillingClient.this);
            }

            @Override  // com.voxelbusters.essentialkit.billingservices.common.interfaces.IConnectionListener
            public final void onDisconnected(String s) {
                Logger.warning("Failed connecting to billing service. Reconnect later.");
            }
        }

        this.isServiceConnected = false;
        this.allProductDetails = new HashMap();
        this.connectionListeners = new ArrayList();
        this.context = context0;
        this.purchasesStateListener = iPurchasesStateListener0;
        this.billingClient = BillingClient.newBuilder(context0).enablePendingPurchases().setListener(this).build();
        HashMap hashMap0 = new HashMap();
        this.cachedPurchases = hashMap0;
        hashMap0.put("inapp", new ArrayList());
        this.cachedPurchases.put("subs", new ArrayList());
        this.connect(new a(this));
    }

    public void acknowledgePurchase(String s, IAcknowledgePurchaseListener iAcknowledgePurchaseListener0) {
        public final class d implements IConnectionListener {
            public final String a;
            public final IAcknowledgePurchaseListener b;
            public final GoogleBillingClient c;

            public d(String s, IAcknowledgePurchaseListener iAcknowledgePurchaseListener0) {
                this.a = s;
                this.b = iAcknowledgePurchaseListener0;
                super();
            }

            @Override  // com.voxelbusters.essentialkit.billingservices.common.interfaces.IConnectionListener
            public final void onConnect() {
                public final class com.voxelbusters.essentialkit.billingservices.providers.google.GoogleBillingClient.d.a implements AcknowledgePurchaseResponseListener {
                    public final d a;

                    @Override  // com.android.billingclient.api.AcknowledgePurchaseResponseListener
                    public final void onAcknowledgePurchaseResponse(BillingResult billingResult0) {
                        if(billingResult0.getResponseCode() == 0) {
                            IAcknowledgePurchaseListener iAcknowledgePurchaseListener0 = d.this.b;
                            if(iAcknowledgePurchaseListener0 != null) {
                                iAcknowledgePurchaseListener0.onAcknowlegePurchaseSuccess();
                            }
                        }
                        else {
                            IAcknowledgePurchaseListener iAcknowledgePurchaseListener1 = d.this.b;
                            if(iAcknowledgePurchaseListener1 != null) {
                                iAcknowledgePurchaseListener1.onAcknowledgePurchaseFailed(billingResult0.getDebugMessage());
                            }
                        }
                    }
                }

                AcknowledgePurchaseParams acknowledgePurchaseParams0 = AcknowledgePurchaseParams.newBuilder().setPurchaseToken(this.a).build();
                com.voxelbusters.essentialkit.billingservices.providers.google.GoogleBillingClient.d.a googleBillingClient$d$a0 = new com.voxelbusters.essentialkit.billingservices.providers.google.GoogleBillingClient.d.a(this);
                GoogleBillingClient.this.billingClient.acknowledgePurchase(acknowledgePurchaseParams0, googleBillingClient$d$a0);
            }

            @Override  // com.voxelbusters.essentialkit.billingservices.common.interfaces.IConnectionListener
            public final void onDisconnected(String s) {
                this.b.onAcknowledgePurchaseFailed("Connection failed");
            }
        }

        this.executeRequestOnConnect(new d(this, s, iAcknowledgePurchaseListener0));
    }

    private void addToCachedPurchasesIfRequired(Purchase purchase0) {
        if(purchase0.getPurchaseState() != 1) {
            return;
        }
        for(Object object0: purchase0.getSkus()) {
            ProductDetails productDetails0 = this.getProductDetails(((String)object0));
            List list0 = (List)this.cachedPurchases.get(productDetails0.getProductType());
            if(list0 != null) {
                boolean z = false;
                for(Object object1: list0) {
                    if(((Purchase)object1).getOrderId() != null && ((Purchase)object1).getOrderId().equals(purchase0.getOrderId())) {
                        z = true;
                    }
                }
                if(!z) {
                    list0.add(purchase0);
                }
            }
        }
    }

    public boolean areSubscriptionsSupported() {
        BillingResult billingResult0 = this.billingClient.isFeatureSupported("subscriptions");
        if(billingResult0.getResponseCode() != 0) {
            Logger.error(billingResult0.getDebugMessage());
        }
        return billingResult0.getResponseCode() == 0;
    }

    private void clearProductDetailsCache() {
        this.allProductDetails.clear();
    }

    private void connect(IConnectionListener iConnectionListener0) {
        public final class h implements BillingClientStateListener {
            public final GoogleBillingClient a;

            @Override  // com.android.billingclient.api.BillingClientStateListener
            public final void onBillingServiceDisconnected() {
                GoogleBillingClient.this.isServiceConnected = false;
                GoogleBillingClient.this.isServiceConnecting = false;
                GoogleBillingClient.this.updateListenersOnDisconnection("Billing service disconnected!");
            }

            @Override  // com.android.billingclient.api.BillingClientStateListener
            public final void onBillingSetupFinished(BillingResult billingResult0) {
                GoogleBillingClient.this.isServiceConnecting = false;
                if(billingResult0.getResponseCode() == 0) {
                    GoogleBillingClient.this.isServiceConnected = true;
                    GoogleBillingClient.this.updateListenersOnSuccess();
                    return;
                }
                GoogleBillingClient.this.isServiceConnected = false;
                GoogleBillingClient.this.updateListenersOnDisconnection(billingResult0.getDebugMessage());
            }
        }

        if(this.isServiceConnected) {
            if(iConnectionListener0 != null) {
                iConnectionListener0.onConnect();
            }
            return;
        }
        if(iConnectionListener0 != null) {
            this.connectionListeners.add(iConnectionListener0);
        }
        if(this.isServiceConnecting) {
            return;
        }
        this.isServiceConnecting = true;
        this.billingClient.startConnection(new h(this));
    }

    public void consumePurchase(String s, IConsumePurchaseListener iConsumePurchaseListener0) {
        public final class c implements IConnectionListener {
            public final String a;
            public final IConsumePurchaseListener b;
            public final GoogleBillingClient c;

            public c(String s, IConsumePurchaseListener iConsumePurchaseListener0) {
                this.a = s;
                this.b = iConsumePurchaseListener0;
                super();
            }

            @Override  // com.voxelbusters.essentialkit.billingservices.common.interfaces.IConnectionListener
            public final void onConnect() {
                public final class com.voxelbusters.essentialkit.billingservices.providers.google.GoogleBillingClient.c.a implements ConsumeResponseListener {
                    public final c a;

                    @Override  // com.android.billingclient.api.ConsumeResponseListener
                    public final void onConsumeResponse(BillingResult billingResult0, String s) {
                        if(billingResult0.getResponseCode() == 0) {
                            GoogleBillingClient.this.refreshPurchases();
                            IConsumePurchaseListener iConsumePurchaseListener0 = c.this.b;
                            if(iConsumePurchaseListener0 != null) {
                                iConsumePurchaseListener0.onConsumePurchaseSuccess();
                            }
                        }
                        else {
                            IConsumePurchaseListener iConsumePurchaseListener1 = c.this.b;
                            if(iConsumePurchaseListener1 != null) {
                                iConsumePurchaseListener1.onConsumePurchaseFailed(billingResult0.getDebugMessage());
                            }
                        }
                    }
                }

                ConsumeParams consumeParams0 = ConsumeParams.newBuilder().setPurchaseToken(this.a).build();
                com.voxelbusters.essentialkit.billingservices.providers.google.GoogleBillingClient.c.a googleBillingClient$c$a0 = new com.voxelbusters.essentialkit.billingservices.providers.google.GoogleBillingClient.c.a(this);
                GoogleBillingClient.this.billingClient.consumeAsync(consumeParams0, googleBillingClient$c$a0);
            }

            @Override  // com.voxelbusters.essentialkit.billingservices.common.interfaces.IConnectionListener
            public final void onDisconnected(String s) {
                IConsumePurchaseListener iConsumePurchaseListener0 = this.b;
                if(iConsumePurchaseListener0 != null) {
                    iConsumePurchaseListener0.onConsumePurchaseFailed(s);
                }
            }
        }

        this.executeRequestOnConnect(new c(this, s, iConsumePurchaseListener0));
    }

    private void executeRequestOnConnect(IConnectionListener iConnectionListener0) {
        this.connect(iConnectionListener0);
    }

    public void fetchPurchase(String s, IFetchBillingPurchaseListener iFetchBillingPurchaseListener0) {
        public final class e implements IQueryPurchasesListener {
            public final String a;
            public final IFetchBillingPurchaseListener b;

            public e(String s, IFetchBillingPurchaseListener iFetchBillingPurchaseListener0) {
                this.b = iFetchBillingPurchaseListener0;
                super();
            }

            @Override  // com.voxelbusters.essentialkit.billingservices.providers.google.interfaces.IQueryPurchasesListener
            public final void onQueryPurchasesFailed(String s) {
                this.b.onFailure(s);
            }

            @Override  // com.voxelbusters.essentialkit.billingservices.providers.google.interfaces.IQueryPurchasesListener
            public final void onQueryPurchasesSuccess(List list0) {
                for(Object object0: list0) {
                    Purchase purchase0 = (Purchase)object0;
                    if(purchase0.getProducts().contains(this.a)) {
                        this.b.onSuccess(purchase0);
                        return;
                    }
                    if(false) {
                        break;
                    }
                }
            }
        }

        ArrayList arrayList0 = new ArrayList();
        arrayList0.addAll(((Collection)this.cachedPurchases.get("inapp")));
        arrayList0.addAll(((Collection)this.cachedPurchases.get("subs")));
        for(Object object0: arrayList0) {
            Purchase purchase0 = (Purchase)object0;
            if(s.equals(purchase0.getProducts().get(0))) {
                iFetchBillingPurchaseListener0.onSuccess(purchase0);
                return;
            }
            if(false) {
                break;
            }
        }
        Log.w("BillingServices", "Unable to find the purchase in cached purchases. Trying by querying server : " + s);
        this.queryPurchases("inapp", new e(s, iFetchBillingPurchaseListener0));
    }

    public List getInAppTypeCachedPurchases() {
        return (List)this.cachedPurchases.get("inapp");
    }

    public List getIncompletePurchases(List list0) {
        List list1 = (List)this.cachedPurchases.get("inapp");
        List list2 = new ArrayList();
        for(Object object0: list1) {
            Purchase purchase0 = (Purchase)object0;
            if(!purchase0.isAcknowledged() || this.isConsumableProductPurchase(purchase0, list0)) {
                ((ArrayList)list2).add(purchase0);
            }
        }
        return list2;
    }

    private ProductDetails getProductDetails(String s) {
        return (ProductDetails)this.allProductDetails.get(s);
    }

    private List getQueryProductsList(List list0, String s) {
        List list1 = new ArrayList();
        for(Object object0: list0) {
            Builder queryProductDetailsParams$Product$Builder0 = Product.newBuilder();
            queryProductDetailsParams$Product$Builder0.setProductId(((String)object0));
            queryProductDetailsParams$Product$Builder0.setProductType(s);
            ((ArrayList)list1).add(queryProductDetailsParams$Product$Builder0.build());
        }
        return list1;
    }

    private String getResponseCodeDescription(int v) {
        switch(v) {
            case -3: {
                return "SERVICE_TIMEOUT";
            }
            case -2: {
                return "FEATURE_NOT_SUPPORTED";
            }
            case -1: {
                return "SERVICE_DISCONNECTED";
            }
            case 0: {
                return "OK";
            }
            case 1: {
                return "USER_CANCELED";
            }
            case 2: {
                return "SERVICE_UNAVAILABLE";
            }
            case 3: {
                return "BILLING_UNAVAILABLE";
            }
            case 4: {
                return "ITEM_UNAVAILABLE";
            }
            case 5: {
                return "DEVELOPER_ERROR";
            }
            case 6: {
                return "ERROR";
            }
            case 7: {
                return "ITEM_ALREADY_OWNED";
            }
            case 8: {
                return "ITEM_NOT_OWNED";
            }
            default: {
                return "UNKNOWN";
            }
        }
    }

    public List getSubscriptionTypeCachedPurchases() {
        return (List)this.cachedPurchases.get("subs");
    }

    private boolean isConsumableProductPurchase(Purchase purchase0, List list0) {
        return list0.contains(((String)purchase0.getSkus().get(0)));
    }

    public boolean isPurchaseValid(String s, String s1, String s2) {
        try {
            return Security.verifyPurchase(s, s1, s2);
        }
        catch(Exception exception0) {
            Logger.error(("Failed when validating purchase : " + exception0));
            return false;
        }
    }

    public boolean isServiceConnected() {
        return this.isServiceConnected;
    }

    @Override  // com.android.billingclient.api.PurchasesUpdatedListener
    public void onPurchasesUpdated(BillingResult billingResult0, List list0) {
        Logger.debug(("Purchases updated : " + this.getResponseCodeDescription(billingResult0.getResponseCode())));
        if(billingResult0.getResponseCode() == 0 && list0 != null) {
            for(Object object0: list0) {
                this.addToCachedPurchasesIfRequired(((Purchase)object0));
            }
            this.refreshPurchases();
            for(Object object1: list0) {
                this.purchasesStateListener.onPurchaseUpdated(((Purchase)object1));
            }
            return;
        }
        IPurchasesStateListener iPurchasesStateListener0 = this.purchasesStateListener;
        if(iPurchasesStateListener0 != null) {
            iPurchasesStateListener0.onPurchaseFailed(this.currentPurchaseProductId, this.getResponseCodeDescription(billingResult0.getResponseCode()));
        }
    }

    public void queryInAppTypePurchases(IQueryPurchasesListener iQueryPurchasesListener0) {
        this.queryPurchases("inapp", iQueryPurchasesListener0);
    }

    public void queryInAppTypeSkuDetails(List list0, IQuerySkuDetailsListener iQuerySkuDetailsListener0) {
        this.querySkuDetails(list0, "inapp", iQuerySkuDetailsListener0);
    }

    private void queryPurchases(String s, IQueryPurchasesListener iQueryPurchasesListener0) {
        public final class g implements IConnectionListener {
            public final String a;
            public final IQueryPurchasesListener b;
            public final GoogleBillingClient c;

            public g(String s, IQueryPurchasesListener iQueryPurchasesListener0) {
                this.a = s;
                this.b = iQueryPurchasesListener0;
                super();
            }

            @Override  // com.voxelbusters.essentialkit.billingservices.common.interfaces.IConnectionListener
            public final void onConnect() {
                public final class com.voxelbusters.essentialkit.billingservices.providers.google.GoogleBillingClient.g.a implements PurchasesResponseListener {
                    public final g a;

                    @Override  // com.android.billingclient.api.PurchasesResponseListener
                    public final void onQueryPurchasesResponse(BillingResult billingResult0, List list0) {
                        HashMap hashMap0 = GoogleBillingClient.this.cachedPurchases;
                        String s = g.this.a;
                        if(list0 == null) {
                            hashMap0.put(s, new ArrayList());
                        }
                        else {
                            hashMap0.put(s, new ArrayList());
                            for(Object object0: list0) {
                                GoogleBillingClient.this.addToCachedPurchasesIfRequired(((Purchase)object0));
                            }
                        }
                        if(g.this.b != null) {
                            Logger.debug(billingResult0.getDebugMessage());
                            if(billingResult0.getResponseCode() == 0) {
                                g.this.b.onQueryPurchasesSuccess(list0);
                                return;
                            }
                            g.this.b.onQueryPurchasesFailed(billingResult0.getDebugMessage());
                        }
                    }
                }

                GoogleBillingClient.this.billingClient.queryPurchasesAsync(QueryPurchasesParams.newBuilder().setProductType("inapp").build(), new com.voxelbusters.essentialkit.billingservices.providers.google.GoogleBillingClient.g.a(this));
            }

            @Override  // com.voxelbusters.essentialkit.billingservices.common.interfaces.IConnectionListener
            public final void onDisconnected(String s) {
                IQueryPurchasesListener iQueryPurchasesListener0 = this.b;
                if(iQueryPurchasesListener0 != null) {
                    iQueryPurchasesListener0.onQueryPurchasesFailed(s);
                }
            }
        }

        this.executeRequestOnConnect(new g(this, s, iQueryPurchasesListener0));
    }

    private void querySkuDetails(List list0, String s, IQuerySkuDetailsListener iQuerySkuDetailsListener0) {
        public final class f implements IConnectionListener {
            public final List a;
            public final IQuerySkuDetailsListener b;
            public final String c;
            public final GoogleBillingClient d;

            public f(List list0, IQuerySkuDetailsListener iQuerySkuDetailsListener0, String s) {
                this.a = list0;
                this.b = iQuerySkuDetailsListener0;
                this.c = s;
                super();
            }

            @Override  // com.voxelbusters.essentialkit.billingservices.common.interfaces.IConnectionListener
            public final void onConnect() {
                public final class com.voxelbusters.essentialkit.billingservices.providers.google.GoogleBillingClient.f.a implements ProductDetailsResponseListener {
                    public final f a;

                    @Override  // com.android.billingclient.api.ProductDetailsResponseListener
                    public final void onProductDetailsResponse(BillingResult billingResult0, List list0) {
                        Logger.debug(("Response code : " + billingResult0.getResponseCode()));
                        if(billingResult0.getResponseCode() == 0) {
                            GoogleBillingClient.this.clearProductDetailsCache();
                            for(Object object0: list0) {
                                GoogleBillingClient.this.allProductDetails.put(((ProductDetails)object0).getProductId(), ((ProductDetails)object0));
                            }
                            IQuerySkuDetailsListener iQuerySkuDetailsListener0 = f.this.b;
                            if(iQuerySkuDetailsListener0 != null) {
                                iQuerySkuDetailsListener0.onQuerySkuDetailsSuccess(list0);
                            }
                        }
                        else {
                            if(billingResult0.getResponseCode() == -2) {
                                Logger.warning("You may need to update google play app!");
                            }
                            IQuerySkuDetailsListener iQuerySkuDetailsListener1 = f.this.b;
                            if(iQuerySkuDetailsListener1 != null) {
                                iQuerySkuDetailsListener1.onQuerySkuDetailsFailed(billingResult0.getDebugMessage());
                            }
                        }
                    }
                }

                if(this.a != null && this.a.size() != 0) {
                    List list0 = Arrays.asList(new String[]{"", 0});
                    this.a.removeAll(list0);
                    Logger.debug(("Product identifiers after cleanup : " + this.a.size()));
                    com.android.billingclient.api.QueryProductDetailsParams.Builder queryProductDetailsParams$Builder0 = QueryProductDetailsParams.newBuilder();
                    queryProductDetailsParams$Builder0.setProductList(GoogleBillingClient.this.getQueryProductsList(this.a, this.c));
                    QueryProductDetailsParams queryProductDetailsParams0 = queryProductDetailsParams$Builder0.build();
                    com.voxelbusters.essentialkit.billingservices.providers.google.GoogleBillingClient.f.a googleBillingClient$f$a0 = new com.voxelbusters.essentialkit.billingservices.providers.google.GoogleBillingClient.f.a(this);
                    GoogleBillingClient.this.billingClient.queryProductDetailsAsync(queryProductDetailsParams0, googleBillingClient$f$a0);
                    return;
                }
                Logger.warning("No product identifiers in the query");
                IQuerySkuDetailsListener iQuerySkuDetailsListener0 = this.b;
                if(iQuerySkuDetailsListener0 != null) {
                    iQuerySkuDetailsListener0.onQuerySkuDetailsSuccess(new ArrayList());
                }
            }

            @Override  // com.voxelbusters.essentialkit.billingservices.common.interfaces.IConnectionListener
            public final void onDisconnected(String s) {
                IQuerySkuDetailsListener iQuerySkuDetailsListener0 = this.b;
                if(iQuerySkuDetailsListener0 != null) {
                    iQuerySkuDetailsListener0.onQuerySkuDetailsFailed(s);
                }
            }
        }

        this.executeRequestOnConnect(new f(this, list0, iQuerySkuDetailsListener0, s));
    }

    public void querySubscriptionTypePurchases(IQueryPurchasesListener iQueryPurchasesListener0) {
        this.queryPurchases("subs", iQueryPurchasesListener0);
    }

    public void querySubscriptionTypeSkuDetails(List list0, IQuerySkuDetailsListener iQuerySkuDetailsListener0) {
        this.querySkuDetails(list0, "subs", iQuerySkuDetailsListener0);
    }

    private void refreshPurchases() {
        this.queryInAppTypePurchases(null);
        this.querySubscriptionTypePurchases(null);
    }

    public void startProductPurchase(String s, String s1, IStartProductPurchaseListener iStartProductPurchaseListener0) {
        public final class b implements IConnectionListener {
            public final String a;
            public final IStartProductPurchaseListener b;
            public final String c;
            public final GoogleBillingClient d;

            public b(String s, IStartProductPurchaseListener iStartProductPurchaseListener0, String s1) {
                this.a = s;
                this.b = iStartProductPurchaseListener0;
                this.c = s1;
                super();
            }

            @Override  // com.voxelbusters.essentialkit.billingservices.common.interfaces.IConnectionListener
            public final void onConnect() {
                ProductDetails productDetails0 = GoogleBillingClient.this.getProductDetails(this.a);
                if(productDetails0 == null) {
                    Logger.warning("No billing product details were found. Make sure you call queryBillingProducts before accessing this method");
                    IStartProductPurchaseListener iStartProductPurchaseListener0 = this.b;
                    if(iStartProductPurchaseListener0 != null) {
                        iStartProductPurchaseListener0.onStartProductPurchaseFailed(this.a, "No billing product details were found. Make sure you call queryBillingProducts before accessing this method");
                    }
                    return;
                }
                ArrayList arrayList0 = new ArrayList();
                arrayList0.add(ProductDetailsParams.newBuilder().setProductDetails(productDetails0).build());
                BillingFlowParams billingFlowParams0 = BillingFlowParams.newBuilder().setProductDetailsParamsList(arrayList0).setObfuscatedAccountId(this.c).build();
                BillingResult billingResult0 = GoogleBillingClient.this.billingClient.launchBillingFlow(((Activity)GoogleBillingClient.this.context), billingFlowParams0);
                if(billingResult0.getResponseCode() != 0) {
                    Logger.debug(("Response from LaunchBillingFlow : " + billingResult0.getDebugMessage()));
                    IStartProductPurchaseListener iStartProductPurchaseListener1 = this.b;
                    if(iStartProductPurchaseListener1 != null) {
                        iStartProductPurchaseListener1.onStartProductPurchaseFailed(this.a, billingResult0.getDebugMessage());
                    }
                }
                else if(this.b != null) {
                    GoogleBillingClient.this.currentPurchaseProductId = this.a;
                    this.b.onStartProductPurchaseSuccess(this.a);
                }
            }

            @Override  // com.voxelbusters.essentialkit.billingservices.common.interfaces.IConnectionListener
            public final void onDisconnected(String s) {
                IStartProductPurchaseListener iStartProductPurchaseListener0 = this.b;
                if(iStartProductPurchaseListener0 != null) {
                    iStartProductPurchaseListener0.onStartProductPurchaseFailed(this.a, s);
                }
            }
        }

        this.executeRequestOnConnect(new b(this, s, iStartProductPurchaseListener0, s1));
    }

    private void updateListenersOnDisconnection(String s) {
        for(Object object0: this.connectionListeners) {
            ((IConnectionListener)object0).onDisconnected(s);
        }
        this.connectionListeners.clear();
    }

    private void updateListenersOnSuccess() {
        for(Object object0: this.connectionListeners) {
            ((IConnectionListener)object0).onConnect();
        }
        this.connectionListeners.clear();
    }
}

