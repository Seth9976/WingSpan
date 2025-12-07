package com.gameanalytics.sdk.events;

public enum EGASdkErrorCategory {
    Undefined("", 0),
    EventValidation("event_validation", 1),
    Database("db", 2),
    Init("init", 3),
    Http("http", 4),
    Json("json", 5);

    private int id;
    private String value;

    private static EGASdkErrorCategory[] $values() [...] // Inlined contents

    private EGASdkErrorCategory(String value, int id) {
        this.value = value;
        this.id = id;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public static EGASdkErrorCategory valueOf(int id) {
        EGASdkErrorCategory[] arr_eGASdkErrorCategory = EGASdkErrorCategory.values();
        for(int v1 = 0; v1 < arr_eGASdkErrorCategory.length; ++v1) {
            EGASdkErrorCategory eGASdkErrorCategory0 = arr_eGASdkErrorCategory[v1];
            if(eGASdkErrorCategory0.id == id) {
                return eGASdkErrorCategory0;
            }
        }
        return EGASdkErrorCategory.Undefined;
    }
}

