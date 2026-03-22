package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class m0<T> extends o0<T> implements e.m.j.a.d, e.m.d<T> {
    private static final AtomicReferenceFieldUpdater m = AtomicReferenceFieldUpdater.newUpdater(m0.class, Object.class, "_reusableCancellableContinuation");
    private volatile Object _reusableCancellableContinuation;
    public Object h;
    private final e.m.j.a.d i;
    public final Object j;
    public final y k;
    public final e.m.d<T> l;

    /* JADX WARN: Multi-variable type inference failed */
    public m0(y yVar, e.m.d<? super T> dVar) {
        super(0);
        this.k = yVar;
        this.l = dVar;
        this.h = n0.a();
        e.m.d<T> dVar2 = this.l;
        this.i = (e.m.j.a.d) (dVar2 instanceof e.m.j.a.d ? dVar2 : null);
        this.j = kotlinx.coroutines.internal.v.b(getContext());
        this._reusableCancellableContinuation = null;
    }

    @Override // kotlinx.coroutines.o0
    public e.m.d<T> b() {
        return this;
    }

    @Override // kotlinx.coroutines.o0
    public Object f() {
        Object obj = this.h;
        if (h0.a()) {
            if (!(obj != n0.a())) {
                throw new AssertionError();
            }
        }
        this.h = n0.a();
        return obj;
    }

    public final Throwable g(h<?> hVar) {
        kotlinx.coroutines.internal.r rVar;
        do {
            Object obj = this._reusableCancellableContinuation;
            rVar = n0.f1606b;
            if (obj != rVar) {
                if (obj == null) {
                    return null;
                }
                if (obj instanceof Throwable) {
                    if (m.compareAndSet(this, obj, null)) {
                        return (Throwable) obj;
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        } while (!m.compareAndSet(this, rVar, hVar));
        return null;
    }

    @Override // e.m.j.a.d
    public e.m.j.a.d getCallerFrame() {
        return this.i;
    }

    @Override // e.m.d
    public e.m.g getContext() {
        return this.l.getContext();
    }

    @Override // e.m.j.a.d
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public final i<?> h() {
        Object obj = this._reusableCancellableContinuation;
        if (!(obj instanceof i)) {
            obj = null;
        }
        return (i) obj;
    }

    public final boolean i(i<?> iVar) {
        Object obj = this._reusableCancellableContinuation;
        if (obj != null) {
            return !(obj instanceof i) || obj == iVar;
        }
        return false;
    }

    public final boolean j(Throwable th) {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            if (e.p.d.i.a(obj, n0.f1606b)) {
                if (m.compareAndSet(this, n0.f1606b, th)) {
                    return true;
                }
            } else {
                if (obj instanceof Throwable) {
                    return true;
                }
                if (m.compareAndSet(this, obj, null)) {
                    return false;
                }
            }
        }
    }

    @Override // e.m.d
    public void resumeWith(Object obj) {
        e.m.g context = this.l.getContext();
        Object a = r.a(obj);
        if (this.k.o(context)) {
            this.h = a;
            this.g = 0;
            this.k.n(context, this);
            return;
        }
        u0 a2 = x1.f1616b.a();
        if (a2.v()) {
            this.h = a;
            this.g = 0;
            a2.r(this);
            return;
        }
        a2.t(true);
        try {
            e.m.g context2 = getContext();
            Object c2 = kotlinx.coroutines.internal.v.c(context2, this.j);
            try {
                this.l.resumeWith(obj);
                e.j jVar = e.j.a;
                do {
                } while (a2.x());
            } finally {
                kotlinx.coroutines.internal.v.a(context2, c2);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public String toString() {
        return "DispatchedContinuation[" + this.k + ", " + i0.c(this.l) + ']';
    }
}
