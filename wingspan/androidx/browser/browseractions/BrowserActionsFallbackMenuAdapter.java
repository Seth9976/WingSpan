package androidx.browser.browseractions;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.browser.R.id;
import androidx.browser.R.layout;
import androidx.core.content.res.ResourcesCompat;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

@Deprecated
class BrowserActionsFallbackMenuAdapter extends BaseAdapter {
    static class ViewHolderItem {
        final ImageView mIcon;
        final TextView mText;

        ViewHolderItem(ImageView icon, TextView text) {
            this.mIcon = icon;
            this.mText = text;
        }
    }

    private final Context mContext;
    private final List mMenuItems;

    BrowserActionsFallbackMenuAdapter(List menuItems, Context context) {
        this.mMenuItems = menuItems;
        this.mContext = context;
    }

    @Override  // android.widget.Adapter
    public int getCount() {
        return this.mMenuItems.size();
    }

    @Override  // android.widget.Adapter
    public Object getItem(int position) {
        return this.mMenuItems.get(position);
    }

    @Override  // android.widget.Adapter
    public long getItemId(int position) {
        return (long)position;
    }

    @Override  // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderItem browserActionsFallbackMenuAdapter$ViewHolderItem0;
        BrowserActionItem browserActionItem0 = (BrowserActionItem)this.mMenuItems.get(position);
        if(convertView == null) {
            convertView = LayoutInflater.from(this.mContext).inflate(layout.browser_actions_context_menu_row, null);
            ImageView imageView0 = (ImageView)convertView.findViewById(id.browser_actions_menu_item_icon);
            TextView textView0 = (TextView)convertView.findViewById(id.browser_actions_menu_item_text);
            if(imageView0 == null || textView0 == null) {
                throw new IllegalStateException("Browser Actions fallback UI does not contain necessary Views.");
            }
            browserActionsFallbackMenuAdapter$ViewHolderItem0 = new ViewHolderItem(imageView0, textView0);
            convertView.setTag(browserActionsFallbackMenuAdapter$ViewHolderItem0);
        }
        else {
            browserActionsFallbackMenuAdapter$ViewHolderItem0 = (ViewHolderItem)convertView.getTag();
        }
        String s = browserActionItem0.getTitle();
        browserActionsFallbackMenuAdapter$ViewHolderItem0.mText.setText(s);
        if(browserActionItem0.getIconId() != 0) {
            Drawable drawable0 = ResourcesCompat.getDrawable(this.mContext.getResources(), browserActionItem0.getIconId(), null);
            browserActionsFallbackMenuAdapter$ViewHolderItem0.mIcon.setImageDrawable(drawable0);
            return convertView;
        }
        if(browserActionItem0.getIconUri() != null) {
            ListenableFuture listenableFuture0 = BrowserServiceFileProvider.loadBitmap(this.mContext.getContentResolver(), browserActionItem0.getIconUri());
            listenableFuture0.addListener(new Runnable() {
                @Override
                public void run() {
                    Bitmap bitmap0;
                    CharSequence charSequence0 = browserActionsFallbackMenuAdapter$ViewHolderItem0.mText.getText();
                    if(!TextUtils.equals(s, charSequence0)) {
                        return;
                    }
                    try {
                        bitmap0 = (Bitmap)listenableFuture0.get();
                    }
                    catch(ExecutionException | InterruptedException unused_ex) {
                        bitmap0 = null;
                    }
                    if(bitmap0 != null) {
                        browserActionsFallbackMenuAdapter$ViewHolderItem0.mIcon.setVisibility(0);
                        browserActionsFallbackMenuAdapter$ViewHolderItem0.mIcon.setImageBitmap(bitmap0);
                        return;
                    }
                    browserActionsFallbackMenuAdapter$ViewHolderItem0.mIcon.setVisibility(4);
                    browserActionsFallbackMenuAdapter$ViewHolderItem0.mIcon.setImageBitmap(null);
                }
            }, new Executor() {
                @Override
                public void execute(Runnable runnable) {
                    runnable.run();
                }
            });
            return convertView;
        }
        browserActionsFallbackMenuAdapter$ViewHolderItem0.mIcon.setImageBitmap(null);
        browserActionsFallbackMenuAdapter$ViewHolderItem0.mIcon.setVisibility(4);
        return convertView;
    }
}

