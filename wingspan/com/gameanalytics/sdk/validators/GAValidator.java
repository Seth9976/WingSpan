package com.gameanalytics.sdk.validators;

import android.text.TextUtils;
import android.util.Log;
import com.gameanalytics.sdk.GAAdAction;
import com.gameanalytics.sdk.GAAdType;
import com.gameanalytics.sdk.GAErrorSeverity;
import com.gameanalytics.sdk.GAProgressionStatus;
import com.gameanalytics.sdk.GAResourceFlowType;
import com.gameanalytics.sdk.events.EGASdkErrorAction;
import com.gameanalytics.sdk.events.EGASdkErrorArea;
import com.gameanalytics.sdk.events.EGASdkErrorCategory;
import com.gameanalytics.sdk.events.EGASdkErrorParameter;
import com.gameanalytics.sdk.logging.GALogger;
import com.gameanalytics.sdk.state.GAState;
import com.gameanalytics.sdk.utilities.GAUtilities;
import java.util.Iterator;
import org.json.JSONObject;

public class GAValidator {
    public static ValidationResult validateAdEvent(GAAdAction adAction, GAAdType adType, String adSdkName, String adPlacement) {
        if(adAction.toString().length() == 0) {
            GALogger.w("Validation fail - ad event - adAction: Ad action was unsupported value.");
            return new ValidationResult(EGASdkErrorCategory.EventValidation, EGASdkErrorArea.AdEvent, EGASdkErrorAction.InvalidAdAction, EGASdkErrorParameter.AdAction, "");
        }
        if(adType.toString().length() == 0) {
            GALogger.w("Validation fail - ad event - adType: Ad type was unsupported value.");
            return new ValidationResult(EGASdkErrorCategory.EventValidation, EGASdkErrorArea.AdEvent, EGASdkErrorAction.InvalidAdType, EGASdkErrorParameter.AdType, "");
        }
        if(!GAValidator.validateShortString(adSdkName, false)) {
            GALogger.w("Validation fail - ad event - message: Ad SDK name cannot be above 32 characters.");
            return new ValidationResult(EGASdkErrorCategory.EventValidation, EGASdkErrorArea.AdEvent, EGASdkErrorAction.InvalidShortString, EGASdkErrorParameter.AdSdkName, adSdkName);
        }
        if(!GAValidator.validateString(adPlacement, false)) {
            GALogger.w("Validation fail - ad event - message: Ad placement cannot be above 64 characters.");
            return new ValidationResult(EGASdkErrorCategory.EventValidation, EGASdkErrorArea.AdEvent, EGASdkErrorAction.InvalidString, EGASdkErrorParameter.AdPlacement, adPlacement);
        }
        return null;
    }

    private static boolean validateAdNetworkName(String network) {
        return GAUtilities.stringMatch(network, "^(mopub|fyber|ironsource|topon|hyperbid|max|aequus|admob)$");
    }

    private static boolean validateAdNetworkVersion(String version) {
        return version != null && GAUtilities.stringMatch(version, "^[0-9]{0,5}(\\.[0-9]{0,5}){0,3}$");
    }

    public static boolean validateAppBuild(Integer appBuild) {
        if(((int)appBuild) > 0) {
            return true;
        }
        Log.w("GameAnalytics", appBuild + " is not a valid version code. Check your Gradle file.");
        return false;
    }

    public static boolean validateAppSignature(String appSignature) {
        if(GAValidator.validateString(appSignature, false)) {
            return true;
        }
        Log.w("GameAnalytics", appSignature + " is not a valid app signature.");
        return false;
    }

    public static boolean validateAppVersion(String appVersion) {
        if(GAValidator.validateString(appVersion, false)) {
            return true;
        }
        Log.w("GameAnalytics", appVersion + " is not a valid version name. Check your Gradle file.");
        return false;
    }

