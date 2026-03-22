package androidx.fragment.app;

import android.animation.Animator;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.lifecycle.d;
import androidx.savedstate.SavedStateRegistry;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

/* loaded from: classes.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, androidx.lifecycle.g, androidx.lifecycle.s, androidx.savedstate.b {
    static final Object a0 = new Object();
    int A;
    String B;
    boolean C;
    boolean D;
    boolean E;
    boolean F;
    boolean G;
    private boolean I;
    ViewGroup J;
    View K;
    View L;
    boolean M;
    c O;
    boolean P;
    boolean Q;
    float R;
    LayoutInflater S;
    boolean T;
    androidx.lifecycle.h V;
    r W;
    androidx.savedstate.a Y;
    private int Z;
    Bundle f;
    SparseArray<Parcelable> g;
    Boolean h;
    Bundle j;
    Fragment k;
    int m;
    boolean o;
    boolean p;
    boolean q;
    boolean r;
    boolean s;
    boolean t;
    int u;
    j v;
    h w;
    Fragment y;
    int z;

    /* renamed from: e, reason: collision with root package name */
    int f370e = 0;
    String i = UUID.randomUUID().toString();
    String l = null;
    private Boolean n = null;
    j x = new j();
    boolean H = true;
    boolean N = true;
    d.b U = d.b.RESUMED;
    androidx.lifecycle.l<androidx.lifecycle.g> X = new androidx.lifecycle.l<>();

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Fragment.this.j();
        }
    }

    /* loaded from: classes.dex */
    class b extends androidx.fragment.app.e {
        b() {
        }

        @Override // androidx.fragment.app.e
        public View c(int i) {
            View view = Fragment.this.K;
            if (view != null) {
                return view.findViewById(i);
            }
            throw new IllegalStateException("Fragment " + this + " does not have a view");
        }

        @Override // androidx.fragment.app.e
        public boolean f() {
            return Fragment.this.K != null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c {
        View a;

        /* renamed from: b, reason: collision with root package name */
        Animator f372b;

        /* renamed from: c, reason: collision with root package name */
        int f373c;

        /* renamed from: d, reason: collision with root package name */
        int f374d;

        /* renamed from: e, reason: collision with root package name */
        int f375e;
        int f;
        Object g = null;
        Object h;
        Object i;
        Object j;
        Object k;
        Object l;
        Boolean m;
        Boolean n;
        androidx.core.app.g o;
        androidx.core.app.g p;
        boolean q;
        e r;
        boolean s;

        c() {
            Object obj = Fragment.a0;
            this.h = obj;
            this.i = null;
            this.j = obj;
            this.k = null;
            this.l = obj;
            this.o = null;
            this.p = null;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends RuntimeException {
        public d(String str, Exception exc) {
            super(str, exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void a();

        void b();
    }

    public Fragment() {
        Q();
    }

    private void Q() {
        this.V = new androidx.lifecycle.h(this);
        this.Y = androidx.savedstate.a.a(this);
        if (Build.VERSION.SDK_INT >= 19) {
            this.V.a(new androidx.lifecycle.e() { // from class: androidx.fragment.app.Fragment.2
                @Override // androidx.lifecycle.e
                public void d(androidx.lifecycle.g gVar, d.a aVar) {
                    View view;
                    if (aVar != d.a.ON_STOP || (view = Fragment.this.K) == null) {
                        return;
                    }
                    view.cancelPendingInputEvents();
                }
            });
        }
    }

    @Deprecated
    public static Fragment S(Context context, String str, Bundle bundle) {
        try {
            Fragment newInstance = g.d(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(newInstance.getClass().getClassLoader());
                newInstance.l1(bundle);
            }
            return newInstance;
        } catch (IllegalAccessException e2) {
            throw new d("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (InstantiationException e3) {
            throw new d("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e3);
        } catch (NoSuchMethodException e4) {
            throw new d("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e4);
        } catch (InvocationTargetException e5) {
            throw new d("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e5);
        }
    }

    private c l() {
        if (this.O == null) {
            this.O = new c();
        }
        return this.O;
    }

    public final Object A() {
        h hVar = this.w;
        if (hVar == null) {
            return null;
        }
        return hVar.m();
    }

    public void A0() {
        this.I = true;
    }

    @Deprecated
    public LayoutInflater B(Bundle bundle) {
        h hVar = this.w;
        if (hVar == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        LayoutInflater n = hVar.n();
        j jVar = this.x;
        jVar.x0();
        c.f.l.f.b(n, jVar);
        return n;
    }

    public void B0(Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int C() {
        c cVar = this.O;
        if (cVar == null) {
            return 0;
        }
        return cVar.f374d;
    }

    public void C0() {
        this.I = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int D() {
        c cVar = this.O;
        if (cVar == null) {
            return 0;
        }
        return cVar.f375e;
    }

    public void D0() {
        this.I = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int E() {
        c cVar = this.O;
        if (cVar == null) {
            return 0;
        }
        return cVar.f;
    }

    public void E0(View view, Bundle bundle) {
    }

    public final Fragment F() {
        return this.y;
    }

    public void F0(Bundle bundle) {
        this.I = true;
    }

    public Object G() {
        c cVar = this.O;
        if (cVar == null) {
            return null;
        }
        Object obj = cVar.j;
        return obj == a0 ? x() : obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G0(Bundle bundle) {
        this.x.R0();
        this.f370e = 2;
        this.I = false;
        Z(bundle);
        if (this.I) {
            this.x.w();
            return;
        }
        throw new s("Fragment " + this + " did not call through to super.onActivityCreated()");
    }

    public final Resources H() {
        return e1().getResources();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H0() {
        this.x.n(this.w, new b(), this);
        this.I = false;
        c0(this.w.i());
        if (this.I) {
            return;
        }
        throw new s("Fragment " + this + " did not call through to super.onAttach()");
    }

    public final boolean I() {
        return this.E;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I0(Configuration configuration) {
        onConfigurationChanged(configuration);
        this.x.x(configuration);
    }

    public Object J() {
        c cVar = this.O;
        if (cVar == null) {
            return null;
        }
        Object obj = cVar.h;
        return obj == a0 ? v() : obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean J0(MenuItem menuItem) {
        if (this.C) {
            return false;
        }
        return e0(menuItem) || this.x.y(menuItem);
    }

    public Object K() {
        c cVar = this.O;
        if (cVar == null) {
            return null;
        }
        return cVar.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K0(Bundle bundle) {
        this.x.R0();
        this.f370e = 1;
        this.I = false;
        this.Y.c(bundle);
        f0(bundle);
        this.T = true;
        if (this.I) {
            this.V.i(d.a.ON_CREATE);
            return;
        }
        throw new s("Fragment " + this + " did not call through to super.onCreate()");
    }

    public Object L() {
        c cVar = this.O;
        if (cVar == null) {
            return null;
        }
        Object obj = cVar.l;
        return obj == a0 ? K() : obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean L0(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.C) {
            return false;
        }
        if (this.G && this.H) {
            z = true;
            i0(menu, menuInflater);
        }
        return z | this.x.A(menu, menuInflater);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int M() {
        c cVar = this.O;
        if (cVar == null) {
            return 0;
        }
        return cVar.f373c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.x.R0();
        this.t = true;
        this.W = new r();
        View j0 = j0(layoutInflater, viewGroup, bundle);
        this.K = j0;
        if (j0 != null) {
            this.W.c();
            this.X.j(this.W);
        } else {
            if (this.W.f()) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.W = null;
        }
    }

    public final String N(int i) {
        return H().getString(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void N0() {
        this.x.B();
        this.V.i(d.a.ON_DESTROY);
        this.f370e = 0;
        this.I = false;
        this.T = false;
        k0();
        if (this.I) {
            return;
        }
        throw new s("Fragment " + this + " did not call through to super.onDestroy()");
    }

    public final Fragment O() {
        String str;
        Fragment fragment = this.k;
        if (fragment != null) {
            return fragment;
        }
        j jVar = this.v;
        if (jVar == null || (str = this.l) == null) {
            return null;
        }
        return jVar.k.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O0() {
        this.x.C();
        if (this.K != null) {
            this.W.b(d.a.ON_DESTROY);
        }
        this.f370e = 1;
        this.I = false;
        m0();
        if (this.I) {
            c.j.a.a.b(this).c();
            this.t = false;
        } else {
            throw new s("Fragment " + this + " did not call through to super.onDestroyView()");
        }
    }

    public View P() {
        return this.K;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P0() {
        this.I = false;
        n0();
        this.S = null;
        if (this.I) {
            if (this.x.C0()) {
                return;
            }
            this.x.B();
            this.x = new j();
            return;
        }
        throw new s("Fragment " + this + " did not call through to super.onDetach()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LayoutInflater Q0(Bundle bundle) {
        LayoutInflater o0 = o0(bundle);
        this.S = o0;
        return o0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R() {
        Q();
        this.i = UUID.randomUUID().toString();
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
        this.u = 0;
        this.v = null;
        this.x = new j();
        this.w = null;
        this.z = 0;
        this.A = 0;
        this.B = null;
        this.C = false;
        this.D = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R0() {
        onLowMemory();
        this.x.D();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S0(boolean z) {
        s0(z);
        this.x.E(z);
    }

    public final boolean T() {
        return this.D;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean T0(MenuItem menuItem) {
        if (this.C) {
            return false;
        }
        return (this.G && this.H && t0(menuItem)) || this.x.T(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean U() {
        c cVar = this.O;
        if (cVar == null) {
            return false;
        }
        return cVar.s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void U0(Menu menu) {
        if (this.C) {
            return;
        }
        if (this.G && this.H) {
            u0(menu);
        }
        this.x.U(menu);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean V() {
        return this.u > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void V0() {
        this.x.W();
        if (this.K != null) {
            this.W.b(d.a.ON_PAUSE);
        }
        this.V.i(d.a.ON_PAUSE);
        this.f370e = 3;
        this.I = false;
        v0();
        if (this.I) {
            return;
        }
        throw new s("Fragment " + this + " did not call through to super.onPause()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean W() {
        c cVar = this.O;
        if (cVar == null) {
            return false;
        }
        return cVar.q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W0(boolean z) {
        w0(z);
        this.x.X(z);
    }

    public final boolean X() {
        j jVar = this.v;
        if (jVar == null) {
            return false;
        }
        return jVar.G0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean X0(Menu menu) {
        boolean z = false;
        if (this.C) {
            return false;
        }
        if (this.G && this.H) {
            z = true;
            x0(menu);
        }
        return z | this.x.Y(menu);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y() {
        this.x.R0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y0() {
        boolean E0 = this.v.E0(this);
        Boolean bool = this.n;
        if (bool == null || bool.booleanValue() != E0) {
            this.n = Boolean.valueOf(E0);
            y0(E0);
            this.x.Z();
        }
    }

    public void Z(Bundle bundle) {
        this.I = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Z0() {
        this.x.R0();
        this.x.j0();
        this.f370e = 4;
        this.I = false;
        A0();
        if (!this.I) {
            throw new s("Fragment " + this + " did not call through to super.onResume()");
        }
        this.V.i(d.a.ON_RESUME);
        if (this.K != null) {
            this.W.b(d.a.ON_RESUME);
        }
        this.x.a0();
        this.x.j0();
    }

    @Override // androidx.lifecycle.g
    public androidx.lifecycle.d a() {
        return this.V;
    }

    public void a0(int i, int i2, Intent intent) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a1(Bundle bundle) {
        B0(bundle);
        this.Y.d(bundle);
        Parcelable d1 = this.x.d1();
        if (d1 != null) {
            bundle.putParcelable("android:support:fragments", d1);
        }
    }

    @Deprecated
    public void b0(Activity activity) {
        this.I = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b1() {
        this.x.R0();
        this.x.j0();
        this.f370e = 3;
        this.I = false;
        C0();
        if (this.I) {
            this.V.i(d.a.ON_START);
            if (this.K != null) {
                this.W.b(d.a.ON_START);
            }
            this.x.b0();
            return;
        }
        throw new s("Fragment " + this + " did not call through to super.onStart()");
    }

    public void c0(Context context) {
        this.I = true;
        h hVar = this.w;
        Activity g = hVar == null ? null : hVar.g();
        if (g != null) {
            this.I = false;
            b0(g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c1() {
        this.x.d0();
        if (this.K != null) {
            this.W.b(d.a.ON_STOP);
        }
        this.V.i(d.a.ON_STOP);
        this.f370e = 2;
        this.I = false;
        D0();
        if (this.I) {
            return;
        }
        throw new s("Fragment " + this + " did not call through to super.onStop()");
    }

    public void d0(Fragment fragment) {
    }

    public final androidx.fragment.app.d d1() {
        androidx.fragment.app.d n = n();
        if (n != null) {
            return n;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    @Override // androidx.savedstate.b
    public final SavedStateRegistry e() {
        return this.Y.b();
    }

    public boolean e0(MenuItem menuItem) {
        return false;
    }

    public final Context e1() {
        Context u = u();
        if (u != null) {
            return u;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public void f0(Bundle bundle) {
        this.I = true;
        h1(bundle);
        if (this.x.F0(1)) {
            return;
        }
        this.x.z();
    }

    public final i f1() {
        i z = z();
        if (z != null) {
            return z;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    public Animation g0(int i, boolean z, int i2) {
        return null;
    }

    public final View g1() {
        View P = P();
        if (P != null) {
            return P;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    @Override // androidx.lifecycle.s
    public androidx.lifecycle.r h() {
        j jVar = this.v;
        if (jVar != null) {
            return jVar.z0(this);
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public Animator h0(int i, boolean z, int i2) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h1(Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        this.x.b1(parcelable);
        this.x.z();
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public void i0(Menu menu, MenuInflater menuInflater) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void i1(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.g;
        if (sparseArray != null) {
            this.L.restoreHierarchyState(sparseArray);
            this.g = null;
        }
        this.I = false;
        F0(bundle);
        if (this.I) {
            if (this.K != null) {
                this.W.b(d.a.ON_CREATE);
            }
        } else {
            throw new s("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    void j() {
        c cVar = this.O;
        e eVar = null;
        if (cVar != null) {
            cVar.q = false;
            e eVar2 = cVar.r;
            cVar.r = null;
            eVar = eVar2;
        }
        if (eVar != null) {
            eVar.a();
        }
    }

    public View j0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i = this.Z;
        if (i != 0) {
            return layoutInflater.inflate(i, viewGroup, false);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j1(View view) {
        l().a = view;
    }

    public void k(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.z));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.A));
        printWriter.print(" mTag=");
        printWriter.println(this.B);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f370e);
        printWriter.print(" mWho=");
        printWriter.print(this.i);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.u);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.o);
        printWriter.print(" mRemoving=");
        printWriter.print(this.p);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.q);
        printWriter.print(" mInLayout=");
        printWriter.println(this.r);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.C);
        printWriter.print(" mDetached=");
        printWriter.print(this.D);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.H);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.G);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.E);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.N);
        if (this.v != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.v);
        }
        if (this.w != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.w);
        }
        if (this.y != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.y);
        }
        if (this.j != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.j);
        }
        if (this.f != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f);
        }
        if (this.g != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.g);
        }
        Fragment O = O();
        if (O != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(O);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.m);
        }
        if (C() != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(C());
        }
        if (this.J != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.J);
        }
        if (this.K != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.K);
        }
        if (this.L != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.K);
        }
        if (q() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(q());
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(M());
        }
        if (u() != null) {
            c.j.a.a.b(this).a(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.x + ":");
        this.x.b(str + "  ", fileDescriptor, printWriter, strArr);
    }

    public void k0() {
        this.I = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k1(Animator animator) {
        l().f372b = animator;
    }

    public void l0() {
    }

    public void l1(Bundle bundle) {
        if (this.v != null && X()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.j = bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment m(String str) {
        return str.equals(this.i) ? this : this.x.p0(str);
    }

    public void m0() {
        this.I = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m1(boolean z) {
        l().s = z;
    }

    public final androidx.fragment.app.d n() {
        h hVar = this.w;
        if (hVar == null) {
            return null;
        }
        return (androidx.fragment.app.d) hVar.g();
    }

    public void n0() {
        this.I = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n1(int i) {
        if (this.O == null && i == 0) {
            return;
        }
        l().f374d = i;
    }

    public boolean o() {
        Boolean bool;
        c cVar = this.O;
        if (cVar == null || (bool = cVar.n) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public LayoutInflater o0(Bundle bundle) {
        return B(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o1(int i, int i2) {
        if (this.O == null && i == 0 && i2 == 0) {
            return;
        }
        l();
        c cVar = this.O;
        cVar.f375e = i;
        cVar.f = i2;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.I = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        d1().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.I = true;
    }

    public boolean p() {
        Boolean bool;
        c cVar = this.O;
        if (cVar == null || (bool = cVar.m) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public void p0(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p1(e eVar) {
        l();
        e eVar2 = this.O.r;
        if (eVar == eVar2) {
            return;
        }
        if (eVar != null && eVar2 != null) {
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
        c cVar = this.O;
        if (cVar.q) {
            cVar.r = eVar;
        }
        if (eVar != null) {
            eVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View q() {
        c cVar = this.O;
        if (cVar == null) {
            return null;
        }
        return cVar.a;
    }

    @Deprecated
    public void q0(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.I = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q1(int i) {
        l().f373c = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Animator r() {
        c cVar = this.O;
        if (cVar == null) {
            return null;
        }
        return cVar.f372b;
    }

    public void r0(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.I = true;
        h hVar = this.w;
        Activity g = hVar == null ? null : hVar.g();
        if (g != null) {
            this.I = false;
            q0(g, attributeSet, bundle);
        }
    }

    public void r1() {
        j jVar = this.v;
        if (jVar == null || jVar.u == null) {
            l().q = false;
        } else if (Looper.myLooper() != this.v.u.j().getLooper()) {
            this.v.u.j().postAtFrontOfQueue(new a());
        } else {
            j();
        }
    }

    public final Bundle s() {
        return this.j;
    }

    public void s0(boolean z) {
    }

    public final i t() {
        if (this.w != null) {
            return this.x;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    public boolean t0(MenuItem menuItem) {
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        c.f.k.a.a(this, sb);
        sb.append(" (");
        sb.append(this.i);
        sb.append(")");
        if (this.z != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.z));
        }
        if (this.B != null) {
            sb.append(" ");
            sb.append(this.B);
        }
        sb.append('}');
        return sb.toString();
    }

    public Context u() {
        h hVar = this.w;
        if (hVar == null) {
            return null;
        }
        return hVar.i();
    }

    public void u0(Menu menu) {
    }

    public Object v() {
        c cVar = this.O;
        if (cVar == null) {
            return null;
        }
        return cVar.g;
    }

    public void v0() {
        this.I = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public androidx.core.app.g w() {
        c cVar = this.O;
        if (cVar == null) {
            return null;
        }
        return cVar.o;
    }

    public void w0(boolean z) {
    }

    public Object x() {
        c cVar = this.O;
        if (cVar == null) {
            return null;
        }
        return cVar.i;
    }

    public void x0(Menu menu) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public androidx.core.app.g y() {
        c cVar = this.O;
        if (cVar == null) {
            return null;
        }
        return cVar.p;
    }

    public void y0(boolean z) {
    }

    public final i z() {
        return this.v;
    }

    public void z0(int i, String[] strArr, int[] iArr) {
    }
}
