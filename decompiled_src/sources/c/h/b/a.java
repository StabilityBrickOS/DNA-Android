package c.h.b;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import c.d.h;
import c.f.l.b0.d;
import c.f.l.b0.e;
import c.f.l.s;
import c.f.l.v;
import c.h.b.b;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class a extends c.f.l.a {
    private static final Rect n = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    private static final b.a<c.f.l.b0.c> o = new C0041a();
    private static final b.InterfaceC0042b<h<c.f.l.b0.c>, c.f.l.b0.c> p = new b();
    private final AccessibilityManager h;
    private final View i;
    private c j;

    /* renamed from: d, reason: collision with root package name */
    private final Rect f830d = new Rect();

    /* renamed from: e, reason: collision with root package name */
    private final Rect f831e = new Rect();
    private final Rect f = new Rect();
    private final int[] g = new int[2];
    int k = Integer.MIN_VALUE;
    int l = Integer.MIN_VALUE;
    private int m = Integer.MIN_VALUE;

    /* renamed from: c.h.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0041a implements b.a<c.f.l.b0.c> {
        C0041a() {
        }

        @Override // c.h.b.b.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(c.f.l.b0.c cVar, Rect rect) {
            cVar.m(rect);
        }
    }

    /* loaded from: classes.dex */
    static class b implements b.InterfaceC0042b<h<c.f.l.b0.c>, c.f.l.b0.c> {
        b() {
        }

        @Override // c.h.b.b.InterfaceC0042b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public c.f.l.b0.c b(h<c.f.l.b0.c> hVar, int i) {
            return hVar.l(i);
        }

        @Override // c.h.b.b.InterfaceC0042b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public int a(h<c.f.l.b0.c> hVar) {
            return hVar.k();
        }
    }

    /* loaded from: classes.dex */
    private class c extends d {
        c() {
        }

        @Override // c.f.l.b0.d
        public c.f.l.b0.c a(int i) {
            return c.f.l.b0.c.P(a.this.H(i));
        }

        @Override // c.f.l.b0.d
        public c.f.l.b0.c c(int i) {
            int i2 = i == 2 ? a.this.k : a.this.l;
            if (i2 == Integer.MIN_VALUE) {
                return null;
            }
            return a(i2);
        }

        @Override // c.f.l.b0.d
        public boolean e(int i, int i2, Bundle bundle) {
            return a.this.P(i, i2, bundle);
        }
    }

    public a(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.i = view;
        this.h = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        if (s.w(view) == 0) {
            s.s0(view, 1);
        }
    }

    private static Rect D(View view, int i, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i == 17) {
            rect.set(width, 0, width, height);
        } else if (i == 33) {
            rect.set(0, height, width, height);
        } else if (i == 66) {
            rect.set(-1, 0, -1, height);
        } else {
            if (i != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            rect.set(0, -1, width, -1);
        }
        return rect;
    }

    private boolean E(Rect rect) {
        if (rect == null || rect.isEmpty() || this.i.getWindowVisibility() != 0) {
            return false;
        }
        View view = this.i;
        do {
            Object parent = view.getParent();
            if (!(parent instanceof View)) {
                return parent != null;
            }
            view = (View) parent;
            if (view.getAlpha() <= 0.0f) {
                break;
            }
        } while (view.getVisibility() == 0);
        return false;
    }

    private static int F(int i) {
        if (i == 19) {
            return 33;
        }
        if (i != 21) {
            return i != 22 ? 130 : 66;
        }
        return 17;
    }

    private boolean G(int i, Rect rect) {
        Object d2;
        h<c.f.l.b0.c> y = y();
        int i2 = this.l;
        c.f.l.b0.c e2 = i2 == Integer.MIN_VALUE ? null : y.e(i2);
        if (i == 1 || i == 2) {
            d2 = c.h.b.b.d(y, p, o, e2, i, s.y(this.i) == 1, false);
        } else {
            if (i != 17 && i != 33 && i != 66 && i != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            Rect rect2 = new Rect();
            int i3 = this.l;
            if (i3 != Integer.MIN_VALUE) {
                z(i3, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                D(this.i, i, rect2);
            }
            d2 = c.h.b.b.c(y, p, o, e2, rect2, i);
        }
        c.f.l.b0.c cVar = (c.f.l.b0.c) d2;
        return T(cVar != null ? y.h(y.g(cVar)) : Integer.MIN_VALUE);
    }

    private boolean Q(int i, int i2, Bundle bundle) {
        return i2 != 1 ? i2 != 2 ? i2 != 64 ? i2 != 128 ? J(i, i2, bundle) : n(i) : S(i) : o(i) : T(i);
    }

    private boolean R(int i, Bundle bundle) {
        return s.Y(this.i, i, bundle);
    }

    private boolean S(int i) {
        int i2;
        if (!this.h.isEnabled() || !this.h.isTouchExplorationEnabled() || (i2 = this.k) == i) {
            return false;
        }
        if (i2 != Integer.MIN_VALUE) {
            n(i2);
        }
        this.k = i;
        this.i.invalidate();
        U(i, 32768);
        return true;
    }

    private void V(int i) {
        int i2 = this.m;
        if (i2 == i) {
            return;
        }
        this.m = i;
        U(i, 128);
        U(i2, 256);
    }

    private boolean n(int i) {
        if (this.k != i) {
            return false;
        }
        this.k = Integer.MIN_VALUE;
        this.i.invalidate();
        U(i, 65536);
        return true;
    }

    private boolean p() {
        int i = this.l;
        return i != Integer.MIN_VALUE && J(i, 16, null);
    }

    private AccessibilityEvent q(int i, int i2) {
        return i != -1 ? r(i, i2) : s(i2);
    }

    private AccessibilityEvent r(int i, int i2) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
        c.f.l.b0.c H = H(i);
        obtain.getText().add(H.w());
        obtain.setContentDescription(H.r());
        obtain.setScrollable(H.J());
        obtain.setPassword(H.I());
        obtain.setEnabled(H.E());
        obtain.setChecked(H.C());
        L(i, obtain);
        if (obtain.getText().isEmpty() && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        obtain.setClassName(H.p());
        e.c(obtain, this.i, i);
        obtain.setPackageName(this.i.getContext().getPackageName());
        return obtain;
    }

    private AccessibilityEvent s(int i) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i);
        this.i.onInitializeAccessibilityEvent(obtain);
        return obtain;
    }

    private c.f.l.b0.c t(int i) {
        c.f.l.b0.c N = c.f.l.b0.c.N();
        N.g0(true);
        N.i0(true);
        N.a0("android.view.View");
        N.W(n);
        N.X(n);
        N.q0(this.i);
        N(i, N);
        if (N.w() == null && N.r() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        N.m(this.f831e);
        if (this.f831e.equals(n)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int k = N.k();
        if ((k & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((k & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        N.o0(this.i.getContext().getPackageName());
        N.x0(this.i, i);
        if (this.k == i) {
            N.U(true);
            N.a(128);
        } else {
            N.U(false);
            N.a(64);
        }
        boolean z = this.l == i;
        if (z) {
            N.a(2);
        } else if (N.F()) {
            N.a(1);
        }
        N.j0(z);
        this.i.getLocationOnScreen(this.g);
        N.n(this.f830d);
        if (this.f830d.equals(n)) {
            N.m(this.f830d);
            if (N.f796b != -1) {
                c.f.l.b0.c N2 = c.f.l.b0.c.N();
                for (int i2 = N.f796b; i2 != -1; i2 = N2.f796b) {
                    N2.r0(this.i, -1);
                    N2.W(n);
                    N(i2, N2);
                    N2.m(this.f831e);
                    Rect rect = this.f830d;
                    Rect rect2 = this.f831e;
                    rect.offset(rect2.left, rect2.top);
                }
                N2.R();
            }
            this.f830d.offset(this.g[0] - this.i.getScrollX(), this.g[1] - this.i.getScrollY());
        }
        if (this.i.getLocalVisibleRect(this.f)) {
            this.f.offset(this.g[0] - this.i.getScrollX(), this.g[1] - this.i.getScrollY());
            if (this.f830d.intersect(this.f)) {
                N.X(this.f830d);
                if (E(this.f830d)) {
                    N.z0(true);
                }
            }
        }
        return N;
    }

    private c.f.l.b0.c u() {
        c.f.l.b0.c O = c.f.l.b0.c.O(this.i);
        s.W(this.i, O);
        ArrayList arrayList = new ArrayList();
        C(arrayList);
        if (O.o() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            O.d(this.i, ((Integer) arrayList.get(i)).intValue());
        }
        return O;
    }

    private h<c.f.l.b0.c> y() {
        ArrayList arrayList = new ArrayList();
        C(arrayList);
        h<c.f.l.b0.c> hVar = new h<>();
        for (int i = 0; i < arrayList.size(); i++) {
            hVar.i(i, t(i));
        }
        return hVar;
    }

    private void z(int i, Rect rect) {
        H(i).m(rect);
    }

    public final int A() {
        return this.l;
    }

    protected abstract int B(float f, float f2);

    protected abstract void C(List<Integer> list);

    c.f.l.b0.c H(int i) {
        return i == -1 ? u() : t(i);
    }

    public final void I(boolean z, int i, Rect rect) {
        int i2 = this.l;
        if (i2 != Integer.MIN_VALUE) {
            o(i2);
        }
        if (z) {
            G(i, rect);
        }
    }

    protected abstract boolean J(int i, int i2, Bundle bundle);

    protected void K(AccessibilityEvent accessibilityEvent) {
    }

    protected void L(int i, AccessibilityEvent accessibilityEvent) {
    }

    protected void M(c.f.l.b0.c cVar) {
    }

    protected abstract void N(int i, c.f.l.b0.c cVar);

    protected void O(int i, boolean z) {
    }

    boolean P(int i, int i2, Bundle bundle) {
        return i != -1 ? Q(i, i2, bundle) : R(i2, bundle);
    }

    public final boolean T(int i) {
        int i2;
        if ((!this.i.isFocused() && !this.i.requestFocus()) || (i2 = this.l) == i) {
            return false;
        }
        if (i2 != Integer.MIN_VALUE) {
            o(i2);
        }
        this.l = i;
        O(i, true);
        U(i, 8);
        return true;
    }

    public final boolean U(int i, int i2) {
        ViewParent parent;
        if (i == Integer.MIN_VALUE || !this.h.isEnabled() || (parent = this.i.getParent()) == null) {
            return false;
        }
        return v.h(parent, this.i, q(i, i2));
    }

    @Override // c.f.l.a
    public d b(View view) {
        if (this.j == null) {
            this.j = new c();
        }
        return this.j;
    }

    @Override // c.f.l.a
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        K(accessibilityEvent);
    }

    @Override // c.f.l.a
    public void g(View view, c.f.l.b0.c cVar) {
        super.g(view, cVar);
        M(cVar);
    }

    public final boolean o(int i) {
        if (this.l != i) {
            return false;
        }
        this.l = Integer.MIN_VALUE;
        O(i, false);
        U(i, 8);
        return true;
    }

    public final boolean v(MotionEvent motionEvent) {
        if (!this.h.isEnabled() || !this.h.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int B = B(motionEvent.getX(), motionEvent.getY());
            V(B);
            return B != Integer.MIN_VALUE;
        }
        if (action != 10 || this.m == Integer.MIN_VALUE) {
            return false;
        }
        V(Integer.MIN_VALUE);
        return true;
    }

    public final boolean w(KeyEvent keyEvent) {
        int i = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 61) {
            if (keyEvent.hasNoModifiers()) {
                return G(2, null);
            }
            if (keyEvent.hasModifiers(1)) {
                return G(1, null);
            }
            return false;
        }
        if (keyCode != 66) {
            switch (keyCode) {
                case 19:
                case 20:
                case 21:
                case 22:
                    if (!keyEvent.hasNoModifiers()) {
                        return false;
                    }
                    int F = F(keyCode);
                    int repeatCount = keyEvent.getRepeatCount() + 1;
                    boolean z = false;
                    while (i < repeatCount && G(F, null)) {
                        i++;
                        z = true;
                    }
                    return z;
                case 23:
                    break;
                default:
                    return false;
            }
        }
        if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
            return false;
        }
        p();
        return true;
    }

    public final int x() {
        return this.k;
    }
}
