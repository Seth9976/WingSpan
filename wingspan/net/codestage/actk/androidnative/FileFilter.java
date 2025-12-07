package net.codestage.actk.androidnative;

import android.util.Log;
import com.unity3d.player.UnityPlayerActivity;
import java.io.File;

class FileFilter {
    private Boolean caseSensitive;
    private Boolean exactFileNameMatch;
    private Boolean exactFolderMatch;
    private String filterExtension;
    private String filterFileName;
    private String filterFolder;
    private Boolean folderRecursive;

    FileFilter(String s) {
        if(s != null && !s.isEmpty()) {
            String[] arr_s = s.split(UnityPlayerActivity.adjustValue("320C"));
            if(arr_s.length < 4) {
                Log.e("ACTk", UnityPlayerActivity.adjustValue("2D1103461A411704001D154D27070D02231B020408135441141100071E0A411D110B0C064E1F030D1741130A52") + arr_s.length + UnityPlayerActivity.adjustValue("4E000C131A12470C1C1D0408000A410803520319030803140A45464E000C131A1246"));
                return;
            }
            this.caseSensitive = Boolean.valueOf(Boolean.parseBoolean(arr_s[0]));
            this.folderRecursive = Boolean.valueOf(Boolean.parseBoolean(arr_s[1]));
            this.exactFileNameMatch = Boolean.valueOf(Boolean.parseBoolean(arr_s[2]));
            this.exactFolderMatch = Boolean.valueOf(Boolean.parseBoolean(arr_s[3]));
            if(arr_s.length >= 5) {
                this.filterFolder = arr_s[4];
            }
            if(arr_s.length >= 6) {
                this.filterExtension = arr_s[5];
            }
            if(arr_s.length >= 7) {
                this.filterFileName = arr_s[6];
            }
            return;
        }
        Log.e("ACTk", UnityPlayerActivity.adjustValue("2D1103461A411704001D154D27070D02231B020408135441141100071E0A410712470B07021C4D0E1C410208021A094C"));
    }

    boolean MatchPath(String s) {
        File file0 = new File(s);
        String s1 = this.filterExtension;
        String s2 = UnityPlayerActivity.adjustValue("40");
        if(s1 != null && !s1.isEmpty()) {
            String s3 = file0.getName();
            if(s3.isEmpty()) {
                return false;
            }
            if(s3.indexOf(s2) <= 0) {
                return false;
            }
            String s4 = s3.substring(s3.lastIndexOf(s2) + 1);
            if(s4.isEmpty()) {
                return false;
            }
            if(this.caseSensitive.booleanValue()) {
                if(!this.filterExtension.equals(s4)) {
                    return false;
                }
            }
            else if(!this.filterExtension.equalsIgnoreCase(s4)) {
                return false;
            }
        }
        if(this.filterFileName != null && !this.filterFileName.isEmpty()) {
            String s5 = file0.getName();
            if(s5.isEmpty()) {
                return false;
            }
            if(s5.indexOf(s2) > 0) {
                s5 = s5.substring(0, s5.lastIndexOf(s2));
            }
            if(this.exactFileNameMatch.booleanValue()) {
                return this.caseSensitive.booleanValue() ? this.filterFileName.equals(s5) : this.filterFileName.equalsIgnoreCase(s5);
            }
            return this.caseSensitive.booleanValue() ? s5.contains(this.filterFileName) : NativeUtils.ContainsIgnoreCase(s5, this.filterFileName);
        }
        return true;
    }
}

