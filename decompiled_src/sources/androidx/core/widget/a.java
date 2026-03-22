package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import c.f.l.s;

/* loaded from: classes.dex */
public abstract class a implements View.OnTouchListener {
    private static final int v = ViewConfiguration.getTapTimeout();
    final View g;
    private Runnable h;
    private int k;
    private int l;
    private boolean p;
    boolean q;
    boolean r;
    boolean s;
    private boolean t;
    private boolean u;

    /* renamed from: e, reason: collision with root package name */
    final C0010a f346e = new C0010a();
    private final Interpolator f = new AccelerateInterpolator();
    private float[] i = {0.0f, 0.0f};
    private float[] j = {Float.MAX_VALUE, Float.MAX_VALUE};
    private float[] m = {0.0f, 0.0f};
    private float[] n = {0.0f, 0.0f};
    private float[] o = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: androidx.core.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0010a {
        private int a;

        /* renamed from: b, reason: collision with root package name */
        private int f347b;

        /* renamed from: c, reason: collision with root package name */
        private float f348c;

        /* renamed from: d, reason: collision with root package name */
        private float f349d;
        private float j;
        private int k;

        /* renamed from: e, reason: collision with root package name */
        private long f350e = Long.MIN_VALUE;
        private long i = -1;
        private long f = 0;
        private int g = 0;
        private int h = 0;

        C0010a() {
        }

        private float e(long j) {
            if (j < this.f350e) {
                return 0.0f;
            }
            long j2 = this.i;
            if (j2 < 0 || j < j2) {
                return a.e(((float) (j - this.f350e)) / this.a, 0.0f, 1.0f) * 0.5f;
            }
            long j3 = j - j2;
            float f = this.j;
            return (1.0f - f) + (f * a.e(((float) j3) / this.k, 0.0f, 1.0f));
        }

        private float g(float f) {
            return ((-4.0f) * f * f) + (f * 4.0f);
        }

        public void a() {
            if (this.f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float g = g(e(currentAnimationTimeMillis));
            long j = currentAnimationTimeMillis - this.f;
            this.f = currentAnimationTimeMillis;
            float f = ((float) j) * g;
            this.g = (int) (this.f348c * f);
            this.h = (int) (f * this.f349d);
        }

        public int b() {
            return this.g;
        }

        public int c() {
            return this.h;
        }

        public int d() {
            float f = this.f348c;
            return (int) (f / Math.abs(f));
        }

        public int f() {
            float f = this.f349d;
            return (int) (f / Math.abs(f));
        }

        public boolean h() {
            return this.i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.i + ((long) this.k);
        }

        public void i() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.k = a.f((int) (currentAnimationTimeMillis - this.f350e), 0, this.f347b);
            this.j = e(currentAnimationTimeMillis);
            this.i = currentAnimationTimeMillis;
        }

        public void j(int i) {
            this.f347b = i;
        }

        public void k(int i) {
            this.a = i;
        }

        public void l(float f, float f2) {
            this.f348c = f;
            this.f349d = f2;
        }

        public void m() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f350e = currentAnimationTimeMillis;
            this.i = -1L;
            this.f = currentAnimationTimeMillis;
            this.j = 0.5f;
            this.g = 0;
            this.h = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            if (aVar.s) {
                if (aVar.q) {
                    aVar.q = false;
                    aVar.f346e.m();
                }
                C0010a c0010a = a.this.f346e;
                if (c0010a.h() || !a.this.u()) {
                    a.this.s = false;
                    return;
                }
                a aVar2 = a.this;
                if (aVar2.r) {
                    aVar2.r = false;
                    aVar2.c();
                }
                c0010a.a();
                a.this.j(c0010a.b(), c0010a.c());
                s.a0(a.this.g, this);
            }
        }
    }

    public a(View view) {
        this.g = view;
        float f = Resources.getSystem().getDisplayMetrics().density;
        float f2 = (int) ((1575.0f * f) + 0.5f);
        o(f2, f2);
        float f3 = (int) ((f * 315.0f) + 0.5f);
        p(f3, f3);
        l(1);
        n(Float.MAX_VALUE, Float.MAX_VALUE);
        s(0.2f, 0.2f);
        t(1.0f, 1.0f);
        k(v);
        r(500);
        q(500);
    }

    private float d(int i, float f, float f2, float f3) {
        float h = h(this.i[i], f2, this.j[i], f);
        if (h == 0.0f) {
            return 0.0f;
        }
        float f4 = this.m[i];
        float f5 = this.n[i];
        float f6 = this.o[i];
        float f7 = f4 * f3;
        return h > 0.0f ? e(h * f7, f5, f6) : -e((-h) * f7, f5, f6);
    }

    static float e(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    static int f(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    private float g(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        int i = this.k;
        if (i == 0 || i == 1) {
            if (f < f2) {
                if (f >= 0.0f) {
                    return 1.0f - (f / f2);
                }
                if (this.s && this.k == 1) {
                    return 1.0f;
                }
            }
        } else if (i == 2 && f < 0.0f) {
            return f / (-f2);
        }
        return 0.0f;
    }

    private float h(float f, float f2, float f3, float f4) {
        float interpolation;
        float e2 = e(f * f2, 0.0f, f3);
        float g = g(f2 - f4, e2) - g(f4, e2);
        if (g < 0.0f) {
            interpolation = -this.f.getInterpolation(-g);
        } else {
            if (g <= 0.0f) {
                return 0.0f;
            }
            interpolation = this.f.getInterpolation(g);
        }
        return e(interpolation, -1.0f, 1.0f);
    }

    private void i() {
        if (this.q) {
            this.s = false;
        } else {
            this.f346e.i();
        }
    }

    private void v() {
        int i;
        if (this.h == null) {
            this.h = new b();
        }
        this.s = true;
        this.q = true;
        if (this.p || (i = this.l) <= 0) {
            this.h.run();
        } else {
            s.b0(this.g, this.h, i);
        }
        this.p = true;
    }

    public abstract boolean a(int i);

    public abstract boolean b(int i);

    void c() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.g.onTouchEvent(obtain);
        obtain.recycle();
    }

    public abstract void j(int i, int i2);

    public a k(int i) {
        this.l = i;
        return this;
    }

    public a l(int i) {
        this.k = i;
        return this;
    }

    public a m(boolean z) {
        if (this.t && !z) {
            i();
        }
        this.t = z;
        return this;
    }

    public a n(float f, float f2) {
        float[] fArr = this.j;
        fArr[0] = f;
        fArr[1] = f2;
        return this;
    }

    public a o(float f, float f2) {
        float[] fArr = this.o;
        fArr[0] = f / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:
    
        if (r0 != 3) goto L20;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.t
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1a
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L1e
            r6 = 3
            if (r0 == r6) goto L16
            goto L58
        L16:
            r5.i()
            goto L58
        L1a:
            r5.r = r2
            r5.p = r1
        L1e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.g
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.d(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.g
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.d(r2, r7, r6, r3)
            androidx.core.widget.a$a r7 = r5.f346e
            r7.l(r0, r6)
            boolean r6 = r5.s
            if (r6 != 0) goto L58
            boolean r6 = r5.u()
            if (r6 == 0) goto L58
            r5.v()
        L58:
            boolean r6 = r5.u
            if (r6 == 0) goto L61
            boolean r6 = r5.s
            if (r6 == 0) goto L61
            r1 = 1
        L61:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public a p(float f, float f2) {
        float[] fArr = this.n;
        fArr[0] = f / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    public a q(int i) {
        this.f346e.j(i);
        return this;
    }

    public a r(int i) {
        this.f346e.k(i);
        return this;
    }

    public a s(float f, float f2) {
        float[] fArr = this.i;
        fArr[0] = f;
        fArr[1] = f2;
        return this;
    }

    public a t(float f, float f2) {
        float[] fArr = this.m;
        fArr[0] = f / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    boolean u() {
        C0010a c0010a = this.f346e;
        int f = c0010a.f();
        int d2 = c0010a.d();
        return (f != 0 && b(f)) || (d2 != 0 && a(d2));
    }
}
