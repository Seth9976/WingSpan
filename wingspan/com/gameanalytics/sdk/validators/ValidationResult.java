package com.gameanalytics.sdk.validators;

import com.gameanalytics.sdk.events.EGASdkErrorAction;
import com.gameanalytics.sdk.events.EGASdkErrorArea;
import com.gameanalytics.sdk.events.EGASdkErrorCategory;
import com.gameanalytics.sdk.events.EGASdkErrorParameter;

public class ValidationResult {
    public EGASdkErrorAction action;
    public EGASdkErrorArea area;
    public EGASdkErrorCategory category;
    public EGASdkErrorParameter parameter;
    public String reason;

    public ValidationResult(EGASdkErrorCategory category, EGASdkErrorArea area, EGASdkErrorAction action, EGASdkErrorParameter parameter, String reason) {
        this.category = category;
        this.area = area;
        this.action = action;
        this.parameter = parameter;
        this.reason = reason;
    }
}

