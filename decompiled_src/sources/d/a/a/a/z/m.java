package d.a.a.a.z;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class m {

    @Deprecated
    public float a;

    /* renamed from: b, reason: collision with root package name */
    @Deprecated
    public float f1338b;

    /* renamed from: c, reason: collision with root package name */
    @Deprecated
    public float f1339c;

    /* renamed from: d, reason: collision with root package name */
    @Deprecated
    public float f1340d;

    /* renamed from: e, reason: collision with root package name */
    @Deprecated
    public float f1341e;

    @Deprecated
    public float f;
    private final List<f> g = new ArrayList();
    private final List<g> h = new ArrayList();
    private boolean i;

    /* loaded from: classes.dex */
    class a extends g {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f1342b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Matrix f1343c;

        a(m mVar, List list, Matrix matrix) {
            this.f1342b = list;
            this.f1343c = matrix;
        }

        @Override // d.a.a.a.z.m.g
        public void a(Matrix matrix, d.a.a.a.y.a aVar, int i, Canvas canvas) {
            Iterator it = this.f1342b.iterator();
            while (it.hasNext()) {
                ((g) it.next()).a(this.f1343c, aVar, i, canvas);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b extends g {

        /* renamed from: b, reason: collision with root package name */
        private final d f1344b;

        public b(d dVar) {
            this.f1344b = dVar;
        }

        @Override // d.a.a.a.z.m.g
        public void a(Matrix matrix, d.a.a.a.y.a aVar, int i, Canvas canvas) {
            aVar.a(canvas, matrix, new RectF(this.f1344b.k(), this.f1344b.o(), this.f1344b.l(), this.f1344b.j()), i, this.f1344b.m(), this.f1344b.n());
        }
    }

    /* loaded from: classes.dex */
    static class c extends g {

        /* renamed from: b, reason: collision with root package name */
        private final e f1345b;

        /* renamed from: c, reason: collision with root package name */
        private final float f1346c;

        /* renamed from: d, reason: collision with root package name */
        private final float f1347d;

        public c(e eVar, float f, float f2) {
            this.f1345b = eVar;
            this.f1346c = f;
            this.f1347d = f2;
        }

        @Override // d.a.a.a.z.m.g
        public void a(Matrix matrix, d.a.a.a.y.a aVar, int i, Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(this.f1345b.f1353c - this.f1347d, this.f1345b.f1352b - this.f1346c), 0.0f);
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(this.f1346c, this.f1347d);
            matrix2.preRotate(c());
            aVar.b(canvas, matrix2, rectF, i);
        }

        float c() {
            return (float) Math.toDegrees(Math.atan((this.f1345b.f1353c - this.f1347d) / (this.f1345b.f1352b - this.f1346c)));
        }
    }

    /* loaded from: classes.dex */
    public static class d extends f {
        private static final RectF h = new RectF();

        /* renamed from: b, reason: collision with root package name */
        @Deprecated
        public float f1348b;

        /* renamed from: c, reason: collision with root package name */
        @Deprecated
        public float f1349c;

        /* renamed from: d, reason: collision with root package name */
        @Deprecated
        public float f1350d;

        /* renamed from: e, reason: collision with root package name */
        @Deprecated
        public float f1351e;

        @Deprecated
        public float f;

        @Deprecated
        public float g;

        public d(float f, float f2, float f3, float f4) {
            q(f);
            u(f2);
            r(f3);
            p(f4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float j() {
            return this.f1351e;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float k() {
            return this.f1348b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float l() {
            return this.f1350d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float m() {
            return this.f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float n() {
            return this.g;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float o() {
            return this.f1349c;
        }

        private void p(float f) {
            this.f1351e = f;
        }

        private void q(float f) {
            this.f1348b = f;
        }

        private void r(float f) {
            this.f1350d = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(float f) {
            this.f = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t(float f) {
            this.g = f;
        }

        private void u(float f) {
            this.f1349c = f;
        }

        @Override // d.a.a.a.z.m.f
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            h.set(k(), o(), l(), j());
            path.arcTo(h, m(), n(), false);
            path.transform(matrix);
        }
    }

    /* loaded from: classes.dex */
    public static class e extends f {

        /* renamed from: b, reason: collision with root package name */
        private float f1352b;

        /* renamed from: c, reason: collision with root package name */
        private float f1353c;

        @Override // d.a.a.a.z.m.f
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f1352b, this.f1353c);
            path.transform(matrix);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class f {
        protected final Matrix a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class g {
        static final Matrix a = new Matrix();

        g() {
        }

        public abstract void a(Matrix matrix, d.a.a.a.y.a aVar, int i, Canvas canvas);

        public final void b(d.a.a.a.y.a aVar, int i, Canvas canvas) {
            a(a, aVar, i, canvas);
        }
    }

    public m() {
        n(0.0f, 0.0f);
    }

    private void b(float f2) {
        if (g() == f2) {
            return;
        }
        float g2 = ((f2 - g()) + 360.0f) % 360.0f;
        if (g2 > 180.0f) {
            return;
        }
        d dVar = new d(i(), j(), i(), j());
        dVar.s(g());
        dVar.t(g2);
        this.h.add(new b(dVar));
        p(f2);
    }

    private void c(g gVar, float f2, float f3) {
        b(f2);
        this.h.add(gVar);
        p(f3);
    }

    private float g() {
        return this.f1341e;
    }

    private float h() {
        return this.f;
    }

    private void p(float f2) {
        this.f1341e = f2;
    }

    private void q(float f2) {
        this.f = f2;
    }

    private void r(float f2) {
        this.f1339c = f2;
    }

    private void s(float f2) {
        this.f1340d = f2;
    }

    private void t(float f2) {
        this.a = f2;
    }

    private void u(float f2) {
        this.f1338b = f2;
    }

    public void a(float f2, float f3, float f4, float f5, float f6, float f7) {
        d dVar = new d(f2, f3, f4, f5);
        dVar.s(f6);
        dVar.t(f7);
        this.g.add(dVar);
        b bVar = new b(dVar);
        float f8 = f6 + f7;
        boolean z = f7 < 0.0f;
        if (z) {
            f6 = (f6 + 180.0f) % 360.0f;
        }
        c(bVar, f6, z ? (180.0f + f8) % 360.0f : f8);
        double d2 = f8;
        r(((f2 + f4) * 0.5f) + (((f4 - f2) / 2.0f) * ((float) Math.cos(Math.toRadians(d2)))));
        s(((f3 + f5) * 0.5f) + (((f5 - f3) / 2.0f) * ((float) Math.sin(Math.toRadians(d2)))));
    }

    public void d(Matrix matrix, Path path) {
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            this.g.get(i).a(matrix, path);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g f(Matrix matrix) {
        b(h());
        return new a(this, new ArrayList(this.h), matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float i() {
        return this.f1339c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float j() {
        return this.f1340d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float k() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float l() {
        return this.f1338b;
    }

    public void m(float f2, float f3) {
        e eVar = new e();
        eVar.f1352b = f2;
        eVar.f1353c = f3;
        this.g.add(eVar);
        c cVar = new c(eVar, i(), j());
        c(cVar, cVar.c() + 270.0f, cVar.c() + 270.0f);
        r(f2);
        s(f3);
    }

    public void n(float f2, float f3) {
        o(f2, f3, 270.0f, 0.0f);
    }

    public void o(float f2, float f3, float f4, float f5) {
        t(f2);
        u(f3);
        r(f2);
        s(f3);
        p(f4);
        q((f4 + f5) % 360.0f);
        this.g.clear();
        this.h.clear();
        this.i = false;
    }
}
