package d.a.a.a.z;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import d.a.a.a.z.k;
import d.a.a.a.z.l;
import d.a.a.a.z.m;
import java.util.BitSet;

/* loaded from: classes.dex */
public class g extends Drawable implements androidx.core.graphics.drawable.b, n {
    private static final String A = g.class.getSimpleName();
    private static final Paint B = new Paint(1);

    /* renamed from: e, reason: collision with root package name */
    private c f1317e;
    private final m.g[] f;
    private final m.g[] g;
    private final BitSet h;
    private boolean i;
    private final Matrix j;
    private final Path k;
    private final Path l;
    private final RectF m;
    private final RectF n;
    private final Region o;
    private final Region p;
    private k q;
    private final Paint r;
    private final Paint s;
    private final d.a.a.a.y.a t;
    private final l.a u;
    private final l v;
    private PorterDuffColorFilter w;
    private PorterDuffColorFilter x;
    private final RectF y;
    private boolean z;

    /* loaded from: classes.dex */
    class a implements l.a {
        a() {
        }

        @Override // d.a.a.a.z.l.a
        public void a(m mVar, Matrix matrix, int i) {
            g.this.h.set(i + 4, mVar.e());
            g.this.g[i] = mVar.f(matrix);
        }

        @Override // d.a.a.a.z.l.a
        public void b(m mVar, Matrix matrix, int i) {
            g.this.h.set(i, mVar.e());
            g.this.f[i] = mVar.f(matrix);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements k.c {
        final /* synthetic */ float a;

        b(g gVar, float f) {
            this.a = f;
        }

        @Override // d.a.a.a.z.k.c
        public d.a.a.a.z.c a(d.a.a.a.z.c cVar) {
            return cVar instanceof i ? cVar : new d.a.a.a.z.b(this.a, cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class c extends Drawable.ConstantState {
        public k a;

        /* renamed from: b, reason: collision with root package name */
        public d.a.a.a.s.a f1318b;

        /* renamed from: c, reason: collision with root package name */
        public ColorFilter f1319c;

        /* renamed from: d, reason: collision with root package name */
        public ColorStateList f1320d;

        /* renamed from: e, reason: collision with root package name */
        public ColorStateList f1321e;
        public ColorStateList f;
        public ColorStateList g;
        public PorterDuff.Mode h;
        public Rect i;
        public float j;
        public float k;
        public float l;
        public int m;
        public float n;
        public float o;
        public float p;
        public int q;
        public int r;
        public int s;
        public int t;
        public boolean u;
        public Paint.Style v;

        public c(c cVar) {
            this.f1320d = null;
            this.f1321e = null;
            this.f = null;
            this.g = null;
            this.h = PorterDuff.Mode.SRC_IN;
            this.i = null;
            this.j = 1.0f;
            this.k = 1.0f;
            this.m = 255;
            this.n = 0.0f;
            this.o = 0.0f;
            this.p = 0.0f;
            this.q = 0;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = false;
            this.v = Paint.Style.FILL_AND_STROKE;
            this.a = cVar.a;
            this.f1318b = cVar.f1318b;
            this.l = cVar.l;
            this.f1319c = cVar.f1319c;
            this.f1320d = cVar.f1320d;
            this.f1321e = cVar.f1321e;
            this.h = cVar.h;
            this.g = cVar.g;
            this.m = cVar.m;
            this.j = cVar.j;
            this.s = cVar.s;
            this.q = cVar.q;
            this.u = cVar.u;
            this.k = cVar.k;
            this.n = cVar.n;
            this.o = cVar.o;
            this.p = cVar.p;
            this.r = cVar.r;
            this.t = cVar.t;
            this.f = cVar.f;
            this.v = cVar.v;
            if (cVar.i != null) {
                this.i = new Rect(cVar.i);
            }
        }

        public c(k kVar, d.a.a.a.s.a aVar) {
            this.f1320d = null;
            this.f1321e = null;
            this.f = null;
            this.g = null;
            this.h = PorterDuff.Mode.SRC_IN;
            this.i = null;
            this.j = 1.0f;
            this.k = 1.0f;
            this.m = 255;
            this.n = 0.0f;
            this.o = 0.0f;
            this.p = 0.0f;
            this.q = 0;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = false;
            this.v = Paint.Style.FILL_AND_STROKE;
            this.a = kVar;
            this.f1318b = aVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            g gVar = new g(this, null);
            gVar.i = true;
            return gVar;
        }
    }

    public g() {
        this(new k());
    }

    public g(Context context, AttributeSet attributeSet, int i, int i2) {
        this(k.e(context, attributeSet, i, i2).m());
    }

    private g(c cVar) {
        this.f = new m.g[4];
        this.g = new m.g[4];
        this.h = new BitSet(8);
        this.j = new Matrix();
        this.k = new Path();
        this.l = new Path();
        this.m = new RectF();
        this.n = new RectF();
        this.o = new Region();
        this.p = new Region();
        this.r = new Paint(1);
        this.s = new Paint(1);
        this.t = new d.a.a.a.y.a();
        this.v = new l();
        this.y = new RectF();
        this.z = true;
        this.f1317e = cVar;
        this.s.setStyle(Paint.Style.STROKE);
        this.r.setStyle(Paint.Style.FILL);
        B.setColor(-1);
        B.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        g0();
        f0(getState());
        this.u = new a();
    }

    /* synthetic */ g(c cVar, a aVar) {
        this(cVar);
    }

    public g(k kVar) {
        this(new c(kVar, null));
    }

    private float D() {
        if (L()) {
            return this.s.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    private boolean J() {
        c cVar = this.f1317e;
        int i = cVar.q;
        return i != 1 && cVar.r > 0 && (i == 2 || T());
    }

    private boolean K() {
        Paint.Style style = this.f1317e.v;
        return style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL;
    }

    private boolean L() {
        Paint.Style style = this.f1317e.v;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.s.getStrokeWidth() > 0.0f;
    }

    private void N() {
        super.invalidateSelf();
    }

    private void Q(Canvas canvas) {
        if (J()) {
            canvas.save();
            S(canvas);
            if (this.z) {
                int width = (int) (this.y.width() - getBounds().width());
                int height = (int) (this.y.height() - getBounds().height());
                if (width < 0 || height < 0) {
                    throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
                }
                Bitmap createBitmap = Bitmap.createBitmap(((int) this.y.width()) + (this.f1317e.r * 2) + width, ((int) this.y.height()) + (this.f1317e.r * 2) + height, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap);
                float f = (getBounds().left - this.f1317e.r) - width;
                float f2 = (getBounds().top - this.f1317e.r) - height;
                canvas2.translate(-f, -f2);
                n(canvas2);
                canvas.drawBitmap(createBitmap, f, f2, (Paint) null);
                createBitmap.recycle();
            } else {
                n(canvas);
            }
            canvas.restore();
        }
    }

    private static int R(int i, int i2) {
        return (i * (i2 + (i2 >>> 7))) >>> 8;
    }

    private void S(Canvas canvas) {
        int z = z();
        int A2 = A();
        if (Build.VERSION.SDK_INT < 21 && this.z) {
            Rect clipBounds = canvas.getClipBounds();
            int i = this.f1317e.r;
            clipBounds.inset(-i, -i);
            clipBounds.offset(z, A2);
            canvas.clipRect(clipBounds, Region.Op.REPLACE);
        }
        canvas.translate(z, A2);
    }

    private PorterDuffColorFilter f(Paint paint, boolean z) {
        int color;
        int l;
        if (!z || (l = l((color = paint.getColor()))) == color) {
            return null;
        }
        return new PorterDuffColorFilter(l, PorterDuff.Mode.SRC_IN);
    }

    private boolean f0(int[] iArr) {
        boolean z;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.f1317e.f1320d == null || color2 == (colorForState2 = this.f1317e.f1320d.getColorForState(iArr, (color2 = this.r.getColor())))) {
            z = false;
        } else {
            this.r.setColor(colorForState2);
            z = true;
        }
        if (this.f1317e.f1321e == null || color == (colorForState = this.f1317e.f1321e.getColorForState(iArr, (color = this.s.getColor())))) {
            return z;
        }
        this.s.setColor(colorForState);
        return true;
    }

    private void g(RectF rectF, Path path) {
        h(rectF, path);
        if (this.f1317e.j != 1.0f) {
            this.j.reset();
            Matrix matrix = this.j;
            float f = this.f1317e.j;
            matrix.setScale(f, f, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.j);
        }
        path.computeBounds(this.y, true);
    }

    private boolean g0() {
        PorterDuffColorFilter porterDuffColorFilter = this.w;
        PorterDuffColorFilter porterDuffColorFilter2 = this.x;
        c cVar = this.f1317e;
        this.w = k(cVar.g, cVar.h, this.r, true);
        c cVar2 = this.f1317e;
        this.x = k(cVar2.f, cVar2.h, this.s, false);
        c cVar3 = this.f1317e;
        if (cVar3.u) {
            this.t.d(cVar3.g.getColorForState(getState(), 0));
        }
        return (c.f.k.c.a(porterDuffColorFilter, this.w) && c.f.k.c.a(porterDuffColorFilter2, this.x)) ? false : true;
    }

    private void h0() {
        float I = I();
        this.f1317e.r = (int) Math.ceil(0.75f * I);
        this.f1317e.s = (int) Math.ceil(I * 0.25f);
        g0();
        N();
    }

    private void i() {
        k x = C().x(new b(this, -D()));
        this.q = x;
        this.v.d(x, this.f1317e.k, v(), this.l);
    }

    private PorterDuffColorFilter j(ColorStateList colorStateList, PorterDuff.Mode mode, boolean z) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z) {
            colorForState = l(colorForState);
        }
        return new PorterDuffColorFilter(colorForState, mode);
    }

    private PorterDuffColorFilter k(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean z) {
        return (colorStateList == null || mode == null) ? f(paint, z) : j(colorStateList, mode, z);
    }

    private int l(int i) {
        float I = I() + y();
        d.a.a.a.s.a aVar = this.f1317e.f1318b;
        return aVar != null ? aVar.c(i, I) : i;
    }

    public static g m(Context context, float f) {
        int b2 = d.a.a.a.q.a.b(context, d.a.a.a.b.colorSurface, g.class.getSimpleName());
        g gVar = new g();
        gVar.M(context);
        gVar.V(ColorStateList.valueOf(b2));
        gVar.U(f);
        return gVar;
    }

    private void n(Canvas canvas) {
        if (this.h.cardinality() > 0) {
            Log.w(A, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.f1317e.s != 0) {
            canvas.drawPath(this.k, this.t.c());
        }
        for (int i = 0; i < 4; i++) {
            this.f[i].b(this.t, this.f1317e.r, canvas);
            this.g[i].b(this.t, this.f1317e.r, canvas);
        }
        if (this.z) {
            int z = z();
            int A2 = A();
            canvas.translate(-z, -A2);
            canvas.drawPath(this.k, B);
            canvas.translate(z, A2);
        }
    }

    private void o(Canvas canvas) {
        q(canvas, this.r, this.k, this.f1317e.a, u());
    }

    private void q(Canvas canvas, Paint paint, Path path, k kVar, RectF rectF) {
        if (!kVar.u(rectF)) {
            canvas.drawPath(path, paint);
        } else {
            float a2 = kVar.t().a(rectF) * this.f1317e.k;
            canvas.drawRoundRect(rectF, a2, a2, paint);
        }
    }

    private void r(Canvas canvas) {
        q(canvas, this.s, this.l, this.q, v());
    }

    private RectF v() {
        this.n.set(u());
        float D = D();
        this.n.inset(D, D);
        return this.n;
    }

    public int A() {
        c cVar = this.f1317e;
        return (int) (cVar.s * Math.cos(Math.toRadians(cVar.t)));
    }

    public int B() {
        return this.f1317e.r;
    }

    public k C() {
        return this.f1317e.a;
    }

    public ColorStateList E() {
        return this.f1317e.g;
    }

    public float F() {
        return this.f1317e.a.r().a(u());
    }

    public float G() {
        return this.f1317e.a.t().a(u());
    }

    public float H() {
        return this.f1317e.p;
    }

    public float I() {
        return w() + H();
    }

    public void M(Context context) {
        this.f1317e.f1318b = new d.a.a.a.s.a(context);
        h0();
    }

    public boolean O() {
        d.a.a.a.s.a aVar = this.f1317e.f1318b;
        return aVar != null && aVar.d();
    }

    public boolean P() {
        return this.f1317e.a.u(u());
    }

    public boolean T() {
        return Build.VERSION.SDK_INT < 21 || !(P() || this.k.isConvex() || Build.VERSION.SDK_INT >= 29);
    }

    public void U(float f) {
        c cVar = this.f1317e;
        if (cVar.o != f) {
            cVar.o = f;
            h0();
        }
    }

    public void V(ColorStateList colorStateList) {
        c cVar = this.f1317e;
        if (cVar.f1320d != colorStateList) {
            cVar.f1320d = colorStateList;
            onStateChange(getState());
        }
    }

    public void W(float f) {
        c cVar = this.f1317e;
        if (cVar.k != f) {
            cVar.k = f;
            this.i = true;
            invalidateSelf();
        }
    }

    public void X(int i, int i2, int i3, int i4) {
        c cVar = this.f1317e;
        if (cVar.i == null) {
            cVar.i = new Rect();
        }
        this.f1317e.i.set(i, i2, i3, i4);
        invalidateSelf();
    }

    public void Y(float f) {
        c cVar = this.f1317e;
        if (cVar.n != f) {
            cVar.n = f;
            h0();
        }
    }

    public void Z(int i) {
        this.t.d(i);
        this.f1317e.u = false;
        N();
    }

    public void a0(int i) {
        c cVar = this.f1317e;
        if (cVar.t != i) {
            cVar.t = i;
            N();
        }
    }

    public void b0(float f, int i) {
        e0(f);
        d0(ColorStateList.valueOf(i));
    }

    public void c0(float f, ColorStateList colorStateList) {
        e0(f);
        d0(colorStateList);
    }

    public void d0(ColorStateList colorStateList) {
        c cVar = this.f1317e;
        if (cVar.f1321e != colorStateList) {
            cVar.f1321e = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.r.setColorFilter(this.w);
        int alpha = this.r.getAlpha();
        this.r.setAlpha(R(alpha, this.f1317e.m));
        this.s.setColorFilter(this.x);
        this.s.setStrokeWidth(this.f1317e.l);
        int alpha2 = this.s.getAlpha();
        this.s.setAlpha(R(alpha2, this.f1317e.m));
        if (this.i) {
            i();
            g(u(), this.k);
            this.i = false;
        }
        Q(canvas);
        if (K()) {
            o(canvas);
        }
        if (L()) {
            r(canvas);
        }
        this.r.setAlpha(alpha);
        this.s.setAlpha(alpha2);
    }

    public void e0(float f) {
        this.f1317e.l = f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f1317e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.f1317e.q == 2) {
            return;
        }
        if (P()) {
            outline.setRoundRect(getBounds(), F() * this.f1317e.k);
            return;
        }
        g(u(), this.k);
        if (this.k.isConvex() || Build.VERSION.SDK_INT >= 29) {
            try {
                outline.setConvexPath(this.k);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        Rect rect2 = this.f1317e.i;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.o.set(getBounds());
        g(u(), this.k);
        this.p.setPath(this.k, this.o);
        this.o.op(this.p, Region.Op.DIFFERENCE);
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h(RectF rectF, Path path) {
        l lVar = this.v;
        c cVar = this.f1317e;
        lVar.e(cVar.a, cVar.k, rectF, this.u, path);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.i = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.f1317e.g) != null && colorStateList.isStateful()) || (((colorStateList2 = this.f1317e.f) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.f1317e.f1321e) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.f1317e.f1320d) != null && colorStateList4.isStateful())));
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f1317e = new c(this.f1317e);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.i = true;
        super.onBoundsChange(rect);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.h.b
    public boolean onStateChange(int[] iArr) {
        boolean z = f0(iArr) || g0();
        if (z) {
            invalidateSelf();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(Canvas canvas, Paint paint, Path path, RectF rectF) {
        q(canvas, paint, path, this.f1317e.a, rectF);
    }

    public float s() {
        return this.f1317e.a.j().a(u());
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        c cVar = this.f1317e;
        if (cVar.m != i) {
            cVar.m = i;
            N();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1317e.f1319c = colorFilter;
        N();
    }

    @Override // d.a.a.a.z.n
    public void setShapeAppearanceModel(k kVar) {
        this.f1317e.a = kVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        this.f1317e.g = colorStateList;
        g0();
        N();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        c cVar = this.f1317e;
        if (cVar.h != mode) {
            cVar.h = mode;
            g0();
            N();
        }
    }

    public float t() {
        return this.f1317e.a.l().a(u());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RectF u() {
        this.m.set(getBounds());
        return this.m;
    }

    public float w() {
        return this.f1317e.o;
    }

    public ColorStateList x() {
        return this.f1317e.f1320d;
    }

    public float y() {
        return this.f1317e.n;
    }

    public int z() {
        c cVar = this.f1317e;
        return (int) (cVar.s * Math.sin(Math.toRadians(cVar.t)));
    }
}
