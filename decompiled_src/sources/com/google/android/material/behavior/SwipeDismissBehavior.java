package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c.f.l.b0.c;
import c.f.l.b0.f;
import c.f.l.s;
import c.h.b.c;

/* loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.c<V> {
    c.h.b.c a;

    /* renamed from: b, reason: collision with root package name */
    c f1054b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f1055c;

    /* renamed from: e, reason: collision with root package name */
    private boolean f1057e;

    /* renamed from: d, reason: collision with root package name */
    private float f1056d = 0.0f;
    int f = 2;
    float g = 0.5f;
    float h = 0.0f;
    float i = 0.5f;
    private final c.AbstractC0043c j = new a();

    /* loaded from: classes.dex */
    class a extends c.AbstractC0043c {
        private int a;

        /* renamed from: b, reason: collision with root package name */
        private int f1058b = -1;

        a() {
        }

        private boolean n(View view, float f) {
            if (f == 0.0f) {
                return Math.abs(view.getLeft() - this.a) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.g);
            }
            boolean z = s.y(view) == 1;
            int i = SwipeDismissBehavior.this.f;
            if (i == 2) {
                return true;
            }
            if (i == 0) {
                if (z) {
                    if (f >= 0.0f) {
                        return false;
                    }
                } else if (f <= 0.0f) {
                    return false;
                }
                return true;
            }
            if (i != 1) {
                return false;
            }
            if (z) {
                if (f <= 0.0f) {
                    return false;
                }
            } else if (f >= 0.0f) {
                return false;
            }
            return true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x001c, code lost:
        
            r5 = r2.a;
            r3 = r3.getWidth() + r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0026, code lost:
        
            if (r5 != false) goto L10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:6:0x0010, code lost:
        
            if (r5 != false) goto L9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:7:0x0012, code lost:
        
            r5 = r2.a - r3.getWidth();
            r3 = r2.a;
         */
        @Override // c.h.b.c.AbstractC0043c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int a(android.view.View r3, int r4, int r5) {
            /*
                r2 = this;
                int r5 = c.f.l.s.y(r3)
                r0 = 1
                if (r5 != r0) goto L9
                r5 = 1
                goto La
            L9:
                r5 = 0
            La:
                com.google.android.material.behavior.SwipeDismissBehavior r1 = com.google.android.material.behavior.SwipeDismissBehavior.this
                int r1 = r1.f
                if (r1 != 0) goto L24
                if (r5 == 0) goto L1c
            L12:
                int r5 = r2.a
                int r3 = r3.getWidth()
                int r5 = r5 - r3
                int r3 = r2.a
                goto L37
            L1c:
                int r5 = r2.a
                int r3 = r3.getWidth()
                int r3 = r3 + r5
                goto L37
            L24:
                if (r1 != r0) goto L29
                if (r5 == 0) goto L12
                goto L1c
            L29:
                int r5 = r2.a
                int r0 = r3.getWidth()
                int r5 = r5 - r0
                int r0 = r2.a
                int r3 = r3.getWidth()
                int r3 = r3 + r0
            L37:
                int r3 = com.google.android.material.behavior.SwipeDismissBehavior.G(r5, r4, r3)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.behavior.SwipeDismissBehavior.a.a(android.view.View, int, int):int");
        }

        @Override // c.h.b.c.AbstractC0043c
        public int b(View view, int i, int i2) {
            return view.getTop();
        }

        @Override // c.h.b.c.AbstractC0043c
        public int d(View view) {
            return view.getWidth();
        }

        @Override // c.h.b.c.AbstractC0043c
        public void i(View view, int i) {
            this.f1058b = i;
            this.a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // c.h.b.c.AbstractC0043c
        public void j(int i) {
            c cVar = SwipeDismissBehavior.this.f1054b;
            if (cVar != null) {
                cVar.b(i);
            }
        }

        @Override // c.h.b.c.AbstractC0043c
        public void k(View view, int i, int i2, int i3, int i4) {
            float width = this.a + (view.getWidth() * SwipeDismissBehavior.this.h);
            float width2 = this.a + (view.getWidth() * SwipeDismissBehavior.this.i);
            float f = i;
            if (f <= width) {
                view.setAlpha(1.0f);
            } else if (f >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.F(0.0f, 1.0f - SwipeDismissBehavior.I(width, width2, f), 1.0f));
            }
        }

        @Override // c.h.b.c.AbstractC0043c
        public void l(View view, float f, float f2) {
            int i;
            boolean z;
            c cVar;
            this.f1058b = -1;
            int width = view.getWidth();
            if (n(view, f)) {
                int left = view.getLeft();
                int i2 = this.a;
                i = left < i2 ? i2 - width : i2 + width;
                z = true;
            } else {
                i = this.a;
                z = false;
            }
            if (SwipeDismissBehavior.this.a.M(i, view.getTop())) {
                s.a0(view, new d(view, z));
            } else {
                if (!z || (cVar = SwipeDismissBehavior.this.f1054b) == null) {
                    return;
                }
                cVar.a(view);
            }
        }

        @Override // c.h.b.c.AbstractC0043c
        public boolean m(View view, int i) {
            int i2 = this.f1058b;
            return (i2 == -1 || i2 == i) && SwipeDismissBehavior.this.E(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements f {
        b() {
        }

        @Override // c.f.l.b0.f
        public boolean a(View view, f.a aVar) {
            boolean z = false;
            if (!SwipeDismissBehavior.this.E(view)) {
                return false;
            }
            boolean z2 = s.y(view) == 1;
            if ((SwipeDismissBehavior.this.f == 0 && z2) || (SwipeDismissBehavior.this.f == 1 && !z2)) {
                z = true;
            }
            int width = view.getWidth();
            if (z) {
                width = -width;
            }
            s.T(view, width);
            view.setAlpha(0.0f);
            c cVar = SwipeDismissBehavior.this.f1054b;
            if (cVar != null) {
                cVar.a(view);
            }
            return true;
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(View view);

        void b(int i);
    }

    /* loaded from: classes.dex */
    private class d implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        private final View f1060e;
        private final boolean f;

        d(View view, boolean z) {
            this.f1060e = view;
            this.f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar;
            c.h.b.c cVar2 = SwipeDismissBehavior.this.a;
            if (cVar2 != null && cVar2.m(true)) {
                s.a0(this.f1060e, this);
            } else {
                if (!this.f || (cVar = SwipeDismissBehavior.this.f1054b) == null) {
                    return;
                }
                cVar.a(this.f1060e);
            }
        }
    }

    static float F(float f, float f2, float f3) {
        return Math.min(Math.max(f, f2), f3);
    }

    static int G(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    private void H(ViewGroup viewGroup) {
        if (this.a == null) {
            this.a = this.f1057e ? c.h.b.c.n(viewGroup, this.f1056d, this.j) : c.h.b.c.o(viewGroup, this.j);
        }
    }

    static float I(float f, float f2, float f3) {
        return (f3 - f) / (f2 - f);
    }

    private void N(View view) {
        s.c0(view, 1048576);
        if (E(view)) {
            s.e0(view, c.a.l, null, new b());
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean D(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        c.h.b.c cVar = this.a;
        if (cVar == null) {
            return false;
        }
        cVar.E(motionEvent);
        return true;
    }

    public boolean E(View view) {
        return true;
    }

    public void J(float f) {
        this.i = F(0.0f, f, 1.0f);
    }

    public void K(c cVar) {
        this.f1054b = cVar;
    }

    public void L(float f) {
        this.h = F(0.0f, f, 1.0f);
    }

    public void M(int i) {
        this.f = i;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = this.f1055c;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z = coordinatorLayout.B(v, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f1055c = z;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f1055c = false;
        }
        if (!z) {
            return false;
        }
        H(coordinatorLayout);
        return this.a.N(motionEvent);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, V v, int i) {
        boolean l = super.l(coordinatorLayout, v, i);
        if (s.w(v) == 0) {
            s.s0(v, 1);
            N(v);
        }
        return l;
    }
}
