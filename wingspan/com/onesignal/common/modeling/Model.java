package com.onesignal.common.modeling;

import com.onesignal.common.events.EventProducer;
import com.onesignal.common.events.IEventNotifier;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u008C\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b)\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001D\u0012\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u0000\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u00A2\u0006\u0002\u0010\u0006J\u001E\u0010\u0018\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u00192\u0006\u0010\u001A\u001A\u00020\u00052\u0006\u0010\u001B\u001A\u00020\u001CH\u0014J\u001A\u0010\u001D\u001A\u0004\u0018\u00010\u00002\u0006\u0010\u001A\u001A\u00020\u00052\u0006\u0010\u001E\u001A\u00020\u001FH\u0014J\"\u0010 \u001A\u00020\u000B2\u0006\u0010!\u001A\u00020\u00052\u0010\b\u0002\u0010\"\u001A\n\u0012\u0004\u0012\u00020\u000B\u0018\u00010#H\u0004J\"\u0010$\u001A\u00020%2\u0006\u0010!\u001A\u00020\u00052\u0010\b\u0002\u0010\"\u001A\n\u0012\u0004\u0012\u00020%\u0018\u00010#H\u0004J\"\u0010&\u001A\u00020\u000F2\u0006\u0010!\u001A\u00020\u00052\u0010\b\u0002\u0010\"\u001A\n\u0012\u0004\u0012\u00020\u000F\u0018\u00010#H\u0004J\"\u0010\'\u001A\u00020(2\u0006\u0010!\u001A\u00020\u00052\u0010\b\u0002\u0010\"\u001A\n\u0012\u0004\u0012\u00020(\u0018\u00010#H\u0004J(\u0010)\u001A\u0002H*\"\u0010\b\u0000\u0010*\u0018\u0001*\b\u0012\u0004\u0012\u0002H*0+2\u0006\u0010!\u001A\u00020\u0005H\u0084\b\u00A2\u0006\u0002\u0010,J\"\u0010-\u001A\u00020.2\u0006\u0010!\u001A\u00020\u00052\u0010\b\u0002\u0010\"\u001A\n\u0012\u0004\u0012\u00020.\u0018\u00010#H\u0004J\"\u0010/\u001A\u0002002\u0006\u0010!\u001A\u00020\u00052\u0010\b\u0002\u0010\"\u001A\n\u0012\u0004\u0012\u000200\u0018\u00010#H\u0004J4\u00101\u001A\b\u0012\u0004\u0012\u0002H*0\u0019\"\u0004\b\u0000\u0010*2\u0006\u0010!\u001A\u00020\u00052\u0016\b\u0002\u0010\"\u001A\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H*0\u0019\u0018\u00010#H\u0004J\"\u00102\u001A\u0002032\u0006\u0010!\u001A\u00020\u00052\u0010\b\u0002\u0010\"\u001A\n\u0012\u0004\u0012\u000203\u0018\u00010#H\u0004J4\u00104\u001A\b\u0012\u0004\u0012\u0002H*05\"\u0004\b\u0000\u0010*2\u0006\u0010!\u001A\u00020\u00052\u0016\b\u0002\u0010\"\u001A\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H*05\u0018\u00010#H\u0004J&\u00106\u001A\u0004\u0018\u00010\u000B2\u0006\u0010!\u001A\u00020\u00052\u0012\b\u0002\u0010\"\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u000B\u0018\u00010#H\u0004J&\u00107\u001A\u0004\u0018\u00010%2\u0006\u0010!\u001A\u00020\u00052\u0012\b\u0002\u0010\"\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010%\u0018\u00010#H\u0004J+\u00108\u001A\u0004\u0018\u00010\u000F2\u0006\u0010!\u001A\u00020\u00052\u0012\b\u0002\u0010\"\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u000F\u0018\u00010#H\u0004\u00A2\u0006\u0002\u00109J+\u0010:\u001A\u0004\u0018\u00010(2\u0006\u0010!\u001A\u00020\u00052\u0012\b\u0002\u0010\"\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010(\u0018\u00010#H\u0004\u00A2\u0006\u0002\u0010;J*\u0010<\u001A\u0004\u0018\u0001H*\"\u0010\b\u0000\u0010*\u0018\u0001*\b\u0012\u0004\u0012\u0002H*0+2\u0006\u0010!\u001A\u00020\u0005H\u0084\b\u00A2\u0006\u0002\u0010,J+\u0010=\u001A\u0004\u0018\u00010.2\u0006\u0010!\u001A\u00020\u00052\u0012\b\u0002\u0010\"\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010.\u0018\u00010#H\u0004\u00A2\u0006\u0002\u0010>J+\u0010?\u001A\u0004\u0018\u0001002\u0006\u0010!\u001A\u00020\u00052\u0012\b\u0002\u0010\"\u001A\f\u0012\u0006\u0012\u0004\u0018\u000100\u0018\u00010#H\u0004\u00A2\u0006\u0002\u0010@J8\u0010A\u001A\n\u0012\u0004\u0012\u0002H*\u0018\u00010\u0019\"\u0004\b\u0000\u0010*2\u0006\u0010!\u001A\u00020\u00052\u0018\b\u0002\u0010\"\u001A\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u0002H*\u0018\u00010\u0019\u0018\u00010#H\u0004J+\u0010B\u001A\u0004\u0018\u0001032\u0006\u0010!\u001A\u00020\u00052\u0012\b\u0002\u0010\"\u001A\f\u0012\u0006\u0012\u0004\u0018\u000103\u0018\u00010#H\u0004\u00A2\u0006\u0002\u0010CJ8\u0010D\u001A\n\u0012\u0004\u0012\u0002H*\u0018\u000105\"\u0004\b\u0000\u0010*2\u0006\u0010!\u001A\u00020\u00052\u0018\b\u0002\u0010\"\u001A\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u0002H*\u0018\u000105\u0018\u00010#H\u0004J&\u0010E\u001A\u0004\u0018\u00010\u00052\u0006\u0010!\u001A\u00020\u00052\u0012\b\u0002\u0010\"\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010#H\u0004J\"\u0010F\u001A\u00020\u00052\u0006\u0010!\u001A\u00020\u00052\u0010\b\u0002\u0010\"\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010#H\u0004J\u000E\u0010G\u001A\u00020\u000F2\u0006\u0010!\u001A\u00020\u0005J\u000E\u0010H\u001A\u00020I2\u0006\u0010\u001E\u001A\u00020\u001FJ\u0018\u0010J\u001A\u00020I2\b\u0010\u0013\u001A\u0004\u0018\u00010\u00052\u0006\u0010K\u001A\u00020\u0000J4\u0010L\u001A\u00020I2\u0006\u0010M\u001A\u00020\u00052\u0006\u0010\u001A\u001A\u00020\u00052\u0006\u0010N\u001A\u00020\u00052\b\u0010O\u001A\u0004\u0018\u00010\u000B2\b\u0010P\u001A\u0004\u0018\u00010\u000BH\u0002J*\u0010Q\u001A\u00020I2\u0006\u0010!\u001A\u00020\u00052\u0006\u0010\u0012\u001A\u00020\u000B2\b\b\u0002\u0010N\u001A\u00020\u00052\b\b\u0002\u0010R\u001A\u00020\u000FJ*\u0010S\u001A\u00020I2\u0006\u0010!\u001A\u00020\u00052\u0006\u0010\u0012\u001A\u00020%2\b\b\u0002\u0010N\u001A\u00020\u00052\b\b\u0002\u0010R\u001A\u00020\u000FJ*\u0010T\u001A\u00020I2\u0006\u0010!\u001A\u00020\u00052\u0006\u0010\u0012\u001A\u00020\u000F2\b\b\u0002\u0010N\u001A\u00020\u00052\b\b\u0002\u0010R\u001A\u00020\u000FJ*\u0010U\u001A\u00020I2\u0006\u0010!\u001A\u00020\u00052\u0006\u0010\u0012\u001A\u00020(2\b\b\u0002\u0010N\u001A\u00020\u00052\b\b\u0002\u0010R\u001A\u00020\u000FJD\u0010V\u001A\u00020I\"\u0010\b\u0000\u0010*\u0018\u0001*\b\u0012\u0004\u0012\u0002H*0+2\u0006\u0010!\u001A\u00020\u00052\u0006\u0010\u0012\u001A\u0002H*2\b\b\u0002\u0010N\u001A\u00020\u00052\b\b\u0002\u0010R\u001A\u00020\u000FH\u0086\b\u00A2\u0006\u0002\u0010WJ*\u0010X\u001A\u00020I2\u0006\u0010!\u001A\u00020\u00052\u0006\u0010\u0012\u001A\u00020.2\b\b\u0002\u0010N\u001A\u00020\u00052\b\b\u0002\u0010R\u001A\u00020\u000FJ*\u0010Y\u001A\u00020I2\u0006\u0010!\u001A\u00020\u00052\u0006\u0010\u0012\u001A\u0002002\b\b\u0002\u0010N\u001A\u00020\u00052\b\b\u0002\u0010R\u001A\u00020\u000FJ6\u0010Z\u001A\u00020I\"\u0004\b\u0000\u0010*2\u0006\u0010!\u001A\u00020\u00052\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u0002H*0\u00192\b\b\u0002\u0010N\u001A\u00020\u00052\b\b\u0002\u0010R\u001A\u00020\u000FJ*\u0010[\u001A\u00020I2\u0006\u0010!\u001A\u00020\u00052\u0006\u0010\u0012\u001A\u0002032\b\b\u0002\u0010N\u001A\u00020\u00052\b\b\u0002\u0010R\u001A\u00020\u000FJ6\u0010\\\u001A\u00020I\"\u0004\b\u0000\u0010*2\u0006\u0010!\u001A\u00020\u00052\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u0002H*052\b\b\u0002\u0010N\u001A\u00020\u00052\b\b\u0002\u0010R\u001A\u00020\u000FJ,\u0010]\u001A\u00020I2\u0006\u0010!\u001A\u00020\u00052\b\u0010\u0012\u001A\u0004\u0018\u00010\u000B2\b\b\u0002\u0010N\u001A\u00020\u00052\b\b\u0002\u0010R\u001A\u00020\u000FJ,\u0010^\u001A\u00020I2\u0006\u0010!\u001A\u00020\u00052\b\u0010\u0012\u001A\u0004\u0018\u00010%2\b\b\u0002\u0010N\u001A\u00020\u00052\b\b\u0002\u0010R\u001A\u00020\u000FJ1\u0010_\u001A\u00020I2\u0006\u0010!\u001A\u00020\u00052\b\u0010\u0012\u001A\u0004\u0018\u00010\u000F2\b\b\u0002\u0010N\u001A\u00020\u00052\b\b\u0002\u0010R\u001A\u00020\u000F\u00A2\u0006\u0002\u0010`J1\u0010a\u001A\u00020I2\u0006\u0010!\u001A\u00020\u00052\b\u0010\u0012\u001A\u0004\u0018\u00010(2\b\b\u0002\u0010N\u001A\u00020\u00052\b\b\u0002\u0010R\u001A\u00020\u000F\u00A2\u0006\u0002\u0010bJF\u0010c\u001A\u00020I\"\u0010\b\u0000\u0010*\u0018\u0001*\b\u0012\u0004\u0012\u0002H*0+2\u0006\u0010!\u001A\u00020\u00052\b\u0010\u0012\u001A\u0004\u0018\u0001H*2\b\b\u0002\u0010N\u001A\u00020\u00052\b\b\u0002\u0010R\u001A\u00020\u000FH\u0086\b\u00A2\u0006\u0002\u0010WJ1\u0010d\u001A\u00020I2\u0006\u0010!\u001A\u00020\u00052\b\u0010\u0012\u001A\u0004\u0018\u00010.2\b\b\u0002\u0010N\u001A\u00020\u00052\b\b\u0002\u0010R\u001A\u00020\u000F\u00A2\u0006\u0002\u0010eJ1\u0010f\u001A\u00020I2\u0006\u0010!\u001A\u00020\u00052\b\u0010\u0012\u001A\u0004\u0018\u0001002\b\b\u0002\u0010N\u001A\u00020\u00052\b\b\u0002\u0010R\u001A\u00020\u000F\u00A2\u0006\u0002\u0010gJ8\u0010h\u001A\u00020I\"\u0004\b\u0000\u0010*2\u0006\u0010!\u001A\u00020\u00052\u000E\u0010\u0012\u001A\n\u0012\u0004\u0012\u0002H*\u0018\u00010\u00192\b\b\u0002\u0010N\u001A\u00020\u00052\b\b\u0002\u0010R\u001A\u00020\u000FJ1\u0010i\u001A\u00020I2\u0006\u0010!\u001A\u00020\u00052\b\u0010\u0012\u001A\u0004\u0018\u0001032\b\b\u0002\u0010N\u001A\u00020\u00052\b\b\u0002\u0010R\u001A\u00020\u000F\u00A2\u0006\u0002\u0010jJ8\u0010k\u001A\u00020I\"\u0004\b\u0000\u0010*2\u0006\u0010!\u001A\u00020\u00052\u000E\u0010\u0012\u001A\n\u0012\u0004\u0012\u0002H*\u0018\u0001052\b\b\u0002\u0010N\u001A\u00020\u00052\b\b\u0002\u0010R\u001A\u00020\u000FJ,\u0010l\u001A\u00020I2\u0006\u0010!\u001A\u00020\u00052\b\u0010\u0012\u001A\u0004\u0018\u00010\u00052\b\b\u0002\u0010N\u001A\u00020\u00052\b\b\u0002\u0010R\u001A\u00020\u000FJ*\u0010m\u001A\u00020I2\u0006\u0010!\u001A\u00020\u00052\u0006\u0010\u0012\u001A\u00020\u00052\b\b\u0002\u0010N\u001A\u00020\u00052\b\b\u0002\u0010R\u001A\u00020\u000FJ\u0010\u0010n\u001A\u00020I2\u0006\u0010o\u001A\u00020\u0002H\u0016J\u0006\u0010p\u001A\u00020\u001FJ\u0010\u0010q\u001A\u00020I2\u0006\u0010o\u001A\u00020\u0002H\u0016R\u0010\u0010\u0003\u001A\u0004\u0018\u00010\u0000X\u0082\u000E\u00A2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00020\bX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\"\u0010\t\u001A\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\nX\u0084\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0014\u0010\u000E\u001A\u00020\u000F8VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001A\u00020\u00052\u0006\u0010\u0012\u001A\u00020\u00058F@FX\u0086\u000E\u00A2\u0006\f\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00A8\u0006r"}, d2 = {"Lcom/onesignal/common/modeling/Model;", "Lcom/onesignal/common/events/IEventNotifier;", "Lcom/onesignal/common/modeling/IModelChangedHandler;", "_parentModel", "_parentProperty", "", "(Lcom/onesignal/common/modeling/Model;Ljava/lang/String;)V", "changeNotifier", "Lcom/onesignal/common/events/EventProducer;", "data", "", "", "getData", "()Ljava/util/Map;", "hasSubscribers", "", "getHasSubscribers", "()Z", "value", "id", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "createListForProperty", "", "property", "jsonArray", "Lorg/json/JSONArray;", "createModelForProperty", "jsonObject", "Lorg/json/JSONObject;", "getAnyProperty", "name", "create", "Lkotlin/Function0;", "getBigDecimalProperty", "Ljava/math/BigDecimal;", "getBooleanProperty", "getDoubleProperty", "", "getEnumProperty", "T", "", "(Ljava/lang/String;)Ljava/lang/Enum;", "getFloatProperty", "", "getIntProperty", "", "getListProperty", "getLongProperty", "", "getMapModelProperty", "Lcom/onesignal/common/modeling/MapModel;", "getOptAnyProperty", "getOptBigDecimalProperty", "getOptBooleanProperty", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Boolean;", "getOptDoubleProperty", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Double;", "getOptEnumProperty", "getOptFloatProperty", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Float;", "getOptIntProperty", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Integer;", "getOptListProperty", "getOptLongProperty", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Long;", "getOptMapModelProperty", "getOptStringProperty", "getStringProperty", "hasProperty", "initializeFromJson", "", "initializeFromModel", "model", "notifyChanged", "path", "tag", "oldValue", "newValue", "setAnyProperty", "forceChange", "setBigDecimalProperty", "setBooleanProperty", "setDoubleProperty", "setEnumProperty", "(Ljava/lang/String;Ljava/lang/Enum;Ljava/lang/String;Z)V", "setFloatProperty", "setIntProperty", "setListProperty", "setLongProperty", "setMapModelProperty", "setOptAnyProperty", "setOptBigDecimalProperty", "setOptBooleanProperty", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Z)V", "setOptDoubleProperty", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Z)V", "setOptEnumProperty", "setOptFloatProperty", "(Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Z)V", "setOptIntProperty", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Z)V", "setOptListProperty", "setOptLongProperty", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Z)V", "setOptMapModelProperty", "setOptStringProperty", "setStringProperty", "subscribe", "handler", "toJSON", "unsubscribe", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public class Model implements IEventNotifier {
    private Model _parentModel;
    private final String _parentProperty;
    private final EventProducer changeNotifier;
    private final Map data;

    public Model() {
        this(null, null, 3, null);
    }

    public Model(Model model0, String s) {
        this._parentModel = model0;
        this._parentProperty = s;
        Map map0 = Collections.synchronizedMap(new LinkedHashMap());
        Intrinsics.checkNotNullExpressionValue(map0, "synchronizedMap(mutableMapOf())");
        this.data = map0;
        this.changeNotifier = new EventProducer();
        Model model1 = this._parentModel;
        if(model1 != null && s == null) {
            throw new Exception("If parent model is set, parent property must also be set.");
        }
        if(model1 == null && s != null) {
            throw new Exception("If parent property is set, parent model must also be set.");
        }
    }

    public Model(Model model0, String s, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            model0 = null;
        }
        if((v & 2) != 0) {
            s = null;
        }
        this(model0, s);
    }

    protected List createListForProperty(String s, JSONArray jSONArray0) {
        Intrinsics.checkNotNullParameter(s, "property");
        Intrinsics.checkNotNullParameter(jSONArray0, "jsonArray");
        return null;
    }

    protected Model createModelForProperty(String s, JSONObject jSONObject0) {
        Intrinsics.checkNotNullParameter(s, "property");
        Intrinsics.checkNotNullParameter(jSONObject0, "jsonObject");
        return null;
    }

    protected final Object getAnyProperty(String s, Function0 function00) {
        Intrinsics.checkNotNullParameter(s, "name");
        Object object0 = this.getOptAnyProperty(s, function00);
        Intrinsics.checkNotNull(object0, "null cannot be cast to non-null type kotlin.Any");
        return object0;
    }

    public static Object getAnyProperty$default(Model model0, String s, Function0 function00, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAnyProperty");
        }
        if((v & 2) != 0) {
            function00 = null;
        }
        return model0.getAnyProperty(s, function00);
    }

    protected final BigDecimal getBigDecimalProperty(String s, Function0 function00) {
        Intrinsics.checkNotNullParameter(s, "name");
        BigDecimal bigDecimal0 = this.getOptBigDecimalProperty(s, function00);
        Intrinsics.checkNotNull(bigDecimal0, "null cannot be cast to non-null type java.math.BigDecimal");
        return bigDecimal0;
    }

    public static BigDecimal getBigDecimalProperty$default(Model model0, String s, Function0 function00, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBigDecimalProperty");
        }
        if((v & 2) != 0) {
            function00 = null;
        }
        return model0.getBigDecimalProperty(s, function00);
    }

    protected final boolean getBooleanProperty(String s, Function0 function00) {
        Intrinsics.checkNotNullParameter(s, "name");
        Boolean boolean0 = this.getOptBooleanProperty(s, function00);
        Intrinsics.checkNotNull(boolean0, "null cannot be cast to non-null type kotlin.Boolean");
        return boolean0.booleanValue();
    }

    public static boolean getBooleanProperty$default(Model model0, String s, Function0 function00, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBooleanProperty");
        }
        if((v & 2) != 0) {
            function00 = null;
        }
        return model0.getBooleanProperty(s, function00);
    }

    protected final Map getData() {
        return this.data;
    }

    protected final double getDoubleProperty(String s, Function0 function00) {
        Intrinsics.checkNotNullParameter(s, "name");
        Double double0 = this.getOptDoubleProperty(s, function00);
        Intrinsics.checkNotNull(double0, "null cannot be cast to non-null type kotlin.Double");
        return (double)double0;
    }

    public static double getDoubleProperty$default(Model model0, String s, Function0 function00, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getDoubleProperty");
        }
        if((v & 2) != 0) {
            function00 = null;
        }
        return model0.getDoubleProperty(s, function00);
    }

    protected final Enum getEnumProperty(String s) {
        Intrinsics.checkNotNullParameter(s, "name");
        Enum enum0 = null;
        Object object0 = Model.getOptAnyProperty$default(this, s, null, 2, null);
        if(object0 != null) {
            Intrinsics.reifiedOperationMarker(3, "T");
            if(object0 instanceof Enum) {
                enum0 = (Enum)object0;
            }
            else if(object0 instanceof String) {
                Intrinsics.reifiedOperationMarker(5, "T");
                enum0 = Enum.valueOf(null, ((String)object0));
            }
            else {
                Intrinsics.reifiedOperationMarker(1, "T");
                enum0 = (Enum)object0;
            }
        }
        Intrinsics.reifiedOperationMarker(1, "T");
        return enum0;
    }

    protected final float getFloatProperty(String s, Function0 function00) {
        Intrinsics.checkNotNullParameter(s, "name");
        Float float0 = this.getOptFloatProperty(s, function00);
        Intrinsics.checkNotNull(float0, "null cannot be cast to non-null type kotlin.Float");
        return (float)float0;
    }

    public static float getFloatProperty$default(Model model0, String s, Function0 function00, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getFloatProperty");
        }
        if((v & 2) != 0) {
            function00 = null;
        }
        return model0.getFloatProperty(s, function00);
    }

    @Override  // com.onesignal.common.events.IEventNotifier
    public boolean getHasSubscribers() {
        return this.changeNotifier.getHasSubscribers();
    }

    public final String getId() {
        return Model.getStringProperty$default(this, "id", null, 2, null);
    }

    protected final int getIntProperty(String s, Function0 function00) {
        Intrinsics.checkNotNullParameter(s, "name");
        Integer integer0 = this.getOptIntProperty(s, function00);
        Intrinsics.checkNotNull(integer0, "null cannot be cast to non-null type kotlin.Int");
        return (int)integer0;
    }

    public static int getIntProperty$default(Model model0, String s, Function0 function00, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getIntProperty");
        }
        if((v & 2) != 0) {
            function00 = null;
        }
        return model0.getIntProperty(s, function00);
    }

    protected final List getListProperty(String s, Function0 function00) {
        Intrinsics.checkNotNullParameter(s, "name");
        List list0 = this.getOptListProperty(s, function00);
        Intrinsics.checkNotNull(list0, "null cannot be cast to non-null type kotlin.collections.List<T of com.onesignal.common.modeling.Model.getListProperty>");
        return list0;
    }

    public static List getListProperty$default(Model model0, String s, Function0 function00, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getListProperty");
        }
        if((v & 2) != 0) {
            function00 = null;
        }
        return model0.getListProperty(s, function00);
    }

    protected final long getLongProperty(String s, Function0 function00) {
        Intrinsics.checkNotNullParameter(s, "name");
        Long long0 = this.getOptLongProperty(s, function00);
        Intrinsics.checkNotNull(long0, "null cannot be cast to non-null type kotlin.Long");
        return (long)long0;
    }

    public static long getLongProperty$default(Model model0, String s, Function0 function00, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLongProperty");
        }
        if((v & 2) != 0) {
            function00 = null;
        }
        return model0.getLongProperty(s, function00);
    }

    protected final MapModel getMapModelProperty(String s, Function0 function00) {
        Intrinsics.checkNotNullParameter(s, "name");
        MapModel mapModel0 = this.getOptMapModelProperty(s, function00);
        Intrinsics.checkNotNull(mapModel0, "null cannot be cast to non-null type com.onesignal.common.modeling.MapModel<T of com.onesignal.common.modeling.Model.getMapModelProperty>");
        return mapModel0;
    }

    public static MapModel getMapModelProperty$default(Model model0, String s, Function0 function00, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMapModelProperty");
        }
        if((v & 2) != 0) {
            function00 = null;
        }
        return model0.getMapModelProperty(s, function00);
    }

    protected final Object getOptAnyProperty(String s, Function0 function00) {
        Object object0;
        Intrinsics.checkNotNullParameter(s, "name");
        synchronized(this.data) {
            if(this.data.containsKey(s) || function00 == null) {
                object0 = this.data.get(s);
            }
            else {
                object0 = function00.invoke();
                this.data.put(s, object0);
            }
            return object0;
        }
    }

    public static Object getOptAnyProperty$default(Model model0, String s, Function0 function00, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOptAnyProperty");
        }
        if((v & 2) != 0) {
            function00 = null;
        }
        return model0.getOptAnyProperty(s, function00);
    }

    protected final BigDecimal getOptBigDecimalProperty(String s, Function0 function00) {
        Intrinsics.checkNotNullParameter(s, "name");
        Object object0 = this.getOptAnyProperty(s, function00);
        if(object0 == null) {
            return null;
        }
        if(object0 instanceof Integer) {
            return new BigDecimal(((Number)object0).intValue());
        }
        if(object0 instanceof Long) {
            return new BigDecimal(((Number)object0).longValue());
        }
        if(object0 instanceof Float) {
            return new BigDecimal(((double)((Number)object0).floatValue()));
        }
        if(object0 instanceof Double) {
            return new BigDecimal(((Number)object0).doubleValue());
        }
        return object0 instanceof String ? new BigDecimal(((String)object0)) : ((BigDecimal)object0);
    }

    public static BigDecimal getOptBigDecimalProperty$default(Model model0, String s, Function0 function00, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOptBigDecimalProperty");
        }
        if((v & 2) != 0) {
            function00 = null;
        }
        return model0.getOptBigDecimalProperty(s, function00);
    }

    protected final Boolean getOptBooleanProperty(String s, Function0 function00) {
        Intrinsics.checkNotNullParameter(s, "name");
        return (Boolean)this.getOptAnyProperty(s, function00);
    }

    public static Boolean getOptBooleanProperty$default(Model model0, String s, Function0 function00, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOptBooleanProperty");
        }
        if((v & 2) != 0) {
            function00 = null;
        }
        return model0.getOptBooleanProperty(s, function00);
    }

    protected final Double getOptDoubleProperty(String s, Function0 function00) {
        Intrinsics.checkNotNullParameter(s, "name");
        Object object0 = this.getOptAnyProperty(s, function00);
        if(object0 == null) {
            return null;
        }
        if(object0 instanceof Double) {
            return (Double)object0;
        }
        if(object0 instanceof Float) {
            return (double)((Number)object0).floatValue();
        }
        if(object0 instanceof Integer) {
            return (double)((Number)object0).intValue();
        }
        return object0 instanceof Long ? ((double)((Number)object0).longValue()) : ((Double)object0);
    }

    public static Double getOptDoubleProperty$default(Model model0, String s, Function0 function00, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOptDoubleProperty");
        }
        if((v & 2) != 0) {
            function00 = null;
        }
        return model0.getOptDoubleProperty(s, function00);
    }

    protected final Enum getOptEnumProperty(String s) {
        Intrinsics.checkNotNullParameter(s, "name");
        Object object0 = Model.getOptAnyProperty$default(this, s, null, 2, null);
        if(object0 == null) {
            return null;
        }
        Intrinsics.reifiedOperationMarker(3, "T");
        if(object0 instanceof Enum) {
            return (Enum)object0;
        }
        if(object0 instanceof String) {
            Intrinsics.reifiedOperationMarker(5, "T");
            return Enum.valueOf(null, ((String)object0));
        }
        Intrinsics.reifiedOperationMarker(1, "T");
        return (Enum)object0;
    }

    protected final Float getOptFloatProperty(String s, Function0 function00) {
        Intrinsics.checkNotNullParameter(s, "name");
        Object object0 = this.getOptAnyProperty(s, function00);
        if(object0 == null) {
            return null;
        }
        if(object0 instanceof Float) {
            return (Float)object0;
        }
        if(object0 instanceof Double) {
            return (float)((Number)object0).doubleValue();
        }
        if(object0 instanceof Integer) {
            return (float)((Number)object0).intValue();
        }
        return object0 instanceof Long ? ((float)((Number)object0).longValue()) : ((Float)object0);
    }

    public static Float getOptFloatProperty$default(Model model0, String s, Function0 function00, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOptFloatProperty");
        }
        if((v & 2) != 0) {
            function00 = null;
        }
        return model0.getOptFloatProperty(s, function00);
    }

    protected final Integer getOptIntProperty(String s, Function0 function00) {
        Intrinsics.checkNotNullParameter(s, "name");
        Object object0 = this.getOptAnyProperty(s, function00);
        if(object0 == null) {
            return null;
        }
        if(object0 instanceof Integer) {
            return (Integer)object0;
        }
        if(object0 instanceof Long) {
            return (int)((Number)object0).longValue();
        }
        if(object0 instanceof Float) {
            return (int)((Number)object0).floatValue();
        }
        return object0 instanceof Double ? ((int)((Number)object0).doubleValue()) : ((Integer)object0);
    }

    public static Integer getOptIntProperty$default(Model model0, String s, Function0 function00, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOptIntProperty");
        }
        if((v & 2) != 0) {
            function00 = null;
        }
        return model0.getOptIntProperty(s, function00);
    }

    protected final List getOptListProperty(String s, Function0 function00) {
        Intrinsics.checkNotNullParameter(s, "name");
        return (List)this.getOptAnyProperty(s, function00);
    }

    public static List getOptListProperty$default(Model model0, String s, Function0 function00, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOptListProperty");
        }
        if((v & 2) != 0) {
            function00 = null;
        }
        return model0.getOptListProperty(s, function00);
    }

    protected final Long getOptLongProperty(String s, Function0 function00) {
        Intrinsics.checkNotNullParameter(s, "name");
        Object object0 = this.getOptAnyProperty(s, function00);
        if(object0 == null) {
            return null;
        }
        if(object0 instanceof Long) {
            return (Long)object0;
        }
        if(object0 instanceof Integer) {
            return (long)((Number)object0).intValue();
        }
        if(object0 instanceof Float) {
            return (long)((Number)object0).floatValue();
        }
        return object0 instanceof Double ? ((long)((Number)object0).doubleValue()) : ((Long)object0);
    }

    public static Long getOptLongProperty$default(Model model0, String s, Function0 function00, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOptLongProperty");
        }
        if((v & 2) != 0) {
            function00 = null;
        }
        return model0.getOptLongProperty(s, function00);
    }

    protected final MapModel getOptMapModelProperty(String s, Function0 function00) {
        Intrinsics.checkNotNullParameter(s, "name");
        return (MapModel)this.getOptAnyProperty(s, function00);
    }

    public static MapModel getOptMapModelProperty$default(Model model0, String s, Function0 function00, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOptMapModelProperty");
        }
        if((v & 2) != 0) {
            function00 = null;
        }
        return model0.getOptMapModelProperty(s, function00);
    }

    protected final String getOptStringProperty(String s, Function0 function00) {
        Intrinsics.checkNotNullParameter(s, "name");
        return (String)this.getOptAnyProperty(s, function00);
    }

    public static String getOptStringProperty$default(Model model0, String s, Function0 function00, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOptStringProperty");
        }
        if((v & 2) != 0) {
            function00 = null;
        }
        return model0.getOptStringProperty(s, function00);
    }

    protected final String getStringProperty(String s, Function0 function00) {
        Intrinsics.checkNotNullParameter(s, "name");
        String s1 = this.getOptStringProperty(s, function00);
        Intrinsics.checkNotNull(s1, "null cannot be cast to non-null type kotlin.String");
        return s1;
    }

    public static String getStringProperty$default(Model model0, String s, Function0 function00, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getStringProperty");
        }
        if((v & 2) != 0) {
            function00 = null;
        }
        return model0.getStringProperty(s, function00);
    }

    public final boolean hasProperty(String s) {
        Intrinsics.checkNotNullParameter(s, "name");
        return this.data.containsKey(s);
    }

    public final void initializeFromJson(JSONObject jSONObject0) {
        boolean z1;
        boolean z;
        Object object2;
        Intrinsics.checkNotNullParameter(jSONObject0, "jsonObject");
        synchronized(this.data) {
            this.data.clear();
            Iterator iterator0 = jSONObject0.keys();
            Intrinsics.checkNotNullExpressionValue(iterator0, "jsonObject.keys()");
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                String s = (String)object0;
                Object object1 = jSONObject0.get(s);
                if(object1 instanceof JSONObject) {
                    Intrinsics.checkNotNullExpressionValue(s, "property");
                    Model model0 = this.createModelForProperty(s, ((JSONObject)object1));
                    if(model0 == null) {
                        continue;
                    }
                    this.data.put(s, model0);
                }
                else if(object1 instanceof JSONArray) {
                    Intrinsics.checkNotNullExpressionValue(s, "property");
                    List list0 = this.createListForProperty(s, ((JSONArray)object1));
                    if(list0 == null) {
                        continue;
                    }
                    this.data.put(s, list0);
                }
                else {
                    Method[] arr_method = this.getClass().getMethods();
                    Intrinsics.checkNotNullExpressionValue(arr_method, "this.javaClass.methods");
                    Object[] arr_object = arr_method;
                    int v1 = 0;
                    while(true) {
                        object2 = null;
                        z = true;
                        if(v1 < arr_object.length) {
                            object2 = arr_object[v1];
                            Method method0 = (Method)object2;
                            if(Intrinsics.areEqual(method0.getReturnType(), Void.class)) {
                                z1 = false;
                            }
                            else {
                                String s1 = method0.getName();
                                Intrinsics.checkNotNullExpressionValue(s1, "it.name");
                                Intrinsics.checkNotNullExpressionValue(s, "property");
                                if(StringsKt.contains(s1, s, true)) {
                                    z1 = true;
                                }
                            }
                            if(!z1) {
                                ++v1;
                                continue;
                            }
                        }
                        break;
                    }
                    if(((Method)object2) == null) {
                        Intrinsics.checkNotNullExpressionValue(s, "property");
                        Object object3 = jSONObject0.get(s);
                        this.data.put(s, object3);
                    }
                    else {
                        Class class0 = ((Method)object2).getReturnType();
                        if((Intrinsics.areEqual(class0, Double.TYPE) ? true : Intrinsics.areEqual(class0, Double.class))) {
                            Intrinsics.checkNotNullExpressionValue(s, "property");
                            Double double0 = jSONObject0.getDouble(s);
                            this.data.put(s, double0);
                        }
                        else if((Intrinsics.areEqual(class0, Long.TYPE) ? true : Intrinsics.areEqual(class0, Long.class))) {
                            Intrinsics.checkNotNullExpressionValue(s, "property");
                            Long long0 = jSONObject0.getLong(s);
                            this.data.put(s, long0);
                        }
                        else if((Intrinsics.areEqual(class0, Float.TYPE) ? true : Intrinsics.areEqual(class0, Float.class))) {
                            Intrinsics.checkNotNullExpressionValue(s, "property");
                            Float float0 = (float)jSONObject0.getDouble(s);
                            this.data.put(s, float0);
                        }
                        else if((Intrinsics.areEqual(class0, Integer.TYPE) ? true : Intrinsics.areEqual(class0, Integer.class))) {
                            Intrinsics.checkNotNullExpressionValue(s, "property");
                            Integer integer0 = jSONObject0.getInt(s);
                            this.data.put(s, integer0);
                        }
                        else if((Intrinsics.areEqual(class0, Boolean.TYPE) ? true : Intrinsics.areEqual(class0, Boolean.class))) {
                            Intrinsics.checkNotNullExpressionValue(s, "property");
                            Boolean boolean0 = Boolean.valueOf(jSONObject0.getBoolean(s));
                            this.data.put(s, boolean0);
                        }
                        else {
                            if(!Intrinsics.areEqual(class0, String.class)) {
                                z = Intrinsics.areEqual(class0, String.class);
                            }
                            if(z) {
                                Intrinsics.checkNotNullExpressionValue(s, "property");
                                String s2 = jSONObject0.getString(s);
                                this.data.put(s, s2);
                            }
                            else {
                                Intrinsics.checkNotNullExpressionValue(s, "property");
                                Object object4 = jSONObject0.get(s);
                                this.data.put(s, object4);
                            }
                        }
                    }
                }
            }
        }
    }

    public final void initializeFromModel(String s, Model model0) {
        Intrinsics.checkNotNullParameter(model0, "model");
        Map map0 = Collections.synchronizedMap(new LinkedHashMap());
        for(Object object0: model0.data.entrySet()) {
            Map.Entry map$Entry0 = (Map.Entry)object0;
            if(map$Entry0.getValue() instanceof Model) {
                Object object1 = map$Entry0.getValue();
                Intrinsics.checkNotNull(object1, "null cannot be cast to non-null type com.onesignal.common.modeling.Model");
                ((Model)object1)._parentModel = this;
                Intrinsics.checkNotNullExpressionValue(map0, "newData");
                map0.put(map$Entry0.getKey(), ((Model)object1));
            }
            else {
                Intrinsics.checkNotNullExpressionValue(map0, "newData");
                map0.put(map$Entry0.getKey(), map$Entry0.getValue());
            }
        }
        if(s != null) {
            Intrinsics.checkNotNullExpressionValue(map0, "newData");
            map0.put("id", s);
        }
        synchronized(this.data) {
            this.data.clear();
            Intrinsics.checkNotNullExpressionValue(map0, "newData");
            this.data.putAll(map0);
        }
    }

    private final void notifyChanged(String s, String s1, String s2, Object object0, Object object1) {
        Function1 function10 = new Function1(s2) {
            final ModelChangedArgs $changeArgs;
            final String $tag;

            {
                this.$changeArgs = modelChangedArgs0;
                this.$tag = s;
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                this.invoke(((IModelChangedHandler)object0));
                return Unit.INSTANCE;
            }

            public final void invoke(IModelChangedHandler iModelChangedHandler0) {
                Intrinsics.checkNotNullParameter(iModelChangedHandler0, "it");
                iModelChangedHandler0.onChanged(this.$changeArgs, this.$tag);
            }
        };
        this.changeNotifier.fire(function10);
        if(this._parentModel != null) {
            Model model0 = this._parentModel;
            Intrinsics.checkNotNull(model0);
            model0.notifyChanged(this._parentProperty + '.' + s, s1, s2, object0, object1);
        }
    }

    public final void setAnyProperty(String s, Object object0, String s1, boolean z) {
        Intrinsics.checkNotNullParameter(s, "name");
        Intrinsics.checkNotNullParameter(object0, "value");
        Intrinsics.checkNotNullParameter(s1, "tag");
        this.setOptAnyProperty(s, object0, s1, z);
    }

    public static void setAnyProperty$default(Model model0, String s, Object object0, String s1, boolean z, int v, Object object1) {
        if(object1 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setAnyProperty");
        }
        if((v & 4) != 0) {
            s1 = "NORMAL";
        }
        if((v & 8) != 0) {
            z = false;
        }
        model0.setAnyProperty(s, object0, s1, z);
    }

    public final void setBigDecimalProperty(String s, BigDecimal bigDecimal0, String s1, boolean z) {
        Intrinsics.checkNotNullParameter(s, "name");
        Intrinsics.checkNotNullParameter(bigDecimal0, "value");
        Intrinsics.checkNotNullParameter(s1, "tag");
        this.setOptBigDecimalProperty(s, bigDecimal0, s1, z);
    }

    public static void setBigDecimalProperty$default(Model model0, String s, BigDecimal bigDecimal0, String s1, boolean z, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setBigDecimalProperty");
        }
        if((v & 4) != 0) {
            s1 = "NORMAL";
        }
        if((v & 8) != 0) {
            z = false;
        }
        model0.setBigDecimalProperty(s, bigDecimal0, s1, z);
    }

    public final void setBooleanProperty(String s, boolean z, String s1, boolean z1) {
        Intrinsics.checkNotNullParameter(s, "name");
        Intrinsics.checkNotNullParameter(s1, "tag");
        this.setOptBooleanProperty(s, Boolean.valueOf(z), s1, z1);
    }

    public static void setBooleanProperty$default(Model model0, String s, boolean z, String s1, boolean z1, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setBooleanProperty");
        }
        if((v & 4) != 0) {
            s1 = "NORMAL";
        }
        if((v & 8) != 0) {
            z1 = false;
        }
        model0.setBooleanProperty(s, z, s1, z1);
    }

    public final void setDoubleProperty(String s, double f, String s1, boolean z) {
        Intrinsics.checkNotNullParameter(s, "name");
        Intrinsics.checkNotNullParameter(s1, "tag");
        this.setOptDoubleProperty(s, f, s1, z);
    }

    public static void setDoubleProperty$default(Model model0, String s, double f, String s1, boolean z, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setDoubleProperty");
        }
        if((v & 4) != 0) {
            s1 = "NORMAL";
        }
        if((v & 8) != 0) {
            z = false;
        }
        model0.setDoubleProperty(s, f, s1, z);
    }

    public final void setEnumProperty(String s, Enum enum0, String s1, boolean z) {
        Intrinsics.checkNotNullParameter(s, "name");
        Intrinsics.checkNotNullParameter(enum0, "value");
        Intrinsics.checkNotNullParameter(s1, "tag");
        this.setOptAnyProperty(s, enum0.toString(), s1, z);
    }

    public static void setEnumProperty$default(Model model0, String s, Enum enum0, String s1, boolean z, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setEnumProperty");
        }
        if((v & 4) != 0) {
            s1 = "NORMAL";
        }
        if((v & 8) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(s, "name");
        Intrinsics.checkNotNullParameter(enum0, "value");
        Intrinsics.checkNotNullParameter(s1, "tag");
        model0.setOptAnyProperty(s, enum0.toString(), s1, z);
    }

    public final void setFloatProperty(String s, float f, String s1, boolean z) {
        Intrinsics.checkNotNullParameter(s, "name");
        Intrinsics.checkNotNullParameter(s1, "tag");
        this.setOptFloatProperty(s, f, s1, z);
    }

    public static void setFloatProperty$default(Model model0, String s, float f, String s1, boolean z, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setFloatProperty");
        }
        if((v & 4) != 0) {
            s1 = "NORMAL";
        }
        if((v & 8) != 0) {
            z = false;
        }
        model0.setFloatProperty(s, f, s1, z);
    }

    public final void setId(String s) {
        Intrinsics.checkNotNullParameter(s, "value");
        Model.setStringProperty$default(this, "id", s, null, false, 12, null);
    }

    public final void setIntProperty(String s, int v, String s1, boolean z) {
        Intrinsics.checkNotNullParameter(s, "name");
        Intrinsics.checkNotNullParameter(s1, "tag");
        this.setOptIntProperty(s, v, s1, z);
    }

    public static void setIntProperty$default(Model model0, String s, int v, String s1, boolean z, int v1, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setIntProperty");
        }
        if((v1 & 4) != 0) {
            s1 = "NORMAL";
        }
        if((v1 & 8) != 0) {
            z = false;
        }
        model0.setIntProperty(s, v, s1, z);
    }

    public final void setListProperty(String s, List list0, String s1, boolean z) {
        Intrinsics.checkNotNullParameter(s, "name");
        Intrinsics.checkNotNullParameter(list0, "value");
        Intrinsics.checkNotNullParameter(s1, "tag");
        this.setOptListProperty(s, list0, s1, z);
    }

    public static void setListProperty$default(Model model0, String s, List list0, String s1, boolean z, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setListProperty");
        }
        if((v & 4) != 0) {
            s1 = "NORMAL";
        }
        if((v & 8) != 0) {
            z = false;
        }
        model0.setListProperty(s, list0, s1, z);
    }

    public final void setLongProperty(String s, long v, String s1, boolean z) {
        Intrinsics.checkNotNullParameter(s, "name");
        Intrinsics.checkNotNullParameter(s1, "tag");
        this.setOptLongProperty(s, v, s1, z);
    }

    public static void setLongProperty$default(Model model0, String s, long v, String s1, boolean z, int v1, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setLongProperty");
        }
        if((v1 & 4) != 0) {
            s1 = "NORMAL";
        }
        if((v1 & 8) != 0) {
            z = false;
        }
        model0.setLongProperty(s, v, s1, z);
    }

    public final void setMapModelProperty(String s, MapModel mapModel0, String s1, boolean z) {
        Intrinsics.checkNotNullParameter(s, "name");
        Intrinsics.checkNotNullParameter(mapModel0, "value");
        Intrinsics.checkNotNullParameter(s1, "tag");
        this.setOptMapModelProperty(s, mapModel0, s1, z);
    }

    public static void setMapModelProperty$default(Model model0, String s, MapModel mapModel0, String s1, boolean z, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMapModelProperty");
        }
        if((v & 4) != 0) {
            s1 = "NORMAL";
        }
        if((v & 8) != 0) {
            z = false;
        }
        model0.setMapModelProperty(s, mapModel0, s1, z);
    }

    public final void setOptAnyProperty(String s, Object object0, String s1, boolean z) {
        Intrinsics.checkNotNullParameter(s, "name");
        Intrinsics.checkNotNullParameter(s1, "tag");
        Object object1 = this.data.get(s);
        synchronized(this.data) {
            if(Intrinsics.areEqual(object1, object0) && !z) {
                return;
            }
            if(object0 != null) {
                this.data.put(s, object0);
            }
            else if(this.data.containsKey(s)) {
                this.data.remove(s);
            }
        }
        this.notifyChanged(s, s, s1, object1, object0);
    }

    public static void setOptAnyProperty$default(Model model0, String s, Object object0, String s1, boolean z, int v, Object object1) {
        if(object1 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOptAnyProperty");
        }
        if((v & 4) != 0) {
            s1 = "NORMAL";
        }
        if((v & 8) != 0) {
            z = false;
        }
        model0.setOptAnyProperty(s, object0, s1, z);
    }

    public final void setOptBigDecimalProperty(String s, BigDecimal bigDecimal0, String s1, boolean z) {
        Intrinsics.checkNotNullParameter(s, "name");
        Intrinsics.checkNotNullParameter(s1, "tag");
        this.setOptAnyProperty(s, (bigDecimal0 == null ? null : bigDecimal0.toString()), s1, z);
    }

    public static void setOptBigDecimalProperty$default(Model model0, String s, BigDecimal bigDecimal0, String s1, boolean z, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOptBigDecimalProperty");
        }
        if((v & 4) != 0) {
            s1 = "NORMAL";
        }
        if((v & 8) != 0) {
            z = false;
        }
        model0.setOptBigDecimalProperty(s, bigDecimal0, s1, z);
    }

    public final void setOptBooleanProperty(String s, Boolean boolean0, String s1, boolean z) {
        Intrinsics.checkNotNullParameter(s, "name");
        Intrinsics.checkNotNullParameter(s1, "tag");
        this.setOptAnyProperty(s, boolean0, s1, z);
    }

    public static void setOptBooleanProperty$default(Model model0, String s, Boolean boolean0, String s1, boolean z, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOptBooleanProperty");
        }
        if((v & 4) != 0) {
            s1 = "NORMAL";
        }
        if((v & 8) != 0) {
            z = false;
        }
        model0.setOptBooleanProperty(s, boolean0, s1, z);
    }

    public final void setOptDoubleProperty(String s, Double double0, String s1, boolean z) {
        Intrinsics.checkNotNullParameter(s, "name");
        Intrinsics.checkNotNullParameter(s1, "tag");
        this.setOptAnyProperty(s, double0, s1, z);
    }

    public static void setOptDoubleProperty$default(Model model0, String s, Double double0, String s1, boolean z, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOptDoubleProperty");
        }
        if((v & 4) != 0) {
            s1 = "NORMAL";
        }
        if((v & 8) != 0) {
            z = false;
        }
        model0.setOptDoubleProperty(s, double0, s1, z);
    }

    public final void setOptEnumProperty(String s, Enum enum0, String s1, boolean z) {
        Intrinsics.checkNotNullParameter(s, "name");
        Intrinsics.checkNotNullParameter(s1, "tag");
        this.setOptAnyProperty(s, (enum0 == null ? null : enum0.toString()), s1, z);
    }

    public static void setOptEnumProperty$default(Model model0, String s, Enum enum0, String s1, boolean z, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOptEnumProperty");
        }
        if((v & 4) != 0) {
            s1 = "NORMAL";
        }
        if((v & 8) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(s, "name");
        Intrinsics.checkNotNullParameter(s1, "tag");
        model0.setOptAnyProperty(s, (enum0 == null ? null : enum0.toString()), s1, z);
    }

    public final void setOptFloatProperty(String s, Float float0, String s1, boolean z) {
        Intrinsics.checkNotNullParameter(s, "name");
        Intrinsics.checkNotNullParameter(s1, "tag");
        this.setOptAnyProperty(s, float0, s1, z);
    }

    public static void setOptFloatProperty$default(Model model0, String s, Float float0, String s1, boolean z, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOptFloatProperty");
        }
        if((v & 4) != 0) {
            s1 = "NORMAL";
        }
        if((v & 8) != 0) {
            z = false;
        }
        model0.setOptFloatProperty(s, float0, s1, z);
    }

    public final void setOptIntProperty(String s, Integer integer0, String s1, boolean z) {
        Intrinsics.checkNotNullParameter(s, "name");
        Intrinsics.checkNotNullParameter(s1, "tag");
        this.setOptAnyProperty(s, integer0, s1, z);
    }

    public static void setOptIntProperty$default(Model model0, String s, Integer integer0, String s1, boolean z, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOptIntProperty");
        }
        if((v & 4) != 0) {
            s1 = "NORMAL";
        }
        if((v & 8) != 0) {
            z = false;
        }
        model0.setOptIntProperty(s, integer0, s1, z);
    }

    public final void setOptListProperty(String s, List list0, String s1, boolean z) {
        Intrinsics.checkNotNullParameter(s, "name");
        Intrinsics.checkNotNullParameter(s1, "tag");
        this.setOptAnyProperty(s, list0, s1, z);
    }

    public static void setOptListProperty$default(Model model0, String s, List list0, String s1, boolean z, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOptListProperty");
        }
        if((v & 4) != 0) {
            s1 = "NORMAL";
        }
        if((v & 8) != 0) {
            z = false;
        }
        model0.setOptListProperty(s, list0, s1, z);
    }

    public final void setOptLongProperty(String s, Long long0, String s1, boolean z) {
        Intrinsics.checkNotNullParameter(s, "name");
        Intrinsics.checkNotNullParameter(s1, "tag");
        this.setOptAnyProperty(s, long0, s1, z);
    }

    public static void setOptLongProperty$default(Model model0, String s, Long long0, String s1, boolean z, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOptLongProperty");
        }
        if((v & 4) != 0) {
            s1 = "NORMAL";
        }
        if((v & 8) != 0) {
            z = false;
        }
        model0.setOptLongProperty(s, long0, s1, z);
    }

    public final void setOptMapModelProperty(String s, MapModel mapModel0, String s1, boolean z) {
        Intrinsics.checkNotNullParameter(s, "name");
        Intrinsics.checkNotNullParameter(s1, "tag");
        this.setOptAnyProperty(s, mapModel0, s1, z);
    }

    public static void setOptMapModelProperty$default(Model model0, String s, MapModel mapModel0, String s1, boolean z, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOptMapModelProperty");
        }
        if((v & 4) != 0) {
            s1 = "NORMAL";
        }
        if((v & 8) != 0) {
            z = false;
        }
        model0.setOptMapModelProperty(s, mapModel0, s1, z);
    }

    public final void setOptStringProperty(String s, String s1, String s2, boolean z) {
        Intrinsics.checkNotNullParameter(s, "name");
        Intrinsics.checkNotNullParameter(s2, "tag");
        this.setOptAnyProperty(s, s1, s2, z);
    }

    public static void setOptStringProperty$default(Model model0, String s, String s1, String s2, boolean z, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOptStringProperty");
        }
        if((v & 4) != 0) {
            s2 = "NORMAL";
        }
        if((v & 8) != 0) {
            z = false;
        }
        model0.setOptStringProperty(s, s1, s2, z);
    }

    public final void setStringProperty(String s, String s1, String s2, boolean z) {
        Intrinsics.checkNotNullParameter(s, "name");
        Intrinsics.checkNotNullParameter(s1, "value");
        Intrinsics.checkNotNullParameter(s2, "tag");
        this.setOptStringProperty(s, s1, s2, z);
    }

    public static void setStringProperty$default(Model model0, String s, String s1, String s2, boolean z, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setStringProperty");
        }
        if((v & 4) != 0) {
            s2 = "NORMAL";
        }
        if((v & 8) != 0) {
            z = false;
        }
        model0.setStringProperty(s, s1, s2, z);
    }

    public void subscribe(IModelChangedHandler iModelChangedHandler0) {
        Intrinsics.checkNotNullParameter(iModelChangedHandler0, "handler");
        this.changeNotifier.subscribe(iModelChangedHandler0);
    }

    @Override  // com.onesignal.common.events.IEventNotifier
    public void subscribe(Object object0) {
        this.subscribe(((IModelChangedHandler)object0));
    }

    public final JSONObject toJSON() {
        JSONObject jSONObject0 = new JSONObject();
        synchronized(this.data) {
            for(Object object0: this.data.entrySet()) {
                Map.Entry map$Entry0 = (Map.Entry)object0;
                Object object1 = map$Entry0.getValue();
                if(object1 instanceof Model) {
                    jSONObject0.put(((String)map$Entry0.getKey()), ((Model)object1).toJSON());
                }
                else if(object1 instanceof List) {
                    JSONArray jSONArray0 = new JSONArray();
                    for(Object object2: ((List)object1)) {
                        if(object2 instanceof Model) {
                            jSONArray0.put(((Model)object2).toJSON());
                        }
                        else {
                            jSONArray0.put(object2);
                        }
                    }
                    jSONObject0.put(((String)map$Entry0.getKey()), jSONArray0);
                }
                else {
                    jSONObject0.put(((String)map$Entry0.getKey()), object1);
                }
            }
            return jSONObject0;
        }
    }

    public void unsubscribe(IModelChangedHandler iModelChangedHandler0) {
        Intrinsics.checkNotNullParameter(iModelChangedHandler0, "handler");
        this.changeNotifier.unsubscribe(iModelChangedHandler0);
    }

    @Override  // com.onesignal.common.events.IEventNotifier
    public void unsubscribe(Object object0) {
        this.unsubscribe(((IModelChangedHandler)object0));
    }
}

