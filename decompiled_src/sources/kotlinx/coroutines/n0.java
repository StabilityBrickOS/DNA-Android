package kotlinx.coroutines;

import e.f;
import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public final class n0 {
    private static final kotlinx.coroutines.internal.r a = new kotlinx.coroutines.internal.r("UNDEFINED");

    /* renamed from: b, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.r f1606b = new kotlinx.coroutines.internal.r("REUSABLE_CLAIMED");

    public static final /* synthetic */ kotlinx.coroutines.internal.r a() {
        return a;
    }

    public static final <T> void b(e.m.d<? super T> dVar, Object obj) {
        boolean z;
        if (!(dVar instanceof m0)) {
            dVar.resumeWith(obj);
            return;
        }
        m0 m0Var = (m0) dVar;
        Object a2 = r.a(obj);
        if (m0Var.k.o(m0Var.getContext())) {
            m0Var.h = a2;
            m0Var.g = 1;
            m0Var.k.n(m0Var.getContext(), m0Var);
            return;
        }
        u0 a3 = x1.f1616b.a();
        if (a3.v()) {
            m0Var.h = a2;
            m0Var.g = 1;
            a3.r(m0Var);
            return;
        }
        a3.t(true);
        try {
            h1 h1Var = (h1) m0Var.getContext().get(h1.f1578d);
            if (h1Var == null || h1Var.a()) {
                z = false;
            } else {
                CancellationException e2 = h1Var.e();
                f.a aVar = e.f.Companion;
                m0Var.resumeWith(e.f.m266constructorimpl(e.g.a(e2)));
                z = true;
            }
            if (!z) {
                e.m.g context = m0Var.getContext();
                Object c2 = kotlinx.coroutines.internal.v.c(context, m0Var.j);
                try {
                    m0Var.l.resumeWith(obj);
                    e.j jVar = e.j.a;
                    kotlinx.coroutines.internal.v.a(context, c2);
                } catch (Throwable th) {
                    kotlinx.coroutines.internal.v.a(context, c2);
                    throw th;
                }
            }
            do {
            } while (a3.x());
        } finally {
            try {
            } finally {
            }
        }
    }
}
