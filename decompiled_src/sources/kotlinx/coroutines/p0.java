package kotlinx.coroutines;

import e.f;

/* loaded from: classes.dex */
public final class p0 {
    public static final <T> void a(o0<? super T> o0Var, int i) {
        e.m.d<? super T> b2 = o0Var.b();
        if (!c(i) || !(b2 instanceof m0) || b(i) != b(o0Var.g)) {
            d(o0Var, b2, i);
            return;
        }
        y yVar = ((m0) b2).k;
        e.m.g context = b2.getContext();
        if (yVar.o(context)) {
            yVar.n(context, o0Var);
        } else {
            e(o0Var);
        }
    }

    public static final boolean b(int i) {
        return i == 1;
    }

    public static final boolean c(int i) {
        return i == 0 || i == 1;
    }

    public static final <T> void d(o0<? super T> o0Var, e.m.d<? super T> dVar, int i) {
        Object d2;
        Object f = o0Var.f();
        Throwable c2 = o0Var.c(f);
        if (c2 == null) {
            c2 = null;
        } else if (h0.d() && (dVar instanceof e.m.j.a.d)) {
            c2 = kotlinx.coroutines.internal.q.j(c2, (e.m.j.a.d) dVar);
        }
        if (c2 != null) {
            f.a aVar = e.f.Companion;
            d2 = e.g.a(c2);
        } else {
            f.a aVar2 = e.f.Companion;
            d2 = o0Var.d(f);
        }
        Object m266constructorimpl = e.f.m266constructorimpl(d2);
        if (i == 0) {
            dVar.resumeWith(m266constructorimpl);
            return;
        }
        if (i == 1) {
            n0.b(dVar, m266constructorimpl);
            return;
        }
        if (i != 2) {
            throw new IllegalStateException(("Invalid mode " + i).toString());
        }
        if (dVar == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.DispatchedContinuation<T>");
        }
        m0 m0Var = (m0) dVar;
        e.m.g context = m0Var.getContext();
        Object c3 = kotlinx.coroutines.internal.v.c(context, m0Var.j);
        try {
            m0Var.l.resumeWith(m266constructorimpl);
            e.j jVar = e.j.a;
        } finally {
            kotlinx.coroutines.internal.v.a(context, c3);
        }
    }

    private static final void e(o0<?> o0Var) {
        u0 a = x1.f1616b.a();
        if (a.v()) {
            a.r(o0Var);
            return;
        }
        a.t(true);
        try {
            d(o0Var, o0Var.b(), 2);
            do {
            } while (a.x());
        } finally {
            try {
            } finally {
            }
        }
    }
}
