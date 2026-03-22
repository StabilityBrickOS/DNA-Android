package c.l;

import android.annotation.SuppressLint;
import android.view.View;

/* loaded from: classes.dex */
class f0 extends e0 {
    private static boolean h = true;

    @Override // c.l.i0
    @SuppressLint({"NewApi"})
    public void e(View view, int i, int i2, int i3, int i4) {
        if (h) {
            try {
                view.setLeftTopRightBottom(i, i2, i3, i4);
            } catch (NoSuchMethodError unused) {
                h = false;
            }
        }
    }
}
