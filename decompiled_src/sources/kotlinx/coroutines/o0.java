package kotlinx.coroutines;

import e.f;

/* loaded from: classes.dex */
public abstract class o0<T> extends kotlinx.coroutines.e2.i {
    public int g;

    public o0(int i) {
        this.g = i;
    }

    public void a(Object obj, Throwable th) {
    }

    public abstract e.m.d<T> b();

    public final Throwable c(Object obj) {
        if (!(obj instanceof q)) {
            obj = null;
        }
        q qVar = (q) obj;
        if (qVar != null) {
            return qVar.a;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T d(Object obj) {
        return obj;
    }

    public final void e(Throwable th, Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            e.b.a(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        e.p.d.i.b(th);
        a0.a(b().getContext(), new g0("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object f();

    @Override // java.lang.Runnable
    public final void run() {
        Object m266constructorimpl;
        Object m266constructorimpl2;
        Object m266constructorimpl3;
        kotlinx.coroutines.e2.j jVar = this.f;
        try {
            e.m.d<T> b2 = b();
            if (b2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.DispatchedContinuation<T>");
            }
            m0 m0Var = (m0) b2;
            e.m.d<T> dVar = m0Var.l;
            e.m.g context = dVar.getContext();
            Object f = f();
            Object c2 = kotlinx.coroutines.internal.v.c(context, m0Var.j);
            try {
                Throwable c3 = c(f);
                h1 h1Var = p0.b(this.g) ? (h1) context.get(h1.f1578d) : null;
                if (c3 == null && h1Var != null && !h1Var.a()) {
                    Throwable e2 = h1Var.e();
                    a(f, e2);
                    f.a aVar = e.f.Companion;
                    if (h0.d() && (dVar instanceof e.m.j.a.d)) {
                        e2 = kotlinx.coroutines.internal.q.a(e2, (e.m.j.a.d) dVar);
                    }
                    m266constructorimpl2 = e.f.m266constructorimpl(e.g.a(e2));
                } else if (c3 != null) {
                    f.a aVar2 = e.f.Companion;
                    m266constructorimpl2 = e.f.m266constructorimpl(e.g.a(c3));
                } else {
                    T d2 = d(f);
                    f.a aVar3 = e.f.Companion;
                    m266constructorimpl2 = e.f.m266constructorimpl(d2);
                }
                dVar.resumeWith(m266constructorimpl2);
                e.j jVar2 = e.j.a;
                try {
                    f.a aVar4 = e.f.Companion;
                    jVar.k();
                    m266constructorimpl3 = e.f.m266constructorimpl(e.j.a);
                } catch (Throwable th) {
                    f.a aVar5 = e.f.Companion;
                    m266constructorimpl3 = e.f.m266constructorimpl(e.g.a(th));
                }
                e(null, e.f.m269exceptionOrNullimpl(m266constructorimpl3));
            } finally {
                kotlinx.coroutines.internal.v.a(context, c2);
            }
        } catch (Throwable th2) {
            try {
                f.a aVar6 = e.f.Companion;
                jVar.k();
                m266constructorimpl = e.f.m266constructorimpl(e.j.a);
            } catch (Throwable th3) {
                f.a aVar7 = e.f.Companion;
                m266constructorimpl = e.f.m266constructorimpl(e.g.a(th3));
            }
            e(th2, e.f.m269exceptionOrNullimpl(m266constructorimpl));
        }
    }
}
