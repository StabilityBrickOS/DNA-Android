package kotlinx.coroutines;

import e.m.g;

/* loaded from: classes.dex */
public interface w1<S> extends g.b {

    /* loaded from: classes.dex */
    public static final class a {
        public static <S, R> R a(w1<S> w1Var, R r, e.p.c.p<? super R, ? super g.b, ? extends R> pVar) {
            return (R) g.b.a.a(w1Var, r, pVar);
        }

        public static <S, E extends g.b> E b(w1<S> w1Var, g.c<E> cVar) {
            return (E) g.b.a.b(w1Var, cVar);
        }

        public static <S> e.m.g c(w1<S> w1Var, g.c<?> cVar) {
            return g.b.a.c(w1Var, cVar);
        }

        public static <S> e.m.g d(w1<S> w1Var, e.m.g gVar) {
            return g.b.a.d(w1Var, gVar);
        }
    }

    void j(e.m.g gVar, S s);

    S l(e.m.g gVar);
}
