package c.l;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import c.l.a;
import c.l.m;

/* loaded from: classes.dex */
public abstract class j0 extends m {
    private static final String[] O = {"android:visibility:visibility", "android:visibility:parent"};
    private int N = 3;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends n {
        final /* synthetic */ ViewGroup a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f874b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f875c;

        a(ViewGroup viewGroup, View view, View view2) {
            this.a = viewGroup;
            this.f874b = view;
            this.f875c = view2;
        }

        @Override // c.l.n, c.l.m.f
        public void a(m mVar) {
            x.a(this.a).c(this.f874b);
        }

        @Override // c.l.n, c.l.m.f
        public void b(m mVar) {
            if (this.f874b.getParent() == null) {
                x.a(this.a).a(this.f874b);
            } else {
                j0.this.f();
            }
        }

        @Override // c.l.m.f
        public void e(m mVar) {
            this.f875c.setTag(j.save_overlay_view, null);
            x.a(this.a).c(this.f874b);
            mVar.P(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends AnimatorListenerAdapter implements m.f, a.InterfaceC0046a {
        private final View a;

        /* renamed from: b, reason: collision with root package name */
        private final int f877b;

        /* renamed from: c, reason: collision with root package name */
        private final ViewGroup f878c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f879d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f880e;
        boolean f = false;

        b(View view, int i, boolean z) {
            this.a = view;
            this.f877b = i;
            this.f878c = (ViewGroup) view.getParent();
            this.f879d = z;
            g(true);
        }

        private void f() {
            if (!this.f) {
                c0.h(this.a, this.f877b);
                ViewGroup viewGroup = this.f878c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            g(false);
        }

        private void g(boolean z) {
            ViewGroup viewGroup;
            if (!this.f879d || this.f880e == z || (viewGroup = this.f878c) == null) {
                return;
            }
            this.f880e = z;
            x.c(viewGroup, z);
        }

        @Override // c.l.m.f
        public void a(m mVar) {
            g(false);
        }

        @Override // c.l.m.f
        public void b(m mVar) {
            g(true);
        }

        @Override // c.l.m.f
        public void c(m mVar) {
        }

        @Override // c.l.m.f
        public void d(m mVar) {
        }

        @Override // c.l.m.f
        public void e(m mVar) {
            f();
            mVar.P(this);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, c.l.a.InterfaceC0046a
        public void onAnimationPause(Animator animator) {
            if (this.f) {
                return;
            }
            c0.h(this.a, this.f877b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, c.l.a.InterfaceC0046a
        public void onAnimationResume(Animator animator) {
            if (this.f) {
                return;
            }
            c0.h(this.a, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        boolean a;

        /* renamed from: b, reason: collision with root package name */
        boolean f881b;

        /* renamed from: c, reason: collision with root package name */
        int f882c;

        /* renamed from: d, reason: collision with root package name */
        int f883d;

        /* renamed from: e, reason: collision with root package name */
        ViewGroup f884e;
        ViewGroup f;

        c() {
        }
    }

    private void c0(s sVar) {
        sVar.a.put("android:visibility:visibility", Integer.valueOf(sVar.f898b.getVisibility()));
        sVar.a.put("android:visibility:parent", sVar.f898b.getParent());
        int[] iArr = new int[2];
        sVar.f898b.getLocationOnScreen(iArr);
        sVar.a.put("android:visibility:screenLocation", iArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0079, code lost:
    
        if (r9 == 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0083, code lost:
    
        if (r0.f884e == null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0095, code lost:
    
        if (r0.f882c == 0) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private c.l.j0.c d0(c.l.s r8, c.l.s r9) {
        /*
            r7 = this;
            c.l.j0$c r0 = new c.l.j0$c
            r0.<init>()
            r1 = 0
            r0.a = r1
            r0.f881b = r1
            java.lang.String r2 = "android:visibility:parent"
            r3 = 0
            r4 = -1
            java.lang.String r5 = "android:visibility:visibility"
            if (r8 == 0) goto L33
            java.util.Map<java.lang.String, java.lang.Object> r6 = r8.a
            boolean r6 = r6.containsKey(r5)
            if (r6 == 0) goto L33
            java.util.Map<java.lang.String, java.lang.Object> r6 = r8.a
            java.lang.Object r6 = r6.get(r5)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            r0.f882c = r6
            java.util.Map<java.lang.String, java.lang.Object> r6 = r8.a
            java.lang.Object r6 = r6.get(r2)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r0.f884e = r6
            goto L37
        L33:
            r0.f882c = r4
            r0.f884e = r3
        L37:
            if (r9 == 0) goto L5a
            java.util.Map<java.lang.String, java.lang.Object> r6 = r9.a
            boolean r6 = r6.containsKey(r5)
            if (r6 == 0) goto L5a
            java.util.Map<java.lang.String, java.lang.Object> r3 = r9.a
            java.lang.Object r3 = r3.get(r5)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r0.f883d = r3
            java.util.Map<java.lang.String, java.lang.Object> r3 = r9.a
            java.lang.Object r2 = r3.get(r2)
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r0.f = r2
            goto L5e
        L5a:
            r0.f883d = r4
            r0.f = r3
        L5e:
            r2 = 1
            if (r8 == 0) goto L86
            if (r9 == 0) goto L86
            int r8 = r0.f882c
            int r9 = r0.f883d
            if (r8 != r9) goto L70
            android.view.ViewGroup r8 = r0.f884e
            android.view.ViewGroup r9 = r0.f
            if (r8 != r9) goto L70
            return r0
        L70:
            int r8 = r0.f882c
            int r9 = r0.f883d
            if (r8 == r9) goto L7c
            if (r8 != 0) goto L79
            goto L97
        L79:
            if (r9 != 0) goto L9a
            goto L8c
        L7c:
            android.view.ViewGroup r8 = r0.f
            if (r8 != 0) goto L81
            goto L97
        L81:
            android.view.ViewGroup r8 = r0.f884e
            if (r8 != 0) goto L9a
            goto L8c
        L86:
            if (r8 != 0) goto L91
            int r8 = r0.f883d
            if (r8 != 0) goto L91
        L8c:
            r0.f881b = r2
        L8e:
            r0.a = r2
            goto L9a
        L91:
            if (r9 != 0) goto L9a
            int r8 = r0.f882c
            if (r8 != 0) goto L9a
        L97:
            r0.f881b = r1
            goto L8e
        L9a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c.l.j0.d0(c.l.s, c.l.s):c.l.j0$c");
    }

    @Override // c.l.m
    public String[] D() {
        return O;
    }

    @Override // c.l.m
    public boolean F(s sVar, s sVar2) {
        if (sVar == null && sVar2 == null) {
            return false;
        }
        if (sVar != null && sVar2 != null && sVar2.a.containsKey("android:visibility:visibility") != sVar.a.containsKey("android:visibility:visibility")) {
            return false;
        }
        c d0 = d0(sVar, sVar2);
        if (d0.a) {
            return d0.f882c == 0 || d0.f883d == 0;
        }
        return false;
    }

    public abstract Animator e0(ViewGroup viewGroup, View view, s sVar, s sVar2);

    public Animator f0(ViewGroup viewGroup, s sVar, int i, s sVar2, int i2) {
        if ((this.N & 1) != 1 || sVar2 == null) {
            return null;
        }
        if (sVar == null) {
            View view = (View) sVar2.f898b.getParent();
            if (d0(t(view, false), E(view, false)).a) {
                return null;
            }
        }
        return e0(viewGroup, sVar2.f898b, sVar, sVar2);
    }

    @Override // c.l.m
    public void g(s sVar) {
        c0(sVar);
    }

    public abstract Animator g0(ViewGroup viewGroup, View view, s sVar, s sVar2);

    /* JADX WARN: Code restructure failed: missing block: B:51:0x007f, code lost:
    
        if (r10.z != false) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.animation.Animator h0(android.view.ViewGroup r11, c.l.s r12, int r13, c.l.s r14, int r15) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.l.j0.h0(android.view.ViewGroup, c.l.s, int, c.l.s, int):android.animation.Animator");
    }

    public void i0(int i) {
        if ((i & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.N = i;
    }

    @Override // c.l.m
    public void j(s sVar) {
        c0(sVar);
    }

    @Override // c.l.m
    public Animator n(ViewGroup viewGroup, s sVar, s sVar2) {
        c d0 = d0(sVar, sVar2);
        if (!d0.a) {
            return null;
        }
        if (d0.f884e == null && d0.f == null) {
            return null;
        }
        return d0.f881b ? f0(viewGroup, sVar, d0.f882c, sVar2, d0.f883d) : h0(viewGroup, sVar, d0.f882c, sVar2, d0.f883d);
    }
}
