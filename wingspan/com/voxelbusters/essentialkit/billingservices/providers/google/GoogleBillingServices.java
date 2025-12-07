package com.voxelbusters.essentialkit.billingservices.providers.google;

import android.content.Context;
import com.android.billingclient.api.AccountIdentifiers;
import com.android.billingclient.api.ProductDetails.OneTimePurchaseOfferDetails;
import com.android.billingclient.api.ProductDetails;
import com.android.billingclient.api.Purchase;
import com.voxelbusters.essentialkit.billingservices.common.BillingProduct;
import com.voxelbusters.essentialkit.billingservices.common.BillingTransaction.Builder;
import com.voxelbusters.essentialkit.billingservices.common.BillingTransaction;
import com.voxelbusters.essentialkit.billingservices.common.BillingTransactionState;
import com.voxelbusters.essentialkit.billingservices.common.BillingTransactionVerificationState;
import com.voxelbusters.essentialkit.billingservices.common.interfaces.IBillingServices;
import com.voxelbusters.essentialkit.billingservices.common.interfaces.IBillingTransactionStateListener;
import com.voxelbusters.essentialkit.billingservices.common.interfaces.IFetchBillingProductsListener;
import com.voxelbusters.essentialkit.billingservices.common.interfaces.IFetchBillingPurchaseListener;
import com.voxelbusters.essentialkit.billingservices.common.interfaces.IRestorePurchasesListener;
import com.voxelbusters.essentialkit.billingservices.providers.google.interfaces.IAcknowledgePurchaseListener;
import com.voxelbusters.essentialkit.billingservices.providers.google.interfaces.IConsumePurchaseListener;
import com.voxelbusters.essentialkit.billingservices.providers.google.interfaces.IPurchasesStateListener;
import com.voxelbusters.essentialkit.billingservices.providers.google.interfaces.IQueryPurchasesListener;
import com.voxelbusters.essentialkit.billingservices.providers.google.interfaces.IQuerySkuDetailsListener;
import com.voxelbusters.essentialkit.billingservices.providers.google.interfaces.IStartProductPurchaseListener;
import com.voxelbusters.essentialkit.utilities.Logger;
import com.voxelbusters.essentialkit.utilities.StringUtil;
import com.voxelbusters.essentialkit.utilities.common.ArrayBuffer;
import com.voxelbusters.essentialkit.utilities.common.annotations.RunOnUiThread;
import com.voxelbusters.essentialkit.utilities.common.interfaces.IFeature;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class GoogleBillingServices implements IBillingServices, IFeature {
    public final class a implements IPurchasesStateListener {
        public final GoogleBillingServices a;

        @Override  // com.voxelbusters.essentialkit.billingservices.providers.google.interfaces.IPurchasesStateListener
        public final void onPurchaseFailed(String s, String s1) {
            if(GoogleBillingServices.this.transactionStateListener != null) {
                Builder billingTransaction$Builder0 = new Builder("");
                billingTransaction$Builder0.setProductIdentifier(s);
                billingTransaction$Builder0.setState(BillingTransactionState.Failed);
                billingTransaction$Builder0.setVerificationState(BillingTransactionVerificationState.Unknown);
                GoogleBillingServices.this.transactionStateListener.onFailed(billingTransaction$Builder0.build(), s1);
            }
        }

        @Override  // com.voxelbusters.essentialkit.billingservices.providers.google.interfaces.IPurchasesStateListener
        public final void onPurchaseStarted(String s) {
            if(GoogleBillingServices.this.transactionStateListener != null) {
                Builder billingTransaction$Builder0 = new Builder("");
                billingTransaction$Builder0.setProductIdentifier(s);
                billingTransaction$Builder0.setState(BillingTransactionState.Started);
                billingTransaction$Builder0.setVerificationState(BillingTransactionVerificationState.Unknown);
                GoogleBillingServices.this.transactionStateListener.onStarted(billingTransaction$Builder0.build());
            }
        }

        @Override  // com.voxelbusters.essentialkit.billingservices.providers.google.interfaces.IPurchasesStateListener
        public final void onPurchaseUpdated(Purchase purchase0) {
            if(GoogleBillingServices.this.transactionStateListener != null) {
                BillingTransaction billingTransaction0 = GoogleBillingServices.this.getBillingTransactionBuilder(purchase0).build();
                GoogleBillingServices.this.transactionStateListener.onUpdated(billingTransaction0);
            }
        }
    }

    private List allBillingProducts;
    private List consumableProductIdentifiers;
    private GoogleBillingClient instance;
    private List nonConsumableProductIdentifiers;
    private String publicKey;
    private IPurchasesStateListener purchasesStateListener;
    private List subscriptionProductIdentifiers;
    private IBillingTransactionStateListener transactionStateListener;

    public GoogleBillingServices(Context context0) {
        this.allBillingProducts = new ArrayList();
        a googleBillingServices$a0 = new a(this);
        this.purchasesStateListener = googleBillingServices$a0;
        this.instance = new GoogleBillingClient(context0, googleBillingServices$a0);
    }

    @Override  // com.voxelbusters.essentialkit.billingservices.common.interfaces.IBillingServices
    @RunOnUiThread
    public void buyProduct(String s, String s1) {
        public final class c implements IStartProductPurchaseListener {
            public final GoogleBillingServices a;

            @Override  // com.voxelbusters.essentialkit.billingservices.providers.google.interfaces.IStartProductPurchaseListener
            public final void onStartProductPurchaseFailed(String s, String s1) {
                GoogleBillingServices.this.purchasesStateListener.onPurchaseFailed(s, s1);
            }

            @Override  // com.voxelbusters.essentialkit.billingservices.providers.google.interfaces.IStartProductPurchaseListener
            public final void onStartProductPurchaseSuccess(String s) {
                GoogleBillingServices.this.purchasesStateListener.onPurchaseStarted(s);
            }
        }

        this.instance.startProductPurchase(s, s1, new c(this));
    }

    @Override  // com.voxelbusters.essentialkit.billingservices.common.interfaces.IBillingServices
    public boolean canMakePayments() {
        return this.instance.isServiceConnected();
    }

    @Override  // com.voxelbusters.essentialkit.billingservices.common.interfaces.IBillingServices
    public void fetchProductDetails(IFetchBillingProductsListener iFetchBillingProductsListener0) {
        public final class b implements IQuerySkuDetailsListener {
            public final List a;
            public final IFetchBillingProductsListener b;
            public final GoogleBillingServices c;

            public b(ArrayList arrayList0, IFetchBillingProductsListener iFetchBillingProductsListener0) {
                this.a = arrayList0;
                this.b = iFetchBillingProductsListener0;
                super();
            }

            @Override  // com.voxelbusters.essentialkit.billingservices.providers.google.interfaces.IQuerySkuDetailsListener
            public final void onQuerySkuDetailsFailed(String s) {
                Logger.debug(("onQuerySkuDetailsFailed : " + s));
                this.b.onFailure(s);
            }

            @Override  // com.voxelbusters.essentialkit.billingservices.providers.google.interfaces.IQuerySkuDetailsListener
            public final void onQuerySkuDetailsSuccess(List list0) {
                public final class com.voxelbusters.essentialkit.billingservices.providers.google.GoogleBillingServices.b.a implements IQuerySkuDetailsListener {
                    public final b a;

                    @Override  // com.voxelbusters.essentialkit.billingservices.providers.google.interfaces.IQuerySkuDetailsListener
                    public final void onQuerySkuDetailsFailed(String s) {
                        b.this.b.onFailure(s);
                        GoogleBillingServices.this.allBillingProducts.clear();
                    }

                    @Override  // com.voxelbusters.essentialkit.billingservices.providers.google.interfaces.IQuerySkuDetailsListener
                    public final void onQuerySkuDetailsSuccess(List list0) {
                        List list1 = GoogleBillingServices.this.getBillingProducts(list0);
                        GoogleBillingServices.this.allBillingProducts.addAll(list1);
                        GoogleBillingServices.this.reportSuccessForProductDetails(GoogleBillingServices.this.allBillingProducts, b.this.a, b.this.b);
                    }
                }


                public final class com.voxelbusters.essentialkit.billingservices.providers.google.GoogleBillingServices.b.b implements IQueryPurchasesListener {
                    public final b a;

                    @Override  // com.voxelbusters.essentialkit.billingservices.providers.google.interfaces.IQueryPurchasesListener
                    public final void onQueryPurchasesFailed(String s) {
                        Logger.warning("Failed fetching past purchases. Try again later");
                        GoogleBillingServices.this.reportSuccessForProductDetails(GoogleBillingServices.this.allBillingProducts, b.this.a, b.this.b);
                    }

                    @Override  // com.voxelbusters.essentialkit.billingservices.providers.google.interfaces.IQueryPurchasesListener
                    public final void onQueryPurchasesSuccess(List list0) {
                        GoogleBillingServices.this.reportSuccessForProductDetails(GoogleBillingServices.this.allBillingProducts, b.this.a, b.this.b);
                    }
                }

                Logger.debug("onQuerySkuDetailsSuccess");
                List list1 = GoogleBillingServices.this.getBillingProducts(list0);
                GoogleBillingServices.this.allBillingProducts = list1;
                if(GoogleBillingServices.this.subscriptionProductIdentifiers.size() > 0) {
                    GoogleBillingServices.this.instance.querySubscriptionTypeSkuDetails(GoogleBillingServices.this.subscriptionProductIdentifiers, new com.voxelbusters.essentialkit.billingservices.providers.google.GoogleBillingServices.b.a(this));
                    return;
                }
                GoogleBillingServices.this.instance.queryInAppTypePurchases(new com.voxelbusters.essentialkit.billingservices.providers.google.GoogleBillingServices.b.b(this));
            }
        }

        ArrayList arrayList0 = new ArrayList();
        arrayList0.addAll(this.consumableProductIdentifiers);
        arrayList0.addAll(this.nonConsumableProductIdentifiers);
        Logger.debug(("Total products to fetch : " + arrayList0.size()));
        this.instance.queryInAppTypeSkuDetails(arrayList0, new b(this, arrayList0, iFetchBillingProductsListener0));
    }

    @Override  // com.voxelbusters.essentialkit.billingservices.common.interfaces.IBillingServices
    public void finishBillingTransaction(String s, boolean z) {
        public final class d implements IFetchBillingPurchaseListener {
            public final String a;
            public final boolean b;
            public final GoogleBillingServices c;

            public d(String s, boolean z) {
                this.a = s;
                this.b = z;
                super();
            }

            @Override  // com.voxelbusters.essentialkit.billingservices.common.interfaces.IFetchBillingPurchaseListener
            public final void onFailure(String s) {
                Logger.warning(("Error fetching purchase details for productId: " + this.a));
            }

            @Override  // com.voxelbusters.essentialkit.billingservices.common.interfaces.IFetchBillingPurchaseListener
            public final void onSuccess(Purchase purchase0) {
                public final class com.voxelbusters.essentialkit.billingservices.providers.google.GoogleBillingServices.d.a implements IConsumePurchaseListener {
                    public final String a;

                    public com.voxelbusters.essentialkit.billingservices.providers.google.GoogleBillingServices.d.a(String s) {
                    }

                    @Override  // com.voxelbusters.essentialkit.billingservices.providers.google.interfaces.IConsumePurchaseListener
                    public final void onConsumePurchaseFailed(String s) {
                        Logger.error(String.format("[ProductId : %s] Failed consuming purchase with error : %s", this.a, s));
                    }

                    @Override  // com.voxelbusters.essentialkit.billingservices.providers.google.interfaces.IConsumePurchaseListener
                    public final void onConsumePurchaseSuccess() {
                        Logger.debug(String.format("[ProductId : %s] Finished consuming purchase", this.a));
                    }
                }


                public final class com.voxelbusters.essentialkit.billingservices.providers.google.GoogleBillingServices.d.b implements IAcknowledgePurchaseListener {
                    public final String a;

                    public com.voxelbusters.essentialkit.billingservices.providers.google.GoogleBillingServices.d.b(String s) {
                    }

                    @Override  // com.voxelbusters.essentialkit.billingservices.providers.google.interfaces.IAcknowledgePurchaseListener
                    public final void onAcknowledgePurchaseFailed(String s) {
                        Logger.error(String.format("[ProductId : %s] Failed with acknowledging purchase with error : %s", this.a, s));
                    }

                    @Override  // com.voxelbusters.essentialkit.billingservices.providers.google.interfaces.IAcknowledgePurchaseListener
                    public final void onAcknowlegePurchaseSuccess() {
                        Logger.debug(String.format("[ProductId : %s] Finished acknowledging purchase", this.a));
                    }
                }

                String s = this.a;
                boolean z = GoogleBillingServices.this.isConsumableProduct(s);
                if(purchase0 != null && purchase0.getPurchaseState() == 1) {
                    if(z || !this.b) {
                        if(!this.b) {
                            Logger.error("Product marked as an invalid purchase due its verification failure. Consuming silently as its an invalid purchase(verification failed)");
                        }
                        String s2 = purchase0.getPurchaseToken();
                        com.voxelbusters.essentialkit.billingservices.providers.google.GoogleBillingServices.d.a googleBillingServices$d$a0 = new com.voxelbusters.essentialkit.billingservices.providers.google.GoogleBillingServices.d.a(s);
                        GoogleBillingServices.this.instance.consumePurchase(s2, googleBillingServices$d$a0);
                    }
                    else if(!purchase0.isAcknowledged()) {
                        String s1 = purchase0.getPurchaseToken();
                        com.voxelbusters.essentialkit.billingservices.providers.google.GoogleBillingServices.d.b googleBillingServices$d$b0 = new com.voxelbusters.essentialkit.billingservices.providers.google.GoogleBillingServices.d.b(s);
                        GoogleBillingServices.this.instance.acknowledgePurchase(s1, googleBillingServices$d$b0);
                        return;
                    }
                    return;
                }
                Logger.warning("Shouldn\'t finish any non-purchased transaction. Returning...");
            }
        }

        if(StringUtil.isNullOrEmpty(s)) {
            return;
        }
        this.instance.fetchPurchase(s, new d(this, s, z));
    }

    private BillingProduct getBillingProduct(ProductDetails productDetails0) {
        com.voxelbusters.essentialkit.billingservices.common.BillingProduct.Builder billingProduct$Builder0 = new com.voxelbusters.essentialkit.billingservices.common.BillingProduct.Builder(productDetails0.getProductId());
        billingProduct$Builder0.setProductIdentifier(productDetails0.getProductId());
        billingProduct$Builder0.setTitle(productDetails0.getTitle());
        billingProduct$Builder0.setDescription(productDetails0.getDescription());
        Logger.debug(("Product details : " + productDetails0));
        if(productDetails0.getProductType().equals("inapp")) {
            OneTimePurchaseOfferDetails productDetails$OneTimePurchaseOfferDetails0 = productDetails0.getOneTimePurchaseOfferDetails();
            billingProduct$Builder0.setPrice(productDetails$OneTimePurchaseOfferDetails0.getFormattedPrice());
            billingProduct$Builder0.setPriceInMicros(productDetails$OneTimePurchaseOfferDetails0.getPriceAmountMicros());
            billingProduct$Builder0.setCurrencyCode(productDetails$OneTimePurchaseOfferDetails0.getPriceCurrencyCode());
        }
        else {
            Logger.warning("Product is subscription and pricing details are not fetched!");
        }
        billingProduct$Builder0.setSubscription(productDetails0.getProductType().equals("subs"));
        return billingProduct$Builder0.build();
    }

    private List getBillingProducts(List list0) {
        List list1 = new ArrayList();
        for(Object object0: list0) {
            ((ArrayList)list1).add(this.getBillingProduct(((ProductDetails)object0)));
        }
        return list1;
    }

    private Builder getBillingTransactionBuilder(Purchase purchase0) {
        Builder billingTransaction$Builder0 = new Builder(purchase0.getOrderId());
        billingTransaction$Builder0.setProductIdentifier(((String)purchase0.getSkus().get(0)));
        billingTransaction$Builder0.setPurchaseData(purchase0.getOriginalJson());
        billingTransaction$Builder0.setPurchaseDate(new Date(purchase0.getPurchaseTime()));
        billingTransaction$Builder0.setState(this.getTransactionState(purchase0.getPurchaseState()));
        billingTransaction$Builder0.setAcknowledged(purchase0.isAcknowledged());
        billingTransaction$Builder0.setReceipt(purchase0.getPurchaseToken());
        billingTransaction$Builder0.setVerificationState((this.instance.isPurchaseValid(this.publicKey, purchase0.getOriginalJson(), purchase0.getSignature()) ? BillingTransactionVerificationState.Success : BillingTransactionVerificationState.Failure));
        billingTransaction$Builder0.setSignature(purchase0.getSignature());
        billingTransaction$Builder0.setQuantity(purchase0.getQuantity());
        AccountIdentifiers accountIdentifiers0 = purchase0.getAccountIdentifiers();
        if(accountIdentifiers0 != null) {
            billingTransaction$Builder0.setUserTag(accountIdentifiers0.getObfuscatedAccountId());
        }
        return billingTransaction$Builder0;
    }

    private List getBillingTransactions(List list0) {
        List list1 = new ArrayList(list0.size());
        for(Object object0: list0) {
            ((ArrayList)list1).add(this.getBillingTransactionBuilder(((Purchase)object0)).build());
        }
        return list1;
    }

    @Override  // com.voxelbusters.essentialkit.utilities.common.interfaces.IFeature
    public String getFeatureName() {
        return "Google Billing Services Handler";
    }

    @Override  // com.voxelbusters.essentialkit.billingservices.common.interfaces.IBillingServices
    public List getIncompleteBillingTransactions() {
        return this.getBillingTransactions(this.instance.getIncompletePurchases(this.consumableProductIdentifiers));
    }

    private BillingTransactionState getTransactionState(int v) {
        switch(v) {
            case 1: {
                return BillingTransactionState.Purchased;
            }
            case 2: {
                return BillingTransactionState.Pending;
            }
            default: {
                return BillingTransactionState.Unknown;
            }
        }
    }

    @Override  // com.voxelbusters.essentialkit.billingservices.common.interfaces.IBillingServices
    public void initialise(String s, IBillingTransactionStateListener iBillingTransactionStateListener0) {
        this.publicKey = s;
        this.transactionStateListener = iBillingTransactionStateListener0;
    }

    private boolean isConsumableProduct(String s) {
        for(Object object0: this.consumableProductIdentifiers) {
            if(((String)object0).equals(s)) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    private void reportSuccessForProductDetails(List list0, List list1, IFetchBillingProductsListener iFetchBillingProductsListener0) {
        ArrayBuffer arrayBuffer0 = null;
        ArrayList arrayList0 = null;
        for(Object object0: list0) {
            BillingProduct billingProduct0 = (BillingProduct)object0;
            if(list1.contains(billingProduct0.getProductIdentifier())) {
                Logger.debug(("exists : " + billingProduct0.getProductIdentifier()));
            }
            else {
                if(arrayList0 == null) {
                    arrayList0 = new ArrayList();
                }
                arrayList0.add(billingProduct0.getProductIdentifier());
            }
        }
        if(iFetchBillingProductsListener0 != null) {
            if(arrayList0 != null) {
                arrayBuffer0 = new ArrayBuffer(arrayList0.toArray(new String[arrayList0.size()]));
            }
            iFetchBillingProductsListener0.onSuccess(list0, arrayBuffer0);
        }
    }

    @Override  // com.voxelbusters.essentialkit.billingservices.common.interfaces.IBillingServices
    public void restorePurchases(String s, IRestorePurchasesListener iRestorePurchasesListener0) {
        public final class e implements IQueryPurchasesListener {
            public final String a;
            public final IRestorePurchasesListener b;
            public final GoogleBillingServices c;

            public e(String s, IRestorePurchasesListener iRestorePurchasesListener0) {
                this.a = s;
                this.b = iRestorePurchasesListener0;
                super();
            }

            @Override  // com.voxelbusters.essentialkit.billingservices.providers.google.interfaces.IQueryPurchasesListener
            public final void onQueryPurchasesFailed(String s) {
                this.b.onFailure(s);
            }

            @Override  // com.voxelbusters.essentialkit.billingservices.providers.google.interfaces.IQueryPurchasesListener
            public final void onQueryPurchasesSuccess(List list0) {
                String s;
                ArrayList arrayList0 = new ArrayList();
                for(Object object0: list0) {
                    Purchase purchase0 = (Purchase)object0;
                    if(StringUtil.isNullOrEmpty(this.a)) {
                        if(purchase0.getPurchaseState() == 1) {
                            String s1 = (String)purchase0.getSkus().get(0);
                            if(!GoogleBillingServices.this.isConsumableProduct(s1)) {
                                Builder billingTransaction$Builder0 = GoogleBillingServices.this.getBillingTransactionBuilder(purchase0);
                                billingTransaction$Builder0.setState(BillingTransactionState.Restored);
                                arrayList0.add(billingTransaction$Builder0.build());
                                continue;
                            }
                        }
                        s = "Skipping adding to restore purchases as its orphan consumable product or not having purchased state : " + ((String)purchase0.getSkus().get(0));
                    }
                    else {
                        Logger.debug("UserTag specified so querying only purchases related to this userTag");
                        AccountIdentifiers accountIdentifiers0 = purchase0.getAccountIdentifiers();
                        if(accountIdentifiers0 != null && !this.a.equals(accountIdentifiers0.getObfuscatedAccountId())) {
                            s = "Skipping purchase found for a different user : " + accountIdentifiers0.getObfuscatedAccountId();
                        }
                    }
                    Logger.warning(s);
                }
                this.b.onSuccess(arrayList0);
            }
        }

        this.instance.queryInAppTypePurchases(new e(this, s, iRestorePurchasesListener0));
    }

    @Override  // com.voxelbusters.essentialkit.billingservices.common.interfaces.IBillingServices
    public void setProducts(String[] arr_s, String[] arr_s1, String[] arr_s2) {
        List list0 = arr_s == null ? new ArrayList() : Arrays.asList(arr_s);
        this.consumableProductIdentifiers = list0;
        List list1 = arr_s1 == null ? new ArrayList() : Arrays.asList(arr_s1);
        this.nonConsumableProductIdentifiers = list1;
        List list2 = arr_s2 == null ? new ArrayList() : Arrays.asList(arr_s2);
        this.subscriptionProductIdentifiers = list2;
    }

    public boolean tryClearingIncompleteTransactions() {
        List list0 = this.instance.getIncompletePurchases(this.consumableProductIdentifiers);
        for(Object object0: list0) {
            this.purchasesStateListener.onPurchaseUpdated(((Purchase)object0));
        }
        return list0.size() > 0;
    }
}

