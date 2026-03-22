package c.l;

import android.annotation.SuppressLint;
import android.view.View;

/* loaded from: classes.dex */
class d0 extends i0 {

    /* renamed from: e, reason: collision with root package name */
    private static boolean f861e = true;

    @Override // c.l.i0
    public void a(View view) {
    }

    @Override // c.l.i0
    @SuppressLint({"NewApi"})
    public float c(View view) {
        if (f861e) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                f861e = false;
            }
        }
        return view.getAlpha();
    }

    @Override // c.l.i0
    public void d(View view) {
    }

    @Override // c.l.i0
    @SuppressLint({"NewApi"})
    public void f(View view, float f) {
        if (f861e) {
            try {
                view.setTransitionAlpha(f);
                return;
            } catch (NoSuchMethodError unused) {
                f861e = false;
            }
        }
        view.setAlpha(f);
    }
}
