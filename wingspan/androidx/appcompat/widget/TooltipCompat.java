package androidx.appcompat.widget;

import android.os.Build.VERSION;
import android.view.View;

public class TooltipCompat {
    public static void setTooltipText(View view0, CharSequence charSequence0) {
        if(Build.VERSION.SDK_INT >= 26) {
            view0.setTooltipText(charSequence0);
            return;
        }
        TooltipCompatHandler.setTooltipText(view0, charSequence0);
    }
}

