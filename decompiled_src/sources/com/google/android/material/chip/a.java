package com.google.android.material.chip;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.core.graphics.drawable.b;
import com.google.android.material.internal.h;
import d.a.a.a.w.d;
import d.a.a.a.z.g;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* loaded from: classes.dex */
public class a extends g implements b, Drawable.Callback, h.b {
    private static final int[] M0 = {R.attr.state_enabled};
    private static final ShapeDrawable N0 = new ShapeDrawable(new OvalShape());
    private ColorFilter A0;
    private PorterDuffColorFilter B0;
    private ColorStateList C;
    private ColorStateList C0;
    private ColorStateList D;
    private PorterDuff.Mode D0;
    private float E;
    private int[] E0;
    private float F;
    private boolean F0;
    private ColorStateList G;
    private ColorStateList G0;
    private float H;
    private WeakReference<InterfaceC0069a> H0;
    private ColorStateList I;
    private TextUtils.TruncateAt I0;
    private CharSequence J;
    private boolean J0;
    private boolean K;
    private int K0;
    private Drawable L;
    private boolean L0;
    private ColorStateList M;
    private float N;
    private boolean O;
    private boolean P;
    private Drawable Q;
    private Drawable R;
    private ColorStateList S;
    private float T;
    private CharSequence U;
    private boolean V;
    private boolean W;
    private Drawable X;
    private ColorStateList Y;
    private d.a.a.a.l.h Z;
    private d.a.a.a.l.h a0;
    private float b0;
    private float c0;
    private float d0;
    private float e0;
    private float f0;
    private float g0;
    private float h0;
    private float i0;
    private final Context j0;
    private final Paint k0;
    private final Paint l0;
    private final Paint.FontMetrics m0;
    private final RectF n0;
    private final PointF o0;
    private final Path p0;
    private final h q0;
    private int r0;
    private int s0;
    private int t0;
    private int u0;
    private int v0;
    private int w0;
    private boolean x0;
    private int y0;
    private int z0;

