package com.voxelbusters.essentialkit.billingservices.common;

import java.util.Date;

public class BillingTransaction {
    public static class Builder {
        private BillingTransaction transaction;

        public Builder(String s) {
            this.transaction = new BillingTransaction(s, null);
        }

        public BillingTransaction build() {
            return this.transaction;
        }

        public Builder setAcknowledged(boolean z) {
            this.transaction.isAcknowledged = z;
            return this;
        }

        public Builder setProductIdentifier(String s) {
            this.transaction.productIdentifier = s;
            return this;
        }

        public Builder setPurchaseData(String s) {
            this.transaction.purchaseData = s;
            return this;
        }

        public Builder setPurchaseDate(Date date0) {
            this.transaction.purchaseDate = date0;
            return this;
        }

        public Builder setQuantity(int v) {
            this.transaction.quantity = v;
            return this;
        }

        public Builder setReceipt(String s) {
            this.transaction.receipt = s;
            return this;
        }

        public Builder setSignature(String s) {
            this.transaction.signature = s;
            return this;
        }

        public Builder setState(BillingTransactionState billingTransactionState0) {
            this.transaction.state = billingTransactionState0;
            return this;
        }

        public Builder setUserTag(String s) {
            this.transaction.userTag = s;
            return this;
        }

        public Builder setVerificationState(BillingTransactionVerificationState billingTransactionVerificationState0) {
            this.transaction.verificationState = billingTransactionVerificationState0;
            return this;
        }
    }

    public static final class a {
    }

    private String error;
    private String id;
    private boolean isAcknowledged;
    private String productIdentifier;
    private String purchaseData;
    private Date purchaseDate;
    private int quantity;
    private String receipt;
    private String signature;
    private BillingTransactionState state;
    private String userTag;
    private BillingTransactionVerificationState verificationState;

    private BillingTransaction(String s) {
        this.id = s;
    }

    public BillingTransaction(String s, a billingTransaction$a0) {
        this(s);
    }

    public String getId() {
        return this.id;
    }

    public String getProductIdentifier() {
        return this.productIdentifier;
    }

    public String getPurchaseData() {
        return this.purchaseData;
    }

    public Date getPurchaseDate() {
        return this.purchaseDate;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public String getReceipt() {
        return this.receipt;
    }

    public String getSignature() {
        return this.signature;
    }

    public BillingTransactionState getState() {
        return this.state;
    }

    public String getUserTag() {
        return this.userTag;
    }

    public BillingTransactionVerificationState getVerificationState() {
        return this.verificationState;
    }

    public boolean isAcknowledged() {
        return this.isAcknowledged;
    }

    public void setVerificationState(BillingTransactionVerificationState billingTransactionVerificationState0) {
        this.verificationState = billingTransactionVerificationState0;
    }

    @Override
    public String toString() {
        return "BillingTransaction{id=\'" + this.id + "\', productIdentifier=\'" + this.productIdentifier + "\', isAcknowledged=" + this.isAcknowledged + ", purchaseData=\'" + this.purchaseData + "\', purchaseDate=" + this.purchaseDate + ", state=" + this.state + ", verificationState=" + this.verificationState + ", userTag=\'" + this.userTag + "\', error=\'" + this.error + "\', quantity=" + this.quantity + '}';
    }
}

