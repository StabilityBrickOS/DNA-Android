package kotlinx.coroutines;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class e {
    public static final <T> k0<T> a(d0 d0Var, e.m.g gVar, f0 f0Var, e.p.c.p<? super d0, ? super e.m.d<? super T>, ? extends Object> pVar) {
        e.m.g c2 = x.c(d0Var, gVar);
        l0 n1Var = f0Var.isLazy() ? new n1(c2, pVar) : new l0(c2, true);
        ((a) n1Var).u0(f0Var, n1Var, pVar);
        return (k0<T>) n1Var;
    }

    public static /* synthetic */ k0 b(d0 d0Var, e.m.g gVar, f0 f0Var, e.p.c.p pVar, int i, Object obj) {
        if ((i & 1) != 0) {
            gVar = e.m.h.INSTANCE;
        }
        if ((i & 2) != 0) {
            f0Var = f0.DEFAULT;
        }
        return d.a(d0Var, gVar, f0Var, pVar);
    }

    public static final h1 c(d0 d0Var, e.m.g gVar, f0 f0Var, e.p.c.p<? super d0, ? super e.m.d<? super e.j>, ? extends Object> pVar) {
        e.m.g c2 = x.c(d0Var, gVar);
        a o1Var = f0Var.isLazy() ? new o1(c2, pVar) : new v1(c2, true);
        o1Var.u0(f0Var, o1Var, pVar);
        return o1Var;
    }

    public static /* synthetic */ h1 d(d0 d0Var, e.m.g gVar, f0 f0Var, e.p.c.p pVar, int i, Object obj) {
        if ((i & 1) != 0) {
            gVar = e.m.h.INSTANCE;
        }
        if ((i & 2) != 0) {
            f0Var = f0.DEFAULT;
        }
        return d.c(d0Var, gVar, f0Var, pVar);
    }
}