    public static boolean validateArrayOfStrings(long maxCount, long maxStringLength, boolean allowNoValues, String logTag, String[] arrayOfStrings) {
        if(TextUtils.isEmpty(logTag)) {
            logTag = "Array";
        }
        if(arrayOfStrings == null) {
            GALogger.w((logTag + " validation failed: array cannot be null. "));
            return false;
        }
        if(!allowNoValues && arrayOfStrings.length == 0) {
            GALogger.w((logTag + " validation failed: array cannot be empty. "));
            return false;
        }
        if(maxCount > 0L && ((long)arrayOfStrings.length) > maxCount) {
            GALogger.w((logTag + " validation failed: array cannot exceed " + maxCount + " values. It has " + arrayOfStrings.length + " values."));
            return false;
        }
        for(int v2 = 0; v2 < arrayOfStrings.length; ++v2) {
            String s1 = arrayOfStrings[v2];
            int v3 = s1 == null ? 0 : s1.length();
            if(v3 == 0) {
                GALogger.w((logTag + " validation failed: contained an empty string."));
                return false;
            }
            if(maxStringLength > 0L && ((long)v3) > maxStringLength) {
                GALogger.w((logTag + " validation failed: a string exceeded max allowed length (which is: " + maxStringLength + "). String was: " + s1));
                return false;
            }
        }
        return true;
    }

    public static boolean validateBuild(String build) {
        return GAValidator.validateShortString(build, false);
    }

    public static boolean validateBundleID(String bundleIdentifier) {
        if(GAValidator.validateMediumString(bundleIdentifier, false)) {
            return true;
        }
        Log.w("GameAnalytics", bundleIdentifier + " is not a valid application ID. Check your Gradle file.");
        return false;
    }

    public static ValidationResult validateBusinessEvent(String currency, long amount, String cartType, String itemType, String itemId, String receipt, String store, String signature) {
        if(!GAValidator.validateCurrency(currency)) {
            GALogger.w(("Validation fail - business event - currency: Cannot be (null) and need to be A-Z, 3 characters and in the standard at openexchangerates.org. Failed currency: " + currency));
            return new ValidationResult(EGASdkErrorCategory.EventValidation, EGASdkErrorArea.BusinessEvent, EGASdkErrorAction.InvalidCurrency, EGASdkErrorParameter.Currency, currency);
        }
        if(amount < 0L) {
            GALogger.w(("Validation fail - business event - amount: Cannot be less then 0. Failed amount: " + amount));
            return new ValidationResult(EGASdkErrorCategory.EventValidation, EGASdkErrorArea.BusinessEvent, EGASdkErrorAction.InvalidAmount, EGASdkErrorParameter.Amount, amount + "");
        }
        if(!GAValidator.validateShortString(cartType, true)) {
            GALogger.w(("Validation fail - business event - cartType. Cannot be above 32 length. String: " + cartType));
            return new ValidationResult(EGASdkErrorCategory.EventValidation, EGASdkErrorArea.BusinessEvent, EGASdkErrorAction.InvalidShortString, EGASdkErrorParameter.CartType, cartType);
        }
        if(!GAValidator.validateEventPartLength(itemType, false)) {
            GALogger.w(("Validation fail - business event - itemType: Cannot be (null), empty or above 64 characters. String: " + itemType));
            return new ValidationResult(EGASdkErrorCategory.EventValidation, EGASdkErrorArea.BusinessEvent, EGASdkErrorAction.InvalidEventPartLength, EGASdkErrorParameter.ItemType, itemType);
        }
        if(!GAValidator.validateEventPartCharacters(itemType)) {
            GALogger.w(("Validation fail - business event - itemType: Cannot contain other characters than A-z, 0-9, -_., ()!?. String: " + itemType));
            return new ValidationResult(EGASdkErrorCategory.EventValidation, EGASdkErrorArea.BusinessEvent, EGASdkErrorAction.InvalidEventPartCharacters, EGASdkErrorParameter.ItemType, itemType);
        }
        if(!GAValidator.validateEventPartLength(itemId, false)) {
            GALogger.w(("Validation fail - business event - itemId. Cannot be (null), empty or above 64 characters. String: " + itemId));
            return new ValidationResult(EGASdkErrorCategory.EventValidation, EGASdkErrorArea.BusinessEvent, EGASdkErrorAction.InvalidEventPartLength, EGASdkErrorParameter.ItemId, itemId);
        }
        if(!GAValidator.validateEventPartCharacters(itemId)) {
            GALogger.w(("Validation fail - business event - itemId: Cannot contain other characters than A-z, 0-9, -_., ()!?. String: " + itemId));
            return new ValidationResult(EGASdkErrorCategory.EventValidation, EGASdkErrorArea.BusinessEvent, EGASdkErrorAction.InvalidEventPartCharacters, EGASdkErrorParameter.ItemId, itemId);
        }
        if(!TextUtils.isEmpty(receipt) && !GAValidator.validateStore(store)) {
            GALogger.w(("Validation fail - business event - store: Is not one of the allowed values. String: " + store));
            return new ValidationResult(EGASdkErrorCategory.EventValidation, EGASdkErrorArea.BusinessEvent, EGASdkErrorAction.InvalidStore, EGASdkErrorParameter.Store, store);
        }
        return null;
    }

