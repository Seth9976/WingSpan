package net.codestage.actk.androidnative;

import android.content.pm.PackageManager.NameNotFoundException;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.unity3d.player.UnityPlayerActivity;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class CodeHashGenerator {
    static class CodeHashCalculator extends AsyncTask {
        private CodeHashCalculator() {
        }

        CodeHashCalculator(net.codestage.actk.androidnative.CodeHashGenerator.1 codeHashGenerator$10) {
        }

        @Override  // android.os.AsyncTask
        protected Object doInBackground(Object[] arr_object) {
            return this.doInBackground(((String[][])arr_object));
        }

        protected HashCalculationResult doInBackground(String[][] arr2_s) {
            try {
                return CodeHashGenerator.GetCodeHashThread(CodeHashGenerator.GetFiltersFromStrings(arr2_s[0]));
            }
            catch(Throwable throwable0) {
                HashCalculationResult codeHashGenerator$HashCalculationResult0 = new HashCalculationResult(null);
                codeHashGenerator$HashCalculationResult0.errorText = ACTkErrors.GetText((UnityPlayerActivity.adjustValue("3D1F00041A090E0B154E07080F1A4110171D00174D1606080B00521A021408000647111D4E180C1206410410001C1503154E20372E484E") + throwable0.toString()));
                Log.e("ACTk", codeHashGenerator$HashCalculationResult0.errorText, throwable0);
                return codeHashGenerator$HashCalculationResult0;
            }
        }

        @Override  // android.os.AsyncTask
        protected void onPostExecute(Object object0) {
            this.onPostExecute(((HashCalculationResult)object0));
        }

        protected void onPostExecute(HashCalculationResult codeHashGenerator$HashCalculationResult0) {
            if(codeHashGenerator$HashCalculationResult0.errorText != null) {
                CodeHashGenerator.lastCallback.OnError(codeHashGenerator$HashCalculationResult0.errorText);
                return;
            }
            CodeHashGenerator.lastCallback.OnSuccess(codeHashGenerator$HashCalculationResult0.buildPath, codeHashGenerator$HashCalculationResult0.paths, codeHashGenerator$HashCalculationResult0.hashes, codeHashGenerator$HashCalculationResult0.summaryHash);
        }
    }

    static class HashCalculationResult {
        String buildPath;
        String errorText;
        String[] hashes;
        String[] paths;
        String summaryHash;

        private HashCalculationResult() {
        }

        HashCalculationResult(net.codestage.actk.androidnative.CodeHashGenerator.1 codeHashGenerator$10) {
        }
    }

    private static CodeHashCallback lastCallback;

    private static String GetArrayHash(MessageDigest messageDigest0, List list0) {
        Collections.sort(list0);
        messageDigest0.update(TextUtils.join(UnityPlayerActivity.adjustValue(""), list0).getBytes());
        return NativeUtils.BytesToHex(messageDigest0.digest());
    }

    public static void GetCodeHash(String[] arr_s, CodeHashCallback codeHashCallback0) {
        CodeHashGenerator.lastCallback = codeHashCallback0;
        new CodeHashCalculator(null).execute(new String[][]{arr_s});
    }

    private static HashCalculationResult GetCodeHashThread(FileFilter[] arr_fileFilter) throws ClassNotFoundException, PackageManager.NameNotFoundException, NoSuchFieldException, IllegalAccessException, IOException, NoSuchAlgorithmException {
        HashCalculationResult codeHashGenerator$HashCalculationResult0 = new HashCalculationResult(null);
        String s = NativeUtils.GetApkPath();
        if(s == null) {
            codeHashGenerator$HashCalculationResult0.errorText = UnityPlayerActivity.adjustValue("353302050B2906161A291503041C00130A004E353F3321333A45310F1E4A154E060211522F2026411E00130D53");
            Log.e("ACTk", codeHashGenerator$HashCalculationResult0.errorText);
            return codeHashGenerator$HashCalculationResult0;
        }
        ArrayList arrayList0 = new ArrayList();
        File file0 = new File(s);
        if(!file0.exists()) {
            codeHashGenerator$HashCalculationResult0.errorText = ACTkErrors.GetText((UnityPlayerActivity.adjustValue("353302050B2906161A291503041C00130A004E353F3321333A45310F1E4A154E021500131A154D07070D02451401024D203E2A4715131A185741") + s));
            Log.e("ACTk", codeHashGenerator$HashCalculationResult0.errorText);
            return codeHashGenerator$HashCalculationResult0;
        }
        File file1 = file0.getParentFile();
        if(file1 == null) {
            Log.w("ACTk", UnityPlayerActivity.adjustValue("353302050B2906161A291503041C00130A004E353F3321333A45310F1E4A154E070E0B164E000C130B0F134514011C09041C410803522F20264108080B00520F044D110F150F5F52"));
            arrayList0.add(s);
        }
        else {
            File[] arr_file = file1.listFiles();
            if(arr_file == null || arr_file.length == 0) {
                Log.w("ACTk", UnityPlayerActivity.adjustValue("353302050B2906161A291503041C00130A004E353F3321333A45310F1E4A154E060211520F1E144108080B00014E1903412F312C4514011C09041C410611521E1119095441"));
                arrayList0.add(s);
            }
            else {
                for(int v = 0; v < arr_file.length; ++v) {
                    String s1 = arr_file[v].getPath();
                    if(s1.equals(UnityPlayerActivity.adjustValue(""))) {
                        Log.w("ACTk", UnityPlayerActivity.adjustValue("353302050B2906161A291503041C00130A004E353F3321333A45310F1E4A154E060211521E1119094E07081752081901044E080945333E3B4D07010D0300004F"));
                    }
                    else if(s1.toLowerCase().endsWith(UnityPlayerActivity.adjustValue("40111D0A"))) {
                        arrayList0.add(s1);
                    }
                }
            }
        }
        codeHashGenerator$HashCalculationResult0.buildPath = s;
        MessageDigest messageDigest0 = MessageDigest.getInstance(UnityPlayerActivity.adjustValue("3D382C4C5F"));
        if(messageDigest0 == null) {
            codeHashGenerator$HashCalculationResult0.errorText = ACTkErrors.GetText(UnityPlayerActivity.adjustValue("353302050B2906161A291503041C00130A004E353F3321333A45310F1E4A154E060211523D382C4C5F41030C150B031941070F14111300130840"));
            Log.e("ACTk", codeHashGenerator$HashCalculationResult0.errorText);
            return codeHashGenerator$HashCalculationResult0;
        }
        ArrayList arrayList1 = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for(Object object0: arrayList0) {
            String s2 = (String)object0;
            JarFile jarFile0 = CodeHashGenerator.GetJarFromApk(s2);
            if(jarFile0 == null) {
                codeHashGenerator$HashCalculationResult0.errorText = ACTkErrors.GetText((UnityPlayerActivity.adjustValue("353302050B2906161A291503041C00130A004E353F3321333A45310F1E4A154E130204164E313D2A4E160E111A4E000C15065B47") + s2));
                Log.e("ACTk", codeHashGenerator$HashCalculationResult0.errorText);
                return codeHashGenerator$HashCalculationResult0;
            }
            CodeHashGenerator.HashFiles(messageDigest0, jarFile0, arr_fileFilter, arrayList1, arrayList2);
        }
        if(arrayList2.size() == 0) {
            codeHashGenerator$HashCalculationResult0.errorText = ACTkErrors.GetText(UnityPlayerActivity.adjustValue("353302050B2906161A291503041C00130A004E353F3321333A453C01040508000647111D4E180C120640"));
            Log.e("ACTk", codeHashGenerator$HashCalculationResult0.errorText);
            return codeHashGenerator$HashCalculationResult0;
        }
        codeHashGenerator$HashCalculationResult0.buildPath = s;
        codeHashGenerator$HashCalculationResult0.hashes = (String[])arrayList2.toArray(new String[0]);
        codeHashGenerator$HashCalculationResult0.paths = (String[])arrayList1.toArray(new String[0]);
        codeHashGenerator$HashCalculationResult0.summaryHash = CodeHashGenerator.GetArrayHash(messageDigest0, arrayList2);
        return codeHashGenerator$HashCalculationResult0;
    }

    private static FileFilter[] GetFiltersFromStrings(String[] arr_s) {
        FileFilter[] arr_fileFilter = new FileFilter[arr_s.length];
        for(int v = 0; v < arr_s.length; ++v) {
            arr_fileFilter[v] = new FileFilter(arr_s[v]);
        }
        return arr_fileFilter;
    }

    // 去混淆评级： 低(20)
    private static JarFile GetJarFromApk(String s) throws IOException {
        return new File(s).exists() ? new JarFile(s) : null;
    }

    private static void HashFiles(MessageDigest messageDigest0, JarFile jarFile0, FileFilter[] arr_fileFilter, List list0, List list1) throws IOException {
        byte[] arr_b = new byte[0x2000];
        Enumeration enumeration0 = jarFile0.entries();
        if(enumeration0 == null) {
            Log.e("ACTk", UnityPlayerActivity.adjustValue("353302050B2906161A291503041C00130A004E353F3321333A453C01040508000647031D1B1E0941070F472422255027203C40"));
            return;
        }
        for(Object object0: Collections.list(enumeration0)) {
            JarEntry jarEntry0 = (JarEntry)object0;
            if(jarEntry0 == null) {
                Log.w("ACTk", UnityPlayerActivity.adjustValue("353302050B2906161A291503041C00130A004E353F3321333A4521011D0841242035451700041F184E0814451C1B1C0140"));
            }
            else {
                String s = jarEntry0.getName();
                if(s == null) {
                    Log.w("ACTk", UnityPlayerActivity.adjustValue("353302050B2906161A291503041C00130A004E353F3321333A4521011D0841242035451700041F184E090616520005010D4E1106111A4F"));
                }
                else {
                    int v = 0;
                    while(true) {
                        boolean z = false;
                        if(v < arr_fileFilter.length) {
                            if(arr_fileFilter[v].MatchPath(s)) {
                                z = true;
                            }
                            else {
                                ++v;
                                continue;
                            }
                        }
                        break;
                    }
                    if(z) {
                        InputStream inputStream0 = jarFile0.getInputStream(jarEntry0);
                        if(inputStream0 == null) {
                            Log.w("ACTk", UnityPlayerActivity.adjustValue("353302050B2906161A291503041C00130A004E353F3321333A45382F224D090F12470B07021C4D0800111211521D041F040F0C47031D1C50080F1A131E4505070405411E00130D484E") + s);
                        }
                        else {
                            int v1 = 0;
                            while(v1 != -1) {
                                v1 = inputStream0.read(arr_b);
                                if(v1 > 0) {
                                    messageDigest0.update(arr_b, 0, v1);
                                }
                            }
                            String s1 = NativeUtils.BytesToHex(messageDigest0.digest());
                            list0.add(s);
                            list1.add(s1);
                            messageDigest0.reset();
                            inputStream0.close();
                        }
                    }
                }
            }
        }
    }

    class net.codestage.actk.androidnative.CodeHashGenerator.1 {
    }

}

