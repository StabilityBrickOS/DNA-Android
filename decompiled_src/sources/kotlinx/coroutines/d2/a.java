package kotlinx.coroutines.d2;

import e.f;
import e.g;
import e.j;
import e.m.d;
import e.p.c.l;
import e.p.c.p;
import kotlinx.coroutines.n0;

/* loaded from: classes.dex */
public final class a {
    public static final void a(d<? super j> dVar, d<?> dVar2) {
        try {
            d c2 = e.m.i.b.c(dVar);
            f.a aVar = f.Companion;
            n0.b(c2, f.m266constructorimpl(j.a));
        } catch (Throwable th) {
            f.a aVar2 = f.Companion;
            dVar2.resumeWith(f.m266constructorimpl(g.a(th)));
        }
    }

    public static final <T> void b(l<? super d<? super T>, ? extends Object> lVar, d<? super T> dVar) {
        try {
            d c2 = e.m.i.b.c(e.m.i.b.a(lVar, dVar));
            f.a aVar = f.Companion;
            n0.b(c2, f.m266constructorimpl(j.a));
        } catch (Throwable th) {
            f.a aVar2 = f.Companion;
            dVar.resumeWith(f.m266constructorimpl(g.a(th)));
        }
    }

    public static final <R, T> void c(p<? super R, ? super d<? super T>, ? extends Object> pVar, R r, d<? super T> dVar) {
        try {
            d c2 = e.m.i.b.c(e.m.i.b.b(pVar, r, dVar));
            f.a aVar = f.Companion;
            n0.b(c2, f.m266constructorimpl(j.a));
        } catch (Throwable th) {
            f.a aVar2 = f.Companion;
            dVar.resumeWith(f.m266constructorimpl(g.a(th)));
        }
    }
}
