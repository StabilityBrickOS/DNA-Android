package androidx.recyclerview.widget;

import android.R;
import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.recyclerview.widget.a;
import androidx.recyclerview.widget.b;
import androidx.recyclerview.widget.e;
import androidx.recyclerview.widget.k;
import androidx.recyclerview.widget.o;
import androidx.recyclerview.widget.p;
import c.f.l.b0.c;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements c.f.l.j {
    private static final int[] B0 = {R.attr.nestedScrollingEnabled};
    static final boolean C0;
    static final boolean D0;
    static final boolean E0;
    private static final boolean F0;
    private static final boolean G0;
    private static final Class<?>[] H0;
    static final Interpolator I0;
    boolean A;
    private final p.b A0;
    private boolean B;
    private int C;
    boolean D;
    private final AccessibilityManager E;
    private List<p> F;
    boolean G;
    boolean H;
    private int I;
    private int J;
    private j K;
    private EdgeEffect L;
    private EdgeEffect M;
    private EdgeEffect N;
    private EdgeEffect O;
    k P;
    private int Q;
    private int R;
    private VelocityTracker S;
    private int T;
    private int U;
    private int V;
    private int W;
    private int a0;
    private q b0;
    private final int c0;
    private final int d0;

    /* renamed from: e, reason: collision with root package name */
    private final w f476e;
    private float e0;
    final u f;
    private float f0;
    private x g;
    private boolean g0;
    androidx.recyclerview.widget.a h;
    final b0 h0;
    androidx.recyclerview.widget.b i;
    androidx.recyclerview.widget.e i0;
    final androidx.recyclerview.widget.p j;
    e.b j0;
    boolean k;
    final z k0;
    final Rect l;
    private s l0;
    private final Rect m;
    private List<s> m0;
    final RectF n;
    boolean n0;
    f o;
    boolean o0;
    n p;
    private k.b p0;
    v q;
    boolean q0;
    final ArrayList<m> r;
    androidx.recyclerview.widget.k r0;
    private final ArrayList<r> s;
    private i s0;
    private r t;
    private final int[] t0;
    boolean u;
    private c.f.l.k u0;
    boolean v;
    private final int[] v0;
    boolean w;
    private final int[] w0;
    boolean x;
    final int[] x0;
    private int y;
    final List<c0> y0;
    boolean z;
    private Runnable z0;

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k kVar = RecyclerView.this.P;
            if (kVar != null) {
                kVar.u();
            }
            RecyclerView.this.q0 = false;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class a0 {
        public abstract View a(u uVar, int i, int i2);
    }

    /* loaded from: classes.dex */
    static class b implements Interpolator {
        b() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b0 implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        private int f478e;
        private int f;
        OverScroller g;
        Interpolator h = RecyclerView.I0;
        private boolean i = false;
        private boolean j = false;

        b0() {
            this.g = new OverScroller(RecyclerView.this.getContext(), RecyclerView.I0);
        }

        private int a(int i, int i2, int i3, int i4) {
            int i5;
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            boolean z = abs > abs2;
            int sqrt = (int) Math.sqrt((i3 * i3) + (i4 * i4));
            int sqrt2 = (int) Math.sqrt((i * i) + (i2 * i2));
            RecyclerView recyclerView = RecyclerView.this;
            int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
            int i6 = width / 2;
            float f = width;
            float f2 = i6;
            float b2 = f2 + (b(Math.min(1.0f, (sqrt2 * 1.0f) / f)) * f2);
            if (sqrt > 0) {
                i5 = Math.round(Math.abs(b2 / sqrt) * 1000.0f) * 4;
            } else {
                if (!z) {
                    abs = abs2;
                }
                i5 = (int) (((abs / f) + 1.0f) * 300.0f);
            }
            return Math.min(i5, 2000);
        }

        private float b(float f) {
            return (float) Math.sin((f - 0.5f) * 0.47123894f);
        }

        private void d() {
            RecyclerView.this.removeCallbacks(this);
            c.f.l.s.a0(RecyclerView.this, this);
        }

        public void c(int i, int i2) {
            RecyclerView.this.setScrollState(2);
            this.f = 0;
            this.f478e = 0;
            Interpolator interpolator = this.h;
            Interpolator interpolator2 = RecyclerView.I0;
            if (interpolator != interpolator2) {
                this.h = interpolator2;
                this.g = new OverScroller(RecyclerView.this.getContext(), RecyclerView.I0);
            }
            this.g.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            e();
        }

        void e() {
            if (this.i) {
                this.j = true;
            } else {
                d();
            }
        }

        public void f(int i, int i2, int i3, Interpolator interpolator) {
            if (i3 == Integer.MIN_VALUE) {
                i3 = a(i, i2, 0, 0);
            }
            int i4 = i3;
            if (interpolator == null) {
                interpolator = RecyclerView.I0;
            }
            if (this.h != interpolator) {
                this.h = interpolator;
                this.g = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.f = 0;
            this.f478e = 0;
            RecyclerView.this.setScrollState(2);
            this.g.startScroll(0, 0, i, i2, i4);
            if (Build.VERSION.SDK_INT < 23) {
                this.g.computeScrollOffset();
            }
            e();
        }

        public void g() {
            RecyclerView.this.removeCallbacks(this);
            this.g.abortAnimation();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.p == null) {
                g();
                return;
            }
            this.j = false;
            this.i = true;
            recyclerView.u();
            OverScroller overScroller = this.g;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i3 = currX - this.f478e;
                int i4 = currY - this.f;
                this.f478e = currX;
                this.f = currY;
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.x0;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.F(i3, i4, iArr, null, 1)) {
                    int[] iArr2 = RecyclerView.this.x0;
                    i3 -= iArr2[0];
                    i4 -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.t(i3, i4);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.o != null) {
                    int[] iArr3 = recyclerView3.x0;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.f1(i3, i4, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.x0;
                    i2 = iArr4[0];
                    i = iArr4[1];
                    i3 -= i2;
                    i4 -= i;
                    y yVar = recyclerView4.p.g;
                    if (yVar != null && !yVar.g() && yVar.h()) {
                        int b2 = RecyclerView.this.k0.b();
                        if (b2 == 0) {
                            yVar.r();
                        } else {
                            if (yVar.f() >= b2) {
                                yVar.p(b2 - 1);
                            }
                            yVar.j(i2, i);
                        }
                    }
                } else {
                    i = 0;
                    i2 = 0;
                }
                if (!RecyclerView.this.r.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.x0;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.G(i2, i, i3, i4, null, 1, iArr5);
                int[] iArr6 = RecyclerView.this.x0;
                int i5 = i3 - iArr6[0];
                int i6 = i4 - iArr6[1];
                if (i2 != 0 || i != 0) {
                    RecyclerView.this.I(i2, i);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i5 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i6 != 0));
                y yVar2 = RecyclerView.this.p.g;
                if ((yVar2 != null && yVar2.g()) || !z) {
                    e();
                    RecyclerView recyclerView6 = RecyclerView.this;
                    androidx.recyclerview.widget.e eVar = recyclerView6.i0;
                    if (eVar != null) {
                        eVar.f(recyclerView6, i2, i);
                    }
                } else {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i7 = i5 < 0 ? -currVelocity : i5 > 0 ? currVelocity : 0;
                        if (i6 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i6 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.a(i7, currVelocity);
                    }
                    if (RecyclerView.E0) {
                        RecyclerView.this.j0.b();
                    }
                }
            }
            y yVar3 = RecyclerView.this.p.g;
            if (yVar3 != null && yVar3.g()) {
                yVar3.j(0, 0);
            }
            this.i = false;
            if (this.j) {
                d();
            } else {
                RecyclerView.this.setScrollState(0);
                RecyclerView.this.s1(1);
            }
        }
    }

    /* loaded from: classes.dex */
    class c implements p.b {
        c() {
        }

        @Override // androidx.recyclerview.widget.p.b
        public void a(c0 c0Var) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.p.m1(c0Var.a, recyclerView.f);
        }

        @Override // androidx.recyclerview.widget.p.b
        public void b(c0 c0Var, k.c cVar, k.c cVar2) {
            RecyclerView.this.l(c0Var, cVar, cVar2);
        }

        @Override // androidx.recyclerview.widget.p.b
        public void c(c0 c0Var, k.c cVar, k.c cVar2) {
            RecyclerView.this.f.J(c0Var);
            RecyclerView.this.n(c0Var, cVar, cVar2);
        }

        @Override // androidx.recyclerview.widget.p.b
        public void d(c0 c0Var, k.c cVar, k.c cVar2) {
            c0Var.G(false);
            RecyclerView recyclerView = RecyclerView.this;
            boolean z = recyclerView.G;
            k kVar = recyclerView.P;
            if (z) {
                if (!kVar.b(c0Var, c0Var, cVar, cVar2)) {
                    return;
                }
            } else if (!kVar.d(c0Var, cVar, cVar2)) {
                return;
            }
            RecyclerView.this.L0();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class c0 {
        private static final List<Object> s = Collections.emptyList();
        public final View a;

        /* renamed from: b, reason: collision with root package name */
        WeakReference<RecyclerView> f479b;
        int j;
        RecyclerView r;

        /* renamed from: c, reason: collision with root package name */
        int f480c = -1;

        /* renamed from: d, reason: collision with root package name */
        int f481d = -1;

        /* renamed from: e, reason: collision with root package name */
        long f482e = -1;
        int f = -1;
        int g = -1;
        c0 h = null;
        c0 i = null;
        List<Object> k = null;
        List<Object> l = null;
        private int m = 0;
        u n = null;
        boolean o = false;
        private int p = 0;
        int q = -1;

        public c0(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.a = view;
        }

        private void g() {
            if (this.k == null) {
                ArrayList arrayList = new ArrayList();
                this.k = arrayList;
                this.l = Collections.unmodifiableList(arrayList);
            }
        }

        void A(int i, boolean z) {
            if (this.f481d == -1) {
                this.f481d = this.f480c;
            }
            if (this.g == -1) {
                this.g = this.f480c;
            }
            if (z) {
                this.g += i;
            }
            this.f480c += i;
            if (this.a.getLayoutParams() != null) {
                ((o) this.a.getLayoutParams()).f497c = true;
            }
        }

        void B(RecyclerView recyclerView) {
            int i = this.q;
            if (i == -1) {
                i = c.f.l.s.w(this.a);
            }
            this.p = i;
            recyclerView.i1(this, 4);
        }

        void C(RecyclerView recyclerView) {
            recyclerView.i1(this, this.p);
            this.p = 0;
        }

        void D() {
            this.j = 0;
            this.f480c = -1;
            this.f481d = -1;
            this.f482e = -1L;
            this.g = -1;
            this.m = 0;
            this.h = null;
            this.i = null;
            d();
            this.p = 0;
            this.q = -1;
            RecyclerView.r(this);
        }

        void E() {
            if (this.f481d == -1) {
                this.f481d = this.f480c;
            }
        }

        void F(int i, int i2) {
            this.j = (i & i2) | (this.j & (~i2));
        }

        public final void G(boolean z) {
            int i;
            int i2 = this.m;
            int i3 = z ? i2 - 1 : i2 + 1;
            this.m = i3;
            if (i3 < 0) {
                this.m = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }
            if (!z && i3 == 1) {
                i = this.j | 16;
            } else if (!z || this.m != 0) {
                return;
            } else {
                i = this.j & (-17);
            }
            this.j = i;
        }

        void H(u uVar, boolean z) {
            this.n = uVar;
            this.o = z;
        }

        boolean I() {
            return (this.j & 16) != 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean J() {
            return (this.j & 128) != 0;
        }

        void K() {
            this.n.J(this);
        }

        boolean L() {
            return (this.j & 32) != 0;
        }

        void a(Object obj) {
            if (obj == null) {
                b(1024);
            } else if ((1024 & this.j) == 0) {
                g();
                this.k.add(obj);
            }
        }

        void b(int i) {
            this.j = i | this.j;
        }

        void c() {
            this.f481d = -1;
            this.g = -1;
        }

        void d() {
            List<Object> list = this.k;
            if (list != null) {
                list.clear();
            }
            this.j &= -1025;
        }

        void e() {
            this.j &= -33;
        }

        void f() {
            this.j &= -257;
        }

        boolean h() {
            return (this.j & 16) == 0 && c.f.l.s.L(this.a);
        }

        void i(int i, int i2, boolean z) {
            b(8);
            A(i2, z);
            this.f480c = i;
        }

        public final int j() {
            RecyclerView recyclerView = this.r;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.b0(this);
        }

        public final long k() {
            return this.f482e;
        }

        public final int l() {
            return this.f;
        }

        public final int m() {
            int i = this.g;
            return i == -1 ? this.f480c : i;
        }

        public final int n() {
            return this.f481d;
        }

        List<Object> o() {
            if ((this.j & 1024) != 0) {
                return s;
            }
            List<Object> list = this.k;
            return (list == null || list.size() == 0) ? s : this.l;
        }

        boolean p(int i) {
            return (i & this.j) != 0;
        }

        boolean q() {
            return (this.j & 512) != 0 || t();
        }

        boolean r() {
            return (this.a.getParent() == null || this.a.getParent() == this.r) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean s() {
            return (this.j & 1) != 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean t() {
            return (this.j & 4) != 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder((getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName()) + "{" + Integer.toHexString(hashCode()) + " position=" + this.f480c + " id=" + this.f482e + ", oldPos=" + this.f481d + ", pLpos:" + this.g);
            if (w()) {
                sb.append(" scrap ");
                sb.append(this.o ? "[changeScrap]" : "[attachedScrap]");
            }
            if (t()) {
                sb.append(" invalid");
            }
            if (!s()) {
                sb.append(" unbound");
            }
            if (z()) {
                sb.append(" update");
            }
            if (v()) {
                sb.append(" removed");
            }
            if (J()) {
                sb.append(" ignored");
            }
            if (x()) {
                sb.append(" tmpDetached");
            }
            if (!u()) {
                sb.append(" not recyclable(" + this.m + ")");
            }
            if (q()) {
                sb.append(" undefined adapter position");
            }
            if (this.a.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public final boolean u() {
            return (this.j & 16) == 0 && !c.f.l.s.L(this.a);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean v() {
            return (this.j & 8) != 0;
        }

        boolean w() {
            return this.n != null;
        }

        boolean x() {
            return (this.j & 256) != 0;
        }

        boolean y() {
            return (this.j & 2) != 0;
        }

        boolean z() {
            return (this.j & 2) != 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements b.InterfaceC0015b {
        d() {
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0015b
        public View a(int i) {
            return RecyclerView.this.getChildAt(i);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0015b
        public void b(View view) {
            c0 f0 = RecyclerView.f0(view);
            if (f0 != null) {
                f0.B(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0015b
        public void c(int i) {
            View childAt = RecyclerView.this.getChildAt(i);
            if (childAt != null) {
                RecyclerView.this.z(childAt);
                childAt.clearAnimation();
            }
            RecyclerView.this.removeViewAt(i);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0015b
        public void d() {
            int k = k();
            for (int i = 0; i < k; i++) {
                View a = a(i);
                RecyclerView.this.z(a);
                a.clearAnimation();
            }
            RecyclerView.this.removeAllViews();
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0015b
        public c0 e(View view) {
            return RecyclerView.f0(view);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0015b
        public void f(int i) {
            c0 f0;
            View a = a(i);
            if (a != null && (f0 = RecyclerView.f0(a)) != null) {
                if (f0.x() && !f0.J()) {
                    throw new IllegalArgumentException("called detach on an already detached child " + f0 + RecyclerView.this.P());
                }
                f0.b(256);
            }
            RecyclerView.this.detachViewFromParent(i);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0015b
        public void g(View view) {
            c0 f0 = RecyclerView.f0(view);
            if (f0 != null) {
                f0.C(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0015b
        public void h(View view, int i, ViewGroup.LayoutParams layoutParams) {
            c0 f0 = RecyclerView.f0(view);
            if (f0 != null) {
                if (!f0.x() && !f0.J()) {
                    throw new IllegalArgumentException("Called attach on a child which is not detached: " + f0 + RecyclerView.this.P());
                }
                f0.f();
            }
            RecyclerView.this.attachViewToParent(view, i, layoutParams);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0015b
        public void i(View view, int i) {
            RecyclerView.this.addView(view, i);
            RecyclerView.this.y(view);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0015b
        public int j(View view) {
            return RecyclerView.this.indexOfChild(view);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0015b
        public int k() {
            return RecyclerView.this.getChildCount();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements a.InterfaceC0014a {
        e() {
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0014a
        public void a(int i, int i2) {
            RecyclerView.this.B0(i, i2);
            RecyclerView.this.n0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0014a
        public void b(a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0014a
        public c0 c(int i) {
            c0 Z = RecyclerView.this.Z(i, true);
            if (Z == null || RecyclerView.this.i.n(Z.a)) {
                return null;
            }
            return Z;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0014a
        public void d(int i, int i2) {
            RecyclerView.this.C0(i, i2, true);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.n0 = true;
            recyclerView.k0.f517d += i2;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0014a
        public void e(int i, int i2) {
            RecyclerView.this.C0(i, i2, false);
            RecyclerView.this.n0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0014a
        public void f(a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0014a
        public void g(int i, int i2) {
            RecyclerView.this.A0(i, i2);
            RecyclerView.this.n0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0014a
        public void h(int i, int i2, Object obj) {
            RecyclerView.this.v1(i, i2, obj);
            RecyclerView.this.o0 = true;
        }

        void i(a.b bVar) {
            int i = bVar.a;
            if (i == 1) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.p.R0(recyclerView, bVar.f536b, bVar.f538d);
                return;
            }
            if (i == 2) {
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.p.U0(recyclerView2, bVar.f536b, bVar.f538d);
            } else if (i == 4) {
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.p.W0(recyclerView3, bVar.f536b, bVar.f538d, bVar.f537c);
            } else {
                if (i != 8) {
                    return;
                }
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.p.T0(recyclerView4, bVar.f536b, bVar.f538d, 1);
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class f<VH extends c0> {
        private final g a = new g();

        /* renamed from: b, reason: collision with root package name */
        private boolean f483b = false;

        public final void a(VH vh, int i) {
            vh.f480c = i;
            if (g()) {
                vh.f482e = d(i);
            }
            vh.F(1, 519);
            c.f.h.a.a("RV OnBindView");
            k(vh, i, vh.o());
            vh.d();
            ViewGroup.LayoutParams layoutParams = vh.a.getLayoutParams();
            if (layoutParams instanceof o) {
                ((o) layoutParams).f497c = true;
            }
            c.f.h.a.b();
        }

        public final VH b(ViewGroup viewGroup, int i) {
            try {
                c.f.h.a.a("RV CreateView");
                VH l = l(viewGroup, i);
                if (l.a.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                l.f = i;
                return l;
            } finally {
                c.f.h.a.b();
            }
        }

        public abstract int c();

        public long d(int i) {
            return -1L;
        }

        public int e(int i) {
            return 0;
        }

        public final boolean f() {
            return this.a.a();
        }

        public final boolean g() {
            return this.f483b;
        }

        public final void h() {
            this.a.b();
        }

        public void i(RecyclerView recyclerView) {
        }

        public abstract void j(VH vh, int i);

        public void k(VH vh, int i, List<Object> list) {
            j(vh, i);
        }

        public abstract VH l(ViewGroup viewGroup, int i);

        public void m(RecyclerView recyclerView) {
        }

        public boolean n(VH vh) {
            return false;
        }

        public void o(VH vh) {
        }

        public void p(VH vh) {
        }

        public void q(VH vh) {
        }

        public void r(h hVar) {
            this.a.registerObserver(hVar);
        }

        public void s(boolean z) {
            if (f()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.f483b = z;
        }

        public void t(h hVar) {
            this.a.unregisterObserver(hVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class g extends Observable<h> {
        g() {
        }

        public boolean a() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public void b() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((h) ((Observable) this).mObservers.get(size)).a();
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class h {
        public void a() {
        }
    }

    /* loaded from: classes.dex */
    public interface i {
        int a(int i, int i2);
    }

    /* loaded from: classes.dex */
    public static class j {
        protected EdgeEffect a(RecyclerView recyclerView, int i) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    /* loaded from: classes.dex */
    public static abstract class k {
        private b a = null;

        /* renamed from: b, reason: collision with root package name */
        private ArrayList<a> f484b = new ArrayList<>();

        /* renamed from: c, reason: collision with root package name */
        private long f485c = 120;

        /* renamed from: d, reason: collision with root package name */
        private long f486d = 120;

        /* renamed from: e, reason: collision with root package name */
        private long f487e = 250;
        private long f = 250;

        /* loaded from: classes.dex */
        public interface a {
            void a();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public interface b {
            void a(c0 c0Var);
        }

        /* loaded from: classes.dex */
        public static class c {
            public int a;

            /* renamed from: b, reason: collision with root package name */
            public int f488b;

            public c a(c0 c0Var) {
                b(c0Var, 0);
                return this;
            }

            public c b(c0 c0Var, int i) {
                View view = c0Var.a;
                this.a = view.getLeft();
                this.f488b = view.getTop();
                view.getRight();
                view.getBottom();
                return this;
            }
        }

        static int e(c0 c0Var) {
            int i = c0Var.j & 14;
            if (c0Var.t()) {
                return 4;
            }
            if ((i & 4) != 0) {
                return i;
            }
            int n = c0Var.n();
            int j = c0Var.j();
            return (n == -1 || j == -1 || n == j) ? i : i | 2048;
        }

        public abstract boolean a(c0 c0Var, c cVar, c cVar2);

        public abstract boolean b(c0 c0Var, c0 c0Var2, c cVar, c cVar2);

        public abstract boolean c(c0 c0Var, c cVar, c cVar2);

        public abstract boolean d(c0 c0Var, c cVar, c cVar2);

        public abstract boolean f(c0 c0Var);

        public boolean g(c0 c0Var, List<Object> list) {
            return f(c0Var);
        }

        public final void h(c0 c0Var) {
            r(c0Var);
            b bVar = this.a;
            if (bVar != null) {
                bVar.a(c0Var);
            }
        }

        public final void i() {
            int size = this.f484b.size();
            for (int i = 0; i < size; i++) {
                this.f484b.get(i).a();
            }
            this.f484b.clear();
        }

        public abstract void j(c0 c0Var);

        public abstract void k();

        public long l() {
            return this.f485c;
        }

        public long m() {
            return this.f;
        }

        public long n() {
            return this.f487e;
        }

        public long o() {
            return this.f486d;
        }

        public abstract boolean p();

        public c q() {
            return new c();
        }

        public void r(c0 c0Var) {
        }

        public c s(z zVar, c0 c0Var) {
            c q = q();
            q.a(c0Var);
            return q;
        }

        public c t(z zVar, c0 c0Var, int i, List<Object> list) {
            c q = q();
            q.a(c0Var);
            return q;
        }

        public abstract void u();

        void v(b bVar) {
            this.a = bVar;
        }
    }

    /* loaded from: classes.dex */
    private class l implements k.b {
        l() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.k.b
        public void a(c0 c0Var) {
            c0Var.G(true);
            if (c0Var.h != null && c0Var.i == null) {
                c0Var.h = null;
            }
            c0Var.i = null;
            if (c0Var.I() || RecyclerView.this.U0(c0Var.a) || !c0Var.x()) {
                return;
            }
            RecyclerView.this.removeDetachedView(c0Var.a, false);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class m {
        @Deprecated
        public void d(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void e(Rect rect, View view, RecyclerView recyclerView, z zVar) {
            d(rect, ((o) view.getLayoutParams()).a(), recyclerView);
        }

        @Deprecated
        public void f(Canvas canvas, RecyclerView recyclerView) {
        }

        public void g(Canvas canvas, RecyclerView recyclerView, z zVar) {
            f(canvas, recyclerView);
        }

        @Deprecated
        public void h(Canvas canvas, RecyclerView recyclerView) {
        }

        public void i(Canvas canvas, RecyclerView recyclerView, z zVar) {
            h(canvas, recyclerView);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class n {
        androidx.recyclerview.widget.b a;

        /* renamed from: b, reason: collision with root package name */
        RecyclerView f489b;
        y g;
        int m;
        boolean n;
        private int o;
        private int p;
        private int q;
        private int r;

        /* renamed from: c, reason: collision with root package name */
        private final o.b f490c = new a();

        /* renamed from: d, reason: collision with root package name */
        private final o.b f491d = new b();

        /* renamed from: e, reason: collision with root package name */
        androidx.recyclerview.widget.o f492e = new androidx.recyclerview.widget.o(this.f490c);
        androidx.recyclerview.widget.o f = new androidx.recyclerview.widget.o(this.f491d);
        boolean h = false;
        boolean i = false;
        boolean j = false;
        private boolean k = true;
        private boolean l = true;

        /* loaded from: classes.dex */
        class a implements o.b {
            a() {
            }

            @Override // androidx.recyclerview.widget.o.b
            public View a(int i) {
                return n.this.I(i);
            }

            @Override // androidx.recyclerview.widget.o.b
            public int b() {
                return n.this.o0() - n.this.f0();
            }

            @Override // androidx.recyclerview.widget.o.b
            public int c() {
                return n.this.e0();
            }

            @Override // androidx.recyclerview.widget.o.b
            public int d(View view) {
                return n.this.T(view) + ((ViewGroup.MarginLayoutParams) ((o) view.getLayoutParams())).rightMargin;
            }

            @Override // androidx.recyclerview.widget.o.b
            public int e(View view) {
                return n.this.Q(view) - ((ViewGroup.MarginLayoutParams) ((o) view.getLayoutParams())).leftMargin;
            }
        }

        /* loaded from: classes.dex */
        class b implements o.b {
            b() {
            }

            @Override // androidx.recyclerview.widget.o.b
            public View a(int i) {
                return n.this.I(i);
            }

            @Override // androidx.recyclerview.widget.o.b
            public int b() {
                return n.this.W() - n.this.d0();
            }

            @Override // androidx.recyclerview.widget.o.b
            public int c() {
                return n.this.g0();
            }

            @Override // androidx.recyclerview.widget.o.b
            public int d(View view) {
                return n.this.O(view) + ((ViewGroup.MarginLayoutParams) ((o) view.getLayoutParams())).bottomMargin;
            }

            @Override // androidx.recyclerview.widget.o.b
            public int e(View view) {
                return n.this.U(view) - ((ViewGroup.MarginLayoutParams) ((o) view.getLayoutParams())).topMargin;
            }
        }

        /* loaded from: classes.dex */
        public interface c {
            void a(int i, int i2);
        }

        /* loaded from: classes.dex */
        public static class d {
            public int a;

            /* renamed from: b, reason: collision with root package name */
            public int f493b;

            /* renamed from: c, reason: collision with root package name */
            public boolean f494c;

            /* renamed from: d, reason: collision with root package name */
            public boolean f495d;
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
        
            if (r5 == 1073741824) goto L14;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int K(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L1a
                if (r7 < 0) goto L11
                goto L1c
            L11:
                if (r7 != r1) goto L2f
                if (r5 == r2) goto L21
                if (r5 == 0) goto L2f
                if (r5 == r3) goto L21
                goto L2f
            L1a:
                if (r7 < 0) goto L1f
            L1c:
                r5 = 1073741824(0x40000000, float:2.0)
                goto L31
            L1f:
                if (r7 != r1) goto L23
            L21:
                r7 = r4
                goto L31
            L23:
                if (r7 != r0) goto L2f
                if (r5 == r2) goto L2c
                if (r5 != r3) goto L2a
                goto L2c
            L2a:
                r5 = 0
                goto L21
            L2c:
                r5 = -2147483648(0xffffffff80000000, float:-0.0)
                goto L21
            L2f:
                r5 = 0
                r7 = 0
            L31:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.n.K(int, int, int, int, boolean):int");
        }

        private int[] L(View view, Rect rect) {
            int[] iArr = new int[2];
            int e0 = e0();
            int g0 = g0();
            int o0 = o0() - f0();
            int W = W() - d0();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width = rect.width() + left;
            int height = rect.height() + top;
            int i = left - e0;
            int min = Math.min(0, i);
            int i2 = top - g0;
            int min2 = Math.min(0, i2);
            int i3 = width - o0;
            int max = Math.max(0, i3);
            int max2 = Math.max(0, height - W);
            if (Z() != 1) {
                if (min == 0) {
                    min = Math.min(i, max);
                }
                max = min;
            } else if (max == 0) {
                max = Math.max(min, i3);
            }
            if (min2 == 0) {
                min2 = Math.min(i2, max2);
            }
            iArr[0] = max;
            iArr[1] = min2;
            return iArr;
        }

        private void f(View view, int i, boolean z) {
            c0 f0 = RecyclerView.f0(view);
            if (z || f0.v()) {
                this.f489b.j.b(f0);
            } else {
                this.f489b.j.p(f0);
            }
            o oVar = (o) view.getLayoutParams();
            if (f0.L() || f0.w()) {
                if (f0.w()) {
                    f0.K();
                } else {
                    f0.e();
                }
                this.a.c(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.f489b) {
                int m = this.a.m(view);
                if (i == -1) {
                    i = this.a.g();
                }
                if (m == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f489b.indexOfChild(view) + this.f489b.P());
                }
                if (m != i) {
                    this.f489b.p.B0(m, i);
                }
            } else {
                this.a.a(view, i, false);
                oVar.f497c = true;
                y yVar = this.g;
                if (yVar != null && yVar.h()) {
                    this.g.k(view);
                }
            }
            if (oVar.f498d) {
                f0.a.invalidate();
                oVar.f498d = false;
            }
        }

        public static d i0(Context context, AttributeSet attributeSet, int i, int i2) {
            d dVar = new d();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.k.c.RecyclerView, i, i2);
            dVar.a = obtainStyledAttributes.getInt(c.k.c.RecyclerView_android_orientation, 1);
            dVar.f493b = obtainStyledAttributes.getInt(c.k.c.RecyclerView_spanCount, 1);
            dVar.f494c = obtainStyledAttributes.getBoolean(c.k.c.RecyclerView_reverseLayout, false);
            dVar.f495d = obtainStyledAttributes.getBoolean(c.k.c.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return dVar;
        }

        public static int n(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i2, i3) : size : Math.min(size, Math.max(i2, i3));
        }

        private boolean t0(RecyclerView recyclerView, int i, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int e0 = e0();
            int g0 = g0();
            int o0 = o0() - f0();
            int W = W() - d0();
            Rect rect = this.f489b.l;
            P(focusedChild, rect);
            return rect.left - i < o0 && rect.right - i > e0 && rect.top - i2 < W && rect.bottom - i2 > g0;
        }

        private void v1(u uVar, int i, View view) {
            c0 f0 = RecyclerView.f0(view);
            if (f0.J()) {
                return;
            }
            if (f0.t() && !f0.v() && !this.f489b.o.g()) {
                q1(i);
                uVar.C(f0);
            } else {
                x(i);
                uVar.D(view);
                this.f489b.j.k(f0);
            }
        }

        private static boolean w0(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i;
            }
            return true;
        }

        private void y(int i, View view) {
            this.a.d(i);
        }

        void A(RecyclerView recyclerView, u uVar) {
            this.i = false;
            I0(recyclerView, uVar);
        }

        public void A0(View view, int i, int i2) {
            o oVar = (o) view.getLayoutParams();
            Rect j0 = this.f489b.j0(view);
            int i3 = i + j0.left + j0.right;
            int i4 = i2 + j0.top + j0.bottom;
            int K = K(o0(), p0(), e0() + f0() + ((ViewGroup.MarginLayoutParams) oVar).leftMargin + ((ViewGroup.MarginLayoutParams) oVar).rightMargin + i3, ((ViewGroup.MarginLayoutParams) oVar).width, k());
            int K2 = K(W(), X(), g0() + d0() + ((ViewGroup.MarginLayoutParams) oVar).topMargin + ((ViewGroup.MarginLayoutParams) oVar).bottomMargin + i4, ((ViewGroup.MarginLayoutParams) oVar).height, l());
            if (F1(view, K, K2, oVar)) {
                view.measure(K, K2);
            }
        }

        void A1(int i, int i2) {
            this.q = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            this.o = mode;
            if (mode == 0 && !RecyclerView.D0) {
                this.q = 0;
            }
            this.r = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.p = mode2;
            if (mode2 != 0 || RecyclerView.D0) {
                return;
            }
            this.r = 0;
        }

        public View B(View view) {
            View R;
            RecyclerView recyclerView = this.f489b;
            if (recyclerView == null || (R = recyclerView.R(view)) == null || this.a.n(R)) {
                return null;
            }
            return R;
        }

        public void B0(int i, int i2) {
            View I = I(i);
            if (I != null) {
                x(i);
                h(I, i2);
            } else {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.f489b.toString());
            }
        }

        public void B1(int i, int i2) {
            this.f489b.setMeasuredDimension(i, i2);
        }

        public View C(int i) {
            int J = J();
            for (int i2 = 0; i2 < J; i2++) {
                View I = I(i2);
                c0 f0 = RecyclerView.f0(I);
                if (f0 != null && f0.m() == i && !f0.J() && (this.f489b.k0.e() || !f0.v())) {
                    return I;
                }
            }
            return null;
        }

        public void C0(int i) {
            RecyclerView recyclerView = this.f489b;
            if (recyclerView != null) {
                recyclerView.y0(i);
            }
        }

        public void C1(Rect rect, int i, int i2) {
            B1(n(i, rect.width() + e0() + f0(), c0()), n(i2, rect.height() + g0() + d0(), b0()));
        }

        public abstract o D();

        public void D0(int i) {
            RecyclerView recyclerView = this.f489b;
            if (recyclerView != null) {
                recyclerView.z0(i);
            }
        }

        void D1(int i, int i2) {
            int J = J();
            if (J == 0) {
                this.f489b.w(i, i2);
                return;
            }
            int i3 = Integer.MIN_VALUE;
            int i4 = Integer.MIN_VALUE;
            int i5 = Integer.MAX_VALUE;
            int i6 = Integer.MAX_VALUE;
            for (int i7 = 0; i7 < J; i7++) {
                View I = I(i7);
                Rect rect = this.f489b.l;
                P(I, rect);
                int i8 = rect.left;
                if (i8 < i5) {
                    i5 = i8;
                }
                int i9 = rect.right;
                if (i9 > i3) {
                    i3 = i9;
                }
                int i10 = rect.top;
                if (i10 < i6) {
                    i6 = i10;
                }
                int i11 = rect.bottom;
                if (i11 > i4) {
                    i4 = i11;
                }
            }
            this.f489b.l.set(i5, i6, i3, i4);
            C1(this.f489b.l, i, i2);
        }

        public o E(Context context, AttributeSet attributeSet) {
            return new o(context, attributeSet);
        }

        public void E0(f fVar, f fVar2) {
        }

        void E1(RecyclerView recyclerView) {
            int height;
            if (recyclerView == null) {
                this.f489b = null;
                this.a = null;
                height = 0;
                this.q = 0;
            } else {
                this.f489b = recyclerView;
                this.a = recyclerView.i;
                this.q = recyclerView.getWidth();
                height = recyclerView.getHeight();
            }
            this.r = height;
            this.o = 1073741824;
            this.p = 1073741824;
        }

        public o F(ViewGroup.LayoutParams layoutParams) {
            return layoutParams instanceof o ? new o((o) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new o((ViewGroup.MarginLayoutParams) layoutParams) : new o(layoutParams);
        }

        public boolean F0(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean F1(View view, int i, int i2, o oVar) {
            return (!view.isLayoutRequested() && this.k && w0(view.getWidth(), i, ((ViewGroup.MarginLayoutParams) oVar).width) && w0(view.getHeight(), i2, ((ViewGroup.MarginLayoutParams) oVar).height)) ? false : true;
        }

        public int G() {
            return -1;
        }

        public void G0(RecyclerView recyclerView) {
        }

        boolean G1() {
            return false;
        }

        public int H(View view) {
            return ((o) view.getLayoutParams()).f496b.bottom;
        }

        @Deprecated
        public void H0(RecyclerView recyclerView) {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean H1(View view, int i, int i2, o oVar) {
            return (this.k && w0(view.getMeasuredWidth(), i, ((ViewGroup.MarginLayoutParams) oVar).width) && w0(view.getMeasuredHeight(), i2, ((ViewGroup.MarginLayoutParams) oVar).height)) ? false : true;
        }

        public View I(int i) {
            androidx.recyclerview.widget.b bVar = this.a;
            if (bVar != null) {
                return bVar.f(i);
            }
            return null;
        }

        public void I0(RecyclerView recyclerView, u uVar) {
            H0(recyclerView);
        }

        public void I1(RecyclerView recyclerView, z zVar, int i) {
            Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public int J() {
            androidx.recyclerview.widget.b bVar = this.a;
            if (bVar != null) {
                return bVar.g();
            }
            return 0;
        }

        public View J0(View view, int i, u uVar, z zVar) {
            return null;
        }

        public void J1(y yVar) {
            y yVar2 = this.g;
            if (yVar2 != null && yVar != yVar2 && yVar2.h()) {
                this.g.r();
            }
            this.g = yVar;
            yVar.q(this.f489b, this);
        }

        public void K0(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f489b;
            L0(recyclerView.f, recyclerView.k0, accessibilityEvent);
        }

        void K1() {
            y yVar = this.g;
            if (yVar != null) {
                yVar.r();
            }
        }

        public void L0(u uVar, z zVar, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f489b;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z = true;
            if (!recyclerView.canScrollVertically(1) && !this.f489b.canScrollVertically(-1) && !this.f489b.canScrollHorizontally(-1) && !this.f489b.canScrollHorizontally(1)) {
                z = false;
            }
            accessibilityEvent.setScrollable(z);
            f fVar = this.f489b.o;
            if (fVar != null) {
                accessibilityEvent.setItemCount(fVar.c());
            }
        }

        public boolean L1() {
            return false;
        }

        public boolean M() {
            RecyclerView recyclerView = this.f489b;
            return recyclerView != null && recyclerView.k;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void M0(c.f.l.b0.c cVar) {
            RecyclerView recyclerView = this.f489b;
            N0(recyclerView.f, recyclerView.k0, cVar);
        }

        public int N(u uVar, z zVar) {
            RecyclerView recyclerView = this.f489b;
            if (recyclerView == null || recyclerView.o == null || !k()) {
                return 1;
            }
            return this.f489b.o.c();
        }

        public void N0(u uVar, z zVar, c.f.l.b0.c cVar) {
            if (this.f489b.canScrollVertically(-1) || this.f489b.canScrollHorizontally(-1)) {
                cVar.a(8192);
                cVar.t0(true);
            }
            if (this.f489b.canScrollVertically(1) || this.f489b.canScrollHorizontally(1)) {
                cVar.a(4096);
                cVar.t0(true);
            }
            cVar.c0(c.b.a(k0(uVar, zVar), N(uVar, zVar), v0(uVar, zVar), l0(uVar, zVar)));
        }

        public int O(View view) {
            return view.getBottom() + H(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void O0(View view, c.f.l.b0.c cVar) {
            c0 f0 = RecyclerView.f0(view);
            if (f0 == null || f0.v() || this.a.n(f0.a)) {
                return;
            }
            RecyclerView recyclerView = this.f489b;
            P0(recyclerView.f, recyclerView.k0, view, cVar);
        }

        public void P(View view, Rect rect) {
            RecyclerView.g0(view, rect);
        }

        public void P0(u uVar, z zVar, View view, c.f.l.b0.c cVar) {
            cVar.d0(c.C0037c.a(l() ? h0(view) : 0, 1, k() ? h0(view) : 0, 1, false, false));
        }

        public int Q(View view) {
            return view.getLeft() - a0(view);
        }

        public View Q0(View view, int i) {
            return null;
        }

        public int R(View view) {
            Rect rect = ((o) view.getLayoutParams()).f496b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void R0(RecyclerView recyclerView, int i, int i2) {
        }

        public int S(View view) {
            Rect rect = ((o) view.getLayoutParams()).f496b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public void S0(RecyclerView recyclerView) {
        }

        public int T(View view) {
            return view.getRight() + j0(view);
        }

        public void T0(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        public int U(View view) {
            return view.getTop() - m0(view);
        }

        public void U0(RecyclerView recyclerView, int i, int i2) {
        }

        public View V() {
            View focusedChild;
            RecyclerView recyclerView = this.f489b;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.a.n(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public void V0(RecyclerView recyclerView, int i, int i2) {
        }

        public int W() {
            return this.r;
        }

        public void W0(RecyclerView recyclerView, int i, int i2, Object obj) {
            V0(recyclerView, i, i2);
        }

        public int X() {
            return this.p;
        }

        public void X0(u uVar, z zVar) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public int Y() {
            RecyclerView recyclerView = this.f489b;
            f adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.c();
            }
            return 0;
        }

        public void Y0(z zVar) {
        }

        public int Z() {
            return c.f.l.s.y(this.f489b);
        }

        public void Z0(u uVar, z zVar, int i, int i2) {
            this.f489b.w(i, i2);
        }

        public int a0(View view) {
            return ((o) view.getLayoutParams()).f496b.left;
        }

        @Deprecated
        public boolean a1(RecyclerView recyclerView, View view, View view2) {
            return x0() || recyclerView.t0();
        }

        public void b(View view) {
            c(view, -1);
        }

        public int b0() {
            return c.f.l.s.z(this.f489b);
        }

        public boolean b1(RecyclerView recyclerView, z zVar, View view, View view2) {
            return a1(recyclerView, view, view2);
        }

        public void c(View view, int i) {
            f(view, i, true);
        }

        public int c0() {
            return c.f.l.s.A(this.f489b);
        }

        public void c1(Parcelable parcelable) {
        }

        public void d(View view) {
            e(view, -1);
        }

        public int d0() {
            RecyclerView recyclerView = this.f489b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public Parcelable d1() {
            return null;
        }

        public void e(View view, int i) {
            f(view, i, false);
        }

        public int e0() {
            RecyclerView recyclerView = this.f489b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public void e1(int i) {
        }

        public int f0() {
            RecyclerView recyclerView = this.f489b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        void f1(y yVar) {
            if (this.g == yVar) {
                this.g = null;
            }
        }

        public void g(String str) {
            RecyclerView recyclerView = this.f489b;
            if (recyclerView != null) {
                recyclerView.o(str);
            }
        }

        public int g0() {
            RecyclerView recyclerView = this.f489b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean g1(int i, Bundle bundle) {
            RecyclerView recyclerView = this.f489b;
            return h1(recyclerView.f, recyclerView.k0, i, bundle);
        }

        public void h(View view, int i) {
            i(view, i, (o) view.getLayoutParams());
        }

        public int h0(View view) {
            return ((o) view.getLayoutParams()).a();
        }

        public boolean h1(u uVar, z zVar, int i, Bundle bundle) {
            int W;
            int o0;
            int i2;
            int i3;
            RecyclerView recyclerView = this.f489b;
            if (recyclerView == null) {
                return false;
            }
            if (i == 4096) {
                W = recyclerView.canScrollVertically(1) ? (W() - g0()) - d0() : 0;
                if (this.f489b.canScrollHorizontally(1)) {
                    o0 = (o0() - e0()) - f0();
                    i2 = W;
                    i3 = o0;
                }
                i2 = W;
                i3 = 0;
            } else if (i != 8192) {
                i3 = 0;
                i2 = 0;
            } else {
                W = recyclerView.canScrollVertically(-1) ? -((W() - g0()) - d0()) : 0;
                if (this.f489b.canScrollHorizontally(-1)) {
                    o0 = -((o0() - e0()) - f0());
                    i2 = W;
                    i3 = o0;
                }
                i2 = W;
                i3 = 0;
            }
            if (i2 == 0 && i3 == 0) {
                return false;
            }
            this.f489b.n1(i3, i2, null, Integer.MIN_VALUE, true);
            return true;
        }

        public void i(View view, int i, o oVar) {
            c0 f0 = RecyclerView.f0(view);
            if (f0.v()) {
                this.f489b.j.b(f0);
            } else {
                this.f489b.j.p(f0);
            }
            this.a.c(view, i, oVar, f0.v());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean i1(View view, int i, Bundle bundle) {
            RecyclerView recyclerView = this.f489b;
            return j1(recyclerView.f, recyclerView.k0, view, i, bundle);
        }

        public void j(View view, Rect rect) {
            RecyclerView recyclerView = this.f489b;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.j0(view));
            }
        }

        public int j0(View view) {
            return ((o) view.getLayoutParams()).f496b.right;
        }

        public boolean j1(u uVar, z zVar, View view, int i, Bundle bundle) {
            return false;
        }

        public boolean k() {
            return false;
        }

        public int k0(u uVar, z zVar) {
            RecyclerView recyclerView = this.f489b;
            if (recyclerView == null || recyclerView.o == null || !l()) {
                return 1;
            }
            return this.f489b.o.c();
        }

        public void k1(u uVar) {
            for (int J = J() - 1; J >= 0; J--) {
                if (!RecyclerView.f0(I(J)).J()) {
                    n1(J, uVar);
                }
            }
        }

        public boolean l() {
            return false;
        }

        public int l0(u uVar, z zVar) {
            return 0;
        }

        void l1(u uVar) {
            int j = uVar.j();
            for (int i = j - 1; i >= 0; i--) {
                View n = uVar.n(i);
                c0 f0 = RecyclerView.f0(n);
                if (!f0.J()) {
                    f0.G(false);
                    if (f0.x()) {
                        this.f489b.removeDetachedView(n, false);
                    }
                    k kVar = this.f489b.P;
                    if (kVar != null) {
                        kVar.j(f0);
                    }
                    f0.G(true);
                    uVar.y(n);
                }
            }
            uVar.e();
            if (j > 0) {
                this.f489b.invalidate();
            }
        }

        public boolean m(o oVar) {
            return oVar != null;
        }

        public int m0(View view) {
            return ((o) view.getLayoutParams()).f496b.top;
        }

        public void m1(View view, u uVar) {
            p1(view);
            uVar.B(view);
        }

        public void n0(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((o) view.getLayoutParams()).f496b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.f489b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.f489b.n;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void n1(int i, u uVar) {
            View I = I(i);
            q1(i);
            uVar.B(I);
        }

        public void o(int i, int i2, z zVar, c cVar) {
        }

        public int o0() {
            return this.q;
        }

        public boolean o1(Runnable runnable) {
            RecyclerView recyclerView = this.f489b;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void p(int i, c cVar) {
        }

        public int p0() {
            return this.o;
        }

        public void p1(View view) {
            this.a.p(view);
        }

        public int q(z zVar) {
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean q0() {
            int J = J();
            for (int i = 0; i < J; i++) {
                ViewGroup.LayoutParams layoutParams = I(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public void q1(int i) {
            if (I(i) != null) {
                this.a.q(i);
            }
        }

        public int r(z zVar) {
            return 0;
        }

        public boolean r0() {
            return this.i;
        }

        public boolean r1(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return s1(recyclerView, view, rect, z, false);
        }

        public int s(z zVar) {
            return 0;
        }

        public boolean s0() {
            return this.j;
        }

        public boolean s1(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] L = L(view, rect);
            int i = L[0];
            int i2 = L[1];
            if ((z2 && !t0(recyclerView, i, i2)) || (i == 0 && i2 == 0)) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i, i2);
            } else {
                recyclerView.k1(i, i2);
            }
            return true;
        }

        public int t(z zVar) {
            return 0;
        }

        public void t1() {
            RecyclerView recyclerView = this.f489b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public int u(z zVar) {
            return 0;
        }

        public final boolean u0() {
            return this.l;
        }

        public void u1() {
            this.h = true;
        }

        public int v(z zVar) {
            return 0;
        }

        public boolean v0(u uVar, z zVar) {
            return false;
        }

        public void w(u uVar) {
            for (int J = J() - 1; J >= 0; J--) {
                v1(uVar, J, I(J));
            }
        }

        public int w1(int i, u uVar, z zVar) {
            return 0;
        }

        public void x(int i) {
            y(i, I(i));
        }

        public boolean x0() {
            y yVar = this.g;
            return yVar != null && yVar.h();
        }

        public void x1(int i) {
        }

        public boolean y0(View view, boolean z, boolean z2) {
            boolean z3 = this.f492e.b(view, 24579) && this.f.b(view, 24579);
            return z ? z3 : !z3;
        }

        public int y1(int i, u uVar, z zVar) {
            return 0;
        }

        void z(RecyclerView recyclerView) {
            this.i = true;
            G0(recyclerView);
        }

        public void z0(View view, int i, int i2, int i3, int i4) {
            o oVar = (o) view.getLayoutParams();
            Rect rect = oVar.f496b;
            view.layout(i + rect.left + ((ViewGroup.MarginLayoutParams) oVar).leftMargin, i2 + rect.top + ((ViewGroup.MarginLayoutParams) oVar).topMargin, (i3 - rect.right) - ((ViewGroup.MarginLayoutParams) oVar).rightMargin, (i4 - rect.bottom) - ((ViewGroup.MarginLayoutParams) oVar).bottomMargin);
        }

        void z1(RecyclerView recyclerView) {
            A1(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }
    }

    /* loaded from: classes.dex */
    public static class o extends ViewGroup.MarginLayoutParams {
        c0 a;

        /* renamed from: b, reason: collision with root package name */
        final Rect f496b;

        /* renamed from: c, reason: collision with root package name */
        boolean f497c;

        /* renamed from: d, reason: collision with root package name */
        boolean f498d;

        public o(int i, int i2) {
            super(i, i2);
            this.f496b = new Rect();
            this.f497c = true;
            this.f498d = false;
        }

        public o(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f496b = new Rect();
            this.f497c = true;
            this.f498d = false;
        }

        public o(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f496b = new Rect();
            this.f497c = true;
            this.f498d = false;
        }

        public o(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f496b = new Rect();
            this.f497c = true;
            this.f498d = false;
        }

        public o(o oVar) {
            super((ViewGroup.LayoutParams) oVar);
            this.f496b = new Rect();
            this.f497c = true;
            this.f498d = false;
        }

        public int a() {
            return this.a.m();
        }

        public boolean b() {
            return this.a.y();
        }

        public boolean c() {
            return this.a.v();
        }

        public boolean d() {
            return this.a.t();
        }
    }

    /* loaded from: classes.dex */
    public interface p {
        void a(View view);

        void b(View view);
    }

    /* loaded from: classes.dex */
    public static abstract class q {
        public abstract boolean a(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface r {
        boolean a(RecyclerView recyclerView, MotionEvent motionEvent);

        void b(RecyclerView recyclerView, MotionEvent motionEvent);

        void c(boolean z);
    }

    /* loaded from: classes.dex */
    public static abstract class s {
        public void a(RecyclerView recyclerView, int i) {
        }

        public void b(RecyclerView recyclerView, int i, int i2) {
        }
    }

    /* loaded from: classes.dex */
    public static class t {
        SparseArray<a> a = new SparseArray<>();

        /* renamed from: b, reason: collision with root package name */
        private int f499b = 0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static class a {
            final ArrayList<c0> a = new ArrayList<>();

            /* renamed from: b, reason: collision with root package name */
            int f500b = 5;

            /* renamed from: c, reason: collision with root package name */
            long f501c = 0;

            /* renamed from: d, reason: collision with root package name */
            long f502d = 0;

            a() {
            }
        }

        private a g(int i) {
            a aVar = this.a.get(i);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.a.put(i, aVar2);
            return aVar2;
        }

        void a() {
            this.f499b++;
        }

        public void b() {
            for (int i = 0; i < this.a.size(); i++) {
                this.a.valueAt(i).a.clear();
            }
        }

        void c() {
            this.f499b--;
        }

        void d(int i, long j) {
            a g = g(i);
            g.f502d = j(g.f502d, j);
        }

        void e(int i, long j) {
            a g = g(i);
            g.f501c = j(g.f501c, j);
        }

        public c0 f(int i) {
            a aVar = this.a.get(i);
            if (aVar == null || aVar.a.isEmpty()) {
                return null;
            }
            ArrayList<c0> arrayList = aVar.a;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!arrayList.get(size).r()) {
                    return arrayList.remove(size);
                }
            }
            return null;
        }

        void h(f fVar, f fVar2, boolean z) {
            if (fVar != null) {
                c();
            }
            if (!z && this.f499b == 0) {
                b();
            }
            if (fVar2 != null) {
                a();
            }
        }

        public void i(c0 c0Var) {
            int l = c0Var.l();
            ArrayList<c0> arrayList = g(l).a;
            if (this.a.get(l).f500b <= arrayList.size()) {
                return;
            }
            c0Var.D();
            arrayList.add(c0Var);
        }

        long j(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        boolean k(int i, long j, long j2) {
            long j3 = g(i).f502d;
            return j3 == 0 || j + j3 < j2;
        }

        boolean l(int i, long j, long j2) {
            long j3 = g(i).f501c;
            return j3 == 0 || j + j3 < j2;
        }
    }

    /* loaded from: classes.dex */
    public final class u {
        final ArrayList<c0> a = new ArrayList<>();

        /* renamed from: b, reason: collision with root package name */
        ArrayList<c0> f503b = null;

        /* renamed from: c, reason: collision with root package name */
        final ArrayList<c0> f504c = new ArrayList<>();

        /* renamed from: d, reason: collision with root package name */
        private final List<c0> f505d = Collections.unmodifiableList(this.a);

        /* renamed from: e, reason: collision with root package name */
        private int f506e = 2;
        int f = 2;
        t g;
        private a0 h;

        public u() {
        }

        private boolean H(c0 c0Var, int i, int i2, long j) {
            c0Var.r = RecyclerView.this;
            int l = c0Var.l();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j != Long.MAX_VALUE && !this.g.k(l, nanoTime, j)) {
                return false;
            }
            RecyclerView.this.o.a(c0Var, i);
            this.g.d(c0Var.l(), RecyclerView.this.getNanoTime() - nanoTime);
            b(c0Var);
            if (!RecyclerView.this.k0.e()) {
                return true;
            }
            c0Var.g = i2;
            return true;
        }

        private void b(c0 c0Var) {
            if (RecyclerView.this.s0()) {
                View view = c0Var.a;
                if (c.f.l.s.w(view) == 0) {
                    c.f.l.s.s0(view, 1);
                }
                androidx.recyclerview.widget.k kVar = RecyclerView.this.r0;
                if (kVar == null) {
                    return;
                }
                c.f.l.a n = kVar.n();
                if (n instanceof k.a) {
                    ((k.a) n).o(view);
                }
                c.f.l.s.i0(view, n);
            }
        }

        private void q(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    q((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                } else {
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }

        private void r(c0 c0Var) {
            View view = c0Var.a;
            if (view instanceof ViewGroup) {
                q((ViewGroup) view, false);
            }
        }

        void A(int i) {
            a(this.f504c.get(i), true);
            this.f504c.remove(i);
        }

        public void B(View view) {
            c0 f0 = RecyclerView.f0(view);
            if (f0.x()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (f0.w()) {
                f0.K();
            } else if (f0.L()) {
                f0.e();
            }
            C(f0);
            if (RecyclerView.this.P == null || f0.u()) {
                return;
            }
            RecyclerView.this.P.j(f0);
        }

        void C(c0 c0Var) {
            boolean z;
            boolean z2 = true;
            if (c0Var.w() || c0Var.a.getParent() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(c0Var.w());
                sb.append(" isAttached:");
                sb.append(c0Var.a.getParent() != null);
                sb.append(RecyclerView.this.P());
                throw new IllegalArgumentException(sb.toString());
            }
            if (c0Var.x()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + c0Var + RecyclerView.this.P());
            }
            if (c0Var.J()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.P());
            }
            boolean h = c0Var.h();
            f fVar = RecyclerView.this.o;
            if ((fVar != null && h && fVar.n(c0Var)) || c0Var.u()) {
                if (this.f <= 0 || c0Var.p(526)) {
                    z = false;
                } else {
                    int size = this.f504c.size();
                    if (size >= this.f && size > 0) {
                        A(0);
                        size--;
                    }
                    if (RecyclerView.E0 && size > 0 && !RecyclerView.this.j0.d(c0Var.f480c)) {
                        int i = size - 1;
                        while (i >= 0) {
                            if (!RecyclerView.this.j0.d(this.f504c.get(i).f480c)) {
                                break;
                            } else {
                                i--;
                            }
                        }
                        size = i + 1;
                    }
                    this.f504c.add(size, c0Var);
                    z = true;
                }
                if (!z) {
                    a(c0Var, true);
                    r1 = z;
                    RecyclerView.this.j.q(c0Var);
                    if (r1 && !z2 && h) {
                        c0Var.r = null;
                        return;
                    }
                    return;
                }
                r1 = z;
            }
            z2 = false;
            RecyclerView.this.j.q(c0Var);
            if (r1) {
            }
        }

        void D(View view) {
            ArrayList<c0> arrayList;
            c0 f0 = RecyclerView.f0(view);
            if (!f0.p(12) && f0.y() && !RecyclerView.this.p(f0)) {
                if (this.f503b == null) {
                    this.f503b = new ArrayList<>();
                }
                f0.H(this, true);
                arrayList = this.f503b;
            } else {
                if (f0.t() && !f0.v() && !RecyclerView.this.o.g()) {
                    throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.P());
                }
                f0.H(this, false);
                arrayList = this.a;
            }
            arrayList.add(f0);
        }

        void E(t tVar) {
            t tVar2 = this.g;
            if (tVar2 != null) {
                tVar2.c();
            }
            this.g = tVar;
            if (tVar == null || RecyclerView.this.getAdapter() == null) {
                return;
            }
            this.g.a();
        }

        void F(a0 a0Var) {
            this.h = a0Var;
        }

        public void G(int i) {
            this.f506e = i;
            K();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x0185  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x01a2  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x01c5  */
        /* JADX WARN: Removed duplicated region for block: B:85:0x01fe  */
        /* JADX WARN: Removed duplicated region for block: B:89:0x0221 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:93:0x020c  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x01d4  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public androidx.recyclerview.widget.RecyclerView.c0 I(int r17, boolean r18, long r19) {
            /*
                Method dump skipped, instructions count: 608
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.u.I(int, boolean, long):androidx.recyclerview.widget.RecyclerView$c0");
        }

        void J(c0 c0Var) {
            (c0Var.o ? this.f503b : this.a).remove(c0Var);
            c0Var.n = null;
            c0Var.o = false;
            c0Var.e();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void K() {
            n nVar = RecyclerView.this.p;
            this.f = this.f506e + (nVar != null ? nVar.m : 0);
            for (int size = this.f504c.size() - 1; size >= 0 && this.f504c.size() > this.f; size--) {
                A(size);
            }
        }

        boolean L(c0 c0Var) {
            if (c0Var.v()) {
                return RecyclerView.this.k0.e();
            }
            int i = c0Var.f480c;
            if (i >= 0 && i < RecyclerView.this.o.c()) {
                if (RecyclerView.this.k0.e() || RecyclerView.this.o.e(c0Var.f480c) == c0Var.l()) {
                    return !RecyclerView.this.o.g() || c0Var.k() == RecyclerView.this.o.d(c0Var.f480c);
                }
                return false;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + c0Var + RecyclerView.this.P());
        }

        void M(int i, int i2) {
            int i3;
            int i4 = i2 + i;
            for (int size = this.f504c.size() - 1; size >= 0; size--) {
                c0 c0Var = this.f504c.get(size);
                if (c0Var != null && (i3 = c0Var.f480c) >= i && i3 < i4) {
                    c0Var.b(2);
                    A(size);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(c0 c0Var, boolean z) {
            RecyclerView.r(c0Var);
            View view = c0Var.a;
            androidx.recyclerview.widget.k kVar = RecyclerView.this.r0;
            if (kVar != null) {
                c.f.l.a n = kVar.n();
                c.f.l.s.i0(view, n instanceof k.a ? ((k.a) n).n(view) : null);
            }
            if (z) {
                g(c0Var);
            }
            c0Var.r = null;
            i().i(c0Var);
        }

        public void c() {
            this.a.clear();
            z();
        }

        void d() {
            int size = this.f504c.size();
            for (int i = 0; i < size; i++) {
                this.f504c.get(i).c();
            }
            int size2 = this.a.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.a.get(i2).c();
            }
            ArrayList<c0> arrayList = this.f503b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    this.f503b.get(i3).c();
                }
            }
        }

        void e() {
            this.a.clear();
            ArrayList<c0> arrayList = this.f503b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public int f(int i) {
            if (i >= 0 && i < RecyclerView.this.k0.b()) {
                return !RecyclerView.this.k0.e() ? i : RecyclerView.this.h.m(i);
            }
            throw new IndexOutOfBoundsException("invalid position " + i + ". State item count is " + RecyclerView.this.k0.b() + RecyclerView.this.P());
        }

        void g(c0 c0Var) {
            v vVar = RecyclerView.this.q;
            if (vVar != null) {
                vVar.a(c0Var);
            }
            f fVar = RecyclerView.this.o;
            if (fVar != null) {
                fVar.q(c0Var);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.k0 != null) {
                recyclerView.j.q(c0Var);
            }
        }

        c0 h(int i) {
            int size;
            int m;
            ArrayList<c0> arrayList = this.f503b;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    c0 c0Var = this.f503b.get(i2);
                    if (!c0Var.L() && c0Var.m() == i) {
                        c0Var.b(32);
                        return c0Var;
                    }
                }
                if (RecyclerView.this.o.g() && (m = RecyclerView.this.h.m(i)) > 0 && m < RecyclerView.this.o.c()) {
                    long d2 = RecyclerView.this.o.d(m);
                    for (int i3 = 0; i3 < size; i3++) {
                        c0 c0Var2 = this.f503b.get(i3);
                        if (!c0Var2.L() && c0Var2.k() == d2) {
                            c0Var2.b(32);
                            return c0Var2;
                        }
                    }
                }
            }
            return null;
        }

        t i() {
            if (this.g == null) {
                this.g = new t();
            }
            return this.g;
        }

        int j() {
            return this.a.size();
        }

        public List<c0> k() {
            return this.f505d;
        }

        c0 l(long j, int i, boolean z) {
            for (int size = this.a.size() - 1; size >= 0; size--) {
                c0 c0Var = this.a.get(size);
                if (c0Var.k() == j && !c0Var.L()) {
                    if (i == c0Var.l()) {
                        c0Var.b(32);
                        if (c0Var.v() && !RecyclerView.this.k0.e()) {
                            c0Var.F(2, 14);
                        }
                        return c0Var;
                    }
                    if (!z) {
                        this.a.remove(size);
                        RecyclerView.this.removeDetachedView(c0Var.a, false);
                        y(c0Var.a);
                    }
                }
            }
            int size2 = this.f504c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                c0 c0Var2 = this.f504c.get(size2);
                if (c0Var2.k() == j && !c0Var2.r()) {
                    if (i == c0Var2.l()) {
                        if (!z) {
                            this.f504c.remove(size2);
                        }
                        return c0Var2;
                    }
                    if (!z) {
                        A(size2);
                        return null;
                    }
                }
            }
        }

        c0 m(int i, boolean z) {
            View e2;
            int size = this.a.size();
            for (int i2 = 0; i2 < size; i2++) {
                c0 c0Var = this.a.get(i2);
                if (!c0Var.L() && c0Var.m() == i && !c0Var.t() && (RecyclerView.this.k0.h || !c0Var.v())) {
                    c0Var.b(32);
                    return c0Var;
                }
            }
            if (z || (e2 = RecyclerView.this.i.e(i)) == null) {
                int size2 = this.f504c.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    c0 c0Var2 = this.f504c.get(i3);
                    if (!c0Var2.t() && c0Var2.m() == i && !c0Var2.r()) {
                        if (!z) {
                            this.f504c.remove(i3);
                        }
                        return c0Var2;
                    }
                }
                return null;
            }
            c0 f0 = RecyclerView.f0(e2);
            RecyclerView.this.i.s(e2);
            int m = RecyclerView.this.i.m(e2);
            if (m != -1) {
                RecyclerView.this.i.d(m);
                D(e2);
                f0.b(8224);
                return f0;
            }
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + f0 + RecyclerView.this.P());
        }

        View n(int i) {
            return this.a.get(i).a;
        }

        public View o(int i) {
            return p(i, false);
        }

        View p(int i, boolean z) {
            return I(i, z, Long.MAX_VALUE).a;
        }

        void s() {
            int size = this.f504c.size();
            for (int i = 0; i < size; i++) {
                o oVar = (o) this.f504c.get(i).a.getLayoutParams();
                if (oVar != null) {
                    oVar.f497c = true;
                }
            }
        }

        void t() {
            int size = this.f504c.size();
            for (int i = 0; i < size; i++) {
                c0 c0Var = this.f504c.get(i);
                if (c0Var != null) {
                    c0Var.b(6);
                    c0Var.a(null);
                }
            }
            f fVar = RecyclerView.this.o;
            if (fVar == null || !fVar.g()) {
                z();
            }
        }

        void u(int i, int i2) {
            int size = this.f504c.size();
            for (int i3 = 0; i3 < size; i3++) {
                c0 c0Var = this.f504c.get(i3);
                if (c0Var != null && c0Var.f480c >= i) {
                    c0Var.A(i2, true);
                }
            }
        }

        void v(int i, int i2) {
            int i3;
            int i4;
            int i5;
            int i6;
            if (i < i2) {
                i3 = -1;
                i5 = i;
                i4 = i2;
            } else {
                i3 = 1;
                i4 = i;
                i5 = i2;
            }
            int size = this.f504c.size();
            for (int i7 = 0; i7 < size; i7++) {
                c0 c0Var = this.f504c.get(i7);
                if (c0Var != null && (i6 = c0Var.f480c) >= i5 && i6 <= i4) {
                    if (i6 == i) {
                        c0Var.A(i2 - i, false);
                    } else {
                        c0Var.A(i3, false);
                    }
                }
            }
        }

        void w(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.f504c.size() - 1; size >= 0; size--) {
                c0 c0Var = this.f504c.get(size);
                if (c0Var != null) {
                    int i4 = c0Var.f480c;
                    if (i4 >= i3) {
                        c0Var.A(-i2, z);
                    } else if (i4 >= i) {
                        c0Var.b(8);
                        A(size);
                    }
                }
            }
        }

        void x(f fVar, f fVar2, boolean z) {
            c();
            i().h(fVar, fVar2, z);
        }

        void y(View view) {
            c0 f0 = RecyclerView.f0(view);
            f0.n = null;
            f0.o = false;
            f0.e();
            C(f0);
        }

        void z() {
            for (int size = this.f504c.size() - 1; size >= 0; size--) {
                A(size);
            }
            this.f504c.clear();
            if (RecyclerView.E0) {
                RecyclerView.this.j0.b();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface v {
        void a(c0 c0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class w extends h {
        w() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public void a() {
            RecyclerView.this.o(null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.k0.g = true;
            recyclerView.O0(true);
            if (RecyclerView.this.h.p()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }
    }

    /* loaded from: classes.dex */
    public static class x extends c.h.a.a {
        public static final Parcelable.Creator<x> CREATOR = new a();
        Parcelable g;

        /* loaded from: classes.dex */
        static class a implements Parcelable.ClassLoaderCreator<x> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public x createFromParcel(Parcel parcel) {
                return new x(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public x createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new x(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public x[] newArray(int i) {
                return new x[i];
            }
        }

        x(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.g = parcel.readParcelable(classLoader == null ? n.class.getClassLoader() : classLoader);
        }

        x(Parcelable parcelable) {
            super(parcelable);
        }

        void g(x xVar) {
            this.g = xVar.g;
        }

        @Override // c.h.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.g, 0);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class y {

        /* renamed from: b, reason: collision with root package name */
        private RecyclerView f507b;

        /* renamed from: c, reason: collision with root package name */
        private n f508c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f509d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f510e;
        private View f;
        private boolean h;
        private int a = -1;
        private final a g = new a(0, 0);

        /* loaded from: classes.dex */
        public static class a {
            private int a;

            /* renamed from: b, reason: collision with root package name */
            private int f511b;

            /* renamed from: c, reason: collision with root package name */
            private int f512c;

            /* renamed from: d, reason: collision with root package name */
            private int f513d;

            /* renamed from: e, reason: collision with root package name */
            private Interpolator f514e;
            private boolean f;
            private int g;

            public a(int i, int i2) {
                this(i, i2, Integer.MIN_VALUE, null);
            }

            public a(int i, int i2, int i3, Interpolator interpolator) {
                this.f513d = -1;
                this.f = false;
                this.g = 0;
                this.a = i;
                this.f511b = i2;
                this.f512c = i3;
                this.f514e = interpolator;
            }

            private void e() {
                if (this.f514e != null && this.f512c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.f512c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            boolean a() {
                return this.f513d >= 0;
            }

            public void b(int i) {
                this.f513d = i;
            }

            void c(RecyclerView recyclerView) {
                int i = this.f513d;
                if (i >= 0) {
                    this.f513d = -1;
                    recyclerView.v0(i);
                    this.f = false;
                } else {
                    if (!this.f) {
                        this.g = 0;
                        return;
                    }
                    e();
                    recyclerView.h0.f(this.a, this.f511b, this.f512c, this.f514e);
                    int i2 = this.g + 1;
                    this.g = i2;
                    if (i2 > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f = false;
                }
            }

            public void d(int i, int i2, int i3, Interpolator interpolator) {
                this.a = i;
                this.f511b = i2;
                this.f512c = i3;
                this.f514e = interpolator;
                this.f = true;
            }
        }

        /* loaded from: classes.dex */
        public interface b {
            PointF a(int i);
        }

        public PointF a(int i) {
            Object e2 = e();
            if (e2 instanceof b) {
                return ((b) e2).a(i);
            }
            Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + b.class.getCanonicalName());
            return null;
        }

        public View b(int i) {
            return this.f507b.p.C(i);
        }

        public int c() {
            return this.f507b.p.J();
        }

        public int d(View view) {
            return this.f507b.d0(view);
        }

        public n e() {
            return this.f508c;
        }

        public int f() {
            return this.a;
        }

        public boolean g() {
            return this.f509d;
        }

        public boolean h() {
            return this.f510e;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void i(PointF pointF) {
            float f = pointF.x;
            float f2 = pointF.y;
            float sqrt = (float) Math.sqrt((f * f) + (f2 * f2));
            pointF.x /= sqrt;
            pointF.y /= sqrt;
        }

        void j(int i, int i2) {
            PointF a2;
            RecyclerView recyclerView = this.f507b;
            if (this.a == -1 || recyclerView == null) {
                r();
            }
            if (this.f509d && this.f == null && this.f508c != null && (a2 = a(this.a)) != null && (a2.x != 0.0f || a2.y != 0.0f)) {
                recyclerView.f1((int) Math.signum(a2.x), (int) Math.signum(a2.y), null);
            }
            this.f509d = false;
            View view = this.f;
            if (view != null) {
                if (d(view) == this.a) {
                    o(this.f, recyclerView.k0, this.g);
                    this.g.c(recyclerView);
                    r();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f = null;
                }
            }
            if (this.f510e) {
                l(i, i2, recyclerView.k0, this.g);
                boolean a3 = this.g.a();
                this.g.c(recyclerView);
                if (a3 && this.f510e) {
                    this.f509d = true;
                    recyclerView.h0.e();
                }
            }
        }

        protected void k(View view) {
            if (d(view) == f()) {
                this.f = view;
            }
        }

        protected abstract void l(int i, int i2, z zVar, a aVar);

        protected abstract void m();

        protected abstract void n();

        protected abstract void o(View view, z zVar, a aVar);

        public void p(int i) {
            this.a = i;
        }

        void q(RecyclerView recyclerView, n nVar) {
            recyclerView.h0.g();
            if (this.h) {
                Log.w("RecyclerView", "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.f507b = recyclerView;
            this.f508c = nVar;
            int i = this.a;
            if (i == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            recyclerView.k0.a = i;
            this.f510e = true;
            this.f509d = true;
            this.f = b(f());
            m();
            this.f507b.h0.e();
            this.h = true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void r() {
            if (this.f510e) {
                this.f510e = false;
                n();
                this.f507b.k0.a = -1;
                this.f = null;
                this.a = -1;
                this.f509d = false;
                this.f508c.f1(this);
                this.f508c = null;
                this.f507b = null;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class z {

        /* renamed from: b, reason: collision with root package name */
        private SparseArray<Object> f515b;
        int m;
        long n;
        int o;
        int p;
        int q;
        int a = -1;

        /* renamed from: c, reason: collision with root package name */
        int f516c = 0;

        /* renamed from: d, reason: collision with root package name */
        int f517d = 0;

        /* renamed from: e, reason: collision with root package name */
        int f518e = 1;
        int f = 0;
        boolean g = false;
        boolean h = false;
        boolean i = false;
        boolean j = false;
        boolean k = false;
        boolean l = false;

        void a(int i) {
            if ((this.f518e & i) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.f518e));
        }

        public int b() {
            return this.h ? this.f516c - this.f517d : this.f;
        }

        public int c() {
            return this.a;
        }

        public boolean d() {
            return this.a != -1;
        }

        public boolean e() {
            return this.h;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void f(f fVar) {
            this.f518e = 1;
            this.f = fVar.c();
            this.h = false;
            this.i = false;
            this.j = false;
        }

        public boolean g() {
            return this.l;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.a + ", mData=" + this.f515b + ", mItemCount=" + this.f + ", mIsMeasuring=" + this.j + ", mPreviousLayoutItemCount=" + this.f516c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f517d + ", mStructureChanged=" + this.g + ", mInPreLayout=" + this.h + ", mRunSimpleAnimations=" + this.k + ", mRunPredictiveAnimations=" + this.l + '}';
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        C0 = i2 == 18 || i2 == 19 || i2 == 20;
        D0 = Build.VERSION.SDK_INT >= 23;
        int i3 = Build.VERSION.SDK_INT;
        E0 = Build.VERSION.SDK_INT >= 21;
        F0 = Build.VERSION.SDK_INT <= 15;
        G0 = Build.VERSION.SDK_INT <= 15;
        Class<?> cls = Integer.TYPE;
        H0 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        I0 = new b();
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.k.a.recyclerViewStyle);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f476e = new w();
        this.f = new u();
        this.j = new androidx.recyclerview.widget.p();
        this.l = new Rect();
        this.m = new Rect();
        this.n = new RectF();
        this.r = new ArrayList<>();
        this.s = new ArrayList<>();
        this.y = 0;
        this.G = false;
        this.H = false;
        this.I = 0;
        this.J = 0;
        this.K = new j();
        this.P = new androidx.recyclerview.widget.c();
        this.Q = 0;
        this.R = -1;
        this.e0 = Float.MIN_VALUE;
        this.f0 = Float.MIN_VALUE;
        boolean z2 = true;
        this.g0 = true;
        this.h0 = new b0();
        this.j0 = E0 ? new e.b() : null;
        this.k0 = new z();
        this.n0 = false;
        this.o0 = false;
        this.p0 = new l();
        this.q0 = false;
        this.t0 = new int[2];
        this.v0 = new int[2];
        this.w0 = new int[2];
        this.x0 = new int[2];
        this.y0 = new ArrayList();
        this.z0 = new a();
        this.A0 = new c();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.a0 = viewConfiguration.getScaledTouchSlop();
        this.e0 = c.f.l.t.b(viewConfiguration, context);
        this.f0 = c.f.l.t.d(viewConfiguration, context);
        this.c0 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.d0 = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.P.v(this.p0);
        n0();
        p0();
        o0();
        if (c.f.l.s.w(this) == 0) {
            c.f.l.s.s0(this, 1);
        }
        this.E = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new androidx.recyclerview.widget.k(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.k.c.RecyclerView, i2, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, c.k.c.RecyclerView, attributeSet, obtainStyledAttributes, i2, 0);
        }
        String string = obtainStyledAttributes.getString(c.k.c.RecyclerView_layoutManager);
        if (obtainStyledAttributes.getInt(c.k.c.RecyclerView_android_descendantFocusability, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.k = obtainStyledAttributes.getBoolean(c.k.c.RecyclerView_android_clipToPadding, true);
        boolean z3 = obtainStyledAttributes.getBoolean(c.k.c.RecyclerView_fastScrollEnabled, false);
        this.w = z3;
        if (z3) {
            q0((StateListDrawable) obtainStyledAttributes.getDrawable(c.k.c.RecyclerView_fastScrollVerticalThumbDrawable), obtainStyledAttributes.getDrawable(c.k.c.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) obtainStyledAttributes.getDrawable(c.k.c.RecyclerView_fastScrollHorizontalThumbDrawable), obtainStyledAttributes.getDrawable(c.k.c.RecyclerView_fastScrollHorizontalTrackDrawable));
        }
        obtainStyledAttributes.recycle();
        v(context, string, attributeSet, i2, 0);
        if (Build.VERSION.SDK_INT >= 21) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, B0, i2, 0);
            if (Build.VERSION.SDK_INT >= 29) {
                saveAttributeDataForStyleable(context, B0, attributeSet, obtainStyledAttributes2, i2, 0);
            }
            z2 = obtainStyledAttributes2.getBoolean(0, true);
            obtainStyledAttributes2.recycle();
        }
        setNestedScrollingEnabled(z2);
    }

    private void A() {
        int i2 = this.C;
        this.C = 0;
        if (i2 == 0 || !s0()) {
            return;
        }
        AccessibilityEvent obtain = AccessibilityEvent.obtain();
        obtain.setEventType(2048);
        c.f.l.b0.b.b(obtain, i2);
        sendAccessibilityEventUnchecked(obtain);
    }

    private void C() {
        this.k0.a(1);
        Q(this.k0);
        this.k0.j = false;
        p1();
        this.j.f();
        F0();
        N0();
        c1();
        z zVar = this.k0;
        zVar.i = zVar.k && this.o0;
        this.o0 = false;
        this.n0 = false;
        z zVar2 = this.k0;
        zVar2.h = zVar2.l;
        zVar2.f = this.o.c();
        U(this.t0);
        if (this.k0.k) {
            int g2 = this.i.g();
            for (int i2 = 0; i2 < g2; i2++) {
                c0 f0 = f0(this.i.f(i2));
                if (!f0.J() && (!f0.t() || this.o.g())) {
                    this.j.e(f0, this.P.t(this.k0, f0, k.e(f0), f0.o()));
                    if (this.k0.i && f0.y() && !f0.v() && !f0.J() && !f0.t()) {
                        this.j.c(c0(f0), f0);
                    }
                }
            }
        }
        if (this.k0.l) {
            d1();
            z zVar3 = this.k0;
            boolean z2 = zVar3.g;
            zVar3.g = false;
            this.p.X0(this.f, zVar3);
            this.k0.g = z2;
            for (int i3 = 0; i3 < this.i.g(); i3++) {
                c0 f02 = f0(this.i.f(i3));
                if (!f02.J() && !this.j.i(f02)) {
                    int e2 = k.e(f02);
                    boolean p2 = f02.p(8192);
                    if (!p2) {
                        e2 |= 4096;
                    }
                    k.c t2 = this.P.t(this.k0, f02, e2, f02.o());
                    if (p2) {
                        Q0(f02, t2);
                    } else {
                        this.j.a(f02, t2);
                    }
                }
            }
        }
        s();
        G0();
        r1(false);
        this.k0.f518e = 2;
    }

    private void D() {
        p1();
        F0();
        this.k0.a(6);
        this.h.j();
        this.k0.f = this.o.c();
        z zVar = this.k0;
        zVar.f517d = 0;
        zVar.h = false;
        this.p.X0(this.f, zVar);
        z zVar2 = this.k0;
        zVar2.g = false;
        this.g = null;
        zVar2.k = zVar2.k && this.P != null;
        this.k0.f518e = 4;
        G0();
        r1(false);
    }

    private void E() {
        this.k0.a(4);
        p1();
        F0();
        z zVar = this.k0;
        zVar.f518e = 1;
        if (zVar.k) {
            for (int g2 = this.i.g() - 1; g2 >= 0; g2--) {
                c0 f0 = f0(this.i.f(g2));
                if (!f0.J()) {
                    long c02 = c0(f0);
                    k.c s2 = this.P.s(this.k0, f0);
                    c0 g3 = this.j.g(c02);
                    if (g3 != null && !g3.J()) {
                        boolean h2 = this.j.h(g3);
                        boolean h3 = this.j.h(f0);
                        if (!h2 || g3 != f0) {
                            k.c n2 = this.j.n(g3);
                            this.j.d(f0, s2);
                            k.c m2 = this.j.m(f0);
                            if (n2 == null) {
                                k0(c02, f0, g3);
                            } else {
                                m(g3, f0, n2, m2, h2, h3);
                            }
                        }
                    }
                    this.j.d(f0, s2);
                }
            }
            this.j.o(this.A0);
        }
        this.p.l1(this.f);
        z zVar2 = this.k0;
        zVar2.f516c = zVar2.f;
        this.G = false;
        this.H = false;
        zVar2.k = false;
        zVar2.l = false;
        this.p.h = false;
        ArrayList<c0> arrayList = this.f.f503b;
        if (arrayList != null) {
            arrayList.clear();
        }
        n nVar = this.p;
        if (nVar.n) {
            nVar.m = 0;
            nVar.n = false;
            this.f.K();
        }
        this.p.Y0(this.k0);
        G0();
        r1(false);
        this.j.f();
        int[] iArr = this.t0;
        if (x(iArr[0], iArr[1])) {
            I(0, 0);
        }
        R0();
        a1();
    }

    private void I0(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.R) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.R = motionEvent.getPointerId(i2);
            int x2 = (int) (motionEvent.getX(i2) + 0.5f);
            this.V = x2;
            this.T = x2;
            int y2 = (int) (motionEvent.getY(i2) + 0.5f);
            this.W = y2;
            this.U = y2;
        }
    }

    private boolean K(MotionEvent motionEvent) {
        r rVar = this.t;
        if (rVar == null) {
            if (motionEvent.getAction() == 0) {
                return false;
            }
            return T(motionEvent);
        }
        rVar.b(this, motionEvent);
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.t = null;
        }
        return true;
    }

    private boolean M0() {
        return this.P != null && this.p.L1();
    }

    private void N0() {
        if (this.G) {
            this.h.u();
            if (this.H) {
                this.p.S0(this);
            }
        }
        if (M0()) {
            this.h.s();
        } else {
            this.h.j();
        }
        boolean z2 = false;
        boolean z3 = this.n0 || this.o0;
        this.k0.k = this.x && this.P != null && (this.G || z3 || this.p.h) && (!this.G || this.o.g());
        z zVar = this.k0;
        if (zVar.k && z3 && !this.G && M0()) {
            z2 = true;
        }
        zVar.l = z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void P0(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 1
            r2 = 0
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 >= 0) goto L21
            r6.M()
            android.widget.EdgeEffect r3 = r6.L
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r0 - r9
        L1c:
            androidx.core.widget.d.a(r3, r4, r9)
            r9 = 1
            goto L39
        L21:
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 <= 0) goto L38
            r6.N()
            android.widget.EdgeEffect r3 = r6.N
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            goto L1c
        L38:
            r9 = 0
        L39:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 >= 0) goto L53
            r6.O()
            android.widget.EdgeEffect r9 = r6.M
            float r0 = -r10
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r0 = r0 / r3
            int r3 = r6.getWidth()
            float r3 = (float) r3
            float r7 = r7 / r3
            androidx.core.widget.d.a(r9, r0, r7)
            goto L6f
        L53:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 <= 0) goto L6e
            r6.L()
            android.widget.EdgeEffect r9 = r6.O
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r3 = r10 / r3
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r0 = r0 - r7
            androidx.core.widget.d.a(r9, r3, r0)
            goto L6f
        L6e:
            r1 = r9
        L6f:
            if (r1 != 0) goto L79
            int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r7 != 0) goto L79
            int r7 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r7 == 0) goto L7c
        L79:
            c.f.l.s.Z(r6)
        L7c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.P0(float, float, float, float):void");
    }

    private void R0() {
        View findViewById;
        if (!this.g0 || this.o == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (!G0 || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                if (!this.i.n(focusedChild)) {
                    return;
                }
            } else if (this.i.g() == 0) {
                requestFocus();
                return;
            }
        }
        View view = null;
        c0 Y = (this.k0.n == -1 || !this.o.g()) ? null : Y(this.k0.n);
        if (Y != null && !this.i.n(Y.a) && Y.a.hasFocusable()) {
            view = Y.a;
        } else if (this.i.g() > 0) {
            view = W();
        }
        if (view != null) {
            int i2 = this.k0.o;
            if (i2 != -1 && (findViewById = view.findViewById(i2)) != null && findViewById.isFocusable()) {
                view = findViewById;
            }
            view.requestFocus();
        }
    }

    private void S0() {
        boolean z2;
        EdgeEffect edgeEffect = this.L;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z2 = this.L.isFinished();
        } else {
            z2 = false;
        }
        EdgeEffect edgeEffect2 = this.M;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z2 |= this.M.isFinished();
        }
        EdgeEffect edgeEffect3 = this.N;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z2 |= this.N.isFinished();
        }
        EdgeEffect edgeEffect4 = this.O;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z2 |= this.O.isFinished();
        }
        if (z2) {
            c.f.l.s.Z(this);
        }
    }

    private boolean T(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.s.size();
        for (int i2 = 0; i2 < size; i2++) {
            r rVar = this.s.get(i2);
            if (rVar.a(this, motionEvent) && action != 3) {
                this.t = rVar;
                return true;
            }
        }
        return false;
    }

    private void U(int[] iArr) {
        int g2 = this.i.g();
        if (g2 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        for (int i4 = 0; i4 < g2; i4++) {
            c0 f0 = f0(this.i.f(i4));
            if (!f0.J()) {
                int m2 = f0.m();
                if (m2 < i2) {
                    i2 = m2;
                }
                if (m2 > i3) {
                    i3 = m2;
                }
            }
        }
        iArr[0] = i2;
        iArr[1] = i3;
    }

    static RecyclerView V(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView V = V(viewGroup.getChildAt(i2));
            if (V != null) {
                return V;
            }
        }
        return null;
    }

    private View W() {
        c0 X;
        int i2 = this.k0.m;
        if (i2 == -1) {
            i2 = 0;
        }
        int b2 = this.k0.b();
        for (int i3 = i2; i3 < b2; i3++) {
            c0 X2 = X(i3);
            if (X2 == null) {
                break;
            }
            if (X2.a.hasFocusable()) {
                return X2.a;
            }
        }
        int min = Math.min(b2, i2);
        do {
            min--;
            if (min < 0 || (X = X(min)) == null) {
                return null;
            }
        } while (!X.a.hasFocusable());
        return X.a;
    }

    private void Z0(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.l.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof o) {
            o oVar = (o) layoutParams;
            if (!oVar.f497c) {
                Rect rect = oVar.f496b;
                Rect rect2 = this.l;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.l);
            offsetRectIntoDescendantCoords(view, this.l);
        }
        this.p.s1(this, view, this.l, !this.x, view2 == null);
    }

    private void a1() {
        z zVar = this.k0;
        zVar.n = -1L;
        zVar.m = -1;
        zVar.o = -1;
    }

    private void b1() {
        VelocityTracker velocityTracker = this.S;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        s1(0);
        S0();
    }

    private void c1() {
        View focusedChild = (this.g0 && hasFocus() && this.o != null) ? getFocusedChild() : null;
        c0 S = focusedChild != null ? S(focusedChild) : null;
        if (S == null) {
            a1();
            return;
        }
        this.k0.n = this.o.g() ? S.k() : -1L;
        this.k0.m = this.G ? -1 : S.v() ? S.f481d : S.j();
        this.k0.o = h0(S.a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c0 f0(View view) {
        if (view == null) {
            return null;
        }
        return ((o) view.getLayoutParams()).a;
    }

    private void g(c0 c0Var) {
        View view = c0Var.a;
        boolean z2 = view.getParent() == this;
        this.f.J(e0(view));
        if (c0Var.x()) {
            this.i.c(view, -1, view.getLayoutParams(), true);
            return;
        }
        androidx.recyclerview.widget.b bVar = this.i;
        if (z2) {
            bVar.k(view);
        } else {
            bVar.b(view, true);
        }
    }

    static void g0(View view, Rect rect) {
        o oVar = (o) view.getLayoutParams();
        Rect rect2 = oVar.f496b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) oVar).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) oVar).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) oVar).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) oVar).bottomMargin);
    }

    private c.f.l.k getScrollingChildHelper() {
        if (this.u0 == null) {
            this.u0 = new c.f.l.k(this);
        }
        return this.u0;
    }

    private int h0(View view) {
        int id;
        loop0: while (true) {
            id = view.getId();
            while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
                view = ((ViewGroup) view).getFocusedChild();
                if (view.getId() != -1) {
                    break;
                }
            }
        }
        return id;
    }

    private void h1(f fVar, boolean z2, boolean z3) {
        f fVar2 = this.o;
        if (fVar2 != null) {
            fVar2.t(this.f476e);
            this.o.m(this);
        }
        if (!z2 || z3) {
            T0();
        }
        this.h.u();
        f fVar3 = this.o;
        this.o = fVar;
        if (fVar != null) {
            fVar.r(this.f476e);
            fVar.i(this);
        }
        n nVar = this.p;
        if (nVar != null) {
            nVar.E0(fVar3, this.o);
        }
        this.f.x(fVar3, this.o, z2);
        this.k0.g = true;
    }

    private String i0(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        if (str.contains(".")) {
            return str;
        }
        return RecyclerView.class.getPackage().getName() + '.' + str;
    }

    private void k0(long j2, c0 c0Var, c0 c0Var2) {
        int g2 = this.i.g();
        for (int i2 = 0; i2 < g2; i2++) {
            c0 f0 = f0(this.i.f(i2));
            if (f0 != c0Var && c0(f0) == j2) {
                f fVar = this.o;
                if (fVar == null || !fVar.g()) {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + f0 + " \n View Holder 2:" + c0Var + P());
                }
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + f0 + " \n View Holder 2:" + c0Var + P());
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + c0Var2 + " cannot be found but it is necessary for " + c0Var + P());
    }

    private void m(c0 c0Var, c0 c0Var2, k.c cVar, k.c cVar2, boolean z2, boolean z3) {
        c0Var.G(false);
        if (z2) {
            g(c0Var);
        }
        if (c0Var != c0Var2) {
            if (z3) {
                g(c0Var2);
            }
            c0Var.h = c0Var2;
            g(c0Var);
            this.f.J(c0Var);
            c0Var2.G(false);
            c0Var2.i = c0Var;
        }
        if (this.P.b(c0Var, c0Var2, cVar, cVar2)) {
            L0();
        }
    }

    private boolean m0() {
        int g2 = this.i.g();
        for (int i2 = 0; i2 < g2; i2++) {
            c0 f0 = f0(this.i.f(i2));
            if (f0 != null && !f0.J() && f0.y()) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"InlinedApi"})
    private void o0() {
        if (c.f.l.s.x(this) == 0) {
            c.f.l.s.t0(this, 8);
        }
    }

    private void p0() {
        this.i = new androidx.recyclerview.widget.b(new d());
    }

    private void q() {
        b1();
        setScrollState(0);
    }

    static void r(c0 c0Var) {
        WeakReference<RecyclerView> weakReference = c0Var.f479b;
        if (weakReference != null) {
            Object obj = weakReference.get();
            while (true) {
                for (View view = (View) obj; view != null; view = null) {
                    if (view == c0Var.a) {
                        return;
                    }
                    obj = view.getParent();
                    if (obj instanceof View) {
                        break;
                    }
                }
                c0Var.f479b = null;
                return;
            }
        }
    }

    private boolean u0(View view, View view2, int i2) {
        int i3;
        if (view2 == null || view2 == this || R(view2) == null) {
            return false;
        }
        if (view == null || R(view) == null) {
            return true;
        }
        this.l.set(0, 0, view.getWidth(), view.getHeight());
        this.m.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.l);
        offsetDescendantRectToMyCoords(view2, this.m);
        char c2 = 65535;
        int i4 = this.p.Z() == 1 ? -1 : 1;
        Rect rect = this.l;
        int i5 = rect.left;
        int i6 = this.m.left;
        if ((i5 < i6 || rect.right <= i6) && this.l.right < this.m.right) {
            i3 = 1;
        } else {
            Rect rect2 = this.l;
            int i7 = rect2.right;
            int i8 = this.m.right;
            i3 = ((i7 > i8 || rect2.left >= i8) && this.l.left > this.m.left) ? -1 : 0;
        }
        Rect rect3 = this.l;
        int i9 = rect3.top;
        int i10 = this.m.top;
        if ((i9 < i10 || rect3.bottom <= i10) && this.l.bottom < this.m.bottom) {
            c2 = 1;
        } else {
            Rect rect4 = this.l;
            int i11 = rect4.bottom;
            int i12 = this.m.bottom;
            if ((i11 <= i12 && rect4.top < i12) || this.l.top <= this.m.top) {
                c2 = 0;
            }
        }
        if (i2 == 1) {
            return c2 < 0 || (c2 == 0 && i3 * i4 <= 0);
        }
        if (i2 == 2) {
            return c2 > 0 || (c2 == 0 && i3 * i4 >= 0);
        }
        if (i2 == 17) {
            return i3 < 0;
        }
        if (i2 == 33) {
            return c2 < 0;
        }
        if (i2 == 66) {
            return i3 > 0;
        }
        if (i2 == 130) {
            return c2 > 0;
        }
        throw new IllegalArgumentException("Invalid direction: " + i2 + P());
    }

    private void u1() {
        this.h0.g();
        n nVar = this.p;
        if (nVar != null) {
            nVar.K1();
        }
    }

    private void v(Context context, String str, AttributeSet attributeSet, int i2, int i3) {
        Constructor constructor;
        if (str != null) {
            String trim = str.trim();
            if (trim.isEmpty()) {
                return;
            }
            String i0 = i0(context, trim);
            try {
                Class<? extends U> asSubclass = Class.forName(i0, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(n.class);
                Object[] objArr = null;
                try {
                    constructor = asSubclass.getConstructor(H0);
                    objArr = new Object[]{context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
                } catch (NoSuchMethodException e2) {
                    try {
                        constructor = asSubclass.getConstructor(new Class[0]);
                    } catch (NoSuchMethodException e3) {
                        e3.initCause(e2);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + i0, e3);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((n) constructor.newInstance(objArr));
            } catch (ClassCastException e4) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + i0, e4);
            } catch (ClassNotFoundException e5) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + i0, e5);
            } catch (IllegalAccessException e6) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + i0, e6);
            } catch (InstantiationException e7) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + i0, e7);
            } catch (InvocationTargetException e8) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + i0, e8);
            }
        }
    }

    private boolean x(int i2, int i3) {
        U(this.t0);
        int[] iArr = this.t0;
        return (iArr[0] == i2 && iArr[1] == i3) ? false : true;
    }

    void A0(int i2, int i3) {
        int j2 = this.i.j();
        for (int i4 = 0; i4 < j2; i4++) {
            c0 f0 = f0(this.i.i(i4));
            if (f0 != null && !f0.J() && f0.f480c >= i2) {
                f0.A(i3, false);
                this.k0.g = true;
            }
        }
        this.f.u(i2, i3);
        requestLayout();
    }

    void B() {
        String str;
        if (this.o == null) {
            str = "No adapter attached; skipping layout";
        } else {
            if (this.p != null) {
                z zVar = this.k0;
                zVar.j = false;
                if (zVar.f518e == 1) {
                    C();
                } else if (!this.h.q() && this.p.o0() == getWidth() && this.p.W() == getHeight()) {
                    this.p.z1(this);
                    E();
                    return;
                }
                this.p.z1(this);
                D();
                E();
                return;
            }
            str = "No layout manager attached; skipping layout";
        }
        Log.e("RecyclerView", str);
    }

    void B0(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int j2 = this.i.j();
        if (i2 < i3) {
            i6 = -1;
            i5 = i2;
            i4 = i3;
        } else {
            i4 = i2;
            i5 = i3;
            i6 = 1;
        }
        for (int i8 = 0; i8 < j2; i8++) {
            c0 f0 = f0(this.i.i(i8));
            if (f0 != null && (i7 = f0.f480c) >= i5 && i7 <= i4) {
                if (i7 == i2) {
                    f0.A(i3 - i2, false);
                } else {
                    f0.A(i6, false);
                }
                this.k0.g = true;
            }
        }
        this.f.v(i2, i3);
        requestLayout();
    }

    void C0(int i2, int i3, boolean z2) {
        int i4 = i2 + i3;
        int j2 = this.i.j();
        for (int i5 = 0; i5 < j2; i5++) {
            c0 f0 = f0(this.i.i(i5));
            if (f0 != null && !f0.J()) {
                int i6 = f0.f480c;
                if (i6 >= i4) {
                    f0.A(-i3, z2);
                } else if (i6 >= i2) {
                    f0.i(i2 - 1, -i3, z2);
                }
                this.k0.g = true;
            }
        }
        this.f.w(i2, i3, z2);
        requestLayout();
    }

    public void D0(View view) {
    }

    public void E0(View view) {
    }

    public boolean F(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return getScrollingChildHelper().d(i2, i3, iArr, iArr2, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F0() {
        this.I++;
    }

    public final void G(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        getScrollingChildHelper().e(i2, i3, i4, i5, iArr, i6, iArr2);
    }

    void G0() {
        H0(true);
    }

    void H(int i2) {
        n nVar = this.p;
        if (nVar != null) {
            nVar.e1(i2);
        }
        J0(i2);
        s sVar = this.l0;
        if (sVar != null) {
            sVar.a(this, i2);
        }
        List<s> list = this.m0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.m0.get(size).a(this, i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H0(boolean z2) {
        int i2 = this.I - 1;
        this.I = i2;
        if (i2 < 1) {
            this.I = 0;
            if (z2) {
                A();
                J();
            }
        }
    }

    void I(int i2, int i3) {
        this.J++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i2, scrollY - i3);
        K0(i2, i3);
        s sVar = this.l0;
        if (sVar != null) {
            sVar.b(this, i2, i3);
        }
        List<s> list = this.m0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.m0.get(size).b(this, i2, i3);
            }
        }
        this.J--;
    }

    void J() {
        int i2;
        for (int size = this.y0.size() - 1; size >= 0; size--) {
            c0 c0Var = this.y0.get(size);
            if (c0Var.a.getParent() == this && !c0Var.J() && (i2 = c0Var.q) != -1) {
                c.f.l.s.s0(c0Var.a, i2);
                c0Var.q = -1;
            }
        }
        this.y0.clear();
    }

    public void J0(int i2) {
    }

    public void K0(int i2, int i3) {
    }

    void L() {
        int measuredWidth;
        int measuredHeight;
        if (this.O != null) {
            return;
        }
        EdgeEffect a2 = this.K.a(this, 3);
        this.O = a2;
        if (this.k) {
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        } else {
            measuredWidth = getMeasuredWidth();
            measuredHeight = getMeasuredHeight();
        }
        a2.setSize(measuredWidth, measuredHeight);
    }

    void L0() {
        if (this.q0 || !this.u) {
            return;
        }
        c.f.l.s.a0(this, this.z0);
        this.q0 = true;
    }

    void M() {
        int measuredHeight;
        int measuredWidth;
        if (this.L != null) {
            return;
        }
        EdgeEffect a2 = this.K.a(this, 0);
        this.L = a2;
        if (this.k) {
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        } else {
            measuredHeight = getMeasuredHeight();
            measuredWidth = getMeasuredWidth();
        }
        a2.setSize(measuredHeight, measuredWidth);
    }

    void N() {
        int measuredHeight;
        int measuredWidth;
        if (this.N != null) {
            return;
        }
        EdgeEffect a2 = this.K.a(this, 2);
        this.N = a2;
        if (this.k) {
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        } else {
            measuredHeight = getMeasuredHeight();
            measuredWidth = getMeasuredWidth();
        }
        a2.setSize(measuredHeight, measuredWidth);
    }

    void O() {
        int measuredWidth;
        int measuredHeight;
        if (this.M != null) {
            return;
        }
        EdgeEffect a2 = this.K.a(this, 1);
        this.M = a2;
        if (this.k) {
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        } else {
            measuredWidth = getMeasuredWidth();
            measuredHeight = getMeasuredHeight();
        }
        a2.setSize(measuredWidth, measuredHeight);
    }

    void O0(boolean z2) {
        this.H = z2 | this.H;
        this.G = true;
        x0();
    }

    String P() {
        return " " + super.toString() + ", adapter:" + this.o + ", layout:" + this.p + ", context:" + getContext();
    }

    final void Q(z zVar) {
        if (getScrollState() != 2) {
            zVar.p = 0;
            zVar.q = 0;
        } else {
            OverScroller overScroller = this.h0.g;
            zVar.p = overScroller.getFinalX() - overScroller.getCurrX();
            zVar.q = overScroller.getFinalY() - overScroller.getCurrY();
        }
    }

    void Q0(c0 c0Var, k.c cVar) {
        c0Var.F(0, 8192);
        if (this.k0.i && c0Var.y() && !c0Var.v() && !c0Var.J()) {
            this.j.c(c0(c0Var), c0Var);
        }
        this.j.e(c0Var, cVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:?, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View R(android.view.View r3) {
        /*
            r2 = this;
        L0:
            android.view.ViewParent r0 = r3.getParent()
            if (r0 == 0) goto L10
            if (r0 == r2) goto L10
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto L10
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            goto L0
        L10:
            if (r0 != r2) goto L13
            goto L14
        L13:
            r3 = 0
        L14:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.R(android.view.View):android.view.View");
    }

    public c0 S(View view) {
        View R = R(view);
        if (R == null) {
            return null;
        }
        return e0(R);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T0() {
        k kVar = this.P;
        if (kVar != null) {
            kVar.k();
        }
        n nVar = this.p;
        if (nVar != null) {
            nVar.k1(this.f);
            this.p.l1(this.f);
        }
        this.f.c();
    }

    boolean U0(View view) {
        p1();
        boolean r2 = this.i.r(view);
        if (r2) {
            c0 f0 = f0(view);
            this.f.J(f0);
            this.f.C(f0);
        }
        r1(!r2);
        return r2;
    }

    public void V0(m mVar) {
        n nVar = this.p;
        if (nVar != null) {
            nVar.g("Cannot remove item decoration during a scroll  or layout");
        }
        this.r.remove(mVar);
        if (this.r.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        w0();
        requestLayout();
    }

    public void W0(r rVar) {
        this.s.remove(rVar);
        if (this.t == rVar) {
            this.t = null;
        }
    }

    public c0 X(int i2) {
        c0 c0Var = null;
        if (this.G) {
            return null;
        }
        int j2 = this.i.j();
        for (int i3 = 0; i3 < j2; i3++) {
            c0 f0 = f0(this.i.i(i3));
            if (f0 != null && !f0.v() && b0(f0) == i2) {
                if (!this.i.n(f0.a)) {
                    return f0;
                }
                c0Var = f0;
            }
        }
        return c0Var;
    }

    public void X0(s sVar) {
        List<s> list = this.m0;
        if (list != null) {
            list.remove(sVar);
        }
    }

    public c0 Y(long j2) {
        f fVar = this.o;
        c0 c0Var = null;
        if (fVar != null && fVar.g()) {
            int j3 = this.i.j();
            for (int i2 = 0; i2 < j3; i2++) {
                c0 f0 = f0(this.i.i(i2));
                if (f0 != null && !f0.v() && f0.k() == j2) {
                    if (!this.i.n(f0.a)) {
                        return f0;
                    }
                    c0Var = f0;
                }
            }
        }
        return c0Var;
    }

    void Y0() {
        c0 c0Var;
        int g2 = this.i.g();
        for (int i2 = 0; i2 < g2; i2++) {
            View f2 = this.i.f(i2);
            c0 e0 = e0(f2);
            if (e0 != null && (c0Var = e0.i) != null) {
                View view = c0Var.a;
                int left = f2.getLeft();
                int top = f2.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0036 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    androidx.recyclerview.widget.RecyclerView.c0 Z(int r6, boolean r7) {
        /*
            r5 = this;
            androidx.recyclerview.widget.b r0 = r5.i
            int r0 = r0.j()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L3a
            androidx.recyclerview.widget.b r3 = r5.i
            android.view.View r3 = r3.i(r2)
            androidx.recyclerview.widget.RecyclerView$c0 r3 = f0(r3)
            if (r3 == 0) goto L37
            boolean r4 = r3.v()
            if (r4 != 0) goto L37
            if (r7 == 0) goto L23
            int r4 = r3.f480c
            if (r4 == r6) goto L2a
            goto L37
        L23:
            int r4 = r3.m()
            if (r4 == r6) goto L2a
            goto L37
        L2a:
            androidx.recyclerview.widget.b r1 = r5.i
            android.view.View r4 = r3.a
            boolean r1 = r1.n(r4)
            if (r1 == 0) goto L36
            r1 = r3
            goto L37
        L36:
            return r3
        L37:
            int r2 = r2 + 1
            goto L8
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.Z(int, boolean):androidx.recyclerview.widget.RecyclerView$c0");
    }

    void a(int i2, int i3) {
        if (i2 < 0) {
            M();
            if (this.L.isFinished()) {
                this.L.onAbsorb(-i2);
            }
        } else if (i2 > 0) {
            N();
            if (this.N.isFinished()) {
                this.N.onAbsorb(i2);
            }
        }
        if (i3 < 0) {
            O();
            if (this.M.isFinished()) {
                this.M.onAbsorb(-i3);
            }
        } else if (i3 > 0) {
            L();
            if (this.O.isFinished()) {
                this.O.onAbsorb(i3);
            }
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        c.f.l.s.Z(this);
    }

    public boolean a0(int i2, int i3) {
        n nVar = this.p;
        if (nVar == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.A) {
            return false;
        }
        boolean k2 = nVar.k();
        boolean l2 = this.p.l();
        if (!k2 || Math.abs(i2) < this.c0) {
            i2 = 0;
        }
        if (!l2 || Math.abs(i3) < this.c0) {
            i3 = 0;
        }
        if (i2 == 0 && i3 == 0) {
            return false;
        }
        float f2 = i2;
        float f3 = i3;
        if (!dispatchNestedPreFling(f2, f3)) {
            boolean z2 = k2 || l2;
            dispatchNestedFling(f2, f3, z2);
            q qVar = this.b0;
            if (qVar != null && qVar.a(i2, i3)) {
                return true;
            }
            if (z2) {
                int i4 = k2 ? 1 : 0;
                if (l2) {
                    i4 |= 2;
                }
                q1(i4, 1);
                int i5 = this.d0;
                int max = Math.max(-i5, Math.min(i2, i5));
                int i6 = this.d0;
                this.h0.c(max, Math.max(-i6, Math.min(i3, i6)));
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        n nVar = this.p;
        if (nVar == null || !nVar.F0(this, arrayList, i2, i3)) {
            super.addFocusables(arrayList, i2, i3);
        }
    }

    int b0(c0 c0Var) {
        if (c0Var.p(524) || !c0Var.s()) {
            return -1;
        }
        return this.h.e(c0Var.f480c);
    }

    long c0(c0 c0Var) {
        return this.o.g() ? c0Var.k() : c0Var.f480c;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof o) && this.p.m((o) layoutParams);
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        n nVar = this.p;
        if (nVar != null && nVar.k()) {
            return this.p.q(this.k0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        n nVar = this.p;
        if (nVar != null && nVar.k()) {
            return this.p.r(this.k0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        n nVar = this.p;
        if (nVar != null && nVar.k()) {
            return this.p.s(this.k0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        n nVar = this.p;
        if (nVar != null && nVar.l()) {
            return this.p.t(this.k0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        n nVar = this.p;
        if (nVar != null && nVar.l()) {
            return this.p.u(this.k0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        n nVar = this.p;
        if (nVar != null && nVar.l()) {
            return this.p.v(this.k0);
        }
        return 0;
    }

    public int d0(View view) {
        c0 f0 = f0(view);
        if (f0 != null) {
            return f0.m();
        }
        return -1;
    }

    void d1() {
        int j2 = this.i.j();
        for (int i2 = 0; i2 < j2; i2++) {
            c0 f0 = f0(this.i.i(i2));
            if (!f0.J()) {
                f0.E();
            }
        }
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return getScrollingChildHelper().a(f2, f3, z2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().b(f2, f3);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i2, i3, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().f(i2, i3, i4, i5, iArr);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z2;
        float f2;
        int i2;
        super.draw(canvas);
        int size = this.r.size();
        boolean z3 = false;
        for (int i3 = 0; i3 < size; i3++) {
            this.r.get(i3).i(canvas, this, this.k0);
        }
        EdgeEffect edgeEffect = this.L;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z2 = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.k ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.L;
            z2 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.M;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.k) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.M;
            z2 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.N;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.k ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.N;
            z2 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.O;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.k) {
                f2 = (-getWidth()) + getPaddingRight();
                i2 = (-getHeight()) + getPaddingBottom();
            } else {
                f2 = -getWidth();
                i2 = -getHeight();
            }
            canvas.translate(f2, i2);
            EdgeEffect edgeEffect8 = this.O;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z3 = true;
            }
            z2 |= z3;
            canvas.restoreToCount(save4);
        }
        if ((z2 || this.P == null || this.r.size() <= 0 || !this.P.p()) ? z2 : true) {
            c.f.l.s.Z(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    public c0 e0(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return f0(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    boolean e1(int i2, int i3, MotionEvent motionEvent) {
        int i4;
        int i5;
        int i6;
        int i7;
        u();
        if (this.o != null) {
            int[] iArr = this.x0;
            iArr[0] = 0;
            iArr[1] = 0;
            f1(i2, i3, iArr);
            int[] iArr2 = this.x0;
            int i8 = iArr2[0];
            int i9 = iArr2[1];
            i4 = i9;
            i5 = i8;
            i6 = i2 - i8;
            i7 = i3 - i9;
        } else {
            i4 = 0;
            i5 = 0;
            i6 = 0;
            i7 = 0;
        }
        if (!this.r.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.x0;
        iArr3[0] = 0;
        iArr3[1] = 0;
        G(i5, i4, i6, i7, this.v0, 0, iArr3);
        int[] iArr4 = this.x0;
        int i10 = i6 - iArr4[0];
        int i11 = i7 - iArr4[1];
        boolean z2 = (iArr4[0] == 0 && iArr4[1] == 0) ? false : true;
        int i12 = this.V;
        int[] iArr5 = this.v0;
        this.V = i12 - iArr5[0];
        this.W -= iArr5[1];
        int[] iArr6 = this.w0;
        iArr6[0] = iArr6[0] + iArr5[0];
        iArr6[1] = iArr6[1] + iArr5[1];
        if (getOverScrollMode() != 2) {
            if (motionEvent != null && !c.f.l.i.f(motionEvent, 8194)) {
                P0(motionEvent.getX(), i10, motionEvent.getY(), i11);
            }
            t(i2, i3);
        }
        if (i5 != 0 || i4 != 0) {
            I(i5, i4);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (!z2 && i5 == 0 && i4 == 0) ? false : true;
    }

    void f1(int i2, int i3, int[] iArr) {
        p1();
        F0();
        c.f.h.a.a("RV Scroll");
        Q(this.k0);
        int w1 = i2 != 0 ? this.p.w1(i2, this.f, this.k0) : 0;
        int y1 = i3 != 0 ? this.p.y1(i3, this.f, this.k0) : 0;
        c.f.h.a.b();
        Y0();
        G0();
        r1(false);
        if (iArr != null) {
            iArr[0] = w1;
            iArr[1] = y1;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i2) {
        View view2;
        boolean z2;
        View Q0 = this.p.Q0(view, i2);
        if (Q0 != null) {
            return Q0;
        }
        boolean z3 = (this.o == null || this.p == null || t0() || this.A) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z3 && (i2 == 2 || i2 == 1)) {
            if (this.p.l()) {
                int i3 = i2 == 2 ? 130 : 33;
                z2 = focusFinder.findNextFocus(this, view, i3) == null;
                if (F0) {
                    i2 = i3;
                }
            } else {
                z2 = false;
            }
            if (!z2 && this.p.k()) {
                int i4 = (this.p.Z() == 1) ^ (i2 == 2) ? 66 : 17;
                boolean z4 = focusFinder.findNextFocus(this, view, i4) == null;
                if (F0) {
                    i2 = i4;
                }
                z2 = z4;
            }
            if (z2) {
                u();
                if (R(view) == null) {
                    return null;
                }
                p1();
                this.p.J0(view, i2, this.f, this.k0);
                r1(false);
            }
            view2 = focusFinder.findNextFocus(this, view, i2);
        } else {
            View findNextFocus = focusFinder.findNextFocus(this, view, i2);
            if (findNextFocus == null && z3) {
                u();
                if (R(view) == null) {
                    return null;
                }
                p1();
                view2 = this.p.J0(view, i2, this.f, this.k0);
                r1(false);
            } else {
                view2 = findNextFocus;
            }
        }
        if (view2 == null || view2.hasFocusable()) {
            return u0(view, view2, i2) ? view2 : super.focusSearch(view, i2);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i2);
        }
        Z0(view2, null);
        return view;
    }

    public void g1(int i2) {
        if (this.A) {
            return;
        }
        t1();
        n nVar = this.p;
        if (nVar == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            nVar.x1(i2);
            awakenScrollBars();
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        n nVar = this.p;
        if (nVar != null) {
            return nVar.D();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + P());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        n nVar = this.p;
        if (nVar != null) {
            return nVar.E(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + P());
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        n nVar = this.p;
        if (nVar != null) {
            return nVar.F(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + P());
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public f getAdapter() {
        return this.o;
    }

    @Override // android.view.View
    public int getBaseline() {
        n nVar = this.p;
        return nVar != null ? nVar.G() : super.getBaseline();
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        i iVar = this.s0;
        return iVar == null ? super.getChildDrawingOrder(i2, i3) : iVar.a(i2, i3);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.k;
    }

    public androidx.recyclerview.widget.k getCompatAccessibilityDelegate() {
        return this.r0;
    }

    public j getEdgeEffectFactory() {
        return this.K;
    }

    public k getItemAnimator() {
        return this.P;
    }

    public int getItemDecorationCount() {
        return this.r.size();
    }

    public n getLayoutManager() {
        return this.p;
    }

    public int getMaxFlingVelocity() {
        return this.d0;
    }

    public int getMinFlingVelocity() {
        return this.c0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getNanoTime() {
        if (E0) {
            return System.nanoTime();
        }
        return 0L;
    }

    public q getOnFlingListener() {
        return this.b0;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.g0;
    }

    public t getRecycledViewPool() {
        return this.f.i();
    }

    public int getScrollState() {
        return this.Q;
    }

    public void h(m mVar) {
        i(mVar, -1);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().j();
    }

    public void i(m mVar, int i2) {
        n nVar = this.p;
        if (nVar != null) {
            nVar.g("Cannot add item decoration during a scroll  or layout");
        }
        if (this.r.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i2 < 0) {
            this.r.add(mVar);
        } else {
            this.r.add(i2, mVar);
        }
        w0();
        requestLayout();
    }

    boolean i1(c0 c0Var, int i2) {
        if (!t0()) {
            c.f.l.s.s0(c0Var.a, i2);
            return true;
        }
        c0Var.q = i2;
        this.y0.add(c0Var);
        return false;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.u;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.A;
    }

    @Override // android.view.View, c.f.l.j
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().l();
    }

    public void j(r rVar) {
        this.s.add(rVar);
    }

    Rect j0(View view) {
        o oVar = (o) view.getLayoutParams();
        if (!oVar.f497c) {
            return oVar.f496b;
        }
        if (this.k0.e() && (oVar.b() || oVar.d())) {
            return oVar.f496b;
        }
        Rect rect = oVar.f496b;
        rect.set(0, 0, 0, 0);
        int size = this.r.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.l.set(0, 0, 0, 0);
            this.r.get(i2).e(this.l, view, this, this.k0);
            int i3 = rect.left;
            Rect rect2 = this.l;
            rect.left = i3 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        oVar.f497c = false;
        return rect;
    }

    boolean j1(AccessibilityEvent accessibilityEvent) {
        if (!t0()) {
            return false;
        }
        int a2 = accessibilityEvent != null ? c.f.l.b0.b.a(accessibilityEvent) : 0;
        this.C |= a2 != 0 ? a2 : 0;
        return true;
    }

    public void k(s sVar) {
        if (this.m0 == null) {
            this.m0 = new ArrayList();
        }
        this.m0.add(sVar);
    }

    public void k1(int i2, int i3) {
        l1(i2, i3, null);
    }

    void l(c0 c0Var, k.c cVar, k.c cVar2) {
        c0Var.G(false);
        if (this.P.a(c0Var, cVar, cVar2)) {
            L0();
        }
    }

    public boolean l0() {
        return !this.x || this.G || this.h.p();
    }

    public void l1(int i2, int i3, Interpolator interpolator) {
        m1(i2, i3, interpolator, Integer.MIN_VALUE);
    }

    public void m1(int i2, int i3, Interpolator interpolator, int i4) {
        n1(i2, i3, interpolator, i4, false);
    }

    void n(c0 c0Var, k.c cVar, k.c cVar2) {
        g(c0Var);
        c0Var.G(false);
        if (this.P.c(c0Var, cVar, cVar2)) {
            L0();
        }
    }

    void n0() {
        this.h = new androidx.recyclerview.widget.a(new e());
    }

    void n1(int i2, int i3, Interpolator interpolator, int i4, boolean z2) {
        n nVar = this.p;
        if (nVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.A) {
            return;
        }
        if (!nVar.k()) {
            i2 = 0;
        }
        if (!this.p.l()) {
            i3 = 0;
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        if (!(i4 == Integer.MIN_VALUE || i4 > 0)) {
            scrollBy(i2, i3);
            return;
        }
        if (z2) {
            int i5 = i2 != 0 ? 1 : 0;
            if (i3 != 0) {
                i5 |= 2;
            }
            q1(i5, 1);
        }
        this.h0.f(i2, i3, i4, interpolator);
    }

    void o(String str) {
        if (t0()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + P());
        }
        if (this.J > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + P()));
        }
    }

    public void o1(int i2) {
        if (this.A) {
            return;
        }
        n nVar = this.p;
        if (nVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            nVar.I1(this, this.k0, i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.I = 0;
        this.u = true;
        this.x = this.x && !isLayoutRequested();
        n nVar = this.p;
        if (nVar != null) {
            nVar.z(this);
        }
        this.q0 = false;
        if (E0) {
            androidx.recyclerview.widget.e eVar = androidx.recyclerview.widget.e.i.get();
            this.i0 = eVar;
            if (eVar == null) {
                this.i0 = new androidx.recyclerview.widget.e();
                Display s2 = c.f.l.s.s(this);
                float f2 = 60.0f;
                if (!isInEditMode() && s2 != null) {
                    float refreshRate = s2.getRefreshRate();
                    if (refreshRate >= 30.0f) {
                        f2 = refreshRate;
                    }
                }
                androidx.recyclerview.widget.e eVar2 = this.i0;
                eVar2.g = 1.0E9f / f2;
                androidx.recyclerview.widget.e.i.set(eVar2);
            }
            this.i0.a(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        androidx.recyclerview.widget.e eVar;
        super.onDetachedFromWindow();
        k kVar = this.P;
        if (kVar != null) {
            kVar.k();
        }
        t1();
        this.u = false;
        n nVar = this.p;
        if (nVar != null) {
            nVar.A(this, this.f);
        }
        this.y0.clear();
        removeCallbacks(this.z0);
        this.j.j();
        if (!E0 || (eVar = this.i0) == null) {
            return;
        }
        eVar.j(this);
        this.i0 = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.r.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.r.get(i2).g(canvas, this, this.k0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0066  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            androidx.recyclerview.widget.RecyclerView$n r0 = r5.p
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r5.A
            if (r0 == 0) goto Lb
            return r1
        Lb:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L77
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L3c
            androidx.recyclerview.widget.RecyclerView$n r0 = r5.p
            boolean r0 = r0.l()
            if (r0 == 0) goto L2c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2d
        L2c:
            r0 = 0
        L2d:
            androidx.recyclerview.widget.RecyclerView$n r3 = r5.p
            boolean r3 = r3.k()
            if (r3 == 0) goto L61
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L62
        L3c:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L60
            r0 = 26
            float r0 = r6.getAxisValue(r0)
            androidx.recyclerview.widget.RecyclerView$n r3 = r5.p
            boolean r3 = r3.l()
            if (r3 == 0) goto L55
            float r0 = -r0
            goto L61
        L55:
            androidx.recyclerview.widget.RecyclerView$n r3 = r5.p
            boolean r3 = r3.k()
            if (r3 == 0) goto L60
            r3 = r0
            r0 = 0
            goto L62
        L60:
            r0 = 0
        L61:
            r3 = 0
        L62:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6a
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L77
        L6a:
            float r2 = r5.e0
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.f0
            float r0 = r0 * r3
            int r0 = (int) r0
            r5.e1(r2, r0, r6)
        L77:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        if (this.A) {
            return false;
        }
        this.t = null;
        if (T(motionEvent)) {
            q();
            return true;
        }
        n nVar = this.p;
        if (nVar == null) {
            return false;
        }
        boolean k2 = nVar.k();
        boolean l2 = this.p.l();
        if (this.S == null) {
            this.S = VelocityTracker.obtain();
        }
        this.S.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.B) {
                this.B = false;
            }
            this.R = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.V = x2;
            this.T = x2;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.W = y2;
            this.U = y2;
            if (this.Q == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                s1(1);
            }
            int[] iArr = this.w0;
            iArr[1] = 0;
            iArr[0] = 0;
            int i2 = k2 ? 1 : 0;
            if (l2) {
                i2 |= 2;
            }
            q1(i2, 0);
        } else if (actionMasked == 1) {
            this.S.clear();
            s1(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.R);
            if (findPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.R + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x3 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y3 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.Q != 1) {
                int i3 = x3 - this.T;
                int i4 = y3 - this.U;
                if (!k2 || Math.abs(i3) <= this.a0) {
                    z2 = false;
                } else {
                    this.V = x3;
                    z2 = true;
                }
                if (l2 && Math.abs(i4) > this.a0) {
                    this.W = y3;
                    z2 = true;
                }
                if (z2) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            q();
        } else if (actionMasked == 5) {
            this.R = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.V = x4;
            this.T = x4;
            int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.W = y4;
            this.U = y4;
        } else if (actionMasked == 6) {
            I0(motionEvent);
        }
        return this.Q == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        c.f.h.a.a("RV OnLayout");
        B();
        c.f.h.a.b();
        this.x = true;
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        n nVar = this.p;
        if (nVar == null) {
            w(i2, i3);
            return;
        }
        boolean z2 = false;
        if (nVar.s0()) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.p.Z0(this.f, this.k0, i2, i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z2 = true;
            }
            if (z2 || this.o == null) {
                return;
            }
            if (this.k0.f518e == 1) {
                C();
            }
            this.p.A1(i2, i3);
            this.k0.j = true;
            D();
            this.p.D1(i2, i3);
            if (this.p.G1()) {
                this.p.A1(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.k0.j = true;
                D();
                this.p.D1(i2, i3);
                return;
            }
            return;
        }
        if (this.v) {
            this.p.Z0(this.f, this.k0, i2, i3);
            return;
        }
        if (this.D) {
            p1();
            F0();
            N0();
            G0();
            z zVar = this.k0;
            if (zVar.l) {
                zVar.h = true;
            } else {
                this.h.j();
                this.k0.h = false;
            }
            this.D = false;
            r1(false);
        } else if (this.k0.l) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        f fVar = this.o;
        if (fVar != null) {
            this.k0.f = fVar.c();
        } else {
            this.k0.f = 0;
        }
        p1();
        this.p.Z0(this.f, this.k0, i2, i3);
        r1(false);
        this.k0.h = false;
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (t0()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof x)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        x xVar = (x) parcelable;
        this.g = xVar;
        super.onRestoreInstanceState(xVar.f());
        n nVar = this.p;
        if (nVar == null || (parcelable2 = this.g.g) == null) {
            return;
        }
        nVar.c1(parcelable2);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        x xVar = new x(super.onSaveInstanceState());
        x xVar2 = this.g;
        if (xVar2 != null) {
            xVar.g(xVar2);
        } else {
            n nVar = this.p;
            xVar.g = nVar != null ? nVar.d1() : null;
        }
        return xVar;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 == i4 && i3 == i5) {
            return;
        }
        r0();
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f4  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 485
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    boolean p(c0 c0Var) {
        k kVar = this.P;
        return kVar == null || kVar.g(c0Var, c0Var.o());
    }

    void p1() {
        int i2 = this.y + 1;
        this.y = i2;
        if (i2 != 1 || this.A) {
            return;
        }
        this.z = false;
    }

    void q0(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
            Resources resources = getContext().getResources();
            new androidx.recyclerview.widget.d(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(c.k.b.fastscroll_default_thickness), resources.getDimensionPixelSize(c.k.b.fastscroll_minimum_range), resources.getDimensionPixelOffset(c.k.b.fastscroll_margin));
        } else {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + P());
        }
    }

    public boolean q1(int i2, int i3) {
        return getScrollingChildHelper().p(i2, i3);
    }

    void r0() {
        this.O = null;
        this.M = null;
        this.N = null;
        this.L = null;
    }

    void r1(boolean z2) {
        if (this.y < 1) {
            this.y = 1;
        }
        if (!z2 && !this.A) {
            this.z = false;
        }
        if (this.y == 1) {
            if (z2 && this.z && !this.A && this.p != null && this.o != null) {
                B();
            }
            if (!this.A) {
                this.z = false;
            }
        }
        this.y--;
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z2) {
        c0 f0 = f0(view);
        if (f0 != null) {
            if (f0.x()) {
                f0.f();
            } else if (!f0.J()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + f0 + P());
            }
        }
        view.clearAnimation();
        z(view);
        super.removeDetachedView(view, z2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.p.b1(this, this.k0, view, view2) && view2 != null) {
            Z0(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        return this.p.r1(this, view, rect, z2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z2) {
        int size = this.s.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.s.get(i2).c(z2);
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.y != 0 || this.A) {
            this.z = true;
        } else {
            super.requestLayout();
        }
    }

    void s() {
        int j2 = this.i.j();
        for (int i2 = 0; i2 < j2; i2++) {
            c0 f0 = f0(this.i.i(i2));
            if (!f0.J()) {
                f0.c();
            }
        }
        this.f.d();
    }

    boolean s0() {
        AccessibilityManager accessibilityManager = this.E;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public void s1(int i2) {
        getScrollingChildHelper().r(i2);
    }

    @Override // android.view.View
    public void scrollBy(int i2, int i3) {
        n nVar = this.p;
        if (nVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.A) {
            return;
        }
        boolean k2 = nVar.k();
        boolean l2 = this.p.l();
        if (k2 || l2) {
            if (!k2) {
                i2 = 0;
            }
            if (!l2) {
                i3 = 0;
            }
            e1(i2, i3, null);
        }
    }

    @Override // android.view.View
    public void scrollTo(int i2, int i3) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (j1(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(androidx.recyclerview.widget.k kVar) {
        this.r0 = kVar;
        c.f.l.s.i0(this, kVar);
    }

    public void setAdapter(f fVar) {
        setLayoutFrozen(false);
        h1(fVar, false, true);
        O0(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(i iVar) {
        if (iVar == this.s0) {
            return;
        }
        this.s0 = iVar;
        setChildrenDrawingOrderEnabled(iVar != null);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z2) {
        if (z2 != this.k) {
            r0();
        }
        this.k = z2;
        super.setClipToPadding(z2);
        if (this.x) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(j jVar) {
        c.f.k.h.c(jVar);
        this.K = jVar;
        r0();
    }

    public void setHasFixedSize(boolean z2) {
        this.v = z2;
    }

    public void setItemAnimator(k kVar) {
        k kVar2 = this.P;
        if (kVar2 != null) {
            kVar2.k();
            this.P.v(null);
        }
        this.P = kVar;
        if (kVar != null) {
            kVar.v(this.p0);
        }
    }

    public void setItemViewCacheSize(int i2) {
        this.f.G(i2);
    }

    @Deprecated
    public void setLayoutFrozen(boolean z2) {
        suppressLayout(z2);
    }

    public void setLayoutManager(n nVar) {
        if (nVar == this.p) {
            return;
        }
        t1();
        if (this.p != null) {
            k kVar = this.P;
            if (kVar != null) {
                kVar.k();
            }
            this.p.k1(this.f);
            this.p.l1(this.f);
            this.f.c();
            if (this.u) {
                this.p.A(this, this.f);
            }
            this.p.E1(null);
            this.p = null;
        } else {
            this.f.c();
        }
        this.i.o();
        this.p = nVar;
        if (nVar != null) {
            if (nVar.f489b != null) {
                throw new IllegalArgumentException("LayoutManager " + nVar + " is already attached to a RecyclerView:" + nVar.f489b.P());
            }
            nVar.E1(this);
            if (this.u) {
                this.p.z(this);
            }
        }
        this.f.K();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (Build.VERSION.SDK_INT < 18) {
            if (layoutTransition == null) {
                suppressLayout(false);
                return;
            } else if (layoutTransition.getAnimator(0) == null && layoutTransition.getAnimator(1) == null && layoutTransition.getAnimator(2) == null && layoutTransition.getAnimator(3) == null && layoutTransition.getAnimator(4) == null) {
                suppressLayout(true);
                return;
            }
        }
        if (layoutTransition != null) {
            throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
        super.setLayoutTransition(null);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z2) {
        getScrollingChildHelper().m(z2);
    }

    public void setOnFlingListener(q qVar) {
        this.b0 = qVar;
    }

    @Deprecated
    public void setOnScrollListener(s sVar) {
        this.l0 = sVar;
    }

    public void setPreserveFocusAfterLayout(boolean z2) {
        this.g0 = z2;
    }

    public void setRecycledViewPool(t tVar) {
        this.f.E(tVar);
    }

    public void setRecyclerListener(v vVar) {
        this.q = vVar;
    }

    void setScrollState(int i2) {
        if (i2 == this.Q) {
            return;
        }
        this.Q = i2;
        if (i2 != 2) {
            u1();
        }
        H(i2);
    }

    public void setScrollingTouchSlop(int i2) {
        int scaledTouchSlop;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i2 != 0) {
            if (i2 == 1) {
                scaledTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                this.a0 = scaledTouchSlop;
            } else {
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i2 + "; using default value");
            }
        }
        scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.a0 = scaledTouchSlop;
    }

    public void setViewCacheExtension(a0 a0Var) {
        this.f.F(a0Var);
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().o(i2);
    }

    @Override // android.view.View, c.f.l.j
    public void stopNestedScroll() {
        getScrollingChildHelper().q();
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z2) {
        if (z2 != this.A) {
            o("Do not suppressLayout in layout or scroll");
            if (z2) {
                long uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                this.A = true;
                this.B = true;
                t1();
                return;
            }
            this.A = false;
            if (this.z && this.p != null && this.o != null) {
                requestLayout();
            }
            this.z = false;
        }
    }

    void t(int i2, int i3) {
        boolean z2;
        EdgeEffect edgeEffect = this.L;
        if (edgeEffect == null || edgeEffect.isFinished() || i2 <= 0) {
            z2 = false;
        } else {
            this.L.onRelease();
            z2 = this.L.isFinished();
        }
        EdgeEffect edgeEffect2 = this.N;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i2 < 0) {
            this.N.onRelease();
            z2 |= this.N.isFinished();
        }
        EdgeEffect edgeEffect3 = this.M;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i3 > 0) {
            this.M.onRelease();
            z2 |= this.M.isFinished();
        }
        EdgeEffect edgeEffect4 = this.O;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i3 < 0) {
            this.O.onRelease();
            z2 |= this.O.isFinished();
        }
        if (z2) {
            c.f.l.s.Z(this);
        }
    }

    public boolean t0() {
        return this.I > 0;
    }

    public void t1() {
        setScrollState(0);
        u1();
    }

    void u() {
        if (!this.x || this.G) {
            c.f.h.a.a("RV FullInvalidate");
            B();
            c.f.h.a.b();
            return;
        }
        if (this.h.p()) {
            if (this.h.o(4) && !this.h.o(11)) {
                c.f.h.a.a("RV PartialInvalidate");
                p1();
                F0();
                this.h.s();
                if (!this.z) {
                    if (m0()) {
                        B();
                    } else {
                        this.h.i();
                    }
                }
                r1(true);
                G0();
            } else {
                if (!this.h.p()) {
                    return;
                }
                c.f.h.a.a("RV FullInvalidate");
                B();
            }
            c.f.h.a.b();
        }
    }

    void v0(int i2) {
        if (this.p == null) {
            return;
        }
        setScrollState(2);
        this.p.x1(i2);
        awakenScrollBars();
    }

    void v1(int i2, int i3, Object obj) {
        int i4;
        int j2 = this.i.j();
        int i5 = i2 + i3;
        for (int i6 = 0; i6 < j2; i6++) {
            View i7 = this.i.i(i6);
            c0 f0 = f0(i7);
            if (f0 != null && !f0.J() && (i4 = f0.f480c) >= i2 && i4 < i5) {
                f0.b(2);
                f0.a(obj);
                ((o) i7.getLayoutParams()).f497c = true;
            }
        }
        this.f.M(i2, i3);
    }

    void w(int i2, int i3) {
        setMeasuredDimension(n.n(i2, getPaddingLeft() + getPaddingRight(), c.f.l.s.A(this)), n.n(i3, getPaddingTop() + getPaddingBottom(), c.f.l.s.z(this)));
    }

    void w0() {
        int j2 = this.i.j();
        for (int i2 = 0; i2 < j2; i2++) {
            ((o) this.i.i(i2).getLayoutParams()).f497c = true;
        }
        this.f.s();
    }

    void x0() {
        int j2 = this.i.j();
        for (int i2 = 0; i2 < j2; i2++) {
            c0 f0 = f0(this.i.i(i2));
            if (f0 != null && !f0.J()) {
                f0.b(6);
            }
        }
        w0();
        this.f.t();
    }

    void y(View view) {
        c0 f0 = f0(view);
        D0(view);
        f fVar = this.o;
        if (fVar != null && f0 != null) {
            fVar.o(f0);
        }
        List<p> list = this.F;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.F.get(size).a(view);
            }
        }
    }

    public void y0(int i2) {
        int g2 = this.i.g();
        for (int i3 = 0; i3 < g2; i3++) {
            this.i.f(i3).offsetLeftAndRight(i2);
        }
    }

    void z(View view) {
        c0 f0 = f0(view);
        E0(view);
        f fVar = this.o;
        if (fVar != null && f0 != null) {
            fVar.p(f0);
        }
        List<p> list = this.F;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.F.get(size).b(view);
            }
        }
    }

    public void z0(int i2) {
        int g2 = this.i.g();
        for (int i3 = 0; i3 < g2; i3++) {
            this.i.f(i3).offsetTopAndBottom(i2);
        }
    }
}
