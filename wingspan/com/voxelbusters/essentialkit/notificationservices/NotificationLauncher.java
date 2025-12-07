package com.voxelbusters.essentialkit.notificationservices;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.voxelbusters.essentialkit.notificationservices.datatypes.Notification;
import com.voxelbusters.essentialkit.utilities.ApplicationUtil;
import com.voxelbusters.essentialkit.utilities.Logger;
import org.json.JSONObject;

public class NotificationLauncher extends Activity {
    private static String TAG = "[Native Plugins : Notification Launcher";
    public static Boolean isRemoteNotification;
    public static JSONObject launchNotificationData;
    public Notification notification;

    public NotificationLauncher() {
        this.notification = null;
    }

    public void launchMainActivity(Intent intent0) {
        Class class0 = ApplicationUtil.getMainLauncherActivity(this);
        Logger.debug(("Main Launcher Class : " + class0));
        Intent intent1 = new Intent(this, class0);
        intent1.addFlags(0x20000000);
        this.startActivity(intent1);
    }

    @Override  // android.app.Activity
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        Intent intent0 = this.getIntent();
        String s = intent0.getStringExtra("notification-payload");
        try {
            Log.d("[Voxel Busters : Essential Kit]", "Payload string : " + s);
            Notification notification0 = Notification.fromJson(this, new JSONObject(s));
            this.notification = notification0;
            notification0.isLaunchNotification = true;
            Log.d("[Voxel Busters : Essential Kit]", "Launch notification : " + this.notification);
            NotificationStore.deleteActiveNotification(this, this.notification.getPersistenceId());
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
        }
        this.launchMainActivity(intent0);
        this.sendLaunchNotificationInfo();
        this.finish();
    }

    public void sendLaunchNotificationInfo() {
        Notification notification0 = this.notification;
        if(notification0 != null) {
            NotificationServices.processLaunchNotification(notification0);
        }
    }
}

