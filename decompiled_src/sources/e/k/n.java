package e.k;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends m {
    public static <T> boolean i(Collection<? super T> collection, Iterable<? extends T> iterable) {
        e.p.d.i.d(collection, "$this$addAll");
        e.p.d.i.d(iterable, "elements");
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        boolean z = false;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z = true;
            }
        }
        return z;
    }

    private static final <T> boolean j(Iterable<? extends T> iterable, e.p.c.l<? super T, Boolean> lVar, boolean z) {
        Iterator<? extends T> it = iterable.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            if (lVar.invoke(it.next()).booleanValue() == z) {
                it.remove();
                z2 = true;
            }
        }
        return z2;
    }

    public static <T> boolean k(Iterable<? extends T> iterable, e.p.c.l<? super T, Boolean> lVar) {
        e.p.d.i.d(iterable, "$this$retainAll");
        e.p.d.i.d(lVar, "predicate");
        return j(iterable, lVar, false);
    }
}
