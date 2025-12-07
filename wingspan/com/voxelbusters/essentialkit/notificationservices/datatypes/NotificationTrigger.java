package com.voxelbusters.essentialkit.notificationservices.datatypes;

import org.json.JSONObject;

public class NotificationTrigger {
    public boolean repeat;

    public JSONObject toJson() {
        JSONObject jSONObject0 = new JSONObject();
        jSONObject0.put("repeat", this.repeat);
        return jSONObject0;
    }
}

