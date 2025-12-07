package com.onesignal.inAppMessages.internal;

import com.onesignal.inAppMessages.IInAppMessage;
import com.onesignal.inAppMessages.IInAppMessageClickEvent;
import com.onesignal.inAppMessages.IInAppMessageClickResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0011\u001A\u00020\u0012R\u000E\u0010\u0007\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001A\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\fR\u0014\u0010\r\u001A\u00020\u000E8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/onesignal/inAppMessages/internal/InAppMessageClickEvent;", "Lcom/onesignal/inAppMessages/IInAppMessageClickEvent;", "msg", "Lcom/onesignal/inAppMessages/internal/InAppMessage;", "actn", "Lcom/onesignal/inAppMessages/internal/InAppMessageClickResult;", "(Lcom/onesignal/inAppMessages/internal/InAppMessage;Lcom/onesignal/inAppMessages/internal/InAppMessageClickResult;)V", "_message", "_result", "message", "Lcom/onesignal/inAppMessages/IInAppMessage;", "getMessage", "()Lcom/onesignal/inAppMessages/IInAppMessage;", "result", "Lcom/onesignal/inAppMessages/IInAppMessageClickResult;", "getResult", "()Lcom/onesignal/inAppMessages/IInAppMessageClickResult;", "toJSONObject", "Lorg/json/JSONObject;", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class InAppMessageClickEvent implements IInAppMessageClickEvent {
    private final InAppMessage _message;
    private final InAppMessageClickResult _result;

    public InAppMessageClickEvent(InAppMessage inAppMessage0, InAppMessageClickResult inAppMessageClickResult0) {
        Intrinsics.checkNotNullParameter(inAppMessage0, "msg");
        Intrinsics.checkNotNullParameter(inAppMessageClickResult0, "actn");
        super();
        this._message = inAppMessage0;
        this._result = inAppMessageClickResult0;
    }

    @Override  // com.onesignal.inAppMessages.IInAppMessageClickEvent
    public IInAppMessage getMessage() {
        return this._message;
    }

    @Override  // com.onesignal.inAppMessages.IInAppMessageClickEvent
    public IInAppMessageClickResult getResult() {
        return this._result;
    }

    public final JSONObject toJSONObject() {
        JSONObject jSONObject0 = new JSONObject().put("message", this._message.toJSONObject()).put("action", this._result.toJSONObject());
        Intrinsics.checkNotNullExpressionValue(jSONObject0, "JSONObject()\n           …, _result.toJSONObject())");
        return jSONObject0;
    }
}

