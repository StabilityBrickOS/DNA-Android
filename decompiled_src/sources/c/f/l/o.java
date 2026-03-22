package c.f.l;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class o {
    private int a;

    /* renamed from: b, reason: collision with root package name */
    private int f810b;

    public o(ViewGroup viewGroup) {
    }

    public int a() {
        return this.a | this.f810b;
    }

    public void b(View view, View view2, int i) {
        c(view, view2, i, 0);
    }

    public void c(View view, View view2, int i, int i2) {
        if (i2 == 1) {
            this.f810b = i;
        } else {
            this.a = i;
        }
    }

    public void d(View view, int i) {
        if (i == 1) {
            this.f810b = 0;
        } else {
            this.a = 0;
        }
    }
}
