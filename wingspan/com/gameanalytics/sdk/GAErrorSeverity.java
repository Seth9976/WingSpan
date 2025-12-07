package com.gameanalytics.sdk;

public enum GAErrorSeverity {
    Undefined("", 0),
    Debug("debug", 1),
    Info("info", 2),
    Warning("warning", 3),
    Error("error", 4),
    Critical("critical", 5);

    private int id;
    private String value;

    private static GAErrorSeverity[] $values() [...] // Inlined contents

    private GAErrorSeverity(String value, int id) {
        this.value = value;
        this.id = id;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public static GAErrorSeverity valueOf(int id) {
        GAErrorSeverity[] arr_gAErrorSeverity = GAErrorSeverity.values();
        for(int v1 = 0; v1 < arr_gAErrorSeverity.length; ++v1) {
            GAErrorSeverity gAErrorSeverity0 = arr_gAErrorSeverity[v1];
            if(gAErrorSeverity0.id == id) {
                return gAErrorSeverity0;
            }
        }
        return GAErrorSeverity.Undefined;
    }
}

