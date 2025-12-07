package com.onesignal;

import com.onesignal.internal.OneSignalImp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/onesignal/internal/OneSignalImp;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
final class OneSignal.oneSignal.2 extends Lambda implements Function0 {
    public static final OneSignal.oneSignal.2 INSTANCE;

    static {
        OneSignal.oneSignal.2.INSTANCE = new OneSignal.oneSignal.2();
    }

    OneSignal.oneSignal.2() {
        super(0);
    }

    public final OneSignalImp invoke() {
        return new OneSignalImp();
    }

    @Override  // kotlin.jvm.functions.Function0
    public Object invoke() {
        return this.invoke();
    }
}

