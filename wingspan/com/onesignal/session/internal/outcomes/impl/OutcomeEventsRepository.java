package com.onesignal.session.internal.outcomes.impl;

import android.content.ContentValues;
import com.onesignal.core.internal.database.ICursor;
import com.onesignal.core.internal.database.IDatabase.DefaultImpls;
import com.onesignal.core.internal.database.IDatabase;
import com.onesignal.core.internal.database.IDatabaseProvider;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.session.internal.influence.Influence;
import com.onesignal.session.internal.influence.InfluenceChannel;
import com.onesignal.session.internal.influence.InfluenceType;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONException;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u0005\u001A\u00020\u00062\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\b2\b\u0010\n\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\f\u001A\u00020\rH\u0002J \u0010\u000E\u001A\u00020\u00062\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\b2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0010H\u0002J\u0011\u0010\u0011\u001A\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u0019\u0010\u0013\u001A\u00020\u00062\u0006\u0010\u0014\u001A\u00020\u0015H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0017\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00150\u0018H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J4\u0010\u0019\u001A\u0004\u0018\u00010\u001A2\u0006\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u00102\u0006\u0010\u001E\u001A\u00020\u00102\u0006\u0010\u001F\u001A\u00020 2\b\u0010!\u001A\u0004\u0018\u00010\u001AH\u0002J-\u0010\"\u001A\b\u0012\u0004\u0012\u00020#0\u00182\u0006\u0010$\u001A\u00020 2\f\u0010%\u001A\b\u0012\u0004\u0012\u00020#0\u0018H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010&J*\u0010\'\u001A\u0004\u0018\u00010\u001A2\u0006\u0010(\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u00102\u0006\u0010\u001E\u001A\u00020\u00102\u0006\u0010)\u001A\u00020 H\u0002J\u0019\u0010*\u001A\u00020\u00062\u0006\u0010+\u001A\u00020\u0015H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0019\u0010,\u001A\u00020\u00062\u0006\u0010+\u001A\u00020\u0015H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, d2 = {"Lcom/onesignal/session/internal/outcomes/impl/OutcomeEventsRepository;", "Lcom/onesignal/session/internal/outcomes/impl/IOutcomeEventsRepository;", "_databaseProvider", "Lcom/onesignal/core/internal/database/IDatabaseProvider;", "(Lcom/onesignal/core/internal/database/IDatabaseProvider;)V", "addIdToListFromChannel", "", "cachedUniqueOutcomes", "", "Lcom/onesignal/session/internal/outcomes/impl/CachedUniqueOutcome;", "channelIds", "Lorg/json/JSONArray;", "channel", "Lcom/onesignal/session/internal/influence/InfluenceChannel;", "addIdsToListFromSource", "sourceBody", "Lcom/onesignal/session/internal/outcomes/impl/OutcomeSourceBody;", "cleanCachedUniqueOutcomeEventNotifications", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteOldOutcomeEvent", "event", "Lcom/onesignal/session/internal/outcomes/impl/OutcomeEventParams;", "(Lcom/onesignal/session/internal/outcomes/impl/OutcomeEventParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllEventsToSend", "", "getIAMInfluenceSource", "Lcom/onesignal/session/internal/outcomes/impl/OutcomeSource;", "iamInfluenceType", "Lcom/onesignal/session/internal/influence/InfluenceType;", "directSourceBody", "indirectSourceBody", "iamIds", "", "source", "getNotCachedUniqueInfluencesForOutcome", "Lcom/onesignal/session/internal/influence/Influence;", "name", "influences", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNotificationInfluenceSource", "notificationInfluenceType", "notificationIds", "saveOutcomeEvent", "eventParams", "saveUniqueOutcomeEventParams", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class OutcomeEventsRepository implements IOutcomeEventsRepository {
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 0x30)
    public final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[InfluenceType.values().length];
            arr_v[InfluenceType.DIRECT.ordinal()] = 1;
            arr_v[InfluenceType.INDIRECT.ordinal()] = 2;
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    private final IDatabaseProvider _databaseProvider;

    public OutcomeEventsRepository(IDatabaseProvider iDatabaseProvider0) {
        Intrinsics.checkNotNullParameter(iDatabaseProvider0, "_databaseProvider");
        super();
        this._databaseProvider = iDatabaseProvider0;
    }

    private final void addIdToListFromChannel(List list0, JSONArray jSONArray0, InfluenceChannel influenceChannel0) {
        if(jSONArray0 != null) {
            int v = jSONArray0.length();
            for(int v1 = 0; v1 < v; ++v1) {
                try {
                    String s = jSONArray0.getString(v1);
                    Intrinsics.checkNotNullExpressionValue(s, "influenceId");
                    list0.add(new CachedUniqueOutcome(s, influenceChannel0));
                }
                catch(JSONException jSONException0) {
                    jSONException0.printStackTrace();
                }
            }
        }
    }

    private final void addIdsToListFromSource(List list0, OutcomeSourceBody outcomeSourceBody0) {
        if(outcomeSourceBody0 != null) {
            this.addIdToListFromChannel(list0, outcomeSourceBody0.getInAppMessagesIds(), InfluenceChannel.IAM);
            this.addIdToListFromChannel(list0, outcomeSourceBody0.getNotificationIds(), InfluenceChannel.NOTIFICATION);
        }
    }

    @Override  // com.onesignal.session.internal.outcomes.impl.IOutcomeEventsRepository
    public Object cleanCachedUniqueOutcomeEventNotifications(Continuation continuation0) {
        Object object0 = BuildersKt.withContext(Dispatchers.getIO(), new Function2("notification_id", this, null) {
            final String $notificationIdColumnName;
            final String $notificationTableName;
            int label;

            {
                this.$notificationTableName = s;
                this.$notificationIdColumnName = s1;
                OutcomeEventsRepository.this = outcomeEventsRepository0;
                super(2, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository.cleanCachedUniqueOutcomeEventNotifications.2(this.$notificationTableName, this.$notificationIdColumnName, OutcomeEventsRepository.this, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function2
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository.cleanCachedUniqueOutcomeEventNotifications.2)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                ResultKt.throwOnFailure(object0);
                Intrinsics.checkNotNullExpressionValue(Locale.ROOT, "ROOT");
                Intrinsics.checkNotNullExpressionValue("notification", "this as java.lang.String).toLowerCase(locale)");
                OutcomeEventsRepository.this._databaseProvider.getOs().delete("cached_unique_outcome", "NOT EXISTS(SELECT NULL FROM " + this.$notificationTableName + " n WHERE n." + this.$notificationIdColumnName + " = channel_influence_id AND channel_type = \"" + "notification" + "\")", null);
                return Unit.INSTANCE;
            }
        }, continuation0);
        return object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object0 : Unit.INSTANCE;
    }

    @Override  // com.onesignal.session.internal.outcomes.impl.IOutcomeEventsRepository
    public Object deleteOldOutcomeEvent(OutcomeEventParams outcomeEventParams0, Continuation continuation0) {
        Object object0 = BuildersKt.withContext(Dispatchers.getIO(), new Function2(outcomeEventParams0, null) {
            final OutcomeEventParams $event;
            int label;

            {
                OutcomeEventsRepository.this = outcomeEventsRepository0;
                this.$event = outcomeEventParams0;
                super(2, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository.deleteOldOutcomeEvent.2(OutcomeEventsRepository.this, this.$event, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function2
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository.deleteOldOutcomeEvent.2)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                ResultKt.throwOnFailure(object0);
                OutcomeEventsRepository.this._databaseProvider.getOs().delete("outcome", "timestamp = ?", new String[]{String.valueOf(this.$event.getTimestamp())});
                return Unit.INSTANCE;
            }
        }, continuation0);
        return object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object0 : Unit.INSTANCE;
    }

    @Override  // com.onesignal.session.internal.outcomes.impl.IOutcomeEventsRepository
    public Object getAllEventsToSend(Continuation continuation0) {
        com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository.getAllEventsToSend.1 outcomeEventsRepository$getAllEventsToSend$10;
        if(continuation0 instanceof com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository.getAllEventsToSend.1) {
            outcomeEventsRepository$getAllEventsToSend$10 = (com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository.getAllEventsToSend.1)continuation0;
            if((outcomeEventsRepository$getAllEventsToSend$10.label & 0x80000000) == 0) {
                outcomeEventsRepository$getAllEventsToSend$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.getAllEventsToSend(this);
                    }
                };
            }
            else {
                outcomeEventsRepository$getAllEventsToSend$10.label ^= 0x80000000;
            }
        }
        else {
            outcomeEventsRepository$getAllEventsToSend$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.getAllEventsToSend(this);
                }
            };
        }
        Object object0 = outcomeEventsRepository$getAllEventsToSend$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(outcomeEventsRepository$getAllEventsToSend$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                List list0 = new ArrayList();
                com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository.getAllEventsToSend.2 outcomeEventsRepository$getAllEventsToSend$20 = new Function2(list0, null) {
                    final List $events;
                    int label;

                    {
                        OutcomeEventsRepository.this = outcomeEventsRepository0;
                        this.$events = list0;
                        super(2, continuation0);
                    }

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository.getAllEventsToSend.2(OutcomeEventsRepository.this, this.$events, continuation0);
                    }

                    @Override  // kotlin.jvm.functions.Function2
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository.getAllEventsToSend.2)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        if(this.label != 0) {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                        ResultKt.throwOnFailure(object0);
                        DefaultImpls.query$default(OutcomeEventsRepository.this._databaseProvider.getOs(), "outcome", null, null, null, null, null, null, null, new Function1(this.$events) {
                            final List $events;

                            {
                                OutcomeEventsRepository.this = outcomeEventsRepository0;
                                this.$events = list0;
                                super(1);
                            }

                            @Override  // kotlin.jvm.functions.Function1
                            public Object invoke(Object object0) {
                                this.invoke(((ICursor)object0));
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ICursor iCursor0) {
                                Intrinsics.checkNotNullParameter(iCursor0, "cursor");
                                if(iCursor0.moveToFirst()) {
                                    while(true) {
                                        String s = iCursor0.getString("notification_influence_type");
                                        InfluenceType influenceType0 = InfluenceType.Companion.fromString(s);
                                        String s1 = iCursor0.getString("iam_influence_type");
                                        InfluenceType influenceType1 = InfluenceType.Companion.fromString(s1);
                                        String s2 = iCursor0.getOptString("notification_ids");
                                        if(s2 == null) {
                                            s2 = "[]";
                                        }
                                        String s3 = iCursor0.getOptString("iam_ids");
                                        String s4 = iCursor0.getString("name");
                                        float f = iCursor0.getFloat("weight");
                                        long v = iCursor0.getLong("timestamp");
                                        long v1 = iCursor0.getLong("session_time");
                                        try {
                                            OutcomeSourceBody outcomeSourceBody0 = new OutcomeSourceBody(null, null, 3, null);
                                            OutcomeSourceBody outcomeSourceBody1 = new OutcomeSourceBody(null, null, 3, null);
                                            OutcomeSource outcomeSource0 = OutcomeEventsRepository.this.getNotificationInfluenceSource(influenceType0, outcomeSourceBody0, outcomeSourceBody1, s2);
                                            OutcomeEventsRepository.this.getIAMInfluenceSource(influenceType1, outcomeSourceBody0, outcomeSourceBody1, (s3 == null ? "[]" : s3), outcomeSource0);
                                            if(outcomeSource0 == null) {
                                                outcomeSource0 = new OutcomeSource(null, null);
                                            }
                                            OutcomeEventParams outcomeEventParams0 = new OutcomeEventParams(s4, outcomeSource0, f, v1, v);
                                            this.$events.add(outcomeEventParams0);
                                        }
                                        catch(JSONException jSONException0) {
                                            Logging.error("Generating JSONArray from notifications ids outcome:JSON Failed.", jSONException0);
                                        }
                                        if(!iCursor0.moveToNext()) {
                                            break;
                                        }
                                    }
                                }
                            }
                        }, 0xFE, null);
                        return Unit.INSTANCE;
                    }
                };
                outcomeEventsRepository$getAllEventsToSend$10.L$0 = list0;
                outcomeEventsRepository$getAllEventsToSend$10.label = 1;
                return BuildersKt.withContext(Dispatchers.getIO(), outcomeEventsRepository$getAllEventsToSend$20, outcomeEventsRepository$getAllEventsToSend$10) == object1 ? object1 : list0;
            }
            case 1: {
                List list1 = (List)outcomeEventsRepository$getAllEventsToSend$10.L$0;
                ResultKt.throwOnFailure(object0);
                return list1;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    private final OutcomeSource getIAMInfluenceSource(InfluenceType influenceType0, OutcomeSourceBody outcomeSourceBody0, OutcomeSourceBody outcomeSourceBody1, String s, OutcomeSource outcomeSource0) {
        switch(WhenMappings.$EnumSwitchMapping$0[influenceType0.ordinal()]) {
            case 1: {
                outcomeSourceBody0.setInAppMessagesIds(new JSONArray(s));
                if(outcomeSource0 != null) {
                    outcomeSource0 = outcomeSource0.setDirectBody(outcomeSourceBody0);
                    return outcomeSource0 == null ? new OutcomeSource(outcomeSourceBody0, null) : outcomeSource0;
                }
                return new OutcomeSource(outcomeSourceBody0, null);
            }
            case 2: {
                outcomeSourceBody1.setInAppMessagesIds(new JSONArray(s));
                if(outcomeSource0 != null) {
                    outcomeSource0 = outcomeSource0.setIndirectBody(outcomeSourceBody1);
                    return outcomeSource0 == null ? new OutcomeSource(null, outcomeSourceBody1) : outcomeSource0;
                }
                return new OutcomeSource(null, outcomeSourceBody1);
            }
            default: {
                return outcomeSource0;
            }
        }
    }

    @Override  // com.onesignal.session.internal.outcomes.impl.IOutcomeEventsRepository
    public Object getNotCachedUniqueInfluencesForOutcome(String s, List list0, Continuation continuation0) {
        com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository.getNotCachedUniqueInfluencesForOutcome.1 outcomeEventsRepository$getNotCachedUniqueInfluencesForOutcome$10;
        if(continuation0 instanceof com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository.getNotCachedUniqueInfluencesForOutcome.1) {
            outcomeEventsRepository$getNotCachedUniqueInfluencesForOutcome$10 = (com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository.getNotCachedUniqueInfluencesForOutcome.1)continuation0;
            if((outcomeEventsRepository$getNotCachedUniqueInfluencesForOutcome$10.label & 0x80000000) == 0) {
                outcomeEventsRepository$getNotCachedUniqueInfluencesForOutcome$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.getNotCachedUniqueInfluencesForOutcome(null, null, this);
                    }
                };
            }
            else {
                outcomeEventsRepository$getNotCachedUniqueInfluencesForOutcome$10.label ^= 0x80000000;
            }
        }
        else {
            outcomeEventsRepository$getNotCachedUniqueInfluencesForOutcome$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.getNotCachedUniqueInfluencesForOutcome(null, null, this);
                }
            };
        }
        Object object0 = outcomeEventsRepository$getNotCachedUniqueInfluencesForOutcome$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(outcomeEventsRepository$getNotCachedUniqueInfluencesForOutcome$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                List list1 = new ArrayList();
                com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository.getNotCachedUniqueInfluencesForOutcome.2 outcomeEventsRepository$getNotCachedUniqueInfluencesForOutcome$20 = new Function2(s, this, list1, null) {
                    final List $influences;
                    final String $name;
                    final List $uniqueInfluences;
                    int label;

                    {
                        this.$influences = list0;
                        this.$name = s;
                        OutcomeEventsRepository.this = outcomeEventsRepository0;
                        this.$uniqueInfluences = list1;
                        super(2, continuation0);
                    }

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository.getNotCachedUniqueInfluencesForOutcome.2(this.$influences, this.$name, OutcomeEventsRepository.this, this.$uniqueInfluences, continuation0);
                    }

                    @Override  // kotlin.jvm.functions.Function2
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository.getNotCachedUniqueInfluencesForOutcome.2)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        if(this.label != 0) {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                        ResultKt.throwOnFailure(object0);
                        try {
                            for(Object object1: this.$influences) {
                                Influence influence0 = (Influence)object1;
                                JSONArray jSONArray0 = new JSONArray();
                                JSONArray jSONArray1 = influence0.getIds();
                                if(jSONArray1 != null) {
                                    int v = jSONArray1.length();
                                    for(int v1 = 0; v1 < v; ++v1) {
                                        String s = jSONArray1.getString(v1);
                                        IDatabase iDatabase0 = OutcomeEventsRepository.this._databaseProvider.getOs();
                                        com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository.getNotCachedUniqueInfluencesForOutcome.2.1 outcomeEventsRepository$getNotCachedUniqueInfluencesForOutcome$2$10 = new Function1(s) {
                                            final JSONArray $availableInfluenceIds;
                                            final String $channelInfluenceId;

                                            {
                                                this.$availableInfluenceIds = jSONArray0;
                                                this.$channelInfluenceId = s;
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
                                                    this.$availableInfluenceIds.put(this.$channelInfluenceId);
                                                }
                                            }
                                        };
                                        DefaultImpls.query$default(iDatabase0, "cached_unique_outcome", new String[0], "channel_influence_id = ? AND channel_type = ? AND name = ?", new String[]{s, influence0.getInfluenceChannel().toString(), this.$name}, null, null, null, "1", outcomeEventsRepository$getNotCachedUniqueInfluencesForOutcome$2$10, 0x70, null);
                                    }
                                    if(jSONArray0.length() > 0) {
                                        Influence influence1 = influence0.copy();
                                        influence1.setIds(jSONArray0);
                                        this.$uniqueInfluences.add(influence1);
                                    }
                                }
                            }
                        }
                        catch(JSONException jSONException0) {
                            jSONException0.printStackTrace();
                        }
                        return Unit.INSTANCE;
                    }
                };
                outcomeEventsRepository$getNotCachedUniqueInfluencesForOutcome$10.L$0 = list1;
                outcomeEventsRepository$getNotCachedUniqueInfluencesForOutcome$10.label = 1;
                return BuildersKt.withContext(Dispatchers.getIO(), outcomeEventsRepository$getNotCachedUniqueInfluencesForOutcome$20, outcomeEventsRepository$getNotCachedUniqueInfluencesForOutcome$10) == object1 ? object1 : list1;
            }
            case 1: {
                List list2 = (List)outcomeEventsRepository$getNotCachedUniqueInfluencesForOutcome$10.L$0;
                ResultKt.throwOnFailure(object0);
                return list2;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    private final OutcomeSource getNotificationInfluenceSource(InfluenceType influenceType0, OutcomeSourceBody outcomeSourceBody0, OutcomeSourceBody outcomeSourceBody1, String s) {
        switch(WhenMappings.$EnumSwitchMapping$0[influenceType0.ordinal()]) {
            case 1: {
                outcomeSourceBody0.setNotificationIds(new JSONArray(s));
                return new OutcomeSource(outcomeSourceBody0, null);
            }
            case 2: {
                outcomeSourceBody1.setNotificationIds(new JSONArray(s));
                return new OutcomeSource(null, outcomeSourceBody1);
            }
            default: {
                return null;
            }
        }
    }

    @Override  // com.onesignal.session.internal.outcomes.impl.IOutcomeEventsRepository
    public Object saveOutcomeEvent(OutcomeEventParams outcomeEventParams0, Continuation continuation0) {
        Object object0 = BuildersKt.withContext(Dispatchers.getIO(), new Function2(this, null) {
            final OutcomeEventParams $eventParams;
            int label;

            {
                this.$eventParams = outcomeEventParams0;
                OutcomeEventsRepository.this = outcomeEventsRepository0;
                super(2, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository.saveOutcomeEvent.2(this.$eventParams, OutcomeEventsRepository.this, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function2
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository.saveOutcomeEvent.2)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                ResultKt.throwOnFailure(object0);
                ObjectRef ref$ObjectRef0 = new ObjectRef();
                ref$ObjectRef0.element = new JSONArray();
                ObjectRef ref$ObjectRef1 = new ObjectRef();
                ref$ObjectRef1.element = new JSONArray();
                ObjectRef ref$ObjectRef2 = new ObjectRef();
                ref$ObjectRef2.element = InfluenceType.UNATTRIBUTED;
                ObjectRef ref$ObjectRef3 = new ObjectRef();
                ref$ObjectRef3.element = InfluenceType.UNATTRIBUTED;
                OutcomeSource outcomeSource0 = this.$eventParams.getOutcomeSource();
                if(outcomeSource0 != null) {
                    OutcomeSourceBody outcomeSourceBody0 = outcomeSource0.getDirectBody();
                    if(outcomeSourceBody0 != null) {
                        JSONArray jSONArray0 = outcomeSourceBody0.getNotificationIds();
                        if(jSONArray0 != null && jSONArray0.length() > 0) {
                            ref$ObjectRef2.element = InfluenceType.DIRECT;
                            ref$ObjectRef0.element = jSONArray0;
                        }
                        JSONArray jSONArray1 = outcomeSourceBody0.getInAppMessagesIds();
                        if(jSONArray1 != null && jSONArray1.length() > 0) {
                            ref$ObjectRef3.element = InfluenceType.DIRECT;
                            ref$ObjectRef1.element = jSONArray1;
                        }
                    }
                }
                OutcomeSource outcomeSource1 = this.$eventParams.getOutcomeSource();
                if(outcomeSource1 != null) {
                    OutcomeSourceBody outcomeSourceBody1 = outcomeSource1.getIndirectBody();
                    if(outcomeSourceBody1 != null) {
                        JSONArray jSONArray2 = outcomeSourceBody1.getNotificationIds();
                        if(jSONArray2 != null && jSONArray2.length() > 0) {
                            ref$ObjectRef2.element = InfluenceType.INDIRECT;
                            ref$ObjectRef0.element = jSONArray2;
                        }
                        JSONArray jSONArray3 = outcomeSourceBody1.getInAppMessagesIds();
                        if(jSONArray3 != null && jSONArray3.length() > 0) {
                            ref$ObjectRef3.element = InfluenceType.INDIRECT;
                            ref$ObjectRef1.element = jSONArray3;
                        }
                    }
                }
                ContentValues contentValues0 = new ContentValues();
                contentValues0.put("notification_ids", ((JSONArray)ref$ObjectRef0.element).toString());
                contentValues0.put("iam_ids", ((JSONArray)ref$ObjectRef1.element).toString());
                String s = ((InfluenceType)ref$ObjectRef2.element).toString();
                Locale locale0 = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(locale0, "ROOT");
                String s1 = s.toLowerCase(locale0);
                Intrinsics.checkNotNullExpressionValue(s1, "this as java.lang.String).toLowerCase(locale)");
                contentValues0.put("notification_influence_type", s1);
                String s2 = ((InfluenceType)ref$ObjectRef3.element).toString();
                Locale locale1 = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(locale1, "ROOT");
                String s3 = s2.toLowerCase(locale1);
                Intrinsics.checkNotNullExpressionValue(s3, "this as java.lang.String).toLowerCase(locale)");
                contentValues0.put("iam_influence_type", s3);
                contentValues0.put("name", this.$eventParams.getOutcomeId());
                contentValues0.put("weight", Boxing.boxFloat(this.$eventParams.getWeight()));
                contentValues0.put("timestamp", Boxing.boxLong(this.$eventParams.getTimestamp()));
                contentValues0.put("session_time", Boxing.boxLong(this.$eventParams.getSessionTime()));
                OutcomeEventsRepository.this._databaseProvider.getOs().insert("outcome", null, contentValues0);
                return contentValues0;
            }
        }, continuation0);
        return object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object0 : Unit.INSTANCE;
    }

    @Override  // com.onesignal.session.internal.outcomes.impl.IOutcomeEventsRepository
    public Object saveUniqueOutcomeEventParams(OutcomeEventParams outcomeEventParams0, Continuation continuation0) {
        Logging.debug$default(("OutcomeEventsCache.saveUniqueOutcomeEventParams(eventParams: " + outcomeEventParams0 + ')'), null, 2, null);
        Object object0 = BuildersKt.withContext(Dispatchers.getIO(), new Function2(this, null) {
            final OutcomeEventParams $eventParams;
            int label;

            {
                this.$eventParams = outcomeEventParams0;
                OutcomeEventsRepository.this = outcomeEventsRepository0;
                super(2, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository.saveUniqueOutcomeEventParams.2(this.$eventParams, OutcomeEventsRepository.this, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function2
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository.saveUniqueOutcomeEventParams.2)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                ResultKt.throwOnFailure(object0);
                String s = this.$eventParams.getOutcomeId();
                List list0 = new ArrayList();
                OutcomeSource outcomeSource0 = this.$eventParams.getOutcomeSource();
                OutcomeSource outcomeSource1 = this.$eventParams.getOutcomeSource();
                OutcomeEventsRepository.this.addIdsToListFromSource(list0, (outcomeSource0 == null ? null : outcomeSource0.getDirectBody()));
                OutcomeEventsRepository.this.addIdsToListFromSource(list0, (outcomeSource1 == null ? null : outcomeSource1.getIndirectBody()));
                for(Object object1: list0) {
                    ContentValues contentValues0 = new ContentValues();
                    contentValues0.put("channel_influence_id", ((CachedUniqueOutcome)object1).getInfluenceId());
                    contentValues0.put("channel_type", ((CachedUniqueOutcome)object1).getChannel().toString());
                    contentValues0.put("name", s);
                    OutcomeEventsRepository.this._databaseProvider.getOs().insert("cached_unique_outcome", null, contentValues0);
                }
                return Unit.INSTANCE;
            }
        }, continuation0);
        return object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object0 : Unit.INSTANCE;
    }
}

