package com.onesignal.notifications.internal.registration.impl;

import android.util.Base64;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions.Builder;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.config.FCMConfigModel;
import com.onesignal.core.internal.device.IDeviceService;
import com.onesignal.debug.internal.logging.Logging;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutionException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \"2\u00020\u0001:\u0001\"B%\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0002\u0010\nJ\u0019\u0010\u001A\u001A\u00020\u00122\u0006\u0010\u001B\u001A\u00020\u0012H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001CJ\u0019\u0010\u001D\u001A\u00020\u00122\u0006\u0010\u001B\u001A\u00020\u0012H\u0083@ø\u0001\u0000¢\u0006\u0002\u0010\u001CJ\u0011\u0010\u001E\u001A\u00020\u0012H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001FJ\u0010\u0010 \u001A\u00020!2\u0006\u0010\u001B\u001A\u00020\u0012H\u0002R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R\u000E\u0010\u0011\u001A\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001A\u0004\u0018\u00010\u0015X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001A\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, d2 = {"Lcom/onesignal/notifications/internal/registration/impl/PushRegistratorFCM;", "Lcom/onesignal/notifications/internal/registration/impl/PushRegistratorAbstractGoogle;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "upgradePrompt", "Lcom/onesignal/notifications/internal/registration/impl/GooglePlayServicesUpgradePrompt;", "deviceService", "Lcom/onesignal/core/internal/device/IDeviceService;", "(Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/notifications/internal/registration/impl/GooglePlayServicesUpgradePrompt;Lcom/onesignal/core/internal/device/IDeviceService;)V", "get_applicationService", "()Lcom/onesignal/core/internal/application/IApplicationService;", "get_configModelStore", "()Lcom/onesignal/core/internal/config/ConfigModelStore;", "set_configModelStore", "(Lcom/onesignal/core/internal/config/ConfigModelStore;)V", "apiKey", "", "appId", "firebaseApp", "Lcom/google/firebase/FirebaseApp;", "projectId", "providerName", "getProviderName", "()Ljava/lang/String;", "getToken", "senderId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTokenWithClassFirebaseInstanceId", "getTokenWithClassFirebaseMessaging", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initFirebaseApp", "", "Companion", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class PushRegistratorFCM extends PushRegistratorAbstractGoogle {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/onesignal/notifications/internal/registration/impl/PushRegistratorFCM$Companion;", "", "()V", "FCM_APP_NAME", "", "FCM_DEFAULT_API_KEY_BASE64", "FCM_DEFAULT_APP_ID", "FCM_DEFAULT_PROJECT_ID", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final Companion Companion = null;
    private static final String FCM_APP_NAME = "ONESIGNAL_SDK_FCM_APP_NAME";
    private static final String FCM_DEFAULT_API_KEY_BASE64 = "QUl6YVN5QW5UTG41LV80TWMyYTJQLWRLVWVFLWFCdGd5Q3JqbFlV";
    private static final String FCM_DEFAULT_APP_ID = "1:754795614042:android:c682b8144a8dd52bc1ad63";
    private static final String FCM_DEFAULT_PROJECT_ID = "onesignal-shared-public";
    private final IApplicationService _applicationService;
    private ConfigModelStore _configModelStore;
    private final String apiKey;
    private final String appId;
    private FirebaseApp firebaseApp;
    private final String projectId;

    static {
        PushRegistratorFCM.Companion = new Companion(null);
    }

    public PushRegistratorFCM(ConfigModelStore configModelStore0, IApplicationService iApplicationService0, GooglePlayServicesUpgradePrompt googlePlayServicesUpgradePrompt0, IDeviceService iDeviceService0) {
        Intrinsics.checkNotNullParameter(configModelStore0, "_configModelStore");
        Intrinsics.checkNotNullParameter(iApplicationService0, "_applicationService");
        Intrinsics.checkNotNullParameter(googlePlayServicesUpgradePrompt0, "upgradePrompt");
        Intrinsics.checkNotNullParameter(iDeviceService0, "deviceService");
        super(iDeviceService0, configModelStore0, googlePlayServicesUpgradePrompt0);
        this._configModelStore = configModelStore0;
        this._applicationService = iApplicationService0;
        FCMConfigModel fCMConfigModel0 = ((ConfigModel)configModelStore0.getModel()).getFcmParams();
        String s = fCMConfigModel0.getProjectId();
        if(s == null) {
            s = "onesignal-shared-public";
        }
        this.projectId = s;
        String s1 = fCMConfigModel0.getAppId();
        if(s1 == null) {
            s1 = "1:754795614042:android:c682b8144a8dd52bc1ad63";
        }
        this.appId = s1;
        byte[] arr_b = Base64.decode("QUl6YVN5QW5UTG41LV80TWMyYTJQLWRLVWVFLWFCdGd5Q3JqbFlV", 0);
        Intrinsics.checkNotNullExpressionValue(arr_b, "decode(FCM_DEFAULT_API_KEY_BASE64, Base64.DEFAULT)");
        String s2 = new String(arr_b, Charsets.UTF_8);
        String s3 = fCMConfigModel0.getApiKey();
        if(s3 != null) {
            s2 = s3;
        }
        this.apiKey = s2;
    }

    public static final Object access$getTokenWithClassFirebaseInstanceId(PushRegistratorFCM pushRegistratorFCM0, String s, Continuation continuation0) {
        return pushRegistratorFCM0.getTokenWithClassFirebaseInstanceId(s, continuation0);
    }

    public static final Object access$getTokenWithClassFirebaseMessaging(PushRegistratorFCM pushRegistratorFCM0, Continuation continuation0) {
        return pushRegistratorFCM0.getTokenWithClassFirebaseMessaging(continuation0);
    }

    @Override  // com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle
    public String getProviderName() {
        return "FCM";
    }

    @Override  // com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle
    public Object getToken(String s, Continuation continuation0) throws ExecutionException, InterruptedException, IOException {
        PushRegistratorFCM pushRegistratorFCM0;
        com.onesignal.notifications.internal.registration.impl.PushRegistratorFCM.getToken.1 pushRegistratorFCM$getToken$10;
        if(continuation0 instanceof com.onesignal.notifications.internal.registration.impl.PushRegistratorFCM.getToken.1) {
            pushRegistratorFCM$getToken$10 = (com.onesignal.notifications.internal.registration.impl.PushRegistratorFCM.getToken.1)continuation0;
            if((pushRegistratorFCM$getToken$10.label & 0x80000000) == 0) {
                pushRegistratorFCM$getToken$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.getToken(null, this);
                    }
                };
            }
            else {
                pushRegistratorFCM$getToken$10.label ^= 0x80000000;
            }
        }
        else {
            pushRegistratorFCM$getToken$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.getToken(null, this);
                }
            };
        }
        Object object0 = pushRegistratorFCM$getToken$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(pushRegistratorFCM$getToken$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                this.initFirebaseApp(s);
                try {
                    pushRegistratorFCM$getToken$10.L$0 = this;
                    pushRegistratorFCM$getToken$10.L$1 = s;
                    pushRegistratorFCM$getToken$10.label = 1;
                    object0 = this.getTokenWithClassFirebaseMessaging(pushRegistratorFCM$getToken$10);
                    return object0 == object1 ? object1 : object0;
                }
                catch(NoClassDefFoundError unused_ex) {
                    pushRegistratorFCM0 = this;
                    Logging.info$default("FirebaseMessaging.getToken not found, attempting to use FirebaseInstanceId.getToken", null, 2, null);
                    goto label_30;
                }
                catch(NoSuchMethodError unused_ex) {
                    pushRegistratorFCM0 = this;
                    goto label_29;
                }
            }
            case 1: {
                s = (String)pushRegistratorFCM$getToken$10.L$1;
                pushRegistratorFCM0 = (PushRegistratorFCM)pushRegistratorFCM$getToken$10.L$0;
                try {
                    ResultKt.throwOnFailure(object0);
                    return object0;
                }
                catch(NoClassDefFoundError unused_ex) {
                    Logging.info$default("FirebaseMessaging.getToken not found, attempting to use FirebaseInstanceId.getToken", null, 2, null);
                    goto label_30;
                }
                catch(NoSuchMethodError unused_ex) {
                }
            label_29:
                Logging.info$default("FirebaseMessaging.getToken not found, attempting to use FirebaseInstanceId.getToken", null, 2, null);
            label_30:
                pushRegistratorFCM$getToken$10.L$0 = null;
                pushRegistratorFCM$getToken$10.L$1 = null;
                pushRegistratorFCM$getToken$10.label = 2;
                object0 = pushRegistratorFCM0.getTokenWithClassFirebaseInstanceId(s, pushRegistratorFCM$getToken$10);
                return object0 == object1 ? object1 : object0;
            }
            case 2: {
                ResultKt.throwOnFailure(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    @Deprecated(message = "")
    private final Object getTokenWithClassFirebaseInstanceId(String s, Continuation continuation0) throws IOException {
        return CoroutineScopeKt.coroutineScope(new Function2(s, null) {
            final String $senderId;
            private Object L$0;
            int label;

            {
                PushRegistratorFCM.this = pushRegistratorFCM0;
                this.$senderId = s;
                super(2, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object object0, Continuation continuation0) {
                com.onesignal.notifications.internal.registration.impl.PushRegistratorFCM.getTokenWithClassFirebaseInstanceId.2 pushRegistratorFCM$getTokenWithClassFirebaseInstanceId$20 = new com.onesignal.notifications.internal.registration.impl.PushRegistratorFCM.getTokenWithClassFirebaseInstanceId.2(PushRegistratorFCM.this, this.$senderId, continuation0);
                pushRegistratorFCM$getTokenWithClassFirebaseInstanceId$20.L$0 = object0;
                return pushRegistratorFCM$getTokenWithClassFirebaseInstanceId$20;
            }

            @Override  // kotlin.jvm.functions.Function2
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.onesignal.notifications.internal.registration.impl.PushRegistratorFCM.getTokenWithClassFirebaseInstanceId.2)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                Exception exception0;
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                ResultKt.throwOnFailure(object0);
                CoroutineScope coroutineScope0 = (CoroutineScope)this.L$0;
                ObjectRef ref$ObjectRef0 = new ObjectRef();
                ref$ObjectRef0.element = "";
                try {
                    Object object1 = Class.forName("com.google.firebase.iid.FirebaseInstanceId").getMethod("getInstance", FirebaseApp.class).invoke(null, PushRegistratorFCM.this.firebaseApp);
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope0, Dispatchers.getDefault(), null, new Function2(object1, this.$senderId, ref$ObjectRef0, null) {
                        final Method $getTokenMethod;
                        final Object $instanceId;
                        final String $senderId;
                        final ObjectRef $token;
                        int label;

                        {
                            this.$getTokenMethod = method0;
                            this.$instanceId = object0;
                            this.$senderId = s;
                            this.$token = ref$ObjectRef0;
                            super(2, continuation0);
                        }

                        @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.onesignal.notifications.internal.registration.impl.PushRegistratorFCM.getTokenWithClassFirebaseInstanceId.2.exception.1(this.$getTokenMethod, this.$instanceId, this.$senderId, this.$token, continuation0);
                        }

                        @Override  // kotlin.jvm.functions.Function2
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.onesignal.notifications.internal.registration.impl.PushRegistratorFCM.getTokenWithClassFirebaseInstanceId.2.exception.1)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object object0) {
                            if(this.label != 0) {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                            ResultKt.throwOnFailure(object0);
                            Object object1 = this.$getTokenMethod.invoke(this.$instanceId, this.$senderId, "FCM");
                            Intrinsics.checkNotNull(object1, "null cannot be cast to non-null type kotlin.String");
                            this.$token.element = (String)object1;
                            return Unit.INSTANCE;
                        }
                    }, 2, null);
                    return ref$ObjectRef0.element;
                }
                catch(ClassNotFoundException classNotFoundException0) {
                    exception0 = classNotFoundException0;
                }
                catch(NoSuchMethodException noSuchMethodException0) {
                    exception0 = noSuchMethodException0;
                }
                catch(IllegalAccessException illegalAccessException0) {
                    exception0 = illegalAccessException0;
                }
                catch(InvocationTargetException invocationTargetException0) {
                    exception0 = invocationTargetException0;
                }
                throw new Error("Reflection error on FirebaseInstanceId.getInstance(firebaseApp).getToken(senderId, FirebaseMessaging.INSTANCE_ID_SCOPE)", exception0);
            }
        }, continuation0);
    }

    private final Object getTokenWithClassFirebaseMessaging(Continuation continuation0) throws ExecutionException, InterruptedException {
        return CoroutineScopeKt.coroutineScope(new Function2(null) {
            Object L$0;
            int label;

            {
                PushRegistratorFCM.this = pushRegistratorFCM0;
                super(2, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.onesignal.notifications.internal.registration.impl.PushRegistratorFCM.getTokenWithClassFirebaseMessaging.2(PushRegistratorFCM.this, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function2
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.onesignal.notifications.internal.registration.impl.PushRegistratorFCM.getTokenWithClassFirebaseMessaging.2)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        ObjectRef ref$ObjectRef0 = new ObjectRef();
                        ref$ObjectRef0.element = "";
                        com.onesignal.notifications.internal.registration.impl.PushRegistratorFCM.getTokenWithClassFirebaseMessaging.2.1 pushRegistratorFCM$getTokenWithClassFirebaseMessaging$2$10 = new Function2(ref$ObjectRef0, null) {
                            final ObjectRef $token;
                            int label;

                            {
                                PushRegistratorFCM.this = pushRegistratorFCM0;
                                this.$token = ref$ObjectRef0;
                                super(2, continuation0);
                            }

                            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.onesignal.notifications.internal.registration.impl.PushRegistratorFCM.getTokenWithClassFirebaseMessaging.2.1(PushRegistratorFCM.this, this.$token, continuation0);
                            }

                            @Override  // kotlin.jvm.functions.Function2
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.onesignal.notifications.internal.registration.impl.PushRegistratorFCM.getTokenWithClassFirebaseMessaging.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object object0) {
                                if(this.label == 0) {
                                    ResultKt.throwOnFailure(object0);
                                    FirebaseApp firebaseApp0 = PushRegistratorFCM.this.firebaseApp;
                                    Intrinsics.checkNotNull(firebaseApp0);
                                    Task task0 = ((FirebaseMessaging)firebaseApp0.get(FirebaseMessaging.class)).getToken();
                                    Intrinsics.checkNotNullExpressionValue(task0, "fcmInstance.token");
                                    try {
                                        Object object1 = Tasks.await(task0);
                                        Intrinsics.checkNotNullExpressionValue(object1, "await(tokenTask)");
                                        this.$token.element = object1;
                                        return Unit.INSTANCE;
                                    }
                                    catch(ExecutionException executionException0) {
                                        Exception exception0 = task0.getException();
                                        Throwable throwable0 = exception0 == null ? executionException0 : exception0;
                                        throw throwable0;
                                    }
                                }
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        };
                        this.L$0 = ref$ObjectRef0;
                        this.label = 1;
                        return BuildersKt.withContext(Dispatchers.getDefault(), pushRegistratorFCM$getTokenWithClassFirebaseMessaging$2$10, this) == object1 ? object1 : ref$ObjectRef0.element;
                    }
                    case 1: {
                        ObjectRef ref$ObjectRef1 = (ObjectRef)this.L$0;
                        ResultKt.throwOnFailure(object0);
                        return ref$ObjectRef1.element;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, continuation0);
    }

    public final IApplicationService get_applicationService() {
        return this._applicationService;
    }

    public final ConfigModelStore get_configModelStore() {
        return this._configModelStore;
    }

    private final void initFirebaseApp(String s) {
        if(this.firebaseApp != null) {
            return;
        }
        FirebaseOptions firebaseOptions0 = new Builder().setGcmSenderId(s).setApplicationId(this.appId).setApiKey(this.apiKey).setProjectId(this.projectId).build();
        Intrinsics.checkNotNullExpressionValue(firebaseOptions0, "Builder()\n              …\n                .build()");
        this.firebaseApp = FirebaseApp.initializeApp(this._applicationService.getAppContext(), firebaseOptions0, "ONESIGNAL_SDK_FCM_APP_NAME");
    }

    public final void set_configModelStore(ConfigModelStore configModelStore0) {
        Intrinsics.checkNotNullParameter(configModelStore0, "<set-?>");
        this._configModelStore = configModelStore0;
    }
}

