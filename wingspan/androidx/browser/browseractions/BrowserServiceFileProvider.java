package androidx.browser.browseractions;

import android.content.ClipData.Item;
import android.content.ClipData;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri.Builder;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.content.FileProvider;
import androidx.core.util.AtomicFile;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Deprecated
public final class BrowserServiceFileProvider extends FileProvider {
    static class FileCleanupTask extends AsyncTask {
        private static final long CLEANUP_REQUIRED_TIME_SPAN;
        private static final long DELETION_FAILED_REATTEMPT_DURATION;
        private static final long IMAGE_RETENTION_DURATION;
        private final Context mAppContext;

        static {
            FileCleanupTask.IMAGE_RETENTION_DURATION = TimeUnit.DAYS.toMillis(7L);
            FileCleanupTask.CLEANUP_REQUIRED_TIME_SPAN = TimeUnit.DAYS.toMillis(7L);
            FileCleanupTask.DELETION_FAILED_REATTEMPT_DURATION = TimeUnit.DAYS.toMillis(1L);
        }

        FileCleanupTask(Context context) {
            this.mAppContext = context.getApplicationContext();
        }

        @Override  // android.os.AsyncTask
        protected Object doInBackground(Object[] params) {
            return this.doInBackground(((Void[])params));
        }

        protected Void doInBackground(Void[] params) {
            SharedPreferences sharedPreferences0 = this.mAppContext.getSharedPreferences("com.MonsterCouch.Wingspan.image_provider", 0);
            if(!FileCleanupTask.shouldCleanUp(sharedPreferences0)) {
                return null;
            }
            synchronized(BrowserServiceFileProvider.sFileCleanupLock) {
                File file0 = new File(this.mAppContext.getFilesDir(), "image_provider");
                if(!file0.exists()) {
                    return null;
                }
                File[] arr_file = file0.listFiles();
                long v1 = System.currentTimeMillis() - FileCleanupTask.IMAGE_RETENTION_DURATION;
                boolean z = true;
                for(int v2 = 0; v2 < arr_file.length; ++v2) {
                    File file1 = arr_file[v2];
                    if(FileCleanupTask.isImageFile(file1) && file1.lastModified() < v1 && !file1.delete()) {
                        Log.e("BrowserServiceFP", "Fail to delete image: " + file1.getAbsoluteFile());
                        z = false;
                    }
                }
                SharedPreferences.Editor sharedPreferences$Editor0 = sharedPreferences0.edit();
                sharedPreferences$Editor0.putLong("last_cleanup_time", (z ? System.currentTimeMillis() : System.currentTimeMillis() - FileCleanupTask.CLEANUP_REQUIRED_TIME_SPAN + FileCleanupTask.DELETION_FAILED_REATTEMPT_DURATION));
                sharedPreferences$Editor0.apply();
                return null;
            }
        }

        private static boolean isImageFile(File file) {
            return file.getName().endsWith("..png");
        }

        private static boolean shouldCleanUp(SharedPreferences prefs) {
            return System.currentTimeMillis() > prefs.getLong("last_cleanup_time", System.currentTimeMillis()) + FileCleanupTask.CLEANUP_REQUIRED_TIME_SPAN;
        }
    }

    static class FileSaveTask extends AsyncTask {
        private final Context mAppContext;
        private final Bitmap mBitmap;
        private final Uri mFileUri;
        private final String mFilename;
        private final ResolvableFuture mResultFuture;

        FileSaveTask(Context context, String filename, Bitmap bitmap, Uri fileUri, ResolvableFuture resultFuture) {
            this.mAppContext = context.getApplicationContext();
            this.mFilename = filename;
            this.mBitmap = bitmap;
            this.mFileUri = fileUri;
            this.mResultFuture = resultFuture;
        }

        @Override  // android.os.AsyncTask
        protected Object doInBackground(Object[] params) {
            return this.doInBackground(((String[])params));
        }

        protected Void doInBackground(String[] params) {
            this.saveFileIfNeededBlocking();
            return null;
        }

        @Override  // android.os.AsyncTask
        protected void onPostExecute(Object result) {
            this.onPostExecute(((Void)result));
        }

        protected void onPostExecute(Void result) {
            new FileCleanupTask(this.mAppContext).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
        }

