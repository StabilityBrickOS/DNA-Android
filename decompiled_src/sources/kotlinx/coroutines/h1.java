package kotlinx.coroutines;

import e.m.g;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* loaded from: classes.dex */
public interface h1 extends g.b {

    /* renamed from: d, reason: collision with root package name */
    public static final b f1578d = b.a;

    /* loaded from: classes.dex */
    public static final class a {
        public static <R> R a(h1 h1Var, R r, e.p.c.p<? super R, ? super g.b, ? extends R> pVar) {
            return (R) g.b.a.a(h1Var, r, pVar);
        }

        public static <E extends g.b> E b(h1 h1Var, g.c<E> cVar) {
            return (E) g.b.a.b(h1Var, cVar);
        }

        public static /* synthetic */ r0 c(h1 h1Var, boolean z, boolean z2, e.p.c.l lVar, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
            }
            if ((i & 1) != 0) {
                z = false;
            }
            if ((i & 2) != 0) {
                z2 = true;
            }
            return h1Var.d(z, z2, lVar);
        }

        public static e.m.g d(h1 h1Var, g.c<?> cVar) {
            return g.b.a.c(h1Var, cVar);
        }

        public static e.m.g e(h1 h1Var, e.m.g gVar) {
            return g.b.a.d(h1Var, gVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements g.c<h1> {
        static final /* synthetic */ b a = new b();

        static {
            CoroutineExceptionHandler.a aVar = CoroutineExceptionHandler.f1554c;
        }

        private b() {
        }
    }

    boolean a();

    r0 d(boolean z, boolean z2, e.p.c.l<? super Throwable, e.j> lVar);

    CancellationException e();

    m m(o oVar);

    boolean start();
}
