package com.onesignal.inAppMessages.internal.repositories.impl;

import android.content.ContentValues;
import com.onesignal.common.JSONUtils;
import com.onesignal.core.internal.database.ICursor;
import com.onesignal.core.internal.database.IDatabase.DefaultImpls;
import com.onesignal.core.internal.database.IDatabase;
import com.onesignal.core.internal.database.IDatabaseProvider;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.inAppMessages.internal.InAppMessage;
import com.onesignal.inAppMessages.internal.InAppMessageRedisplayStats;
import com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController;
import com.onesignal.inAppMessages.internal.repositories.IInAppRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONException;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\t\u001A\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000BJ\u0017\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000E0\rH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000BJ\u0019\u0010\u000F\u001A\u00020\n2\u0006\u0010\u0010\u001A\u00020\u000EH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/onesignal/inAppMessages/internal/repositories/impl/InAppRepository;", "Lcom/onesignal/inAppMessages/internal/repositories/IInAppRepository;", "_databaseProvider", "Lcom/onesignal/core/internal/database/IDatabaseProvider;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "_prefs", "Lcom/onesignal/inAppMessages/internal/preferences/IInAppPreferencesController;", "(Lcom/onesignal/core/internal/database/IDatabaseProvider;Lcom/onesignal/core/internal/time/ITime;Lcom/onesignal/inAppMessages/internal/preferences/IInAppPreferencesController;)V", "cleanCachedInAppMessages", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listInAppMessages", "", "Lcom/onesignal/inAppMessages/internal/InAppMessage;", "saveInAppMessage", "inAppMessage", "(Lcom/onesignal/inAppMessages/internal/InAppMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class InAppRepository implements IInAppRepository {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/onesignal/inAppMessages/internal/repositories/impl/InAppRepository$Companion;", "", "()V", "IAM_CACHE_DATA_LIFETIME", "", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final Companion Companion = null;
    public static final long IAM_CACHE_DATA_LIFETIME = 15552000L;
    private final IDatabaseProvider _databaseProvider;
    private final IInAppPreferencesController _prefs;
    private final ITime _time;

    static {
        InAppRepository.Companion = new Companion(null);
    }

    public InAppRepository(IDatabaseProvider iDatabaseProvider0, ITime iTime0, IInAppPreferencesController iInAppPreferencesController0) {
        Intrinsics.checkNotNullParameter(iDatabaseProvider0, "_databaseProvider");
        Intrinsics.checkNotNullParameter(iTime0, "_time");
        Intrinsics.checkNotNullParameter(iInAppPreferencesController0, "_prefs");
        super();
        this._databaseProvider = iDatabaseProvider0;
        this._time = iTime0;
        this._prefs = iInAppPreferencesController0;
    }

    @Override  // com.onesignal.inAppMessages.internal.repositories.IInAppRepository
    public Object cleanCachedInAppMessages(Continuation continuation0) {
        Object object0 = BuildersKt.withContext(Dispatchers.getIO(), new Function2(null) {
            int label;

            {
                InAppRepository.this = inAppRepository0;
                super(2, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.onesignal.inAppMessages.internal.repositories.impl.InAppRepository.cleanCachedInAppMessages.2(InAppRepository.this, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function2
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.onesignal.inAppMessages.internal.repositories.impl.InAppRepository.cleanCachedInAppMessages.2)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                Set set3;
                Set set2;
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                ResultKt.throwOnFailure(object0);
                String[] arr_s = {"1749150305"};
                Set set0 = new LinkedHashSet();
                Set set1 = new LinkedHashSet();
                try {
                    IDatabase iDatabase0 = InAppRepository.this._databaseProvider.getOs();
                    set2 = set1;
                    set3 = set0;
                    Function1 function10 = new Function1(set1) {
                        final Set $oldClickedClickIds;
                        final Set $oldMessageIds;

                        {
                            this.$oldMessageIds = set0;
                            this.$oldClickedClickIds = set1;
                            super(1);
                        }

                        @Override  // kotlin.jvm.functions.Function1
                        public Object invoke(Object object0) {
                            this.invoke(((ICursor)object0));
                            return Unit.INSTANCE;
                        }

                        public final void invoke(ICursor iCursor0) {
                            Intrinsics.checkNotNullParameter(iCursor0, "it");
                            if(iCursor0.getCount() == 0) {
                                Logging.debug$default("Attempted to clean 6 month old IAM data, but none exists!", null, 2, null);
                                return;
                            }
                            if(iCursor0.moveToFirst()) {
                                while(true) {
                                    String s = iCursor0.getString("message_id");
                                    String s1 = iCursor0.getString("click_ids");
                                    this.$oldMessageIds.add(s);
                                    JSONArray jSONArray0 = new JSONArray(s1);
                                    Collection collection0 = JSONUtils.INSTANCE.newStringSetFromJSONArray(jSONArray0);
                                    this.$oldClickedClickIds.addAll(collection0);
                                    if(!iCursor0.moveToNext()) {
                                        break;
                                    }
                                }
                            }
                        }
                    };
                    set2 = set1;
                    set3 = set0;
                    DefaultImpls.query$default(iDatabase0, "in_app_message", new String[]{"message_id", "click_ids"}, "last_display < ?", arr_s, null, null, null, null, function10, 0xF0, null);
                }
                catch(JSONException jSONException0) {
                    jSONException0.printStackTrace();
                }
                InAppRepository.this._databaseProvider.getOs().delete("in_app_message", "last_display < ?", arr_s);
                InAppRepository.this._prefs.cleanInAppMessageIds(set3);
                InAppRepository.this._prefs.cleanInAppMessageClickedClickIds(set2);
                return Unit.INSTANCE;
            }
        }, continuation0);
        return object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object0 : Unit.INSTANCE;
    }

    @Override  // com.onesignal.inAppMessages.internal.repositories.IInAppRepository
    public Object listInAppMessages(Continuation continuation0) {
        com.onesignal.inAppMessages.internal.repositories.impl.InAppRepository.listInAppMessages.1 inAppRepository$listInAppMessages$10;
        if(continuation0 instanceof com.onesignal.inAppMessages.internal.repositories.impl.InAppRepository.listInAppMessages.1) {
            inAppRepository$listInAppMessages$10 = (com.onesignal.inAppMessages.internal.repositories.impl.InAppRepository.listInAppMessages.1)continuation0;
            if((inAppRepository$listInAppMessages$10.label & 0x80000000) == 0) {
                inAppRepository$listInAppMessages$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.listInAppMessages(this);
                    }
                };
            }
            else {
                inAppRepository$listInAppMessages$10.label ^= 0x80000000;
            }
        }
        else {
            inAppRepository$listInAppMessages$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.listInAppMessages(this);
                }
            };
        }
        Object object0 = inAppRepository$listInAppMessages$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(inAppRepository$listInAppMessages$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                List list0 = new ArrayList();
                com.onesignal.inAppMessages.internal.repositories.impl.InAppRepository.listInAppMessages.2 inAppRepository$listInAppMessages$20 = new Function2(list0, null) {
                    final List $inAppMessages;
                    int label;

                    {
                        InAppRepository.this = inAppRepository0;
                        this.$inAppMessages = list0;
                        super(2, continuation0);
                    }

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.onesignal.inAppMessages.internal.repositories.impl.InAppRepository.listInAppMessages.2(InAppRepository.this, this.$inAppMessages, continuation0);
                    }

                    @Override  // kotlin.jvm.functions.Function2
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.onesignal.inAppMessages.internal.repositories.impl.InAppRepository.listInAppMessages.2)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        if(this.label != 0) {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                        ResultKt.throwOnFailure(object0);
                        try {
                            DefaultImpls.query$default(InAppRepository.this._databaseProvider.getOs(), "in_app_message", null, null, null, null, null, null, null, new Function1(this.$inAppMessages) {
                                final List $inAppMessages;

                                {
                                    InAppRepository.this = inAppRepository0;
                                    this.$inAppMessages = list0;
                                    super(1);
                                }

                                @Override  // kotlin.jvm.functions.Function1
                                public Object invoke(Object object0) {
                                    this.invoke(((ICursor)object0));
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ICursor iCursor0) {
                                    Intrinsics.checkNotNullParameter(iCursor0, "it");
                                    if(iCursor0.moveToFirst()) {
                                        while(true) {
                                            String s = iCursor0.getString("message_id");
                                            String s1 = iCursor0.getString("click_ids");
                                            int v = iCursor0.getInt("display_quantity");
                                            long v1 = iCursor0.getLong("last_display");
                                            boolean z = iCursor0.getInt("displayed_in_session") == 1;
                                            JSONArray jSONArray0 = new JSONArray(s1);
                                            InAppMessage inAppMessage0 = new InAppMessage(s, JSONUtils.INSTANCE.newStringSetFromJSONArray(jSONArray0), z, new InAppMessageRedisplayStats(v, v1, InAppRepository.this._time), InAppRepository.this._time);
                                            this.$inAppMessages.add(inAppMessage0);
                                            if(!iCursor0.moveToNext()) {
                                                break;
                                            }
                                        }
                                    }
                                }
                            }, 0xFE, null);
                        }
                        catch(JSONException jSONException0) {
                            Logging.error("Generating JSONArray from iam click ids:JSON Failed.", jSONException0);
                        }
                        return Unit.INSTANCE;
                    }
                };
                inAppRepository$listInAppMessages$10.L$0 = list0;
                inAppRepository$listInAppMessages$10.label = 1;
                return BuildersKt.withContext(Dispatchers.getIO(), inAppRepository$listInAppMessages$20, inAppRepository$listInAppMessages$10) == object1 ? object1 : list0;
            }
            case 1: {
                List list1 = (List)inAppRepository$listInAppMessages$10.L$0;
                ResultKt.throwOnFailure(object0);
                return list1;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    @Override  // com.onesignal.inAppMessages.internal.repositories.IInAppRepository
    public Object saveInAppMessage(InAppMessage inAppMessage0, Continuation continuation0) {
        ContentValues contentValues0 = new ContentValues();
        contentValues0.put("message_id", inAppMessage0.getMessageId());
        contentValues0.put("display_quantity", Boxing.boxInt(inAppMessage0.getRedisplayStats().getDisplayQuantity()));
        contentValues0.put("last_display", Boxing.boxLong(inAppMessage0.getRedisplayStats().getLastDisplayTime()));
        contentValues0.put("click_ids", inAppMessage0.getClickedClickIds().toString());
        contentValues0.put("displayed_in_session", Boxing.boxBoolean(inAppMessage0.isDisplayedInSession()));
        Object object0 = BuildersKt.withContext(Dispatchers.getIO(), new Function2(contentValues0, inAppMessage0, null) {
            final InAppMessage $inAppMessage;
            final ContentValues $values;
            int label;

            {
                InAppRepository.this = inAppRepository0;
                this.$values = contentValues0;
                this.$inAppMessage = inAppMessage0;
                super(2, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.onesignal.inAppMessages.internal.repositories.impl.InAppRepository.saveInAppMessage.2(InAppRepository.this, this.$values, this.$inAppMessage, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function2
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.onesignal.inAppMessages.internal.repositories.impl.InAppRepository.saveInAppMessage.2)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                ResultKt.throwOnFailure(object0);
                if(InAppRepository.this._databaseProvider.getOs().update("in_app_message", this.$values, "message_id = ?", new String[]{this.$inAppMessage.getMessageId()}) == 0) {
                    InAppRepository.this._databaseProvider.getOs().insert("in_app_message", null, this.$values);
                }
                return Unit.INSTANCE;
            }
        }, continuation0);
        return object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object0 : Unit.INSTANCE;
    }
}

