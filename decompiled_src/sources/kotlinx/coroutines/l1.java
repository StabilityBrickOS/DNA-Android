package kotlinx.coroutines;

import e.m.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.h1;
import kotlinx.coroutines.internal.i;

/* loaded from: classes.dex */
public class l1 implements h1, o, t1 {

    /* renamed from: e, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f1598e = AtomicReferenceFieldUpdater.newUpdater(l1.class, Object.class, "_state");
    private volatile Object _parentHandle;
    private volatile Object _state;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a<T> extends i<T> {
        private final l1 l;

        public a(e.m.d<? super T> dVar, l1 l1Var) {
            super(dVar, 1);
            this.l = l1Var;
        }

        @Override // kotlinx.coroutines.i
        public Throwable o(h1 h1Var) {
            Throwable f;
            Object K = this.l.K();
            return (!(K instanceof c) || (f = ((c) K).f()) == null) ? K instanceof q ? ((q) K).a : h1Var.e() : f;
        }

        @Override // kotlinx.coroutines.i
        protected String w() {
            return "AwaitContinuation";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b extends k1<h1> {
        private final l1 i;
        private final c j;
        private final n k;
        private final Object l;

        public b(l1 l1Var, c cVar, n nVar, Object obj) {
            super(nVar.i);
            this.i = l1Var;
            this.j = cVar;
            this.k = nVar;
            this.l = obj;
        }

        @Override // e.p.c.l
        public /* bridge */ /* synthetic */ e.j invoke(Throwable th) {
            r(th);
            return e.j.a;
        }

        @Override // kotlinx.coroutines.u
        public void r(Throwable th) {
            this.i.A(this.j, this.k, this.l);
        }

