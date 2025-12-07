package androidx.activity.result.contract;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0011\u0018\u00002\u00020\u0001:\u000F\u0003\u0004\u0005\u0006\u0007\b\t\n\u000B\f\r\u000E\u000F\u0010\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0012"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts;", "", "()V", "CaptureVideo", "CreateDocument", "GetContent", "GetMultipleContents", "OpenDocument", "OpenDocumentTree", "OpenMultipleDocuments", "PickContact", "RequestMultiplePermissions", "RequestPermission", "StartActivityForResult", "StartIntentSenderForResult", "TakePicture", "TakePicturePreview", "TakeVideo", "activity_release"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
public final class ActivityResultContracts {
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\u0002H\u0017J\u001E\u0010\n\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000B2\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\u0002J\u001D\u0010\f\u001A\u00020\u00032\u0006\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$CaptureVideo;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/net/Uri;", "", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "(ILandroid/content/Intent;)Ljava/lang/Boolean;", "activity_release"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    public static class CaptureVideo extends ActivityResultContract {
        public Intent createIntent(Context context0, Uri uri0) {
            Intrinsics.checkNotNullParameter(context0, "context");
            Intrinsics.checkNotNullParameter(uri0, "input");
            Intent intent0 = new Intent("android.media.action.VIDEO_CAPTURE").putExtra("output", uri0);
            Intrinsics.checkNotNullExpressionValue(intent0, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return intent0;
        }

        @Override  // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context0, Object object0) {
            return this.createIntent(context0, ((Uri)object0));
        }

        public final SynchronousResult getSynchronousResult(Context context0, Uri uri0) {
            Intrinsics.checkNotNullParameter(context0, "context");
            Intrinsics.checkNotNullParameter(uri0, "input");
            return null;
        }

        @Override  // androidx.activity.result.contract.ActivityResultContract
        public SynchronousResult getSynchronousResult(Context context0, Object object0) {
            return this.getSynchronousResult(context0, ((Uri)object0));
        }

        public final Boolean parseResult(int v, Intent intent0) {
            return v == -1;
        }

        @Override  // androidx.activity.result.contract.ActivityResultContract
        public Object parseResult(int v, Intent intent0) {
            return this.parseResult(v, intent0);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0017\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0007\b\u0017¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001A\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u0002H\u0017J \u0010\f\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\r2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u0002J\u001A\u0010\u000E\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\bR\u000E\u0010\u0005\u001A\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$CreateDocument;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "Landroid/net/Uri;", "()V", "mimeType", "(Ljava/lang/String;)V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "activity_release"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    public static class CreateDocument extends ActivityResultContract {
        private final String mimeType;

        @Deprecated(message = "Using a wildcard mime type with CreateDocument is not recommended as it breaks the automatic handling of file extensions. Instead, specify the mime type by using the constructor that takes an concrete mime type (e.g.., CreateDocument(\"image/png\")).", replaceWith = @ReplaceWith(expression = "CreateDocument(\"todo/todo\")", imports = {}))
        public CreateDocument() {
            this("*/*");
        }

        public CreateDocument(String s) {
            Intrinsics.checkNotNullParameter(s, "mimeType");
            super();
            this.mimeType = s;
        }

        @Override  // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context0, Object object0) {
            return this.createIntent(context0, ((String)object0));
        }

        public Intent createIntent(Context context0, String s) {
            Intrinsics.checkNotNullParameter(context0, "context");
            Intrinsics.checkNotNullParameter(s, "input");
            Intent intent0 = new Intent("android.intent.action.CREATE_DOCUMENT").setType(this.mimeType).putExtra("android.intent.extra.TITLE", s);
            Intrinsics.checkNotNullExpressionValue(intent0, "Intent(Intent.ACTION_CRE…ntent.EXTRA_TITLE, input)");
            return intent0;
        }

        @Override  // androidx.activity.result.contract.ActivityResultContract
        public SynchronousResult getSynchronousResult(Context context0, Object object0) {
            return this.getSynchronousResult(context0, ((String)object0));
        }

