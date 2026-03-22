package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e {
    private final View a;

    /* renamed from: d, reason: collision with root package name */
    private u0 f202d;

    /* renamed from: e, reason: collision with root package name */
    private u0 f203e;
    private u0 f;

    /* renamed from: c, reason: collision with root package name */
    private int f201c = -1;

    /* renamed from: b, reason: collision with root package name */
    private final j f200b = j.b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(View view) {
        this.a = view;
    }

    private boolean a(Drawable drawable) {
        if (this.f == null) {
            this.f = new u0();
        }
        u0 u0Var = this.f;
        u0Var.a();
        ColorStateList p = c.f.l.s.p(this.a);
        if (p != null) {
            u0Var.f269d = true;
            u0Var.a = p;
        }
        PorterDuff.Mode q = c.f.l.s.q(this.a);
        if (q != null) {
            u0Var.f268c = true;
            u0Var.f267b = q;
        }
        if (!u0Var.f269d && !u0Var.f268c) {
            return false;
        }
        j.i(drawable, u0Var, this.a.getDrawableState());
        return true;
    }

    private boolean k() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.f202d != null : i == 21;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        Drawable background = this.a.getBackground();
        if (background != null) {
            if (k() && a(background)) {
                return;
            }
            u0 u0Var = this.f203e;
            if (u0Var != null) {
                j.i(background, u0Var, this.a.getDrawableState());
                return;
            }
            u0 u0Var2 = this.f202d;
            if (u0Var2 != null) {
                j.i(background, u0Var2, this.a.getDrawableState());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList c() {
        u0 u0Var = this.f203e;
        if (u0Var != null) {
            return u0Var.a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode d() {
        u0 u0Var = this.f203e;
        if (u0Var != null) {
            return u0Var.f267b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(AttributeSet attributeSet, int i) {
        w0 v = w0.v(this.a.getContext(), attributeSet, c.a.j.ViewBackgroundHelper, i, 0);
        View view = this.a;
        c.f.l.s.g0(view, view.getContext(), c.a.j.ViewBackgroundHelper, attributeSet, v.r(), i, 0);
        try {
            if (v.s(c.a.j.ViewBackgroundHelper_android_background)) {
                this.f201c = v.n(c.a.j.ViewBackgroundHelper_android_background, -1);
                ColorStateList f = this.f200b.f(this.a.getContext(), this.f201c);
                if (f != null) {
                    h(f);
                }
            }
            if (v.s(c.a.j.ViewBackgroundHelper_backgroundTint)) {
                c.f.l.s.m0(this.a, v.c(c.a.j.ViewBackgroundHelper_backgroundTint));
            }
            if (v.s(c.a.j.ViewBackgroundHelper_backgroundTintMode)) {
                c.f.l.s.n0(this.a, e0.d(v.k(c.a.j.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
        } finally {
            v.w();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Drawable drawable) {
        this.f201c = -1;
        h(null);
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(int i) {
        this.f201c = i;
        j jVar = this.f200b;
        h(jVar != null ? jVar.f(this.a.getContext(), i) : null);
        b();
    }

    void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f202d == null) {
                this.f202d = new u0();
            }
            u0 u0Var = this.f202d;
            u0Var.a = colorStateList;
            u0Var.f269d = true;
        } else {
            this.f202d = null;
        }
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(ColorStateList colorStateList) {
        if (this.f203e == null) {
            this.f203e = new u0();
        }
        u0 u0Var = this.f203e;
        u0Var.a = colorStateList;
        u0Var.f269d = true;
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(PorterDuff.Mode mode) {
        if (this.f203e == null) {
            this.f203e = new u0();
        }
        u0 u0Var = this.f203e;
        u0Var.f267b = mode;
        u0Var.f268c = true;
        b();
    }
}
