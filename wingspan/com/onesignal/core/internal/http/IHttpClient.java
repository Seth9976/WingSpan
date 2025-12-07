package com.onesignal.core.internal.http;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J%\u0010\u0007\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\tJ!\u0010\n\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\fH¦@ø\u0001\u0000¢\u0006\u0002\u0010\rJ!\u0010\u000E\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\fH¦@ø\u0001\u0000¢\u0006\u0002\u0010\rJ!\u0010\u000F\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\fH¦@ø\u0001\u0000¢\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/onesignal/core/internal/http/IHttpClient;", "", "delete", "Lcom/onesignal/core/internal/http/HttpResponse;", "url", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "get", "cacheKey", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "patch", "body", "Lorg/json/JSONObject;", "(Ljava/lang/String;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "post", "put", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface IHttpClient {
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 0x30)
    public static final class DefaultImpls {
        public static Object get$default(IHttpClient iHttpClient0, String s, String s1, Continuation continuation0, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: get");
            }
            if((v & 2) != 0) {
                s1 = null;
            }
            return iHttpClient0.get(s, s1, continuation0);
        }
    }

    Object delete(String arg1, Continuation arg2);

    Object get(String arg1, String arg2, Continuation arg3);

    Object patch(String arg1, JSONObject arg2, Continuation arg3);

    Object post(String arg1, JSONObject arg2, Continuation arg3);

    Object put(String arg1, JSONObject arg2, Continuation arg3);
}

