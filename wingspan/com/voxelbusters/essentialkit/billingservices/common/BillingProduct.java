package com.voxelbusters.essentialkit.billingservices.common;

public class BillingProduct {
    public static class Builder {
        private BillingProduct billingProduct;

        public Builder(String s) {
            this.billingProduct = new BillingProduct(s, null);
        }

        public BillingProduct build() {
            return this.billingProduct;
        }

        public Builder setCurrencyCode(String s) {
            this.billingProduct.currencyCode = s;
            return this;
        }

        public Builder setDescription(String s) {
            this.billingProduct.description = s;
            return this;
        }

        public Builder setIconUrl(String s) {
            this.billingProduct.iconUrl = s;
            return this;
        }

        public Builder setIntroductoryPrice(String s) {
            this.billingProduct.introductoryPrice = s;
            return this;
        }

        public Builder setIntroductoryPriceInMicros(long v) {
            this.billingProduct.introductoryPriceInMicros = v;
            return this;
        }

        public Builder setOriginalPrice(String s) {
            this.billingProduct.originalPrice = s;
            return this;
        }

        public Builder setOriginalPriceInMicros(long v) {
            this.billingProduct.originalPriceInMicros = v;
            return this;
        }

        public Builder setPrice(String s) {
            this.billingProduct.price = s;
            return this;
        }

        public Builder setPriceInMicros(long v) {
            this.billingProduct.priceInMicros = v;
            return this;
        }

        public Builder setProductIdentifier(String s) {
            this.billingProduct.productIdentifier = s;
            return this;
        }

        public Builder setRewardable(boolean z) {
            this.billingProduct.isRewardable = z;
            return this;
        }

        public Builder setSubscription(boolean z) {
            this.billingProduct.isSubscription = z;
            return this;
        }

        public Builder setTitle(String s) {
            this.billingProduct.title = s;
            return this;
        }
    }

    public static final class a {
    }

    private String currencyCode;
    private String description;
    private String iconUrl;
    private String introductoryPrice;
    private long introductoryPriceInMicros;
    private boolean isRewardable;
    private boolean isSubscription;
    private String originalPrice;
    private long originalPriceInMicros;
    private String price;
    private long priceInMicros;
    private String productIdentifier;
    private String title;

    private BillingProduct(String s) {
        this.productIdentifier = s;
    }

    public BillingProduct(String s, a billingProduct$a0) {
        this(s);
    }

    public String getCurrencyCode() {
        return this.currencyCode;
    }

    public String getDescription() {
        return this.description;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getIntroductoryPrice() {
        return this.introductoryPrice;
    }

    public long getIntroductoryPriceInMicros() {
        return this.introductoryPriceInMicros;
    }

    public String getOriginalPrice() {
        return this.originalPrice;
    }

    public long getOriginalPriceInMicros() {
        return this.originalPriceInMicros;
    }

    public String getPrice() {
        return this.price;
    }

    public long getPriceInMicros() {
        return this.priceInMicros;
    }

    public String getProductIdentifier() {
        return this.productIdentifier;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isRewardable() {
        return this.isRewardable;
    }

    public boolean isSubscription() {
        return this.isSubscription;
    }
}

