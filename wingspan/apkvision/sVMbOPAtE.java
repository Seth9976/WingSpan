package apkvision;

import android.animation.Animator.AnimatorListener;
import android.animation.Animator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View.OnClickListener;
import android.view.View;
import np.dcc.protect.EntryPoint;

public class sVMbOPAtE {
    static {
        EntryPoint.stub(2);
    }

    public static Bitmap access$000(Bitmap bitmap0, int v) {
        return sVMbOPAtE.krjUyALI(bitmap0, v);
    }

    public static native Bitmap krjUyALI(Bitmap arg0, int arg1) {
    }

    public static native void krjUyALI(Activity arg0) {

        public class apkvision.sVMbOPAtE.1 implements Runnable {
            public final Activity val$activity;

            static {
                EntryPoint.stub(1);
            }

            public apkvision.sVMbOPAtE.1(Activity activity0) {
                this.val$activity = activity0;
                super();
            }

            @Override
            public native void run() {

                public class apkvision.sVMbOPAtE.1.1 implements View.OnClickListener {
                    static {
                        EntryPoint.stub(7);
                    }

                    public apkvision.sVMbOPAtE.1.1() {
                        apkvision.sVMbOPAtE.1.this = sVMbOPAtE$10;
                        super();
                    }

                    @Override  // android.view.View$OnClickListener
                    public native void onClick(View arg1) {
                    }
                }


                public class apkvision.sVMbOPAtE.1.2 implements Animator.AnimatorListener {
                    public final int val$idImageView;

                    static {
                        EntryPoint.stub(0);
                    }

                    public apkvision.sVMbOPAtE.1.2(int v) {
                        apkvision.sVMbOPAtE.1.this = sVMbOPAtE$10;
                        this.val$idImageView = v;
                        super();
                    }

                    @Override  // android.animation.Animator$AnimatorListener
                    public native void onAnimationCancel(Animator arg1) {
                    }

                    @Override  // android.animation.Animator$AnimatorListener
                    public native void onAnimationEnd(Animator arg1) {
                    }

                    @Override  // android.animation.Animator$AnimatorListener
                    public native void onAnimationRepeat(Animator arg1) {
                    }

                    @Override  // android.animation.Animator$AnimatorListener
                    public native void onAnimationStart(Animator arg1) {
                    }
                }

            }
        }

    }
}