    public static boolean validateChannelId(String channelId) {
        return GAValidator.validateMediumString(channelId, false);
    }

    public static boolean validateClientTs(long clientTs) {
        return clientTs >= 0L && clientTs <= 0x174876E7FFL;
    }

    public static boolean validateConnectionType(String connectionType) {
        return GAUtilities.stringMatch(connectionType, "^(wwan|wifi|lan|offline)$");
    }

    // 去混淆评级： 低(30)
    public static boolean validateCurrency(String currency) {
        return TextUtils.isEmpty(currency) ? false : GAUtilities.stringMatch(currency, "^[A-Z]{3}$");
    }

    public static boolean validateCustomDimensions(String[] customDimensions) {
        return GAValidator.validateArrayOfStrings(20L, 0x20L, false, "custom dimensions", customDimensions);
    }

    public static ValidationResult validateDesignEvent(String eventId) {
        if(!GAValidator.validateEventIdLength(eventId)) {
            GALogger.w(("Validation fail - design event - eventId: Cannot be (null) or empty. Only 5 event parts allowed separated by :. Each part need to be 64 characters or less. String: " + eventId));
            return new ValidationResult(EGASdkErrorCategory.EventValidation, EGASdkErrorArea.DesignEvent, EGASdkErrorAction.InvalidEventIdLength, EGASdkErrorParameter.EventId, eventId);
        }
        if(!GAValidator.validateEventIdCharacters(eventId)) {
            GALogger.w(("Validation fail - design event - eventId: Non valid characters. Only allowed A-z, 0-9, -_., ()!?. String: " + eventId));
            return new ValidationResult(EGASdkErrorCategory.EventValidation, EGASdkErrorArea.DesignEvent, EGASdkErrorAction.InvalidEventIdCharacters, EGASdkErrorParameter.EventId, eventId);
        }
        return null;
    }

    // 去混淆评级： 低(30)
    public static boolean validateDimension01(String dimension01) {
        return TextUtils.isEmpty(dimension01) ? true : GAState.hasAvailableCustomDimensions01(dimension01);
    }

    // 去混淆评级： 低(30)
    public static boolean validateDimension02(String dimension02) {
        return TextUtils.isEmpty(dimension02) ? true : GAState.hasAvailableCustomDimensions02(dimension02);
    }

    // 去混淆评级： 低(30)
    public static boolean validateDimension03(String dimension03) {
        return TextUtils.isEmpty(dimension03) ? true : GAState.hasAvailableCustomDimensions03(dimension03);
    }

    public static boolean validateEngineVersion(String engineVersion) {
        return engineVersion != null && GAUtilities.stringMatch(engineVersion, "^(unity|unreal|corona|marmalade|cocos2d|xamarin|lumberyard|gamemaker|defold|nativescript|cordova|construct|stencyl|godot) [0-9]{0,5}(\\.[0-9]{0,5}){0,2}$");
    }

    public static ValidationResult validateErrorEvent(GAErrorSeverity severity, String message) {
        if(severity.toString().length() == 0) {
            GALogger.w("Validation fail - error event - severity: Severity was unsupported value.");
            return new ValidationResult(EGASdkErrorCategory.EventValidation, EGASdkErrorArea.ErrorEvent, EGASdkErrorAction.InvalidSeverity, EGASdkErrorParameter.Severity, "");
        }
        if(!GAValidator.validateLongString(message, true)) {
            GALogger.w("Validation fail - error event - message: Message cannot be above 8192 characters.");
            return new ValidationResult(EGASdkErrorCategory.EventValidation, EGASdkErrorArea.ErrorEvent, EGASdkErrorAction.InvalidLongString, EGASdkErrorParameter.Message, message);
        }
        return null;
    }

