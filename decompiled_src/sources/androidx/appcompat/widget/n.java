package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class n {
    private final ImageView a;

    /* renamed from: b, reason: collision with root package name */
    private u0 f236b;

    /* renamed from: c, reason: collision with root package name */
    private u0 f237c;

    /* renamed from: d, reason: collision with root package name */
    private u0 f238d;

    public n(ImageView imageView) {
        this.a = imageView;
    }

    private boolean a(Drawable drawable) {
        if (this.f238d == null) {
            this.f238d = new u0();
        }
        u0 u0Var = this.f238d;
        u0Var.a();
        ColorStateList a = androidx.core.widget.e.a(this.a);
        if (a != null) {
            u0Var.f269d = true;
            u0Var.a = a;
        }
        PorterDuff.Mode b2 = androidx.core.widget.e.b(this.a);
        if (b2 != null) {
            u0Var.f268c = true;
            u0Var.f267b = b2;
        }
        if (!u0Var.f269d && !u0Var.f268c) {
            return false;
        }
        j.i(drawable, u0Var, this.a.getDrawableState());
        return true;
    }

    private boolean j() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.f236b != null : i == 21;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        Drawable drawable = this.a.getDrawable();
        if (drawable != null) {
            e0.b(drawable);
        }
        if (drawable != null) {
            if (j() && a(drawable)) {
                return;
            }
            u0 u0Var = this.f237c;
            if (u0Var != null) {
                j.i(drawable, u0Var, this.a.getDrawableState());
                return;
            }
            u0 u0Var2 = this.f236b;
            if (u0Var2 != null) {
                j.i(drawable, u0Var2, this.a.getDrawableState());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList c() {
        u0 u0Var = this.f237c;
        if (u0Var != null) {
            return u0Var.a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode d() {
        u0 u0Var = this.f237c;
        if (u0Var != null) {
            return u0Var.f267b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return Build.VERSION.SDK_INT < 21 || !(this.a.getBackground() instanceof RippleDrawable);
    }

    public void f(AttributeSet attributeSet, int i) {
        int n;
        w0 v = w0.v(this.a.getContext(), attributeSet, c.a.j.AppCompatImageView, i, 0);
        ImageView imageView = this.a;
        c.f.l.s.g0(imageView, imageView.getContext(), c.a.j.AppCompatImageView, attributeSet, v.r(), i, 0);
        try {
            Drawable drawable = this.a.getDrawable();
            if (drawable == null && (n = v.n(c.a.j.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = c.a.k.a.a.d(this.a.getContext(), n)) != null) {
                this.a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                e0.b(drawable);
            }
            if (v.s(c.a.j.AppCompatImageView_tint)) {
                androidx.core.widget.e.c(this.a, v.c(c.a.j.AppCompatImageView_tint));
            }
            if (v.s(c.a.j.AppCompatImageView_tintMode)) {
                androidx.core.widget.e.d(this.a, e0.d(v.k(c.a.j.AppCompatImageView_tintMode, -1), null));
            }
        } finally {
            v.w();
        }
    }

    public void g(int i) {
        if (i != 0) {
            Drawable d2 = c.a.k.a.a.d(this.a.getContext(), i);
            if (d2 != null) {
                e0.b(d2);
            }
            this.a.setImageDrawable(d2);
        } else {
            this.a.setImageDrawable(null);
        }
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(ColorStateList colorStateList) {
        if (this.f237c == null) {
            this.f237c = new u0();
        }
        u0 u0Var = this.f237c;
        u0Var.a = colorStateList;
        u0Var.f269d = true;
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(PorterDuff.Mode mode) {
        if (this.f237c == null) {
            this.f237c = new u0();
        }
        u0 u0Var = this.f237c;
        u0Var.f267b = mode;
        u0Var.f268c = true;
        b();
    }
}
