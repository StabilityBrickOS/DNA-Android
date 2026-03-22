package e.m;

import e.m.g;
import e.p.c.p;
import e.p.d.i;

/* loaded from: classes.dex */
public abstract class a implements g.b {
    private final g.c<?> key;

    public a(g.c<?> cVar) {
        i.d(cVar, "key");
        this.key = cVar;
    }

    @Override // e.m.g
    public <R> R fold(R r, p<? super R, ? super g.b, ? extends R> pVar) {
        i.d(pVar, "operation");
        return (R) g.b.a.a(this, r, pVar);
    }

    @Override // e.m.g.b, e.m.g
    public <E extends g.b> E get(g.c<E> cVar) {
        i.d(cVar, "key");
        return (E) g.b.a.b(this, cVar);
    }

    @Override // e.m.g.b
    public g.c<?> getKey() {
        return this.key;
    }

    @Override // e.m.g
    public g minusKey(g.c<?> cVar) {
        i.d(cVar, "key");
        return g.b.a.c(this, cVar);
    }

    @Override // e.m.g
    public g plus(g gVar) {
        i.d(gVar, "context");
        return g.b.a.d(this, gVar);
    }
}