    // 去混淆评级： 低(30)
    public static boolean validateEventIdCharacters(String eventId) {
        return TextUtils.isEmpty(eventId) ? false : GAUtilities.stringMatch(eventId, "^[A-Za-z0-9\\s\\-_\\.\\(\\)\\!\\?]{1,64}(:[A-Za-z0-9\\s\\-_\\.\\(\\)\\!\\?]{1,64}){0,4}$");
    }

    // 去混淆评级： 低(30)
    public static boolean validateEventIdLength(String eventId) {
        return TextUtils.isEmpty(eventId) ? false : GAUtilities.stringMatch(eventId, "^[^:]{1,64}(?::[^:]{1,64}){0,4}$");
    }

    public static boolean validateEventPartCharacters(String eventPart) {
        return GAUtilities.stringMatch(eventPart, "^[A-Za-z0-9\\s\\-_\\.\\(\\)\\!\\?]{1,64}$");
    }

    public static boolean validateEventPartLength(String eventPart, boolean allowNull) {
        return GAValidator.validateString(eventPart, allowNull);
    }

    public static ValidationResult validateImpressionEvent(String adNetworkName, String adNetworkVersion, JSONObject data) {
        if(!GAValidator.validateAdNetworkName(adNetworkName)) {
            return new ValidationResult(EGASdkErrorCategory.EventValidation, EGASdkErrorArea.ImpressionEvent, EGASdkErrorAction.InvalidAdNetworkName, EGASdkErrorParameter.AdNetwork, adNetworkName);
        }
        if(!GAValidator.validateAdNetworkVersion(adNetworkVersion)) {
            return new ValidationResult(EGASdkErrorCategory.EventValidation, EGASdkErrorArea.ImpressionEvent, EGASdkErrorAction.InvalidAdNetworkVersion, EGASdkErrorParameter.AdNetworkVersion, adNetworkVersion);
        }
        if(data != null && data.length() != 0) {
            Iterator iterator0 = data.keys();
            try {
                while(iterator0.hasNext()) {
                    Object object0 = iterator0.next();
                    String s2 = (String)object0;
                    if(data.isNull(s2)) {
                        String s3 = "Impression event field: " + s2 + " is empty.";
                        GALogger.e(s3);
                        return new ValidationResult(EGASdkErrorCategory.EventValidation, EGASdkErrorArea.ImpressionEvent, EGASdkErrorAction.ImpressionDataIsNull, EGASdkErrorParameter.ImpressionData, s3);
                    }
                    if(false) {
                        break;
                    }
                }
                return null;
            }
            catch(Exception exception0) {
                GALogger.e("An exception occurred while validating an impression event.");
                exception0.printStackTrace();
                return new ValidationResult(EGASdkErrorCategory.EventValidation, EGASdkErrorArea.ImpressionEvent, EGASdkErrorAction.ImpressionDataIsNull, EGASdkErrorParameter.ImpressionData, exception0.getMessage());
            }
        }
        return new ValidationResult(EGASdkErrorCategory.EventValidation, EGASdkErrorArea.ImpressionEvent, EGASdkErrorAction.ImpressionDataIsNull, EGASdkErrorParameter.ImpressionData, "");
    }

    // 去混淆评级： 低(20)
    public static boolean validateKeys(String gameKey, String gameSecret) {
        return GAUtilities.stringMatch(gameKey, "^[A-z0-9]{32}$") && GAUtilities.stringMatch(gameSecret, "^[A-z0-9]{40}$");
    }

    // 去混淆评级： 低(30)
    private static boolean validateLongString(String longString, boolean canBeEmpty) {
        return !canBeEmpty || !TextUtils.isEmpty(longString) ? !TextUtils.isEmpty(longString) && longString.length() <= 0x2000 : true;
    }

    // 去混淆评级： 低(30)
    public static boolean validateMediumString(String string, boolean canBeEmpty) {
        return !canBeEmpty || !TextUtils.isEmpty(string) ? !TextUtils.isEmpty(string) && string.length() <= 0x100 : true;
    }

