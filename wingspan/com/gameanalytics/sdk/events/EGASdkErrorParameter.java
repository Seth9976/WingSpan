package com.gameanalytics.sdk.events;

public enum EGASdkErrorParameter {
    Undefined("", 0),
    Currency("currency", 1),
    CartType("cart_type", 2),
    ItemType("item_type", 3),
    ItemId("item_id", 4),
    Store("store", 5),
    FlowType("flow_type", 6),
    Amount("amount", 7),
    Progression01("progression01", 8),
    Progression02("progression02", 9),
    Progression03("progression03", 10),
    EventId("event_id", 11),
    ProgressionStatus("progression_status", 12),
    Severity("severity", 13),
    Message("message", 14),
    AdAction("ad_action", 15),
    AdType("ad_type", 16),
    AdSdkName("ad_sdk_name", 17),
    AdPlacement("ad_placement", 18),
    AdNetwork("ad_network", 19),
    ImpressionData("impression_data", 20),
    AdNetworkVersion("ad_network_version", 19);

    private int id;
    private String value;

    private static EGASdkErrorParameter[] $values() [...] // Inlined contents

    private EGASdkErrorParameter(String value, int id) {
        this.value = value;
        this.id = id;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public static EGASdkErrorParameter valueOf(int id) {
        EGASdkErrorParameter[] arr_eGASdkErrorParameter = EGASdkErrorParameter.values();
        for(int v1 = 0; v1 < arr_eGASdkErrorParameter.length; ++v1) {
            EGASdkErrorParameter eGASdkErrorParameter0 = arr_eGASdkErrorParameter[v1];
            if(eGASdkErrorParameter0.id == id) {
                return eGASdkErrorParameter0;
            }
        }
        return EGASdkErrorParameter.Undefined;
    }
}

