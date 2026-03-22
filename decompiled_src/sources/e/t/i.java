package e.t;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends h {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    public static final class a<T> implements Iterable<T> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ c f1548e;

        public a(c cVar) {
            this.f1548e = cVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return this.f1548e.iterator();
        }
    }

    public static <T> Iterable<T> d(c<? extends T> cVar) {
        e.p.d.i.d(cVar, "$this$asIterable");
        return new a(cVar);
    }

    public static final <T, C extends Collection<? super T>> C e(c<? extends T> cVar, C c2) {
        e.p.d.i.d(cVar, "$this$toCollection");
        e.p.d.i.d(c2, "destination");
        Iterator<? extends T> it = cVar.iterator();
        while (it.hasNext()) {
            c2.add(it.next());
        }
        return c2;
    }

    public static <T> List<T> f(c<? extends T> cVar) {
        List<T> e2;
        e.p.d.i.d(cVar, "$this$toList");
        e2 = e.k.i.e(g(cVar));
        return e2;
    }

    public static final <T> List<T> g(c<? extends T> cVar) {
        e.p.d.i.d(cVar, "$this$toMutableList");
        ArrayList arrayList = new ArrayList();
        e(cVar, arrayList);
        return arrayList;
    }
}