    public static ValidationResult validateProgressionEvent(GAProgressionStatus progressionStatus, String progression01, String progression02, String progression03) {
        if(progressionStatus.toString().length() == 0) {
            GALogger.w("Validation fail - progression event: Invalid progression status.");
            return new ValidationResult(EGASdkErrorCategory.EventValidation, EGASdkErrorArea.ProgressionEvent, EGASdkErrorAction.InvalidProgressionStatus, EGASdkErrorParameter.ProgressionStatus, "");
        }
        if(!TextUtils.isEmpty(progression03) && TextUtils.isEmpty(progression02) && !TextUtils.isEmpty(progression01)) {
            GALogger.w("Validation fail - progression event: 03 found but 01+02 are invalid. Progression must be set as either 01, 01+02 or 01+02+03.");
            return new ValidationResult(EGASdkErrorCategory.EventValidation, EGASdkErrorArea.ProgressionEvent, EGASdkErrorAction.WrongProgressionOrder, EGASdkErrorParameter.Undefined, progression01 + ":" + progression02 + ":" + progression03);
        }
        if(!TextUtils.isEmpty(progression02) && TextUtils.isEmpty(progression01)) {
            GALogger.w("Validation fail - progression event: 02 found but not 01. Progression must be set as either 01, 01+02 or 01+02+03");
            return new ValidationResult(EGASdkErrorCategory.EventValidation, EGASdkErrorArea.ProgressionEvent, EGASdkErrorAction.WrongProgressionOrder, EGASdkErrorParameter.Undefined, progression01 + ":" + progression02 + ":" + progression03);
        }
        if(TextUtils.isEmpty(progression01)) {
            GALogger.w("Validation fail - progression event: progression01 not valid. Progressions must be set as either 01, 01+02 or 01+02+03");
            return new ValidationResult(EGASdkErrorCategory.EventValidation, EGASdkErrorArea.ProgressionEvent, EGASdkErrorAction.WrongProgressionOrder, EGASdkErrorParameter.Undefined, progression01 + ":" + progression02 + ":" + progression03);
        }
        if(!GAValidator.validateEventPartLength(progression01, false)) {
            GALogger.w(("Validation fail - progression event - progression01: Cannot be (null), empty or above 64 characters. String: " + progression01));
            return new ValidationResult(EGASdkErrorCategory.EventValidation, EGASdkErrorArea.ProgressionEvent, EGASdkErrorAction.InvalidEventPartLength, EGASdkErrorParameter.Progression01, progression01);
        }
        if(!GAValidator.validateEventPartCharacters(progression01)) {
            GALogger.w(("Validation fail - progression event - progression01: Cannot contain other characters than A-z, 0-9, -_., ()!?. String: " + progression01));
            return new ValidationResult(EGASdkErrorCategory.EventValidation, EGASdkErrorArea.ProgressionEvent, EGASdkErrorAction.InvalidEventPartCharacters, EGASdkErrorParameter.Progression01, progression01);
        }
        if(!TextUtils.isEmpty(progression02)) {
            if(!GAValidator.validateEventPartLength(progression02, true)) {
                GALogger.w(("Validation fail - progression event - progression02: Cannot be empty or above 64 characters. String: " + progression02));
                return new ValidationResult(EGASdkErrorCategory.EventValidation, EGASdkErrorArea.ProgressionEvent, EGASdkErrorAction.InvalidEventPartLength, EGASdkErrorParameter.Progression02, progression02);
            }
            if(!GAValidator.validateEventPartCharacters(progression02)) {
                GALogger.w(("Validation fail - progression event - progression02: Cannot contain other characters than A-z, 0-9, -_., ()!?. String: " + progression02));
                return new ValidationResult(EGASdkErrorCategory.EventValidation, EGASdkErrorArea.ProgressionEvent, EGASdkErrorAction.InvalidEventPartCharacters, EGASdkErrorParameter.Progression02, progression02);
            }
        }
        if(!TextUtils.isEmpty(progression03)) {
            if(!GAValidator.validateEventPartLength(progression03, true)) {
                GALogger.w(("Validation fail - progression event - progression03: Cannot be empty or above 64 characters. String: " + progression03));
                return new ValidationResult(EGASdkErrorCategory.EventValidation, EGASdkErrorArea.ProgressionEvent, EGASdkErrorAction.InvalidEventPartLength, EGASdkErrorParameter.Progression03, progression03);
            }
            if(!GAValidator.validateEventPartCharacters(progression03)) {
                GALogger.w(("Validation fail - progression event - progression03: Cannot contain other characters than A-z, 0-9, -_., ()!?. String: " + progression03));
                return new ValidationResult(EGASdkErrorCategory.EventValidation, EGASdkErrorArea.ProgressionEvent, EGASdkErrorAction.InvalidEventPartCharacters, EGASdkErrorParameter.Progression03, progression03);
            }
        }
        return null;
    }

