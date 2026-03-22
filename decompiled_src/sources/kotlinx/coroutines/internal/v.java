package kotlinx.coroutines.internal;

import e.m.g;
import kotlinx.coroutines.w1;

/* loaded from: classes.dex */
public final class v {
    private static final r a = new r("ZERO");

    /* renamed from: b, reason: collision with root package name */
    private static final e.p.c.p<Object, g.b, Object> f1591b = a.INSTANCE;

    /* renamed from: c, reason: collision with root package name */
    private static final e.p.c.p<w1<?>, g.b, w1<?>> f1592c = b.INSTANCE;

    /* renamed from: d, reason: collision with root package name */
    private static final e.p.c.p<y, g.b, y> f1593d = d.INSTANCE;

    /* renamed from: e, reason: collision with root package name */
    private static final e.p.c.p<y, g.b, y> f1594e = c.INSTANCE;

    /* loaded from: classes.dex */
    static final class a extends e.p.d.j implements e.p.c.p<Object, g.b, Object> {
        public static final a INSTANCE = new a();

        a() {
            super(2);
        }

        @Override // e.p.c.p
        public final Object invoke(Object obj, g.b bVar) {
            if (!(bVar instanceof w1)) {
                return obj;
            }
            if (!(obj instanceof Integer)) {
                obj = null;
            }
            Integer num = (Integer) obj;
            int intValue = num != null ? num.intValue() : 1;
            return intValue == 0 ? bVar : Integer.valueOf(intValue + 1);
        }
    }

    /* loaded from: classes.dex */
    static final class b extends e.p.d.j implements e.p.c.p<w1<?>, g.b, w1<?>> {
        public static final b INSTANCE = new b();

        b() {
            super(2);
        }

        @Override // e.p.c.p
        public final w1<?> invoke(w1<?> w1Var, g.b bVar) {
            if (w1Var != null) {
                return w1Var;
            }
            if (!(bVar instanceof w1)) {
                bVar = null;
            }
            return (w1) bVar;
        }
    }

    /* loaded from: classes.dex */
    static final class c extends e.p.d.j implements e.p.c.p<y, g.b, y> {
        public static final c INSTANCE = new c();

        c() {
            super(2);
        }

        @Override // e.p.c.p
        public final y invoke(y yVar, g.b bVar) {
            if (bVar instanceof w1) {
                ((w1) bVar).j(yVar.b(), yVar.d());
            }
            return yVar;
        }
    }

    /* loaded from: classes.dex */
    static final class d extends e.p.d.j implements e.p.c.p<y, g.b, y> {
        public static final d INSTANCE = new d();

        d() {
            super(2);
        }

        @Override // e.p.c.p
        public final y invoke(y yVar, g.b bVar) {
            if (bVar instanceof w1) {
                yVar.a(((w1) bVar).l(yVar.b()));
            }
            return yVar;
        }
    }

    public static final void a(e.m.g gVar, Object obj) {
        if (obj == a) {
            return;
        }
        if (obj instanceof y) {
            ((y) obj).c();
            gVar.fold(obj, f1594e);
        } else {
            Object fold = gVar.fold(null, f1592c);
            if (fold == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            }
            ((w1) fold).j(gVar, obj);
        }
    }

    public static final Object b(e.m.g gVar) {
        Object fold = gVar.fold(0, f1591b);
        e.p.d.i.b(fold);
        return fold;
    }

    public static final Object c(e.m.g gVar, Object obj) {
        if (obj == null) {
            obj = b(gVar);
        }
        if (obj == 0) {
            return a;
        }
        if (obj instanceof Integer) {
            return gVar.fold(new y(gVar, ((Number) obj).intValue()), f1593d);
        }
        if (obj != null) {
            return ((w1) obj).l(gVar);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
    }
}
