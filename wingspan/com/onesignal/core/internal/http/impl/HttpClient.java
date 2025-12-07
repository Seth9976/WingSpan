package com.onesignal.core.internal.http.impl;

import android.net.TrafficStats;
import android.os.Build.VERSION;
import com.onesignal.common.JSONUtils;
import com.onesignal.common.OneSignalWrapper;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.http.HttpResponse;
import com.onesignal.core.internal.http.IHttpClient;
import com.onesignal.core.internal.preferences.IPreferencesService.DefaultImpls;
import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.debug.internal.logging.Logging;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.Scanner;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \u001F2\u00020\u0001:\u0001\u001FB\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0002\u0010\bJ\u0019\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\rJ#\u0010\u000E\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\b\u0010\u000F\u001A\u0004\u0018\u00010\fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u0012H\u0002J?\u0010\u0014\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\b\u0010\u0015\u001A\u0004\u0018\u00010\f2\b\u0010\u0016\u001A\u0004\u0018\u00010\u00172\u0006\u0010\u0013\u001A\u00020\u00122\b\u0010\u000F\u001A\u0004\u0018\u00010\fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J?\u0010\u0019\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\b\u0010\u0015\u001A\u0004\u0018\u00010\f2\b\u0010\u0016\u001A\u0004\u0018\u00010\u00172\u0006\u0010\u0013\u001A\u00020\u00122\b\u0010\u000F\u001A\u0004\u0018\u00010\fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J!\u0010\u001A\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\u001B\u001A\u00020\u0017H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001CJ!\u0010\u001D\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\u001B\u001A\u00020\u0017H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001CJ!\u0010\u001E\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\u001B\u001A\u00020\u0017H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001CR\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lcom/onesignal/core/internal/http/impl/HttpClient;", "Lcom/onesignal/core/internal/http/IHttpClient;", "_connectionFactory", "Lcom/onesignal/core/internal/http/impl/IHttpConnectionFactory;", "_prefs", "Lcom/onesignal/core/internal/preferences/IPreferencesService;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "(Lcom/onesignal/core/internal/http/impl/IHttpConnectionFactory;Lcom/onesignal/core/internal/preferences/IPreferencesService;Lcom/onesignal/core/internal/config/ConfigModelStore;)V", "delete", "Lcom/onesignal/core/internal/http/HttpResponse;", "url", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "get", "cacheKey", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getThreadTimeout", "", "timeout", "makeRequest", "method", "jsonBody", "Lorg/json/JSONObject;", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "makeRequestIODispatcher", "patch", "body", "(Ljava/lang/String;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "post", "put", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class HttpClient implements IHttpClient {
    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/onesignal/core/internal/http/impl/HttpClient$Companion;", "", "()V", "OS_ACCEPT_HEADER", "", "OS_API_VERSION", "THREAD_ID", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final Companion Companion = null;
    private static final String OS_ACCEPT_HEADER = "application/vnd.onesignal.v1+json";
    private static final String OS_API_VERSION = "1";
    private static final int THREAD_ID = 10000;
    private final ConfigModelStore _configModelStore;
    private final IHttpConnectionFactory _connectionFactory;
    private final IPreferencesService _prefs;

    static {
        HttpClient.Companion = new Companion(null);
    }

    public HttpClient(IHttpConnectionFactory iHttpConnectionFactory0, IPreferencesService iPreferencesService0, ConfigModelStore configModelStore0) {
        Intrinsics.checkNotNullParameter(iHttpConnectionFactory0, "_connectionFactory");
        Intrinsics.checkNotNullParameter(iPreferencesService0, "_prefs");
        Intrinsics.checkNotNullParameter(configModelStore0, "_configModelStore");
        super();
        this._connectionFactory = iHttpConnectionFactory0;
        this._prefs = iPreferencesService0;
        this._configModelStore = configModelStore0;
    }

    @Override  // com.onesignal.core.internal.http.IHttpClient
    public Object delete(String s, Continuation continuation0) {
        return this.makeRequest(s, "DELETE", null, ((ConfigModel)this._configModelStore.getModel()).getHttpTimeout(), null, continuation0);
    }

    @Override  // com.onesignal.core.internal.http.IHttpClient
    public Object get(String s, String s1, Continuation continuation0) {
        return this.makeRequest(s, null, null, ((ConfigModel)this._configModelStore.getModel()).getHttpGetTimeout(), s1, continuation0);
    }

    private final int getThreadTimeout(int v) [...] // Inlined contents

    private final Object makeRequest(String s, String s1, JSONObject jSONObject0, int v, String s2, Continuation continuation0) {
        com.onesignal.core.internal.http.impl.HttpClient.makeRequest.1 httpClient$makeRequest$10;
        String s3 = s;
        if(continuation0 instanceof com.onesignal.core.internal.http.impl.HttpClient.makeRequest.1) {
            httpClient$makeRequest$10 = (com.onesignal.core.internal.http.impl.HttpClient.makeRequest.1)continuation0;
            if((httpClient$makeRequest$10.label & 0x80000000) == 0) {
                httpClient$makeRequest$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.makeRequest(null, null, null, 0, null, this);
                    }
                };
            }
            else {
                httpClient$makeRequest$10.label ^= 0x80000000;
            }
        }
        else {
            httpClient$makeRequest$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.makeRequest(null, null, null, 0, null, this);
                }
            };
        }
        Object object0 = httpClient$makeRequest$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(httpClient$makeRequest$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                if(s1 != null && Intrinsics.areEqual(((ConfigModel)this._configModelStore.getModel()).getConsentRequired(), Boxing.boxBoolean(true)) && !Intrinsics.areEqual(((ConfigModel)this._configModelStore.getModel()).getConsentGiven(), Boxing.boxBoolean(true))) {
                    Logging.warn$default((s1 + " `" + s3 + "` was called before the user provided privacy consent. Your application is set to require the user\'s privacy consent before the OneSignal SDK can be initialized. Please ensure the user has provided consent before calling this method. You can check the latest OneSignal consent status by calling OneSignal.privacyConsent"), null, 2, null);
                    return new HttpResponse(0, null, null);
                }
                try {
                    com.onesignal.core.internal.http.impl.HttpClient.makeRequest.2 httpClient$makeRequest$20 = new Function2(s, s1, jSONObject0, v, s2, null) {
                        final String $cacheKey;
                        final JSONObject $jsonBody;
                        final String $method;
                        final int $timeout;
                        final String $url;
                        int label;

                        {
                            HttpClient.this = httpClient0;
                            this.$url = s;
                            this.$method = s1;
                            this.$jsonBody = jSONObject0;
                            this.$timeout = v;
                            this.$cacheKey = s2;
                            super(2, continuation0);
                        }

                        @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.onesignal.core.internal.http.impl.HttpClient.makeRequest.2(HttpClient.this, this.$url, this.$method, this.$jsonBody, this.$timeout, this.$cacheKey, continuation0);
                        }

                        @Override  // kotlin.jvm.functions.Function2
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.onesignal.core.internal.http.impl.HttpClient.makeRequest.2)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object object0) {
                            Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch(this.label) {
                                case 0: {
                                    ResultKt.throwOnFailure(object0);
                                    this.label = 1;
                                    object0 = HttpClient.this.makeRequestIODispatcher(this.$url, this.$method, this.$jsonBody, this.$timeout, this.$cacheKey, this);
                                    return object0 == object1 ? object1 : object0;
                                }
                                case 1: {
                                    ResultKt.throwOnFailure(object0);
                                    return object0;
                                }
                                default: {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                            }
                        }
                    };
                    httpClient$makeRequest$10.L$0 = s3;
                    httpClient$makeRequest$10.label = 1;
                    object0 = TimeoutKt.withTimeout(v + 5000, httpClient$makeRequest$20, httpClient$makeRequest$10);
                    return object0 == object1 ? object1 : object0;
                }
                catch(TimeoutCancellationException timeoutCancellationException0) {
                }
                catch(Throwable throwable0) {
                    return new HttpResponse(0, null, throwable0);
                }
                Logging.error(("HttpClient: Request timed out: " + s3), timeoutCancellationException0);
                return new HttpResponse(0, null, timeoutCancellationException0);
            }
            case 1: {
                String s4 = (String)httpClient$makeRequest$10.L$0;
                try {
                    ResultKt.throwOnFailure(object0);
                    return object0;
                }
                catch(TimeoutCancellationException timeoutCancellationException0) {
                    s3 = s4;
                    Logging.error(("HttpClient: Request timed out: " + s3), timeoutCancellationException0);
                    return new HttpResponse(0, null, timeoutCancellationException0);
                }
                catch(Throwable throwable0) {
                    return new HttpResponse(0, null, throwable0);
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    private final Object makeRequestIODispatcher(String s, String s1, JSONObject jSONObject0, int v, String s2, Continuation continuation0) {
        ObjectRef ref$ObjectRef1;
        com.onesignal.core.internal.http.impl.HttpClient.makeRequestIODispatcher.1 httpClient$makeRequestIODispatcher$10;
        if(continuation0 instanceof com.onesignal.core.internal.http.impl.HttpClient.makeRequestIODispatcher.1) {
            httpClient$makeRequestIODispatcher$10 = (com.onesignal.core.internal.http.impl.HttpClient.makeRequestIODispatcher.1)continuation0;
            if((httpClient$makeRequestIODispatcher$10.label & 0x80000000) == 0) {
                httpClient$makeRequestIODispatcher$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.makeRequestIODispatcher(null, null, null, 0, null, this);
                    }
                };
            }
            else {
                httpClient$makeRequestIODispatcher$10.label ^= 0x80000000;
            }
        }
        else {
            httpClient$makeRequestIODispatcher$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.makeRequestIODispatcher(null, null, null, 0, null, this);
                }
            };
        }
        Object object0 = httpClient$makeRequestIODispatcher$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(httpClient$makeRequestIODispatcher$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                ObjectRef ref$ObjectRef0 = new ObjectRef();
                com.onesignal.core.internal.http.impl.HttpClient.makeRequestIODispatcher.job.1 httpClient$makeRequestIODispatcher$job$10 = new Function2(s, v, jSONObject0, s1, s2, ref$ObjectRef0, null) {
                    final String $cacheKey;
                    final JSONObject $jsonBody;
                    final String $method;
                    final ObjectRef $retVal;
                    final int $timeout;
                    final String $url;
                    int label;

                    {
                        HttpClient.this = httpClient0;
                        this.$url = s;
                        this.$timeout = v;
                        this.$jsonBody = jSONObject0;
                        this.$method = s1;
                        this.$cacheKey = s2;
                        this.$retVal = ref$ObjectRef0;
                        super(2, continuation0);
                    }

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.onesignal.core.internal.http.impl.HttpClient.makeRequestIODispatcher.job.1(HttpClient.this, this.$url, this.$timeout, this.$jsonBody, this.$method, this.$cacheKey, this.$retVal, continuation0);
                    }

                    @Override  // kotlin.jvm.functions.Function2
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.onesignal.core.internal.http.impl.HttpClient.makeRequestIODispatcher.job.1)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        String s6;
                        String s4;
                        String s1;
                        int v;
                        HttpURLConnection httpURLConnection0;
                        if(this.label != 0) {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                        ResultKt.throwOnFailure(object0);
                        if(Build.VERSION.SDK_INT >= 26) {
                            TrafficStats.setThreadStatsTag(10000);
                        }
                        try {
                            httpURLConnection0 = HttpClient.this._connectionFactory.newHttpURLConnection(this.$url);
                        }
                        catch(Throwable throwable0) {
                            v = -1;
                            httpURLConnection0 = null;
                            goto label_114;
                        }
                        try {
                            httpURLConnection0.setUseCaches(false);
                            httpURLConnection0.setConnectTimeout(this.$timeout);
                            httpURLConnection0.setReadTimeout(this.$timeout);
                            httpURLConnection0.setRequestProperty("SDK-Version", "onesignal/android/050109");
                            if(OneSignalWrapper.getSdkType() != null && OneSignalWrapper.getSdkVersion() != null) {
                                httpURLConnection0.setRequestProperty("SDK-Wrapper", "onesignal/" + OneSignalWrapper.getSdkType() + '/' + OneSignalWrapper.getSdkVersion());
                            }
                            httpURLConnection0.setRequestProperty("Accept", "application/vnd.onesignal.v1+json");
                            String s = ((ConfigModel)HttpClient.this._configModelStore.getModel()).getPushSubscriptionId();
                            if(s != null && s.length() > 0) {
                                httpURLConnection0.setRequestProperty("OneSignal-Subscription-Id", s);
                            }
                            if(this.$jsonBody != null) {
                                httpURLConnection0.setDoInput(true);
                            }
                            if(this.$method != null) {
                                httpURLConnection0.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                                httpURLConnection0.setRequestMethod(this.$method);
                                httpURLConnection0.setDoOutput(true);
                            }
                            s1 = "GET";
                            if(this.$jsonBody == null) {
                                Logging.debug$default(("HttpClient: " + (this.$method == null ? "GET" : this.$method) + ' ' + this.$url), null, 2, null);
                            }
                            else {
                                String s2 = JSONUtils.INSTANCE.toUnescapedEUIDString(this.$jsonBody);
                                Logging.debug$default(("HttpClient: " + (this.$method == null ? "GET" : this.$method) + ' ' + this.$url + " - " + s2), null, 2, null);
                                Charset charset0 = Charset.forName("UTF-8");
                                Intrinsics.checkNotNullExpressionValue(charset0, "forName(charsetName)");
                                byte[] arr_b = s2.getBytes(charset0);
                                Intrinsics.checkNotNullExpressionValue(arr_b, "this as java.lang.String).getBytes(charset)");
                                httpURLConnection0.setFixedLengthStreamingMode(arr_b.length);
                                httpURLConnection0.getOutputStream().write(arr_b);
                            }
                            if(this.$cacheKey != null) {
                                String s3 = DefaultImpls.getString$default(HttpClient.this._prefs, "OneSignal", "PREFS_OS_ETAG_PREFIX_" + this.$cacheKey, null, 4, null);
                                if(s3 != null) {
                                    httpURLConnection0.setRequestProperty("if-none-match", s3);
                                    Logging.debug$default(("HttpClient: Adding header if-none-match: " + s3), null, 2, null);
                                }
                            }
                            s4 = "";
                            v = httpURLConnection0.getResponseCode();
                        }
                        catch(Throwable throwable0) {
                            v = -1;
                            goto label_114;
                        }
                        if(v == 304) {
                            goto label_100;
                            try {
                            label_114:
                                if(throwable0 instanceof ConnectException || throwable0 instanceof UnknownHostException) {
                                    Logging.info$default(("HttpClient: Could not send last request, device is offline. Throwable: " + throwable0.getClass().getName()), null, 2, null);
                                }
                                else {
                                    Logging.warn(("HttpClient: " + this.$method + " Error thrown from network stack. "), throwable0);
                                }
                                this.$retVal.element = new HttpResponse(v, null, throwable0);
                            }
                            catch(Throwable throwable1) {
                                if(httpURLConnection0 != null) {
                                    httpURLConnection0.disconnect();
                                }
                                throw throwable1;
                            }
                            if(httpURLConnection0 == null) {
                                return Unit.INSTANCE;
                            }
                        }
                        else {
                            try {
                                if(v == 200 || v == 201 || v == 202) {
                                    Scanner scanner1 = new Scanner(httpURLConnection0.getInputStream(), "UTF-8");
                                    if(scanner1.useDelimiter("\\A").hasNext()) {
                                        s4 = scanner1.next();
                                    }
                                    scanner1.close();
                                    StringBuilder stringBuilder1 = new StringBuilder("HttpClient: ");
                                    String s7 = this.$method;
                                    if(s7 != null) {
                                        s1 = s7;
                                    }
                                    stringBuilder1.append(s1);
                                    stringBuilder1.append(' ');
                                    stringBuilder1.append(this.$url);
                                    stringBuilder1.append(" - STATUS: ");
                                    stringBuilder1.append(v);
                                    stringBuilder1.append(" JSON: ");
                                    stringBuilder1.append(s4);
                                    Logging.debug$default(stringBuilder1.toString(), null, 2, null);
                                    if(this.$cacheKey != null) {
                                        String s8 = httpURLConnection0.getHeaderField("etag");
                                        if(s8 != null) {
                                            Logging.debug$default(("HttpClient: Response has etag of " + s8 + " so caching the response."), null, 2, null);
                                            HttpClient.this._prefs.saveString("OneSignal", "PREFS_OS_ETAG_PREFIX_" + this.$cacheKey, s8);
                                            HttpClient.this._prefs.saveString("OneSignal", "PREFS_OS_HTTP_CACHE_PREFIX_" + this.$cacheKey, s4);
                                        }
                                    }
                                    this.$retVal.element = new HttpResponse(v, s4, null, 4, null);
                                    goto label_126;
                                label_100:
                                    String s9 = DefaultImpls.getString$default(HttpClient.this._prefs, "OneSignal", "PREFS_OS_HTTP_CACHE_PREFIX_" + this.$cacheKey, null, 4, null);
                                    StringBuilder stringBuilder2 = new StringBuilder("HttpClient: ");
                                    String s10 = this.$method;
                                    if(s10 != null) {
                                        s1 = s10;
                                    }
                                    stringBuilder2.append(s1);
                                    stringBuilder2.append(' ');
                                    stringBuilder2.append(this.$url);
                                    stringBuilder2.append(" - Using Cached response due to 304: ");
                                    stringBuilder2.append(s9);
                                    Logging.debug$default(stringBuilder2.toString(), null, 2, null);
                                    this.$retVal.element = new HttpResponse(304, s9, null, 4, null);
                                }
                                else {
                                    StringBuilder stringBuilder0 = new StringBuilder("HttpClient: ");
                                    String s5 = this.$method;
                                    if(s5 != null) {
                                        s1 = s5;
                                    }
                                    stringBuilder0.append(s1);
                                    stringBuilder0.append(' ');
                                    stringBuilder0.append(this.$url);
                                    stringBuilder0.append(" - FAILED STATUS: ");
                                    stringBuilder0.append(v);
                                    Logging.debug$default(stringBuilder0.toString(), null, 2, null);
                                    InputStream inputStream0 = httpURLConnection0.getErrorStream();
                                    if(inputStream0 == null) {
                                        inputStream0 = httpURLConnection0.getInputStream();
                                    }
                                    if(inputStream0 == null) {
                                        Logging.warn$default(("HttpClient: " + this.$method + " HTTP Code: " + v + " No response body!"), null, 2, null);
                                        s6 = null;
                                    }
                                    else {
                                        Scanner scanner0 = new Scanner(inputStream0, "UTF-8");
                                        if(scanner0.useDelimiter("\\A").hasNext()) {
                                            s4 = scanner0.next();
                                        }
                                        scanner0.close();
                                        Logging.warn$default(("HttpClient: " + this.$method + " RECEIVED JSON: " + s4), null, 2, null);
                                        s6 = s4;
                                    }
                                    this.$retVal.element = new HttpResponse(v, s6, null, 4, null);
                                }
                            }
                            catch(Throwable throwable0) {
                                goto label_114;
                            }
                        }
                    label_126:
                        httpURLConnection0.disconnect();
                        return Unit.INSTANCE;
                    }
                };
                Job job0 = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, httpClient$makeRequestIODispatcher$job$10, 2, null);
                httpClient$makeRequestIODispatcher$10.L$0 = ref$ObjectRef0;
                httpClient$makeRequestIODispatcher$10.label = 1;
                if(job0.join(httpClient$makeRequestIODispatcher$10) == object1) {
                    return object1;
                }
                ref$ObjectRef1 = ref$ObjectRef0;
                break;
            }
            case 1: {
                ref$ObjectRef1 = (ObjectRef)httpClient$makeRequestIODispatcher$10.L$0;
                ResultKt.throwOnFailure(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        Object object2 = ref$ObjectRef1.element;
        Intrinsics.checkNotNull(object2);
        return object2;
    }

    @Override  // com.onesignal.core.internal.http.IHttpClient
    public Object patch(String s, JSONObject jSONObject0, Continuation continuation0) {
        return this.makeRequest(s, "PATCH", jSONObject0, ((ConfigModel)this._configModelStore.getModel()).getHttpTimeout(), null, continuation0);
    }

    @Override  // com.onesignal.core.internal.http.IHttpClient
    public Object post(String s, JSONObject jSONObject0, Continuation continuation0) {
        return this.makeRequest(s, "POST", jSONObject0, ((ConfigModel)this._configModelStore.getModel()).getHttpTimeout(), null, continuation0);
    }

    @Override  // com.onesignal.core.internal.http.IHttpClient
    public Object put(String s, JSONObject jSONObject0, Continuation continuation0) {
        return this.makeRequest(s, "PUT", jSONObject0, ((ConfigModel)this._configModelStore.getModel()).getHttpTimeout(), null, continuation0);
    }
}