        public final SynchronousResult getSynchronousResult(Context context0, String s) {
            Intrinsics.checkNotNullParameter(context0, "context");
            Intrinsics.checkNotNullParameter(s, "input");
            return null;
        }

        public final Uri parseResult(int v, Intent intent0) {
            if(v != -1) {
                intent0 = null;
            }
            return intent0 == null ? null : intent0.getData();
        }

        @Override  // androidx.activity.result.contract.ActivityResultContract
        public Object parseResult(int v, Intent intent0) {
            return this.parseResult(v, intent0);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\u0002H\u0017J \u0010\n\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000B2\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\u0002J\u001A\u0010\f\u001A\u0004\u0018\u00010\u00032\u0006\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0006¨\u0006\u0010"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$GetContent;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "Landroid/net/Uri;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "activity_release"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    public static class GetContent extends ActivityResultContract {
        @Override  // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context0, Object object0) {
            return this.createIntent(context0, ((String)object0));
        }

        public Intent createIntent(Context context0, String s) {
            Intrinsics.checkNotNullParameter(context0, "context");
            Intrinsics.checkNotNullParameter(s, "input");
            Intent intent0 = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(s);
            Intrinsics.checkNotNullExpressionValue(intent0, "Intent(Intent.ACTION_GET…          .setType(input)");
            return intent0;
        }

        @Override  // androidx.activity.result.contract.ActivityResultContract
        public SynchronousResult getSynchronousResult(Context context0, Object object0) {
            return this.getSynchronousResult(context0, ((String)object0));
        }

        public final SynchronousResult getSynchronousResult(Context context0, String s) {
            Intrinsics.checkNotNullParameter(context0, "context");
            Intrinsics.checkNotNullParameter(s, "input");
            return null;
        }

        public final Uri parseResult(int v, Intent intent0) {
            if(v != -1) {
                intent0 = null;
            }
            return intent0 == null ? null : intent0.getData();
        }

        @Override  // androidx.activity.result.contract.ActivityResultContract
        public Object parseResult(int v, Intent intent0) {
            return this.parseResult(v, intent0);
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0017\u0018\u0000 \u00122\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u000F\u0012\r\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\u00050\u00030\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u0002H\u0017J$\u0010\f\u001A\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\r2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u0002J\u001E\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\b¨\u0006\u0013"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$GetMultipleContents;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "Landroid/net/Uri;", "Lkotlin/jvm/JvmSuppressWildcards;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "Companion", "activity_release"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    public static class GetMultipleContents extends ActivityResultContract {
        @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u0006H\u0000¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$GetMultipleContents$Companion;", "", "()V", "getClipDataUris", "", "Landroid/net/Uri;", "Landroid/content/Intent;", "getClipDataUris$activity_release", "activity_release"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
        public static final class Companion {
            private Companion() {
            }

            public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }

            public final List getClipDataUris$activity_release(Intent intent0) {
                Intrinsics.checkNotNullParameter(intent0, "<this>");
                LinkedHashSet linkedHashSet0 = new LinkedHashSet();
                Uri uri0 = intent0.getData();
                if(uri0 != null) {
                    linkedHashSet0.add(uri0);
                }
                ClipData clipData0 = intent0.getClipData();
                if(clipData0 == null && linkedHashSet0.isEmpty()) {
                    return CollectionsKt.emptyList();
                }
                if(clipData0 != null) {
                    int v = clipData0.getItemCount();
                    for(int v1 = 0; v1 < v; ++v1) {
                        Uri uri1 = clipData0.getItemAt(v1).getUri();
                        if(uri1 != null) {
                            linkedHashSet0.add(uri1);
                        }
                    }
                }
                return new ArrayList(linkedHashSet0);
            }
        }

        public static final Companion Companion;

        static {
            GetMultipleContents.Companion = new Companion(null);
        }

        @Override  // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context0, Object object0) {
            return this.createIntent(context0, ((String)object0));
        }

        public Intent createIntent(Context context0, String s) {
            Intrinsics.checkNotNullParameter(context0, "context");
            Intrinsics.checkNotNullParameter(s, "input");
            Intent intent0 = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(s).putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            Intrinsics.checkNotNullExpressionValue(intent0, "Intent(Intent.ACTION_GET…TRA_ALLOW_MULTIPLE, true)");
            return intent0;
        }

        @Override  // androidx.activity.result.contract.ActivityResultContract
        public SynchronousResult getSynchronousResult(Context context0, Object object0) {
            return this.getSynchronousResult(context0, ((String)object0));
        }

        public final SynchronousResult getSynchronousResult(Context context0, String s) {
            Intrinsics.checkNotNullParameter(context0, "context");
            Intrinsics.checkNotNullParameter(s, "input");
            return null;
        }

        @Override  // androidx.activity.result.contract.ActivityResultContract
        public Object parseResult(int v, Intent intent0) {
            return this.parseResult(v, intent0);
        }

        public final List parseResult(int v, Intent intent0) {
            if(v != -1) {
                intent0 = null;
            }
            if(intent0 != null) {
                List list0 = GetMultipleContents.Companion.getClipDataUris$activity_release(intent0);
                return list0 == null ? CollectionsKt.emptyList() : list0;
            }
            return CollectionsKt.emptyList();
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0017\u0018\u00002\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001B\u0005¢\u0006\u0002\u0010\u0005J#\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0017¢\u0006\u0002\u0010\u000BJ+\u0010\f\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\r2\u0006\u0010\b\u001A\u00020\t2\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\u0010\u000EJ\u001A\u0010\u000F\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001A\u00020\u00112\b\u0010\u0012\u001A\u0004\u0018\u00010\u0007¨\u0006\u0013"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$OpenDocument;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "Landroid/net/Uri;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "(Landroid/content/Context;[Ljava/lang/String;)Landroid/content/Intent;", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "(Landroid/content/Context;[Ljava/lang/String;)Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "activity_release"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    public static class OpenDocument extends ActivityResultContract {
        @Override  // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context0, Object object0) {
            return this.createIntent(context0, ((String[])object0));
        }

        public Intent createIntent(Context context0, String[] arr_s) {
            Intrinsics.checkNotNullParameter(context0, "context");
            Intrinsics.checkNotNullParameter(arr_s, "input");
            Intent intent0 = new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", arr_s).setType("*/*");
            Intrinsics.checkNotNullExpressionValue(intent0, "Intent(Intent.ACTION_OPE…          .setType(\"*/*\")");
            return intent0;
        }

