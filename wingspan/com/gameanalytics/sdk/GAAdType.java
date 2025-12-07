package com.gameanalytics.sdk;

public enum GAAdType {
    Undefined("", 0),
    Video("video", 1),
    RewardedVideo("rewarded_video", 2),
    Playable("playable", 3),
    Interstitial("interstitial", 4),
    OfferWall("offer_wall", 5),
    Banner("banner", 6),
    AppOpen("app_open", 7);

    private int id;
    private String value;

    private static GAAdType[] $values() [...] // Inlined contents

    private GAAdType(String value, int id) {
        this.value = value;
        this.id = id;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public static GAAdType valueOf(int id) {
        GAAdType[] arr_gAAdType = GAAdType.values();
        for(int v1 = 0; v1 < arr_gAAdType.length; ++v1) {
            GAAdType gAAdType0 = arr_gAAdType[v1];
            if(gAAdType0.id == id) {
                return gAAdType0;
            }
        }
        return GAAdType.Undefined;
    }
}