    /* renamed from: com.google.android.material.chip.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0069a {
        void a();
    }

    private a(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.F = -1.0f;
        this.k0 = new Paint(1);
        this.m0 = new Paint.FontMetrics();
        this.n0 = new RectF();
        this.o0 = new PointF();
        this.p0 = new Path();
        this.z0 = 255;
        this.D0 = PorterDuff.Mode.SRC_IN;
        Paint paint = null;
        this.H0 = new WeakReference<>(null);
        M(context);
        this.j0 = context;
        h hVar = new h(this);
        this.q0 = hVar;
        this.J = "";
        hVar.e().density = context.getResources().getDisplayMetrics().density;
        this.l0 = null;
        if (0 != 0) {
            paint.setStyle(Paint.Style.STROKE);
        }
        setState(M0);
        h2(M0);
        this.J0 = true;
        if (d.a.a.a.x.b.a) {
            N0.setTint(-1);
        }
    }

    private void A0(Canvas canvas, Rect rect) {
        this.k0.setColor(this.v0);
        this.k0.setStyle(Paint.Style.FILL);
        this.n0.set(rect);
        if (!this.L0) {
            canvas.drawRoundRect(this.n0, G0(), G0(), this.k0);
        } else {
            h(new RectF(rect), this.p0);
            super.p(canvas, this.k0, this.p0, u());
        }
    }

    private void B0(Canvas canvas, Rect rect) {
        Paint paint = this.l0;
        if (paint != null) {
            paint.setColor(c.f.e.a.d(-16777216, 127));
            canvas.drawRect(rect, this.l0);
            if (J2() || I2()) {
                j0(rect, this.n0);
                canvas.drawRect(this.n0, this.l0);
            }
            if (this.J != null) {
                canvas.drawLine(rect.left, rect.exactCenterY(), rect.right, rect.exactCenterY(), this.l0);
            }
            if (K2()) {
                m0(rect, this.n0);
                canvas.drawRect(this.n0, this.l0);
            }
            this.l0.setColor(c.f.e.a.d(-65536, 127));
            l0(rect, this.n0);
            canvas.drawRect(this.n0, this.l0);
            this.l0.setColor(c.f.e.a.d(-16711936, 127));
            n0(rect, this.n0);
            canvas.drawRect(this.n0, this.l0);
        }
    }

    private void C0(Canvas canvas, Rect rect) {
        if (this.J != null) {
            Paint.Align r0 = r0(rect, this.o0);
            p0(rect, this.n0);
            if (this.q0.d() != null) {
                this.q0.e().drawableState = getState();
                this.q0.j(this.j0);
            }
            this.q0.e().setTextAlign(r0);
            int i = 0;
            boolean z = Math.round(this.q0.f(d1().toString())) > Math.round(this.n0.width());
            if (z) {
                i = canvas.save();
                canvas.clipRect(this.n0);
            }
            CharSequence charSequence = this.J;
            if (z && this.I0 != null) {
                charSequence = TextUtils.ellipsize(charSequence, this.q0.e(), this.n0.width(), this.I0);
            }
            CharSequence charSequence2 = charSequence;
            int length = charSequence2.length();
            PointF pointF = this.o0;
            canvas.drawText(charSequence2, 0, length, pointF.x, pointF.y, this.q0.e());
            if (z) {
                canvas.restoreToCount(i);
            }
        }
    }

    private boolean I2() {
        return this.W && this.X != null && this.x0;
    }

    private boolean J2() {
        return this.K && this.L != null;
    }

    private boolean K2() {
        return this.P && this.Q != null;
    }

    private void L2(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    private void M2() {
        this.G0 = this.F0 ? d.a.a.a.x.b.a(this.I) : null;
    }

    @TargetApi(21)
    private void N2() {
        this.R = new RippleDrawable(d.a.a.a.x.b.a(b1()), this.Q, N0);
    }

    private void X1(ColorStateList colorStateList) {
        if (this.C != colorStateList) {
            this.C = colorStateList;
            onStateChange(getState());
        }
    }

    private ColorFilter h1() {
        ColorFilter colorFilter = this.A0;
        return colorFilter != null ? colorFilter : this.B0;
    }

    private void i0(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        androidx.core.graphics.drawable.a.m(drawable, androidx.core.graphics.drawable.a.f(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.Q) {
            if (drawable.isStateful()) {
                drawable.setState(U0());
            }
            androidx.core.graphics.drawable.a.o(drawable, this.S);
            return;
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
        Drawable drawable2 = this.L;
        if (drawable == drawable2 && this.O) {
            androidx.core.graphics.drawable.a.o(drawable2, this.M);
        }
    }

    private void j0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (J2() || I2()) {
            float f = this.b0 + this.c0;
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                float f2 = rect.left + f;
                rectF.left = f2;
                rectF.right = f2 + this.N;
            } else {
                float f3 = rect.right - f;
                rectF.right = f3;
                rectF.left = f3 - this.N;
            }
            float exactCenterY = rect.exactCenterY();
            float f4 = this.N;
            float f5 = exactCenterY - (f4 / 2.0f);
            rectF.top = f5;
            rectF.bottom = f5 + f4;
        }
    }

    private static boolean j1(int[] iArr, int i) {
        if (iArr == null) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private void l0(Rect rect, RectF rectF) {
        rectF.set(rect);
        if (K2()) {
            float f = this.i0 + this.h0 + this.T + this.g0 + this.f0;
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                rectF.right = rect.right - f;
            } else {
                rectF.left = rect.left + f;
            }
        }
    }

    private void m0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (K2()) {
            float f = this.i0 + this.h0;
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                float f2 = rect.right - f;
                rectF.right = f2;
                rectF.left = f2 - this.T;
            } else {
                float f3 = rect.left + f;
                rectF.left = f3;
                rectF.right = f3 + this.T;
            }
            float exactCenterY = rect.exactCenterY();
            float f4 = this.T;
            float f5 = exactCenterY - (f4 / 2.0f);
            rectF.top = f5;
            rectF.bottom = f5 + f4;
        }
    }

    private void n0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (K2()) {
            float f = this.i0 + this.h0 + this.T + this.g0 + this.f0;
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                float f2 = rect.right;
                rectF.right = f2;
                rectF.left = f2 - f;
            } else {
                int i = rect.left;
                rectF.left = i;
                rectF.right = i + f;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private static boolean n1(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    private static boolean o1(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    private void p0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (this.J != null) {
            float k0 = this.b0 + k0() + this.e0;
            float o0 = this.i0 + o0() + this.f0;
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                rectF.left = rect.left + k0;
                rectF.right = rect.right - o0;
            } else {
                rectF.left = rect.left + o0;
                rectF.right = rect.right - k0;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private static boolean p1(d dVar) {
        ColorStateList colorStateList;
        return (dVar == null || (colorStateList = dVar.f1301b) == null || !colorStateList.isStateful()) ? false : true;
    }

    private float q0() {
        this.q0.e().getFontMetrics(this.m0);
        Paint.FontMetrics fontMetrics = this.m0;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0165  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void q1(android.util.AttributeSet r8, int r9, int r10) {
        /*
            Method dump skipped, instructions count: 478
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.a.q1(android.util.AttributeSet, int, int):void");
    }

    private boolean s0() {
        return this.W && this.X != null && this.V;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean s1(int[] r7, int[] r8) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.a.s1(int[], int[]):boolean");
    }

    public static a t0(Context context, AttributeSet attributeSet, int i, int i2) {
        a aVar = new a(context, attributeSet, i, i2);
        aVar.q1(attributeSet, i, i2);
        return aVar;
    }

    private void u0(Canvas canvas, Rect rect) {
        if (I2()) {
            j0(rect, this.n0);
            RectF rectF = this.n0;
            float f = rectF.left;
            float f2 = rectF.top;
            canvas.translate(f, f2);
            this.X.setBounds(0, 0, (int) this.n0.width(), (int) this.n0.height());
            this.X.draw(canvas);
            canvas.translate(-f, -f2);
        }
    }

    private void v0(Canvas canvas, Rect rect) {
        if (this.L0) {
            return;
        }
        this.k0.setColor(this.s0);
        this.k0.setStyle(Paint.Style.FILL);
        this.k0.setColorFilter(h1());
        this.n0.set(rect);
        canvas.drawRoundRect(this.n0, G0(), G0(), this.k0);
    }

    private void w0(Canvas canvas, Rect rect) {
        if (J2()) {
            j0(rect, this.n0);
            RectF rectF = this.n0;
            float f = rectF.left;
            float f2 = rectF.top;
            canvas.translate(f, f2);
            this.L.setBounds(0, 0, (int) this.n0.width(), (int) this.n0.height());
            this.L.draw(canvas);
            canvas.translate(-f, -f2);
        }
    }

    private void x0(Canvas canvas, Rect rect) {
        if (this.H <= 0.0f || this.L0) {
            return;
        }
        this.k0.setColor(this.u0);
        this.k0.setStyle(Paint.Style.STROKE);
        if (!this.L0) {
            this.k0.setColorFilter(h1());
        }
        RectF rectF = this.n0;
        float f = rect.left;
        float f2 = this.H;
        rectF.set(f + (f2 / 2.0f), rect.top + (f2 / 2.0f), rect.right - (f2 / 2.0f), rect.bottom - (f2 / 2.0f));
        float f3 = this.F - (this.H / 2.0f);
        canvas.drawRoundRect(this.n0, f3, f3, this.k0);
    }

    private void y0(Canvas canvas, Rect rect) {
        if (this.L0) {
            return;
        }
        this.k0.setColor(this.r0);
        this.k0.setStyle(Paint.Style.FILL);
        this.n0.set(rect);
        canvas.drawRoundRect(this.n0, G0(), G0(), this.k0);
    }

    private void z0(Canvas canvas, Rect rect) {
        Drawable drawable;
        if (K2()) {
            m0(rect, this.n0);
            RectF rectF = this.n0;
            float f = rectF.left;
            float f2 = rectF.top;
            canvas.translate(f, f2);
            this.Q.setBounds(0, 0, (int) this.n0.width(), (int) this.n0.height());
            if (d.a.a.a.x.b.a) {
                this.R.setBounds(this.Q.getBounds());
                this.R.jumpToCurrentState();
                drawable = this.R;
            } else {
                drawable = this.Q;
            }
            drawable.draw(canvas);
            canvas.translate(-f, -f2);
        }
    }

    public void A1(boolean z) {
        if (this.W != z) {
            boolean I2 = I2();
            this.W = z;
            boolean I22 = I2();
            if (I2 != I22) {
                if (I22) {
                    i0(this.X);
                } else {
                    L2(this.X);
                }
                invalidateSelf();
                r1();
            }
        }
    }

    public void A2(d dVar) {
        this.q0.h(dVar, this.j0);
    }

    public void B1(ColorStateList colorStateList) {
        if (this.D != colorStateList) {
            this.D = colorStateList;
            onStateChange(getState());
        }
    }

    public void B2(int i) {
        A2(new d(this.j0, i));
    }

    public void C1(int i) {
        B1(c.a.k.a.a.c(this.j0, i));
    }

    public void C2(float f) {
        if (this.f0 != f) {
            this.f0 = f;
            invalidateSelf();
            r1();
        }
    }

    public Drawable D0() {
        return this.X;
    }

    @Deprecated
    public void D1(float f) {
        if (this.F != f) {
            this.F = f;
            setShapeAppearanceModel(C().w(f));
        }
    }

    public void D2(int i) {
        C2(this.j0.getResources().getDimension(i));
    }

    public ColorStateList E0() {
        return this.Y;
    }

    @Deprecated
    public void E1(int i) {
        D1(this.j0.getResources().getDimension(i));
    }

    public void E2(float f) {
        if (this.e0 != f) {
            this.e0 = f;
            invalidateSelf();
            r1();
        }
    }

    public ColorStateList F0() {
        return this.D;
    }

    public void F1(float f) {
        if (this.i0 != f) {
            this.i0 = f;
            invalidateSelf();
            r1();
        }
    }

    public void F2(int i) {
        E2(this.j0.getResources().getDimension(i));
    }

    public float G0() {
        return this.L0 ? F() : this.F;
    }

    public void G1(int i) {
        F1(this.j0.getResources().getDimension(i));
    }

    public void G2(boolean z) {
        if (this.F0 != z) {
            this.F0 = z;
            M2();
            onStateChange(getState());
        }
    }

    public float H0() {
        return this.i0;
    }

    public void H1(Drawable drawable) {
        Drawable I0 = I0();
        if (I0 != drawable) {
            float k0 = k0();
            this.L = drawable != null ? androidx.core.graphics.drawable.a.r(drawable).mutate() : null;
            float k02 = k0();
            L2(I0);
            if (J2()) {
                i0(this.L);
            }
            invalidateSelf();
            if (k0 != k02) {
                r1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean H2() {
        return this.J0;
    }

    public Drawable I0() {
        Drawable drawable = this.L;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.q(drawable);
        }
        return null;
    }

    public void I1(int i) {
        H1(c.a.k.a.a.d(this.j0, i));
    }

    public float J0() {
        return this.N;
    }

    public void J1(float f) {
        if (this.N != f) {
            float k0 = k0();
            this.N = f;
            float k02 = k0();
            invalidateSelf();
            if (k0 != k02) {
                r1();
            }
        }
    }

    public ColorStateList K0() {
        return this.M;
    }

    public void K1(int i) {
        J1(this.j0.getResources().getDimension(i));
    }

    public float L0() {
        return this.E;
    }

    public void L1(ColorStateList colorStateList) {
        this.O = true;
        if (this.M != colorStateList) {
            this.M = colorStateList;
            if (J2()) {
                androidx.core.graphics.drawable.a.o(this.L, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public float M0() {
        return this.b0;
    }

    public void M1(int i) {
        L1(c.a.k.a.a.c(this.j0, i));
    }

    public ColorStateList N0() {
        return this.G;
    }

    public void N1(int i) {
        O1(this.j0.getResources().getBoolean(i));
    }

    public float O0() {
        return this.H;
    }

    public void O1(boolean z) {
        if (this.K != z) {
            boolean J2 = J2();
            this.K = z;
            boolean J22 = J2();
            if (J2 != J22) {
                if (J22) {
                    i0(this.L);
                } else {
                    L2(this.L);
                }
                invalidateSelf();
                r1();
            }
        }
    }

    public Drawable P0() {
        Drawable drawable = this.Q;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.q(drawable);
        }
        return null;
    }

    public void P1(float f) {
        if (this.E != f) {
            this.E = f;
            invalidateSelf();
            r1();
        }
    }

    public CharSequence Q0() {
        return this.U;
    }

    public void Q1(int i) {
        P1(this.j0.getResources().getDimension(i));
    }

    public float R0() {
        return this.h0;
    }

    public void R1(float f) {
        if (this.b0 != f) {
            this.b0 = f;
            invalidateSelf();
            r1();
        }
    }

    public float S0() {
        return this.T;
    }

    public void S1(int i) {
        R1(this.j0.getResources().getDimension(i));
    }

    public float T0() {
        return this.g0;
    }

    public void T1(ColorStateList colorStateList) {
        if (this.G != colorStateList) {
            this.G = colorStateList;
            if (this.L0) {
                d0(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public int[] U0() {
        return this.E0;
    }

    public void U1(int i) {
        T1(c.a.k.a.a.c(this.j0, i));
    }

    public ColorStateList V0() {
        return this.S;
    }

    public void V1(float f) {
        if (this.H != f) {
            this.H = f;
            this.k0.setStrokeWidth(f);
            if (this.L0) {
                super.e0(f);
            }
            invalidateSelf();
        }
    }

    public void W0(RectF rectF) {
        n0(getBounds(), rectF);
    }

    public void W1(int i) {
        V1(this.j0.getResources().getDimension(i));
    }

    public TextUtils.TruncateAt X0() {
        return this.I0;
    }

    public d.a.a.a.l.h Y0() {
        return this.a0;
    }

    public void Y1(Drawable drawable) {
        Drawable P0 = P0();
        if (P0 != drawable) {
            float o0 = o0();
            this.Q = drawable != null ? androidx.core.graphics.drawable.a.r(drawable).mutate() : null;
            if (d.a.a.a.x.b.a) {
                N2();
            }
            float o02 = o0();
            L2(P0);
            if (K2()) {
                i0(this.Q);
            }
            invalidateSelf();
            if (o0 != o02) {
                r1();
            }
        }
    }

    public float Z0() {
        return this.d0;
    }

    public void Z1(CharSequence charSequence) {
        if (this.U != charSequence) {
            this.U = c.f.j.a.c().h(charSequence);
            invalidateSelf();
        }
    }

    @Override // com.google.android.material.internal.h.b
    public void a() {
        r1();
        invalidateSelf();
    }

    public float a1() {
        return this.c0;
    }

    public void a2(float f) {
        if (this.h0 != f) {
            this.h0 = f;
            invalidateSelf();
            if (K2()) {
                r1();
            }
        }
    }

    public ColorStateList b1() {
        return this.I;
    }

    public void b2(int i) {
        a2(this.j0.getResources().getDimension(i));
    }

    public d.a.a.a.l.h c1() {
        return this.Z;
    }

    public void c2(int i) {
        Y1(c.a.k.a.a.d(this.j0, i));
    }

    public CharSequence d1() {
        return this.J;
    }

    public void d2(float f) {
        if (this.T != f) {
            this.T = f;
            invalidateSelf();
            if (K2()) {
                r1();
            }
        }
    }

    @Override // d.a.a.a.z.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.isEmpty() || getAlpha() == 0) {
            return;
        }
        int i = this.z0;
        int a = i < 255 ? d.a.a.a.m.a.a(canvas, bounds.left, bounds.top, bounds.right, bounds.bottom, i) : 0;
        y0(canvas, bounds);
        v0(canvas, bounds);
        if (this.L0) {
            super.draw(canvas);
        }
        x0(canvas, bounds);
        A0(canvas, bounds);
        w0(canvas, bounds);
        u0(canvas, bounds);
        if (this.J0) {
            C0(canvas, bounds);
        }
        z0(canvas, bounds);
        B0(canvas, bounds);
        if (this.z0 < 255) {
            canvas.restoreToCount(a);
        }
    }

    public d e1() {
        return this.q0.d();
    }

    public void e2(int i) {
        d2(this.j0.getResources().getDimension(i));
    }

    public float f1() {
        return this.f0;
    }

    public void f2(float f) {
        if (this.g0 != f) {
            this.g0 = f;
            invalidateSelf();
            if (K2()) {
                r1();
            }
        }
    }

    public float g1() {
        return this.e0;
    }

    public void g2(int i) {
        f2(this.j0.getResources().getDimension(i));
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.z0;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.A0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.E;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.b0 + k0() + this.e0 + this.q0.f(d1().toString()) + this.f0 + o0() + this.i0), this.K0);
    }

    @Override // d.a.a.a.z.g, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // d.a.a.a.z.g, android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.L0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.F);
        } else {
            outline.setRoundRect(bounds, this.F);
        }
        outline.setAlpha(getAlpha() / 255.0f);
    }

    public boolean h2(int[] iArr) {
        if (Arrays.equals(this.E0, iArr)) {
            return false;
        }
        this.E0 = iArr;
        if (K2()) {
            return s1(getState(), iArr);
        }
        return false;
    }

    public boolean i1() {
        return this.F0;
    }

    public void i2(ColorStateList colorStateList) {
        if (this.S != colorStateList) {
            this.S = colorStateList;
            if (K2()) {
                androidx.core.graphics.drawable.a.o(this.Q, colorStateList);
            }
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // d.a.a.a.z.g, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return n1(this.C) || n1(this.D) || n1(this.G) || (this.F0 && n1(this.G0)) || p1(this.q0.d()) || s0() || o1(this.L) || o1(this.X) || n1(this.C0);
    }

    public void j2(int i) {
        i2(c.a.k.a.a.c(this.j0, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float k0() {
        if (J2() || I2()) {
            return this.c0 + this.N + this.d0;
        }
        return 0.0f;
    }

    public boolean k1() {
        return this.V;
    }

    public void k2(boolean z) {
        if (this.P != z) {
            boolean K2 = K2();
            this.P = z;
            boolean K22 = K2();
            if (K2 != K22) {
                if (K22) {
                    i0(this.Q);
                } else {
                    L2(this.Q);
                }
                invalidateSelf();
                r1();
            }
        }
    }

    public boolean l1() {
        return o1(this.Q);
    }

    public void l2(InterfaceC0069a interfaceC0069a) {
        this.H0 = new WeakReference<>(interfaceC0069a);
    }

    public boolean m1() {
        return this.P;
    }

    public void m2(TextUtils.TruncateAt truncateAt) {
        this.I0 = truncateAt;
    }

    public void n2(d.a.a.a.l.h hVar) {
        this.a0 = hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float o0() {
        if (K2()) {
            return this.g0 + this.T + this.h0;
        }
        return 0.0f;
    }

    public void o2(int i) {
        n2(d.a.a.a.l.h.c(this.j0, i));
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i);
        if (J2()) {
            onLayoutDirectionChanged |= androidx.core.graphics.drawable.a.m(this.L, i);
        }
        if (I2()) {
            onLayoutDirectionChanged |= androidx.core.graphics.drawable.a.m(this.X, i);
        }
        if (K2()) {
            onLayoutDirectionChanged |= androidx.core.graphics.drawable.a.m(this.Q, i);
        }
        if (!onLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        boolean onLevelChange = super.onLevelChange(i);
        if (J2()) {
            onLevelChange |= this.L.setLevel(i);
        }
        if (I2()) {
            onLevelChange |= this.X.setLevel(i);
        }
        if (K2()) {
            onLevelChange |= this.Q.setLevel(i);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    @Override // d.a.a.a.z.g, android.graphics.drawable.Drawable, com.google.android.material.internal.h.b
    public boolean onStateChange(int[] iArr) {
        if (this.L0) {
            super.onStateChange(iArr);
        }
        return s1(iArr, U0());
    }

    public void p2(float f) {
        if (this.d0 != f) {
            float k0 = k0();
            this.d0 = f;
            float k02 = k0();
            invalidateSelf();
            if (k0 != k02) {
                r1();
            }
        }
    }

    public void q2(int i) {
        p2(this.j0.getResources().getDimension(i));
    }

    Paint.Align r0(Rect rect, PointF pointF) {
        pointF.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.J != null) {
            float k0 = this.b0 + k0() + this.e0;
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                pointF.x = rect.left + k0;
                align = Paint.Align.LEFT;
            } else {
                pointF.x = rect.right - k0;
                align = Paint.Align.RIGHT;
            }
            pointF.y = rect.centerY() - q0();
        }
        return align;
    }

    protected void r1() {
        InterfaceC0069a interfaceC0069a = this.H0.get();
        if (interfaceC0069a != null) {
            interfaceC0069a.a();
        }
    }

    public void r2(float f) {
        if (this.c0 != f) {
            float k0 = k0();
            this.c0 = f;
            float k02 = k0();
            invalidateSelf();
            if (k0 != k02) {
                r1();
            }
        }
    }

    public void s2(int i) {
        r2(this.j0.getResources().getDimension(i));
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    @Override // d.a.a.a.z.g, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.z0 != i) {
            this.z0 = i;
            invalidateSelf();
        }
    }

    @Override // d.a.a.a.z.g, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.A0 != colorFilter) {
            this.A0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // d.a.a.a.z.g, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        if (this.C0 != colorStateList) {
            this.C0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // d.a.a.a.z.g, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.D0 != mode) {
            this.D0 = mode;
            this.B0 = d.a.a.a.r.a.a(this, this.C0, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (J2()) {
            visible |= this.L.setVisible(z, z2);
        }
        if (I2()) {
            visible |= this.X.setVisible(z, z2);
        }
        if (K2()) {
            visible |= this.Q.setVisible(z, z2);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public void t1(boolean z) {
        if (this.V != z) {
            this.V = z;
            float k0 = k0();
            if (!z && this.x0) {
                this.x0 = false;
            }
            float k02 = k0();
            invalidateSelf();
            if (k0 != k02) {
                r1();
            }
        }
    }

    public void t2(int i) {
        this.K0 = i;
    }

    public void u1(int i) {
        t1(this.j0.getResources().getBoolean(i));
    }

    public void u2(ColorStateList colorStateList) {
        if (this.I != colorStateList) {
            this.I = colorStateList;
            M2();
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public void v1(Drawable drawable) {
        if (this.X != drawable) {
            float k0 = k0();
            this.X = drawable;
            float k02 = k0();
            L2(this.X);
            i0(this.X);
            invalidateSelf();
            if (k0 != k02) {
                r1();
            }
        }
    }

    public void v2(int i) {
        u2(c.a.k.a.a.c(this.j0, i));
    }

    public void w1(int i) {
        v1(c.a.k.a.a.d(this.j0, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w2(boolean z) {
        this.J0 = z;
    }

    public void x1(ColorStateList colorStateList) {
        if (this.Y != colorStateList) {
            this.Y = colorStateList;
            if (s0()) {
                androidx.core.graphics.drawable.a.o(this.X, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void x2(d.a.a.a.l.h hVar) {
        this.Z = hVar;
    }

    public void y1(int i) {
        x1(c.a.k.a.a.c(this.j0, i));
    }

    public void y2(int i) {
        x2(d.a.a.a.l.h.c(this.j0, i));
    }

    public void z1(int i) {
        A1(this.j0.getResources().getBoolean(i));
    }

    public void z2(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (TextUtils.equals(this.J, charSequence)) {
            return;
        }
        this.J = charSequence;
        this.q0.i(true);
        invalidateSelf();
        r1();
    }
}
