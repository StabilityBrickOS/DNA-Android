package com.google.android.material.floatingactionbutton;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import d.a.a.a.z.k;
import d.a.a.a.z.l;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends Drawable {

    /* renamed from: b, reason: collision with root package name */
    private final Paint f1120b;
    float h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private k o;
    private ColorStateList p;
    private final l a = new l();

    /* renamed from: c, reason: collision with root package name */
    private final Path f1121c = new Path();

    /* renamed from: d, reason: collision with root package name */
    private final Rect f1122d = new Rect();

    /* renamed from: e, reason: collision with root package name */
    private final RectF f1123e = new RectF();
    private final RectF f = new RectF();
    private final b g = new b();
    private boolean n = true;

    /* loaded from: classes.dex */
    private class b extends Drawable.ConstantState {
        private b() {
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return a.this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(k kVar) {
        this.o = kVar;
        Paint paint = new Paint(1);
        this.f1120b = paint;
        paint.setStyle(Paint.Style.STROKE);
    }

    private Shader a() {
        copyBounds(this.f1122d);
        float height = this.h / r0.height();
        return new LinearGradient(0.0f, r0.top, 0.0f, r0.bottom, new int[]{c.f.e.a.b(this.i, this.m), c.f.e.a.b(this.j, this.m), c.f.e.a.b(c.f.e.a.d(this.j, 0), this.m), c.f.e.a.b(c.f.e.a.d(this.l, 0), this.m), c.f.e.a.b(this.l, this.m), c.f.e.a.b(this.k, this.m)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, Shader.TileMode.CLAMP);
    }

    protected RectF b() {
        this.f.set(getBounds());
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.m = colorStateList.getColorForState(getState(), this.m);
        }
        this.p = colorStateList;
        this.n = true;
        invalidateSelf();
    }

    public void d(float f) {
        if (this.h != f) {
            this.h = f;
            this.f1120b.setStrokeWidth(f * 1.3333f);
            this.n = true;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.n) {
            this.f1120b.setShader(a());
            this.n = false;
        }
        float strokeWidth = this.f1120b.getStrokeWidth() / 2.0f;
        copyBounds(this.f1122d);
        this.f1123e.set(this.f1122d);
        float min = Math.min(this.o.r().a(b()), this.f1123e.width() / 2.0f);
        if (this.o.u(b())) {
            this.f1123e.inset(strokeWidth, strokeWidth);
            canvas.drawRoundRect(this.f1123e, min, min, this.f1120b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(int i, int i2, int i3, int i4) {
        this.i = i;
        this.j = i2;
        this.k = i3;
        this.l = i4;
    }

    public void f(k kVar) {
        this.o = kVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.h > 0.0f ? -3 : -2;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.o.u(b())) {
            outline.setRoundRect(getBounds(), this.o.r().a(b()));
            return;
        }
        copyBounds(this.f1122d);
        this.f1123e.set(this.f1122d);
        this.a.d(this.o, 1.0f, this.f1123e, this.f1121c);
        if (this.f1121c.isConvex()) {
            outline.setConvexPath(this.f1121c);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        if (!this.o.u(b())) {
            return true;
        }
        int round = Math.round(this.h);
        rect.set(round, round, round, round);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.p;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.n = true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState;
        ColorStateList colorStateList = this.p;
        if (colorStateList != null && (colorForState = colorStateList.getColorForState(iArr, this.m)) != this.m) {
            this.n = true;
            this.m = colorForState;
        }
        if (this.n) {
            invalidateSelf();
        }
        return this.n;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f1120b.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1120b.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