    public static boolean validateResourceCurrencies(String[] resourceCurrencies) {
        if(!GAValidator.validateArrayOfStrings(50L, 0x40L, false, "resource currencies", resourceCurrencies)) {
            return false;
        }
        for(int v = 0; v < resourceCurrencies.length; ++v) {
            String s = resourceCurrencies[v];
            if(!GAUtilities.stringMatch(s, "^[A-Za-z]+$")) {
                GALogger.w(("resource currencies validation failed: a resource currency can only be A-Z, a-z. String was: " + s));
                return false;
            }
        }
        return true;
    }

    public static ValidationResult validateResourceEvent(GAResourceFlowType flowType, String currency, long amount, String itemType, String itemId) {
        if(flowType.toString().length() == 0) {
            GALogger.w("Validation fail - resource event - flowType: Invalid flow type.");
            return new ValidationResult(EGASdkErrorCategory.EventValidation, EGASdkErrorArea.ResourceEvent, EGASdkErrorAction.InvalidFlowType, EGASdkErrorParameter.FlowType, "");
        }
        if(TextUtils.isEmpty(currency)) {
            GALogger.w("Validation fail - resource event - currency: Cannot be (null)");
            return new ValidationResult(EGASdkErrorCategory.EventValidation, EGASdkErrorArea.ResourceEvent, EGASdkErrorAction.StringEmptyOrNull, EGASdkErrorParameter.Currency, "");
        }
        if(!GAState.hasAvailableResourceCurrency(currency)) {
            GALogger.w(("Validation fail - resource event - currency: Not found in list of pre-defined available resource currencies. String: " + currency));
            return new ValidationResult(EGASdkErrorCategory.EventValidation, EGASdkErrorArea.ResourceEvent, EGASdkErrorAction.NotFoundInAvailableCurrencies, EGASdkErrorParameter.Currency, currency);
        }
        if(amount <= 0L) {
            GALogger.w(("Validation fail - resource event - amount: Float amount cannot be 0 or negative. Value: " + amount));
            return new ValidationResult(EGASdkErrorCategory.EventValidation, EGASdkErrorArea.ResourceEvent, EGASdkErrorAction.InvalidAmount, EGASdkErrorParameter.Amount, amount + "");
        }
        if(TextUtils.isEmpty(itemType)) {
            GALogger.w("Validation fail - resource event - itemType: Cannot be (null)");
            return new ValidationResult(EGASdkErrorCategory.EventValidation, EGASdkErrorArea.ResourceEvent, EGASdkErrorAction.StringEmptyOrNull, EGASdkErrorParameter.ItemType, "");
        }
        if(!GAValidator.validateEventPartLength(itemType, false)) {
            GALogger.w(("Validation fail - resource event - itemType: Cannot be (null), empty or above 64 characters. String: " + itemType));
            return new ValidationResult(EGASdkErrorCategory.EventValidation, EGASdkErrorArea.ResourceEvent, EGASdkErrorAction.InvalidEventPartLength, EGASdkErrorParameter.ItemType, itemType);
        }
        if(!GAValidator.validateEventPartCharacters(itemType)) {
            GALogger.w(("Validation fail - resource event - itemType: Cannot contain other characters than A-z, 0-9, -_., ()!?. String: " + itemType));
            return new ValidationResult(EGASdkErrorCategory.EventValidation, EGASdkErrorArea.ResourceEvent, EGASdkErrorAction.InvalidEventPartCharacters, EGASdkErrorParameter.ItemType, itemType);
        }
        if(!GAState.hasAvailableResourceItemType(itemType)) {
            GALogger.w(("Validation fail - resource event - itemType: Not found in list of pre-defined available resource itemTypes. String: " + itemType));
            return new ValidationResult(EGASdkErrorCategory.EventValidation, EGASdkErrorArea.ResourceEvent, EGASdkErrorAction.NotFoundInAvailableItemTypes, EGASdkErrorParameter.ItemType, itemType);
        }
        if(!GAValidator.validateEventPartLength(itemId, false)) {
            GALogger.w(("Validation fail - resource event - itemId: Cannot be (null), empty or above 64 characters. String: " + itemId));
            return new ValidationResult(EGASdkErrorCategory.EventValidation, EGASdkErrorArea.ResourceEvent, EGASdkErrorAction.InvalidEventPartLength, EGASdkErrorParameter.ItemId, itemId);
        }
        if(!GAValidator.validateEventPartCharacters(itemId)) {
            GALogger.w(("Validation fail - resource event - itemId: Cannot contain other characters than A-z, 0-9, -_., ()!?. String: " + itemId));
            return new ValidationResult(EGASdkErrorCategory.EventValidation, EGASdkErrorArea.ResourceEvent, EGASdkErrorAction.InvalidEventPartCharacters, EGASdkErrorParameter.ItemId, itemId);
        }
        return null;
    }

