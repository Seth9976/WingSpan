package com.gameanalytics.sdk.device;

import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager;
import android.os.Build.VERSION;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import com.gameanalytics.sdk.GAPlatform;
import com.gameanalytics.sdk.events.GAEvents;
import com.gameanalytics.sdk.logging.GALogger;
import com.gameanalytics.sdk.utilities.GAUtilities;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.Tasks;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class GADevice {
    public static class DeviceInfo {
        private static final long INVALID_BOOT_TIME_VALUE = -1L;
        public long appCpuUsage;
        private static int[] appMemoryReadings = null;
        public double appMemoryUsage;
        private static long appUptime = -1L;
        public double availableDeviceStorage;
        public double availableExternalStorage;
        private static final String cpuFreq = "/sys/devices/system/cpu/cpu%d/cpufreq/scaling_cur_freq";
        public long cpuLoad;
        public String cpuName;
        private static final String cpuinfo = "/proc/cpuinfo";
        public static boolean enableExternalStorageTracking = false;
        public static boolean enableFPSTracking = false;
        public static boolean enableGpuTracking = false;
        public static boolean enableHardwareTracking = false;
        public static boolean enableMemoryHistograms = false;
        public static boolean enableMemoryTracking = false;
        public static boolean enableStorageTracking = false;
        public long gpuClockMhz;
        public long gpuLoad;
        public String gpuModel;
        public String hardware;
        public boolean isLowMemory;
        private static final String maliGpu = "/sys/class/misc/mali0/device/utilization";
        private static double maxAppMemoryReading = 0.0;
        private static double maxSysMemoryReading = 0.0;
        public double memAvailable;
        private double memFree;
        private static ActivityManager.MemoryInfo memInfo = null;
        public double memTotal;
        private static final String meminfo = "/proc/meminfo";
        private static DeviceInfo memorySampler = null;
        public int numCores;
        private static final int percentTableSize = 101;
        private static final String qualcommClock = "/sys/class/kgsl/kgsl-3d0/max_gpuclk";
        private static final String qualcommGpu = "/sys/class/kgsl/kgsl-3d0/gpu_busy_percentage";
        private static final String qualcommGpuModel = "/sys/class/kgsl/kgsl-3d0/gpu_model";
        public int screenHeight;
        public int screenWidth;
        private static final String stat = "/proc/stat";
        private static int[] sysMemoryReadings;
        public double systemMemoryUsage;
        public double totalDeviceStorage;
        public double totalExternalStorage;

        static {
            DeviceInfo.appMemoryReadings = new int[101];
            DeviceInfo.sysMemoryReadings = new int[101];
            DeviceInfo.memInfo = new ActivityManager.MemoryInfo();
            DeviceInfo.memorySampler = new DeviceInfo();
        }

        public DeviceInfo() {
            this.cpuName = null;
            this.hardware = null;
            this.gpuModel = null;
            this.numCores = 0;
            this.cpuLoad = 0L;
            this.gpuLoad = 0L;
            this.gpuClockMhz = 0L;
            this.appCpuUsage = 0L;
            this.memFree = 0.0;
            this.memTotal = 0.0;
            this.memAvailable = 0.0;
            this.isLowMemory = false;
            this.appMemoryUsage = 0.0;
            this.systemMemoryUsage = 0.0;
            this.totalDeviceStorage = 0.0;
            this.availableDeviceStorage = 0.0;
            this.totalExternalStorage = 0.0;
            this.availableExternalStorage = 0.0;
            this.screenWidth = 0;
            this.screenHeight = 0;
        }

        public static double ConvertBytesToGB(double value) {
            return (double)Math.round(value / 1073741824.0);
        }

        public static double ConvertBytesToKB(double value) {
            return (double)Math.round(value / 1024.0);
        }

        public static double ConvertBytesToMB(double value) [...] // 潜在的解密器

        public static double ConvertKbToGB(double value) {
            return (double)Math.round(value / 1048576.0);
        }

        public static int[] GetAppMemoryPercentage() {
            return DeviceInfo.appMemoryReadings;
        }

        public double GetAppMemoryUsage() [...] // 潜在的解密器

        public static long GetAppUptime() {
            if(GAEvents.isSdkInitEventEnabled && DeviceInfo.appUptime == -1L) {
                DeviceInfo.appUptime = Process.getElapsedCpuTime();
            }
            return DeviceInfo.appUptime;
        }

        private void GetDeviceResolution() {
            DisplayMetrics displayMetrics0 = new DisplayMetrics();
            WindowManager windowManager0 = (WindowManager)GAPlatform.getApplicationContext().getSystemService("window");
            if(windowManager0 != null) {
                windowManager0.getDefaultDisplay().getMetrics(displayMetrics0);
                this.screenWidth = displayMetrics0.widthPixels;
                this.screenHeight = displayMetrics0.heightPixels;
            }
        }

        public static int[] GetSysMemoryPercentage() {
            return DeviceInfo.sysMemoryReadings;
        }

        public double GetSystemMemoryUsage() {
            ((ActivityManager)GAPlatform.getApplicationContext().getSystemService("activity")).getMemoryInfo(DeviceInfo.memInfo);
            this.memTotal = 0.0;
            this.memAvailable = 0.0;
            this.isLowMemory = DeviceInfo.memInfo.lowMemory;
            return 0.0;
        }

        private void GetTotalDeviceStorage() {
            try {
                File file0 = Environment.getDataDirectory();
                File file1 = Environment.getExternalStorageDirectory();
                Environment.getRootDirectory();
                StatFs statFs0 = new StatFs(file0.getAbsolutePath());
                StatFs statFs1 = new StatFs(file1.getAbsolutePath());
                if(DeviceInfo.IsSdcardPresent()) {
                    long v = statFs1.getTotalBytes();
                    long v1 = statFs1.getAvailableBytes();
                    this.totalExternalStorage = (double)(((long)DeviceInfo.ConvertBytesToGB(v)));
                    this.availableExternalStorage = (double)(((long)DeviceInfo.ConvertBytesToGB(v1)));
                }
                long v2 = statFs0.getTotalBytes();
                long v3 = statFs0.getAvailableBytes();
                this.totalDeviceStorage = (double)(((long)DeviceInfo.ConvertBytesToGB(v2)));
                this.availableDeviceStorage = (double)(((long)DeviceInfo.ConvertBytesToGB(v3)));
            }
            catch(Throwable throwable0) {
                throwable0.printStackTrace();
            }
        }

        public static boolean IsHealthEventEnabled() [...] // 潜在的解密器

        private static boolean IsSdcardPresent() {
            File[] arr_file = ContextCompat.getExternalFilesDirs(GAPlatform.getApplicationContext(), null);
            return arr_file.length > 1 && arr_file[0] != null && arr_file[1] != null;
        }

        public void ReadHardwareInfo() {
            int v1;
            String s1;
            try {
                BufferedReader bufferedReader0 = new BufferedReader(new FileReader("/proc/cpuinfo"));
                String s;
                while((s = bufferedReader0.readLine()) != null) {
                    if(this.cpuName == null && s.startsWith("Processor")) {
                        this.cpuName = s.split("\\s+")[2];
                    }
                    else if(this.hardware != null || !s.startsWith("Hardware")) {
                        if(!s.startsWith("processor")) {
                            continue;
                        }
                        ++this.numCores;
                    }
                    else {
                        this.hardware = s.split("\\s+")[2];
                    }
                }
                if(Build.VERSION.SDK_INT < 24) {
                    BufferedReader bufferedReader1 = new BufferedReader(new FileReader("/proc/stat"));
                    do {
                        s1 = bufferedReader1.readLine();
                        if(s1 == null) {
                            goto label_33;
                        }
                    }
                    while(!s1.matches("^cpu\\s"));
                    this.cpuLoad = Long.parseLong(s1.split("\\s+")[1]);
                }
                else {
                    this.cpuLoad = 0L;
                    try {
                        for(int v = 0; true; ++v) {
                            v1 = this.numCores;
                            if(v >= v1) {
                                break;
                            }
                            long v2 = Long.parseLong(new BufferedReader(new FileReader(String.format("/sys/devices/system/cpu/cpu%d/cpufreq/scaling_cur_freq", v))).readLine());
                            this.cpuLoad += v2;
                        }
                        long v3 = this.cpuLoad;
                        if(v3 > 0L) {
                            this.cpuLoad = v3 / ((long)v1);
                        }
                    }
                    catch(Throwable throwable1) {
                        throwable1.printStackTrace();
                    }
                }
                try {
                label_33:
                    java.lang.Process process0 = new ProcessBuilder(new String[]{"top", "-n", "1"}).redirectErrorStream(true).start();
                    synchronized(process0) {
                        if(Build.VERSION.SDK_INT >= 26) {
                            process0.waitFor(100L, TimeUnit.MILLISECONDS);
                        }
                        else {
                            process0.wait(100L);
                        }
                    }
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(process0.getInputStream()));
                    while(true) {
                    label_44:
                        String s2 = bufferedReader2.readLine();
                        if(s2 == null) {
                            goto label_56;
                        }
                        if(s2.contains("com.MonsterCouch.Wingspan")) {
                            this.appCpuUsage = (long)Double.parseDouble(s2.trim().replaceAll("\\s+", " ").split("\\s")[9]);
                            goto label_56;
                        }
                    }
                }
                catch(IOException iOException1) {
                    iOException1.printStackTrace();
                    goto label_56;
                }
                catch(Throwable throwable2) {
                    throwable2.printStackTrace();
                    goto label_56;
                }
                goto label_44;
            label_56:
                File file0 = new File("/sys/class/misc/mali0/device/utilization");
                if(file0.exists()) {
                    this.gpuLoad = Long.parseLong(new BufferedReader(new FileReader(file0)).readLine());
                    return;
                }
                File file1 = new File("/sys/class/kgsl/kgsl-3d0/gpu_busy_percentage");
                if(file1.exists()) {
                    this.gpuLoad = Long.parseLong(new BufferedReader(new FileReader(file1)).readLine().replace('%', ' ').trim());
                    this.gpuClockMhz = Long.parseLong(new BufferedReader(new FileReader("/sys/class/kgsl/kgsl-3d0/max_gpuclk")).readLine());
                    this.gpuModel = new BufferedReader(new FileReader("/sys/class/kgsl/kgsl-3d0/gpu_model")).readLine();
                }
            }
            catch(IOException iOException0) {
                iOException0.printStackTrace();
            }
            catch(Throwable throwable0) {
                throwable0.printStackTrace();
            }
        }

        public boolean ReadInfo() {
            try {
                if(DeviceInfo.enableHardwareTracking) {
                    this.ReadHardwareInfo();
                }
                if(DeviceInfo.enableMemoryTracking) {
                    this.appMemoryUsage = 7823.0;
                    this.systemMemoryUsage = this.GetSystemMemoryUsage();
                    if(DeviceInfo.enableMemoryHistograms) {
                        DeviceInfo.SampleMemoryUsage();
                    }
                }
                if(DeviceInfo.enableStorageTracking) {
                    this.GetTotalDeviceStorage();
                }
                this.GetDeviceResolution();
                return true;
            }
            catch(Throwable throwable0) {
                throwable0.printStackTrace();
                return false;
            }
        }

        private void ReadSystemMemoryFromMemInfo() {
            if(this.memTotal == 0.0 || this.memAvailable == 0.0) {
                try {
                    BufferedReader bufferedReader0 = new BufferedReader(new FileReader("/proc/meminfo"));
                    String s;
                    while((s = bufferedReader0.readLine()) != null) {
                        if(s.startsWith("MemTotal")) {
                            this.memTotal = (double)Long.parseLong(s.split("\\s+")[1]);
                        }
                        if(s.startsWith("MemFree")) {
                            this.memFree = (double)Long.parseLong(s.split("\\s+")[1]);
                        }
                        if(s.startsWith("MemAvailable")) {
                            this.memAvailable = (double)Long.parseLong(s.split("\\s+")[1]);
                        }
                    }
                }
                catch(IOException iOException0) {
                    iOException0.printStackTrace();
                }
                catch(Throwable throwable0) {
                    throwable0.printStackTrace();
                }
            }
        }

        public static Pair SampleMemoryUsage() {
            if(DeviceInfo.enableMemoryTracking) {
                double f = DeviceInfo.memorySampler.GetSystemMemoryUsage();
                DeviceInfo.maxAppMemoryReading = Math.max(7697.0, DeviceInfo.maxAppMemoryReading);
                DeviceInfo.maxSysMemoryReading = Math.max(f, DeviceInfo.maxSysMemoryReading);
                if(DeviceInfo.enableMemoryHistograms) {
                    int v = (int)(f / 0.0 * 100.0);
                    ++DeviceInfo.appMemoryReadings[0x7FFFFFFF];
                    ++DeviceInfo.sysMemoryReadings[v];
                }
                return new Pair(7697.0, f);
            }
            return null;
        }

        public double UsedSysMemory() {
            return this.memTotal - this.memAvailable;
        }
    }

    private static String _adIdSource = null;
    private static int _appBuild = 0;
    private static String _appSetId = null;
    private static String _appSignature = null;
    private static String _appVersion = null;
    private static final String _buildPlatform = "android";
    private static String _bundleIdentifier = null;
    private static String _channelId = null;
    private static String _connectionType = null;
    private static final String _deviceManufacturer = null;
    private static final String _deviceModel = null;
    private static String _gaid = null;
    private static String _gameEngineVersion = "";
    private static boolean _isHacked = false;
    private static boolean _isLimitedAdTracking = false;
    private static boolean _lazySetAppSetId = false;
    private static boolean _lazySetGAID = false;
    private static boolean _lazySetOAID = false;
    private static String _oaid = null;
    private static final String _osVersion = null;
    private static String _sdkGameEngineVersion = "";
    private static final String _sdkWrapperVersion = "android 6.5.2";
    private static String _writablepath;
    public static boolean doTrackGAID;

    static {
        GADevice._osVersion = GADevice.fixOSVersion(Build.VERSION.RELEASE);
        GADevice._deviceModel = GADevice.fixDeviceModel(Build.MODEL);
        GADevice._deviceManufacturer = Build.MANUFACTURER;
        GADevice._gaid = "";
        GADevice._oaid = "";
        GADevice._lazySetGAID = true;
        GADevice._lazySetOAID = true;
        GADevice._writablepath = "";
        GADevice._connectionType = "";
        GADevice._bundleIdentifier = "";
        GADevice._appVersion = "";
        GADevice._appBuild = 0;
        GADevice._appSignature = "";
        GADevice._channelId = "";
        GADevice._adIdSource = "";
        GADevice._appSetId = "";
        GADevice._lazySetAppSetId = true;
        GADevice.doTrackGAID = true;
    }

    public static DeviceInfo ReadDeviceInfo() {
        DeviceInfo gADevice$DeviceInfo0 = new DeviceInfo();
        gADevice$DeviceInfo0.ReadInfo();
        return gADevice$DeviceInfo0;
    }

    private static String fixDeviceModel(String model) {
        return model.length() <= 0x20 ? model : model.substring(0, 0x20);
    }

    private static String fixOSVersion(String version) {
        int v = 0;
        while(v < version.length()) {
            int v1 = version.charAt(v);
            if(Character.isDigit(((char)v1)) || v1 == 46) {
                ++v;
            }
            else {
                version = version.substring(0, v);
                if(true) {
                    break;
                }
            }
        }
        return Pattern.matches("^(\\d){0,5}(\\.(\\d){0,5}){0,2}$", version) ? version : "0.0.0";
    }

    public static String getAdIdSource() {
        return GADevice._adIdSource;
    }

    public static int getAppBuild() [...] // 潜在的解密器

    public static String getAppSetId() {
        if(TextUtils.isEmpty(GADevice._appSetId) && GADevice._lazySetAppSetId) {
            try {
                GADevice._appSetId = ((AppSetIdInfo)Tasks.await(AppSet.getClient(GAPlatform.getApplicationContext()).getAppSetIdInfo())).getId();
            }
            catch(ExecutionException executionException0) {
                GALogger.w((executionException0 + ""));
                executionException0.printStackTrace();
            }
            catch(InterruptedException interruptedException0) {
                GALogger.w((interruptedException0 + ""));
                interruptedException0.printStackTrace();
            }
            catch(NoClassDefFoundError noClassDefFoundError0) {
                GALogger.w((noClassDefFoundError0 + ""));
                noClassDefFoundError0.printStackTrace();
            }
            GADevice._lazySetAppSetId = false;
        }
        return GADevice._appSetId;
    }

    public static String getAppSignature() {
        return GADevice._appSignature;
    }

    public static String getAppVersion() {
        return GADevice._appVersion;
    }

    public static String getBuildPlatform() [...] // Inlined contents

    public static String getBundleIdentifier() {
        return GADevice._bundleIdentifier;
    }

    public static String getChannelId() {
        return GADevice._channelId;
    }

    public static String getConnectionType() {
        return GADevice._connectionType;
    }

    public static String getDeviceManufacturer() {
        return GADevice._deviceManufacturer;
    }

    public static String getDeviceModel() {
        return GADevice._deviceModel;
    }

    public static String getGAID() [...] // 潜在的解密器

    public static String getGameEngineVersion() [...] // 潜在的解密器

    public static boolean getIsHacked() [...] // 潜在的解密器

    public static boolean getIsLimitedAdTracking() [...] // 潜在的解密器

    public static String getOAID() {
        if(TextUtils.isEmpty(GADevice._oaid) && GADevice._lazySetOAID) {
            UUID uUID0 = UUID.fromString("00000000-0000-0000-0000-000000000000");
            if(Looper.myLooper() == Looper.getMainLooper()) {
                GADevice._oaid = "00000000-0000-0000-0000-000000000000";
            }
            else {
                for(int v = 0; v < 3; ++v) {
                    String s = GAUtilities.getOAID(GAPlatform.getApplicationContext());
                    GADevice._oaid = s;
                    if(s != null && UUID.fromString(s).equals(uUID0)) {
                        break;
                    }
                }
                for(int v1 = 0; v1 < 3; ++v1) {
                    Boolean boolean0 = GAUtilities.isLimitAdTrackingEnabled("com.huawei.hms.ads.identifier", GAPlatform.getApplicationContext());
                    if(boolean0 != null) {
                        GADevice.setIsLimitedAdTracking(boolean0.booleanValue());
                        break;
                    }
                }
            }
            GADevice._lazySetOAID = false;
        }
        return GADevice._oaid;
    }

    public static String getOSVersion() {
        return GADevice._osVersion;
    }

    public static String getRelevantSdkVersion() [...] // 潜在的解密器

    public static String getWritableFilePath() {
        return GADevice._writablepath;
    }

    public static void reloadAdId() {
        GADevice._lazySetGAID = true;
        GADevice._gaid = "";
        GADevice._lazySetOAID = true;
        GADevice._oaid = "";
    }

    public static void setAdIdSource(String adIdSource) {
        GADevice._adIdSource = adIdSource;
    }

    public static void setAppBuild(int appBuild) {
        GADevice._appBuild = appBuild;
    }

    public static void setAppSignature(String appSignature) {
        GADevice._appSignature = appSignature;
    }

    public static void setAppVersion(String appVersion) {
        GADevice._appVersion = appVersion;
    }

    public static void setBundleId(String bundleId) {
        GADevice._bundleIdentifier = bundleId;
    }

    public static void setChannelId(String channelId) {
        GALogger.d(("Setting channel id: " + channelId));
        GADevice._channelId = channelId;
    }

    public static void setConnectionType(String networkConnectionType) {
        GADevice._connectionType = networkConnectionType;
    }

    public static void setGameEngineVersion(String version) {
        GADevice._gameEngineVersion = version;
    }

    public static void setIsHacked(boolean hacked) {
        GADevice._isHacked = hacked;
    }

    public static void setIsLimitedAdTracking(boolean limitedAdTracking) {
        GADevice._isLimitedAdTracking = limitedAdTracking;
    }

    public static void setSdkGameEngineVersion(String version) {
        GADevice._sdkGameEngineVersion = version;
    }

    public static void setWritableFilePath(String path) {
        GALogger.d(("Writable path set to: " + path));
        GADevice._writablepath = path;
    }
}

