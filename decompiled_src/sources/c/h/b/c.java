package c.h.b;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import c.f.l.s;
import java.util.Arrays;

/* loaded from: classes.dex */
public class c {
    private static final Interpolator w = new a();
    private int a;

    /* renamed from: b, reason: collision with root package name */
    private int f834b;

    /* renamed from: d, reason: collision with root package name */
    private float[] f836d;

    /* renamed from: e, reason: collision with root package name */
    private float[] f837e;
    private float[] f;
    private float[] g;
    private int[] h;
    private int[] i;
    private int[] j;
    private int k;
    private VelocityTracker l;
    private float m;
    private float n;
    private int o;
    private int p;
    private OverScroller q;
    private final AbstractC0043c r;
    private View s;
    private boolean t;
    private final ViewGroup u;

    /* renamed from: c, reason: collision with root package name */
    private int f835c = -1;
    private final Runnable v = new b();

    /* loaded from: classes.dex */
    static class a implements Interpolator {
        a() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.J(0);
        }
    }

    /* renamed from: c.h.b.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0043c {
        public abstract int a(View view, int i, int i2);

        public abstract int b(View view, int i, int i2);

        public int c(int i) {
            return i;
        }

        public int d(View view) {
            return 0;
        }

        public int e(View view) {
            return 0;
        }

        public void f(int i, int i2) {
        }

        public boolean g(int i) {
            return false;
        }

        public void h(int i, int i2) {
        }

        public void i(View view, int i) {
        }

        public abstract void j(int i);

        public abstract void k(View view, int i, int i2, int i3, int i4);

        public abstract void l(View view, float f, float f2);

        public abstract boolean m(View view, int i);
    }

    private c(Context context, ViewGroup viewGroup, AbstractC0043c abstractC0043c) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (abstractC0043c == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.u = viewGroup;
        this.r = abstractC0043c;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f834b = viewConfiguration.getScaledTouchSlop();
        this.m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.q = new OverScroller(context, w);
    }

    private boolean C(int i) {
        if (B(i)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    private void F() {
        this.l.computeCurrentVelocity(1000, this.m);
        p(g(this.l.getXVelocity(this.f835c), this.n, this.m), g(this.l.getYVelocity(this.f835c), this.n, this.m));
    }

    private void G(float f, float f2, int i) {
        int i2 = c(f, f2, i, 1) ? 1 : 0;
        if (c(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (c(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (c(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.i;
            iArr[i] = iArr[i] | i2;
            this.r.f(i2, i);
        }
    }

    private void H(float f, float f2, int i) {
        s(i);
        float[] fArr = this.f836d;
        this.f[i] = f;
        fArr[i] = f;
        float[] fArr2 = this.f837e;
        this.g[i] = f2;
        fArr2[i] = f2;
        this.h[i] = x((int) f, (int) f2);
        this.k |= 1 << i;
    }

    private void I(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            if (C(pointerId)) {
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                this.f[pointerId] = x;
                this.g[pointerId] = y;
            }
        }
    }

    private boolean c(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.h[i] & i2) != i2 || (this.p & i2) == 0 || (this.j[i] & i2) == i2 || (this.i[i] & i2) == i2) {
            return false;
        }
        int i3 = this.f834b;
        if (abs <= i3 && abs2 <= i3) {
            return false;
        }
        if (abs >= abs2 * 0.5f || !this.r.g(i2)) {
            return (this.i[i] & i2) == 0 && abs > ((float) this.f834b);
        }
        int[] iArr = this.j;
        iArr[i] = iArr[i] | i2;
        return false;
    }

    private boolean f(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z = this.r.d(view) > 0;
        boolean z2 = this.r.e(view) > 0;
        if (!z || !z2) {
            return z ? Math.abs(f) > ((float) this.f834b) : z2 && Math.abs(f2) > ((float) this.f834b);
        }
        float f3 = (f * f) + (f2 * f2);
        int i = this.f834b;
        return f3 > ((float) (i * i));
    }

    private float g(float f, float f2, float f3) {
        float abs = Math.abs(f);
        if (abs < f2) {
            return 0.0f;
        }
        return abs > f3 ? f > 0.0f ? f3 : -f3 : f;
    }

    private int h(int i, int i2, int i3) {
        int abs = Math.abs(i);
        if (abs < i2) {
            return 0;
        }
        return abs > i3 ? i > 0 ? i3 : -i3 : i;
    }

    private void i() {
        float[] fArr = this.f836d;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.f837e, 0.0f);
        Arrays.fill(this.f, 0.0f);
        Arrays.fill(this.g, 0.0f);
        Arrays.fill(this.h, 0);
        Arrays.fill(this.i, 0);
        Arrays.fill(this.j, 0);
        this.k = 0;
    }

    private void j(int i) {
        if (this.f836d == null || !B(i)) {
            return;
        }
        this.f836d[i] = 0.0f;
        this.f837e[i] = 0.0f;
        this.f[i] = 0.0f;
        this.g[i] = 0.0f;
        this.h[i] = 0;
        this.i[i] = 0;
        this.j[i] = 0;
        this.k = (~(1 << i)) & this.k;
    }

    private int k(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.u.getWidth();
        float f = width / 2;
        float q = f + (q(Math.min(1.0f, Math.abs(i) / width)) * f);
        int abs = Math.abs(i2);
        return Math.min(abs > 0 ? Math.round(Math.abs(q / abs) * 1000.0f) * 4 : (int) (((Math.abs(i) / i3) + 1.0f) * 256.0f), 600);
    }

    private int l(View view, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        float f4;
        int h = h(i3, (int) this.n, (int) this.m);
        int h2 = h(i4, (int) this.n, (int) this.m);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(h);
        int abs4 = Math.abs(h2);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        if (h != 0) {
            f = abs3;
            f2 = i5;
        } else {
            f = abs;
            f2 = i6;
        }
        float f5 = f / f2;
        if (h2 != 0) {
            f3 = abs4;
            f4 = i5;
        } else {
            f3 = abs2;
            f4 = i6;
        }
        return (int) ((k(i, h, this.r.d(view)) * f5) + (k(i2, h2, this.r.e(view)) * (f3 / f4)));
    }

    public static c n(ViewGroup viewGroup, float f, AbstractC0043c abstractC0043c) {
        c o = o(viewGroup, abstractC0043c);
        o.f834b = (int) (o.f834b * (1.0f / f));
        return o;
    }

    public static c o(ViewGroup viewGroup, AbstractC0043c abstractC0043c) {
        return new c(viewGroup.getContext(), viewGroup, abstractC0043c);
    }

    private void p(float f, float f2) {
        this.t = true;
        this.r.l(this.s, f, f2);
        this.t = false;
        if (this.a == 1) {
            J(0);
        }
    }

    private float q(float f) {
        return (float) Math.sin((f - 0.5f) * 0.47123894f);
    }

    private void r(int i, int i2, int i3, int i4) {
        int left = this.s.getLeft();
        int top = this.s.getTop();
        if (i3 != 0) {
            i = this.r.a(this.s, i, i3);
            s.T(this.s, i - left);
        }
        int i5 = i;
        if (i4 != 0) {
            i2 = this.r.b(this.s, i2, i4);
            s.U(this.s, i2 - top);
        }
        int i6 = i2;
        if (i3 == 0 && i4 == 0) {
            return;
        }
        this.r.k(this.s, i5, i6, i5 - left, i6 - top);
    }

    private void s(int i) {
        float[] fArr = this.f836d;
        if (fArr == null || fArr.length <= i) {
            int i2 = i + 1;
            float[] fArr2 = new float[i2];
            float[] fArr3 = new float[i2];
            float[] fArr4 = new float[i2];
            float[] fArr5 = new float[i2];
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            int[] iArr3 = new int[i2];
            float[] fArr6 = this.f836d;
            if (fArr6 != null) {
                System.arraycopy(fArr6, 0, fArr2, 0, fArr6.length);
                float[] fArr7 = this.f837e;
                System.arraycopy(fArr7, 0, fArr3, 0, fArr7.length);
                float[] fArr8 = this.f;
                System.arraycopy(fArr8, 0, fArr4, 0, fArr8.length);
                float[] fArr9 = this.g;
                System.arraycopy(fArr9, 0, fArr5, 0, fArr9.length);
                int[] iArr4 = this.h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f836d = fArr2;
            this.f837e = fArr3;
            this.f = fArr4;
            this.g = fArr5;
            this.h = iArr;
            this.i = iArr2;
            this.j = iArr3;
        }
    }

    private boolean u(int i, int i2, int i3, int i4) {
        int left = this.s.getLeft();
        int top = this.s.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.q.abortAnimation();
            J(0);
            return false;
        }
        this.q.startScroll(left, top, i5, i6, l(this.s, i5, i6, i3, i4));
        J(2);
        return true;
    }

    private int x(int i, int i2) {
        int i3 = i < this.u.getLeft() + this.o ? 1 : 0;
        if (i2 < this.u.getTop() + this.o) {
            i3 |= 4;
        }
        if (i > this.u.getRight() - this.o) {
            i3 |= 2;
        }
        return i2 > this.u.getBottom() - this.o ? i3 | 8 : i3;
    }

    public boolean A(int i, int i2) {
        return D(this.s, i, i2);
    }

    public boolean B(int i) {
        return ((1 << i) & this.k) != 0;
    }

    public boolean D(View view, int i, int i2) {
        return view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom();
    }

    public void E(MotionEvent motionEvent) {
        int i;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.l == null) {
            this.l = VelocityTracker.obtain();
        }
        this.l.addMovement(motionEvent);
        int i2 = 0;
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View t = t((int) x, (int) y);
            H(x, y, pointerId);
            P(t, pointerId);
            int i3 = this.h[pointerId];
            int i4 = this.p;
            if ((i3 & i4) != 0) {
                this.r.h(i3 & i4, pointerId);
                return;
            }
            return;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                if (this.a != 1) {
                    int pointerCount = motionEvent.getPointerCount();
                    while (i2 < pointerCount) {
                        int pointerId2 = motionEvent.getPointerId(i2);
                        if (C(pointerId2)) {
                            float x2 = motionEvent.getX(i2);
                            float y2 = motionEvent.getY(i2);
                            float f = x2 - this.f836d[pointerId2];
                            float f2 = y2 - this.f837e[pointerId2];
                            G(f, f2, pointerId2);
                            if (this.a != 1) {
                                View t2 = t((int) x2, (int) y2);
                                if (f(t2, f, f2) && P(t2, pointerId2)) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        i2++;
                    }
                } else {
                    if (!C(this.f835c)) {
                        return;
                    }
                    int findPointerIndex = motionEvent.findPointerIndex(this.f835c);
                    float x3 = motionEvent.getX(findPointerIndex);
                    float y3 = motionEvent.getY(findPointerIndex);
                    float[] fArr = this.f;
                    int i5 = this.f835c;
                    int i6 = (int) (x3 - fArr[i5]);
                    int i7 = (int) (y3 - this.g[i5]);
                    r(this.s.getLeft() + i6, this.s.getTop() + i7, i6, i7);
                }
                I(motionEvent);
                return;
            }
            if (actionMasked != 3) {
                if (actionMasked == 5) {
                    int pointerId3 = motionEvent.getPointerId(actionIndex);
                    float x4 = motionEvent.getX(actionIndex);
                    float y4 = motionEvent.getY(actionIndex);
                    H(x4, y4, pointerId3);
                    if (this.a != 0) {
                        if (A((int) x4, (int) y4)) {
                            P(this.s, pointerId3);
                            return;
                        }
                        return;
                    } else {
                        P(t((int) x4, (int) y4), pointerId3);
                        int i8 = this.h[pointerId3];
                        int i9 = this.p;
                        if ((i8 & i9) != 0) {
                            this.r.h(i8 & i9, pointerId3);
                            return;
                        }
                        return;
                    }
                }
                if (actionMasked != 6) {
                    return;
                }
                int pointerId4 = motionEvent.getPointerId(actionIndex);
                if (this.a == 1 && pointerId4 == this.f835c) {
                    int pointerCount2 = motionEvent.getPointerCount();
                    while (true) {
                        if (i2 >= pointerCount2) {
                            i = -1;
                            break;
                        }
                        int pointerId5 = motionEvent.getPointerId(i2);
                        if (pointerId5 != this.f835c) {
                            View t3 = t((int) motionEvent.getX(i2), (int) motionEvent.getY(i2));
                            View view = this.s;
                            if (t3 == view && P(view, pointerId5)) {
                                i = this.f835c;
                                break;
                            }
                        }
                        i2++;
                    }
                    if (i == -1) {
                        F();
                    }
                }
                j(pointerId4);
                return;
            }
            if (this.a == 1) {
                p(0.0f, 0.0f);
            }
        } else if (this.a == 1) {
            F();
        }
        a();
    }

    void J(int i) {
        this.u.removeCallbacks(this.v);
        if (this.a != i) {
            this.a = i;
            this.r.j(i);
            if (this.a == 0) {
                this.s = null;
            }
        }
    }

    public void K(int i) {
        this.p = i;
    }

    public void L(float f) {
        this.n = f;
    }

    public boolean M(int i, int i2) {
        if (this.t) {
            return u(i, i2, (int) this.l.getXVelocity(this.f835c), (int) this.l.getYVelocity(this.f835c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00dd, code lost:
    
        if (r12 != r11) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean N(android.view.MotionEvent r17) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.h.b.c.N(android.view.MotionEvent):boolean");
    }

    public boolean O(View view, int i, int i2) {
        this.s = view;
        this.f835c = -1;
        boolean u = u(i, i2, 0, 0);
        if (!u && this.a == 0 && this.s != null) {
            this.s = null;
        }
        return u;
    }

    boolean P(View view, int i) {
        if (view == this.s && this.f835c == i) {
            return true;
        }
        if (view == null || !this.r.m(view, i)) {
            return false;
        }
        this.f835c = i;
        b(view, i);
        return true;
    }

    public void a() {
        this.f835c = -1;
        i();
        VelocityTracker velocityTracker = this.l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.l = null;
        }
    }

    public void b(View view, int i) {
        if (view.getParent() == this.u) {
            this.s = view;
            this.f835c = i;
            this.r.i(view, i);
            J(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.u + ")");
    }

    public boolean d(int i) {
        int length = this.f836d.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (e(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean e(int i, int i2) {
        if (!B(i2)) {
            return false;
        }
        boolean z = (i & 1) == 1;
        boolean z2 = (i & 2) == 2;
        float f = this.f[i2] - this.f836d[i2];
        float f2 = this.g[i2] - this.f837e[i2];
        if (!z || !z2) {
            return z ? Math.abs(f) > ((float) this.f834b) : z2 && Math.abs(f2) > ((float) this.f834b);
        }
        float f3 = (f * f) + (f2 * f2);
        int i3 = this.f834b;
        return f3 > ((float) (i3 * i3));
    }

    public boolean m(boolean z) {
        if (this.a == 2) {
            boolean computeScrollOffset = this.q.computeScrollOffset();
            int currX = this.q.getCurrX();
            int currY = this.q.getCurrY();
            int left = currX - this.s.getLeft();
            int top = currY - this.s.getTop();
            if (left != 0) {
                s.T(this.s, left);
            }
            if (top != 0) {
                s.U(this.s, top);
            }
            if (left != 0 || top != 0) {
                this.r.k(this.s, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.q.getFinalX() && currY == this.q.getFinalY()) {
                this.q.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z) {
                    this.u.post(this.v);
                } else {
                    J(0);
                }
            }
        }
        return this.a == 2;
    }

    public View t(int i, int i2) {
        for (int childCount = this.u.getChildCount() - 1; childCount >= 0; childCount--) {
            ViewGroup viewGroup = this.u;
            this.r.c(childCount);
            View childAt = viewGroup.getChildAt(childCount);
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public View v() {
        return this.s;
    }

    public int w() {
        return this.o;
    }

    public int y() {
        return this.f834b;
    }

    public int z() {
        return this.a;
    }
}
