package e.m;

import e.m.g;
import e.m.g.b;
import e.p.c.l;
import e.p.d.i;

/* loaded from: classes.dex */
public abstract class b<B extends g.b, E extends B> implements g.c<E> {
    private final g.c<?> a;

    /* renamed from: b, reason: collision with root package name */
    private final l<g.b, E> f1533b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [e.m.g$c<?>] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v0, types: [e.p.c.l<e.m.g$b, E extends B>, e.p.c.l<? super e.m.g$b, ? extends E extends B>, java.lang.Object] */
    public b(g.c<B> cVar, l<? super g.b, ? extends E> lVar) {
        i.d(cVar, "baseKey");
        i.d(lVar, "safeCast");
        this.f1533b = lVar;
        this.a = cVar instanceof b ? (g.c<B>) ((b) cVar).a : cVar;
    }

    public final boolean a(g.c<?> cVar) {
        i.d(cVar, "key");
        return cVar == this || this.a == cVar;
    }

    /* JADX WARN: Incorrect return type in method signature: (Le/m/g$b;)TE; */
    public final g.b b(g.b bVar) {
        i.d(bVar, "element");
        return (g.b) this.f1533b.invoke(bVar);
    }
}
