package kotlinx.coroutines;

import e.m.e;
import e.m.g;

/* loaded from: classes.dex */
public abstract class y extends e.m.a implements e.m.e {

    /* renamed from: e, reason: collision with root package name */
    public static final a f1617e = new a(null);

    /* loaded from: classes.dex */
    public static final class a extends e.m.b<e.m.e, y> {

        /* renamed from: kotlinx.coroutines.y$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static final class C0126a extends e.p.d.j implements e.p.c.l<g.b, y> {
            public static final C0126a INSTANCE = new C0126a();

            C0126a() {
                super(1);
            }

            @Override // e.p.c.l
            public final y invoke(g.b bVar) {
                if (!(bVar instanceof y)) {
                    bVar = null;
                }
                return (y) bVar;
            }
        }

        private a() {
            super(e.m.e.f1534b, C0126a.INSTANCE);
        }

        public /* synthetic */ a(e.p.d.e eVar) {
            this();
        }
    }

    public y() {
        super(e.m.e.f1534b);
    }

    @Override // e.m.e
    public void b(e.m.d<?> dVar) {
        if (dVar == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.DispatchedContinuation<*>");
        }
        i<?> h = ((m0) dVar).h();
        if (h != null) {
            h.l();
        }
    }

    @Override // e.m.e
    public final <T> e.m.d<T> f(e.m.d<? super T> dVar) {
        return new m0(this, dVar);
    }

    @Override // e.m.a, e.m.g.b, e.m.g
    public <E extends g.b> E get(g.c<E> cVar) {
        return (E) e.a.a(this, cVar);
    }

    @Override // e.m.a, e.m.g
    public e.m.g minusKey(g.c<?> cVar) {
        return e.a.b(this, cVar);
    }

    public abstract void n(e.m.g gVar, Runnable runnable);

    public boolean o(e.m.g gVar) {
        return true;
    }

    public String toString() {
        return i0.a(this) + '@' + i0.b(this);
    }
}
