package com.voxelbusters.essentialkit.utilities.common;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import com.voxelbusters.essentialkit.utilities.Logger;
import com.voxelbusters.essentialkit.utilities.common.interfaces.ILoadAssetListener;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class Asset {
    public static class Builder {
        private Context context;
        private Uri uri;

        public Builder(Context context0) {
            this.context = context0;
        }

        public Asset build() {
            return new Asset(this.context, this.uri, null);
        }

        public Builder withFilePath(String s) {
            this.uri = Uri.parse(("file://" + s));
            return this;
        }

        public Builder withUri(Uri uri0) {
            this.uri = uri0;
            return this;
        }
    }

    public static final class a {
    }

    private Context context;
    private Uri uri;

    private Asset(Context context0, Uri uri0) {
        this.context = context0;
        this.uri = uri0;
    }

    public Asset(Context context0, Uri uri0, a asset$a0) {
        this(context0, uri0);
    }

    public boolean isValid() {
        return this.uri != null;
    }

    // 检测为 Lambda 实现
    void lambda$load$0$com-voxelbusters-essentialkit-utilities-common-Asset(ILoadAssetListener iLoadAssetListener0) [...]

    public void load(ILoadAssetListener iLoadAssetListener0) {
        Logger.debug(("Loading Uri : " + this.uri));
        if(!this.isValid()) {
            Logger.warning(("Invalid asset : " + this.uri));
            iLoadAssetListener0.onSuccess(null);
            return;
        }
        AsyncTask.execute(() -> try {
            InputStream inputStream0 = this.context.getContentResolver().openInputStream(this.uri);
            ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
            byte[] arr_b = new byte[0x400];
            int v;
            while((v = inputStream0.read(arr_b)) != -1) {
                byteArrayOutputStream0.write(arr_b, 0, v);
                Thread.sleep(1L);
            }
            byte[] arr_b1 = byteArrayOutputStream0.toByteArray();
            if(iLoadAssetListener0 != null) {
                iLoadAssetListener0.onSuccess(new BytesWrapper(arr_b1));
            }
        }
        catch(Exception exception0) {
            Logger.error(exception0.toString());
            iLoadAssetListener0.onFailure(exception0.getMessage());
        });
    }
}