    public static boolean validateResourceItemTypes(String[] resourceItemTypes) {
        if(!GAValidator.validateArrayOfStrings(20L, 0x20L, false, "resource item types", resourceItemTypes)) {
            return false;
        }
        for(int v = 0; v < resourceItemTypes.length; ++v) {
            String s = resourceItemTypes[v];
            if(!GAValidator.validateEventPartCharacters(s)) {
                GALogger.w(("resource item types validation failed: a resource item type cannot contain other characters than A-z, 0-9, -_., ()!?. String was: " + s));
                return false;
            }
        }
        return true;
    }

    public static boolean validateSdkErrorEvent(String gameKey, String gameSecret, EGASdkErrorCategory category, EGASdkErrorArea area, EGASdkErrorAction action) {
        if(!GAValidator.validateKeys(gameKey, gameSecret)) {
            GALogger.w(("validateSdkErrorEvent failed. Game key or secret key is invalid. Can only contain characters A-z 0-9, gameKey is 32 length, gameSecret is 40 length. Failed keys - gameKey: " + gameKey + ", secretKey: " + gameSecret));
            return false;
        }
        if(category.toString().length() == 0) {
            GALogger.w("Validation fail - sdk error event - category: Category was unsupported value.");
            return false;
        }
        if(area.toString().length() == 0) {
            GALogger.w("Validation fail - sdk error event - area: Area was unsupported value.");
            return false;
        }
        if(action.toString().length() == 0) {
            GALogger.w("Validation fail - sdk error event - action: Action was unsupported value.");
            return false;
        }
        return true;
    }

    public static boolean validateSdkWrapperVersion(String wrapperVersion) {
        return GAUtilities.stringMatch(wrapperVersion, "^(unity|unreal|corona|marmalade|cocos2d|xamarin|lumberyard|air|gamemaker|defold|nativescript|cordova|construct|stencyl|godot|flutter) [0-9]{0,5}(\\.[0-9]{0,5}){0,2}(([a,b]{0,1})|(\\-alpha|\\-beta))$");
    }

    // 去混淆评级： 低(30)
    public static boolean validateShortString(String shortString, boolean canBeEmpty) {
        return !canBeEmpty || !TextUtils.isEmpty(shortString) ? !TextUtils.isEmpty(shortString) && shortString.length() <= 0x20 : true;
    }

    private static boolean validateStore(String store) {
        return GAUtilities.stringMatch(store, "^(apple|google_play)$");
    }

    // 去混淆评级： 低(30)
    public static boolean validateString(String string, boolean canBeEmpty) {
        return !canBeEmpty || !TextUtils.isEmpty(string) ? !TextUtils.isEmpty(string) && string.length() <= 0x40 : true;
    }

    public static boolean validateUserId(String uId) {
        if(!GAValidator.validateString(uId, false)) {
            GALogger.w("Validation fail - user id: id cannot be (null), empty or above 64 characters.");
            return false;
        }
        return true;
    }
}

