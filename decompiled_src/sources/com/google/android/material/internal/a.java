package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import c.f.l.s;
import com.google.android.material.internal.g;
import d.a.a.a.w.a;

/* loaded from: classes.dex */
public final class a {
    private static final boolean Z;
    private static final Paint a0;
    private boolean A;
    private Bitmap B;
    private Paint C;
    private float D;
    private float E;
    private int[] F;
    private boolean G;
    private TimeInterpolator J;
    private TimeInterpolator K;
    private float L;
    private float M;
    private float N;
    private ColorStateList O;
    private float P;
    private float Q;
    private float R;
    private ColorStateList S;
    private StaticLayout T;
    private float U;
    private float V;
    private float W;
    private CharSequence X;
    private final View a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f1144b;

    /* renamed from: c, reason: collision with root package name */
    private float f1145c;
    private ColorStateList k;
    private ColorStateList l;
    private float m;
    private float n;
    private float o;
    private float p;
    private float q;
    private float r;
    private Typeface s;
    private Typeface t;
    private Typeface u;
    private d.a.a.a.w.a v;
    private d.a.a.a.w.a w;
    private CharSequence x;
    private CharSequence y;
    private boolean z;
    private int g = 16;
    private int h = 16;
    private float i = 15.0f;
    private float j = 15.0f;
    private int Y = 1;
    private final TextPaint H = new TextPaint(129);
    private final TextPaint I = new TextPaint(this.H);

    /* renamed from: e, reason: collision with root package name */
    private final Rect f1147e = new Rect();

    /* renamed from: d, reason: collision with root package name */
    private final Rect f1146d = new Rect();
    private final RectF f = new RectF();

