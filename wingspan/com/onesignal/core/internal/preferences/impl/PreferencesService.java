package com.onesignal.core.internal.preferences.impl;

import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;
import com.onesignal.common.threading.Waiter;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.logging.Logging;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\r\b\u0000\u0018\u0000 22\u00020\u00012\u00020\u0002:\u00012B\u0015\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u00A2\u0006\u0002\u0010\u0007J\u000E\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u000F0\u000EH\u0002J0\u0010\u0013\u001A\u0004\u0018\u00010\f2\u0006\u0010\u0014\u001A\u00020\n2\u0006\u0010\u0015\u001A\u00020\n2\n\u0010\u0016\u001A\u0006\u0012\u0002\b\u00030\u00172\b\u0010\u0018\u001A\u0004\u0018\u00010\fH\u0002J)\u0010\u0019\u001A\u0004\u0018\u00010\u001A2\u0006\u0010\u0014\u001A\u00020\n2\u0006\u0010\u0015\u001A\u00020\n2\b\u0010\u0018\u001A\u0004\u0018\u00010\u001AH\u0016\u00A2\u0006\u0002\u0010\u001BJ)\u0010\u001C\u001A\u0004\u0018\u00010\u001D2\u0006\u0010\u0014\u001A\u00020\n2\u0006\u0010\u0015\u001A\u00020\n2\b\u0010\u0018\u001A\u0004\u0018\u00010\u001DH\u0016\u00A2\u0006\u0002\u0010\u001EJ)\u0010\u001F\u001A\u0004\u0018\u00010 2\u0006\u0010\u0014\u001A\u00020\n2\u0006\u0010\u0015\u001A\u00020\n2\b\u0010\u0018\u001A\u0004\u0018\u00010 H\u0016\u00A2\u0006\u0002\u0010!J\u0012\u0010\"\u001A\u0004\u0018\u00010#2\u0006\u0010\u0014\u001A\u00020\nH\u0002J$\u0010$\u001A\u0004\u0018\u00010\n2\u0006\u0010\u0014\u001A\u00020\n2\u0006\u0010\u0015\u001A\u00020\n2\b\u0010\u0018\u001A\u0004\u0018\u00010\nH\u0016J0\u0010%\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010&2\u0006\u0010\u0014\u001A\u00020\n2\u0006\u0010\u0015\u001A\u00020\n2\u000E\u0010\u0018\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010&H\u0016J\"\u0010\'\u001A\u00020\u000F2\u0006\u0010\u0014\u001A\u00020\n2\u0006\u0010\u0015\u001A\u00020\n2\b\u0010(\u001A\u0004\u0018\u00010\fH\u0002J\'\u0010)\u001A\u00020\u000F2\u0006\u0010\u0014\u001A\u00020\n2\u0006\u0010\u0015\u001A\u00020\n2\b\u0010(\u001A\u0004\u0018\u00010\u001AH\u0016\u00A2\u0006\u0002\u0010*J\'\u0010+\u001A\u00020\u000F2\u0006\u0010\u0014\u001A\u00020\n2\u0006\u0010\u0015\u001A\u00020\n2\b\u0010(\u001A\u0004\u0018\u00010\u001DH\u0016\u00A2\u0006\u0002\u0010,J\'\u0010-\u001A\u00020\u000F2\u0006\u0010\u0014\u001A\u00020\n2\u0006\u0010\u0015\u001A\u00020\n2\b\u0010(\u001A\u0004\u0018\u00010 H\u0016\u00A2\u0006\u0002\u0010.J\"\u0010/\u001A\u00020\u000F2\u0006\u0010\u0014\u001A\u00020\n2\u0006\u0010\u0015\u001A\u00020\n2\b\u0010(\u001A\u0004\u0018\u00010\nH\u0016J(\u00100\u001A\u00020\u000F2\u0006\u0010\u0014\u001A\u00020\n2\u0006\u0010\u0015\u001A\u00020\n2\u000E\u0010(\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010&H\u0016J\b\u00101\u001A\u00020\u000FH\u0016R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004\u00A2\u0006\u0002\n\u0000R(\u0010\b\u001A\u001C\u0012\u0004\u0012\u00020\n\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000B0\tX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u0016\u0010\r\u001A\n\u0012\u0004\u0012\u00020\u000F\u0018\u00010\u000EX\u0082\u000E\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0011X\u0082\u0004\u00A2\u0006\u0002\n\u0000\u00A8\u00063"}, d2 = {"Lcom/onesignal/core/internal/preferences/impl/PreferencesService;", "Lcom/onesignal/core/internal/preferences/IPreferencesService;", "Lcom/onesignal/core/internal/startup/IStartableService;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/core/internal/time/ITime;)V", "prefsToApply", "", "", "", "", "queueJob", "Lkotlinx/coroutines/Deferred;", "", "waiter", "Lcom/onesignal/common/threading/Waiter;", "doWorkAsync", "get", "store", "key", "type", "Ljava/lang/Class;", "defValue", "getBool", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Ljava/lang/Boolean;", "getInt", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/Integer;", "getLong", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Ljava/lang/Long;", "getSharedPrefsByName", "Landroid/content/SharedPreferences;", "getString", "getStringSet", "", "save", "value", "saveBool", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "saveInt", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "saveLong", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "saveString", "saveStringSet", "start", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class PreferencesService implements IPreferencesService, IStartableService {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/onesignal/core/internal/preferences/impl/PreferencesService$Companion;", "", "()V", "WRITE_CALL_DELAY_TO_BUFFER_MS", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final Companion Companion = null;
    private static final int WRITE_CALL_DELAY_TO_BUFFER_MS = 200;
    private final IApplicationService _applicationService;
    private final ITime _time;
    private final Map prefsToApply;
    private Deferred queueJob;
    private final Waiter waiter;

    static {
        PreferencesService.Companion = new Companion(null);
    }

    public PreferencesService(IApplicationService iApplicationService0, ITime iTime0) {
        Intrinsics.checkNotNullParameter(iApplicationService0, "_applicationService");
        Intrinsics.checkNotNullParameter(iTime0, "_time");
        super();
        this._applicationService = iApplicationService0;
        this._time = iTime0;
        this.prefsToApply = MapsKt.mapOf(new Pair[]{TuplesKt.to("OneSignal", new LinkedHashMap()), TuplesKt.to("GTPlayerPurchases", new LinkedHashMap())});
        this.waiter = new Waiter();
    }

    private final Deferred doWorkAsync() {
        com.onesignal.core.internal.preferences.impl.PreferencesService.doWorkAsync.1 preferencesService$doWorkAsync$10 = new Function2(null) {
            long J$0;
            int label;

            {
                PreferencesService.this = preferencesService0;
                super(2, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.onesignal.core.internal.preferences.impl.PreferencesService.doWorkAsync.1(PreferencesService.this, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function2
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.onesignal.core.internal.preferences.impl.PreferencesService.doWorkAsync.1)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                long v2;
                com.onesignal.core.internal.preferences.impl.PreferencesService.doWorkAsync.1 preferencesService$doWorkAsync$11;
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                try {
                    switch(this.label) {
                        case 0: {
                            goto label_3;
                        }
                        case 1: {
                            goto label_7;
                        }
                        case 2: {
                            goto label_11;
                        }
                    }
                }
                catch(Throwable throwable0) {
                    preferencesService$doWorkAsync$11 = this;
                    goto label_79;
                }
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            label_3:
                ResultKt.throwOnFailure(object0);
                long v = PreferencesService.this._time.getCurrentTimeMillis();
                com.onesignal.core.internal.preferences.impl.PreferencesService.doWorkAsync.1 preferencesService$doWorkAsync$10 = this;
                goto label_18;
                try {
                label_7:
                    v = this.J$0;
                    ResultKt.throwOnFailure(object0);
                    preferencesService$doWorkAsync$10 = this;
                    goto label_72;
                label_11:
                    v = this.J$0;
                    ResultKt.throwOnFailure(object0);
                }
                catch(Throwable throwable0) {
                    preferencesService$doWorkAsync$11 = this;
                    goto label_79;
                }
                preferencesService$doWorkAsync$10 = this;
                while(true) {
                    try {
                    label_18:
                        for(Object object2: PreferencesService.this.prefsToApply.keySet()) {
                            Object object3 = PreferencesService.this.prefsToApply.get(((String)object2));
                            Intrinsics.checkNotNull(object3);
                            Map map0 = (Map)object3;
                            SharedPreferences sharedPreferences0 = PreferencesService.this.getSharedPrefsByName(((String)object2));
                            if(sharedPreferences0 == null) {
                                PreferencesService.this.waiter.wake();
                            }
                            else {
                                SharedPreferences.Editor sharedPreferences$Editor0 = sharedPreferences0.edit();
                                synchronized(map0) {
                                    for(Object object4: map0.keySet()) {
                                        String s = (String)object4;
                                        Object object5 = map0.get(s);
                                        if(object5 instanceof String) {
                                            sharedPreferences$Editor0.putString(s, ((String)object5));
                                        }
                                        else if(object5 instanceof Boolean) {
                                            sharedPreferences$Editor0.putBoolean(s, ((Boolean)object5).booleanValue());
                                        }
                                        else if(object5 instanceof Integer) {
                                            sharedPreferences$Editor0.putInt(s, ((int)(((Integer)object5))));
                                        }
                                        else if(object5 instanceof Long) {
                                            sharedPreferences$Editor0.putLong(s, ((long)(((Long)object5))));
                                        }
                                        else if(object5 instanceof Set) {
                                            sharedPreferences$Editor0.putStringSet(s, ((Set)object5));
                                        }
                                        else {
                                            if(object5 != null) {
                                                continue;
                                            }
                                            sharedPreferences$Editor0.remove(s);
                                        }
                                    }
                                    map0.clear();
                                }
                                sharedPreferences$Editor0.apply();
                            }
                        }
                        v2 = PreferencesService.this._time.getCurrentTimeMillis();
                        long v3 = v - v2 + 200L;
                        if(v3 > 0L) {
                            goto label_63;
                        }
                        goto label_71;
                    }
                    catch(Throwable throwable1) {
                        goto label_77;
                    }
                    try {
                    label_63:
                        preferencesService$doWorkAsync$10.J$0 = v2;
                        preferencesService$doWorkAsync$10.label = 1;
                        if(DelayKt.delay(v3, preferencesService$doWorkAsync$10) == object1) {
                            return object1;
                        }
                    }
                    catch(Throwable throwable1) {
                        v = v2;
                        goto label_77;
                    }
                label_71:
                    v = v2;
                    try {
                    label_72:
                        preferencesService$doWorkAsync$10.J$0 = v;
                        preferencesService$doWorkAsync$10.label = 2;
                        if(PreferencesService.this.waiter.waitForWake(preferencesService$doWorkAsync$10) != object1) {
                            goto label_18;
                        }
                        break;
                    }
                    catch(Throwable throwable1) {
                    }
                label_77:
                    preferencesService$doWorkAsync$11 = preferencesService$doWorkAsync$10;
                    throwable0 = throwable1;
                label_79:
                    Logging.log(LogLevel.ERROR, "Error with Preference work loop", throwable0);
                    preferencesService$doWorkAsync$10 = preferencesService$doWorkAsync$11;
                }
                return object1;
            }
        };
        return BuildersKt.async$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, preferencesService$doWorkAsync$10, 2, null);
    }

    private final Object get(String s, String s1, Class class0, Object object0) {
        if(this.prefsToApply.containsKey(s)) {
            Object object1 = this.prefsToApply.get(s);
            Intrinsics.checkNotNull(object1);
            synchronized(((Map)object1)) {
                Object object2 = ((Map)object1).get(s1);
                if(object2 == null && !((Map)object1).containsKey(s1)) {
                    SharedPreferences sharedPreferences0 = this.getSharedPrefsByName(s);
                    long v1 = 0L;
                    boolean z = false;
                    if(sharedPreferences0 != null) {
                        try {
                            if(Intrinsics.areEqual(class0, String.class)) {
                                return sharedPreferences0.getString(s1, ((String)object0));
                            }
                            if(Intrinsics.areEqual(class0, Boolean.TYPE)) {
                                return Boolean.valueOf(sharedPreferences0.getBoolean(s1, (((Boolean)object0) == null ? false : ((Boolean)object0).booleanValue())));
                            }
                            if(Intrinsics.areEqual(class0, Integer.TYPE)) {
                                return sharedPreferences0.getInt(s1, (((Integer)object0) == null ? 0 : ((int)(((Integer)object0)))));
                            }
                            if(Intrinsics.areEqual(class0, Long.TYPE)) {
                                return sharedPreferences0.getLong(s1, (((Long)object0) == null ? 0L : ((long)(((Long)object0)))));
                            }
                            return Intrinsics.areEqual(class0, Set.class) ? sharedPreferences0.getStringSet(s1, ((Set)object0)) : null;
                        }
                        catch(Exception unused_ex) {
                        }
                    }
                    if(Intrinsics.areEqual(class0, String.class)) {
                        return (String)object0;
                    }
                    if(Intrinsics.areEqual(class0, Boolean.TYPE)) {
                        if(((Boolean)object0) != null) {
                            z = ((Boolean)object0).booleanValue();
                        }
                        return Boolean.valueOf(z);
                    }
                    if(Intrinsics.areEqual(class0, Integer.TYPE)) {
                        if(((Integer)object0) != null) {
                            z = (int)(((Integer)object0));
                        }
                        return (int)z;
                    }
                    if(Intrinsics.areEqual(class0, Long.TYPE)) {
                        if(((Long)object0) != null) {
                            v1 = (long)(((Long)object0));
                        }
                        return v1;
                    }
                    return Intrinsics.areEqual(class0, Set.class) ? ((Set)object0) : null;
                }
                return object2;
            }
        }
        throw new Exception("Store not found: " + s);
    }

    @Override  // com.onesignal.core.internal.preferences.IPreferencesService
    public Boolean getBool(String s, String s1, Boolean boolean0) {
        Intrinsics.checkNotNullParameter(s, "store");
        Intrinsics.checkNotNullParameter(s1, "key");
        return (Boolean)this.get(s, s1, Boolean.TYPE, boolean0);
    }

    @Override  // com.onesignal.core.internal.preferences.IPreferencesService
    public Integer getInt(String s, String s1, Integer integer0) {
        Intrinsics.checkNotNullParameter(s, "store");
        Intrinsics.checkNotNullParameter(s1, "key");
        return (Integer)this.get(s, s1, Integer.TYPE, integer0);
    }

    @Override  // com.onesignal.core.internal.preferences.IPreferencesService
    public Long getLong(String s, String s1, Long long0) {
        Intrinsics.checkNotNullParameter(s, "store");
        Intrinsics.checkNotNullParameter(s1, "key");
        return (Long)this.get(s, s1, Long.TYPE, long0);
    }

    private final SharedPreferences getSharedPrefsByName(String s) {
        synchronized(this) {
            return this._applicationService.getAppContext().getSharedPreferences(s, 0);
        }
    }

    @Override  // com.onesignal.core.internal.preferences.IPreferencesService
    public String getString(String s, String s1, String s2) {
        Intrinsics.checkNotNullParameter(s, "store");
        Intrinsics.checkNotNullParameter(s1, "key");
        return (String)this.get(s, s1, String.class, s2);
    }

    @Override  // com.onesignal.core.internal.preferences.IPreferencesService
    public Set getStringSet(String s, String s1, Set set0) {
        Intrinsics.checkNotNullParameter(s, "store");
        Intrinsics.checkNotNullParameter(s1, "key");
        return (Set)this.get(s, s1, Set.class, set0);
    }

    private final void save(String s, String s1, Object object0) {
        if(!this.prefsToApply.containsKey(s)) {
            throw new Exception("Store not found: " + s);
        }
        Object object1 = this.prefsToApply.get(s);
        Intrinsics.checkNotNull(object1);
        synchronized(((Map)object1)) {
            ((Map)object1).put(s1, object0);
        }
        this.waiter.wake();
    }

    @Override  // com.onesignal.core.internal.preferences.IPreferencesService
    public void saveBool(String s, String s1, Boolean boolean0) {
        Intrinsics.checkNotNullParameter(s, "store");
        Intrinsics.checkNotNullParameter(s1, "key");
        this.save(s, s1, boolean0);
    }

    @Override  // com.onesignal.core.internal.preferences.IPreferencesService
    public void saveInt(String s, String s1, Integer integer0) {
        Intrinsics.checkNotNullParameter(s, "store");
        Intrinsics.checkNotNullParameter(s1, "key");
        this.save(s, s1, integer0);
    }

    @Override  // com.onesignal.core.internal.preferences.IPreferencesService
    public void saveLong(String s, String s1, Long long0) {
        Intrinsics.checkNotNullParameter(s, "store");
        Intrinsics.checkNotNullParameter(s1, "key");
        this.save(s, s1, long0);
    }

    @Override  // com.onesignal.core.internal.preferences.IPreferencesService
    public void saveString(String s, String s1, String s2) {
        Intrinsics.checkNotNullParameter(s, "store");
        Intrinsics.checkNotNullParameter(s1, "key");
        this.save(s, s1, s2);
    }

    @Override  // com.onesignal.core.internal.preferences.IPreferencesService
    public void saveStringSet(String s, String s1, Set set0) {
        Intrinsics.checkNotNullParameter(s, "store");
        Intrinsics.checkNotNullParameter(s1, "key");
        this.save(s, s1, set0);
    }

    @Override  // com.onesignal.core.internal.startup.IStartableService
    public void start() {
        this.queueJob = this.doWorkAsync();
    }
}

