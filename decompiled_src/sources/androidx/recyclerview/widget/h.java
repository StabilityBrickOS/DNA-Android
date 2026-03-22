package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class h extends n {

    /* renamed from: d, reason: collision with root package name */
    private j f587d;

    /* renamed from: e, reason: collision with root package name */
    private j f588e;

    private float m(RecyclerView.n nVar, j jVar) {
        int J = nVar.J();
        if (J == 0) {
            return 1.0f;
        }
        View view = null;
        View view2 = null;
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < J; i3++) {
            View I = nVar.I(i3);
            int h0 = nVar.h0(I);
            if (h0 != -1) {
                if (h0 < i) {
                    view = I;
                    i = h0;
                }
                if (h0 > i2) {
                    view2 = I;
                    i2 = h0;
                }
            }
        }
        if (view == null || view2 == null) {
            return 1.0f;
        }
        int max = Math.max(jVar.d(view), jVar.d(view2)) - Math.min(jVar.g(view), jVar.g(view2));
        if (max == 0) {
            return 1.0f;
        }
        return (max * 1.0f) / ((i2 - i) + 1);
    }

    private int n(RecyclerView.n nVar, View view, j jVar) {
        return (jVar.g(view) + (jVar.e(view) / 2)) - (jVar.m() + (jVar.n() / 2));
    }

    private int o(RecyclerView.n nVar, j jVar, int i, int i2) {
        int[] d2 = d(i, i2);
        float m = m(nVar, jVar);
        if (m <= 0.0f) {
            return 0;
        }
        return Math.round((Math.abs(d2[0]) > Math.abs(d2[1]) ? d2[0] : d2[1]) / m);
    }

    private View p(RecyclerView.n nVar, j jVar) {
        int J = nVar.J();
        View view = null;
        if (J == 0) {
            return null;
        }
        int m = jVar.m() + (jVar.n() / 2);
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < J; i2++) {
            View I = nVar.I(i2);
            int abs = Math.abs((jVar.g(I) + (jVar.e(I) / 2)) - m);
            if (abs < i) {
                view = I;
                i = abs;
            }
        }
        return view;
    }

    private j q(RecyclerView.n nVar) {
        j jVar = this.f588e;
        if (jVar == null || jVar.a != nVar) {
            this.f588e = j.a(nVar);
        }
        return this.f588e;
    }

    private j r(RecyclerView.n nVar) {
        j jVar = this.f587d;
        if (jVar == null || jVar.a != nVar) {
            this.f587d = j.c(nVar);
        }
        return this.f587d;
    }

    @Override // androidx.recyclerview.widget.n
    public int[] c(RecyclerView.n nVar, View view) {
        int[] iArr = new int[2];
        if (nVar.k()) {
            iArr[0] = n(nVar, view, q(nVar));
        } else {
            iArr[0] = 0;
        }
        if (nVar.l()) {
            iArr[1] = n(nVar, view, r(nVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.n
    public View h(RecyclerView.n nVar) {
        j q;
        if (nVar.l()) {
            q = r(nVar);
        } else {
            if (!nVar.k()) {
                return null;
            }
            q = q(nVar);
        }
        return p(nVar, q);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.n
    public int i(RecyclerView.n nVar, int i, int i2) {
        int Y;
        View h;
        int h0;
        int i3;
        PointF a;
        int i4;
        int i5;
        if (!(nVar instanceof RecyclerView.y.b) || (Y = nVar.Y()) == 0 || (h = h(nVar)) == null || (h0 = nVar.h0(h)) == -1 || (a = ((RecyclerView.y.b) nVar).a(Y - 1)) == null) {
            return -1;
        }
        if (nVar.k()) {
            i4 = o(nVar, q(nVar), i, 0);
            if (a.x < 0.0f) {
                i4 = -i4;
            }
        } else {
            i4 = 0;
        }
        if (nVar.l()) {
            i5 = o(nVar, r(nVar), 0, i2);
            if (a.y < 0.0f) {
                i5 = -i5;
            }
        } else {
            i5 = 0;
        }
        if (nVar.l()) {
            i4 = i5;
        }
        if (i4 == 0) {
            return -1;
        }
        int i6 = h0 + i4;
        int i7 = i6 >= 0 ? i6 : 0;
        return i7 >= Y ? i3 : i7;
    }
}
