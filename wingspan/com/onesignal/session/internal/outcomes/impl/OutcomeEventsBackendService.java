package com.onesignal.session.internal.outcomes.impl;

import com.onesignal.common.exceptions.BackendException;
import com.onesignal.core.internal.http.HttpResponse;
import com.onesignal.core.internal.http.IHttpClient;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004JC\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\b2\b\u0010\f\u001A\u0004\u0018\u00010\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0010R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/onesignal/session/internal/outcomes/impl/OutcomeEventsBackendService;", "Lcom/onesignal/session/internal/outcomes/impl/IOutcomeEventsBackendService;", "_http", "Lcom/onesignal/core/internal/http/IHttpClient;", "(Lcom/onesignal/core/internal/http/IHttpClient;)V", "sendOutcomeEvent", "", "appId", "", "userId", "subscriptionId", "deviceType", "direct", "", "event", "Lcom/onesignal/session/internal/outcomes/impl/OutcomeEvent;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/onesignal/session/internal/outcomes/impl/OutcomeEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class OutcomeEventsBackendService implements IOutcomeEventsBackendService {
    private final IHttpClient _http;

    public OutcomeEventsBackendService(IHttpClient iHttpClient0) {
        Intrinsics.checkNotNullParameter(iHttpClient0, "_http");
        super();
        this._http = iHttpClient0;
    }

    @Override  // com.onesignal.session.internal.outcomes.impl.IOutcomeEventsBackendService
    public Object sendOutcomeEvent(String s, String s1, String s2, String s3, Boolean boolean0, OutcomeEvent outcomeEvent0, Continuation continuation0) {
        com.onesignal.session.internal.outcomes.impl.OutcomeEventsBackendService.sendOutcomeEvent.1 outcomeEventsBackendService$sendOutcomeEvent$10;
        if(continuation0 instanceof com.onesignal.session.internal.outcomes.impl.OutcomeEventsBackendService.sendOutcomeEvent.1) {
            outcomeEventsBackendService$sendOutcomeEvent$10 = (com.onesignal.session.internal.outcomes.impl.OutcomeEventsBackendService.sendOutcomeEvent.1)continuation0;
            if((outcomeEventsBackendService$sendOutcomeEvent$10.label & 0x80000000) == 0) {
                outcomeEventsBackendService$sendOutcomeEvent$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.sendOutcomeEvent(null, null, null, null, null, null, this);
                    }
                };
            }
            else {
                outcomeEventsBackendService$sendOutcomeEvent$10.label ^= 0x80000000;
            }
        }
        else {
            outcomeEventsBackendService$sendOutcomeEvent$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.sendOutcomeEvent(null, null, null, null, null, null, this);
                }
            };
        }
        Object object0 = outcomeEventsBackendService$sendOutcomeEvent$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(outcomeEventsBackendService$sendOutcomeEvent$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                JSONObject jSONObject0 = new JSONObject().put("app_id", s).put("onesignal_id", s1).put("subscription", new JSONObject().put("id", s2).put("type", s3));
                if(boolean0 != null) {
                    jSONObject0.put("direct", boolean0.booleanValue());
                }
                if(outcomeEvent0.getNotificationIds() != null && outcomeEvent0.getNotificationIds().length() > 0) {
                    jSONObject0.put("notification_ids", outcomeEvent0.getNotificationIds());
                }
                jSONObject0.put("id", outcomeEvent0.getName());
                if(outcomeEvent0.getWeight() > 0.0f) {
                    jSONObject0.put("weight", Boxing.boxFloat(outcomeEvent0.getWeight()));
                }
                if(outcomeEvent0.getTimestamp() > 0L) {
                    jSONObject0.put("timestamp", outcomeEvent0.getTimestamp());
                }
                if(outcomeEvent0.getSessionTime() > 0L) {
                    jSONObject0.put("session_time", outcomeEvent0.getSessionTime());
                }
                Intrinsics.checkNotNullExpressionValue(jSONObject0, "jsonObject");
                outcomeEventsBackendService$sendOutcomeEvent$10.label = 1;
                object0 = this._http.post("outcomes/measure", jSONObject0, outcomeEventsBackendService$sendOutcomeEvent$10);
                if(object0 == object1) {
                    return object1;
                }
                break;
            }
            case 1: {
                ResultKt.throwOnFailure(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(!((HttpResponse)object0).isSuccess()) {
            throw new BackendException(((HttpResponse)object0).getStatusCode(), ((HttpResponse)object0).getPayload());
        }
        return Unit.INSTANCE;
    }
}

