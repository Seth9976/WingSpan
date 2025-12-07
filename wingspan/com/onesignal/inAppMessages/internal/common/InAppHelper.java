package com.onesignal.inAppMessages.internal.common;

import com.onesignal.core.internal.language.ILanguageContext;
import com.onesignal.inAppMessages.internal.InAppMessage;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\nR\u0014\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2 = {"Lcom/onesignal/inAppMessages/internal/common/InAppHelper;", "", "()V", "PREFERRED_VARIANT_ORDER", "", "", "variantIdForMessage", "message", "Lcom/onesignal/inAppMessages/internal/InAppMessage;", "languageContext", "Lcom/onesignal/core/internal/language/ILanguageContext;", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class InAppHelper {
    public static final InAppHelper INSTANCE;
    private static final List PREFERRED_VARIANT_ORDER;

    static {
        InAppHelper.INSTANCE = new InAppHelper();
        InAppHelper.PREFERRED_VARIANT_ORDER = CollectionsKt.listOf(new String[]{"android", "app", "all"});
    }

    public final String variantIdForMessage(InAppMessage inAppMessage0, ILanguageContext iLanguageContext0) {
        Intrinsics.checkNotNullParameter(inAppMessage0, "message");
        Intrinsics.checkNotNullParameter(iLanguageContext0, "languageContext");
        String s = iLanguageContext0.getLanguage();
        for(Object object0: InAppHelper.PREFERRED_VARIANT_ORDER) {
            String s1 = (String)object0;
            if(inAppMessage0.getVariants().containsKey(s1)) {
                Object object1 = inAppMessage0.getVariants().get(s1);
                Intrinsics.checkNotNull(object1);
                if(!((Map)object1).containsKey(s)) {
                    s = "default";
                }
                return (String)((Map)object1).get(s);
            }
            if(false) {
                break;
            }
        }
        return null;
    }
}