        @Override  // androidx.activity.result.contract.ActivityResultContract
        public SynchronousResult getSynchronousResult(Context context0, Object object0) {
            return this.getSynchronousResult(context0, ((String[])object0));
        }

        public final SynchronousResult getSynchronousResult(Context context0, String[] arr_s) {
            Intrinsics.checkNotNullParameter(context0, "context");
            Intrinsics.checkNotNullParameter(arr_s, "input");
            return null;
        }

        public final Uri parseResult(int v, Intent intent0) {
            if(v != -1) {
                intent0 = null;
            }
            return intent0 == null ? null : intent0.getData();
        }

        @Override  // androidx.activity.result.contract.ActivityResultContract
        public Object parseResult(int v, Intent intent0) {
            return this.parseResult(v, intent0);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0017\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001A\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\u0002H\u0017J\"\u0010\t\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\n2\u0006\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\u0002J\u001A\u0010\u000B\u001A\u0004\u0018\u00010\u00022\u0006\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u0005¨\u0006\u000F"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$OpenDocumentTree;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/net/Uri;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "activity_release"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    public static class OpenDocumentTree extends ActivityResultContract {
        public Intent createIntent(Context context0, Uri uri0) {
            Intrinsics.checkNotNullParameter(context0, "context");
            Intent intent0 = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
            if(Build.VERSION.SDK_INT >= 26 && uri0 != null) {
                intent0.putExtra("android.provider.extra.INITIAL_URI", uri0);
            }
            return intent0;
        }

        @Override  // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context0, Object object0) {
            return this.createIntent(context0, ((Uri)object0));
        }

        public final SynchronousResult getSynchronousResult(Context context0, Uri uri0) {
            Intrinsics.checkNotNullParameter(context0, "context");
            return null;
        }

        @Override  // androidx.activity.result.contract.ActivityResultContract
        public SynchronousResult getSynchronousResult(Context context0, Object object0) {
            return this.getSynchronousResult(context0, ((Uri)object0));
        }

        public final Uri parseResult(int v, Intent intent0) {
            if(v != -1) {
                intent0 = null;
            }
            return intent0 == null ? null : intent0.getData();
        }

        @Override  // androidx.activity.result.contract.ActivityResultContract
        public Object parseResult(int v, Intent intent0) {
            return this.parseResult(v, intent0);
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000E\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0017\u0018\u00002\u001F\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000F\u0012\r\u0012\t\u0012\u00070\u0005¢\u0006\u0002\b\u00060\u00040\u0001B\u0005¢\u0006\u0002\u0010\u0007J#\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0017¢\u0006\u0002\u0010\rJ/\u0010\u000E\u001A\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u000F2\u0006\u0010\n\u001A\u00020\u000B2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\u0010\u0010J\u001E\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\t¨\u0006\u0015"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$OpenMultipleDocuments;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "", "Landroid/net/Uri;", "Lkotlin/jvm/JvmSuppressWildcards;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "(Landroid/content/Context;[Ljava/lang/String;)Landroid/content/Intent;", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "(Landroid/content/Context;[Ljava/lang/String;)Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "activity_release"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    public static class OpenMultipleDocuments extends ActivityResultContract {
        @Override  // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context0, Object object0) {
            return this.createIntent(context0, ((String[])object0));
        }

        public Intent createIntent(Context context0, String[] arr_s) {
            Intrinsics.checkNotNullParameter(context0, "context");
            Intrinsics.checkNotNullParameter(arr_s, "input");
            Intent intent0 = new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", arr_s).putExtra("android.intent.extra.ALLOW_MULTIPLE", true).setType("*/*");
            Intrinsics.checkNotNullExpressionValue(intent0, "Intent(Intent.ACTION_OPE…          .setType(\"*/*\")");
            return intent0;
        }