        @Override // kotlinx.coroutines.internal.i
        public String toString() {
            return "ChildCompletion[" + this.k + ", " + this.l + ']';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c implements c1 {
        private volatile Object _exceptionsHolder = null;
        private volatile int _isCompleting;
        private volatile Object _rootCause;

        /* renamed from: e, reason: collision with root package name */
        private final q1 f1599e;

        public c(q1 q1Var, boolean z, Throwable th) {
            this.f1599e = q1Var;
            this._isCompleting = z ? 1 : 0;
            this._rootCause = th;
        }

        private final ArrayList<Throwable> d() {
            return new ArrayList<>(4);
        }

        private final Object e() {
            return this._exceptionsHolder;
        }

        private final void l(Object obj) {
            this._exceptionsHolder = obj;
        }

        @Override // kotlinx.coroutines.c1
        public boolean a() {
            return f() == null;
        }

        public final void b(Throwable th) {
            Throwable f = f();
            if (f == null) {
                m(th);
                return;
            }
            if (th == f) {
                return;
            }
            Object e2 = e();
            if (e2 == null) {
                l(th);
                return;
            }
            if (!(e2 instanceof Throwable)) {
                if (e2 instanceof ArrayList) {
                    ((ArrayList) e2).add(th);
                    return;
                }
                throw new IllegalStateException(("State is " + e2).toString());
            }
            if (th == e2) {
                return;
            }
            ArrayList<Throwable> d2 = d();
            d2.add(e2);
            d2.add(th);
            e.j jVar = e.j.a;
            l(d2);
        }

        @Override // kotlinx.coroutines.c1
        public q1 c() {
            return this.f1599e;
        }

        public final Throwable f() {
            return (Throwable) this._rootCause;
        }

        public final boolean g() {
            return f() != null;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [int, boolean] */
        public final boolean h() {
            return this._isCompleting;
        }

        public final boolean i() {
            kotlinx.coroutines.internal.r rVar;
            Object e2 = e();
            rVar = m1.f1605e;
            return e2 == rVar;
        }

        public final List<Throwable> j(Throwable th) {
            ArrayList<Throwable> arrayList;
            kotlinx.coroutines.internal.r rVar;
            Object e2 = e();
            if (e2 == null) {
                arrayList = d();
            } else if (e2 instanceof Throwable) {
                ArrayList<Throwable> d2 = d();
                d2.add(e2);
                arrayList = d2;
            } else {
                if (!(e2 instanceof ArrayList)) {
                    throw new IllegalStateException(("State is " + e2).toString());
                }
                arrayList = (ArrayList) e2;
            }
            Throwable f = f();
            if (f != null) {
                arrayList.add(0, f);
            }
            if (th != null && (!e.p.d.i.a(th, f))) {
                arrayList.add(th);
            }
            rVar = m1.f1605e;
            l(rVar);
            return arrayList;
        }

        public final void k(boolean z) {
            this._isCompleting = z ? 1 : 0;
        }

        public final void m(Throwable th) {
            this._rootCause = th;
        }

        public String toString() {
            return "Finishing[cancelling=" + g() + ", completing=" + h() + ", rootCause=" + f() + ", exceptions=" + e() + ", list=" + c() + ']';
        }
    }

    /* loaded from: classes.dex */
    public static final class d extends i.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ l1 f1600d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Object f1601e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(kotlinx.coroutines.internal.i iVar, kotlinx.coroutines.internal.i iVar2, l1 l1Var, Object obj) {
            super(iVar2);
            this.f1600d = l1Var;
            this.f1601e = obj;
        }

        @Override // kotlinx.coroutines.internal.c
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Object g(kotlinx.coroutines.internal.i iVar) {
            if (this.f1600d.K() == this.f1601e) {
                return null;
            }
            return kotlinx.coroutines.internal.h.a();
        }
    }

    public l1(boolean z) {
        this._state = z ? m1.g : m1.f;
        this._parentHandle = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(c cVar, n nVar, Object obj) {
        if (h0.a()) {
            if (!(K() == cVar)) {
                throw new AssertionError();
            }
        }
        n V = V(nVar);
        if (V == null || !o0(cVar, V, obj)) {
            r(C(cVar, obj));
        }
    }

    private final Throwable B(Object obj) {
        if (obj != null ? obj instanceof Throwable : true) {
            return obj != null ? (Throwable) obj : new i1(x(), null, this);
        }
        if (obj != null) {
            return ((t1) obj).c();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
    }

    private final Object C(c cVar, Object obj) {
        boolean g;
        Throwable F;
        boolean z = true;
        if (h0.a()) {
            if (!(K() == cVar)) {
                throw new AssertionError();
            }
        }
        if (h0.a() && !(!cVar.i())) {
            throw new AssertionError();
        }
        if (h0.a() && !cVar.h()) {
            throw new AssertionError();
        }
        q qVar = (q) (!(obj instanceof q) ? null : obj);
        Throwable th = qVar != null ? qVar.a : null;
        synchronized (cVar) {
            g = cVar.g();
            List<Throwable> j = cVar.j(th);
            F = F(cVar, j);
            if (F != null) {
                q(F, j);
            }
        }
        if (F != null && F != th) {
            obj = new q(F, false, 2, null);
        }
        if (F != null) {
            if (!w(F) && !L(F)) {
                z = false;
            }
            if (z) {
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                }
                ((q) obj).b();
            }
        }
        if (!g) {
            Y(F);
        }
        Z(obj);
        boolean compareAndSet = f1598e.compareAndSet(this, cVar, m1.g(obj));
        if (h0.a() && !compareAndSet) {
            throw new AssertionError();
        }
        z(cVar, obj);
        return obj;
    }

    private final n D(c1 c1Var) {
        n nVar = (n) (!(c1Var instanceof n) ? null : c1Var);
        if (nVar != null) {
            return nVar;
        }
        q1 c2 = c1Var.c();
        if (c2 != null) {
            return V(c2);
        }
        return null;
    }

    private final Throwable E(Object obj) {
        if (!(obj instanceof q)) {
            obj = null;
        }
        q qVar = (q) obj;
        if (qVar != null) {
            return qVar.a;
        }
        return null;
    }

    private final Throwable F(c cVar, List<? extends Throwable> list) {
        Object obj;
        Object obj2 = null;
        if (list.isEmpty()) {
            if (cVar.g()) {
                return new i1(x(), null, this);
            }
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (!(((Throwable) obj) instanceof CancellationException)) {
                break;
            }
        }
        Throwable th = (Throwable) obj;
        if (th != null) {
            return th;
        }
        Throwable th2 = list.get(0);
        if (th2 instanceof a2) {
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                Throwable th3 = (Throwable) next;
                if (th3 != th2 && (th3 instanceof a2)) {
                    obj2 = next;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj2;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    private final q1 I(c1 c1Var) {
        q1 c2 = c1Var.c();
        if (c2 != null) {
            return c2;
        }
        if (c1Var instanceof t0) {
            return new q1();
        }
        if (c1Var instanceof k1) {
            c0((k1) c1Var);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + c1Var).toString());
    }

    private final Object R(Object obj) {
        kotlinx.coroutines.internal.r rVar;
        kotlinx.coroutines.internal.r rVar2;
        kotlinx.coroutines.internal.r rVar3;
        kotlinx.coroutines.internal.r rVar4;
        kotlinx.coroutines.internal.r rVar5;
        kotlinx.coroutines.internal.r rVar6;
        Throwable th = null;
        while (true) {
            Object K = K();
            if (K instanceof c) {
                synchronized (K) {
                    if (((c) K).i()) {
                        rVar2 = m1.f1604d;
                        return rVar2;
                    }
                    boolean g = ((c) K).g();
                    if (obj != null || !g) {
                        if (th == null) {
                            th = B(obj);
                        }
                        ((c) K).b(th);
                    }
                    Throwable f = g ^ true ? ((c) K).f() : null;
                    if (f != null) {
                        W(((c) K).c(), f);
                    }
                    rVar = m1.a;
                    return rVar;
                }
            }
            if (!(K instanceof c1)) {
                rVar3 = m1.f1604d;
                return rVar3;
            }
            if (th == null) {
                th = B(obj);
            }
            c1 c1Var = (c1) K;
            if (!c1Var.a()) {
                Object m0 = m0(K, new q(th, false, 2, null));
                rVar5 = m1.a;
                if (m0 == rVar5) {
                    throw new IllegalStateException(("Cannot happen in " + K).toString());
                }
                rVar6 = m1.f1603c;
                if (m0 != rVar6) {
                    return m0;
                }
            } else if (l0(c1Var, th)) {
                rVar4 = m1.a;
                return rVar4;
            }
        }
    }

    private final k1<?> T(e.p.c.l<? super Throwable, e.j> lVar, boolean z) {
        if (z) {
            j1 j1Var = (j1) (lVar instanceof j1 ? lVar : null);
            if (j1Var != null) {
                if (h0.a()) {
                    if (!(j1Var.h == this)) {
                        throw new AssertionError();
                    }
                }
                if (j1Var != null) {
                    return j1Var;
                }
            }
            return new f1(this, lVar);
        }
        k1<?> k1Var = (k1) (lVar instanceof k1 ? lVar : null);
        if (k1Var != null) {
            if (h0.a()) {
                if (!(k1Var.h == this && !(k1Var instanceof j1))) {
                    throw new AssertionError();
                }
            }
            if (k1Var != null) {
                return k1Var;
            }
        }
        return new g1(this, lVar);
    }

    private final n V(kotlinx.coroutines.internal.i iVar) {
        while (iVar.m()) {
            iVar = iVar.l();
        }
        while (true) {
            iVar = iVar.k();
            if (!iVar.m()) {
                if (iVar instanceof n) {
                    return (n) iVar;
                }
                if (iVar instanceof q1) {
                    return null;
                }
            }
        }
    }

    private final void W(q1 q1Var, Throwable th) {
        Y(th);
        Object j = q1Var.j();
        if (j == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        }
        v vVar = null;
        for (kotlinx.coroutines.internal.i iVar = (kotlinx.coroutines.internal.i) j; !e.p.d.i.a(iVar, q1Var); iVar = iVar.k()) {
            if (iVar instanceof j1) {
                k1 k1Var = (k1) iVar;
                try {
                    k1Var.r(th);
                } catch (Throwable th2) {
                    if (vVar != null) {
                        e.b.a(vVar, th2);
                        if (vVar != null) {
                        }
                    }
                    vVar = new v("Exception in completion handler " + k1Var + " for " + this, th2);
                    e.j jVar = e.j.a;
                }
            }
        }
        if (vVar != null) {
            M(vVar);
        }
        w(th);
    }

    private final void X(q1 q1Var, Throwable th) {
        Object j = q1Var.j();
        if (j == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        }
        v vVar = null;
        for (kotlinx.coroutines.internal.i iVar = (kotlinx.coroutines.internal.i) j; !e.p.d.i.a(iVar, q1Var); iVar = iVar.k()) {
            if (iVar instanceof k1) {
                k1 k1Var = (k1) iVar;
                try {
                    k1Var.r(th);
                } catch (Throwable th2) {
                    if (vVar != null) {
                        e.b.a(vVar, th2);
                        if (vVar != null) {
                        }
                    }
                    vVar = new v("Exception in completion handler " + k1Var + " for " + this, th2);
                    e.j jVar = e.j.a;
                }
            }
        }
        if (vVar != null) {
            M(vVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [kotlinx.coroutines.b1] */
    private final void b0(t0 t0Var) {
        q1 q1Var = new q1();
        if (!t0Var.a()) {
            q1Var = new b1(q1Var);
        }
        f1598e.compareAndSet(this, t0Var, q1Var);
    }

    private final void c0(k1<?> k1Var) {
        k1Var.f(new q1());
        f1598e.compareAndSet(this, k1Var, k1Var.k());
    }

    private final int f0(Object obj) {
        t0 t0Var;
        if (!(obj instanceof t0)) {
            if (!(obj instanceof b1)) {
                return 0;
            }
            if (!f1598e.compareAndSet(this, obj, ((b1) obj).c())) {
                return -1;
            }
            a0();
            return 1;
        }
        if (((t0) obj).a()) {
            return 0;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1598e;
        t0Var = m1.g;
        if (!atomicReferenceFieldUpdater.compareAndSet(this, obj, t0Var)) {
            return -1;
        }
        a0();
        return 1;
    }

    private final String g0(Object obj) {
        if (!(obj instanceof c)) {
            return obj instanceof c1 ? ((c1) obj).a() ? "Active" : "New" : obj instanceof q ? "Cancelled" : "Completed";
        }
        c cVar = (c) obj;
        return cVar.g() ? "Cancelling" : cVar.h() ? "Completing" : "Active";
    }

    public static /* synthetic */ CancellationException i0(l1 l1Var, Throwable th, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        return l1Var.h0(th, str);
    }

    private final boolean k0(c1 c1Var, Object obj) {
        if (h0.a()) {
            if (!((c1Var instanceof t0) || (c1Var instanceof k1))) {
                throw new AssertionError();
            }
        }
        if (h0.a() && !(!(obj instanceof q))) {
            throw new AssertionError();
        }
        if (!f1598e.compareAndSet(this, c1Var, m1.g(obj))) {
            return false;
        }
        Y(null);
        Z(obj);
        z(c1Var, obj);
        return true;
    }

    private final boolean l0(c1 c1Var, Throwable th) {
        if (h0.a() && !(!(c1Var instanceof c))) {
            throw new AssertionError();
        }
        if (h0.a() && !c1Var.a()) {
            throw new AssertionError();
        }
        q1 I = I(c1Var);
        if (I == null) {
            return false;
        }
        if (!f1598e.compareAndSet(this, c1Var, new c(I, false, th))) {
            return false;
        }
        W(I, th);
        return true;
    }

    private final Object m0(Object obj, Object obj2) {
        kotlinx.coroutines.internal.r rVar;
        kotlinx.coroutines.internal.r rVar2;
        if (!(obj instanceof c1)) {
            rVar2 = m1.a;
            return rVar2;
        }
        if ((!(obj instanceof t0) && !(obj instanceof k1)) || (obj instanceof n) || (obj2 instanceof q)) {
            return n0((c1) obj, obj2);
        }
        if (k0((c1) obj, obj2)) {
            return obj2;
        }
        rVar = m1.f1603c;
        return rVar;
    }

    private final Object n0(c1 c1Var, Object obj) {
        kotlinx.coroutines.internal.r rVar;
        kotlinx.coroutines.internal.r rVar2;
        kotlinx.coroutines.internal.r rVar3;
        q1 I = I(c1Var);
        if (I == null) {
            rVar = m1.f1603c;
            return rVar;
        }
        c cVar = (c) (!(c1Var instanceof c) ? null : c1Var);
        if (cVar == null) {
            cVar = new c(I, false, null);
        }
        synchronized (cVar) {
            if (cVar.h()) {
                rVar3 = m1.a;
                return rVar3;
            }
            cVar.k(true);
            if (cVar != c1Var && !f1598e.compareAndSet(this, c1Var, cVar)) {
                rVar2 = m1.f1603c;
                return rVar2;
            }
            if (h0.a() && !(!cVar.i())) {
                throw new AssertionError();
            }
            boolean g = cVar.g();
            q qVar = (q) (!(obj instanceof q) ? null : obj);
            if (qVar != null) {
                cVar.b(qVar.a);
            }
            Throwable f = true ^ g ? cVar.f() : null;
            e.j jVar = e.j.a;
            if (f != null) {
                W(I, f);
            }
            n D = D(c1Var);
            return (D == null || !o0(cVar, D, obj)) ? C(cVar, obj) : m1.f1602b;
        }
    }

    private final boolean o0(c cVar, n nVar, Object obj) {
        while (h1.a.c(nVar.i, false, false, new b(this, cVar, nVar, obj), 1, null) == r1.f1610e) {
            nVar = V(nVar);
            if (nVar == null) {
                return false;
            }
        }
        return true;
    }

    private final boolean p(Object obj, q1 q1Var, k1<?> k1Var) {
        int q;
        d dVar = new d(k1Var, k1Var, this, obj);
        do {
            q = q1Var.l().q(k1Var, q1Var, dVar);
            if (q == 1) {
                return true;
            }
        } while (q != 2);
        return false;
    }

    private final void q(Throwable th, List<? extends Throwable> list) {
        if (list.size() <= 1) {
            return;
        }
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
        Throwable k = !h0.d() ? th : kotlinx.coroutines.internal.q.k(th);
        for (Throwable th2 : list) {
            if (h0.d()) {
                th2 = kotlinx.coroutines.internal.q.k(th2);
            }
            if (th2 != th && th2 != k && !(th2 instanceof CancellationException) && newSetFromMap.add(th2)) {
                e.b.a(th, th2);
            }
        }
    }

    private final Object v(Object obj) {
        kotlinx.coroutines.internal.r rVar;
        Object m0;
        kotlinx.coroutines.internal.r rVar2;
        do {
            Object K = K();
            if (!(K instanceof c1) || ((K instanceof c) && ((c) K).h())) {
                rVar = m1.a;
                return rVar;
            }
            m0 = m0(K, new q(B(obj), false, 2, null));
            rVar2 = m1.f1603c;
        } while (m0 == rVar2);
        return m0;
    }

    private final boolean w(Throwable th) {
        if (Q()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        m J = J();
        return (J == null || J == r1.f1610e) ? z : J.d(th) || z;
    }

    private final void z(c1 c1Var, Object obj) {
        m J = J();
        if (J != null) {
            J.b();
            e0(r1.f1610e);
        }
        if (!(obj instanceof q)) {
            obj = null;
        }
        q qVar = (q) obj;
        Throwable th = qVar != null ? qVar.a : null;
        if (!(c1Var instanceof k1)) {
            q1 c2 = c1Var.c();
            if (c2 != null) {
                X(c2, th);
                return;
            }
            return;
        }
        try {
            ((k1) c1Var).r(th);
        } catch (Throwable th2) {
            M(new v("Exception in completion handler " + c1Var + " for " + this, th2));
        }
    }

    public boolean G() {
        return true;
    }

    public boolean H() {
        return false;
    }

    public final m J() {
        return (m) this._parentHandle;
    }

    public final Object K() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof kotlinx.coroutines.internal.o)) {
                return obj;
            }
            ((kotlinx.coroutines.internal.o) obj).c(this);
        }
    }

    protected boolean L(Throwable th) {
        return false;
    }

    public void M(Throwable th) {
        throw th;
    }

    public final void N(h1 h1Var) {
        if (h0.a()) {
            if (!(J() == null)) {
                throw new AssertionError();
            }
        }
        if (h1Var == null) {
            e0(r1.f1610e);
            return;
        }
        h1Var.start();
        m m = h1Var.m(this);
        e0(m);
        if (P()) {
            m.b();
            e0(r1.f1610e);
        }
    }

    public final r0 O(e.p.c.l<? super Throwable, e.j> lVar) {
        return d(false, true, lVar);
    }

    public final boolean P() {
        return !(K() instanceof c1);
    }

    protected boolean Q() {
        return false;
    }

    public final Object S(Object obj) {
        Object m0;
        kotlinx.coroutines.internal.r rVar;
        kotlinx.coroutines.internal.r rVar2;
        do {
            m0 = m0(K(), obj);
            rVar = m1.a;
            if (m0 == rVar) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, E(obj));
            }
            rVar2 = m1.f1603c;
        } while (m0 == rVar2);
        return m0;
    }

    public String U() {
        return i0.a(this);
    }

    protected void Y(Throwable th) {
    }

    protected void Z(Object obj) {
    }

    @Override // kotlinx.coroutines.h1
    public boolean a() {
        Object K = K();
        return (K instanceof c1) && ((c1) K).a();
    }

    public void a0() {
    }

    @Override // kotlinx.coroutines.t1
    public CancellationException c() {
        Throwable th;
        Object K = K();
        if (K instanceof c) {
            th = ((c) K).f();
        } else if (K instanceof q) {
            th = ((q) K).a;
        } else {
            if (K instanceof c1) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + K).toString());
            }
            th = null;
        }
        CancellationException cancellationException = (CancellationException) (th instanceof CancellationException ? th : null);
        if (cancellationException != null) {
            return cancellationException;
        }
        return new i1("Parent job is " + g0(K), th, this);
    }

