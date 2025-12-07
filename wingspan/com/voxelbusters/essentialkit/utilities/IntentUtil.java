package com.voxelbusters.essentialkit.utilities;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class IntentUtil {
    public static Intent buildIntent(String s, Uri uri0, String s1, List list0) {
        String s3;
        Intent intent0 = new Intent(s);
        if(list0 == null || list0.size() <= 0) {
            s3 = "text/plain";
        }
        else {
            ArrayList arrayList0 = new ArrayList();
            ArrayList arrayList1 = new ArrayList();
            for(Object object0: list0) {
                arrayList0.add(((FileAttachment)object0).uri);
                arrayList1.add(((FileAttachment)object0).mimeType);
            }
            if(arrayList0.size() > 1) {
                intent0.setAction("android.intent.action.SEND_MULTIPLE");
                intent0.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList0);
            }
            else {
                intent0.putExtra("android.intent.extra.STREAM", ((Parcelable)arrayList0.get(0)));
            }
            boolean z = false;
            boolean z1 = false;
            boolean z2 = false;
            for(Object object1: arrayList1) {
                String s2 = (String)object1;
                if(s2.startsWith("image/")) {
                    z = true;
                }
                else if(s2.startsWith("video/")) {
                    z1 = true;
                }
                else {
                    z2 = true;
                }
            }
            if(z && z1 || z2) {
                s3 = "*/*";
            }
            else if(!z) {
                s3 = "video/*";
            }
            else if(arrayList1.size() == 1) {
                s3 = (String)arrayList1.get(0);
            }
            else {
                s3 = "image/*";
            }
        }
        intent0.setDataAndType(uri0, s3);
        intent0.setPackage(s1);
        intent0.addFlags(1);
        return intent0;
    }

    public static Intent getAlternativeGalleryIntent(String s) {
        Intent intent0 = new Intent("android.intent.action.PICK");
        intent0.setType(s);
        return intent0;
    }

    public static Intent getCameraIntent(Context context0, Uri uri0) {
        Intent intent0 = new Intent("android.media.action.IMAGE_CAPTURE");
        for(Object object0: context0.getPackageManager().queryIntentActivities(intent0, 0x20000)) {
            context0.grantUriPermission(((ResolveInfo)object0).activityInfo.packageName, uri0, 3);
        }
        context0.grantUriPermission("com.MonsterCouch.Wingspan", uri0, 3);
        intent0.putExtra("output", uri0);
        return intent0;
    }

    public static Intent getGalleryIntent(String s) {
        Intent intent0 = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent0.addCategory("android.intent.category.OPENABLE");
        intent0.setType(s);
        return intent0;
    }

    public static Intent getSelectiveIntentChooser(Context context0, Intent intent0, Intent intent1) {
        List list0 = context0.getPackageManager().queryIntentActivities(intent0, 0x10000);
        Intent intent2 = null;
        if(!list0.isEmpty()) {
            ArrayList arrayList0 = new ArrayList();
            for(Object object0: list0) {
                ActivityInfo activityInfo0 = ((ResolveInfo)object0).activityInfo;
                String s = activityInfo0 == null ? null : activityInfo0.packageName;
                Intent intent3 = new Intent(intent1);
                intent3.setComponent(new ComponentName(s, ((ResolveInfo)object0).activityInfo.name));
                intent3.setPackage(s);
                arrayList0.add(intent3);
            }
            if(!arrayList0.isEmpty()) {
                intent2 = Intent.createChooser(((Intent)arrayList0.remove(0)), "");
                intent2.putExtra("android.intent.extra.INITIAL_INTENTS", ((Parcelable[])arrayList0.toArray(new Parcelable[0])));
                intent2.addFlags(1);
            }
        }
        return intent2 == null ? intent1 : intent2;
    }
}

