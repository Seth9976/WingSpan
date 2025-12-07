package com.onesignal.inAppMessages.internal.display.impl;

import android.app.Activity;
import android.util.Base64;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.language.ILanguageContext;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.inAppMessages.internal.InAppMessage;
import com.onesignal.inAppMessages.internal.InAppMessageContent;
import com.onesignal.inAppMessages.internal.backend.GetIAMDataResponse;
import com.onesignal.inAppMessages.internal.backend.IInAppBackendService;
import com.onesignal.inAppMessages.internal.common.InAppHelper;
import com.onesignal.inAppMessages.internal.display.IInAppDisplayer;
import com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleService;
import com.onesignal.inAppMessages.internal.prompt.IInAppMessagePromptFactory;
import com.onesignal.session.internal.influence.IInfluenceManager;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 (2\u00020\u0001:\u0001(BE\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\f\u001A\u00020\r\u0012\u0006\u0010\u000E\u001A\u00020\u000F\u0012\u0006\u0010\u0010\u001A\u00020\u0011¢\u0006\u0002\u0010\u0012J\b\u0010\u0015\u001A\u00020\u0016H\u0016J\u001B\u0010\u0017\u001A\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001A\u00020\u001AH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001BJ\u0019\u0010\u001C\u001A\u00020\u00182\u0006\u0010\u001D\u001A\u00020\u001EH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001FJ)\u0010 \u001A\u00020\u00162\u0006\u0010!\u001A\u00020\"2\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010#\u001A\u00020$H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010%J!\u0010&\u001A\u00020\u00162\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010#\u001A\u00020$H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\'R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001A\u0004\u0018\u00010\u0014X\u0082\u000E¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Lcom/onesignal/inAppMessages/internal/display/impl/InAppDisplayer;", "Lcom/onesignal/inAppMessages/internal/display/IInAppDisplayer;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_lifecycle", "Lcom/onesignal/inAppMessages/internal/lifecycle/IInAppLifecycleService;", "_promptFactory", "Lcom/onesignal/inAppMessages/internal/prompt/IInAppMessagePromptFactory;", "_backend", "Lcom/onesignal/inAppMessages/internal/backend/IInAppBackendService;", "_influenceManager", "Lcom/onesignal/session/internal/influence/IInfluenceManager;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_languageContext", "Lcom/onesignal/core/internal/language/ILanguageContext;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/inAppMessages/internal/lifecycle/IInAppLifecycleService;Lcom/onesignal/inAppMessages/internal/prompt/IInAppMessagePromptFactory;Lcom/onesignal/inAppMessages/internal/backend/IInAppBackendService;Lcom/onesignal/session/internal/influence/IInfluenceManager;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/core/internal/language/ILanguageContext;Lcom/onesignal/core/internal/time/ITime;)V", "lastInstance", "Lcom/onesignal/inAppMessages/internal/display/impl/WebViewManager;", "dismissCurrentInAppMessage", "", "displayMessage", "", "message", "Lcom/onesignal/inAppMessages/internal/InAppMessage;", "(Lcom/onesignal/inAppMessages/internal/InAppMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "displayPreviewMessage", "previewUUID", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initInAppMessage", "currentActivity", "Landroid/app/Activity;", "content", "Lcom/onesignal/inAppMessages/internal/InAppMessageContent;", "(Landroid/app/Activity;Lcom/onesignal/inAppMessages/internal/InAppMessage;Lcom/onesignal/inAppMessages/internal/InAppMessageContent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showMessageContent", "(Lcom/onesignal/inAppMessages/internal/InAppMessage;Lcom/onesignal/inAppMessages/internal/InAppMessageContent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class InAppDisplayer implements IInAppDisplayer {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/onesignal/inAppMessages/internal/display/impl/InAppDisplayer$Companion;", "", "()V", "IN_APP_MESSAGE_INIT_DELAY", "", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final Companion Companion = null;
    private static final int IN_APP_MESSAGE_INIT_DELAY = 200;
    private final IApplicationService _applicationService;
    private final IInAppBackendService _backend;
    private final ConfigModelStore _configModelStore;
    private final IInfluenceManager _influenceManager;
    private final ILanguageContext _languageContext;
    private final IInAppLifecycleService _lifecycle;
    private final IInAppMessagePromptFactory _promptFactory;
    private final ITime _time;
    private WebViewManager lastInstance;

    static {
        InAppDisplayer.Companion = new Companion(null);
    }

    public InAppDisplayer(IApplicationService iApplicationService0, IInAppLifecycleService iInAppLifecycleService0, IInAppMessagePromptFactory iInAppMessagePromptFactory0, IInAppBackendService iInAppBackendService0, IInfluenceManager iInfluenceManager0, ConfigModelStore configModelStore0, ILanguageContext iLanguageContext0, ITime iTime0) {
        Intrinsics.checkNotNullParameter(iApplicationService0, "_applicationService");
        Intrinsics.checkNotNullParameter(iInAppLifecycleService0, "_lifecycle");
        Intrinsics.checkNotNullParameter(iInAppMessagePromptFactory0, "_promptFactory");
        Intrinsics.checkNotNullParameter(iInAppBackendService0, "_backend");
        Intrinsics.checkNotNullParameter(iInfluenceManager0, "_influenceManager");
        Intrinsics.checkNotNullParameter(configModelStore0, "_configModelStore");
        Intrinsics.checkNotNullParameter(iLanguageContext0, "_languageContext");
        Intrinsics.checkNotNullParameter(iTime0, "_time");
        super();
        this._applicationService = iApplicationService0;
        this._lifecycle = iInAppLifecycleService0;
        this._promptFactory = iInAppMessagePromptFactory0;
        this._backend = iInAppBackendService0;
        this._influenceManager = iInfluenceManager0;
        this._configModelStore = configModelStore0;
        this._languageContext = iLanguageContext0;
        this._time = iTime0;
    }

    @Override  // com.onesignal.inAppMessages.internal.display.IInAppDisplayer
    public void dismissCurrentInAppMessage() {
        Logging.debug$default(("WebViewManager IAM dismissAndAwaitNextMessage lastInstance: " + this.lastInstance), null, 2, null);
        WebViewManager webViewManager0 = this.lastInstance;
        if(webViewManager0 != null) {
            Intrinsics.checkNotNull(webViewManager0);
            webViewManager0.backgroundDismissAndAwaitNextMessage();
        }
    }

    @Override  // com.onesignal.inAppMessages.internal.display.IInAppDisplayer
    public Object displayMessage(InAppMessage inAppMessage0, Continuation continuation0) {
        InAppDisplayer inAppDisplayer0;
        com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer.displayMessage.1 inAppDisplayer$displayMessage$10;
        if(continuation0 instanceof com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer.displayMessage.1) {
            inAppDisplayer$displayMessage$10 = (com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer.displayMessage.1)continuation0;
            if((inAppDisplayer$displayMessage$10.label & 0x80000000) == 0) {
                inAppDisplayer$displayMessage$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.displayMessage(null, this);
                    }
                };
            }
            else {
                inAppDisplayer$displayMessage$10.label ^= 0x80000000;
            }
        }
        else {
            inAppDisplayer$displayMessage$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.displayMessage(null, this);
                }
            };
        }
        Object object0 = inAppDisplayer$displayMessage$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(inAppDisplayer$displayMessage$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                String s = ((ConfigModel)this._configModelStore.getModel()).getAppId();
                String s1 = InAppHelper.INSTANCE.variantIdForMessage(inAppMessage0, this._languageContext);
                inAppDisplayer$displayMessage$10.L$0 = this;
                inAppDisplayer$displayMessage$10.L$1 = inAppMessage0;
                inAppDisplayer$displayMessage$10.label = 1;
                object0 = this._backend.getIAMData(s, inAppMessage0.getMessageId(), s1, inAppDisplayer$displayMessage$10);
                if(object0 == object1) {
                    return object1;
                }
                inAppDisplayer0 = this;
                break;
            }
            case 1: {
                inAppMessage0 = (InAppMessage)inAppDisplayer$displayMessage$10.L$1;
                inAppDisplayer0 = (InAppDisplayer)inAppDisplayer$displayMessage$10.L$0;
                ResultKt.throwOnFailure(object0);
                break;
            }
            case 2: {
                ResultKt.throwOnFailure(object0);
                return Boxing.boxBoolean(true);
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(((GetIAMDataResponse)object0).getContent() != null) {
            InAppMessageContent inAppMessageContent0 = ((GetIAMDataResponse)object0).getContent();
            Intrinsics.checkNotNull(inAppMessageContent0);
            Double double0 = inAppMessageContent0.getDisplayDuration();
            Intrinsics.checkNotNull(double0);
            inAppMessage0.setDisplayDuration(((double)double0));
            inAppDisplayer0._influenceManager.onInAppMessageDisplayed(inAppMessage0.getMessageId());
            InAppMessageContent inAppMessageContent1 = ((GetIAMDataResponse)object0).getContent();
            Intrinsics.checkNotNull(inAppMessageContent1);
            inAppDisplayer$displayMessage$10.L$0 = null;
            inAppDisplayer$displayMessage$10.L$1 = null;
            inAppDisplayer$displayMessage$10.label = 2;
            return inAppDisplayer0.showMessageContent(inAppMessage0, inAppMessageContent1, inAppDisplayer$displayMessage$10) == object1 ? object1 : Boxing.boxBoolean(true);
        }
        return ((GetIAMDataResponse)object0).getShouldRetry() ? null : Boxing.boxBoolean(false);
    }

    @Override  // com.onesignal.inAppMessages.internal.display.IInAppDisplayer
    public Object displayPreviewMessage(String s, Continuation continuation0) {
        InAppMessage inAppMessage1;
        InAppDisplayer inAppDisplayer0;
        com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer.displayPreviewMessage.1 inAppDisplayer$displayPreviewMessage$10;
        if(continuation0 instanceof com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer.displayPreviewMessage.1) {
            inAppDisplayer$displayPreviewMessage$10 = (com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer.displayPreviewMessage.1)continuation0;
            if((inAppDisplayer$displayPreviewMessage$10.label & 0x80000000) == 0) {
                inAppDisplayer$displayPreviewMessage$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.displayPreviewMessage(null, this);
                    }
                };
            }
            else {
                inAppDisplayer$displayPreviewMessage$10.label ^= 0x80000000;
            }
        }
        else {
            inAppDisplayer$displayPreviewMessage$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.displayPreviewMessage(null, this);
                }
            };
        }
        Object object0 = inAppDisplayer$displayPreviewMessage$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(inAppDisplayer$displayPreviewMessage$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                InAppMessage inAppMessage0 = new InAppMessage(true, this._time);
                String s1 = ((ConfigModel)this._configModelStore.getModel()).getAppId();
                inAppDisplayer$displayPreviewMessage$10.L$0 = this;
                inAppDisplayer$displayPreviewMessage$10.L$1 = inAppMessage0;
                inAppDisplayer$displayPreviewMessage$10.label = 1;
                Object object2 = this._backend.getIAMPreviewData(s1, s, inAppDisplayer$displayPreviewMessage$10);
                if(object2 == object1) {
                    return object1;
                }
                inAppDisplayer0 = this;
                object0 = object2;
                inAppMessage1 = inAppMessage0;
                break;
            }
            case 1: {
                inAppMessage1 = (InAppMessage)inAppDisplayer$displayPreviewMessage$10.L$1;
                inAppDisplayer0 = (InAppDisplayer)inAppDisplayer$displayPreviewMessage$10.L$0;
                ResultKt.throwOnFailure(object0);
                break;
            }
            case 2: {
                ResultKt.throwOnFailure(object0);
                return Boxing.boxBoolean(true);
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(((InAppMessageContent)object0) == null) {
            return Boxing.boxBoolean(false);
        }
        Double double0 = ((InAppMessageContent)object0).getDisplayDuration();
        Intrinsics.checkNotNull(double0);
        inAppMessage1.setDisplayDuration(((double)double0));
        inAppDisplayer$displayPreviewMessage$10.L$0 = null;
        inAppDisplayer$displayPreviewMessage$10.L$1 = null;
        inAppDisplayer$displayPreviewMessage$10.label = 2;
        return inAppDisplayer0.showMessageContent(inAppMessage1, ((InAppMessageContent)object0), inAppDisplayer$displayPreviewMessage$10) == object1 ? object1 : Boxing.boxBoolean(true);
    }

    private final Object initInAppMessage(Activity activity0, InAppMessage inAppMessage0, InAppMessageContent inAppMessageContent0, Continuation continuation0) {
        com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer.initInAppMessage.1 inAppDisplayer$initInAppMessage$10;
        if(continuation0 instanceof com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer.initInAppMessage.1) {
            inAppDisplayer$initInAppMessage$10 = (com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer.initInAppMessage.1)continuation0;
            if((inAppDisplayer$initInAppMessage$10.label & 0x80000000) == 0) {
                inAppDisplayer$initInAppMessage$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.initInAppMessage(null, null, null, this);
                    }
                };
            }
            else {
                inAppDisplayer$initInAppMessage$10.label ^= 0x80000000;
            }
        }
        else {
            inAppDisplayer$initInAppMessage$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.initInAppMessage(null, null, null, this);
                }
            };
        }
        Object object0 = inAppDisplayer$initInAppMessage$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(inAppDisplayer$initInAppMessage$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                try {
                    String s = inAppMessageContent0.getContentHtml();
                    Intrinsics.checkNotNull(s);
                    Charset charset0 = Charset.forName("UTF-8");
                    Intrinsics.checkNotNullExpressionValue(charset0, "forName(charsetName)");
                    byte[] arr_b = s.getBytes(charset0);
                    Intrinsics.checkNotNullExpressionValue(arr_b, "this as java.lang.String).getBytes(charset)");
                    String s1 = Base64.encodeToString(arr_b, 2);
                    WebViewManager webViewManager0 = new WebViewManager(inAppMessage0, activity0, inAppMessageContent0, this._lifecycle, this._applicationService, this._promptFactory);
                    this.lastInstance = webViewManager0;
                    if(inAppMessageContent0.isFullBleed()) {
                        webViewManager0.setContentSafeAreaInsets(inAppMessageContent0, activity0);
                    }
                    com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer.initInAppMessage.2 inAppDisplayer$initInAppMessage$20 = new Function2(activity0, s1, inAppMessageContent0, null) {
                        final String $base64Str;
                        final InAppMessageContent $content;
                        final Activity $currentActivity;
                        final WebViewManager $webViewManager;
                        int label;

                        {
                            this.$webViewManager = webViewManager0;
                            this.$currentActivity = activity0;
                            this.$base64Str = s;
                            this.$content = inAppMessageContent0;
                            super(2, continuation0);
                        }

                        @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer.initInAppMessage.2(this.$webViewManager, this.$currentActivity, this.$base64Str, this.$content, continuation0);
                        }

                        @Override  // kotlin.jvm.functions.Function2
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer.initInAppMessage.2)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object object0) {
                            Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch(this.label) {
                                case 0: {
                                    ResultKt.throwOnFailure(object0);
                                    try {
                                        Intrinsics.checkNotNullExpressionValue(this.$base64Str, "base64Str");
                                        this.label = 1;
                                        return this.$webViewManager.setupWebView(this.$currentActivity, this.$base64Str, this.$content.isFullBleed(), this) == object1 ? object1 : Unit.INSTANCE;
                                    label_9:
                                        ResultKt.throwOnFailure(object0);
                                        return Unit.INSTANCE;
                                    }
                                    catch(Exception exception0) {
                                        goto label_12;
                                    }
                                }
                                case 1: {
                                    goto label_9;
                                label_12:
                                    if(exception0.getMessage() != null) {
                                        String s = exception0.getMessage();
                                        Intrinsics.checkNotNull(s);
                                        if(StringsKt.contains$default(s, "No WebView installed", false, 2, null)) {
                                            Logging.error("Error setting up WebView: ", exception0);
                                            return Unit.INSTANCE;
                                        }
                                    }
                                    throw exception0;
                                }
                                default: {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                            }
                        }
                    };
                    inAppDisplayer$initInAppMessage$10.label = 1;
                    if(BuildersKt.withContext(Dispatchers.getMain(), inAppDisplayer$initInAppMessage$20, inAppDisplayer$initInAppMessage$10) == object1) {
                        return object1;
                    }
                }
                catch(UnsupportedEncodingException unsupportedEncodingException0) {
                    Logging.error("Catch on initInAppMessage: ", unsupportedEncodingException0);
                }
                return Unit.INSTANCE;
            }
            case 1: {
                try {
                    ResultKt.throwOnFailure(object0);
                }
                catch(UnsupportedEncodingException unsupportedEncodingException0) {
                    Logging.error("Catch on initInAppMessage: ", unsupportedEncodingException0);
                }
                return Unit.INSTANCE;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    private final Object showMessageContent(InAppMessage inAppMessage0, InAppMessageContent inAppMessageContent0, Continuation continuation0) {
        InAppDisplayer inAppDisplayer0;
        InAppDisplayer inAppDisplayer1;
        InAppMessage inAppMessage1;
        Activity activity0;
        com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer.showMessageContent.1 inAppDisplayer$showMessageContent$10;
        if(continuation0 instanceof com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer.showMessageContent.1) {
            inAppDisplayer$showMessageContent$10 = (com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer.showMessageContent.1)continuation0;
            if((inAppDisplayer$showMessageContent$10.label & 0x80000000) == 0) {
                inAppDisplayer$showMessageContent$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.showMessageContent(null, null, this);
                    }
                };
            }
            else {
                inAppDisplayer$showMessageContent$10.label ^= 0x80000000;
            }
        }
        else {
            inAppDisplayer$showMessageContent$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.showMessageContent(null, null, this);
                }
            };
        }
        Object object0 = inAppDisplayer$showMessageContent$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(inAppDisplayer$showMessageContent$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                Activity activity1 = this._applicationService.getCurrent();
                Logging.debug$default(("InAppDisplayer.showMessageContent: in app message on currentActivity: " + activity1), null, 2, null);
                if(activity1 != null) {
                    if(this.lastInstance == null || !inAppMessage0.isPreview()) {
                        inAppDisplayer$showMessageContent$10.label = 3;
                        if(this.initInAppMessage(activity1, inAppMessage0, inAppMessageContent0, inAppDisplayer$showMessageContent$10) == object1) {
                            return object1;
                        }
                    }
                    else {
                        WebViewManager webViewManager0 = this.lastInstance;
                        Intrinsics.checkNotNull(webViewManager0);
                        inAppDisplayer$showMessageContent$10.L$0 = this;
                        inAppDisplayer$showMessageContent$10.L$1 = inAppMessage0;
                        inAppDisplayer$showMessageContent$10.L$2 = inAppMessageContent0;
                        inAppDisplayer$showMessageContent$10.L$3 = activity1;
                        inAppDisplayer$showMessageContent$10.label = 1;
                        if(webViewManager0.dismissAndAwaitNextMessage(inAppDisplayer$showMessageContent$10) == object1) {
                            return object1;
                        }
                        inAppDisplayer1 = this;
                        inAppMessage1 = inAppMessage0;
                        activity0 = activity1;
                    label_44:
                        inAppDisplayer1.lastInstance = null;
                        inAppDisplayer$showMessageContent$10.L$0 = null;
                        inAppDisplayer$showMessageContent$10.L$1 = null;
                        inAppDisplayer$showMessageContent$10.L$2 = null;
                        inAppDisplayer$showMessageContent$10.L$3 = null;
                        inAppDisplayer$showMessageContent$10.label = 2;
                        if(inAppDisplayer1.initInAppMessage(activity0, inAppMessage1, inAppMessageContent0, inAppDisplayer$showMessageContent$10) == object1) {
                            return object1;
                        }
                    }
                    return Unit.INSTANCE;
                }
                inAppDisplayer$showMessageContent$10.L$0 = this;
                inAppDisplayer$showMessageContent$10.L$1 = inAppMessage0;
                inAppDisplayer$showMessageContent$10.L$2 = inAppMessageContent0;
                inAppDisplayer$showMessageContent$10.label = 4;
                if(DelayKt.delay(200L, inAppDisplayer$showMessageContent$10) == object1) {
                    return object1;
                }
                inAppDisplayer0 = this;
                break;
            }
            case 1: {
                activity0 = (Activity)inAppDisplayer$showMessageContent$10.L$3;
                inAppMessageContent0 = (InAppMessageContent)inAppDisplayer$showMessageContent$10.L$2;
                inAppMessage1 = (InAppMessage)inAppDisplayer$showMessageContent$10.L$1;
                inAppDisplayer1 = (InAppDisplayer)inAppDisplayer$showMessageContent$10.L$0;
                ResultKt.throwOnFailure(object0);
                goto label_44;
            }
            case 2: 
            case 3: {
                ResultKt.throwOnFailure(object0);
                return Unit.INSTANCE;
            }
            case 4: {
                inAppMessageContent0 = (InAppMessageContent)inAppDisplayer$showMessageContent$10.L$2;
                inAppMessage0 = (InAppMessage)inAppDisplayer$showMessageContent$10.L$1;
                inAppDisplayer0 = (InAppDisplayer)inAppDisplayer$showMessageContent$10.L$0;
                ResultKt.throwOnFailure(object0);
                break;
            }
            case 5: {
                ResultKt.throwOnFailure(object0);
                return Unit.INSTANCE;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        inAppDisplayer$showMessageContent$10.L$0 = null;
        inAppDisplayer$showMessageContent$10.L$1 = null;
        inAppDisplayer$showMessageContent$10.L$2 = null;
        inAppDisplayer$showMessageContent$10.label = 5;
        return inAppDisplayer0.showMessageContent(inAppMessage0, inAppMessageContent0, inAppDisplayer$showMessageContent$10) == object1 ? object1 : Unit.INSTANCE;
    }
}

