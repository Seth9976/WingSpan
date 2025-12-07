package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

class ActionBarBackgroundDrawable extends Drawable {
    final ActionBarContainer mContainer;

    public ActionBarBackgroundDrawable(ActionBarContainer actionBarContainer0) {
        this.mContainer = actionBarContainer0;
    }

    @Override  // android.graphics.drawable.Drawable
    public void draw(Canvas canvas0) {
        if(!this.mContainer.mIsSplit) {
            if(this.mContainer.mBackground != null) {
                this.mContainer.mBackground.draw(canvas0);
            }
            if(this.mContainer.mStackedBackground != null && this.mContainer.mIsStacked) {
                this.mContainer.mStackedBackground.draw(canvas0);
            }
        }
        else if(this.mContainer.mSplitBackground != null) {
            this.mContainer.mSplitBackground.draw(canvas0);
        }
    }

    @Override  // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override  // android.graphics.drawable.Drawable
    public void getOutline(Outline outline0) {
        if(this.mContainer.mIsSplit) {
            if(this.mContainer.mSplitBackground != null) {
                this.mContainer.mSplitBackground.getOutline(outline0);
            }
        }
        else if(this.mContainer.mBackground != null) {
            this.mContainer.mBackground.getOutline(outline0);
        }
    }

    @Override  // android.graphics.drawable.Drawable
    public void setAlpha(int v) {
    }

    @Override  // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter0) {
    }
}

