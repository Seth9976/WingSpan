package com.gameanalytics.sdk.events;

public enum EGASdkErrorArea {
    Undefined("", 0),
    BusinessEvent("business", 1),
    ResourceEvent("resource", 2),
    ProgressionEvent("progression", 3),
    DesignEvent("design", 4),
    ErrorEvent("error", 5),
    Sql("sql", 6),
    EnsurePersistedStates("ensure_persisted_states", 7),
    SessionEnd("session_end", 8),
    InitHttp("init_http", 9),
    EventsHttp("events_http", 10),
    ProcessEvents("process_events", 11),
    AddEventsToStore("add_events_to_store", 12),
    JsonStringToMap("json_string_to_map", 13),
    SessionStart("session_start", 14),
    AddDimensions("add_dimensions", 15),
    AddFields("add_fields", 16),
    InitRequest("init_request", 17),
    SendEvents("send_events", 18),
    InitialInit("internal_init", 19),
    AdEvent("ad", 20),
    ImpressionEvent("impression", 21),
    HealthEvent("health", 1);

    private int id;
    private String value;

    private static EGASdkErrorArea[] $values() [...] // Inlined contents

    private EGASdkErrorArea(String value, int id) {
        this.value = value;
        this.id = id;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public static EGASdkErrorArea valueOf(int id) {
        EGASdkErrorArea[] arr_eGASdkErrorArea = EGASdkErrorArea.values();
        for(int v1 = 0; v1 < arr_eGASdkErrorArea.length; ++v1) {
            EGASdkErrorArea eGASdkErrorArea0 = arr_eGASdkErrorArea[v1];
            if(eGASdkErrorArea0.id == id) {
                return eGASdkErrorArea0;
            }
        }
        return EGASdkErrorArea.Undefined;
    }
}

