package androidx.fragment.app;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.i;
import androidx.lifecycle.d;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j extends androidx.fragment.app.i implements LayoutInflater.Factory2 {
    static boolean L;
    static final Interpolator M = new DecelerateInterpolator(2.5f);
    static final Interpolator N = new DecelerateInterpolator(1.5f);
    boolean A;
    boolean B;
    boolean C;
    ArrayList<androidx.fragment.app.a> D;
    ArrayList<Boolean> E;
    ArrayList<Fragment> F;
    ArrayList<m> I;
    private androidx.fragment.app.l J;
    ArrayList<k> g;
    boolean h;
    ArrayList<androidx.fragment.app.a> l;
    ArrayList<Fragment> m;
    private OnBackPressedDispatcher n;
    ArrayList<androidx.fragment.app.a> p;
    ArrayList<Integer> q;
    ArrayList<i.b> r;
    androidx.fragment.app.h u;
    androidx.fragment.app.e v;
    Fragment w;
    Fragment x;
    boolean y;
    boolean z;
    int i = 0;
    final ArrayList<Fragment> j = new ArrayList<>();
    final HashMap<String, Fragment> k = new HashMap<>();
    private final androidx.activity.b o = new a(false);
    private final CopyOnWriteArrayList<i> s = new CopyOnWriteArrayList<>();
    int t = 0;
    Bundle G = null;
    SparseArray<Parcelable> H = null;
    Runnable K = new b();

    /* loaded from: classes.dex */
    class a extends androidx.activity.b {
        a(boolean z) {
            super(z);
        }

        @Override // androidx.activity.b
        public void b() {
            j.this.A0();
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.j0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Animation.AnimationListener {
        final /* synthetic */ ViewGroup a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Fragment f382b;

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (c.this.f382b.q() != null) {
                    c.this.f382b.j1(null);
                    c cVar = c.this;
                    j jVar = j.this;
                    Fragment fragment = cVar.f382b;
                    jVar.Q0(fragment, fragment.M(), 0, 0, false);
                }
            }
        }

        c(ViewGroup viewGroup, Fragment fragment) {
            this.a = viewGroup;
            this.f382b = fragment;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.a.post(new a());
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends AnimatorListenerAdapter {
        final /* synthetic */ ViewGroup a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f385b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Fragment f386c;

        d(ViewGroup viewGroup, View view, Fragment fragment) {
            this.a = viewGroup;
            this.f385b = view;
            this.f386c = fragment;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.endViewTransition(this.f385b);
            Animator r = this.f386c.r();
            this.f386c.k1(null);
            if (r == null || this.a.indexOfChild(this.f385b) >= 0) {
                return;
            }
            j jVar = j.this;
            Fragment fragment = this.f386c;
            jVar.Q0(fragment, fragment.M(), 0, 0, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends AnimatorListenerAdapter {
        final /* synthetic */ ViewGroup a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f388b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Fragment f389c;

        e(j jVar, ViewGroup viewGroup, View view, Fragment fragment) {
            this.a = viewGroup;
            this.f388b = view;
            this.f389c = fragment;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.endViewTransition(this.f388b);
            animator.removeListener(this);
            Fragment fragment = this.f389c;
            View view = fragment.K;
            if (view == null || !fragment.C) {
                return;
            }
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends androidx.fragment.app.g {
        f() {
        }

        @Override // androidx.fragment.app.g
        public Fragment a(ClassLoader classLoader, String str) {
            androidx.fragment.app.h hVar = j.this.u;
            return hVar.b(hVar.i(), str, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class g {
        public final Animation a;

        /* renamed from: b, reason: collision with root package name */
        public final Animator f391b;

        g(Animator animator) {
            this.a = null;
            this.f391b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }

        g(Animation animation) {
            this.a = animation;
            this.f391b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class h extends AnimationSet implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        private final ViewGroup f392e;
        private final View f;
        private boolean g;
        private boolean h;
        private boolean i;

        h(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.i = true;
            this.f392e = viewGroup;
            this.f = view;
            addAnimation(animation);
            this.f392e.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            this.i = true;
            if (this.g) {
                return !this.h;
            }
            if (!super.getTransformation(j, transformation)) {
                this.g = true;
                c.f.l.q.a(this.f392e, this);
            }
            return true;
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation, float f) {
            this.i = true;
            if (this.g) {
                return !this.h;
            }
            if (!super.getTransformation(j, transformation, f)) {
                this.g = true;
                c.f.l.q.a(this.f392e, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.g || !this.i) {
                this.f392e.endViewTransition(this.f);
                this.h = true;
            } else {
                this.i = false;
                this.f392e.post(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class i {
        final i.a a;

        /* renamed from: b, reason: collision with root package name */
        final boolean f393b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.fragment.app.j$j, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0011j {
        public static final int[] a = {R.attr.name, R.attr.id, R.attr.tag};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface k {
        boolean a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* loaded from: classes.dex */
    private class l implements k {
        final String a;

        /* renamed from: b, reason: collision with root package name */
        final int f394b;

        /* renamed from: c, reason: collision with root package name */
        final int f395c;

        l(String str, int i, int i2) {
            this.a = str;
            this.f394b = i;
            this.f395c = i2;
        }

        @Override // androidx.fragment.app.j.k
        public boolean a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
            Fragment fragment = j.this.x;
            if (fragment == null || this.f394b >= 0 || this.a != null || !fragment.t().f()) {
                return j.this.U0(arrayList, arrayList2, this.a, this.f394b, this.f395c);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class m implements Fragment.e {
        final boolean a;

        /* renamed from: b, reason: collision with root package name */
        final androidx.fragment.app.a f397b;

        /* renamed from: c, reason: collision with root package name */
        private int f398c;

        m(androidx.fragment.app.a aVar, boolean z) {
            this.a = z;
            this.f397b = aVar;
        }

        @Override // androidx.fragment.app.Fragment.e
        public void a() {
            int i = this.f398c - 1;
            this.f398c = i;
            if (i != 0) {
                return;
            }
            this.f397b.r.g1();
        }

        @Override // androidx.fragment.app.Fragment.e
        public void b() {
            this.f398c++;
        }

        public void c() {
            androidx.fragment.app.a aVar = this.f397b;
            aVar.r.t(aVar, this.a, false, false);
        }

        public void d() {
            boolean z = this.f398c > 0;
            j jVar = this.f397b.r;
            int size = jVar.j.size();
            for (int i = 0; i < size; i++) {
                Fragment fragment = jVar.j.get(i);
                fragment.p1(null);
                if (z && fragment.W()) {
                    fragment.r1();
                }
            }
            androidx.fragment.app.a aVar = this.f397b;
            aVar.r.t(aVar, this.a, !z, true);
        }

        public boolean e() {
            return this.f398c == 0;
        }
    }

    private boolean D0(Fragment fragment) {
        return (fragment.G && fragment.H) || fragment.x.q();
    }

    static g J0(float f2, float f3) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f3);
        alphaAnimation.setInterpolator(N);
        alphaAnimation.setDuration(220L);
        return new g(alphaAnimation);
    }

    static g L0(float f2, float f3, float f4, float f5) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f2, f3, f2, f3, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(M);
        scaleAnimation.setDuration(220L);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f4, f5);
        alphaAnimation.setInterpolator(N);
        alphaAnimation.setDuration(220L);
        animationSet.addAnimation(alphaAnimation);
        return new g(animationSet);
    }

    private void M0(c.d.b<Fragment> bVar) {
        int size = bVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment h2 = bVar.h(i2);
            if (!h2.o) {
                View g1 = h2.g1();
                h2.R = g1.getAlpha();
                g1.setAlpha(0.0f);
            }
        }
    }

    private boolean T0(String str, int i2, int i3) {
        j0();
        h0(true);
        Fragment fragment = this.x;
        if (fragment != null && i2 < 0 && str == null && fragment.t().f()) {
            return true;
        }
        boolean U0 = U0(this.D, this.E, str, i2, i3);
        if (U0) {
            this.h = true;
            try {
                Y0(this.D, this.E);
            } finally {
                s();
            }
        }
        o1();
        e0();
        p();
        return U0;
    }

    private void V(Fragment fragment) {
        if (fragment == null || this.k.get(fragment.i) != fragment) {
            return;
        }
        fragment.Y0();
    }

    private int V0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3, c.d.b<Fragment> bVar) {
        int i4 = i3;
        for (int i5 = i3 - 1; i5 >= i2; i5--) {
            androidx.fragment.app.a aVar = arrayList.get(i5);
            boolean booleanValue = arrayList2.get(i5).booleanValue();
            if (aVar.u() && !aVar.s(arrayList, i5 + 1, i3)) {
                if (this.I == null) {
                    this.I = new ArrayList<>();
                }
                m mVar = new m(aVar, booleanValue);
                this.I.add(mVar);
                aVar.w(mVar);
                if (booleanValue) {
                    aVar.n();
                } else {
                    aVar.o(false);
                }
                i4--;
                if (i5 != i4) {
                    arrayList.remove(i5);
                    arrayList.add(i4, aVar);
                }
                h(bVar);
            }
        }
        return i4;
    }

    private void Y0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        m0(arrayList, arrayList2);
        int size = arrayList.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            if (!arrayList.get(i2).p) {
                if (i3 != i2) {
                    l0(arrayList, arrayList2, i3, i2);
                }
                i3 = i2 + 1;
                if (arrayList2.get(i2).booleanValue()) {
                    while (i3 < size && arrayList2.get(i3).booleanValue() && !arrayList.get(i3).p) {
                        i3++;
                    }
                }
                l0(arrayList, arrayList2, i2, i3);
                i2 = i3 - 1;
            }
            i2++;
        }
        if (i3 != size) {
            l0(arrayList, arrayList2, i3, size);
        }
    }

    private void c0(int i2) {
        try {
            this.h = true;
            O0(i2, false);
            this.h = false;
            j0();
        } catch (Throwable th) {
            this.h = false;
            throw th;
        }
    }

    public static int c1(int i2) {
        if (i2 == 4097) {
            return 8194;
        }
        if (i2 != 4099) {
            return i2 != 8194 ? 0 : 4097;
        }
        return 4099;
    }

    private void f0() {
        for (Fragment fragment : this.k.values()) {
            if (fragment != null) {
                if (fragment.q() != null) {
                    int M2 = fragment.M();
                    View q = fragment.q();
                    Animation animation = q.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        q.clearAnimation();
                    }
                    fragment.j1(null);
                    Q0(fragment, M2, 0, 0, false);
                } else if (fragment.r() != null) {
                    fragment.r().end();
                }
            }
        }
    }

    private void h(c.d.b<Fragment> bVar) {
        int i2 = this.t;
        if (i2 < 1) {
            return;
        }
        int min = Math.min(i2, 3);
        int size = this.j.size();
        for (int i3 = 0; i3 < size; i3++) {
            Fragment fragment = this.j.get(i3);
            if (fragment.f370e < min) {
                Q0(fragment, min, fragment.C(), fragment.D(), false);
                if (fragment.K != null && !fragment.C && fragment.P) {
                    bVar.add(fragment);
                }
            }
        }
    }

    private void h0(boolean z) {
        if (this.h) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.u == null) {
            throw new IllegalStateException("Fragment host has been destroyed");
        }
        if (Looper.myLooper() != this.u.j().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z) {
            r();
        }
        if (this.D == null) {
            this.D = new ArrayList<>();
            this.E = new ArrayList<>();
        }
        this.h = true;
        try {
            m0(null, null);
        } finally {
            this.h = false;
        }
    }

    private static void k0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        while (i2 < i3) {
            androidx.fragment.app.a aVar = arrayList.get(i2);
            if (arrayList2.get(i2).booleanValue()) {
                aVar.j(-1);
                aVar.o(i2 == i3 + (-1));
            } else {
                aVar.j(1);
                aVar.n();
            }
            i2++;
        }
    }

    private void l0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        int i4;
        int i5;
        int i6 = i2;
        boolean z = arrayList.get(i6).p;
        ArrayList<Fragment> arrayList3 = this.F;
        if (arrayList3 == null) {
            this.F = new ArrayList<>();
        } else {
            arrayList3.clear();
        }
        this.F.addAll(this.j);
        Fragment y0 = y0();
        boolean z2 = false;
        for (int i7 = i6; i7 < i3; i7++) {
            androidx.fragment.app.a aVar = arrayList.get(i7);
            y0 = !arrayList2.get(i7).booleanValue() ? aVar.p(this.F, y0) : aVar.x(this.F, y0);
            z2 = z2 || aVar.h;
        }
        this.F.clear();
        if (!z) {
            o.C(this, arrayList, arrayList2, i2, i3, false);
        }
        k0(arrayList, arrayList2, i2, i3);
        if (z) {
            c.d.b<Fragment> bVar = new c.d.b<>();
            h(bVar);
            int V0 = V0(arrayList, arrayList2, i2, i3, bVar);
            M0(bVar);
            i4 = V0;
        } else {
            i4 = i3;
        }
        if (i4 != i6 && z) {
            o.C(this, arrayList, arrayList2, i2, i4, true);
            O0(this.t, true);
        }
        while (i6 < i3) {
            androidx.fragment.app.a aVar2 = arrayList.get(i6);
            if (arrayList2.get(i6).booleanValue() && (i5 = aVar2.t) >= 0) {
                s0(i5);
                aVar2.t = -1;
            }
            aVar2.v();
            i6++;
        }
        if (z2) {
            a1();
        }
    }

    private void m(Fragment fragment, g gVar, int i2) {
        View view = fragment.K;
        ViewGroup viewGroup = fragment.J;
        viewGroup.startViewTransition(view);
        fragment.q1(i2);
        if (gVar.a != null) {
            h hVar = new h(gVar.a, viewGroup, view);
            fragment.j1(fragment.K);
            hVar.setAnimationListener(new c(viewGroup, fragment));
            fragment.K.startAnimation(hVar);
            return;
        }
        Animator animator = gVar.f391b;
        fragment.k1(animator);
        animator.addListener(new d(viewGroup, view, fragment));
        animator.setTarget(fragment.K);
        animator.start();
    }

    private void m0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        int indexOf;
        int indexOf2;
        ArrayList<m> arrayList3 = this.I;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i2 = 0;
        while (i2 < size) {
            m mVar = this.I.get(i2);
            if (arrayList == null || mVar.a || (indexOf2 = arrayList.indexOf(mVar.f397b)) == -1 || !arrayList2.get(indexOf2).booleanValue()) {
                if (mVar.e() || (arrayList != null && mVar.f397b.s(arrayList, 0, arrayList.size()))) {
                    this.I.remove(i2);
                    i2--;
                    size--;
                    if (arrayList == null || mVar.a || (indexOf = arrayList.indexOf(mVar.f397b)) == -1 || !arrayList2.get(indexOf).booleanValue()) {
                        mVar.d();
                    }
                }
                i2++;
            } else {
                this.I.remove(i2);
                i2--;
                size--;
            }
            mVar.c();
            i2++;
        }
    }

    private void m1(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new c.f.k.b("FragmentManager"));
        androidx.fragment.app.h hVar = this.u;
        try {
            if (hVar != null) {
                hVar.l("  ", null, printWriter, new String[0]);
            } else {
                b("  ", null, printWriter, new String[0]);
            }
            throw runtimeException;
        } catch (Exception e2) {
            Log.e("FragmentManager", "Failed dumping state", e2);
            throw runtimeException;
        }
    }

    public static int n1(int i2, boolean z) {
        if (i2 == 4097) {
            return z ? 1 : 2;
        }
        if (i2 == 4099) {
            return z ? 5 : 6;
        }
        if (i2 != 8194) {
            return -1;
        }
        return z ? 3 : 4;
    }

    private void o1() {
        ArrayList<k> arrayList = this.g;
        if (arrayList == null || arrayList.isEmpty()) {
            this.o.f(u0() > 0 && E0(this.w));
        } else {
            this.o.f(true);
        }
    }

    private void p() {
        this.k.values().removeAll(Collections.singleton(null));
    }

    private Fragment q0(Fragment fragment) {
        ViewGroup viewGroup = fragment.J;
        View view = fragment.K;
        if (viewGroup != null && view != null) {
            for (int indexOf = this.j.indexOf(fragment) - 1; indexOf >= 0; indexOf--) {
                Fragment fragment2 = this.j.get(indexOf);
                if (fragment2.J == viewGroup && fragment2.K != null) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    private void r() {
        if (G0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    private void r0() {
        if (this.I != null) {
            while (!this.I.isEmpty()) {
                this.I.remove(0).d();
            }
        }
    }

    private void s() {
        this.h = false;
        this.E.clear();
        this.D.clear();
    }

    private boolean t0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this) {
            if (this.g != null && this.g.size() != 0) {
                int size = this.g.size();
                boolean z = false;
                for (int i2 = 0; i2 < size; i2++) {
                    z |= this.g.get(i2).a(arrayList, arrayList2);
                }
                this.g.clear();
                this.u.j().removeCallbacks(this.K);
                return z;
            }
            return false;
        }
    }

    public boolean A(Menu menu, MenuInflater menuInflater) {
        if (this.t < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z = false;
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            Fragment fragment = this.j.get(i2);
            if (fragment != null && fragment.L0(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z = true;
            }
        }
        if (this.m != null) {
            for (int i3 = 0; i3 < this.m.size(); i3++) {
                Fragment fragment2 = this.m.get(i3);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.l0();
                }
            }
        }
        this.m = arrayList;
        return z;
    }

    void A0() {
        j0();
        if (this.o.c()) {
            f();
        } else {
            this.n.c();
        }
    }

    public void B() {
        this.B = true;
        j0();
        c0(0);
        this.u = null;
        this.v = null;
        this.w = null;
        if (this.n != null) {
            this.o.d();
            this.n = null;
        }
    }

    public void B0(Fragment fragment) {
        if (L) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.C) {
            return;
        }
        fragment.C = true;
        fragment.Q = true ^ fragment.Q;
    }

    public void C() {
        c0(1);
    }

    public boolean C0() {
        return this.B;
    }

    public void D() {
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            Fragment fragment = this.j.get(i2);
            if (fragment != null) {
                fragment.R0();
            }
        }
    }

    public void E(boolean z) {
        int size = this.j.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            }
            Fragment fragment = this.j.get(size);
            if (fragment != null) {
                fragment.S0(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean E0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        j jVar = fragment.v;
        return fragment == jVar.y0() && E0(jVar.w);
    }

    void F(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.w;
        if (fragment2 != null) {
            androidx.fragment.app.i z2 = fragment2.z();
            if (z2 instanceof j) {
                ((j) z2).F(fragment, bundle, true);
            }
        }
        Iterator<i> it = this.s.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (!z || next.f393b) {
                next.a.a(this, fragment, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean F0(int i2) {
        return this.t >= i2;
    }

    void G(Fragment fragment, Context context, boolean z) {
        Fragment fragment2 = this.w;
        if (fragment2 != null) {
            androidx.fragment.app.i z2 = fragment2.z();
            if (z2 instanceof j) {
                ((j) z2).G(fragment, context, true);
            }
        }
        Iterator<i> it = this.s.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (!z || next.f393b) {
                next.a.b(this, fragment, context);
            }
        }
    }

    public boolean G0() {
        return this.z || this.A;
    }

    void H(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.w;
        if (fragment2 != null) {
            androidx.fragment.app.i z2 = fragment2.z();
            if (z2 instanceof j) {
                ((j) z2).H(fragment, bundle, true);
            }
        }
        Iterator<i> it = this.s.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (!z || next.f393b) {
                next.a.c(this, fragment, bundle);
            }
        }
    }

    g H0(Fragment fragment, int i2, boolean z, int i3) {
        int n1;
        int C = fragment.C();
        boolean z2 = false;
        fragment.n1(0);
        ViewGroup viewGroup = fragment.J;
        if (viewGroup != null && viewGroup.getLayoutTransition() != null) {
            return null;
        }
        Animation g0 = fragment.g0(i2, z, C);
        if (g0 != null) {
            return new g(g0);
        }
        Animator h0 = fragment.h0(i2, z, C);
        if (h0 != null) {
            return new g(h0);
        }
        if (C != 0) {
            boolean equals = "anim".equals(this.u.i().getResources().getResourceTypeName(C));
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(this.u.i(), C);
                    if (loadAnimation != null) {
                        return new g(loadAnimation);
                    }
                    z2 = true;
                } catch (Resources.NotFoundException e2) {
                    throw e2;
                } catch (RuntimeException unused) {
                }
            }
            if (!z2) {
                try {
                    Animator loadAnimator = AnimatorInflater.loadAnimator(this.u.i(), C);
                    if (loadAnimator != null) {
                        return new g(loadAnimator);
                    }
                } catch (RuntimeException e3) {
                    if (equals) {
                        throw e3;
                    }
                    Animation loadAnimation2 = AnimationUtils.loadAnimation(this.u.i(), C);
                    if (loadAnimation2 != null) {
                        return new g(loadAnimation2);
                    }
                }
            }
        }
        if (i2 == 0 || (n1 = n1(i2, z)) < 0) {
            return null;
        }
        switch (n1) {
            case 1:
                return L0(1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return L0(1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return L0(0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return L0(1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return J0(0.0f, 1.0f);
            case 6:
                return J0(1.0f, 0.0f);
            default:
                if (i3 == 0 && this.u.p()) {
                    this.u.o();
                }
                return null;
        }
    }

    void I(Fragment fragment, boolean z) {
        Fragment fragment2 = this.w;
        if (fragment2 != null) {
            androidx.fragment.app.i z2 = fragment2.z();
            if (z2 instanceof j) {
                ((j) z2).I(fragment, true);
            }
        }
        Iterator<i> it = this.s.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (!z || next.f393b) {
                next.a.d(this, fragment);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I0(Fragment fragment) {
        if (this.k.get(fragment.i) != null) {
            return;
        }
        this.k.put(fragment.i, fragment);
        if (fragment.F) {
            if (fragment.E) {
                k(fragment);
            } else {
                Z0(fragment);
            }
            fragment.F = false;
        }
        if (L) {
            Log.v("FragmentManager", "Added fragment to active set " + fragment);
        }
    }

    void J(Fragment fragment, boolean z) {
        Fragment fragment2 = this.w;
        if (fragment2 != null) {
            androidx.fragment.app.i z2 = fragment2.z();
            if (z2 instanceof j) {
                ((j) z2).J(fragment, true);
            }
        }
        Iterator<i> it = this.s.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (!z || next.f393b) {
                next.a.e(this, fragment);
            }
        }
    }

    void K(Fragment fragment, boolean z) {
        Fragment fragment2 = this.w;
        if (fragment2 != null) {
            androidx.fragment.app.i z2 = fragment2.z();
            if (z2 instanceof j) {
                ((j) z2).K(fragment, true);
            }
        }
        Iterator<i> it = this.s.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (!z || next.f393b) {
                next.a.f(this, fragment);
            }
        }
    }

    void K0(Fragment fragment) {
        if (this.k.get(fragment.i) == null) {
            return;
        }
        if (L) {
            Log.v("FragmentManager", "Removed fragment from active set " + fragment);
        }
        for (Fragment fragment2 : this.k.values()) {
            if (fragment2 != null && fragment.i.equals(fragment2.l)) {
                fragment2.k = fragment;
                fragment2.l = null;
            }
        }
        this.k.put(fragment.i, null);
        Z0(fragment);
        String str = fragment.l;
        if (str != null) {
            fragment.k = this.k.get(str);
        }
        fragment.R();
    }

    void L(Fragment fragment, Context context, boolean z) {
        Fragment fragment2 = this.w;
        if (fragment2 != null) {
            androidx.fragment.app.i z2 = fragment2.z();
            if (z2 instanceof j) {
                ((j) z2).L(fragment, context, true);
            }
        }
        Iterator<i> it = this.s.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (!z || next.f393b) {
                next.a.g(this, fragment, context);
            }
        }
    }

    void M(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.w;
        if (fragment2 != null) {
            androidx.fragment.app.i z2 = fragment2.z();
            if (z2 instanceof j) {
                ((j) z2).M(fragment, bundle, true);
            }
        }
        Iterator<i> it = this.s.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (!z || next.f393b) {
                next.a.h(this, fragment, bundle);
            }
        }
    }

    void N(Fragment fragment, boolean z) {
        Fragment fragment2 = this.w;
        if (fragment2 != null) {
            androidx.fragment.app.i z2 = fragment2.z();
            if (z2 instanceof j) {
                ((j) z2).N(fragment, true);
            }
        }
        Iterator<i> it = this.s.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (!z || next.f393b) {
                next.a.i(this, fragment);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void N0(Fragment fragment) {
        if (fragment == null) {
            return;
        }
        if (!this.k.containsKey(fragment.i)) {
            if (L) {
                Log.v("FragmentManager", "Ignoring moving " + fragment + " to state " + this.t + "since it is not added to " + this);
                return;
            }
            return;
        }
        int i2 = this.t;
        if (fragment.p) {
            i2 = fragment.V() ? Math.min(i2, 1) : Math.min(i2, 0);
        }
        Q0(fragment, i2, fragment.D(), fragment.E(), false);
        if (fragment.K != null) {
            Fragment q0 = q0(fragment);
            if (q0 != null) {
                View view = q0.K;
                ViewGroup viewGroup = fragment.J;
                int indexOfChild = viewGroup.indexOfChild(view);
                int indexOfChild2 = viewGroup.indexOfChild(fragment.K);
                if (indexOfChild2 < indexOfChild) {
                    viewGroup.removeViewAt(indexOfChild2);
                    viewGroup.addView(fragment.K, indexOfChild);
                }
            }
            if (fragment.P && fragment.J != null) {
                float f2 = fragment.R;
                if (f2 > 0.0f) {
                    fragment.K.setAlpha(f2);
                }
                fragment.R = 0.0f;
                fragment.P = false;
                g H0 = H0(fragment, fragment.D(), true, fragment.E());
                if (H0 != null) {
                    Animation animation = H0.a;
                    if (animation != null) {
                        fragment.K.startAnimation(animation);
                    } else {
                        H0.f391b.setTarget(fragment.K);
                        H0.f391b.start();
                    }
                }
            }
        }
        if (fragment.Q) {
            u(fragment);
        }
    }

    void O(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.w;
        if (fragment2 != null) {
            androidx.fragment.app.i z2 = fragment2.z();
            if (z2 instanceof j) {
                ((j) z2).O(fragment, bundle, true);
            }
        }
        Iterator<i> it = this.s.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (!z || next.f393b) {
                next.a.j(this, fragment, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O0(int i2, boolean z) {
        androidx.fragment.app.h hVar;
        if (this.u == null && i2 != 0) {
            throw new IllegalStateException("No activity");
        }
        if (z || i2 != this.t) {
            this.t = i2;
            int size = this.j.size();
            for (int i3 = 0; i3 < size; i3++) {
                N0(this.j.get(i3));
            }
            for (Fragment fragment : this.k.values()) {
                if (fragment != null && (fragment.p || fragment.D)) {
                    if (!fragment.P) {
                        N0(fragment);
                    }
                }
            }
            l1();
            if (this.y && (hVar = this.u) != null && this.t == 4) {
                hVar.r();
                this.y = false;
            }
        }
    }

    void P(Fragment fragment, boolean z) {
        Fragment fragment2 = this.w;
        if (fragment2 != null) {
            androidx.fragment.app.i z2 = fragment2.z();
            if (z2 instanceof j) {
                ((j) z2).P(fragment, true);
            }
        }
        Iterator<i> it = this.s.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (!z || next.f393b) {
                next.a.k(this, fragment);
            }
        }
    }

    void P0(Fragment fragment) {
        Q0(fragment, this.t, 0, 0, false);
    }

    void Q(Fragment fragment, boolean z) {
        Fragment fragment2 = this.w;
        if (fragment2 != null) {
            androidx.fragment.app.i z2 = fragment2.z();
            if (z2 instanceof j) {
                ((j) z2).Q(fragment, true);
            }
        }
        Iterator<i> it = this.s.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (!z || next.f393b) {
                next.a.l(this, fragment);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0084, code lost:
    
        if (r0 != 3) goto L268;
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x04d9  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x02dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void Q0(androidx.fragment.app.Fragment r19, int r20, int r21, int r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 1282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.j.Q0(androidx.fragment.app.Fragment, int, int, int, boolean):void");
    }

    void R(Fragment fragment, View view, Bundle bundle, boolean z) {
        Fragment fragment2 = this.w;
        if (fragment2 != null) {
            androidx.fragment.app.i z2 = fragment2.z();
            if (z2 instanceof j) {
                ((j) z2).R(fragment, view, bundle, true);
            }
        }
        Iterator<i> it = this.s.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (!z || next.f393b) {
                next.a.m(this, fragment, view, bundle);
            }
        }
    }

    public void R0() {
        this.z = false;
        this.A = false;
        int size = this.j.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = this.j.get(i2);
            if (fragment != null) {
                fragment.Y();
            }
        }
    }

    void S(Fragment fragment, boolean z) {
        Fragment fragment2 = this.w;
        if (fragment2 != null) {
            androidx.fragment.app.i z2 = fragment2.z();
            if (z2 instanceof j) {
                ((j) z2).S(fragment, true);
            }
        }
        Iterator<i> it = this.s.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (!z || next.f393b) {
                next.a.n(this, fragment);
            }
        }
    }

    public void S0(Fragment fragment) {
        if (fragment.M) {
            if (this.h) {
                this.C = true;
            } else {
                fragment.M = false;
                Q0(fragment, this.t, 0, 0, false);
            }
        }
    }

    public boolean T(MenuItem menuItem) {
        if (this.t < 1) {
            return false;
        }
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            Fragment fragment = this.j.get(i2);
            if (fragment != null && fragment.T0(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void U(Menu menu) {
        if (this.t < 1) {
            return;
        }
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            Fragment fragment = this.j.get(i2);
            if (fragment != null) {
                fragment.U0(menu);
            }
        }
    }

    boolean U0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, String str, int i2, int i3) {
        int i4;
        ArrayList<androidx.fragment.app.a> arrayList3 = this.l;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i2 < 0 && (i3 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.l.remove(size));
            arrayList2.add(Boolean.TRUE);
        } else {
            if (str != null || i2 >= 0) {
                int size2 = this.l.size() - 1;
                while (size2 >= 0) {
                    androidx.fragment.app.a aVar = this.l.get(size2);
                    if ((str != null && str.equals(aVar.q())) || (i2 >= 0 && i2 == aVar.t)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i3 & 1) != 0) {
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        androidx.fragment.app.a aVar2 = this.l.get(size2);
                        if (str == null || !str.equals(aVar2.q())) {
                            if (i2 < 0 || i2 != aVar2.t) {
                                break;
                            }
                        }
                    }
                }
                i4 = size2;
            } else {
                i4 = -1;
            }
            if (i4 == this.l.size() - 1) {
                return false;
            }
            for (int size3 = this.l.size() - 1; size3 > i4; size3--) {
                arrayList.add(this.l.remove(size3));
                arrayList2.add(Boolean.TRUE);
            }
        }
        return true;
    }

    public void W() {
        c0(3);
    }

    public void W0(Bundle bundle, String str, Fragment fragment) {
        if (fragment.v == this) {
            bundle.putString(str, fragment.i);
            return;
        }
        m1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        throw null;
    }

    public void X(boolean z) {
        int size = this.j.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            }
            Fragment fragment = this.j.get(size);
            if (fragment != null) {
                fragment.W0(z);
            }
        }
    }

    public void X0(Fragment fragment) {
        if (L) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.u);
        }
        boolean z = !fragment.V();
        if (!fragment.D || z) {
            synchronized (this.j) {
                this.j.remove(fragment);
            }
            if (D0(fragment)) {
                this.y = true;
            }
            fragment.o = false;
            fragment.p = true;
        }
    }

    public boolean Y(Menu menu) {
        if (this.t < 1) {
            return false;
        }
        boolean z = false;
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            Fragment fragment = this.j.get(i2);
            if (fragment != null && fragment.X0(menu)) {
                z = true;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Z() {
        o1();
        V(this.x);
    }

    void Z0(Fragment fragment) {
        if (G0()) {
            if (L) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else if (this.J.k(fragment) && L) {
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    @Override // androidx.fragment.app.i
    public n a() {
        return new androidx.fragment.app.a(this);
    }

    public void a0() {
        this.z = false;
        this.A = false;
        c0(4);
    }

    void a1() {
        if (this.r != null) {
            for (int i2 = 0; i2 < this.r.size(); i2++) {
                this.r.get(i2).a();
            }
        }
    }

    @Override // androidx.fragment.app.i
    public void b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        String str2 = str + "    ";
        if (!this.k.isEmpty()) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (Fragment fragment : this.k.values()) {
                printWriter.print(str);
                printWriter.println(fragment);
                if (fragment != null) {
                    fragment.k(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        int size5 = this.j.size();
        if (size5 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size5; i2++) {
                Fragment fragment2 = this.j.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment2.toString());
            }
        }
        ArrayList<Fragment> arrayList = this.m;
        if (arrayList != null && (size4 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i3 = 0; i3 < size4; i3++) {
                Fragment fragment3 = this.m.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(fragment3.toString());
            }
        }
        ArrayList<androidx.fragment.app.a> arrayList2 = this.l;
        if (arrayList2 != null && (size3 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i4 = 0; i4 < size3; i4++) {
                androidx.fragment.app.a aVar = this.l.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.l(str2, printWriter);
            }
        }
        synchronized (this) {
            if (this.p != null && (size2 = this.p.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i5 = 0; i5 < size2; i5++) {
                    Object obj = (androidx.fragment.app.a) this.p.get(i5);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i5);
                    printWriter.print(": ");
                    printWriter.println(obj);
                }
            }
            if (this.q != null && this.q.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.q.toArray()));
            }
        }
        ArrayList<k> arrayList3 = this.g;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i6 = 0; i6 < size; i6++) {
                Object obj2 = (k) this.g.get(i6);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i6);
                printWriter.print(": ");
                printWriter.println(obj2);
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.u);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.v);
        if (this.w != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.w);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.t);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.z);
        printWriter.print(" mStopped=");
        printWriter.print(this.A);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.B);
        if (this.y) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.y);
        }
    }

    public void b0() {
        this.z = false;
        this.A = false;
        c0(3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b1(Parcelable parcelable) {
        androidx.fragment.app.m mVar;
        if (parcelable == null) {
            return;
        }
        androidx.fragment.app.k kVar = (androidx.fragment.app.k) parcelable;
        if (kVar.f399e == null) {
            return;
        }
        for (Fragment fragment : this.J.h()) {
            if (L) {
                Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + fragment);
            }
            Iterator<androidx.fragment.app.m> it = kVar.f399e.iterator();
            while (true) {
                if (it.hasNext()) {
                    mVar = it.next();
                    if (mVar.f.equals(fragment.i)) {
                        break;
                    }
                } else {
                    mVar = null;
                    break;
                }
            }
            if (mVar == null) {
                if (L) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment + " that was not found in the set of active Fragments " + kVar.f399e);
                }
                Q0(fragment, 1, 0, 0, false);
                fragment.p = true;
                Q0(fragment, 0, 0, 0, false);
            } else {
                mVar.r = fragment;
                fragment.g = null;
                fragment.u = 0;
                fragment.r = false;
                fragment.o = false;
                Fragment fragment2 = fragment.k;
                fragment.l = fragment2 != null ? fragment2.i : null;
                fragment.k = null;
                Bundle bundle = mVar.q;
                if (bundle != null) {
                    bundle.setClassLoader(this.u.i().getClassLoader());
                    fragment.g = mVar.q.getSparseParcelableArray("android:view_state");
                    fragment.f = mVar.q;
                }
            }
        }
        this.k.clear();
        Iterator<androidx.fragment.app.m> it2 = kVar.f399e.iterator();
        while (it2.hasNext()) {
            androidx.fragment.app.m next = it2.next();
            if (next != null) {
                Fragment f2 = next.f(this.u.i().getClassLoader(), c());
                f2.v = this;
                if (L) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + f2.i + "): " + f2);
                }
                this.k.put(f2.i, f2);
                next.r = null;
            }
        }
        this.j.clear();
        ArrayList<String> arrayList = kVar.f;
        if (arrayList != null) {
            Iterator<String> it3 = arrayList.iterator();
            while (it3.hasNext()) {
                String next2 = it3.next();
                Fragment fragment3 = this.k.get(next2);
                if (fragment3 == null) {
                    m1(new IllegalStateException("No instantiated fragment for (" + next2 + ")"));
                    throw null;
                }
                fragment3.o = true;
                if (L) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + next2 + "): " + fragment3);
                }
                if (this.j.contains(fragment3)) {
                    throw new IllegalStateException("Already added " + fragment3);
                }
                synchronized (this.j) {
                    this.j.add(fragment3);
                }
            }
        }
        if (kVar.g != null) {
            this.l = new ArrayList<>(kVar.g.length);
            int i2 = 0;
            while (true) {
                androidx.fragment.app.b[] bVarArr = kVar.g;
                if (i2 >= bVarArr.length) {
                    break;
                }
                androidx.fragment.app.a f3 = bVarArr[i2].f(this);
                if (L) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i2 + " (index " + f3.t + "): " + f3);
                    PrintWriter printWriter = new PrintWriter(new c.f.k.b("FragmentManager"));
                    f3.m("  ", printWriter, false);
                    printWriter.close();
                }
                this.l.add(f3);
                int i3 = f3.t;
                if (i3 >= 0) {
                    h1(i3, f3);
                }
                i2++;
            }
        } else {
            this.l = null;
        }
        String str = kVar.h;
        if (str != null) {
            Fragment fragment4 = this.k.get(str);
            this.x = fragment4;
            V(fragment4);
        }
        this.i = kVar.i;
    }

    @Override // androidx.fragment.app.i
    public androidx.fragment.app.g c() {
        if (super.c() == androidx.fragment.app.i.f) {
            Fragment fragment = this.w;
            if (fragment != null) {
                return fragment.v.c();
            }
            g(new f());
        }
        return super.c();
    }

    @Override // androidx.fragment.app.i
    public List<Fragment> d() {
        List<Fragment> list;
        if (this.j.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.j) {
            list = (List) this.j.clone();
        }
        return list;
    }

    public void d0() {
        this.A = true;
        c0(2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Parcelable d1() {
        ArrayList<String> arrayList;
        int size;
        r0();
        f0();
        j0();
        this.z = true;
        androidx.fragment.app.b[] bVarArr = null;
        if (this.k.isEmpty()) {
            return null;
        }
        ArrayList<androidx.fragment.app.m> arrayList2 = new ArrayList<>(this.k.size());
        boolean z = false;
        for (Fragment fragment : this.k.values()) {
            if (fragment != null) {
                if (fragment.v != this) {
                    m1(new IllegalStateException("Failure saving state: active " + fragment + " was removed from the FragmentManager"));
                    throw null;
                }
                androidx.fragment.app.m mVar = new androidx.fragment.app.m(fragment);
                arrayList2.add(mVar);
                if (fragment.f370e <= 0 || mVar.q != null) {
                    mVar.q = fragment.f;
                } else {
                    mVar.q = e1(fragment);
                    String str = fragment.l;
                    if (str != null) {
                        Fragment fragment2 = this.k.get(str);
                        if (fragment2 == null) {
                            m1(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.l));
                            throw null;
                        }
                        if (mVar.q == null) {
                            mVar.q = new Bundle();
                        }
                        W0(mVar.q, "android:target_state", fragment2);
                        int i2 = fragment.m;
                        if (i2 != 0) {
                            mVar.q.putInt("android:target_req_state", i2);
                        }
                    }
                }
                if (L) {
                    Log.v("FragmentManager", "Saved state of " + fragment + ": " + mVar.q);
                }
                z = true;
            }
        }
        if (!z) {
            if (L) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        int size2 = this.j.size();
        if (size2 > 0) {
            arrayList = new ArrayList<>(size2);
            Iterator<Fragment> it = this.j.iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                arrayList.add(next.i);
                if (next.v != this) {
                    m1(new IllegalStateException("Failure saving state: active " + next + " was removed from the FragmentManager"));
                    throw null;
                }
                if (L) {
                    Log.v("FragmentManager", "saveAllState: adding fragment (" + next.i + "): " + next);
                }
            }
        } else {
            arrayList = null;
        }
        ArrayList<androidx.fragment.app.a> arrayList3 = this.l;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            bVarArr = new androidx.fragment.app.b[size];
            for (int i3 = 0; i3 < size; i3++) {
                bVarArr[i3] = new androidx.fragment.app.b(this.l.get(i3));
                if (L) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i3 + ": " + this.l.get(i3));
                }
            }
        }
        androidx.fragment.app.k kVar = new androidx.fragment.app.k();
        kVar.f399e = arrayList2;
        kVar.f = arrayList;
        kVar.g = bVarArr;
        Fragment fragment3 = this.x;
        if (fragment3 != null) {
            kVar.h = fragment3.i;
        }
        kVar.i = this.i;
        return kVar;
    }

    @Override // androidx.fragment.app.i
    public void e(int i2, int i3) {
        if (i2 >= 0) {
            g0(new l(null, i2, i3), false);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i2);
    }

    void e0() {
        if (this.C) {
            this.C = false;
            l1();
        }
    }

    Bundle e1(Fragment fragment) {
        if (this.G == null) {
            this.G = new Bundle();
        }
        fragment.a1(this.G);
        O(fragment, this.G, false);
        Bundle bundle = null;
        if (!this.G.isEmpty()) {
            Bundle bundle2 = this.G;
            this.G = null;
            bundle = bundle2;
        }
        if (fragment.K != null) {
            f1(fragment);
        }
        if (fragment.g != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.g);
        }
        if (!fragment.N) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.N);
        }
        return bundle;
    }

    @Override // androidx.fragment.app.i
    public boolean f() {
        r();
        return T0(null, -1, 0);
    }

    void f1(Fragment fragment) {
        if (fragment.L == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = this.H;
        if (sparseArray == null) {
            this.H = new SparseArray<>();
        } else {
            sparseArray.clear();
        }
        fragment.L.saveHierarchyState(this.H);
        if (this.H.size() > 0) {
            fragment.g = this.H;
            this.H = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0027, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void g0(androidx.fragment.app.j.k r2, boolean r3) {
        /*
            r1 = this;
            if (r3 != 0) goto L5
            r1.r()
        L5:
            monitor-enter(r1)
            boolean r0 = r1.B     // Catch: java.lang.Throwable -> L30
            if (r0 != 0) goto L24
            androidx.fragment.app.h r0 = r1.u     // Catch: java.lang.Throwable -> L30
            if (r0 != 0) goto Lf
            goto L24
        Lf:
            java.util.ArrayList<androidx.fragment.app.j$k> r3 = r1.g     // Catch: java.lang.Throwable -> L30
            if (r3 != 0) goto L1a
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L30
            r3.<init>()     // Catch: java.lang.Throwable -> L30
            r1.g = r3     // Catch: java.lang.Throwable -> L30
        L1a:
            java.util.ArrayList<androidx.fragment.app.j$k> r3 = r1.g     // Catch: java.lang.Throwable -> L30
            r3.add(r2)     // Catch: java.lang.Throwable -> L30
            r1.g1()     // Catch: java.lang.Throwable -> L30
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L30
            return
        L24:
            if (r3 == 0) goto L28
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L30
            return
        L28:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L30
            java.lang.String r3 = "Activity has been destroyed"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L30
            throw r2     // Catch: java.lang.Throwable -> L30
        L30:
            r2 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L30
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.j.g0(androidx.fragment.app.j$k, boolean):void");
    }

    void g1() {
        synchronized (this) {
            boolean z = false;
            boolean z2 = (this.I == null || this.I.isEmpty()) ? false : true;
            if (this.g != null && this.g.size() == 1) {
                z = true;
            }
            if (z2 || z) {
                this.u.j().removeCallbacks(this.K);
                this.u.j().post(this.K);
                o1();
            }
        }
    }

    public void h1(int i2, androidx.fragment.app.a aVar) {
        synchronized (this) {
            if (this.p == null) {
                this.p = new ArrayList<>();
            }
            int size = this.p.size();
            if (i2 < size) {
                if (L) {
                    Log.v("FragmentManager", "Setting back stack index " + i2 + " to " + aVar);
                }
                this.p.set(i2, aVar);
            } else {
                while (size < i2) {
                    this.p.add(null);
                    if (this.q == null) {
                        this.q = new ArrayList<>();
                    }
                    if (L) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.q.add(Integer.valueOf(size));
                    size++;
                }
                if (L) {
                    Log.v("FragmentManager", "Adding back stack index " + i2 + " with " + aVar);
                }
                this.p.add(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(androidx.fragment.app.a aVar) {
        if (this.l == null) {
            this.l = new ArrayList<>();
        }
        this.l.add(aVar);
    }

    void i0(Fragment fragment) {
        if (!fragment.q || fragment.t) {
            return;
        }
        fragment.M0(fragment.Q0(fragment.f), null, fragment.f);
        View view = fragment.K;
        if (view == null) {
            fragment.L = null;
            return;
        }
        fragment.L = view;
        view.setSaveFromParentEnabled(false);
        if (fragment.C) {
            fragment.K.setVisibility(8);
        }
        fragment.E0(fragment.K, fragment.f);
        R(fragment, fragment.K, fragment.f, false);
    }

    public void i1(Fragment fragment, d.b bVar) {
        if (this.k.get(fragment.i) == fragment && (fragment.w == null || fragment.z() == this)) {
            fragment.U = bVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public void j(Fragment fragment, boolean z) {
        if (L) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        I0(fragment);
        if (fragment.D) {
            return;
        }
        if (this.j.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.j) {
            this.j.add(fragment);
        }
        fragment.o = true;
        fragment.p = false;
        if (fragment.K == null) {
            fragment.Q = false;
        }
        if (D0(fragment)) {
            this.y = true;
        }
        if (z) {
            P0(fragment);
        }
    }

    public boolean j0() {
        h0(true);
        boolean z = false;
        while (t0(this.D, this.E)) {
            this.h = true;
            try {
                Y0(this.D, this.E);
                s();
                z = true;
            } catch (Throwable th) {
                s();
                throw th;
            }
        }
        o1();
        e0();
        p();
        return z;
    }

    public void j1(Fragment fragment) {
        if (fragment == null || (this.k.get(fragment.i) == fragment && (fragment.w == null || fragment.z() == this))) {
            Fragment fragment2 = this.x;
            this.x = fragment;
            V(fragment2);
            V(this.x);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    void k(Fragment fragment) {
        if (G0()) {
            if (L) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else if (this.J.d(fragment) && L) {
            Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
        }
    }

    public void k1(Fragment fragment) {
        if (L) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.C) {
            fragment.C = false;
            fragment.Q = !fragment.Q;
        }
    }

    public int l(androidx.fragment.app.a aVar) {
        synchronized (this) {
            if (this.q != null && this.q.size() > 0) {
                int intValue = this.q.remove(this.q.size() - 1).intValue();
                if (L) {
                    Log.v("FragmentManager", "Adding back stack index " + intValue + " with " + aVar);
                }
                this.p.set(intValue, aVar);
                return intValue;
            }
            if (this.p == null) {
                this.p = new ArrayList<>();
            }
            int size = this.p.size();
            if (L) {
                Log.v("FragmentManager", "Setting back stack index " + size + " to " + aVar);
            }
            this.p.add(aVar);
            return size;
        }
    }

    void l1() {
        for (Fragment fragment : this.k.values()) {
            if (fragment != null) {
                S0(fragment);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void n(androidx.fragment.app.h hVar, androidx.fragment.app.e eVar, Fragment fragment) {
        if (this.u != null) {
            throw new IllegalStateException("Already attached");
        }
        this.u = hVar;
        this.v = eVar;
        this.w = fragment;
        if (fragment != null) {
            o1();
        }
        if (hVar instanceof androidx.activity.c) {
            androidx.activity.c cVar = (androidx.activity.c) hVar;
            this.n = cVar.d();
            Fragment fragment2 = cVar;
            if (fragment != null) {
                fragment2 = fragment;
            }
            this.n.a(fragment2, this.o);
        }
        this.J = fragment != null ? fragment.v.v0(fragment) : hVar instanceof androidx.lifecycle.s ? androidx.fragment.app.l.g(((androidx.lifecycle.s) hVar).h()) : new androidx.fragment.app.l(false);
    }

    public Fragment n0(int i2) {
        for (int size = this.j.size() - 1; size >= 0; size--) {
            Fragment fragment = this.j.get(size);
            if (fragment != null && fragment.z == i2) {
                return fragment;
            }
        }
        for (Fragment fragment2 : this.k.values()) {
            if (fragment2 != null && fragment2.z == i2) {
                return fragment2;
            }
        }
        return null;
    }

    public void o(Fragment fragment) {
        if (L) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.D) {
            fragment.D = false;
            if (fragment.o) {
                return;
            }
            if (this.j.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
            if (L) {
                Log.v("FragmentManager", "add from attach: " + fragment);
            }
            synchronized (this.j) {
                this.j.add(fragment);
            }
            fragment.o = true;
            if (D0(fragment)) {
                this.y = true;
            }
        }
    }

    public Fragment o0(String str) {
        if (str != null) {
            for (int size = this.j.size() - 1; size >= 0; size--) {
                Fragment fragment = this.j.get(size);
                if (fragment != null && str.equals(fragment.B)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (Fragment fragment2 : this.k.values()) {
            if (fragment2 != null && str.equals(fragment2.B)) {
                return fragment2;
            }
        }
        return null;
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0011j.a);
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(0);
        }
        String str2 = attributeValue;
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (str2 == null || !androidx.fragment.app.g.b(context.getClassLoader(), str2)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str2);
        }
        Fragment n0 = resourceId != -1 ? n0(resourceId) : null;
        if (n0 == null && string != null) {
            n0 = o0(string);
        }
        if (n0 == null && id != -1) {
            n0 = n0(id);
        }
        if (L) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + str2 + " existing=" + n0);
        }
        if (n0 == null) {
            n0 = c().a(context.getClassLoader(), str2);
            n0.q = true;
            n0.z = resourceId != 0 ? resourceId : id;
            n0.A = id;
            n0.B = string;
            n0.r = true;
            n0.v = this;
            androidx.fragment.app.h hVar = this.u;
            n0.w = hVar;
            n0.r0(hVar.i(), attributeSet, n0.f);
            j(n0, true);
        } else {
            if (n0.r) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + str2);
            }
            n0.r = true;
            androidx.fragment.app.h hVar2 = this.u;
            n0.w = hVar2;
            n0.r0(hVar2.i(), attributeSet, n0.f);
        }
        Fragment fragment = n0;
        if (this.t >= 1 || !fragment.q) {
            P0(fragment);
        } else {
            Q0(fragment, 1, 0, 0, false);
        }
        View view2 = fragment.K;
        if (view2 != null) {
            if (resourceId != 0) {
                view2.setId(resourceId);
            }
            if (fragment.K.getTag() == null) {
                fragment.K.setTag(string);
            }
            return fragment.K;
        }
        throw new IllegalStateException("Fragment " + str2 + " did not create a view.");
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    public Fragment p0(String str) {
        Fragment m2;
        for (Fragment fragment : this.k.values()) {
            if (fragment != null && (m2 = fragment.m(str)) != null) {
                return m2;
            }
        }
        return null;
    }

    boolean q() {
        boolean z = false;
        for (Fragment fragment : this.k.values()) {
            if (fragment != null) {
                z = D0(fragment);
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public void s0(int i2) {
        synchronized (this) {
            this.p.set(i2, null);
            if (this.q == null) {
                this.q = new ArrayList<>();
            }
            if (L) {
                Log.v("FragmentManager", "Freeing back stack index " + i2);
            }
            this.q.add(Integer.valueOf(i2));
        }
    }

    void t(androidx.fragment.app.a aVar, boolean z, boolean z2, boolean z3) {
        if (z) {
            aVar.o(z3);
        } else {
            aVar.n();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(Boolean.valueOf(z));
        if (z2) {
            o.C(this, arrayList, arrayList2, 0, 1, true);
        }
        if (z3) {
            O0(this.t, true);
        }
        for (Fragment fragment : this.k.values()) {
            if (fragment != null && fragment.K != null && fragment.P && aVar.r(fragment.A)) {
                float f2 = fragment.R;
                if (f2 > 0.0f) {
                    fragment.K.setAlpha(f2);
                }
                if (z3) {
                    fragment.R = 0.0f;
                } else {
                    fragment.R = -1.0f;
                    fragment.P = false;
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Object obj = this.w;
        if (obj == null) {
            obj = this.u;
        }
        c.f.k.a.a(obj, sb);
        sb.append("}}");
        return sb.toString();
    }

    void u(Fragment fragment) {
        Animator animator;
        if (fragment.K != null) {
            g H0 = H0(fragment, fragment.D(), !fragment.C, fragment.E());
            if (H0 == null || (animator = H0.f391b) == null) {
                if (H0 != null) {
                    fragment.K.startAnimation(H0.a);
                    H0.a.start();
                }
                fragment.K.setVisibility((!fragment.C || fragment.U()) ? 0 : 8);
                if (fragment.U()) {
                    fragment.m1(false);
                }
            } else {
                animator.setTarget(fragment.K);
                if (!fragment.C) {
                    fragment.K.setVisibility(0);
                } else if (fragment.U()) {
                    fragment.m1(false);
                } else {
                    ViewGroup viewGroup = fragment.J;
                    View view = fragment.K;
                    viewGroup.startViewTransition(view);
                    H0.f391b.addListener(new e(this, viewGroup, view, fragment));
                }
                H0.f391b.start();
            }
        }
        if (fragment.o && D0(fragment)) {
            this.y = true;
        }
        fragment.Q = false;
        fragment.p0(fragment.C);
    }

    public int u0() {
        ArrayList<androidx.fragment.app.a> arrayList = this.l;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public void v(Fragment fragment) {
        if (L) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.D) {
            return;
        }
        fragment.D = true;
        if (fragment.o) {
            if (L) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            synchronized (this.j) {
                this.j.remove(fragment);
            }
            if (D0(fragment)) {
                this.y = true;
            }
            fragment.o = false;
        }
    }

    androidx.fragment.app.l v0(Fragment fragment) {
        return this.J.f(fragment);
    }

    public void w() {
        this.z = false;
        this.A = false;
        c0(2);
    }

    public Fragment w0(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment fragment = this.k.get(string);
        if (fragment != null) {
            return fragment;
        }
        m1(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        throw null;
    }

    public void x(Configuration configuration) {
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            Fragment fragment = this.j.get(i2);
            if (fragment != null) {
                fragment.I0(configuration);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LayoutInflater.Factory2 x0() {
        return this;
    }

    public boolean y(MenuItem menuItem) {
        if (this.t < 1) {
            return false;
        }
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            Fragment fragment = this.j.get(i2);
            if (fragment != null && fragment.J0(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public Fragment y0() {
        return this.x;
    }

    public void z() {
        this.z = false;
        this.A = false;
        c0(1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public androidx.lifecycle.r z0(Fragment fragment) {
        return this.J.i(fragment);
    }
}
