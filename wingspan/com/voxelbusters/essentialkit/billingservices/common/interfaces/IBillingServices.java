package com.voxelbusters.essentialkit.billingservices.common.interfaces;

import java.util.List;

public interface IBillingServices {
    void buyProduct(String arg1, String arg2);

    boolean canMakePayments();

    void fetchProductDetails(IFetchBillingProductsListener arg1);

    void finishBillingTransaction(String arg1, boolean arg2);

    List getIncompleteBillingTransactions();

    void initialise(String arg1, IBillingTransactionStateListener arg2);

    void restorePurchases(String arg1, IRestorePurchasesListener arg2);

    void setProducts(String[] arg1, String[] arg2, String[] arg3);
}

