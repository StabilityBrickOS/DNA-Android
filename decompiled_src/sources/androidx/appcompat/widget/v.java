package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* loaded from: classes.dex */
class v extends r {

    /* renamed from: d, reason: collision with root package name */
    private final SeekBar f270d;

    /* renamed from: e, reason: collision with root package name */
    private Drawable f271e;
    private ColorStateList f;
    private PorterDuff.Mode g;
    private boolean h;
    private boolean i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(SeekBar seekBar) {
        super(seekBar);
        this.f = null;
        this.g = null;
        this.h = false;
        this.i = false;
        this.f270d = seekBar;
    }

    private void f() {
        if (this.f271e != null) {
            if (this.h || this.i) {
                Drawable r = androidx.core.graphics.drawable.a.r(this.f271e.mutate());
                this.f271e = r;
                if (this.h) {
                    androidx.core.graphics.drawable.a.o(r, this.f);
                }
                if (this.i) {
                    androidx.core.graphics.drawable.a.p(this.f271e, this.g);
                }
                if (this.f271e.isStateful()) {
                    this.f271e.setState(this.f270d.getDrawableState());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.widget.r
    public void c(AttributeSet attributeSet, int i) {
        super.c(attributeSet, i);
        w0 v = w0.v(this.f270d.getContext(), attributeSet, c.a.j.AppCompatSeekBar, i, 0);
        SeekBar seekBar = this.f270d;
        c.f.l.s.g0(seekBar, seekBar.getContext(), c.a.j.AppCompatSeekBar, attributeSet, v.r(), i, 0);
        Drawable h = v.h(c.a.j.AppCompatSeekBar_android_thumb);
        if (h != null) {
            this.f270d.setThumb(h);
        }
        j(v.g(c.a.j.AppCompatSeekBar_tickMark));
        if (v.s(c.a.j.AppCompatSeekBar_tickMarkTintMode)) {
            this.g = e0.d(v.k(c.a.j.AppCompatSeekBar_tickMarkTintMode, -1), this.g);
            this.i = true;
        }
        if (v.s(c.a.j.AppCompatSeekBar_tickMarkTint)) {
            this.f = v.c(c.a.j.AppCompatSeekBar_tickMarkTint);
            this.h = true;
        }
        v.w();
        f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(Canvas canvas) {
        if (this.f271e != null) {
            int max = this.f270d.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f271e.getIntrinsicWidth();
                int intrinsicHeight = this.f271e.getIntrinsicHeight();
                int i = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i2 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f271e.setBounds(-i, -i2, i, i2);
                float width = ((this.f270d.getWidth() - this.f270d.getPaddingLeft()) - this.f270d.getPaddingRight()) / max;
                int save = canvas.save();
                canvas.translate(this.f270d.getPaddingLeft(), this.f270d.getHeight() / 2);
                for (int i3 = 0; i3 <= max; i3++) {
                    this.f271e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        Drawable drawable = this.f271e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f270d.getDrawableState())) {
            this.f270d.invalidateDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        Drawable drawable = this.f271e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    void j(Drawable drawable) {
        Drawable drawable2 = this.f271e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f271e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f270d);
            androidx.core.graphics.drawable.a.m(drawable, c.f.l.s.y(this.f270d));
            if (drawable.isStateful()) {
                drawable.setState(this.f270d.getDrawableState());
            }
            f();
        }
        this.f270d.invalidate();
    }
}
