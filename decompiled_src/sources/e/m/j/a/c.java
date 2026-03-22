package e.m.j.a;

import e.m.g;

/* loaded from: classes.dex */
public abstract class c extends a {
    private final e.m.g _context;
    private transient e.m.d<Object> intercepted;

    public c(e.m.d<Object> dVar) {
        this(dVar, dVar != null ? dVar.getContext() : null);
    }

    public c(e.m.d<Object> dVar, e.m.g gVar) {
        super(dVar);
        this._context = gVar;
    }

    @Override // e.m.j.a.a, e.m.d
    public e.m.g getContext() {
        e.m.g gVar = this._context;
        e.p.d.i.b(gVar);
        return gVar;
    }

    public final e.m.d<Object> intercepted() {
        e.m.d<Object> dVar = this.intercepted;
        if (dVar == null) {
            e.m.e eVar = (e.m.e) getContext().get(e.m.e.f1534b);
            if (eVar == null || (dVar = eVar.f(this)) == null) {
                dVar = this;
            }
            this.intercepted = dVar;
        }
        return dVar;
    }

    @Override // e.m.j.a.a
    protected void releaseIntercepted() {
        e.m.d<?> dVar = this.intercepted;
        if (dVar != null && dVar != this) {
            g.b bVar = getContext().get(e.m.e.f1534b);
            e.p.d.i.b(bVar);
            ((e.m.e) bVar).b(dVar);
        }
        this.intercepted = b.f1535e;
    }
}