        private void saveFileBlocking(File img) {
            FileOutputStream fileOutputStream0;
            AtomicFile atomicFile0 = new AtomicFile(img);
            try {
                fileOutputStream0 = null;
                fileOutputStream0 = atomicFile0.startWrite();
                this.mBitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream0);
                fileOutputStream0.close();
                atomicFile0.finishWrite(fileOutputStream0);
                this.mResultFuture.set(this.mFileUri);
            }
            catch(IOException iOException0) {
                atomicFile0.failWrite(fileOutputStream0);
                this.mResultFuture.setException(iOException0);
            }
        }

        private void saveFileIfNeededBlocking() {
            File file0 = new File(this.mAppContext.getFilesDir(), "image_provider");
            synchronized(BrowserServiceFileProvider.sFileCleanupLock) {
                if(!file0.exists() && !file0.mkdir()) {
                    IOException iOException0 = new IOException("Could not create file directory.");
                    this.mResultFuture.setException(iOException0);
                    return;
                }
                File file1 = new File(file0, this.mFilename + ".png");
                if(file1.exists()) {
                    this.mResultFuture.set(this.mFileUri);
                }
                else {
                    this.saveFileBlocking(file1);
                }
                file1.setLastModified(System.currentTimeMillis());
            }
        }
    }

    private static final String AUTHORITY_SUFFIX = ".image_provider";
    private static final String CLIP_DATA_LABEL = "image_provider_uris";
    private static final String CONTENT_SCHEME = "content";
    private static final String FILE_EXTENSION = ".png";
    private static final String FILE_SUB_DIR = "image_provider";
    private static final String FILE_SUB_DIR_NAME = "image_provider_images/";
    private static final String LAST_CLEANUP_TIME_KEY = "last_cleanup_time";
    private static final String TAG = "BrowserServiceFP";
    static Object sFileCleanupLock;

    static {
        BrowserServiceFileProvider.sFileCleanupLock = new Object();
    }

    // 去混淆评级： 低(20)
    private static Uri generateUri(Context context, String filename) {
        return new Uri.Builder().scheme("content").authority("com.MonsterCouch.Wingspan.image_provider").path("image_provider_images/" + filename + ".png").build();
    }

    public static void grantReadPermission(Intent intent, List uris, Context context) {
        if(uris != null && uris.size() != 0) {
            ContentResolver contentResolver0 = context.getContentResolver();
            intent.addFlags(1);
            ClipData clipData0 = ClipData.newUri(contentResolver0, "image_provider_uris", ((Uri)uris.get(0)));
            for(int v = 1; v < uris.size(); ++v) {
                clipData0.addItem(new ClipData.Item(((Uri)uris.get(v))));
            }
            intent.setClipData(clipData0);
        }
    }

    public static ListenableFuture loadBitmap(ContentResolver resolver, Uri uri) {
        ListenableFuture listenableFuture0 = ResolvableFuture.create();
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    ParcelFileDescriptor parcelFileDescriptor0 = resolver.openFileDescriptor(uri, "r");
                    if(parcelFileDescriptor0 == null) {
                        FileNotFoundException fileNotFoundException0 = new FileNotFoundException();
                        ((ResolvableFuture)listenableFuture0).setException(fileNotFoundException0);
                        return;
                    }
                    Bitmap bitmap0 = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor0.getFileDescriptor());
                    parcelFileDescriptor0.close();
                    if(bitmap0 == null) {
                        IOException iOException1 = new IOException("File could not be decoded.");
                        ((ResolvableFuture)listenableFuture0).setException(iOException1);
                        return;
                    }
                    ((ResolvableFuture)listenableFuture0).set(bitmap0);
                }
                catch(IOException iOException0) {
                    ((ResolvableFuture)listenableFuture0).setException(iOException0);
                }
            }
        });
        return listenableFuture0;
    }

    public static ResolvableFuture saveBitmap(Context context, Bitmap bitmap, String name, int version) {
        String s1 = name + "_" + Integer.toString(version);
        Uri uri0 = BrowserServiceFileProvider.generateUri(context, s1);
        ResolvableFuture resolvableFuture0 = ResolvableFuture.create();
        new FileSaveTask(context, s1, bitmap, uri0, resolvableFuture0).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        return resolvableFuture0;
    }
}

