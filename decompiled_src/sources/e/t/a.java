package e.t;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class a<T> implements c<T> {
    private final AtomicReference<c<T>> a;

    public a(c<? extends T> cVar) {
        e.p.d.i.d(cVar, "sequence");
        this.a = new AtomicReference<>(cVar);
    }

    @Override // e.t.c
    public Iterator<T> iterator() {
        c<T> andSet = this.a.getAndSet(null);
        if (andSet != null) {
            return andSet.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
