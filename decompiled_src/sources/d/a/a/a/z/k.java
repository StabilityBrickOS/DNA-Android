package d.a.a.a.z;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;

/* loaded from: classes.dex */
public class k {
    public static final d.a.a.a.z.c m = new i(0.5f);
    d a;

    /* renamed from: b, reason: collision with root package name */
    d f1322b;

    /* renamed from: c, reason: collision with root package name */
    d f1323c;

    /* renamed from: d, reason: collision with root package name */
    d f1324d;

    /* renamed from: e, reason: collision with root package name */
    d.a.a.a.z.c f1325e;
    d.a.a.a.z.c f;
    d.a.a.a.z.c g;
    d.a.a.a.z.c h;
    f i;
    f j;
    f k;
    f l;

    /* loaded from: classes.dex */
    public static final class b {
        private d a;

        /* renamed from: b, reason: collision with root package name */
        private d f1326b;

        /* renamed from: c, reason: collision with root package name */
        private d f1327c;

        /* renamed from: d, reason: collision with root package name */
        private d f1328d;

        /* renamed from: e, reason: collision with root package name */
        private d.a.a.a.z.c f1329e;
        private d.a.a.a.z.c f;
        private d.a.a.a.z.c g;
        private d.a.a.a.z.c h;
        private f i;
        private f j;
        private f k;
        private f l;

        public b() {
            this.a = h.b();
            this.f1326b = h.b();
            this.f1327c = h.b();
            this.f1328d = h.b();
            this.f1329e = new d.a.a.a.z.a(0.0f);
            this.f = new d.a.a.a.z.a(0.0f);
            this.g = new d.a.a.a.z.a(0.0f);
            this.h = new d.a.a.a.z.a(0.0f);
            this.i = h.c();
            this.j = h.c();
            this.k = h.c();
            this.l = h.c();
        }

        public b(k kVar) {
            this.a = h.b();
            this.f1326b = h.b();
            this.f1327c = h.b();
            this.f1328d = h.b();
            this.f1329e = new d.a.a.a.z.a(0.0f);
            this.f = new d.a.a.a.z.a(0.0f);
            this.g = new d.a.a.a.z.a(0.0f);
            this.h = new d.a.a.a.z.a(0.0f);
            this.i = h.c();
            this.j = h.c();
            this.k = h.c();
            this.l = h.c();
            this.a = kVar.a;
            this.f1326b = kVar.f1322b;
            this.f1327c = kVar.f1323c;
            this.f1328d = kVar.f1324d;
            this.f1329e = kVar.f1325e;
            this.f = kVar.f;
            this.g = kVar.g;
            this.h = kVar.h;
            this.i = kVar.i;
            this.j = kVar.j;
            this.k = kVar.k;
            this.l = kVar.l;
        }

        private static float n(d dVar) {
            if (dVar instanceof j) {
                return ((j) dVar).a;
            }
            if (dVar instanceof e) {
                return ((e) dVar).a;
            }
            return -1.0f;
        }

        public b A(d.a.a.a.z.c cVar) {
            this.f1329e = cVar;
            return this;
        }

        public b B(int i, d.a.a.a.z.c cVar) {
            C(h.a(i));
            E(cVar);
            return this;
        }

        public b C(d dVar) {
            this.f1326b = dVar;
            float n = n(dVar);
            if (n != -1.0f) {
                D(n);
            }
            return this;
        }

        public b D(float f) {
            this.f = new d.a.a.a.z.a(f);
            return this;
        }

        public b E(d.a.a.a.z.c cVar) {
            this.f = cVar;
            return this;
        }

        public k m() {
            return new k(this);
        }

        public b o(float f) {
            z(f);
            D(f);
            v(f);
            r(f);
            return this;
        }

        public b p(int i, d.a.a.a.z.c cVar) {
            q(h.a(i));
            s(cVar);
            return this;
        }

        public b q(d dVar) {
            this.f1328d = dVar;
            float n = n(dVar);
            if (n != -1.0f) {
                r(n);
            }
            return this;
        }

        public b r(float f) {
            this.h = new d.a.a.a.z.a(f);
            return this;
        }

        public b s(d.a.a.a.z.c cVar) {
            this.h = cVar;
            return this;
        }

        public b t(int i, d.a.a.a.z.c cVar) {
            u(h.a(i));
            w(cVar);
            return this;
        }

        public b u(d dVar) {
            this.f1327c = dVar;
            float n = n(dVar);
            if (n != -1.0f) {
                v(n);
            }
            return this;
        }

        public b v(float f) {
            this.g = new d.a.a.a.z.a(f);
            return this;
        }

        public b w(d.a.a.a.z.c cVar) {
            this.g = cVar;
            return this;
        }

        public b x(int i, d.a.a.a.z.c cVar) {
            y(h.a(i));
            A(cVar);
            return this;
        }

        public b y(d dVar) {
            this.a = dVar;
            float n = n(dVar);
            if (n != -1.0f) {
                z(n);
            }
            return this;
        }

        public b z(float f) {
            this.f1329e = new d.a.a.a.z.a(f);
            return this;
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        d.a.a.a.z.c a(d.a.a.a.z.c cVar);
    }

    public k() {
        this.a = h.b();
        this.f1322b = h.b();
        this.f1323c = h.b();
        this.f1324d = h.b();
        this.f1325e = new d.a.a.a.z.a(0.0f);
        this.f = new d.a.a.a.z.a(0.0f);
        this.g = new d.a.a.a.z.a(0.0f);
        this.h = new d.a.a.a.z.a(0.0f);
        this.i = h.c();
        this.j = h.c();
        this.k = h.c();
        this.l = h.c();
    }

