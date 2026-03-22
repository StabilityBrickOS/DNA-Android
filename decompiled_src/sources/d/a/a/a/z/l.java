package d.a.a.a.z;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;

/* loaded from: classes.dex */
public class l {
    private final m[] a = new m[4];

    /* renamed from: b, reason: collision with root package name */
    private final Matrix[] f1330b = new Matrix[4];

    /* renamed from: c, reason: collision with root package name */
    private final Matrix[] f1331c = new Matrix[4];

    /* renamed from: d, reason: collision with root package name */
    private final PointF f1332d = new PointF();

    /* renamed from: e, reason: collision with root package name */
    private final Path f1333e = new Path();
    private final Path f = new Path();
    private final m g = new m();
    private final float[] h = new float[2];
    private final float[] i = new float[2];
    private boolean j = true;

    /* loaded from: classes.dex */
    public interface a {
        void a(m mVar, Matrix matrix, int i);

        void b(m mVar, Matrix matrix, int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b {
        public final k a;

        /* renamed from: b, reason: collision with root package name */
        public final Path f1334b;

        /* renamed from: c, reason: collision with root package name */
        public final RectF f1335c;

        /* renamed from: d, reason: collision with root package name */
        public final a f1336d;

        /* renamed from: e, reason: collision with root package name */
        public final float f1337e;

        b(k kVar, float f, RectF rectF, a aVar, Path path) {
            this.f1336d = aVar;
            this.a = kVar;
            this.f1337e = f;
            this.f1335c = rectF;
            this.f1334b = path;
        }
    }

    public l() {
        for (int i = 0; i < 4; i++) {
            this.a[i] = new m();
            this.f1330b[i] = new Matrix();
            this.f1331c[i] = new Matrix();
        }
    }

    private float a(int i) {
        return (i + 1) * 90;
    }

    private void b(b bVar, int i) {
        this.h[0] = this.a[i].k();
        this.h[1] = this.a[i].l();
        this.f1330b[i].mapPoints(this.h);
        Path path = bVar.f1334b;
        float[] fArr = this.h;
        if (i == 0) {
            path.moveTo(fArr[0], fArr[1]);
        } else {
            path.lineTo(fArr[0], fArr[1]);
        }
        this.a[i].d(this.f1330b[i], bVar.f1334b);
        a aVar = bVar.f1336d;
        if (aVar != null) {
            aVar.b(this.a[i], this.f1330b[i], i);
        }
    }

    private void c(b bVar, int i) {
        m mVar;
        Matrix matrix;
        Path path;
        int i2 = (i + 1) % 4;
        this.h[0] = this.a[i].i();
        this.h[1] = this.a[i].j();
        this.f1330b[i].mapPoints(this.h);
        this.i[0] = this.a[i2].k();
        this.i[1] = this.a[i2].l();
        this.f1330b[i2].mapPoints(this.i);
        float f = this.h[0];
        float[] fArr = this.i;
        float max = Math.max(((float) Math.hypot(f - fArr[0], r1[1] - fArr[1])) - 0.001f, 0.0f);
        float i3 = i(bVar.f1335c, i);
        this.g.n(0.0f, 0.0f);
        f j = j(i, bVar.a);
        j.b(max, i3, bVar.f1337e, this.g);
        Path path2 = new Path();
        this.g.d(this.f1331c[i], path2);
        if (this.j && Build.VERSION.SDK_INT >= 19 && (j.a() || k(path2, i) || k(path2, i2))) {
            path2.op(path2, this.f, Path.Op.DIFFERENCE);
            this.h[0] = this.g.k();
            this.h[1] = this.g.l();
            this.f1331c[i].mapPoints(this.h);
            Path path3 = this.f1333e;
            float[] fArr2 = this.h;
            path3.moveTo(fArr2[0], fArr2[1]);
            mVar = this.g;
            matrix = this.f1331c[i];
            path = this.f1333e;
        } else {
            mVar = this.g;
            matrix = this.f1331c[i];
            path = bVar.f1334b;
        }
        mVar.d(matrix, path);
        a aVar = bVar.f1336d;
        if (aVar != null) {
            aVar.a(this.g, this.f1331c[i], i);
        }
    }

    private void f(int i, RectF rectF, PointF pointF) {
        float f;
        float f2;
        if (i == 1) {
            f = rectF.right;
        } else {
            if (i != 2) {
                f = i != 3 ? rectF.right : rectF.left;
                f2 = rectF.top;
                pointF.set(f, f2);
            }
            f = rectF.left;
        }
        f2 = rectF.bottom;
        pointF.set(f, f2);
    }

    private c g(int i, k kVar) {
        return i != 1 ? i != 2 ? i != 3 ? kVar.t() : kVar.r() : kVar.j() : kVar.l();
    }

    private d h(int i, k kVar) {
        return i != 1 ? i != 2 ? i != 3 ? kVar.s() : kVar.q() : kVar.i() : kVar.k();
    }

    private float i(RectF rectF, int i) {
        float centerX;
        float f;
        float[] fArr = this.h;
        m[] mVarArr = this.a;
        fArr[0] = mVarArr[i].f1339c;
        fArr[1] = mVarArr[i].f1340d;
        this.f1330b[i].mapPoints(fArr);
        if (i == 1 || i == 3) {
            centerX = rectF.centerX();
            f = this.h[0];
        } else {
            centerX = rectF.centerY();
            f = this.h[1];
        }
        return Math.abs(centerX - f);
    }

    private f j(int i, k kVar) {
        return i != 1 ? i != 2 ? i != 3 ? kVar.o() : kVar.p() : kVar.n() : kVar.h();
    }

    private boolean k(Path path, int i) {
        Path path2 = new Path();
        this.a[i].d(this.f1330b[i], path2);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        path2.computeBounds(rectF, true);
        path.op(path2, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (rectF.isEmpty()) {
            return rectF.width() > 1.0f && rectF.height() > 1.0f;
        }
        return true;
    }

    private void l(b bVar, int i) {
        h(i, bVar.a).b(this.a[i], 90.0f, bVar.f1337e, bVar.f1335c, g(i, bVar.a));
        float a2 = a(i);
        this.f1330b[i].reset();
        f(i, bVar.f1335c, this.f1332d);
        Matrix matrix = this.f1330b[i];
        PointF pointF = this.f1332d;
        matrix.setTranslate(pointF.x, pointF.y);
        this.f1330b[i].preRotate(a2);
    }

    private void m(int i) {
        this.h[0] = this.a[i].i();
        this.h[1] = this.a[i].j();
        this.f1330b[i].mapPoints(this.h);
        float a2 = a(i);
        this.f1331c[i].reset();
        Matrix matrix = this.f1331c[i];
        float[] fArr = this.h;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.f1331c[i].preRotate(a2);
    }

    public void d(k kVar, float f, RectF rectF, Path path) {
        e(kVar, f, rectF, null, path);
    }

    public void e(k kVar, float f, RectF rectF, a aVar, Path path) {
        path.rewind();
        this.f1333e.rewind();
        this.f.rewind();
        this.f.addRect(rectF, Path.Direction.CW);
        b bVar = new b(kVar, f, rectF, aVar, path);
        for (int i = 0; i < 4; i++) {
            l(bVar, i);
            m(i);
        }
        for (int i2 = 0; i2 < 4; i2++) {
            b(bVar, i2);
            c(bVar, i2);
        }
        path.close();
        this.f1333e.close();
        if (Build.VERSION.SDK_INT < 19 || this.f1333e.isEmpty()) {
            return;
        }
        path.op(this.f1333e, Path.Op.UNION);
    }
}
