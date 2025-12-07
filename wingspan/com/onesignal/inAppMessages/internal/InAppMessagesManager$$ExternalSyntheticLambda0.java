package com.onesignal.inAppMessages.internal;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import java.util.List;

public final class InAppMessagesManager..ExternalSyntheticLambda0 implements DialogInterface.OnClickListener {
    public final InAppMessagesManager f$0;
    public final InAppMessage f$1;
    public final List f$2;

    public InAppMessagesManager..ExternalSyntheticLambda0(InAppMessagesManager inAppMessagesManager0, InAppMessage inAppMessage0, List list0) {
        this.f$0 = inAppMessagesManager0;
        this.f$1 = inAppMessage0;
        this.f$2 = list0;
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface0, int v) {
        InAppMessagesManager.$r8$lambda$MLBJj_Ls45pAFK2C6b0wM-z-GQo(this.f$0, this.f$1, this.f$2, dialogInterface0, v);
    }
}

