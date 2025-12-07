package com.gameanalytics.sdk;

public enum GAAdError {
    Undefined("", 0),
    Unknown("unknown", 1),
    Offline("offline", 2),
    NoFill("no_fill", 3),
    InternalError("internal_error", 4),
    InvalidRequest("invalid_request", 5),
    UnableToPrecache("unable_to_precache", 6);

    private int id;
    private String value;

    private static GAAdError[] $values() [...] // Inlined contents

    private GAAdError(String value, int id) {
        this.value = value;
        this.id = id;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public static GAAdError valueOf(int id) {
        GAAdError[] arr_gAAdError = GAAdError.values();
        for(int v1 = 0; v1 < arr_gAAdError.length; ++v1) {
            GAAdError gAAdError0 = arr_gAAdError[v1];
            if(gAAdError0.id == id) {
                return gAAdError0;
            }
        }
        return GAAdError.Undefined;
    }
}