        @Override  // androidx.activity.result.contract.ActivityResultContract
        public SynchronousResult getSynchronousResult(Context context0, Object object0) {
            return this.getSynchronousResult(context0, ((String[])object0));
        }

        public final SynchronousResult getSynchronousResult(Context context0, String[] arr_s) {
            Intrinsics.checkNotNullParameter(context0, "context");
            Intrinsics.checkNotNullParameter(arr_s, "input");
            return null;
        }

        @Override  // androidx.activity.result.contract.ActivityResultContract
        public Object parseResult(int v, Intent intent0) {
            return this.parseResult(v, intent0);
        }

        public final List parseResult(int v, Intent intent0) {
            if(v != -1) {
                intent0 = null;
            }
            if(intent0 != null) {
                List list0 = GetMultipleContents.Companion.getClipDataUris$activity_release(intent0);
                return list0 == null ? CollectionsKt.emptyList() : list0;
            }
            return CollectionsKt.emptyList();
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u001A\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\b\u0010\t\u001A\u0004\u0018\u00010\u0002H\u0016J\u001C\u0010\n\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u0006H\u0016¨\u0006\u000E"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$PickContact;", "Landroidx/activity/result/contract/ActivityResultContract;", "Ljava/lang/Void;", "Landroid/net/Uri;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "parseResult", "resultCode", "", "intent", "activity_release"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    public static final class PickContact extends ActivityResultContract {
        @Override  // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context0, Object object0) {
            return this.createIntent(context0, ((Void)object0));
        }

        public Intent createIntent(Context context0, Void void0) {
            Intrinsics.checkNotNullParameter(context0, "context");
            Intent intent0 = new Intent("android.intent.action.PICK").setType("vnd.android.cursor.dir/contact");
            Intrinsics.checkNotNullExpressionValue(intent0, "Intent(Intent.ACTION_PIC…ct.Contacts.CONTENT_TYPE)");
            return intent0;
        }

