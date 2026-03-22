package e.m;

import e.m.g;
import e.p.d.i;

/* loaded from: classes.dex */
public interface e extends g.b {

    /* renamed from: b, reason: collision with root package name */
    public static final b f1534b = b.a;

    /* loaded from: classes.dex */
    public static final class a {
        public static <E extends g.b> E a(e eVar, g.c<E> cVar) {
            i.d(cVar, "key");
            if (!(cVar instanceof e.m.b)) {
                if (e.f1534b != cVar) {
                    return null;
                }
                if (eVar != null) {
                    return eVar;
                }
                throw new NullPointerException("null cannot be cast to non-null type E");
            }
            e.m.b bVar = (e.m.b) cVar;
            if (!bVar.a(eVar.getKey())) {
                return null;
            }
            E e2 = (E) bVar.b(eVar);
            if (e2 instanceof g.b) {
                return e2;
            }
            return null;
        }

        public static g b(e eVar, g.c<?> cVar) {
            i.d(cVar, "key");
            if (!(cVar instanceof e.m.b)) {
                return e.f1534b == cVar ? h.INSTANCE : eVar;
            }
            e.m.b bVar = (e.m.b) cVar;
            return (!bVar.a(eVar.getKey()) || bVar.b(eVar) == null) ? eVar : h.INSTANCE;
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements g.c<e> {
        static final /* synthetic */ b a = new b();

        private b() {
        }
    }

    void b(d<?> dVar);

    <T> d<T> f(d<? super T> dVar);
}
