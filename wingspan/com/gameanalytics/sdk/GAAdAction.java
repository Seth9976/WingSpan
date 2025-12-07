package com.gameanalytics.sdk;

public enum GAAdAction {
    Undefined("", 0),
    Clicked("clicked", 1),
    Show("show", 2),
    FailedShow("failed_show", 3),
    RewardReceived("reward_received", 4),
    Request("request", 5),
    Loaded("loaded", 6);

    private int id;
    private String value;

    private static GAAdAction[] $values() [...] // Inlined contents

    private GAAdAction(String value, int id) {
        this.value = value;
        this.id = id;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public static GAAdAction valueOf(int id) {
        GAAdAction[] arr_gAAdAction = GAAdAction.values();
        for(int v1 = 0; v1 < arr_gAAdAction.length; ++v1) {
            GAAdAction gAAdAction0 = arr_gAAdAction[v1];
            if(gAAdAction0.id == id) {
                return gAAdAction0;
            }
        }
        return GAAdAction.Undefined;
    }
}

