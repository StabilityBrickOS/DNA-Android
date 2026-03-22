package e.m;

import e.p.c.p;
import e.p.d.i;
import e.p.d.j;

/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public static final class a {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: e.m.g$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0119a extends j implements p<g, b, g> {
            public static final C0119a INSTANCE = new C0119a();

            C0119a() {
                super(2);
            }

            @Override // e.p.c.p
            public final g invoke(g gVar, b bVar) {
                i.d(gVar, "acc");
                i.d(bVar, "element");
                g minusKey = gVar.minusKey(bVar.getKey());
                if (minusKey == h.INSTANCE) {
                    return bVar;
                }
                e eVar = (e) minusKey.get(e.f1534b);
                if (eVar == null) {
                    return new e.m.c(minusKey, bVar);
                }
                g minusKey2 = minusKey.minusKey(e.f1534b);
                return minusKey2 == h.INSTANCE ? new e.m.c(bVar, eVar) : new e.m.c(new e.m.c(minusKey2, bVar), eVar);
            }
        }

        public static g a(g gVar, g gVar2) {
            i.d(gVar2, "context");
            return gVar2 == h.INSTANCE ? gVar : (g) gVar2.fold(gVar, C0119a.INSTANCE);
        }
    }

    /* loaded from: classes.dex */
    public interface b extends g {

        /* loaded from: classes.dex */
        public static final class a {
            public static <R> R a(b bVar, R r, p<? super R, ? super b, ? extends R> pVar) {
                i.d(pVar, "operation");
                return pVar.invoke(r, bVar);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static <E extends b> E b(b bVar, c<E> cVar) {
                i.d(cVar, "key");
                if (!i.a(bVar.getKey(), cVar)) {
                    return null;
                }
                if (bVar != 0) {
                    return bVar;
                }
                throw new NullPointerException("null cannot be cast to non-null type E");
            }

            public static g c(b bVar, c<?> cVar) {
                i.d(cVar, "key");
                return i.a(bVar.getKey(), cVar) ? h.INSTANCE : bVar;
            }

            public static g d(b bVar, g gVar) {
                i.d(gVar, "context");
                return a.a(bVar, gVar);
            }
        }

        @Override // e.m.g
        <E extends b> E get(c<E> cVar);

        c<?> getKey();
    }

    /* loaded from: classes.dex */
    public interface c<E extends b> {
    }

    <R> R fold(R r, p<? super R, ? super b, ? extends R> pVar);

    <E extends b> E get(c<E> cVar);

    g minusKey(c<?> cVar);

    g plus(g gVar);
}