    @Override // kotlinx.coroutines.h1
    public final r0 d(boolean z, boolean z2, e.p.c.l<? super Throwable, e.j> lVar) {
        Throwable th;
        k1<?> k1Var = null;
        while (true) {
            Object K = K();
            if (K instanceof t0) {
                t0 t0Var = (t0) K;
                if (t0Var.a()) {
                    if (k1Var == null) {
                        k1Var = T(lVar, z);
                    }
                    if (f1598e.compareAndSet(this, K, k1Var)) {
                        return k1Var;
                    }
                } else {
                    b0(t0Var);
                }
            } else {
                if (!(K instanceof c1)) {
                    if (z2) {
                        if (!(K instanceof q)) {
                            K = null;
                        }
                        q qVar = (q) K;
                        lVar.invoke(qVar != null ? qVar.a : null);
                    }
                    return r1.f1610e;
                }
                q1 c2 = ((c1) K).c();
                if (c2 != null) {
                    r0 r0Var = r1.f1610e;
                    if (z && (K instanceof c)) {
                        synchronized (K) {
                            th = ((c) K).f();
                            if (th == null || ((lVar instanceof n) && !((c) K).h())) {
                                if (k1Var == null) {
                                    k1Var = T(lVar, z);
                                }
                                if (p(K, c2, k1Var)) {
                                    if (th == null) {
                                        return k1Var;
                                    }
                                    r0Var = k1Var;
                                }
                            }
                            e.j jVar = e.j.a;
                        }
                    } else {
                        th = null;
                    }
                    if (th != null) {
                        if (z2) {
                            lVar.invoke(th);
                        }
                        return r0Var;
                    }
                    if (k1Var == null) {
                        k1Var = T(lVar, z);
                    }
                    if (p(K, c2, k1Var)) {
                        return k1Var;
                    }
                } else {
                    if (K == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.JobNode<*>");
                    }
                    c0((k1) K);
                }
            }
        }
    }

