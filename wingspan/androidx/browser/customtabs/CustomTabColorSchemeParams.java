package androidx.browser.customtabs;

import android.os.Bundle;

public final class CustomTabColorSchemeParams {
    public static final class Builder {
        private Integer mNavigationBarColor;
        private Integer mNavigationBarDividerColor;
        private Integer mSecondaryToolbarColor;
        private Integer mToolbarColor;

        public CustomTabColorSchemeParams build() {
            return new CustomTabColorSchemeParams(this.mToolbarColor, this.mSecondaryToolbarColor, this.mNavigationBarColor, this.mNavigationBarDividerColor);
        }

        public Builder setNavigationBarColor(int color) {
            this.mNavigationBarColor = (int)(color | 0xFF000000);
            return this;
        }

        public Builder setNavigationBarDividerColor(int color) {
            this.mNavigationBarDividerColor = color;
            return this;
        }

        public Builder setSecondaryToolbarColor(int color) {
            this.mSecondaryToolbarColor = color;
            return this;
        }

        public Builder setToolbarColor(int color) {
            this.mToolbarColor = (int)(color | 0xFF000000);
            return this;
        }
    }

    public final Integer navigationBarColor;
    public final Integer navigationBarDividerColor;
    public final Integer secondaryToolbarColor;
    public final Integer toolbarColor;

    CustomTabColorSchemeParams(Integer toolbarColor, Integer secondaryToolbarColor, Integer navigationBarColor, Integer navigationBarDividerColor) {
        this.toolbarColor = toolbarColor;
        this.secondaryToolbarColor = secondaryToolbarColor;
        this.navigationBarColor = navigationBarColor;
        this.navigationBarDividerColor = navigationBarDividerColor;
    }

    static CustomTabColorSchemeParams fromBundle(Bundle bundle) {
        if(bundle == null) {
            bundle = new Bundle(0);
        }
        return new CustomTabColorSchemeParams(((Integer)bundle.get("android.support.customtabs.extra.TOOLBAR_COLOR")), ((Integer)bundle.get("android.support.customtabs.extra.SECONDARY_TOOLBAR_COLOR")), ((Integer)bundle.get("androidx.browser.customtabs.extra.NAVIGATION_BAR_COLOR")), ((Integer)bundle.get("androidx.browser.customtabs.extra.NAVIGATION_BAR_DIVIDER_COLOR")));
    }

    Bundle toBundle() {
        Bundle bundle0 = new Bundle();
        Integer integer0 = this.toolbarColor;
        if(integer0 != null) {
            bundle0.putInt("android.support.customtabs.extra.TOOLBAR_COLOR", ((int)integer0));
        }
        Integer integer1 = this.secondaryToolbarColor;
        if(integer1 != null) {
            bundle0.putInt("android.support.customtabs.extra.SECONDARY_TOOLBAR_COLOR", ((int)integer1));
        }
        Integer integer2 = this.navigationBarColor;
        if(integer2 != null) {
            bundle0.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_COLOR", ((int)integer2));
        }
        Integer integer3 = this.navigationBarDividerColor;
        if(integer3 != null) {
            bundle0.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_DIVIDER_COLOR", ((int)integer3));
        }
        return bundle0;
    }

    // 去混淆评级： 低(40)
    CustomTabColorSchemeParams withDefaults(CustomTabColorSchemeParams defaults) {
        return new CustomTabColorSchemeParams((this.toolbarColor == null ? defaults.toolbarColor : this.toolbarColor), (this.secondaryToolbarColor == null ? defaults.secondaryToolbarColor : this.secondaryToolbarColor), (this.navigationBarColor == null ? defaults.navigationBarColor : this.navigationBarColor), (this.navigationBarDividerColor == null ? defaults.navigationBarDividerColor : this.navigationBarDividerColor));
    }
}

