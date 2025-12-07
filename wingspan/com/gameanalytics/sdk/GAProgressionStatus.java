package com.gameanalytics.sdk;

public enum GAProgressionStatus {
    Undefined("", 0),
    Start("Start", 1),
    Complete("Complete", 2),
    Fail("Fail", 3);

    private int id;
    private String value;

    private static GAProgressionStatus[] $values() [...] // Inlined contents

    private GAProgressionStatus(String value, int id) {
        this.value = value;
        this.id = id;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public static GAProgressionStatus valueOf(int id) {
        GAProgressionStatus[] arr_gAProgressionStatus = GAProgressionStatus.values();
        for(int v1 = 0; v1 < arr_gAProgressionStatus.length; ++v1) {
            GAProgressionStatus gAProgressionStatus0 = arr_gAProgressionStatus[v1];
            if(gAProgressionStatus0.id == id) {
                return gAProgressionStatus0;
            }
        }
        return GAProgressionStatus.Undefined;
    }
}

