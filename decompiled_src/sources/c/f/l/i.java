package c.f.l;

import android.view.MotionEvent;

/* loaded from: classes.dex */
public final class i {
    @Deprecated
    public static int a(MotionEvent motionEvent, int i) {
        return motionEvent.findPointerIndex(i);
    }

    @Deprecated
    public static int b(MotionEvent motionEvent) {
        return motionEvent.getActionIndex();
    }

    @Deprecated
    public static int c(MotionEvent motionEvent) {
        return motionEvent.getActionMasked();
    }

    @Deprecated
    public static int d(MotionEvent motionEvent, int i) {
        return motionEvent.getPointerId(i);
    }

    @Deprecated
    public static float e(MotionEvent motionEvent, int i) {
        return motionEvent.getY(i);
    }

    public static boolean f(MotionEvent motionEvent, int i) {
        return (motionEvent.getSource() & i) == i;
    }
}
