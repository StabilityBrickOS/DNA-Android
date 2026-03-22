package e.t;

import e.p.c.l;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends f {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    public static final class a<T> implements c<T> {
        final /* synthetic */ Iterator a;

        public a(Iterator it) {
            this.a = it;
        }

        @Override // e.t.c
        public Iterator<T> iterator() {
            return this.a;
        }
    }

    public static <T> c<T> a(Iterator<? extends T> it) {
        e.p.d.i.d(it, "$this$asSequence");
        return b(new a(it));
    }

    public static final <T> c<T> b(c<? extends T> cVar) {
        e.p.d.i.d(cVar, "$this$constrainOnce");
        return cVar instanceof e.t.a ? (e.t.a) cVar : new e.t.a(cVar);
    }

    public static <T> c<T> c(e.p.c.a<? extends T> aVar, l<? super T, ? extends T> lVar) {
        e.p.d.i.d(aVar, "seedFunction");
        e.p.d.i.d(lVar, "nextFunction");
        return new b(aVar, lVar);
    }
}