    public final void d0(k1<?> k1Var) {
        Object K;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        t0 t0Var;
        do {
            K = K();
            if (!(K instanceof k1)) {
                if (!(K instanceof c1) || ((c1) K).c() == null) {
                    return;
                }
                k1Var.n();
                return;
            }
            if (K != k1Var) {
                return;
            }
            atomicReferenceFieldUpdater = f1598e;
            t0Var = m1.g;
        } while (!atomicReferenceFieldUpdater.compareAndSet(this, K, t0Var));
    }

    @Override // kotlinx.coroutines.h1
    public final CancellationException e() {
        Object K = K();
        if (!(K instanceof c)) {
            if (K instanceof c1) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            if (K instanceof q) {
                return i0(this, ((q) K).a, null, 1, null);
            }
            return new i1(i0.a(this) + " has completed normally", null, this);
        }
        Throwable f = ((c) K).f();
        if (f != null) {
            CancellationException h0 = h0(f, i0.a(this) + " is cancelling");
            if (h0 != null) {
                return h0;
            }
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    public final void e0(m mVar) {
        this._parentHandle = mVar;
    }

    @Override // e.m.g
    public <R> R fold(R r, e.p.c.p<? super R, ? super g.b, ? extends R> pVar) {
        return (R) h1.a.a(this, r, pVar);
    }

    @Override // e.m.g.b, e.m.g
    public <E extends g.b> E get(g.c<E> cVar) {
        return (E) h1.a.b(this, cVar);
    }

    @Override // e.m.g.b
    public final g.c<?> getKey() {
        return h1.f1578d;
    }

    protected final CancellationException h0(Throwable th, String str) {
        CancellationException cancellationException = (CancellationException) (!(th instanceof CancellationException) ? null : th);
        if (cancellationException == null) {
            if (str == null) {
                str = x();
            }
            cancellationException = new i1(str, th, this);
        }
        return cancellationException;
    }

    @Override // kotlinx.coroutines.o
    public final void i(t1 t1Var) {
        u(t1Var);
    }

    public final String j0() {
        return U() + '{' + g0(K()) + '}';
    }

    @Override // kotlinx.coroutines.h1
    public final m m(o oVar) {
        r0 c2 = h1.a.c(this, true, false, new n(this, oVar), 2, null);
        if (c2 != null) {
            return (m) c2;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
    }

    @Override // e.m.g
    public e.m.g minusKey(g.c<?> cVar) {
        return h1.a.d(this, cVar);
    }

    @Override // e.m.g
    public e.m.g plus(e.m.g gVar) {
        return h1.a.e(this, gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r(Object obj) {
    }

    public final Object s(e.m.d<Object> dVar) {
        Object K;
        do {
            K = K();
            if (!(K instanceof c1)) {
                if (!(K instanceof q)) {
                    return m1.h(K);
                }
                Throwable th = ((q) K).a;
                if (!h0.d()) {
                    throw th;
                }
                if (dVar instanceof e.m.j.a.d) {
                    throw kotlinx.coroutines.internal.q.a(th, (e.m.j.a.d) dVar);
                }
                throw th;
            }
        } while (f0(K) < 0);
        return t(dVar);
    }

    @Override // kotlinx.coroutines.h1
    public final boolean start() {
        int f0;
        do {
            f0 = f0(K());
            if (f0 == 0) {
                return false;
            }
        } while (f0 != 1);
        return true;
    }

    final /* synthetic */ Object t(e.m.d<Object> dVar) {
        e.m.d c2;
        Object d2;
        c2 = e.m.i.c.c(dVar);
        a aVar = new a(c2, this);
        j.a(aVar, O(new u1(this, aVar)));
        Object q = aVar.q();
        d2 = e.m.i.d.d();
        if (q == d2) {
            e.m.j.a.g.c(dVar);
        }
        return q;
    }

    public String toString() {
        return j0() + '@' + i0.b(this);
    }

    public final boolean u(Object obj) {
        Object obj2;
        kotlinx.coroutines.internal.r rVar;
        kotlinx.coroutines.internal.r rVar2;
        kotlinx.coroutines.internal.r rVar3;
        obj2 = m1.a;
        if (H() && (obj2 = v(obj)) == m1.f1602b) {
            return true;
        }
        rVar = m1.a;
        if (obj2 == rVar) {
            obj2 = R(obj);
        }
        rVar2 = m1.a;
        if (obj2 == rVar2 || obj2 == m1.f1602b) {
            return true;
        }
        rVar3 = m1.f1604d;
        if (obj2 == rVar3) {
            return false;
        }
        r(obj2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String x() {
        return "Job was cancelled";
    }

    public boolean y(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return u(th) && G();
    }
}