    /* renamed from: com.google.android.material.internal.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0074a implements a.InterfaceC0089a {
        C0074a() {
        }

        @Override // d.a.a.a.w.a.InterfaceC0089a
        public void a(Typeface typeface) {
            a.this.M(typeface);
        }
    }

    static {
        Z = Build.VERSION.SDK_INT < 18;
        Paint paint = null;
        a0 = null;
        if (0 != 0) {
            paint.setAntiAlias(true);
            a0.setColor(-65281);
        }
    }

    public a(View view) {
        this.a = view;
    }

    private boolean A() {
        return s.y(this.a) == 1;
    }

    private static float C(float f, float f2, float f3, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f3 = timeInterpolator.getInterpolation(f3);
        }
        return d.a.a.a.l.a.a(f, f2, f3);
    }

    private static boolean F(Rect rect, int i, int i2, int i3, int i4) {
        return rect.left == i && rect.top == i2 && rect.right == i3 && rect.bottom == i4;
    }

    private void J(float f) {
        this.U = f;
        s.Z(this.a);
    }

    private boolean N(Typeface typeface) {
        d.a.a.a.w.a aVar = this.w;
        if (aVar != null) {
            aVar.c();
        }
        if (this.s == typeface) {
            return false;
        }
        this.s = typeface;
        return true;
    }

    private void Q(float f) {
        this.V = f;
        s.Z(this.a);
    }

    private boolean U(Typeface typeface) {
        d.a.a.a.w.a aVar = this.v;
        if (aVar != null) {
            aVar.c();
        }
        if (this.t == typeface) {
            return false;
        }
        this.t = typeface;
        return true;
    }

    private void W(float f) {
        g(f);
        boolean z = Z && this.D != 1.0f;
        this.A = z;
        if (z) {
            l();
        }
        s.Z(this.a);
    }

    private static int a(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((Color.alpha(i) * f2) + (Color.alpha(i2) * f)), (int) ((Color.red(i) * f2) + (Color.red(i2) * f)), (int) ((Color.green(i) * f2) + (Color.green(i2) * f)), (int) ((Color.blue(i) * f2) + (Color.blue(i2) * f)));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b() {
        /*
            Method dump skipped, instructions count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.internal.a.b():void");
    }

    private boolean c0() {
        return (this.Y <= 1 || this.z || this.A) ? false : true;
    }

    private void d() {
        f(this.f1145c);
    }

    private boolean e(CharSequence charSequence) {
        return (A() ? c.f.j.e.f774d : c.f.j.e.f773c).a(charSequence, 0, charSequence.length());
    }

    private void f(float f) {
        TextPaint textPaint;
        int r;
        y(f);
        this.q = C(this.o, this.p, f, this.J);
        this.r = C(this.m, this.n, f, this.J);
        W(C(this.i, this.j, f, this.K));
        J(1.0f - C(0.0f, 1.0f, 1.0f - f, d.a.a.a.l.a.f1276b));
        Q(C(1.0f, 0.0f, f, d.a.a.a.l.a.f1276b));
        if (this.l != this.k) {
            textPaint = this.H;
            r = a(t(), r(), f);
        } else {
            textPaint = this.H;
            r = r();
        }
        textPaint.setColor(r);
        this.H.setShadowLayer(C(this.P, this.L, f, null), C(this.Q, this.M, f, null), C(this.R, this.N, f, null), a(s(this.S), s(this.O), f));
        s.Z(this.a);
    }

    private void g(float f) {
        boolean z;
        float f2;
        boolean z2;
        if (this.x == null) {
            return;
        }
        float width = this.f1147e.width();
        float width2 = this.f1146d.width();
        if (z(f, this.j)) {
            f2 = this.j;
            this.D = 1.0f;
            Typeface typeface = this.u;
            Typeface typeface2 = this.s;
            if (typeface != typeface2) {
                this.u = typeface2;
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            float f3 = this.i;
            Typeface typeface3 = this.u;
            Typeface typeface4 = this.t;
            if (typeface3 != typeface4) {
                this.u = typeface4;
                z = true;
            } else {
                z = false;
            }
            if (z(f, this.i)) {
                this.D = 1.0f;
            } else {
                this.D = f / this.i;
            }
            float f4 = this.j / this.i;
            width = width2 * f4 > width ? Math.min(width / f4, width2) : width2;
            f2 = f3;
            z2 = z;
        }
        if (width > 0.0f) {
            z2 = this.E != f2 || this.G || z2;
            this.E = f2;
            this.G = false;
        }
        if (this.y == null || z2) {
            this.H.setTextSize(this.E);
            this.H.setTypeface(this.u);
            this.H.setLinearText(this.D != 1.0f);
            this.z = e(this.x);
            StaticLayout i = i(c0() ? this.Y : 1, width, this.z);
            this.T = i;
            this.y = i.getText();
        }
    }

    private void h() {
        Bitmap bitmap = this.B;
        if (bitmap != null) {
            bitmap.recycle();
            this.B = null;
        }
    }

    private StaticLayout i(int i, float f, boolean z) {
        StaticLayout staticLayout;
        try {
            g c2 = g.c(this.x, this.H, (int) f);
            c2.e(TextUtils.TruncateAt.END);
            c2.g(z);
            c2.d(Layout.Alignment.ALIGN_NORMAL);
            c2.f(false);
            c2.h(i);
            staticLayout = c2.a();
        } catch (g.a e2) {
            Log.e("CollapsingTextHelper", e2.getCause().getMessage(), e2);
            staticLayout = null;
        }
        c.f.k.h.c(staticLayout);
        return staticLayout;
    }

    private void k(Canvas canvas, float f, float f2) {
        int alpha = this.H.getAlpha();
        canvas.translate(f, f2);
        float f3 = alpha;
        this.H.setAlpha((int) (this.V * f3));
        this.T.draw(canvas);
        this.H.setAlpha((int) (this.U * f3));
        int lineBaseline = this.T.getLineBaseline(0);
        CharSequence charSequence = this.X;
        float f4 = lineBaseline;
        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f4, this.H);
        String trim = this.X.toString().trim();
        if (trim.endsWith("…")) {
            trim = trim.substring(0, trim.length() - 1);
        }
        String str = trim;
        this.H.setAlpha(alpha);
        canvas.drawText(str, 0, Math.min(this.T.getLineEnd(0), str.length()), 0.0f, f4, (Paint) this.H);
    }

    private void l() {
        if (this.B != null || this.f1146d.isEmpty() || TextUtils.isEmpty(this.y)) {
            return;
        }
        f(0.0f);
        int width = this.T.getWidth();
        int height = this.T.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        this.B = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        this.T.draw(new Canvas(this.B));
        if (this.C == null) {
            this.C = new Paint(3);
        }
    }

    private float p(int i, int i2) {
        return (i2 == 17 || (i2 & 7) == 1) ? (i / 2.0f) - (c() / 2.0f) : ((i2 & 8388613) == 8388613 || (i2 & 5) == 5) ? this.z ? this.f1147e.left : this.f1147e.right - c() : this.z ? this.f1147e.right - c() : this.f1147e.left;
    }

    private float q(RectF rectF, int i, int i2) {
        return (i2 == 17 || (i2 & 7) == 1) ? (i / 2.0f) + (c() / 2.0f) : ((i2 & 8388613) == 8388613 || (i2 & 5) == 5) ? this.z ? rectF.left + c() : this.f1147e.right : this.z ? this.f1147e.right : rectF.left + c();
    }

    private int s(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.F;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    private int t() {
        return s(this.k);
    }

    private void w(TextPaint textPaint) {
        textPaint.setTextSize(this.j);
        textPaint.setTypeface(this.s);
    }

    private void x(TextPaint textPaint) {
        textPaint.setTextSize(this.i);
        textPaint.setTypeface(this.t);
    }

    private void y(float f) {
        this.f.left = C(this.f1146d.left, this.f1147e.left, f, this.J);
        this.f.top = C(this.m, this.n, f, this.J);
        this.f.right = C(this.f1146d.right, this.f1147e.right, f, this.J);
        this.f.bottom = C(this.f1146d.bottom, this.f1147e.bottom, f, this.J);
    }

    private static boolean z(float f, float f2) {
        return Math.abs(f - f2) < 0.001f;
    }

    public final boolean B() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.l;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.k) != null && colorStateList.isStateful());
    }

    void D() {
        this.f1144b = this.f1147e.width() > 0 && this.f1147e.height() > 0 && this.f1146d.width() > 0 && this.f1146d.height() > 0;
    }

    public void E() {
        if (this.a.getHeight() <= 0 || this.a.getWidth() <= 0) {
            return;
        }
        b();
        d();
    }

    public void G(int i, int i2, int i3, int i4) {
        if (F(this.f1147e, i, i2, i3, i4)) {
            return;
        }
        this.f1147e.set(i, i2, i3, i4);
        this.G = true;
        D();
    }

    public void H(Rect rect) {
        G(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void I(int i) {
        d.a.a.a.w.d dVar = new d.a.a.a.w.d(this.a.getContext(), i);
        ColorStateList colorStateList = dVar.f1301b;
        if (colorStateList != null) {
            this.l = colorStateList;
        }
        float f = dVar.a;
        if (f != 0.0f) {
            this.j = f;
        }
        ColorStateList colorStateList2 = dVar.f;
        if (colorStateList2 != null) {
            this.O = colorStateList2;
        }
        this.M = dVar.g;
        this.N = dVar.h;
        this.L = dVar.i;
        d.a.a.a.w.a aVar = this.w;
        if (aVar != null) {
            aVar.c();
        }
        this.w = new d.a.a.a.w.a(new C0074a(), dVar.e());
        dVar.h(this.a.getContext(), this.w);
        E();
    }

    public void K(ColorStateList colorStateList) {
        if (this.l != colorStateList) {
            this.l = colorStateList;
            E();
        }
    }

    public void L(int i) {
        if (this.h != i) {
            this.h = i;
            E();
        }
    }

    public void M(Typeface typeface) {
        if (N(typeface)) {
            E();
        }
    }

    public void O(int i, int i2, int i3, int i4) {
        if (F(this.f1146d, i, i2, i3, i4)) {
            return;
        }
        this.f1146d.set(i, i2, i3, i4);
        this.G = true;
        D();
    }

    public void P(Rect rect) {
        O(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void R(ColorStateList colorStateList) {
        if (this.k != colorStateList) {
            this.k = colorStateList;
            E();
        }
    }

    public void S(int i) {
        if (this.g != i) {
            this.g = i;
            E();
        }
    }

    public void T(float f) {
        if (this.i != f) {
            this.i = f;
            E();
        }
    }

    public void V(float f) {
        float a = c.f.g.a.a(f, 0.0f, 1.0f);
        if (a != this.f1145c) {
            this.f1145c = a;
            d();
        }
    }

    public void X(TimeInterpolator timeInterpolator) {
        this.J = timeInterpolator;
        E();
    }

    public final boolean Y(int[] iArr) {
        this.F = iArr;
        if (!B()) {
            return false;
        }
        E();
        return true;
    }

    public void Z(CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.x, charSequence)) {
            this.x = charSequence;
            this.y = null;
            h();
            E();
        }
    }

    public void a0(TimeInterpolator timeInterpolator) {
        this.K = timeInterpolator;
        E();
    }

    public void b0(Typeface typeface) {
        boolean N = N(typeface);
        boolean U = U(typeface);
        if (N || U) {
            E();
        }
    }

    public float c() {
        if (this.x == null) {
            return 0.0f;
        }
        w(this.I);
        TextPaint textPaint = this.I;
        CharSequence charSequence = this.x;
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    public void j(Canvas canvas) {
        int save = canvas.save();
        if (this.y == null || !this.f1144b) {
            return;
        }
        boolean z = false;
        float lineLeft = (this.q + this.T.getLineLeft(0)) - (this.W * 2.0f);
        this.H.setTextSize(this.E);
        float f = this.q;
        float f2 = this.r;
        if (this.A && this.B != null) {
            z = true;
        }
        float f3 = this.D;
        if (f3 != 1.0f) {
            canvas.scale(f3, f3, f, f2);
        }
        if (z) {
            canvas.drawBitmap(this.B, f, f2, this.C);
            canvas.restoreToCount(save);
            return;
        }
        if (c0()) {
            k(canvas, lineLeft, f2);
        } else {
            canvas.translate(f, f2);
            this.T.draw(canvas);
        }
        canvas.restoreToCount(save);
    }

    public void m(RectF rectF, int i, int i2) {
        this.z = e(this.x);
        rectF.left = p(i, i2);
        rectF.top = this.f1147e.top;
        rectF.right = q(rectF, i, i2);
        rectF.bottom = this.f1147e.top + o();
    }

    public ColorStateList n() {
        return this.l;
    }

    public float o() {
        w(this.I);
        return -this.I.ascent();
    }

    public int r() {
        return s(this.l);
    }

    public float u() {
        x(this.I);
        return -this.I.ascent();
    }

    public float v() {
        return this.f1145c;
    }
}
