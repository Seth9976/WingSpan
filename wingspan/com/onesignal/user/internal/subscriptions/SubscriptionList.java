package com.onesignal.user.internal.subscriptions;

import com.onesignal.user.subscriptions.IEmailSubscription;
import com.onesignal.user.subscriptions.IPushSubscription;
import com.onesignal.user.subscriptions.ISmsSubscription;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001B\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0013\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\u0014\u001A\u00020\u0015J\u0010\u0010\u0016\u001A\u0004\u0018\u00010\u00112\u0006\u0010\u0017\u001A\u00020\u0015R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0017\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u000B0\u00038F¢\u0006\u0006\u001A\u0004\b\f\u0010\tR\u0011\u0010\r\u001A\u00020\u00068F¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0017\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00110\u00038F¢\u0006\u0006\u001A\u0004\b\u0012\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/onesignal/user/internal/subscriptions/SubscriptionList;", "", "collection", "", "Lcom/onesignal/user/subscriptions/ISubscription;", "_fallbackPushSub", "Lcom/onesignal/user/subscriptions/IPushSubscription;", "(Ljava/util/List;Lcom/onesignal/user/subscriptions/IPushSubscription;)V", "getCollection", "()Ljava/util/List;", "emails", "Lcom/onesignal/user/subscriptions/IEmailSubscription;", "getEmails", "push", "getPush", "()Lcom/onesignal/user/subscriptions/IPushSubscription;", "smss", "Lcom/onesignal/user/subscriptions/ISmsSubscription;", "getSmss", "getByEmail", "email", "", "getBySMS", "sms", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class SubscriptionList {
    private final IPushSubscription _fallbackPushSub;
    private final List collection;

    public SubscriptionList(List list0, IPushSubscription iPushSubscription0) {
        Intrinsics.checkNotNullParameter(list0, "collection");
        Intrinsics.checkNotNullParameter(iPushSubscription0, "_fallbackPushSub");
        super();
        this.collection = list0;
        this._fallbackPushSub = iPushSubscription0;
    }

    public final IEmailSubscription getByEmail(String s) {
        Intrinsics.checkNotNullParameter(s, "email");
        for(Object object0: this.getEmails()) {
            if(Intrinsics.areEqual(((IEmailSubscription)object0).getEmail(), s)) {
                return (IEmailSubscription)object0;
            }
            if(false) {
                break;
            }
        }
        return null;
    }

    public final ISmsSubscription getBySMS(String s) {
        Intrinsics.checkNotNullParameter(s, "sms");
        for(Object object0: this.getSmss()) {
            if(Intrinsics.areEqual(((ISmsSubscription)object0).getNumber(), s)) {
                return (ISmsSubscription)object0;
            }
            if(false) {
                break;
            }
        }
        return null;
    }

    public final List getCollection() {
        return this.collection;
    }

    public final List getEmails() {
        Collection collection0 = new ArrayList();
        for(Object object0: this.collection) {
            if(object0 instanceof IEmailSubscription) {
                collection0.add(object0);
            }
        }
        return (List)collection0;
    }

    public final IPushSubscription getPush() {
        Collection collection0 = new ArrayList();
        for(Object object0: this.collection) {
            if(object0 instanceof IPushSubscription) {
                collection0.add(object0);
            }
        }
        IPushSubscription iPushSubscription0 = (IPushSubscription)CollectionsKt.firstOrNull(((List)collection0));
        return iPushSubscription0 == null ? this._fallbackPushSub : iPushSubscription0;
    }

    public final List getSmss() {
        Collection collection0 = new ArrayList();
        for(Object object0: this.collection) {
            if(object0 instanceof ISmsSubscription) {
                collection0.add(object0);
            }
        }
        return (List)collection0;
    }
}

