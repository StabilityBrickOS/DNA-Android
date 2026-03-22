package c.l;

import android.graphics.Matrix;
import android.view.View;

/* loaded from: classes.dex */
class h0 extends g0 {
    @Override // c.l.d0, c.l.i0
    public float c(View view) {
        return view.getTransitionAlpha();
    }

    @Override // c.l.f0, c.l.i0
    public void e(View view, int i, int i2, int i3, int i4) {
        view.setLeftTopRightBottom(i, i2, i3, i4);
    }

    @Override // c.l.d0, c.l.i0
    public void f(View view, float f) {
        view.setTransitionAlpha(f);
    }

    @Override // c.l.g0, c.l.i0
    public void g(View view, int i) {
        view.setTransitionVisibility(i);
    }

    @Override // c.l.e0, c.l.i0
    public void h(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // c.l.e0, c.l.i0
    public void i(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