    private k(b bVar) {
        this.a = bVar.a;
        this.f1322b = bVar.f1326b;
        this.f1323c = bVar.f1327c;
        this.f1324d = bVar.f1328d;
        this.f1325e = bVar.f1329e;
        this.f = bVar.f;
        this.g = bVar.g;
        this.h = bVar.h;
        this.i = bVar.i;
        this.j = bVar.j;
        this.k = bVar.k;
        this.l = bVar.l;
    }

    public static b a() {
        return new b();
    }

    public static b b(Context context, int i, int i2) {
        return c(context, i, i2, 0);
    }

    private static b c(Context context, int i, int i2, int i3) {
        return d(context, i, i2, new d.a.a.a.z.a(i3));
    }

    private static b d(Context context, int i, int i2, d.a.a.a.z.c cVar) {
        if (i2 != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i);
            i = i2;
            context = contextThemeWrapper;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, d.a.a.a.k.ShapeAppearance);
        try {
            int i3 = obtainStyledAttributes.getInt(d.a.a.a.k.ShapeAppearance_cornerFamily, 0);
            int i4 = obtainStyledAttributes.getInt(d.a.a.a.k.ShapeAppearance_cornerFamilyTopLeft, i3);
            int i5 = obtainStyledAttributes.getInt(d.a.a.a.k.ShapeAppearance_cornerFamilyTopRight, i3);
            int i6 = obtainStyledAttributes.getInt(d.a.a.a.k.ShapeAppearance_cornerFamilyBottomRight, i3);
            int i7 = obtainStyledAttributes.getInt(d.a.a.a.k.ShapeAppearance_cornerFamilyBottomLeft, i3);
            d.a.a.a.z.c m2 = m(obtainStyledAttributes, d.a.a.a.k.ShapeAppearance_cornerSize, cVar);
            d.a.a.a.z.c m3 = m(obtainStyledAttributes, d.a.a.a.k.ShapeAppearance_cornerSizeTopLeft, m2);
            d.a.a.a.z.c m4 = m(obtainStyledAttributes, d.a.a.a.k.ShapeAppearance_cornerSizeTopRight, m2);
            d.a.a.a.z.c m5 = m(obtainStyledAttributes, d.a.a.a.k.ShapeAppearance_cornerSizeBottomRight, m2);
            d.a.a.a.z.c m6 = m(obtainStyledAttributes, d.a.a.a.k.ShapeAppearance_cornerSizeBottomLeft, m2);
            b bVar = new b();
            bVar.x(i4, m3);
            bVar.B(i5, m4);
            bVar.t(i6, m5);
            bVar.p(i7, m6);
            return bVar;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static b e(Context context, AttributeSet attributeSet, int i, int i2) {
        return f(context, attributeSet, i, i2, 0);
    }

    public static b f(Context context, AttributeSet attributeSet, int i, int i2, int i3) {
        return g(context, attributeSet, i, i2, new d.a.a.a.z.a(i3));
    }

    public static b g(Context context, AttributeSet attributeSet, int i, int i2, d.a.a.a.z.c cVar) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.a.a.a.k.MaterialShape, i, i2);
        int resourceId = obtainStyledAttributes.getResourceId(d.a.a.a.k.MaterialShape_shapeAppearance, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(d.a.a.a.k.MaterialShape_shapeAppearanceOverlay, 0);
        obtainStyledAttributes.recycle();
        return d(context, resourceId, resourceId2, cVar);
    }

    private static d.a.a.a.z.c m(TypedArray typedArray, int i, d.a.a.a.z.c cVar) {
        TypedValue peekValue = typedArray.peekValue(i);
        if (peekValue == null) {
            return cVar;
        }
        int i2 = peekValue.type;
        return i2 == 5 ? new d.a.a.a.z.a(TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics())) : i2 == 6 ? new i(peekValue.getFraction(1.0f, 1.0f)) : cVar;
    }

    public f h() {
        return this.k;
    }

    public d i() {
        return this.f1324d;
    }

    public d.a.a.a.z.c j() {
        return this.h;
    }

    public d k() {
        return this.f1323c;
    }

    public d.a.a.a.z.c l() {
        return this.g;
    }

    public f n() {
        return this.l;
    }

    public f o() {
        return this.j;
    }

    public f p() {
        return this.i;
    }

    public d q() {
        return this.a;
    }

    public d.a.a.a.z.c r() {
        return this.f1325e;
    }

    public d s() {
        return this.f1322b;
    }

    public d.a.a.a.z.c t() {
        return this.f;
    }

    public boolean u(RectF rectF) {
        boolean z = this.l.getClass().equals(f.class) && this.j.getClass().equals(f.class) && this.i.getClass().equals(f.class) && this.k.getClass().equals(f.class);
        float a2 = this.f1325e.a(rectF);
        return z && ((this.f.a(rectF) > a2 ? 1 : (this.f.a(rectF) == a2 ? 0 : -1)) == 0 && (this.h.a(rectF) > a2 ? 1 : (this.h.a(rectF) == a2 ? 0 : -1)) == 0 && (this.g.a(rectF) > a2 ? 1 : (this.g.a(rectF) == a2 ? 0 : -1)) == 0) && ((this.f1322b instanceof j) && (this.a instanceof j) && (this.f1323c instanceof j) && (this.f1324d instanceof j));
    }

    public b v() {
        return new b(this);
    }

    public k w(float f) {
        b v = v();
        v.o(f);
        return v.m();
    }

    public k x(c cVar) {
        b v = v();
        v.A(cVar.a(r()));
        v.E(cVar.a(t()));
        v.s(cVar.a(j()));
        v.w(cVar.a(l()));
        return v.m();
    }
}
