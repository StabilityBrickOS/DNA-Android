package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.h1;

/* loaded from: classes.dex */
public class i<T> extends o0<T> implements h<T>, e.m.j.a.d {
    private static final AtomicIntegerFieldUpdater j = AtomicIntegerFieldUpdater.newUpdater(i.class, "_decision");
    private static final AtomicReferenceFieldUpdater k = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "_state");
    private volatile int _decision;
    private volatile Object _parentHandle;
    private volatile Object _state;
    private final e.m.g h;
    private final e.m.d<T> i;

    /* JADX WARN: Multi-variable type inference failed */
    public i(e.m.d<? super T> dVar, int i) {
        super(i);
        this.i = dVar;
        this.h = dVar.getContext();
        this._decision = 0;
        this._state = b.f1556e;
        this._parentHandle = null;
    }

    private final void A() {
        h1 h1Var;
        if (j() || p() != null || (h1Var = (h1) this.i.getContext().get(h1.f1578d)) == null) {
            return;
        }
        h1Var.start();
        r0 c2 = h1.a.c(h1Var, true, false, new l(h1Var, this), 2, null);
        z(c2);
        if (!s() || t()) {
            return;
        }
        c2.b();
        z(r1.f1610e);
    }

    private final boolean B() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!j.compareAndSet(this, 0, 2));
        return true;
    }

    private final boolean C() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!j.compareAndSet(this, 0, 1));
        return true;
    }

    private final void g(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    private final boolean i(Throwable th) {
        if (this.g != 0) {
            return false;
        }
        e.m.d<T> dVar = this.i;
        if (!(dVar instanceof m0)) {
            dVar = null;
        }
        m0 m0Var = (m0) dVar;
        if (m0Var != null) {
            return m0Var.j(th);
        }
        return false;
    }

    private final boolean j() {
        Throwable g;
        boolean s = s();
        if (this.g != 0) {
            return s;
        }
        e.m.d<T> dVar = this.i;
        if (!(dVar instanceof m0)) {
            dVar = null;
        }
        m0 m0Var = (m0) dVar;
        if (m0Var == null || (g = m0Var.g(this)) == null) {
            return s;
        }
        if (!s) {
            h(g);
        }
        return true;
    }

    private final void m() {
        if (t()) {
            return;
        }
        l();
    }

    private final void n(int i) {
        if (B()) {
            return;
        }
        p0.a(this, i);
    }

    private final r0 p() {
        return (r0) this._parentHandle;
    }

    private final boolean t() {
        e.m.d<T> dVar = this.i;
        return (dVar instanceof m0) && ((m0) dVar).i(this);
    }

    private final f u(e.p.c.l<? super Throwable, e.j> lVar) {
        return lVar instanceof f ? (f) lVar : new e1(lVar);
    }

    private final void v(e.p.c.l<? super Throwable, e.j> lVar, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + lVar + ", already has " + obj).toString());
    }

    private final k y(Object obj, int i) {
        Object obj2;
        do {
            obj2 = this._state;
            if (!(obj2 instanceof s1)) {
                if (obj2 instanceof k) {
                    k kVar = (k) obj2;
                    if (kVar.c()) {
                        return kVar;
                    }
                }
                g(obj);
                throw null;
            }
        } while (!k.compareAndSet(this, obj2, obj));
        m();
        n(i);
        return null;
    }

    private final void z(r0 r0Var) {
        this._parentHandle = r0Var;
    }

    @Override // kotlinx.coroutines.o0
    public void a(Object obj, Throwable th) {
        if (obj instanceof t) {
            try {
                ((t) obj).f1612b.invoke(th);
            } catch (Throwable th2) {
                a0.a(getContext(), new v("Exception in cancellation handler for " + this, th2));
            }
        }
    }

    @Override // kotlinx.coroutines.o0
    public final e.m.d<T> b() {
        return this.i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.o0
    public <T> T d(Object obj) {
        return obj instanceof s ? (T) ((s) obj).a : obj instanceof t ? (T) ((t) obj).a : obj;
    }

    @Override // kotlinx.coroutines.o0
    public Object f() {
        return r();
    }

    @Override // e.m.j.a.d
    public e.m.j.a.d getCallerFrame() {
        e.m.d<T> dVar = this.i;
        if (!(dVar instanceof e.m.j.a.d)) {
            dVar = null;
        }
        return (e.m.j.a.d) dVar;
    }

    @Override // e.m.d
    public e.m.g getContext() {
        return this.h;
    }

    @Override // e.m.j.a.d
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public boolean h(Throwable th) {
        Object obj;
        boolean z;
        do {
            obj = this._state;
            if (!(obj instanceof s1)) {
                return false;
            }
            z = obj instanceof f;
        } while (!k.compareAndSet(this, obj, new k(this, th, z)));
        if (z) {
            try {
                ((f) obj).a(th);
            } catch (Throwable th2) {
                a0.a(getContext(), new v("Exception in cancellation handler for " + this, th2));
            }
        }
        m();
        n(0);
        return true;
    }

    @Override // kotlinx.coroutines.h
    public void k(e.p.c.l<? super Throwable, e.j> lVar) {
        Object obj;
        f fVar = null;
        do {
            obj = this._state;
            if (!(obj instanceof b)) {
                if (obj instanceof f) {
                    v(lVar, obj);
                    throw null;
                }
                if (obj instanceof k) {
                    if (!((k) obj).b()) {
                        v(lVar, obj);
                        throw null;
                    }
                    try {
                        if (!(obj instanceof q)) {
                            obj = null;
                        }
                        q qVar = (q) obj;
                        lVar.invoke(qVar != null ? qVar.a : null);
                        return;
                    } catch (Throwable th) {
                        a0.a(getContext(), new v("Exception in cancellation handler for " + this, th));
                        return;
                    }
                }
                return;
            }
            if (fVar == null) {
                fVar = u(lVar);
            }
        } while (!k.compareAndSet(this, obj, fVar));
    }

    public final void l() {
        r0 p = p();
        if (p != null) {
            p.b();
        }
        z(r1.f1610e);
    }

    public Throwable o(h1 h1Var) {
        return h1Var.e();
    }

    public final Object q() {
        h1 h1Var;
        Object d2;
        A();
        if (C()) {
            d2 = e.m.i.d.d();
            return d2;
        }
        Object r = r();
        if (r instanceof q) {
            Throwable th = ((q) r).a;
            if (h0.d()) {
                throw kotlinx.coroutines.internal.q.a(th, this);
            }
            throw th;
        }
        if (this.g != 1 || (h1Var = (h1) getContext().get(h1.f1578d)) == null || h1Var.a()) {
            return d(r);
        }
        CancellationException e2 = h1Var.e();
        a(r, e2);
        if (h0.d()) {
            throw kotlinx.coroutines.internal.q.a(e2, this);
        }
        throw e2;
    }

    public final Object r() {
        return this._state;
    }

    @Override // e.m.d
    public void resumeWith(Object obj) {
        y(r.b(obj, this), this.g);
    }

    public boolean s() {
        return !(r() instanceof s1);
    }

    public String toString() {
        return w() + '(' + i0.c(this.i) + "){" + r() + "}@" + i0.b(this);
    }

    protected String w() {
        return "CancellableContinuation";
    }

    public final void x(Throwable th) {
        if (i(th)) {
            return;
        }
        h(th);
        m();
    }
}
