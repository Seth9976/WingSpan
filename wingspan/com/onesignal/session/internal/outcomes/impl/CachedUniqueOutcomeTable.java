package com.onesignal.session.internal.outcomes.impl;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/onesignal/session/internal/outcomes/impl/CachedUniqueOutcomeTable;", "", "()V", "COLUMN_CHANNEL_INFLUENCE_ID", "", "COLUMN_CHANNEL_TYPE", "COLUMN_NAME_NAME", "COLUMN_NAME_NOTIFICATION_ID", "ID", "TABLE_NAME", "TABLE_NAME_V1", "TABLE_NAME_V2", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class CachedUniqueOutcomeTable {
    public static final String COLUMN_CHANNEL_INFLUENCE_ID = "channel_influence_id";
    public static final String COLUMN_CHANNEL_TYPE = "channel_type";
    public static final String COLUMN_NAME_NAME = "name";
    public static final String COLUMN_NAME_NOTIFICATION_ID = "notification_id";
    public static final String ID = "_id";
    public static final CachedUniqueOutcomeTable INSTANCE = null;
    public static final String TABLE_NAME = "cached_unique_outcome";
    public static final String TABLE_NAME_V1 = "cached_unique_outcome_notification";
    public static final String TABLE_NAME_V2 = "cached_unique_outcome";

    static {
        CachedUniqueOutcomeTable.INSTANCE = new CachedUniqueOutcomeTable();
    }
}

