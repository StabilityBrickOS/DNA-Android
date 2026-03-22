package e.m;

import e.f;
import e.j;
import e.p.c.l;
import e.p.c.p;
import e.p.d.i;

/* loaded from: classes.dex */
public final class f {
    public static final <T> void a(l<? super d<? super T>, ? extends Object> lVar, d<? super T> dVar) {
        i.d(lVar, "$this$startCoroutine");
        i.d(dVar, "completion");
        d c2 = e.m.i.b.c(e.m.i.b.a(lVar, dVar));
        j jVar = j.a;
        f.a aVar = e.f.Companion;
        c2.resumeWith(e.f.m266constructorimpl(jVar));
    }

    public static final <R, T> void b(p<? super R, ? super d<? super T>, ? extends Object> pVar, R r, d<? super T> dVar) {
        i.d(pVar, "$this$startCoroutine");
        i.d(dVar, "completion");
        d c2 = e.m.i.b.c(e.m.i.b.b(pVar, r, dVar));
        j jVar = j.a;
        f.a aVar = e.f.Companion;
        c2.resumeWith(e.f.m266constructorimpl(jVar));
    }
}
