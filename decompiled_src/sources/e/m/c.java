package e.m;

import e.m.g;
import e.p.c.p;
import e.p.d.i;
import e.p.d.j;
import e.p.d.m;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class c implements g, Serializable {
    private final g.b element;
    private final g left;

    /* loaded from: classes.dex */
    private static final class a implements Serializable {
        public static final C0117a Companion = new C0117a(null);
        private static final long serialVersionUID = 0;
        private final g[] elements;

        /* renamed from: e.m.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0117a {
            private C0117a() {
            }

            public /* synthetic */ C0117a(e.p.d.e eVar) {
                this();
            }
        }

        public a(g[] gVarArr) {
            i.d(gVarArr, "elements");
            this.elements = gVarArr;
        }

        private final Object readResolve() {
            g[] gVarArr = this.elements;
            g gVar = h.INSTANCE;
            for (g gVar2 : gVarArr) {
                gVar = gVar.plus(gVar2);
            }
            return gVar;
        }

        public final g[] getElements() {
            return this.elements;
        }
    }

    /* loaded from: classes.dex */
    static final class b extends j implements p<String, g.b, String> {
        public static final b INSTANCE = new b();

        b() {
            super(2);
        }

        @Override // e.p.c.p
        public final String invoke(String str, g.b bVar) {
            i.d(str, "acc");
            i.d(bVar, "element");
            if (str.length() == 0) {
                return bVar.toString();
            }
            return str + ", " + bVar;
        }
    }

    /* renamed from: e.m.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static final class C0118c extends j implements p<e.j, g.b, e.j> {
        final /* synthetic */ g[] $elements;
        final /* synthetic */ m $index;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0118c(g[] gVarArr, m mVar) {
            super(2);
            this.$elements = gVarArr;
            this.$index = mVar;
        }

        @Override // e.p.c.p
        public /* bridge */ /* synthetic */ e.j invoke(e.j jVar, g.b bVar) {
            invoke2(jVar, bVar);
            return e.j.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(e.j jVar, g.b bVar) {
            i.d(jVar, "<anonymous parameter 0>");
            i.d(bVar, "element");
            g[] gVarArr = this.$elements;
            m mVar = this.$index;
            int i = mVar.element;
            mVar.element = i + 1;
            gVarArr[i] = bVar;
        }
    }

    public c(g gVar, g.b bVar) {
        i.d(gVar, "left");
        i.d(bVar, "element");
        this.left = gVar;
        this.element = bVar;
    }

    private final boolean contains(g.b bVar) {
        return i.a(get(bVar.getKey()), bVar);
    }

    private final boolean containsAll(c cVar) {
        while (contains(cVar.element)) {
            g gVar = cVar.left;
            if (!(gVar instanceof c)) {
                if (gVar != null) {
                    return contains((g.b) gVar);
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
            }
            cVar = (c) gVar;
        }
        return false;
    }

    private final int size() {
        int i = 2;
        c cVar = this;
        while (true) {
            g gVar = cVar.left;
            if (!(gVar instanceof c)) {
                gVar = null;
            }
            cVar = (c) gVar;
            if (cVar == null) {
                return i;
            }
            i++;
        }
    }

    private final Object writeReplace() {
        int size = size();
        g[] gVarArr = new g[size];
        m mVar = new m();
        mVar.element = 0;
        fold(e.j.a, new C0118c(gVarArr, mVar));
        if (mVar.element == size) {
            return new a(gVarArr);
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (cVar.size() != size() || !cVar.containsAll(this)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // e.m.g
    public <R> R fold(R r, p<? super R, ? super g.b, ? extends R> pVar) {
        i.d(pVar, "operation");
        return pVar.invoke((Object) this.left.fold(r, pVar), this.element);
    }

    @Override // e.m.g
    public <E extends g.b> E get(g.c<E> cVar) {
        i.d(cVar, "key");
        c cVar2 = this;
        while (true) {
            E e2 = (E) cVar2.element.get(cVar);
            if (e2 != null) {
                return e2;
            }
            g gVar = cVar2.left;
            if (!(gVar instanceof c)) {
                return (E) gVar.get(cVar);
            }
            cVar2 = (c) gVar;
        }
    }

    public int hashCode() {
        return this.left.hashCode() + this.element.hashCode();
    }

    @Override // e.m.g
    public g minusKey(g.c<?> cVar) {
        i.d(cVar, "key");
        if (this.element.get(cVar) != null) {
            return this.left;
        }
        g minusKey = this.left.minusKey(cVar);
        return minusKey == this.left ? this : minusKey == h.INSTANCE ? this.element : new c(minusKey, this.element);
    }

    @Override // e.m.g
    public g plus(g gVar) {
        i.d(gVar, "context");
        return g.a.a(this, gVar);
    }

    public String toString() {
        return "[" + ((String) fold("", b.INSTANCE)) + "]";
    }
}
