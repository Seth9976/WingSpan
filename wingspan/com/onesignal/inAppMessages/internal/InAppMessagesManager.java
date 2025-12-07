package com.onesignal.inAppMessages.internal;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import com.onesignal.common.AndroidUtils;
import com.onesignal.common.IDManager;
import com.onesignal.common.JSONUtils;
import com.onesignal.common.events.EventProducer;
import com.onesignal.common.exceptions.BackendException;
import com.onesignal.common.modeling.IModelStore.DefaultImpls;
import com.onesignal.common.modeling.ISingletonModelStoreChangeHandler;
import com.onesignal.common.modeling.Model;
import com.onesignal.common.modeling.ModelChangedArgs;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.internal.application.IApplicationLifecycleHandler;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.language.ILanguageContext;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.inAppMessages.IInAppMessageClickListener;
import com.onesignal.inAppMessages.IInAppMessageLifecycleListener;
import com.onesignal.inAppMessages.IInAppMessagesManager;
import com.onesignal.inAppMessages.InAppMessageActionUrlType;
import com.onesignal.inAppMessages.R.string;
import com.onesignal.inAppMessages.internal.backend.IInAppBackendService;
import com.onesignal.inAppMessages.internal.common.InAppHelper;
import com.onesignal.inAppMessages.internal.common.OneSignalChromeTab;
import com.onesignal.inAppMessages.internal.display.IInAppDisplayer;
import com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleEventHandler;
import com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleService;
import com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController;
import com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePrompt.PromptActionResult;
import com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePrompt;
import com.onesignal.inAppMessages.internal.repositories.IInAppRepository;
import com.onesignal.inAppMessages.internal.state.InAppStateService;
import com.onesignal.inAppMessages.internal.triggers.ITriggerController;
import com.onesignal.inAppMessages.internal.triggers.ITriggerHandler;
import com.onesignal.inAppMessages.internal.triggers.TriggerModel;
import com.onesignal.inAppMessages.internal.triggers.TriggerModelStore;
import com.onesignal.session.internal.influence.IInfluenceManager;
import com.onesignal.session.internal.outcomes.IOutcomeEventsController;
import com.onesignal.session.internal.session.ISessionLifecycleHandler;
import com.onesignal.session.internal.session.ISessionService;
import com.onesignal.user.IUserManager;
import com.onesignal.user.internal.subscriptions.ISubscriptionChangedHandler;
import com.onesignal.user.internal.subscriptions.ISubscriptionManager;
import com.onesignal.user.subscriptions.IPushSubscription;
import com.onesignal.user.subscriptions.ISubscription;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u00A0\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u001E\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u00042\u00020\u00062\u00020\u00072\u00020\b2\u00020\tB\u008D\u0001\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\f\u001A\u00020\r\u0012\u0006\u0010\u000E\u001A\u00020\u000F\u0012\u0006\u0010\u0010\u001A\u00020\u0011\u0012\u0006\u0010\u0012\u001A\u00020\u0013\u0012\u0006\u0010\u0014\u001A\u00020\u0015\u0012\u0006\u0010\u0016\u001A\u00020\u0017\u0012\u0006\u0010\u0018\u001A\u00020\u0019\u0012\u0006\u0010\u001A\u001A\u00020\u001B\u0012\u0006\u0010\u001C\u001A\u00020\u001D\u0012\u0006\u0010\u001E\u001A\u00020\u001F\u0012\u0006\u0010 \u001A\u00020!\u0012\u0006\u0010\"\u001A\u00020#\u0012\u0006\u0010$\u001A\u00020%\u0012\u0006\u0010&\u001A\u00020\'\u0012\u0006\u0010(\u001A\u00020)\u0012\u0006\u0010*\u001A\u00020+\u00A2\u0006\u0002\u0010,J\u0010\u0010L\u001A\u00020M2\u0006\u0010N\u001A\u00020;H\u0016J\u0010\u0010O\u001A\u00020M2\u0006\u0010N\u001A\u000209H\u0016J\u0018\u0010P\u001A\u00020M2\u0006\u0010Q\u001A\u00020/2\u0006\u0010D\u001A\u00020/H\u0016J\u001C\u0010R\u001A\u00020M2\u0012\u0010S\u001A\u000E\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/0TH\u0016J\u0011\u0010U\u001A\u00020MH\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010VJ\'\u0010W\u001A\u00020M2\u0006\u0010X\u001A\u00020>2\f\u0010Y\u001A\b\u0012\u0004\u0012\u00020Z0AH\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010[J\b\u0010\\\u001A\u00020MH\u0016J\u0011\u0010]\u001A\u00020MH\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010VJ\u0011\u0010^\u001A\u00020MH\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010VJ\u0010\u0010_\u001A\u00020M2\u0006\u0010`\u001A\u00020aH\u0002J\'\u0010b\u001A\u00020M2\u0006\u0010c\u001A\u00020/2\f\u0010d\u001A\b\u0012\u0004\u0012\u00020e0AH\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010fJ!\u0010g\u001A\u00020M2\u0006\u0010X\u001A\u00020>2\u0006\u0010`\u001A\u00020aH\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010hJ!\u0010i\u001A\u00020M2\u0006\u0010X\u001A\u00020>2\u0006\u0010`\u001A\u00020aH\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010hJ!\u0010j\u001A\u00020M2\u0006\u0010X\u001A\u00020>2\u0006\u0010k\u001A\u00020lH\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010mJ\u0010\u0010n\u001A\u00020M2\u0006\u0010`\u001A\u00020aH\u0002J\u0010\u0010o\u001A\u00020C2\u0006\u0010X\u001A\u00020>H\u0002J\u0010\u0010p\u001A\u00020M2\u0006\u0010`\u001A\u00020aH\u0002J\u0016\u0010q\u001A\u00020M2\f\u0010r\u001A\b\u0012\u0004\u0012\u00020/0sH\u0002J#\u0010t\u001A\u00020M2\u0006\u0010X\u001A\u00020>2\b\b\u0002\u0010u\u001A\u00020CH\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010vJ\b\u0010w\u001A\u00020MH\u0016J\u0018\u0010x\u001A\u00020M2\u0006\u0010X\u001A\u00020>2\u0006\u0010`\u001A\u00020aH\u0016J\u0018\u0010y\u001A\u00020M2\u0006\u0010X\u001A\u00020>2\u0006\u0010`\u001A\u00020aH\u0016J\u0018\u0010z\u001A\u00020M2\u0006\u0010X\u001A\u00020>2\u0006\u0010k\u001A\u00020lH\u0016J\u0010\u0010{\u001A\u00020M2\u0006\u0010X\u001A\u00020>H\u0016J\u0010\u0010|\u001A\u00020M2\u0006\u0010X\u001A\u00020>H\u0016J\u0010\u0010}\u001A\u00020M2\u0006\u0010X\u001A\u00020>H\u0016J\u0010\u0010~\u001A\u00020M2\u0006\u0010X\u001A\u00020>H\u0016J\u001A\u0010\u007F\u001A\u00020M2\u0007\u0010\u0080\u0001\u001A\u00020\u00052\u0007\u0010\u0081\u0001\u001A\u00020/H\u0016J\u001C\u0010\u0082\u0001\u001A\u00020M2\b\u0010\u0083\u0001\u001A\u00030\u0084\u00012\u0007\u0010\u0081\u0001\u001A\u00020/H\u0016J\t\u0010\u0085\u0001\u001A\u00020MH\u0016J\u0012\u0010\u0086\u0001\u001A\u00020M2\u0007\u0010\u0087\u0001\u001A\u000205H\u0016J\t\u0010\u0088\u0001\u001A\u00020MH\u0016J\u0013\u0010\u0089\u0001\u001A\u00020M2\b\u0010\u008A\u0001\u001A\u00030\u008B\u0001H\u0016J\u001D\u0010\u008C\u0001\u001A\u00020M2\b\u0010\u008A\u0001\u001A\u00030\u008B\u00012\b\u0010\u0083\u0001\u001A\u00030\u0084\u0001H\u0016J\u0013\u0010\u008D\u0001\u001A\u00020M2\b\u0010\u008A\u0001\u001A\u00030\u008B\u0001H\u0016J\u0012\u0010\u008E\u0001\u001A\u00020M2\u0007\u0010\u008F\u0001\u001A\u00020/H\u0016J\u0012\u0010\u0090\u0001\u001A\u00020M2\u0007\u0010\u0091\u0001\u001A\u00020/H\u0016J\t\u0010\u0092\u0001\u001A\u00020MH\u0016J\t\u0010\u0093\u0001\u001A\u00020MH\u0016J\u001B\u0010\u0094\u0001\u001A\u00020M2\u0006\u0010X\u001A\u00020>H\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0003\u0010\u0095\u0001J\u001B\u0010\u0096\u0001\u001A\u00020M2\u0006\u0010X\u001A\u00020>H\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0003\u0010\u0095\u0001J\u0011\u0010\u0097\u0001\u001A\u00020M2\u0006\u0010N\u001A\u00020;H\u0016J\u0011\u0010\u0098\u0001\u001A\u00020M2\u0006\u0010N\u001A\u000209H\u0016J\u0011\u0010\u0099\u0001\u001A\u00020M2\u0006\u0010Q\u001A\u00020/H\u0016J\u0018\u0010\u009A\u0001\u001A\u00020M2\r\u0010\u009B\u0001\u001A\b\u0012\u0004\u0012\u00020/0sH\u0016J\u0011\u0010\u009C\u0001\u001A\u00020M2\u0006\u0010X\u001A\u00020>H\u0002J \u0010\u009D\u0001\u001A\u00020M2\u0007\u0010\u009E\u0001\u001A\u00020>2\f\u0010Y\u001A\b\u0012\u0004\u0012\u00020Z0AH\u0002J)\u0010\u009F\u0001\u001A\u00020M2\u0007\u0010\u009E\u0001\u001A\u00020>2\f\u0010Y\u001A\b\u0012\u0004\u0012\u00020Z0AH\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010[J\t\u0010\u00A0\u0001\u001A\u00020MH\u0016R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u001E\u001A\u00020\u001FX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0011X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010$\u001A\u00020%X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010(\u001A\u00020)X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010&\u001A\u00020\'X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\u0017X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\u001BX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u001C\u001A\u00020\u001DX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0018\u001A\u00020\u0019X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0015X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010*\u001A\u00020+X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010 \u001A\u00020!X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\"\u001A\u00020#X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0013X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u0014\u0010-\u001A\b\u0012\u0004\u0012\u00020/0.X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u0014\u00100\u001A\b\u0012\u0004\u0012\u00020/0.X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u00101\u001A\u000202X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u0014\u00103\u001A\b\u0012\u0004\u0012\u00020/0.X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u0012\u00104\u001A\u0004\u0018\u000105X\u0082\u000E\u00A2\u0006\u0004\n\u0002\u00106R\u0014\u00107\u001A\b\u0012\u0004\u0012\u00020908X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u0014\u0010:\u001A\b\u0012\u0004\u0012\u00020;08X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u0014\u0010<\u001A\b\u0012\u0004\u0012\u00020>0=X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010?\u001A\u000202X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u0014\u0010@\u001A\b\u0012\u0004\u0012\u00020>0AX\u0082\u000E\u00A2\u0006\u0002\n\u0000R\u000E\u0010B\u001A\u00020CX\u0082\u000E\u00A2\u0006\u0002\n\u0000R$\u0010E\u001A\u00020C2\u0006\u0010D\u001A\u00020C8V@VX\u0096\u000E\u00A2\u0006\f\u001A\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0014\u0010J\u001A\b\u0012\u0004\u0012\u00020>0=X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u0014\u0010K\u001A\b\u0012\u0004\u0012\u00020/0.X\u0082\u0004\u00A2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00A8\u0006\u00A1\u0001"}, d2 = {"Lcom/onesignal/inAppMessages/internal/InAppMessagesManager;", "Lcom/onesignal/inAppMessages/IInAppMessagesManager;", "Lcom/onesignal/core/internal/startup/IStartableService;", "Lcom/onesignal/user/internal/subscriptions/ISubscriptionChangedHandler;", "Lcom/onesignal/common/modeling/ISingletonModelStoreChangeHandler;", "Lcom/onesignal/core/internal/config/ConfigModel;", "Lcom/onesignal/inAppMessages/internal/lifecycle/IInAppLifecycleEventHandler;", "Lcom/onesignal/inAppMessages/internal/triggers/ITriggerHandler;", "Lcom/onesignal/session/internal/session/ISessionLifecycleHandler;", "Lcom/onesignal/core/internal/application/IApplicationLifecycleHandler;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_sessionService", "Lcom/onesignal/session/internal/session/ISessionService;", "_influenceManager", "Lcom/onesignal/session/internal/influence/IInfluenceManager;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_userManager", "Lcom/onesignal/user/IUserManager;", "_subscriptionManager", "Lcom/onesignal/user/internal/subscriptions/ISubscriptionManager;", "_outcomeEventsController", "Lcom/onesignal/session/internal/outcomes/IOutcomeEventsController;", "_state", "Lcom/onesignal/inAppMessages/internal/state/InAppStateService;", "_prefs", "Lcom/onesignal/inAppMessages/internal/preferences/IInAppPreferencesController;", "_repository", "Lcom/onesignal/inAppMessages/internal/repositories/IInAppRepository;", "_backend", "Lcom/onesignal/inAppMessages/internal/backend/IInAppBackendService;", "_triggerController", "Lcom/onesignal/inAppMessages/internal/triggers/ITriggerController;", "_triggerModelStore", "Lcom/onesignal/inAppMessages/internal/triggers/TriggerModelStore;", "_displayer", "Lcom/onesignal/inAppMessages/internal/display/IInAppDisplayer;", "_lifecycle", "Lcom/onesignal/inAppMessages/internal/lifecycle/IInAppLifecycleService;", "_languageContext", "Lcom/onesignal/core/internal/language/ILanguageContext;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/session/internal/session/ISessionService;Lcom/onesignal/session/internal/influence/IInfluenceManager;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/user/IUserManager;Lcom/onesignal/user/internal/subscriptions/ISubscriptionManager;Lcom/onesignal/session/internal/outcomes/IOutcomeEventsController;Lcom/onesignal/inAppMessages/internal/state/InAppStateService;Lcom/onesignal/inAppMessages/internal/preferences/IInAppPreferencesController;Lcom/onesignal/inAppMessages/internal/repositories/IInAppRepository;Lcom/onesignal/inAppMessages/internal/backend/IInAppBackendService;Lcom/onesignal/inAppMessages/internal/triggers/ITriggerController;Lcom/onesignal/inAppMessages/internal/triggers/TriggerModelStore;Lcom/onesignal/inAppMessages/internal/display/IInAppDisplayer;Lcom/onesignal/inAppMessages/internal/lifecycle/IInAppLifecycleService;Lcom/onesignal/core/internal/language/ILanguageContext;Lcom/onesignal/core/internal/time/ITime;)V", "clickedClickIds", "", "", "dismissedMessages", "fetchIAMMutex", "Lkotlinx/coroutines/sync/Mutex;", "impressionedMessages", "lastTimeFetchedIAMs", "", "Ljava/lang/Long;", "lifecycleCallback", "Lcom/onesignal/common/events/EventProducer;", "Lcom/onesignal/inAppMessages/IInAppMessageLifecycleListener;", "messageClickCallback", "Lcom/onesignal/inAppMessages/IInAppMessageClickListener;", "messageDisplayQueue", "", "Lcom/onesignal/inAppMessages/internal/InAppMessage;", "messageDisplayQueueMutex", "messages", "", "onFocusCalled", "", "value", "paused", "getPaused", "()Z", "setPaused", "(Z)V", "redisplayedInAppMessages", "viewedPageIds", "addClickListener", "", "listener", "addLifecycleListener", "addTrigger", "key", "addTriggers", "triggers", "", "attemptToShowInAppMessage", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "beginProcessingPrompts", "message", "prompts", "Lcom/onesignal/inAppMessages/internal/prompt/impl/InAppMessagePrompt;", "(Lcom/onesignal/inAppMessages/internal/InAppMessage;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearTriggers", "evaluateInAppMessages", "fetchMessages", "fireClickAction", "action", "Lcom/onesignal/inAppMessages/internal/InAppMessageClickResult;", "fireOutcomesForClick", "messageId", "outcomes", "Lcom/onesignal/inAppMessages/internal/InAppMessageOutcome;", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "firePublicClickHandler", "(Lcom/onesignal/inAppMessages/internal/InAppMessage;Lcom/onesignal/inAppMessages/internal/InAppMessageClickResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fireRESTCallForClick", "fireRESTCallForPageChange", "page", "Lcom/onesignal/inAppMessages/internal/InAppMessagePage;", "(Lcom/onesignal/inAppMessages/internal/InAppMessage;Lcom/onesignal/inAppMessages/internal/InAppMessagePage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fireTagCallForClick", "hasMessageTriggerChanged", "logInAppMessagePreviewActions", "makeRedisplayMessagesAvailableWithTriggers", "newTriggersKeys", "", "messageWasDismissed", "failed", "(Lcom/onesignal/inAppMessages/internal/InAppMessage;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onFocus", "onMessageActionOccurredOnMessage", "onMessageActionOccurredOnPreview", "onMessagePageChanged", "onMessageWasDismissed", "onMessageWasDisplayed", "onMessageWillDismiss", "onMessageWillDisplay", "onModelReplaced", "model", "tag", "onModelUpdated", "args", "Lcom/onesignal/common/modeling/ModelChangedArgs;", "onSessionActive", "onSessionEnded", "duration", "onSessionStarted", "onSubscriptionAdded", "subscription", "Lcom/onesignal/user/subscriptions/ISubscription;", "onSubscriptionChanged", "onSubscriptionRemoved", "onTriggerChanged", "newTriggerKey", "onTriggerCompleted", "triggerId", "onTriggerConditionChanged", "onUnfocused", "persistInAppMessage", "(Lcom/onesignal/inAppMessages/internal/InAppMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queueMessageForDisplay", "removeClickListener", "removeLifecycleListener", "removeTrigger", "removeTriggers", "keys", "setDataForRedisplay", "showAlertDialogMessage", "inAppMessage", "showMultiplePrompts", "start", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class InAppMessagesManager implements ISingletonModelStoreChangeHandler, IApplicationLifecycleHandler, IStartableService, IInAppMessagesManager, IInAppLifecycleEventHandler, ITriggerHandler, ISessionLifecycleHandler, ISubscriptionChangedHandler {
    private final IApplicationService _applicationService;
    private final IInAppBackendService _backend;
    private final ConfigModelStore _configModelStore;
    private final IInAppDisplayer _displayer;
    private final IInfluenceManager _influenceManager;
    private final ILanguageContext _languageContext;
    private final IInAppLifecycleService _lifecycle;
    private final IOutcomeEventsController _outcomeEventsController;
    private final IInAppPreferencesController _prefs;
    private final IInAppRepository _repository;
    private final ISessionService _sessionService;
    private final InAppStateService _state;
    private final ISubscriptionManager _subscriptionManager;
    private final ITime _time;
    private final ITriggerController _triggerController;
    private final TriggerModelStore _triggerModelStore;
    private final IUserManager _userManager;
    private final Set clickedClickIds;
    private final Set dismissedMessages;
    private final Mutex fetchIAMMutex;
    private final Set impressionedMessages;
    private Long lastTimeFetchedIAMs;
    private final EventProducer lifecycleCallback;
    private final EventProducer messageClickCallback;
    private final List messageDisplayQueue;
    private final Mutex messageDisplayQueueMutex;
    private List messages;
    private boolean onFocusCalled;
    private final List redisplayedInAppMessages;
    private final Set viewedPageIds;

    // 检测为 Lambda 实现
    public static void $r8$lambda$MLBJj_Ls45pAFK2C6b0wM-z-GQo(InAppMessagesManager inAppMessagesManager0, InAppMessage inAppMessage0, List list0, DialogInterface dialogInterface0, int v) [...]

    public InAppMessagesManager(IApplicationService iApplicationService0, ISessionService iSessionService0, IInfluenceManager iInfluenceManager0, ConfigModelStore configModelStore0, IUserManager iUserManager0, ISubscriptionManager iSubscriptionManager0, IOutcomeEventsController iOutcomeEventsController0, InAppStateService inAppStateService0, IInAppPreferencesController iInAppPreferencesController0, IInAppRepository iInAppRepository0, IInAppBackendService iInAppBackendService0, ITriggerController iTriggerController0, TriggerModelStore triggerModelStore0, IInAppDisplayer iInAppDisplayer0, IInAppLifecycleService iInAppLifecycleService0, ILanguageContext iLanguageContext0, ITime iTime0) {
        Intrinsics.checkNotNullParameter(iApplicationService0, "_applicationService");
        Intrinsics.checkNotNullParameter(iSessionService0, "_sessionService");
        Intrinsics.checkNotNullParameter(iInfluenceManager0, "_influenceManager");
        Intrinsics.checkNotNullParameter(configModelStore0, "_configModelStore");
        Intrinsics.checkNotNullParameter(iUserManager0, "_userManager");
        Intrinsics.checkNotNullParameter(iSubscriptionManager0, "_subscriptionManager");
        Intrinsics.checkNotNullParameter(iOutcomeEventsController0, "_outcomeEventsController");
        Intrinsics.checkNotNullParameter(inAppStateService0, "_state");
        Intrinsics.checkNotNullParameter(iInAppPreferencesController0, "_prefs");
        Intrinsics.checkNotNullParameter(iInAppRepository0, "_repository");
        Intrinsics.checkNotNullParameter(iInAppBackendService0, "_backend");
        Intrinsics.checkNotNullParameter(iTriggerController0, "_triggerController");
        Intrinsics.checkNotNullParameter(triggerModelStore0, "_triggerModelStore");
        Intrinsics.checkNotNullParameter(iInAppDisplayer0, "_displayer");
        Intrinsics.checkNotNullParameter(iInAppLifecycleService0, "_lifecycle");
        Intrinsics.checkNotNullParameter(iLanguageContext0, "_languageContext");
        Intrinsics.checkNotNullParameter(iTime0, "_time");
        super();
        this._applicationService = iApplicationService0;
        this._sessionService = iSessionService0;
        this._influenceManager = iInfluenceManager0;
        this._configModelStore = configModelStore0;
        this._userManager = iUserManager0;
        this._subscriptionManager = iSubscriptionManager0;
        this._outcomeEventsController = iOutcomeEventsController0;
        this._state = inAppStateService0;
        this._prefs = iInAppPreferencesController0;
        this._repository = iInAppRepository0;
        this._backend = iInAppBackendService0;
        this._triggerController = iTriggerController0;
        this._triggerModelStore = triggerModelStore0;
        this._displayer = iInAppDisplayer0;
        this._lifecycle = iInAppLifecycleService0;
        this._languageContext = iLanguageContext0;
        this._time = iTime0;
        this.lifecycleCallback = new EventProducer();
        this.messageClickCallback = new EventProducer();
        this.messages = CollectionsKt.emptyList();
        this.dismissedMessages = new LinkedHashSet();
        this.impressionedMessages = new LinkedHashSet();
        this.viewedPageIds = new LinkedHashSet();
        this.clickedClickIds = new LinkedHashSet();
        this.messageDisplayQueue = new ArrayList();
        this.messageDisplayQueueMutex = MutexKt.Mutex$default(false, 1, null);
        this.redisplayedInAppMessages = new ArrayList();
        this.fetchIAMMutex = MutexKt.Mutex$default(false, 1, null);
    }

    @Override  // com.onesignal.inAppMessages.IInAppMessagesManager
    public void addClickListener(IInAppMessageClickListener iInAppMessageClickListener0) {
        Intrinsics.checkNotNullParameter(iInAppMessageClickListener0, "listener");
        Logging.debug$default(("InAppMessagesManager.addClickListener(listener: " + iInAppMessageClickListener0 + ')'), null, 2, null);
        this.messageClickCallback.subscribe(iInAppMessageClickListener0);
    }

    @Override  // com.onesignal.inAppMessages.IInAppMessagesManager
    public void addLifecycleListener(IInAppMessageLifecycleListener iInAppMessageLifecycleListener0) {
        Intrinsics.checkNotNullParameter(iInAppMessageLifecycleListener0, "listener");
        Logging.debug$default(("InAppMessagesManager.addLifecycleListener(listener: " + iInAppMessageLifecycleListener0 + ')'), null, 2, null);
        this.lifecycleCallback.subscribe(iInAppMessageLifecycleListener0);
    }

    @Override  // com.onesignal.inAppMessages.IInAppMessagesManager
    public void addTrigger(String s, String s1) {
        Intrinsics.checkNotNullParameter(s, "key");
        Intrinsics.checkNotNullParameter(s1, "value");
        Logging.debug$default(("InAppMessagesManager.addTrigger(key: " + s + ", value: " + s1 + ')'), null, 2, null);
        TriggerModel triggerModel0 = (TriggerModel)this._triggerModelStore.get(s);
        if(triggerModel0 != null) {
            triggerModel0.setValue(s1);
            return;
        }
        TriggerModel triggerModel1 = new TriggerModel();
        triggerModel1.setId(s);
        triggerModel1.setKey(s);
        triggerModel1.setValue(s1);
        DefaultImpls.add$default(this._triggerModelStore, triggerModel1, null, 2, null);
    }

    @Override  // com.onesignal.inAppMessages.IInAppMessagesManager
    public void addTriggers(Map map0) {
        Intrinsics.checkNotNullParameter(map0, "triggers");
        Logging.debug$default(("InAppMessagesManager.addTriggers(triggers: " + map0 + ')'), null, 2, null);
        for(Object object0: map0.entrySet()) {
            this.addTrigger(((String)((Map.Entry)object0).getKey()), ((String)((Map.Entry)object0).getValue()));
        }
    }

    private final Object attemptToShowInAppMessage(Continuation continuation0) {
        InAppMessagesManager inAppMessagesManager0;
        ObjectRef ref$ObjectRef0;
        Mutex mutex1;
        ObjectRef ref$ObjectRef2;
        com.onesignal.inAppMessages.internal.InAppMessagesManager.attemptToShowInAppMessage.1 inAppMessagesManager$attemptToShowInAppMessage$10;
        if(continuation0 instanceof com.onesignal.inAppMessages.internal.InAppMessagesManager.attemptToShowInAppMessage.1) {
            inAppMessagesManager$attemptToShowInAppMessage$10 = (com.onesignal.inAppMessages.internal.InAppMessagesManager.attemptToShowInAppMessage.1)continuation0;
            if((inAppMessagesManager$attemptToShowInAppMessage$10.label & 0x80000000) == 0) {
                inAppMessagesManager$attemptToShowInAppMessage$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.attemptToShowInAppMessage(this);
                    }
                };
            }
            else {
                inAppMessagesManager$attemptToShowInAppMessage$10.label ^= 0x80000000;
            }
        }
        else {
            inAppMessagesManager$attemptToShowInAppMessage$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                Object L$2;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.attemptToShowInAppMessage(this);
                }
            };
        }
        Object object0 = inAppMessagesManager$attemptToShowInAppMessage$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(inAppMessagesManager$attemptToShowInAppMessage$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                inAppMessagesManager$attemptToShowInAppMessage$10.L$0 = this;
                inAppMessagesManager$attemptToShowInAppMessage$10.label = 1;
                object0 = this._applicationService.waitUntilSystemConditionsAvailable(inAppMessagesManager$attemptToShowInAppMessage$10);
                if(object0 == object1) {
                    return object1;
                }
                inAppMessagesManager0 = this;
                break;
            }
            case 1: {
                inAppMessagesManager0 = (InAppMessagesManager)inAppMessagesManager$attemptToShowInAppMessage$10.L$0;
                ResultKt.throwOnFailure(object0);
                break;
            }
            case 2: {
                Mutex mutex0 = (Mutex)inAppMessagesManager$attemptToShowInAppMessage$10.L$2;
                ObjectRef ref$ObjectRef1 = (ObjectRef)inAppMessagesManager$attemptToShowInAppMessage$10.L$1;
                InAppMessagesManager inAppMessagesManager1 = (InAppMessagesManager)inAppMessagesManager$attemptToShowInAppMessage$10.L$0;
                ResultKt.throwOnFailure(object0);
                ref$ObjectRef2 = ref$ObjectRef1;
                mutex1 = mutex0;
                inAppMessagesManager0 = inAppMessagesManager1;
                goto label_49;
            }
            case 3: {
                ref$ObjectRef0 = (ObjectRef)inAppMessagesManager$attemptToShowInAppMessage$10.L$1;
                inAppMessagesManager0 = (InAppMessagesManager)inAppMessagesManager$attemptToShowInAppMessage$10.L$0;
                ResultKt.throwOnFailure(object0);
                goto label_80;
            }
            case 4: {
                ResultKt.throwOnFailure(object0);
                return Unit.INSTANCE;
            }
            case 5: {
                ResultKt.throwOnFailure(object0);
                return Unit.INSTANCE;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(!((Boolean)object0).booleanValue()) {
            Logging.warn$default("InAppMessagesManager.attemptToShowInAppMessage: In app message not showing due to system condition not correct", null, 2, null);
            return Unit.INSTANCE;
        }
        ref$ObjectRef2 = new ObjectRef();
        mutex1 = inAppMessagesManager0.messageDisplayQueueMutex;
        inAppMessagesManager$attemptToShowInAppMessage$10.L$0 = inAppMessagesManager0;
        inAppMessagesManager$attemptToShowInAppMessage$10.L$1 = ref$ObjectRef2;
        inAppMessagesManager$attemptToShowInAppMessage$10.L$2 = mutex1;
        inAppMessagesManager$attemptToShowInAppMessage$10.label = 2;
        if(mutex1.lock(null, inAppMessagesManager$attemptToShowInAppMessage$10) == object1) {
            return object1;
        }
    label_49:
        try {
            Logging.debug$default(("InAppMessagesManager.attemptToShowInAppMessage: " + inAppMessagesManager0.messageDisplayQueue), null, 2, null);
            if(inAppMessagesManager0.getPaused()) {
                Logging.warn$default("InAppMessagesManager.attemptToShowInAppMessage: In app messaging is currently paused, in app messages will not be shown!", null, 2, null);
            }
            else if(inAppMessagesManager0.messageDisplayQueue.isEmpty()) {
                Logging.debug$default("InAppMessagesManager.attemptToShowInAppMessage: There are no IAMs left in the queue!", null, 2, null);
            }
            else if(inAppMessagesManager0._state.getInAppMessageIdShowing() == null) {
                Logging.debug$default("InAppMessagesManager.attemptToShowInAppMessage: No IAM showing currently, showing first item in the queue!", null, 2, null);
                ref$ObjectRef2.element = inAppMessagesManager0.messageDisplayQueue.remove(0);
                Object object2 = ref$ObjectRef2.element;
                Intrinsics.checkNotNull(object2);
                inAppMessagesManager0._state.setInAppMessageIdShowing(((InAppMessage)object2).getMessageId());
            }
            else {
                Logging.debug$default("InAppMessagesManager.attemptToShowInAppMessage: There is an IAM currently showing!", null, 2, null);
            }
        }
        finally {
            mutex1.unlock(null);
        }
        if(ref$ObjectRef2.element != null) {
            Object object3 = ref$ObjectRef2.element;
            Intrinsics.checkNotNull(object3);
            inAppMessagesManager$attemptToShowInAppMessage$10.L$0 = inAppMessagesManager0;
            inAppMessagesManager$attemptToShowInAppMessage$10.L$1 = ref$ObjectRef2;
            inAppMessagesManager$attemptToShowInAppMessage$10.L$2 = null;
            inAppMessagesManager$attemptToShowInAppMessage$10.label = 3;
            Object object4 = inAppMessagesManager0._displayer.displayMessage(((InAppMessage)object3), inAppMessagesManager$attemptToShowInAppMessage$10);
            if(object4 == object1) {
                return object1;
            }
            ref$ObjectRef0 = ref$ObjectRef2;
            object0 = object4;
        label_80:
            if(((Boolean)object0) == null) {
                inAppMessagesManager0._state.setInAppMessageIdShowing(null);
                Object object5 = ref$ObjectRef0.element;
                Intrinsics.checkNotNull(object5);
                inAppMessagesManager$attemptToShowInAppMessage$10.L$0 = null;
                inAppMessagesManager$attemptToShowInAppMessage$10.L$1 = null;
                inAppMessagesManager$attemptToShowInAppMessage$10.label = 4;
                return inAppMessagesManager0.queueMessageForDisplay(((InAppMessage)object5), inAppMessagesManager$attemptToShowInAppMessage$10) == object1 ? object1 : Unit.INSTANCE;
            }
            if(Intrinsics.areEqual(((Boolean)object0), Boxing.boxBoolean(false))) {
                inAppMessagesManager0._state.setInAppMessageIdShowing(null);
                Object object6 = ref$ObjectRef0.element;
                Intrinsics.checkNotNull(object6);
                inAppMessagesManager$attemptToShowInAppMessage$10.L$0 = null;
                inAppMessagesManager$attemptToShowInAppMessage$10.L$1 = null;
                inAppMessagesManager$attemptToShowInAppMessage$10.label = 5;
                return inAppMessagesManager0.messageWasDismissed(((InAppMessage)object6), true, inAppMessagesManager$attemptToShowInAppMessage$10) == object1 ? object1 : Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }

    private final Object beginProcessingPrompts(InAppMessage inAppMessage0, List list0, Continuation continuation0) {
        if(!list0.isEmpty() != 0) {
            Logging.debug$default(("InAppMessagesManager.beginProcessingPrompts: IAM showing prompts from IAM: " + inAppMessage0), null, 2, null);
            this._displayer.dismissCurrentInAppMessage();
            Object object0 = this.showMultiplePrompts(inAppMessage0, list0, continuation0);
            return object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object0 : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    @Override  // com.onesignal.inAppMessages.IInAppMessagesManager
    public void clearTriggers() {
        Logging.debug$default("InAppMessagesManager.clearTriggers()", null, 2, null);
        DefaultImpls.clear$default(this._triggerModelStore, null, 1, null);
    }

    private final Object evaluateInAppMessages(Continuation continuation0) {
        Iterator iterator0;
        InAppMessagesManager inAppMessagesManager0;
        com.onesignal.inAppMessages.internal.InAppMessagesManager.evaluateInAppMessages.1 inAppMessagesManager$evaluateInAppMessages$10;
        if(continuation0 instanceof com.onesignal.inAppMessages.internal.InAppMessagesManager.evaluateInAppMessages.1) {
            inAppMessagesManager$evaluateInAppMessages$10 = (com.onesignal.inAppMessages.internal.InAppMessagesManager.evaluateInAppMessages.1)continuation0;
            if((inAppMessagesManager$evaluateInAppMessages$10.label & 0x80000000) == 0) {
                inAppMessagesManager$evaluateInAppMessages$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.evaluateInAppMessages(this);
                    }
                };
            }
            else {
                inAppMessagesManager$evaluateInAppMessages$10.label ^= 0x80000000;
            }
        }
        else {
            inAppMessagesManager$evaluateInAppMessages$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.evaluateInAppMessages(this);
                }
            };
        }
        Object object0 = inAppMessagesManager$evaluateInAppMessages$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(inAppMessagesManager$evaluateInAppMessages$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                Logging.debug$default("InAppMessagesManager.evaluateInAppMessages()", null, 2, null);
                inAppMessagesManager0 = this;
                iterator0 = this.messages.iterator();
                break;
            }
            case 1: {
                iterator0 = (Iterator)inAppMessagesManager$evaluateInAppMessages$10.L$1;
                inAppMessagesManager0 = (InAppMessagesManager)inAppMessagesManager$evaluateInAppMessages$10.L$0;
                ResultKt.throwOnFailure(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        while(iterator0.hasNext()) {
            Object object2 = iterator0.next();
            InAppMessage inAppMessage0 = (InAppMessage)object2;
            if(inAppMessagesManager0._triggerController.evaluateMessageTriggers(inAppMessage0)) {
                inAppMessagesManager0.setDataForRedisplay(inAppMessage0);
                if(!inAppMessagesManager0.dismissedMessages.contains(inAppMessage0.getMessageId()) && !inAppMessage0.isFinished()) {
                    inAppMessagesManager$evaluateInAppMessages$10.L$0 = inAppMessagesManager0;
                    inAppMessagesManager$evaluateInAppMessages$10.L$1 = iterator0;
                    inAppMessagesManager$evaluateInAppMessages$10.label = 1;
                    if(inAppMessagesManager0.queueMessageForDisplay(inAppMessage0, inAppMessagesManager$evaluateInAppMessages$10) == object1) {
                        return object1;
                    }
                    if(false) {
                        break;
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }

    private final Object fetchMessages(Continuation continuation0) {
        InAppMessagesManager inAppMessagesManager0;
        Mutex mutex1;
        String s2;
        String s;
        com.onesignal.inAppMessages.internal.InAppMessagesManager.fetchMessages.1 inAppMessagesManager$fetchMessages$10;
        if(continuation0 instanceof com.onesignal.inAppMessages.internal.InAppMessagesManager.fetchMessages.1) {
            inAppMessagesManager$fetchMessages$10 = (com.onesignal.inAppMessages.internal.InAppMessagesManager.fetchMessages.1)continuation0;
            if((inAppMessagesManager$fetchMessages$10.label & 0x80000000) == 0) {
                inAppMessagesManager$fetchMessages$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.fetchMessages(this);
                    }
                };
            }
            else {
                inAppMessagesManager$fetchMessages$10.label ^= 0x80000000;
            }
        }
        else {
            inAppMessagesManager$fetchMessages$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.fetchMessages(this);
                }
            };
        }
        Object object0 = inAppMessagesManager$fetchMessages$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(inAppMessagesManager$fetchMessages$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                if(!this._applicationService.isInForeground()) {
                    return Unit.INSTANCE;
                }
                s = ((ConfigModel)this._configModelStore.getModel()).getAppId();
                String s1 = this._subscriptionManager.getSubscriptions().getPush().getId();
                if(s1.length() != 0 && !IDManager.INSTANCE.isLocalId(s1) && s.length() != 0) {
                    Mutex mutex0 = this.fetchIAMMutex;
                    inAppMessagesManager$fetchMessages$10.L$0 = this;
                    inAppMessagesManager$fetchMessages$10.L$1 = s;
                    inAppMessagesManager$fetchMessages$10.L$2 = s1;
                    inAppMessagesManager$fetchMessages$10.L$3 = mutex0;
                    inAppMessagesManager$fetchMessages$10.label = 1;
                    if(mutex0.lock(null, inAppMessagesManager$fetchMessages$10) == object1) {
                        return object1;
                    }
                    s2 = s1;
                    mutex1 = mutex0;
                    inAppMessagesManager0 = this;
                    goto label_40;
                }
                return Unit.INSTANCE;
            }
            case 1: {
                Mutex mutex2 = (Mutex)inAppMessagesManager$fetchMessages$10.L$3;
                s2 = (String)inAppMessagesManager$fetchMessages$10.L$2;
                s = (String)inAppMessagesManager$fetchMessages$10.L$1;
                InAppMessagesManager inAppMessagesManager1 = (InAppMessagesManager)inAppMessagesManager$fetchMessages$10.L$0;
                ResultKt.throwOnFailure(object0);
                mutex1 = mutex2;
                inAppMessagesManager0 = inAppMessagesManager1;
            label_40:
                try {
                    long v1 = inAppMessagesManager0._time.getCurrentTimeMillis();
                    Long long0 = inAppMessagesManager0.lastTimeFetchedIAMs;
                    if(long0 != null) {
                        Intrinsics.checkNotNull(long0);
                        if(v1 - ((long)long0) < ((ConfigModel)inAppMessagesManager0._configModelStore.getModel()).getFetchIAMMinInterval()) {
                            return Unit.INSTANCE;
                        }
                    }
                    inAppMessagesManager0.lastTimeFetchedIAMs = Boxing.boxLong(v1);
                }
                finally {
                    mutex1.unlock(null);
                }
                inAppMessagesManager$fetchMessages$10.L$0 = inAppMessagesManager0;
                inAppMessagesManager$fetchMessages$10.L$1 = null;
                inAppMessagesManager$fetchMessages$10.L$2 = null;
                inAppMessagesManager$fetchMessages$10.L$3 = null;
                inAppMessagesManager$fetchMessages$10.label = 2;
                object0 = inAppMessagesManager0._backend.listInAppMessages(s, s2, inAppMessagesManager$fetchMessages$10);
                if(object0 == object1) {
                    return object1;
                }
                goto label_62;
            }
            case 2: {
                break;
            }
            case 3: {
                ResultKt.throwOnFailure(object0);
                return Unit.INSTANCE;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        inAppMessagesManager0 = (InAppMessagesManager)inAppMessagesManager$fetchMessages$10.L$0;
        ResultKt.throwOnFailure(object0);
    label_62:
        if(((List)object0) != null) {
            inAppMessagesManager0.messages = (List)object0;
            inAppMessagesManager$fetchMessages$10.L$0 = null;
            inAppMessagesManager$fetchMessages$10.label = 3;
            return inAppMessagesManager0.evaluateInAppMessages(inAppMessagesManager$fetchMessages$10) == object1 ? object1 : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    private final void fireClickAction(InAppMessageClickResult inAppMessageClickResult0) {
        if(inAppMessageClickResult0.getUrl() != null && inAppMessageClickResult0.getUrl().length() > 0) {
            if(inAppMessageClickResult0.getUrlTarget() == InAppMessageActionUrlType.BROWSER) {
                Context context0 = this._applicationService.getAppContext();
                AndroidUtils.INSTANCE.openURLInBrowser(context0, inAppMessageClickResult0.getUrl());
                return;
            }
            if(inAppMessageClickResult0.getUrlTarget() == InAppMessageActionUrlType.IN_APP_WEBVIEW) {
                Context context1 = this._applicationService.getAppContext();
                OneSignalChromeTab.INSTANCE.open$com_onesignal_inAppMessages(inAppMessageClickResult0.getUrl(), true, context1);
            }
        }
    }

    private final Object fireOutcomesForClick(String s, List list0, Continuation continuation0) {
        Iterator iterator0;
        InAppMessagesManager inAppMessagesManager0;
        com.onesignal.inAppMessages.internal.InAppMessagesManager.fireOutcomesForClick.1 inAppMessagesManager$fireOutcomesForClick$10;
        if(continuation0 instanceof com.onesignal.inAppMessages.internal.InAppMessagesManager.fireOutcomesForClick.1) {
            inAppMessagesManager$fireOutcomesForClick$10 = (com.onesignal.inAppMessages.internal.InAppMessagesManager.fireOutcomesForClick.1)continuation0;
            if((inAppMessagesManager$fireOutcomesForClick$10.label & 0x80000000) == 0) {
                inAppMessagesManager$fireOutcomesForClick$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.fireOutcomesForClick(null, null, this);
                    }
                };
            }
            else {
                inAppMessagesManager$fireOutcomesForClick$10.label ^= 0x80000000;
            }
        }
        else {
            inAppMessagesManager$fireOutcomesForClick$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.fireOutcomesForClick(null, null, this);
                }
            };
        }
        Object object0 = inAppMessagesManager$fireOutcomesForClick$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(inAppMessagesManager$fireOutcomesForClick$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                this._influenceManager.onDirectInfluenceFromIAM(s);
                inAppMessagesManager0 = this;
                iterator0 = list0.iterator();
                break;
            }
            case 1: 
            case 2: 
            case 3: {
                iterator0 = (Iterator)inAppMessagesManager$fireOutcomesForClick$10.L$1;
                inAppMessagesManager0 = (InAppMessagesManager)inAppMessagesManager$fireOutcomesForClick$10.L$0;
                ResultKt.throwOnFailure(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        while(iterator0.hasNext()) {
            Object object2 = iterator0.next();
            InAppMessageOutcome inAppMessageOutcome0 = (InAppMessageOutcome)object2;
            String s1 = inAppMessageOutcome0.getName();
            if(inAppMessageOutcome0.isUnique()) {
                inAppMessagesManager$fireOutcomesForClick$10.L$0 = inAppMessagesManager0;
                inAppMessagesManager$fireOutcomesForClick$10.L$1 = iterator0;
                inAppMessagesManager$fireOutcomesForClick$10.label = 1;
                if(inAppMessagesManager0._outcomeEventsController.sendUniqueOutcomeEvent(s1, inAppMessagesManager$fireOutcomesForClick$10) != object1) {
                    continue;
                }
                return object1;
            }
            if(inAppMessageOutcome0.getWeight() > 0.0f) {
                inAppMessagesManager$fireOutcomesForClick$10.L$0 = inAppMessagesManager0;
                inAppMessagesManager$fireOutcomesForClick$10.L$1 = iterator0;
                inAppMessagesManager$fireOutcomesForClick$10.label = 2;
                if(inAppMessagesManager0._outcomeEventsController.sendOutcomeEventWithValue(s1, inAppMessageOutcome0.getWeight(), inAppMessagesManager$fireOutcomesForClick$10) != object1) {
                    continue;
                }
                return object1;
            }
            inAppMessagesManager$fireOutcomesForClick$10.L$0 = inAppMessagesManager0;
            inAppMessagesManager$fireOutcomesForClick$10.L$1 = iterator0;
            inAppMessagesManager$fireOutcomesForClick$10.label = 3;
            if(inAppMessagesManager0._outcomeEventsController.sendOutcomeEvent(s1, inAppMessagesManager$fireOutcomesForClick$10) == object1) {
                return object1;
            }
            if(false) {
                break;
            }
        }
        return Unit.INSTANCE;
    }

    private final Object firePublicClickHandler(InAppMessage inAppMessage0, InAppMessageClickResult inAppMessageClickResult0, Continuation continuation0) {
        if(!this.messageClickCallback.getHasSubscribers()) {
            return Unit.INSTANCE;
        }
        this._influenceManager.onDirectInfluenceFromIAM(inAppMessage0.getMessageId());
        com.onesignal.inAppMessages.internal.InAppMessagesManager.firePublicClickHandler.2 inAppMessagesManager$firePublicClickHandler$20 = new Function2(null) {
            final InAppMessageClickEvent $result;
            Object L$0;
            int label;

            {
                this.$result = inAppMessageClickEvent0;
                super(2, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object object0, Continuation continuation0) {
                com.onesignal.inAppMessages.internal.InAppMessagesManager.firePublicClickHandler.2 inAppMessagesManager$firePublicClickHandler$20 = new com.onesignal.inAppMessages.internal.InAppMessagesManager.firePublicClickHandler.2(this.$result, continuation0);
                inAppMessagesManager$firePublicClickHandler$20.L$0 = object0;
                return inAppMessagesManager$firePublicClickHandler$20;
            }

            public final Object invoke(IInAppMessageClickListener iInAppMessageClickListener0, Continuation continuation0) {
                return ((com.onesignal.inAppMessages.internal.InAppMessagesManager.firePublicClickHandler.2)this.create(iInAppMessageClickListener0, continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.jvm.functions.Function2
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((IInAppMessageClickListener)object0), ((Continuation)object1));
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                ResultKt.throwOnFailure(object0);
                ((IInAppMessageClickListener)this.L$0).onClick(this.$result);
                return Unit.INSTANCE;
            }
        };
        Object object0 = this.messageClickCallback.suspendingFireOnMain(inAppMessagesManager$firePublicClickHandler$20, continuation0);
        return object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object0 : Unit.INSTANCE;
    }

    private final Object fireRESTCallForClick(InAppMessage inAppMessage0, InAppMessageClickResult inAppMessageClickResult0, Continuation continuation0) {
        InAppMessage inAppMessage1;
        String s4;
        InAppMessagesManager inAppMessagesManager0;
        String s1;
        com.onesignal.inAppMessages.internal.InAppMessagesManager.fireRESTCallForClick.1 inAppMessagesManager$fireRESTCallForClick$10;
        if(continuation0 instanceof com.onesignal.inAppMessages.internal.InAppMessagesManager.fireRESTCallForClick.1) {
            inAppMessagesManager$fireRESTCallForClick$10 = (com.onesignal.inAppMessages.internal.InAppMessagesManager.fireRESTCallForClick.1)continuation0;
            if((inAppMessagesManager$fireRESTCallForClick$10.label & 0x80000000) == 0) {
                inAppMessagesManager$fireRESTCallForClick$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.fireRESTCallForClick(null, null, this);
                    }
                };
            }
            else {
                inAppMessagesManager$fireRESTCallForClick$10.label ^= 0x80000000;
            }
        }
        else {
            inAppMessagesManager$fireRESTCallForClick$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                Object L$2;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.fireRESTCallForClick(null, null, this);
                }
            };
        }
        Object object0 = inAppMessagesManager$fireRESTCallForClick$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(inAppMessagesManager$fireRESTCallForClick$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                String s = InAppHelper.INSTANCE.variantIdForMessage(inAppMessage0, this._languageContext);
                if(s == null) {
                    return Unit.INSTANCE;
                }
                s1 = inAppMessageClickResult0.getClickId();
                if((!inAppMessage0.getRedisplayStats().isRedisplayEnabled() || s1 == null || !inAppMessage0.isClickAvailable(s1)) && CollectionsKt.contains(this.clickedClickIds, s1)) {
                    return Unit.INSTANCE;
                }
                if(s1 != null) {
                    this.clickedClickIds.add(s1);
                    inAppMessage0.addClickId(s1);
                }
                try {
                    String s2 = ((ConfigModel)this._configModelStore.getModel()).getAppId();
                    String s3 = this._subscriptionManager.getSubscriptions().getPush().getId();
                    inAppMessagesManager$fireRESTCallForClick$10.L$0 = this;
                    inAppMessagesManager$fireRESTCallForClick$10.L$1 = inAppMessage0;
                    inAppMessagesManager$fireRESTCallForClick$10.L$2 = s1;
                    inAppMessagesManager$fireRESTCallForClick$10.label = 1;
                    if(this._backend.sendIAMClick(s2, s3, s, inAppMessage0.getMessageId(), s1, inAppMessageClickResult0.isFirstClick(), inAppMessagesManager$fireRESTCallForClick$10) == object1) {
                        return object1;
                    }
                }
                catch(BackendException unused_ex) {
                    inAppMessagesManager0 = this;
                    inAppMessage1 = inAppMessage0;
                    s4 = s1;
                    break;
                }
                inAppMessagesManager0 = this;
                goto label_41;
            }
            case 1: {
                s4 = (String)inAppMessagesManager$fireRESTCallForClick$10.L$2;
                inAppMessage1 = (InAppMessage)inAppMessagesManager$fireRESTCallForClick$10.L$1;
                inAppMessagesManager0 = (InAppMessagesManager)inAppMessagesManager$fireRESTCallForClick$10.L$0;
                try {
                    ResultKt.throwOnFailure(object0);
                    s1 = s4;
                    inAppMessage0 = inAppMessage1;
                    try {
                    label_41:
                        inAppMessagesManager0._prefs.setClickedMessagesId(inAppMessagesManager0.clickedClickIds);
                        return Unit.INSTANCE;
                    }
                    catch(BackendException unused_ex) {
                    }
                    inAppMessage1 = inAppMessage0;
                    s4 = s1;
                }
                catch(BackendException unused_ex) {
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        TypeIntrinsics.asMutableCollection(inAppMessagesManager0.clickedClickIds).remove(s4);
        if(s4 != null) {
            inAppMessage1.removeClickId(s4);
        }
        return Unit.INSTANCE;
    }

    private final Object fireRESTCallForPageChange(InAppMessage inAppMessage0, InAppMessagePage inAppMessagePage0, Continuation continuation0) {
        InAppMessagesManager inAppMessagesManager0;
        String s5;
        com.onesignal.inAppMessages.internal.InAppMessagesManager.fireRESTCallForPageChange.1 inAppMessagesManager$fireRESTCallForPageChange$10;
        if(continuation0 instanceof com.onesignal.inAppMessages.internal.InAppMessagesManager.fireRESTCallForPageChange.1) {
            inAppMessagesManager$fireRESTCallForPageChange$10 = (com.onesignal.inAppMessages.internal.InAppMessagesManager.fireRESTCallForPageChange.1)continuation0;
            if((inAppMessagesManager$fireRESTCallForPageChange$10.label & 0x80000000) == 0) {
                inAppMessagesManager$fireRESTCallForPageChange$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.fireRESTCallForPageChange(null, null, this);
                    }
                };
            }
            else {
                inAppMessagesManager$fireRESTCallForPageChange$10.label ^= 0x80000000;
            }
        }
        else {
            inAppMessagesManager$fireRESTCallForPageChange$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.fireRESTCallForPageChange(null, null, this);
                }
            };
        }
        Object object0 = inAppMessagesManager$fireRESTCallForPageChange$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(inAppMessagesManager$fireRESTCallForPageChange$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                String s = InAppHelper.INSTANCE.variantIdForMessage(inAppMessage0, this._languageContext);
                if(s == null) {
                    return Unit.INSTANCE;
                }
                String s1 = inAppMessagePage0.getPageId();
                String s2 = inAppMessage0.getMessageId() + s1;
                if(this.viewedPageIds.contains(s2)) {
                    Logging.verbose$default(("InAppMessagesManager: Already sent page impression for id: " + s1), null, 2, null);
                    return Unit.INSTANCE;
                }
                this.viewedPageIds.add(s2);
                try {
                    String s3 = ((ConfigModel)this._configModelStore.getModel()).getAppId();
                    String s4 = this._subscriptionManager.getSubscriptions().getPush().getId();
                    inAppMessagesManager$fireRESTCallForPageChange$10.L$0 = this;
                    inAppMessagesManager$fireRESTCallForPageChange$10.L$1 = s2;
                    inAppMessagesManager$fireRESTCallForPageChange$10.label = 1;
                    if(this._backend.sendIAMPageImpression(s3, s4, s, inAppMessage0.getMessageId(), s1, inAppMessagesManager$fireRESTCallForPageChange$10) == object1) {
                        return object1;
                    }
                }
                catch(BackendException unused_ex) {
                    s5 = s2;
                    inAppMessagesManager0 = this;
                    break;
                }
                s5 = s2;
                inAppMessagesManager0 = this;
                goto label_39;
            }
            case 1: {
                s5 = (String)inAppMessagesManager$fireRESTCallForPageChange$10.L$1;
                inAppMessagesManager0 = (InAppMessagesManager)inAppMessagesManager$fireRESTCallForPageChange$10.L$0;
                try {
                    ResultKt.throwOnFailure(object0);
                label_39:
                    inAppMessagesManager0._prefs.setViewPageImpressionedIds(inAppMessagesManager0.viewedPageIds);
                    return Unit.INSTANCE;
                }
                catch(BackendException unused_ex) {
                    break;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        inAppMessagesManager0.viewedPageIds.remove(s5);
        return Unit.INSTANCE;
    }

    private final void fireTagCallForClick(InAppMessageClickResult inAppMessageClickResult0) {
        if(inAppMessageClickResult0.getTags() != null) {
            InAppMessageTag inAppMessageTag0 = inAppMessageClickResult0.getTags();
            JSONArray jSONArray0 = null;
            if((inAppMessageTag0 == null ? null : inAppMessageTag0.getTagsToAdd()) != null) {
                JSONObject jSONObject0 = inAppMessageTag0.getTagsToAdd();
                Intrinsics.checkNotNull(jSONObject0);
                Map map0 = JSONUtils.INSTANCE.newStringMapFromJSONObject(jSONObject0);
                this._userManager.addTags(map0);
            }
            if((inAppMessageTag0 == null ? null : inAppMessageTag0.getTagsToRemove()) != null) {
                JSONUtils jSONUtils0 = JSONUtils.INSTANCE;
                if(inAppMessageTag0 != null) {
                    jSONArray0 = inAppMessageTag0.getTagsToRemove();
                }
                Intrinsics.checkNotNull(jSONArray0);
                Set set0 = jSONUtils0.newStringSetFromJSONArray(jSONArray0);
                this._userManager.removeTags(set0);
            }
        }
    }

    @Override  // com.onesignal.inAppMessages.IInAppMessagesManager
    public boolean getPaused() {
        return this._state.getPaused();
    }

    // 去混淆评级： 中等(60)
    private final boolean hasMessageTriggerChanged(InAppMessage inAppMessage0) {
        return this._triggerController.messageHasOnlyDynamicTriggers(inAppMessage0) ? !inAppMessage0.isDisplayedInSession() : inAppMessage0.isTriggerChanged() || !inAppMessage0.isDisplayedInSession() && inAppMessage0.getTriggers().isEmpty();
    }

    private final void logInAppMessagePreviewActions(InAppMessageClickResult inAppMessageClickResult0) {
        if(inAppMessageClickResult0.getTags() != null) {
            Logging.debug$default(("InAppMessagesManager.logInAppMessagePreviewActions: Tags detected inside of the action click payload, ignoring because action came from IAM preview:: " + inAppMessageClickResult0.getTags()), null, 2, null);
        }
        if(inAppMessageClickResult0.getOutcomes().size() > 0) {
            Logging.debug$default(("InAppMessagesManager.logInAppMessagePreviewActions: Outcomes detected inside of the action click payload, ignoring because action came from IAM preview: " + inAppMessageClickResult0.getOutcomes()), null, 2, null);
        }
    }

    private final void makeRedisplayMessagesAvailableWithTriggers(Collection collection0) {
        for(Object object0: this.messages) {
            InAppMessage inAppMessage0 = (InAppMessage)object0;
            if(!inAppMessage0.isTriggerChanged() && this.redisplayedInAppMessages.contains(inAppMessage0) && this._triggerController.isTriggerOnMessage(inAppMessage0, collection0)) {
                Logging.debug$default(("InAppMessagesManager.makeRedisplayMessagesAvailableWithTriggers: Trigger changed for message: " + inAppMessage0), null, 2, null);
                inAppMessage0.setTriggerChanged(true);
            }
        }
    }

    private final Object messageWasDismissed(InAppMessage inAppMessage0, boolean z, Continuation continuation0) {
        InAppMessagesManager inAppMessagesManager0;
        com.onesignal.inAppMessages.internal.InAppMessagesManager.messageWasDismissed.1 inAppMessagesManager$messageWasDismissed$10;
        if(continuation0 instanceof com.onesignal.inAppMessages.internal.InAppMessagesManager.messageWasDismissed.1) {
            inAppMessagesManager$messageWasDismissed$10 = (com.onesignal.inAppMessages.internal.InAppMessagesManager.messageWasDismissed.1)continuation0;
            if((inAppMessagesManager$messageWasDismissed$10.label & 0x80000000) == 0) {
                inAppMessagesManager$messageWasDismissed$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.messageWasDismissed(null, false, this);
                    }
                };
            }
            else {
                inAppMessagesManager$messageWasDismissed$10.label ^= 0x80000000;
            }
        }
        else {
            inAppMessagesManager$messageWasDismissed$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.messageWasDismissed(null, false, this);
                }
            };
        }
        Object object0 = inAppMessagesManager$messageWasDismissed$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(inAppMessagesManager$messageWasDismissed$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                if(inAppMessage0.isPreview()) {
                    inAppMessagesManager0 = this;
                }
                else {
                    this.dismissedMessages.add(inAppMessage0.getMessageId());
                    if(!z) {
                        this._prefs.setDismissedMessagesId(this.dismissedMessages);
                        Long long0 = Boxing.boxLong(this._time.getCurrentTimeMillis());
                        this._state.setLastTimeInAppDismissed(long0);
                        inAppMessagesManager$messageWasDismissed$10.L$0 = this;
                        inAppMessagesManager$messageWasDismissed$10.L$1 = inAppMessage0;
                        inAppMessagesManager$messageWasDismissed$10.label = 1;
                        if(this.persistInAppMessage(inAppMessage0, inAppMessagesManager$messageWasDismissed$10) == object1) {
                            return object1;
                        }
                    }
                    inAppMessagesManager0 = this;
                    Logging.debug$default(("InAppMessagesManager.messageWasDismissed: dismissedMessages: " + inAppMessagesManager0.dismissedMessages), null, 2, null);
                }
                break;
            }
            case 1: {
                inAppMessage0 = (InAppMessage)inAppMessagesManager$messageWasDismissed$10.L$1;
                inAppMessagesManager0 = (InAppMessagesManager)inAppMessagesManager$messageWasDismissed$10.L$0;
                ResultKt.throwOnFailure(object0);
                Logging.debug$default(("InAppMessagesManager.messageWasDismissed: dismissedMessages: " + inAppMessagesManager0.dismissedMessages), null, 2, null);
                break;
            }
            case 2: {
                ResultKt.throwOnFailure(object0);
                return Unit.INSTANCE;
            }
            case 3: {
                ResultKt.throwOnFailure(object0);
                return Unit.INSTANCE;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        inAppMessagesManager0._influenceManager.onInAppMessageDismissed();
        if(inAppMessagesManager0._state.getCurrentPrompt() != null) {
            Logging.debug$default("InAppMessagesManager.messageWasDismissed: Stop evaluateMessageDisplayQueue because prompt is currently displayed", null, 2, null);
            return Unit.INSTANCE;
        }
        if(inAppMessagesManager0.lifecycleCallback.getHasSubscribers()) {
            Function1 function10 = new Function1() {
                final InAppMessage $message;

                {
                    this.$message = inAppMessage0;
                    super(1);
                }

                @Override  // kotlin.jvm.functions.Function1
                public Object invoke(Object object0) {
                    this.invoke(((IInAppMessageLifecycleListener)object0));
                    return Unit.INSTANCE;
                }

                public final void invoke(IInAppMessageLifecycleListener iInAppMessageLifecycleListener0) {
                    Intrinsics.checkNotNullParameter(iInAppMessageLifecycleListener0, "it");
                    iInAppMessageLifecycleListener0.onDidDismiss(new InAppMessageLifecycleEvent(this.$message));
                }
            };
            inAppMessagesManager0.lifecycleCallback.fireOnMain(function10);
        }
        inAppMessagesManager0._state.setInAppMessageIdShowing(null);
        if(!inAppMessagesManager0.messageDisplayQueue.isEmpty() != 0) {
            Logging.debug$default("InAppMessagesManager.messageWasDismissed: In app message on queue available, attempting to show", null, 2, null);
            inAppMessagesManager$messageWasDismissed$10.L$0 = null;
            inAppMessagesManager$messageWasDismissed$10.L$1 = null;
            inAppMessagesManager$messageWasDismissed$10.label = 2;
            return inAppMessagesManager0.attemptToShowInAppMessage(inAppMessagesManager$messageWasDismissed$10) == object1 ? object1 : Unit.INSTANCE;
        }
        Logging.debug$default("InAppMessagesManager.messageWasDismissed: In app message dismissed evaluating messages", null, 2, null);
        inAppMessagesManager$messageWasDismissed$10.L$0 = null;
        inAppMessagesManager$messageWasDismissed$10.L$1 = null;
        inAppMessagesManager$messageWasDismissed$10.label = 3;
        return inAppMessagesManager0.evaluateInAppMessages(inAppMessagesManager$messageWasDismissed$10) == object1 ? object1 : Unit.INSTANCE;
    }

    static Object messageWasDismissed$default(InAppMessagesManager inAppMessagesManager0, InAppMessage inAppMessage0, boolean z, Continuation continuation0, int v, Object object0) {
        if((v & 2) != 0) {
            z = false;
        }
        return inAppMessagesManager0.messageWasDismissed(inAppMessage0, z, continuation0);
    }

    @Override  // com.onesignal.core.internal.application.IApplicationLifecycleHandler
    public void onFocus() {
        if(this.onFocusCalled) {
            return;
        }
        this.onFocusCalled = true;
        ThreadUtilsKt.suspendifyOnThread$default(0, new Function1(null) {
            int label;

            {
                InAppMessagesManager.this = inAppMessagesManager0;
                super(1, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation0) {
                return new com.onesignal.inAppMessages.internal.InAppMessagesManager.onFocus.1(InAppMessagesManager.this, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((Continuation)object0));
            }

            public final Object invoke(Continuation continuation0) {
                return ((com.onesignal.inAppMessages.internal.InAppMessagesManager.onFocus.1)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        this.label = 1;
                        return InAppMessagesManager.this.fetchMessages(this) == object1 ? object1 : Unit.INSTANCE;
                    }
                    case 1: {
                        ResultKt.throwOnFailure(object0);
                        return Unit.INSTANCE;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 1, null);
    }

    @Override  // com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleEventHandler
    public void onMessageActionOccurredOnMessage(InAppMessage inAppMessage0, InAppMessageClickResult inAppMessageClickResult0) {
        Intrinsics.checkNotNullParameter(inAppMessage0, "message");
        Intrinsics.checkNotNullParameter(inAppMessageClickResult0, "action");
        ThreadUtilsKt.suspendifyOnThread$default(0, new Function1(inAppMessage0, this, null) {
            final InAppMessageClickResult $action;
            final InAppMessage $message;
            int label;

            {
                this.$action = inAppMessageClickResult0;
                this.$message = inAppMessage0;
                InAppMessagesManager.this = inAppMessagesManager0;
                super(1, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation0) {
                return new com.onesignal.inAppMessages.internal.InAppMessagesManager.onMessageActionOccurredOnMessage.1(this.$action, this.$message, InAppMessagesManager.this, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((Continuation)object0));
            }

            public final Object invoke(Continuation continuation0) {
                return ((com.onesignal.inAppMessages.internal.InAppMessagesManager.onMessageActionOccurredOnMessage.1)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        boolean z = this.$message.takeActionAsUnique();
                        this.$action.setFirstClick(z);
                        this.label = 1;
                        if(InAppMessagesManager.this.firePublicClickHandler(this.$message, this.$action, this) == object1) {
                            return object1;
                        }
                    label_17:
                        this.label = 2;
                        if(InAppMessagesManager.this.beginProcessingPrompts(this.$message, this.$action.getPrompts(), this) == object1) {
                            return object1;
                        }
                    label_20:
                        InAppMessagesManager.this.fireClickAction(this.$action);
                        this.label = 3;
                        if(InAppMessagesManager.this.fireRESTCallForClick(this.$message, this.$action, this) == object1) {
                            return object1;
                        }
                        break;
                    }
                    case 1: {
                        ResultKt.throwOnFailure(object0);
                        goto label_17;
                    }
                    case 2: {
                        ResultKt.throwOnFailure(object0);
                        goto label_20;
                    }
                    case 3: {
                        ResultKt.throwOnFailure(object0);
                        break;
                    }
                    case 4: {
                        ResultKt.throwOnFailure(object0);
                        return Unit.INSTANCE;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                InAppMessagesManager.this.fireTagCallForClick(this.$action);
                this.label = 4;
                return InAppMessagesManager.this.fireOutcomesForClick(this.$message.getMessageId(), this.$action.getOutcomes(), this) == object1 ? object1 : Unit.INSTANCE;
            }
        }, 1, null);
    }

    @Override  // com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleEventHandler
    public void onMessageActionOccurredOnPreview(InAppMessage inAppMessage0, InAppMessageClickResult inAppMessageClickResult0) {
        Intrinsics.checkNotNullParameter(inAppMessage0, "message");
        Intrinsics.checkNotNullParameter(inAppMessageClickResult0, "action");
        ThreadUtilsKt.suspendifyOnThread$default(0, new Function1(inAppMessage0, this, null) {
            final InAppMessageClickResult $action;
            final InAppMessage $message;
            int label;

            {
                this.$action = inAppMessageClickResult0;
                this.$message = inAppMessage0;
                InAppMessagesManager.this = inAppMessagesManager0;
                super(1, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation0) {
                return new com.onesignal.inAppMessages.internal.InAppMessagesManager.onMessageActionOccurredOnPreview.1(this.$action, this.$message, InAppMessagesManager.this, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((Continuation)object0));
            }

            public final Object invoke(Continuation continuation0) {
                return ((com.onesignal.inAppMessages.internal.InAppMessagesManager.onMessageActionOccurredOnPreview.1)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        boolean z = this.$message.takeActionAsUnique();
                        this.$action.setFirstClick(z);
                        this.label = 1;
                        if(InAppMessagesManager.this.firePublicClickHandler(this.$message, this.$action, this) == object1) {
                            return object1;
                        }
                        goto label_10;
                    }
                    case 1: {
                        ResultKt.throwOnFailure(object0);
                    label_10:
                        this.label = 2;
                        if(InAppMessagesManager.this.beginProcessingPrompts(this.$message, this.$action.getPrompts(), this) == object1) {
                            return object1;
                        }
                        break;
                    }
                    case 2: {
                        ResultKt.throwOnFailure(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                InAppMessagesManager.this.fireClickAction(this.$action);
                InAppMessagesManager.this.logInAppMessagePreviewActions(this.$action);
                return Unit.INSTANCE;
            }
        }, 1, null);
    }

    @Override  // com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleEventHandler
    public void onMessagePageChanged(InAppMessage inAppMessage0, InAppMessagePage inAppMessagePage0) {
        Intrinsics.checkNotNullParameter(inAppMessage0, "message");
        Intrinsics.checkNotNullParameter(inAppMessagePage0, "page");
        if(inAppMessage0.isPreview()) {
            return;
        }
        ThreadUtilsKt.suspendifyOnThread$default(0, new Function1(inAppMessage0, inAppMessagePage0, null) {
            final InAppMessage $message;
            final InAppMessagePage $page;
            int label;

            {
                InAppMessagesManager.this = inAppMessagesManager0;
                this.$message = inAppMessage0;
                this.$page = inAppMessagePage0;
                super(1, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation0) {
                return new com.onesignal.inAppMessages.internal.InAppMessagesManager.onMessagePageChanged.1(InAppMessagesManager.this, this.$message, this.$page, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((Continuation)object0));
            }

            public final Object invoke(Continuation continuation0) {
                return ((com.onesignal.inAppMessages.internal.InAppMessagesManager.onMessagePageChanged.1)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        this.label = 1;
                        return InAppMessagesManager.this.fireRESTCallForPageChange(this.$message, this.$page, this) == object1 ? object1 : Unit.INSTANCE;
                    }
                    case 1: {
                        ResultKt.throwOnFailure(object0);
                        return Unit.INSTANCE;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 1, null);
    }

    @Override  // com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleEventHandler
    public void onMessageWasDismissed(InAppMessage inAppMessage0) {
        Intrinsics.checkNotNullParameter(inAppMessage0, "message");
        ThreadUtilsKt.suspendifyOnThread$default(0, new Function1(inAppMessage0, null) {
            final InAppMessage $message;
            int label;

            {
                InAppMessagesManager.this = inAppMessagesManager0;
                this.$message = inAppMessage0;
                super(1, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation0) {
                return new com.onesignal.inAppMessages.internal.InAppMessagesManager.onMessageWasDismissed.1(InAppMessagesManager.this, this.$message, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((Continuation)object0));
            }

            public final Object invoke(Continuation continuation0) {
                return ((com.onesignal.inAppMessages.internal.InAppMessagesManager.onMessageWasDismissed.1)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        this.label = 1;
                        return InAppMessagesManager.messageWasDismissed$default(InAppMessagesManager.this, this.$message, false, this, 2, null) == object1 ? object1 : Unit.INSTANCE;
                    }
                    case 1: {
                        ResultKt.throwOnFailure(object0);
                        return Unit.INSTANCE;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 1, null);
    }

    @Override  // com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleEventHandler
    public void onMessageWasDisplayed(InAppMessage inAppMessage0) {
        Intrinsics.checkNotNullParameter(inAppMessage0, "message");
        if(this.lifecycleCallback.getHasSubscribers()) {
            Function1 function10 = new Function1() {
                final InAppMessage $message;

                {
                    this.$message = inAppMessage0;
                    super(1);
                }

                @Override  // kotlin.jvm.functions.Function1
                public Object invoke(Object object0) {
                    this.invoke(((IInAppMessageLifecycleListener)object0));
                    return Unit.INSTANCE;
                }

                public final void invoke(IInAppMessageLifecycleListener iInAppMessageLifecycleListener0) {
                    Intrinsics.checkNotNullParameter(iInAppMessageLifecycleListener0, "it");
                    iInAppMessageLifecycleListener0.onDidDisplay(new InAppMessageLifecycleEvent(this.$message));
                }
            };
            this.lifecycleCallback.fireOnMain(function10);
        }
        else {
            Logging.verbose$default("InAppMessagesManager.onMessageWasDisplayed: inAppMessageLifecycleHandler is null", null, 2, null);
        }
        if(inAppMessage0.isPreview()) {
            return;
        }
        if(this.impressionedMessages.contains(inAppMessage0.getMessageId())) {
            return;
        }
        this.impressionedMessages.add(inAppMessage0.getMessageId());
        String s = InAppHelper.INSTANCE.variantIdForMessage(inAppMessage0, this._languageContext);
        if(s == null) {
            return;
        }
        ThreadUtilsKt.suspendifyOnThread$default(0, new Function1(s, inAppMessage0, null) {
            final InAppMessage $message;
            final String $variantId;
            int label;

            {
                InAppMessagesManager.this = inAppMessagesManager0;
                this.$variantId = s;
                this.$message = inAppMessage0;
                super(1, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation0) {
                return new com.onesignal.inAppMessages.internal.InAppMessagesManager.onMessageWasDisplayed.2(InAppMessagesManager.this, this.$variantId, this.$message, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((Continuation)object0));
            }

            public final Object invoke(Continuation continuation0) {
                return ((com.onesignal.inAppMessages.internal.InAppMessagesManager.onMessageWasDisplayed.2)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        try {
                            String s = ((ConfigModel)InAppMessagesManager.this._configModelStore.getModel()).getAppId();
                            String s1 = InAppMessagesManager.this._subscriptionManager.getSubscriptions().getPush().getId();
                            this.label = 1;
                            if(InAppMessagesManager.this._backend.sendIAMImpression(s, s1, this.$variantId, this.$message.getMessageId(), this) == object1) {
                                return object1;
                            label_9:
                                ResultKt.throwOnFailure(object0);
                            }
                            InAppMessagesManager.this._prefs.setImpressionesMessagesId(InAppMessagesManager.this.impressionedMessages);
                            return Unit.INSTANCE;
                        }
                        catch(BackendException unused_ex) {
                            break;
                        }
                    }
                    case 1: {
                        goto label_9;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                InAppMessagesManager.this.impressionedMessages.remove(this.$message.getMessageId());
                return Unit.INSTANCE;
            }
        }, 1, null);
    }

    @Override  // com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleEventHandler
    public void onMessageWillDismiss(InAppMessage inAppMessage0) {
        Intrinsics.checkNotNullParameter(inAppMessage0, "message");
        if(!this.lifecycleCallback.getHasSubscribers()) {
            Logging.verbose$default("InAppMessagesManager.onMessageWillDismiss: inAppMessageLifecycleHandler is null", null, 2, null);
            return;
        }
        Function1 function10 = new Function1() {
            final InAppMessage $message;

            {
                this.$message = inAppMessage0;
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                this.invoke(((IInAppMessageLifecycleListener)object0));
                return Unit.INSTANCE;
            }

            public final void invoke(IInAppMessageLifecycleListener iInAppMessageLifecycleListener0) {
                Intrinsics.checkNotNullParameter(iInAppMessageLifecycleListener0, "it");
                iInAppMessageLifecycleListener0.onWillDismiss(new InAppMessageLifecycleEvent(this.$message));
            }
        };
        this.lifecycleCallback.fireOnMain(function10);
    }

    @Override  // com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleEventHandler
    public void onMessageWillDisplay(InAppMessage inAppMessage0) {
        Intrinsics.checkNotNullParameter(inAppMessage0, "message");
        if(!this.lifecycleCallback.getHasSubscribers()) {
            Logging.verbose$default("InAppMessagesManager.onMessageWillDisplay: inAppMessageLifecycleHandler is null", null, 2, null);
            return;
        }
        Function1 function10 = new Function1() {
            final InAppMessage $message;

            {
                this.$message = inAppMessage0;
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                this.invoke(((IInAppMessageLifecycleListener)object0));
                return Unit.INSTANCE;
            }

            public final void invoke(IInAppMessageLifecycleListener iInAppMessageLifecycleListener0) {
                Intrinsics.checkNotNullParameter(iInAppMessageLifecycleListener0, "it");
                iInAppMessageLifecycleListener0.onWillDisplay(new InAppMessageLifecycleEvent(this.$message));
            }
        };
        this.lifecycleCallback.fireOnMain(function10);
    }

    @Override  // com.onesignal.common.modeling.ISingletonModelStoreChangeHandler
    public void onModelReplaced(Model model0, String s) {
        this.onModelReplaced(((ConfigModel)model0), s);
    }

    public void onModelReplaced(ConfigModel configModel0, String s) {
        Intrinsics.checkNotNullParameter(configModel0, "model");
        Intrinsics.checkNotNullParameter(s, "tag");
        ThreadUtilsKt.suspendifyOnThread$default(0, new Function1(null) {
            int label;

            {
                InAppMessagesManager.this = inAppMessagesManager0;
                super(1, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation0) {
                return new com.onesignal.inAppMessages.internal.InAppMessagesManager.onModelReplaced.1(InAppMessagesManager.this, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((Continuation)object0));
            }

            public final Object invoke(Continuation continuation0) {
                return ((com.onesignal.inAppMessages.internal.InAppMessagesManager.onModelReplaced.1)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        this.label = 1;
                        return InAppMessagesManager.this.fetchMessages(this) == object1 ? object1 : Unit.INSTANCE;
                    }
                    case 1: {
                        ResultKt.throwOnFailure(object0);
                        return Unit.INSTANCE;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 1, null);
    }

    @Override  // com.onesignal.common.modeling.ISingletonModelStoreChangeHandler
    public void onModelUpdated(ModelChangedArgs modelChangedArgs0, String s) {
        Intrinsics.checkNotNullParameter(modelChangedArgs0, "args");
        Intrinsics.checkNotNullParameter(s, "tag");
        if(!Intrinsics.areEqual(modelChangedArgs0.getProperty(), "appId")) {
            return;
        }
        ThreadUtilsKt.suspendifyOnThread$default(0, new Function1(null) {
            int label;

            {
                InAppMessagesManager.this = inAppMessagesManager0;
                super(1, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation0) {
                return new com.onesignal.inAppMessages.internal.InAppMessagesManager.onModelUpdated.2(InAppMessagesManager.this, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((Continuation)object0));
            }

            public final Object invoke(Continuation continuation0) {
                return ((com.onesignal.inAppMessages.internal.InAppMessagesManager.onModelUpdated.2)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        this.label = 1;
                        return InAppMessagesManager.this.fetchMessages(this) == object1 ? object1 : Unit.INSTANCE;
                    }
                    case 1: {
                        ResultKt.throwOnFailure(object0);
                        return Unit.INSTANCE;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 1, null);
    }

    @Override  // com.onesignal.session.internal.session.ISessionLifecycleHandler
    public void onSessionActive() {
    }

    @Override  // com.onesignal.session.internal.session.ISessionLifecycleHandler
    public void onSessionEnded(long v) {
    }

    @Override  // com.onesignal.session.internal.session.ISessionLifecycleHandler
    public void onSessionStarted() {
        for(Object object0: this.redisplayedInAppMessages) {
            ((InAppMessage)object0).setDisplayedInSession(false);
        }
        ThreadUtilsKt.suspendifyOnThread$default(0, new Function1(null) {
            int label;

            {
                InAppMessagesManager.this = inAppMessagesManager0;
                super(1, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation0) {
                return new com.onesignal.inAppMessages.internal.InAppMessagesManager.onSessionStarted.1(InAppMessagesManager.this, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((Continuation)object0));
            }

            public final Object invoke(Continuation continuation0) {
                return ((com.onesignal.inAppMessages.internal.InAppMessagesManager.onSessionStarted.1)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        this.label = 1;
                        return InAppMessagesManager.this.fetchMessages(this) == object1 ? object1 : Unit.INSTANCE;
                    }
                    case 1: {
                        ResultKt.throwOnFailure(object0);
                        return Unit.INSTANCE;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 1, null);
    }

    @Override  // com.onesignal.user.internal.subscriptions.ISubscriptionChangedHandler
    public void onSubscriptionAdded(ISubscription iSubscription0) {
        Intrinsics.checkNotNullParameter(iSubscription0, "subscription");
    }

    @Override  // com.onesignal.user.internal.subscriptions.ISubscriptionChangedHandler
    public void onSubscriptionChanged(ISubscription iSubscription0, ModelChangedArgs modelChangedArgs0) {
        Intrinsics.checkNotNullParameter(iSubscription0, "subscription");
        Intrinsics.checkNotNullParameter(modelChangedArgs0, "args");
        if(iSubscription0 instanceof IPushSubscription && Intrinsics.areEqual(modelChangedArgs0.getPath(), "id")) {
            ThreadUtilsKt.suspendifyOnThread$default(0, new Function1(null) {
                int label;

                {
                    InAppMessagesManager.this = inAppMessagesManager0;
                    super(1, continuation0);
                }

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Continuation continuation0) {
                    return new com.onesignal.inAppMessages.internal.InAppMessagesManager.onSubscriptionChanged.2(InAppMessagesManager.this, continuation0);
                }

                @Override  // kotlin.jvm.functions.Function1
                public Object invoke(Object object0) {
                    return this.invoke(((Continuation)object0));
                }

                public final Object invoke(Continuation continuation0) {
                    return ((com.onesignal.inAppMessages.internal.InAppMessagesManager.onSubscriptionChanged.2)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
                }

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch(this.label) {
                        case 0: {
                            ResultKt.throwOnFailure(object0);
                            this.label = 1;
                            return InAppMessagesManager.this.fetchMessages(this) == object1 ? object1 : Unit.INSTANCE;
                        }
                        case 1: {
                            ResultKt.throwOnFailure(object0);
                            return Unit.INSTANCE;
                        }
                        default: {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                    }
                }
            }, 1, null);
        }
    }

    @Override  // com.onesignal.user.internal.subscriptions.ISubscriptionChangedHandler
    public void onSubscriptionRemoved(ISubscription iSubscription0) {
        Intrinsics.checkNotNullParameter(iSubscription0, "subscription");
    }

    @Override  // com.onesignal.inAppMessages.internal.triggers.ITriggerHandler
    public void onTriggerChanged(String s) {
        Intrinsics.checkNotNullParameter(s, "newTriggerKey");
        Logging.debug$default(("InAppMessagesManager.onTriggerChanged(newTriggerKey: " + s + ')'), null, 2, null);
        this.makeRedisplayMessagesAvailableWithTriggers(CollectionsKt.listOf(s));
        ThreadUtilsKt.suspendifyOnThread$default(0, new Function1(null) {
            int label;

            {
                InAppMessagesManager.this = inAppMessagesManager0;
                super(1, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation0) {
                return new com.onesignal.inAppMessages.internal.InAppMessagesManager.onTriggerChanged.1(InAppMessagesManager.this, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((Continuation)object0));
            }

            public final Object invoke(Continuation continuation0) {
                return ((com.onesignal.inAppMessages.internal.InAppMessagesManager.onTriggerChanged.1)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        this.label = 1;
                        return InAppMessagesManager.this.evaluateInAppMessages(this) == object1 ? object1 : Unit.INSTANCE;
                    }
                    case 1: {
                        ResultKt.throwOnFailure(object0);
                        return Unit.INSTANCE;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 1, null);
    }

    @Override  // com.onesignal.inAppMessages.internal.triggers.ITriggerHandler
    public void onTriggerCompleted(String s) {
        Intrinsics.checkNotNullParameter(s, "triggerId");
        Logging.debug$default(("InAppMessagesManager.onTriggerCompleted: called with triggerId: " + s), null, 2, null);
        Set set0 = new HashSet();
        set0.add(s);
        this.makeRedisplayMessagesAvailableWithTriggers(set0);
    }

    @Override  // com.onesignal.inAppMessages.internal.triggers.ITriggerHandler
    public void onTriggerConditionChanged() {
        Logging.debug$default("InAppMessagesManager.onTriggerConditionChanged()", null, 2, null);
        ThreadUtilsKt.suspendifyOnThread$default(0, new Function1(null) {
            int label;

            {
                InAppMessagesManager.this = inAppMessagesManager0;
                super(1, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation0) {
                return new com.onesignal.inAppMessages.internal.InAppMessagesManager.onTriggerConditionChanged.1(InAppMessagesManager.this, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((Continuation)object0));
            }

            public final Object invoke(Continuation continuation0) {
                return ((com.onesignal.inAppMessages.internal.InAppMessagesManager.onTriggerConditionChanged.1)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        this.label = 1;
                        return InAppMessagesManager.this.evaluateInAppMessages(this) == object1 ? object1 : Unit.INSTANCE;
                    }
                    case 1: {
                        ResultKt.throwOnFailure(object0);
                        return Unit.INSTANCE;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 1, null);
    }

    @Override  // com.onesignal.core.internal.application.IApplicationLifecycleHandler
    public void onUnfocused() {
    }

    private final Object persistInAppMessage(InAppMessage inAppMessage0, Continuation continuation0) {
        InAppMessagesManager inAppMessagesManager0;
        com.onesignal.inAppMessages.internal.InAppMessagesManager.persistInAppMessage.1 inAppMessagesManager$persistInAppMessage$10;
        if(continuation0 instanceof com.onesignal.inAppMessages.internal.InAppMessagesManager.persistInAppMessage.1) {
            inAppMessagesManager$persistInAppMessage$10 = (com.onesignal.inAppMessages.internal.InAppMessagesManager.persistInAppMessage.1)continuation0;
            if((inAppMessagesManager$persistInAppMessage$10.label & 0x80000000) == 0) {
                inAppMessagesManager$persistInAppMessage$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.persistInAppMessage(null, this);
                    }
                };
            }
            else {
                inAppMessagesManager$persistInAppMessage$10.label ^= 0x80000000;
            }
        }
        else {
            inAppMessagesManager$persistInAppMessage$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.persistInAppMessage(null, this);
                }
            };
        }
        Object object0 = inAppMessagesManager$persistInAppMessage$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(inAppMessagesManager$persistInAppMessage$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                inAppMessage0.getRedisplayStats().setLastDisplayTime(this._time.getCurrentTimeMillis() / 1000L);
                inAppMessage0.getRedisplayStats().incrementDisplayQuantity();
                inAppMessage0.setTriggerChanged(false);
                inAppMessage0.setDisplayedInSession(true);
                inAppMessagesManager$persistInAppMessage$10.L$0 = this;
                inAppMessagesManager$persistInAppMessage$10.L$1 = inAppMessage0;
                inAppMessagesManager$persistInAppMessage$10.label = 1;
                if(this._repository.saveInAppMessage(inAppMessage0, inAppMessagesManager$persistInAppMessage$10) == object1) {
                    return object1;
                }
                inAppMessagesManager0 = this;
                break;
            }
            case 1: {
                inAppMessage0 = (InAppMessage)inAppMessagesManager$persistInAppMessage$10.L$1;
                inAppMessagesManager0 = (InAppMessagesManager)inAppMessagesManager$persistInAppMessage$10.L$0;
                ResultKt.throwOnFailure(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        inAppMessagesManager0._prefs.setLastTimeInAppDismissed(inAppMessagesManager0._state.getLastTimeInAppDismissed());
        int v = inAppMessagesManager0.redisplayedInAppMessages.indexOf(inAppMessage0);
        if(v == -1) {
            inAppMessagesManager0.redisplayedInAppMessages.add(inAppMessage0);
        }
        else {
            inAppMessagesManager0.redisplayedInAppMessages.set(v, inAppMessage0);
        }
        Logging.debug$default(("InAppMessagesManager.persistInAppMessage: " + inAppMessage0 + " with msg array data: " + inAppMessagesManager0.redisplayedInAppMessages), null, 2, null);
        return Unit.INSTANCE;
    }

    private final Object queueMessageForDisplay(InAppMessage inAppMessage0, Continuation continuation0) {
        InAppMessagesManager inAppMessagesManager0;
        Mutex mutex0;
        com.onesignal.inAppMessages.internal.InAppMessagesManager.queueMessageForDisplay.1 inAppMessagesManager$queueMessageForDisplay$10;
        if(continuation0 instanceof com.onesignal.inAppMessages.internal.InAppMessagesManager.queueMessageForDisplay.1) {
            inAppMessagesManager$queueMessageForDisplay$10 = (com.onesignal.inAppMessages.internal.InAppMessagesManager.queueMessageForDisplay.1)continuation0;
            if((inAppMessagesManager$queueMessageForDisplay$10.label & 0x80000000) == 0) {
                inAppMessagesManager$queueMessageForDisplay$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.queueMessageForDisplay(null, this);
                    }
                };
            }
            else {
                inAppMessagesManager$queueMessageForDisplay$10.label ^= 0x80000000;
            }
        }
        else {
            inAppMessagesManager$queueMessageForDisplay$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                Object L$2;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.queueMessageForDisplay(null, this);
                }
            };
        }
        Object object0 = inAppMessagesManager$queueMessageForDisplay$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(inAppMessagesManager$queueMessageForDisplay$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                mutex0 = this.messageDisplayQueueMutex;
                inAppMessagesManager$queueMessageForDisplay$10.L$0 = this;
                inAppMessagesManager$queueMessageForDisplay$10.L$1 = inAppMessage0;
                inAppMessagesManager$queueMessageForDisplay$10.L$2 = mutex0;
                inAppMessagesManager$queueMessageForDisplay$10.label = 1;
                if(mutex0.lock(null, inAppMessagesManager$queueMessageForDisplay$10) == object1) {
                    return object1;
                }
                inAppMessagesManager0 = this;
                break;
            }
            case 1: {
                Mutex mutex1 = (Mutex)inAppMessagesManager$queueMessageForDisplay$10.L$2;
                InAppMessage inAppMessage1 = (InAppMessage)inAppMessagesManager$queueMessageForDisplay$10.L$1;
                inAppMessagesManager0 = (InAppMessagesManager)inAppMessagesManager$queueMessageForDisplay$10.L$0;
                ResultKt.throwOnFailure(object0);
                mutex0 = mutex1;
                inAppMessage0 = inAppMessage1;
                break;
            }
            case 2: {
                ResultKt.throwOnFailure(object0);
                return Unit.INSTANCE;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            if(!inAppMessagesManager0.messageDisplayQueue.contains(inAppMessage0) && !Intrinsics.areEqual(inAppMessagesManager0._state.getInAppMessageIdShowing(), inAppMessage0.getMessageId())) {
                inAppMessagesManager0.messageDisplayQueue.add(inAppMessage0);
                Logging.debug$default(("InAppMessagesManager.queueMessageForDisplay: In app message with id: " + inAppMessage0.getMessageId() + ", added to the queue"), null, 2, null);
            }
        }
        finally {
            mutex0.unlock(null);
        }
        inAppMessagesManager$queueMessageForDisplay$10.L$0 = null;
        inAppMessagesManager$queueMessageForDisplay$10.L$1 = null;
        inAppMessagesManager$queueMessageForDisplay$10.L$2 = null;
        inAppMessagesManager$queueMessageForDisplay$10.label = 2;
        return inAppMessagesManager0.attemptToShowInAppMessage(inAppMessagesManager$queueMessageForDisplay$10) == object1 ? object1 : Unit.INSTANCE;
    }

    @Override  // com.onesignal.inAppMessages.IInAppMessagesManager
    public void removeClickListener(IInAppMessageClickListener iInAppMessageClickListener0) {
        Intrinsics.checkNotNullParameter(iInAppMessageClickListener0, "listener");
        Logging.debug$default(("InAppMessagesManager.removeClickListener(listener: " + iInAppMessageClickListener0 + ')'), null, 2, null);
        this.messageClickCallback.unsubscribe(iInAppMessageClickListener0);
    }

    @Override  // com.onesignal.inAppMessages.IInAppMessagesManager
    public void removeLifecycleListener(IInAppMessageLifecycleListener iInAppMessageLifecycleListener0) {
        Intrinsics.checkNotNullParameter(iInAppMessageLifecycleListener0, "listener");
        Logging.debug$default(("InAppMessagesManager.removeLifecycleListener(listener: " + iInAppMessageLifecycleListener0 + ')'), null, 2, null);
        this.lifecycleCallback.unsubscribe(iInAppMessageLifecycleListener0);
    }

    @Override  // com.onesignal.inAppMessages.IInAppMessagesManager
    public void removeTrigger(String s) {
        Intrinsics.checkNotNullParameter(s, "key");
        Logging.debug$default(("InAppMessagesManager.removeTrigger(key: " + s + ')'), null, 2, null);
        DefaultImpls.remove$default(this._triggerModelStore, s, null, 2, null);
    }

    @Override  // com.onesignal.inAppMessages.IInAppMessagesManager
    public void removeTriggers(Collection collection0) {
        Intrinsics.checkNotNullParameter(collection0, "keys");
        Logging.debug$default(("InAppMessagesManager.removeTriggers(keys: " + collection0 + ')'), null, 2, null);
        for(Object object0: collection0) {
            this.removeTrigger(((String)object0));
        }
    }

    private final void setDataForRedisplay(InAppMessage inAppMessage0) {
        boolean z = this.dismissedMessages.contains(inAppMessage0.getMessageId());
        int v = this.redisplayedInAppMessages.indexOf(inAppMessage0);
        if(z && v != -1) {
            InAppMessage inAppMessage1 = (InAppMessage)this.redisplayedInAppMessages.get(v);
            inAppMessage0.getRedisplayStats().setDisplayStats(inAppMessage1.getRedisplayStats());
            inAppMessage0.setDisplayedInSession(inAppMessage1.isDisplayedInSession());
            boolean z1 = this.hasMessageTriggerChanged(inAppMessage0);
            Logging.debug$default(("InAppMessagesManager.setDataForRedisplay: " + inAppMessage0 + " triggerHasChanged: " + z1), null, 2, null);
            if(z1 && inAppMessage0.getRedisplayStats().isDelayTimeSatisfied() && inAppMessage0.getRedisplayStats().shouldDisplayAgain()) {
                Logging.debug$default(("InAppMessagesManager.setDataForRedisplay message available for redisplay: " + inAppMessage0.getMessageId()), null, 2, null);
                this.dismissedMessages.remove(inAppMessage0.getMessageId());
                this.impressionedMessages.remove(inAppMessage0.getMessageId());
                this.viewedPageIds.clear();
                this._prefs.setViewPageImpressionedIds(this.viewedPageIds);
                inAppMessage0.clearClickIds();
            }
        }
    }

    @Override  // com.onesignal.inAppMessages.IInAppMessagesManager
    public void setPaused(boolean z) {
        Logging.debug$default(("InAppMessagesManager.setPaused(value: " + z + ')'), null, 2, null);
        this._state.setPaused(z);
        if(!z) {
            ThreadUtilsKt.suspendifyOnThread$default(0, new Function1(null) {
                int label;

                {
                    InAppMessagesManager.this = inAppMessagesManager0;
                    super(1, continuation0);
                }

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Continuation continuation0) {
                    return new com.onesignal.inAppMessages.internal.InAppMessagesManager.paused.1(InAppMessagesManager.this, continuation0);
                }

                @Override  // kotlin.jvm.functions.Function1
                public Object invoke(Object object0) {
                    return this.invoke(((Continuation)object0));
                }

                public final Object invoke(Continuation continuation0) {
                    return ((com.onesignal.inAppMessages.internal.InAppMessagesManager.paused.1)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
                }

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch(this.label) {
                        case 0: {
                            ResultKt.throwOnFailure(object0);
                            this.label = 1;
                            return InAppMessagesManager.this.evaluateInAppMessages(this) == object1 ? object1 : Unit.INSTANCE;
                        }
                        case 1: {
                            ResultKt.throwOnFailure(object0);
                            return Unit.INSTANCE;
                        }
                        default: {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                    }
                }
            }, 1, null);
        }
    }

    private final void showAlertDialogMessage(InAppMessage inAppMessage0, List list0) {
        String s = this._applicationService.getAppContext().getString(string.location_permission_missing_title);
        Intrinsics.checkNotNullExpressionValue(s, "_applicationService.appC…permission_missing_title)");
        String s1 = this._applicationService.getAppContext().getString(string.location_permission_missing_message);
        Intrinsics.checkNotNullExpressionValue(s1, "_applicationService.appC…rmission_missing_message)");
        new AlertDialog.Builder(this._applicationService.getCurrent()).setTitle(s).setMessage(s1).setPositiveButton(0x104000A, (DialogInterface dialogInterface0, int v) -> InAppMessagesManager.showAlertDialogMessage$lambda-5(this, inAppMessage0, list0, dialogInterface0, v)).show();
    }

    private static final void showAlertDialogMessage$lambda-5(InAppMessagesManager inAppMessagesManager0, InAppMessage inAppMessage0, List list0, DialogInterface dialogInterface0, int v) {
        Intrinsics.checkNotNullParameter(inAppMessagesManager0, "this$0");
        Intrinsics.checkNotNullParameter(inAppMessage0, "$inAppMessage");
        Intrinsics.checkNotNullParameter(list0, "$prompts");
        ThreadUtilsKt.suspendifyOnThread$default(0, new Function1(inAppMessagesManager0, inAppMessage0, list0, null) {
            final InAppMessage $inAppMessage;
            final List $prompts;
            int label;

            {
                InAppMessagesManager.this = inAppMessagesManager0;
                this.$inAppMessage = inAppMessage0;
                this.$prompts = list0;
                super(1, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation0) {
                return new com.onesignal.inAppMessages.internal.InAppMessagesManager.showAlertDialogMessage.1.1(InAppMessagesManager.this, this.$inAppMessage, this.$prompts, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((Continuation)object0));
            }

            public final Object invoke(Continuation continuation0) {
                return ((com.onesignal.inAppMessages.internal.InAppMessagesManager.showAlertDialogMessage.1.1)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        this.label = 1;
                        return InAppMessagesManager.this.showMultiplePrompts(this.$inAppMessage, this.$prompts, this) == object1 ? object1 : Unit.INSTANCE;
                    }
                    case 1: {
                        ResultKt.throwOnFailure(object0);
                        return Unit.INSTANCE;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 1, null);
    }

    private final Object showMultiplePrompts(InAppMessage inAppMessage0, List list0, Continuation continuation0) {
        InAppMessage inAppMessage3;
        com.onesignal.inAppMessages.internal.InAppMessagesManager.showMultiplePrompts.1 inAppMessagesManager$showMultiplePrompts$12;
        InAppMessage inAppMessage2;
        List list1;
        com.onesignal.inAppMessages.internal.InAppMessagesManager.showMultiplePrompts.1 inAppMessagesManager$showMultiplePrompts$11;
        InAppMessage inAppMessage1;
        Object object2;
        InAppMessagesManager inAppMessagesManager0;
        Iterator iterator0;
        com.onesignal.inAppMessages.internal.InAppMessagesManager.showMultiplePrompts.1 inAppMessagesManager$showMultiplePrompts$10;
        if(continuation0 instanceof com.onesignal.inAppMessages.internal.InAppMessagesManager.showMultiplePrompts.1) {
            inAppMessagesManager$showMultiplePrompts$10 = (com.onesignal.inAppMessages.internal.InAppMessagesManager.showMultiplePrompts.1)continuation0;
            if((inAppMessagesManager$showMultiplePrompts$10.label & 0x80000000) == 0) {
                inAppMessagesManager$showMultiplePrompts$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.showMultiplePrompts(null, null, this);
                    }
                };
            }
            else {
                inAppMessagesManager$showMultiplePrompts$10.label ^= 0x80000000;
            }
        }
        else {
            inAppMessagesManager$showMultiplePrompts$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.showMultiplePrompts(null, null, this);
                }
            };
        }
        Object object0 = inAppMessagesManager$showMultiplePrompts$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(inAppMessagesManager$showMultiplePrompts$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                iterator0 = list0.iterator();
                inAppMessagesManager0 = this;
                object2 = object1;
                inAppMessage1 = inAppMessage0;
                inAppMessagesManager$showMultiplePrompts$11 = inAppMessagesManager$showMultiplePrompts$10;
                list1 = list0;
                goto label_39;
            }
            case 1: {
                Iterator iterator1 = (Iterator)inAppMessagesManager$showMultiplePrompts$10.L$3;
                List list2 = (List)inAppMessagesManager$showMultiplePrompts$10.L$2;
                inAppMessage2 = (InAppMessage)inAppMessagesManager$showMultiplePrompts$10.L$1;
                inAppMessagesManager0 = (InAppMessagesManager)inAppMessagesManager$showMultiplePrompts$10.L$0;
                ResultKt.throwOnFailure(object0);
                inAppMessagesManager$showMultiplePrompts$11 = inAppMessagesManager$showMultiplePrompts$10;
                list1 = list2;
                iterator0 = iterator1;
                object2 = object1;
                break;
            }
            case 2: {
                ResultKt.throwOnFailure(object0);
                return Unit.INSTANCE;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        while(true) {
            inAppMessagesManager0._state.setCurrentPrompt(null);
            Logging.debug$default(("InAppMessagesManager.showMultiplePrompts: IAM prompt to handle finished with result: " + ((PromptActionResult)object0)), null, 2, null);
            if(inAppMessage2.isPreview() && ((PromptActionResult)object0) == PromptActionResult.LOCATION_PERMISSIONS_MISSING_MANIFEST) {
                inAppMessagesManager0.showAlertDialogMessage(inAppMessage2, list1);
                inAppMessagesManager$showMultiplePrompts$12 = inAppMessagesManager$showMultiplePrompts$11;
                inAppMessage3 = inAppMessage2;
                goto label_64;
            }
            inAppMessage1 = inAppMessage2;
        label_39:
            if(!iterator0.hasNext()) {
                goto label_62;
            }
            Object object3 = iterator0.next();
            InAppMessagePrompt inAppMessagePrompt0 = (InAppMessagePrompt)object3;
            if(inAppMessagePrompt0.hasPrompted()) {
                break;
            }
            inAppMessagesManager0._state.setCurrentPrompt(inAppMessagePrompt0);
            Logging.debug$default(("InAppMessagesManager.showMultiplePrompts: IAM prompt to handle: " + inAppMessagesManager0._state.getCurrentPrompt()), null, 2, null);
            InAppMessagePrompt inAppMessagePrompt1 = inAppMessagesManager0._state.getCurrentPrompt();
            Intrinsics.checkNotNull(inAppMessagePrompt1);
            inAppMessagePrompt1.setPrompted(true);
            InAppMessagePrompt inAppMessagePrompt2 = inAppMessagesManager0._state.getCurrentPrompt();
            Intrinsics.checkNotNull(inAppMessagePrompt2);
            inAppMessagesManager$showMultiplePrompts$11.L$0 = inAppMessagesManager0;
            inAppMessagesManager$showMultiplePrompts$11.L$1 = inAppMessage1;
            inAppMessagesManager$showMultiplePrompts$11.L$2 = list1;
            inAppMessagesManager$showMultiplePrompts$11.L$3 = iterator0;
            inAppMessagesManager$showMultiplePrompts$11.label = 1;
            Object object4 = inAppMessagePrompt2.handlePrompt(inAppMessagesManager$showMultiplePrompts$11);
            if(object4 == object2) {
                return object2;
            }
            inAppMessage2 = inAppMessage1;
            object0 = object4;
        }
        goto label_39;
    label_62:
        inAppMessage3 = inAppMessage1;
        inAppMessagesManager$showMultiplePrompts$12 = inAppMessagesManager$showMultiplePrompts$11;
    label_64:
        if(inAppMessagesManager0._state.getCurrentPrompt() == null) {
            Logging.debug$default(("InAppMessagesManager.showMultiplePrompts: No IAM prompt to handle, dismiss message: " + inAppMessage3.getMessageId()), null, 2, null);
            inAppMessagesManager$showMultiplePrompts$12.L$0 = null;
            inAppMessagesManager$showMultiplePrompts$12.L$1 = null;
            inAppMessagesManager$showMultiplePrompts$12.L$2 = null;
            inAppMessagesManager$showMultiplePrompts$12.L$3 = null;
            inAppMessagesManager$showMultiplePrompts$12.label = 2;
            return InAppMessagesManager.messageWasDismissed$default(inAppMessagesManager0, inAppMessage3, false, inAppMessagesManager$showMultiplePrompts$12, 2, null) == object2 ? object2 : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    @Override  // com.onesignal.core.internal.startup.IStartableService
    public void start() {
        Set set0 = this._prefs.getDismissedMessagesId();
        if(set0 != null) {
            this.dismissedMessages.addAll(set0);
        }
        Long long0 = this._prefs.getLastTimeInAppDismissed();
        if(long0 != null) {
            this._state.setLastTimeInAppDismissed(long0);
        }
        this._subscriptionManager.subscribe(this);
        this._configModelStore.subscribe(this);
        this._lifecycle.subscribe(this);
        this._triggerController.subscribe(this);
        this._sessionService.subscribe(this);
        this._applicationService.addApplicationLifecycleHandler(this);
        ThreadUtilsKt.suspendifyOnThread$default(0, new Function1(null) {
            Object L$0;
            int label;

            {
                InAppMessagesManager.this = inAppMessagesManager0;
                super(1, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation0) {
                return new com.onesignal.inAppMessages.internal.InAppMessagesManager.start.1(InAppMessagesManager.this, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((Continuation)object0));
            }

            public final Object invoke(Continuation continuation0) {
                return ((com.onesignal.inAppMessages.internal.InAppMessagesManager.start.1)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                List list0;
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        this.label = 1;
                        if(InAppMessagesManager.this._repository.cleanCachedInAppMessages(this) == object1) {
                            return object1;
                        }
                        goto label_10;
                    }
                    case 1: {
                        ResultKt.throwOnFailure(object0);
                    label_10:
                        list0 = InAppMessagesManager.this.redisplayedInAppMessages;
                        this.L$0 = list0;
                        this.label = 2;
                        object0 = InAppMessagesManager.this._repository.listInAppMessages(this);
                        if(object0 == object1) {
                            return object1;
                        }
                        break;
                    }
                    case 2: {
                        list0 = (List)this.L$0;
                        ResultKt.throwOnFailure(object0);
                        break;
                    }
                    case 3: {
                        ResultKt.throwOnFailure(object0);
                        return Unit.INSTANCE;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                list0.addAll(((Collection)object0));
                for(Object object2: InAppMessagesManager.this.redisplayedInAppMessages) {
                    ((InAppMessage)object2).setDisplayedInSession(false);
                }
                this.L$0 = null;
                this.label = 3;
                return InAppMessagesManager.this.fetchMessages(this) == object1 ? object1 : Unit.INSTANCE;
            }
        }, 1, null);
    }
}

