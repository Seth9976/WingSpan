package com.voxelbusters.essentialkit.notificationservices;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import androidx.core.app.NotificationCompat.BigPictureStyle;
import androidx.core.app.NotificationCompat.Builder;
import androidx.core.app.NotificationManagerCompat;
import com.voxelbusters.essentialkit.notificationservices.datatypes.Notification;
import com.voxelbusters.essentialkit.notificationservices.datatypes.NotificationImportance;
import com.voxelbusters.essentialkit.notificationservices.datatypes.NotificationSettings;
import com.voxelbusters.essentialkit.utilities.ApplicationUtil;
import com.voxelbusters.essentialkit.utilities.Logger;
import com.voxelbusters.essentialkit.utilities.ResourcesUtil;
import com.voxelbusters.essentialkit.utilities.StringUtil;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.concurrent.Executors;

public class NotificationDispatcher {
    public static final class c {
        public static final int[] a;

        static {
            int[] arr_v = new int[NotificationImportance.values().length];
            c.a = arr_v;
            try {
                arr_v[NotificationImportance.Min.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                c.a[NotificationImportance.Low.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                c.a[NotificationImportance.High.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                c.a[NotificationImportance.Max.ordinal()] = 4;
            }
            catch(NoSuchFieldError unused_ex) {
            }
        }
    }

    private Context context;
    private Notification notification;

    public NotificationDispatcher(Context context0, Notification notification0) {
        this.context = context0;
        this.notification = notification0;
    }

    public void dispatch() {
        public final class a implements Runnable {
            public final Handler a;
            public final NotificationDispatcher b;

            public a(Handler handler0) {
                this.a = handler0;
                super();
            }

            @Override
            public final void run() {
                public final class com.voxelbusters.essentialkit.notificationservices.NotificationDispatcher.a.a implements Runnable {
                    public final Bitmap a;
                    public final Bitmap b;
                    public final a c;

                    public com.voxelbusters.essentialkit.notificationservices.NotificationDispatcher.a.a(Bitmap bitmap0, Bitmap bitmap1) {
                        this.a = bitmap0;
                        this.b = bitmap1;
                        super();
                    }

                    @Override
                    public final void run() {
                        NotificationDispatcher.this.sendNotification(this.a, this.b);
                    }
                }

                Context context0 = NotificationDispatcher.this.context;
                Notification notification0 = NotificationDispatcher.this.notification;
                Bitmap bitmap0 = NotificationDispatcher.this.loadBitmap(context0, notification0.largeIcon);
                Context context1 = NotificationDispatcher.this.context;
                Notification notification1 = NotificationDispatcher.this.notification;
                com.voxelbusters.essentialkit.notificationservices.NotificationDispatcher.a.a notificationDispatcher$a$a0 = new com.voxelbusters.essentialkit.notificationservices.NotificationDispatcher.a.a(this, bitmap0, NotificationDispatcher.this.loadBitmap(context1, notification1.bigPicture));
                this.a.post(notificationDispatcher$a$a0);
            }
        }

        if(!this.notification.process) {
            return;
        }
        Executors.newSingleThreadExecutor().execute(new a(this, new Handler(Looper.getMainLooper())));
    }

    // 去混淆评级： 低(40)
    private String getNewChannelId(Context context0) {
        return "com.monstercouch.wingspan-general-channel";
    }

    private static Object getNotificationChannel(Context context0, String s) {
        List list0 = NotificationDispatcher.getNotificationManager(context0).getNotificationChannels();
        if(list0 != null) {
            for(int v = 0; v < list0.size(); ++v) {
                NotificationChannel notificationChannel0 = (NotificationChannel)list0.get(v);
                if(notificationChannel0.getName().equals(s)) {
                    return notificationChannel0;
                }
            }
        }
        return null;
    }

    private static NotificationManager getNotificationManager(Context context0) {
        return (NotificationManager)context0.getSystemService("notification");
    }

    private String getOldChannelId() {
        return "com.MonsterCouch.Wingspan";
    }

    private int getPriority(NotificationImportance notificationImportance0) {
        switch(c.a[notificationImportance0.ordinal()]) {
            case 1: 
            case 2: {
                return 1;
            }
            case 4: {
                return 5;
            }
            default: {
                return 4;
            }
        }
    }

    private int getSmallIcon(NotificationSettings notificationSettings0) {
        if(notificationSettings0.isCustomIconAllowed()) {
            return ResourcesUtil.getDrawableResourceId(this.context, "app_icon_custom_white");
        }
        int v = this.context.getApplicationInfo().icon;
        return v == 0 ? ResourcesUtil.getColorResourceId(this.context, "ESSENTIAL_KIT_COLOR_BLACK") : v;
    }

    private boolean isMinimumLollipopVersion() [...] // Inlined contents

    private Bitmap loadBitmap(Context context0, String s) {
        Bitmap bitmap0 = null;
        if(!StringUtil.isNullOrEmpty(s)) {
            try {
                if(s.startsWith("http")) {
                    return BitmapFactory.decodeStream(new URL(s).openStream());
                }
                InputStream inputStream0 = ResourcesUtil.getStreamFromAssets(context0, s);
                bitmap0 = BitmapFactory.decodeStream(inputStream0);
                inputStream0.close();
            }
            catch(IOException iOException0) {
                Logger.error(String.format("%s not found", s));
                iOException0.printStackTrace();
            }
            return bitmap0;
        }
        return null;
    }

    private void playCustomNotificationSound(Context context0, String s, String s1) {
        public final class b implements MediaPlayer.OnCompletionListener {
            public b() {
                super();
            }

            @Override  // android.media.MediaPlayer$OnCompletionListener
            public final void onCompletion(MediaPlayer mediaPlayer0) {
                mediaPlayer0.release();
            }
        }

        if(Build.VERSION.SDK_INT >= 26) {
            Logger.warning("Returning as notification channel will handle playing this sound for devices >= oreo");
            return;
        }
        if(!StringUtil.isNullOrEmpty(s)) {
            try {
                AssetFileDescriptor assetFileDescriptor0 = context0.getAssets().openFd(s);
                MediaPlayer mediaPlayer0 = new MediaPlayer();
                mediaPlayer0.setDataSource(assetFileDescriptor0.getFileDescriptor(), assetFileDescriptor0.getStartOffset(), assetFileDescriptor0.getLength());
                mediaPlayer0.setAudioStreamType(5);
                mediaPlayer0.prepare();
                mediaPlayer0.start();
                mediaPlayer0.setOnCompletionListener(new b());
                assetFileDescriptor0.close();
            }
            catch(Exception exception0) {
                Logger.debug(("Expecting " + s + " in Assets/StreamingAssets"));
                exception0.printStackTrace();
            }
        }
    }

    private void sendNotification(Bitmap bitmap0, Bitmap bitmap1) {
        Builder notificationCompat$Builder0;
        NotificationManager notificationManager0 = NotificationDispatcher.getNotificationManager(this.context);
        String s = this.getOldChannelId();
        String s1 = this.getNewChannelId(this.context);
        Logger.debug(("Dispatching notification : " + this.notification));
        NotificationSettings notificationSettings0 = NotificationStore.getSettings(this.context);
        int v = Build.VERSION.SDK_INT;
        android.app.Notification notification0 = null;
        if(v >= 26) {
            if(((NotificationChannel)NotificationDispatcher.getNotificationChannel(this.context, s)) != null) {
                notificationManager0.deleteNotificationChannel(s);
            }
            NotificationChannel notificationChannel0 = new NotificationChannel(s1, "General", this.getPriority(this.notification.priority));
            notificationChannel0.enableVibration(notificationSettings0.isVibrationAllowed());
            notificationChannel0.setShowBadge(false);
            notificationChannel0.setSound(null, null);
            notificationManager0.createNotificationChannel(notificationChannel0);
        }
        ApplicationUtil.getApplicationName(this.context);
        int v1 = ApplicationUtil.getAppState(this.context);
        boolean z = notificationSettings0.isNotificationDisplayAllowedInForeground();
        NotificationManagerCompat.from(this.context).areNotificationsEnabled();
        switch(v1) {
            case 1: {
                if(z) {
                    goto label_22;
                }
                break;
            }
            case 2: 
            case 3: {
            label_22:
                Intent intent0 = new Intent(this.context, NotificationLauncher.class);
                intent0.setPackage("com.MonsterCouch.Wingspan");
                intent0.setFlags(0x24000000);
                intent0.putExtra("notification-payload", Notification.toJson(this.context, this.notification).toString());
                PendingIntent pendingIntent0 = PendingIntent.getActivity(this.context.getApplicationContext(), ((int)System.currentTimeMillis()), intent0, (v <= 30 ? 0x48000000 : 0x4C000000));
                try {
                    notificationCompat$Builder0 = new Builder(this.context, s1);
                }
                catch(Throwable throwable0) {
                    Builder notificationCompat$Builder1 = new Builder(this.context, null);
                    if(Build.VERSION.SDK_INT >= 26) {
                        Logger.error(("Make sure you are compiling with minimum 26.0.1 support libraries." + throwable0));
                    }
                    notificationCompat$Builder0 = notificationCompat$Builder1;
                }
                notificationCompat$Builder0.setDefaults((notificationSettings0.isVibrationAllowed() ? 6 : 4));
                notificationCompat$Builder0.setSmallIcon(this.getSmallIcon(notificationSettings0));
                notificationCompat$Builder0.setColor(Color.parseColor(ResourcesUtil.getString(this.context, "NOTIFICATION_SERVICES_ACCENT_COLOR")));
                if(bitmap0 != null) {
                    notificationCompat$Builder0.setLargeIcon(bitmap0);
                }
                notificationCompat$Builder0.setWhen(System.currentTimeMillis());
                notificationCompat$Builder0.setAutoCancel(true);
                notificationCompat$Builder0.setContentIntent(pendingIntent0);
                if(bitmap1 != null) {
                    notificationCompat$Builder0.setStyle(new BigPictureStyle().bigPicture(bitmap1));
                }
                if(!StringUtil.isNullOrEmpty(this.notification.contentTitle) || !StringUtil.isNullOrEmpty(this.notification.contentText)) {
                    Logger.error("Alerts off. Notification type set doesn\'t have Alert type to display a notification");
                }
                else {
                    Logger.warning("No data for content text to show in notification bar!");
                    if(ApplicationUtil.isDebugBuild(this.context)) {
                        notificationCompat$Builder0.setContentText("No Message!!!");
                        notification0 = notificationCompat$Builder0.build();
                    }
                }
                if(notification0 != null) {
                    String s2 = this.notification.tag;
                    notificationManager0.notify(s2, (StringUtil.isNullOrEmpty(s2) ? this.notification.persistenceId : 0x6F), notification0);
                    NotificationStore.saveActiveNotification(this.context, this.notification);
                }
            }
        }
        if(v1 == 1) {
            INotificationReceivedListener iNotificationServices$INotificationReceivedListener0 = NotificationServices.listener;
            if(iNotificationServices$INotificationReceivedListener0 != null) {
                iNotificationServices$INotificationReceivedListener0.onNotificationReceived(this.notification);
            }
        }
    }
}

