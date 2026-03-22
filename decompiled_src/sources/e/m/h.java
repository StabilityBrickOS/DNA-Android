package e.m;

import e.m.g;
import e.p.c.p;
import e.p.d.i;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class h implements g, Serializable {
    public static final h INSTANCE = new h();
    private static final long serialVersionUID = 0;

    private h() {
    }

    private final Object readResolve() {
        return INSTANCE;
    }

    @Override // e.m.g
    public <R> R fold(R r, p<? super R, ? super g.b, ? extends R> pVar) {
        i.d(pVar, "operation");
        return r;
    }

    @Override // e.m.g
    public <E extends g.b> E get(g.c<E> cVar) {
        i.d(cVar, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override // e.m.g
    public g minusKey(g.c<?> cVar) {
        i.d(cVar, "key");
        return this;
    }

    @Override // e.m.g
    public g plus(g gVar) {
        i.d(gVar, "context");
        return gVar;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
