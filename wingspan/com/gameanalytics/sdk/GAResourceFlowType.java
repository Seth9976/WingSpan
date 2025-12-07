package com.gameanalytics.sdk;

public enum GAResourceFlowType {
    Undefined("", 0),
    Source("Source", 1),
    Sink("Sink", 2);

    private int id;
    private String value;

    private static GAResourceFlowType[] $values() [...] // Inlined contents

    private GAResourceFlowType(String value, int id) {
        this.value = value;
        this.id = id;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public static GAResourceFlowType valueOf(int id) {
        GAResourceFlowType[] arr_gAResourceFlowType = GAResourceFlowType.values();
        for(int v1 = 0; v1 < arr_gAResourceFlowType.length; ++v1) {
            GAResourceFlowType gAResourceFlowType0 = arr_gAResourceFlowType[v1];
            if(gAResourceFlowType0.id == id) {
                return gAResourceFlowType0;
            }
        }
        return GAResourceFlowType.Undefined;
    }
}