        public Uri parseResult(int v, Intent intent0) {
            if(v != -1) {
                intent0 = null;
            }
            return intent0 == null ? null : intent0.getData();
        }

        @Override  // androidx.activity.result.contract.ActivityResultContract
        public Object parseResult(int v, Intent intent0) {
            return this.parseResult(v, intent0);
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000E\n\u0002\u0010$\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00152%\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0003\u0012\t\u0012\u00070\u0005¢\u0006\u0002\b\u00060\u00040\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0007J#\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0002\u0010\rJ7\u0010\u000E\u001A\u0016\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u000F2\u0006\u0010\n\u001A\u00020\u000B2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0002\u0010\u0010J&\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\tH\u0016¨\u0006\u0016"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$RequestMultiplePermissions;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "", "", "Lkotlin/jvm/JvmSuppressWildcards;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "(Landroid/content/Context;[Ljava/lang/String;)Landroid/content/Intent;", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "(Landroid/content/Context;[Ljava/lang/String;)Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "Companion", "activity_release"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    public static final class RequestMultiplePermissions extends ActivityResultContract {
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001D\u0010\u0007\u001A\u00020\b2\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00040\nH\u0000¢\u0006\u0004\b\u000B\u0010\fR\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$RequestMultiplePermissions$Companion;", "", "()V", "ACTION_REQUEST_PERMISSIONS", "", "EXTRA_PERMISSIONS", "EXTRA_PERMISSION_GRANT_RESULTS", "createIntent", "Landroid/content/Intent;", "input", "", "createIntent$activity_release", "([Ljava/lang/String;)Landroid/content/Intent;", "activity_release"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
        public static final class androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions.Companion {
            private androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions.Companion() {
            }

            public androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }

            public final Intent createIntent$activity_release(String[] arr_s) {
                Intrinsics.checkNotNullParameter(arr_s, "input");
                Intent intent0 = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", arr_s);
                Intrinsics.checkNotNullExpressionValue(intent0, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
                return intent0;
            }
        }

        public static final String ACTION_REQUEST_PERMISSIONS = "androidx.activity.result.contract.action.REQUEST_PERMISSIONS";
        public static final androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions.Companion Companion = null;
        public static final String EXTRA_PERMISSIONS = "androidx.activity.result.contract.extra.PERMISSIONS";
        public static final String EXTRA_PERMISSION_GRANT_RESULTS = "androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS";

        static {
            RequestMultiplePermissions.Companion = new androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions.Companion(null);
        }

        @Override  // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context0, Object object0) {
            return this.createIntent(context0, ((String[])object0));
        }

        public Intent createIntent(Context context0, String[] arr_s) {
            Intrinsics.checkNotNullParameter(context0, "context");
            Intrinsics.checkNotNullParameter(arr_s, "input");
            return RequestMultiplePermissions.Companion.createIntent$activity_release(arr_s);
        }

        @Override  // androidx.activity.result.contract.ActivityResultContract
        public SynchronousResult getSynchronousResult(Context context0, Object object0) {
            return this.getSynchronousResult(context0, ((String[])object0));
        }

        public SynchronousResult getSynchronousResult(Context context0, String[] arr_s) {
            Intrinsics.checkNotNullParameter(context0, "context");
            Intrinsics.checkNotNullParameter(arr_s, "input");
            if(arr_s.length == 0) {
                return new SynchronousResult(MapsKt.emptyMap());
            }
            for(int v1 = 0; true; ++v1) {
                boolean z = true;
                if(v1 >= arr_s.length) {
                    break;
                }
                if(ContextCompat.checkSelfPermission(context0, arr_s[v1]) != 0) {
                    z = false;
                    break;
                }
            }
            if(z) {
                Map map0 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(arr_s.length), 16));
                for(int v = 0; v < arr_s.length; ++v) {
                    Pair pair0 = TuplesKt.to(arr_s[v], Boolean.TRUE);
                    map0.put(pair0.getFirst(), pair0.getSecond());
                }
                return new SynchronousResult(map0);
            }
            return null;
        }

        @Override  // androidx.activity.result.contract.ActivityResultContract
        public Object parseResult(int v, Intent intent0) {
            return this.parseResult(v, intent0);
        }

        public Map parseResult(int v, Intent intent0) {
            if(v != -1) {
                return MapsKt.emptyMap();
            }
            if(intent0 == null) {
                return MapsKt.emptyMap();
            }
            String[] arr_s = intent0.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            int[] arr_v = intent0.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
            if(arr_v != null && arr_s != null) {
                ArrayList arrayList0 = new ArrayList(arr_v.length);
                for(int v1 = 0; v1 < arr_v.length; ++v1) {
                    arrayList0.add(Boolean.valueOf(arr_v[v1] == 0));
                }
                return MapsKt.toMap(CollectionsKt.zip(ArraysKt.filterNotNull(arr_s), arrayList0));
            }
            return MapsKt.emptyMap();
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\u0002H\u0016J \u0010\n\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000B2\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\u0002H\u0016J\u001F\u0010\f\u001A\u00020\u00032\u0006\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$RequestPermission;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "(ILandroid/content/Intent;)Ljava/lang/Boolean;", "activity_release"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    public static final class RequestPermission extends ActivityResultContract {
        @Override  // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context0, Object object0) {
            return this.createIntent(context0, ((String)object0));
        }

        public Intent createIntent(Context context0, String s) {
            Intrinsics.checkNotNullParameter(context0, "context");
            Intrinsics.checkNotNullParameter(s, "input");
            return RequestMultiplePermissions.Companion.createIntent$activity_release(new String[]{s});
        }

        @Override  // androidx.activity.result.contract.ActivityResultContract
        public SynchronousResult getSynchronousResult(Context context0, Object object0) {
            return this.getSynchronousResult(context0, ((String)object0));
        }

        public SynchronousResult getSynchronousResult(Context context0, String s) {
            Intrinsics.checkNotNullParameter(context0, "context");
            Intrinsics.checkNotNullParameter(s, "input");
            return ContextCompat.checkSelfPermission(context0, s) == 0 ? null : new SynchronousResult(Boolean.TRUE);
        }

        public Boolean parseResult(int v, Intent intent0) {
            boolean z = false;
            if(intent0 != null && v == -1) {
                int[] arr_v = intent0.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
                if(arr_v != null) {
                    for(int v1 = 0; true; ++v1) {
                        boolean z1 = false;
                        if(v1 >= arr_v.length) {
                            break;
                        }
                        if(arr_v[v1] == 0) {
                            z1 = true;
                            break;
                        }
                    }
                    if(z1) {
                        z = true;
                    }
                }
                return Boolean.valueOf(z);
            }
            return false;
        }

        @Override  // androidx.activity.result.contract.ActivityResultContract
        public Object parseResult(int v, Intent intent0) {
            return this.parseResult(v, intent0);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \r2\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001A\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0002H\u0016J\u001A\u0010\t\u001A\u00020\u00032\u0006\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0002H\u0016¨\u0006\u000E"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$StartActivityForResult;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/content/Intent;", "Landroidx/activity/result/ActivityResult;", "()V", "createIntent", "context", "Landroid/content/Context;", "input", "parseResult", "resultCode", "", "intent", "Companion", "activity_release"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    public static final class StartActivityForResult extends ActivityResultContract {
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$StartActivityForResult$Companion;", "", "()V", "EXTRA_ACTIVITY_OPTIONS_BUNDLE", "", "activity_release"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
        public static final class androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult.Companion {
            private androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult.Companion() {
            }

            public androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }
        }

        public static final androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult.Companion Companion = null;
        public static final String EXTRA_ACTIVITY_OPTIONS_BUNDLE = "androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE";

        static {
            StartActivityForResult.Companion = new androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult.Companion(null);
        }

        public Intent createIntent(Context context0, Intent intent0) {
            Intrinsics.checkNotNullParameter(context0, "context");
            Intrinsics.checkNotNullParameter(intent0, "input");
            return intent0;
        }

        @Override  // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context0, Object object0) {
            return this.createIntent(context0, ((Intent)object0));
        }

        public ActivityResult parseResult(int v, Intent intent0) {
            return new ActivityResult(v, intent0);
        }

        @Override  // androidx.activity.result.contract.ActivityResultContract
        public Object parseResult(int v, Intent intent0) {
            return this.parseResult(v, intent0);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u000E2\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000EB\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\u0002H\u0016J\u001A\u0010\n\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u0006H\u0016¨\u0006\u000F"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$StartIntentSenderForResult;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroidx/activity/result/IntentSenderRequest;", "Landroidx/activity/result/ActivityResult;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "parseResult", "resultCode", "", "intent", "Companion", "activity_release"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    public static final class StartIntentSenderForResult extends ActivityResultContract {
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$StartIntentSenderForResult$Companion;", "", "()V", "ACTION_INTENT_SENDER_REQUEST", "", "EXTRA_INTENT_SENDER_REQUEST", "EXTRA_SEND_INTENT_EXCEPTION", "activity_release"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
        public static final class androidx.activity.result.contract.ActivityResultContracts.StartIntentSenderForResult.Companion {
            private androidx.activity.result.contract.ActivityResultContracts.StartIntentSenderForResult.Companion() {
            }

            public androidx.activity.result.contract.ActivityResultContracts.StartIntentSenderForResult.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }
        }

        public static final String ACTION_INTENT_SENDER_REQUEST = "androidx.activity.result.contract.action.INTENT_SENDER_REQUEST";
        public static final androidx.activity.result.contract.ActivityResultContracts.StartIntentSenderForResult.Companion Companion = null;
        public static final String EXTRA_INTENT_SENDER_REQUEST = "androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST";
        public static final String EXTRA_SEND_INTENT_EXCEPTION = "androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION";

        static {
            StartIntentSenderForResult.Companion = new androidx.activity.result.contract.ActivityResultContracts.StartIntentSenderForResult.Companion(null);
        }

        public Intent createIntent(Context context0, IntentSenderRequest intentSenderRequest0) {
            Intrinsics.checkNotNullParameter(context0, "context");
            Intrinsics.checkNotNullParameter(intentSenderRequest0, "input");
            Intent intent0 = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", intentSenderRequest0);
            Intrinsics.checkNotNullExpressionValue(intent0, "Intent(ACTION_INTENT_SEN…NT_SENDER_REQUEST, input)");
            return intent0;
        }

        @Override  // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context0, Object object0) {
            return this.createIntent(context0, ((IntentSenderRequest)object0));
        }

        public ActivityResult parseResult(int v, Intent intent0) {
            return new ActivityResult(v, intent0);
        }

        @Override  // androidx.activity.result.contract.ActivityResultContract
        public Object parseResult(int v, Intent intent0) {
            return this.parseResult(v, intent0);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\u0002H\u0017J\u001E\u0010\n\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000B2\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\u0002J\u001D\u0010\f\u001A\u00020\u00032\u0006\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$TakePicture;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/net/Uri;", "", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "(ILandroid/content/Intent;)Ljava/lang/Boolean;", "activity_release"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    public static class TakePicture extends ActivityResultContract {
        public Intent createIntent(Context context0, Uri uri0) {
            Intrinsics.checkNotNullParameter(context0, "context");
            Intrinsics.checkNotNullParameter(uri0, "input");
            Intent intent0 = new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", uri0);
            Intrinsics.checkNotNullExpressionValue(intent0, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return intent0;
        }

        @Override  // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context0, Object object0) {
            return this.createIntent(context0, ((Uri)object0));
        }

        public final SynchronousResult getSynchronousResult(Context context0, Uri uri0) {
            Intrinsics.checkNotNullParameter(context0, "context");
            Intrinsics.checkNotNullParameter(uri0, "input");
            return null;
        }

        @Override  // androidx.activity.result.contract.ActivityResultContract
        public SynchronousResult getSynchronousResult(Context context0, Object object0) {
            return this.getSynchronousResult(context0, ((Uri)object0));
        }

        public final Boolean parseResult(int v, Intent intent0) {
            return v == -1;
        }

        @Override  // androidx.activity.result.contract.ActivityResultContract
        public Object parseResult(int v, Intent intent0) {
            return this.parseResult(v, intent0);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u001A\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\b\u0010\t\u001A\u0004\u0018\u00010\u0002H\u0017J\"\u0010\n\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000B2\u0006\u0010\u0007\u001A\u00020\b2\b\u0010\t\u001A\u0004\u0018\u00010\u0002J\u001A\u0010\f\u001A\u0004\u0018\u00010\u00032\u0006\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0006¨\u0006\u0010"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$TakePicturePreview;", "Landroidx/activity/result/contract/ActivityResultContract;", "Ljava/lang/Void;", "Landroid/graphics/Bitmap;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "activity_release"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    public static class TakePicturePreview extends ActivityResultContract {
        @Override  // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context0, Object object0) {
            return this.createIntent(context0, ((Void)object0));
        }

        public Intent createIntent(Context context0, Void void0) {
            Intrinsics.checkNotNullParameter(context0, "context");
            return new Intent("android.media.action.IMAGE_CAPTURE");
        }

        @Override  // androidx.activity.result.contract.ActivityResultContract
        public SynchronousResult getSynchronousResult(Context context0, Object object0) {
            return this.getSynchronousResult(context0, ((Void)object0));
        }

        public final SynchronousResult getSynchronousResult(Context context0, Void void0) {
            Intrinsics.checkNotNullParameter(context0, "context");
            return null;
        }

        public final Bitmap parseResult(int v, Intent intent0) {
            if(v != -1) {
                intent0 = null;
            }
            return intent0 == null ? null : ((Bitmap)intent0.getParcelableExtra("data"));
        }

        @Override  // androidx.activity.result.contract.ActivityResultContract
        public Object parseResult(int v, Intent intent0) {
            return this.parseResult(v, intent0);
        }
    }

    @Deprecated(message = "The thumbnail bitmap is rarely returned and is not a good signal to determine\n      whether the video was actually successfully captured. Use {@link CaptureVideo} instead.")
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0017\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\u0002H\u0017J \u0010\n\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000B2\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\u0002J\u001A\u0010\f\u001A\u0004\u0018\u00010\u00032\u0006\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0006¨\u0006\u0010"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$TakeVideo;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/net/Uri;", "Landroid/graphics/Bitmap;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "activity_release"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    public static class TakeVideo extends ActivityResultContract {
        public Intent createIntent(Context context0, Uri uri0) {
            Intrinsics.checkNotNullParameter(context0, "context");
            Intrinsics.checkNotNullParameter(uri0, "input");
            Intent intent0 = new Intent("android.media.action.VIDEO_CAPTURE").putExtra("output", uri0);
            Intrinsics.checkNotNullExpressionValue(intent0, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return intent0;
        }

        @Override  // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context0, Object object0) {
            return this.createIntent(context0, ((Uri)object0));
        }

        public final SynchronousResult getSynchronousResult(Context context0, Uri uri0) {
            Intrinsics.checkNotNullParameter(context0, "context");
            Intrinsics.checkNotNullParameter(uri0, "input");
            return null;
        }

        @Override  // androidx.activity.result.contract.ActivityResultContract
        public SynchronousResult getSynchronousResult(Context context0, Object object0) {
            return this.getSynchronousResult(context0, ((Uri)object0));
        }

        public final Bitmap parseResult(int v, Intent intent0) {
            if(v != -1) {
                intent0 = null;
            }
            return intent0 == null ? null : ((Bitmap)intent0.getParcelableExtra("data"));
        }

        @Override  // androidx.activity.result.contract.ActivityResultContract
        public Object parseResult(int v, Intent intent0) {
            return this.parseResult(v, intent0);
        }
    }

}

