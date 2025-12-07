package com.onesignal.common.services;

import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u00042\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0006H&J!\u0010\u0007\u001A\u0002H\u0004\"\u0004\b\u0000\u0010\u00042\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0006H&¢\u0006\u0002\u0010\bJ#\u0010\t\u001A\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u00042\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0006H&¢\u0006\u0002\u0010\bJ\u001C\u0010\n\u001A\u00020\u000B\"\u0004\b\u0000\u0010\u00042\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0006H&¨\u0006\f"}, d2 = {"Lcom/onesignal/common/services/IServiceProvider;", "", "getAllServices", "", "T", "c", "Ljava/lang/Class;", "getService", "(Ljava/lang/Class;)Ljava/lang/Object;", "getServiceOrNull", "hasService", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface IServiceProvider {
    List getAllServices(Class arg1);

    Object getService(Class arg1);

    Object getServiceOrNull(Class arg1);

    boolean hasService(Class arg1);
}

