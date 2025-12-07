package com.google.android.gms.nearby;

import android.app.Activity;
import android.content.Context;
import androidx.core.content.PermissionChecker;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.nearby.zzbd;
import com.google.android.gms.internal.nearby.zzca;
import com.google.android.gms.internal.nearby.zze;
import com.google.android.gms.internal.nearby.zzg;
import com.google.android.gms.internal.nearby.zzhe;
import com.google.android.gms.nearby.connection.Connections;
import com.google.android.gms.nearby.connection.ConnectionsClient;
import com.google.android.gms.nearby.messages.Messages;
import com.google.android.gms.nearby.messages.MessagesClient;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.internal.zzak;
import com.google.android.gms.nearby.messages.internal.zzbi;
import com.google.android.gms.nearby.messages.internal.zzby;
import com.google.android.gms.nearby.messages.zzd;

public final class Nearby {
    @Deprecated
    public static final Api CONNECTIONS_API;
    @Deprecated
    public static final Connections Connections;
    @Deprecated
    public static final Api MESSAGES_API;
    @Deprecated
    public static final Messages Messages;
    private static final zzd zze;
    private static final Api zzf;
    private static final zze zzg;

    static {
        Nearby.CONNECTIONS_API = new Api("Nearby.CONNECTIONS_API", zzca.CLIENT_BUILDER, zzca.CLIENT_KEY);
        Nearby.Connections = new zzca();
        Nearby.MESSAGES_API = new Api("Nearby.MESSAGES_API", zzbi.CLIENT_BUILDER, zzbi.CLIENT_KEY);
        Nearby.Messages = zzbi.zzij;
        Nearby.zze = new zzby();
        Nearby.zzf = new Api("Nearby.BOOTSTRAP_API", zzg.CLIENT_BUILDER, zzg.CLIENT_KEY);
        Nearby.zzg = new zzg();
    }

    public static final ConnectionsClient getConnectionsClient(Activity activity0) {
        Preconditions.checkNotNull(activity0, "Activity must not be null");
        return new zzbd(activity0);
    }

    public static final ConnectionsClient getConnectionsClient(Context context0) {
        Preconditions.checkNotNull(context0, "Context must not be null");
        return new zzbd(context0);
    }

    public static final MessagesClient getMessagesClient(Activity activity0) {
        Preconditions.checkNotNull(activity0, "Activity must not be null");
        return new zzak(activity0, null);
    }

    public static final MessagesClient getMessagesClient(Activity activity0, MessagesOptions messagesOptions0) {
        Preconditions.checkNotNull(activity0, "Activity must not be null");
        Preconditions.checkNotNull(messagesOptions0, "Options must not be null");
        return new zzak(activity0, messagesOptions0);
    }

    public static final MessagesClient getMessagesClient(Context context0) {
        Preconditions.checkNotNull(context0, "Context must not be null");
        return new zzak(context0, null);
    }

    public static final MessagesClient getMessagesClient(Context context0, MessagesOptions messagesOptions0) {
        Preconditions.checkNotNull(context0, "Context must not be null");
        Preconditions.checkNotNull(messagesOptions0, "Options must not be null");
        return new zzak(context0, messagesOptions0);
    }

    public static boolean zza(Context context0) {
        return PermissionChecker.checkCallingOrSelfPermission(context0, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? zzhe.zza(context0.getContentResolver(), "gms:nearby:requires_gms_check", true) : true;
    }
}

