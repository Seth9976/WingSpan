package com.gameanalytics.sdk.events;

public enum EGASdkErrorAction {
    Undefined("", 0),
    InvalidCurrency("invalid_currency", 1),
    InvalidShortString("invalid_short_string", 2),
    InvalidEventPartLength("invalid_event_part_length", 3),
    InvalidEventPartCharacters("invalid_event_part_characters", 4),
    InvalidStore("invalid_store", 5),
    InvalidFlowType("invalid_flow_type", 6),
    StringEmptyOrNull("string_empty_or_null", 7),
    NotFoundInAvailableCurrencies("not_found_in_available_currencies", 8),
    InvalidAmount("invalid_amount", 9),
    NotFoundInAvailableItemTypes("not_found_in_available_item_types", 10),
    WrongProgressionOrder("wrong_progression_order", 11),
    InvalidEventIdLength("invalid_event_id_length", 12),
    InvalidEventIdCharacters("invalid_event_id_characters", 13),
    InvalidProgressionStatus("invalid_progression_status", 15),
    InvalidSeverity("invalid_severity", 16),
    InvalidLongString("invalid_long_string", 17),
    DatabaseTooLarge("db_too_large", 18),
    DatabaseOpenOrCreate("db_open_or_create", 19),
    SqlBegin("sql_begin", 20),
    SqlSetColumn("sql_set_column", 21),
    SqlRawQuery("sql_raw_query", 22),
    SqlCommit("sql_commit", 23),
    SqlRollback("sql_rollback", 24),
    JsonError("json_error", 25),
    FailHttp400("fail_http_400", 26),
    FailHttp401("fail_http_401", 27),
    FailHttp500("fail_http_500", 28),
    FailHttpJsonDecode("fail_http_json_decode", 29),
    FailHttpJsonEncode("fail_http_json_encode", 30),
    InvalidAdAction("invalid_ad_action", 0x1F),
    InvalidAdType("invalid_ad_type", 0x20),
    InvalidString("invalid_string", 33),
    InvalidAdNetworkName("invalid_ad_network", 34),
    ImpressionDataIsNull("impression_data_null", 35),
    InvalidAdNetworkVersion("invalid_ad_network_version", 36);

    private int id;
    private String value;

    private static EGASdkErrorAction[] $values() [...] // Inlined contents

    private EGASdkErrorAction(String value, int id) {
        this.value = value;
        this.id = id;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public static EGASdkErrorAction valueOf(int id) {
        EGASdkErrorAction[] arr_eGASdkErrorAction = EGASdkErrorAction.values();
        for(int v1 = 0; v1 < arr_eGASdkErrorAction.length; ++v1) {
            EGASdkErrorAction eGASdkErrorAction0 = arr_eGASdkErrorAction[v1];
            if(eGASdkErrorAction0.id == id) {
                return eGASdkErrorAction0;
            }
        }
        return EGASdkErrorAction.Undefined;
    }
}

