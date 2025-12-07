package com.onesignal.inAppMessages.internal.display.impl;

import android.animation.Animator.AnimatorListener;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Animation;
import android.webkit.WebView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.RelativeLayout;
import androidx.cardview.widget.CardView;
import androidx.core.widget.PopupWindowCompat;
import com.onesignal.common.AndroidUtils;
import com.onesignal.common.ViewUtils;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.common.threading.Waiter;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.inAppMessages.internal.InAppMessageContent;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\u00A4\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001A\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0000\u0018\u0000 l2\u00020\u0001:\u0002lmB\'\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\u0007\u00A2\u0006\u0002\u0010\tJ\u0019\u0010+\u001A\u00020,2\u0006\u0010-\u001A\u00020.H\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010/J2\u00100\u001A\u0002012\u0006\u0010-\u001A\u00020.2\u0006\u00102\u001A\u00020\u00142\u0006\u00103\u001A\u00020\u00142\u0006\u00104\u001A\u00020\u00142\b\u00105\u001A\u0004\u0018\u000106H\u0002J \u00107\u001A\u00020,2\u0006\u00108\u001A\u00020.2\u0006\u00109\u001A\u00020\u00142\u0006\u0010:\u001A\u00020;H\u0002J*\u0010<\u001A\u00020,2\u0006\u00108\u001A\u00020.2\u0006\u0010-\u001A\u00020.2\u0006\u0010:\u001A\u00020;2\b\u0010=\u001A\u0004\u0018\u000106H\u0002J \u0010>\u001A\u00020,2\u0006\u0010?\u001A\u00020\u00102\u0006\u00108\u001A\u00020.2\u0006\u0010-\u001A\u00020.H\u0002J \u0010@\u001A\u00020,2\u0006\u00108\u001A\u00020.2\u0006\u00109\u001A\u00020\u00142\u0006\u0010:\u001A\u00020;H\u0002J\u0011\u0010A\u001A\u00020,H\u0086@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010BJ\b\u0010C\u001A\u00020,H\u0002J\u0010\u0010D\u001A\u00020;2\u0006\u0010E\u001A\u00020FH\u0002J\u0010\u0010G\u001A\u00020F2\u0006\u0010H\u001A\u00020IH\u0002J \u0010J\u001A\u00020K2\u0006\u0010$\u001A\u00020\u00142\u0006\u0010?\u001A\u00020\u00102\u0006\u0010L\u001A\u00020\u0007H\u0002J\b\u0010M\u001A\u00020NH\u0002J\u0010\u0010O\u001A\u00020,2\u0006\u0010&\u001A\u00020\'H\u0002J\u0019\u0010P\u001A\u00020,2\u0006\u0010\u000B\u001A\u00020\fH\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010QJ\b\u0010R\u001A\u00020,H\u0002J\u0011\u0010S\u001A\u00020,H\u0086@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010BJ\u0011\u0010T\u001A\u00020,H\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010BJ\u0010\u0010U\u001A\u00020\u00072\u0006\u0010H\u001A\u00020IH\u0002J\b\u0010V\u001A\u00020\u0014H\u0002J\u0006\u0010W\u001A\u00020,J\u0010\u0010X\u001A\u00020,2\u0006\u0010Y\u001A\u00020\u0005H\u0002J\u0010\u0010Z\u001A\u00020,2\b\u0010\"\u001A\u0004\u0018\u00010#J\"\u0010[\u001A\u00020,2\u0006\u0010H\u001A\u00020I2\b\u0010\\\u001A\u0004\u0018\u00010N2\u0006\u0010]\u001A\u00020KH\u0002J\u0010\u0010^\u001A\u00020,2\u0006\u0010H\u001A\u00020IH\u0002J\u000E\u0010_\u001A\u00020,2\u0006\u0010\u0002\u001A\u00020\u0003J3\u0010`\u001A\u00020,2\u0006\u0010?\u001A\u00020\u00102\u0006\u0010\\\u001A\u00020N2\b\u0010a\u001A\u0004\u0018\u00010N2\u0006\u0010b\u001A\u00020KH\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010cJ\u001B\u0010d\u001A\u00020,2\b\u0010\u000B\u001A\u0004\u0018\u00010\fH\u0086@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010QJ\u0019\u0010e\u001A\u00020,2\u0006\u0010f\u001A\u00020\fH\u0086@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010QJ\u0011\u0010g\u001A\u00020,H\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010BJ\b\u0010h\u001A\u00020iH\u0016J\u0019\u0010j\u001A\u00020,2\u0006\u0010$\u001A\u00020\u0014H\u0086@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010kR\u000E\u0010\n\u001A\u00020\u0007X\u0082\u000E\u00A2\u0006\u0002\n\u0000R\u0010\u0010\u000B\u001A\u0004\u0018\u00010\fX\u0082\u000E\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u0011\u0010\u000F\u001A\u00020\u0010\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001A\u00020\u00148BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001A\u0004\u0018\u00010\u0018X\u0082\u000E\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0019\u001A\u00020\u0007X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\u0007X\u0082\u000E\u00A2\u0006\u0002\n\u0000R\u001E\u0010\u001C\u001A\u00020\u00072\u0006\u0010\u001B\u001A\u00020\u0007@BX\u0086\u000E\u00A2\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u001DR\u000E\u0010\u001E\u001A\u00020\u0014X\u0082\u000E\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u001F\u001A\u00020\u0014X\u0082\u000E\u00A2\u0006\u0002\n\u0000R\u000E\u0010 \u001A\u00020\u0014X\u0082\u000E\u00A2\u0006\u0002\n\u0000R\u000E\u0010!\u001A\u00020\u0014X\u0082\u000E\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u0010\u0010\"\u001A\u0004\u0018\u00010#X\u0082\u000E\u00A2\u0006\u0002\n\u0000R\u000E\u0010$\u001A\u00020\u0014X\u0082\u000E\u00A2\u0006\u0002\n\u0000R\u000E\u0010%\u001A\u00020\u0014X\u0082D\u00A2\u0006\u0002\n\u0000R\u0010\u0010&\u001A\u0004\u0018\u00010\'X\u0082\u000E\u00A2\u0006\u0002\n\u0000R\u0010\u0010(\u001A\u0004\u0018\u00010)X\u0082\u000E\u00A2\u0006\u0002\n\u0000R\u000E\u0010*\u001A\u00020\u0007X\u0082\u000E\u00A2\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001A\u0004\u0018\u00010\u0003X\u0082\u000E\u00A2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00A8\u0006n"}, d2 = {"Lcom/onesignal/inAppMessages/internal/display/impl/InAppMessageView;", "", "webView", "Landroid/webkit/WebView;", "messageContent", "Lcom/onesignal/inAppMessages/internal/InAppMessageContent;", "disableDragDismiss", "", "hideGrayOverlay", "(Landroid/webkit/WebView;Lcom/onesignal/inAppMessages/internal/InAppMessageContent;ZZ)V", "cancelDismissTimer", "currentActivity", "Landroid/app/Activity;", "displayDuration", "", "displayPosition", "Lcom/onesignal/inAppMessages/internal/display/impl/WebViewManager$Position;", "getDisplayPosition", "()Lcom/onesignal/inAppMessages/internal/display/impl/WebViewManager$Position;", "displayYSize", "", "getDisplayYSize", "()I", "draggableRelativeLayout", "Lcom/onesignal/inAppMessages/internal/display/impl/DraggableRelativeLayout;", "hasBackground", "isDismissTimerSet", "<set-?>", "isDragging", "()Z", "marginPxSizeBottom", "marginPxSizeLeft", "marginPxSizeRight", "marginPxSizeTop", "messageController", "Lcom/onesignal/inAppMessages/internal/display/impl/InAppMessageView$InAppMessageViewListener;", "pageHeight", "pageWidth", "parentRelativeLayout", "Landroid/widget/RelativeLayout;", "popupWindow", "Landroid/widget/PopupWindow;", "shouldDismissWhenActive", "animateAndDismissLayout", "", "backgroundView", "Landroid/view/View;", "(Landroid/view/View;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateBackgroundColor", "Landroid/animation/ValueAnimator;", "duration", "startColor", "endColor", "animCallback", "Landroid/animation/Animator$AnimatorListener;", "animateBottom", "messageView", "height", "cardViewAnimCallback", "Landroid/view/animation/Animation$AnimationListener;", "animateCenter", "backgroundAnimCallback", "animateInAppMessage", "displayLocation", "animateTop", "checkIfShouldDismiss", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanupViewsAfterDismiss", "createAnimationListener", "messageViewCardView", "Landroidx/cardview/widget/CardView;", "createCardView", "context", "Landroid/content/Context;", "createDraggableLayoutParams", "Lcom/onesignal/inAppMessages/internal/display/impl/DraggableRelativeLayout$Params;", "disableDragging", "createParentRelativeLayoutParams", "Landroid/widget/RelativeLayout$LayoutParams;", "createPopupWindow", "delayShowUntilAvailable", "(Landroid/app/Activity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dereferenceViews", "dismissAndAwaitNextMessage", "finishAfterDelay", "getHideDropShadow", "getOverlayColor", "removeAllViews", "setMarginsFromContent", "content", "setMessageController", "setUpDraggableLayout", "relativeLayoutParams", "draggableParams", "setUpParentRelativeLayout", "setWebView", "showDraggableView", "draggableRelativeLayoutParams", "webViewLayoutParams", "(Lcom/onesignal/inAppMessages/internal/display/impl/WebViewManager$Position;Landroid/widget/RelativeLayout$LayoutParams;Landroid/widget/RelativeLayout$LayoutParams;Lcom/onesignal/inAppMessages/internal/display/impl/DraggableRelativeLayout$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showInAppMessageView", "showView", "activity", "startDismissTimerIfNeeded", "toString", "", "updateHeight", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "InAppMessageViewListener", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class InAppMessageView {
    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2 = {"Lcom/onesignal/inAppMessages/internal/display/impl/InAppMessageView$Companion;", "", "()V", "ACTIVITY_BACKGROUND_COLOR_EMPTY", "", "ACTIVITY_BACKGROUND_COLOR_FULL", "ACTIVITY_FINISH_AFTER_DISMISS_DELAY_MS", "ACTIVITY_INIT_DELAY", "DRAG_THRESHOLD_PX_SIZE", "IN_APP_BACKGROUND_ANIMATION_DURATION_MS", "IN_APP_BANNER_ANIMATION_DURATION_MS", "IN_APP_CENTER_ANIMATION_DURATION_MS", "IN_APP_MESSAGE_CARD_VIEW_TAG", "", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001A\u00020\u0003H&J\b\u0010\u0004\u001A\u00020\u0003H&J\b\u0010\u0005\u001A\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/onesignal/inAppMessages/internal/display/impl/InAppMessageView$InAppMessageViewListener;", "", "onMessageWasDismissed", "", "onMessageWasDisplayed", "onMessageWillDismiss", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public interface InAppMessageViewListener {
        void onMessageWasDismissed();

        void onMessageWasDisplayed();

        void onMessageWillDismiss();
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 0x30)
    public final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[Position.values().length];
            arr_v[Position.TOP_BANNER.ordinal()] = 1;
            arr_v[Position.BOTTOM_BANNER.ordinal()] = 2;
            arr_v[Position.CENTER_MODAL.ordinal()] = 3;
            arr_v[Position.FULL_SCREEN.ordinal()] = 4;
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    private static final int ACTIVITY_BACKGROUND_COLOR_EMPTY = 0;
    private static final int ACTIVITY_BACKGROUND_COLOR_FULL = 0;
    private static final int ACTIVITY_FINISH_AFTER_DISMISS_DELAY_MS = 600;
    private static final int ACTIVITY_INIT_DELAY = 200;
    public static final Companion Companion = null;
    private static final int DRAG_THRESHOLD_PX_SIZE = 0;
    private static final int IN_APP_BACKGROUND_ANIMATION_DURATION_MS = 400;
    private static final int IN_APP_BANNER_ANIMATION_DURATION_MS = 1000;
    private static final int IN_APP_CENTER_ANIMATION_DURATION_MS = 1000;
    private static final String IN_APP_MESSAGE_CARD_VIEW_TAG = "IN_APP_MESSAGE_CARD_VIEW_TAG";
    private boolean cancelDismissTimer;
    private Activity currentActivity;
    private final boolean disableDragDismiss;
    private final double displayDuration;
    private final Position displayPosition;
    private DraggableRelativeLayout draggableRelativeLayout;
    private final boolean hasBackground;
    private final boolean hideGrayOverlay;
    private boolean isDismissTimerSet;
    private boolean isDragging;
    private int marginPxSizeBottom;
    private int marginPxSizeLeft;
    private int marginPxSizeRight;
    private int marginPxSizeTop;
    private final InAppMessageContent messageContent;
    private InAppMessageViewListener messageController;
    private int pageHeight;
    private final int pageWidth;
    private RelativeLayout parentRelativeLayout;
    private PopupWindow popupWindow;
    private boolean shouldDismissWhenActive;
    private WebView webView;

    static {
        InAppMessageView.Companion = new Companion(null);
        InAppMessageView.ACTIVITY_BACKGROUND_COLOR_FULL = Color.parseColor("#BB000000");
        InAppMessageView.DRAG_THRESHOLD_PX_SIZE = ViewUtils.INSTANCE.dpToPx(4);
    }

    public InAppMessageView(WebView webView0, InAppMessageContent inAppMessageContent0, boolean z, boolean z1) {
        Intrinsics.checkNotNullParameter(inAppMessageContent0, "messageContent");
        double f;
        super();
        this.webView = webView0;
        this.messageContent = inAppMessageContent0;
        this.disableDragDismiss = z;
        this.hideGrayOverlay = z1;
        this.pageWidth = -1;
        this.pageHeight = inAppMessageContent0.getPageHeight();
        this.marginPxSizeLeft = ViewUtils.INSTANCE.dpToPx(24);
        this.marginPxSizeRight = ViewUtils.INSTANCE.dpToPx(24);
        this.marginPxSizeTop = ViewUtils.INSTANCE.dpToPx(24);
        this.marginPxSizeBottom = ViewUtils.INSTANCE.dpToPx(24);
        Position webViewManager$Position0 = inAppMessageContent0.getDisplayLocation();
        Intrinsics.checkNotNull(webViewManager$Position0);
        this.displayPosition = webViewManager$Position0;
        if(inAppMessageContent0.getDisplayDuration() == null) {
            f = 0.0;
        }
        else {
            Double double0 = inAppMessageContent0.getDisplayDuration();
            Intrinsics.checkNotNull(double0);
            f = (double)double0;
        }
        this.displayDuration = f;
        this.hasBackground = !webViewManager$Position0.isBanner();
        this.setMarginsFromContent(inAppMessageContent0);
    }

    public static final Object access$showDraggableView(InAppMessageView inAppMessageView0, Position webViewManager$Position0, RelativeLayout.LayoutParams relativeLayout$LayoutParams0, RelativeLayout.LayoutParams relativeLayout$LayoutParams1, Params draggableRelativeLayout$Params0, Continuation continuation0) {
        return inAppMessageView0.showDraggableView(webViewManager$Position0, relativeLayout$LayoutParams0, relativeLayout$LayoutParams1, draggableRelativeLayout$Params0, continuation0);
    }

    private final Object animateAndDismissLayout(View view0, Continuation continuation0) {
        Waiter waiter0 = new Waiter();
        this.animateBackgroundColor(view0, 400, this.getOverlayColor(), 0, new AnimatorListenerAdapter() {
            @Override  // android.animation.AnimatorListenerAdapter
            public void onAnimationEnd(Animator animator0) {
                Intrinsics.checkNotNullParameter(animator0, "animation");
                waiter0.cleanupViewsAfterDismiss();
                this.$waiter.wake();
            }
        }).start();
        Object object0 = waiter0.waitForWake(continuation0);
        return object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object0 : Unit.INSTANCE;
    }

    private final ValueAnimator animateBackgroundColor(View view0, int v, int v1, int v2, Animator.AnimatorListener animator$AnimatorListener0) {
        return OneSignalAnimate.INSTANCE.animateViewColor(view0, v, v1, v2, animator$AnimatorListener0);
    }

    private final void animateBottom(View view0, int v, Animation.AnimationListener animation$AnimationListener0) {
        float f = (float)(v + this.marginPxSizeBottom);
        OneSignalBounceInterpolator oneSignalBounceInterpolator0 = new OneSignalBounceInterpolator(0.1, 8.0);
        OneSignalAnimate.INSTANCE.animateViewByTranslation(view0, f, 0.0f, 1000, oneSignalBounceInterpolator0, animation$AnimationListener0).start();
    }

    private final void animateCenter(View view0, View view1, Animation.AnimationListener animation$AnimationListener0, Animator.AnimatorListener animator$AnimatorListener0) {
        OneSignalBounceInterpolator oneSignalBounceInterpolator0 = new OneSignalBounceInterpolator(0.1, 8.0);
        Animation animation0 = OneSignalAnimate.INSTANCE.animateViewSmallToLarge(view0, 1000, oneSignalBounceInterpolator0, animation$AnimationListener0);
        ValueAnimator valueAnimator0 = this.animateBackgroundColor(view1, 400, 0, this.getOverlayColor(), animator$AnimatorListener0);
        animation0.start();
        valueAnimator0.start();
    }

    private final void animateInAppMessage(Position webViewManager$Position0, View view0, View view1) {
        Intrinsics.checkNotNull(view0);
        CardView cardView0 = (CardView)view0.findViewWithTag("IN_APP_MESSAGE_CARD_VIEW_TAG");
        Intrinsics.checkNotNullExpressionValue(cardView0, "messageViewCardView");
        Animation.AnimationListener animation$AnimationListener0 = this.createAnimationListener(cardView0);
        switch(WhenMappings.$EnumSwitchMapping$0[webViewManager$Position0.ordinal()]) {
            case 1: {
                WebView webView0 = this.webView;
                Intrinsics.checkNotNull(webView0);
                this.animateTop(cardView0, webView0.getHeight(), animation$AnimationListener0);
                return;
            }
            case 2: {
                WebView webView1 = this.webView;
                Intrinsics.checkNotNull(webView1);
                this.animateBottom(cardView0, webView1.getHeight(), animation$AnimationListener0);
                return;
            }
            case 3: 
            case 4: {
                this.animateCenter(view0, view1, animation$AnimationListener0, null);
            }
        }
    }

    private final void animateTop(View view0, int v, Animation.AnimationListener animation$AnimationListener0) {
        float f = (float)(-v - this.marginPxSizeTop);
        OneSignalBounceInterpolator oneSignalBounceInterpolator0 = new OneSignalBounceInterpolator(0.1, 8.0);
        OneSignalAnimate.INSTANCE.animateViewByTranslation(view0, f, 0.0f, 1000, oneSignalBounceInterpolator0, animation$AnimationListener0).start();
    }

    public final Object checkIfShouldDismiss(Continuation continuation0) {
        if(this.shouldDismissWhenActive) {
            this.shouldDismissWhenActive = false;
            Object object0 = this.finishAfterDelay(continuation0);
            return object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object0 : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    private final void cleanupViewsAfterDismiss() {
        this.removeAllViews();
        InAppMessageViewListener inAppMessageView$InAppMessageViewListener0 = this.messageController;
        if(inAppMessageView$InAppMessageViewListener0 != null) {
            inAppMessageView$InAppMessageViewListener0.onMessageWasDismissed();
        }
    }

    private final Animation.AnimationListener createAnimationListener(CardView cardView0) {
        return new Animation.AnimationListener() {
            @Override  // android.view.animation.Animation$AnimationListener
            public void onAnimationEnd(Animation animation0) {
                Intrinsics.checkNotNullParameter(animation0, "animation");
                if(Build.VERSION.SDK_INT == 23) {
                    float f = (float)ViewUtils.INSTANCE.dpToPx(5);
                    this.setCardElevation(f);
                }
                if(InAppMessageView.this.messageController != null) {
                    InAppMessageViewListener inAppMessageView$InAppMessageViewListener0 = InAppMessageView.this.messageController;
                    Intrinsics.checkNotNull(inAppMessageView$InAppMessageViewListener0);
                    inAppMessageView$InAppMessageViewListener0.onMessageWasDisplayed();
                }
            }

            @Override  // android.view.animation.Animation$AnimationListener
            public void onAnimationRepeat(Animation animation0) {
                Intrinsics.checkNotNullParameter(animation0, "animation");
            }

            @Override  // android.view.animation.Animation$AnimationListener
            public void onAnimationStart(Animation animation0) {
                Intrinsics.checkNotNullParameter(animation0, "animation");
            }
        };
    }

    private final CardView createCardView(Context context0) {
        CardView cardView0 = new CardView(context0);
        RelativeLayout.LayoutParams relativeLayout$LayoutParams0 = new RelativeLayout.LayoutParams(-1, (this.displayPosition == Position.FULL_SCREEN ? -1 : -2));
        relativeLayout$LayoutParams0.addRule(13);
        cardView0.setLayoutParams(relativeLayout$LayoutParams0);
        if(Build.VERSION.SDK_INT == 23) {
            cardView0.setCardElevation(0.0f);
        }
        else if(this.getHideDropShadow(context0)) {
            cardView0.setCardElevation(0.0f);
        }
        else {
            cardView0.setCardElevation(((float)ViewUtils.INSTANCE.dpToPx(5)));
        }
        cardView0.setRadius(((float)ViewUtils.INSTANCE.dpToPx(8)));
        cardView0.setClipChildren(false);
        cardView0.setClipToPadding(false);
        cardView0.setPreventCornerOverlap(false);
        cardView0.setCardBackgroundColor(0);
        return cardView0;
    }

    private final Params createDraggableLayoutParams(int v, Position webViewManager$Position0, boolean z) {
        Params draggableRelativeLayout$Params0 = new Params();
        draggableRelativeLayout$Params0.setMaxXPos(this.marginPxSizeRight);
        draggableRelativeLayout$Params0.setMaxYPos(this.marginPxSizeTop);
        draggableRelativeLayout$Params0.setDraggingDisabled(z);
        draggableRelativeLayout$Params0.setMessageHeight(v);
        draggableRelativeLayout$Params0.setHeight(this.getDisplayYSize());
        int v1 = 1;
        switch(WhenMappings.$EnumSwitchMapping$0[webViewManager$Position0.ordinal()]) {
            case 1: {
                draggableRelativeLayout$Params0.setDragThresholdY(this.marginPxSizeTop - InAppMessageView.DRAG_THRESHOLD_PX_SIZE);
                break;
            }
            case 2: {
                draggableRelativeLayout$Params0.setPosY(this.getDisplayYSize() - v);
                draggableRelativeLayout$Params0.setDragThresholdY(this.marginPxSizeBottom + InAppMessageView.DRAG_THRESHOLD_PX_SIZE);
                break;
            }
            case 3: {
                int v2 = this.getDisplayYSize() / 2 - v / 2;
                draggableRelativeLayout$Params0.setDragThresholdY(InAppMessageView.DRAG_THRESHOLD_PX_SIZE + v2);
                draggableRelativeLayout$Params0.setMaxYPos(v2);
                draggableRelativeLayout$Params0.setPosY(v2);
                break;
            }
            case 4: {
                int v3 = this.getDisplayYSize() - (this.marginPxSizeBottom + this.marginPxSizeTop);
                draggableRelativeLayout$Params0.setMessageHeight(v3);
                int v4 = this.getDisplayYSize() / 2 - v3 / 2;
                draggableRelativeLayout$Params0.setDragThresholdY(InAppMessageView.DRAG_THRESHOLD_PX_SIZE + v4);
                draggableRelativeLayout$Params0.setMaxYPos(v4);
                draggableRelativeLayout$Params0.setPosY(v4);
            }
        }
        if(webViewManager$Position0 == Position.TOP_BANNER) {
            v1 = 0;
        }
        draggableRelativeLayout$Params0.setDragDirection(v1);
        return draggableRelativeLayout$Params0;
    }

    private final RelativeLayout.LayoutParams createParentRelativeLayoutParams() {
        RelativeLayout.LayoutParams relativeLayout$LayoutParams0 = new RelativeLayout.LayoutParams(this.pageWidth, -1);
        switch(WhenMappings.$EnumSwitchMapping$0[this.displayPosition.ordinal()]) {
            case 1: {
                relativeLayout$LayoutParams0.addRule(10);
                relativeLayout$LayoutParams0.addRule(14);
                return relativeLayout$LayoutParams0;
            }
            case 2: {
                relativeLayout$LayoutParams0.addRule(12);
                relativeLayout$LayoutParams0.addRule(14);
                return relativeLayout$LayoutParams0;
            }
            case 3: 
            case 4: {
                relativeLayout$LayoutParams0.addRule(13);
                return relativeLayout$LayoutParams0;
            }
            default: {
                return relativeLayout$LayoutParams0;
            }
        }
    }

    private final void createPopupWindow(RelativeLayout relativeLayout0) {
        int v = -1;
        int v1 = this.hasBackground ? -1 : this.pageWidth;
        if(!this.hasBackground) {
            v = -2;
        }
        PopupWindow popupWindow0 = new PopupWindow(relativeLayout0, v1, v, false);
        this.popupWindow = popupWindow0;
        Intrinsics.checkNotNull(popupWindow0);
        popupWindow0.setBackgroundDrawable(new ColorDrawable(0));
        PopupWindow popupWindow1 = this.popupWindow;
        Intrinsics.checkNotNull(popupWindow1);
        int v2 = 1;
        popupWindow1.setTouchable(true);
        PopupWindow popupWindow2 = this.popupWindow;
        Intrinsics.checkNotNull(popupWindow2);
        popupWindow2.setClippingEnabled(false);
        if(this.hasBackground) {
            v2 = 0;
        }
        else {
            switch(WhenMappings.$EnumSwitchMapping$0[this.displayPosition.ordinal()]) {
                case 1: {
                    v2 = 49;
                    break;
                }
                case 2: {
                    v2 = 81;
                    break;
                }
                case 3: 
                case 4: {
                    break;
                }
                default: {
                    throw new NoWhenBranchMatchedException();
                }
            }
        }
        PopupWindow popupWindow3 = this.popupWindow;
        Intrinsics.checkNotNull(popupWindow3);
        PopupWindowCompat.setWindowLayoutType(popupWindow3, (this.messageContent.isFullBleed() ? 1000 : 1003));
        PopupWindow popupWindow4 = this.popupWindow;
        Intrinsics.checkNotNull(popupWindow4);
        Activity activity0 = this.currentActivity;
        Intrinsics.checkNotNull(activity0);
        popupWindow4.showAtLocation(activity0.getWindow().getDecorView().getRootView(), v2, 0, 0);
    }

    private final Object delayShowUntilAvailable(Activity activity0, Continuation continuation0) {
        InAppMessageView inAppMessageView0;
        com.onesignal.inAppMessages.internal.display.impl.InAppMessageView.delayShowUntilAvailable.1 inAppMessageView$delayShowUntilAvailable$10;
        if(continuation0 instanceof com.onesignal.inAppMessages.internal.display.impl.InAppMessageView.delayShowUntilAvailable.1) {
            inAppMessageView$delayShowUntilAvailable$10 = (com.onesignal.inAppMessages.internal.display.impl.InAppMessageView.delayShowUntilAvailable.1)continuation0;
            if((inAppMessageView$delayShowUntilAvailable$10.label & 0x80000000) == 0) {
                inAppMessageView$delayShowUntilAvailable$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.delayShowUntilAvailable(null, this);
                    }
                };
            }
            else {
                inAppMessageView$delayShowUntilAvailable$10.label ^= 0x80000000;
            }
        }
        else {
            inAppMessageView$delayShowUntilAvailable$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.delayShowUntilAvailable(null, this);
                }
            };
        }
        Object object0 = inAppMessageView$delayShowUntilAvailable$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(inAppMessageView$delayShowUntilAvailable$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                if(AndroidUtils.INSTANCE.isActivityFullyReady(activity0) && this.parentRelativeLayout == null) {
                    inAppMessageView$delayShowUntilAvailable$10.label = 1;
                    return this.showInAppMessageView(activity0, inAppMessageView$delayShowUntilAvailable$10) == object1 ? object1 : Unit.INSTANCE;
                }
                inAppMessageView$delayShowUntilAvailable$10.L$0 = this;
                inAppMessageView$delayShowUntilAvailable$10.L$1 = activity0;
                inAppMessageView$delayShowUntilAvailable$10.label = 2;
                if(DelayKt.delay(200L, inAppMessageView$delayShowUntilAvailable$10) == object1) {
                    return object1;
                }
                inAppMessageView0 = this;
                break;
            }
            case 1: {
                ResultKt.throwOnFailure(object0);
                return Unit.INSTANCE;
            }
            case 2: {
                activity0 = (Activity)inAppMessageView$delayShowUntilAvailable$10.L$1;
                inAppMessageView0 = (InAppMessageView)inAppMessageView$delayShowUntilAvailable$10.L$0;
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
        inAppMessageView$delayShowUntilAvailable$10.L$0 = null;
        inAppMessageView$delayShowUntilAvailable$10.L$1 = null;
        inAppMessageView$delayShowUntilAvailable$10.label = 3;
        return inAppMessageView0.delayShowUntilAvailable(activity0, inAppMessageView$delayShowUntilAvailable$10) == object1 ? object1 : Unit.INSTANCE;
    }

    private final void dereferenceViews() {
        this.parentRelativeLayout = null;
        this.draggableRelativeLayout = null;
        this.webView = null;
    }

    public final Object dismissAndAwaitNextMessage(Continuation continuation0) {
        DraggableRelativeLayout draggableRelativeLayout0 = this.draggableRelativeLayout;
        if(draggableRelativeLayout0 == null) {
            Logging.error$default("No host presenter to trigger dismiss animation, counting as dismissed already", null, 2, null);
            this.dereferenceViews();
            return Unit.INSTANCE;
        }
        Intrinsics.checkNotNull(draggableRelativeLayout0);
        draggableRelativeLayout0.dismiss();
        Object object0 = this.finishAfterDelay(continuation0);
        return object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object0 : Unit.INSTANCE;
    }

    private final Object finishAfterDelay(Continuation continuation0) {
        Object object0 = BuildersKt.withContext(Dispatchers.getMain(), new Function2(null) {
            int label;

            {
                InAppMessageView.this = inAppMessageView0;
                super(2, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.onesignal.inAppMessages.internal.display.impl.InAppMessageView.finishAfterDelay.2(InAppMessageView.this, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function2
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.onesignal.inAppMessages.internal.display.impl.InAppMessageView.finishAfterDelay.2)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        this.label = 1;
                        if(DelayKt.delay(600L, this) == object1) {
                            return object1;
                        }
                        break;
                    }
                    case 1: {
                        ResultKt.throwOnFailure(object0);
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
                if(!InAppMessageView.this.hasBackground || InAppMessageView.this.parentRelativeLayout == null) {
                    InAppMessageView.this.cleanupViewsAfterDismiss();
                }
                else {
                    RelativeLayout relativeLayout0 = InAppMessageView.this.parentRelativeLayout;
                    Intrinsics.checkNotNull(relativeLayout0);
                    this.label = 2;
                    if(InAppMessageView.this.animateAndDismissLayout(relativeLayout0, this) == object1) {
                        return object1;
                    }
                }
                return Unit.INSTANCE;
            }
        }, continuation0);
        return object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object0 : Unit.INSTANCE;
    }

    public final Position getDisplayPosition() {
        return this.displayPosition;
    }

    private final int getDisplayYSize() {
        Activity activity0 = this.currentActivity;
        Intrinsics.checkNotNull(activity0);
        return ViewUtils.INSTANCE.getWindowHeight(activity0);
    }

    private final boolean getHideDropShadow(Context context0) {
        return AndroidUtils.INSTANCE.getManifestMetaBoolean(context0, "com.onesignal.inAppMessageHideDropShadow");
    }

    // 去混淆评级： 低(20)
    private final int getOverlayColor() {
        return this.hideGrayOverlay ? 0 : InAppMessageView.ACTIVITY_BACKGROUND_COLOR_FULL;
    }

    public final boolean isDragging() {
        return this.isDragging;
    }

    public final void removeAllViews() {
        Logging.debug$default("InAppMessageView.removeAllViews()", null, 2, null);
        if(this.isDismissTimerSet) {
            this.cancelDismissTimer = true;
        }
        DraggableRelativeLayout draggableRelativeLayout0 = this.draggableRelativeLayout;
        if(draggableRelativeLayout0 != null) {
            Intrinsics.checkNotNull(draggableRelativeLayout0);
            draggableRelativeLayout0.removeAllViews();
        }
        PopupWindow popupWindow0 = this.popupWindow;
        if(popupWindow0 != null) {
            Intrinsics.checkNotNull(popupWindow0);
            popupWindow0.dismiss();
        }
        this.dereferenceViews();
    }

    private final void setMarginsFromContent(InAppMessageContent inAppMessageContent0) {
        int v = 0;
        this.marginPxSizeTop = inAppMessageContent0.getUseHeightMargin() ? ViewUtils.INSTANCE.dpToPx(24) : 0;
        this.marginPxSizeBottom = inAppMessageContent0.getUseHeightMargin() ? ViewUtils.INSTANCE.dpToPx(24) : 0;
        this.marginPxSizeLeft = inAppMessageContent0.getUseWidthMargin() ? ViewUtils.INSTANCE.dpToPx(24) : 0;
        if(inAppMessageContent0.getUseWidthMargin()) {
            v = ViewUtils.INSTANCE.dpToPx(24);
        }
        this.marginPxSizeRight = v;
    }

    public final void setMessageController(InAppMessageViewListener inAppMessageView$InAppMessageViewListener0) {
        this.messageController = inAppMessageView$InAppMessageViewListener0;
    }

    private final void setUpDraggableLayout(Context context0, RelativeLayout.LayoutParams relativeLayout$LayoutParams0, Params draggableRelativeLayout$Params0) {
        DraggableRelativeLayout draggableRelativeLayout0 = new DraggableRelativeLayout(context0);
        this.draggableRelativeLayout = draggableRelativeLayout0;
        if(relativeLayout$LayoutParams0 != null) {
            Intrinsics.checkNotNull(draggableRelativeLayout0);
            draggableRelativeLayout0.setLayoutParams(relativeLayout$LayoutParams0);
        }
        DraggableRelativeLayout draggableRelativeLayout1 = this.draggableRelativeLayout;
        Intrinsics.checkNotNull(draggableRelativeLayout1);
        draggableRelativeLayout1.setParams(draggableRelativeLayout$Params0);
        DraggableRelativeLayout draggableRelativeLayout2 = this.draggableRelativeLayout;
        Intrinsics.checkNotNull(draggableRelativeLayout2);
        draggableRelativeLayout2.setListener(new DraggableListener() {
            @Override  // com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout$DraggableListener
            public void onDismiss() {
                if(InAppMessageView.this.messageController != null) {
                    InAppMessageViewListener inAppMessageView$InAppMessageViewListener0 = InAppMessageView.this.messageController;
                    Intrinsics.checkNotNull(inAppMessageView$InAppMessageViewListener0);
                    inAppMessageView$InAppMessageViewListener0.onMessageWillDismiss();
                }
                ThreadUtilsKt.suspendifyOnThread$default(0, new Function1(null) {
                    int label;

                    {
                        InAppMessageView.this = inAppMessageView0;
                        super(1, continuation0);
                    }

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Continuation continuation0) {
                        return new com.onesignal.inAppMessages.internal.display.impl.InAppMessageView.setUpDraggableLayout.1.onDismiss.1(InAppMessageView.this, continuation0);
                    }

                    @Override  // kotlin.jvm.functions.Function1
                    public Object invoke(Object object0) {
                        return this.invoke(((Continuation)object0));
                    }

                    public final Object invoke(Continuation continuation0) {
                        return ((com.onesignal.inAppMessages.internal.display.impl.InAppMessageView.setUpDraggableLayout.1.onDismiss.1)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch(this.label) {
                            case 0: {
                                ResultKt.throwOnFailure(object0);
                                this.label = 1;
                                return InAppMessageView.this.finishAfterDelay(this) == object1 ? object1 : Unit.INSTANCE;
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

            @Override  // com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout$DraggableListener
            public void onDragEnd() {
                InAppMessageView.this.isDragging = false;
            }

            @Override  // com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout$DraggableListener
            public void onDragStart() {
                InAppMessageView.this.isDragging = true;
            }
        });
        WebView webView0 = this.webView;
        Intrinsics.checkNotNull(webView0);
        if(webView0.getParent() != null) {
            WebView webView1 = this.webView;
            Intrinsics.checkNotNull(webView1);
            ViewParent viewParent0 = webView1.getParent();
            Intrinsics.checkNotNull(viewParent0, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup)viewParent0).removeAllViews();
        }
        CardView cardView0 = this.createCardView(context0);
        cardView0.setTag("IN_APP_MESSAGE_CARD_VIEW_TAG");
        cardView0.addView(this.webView);
        DraggableRelativeLayout draggableRelativeLayout3 = this.draggableRelativeLayout;
        Intrinsics.checkNotNull(draggableRelativeLayout3);
        draggableRelativeLayout3.setPadding(this.marginPxSizeLeft, this.marginPxSizeTop, this.marginPxSizeRight, this.marginPxSizeBottom);
        DraggableRelativeLayout draggableRelativeLayout4 = this.draggableRelativeLayout;
        Intrinsics.checkNotNull(draggableRelativeLayout4);
        draggableRelativeLayout4.setClipChildren(false);
        DraggableRelativeLayout draggableRelativeLayout5 = this.draggableRelativeLayout;
        Intrinsics.checkNotNull(draggableRelativeLayout5);
        draggableRelativeLayout5.setClipToPadding(false);
        DraggableRelativeLayout draggableRelativeLayout6 = this.draggableRelativeLayout;
        Intrinsics.checkNotNull(draggableRelativeLayout6);
        draggableRelativeLayout6.addView(cardView0);
    }

    private final void setUpParentRelativeLayout(Context context0) {
        RelativeLayout relativeLayout0 = new RelativeLayout(context0);
        this.parentRelativeLayout = relativeLayout0;
        Intrinsics.checkNotNull(relativeLayout0);
        relativeLayout0.setBackgroundDrawable(new ColorDrawable(0));
        RelativeLayout relativeLayout1 = this.parentRelativeLayout;
        Intrinsics.checkNotNull(relativeLayout1);
        relativeLayout1.setClipChildren(false);
        RelativeLayout relativeLayout2 = this.parentRelativeLayout;
        Intrinsics.checkNotNull(relativeLayout2);
        relativeLayout2.setClipToPadding(false);
        RelativeLayout relativeLayout3 = this.parentRelativeLayout;
        Intrinsics.checkNotNull(relativeLayout3);
        relativeLayout3.addView(this.draggableRelativeLayout);
    }

    public final void setWebView(WebView webView0) {
        Intrinsics.checkNotNullParameter(webView0, "webView");
        this.webView = webView0;
        Intrinsics.checkNotNull(webView0);
        webView0.setBackgroundColor(0);
    }

    private final Object showDraggableView(Position webViewManager$Position0, RelativeLayout.LayoutParams relativeLayout$LayoutParams0, RelativeLayout.LayoutParams relativeLayout$LayoutParams1, Params draggableRelativeLayout$Params0, Continuation continuation0) {
        Object object0 = BuildersKt.withContext(Dispatchers.getMain(), new Function2(relativeLayout$LayoutParams0, relativeLayout$LayoutParams1, draggableRelativeLayout$Params0, webViewManager$Position0, null) {
            final Position $displayLocation;
            final RelativeLayout.LayoutParams $draggableRelativeLayoutParams;
            final RelativeLayout.LayoutParams $relativeLayoutParams;
            final Params $webViewLayoutParams;
            int label;

            {
                InAppMessageView.this = inAppMessageView0;
                this.$relativeLayoutParams = relativeLayout$LayoutParams0;
                this.$draggableRelativeLayoutParams = relativeLayout$LayoutParams1;
                this.$webViewLayoutParams = draggableRelativeLayout$Params0;
                this.$displayLocation = webViewManager$Position0;
                super(2, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.onesignal.inAppMessages.internal.display.impl.InAppMessageView.showDraggableView.2(InAppMessageView.this, this.$relativeLayoutParams, this.$draggableRelativeLayoutParams, this.$webViewLayoutParams, this.$displayLocation, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function2
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.onesignal.inAppMessages.internal.display.impl.InAppMessageView.showDraggableView.2)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        if(InAppMessageView.this.webView == null) {
                            return Unit.INSTANCE;
                        }
                        WebView webView0 = InAppMessageView.this.webView;
                        Intrinsics.checkNotNull(webView0);
                        webView0.setLayoutParams(this.$relativeLayoutParams);
                        Activity activity0 = InAppMessageView.this.currentActivity;
                        Intrinsics.checkNotNull(activity0);
                        InAppMessageView.this.setUpDraggableLayout(activity0, this.$draggableRelativeLayoutParams, this.$webViewLayoutParams);
                        Activity activity1 = InAppMessageView.this.currentActivity;
                        Intrinsics.checkNotNull(activity1);
                        InAppMessageView.this.setUpParentRelativeLayout(activity1);
                        RelativeLayout relativeLayout0 = InAppMessageView.this.parentRelativeLayout;
                        Intrinsics.checkNotNull(relativeLayout0);
                        InAppMessageView.this.createPopupWindow(relativeLayout0);
                        if(InAppMessageView.this.messageController != null) {
                            DraggableRelativeLayout draggableRelativeLayout0 = InAppMessageView.this.draggableRelativeLayout;
                            Intrinsics.checkNotNull(draggableRelativeLayout0);
                            RelativeLayout relativeLayout1 = InAppMessageView.this.parentRelativeLayout;
                            Intrinsics.checkNotNull(relativeLayout1);
                            InAppMessageView.this.animateInAppMessage(this.$displayLocation, draggableRelativeLayout0, relativeLayout1);
                        }
                        this.label = 1;
                        return InAppMessageView.this.startDismissTimerIfNeeded(this) == object1 ? object1 : Unit.INSTANCE;
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
        }, continuation0);
        return object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object0 : Unit.INSTANCE;
    }

    public final Object showInAppMessageView(Activity activity0, Continuation continuation0) {
        this.currentActivity = activity0;
        RelativeLayout.LayoutParams relativeLayout$LayoutParams0 = new RelativeLayout.LayoutParams(-1, this.pageHeight);
        relativeLayout$LayoutParams0.addRule(13);
        RelativeLayout.LayoutParams relativeLayout$LayoutParams1 = this.hasBackground ? this.createParentRelativeLayoutParams() : null;
        Params draggableRelativeLayout$Params0 = this.createDraggableLayoutParams(this.pageHeight, this.displayPosition, this.disableDragDismiss);
        Object object0 = this.showDraggableView(this.displayPosition, relativeLayout$LayoutParams0, relativeLayout$LayoutParams1, draggableRelativeLayout$Params0, continuation0);
        return object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object0 : Unit.INSTANCE;
    }

    public final Object showView(Activity activity0, Continuation continuation0) {
        Object object0 = this.delayShowUntilAvailable(activity0, continuation0);
        return object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object0 : Unit.INSTANCE;
    }

    private final Object startDismissTimerIfNeeded(Continuation continuation0) {
        InAppMessageView inAppMessageView1;
        InAppMessageView inAppMessageView0;
        com.onesignal.inAppMessages.internal.display.impl.InAppMessageView.startDismissTimerIfNeeded.1 inAppMessageView$startDismissTimerIfNeeded$10;
        if(continuation0 instanceof com.onesignal.inAppMessages.internal.display.impl.InAppMessageView.startDismissTimerIfNeeded.1) {
            inAppMessageView$startDismissTimerIfNeeded$10 = (com.onesignal.inAppMessages.internal.display.impl.InAppMessageView.startDismissTimerIfNeeded.1)continuation0;
            if((inAppMessageView$startDismissTimerIfNeeded$10.label & 0x80000000) == 0) {
                inAppMessageView$startDismissTimerIfNeeded$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.startDismissTimerIfNeeded(this);
                    }
                };
            }
            else {
                inAppMessageView$startDismissTimerIfNeeded$10.label ^= 0x80000000;
            }
        }
        else {
            inAppMessageView$startDismissTimerIfNeeded$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.startDismissTimerIfNeeded(this);
                }
            };
        }
        Object object0 = inAppMessageView$startDismissTimerIfNeeded$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(inAppMessageView$startDismissTimerIfNeeded$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                double f = this.displayDuration;
                if(f > 0.0 && !this.isDismissTimerSet) {
                    this.isDismissTimerSet = true;
                    inAppMessageView$startDismissTimerIfNeeded$10.L$0 = this;
                    inAppMessageView$startDismissTimerIfNeeded$10.label = 1;
                    if(DelayKt.delay(((long)f) * 1000L, inAppMessageView$startDismissTimerIfNeeded$10) == object1) {
                        return object1;
                    }
                    inAppMessageView0 = this;
                    goto label_25;
                }
                return Unit.INSTANCE;
            }
            case 1: {
                inAppMessageView0 = (InAppMessageView)inAppMessageView$startDismissTimerIfNeeded$10.L$0;
                ResultKt.throwOnFailure(object0);
            label_25:
                if(inAppMessageView0.cancelDismissTimer) {
                    inAppMessageView0.cancelDismissTimer = false;
                    return Unit.INSTANCE;
                }
                InAppMessageViewListener inAppMessageView$InAppMessageViewListener0 = inAppMessageView0.messageController;
                if(inAppMessageView$InAppMessageViewListener0 != null) {
                    Intrinsics.checkNotNull(inAppMessageView$InAppMessageViewListener0);
                    inAppMessageView$InAppMessageViewListener0.onMessageWillDismiss();
                }
                if(inAppMessageView0.currentActivity != null) {
                    inAppMessageView$startDismissTimerIfNeeded$10.L$0 = inAppMessageView0;
                    inAppMessageView$startDismissTimerIfNeeded$10.label = 2;
                    if(inAppMessageView0.dismissAndAwaitNextMessage(inAppMessageView$startDismissTimerIfNeeded$10) == object1) {
                        return object1;
                    }
                    inAppMessageView1 = inAppMessageView0;
                    break;
                }
                inAppMessageView0.shouldDismissWhenActive = true;
                return Unit.INSTANCE;
            }
            case 2: {
                inAppMessageView1 = (InAppMessageView)inAppMessageView$startDismissTimerIfNeeded$10.L$0;
                ResultKt.throwOnFailure(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        inAppMessageView1.isDismissTimerSet = false;
        return Unit.INSTANCE;
    }

    @Override
    public String toString() {
        return "InAppMessageView{currentActivity=" + this.currentActivity + ", pageWidth=" + this.pageWidth + ", pageHeight=" + this.pageHeight + ", displayDuration=" + this.displayDuration + ", hasBackground=" + this.hasBackground + ", shouldDismissWhenActive=" + this.shouldDismissWhenActive + ", isDragging=" + this.isDragging + ", disableDragDismiss=" + this.disableDragDismiss + ", displayLocation=" + this.displayPosition + ", webView=" + this.webView + '}';
    }

    public final Object updateHeight(int v, Continuation continuation0) {
        this.pageHeight = v;
        Object object0 = BuildersKt.withContext(Dispatchers.getMain(), new Function2(v, null) {
            final int $pageHeight;
            int label;

            {
                InAppMessageView.this = inAppMessageView0;
                this.$pageHeight = v;
                super(2, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.onesignal.inAppMessages.internal.display.impl.InAppMessageView.updateHeight.2(InAppMessageView.this, this.$pageHeight, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function2
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.onesignal.inAppMessages.internal.display.impl.InAppMessageView.updateHeight.2)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                ResultKt.throwOnFailure(object0);
                if(InAppMessageView.this.webView == null) {
                    Logging.warn$default("WebView height update skipped, new height will be used once it is displayed.", null, 2, null);
                    return Unit.INSTANCE;
                }
                WebView webView0 = InAppMessageView.this.webView;
                Intrinsics.checkNotNull(webView0);
                ViewGroup.LayoutParams viewGroup$LayoutParams0 = webView0.getLayoutParams();
                if(viewGroup$LayoutParams0 == null) {
                    Logging.warn$default("WebView height update skipped because of null layoutParams, new height will be used once it is displayed.", null, 2, null);
                    return Unit.INSTANCE;
                }
                viewGroup$LayoutParams0.height = this.$pageHeight;
                WebView webView1 = InAppMessageView.this.webView;
                Intrinsics.checkNotNull(webView1);
                webView1.setLayoutParams(viewGroup$LayoutParams0);
                if(InAppMessageView.this.draggableRelativeLayout != null) {
                    DraggableRelativeLayout draggableRelativeLayout0 = InAppMessageView.this.draggableRelativeLayout;
                    Intrinsics.checkNotNull(draggableRelativeLayout0);
                    draggableRelativeLayout0.setParams(InAppMessageView.this.createDraggableLayoutParams(this.$pageHeight, InAppMessageView.this.getDisplayPosition(), InAppMessageView.this.disableDragDismiss));
                }
                return Unit.INSTANCE;
            }
        }, continuation0);
        return object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object0 : Unit.INSTANCE;
    }
}

