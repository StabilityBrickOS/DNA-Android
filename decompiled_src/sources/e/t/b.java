package e.t;

import e.p.c.l;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b<T> implements c<T> {
    private final e.p.c.a<T> a;

    /* renamed from: b, reason: collision with root package name */
    private final l<T, T> f1546b;

    /* loaded from: classes.dex */
    public static final class a implements Iterator<T> {

        /* renamed from: e, reason: collision with root package name */
        private T f1547e;
        private int f = -2;

        a() {
        }

        private final void a() {
            T t;
            if (this.f == -2) {
                t = (T) b.this.a.invoke();
            } else {
                l lVar = b.this.f1546b;
                T t2 = this.f1547e;
                e.p.d.i.b(t2);
                t = (T) lVar.invoke(t2);
            }
            this.f1547e = t;
            this.f = t == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f < 0) {
                a();
            }
            return this.f == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f < 0) {
                a();
            }
            if (this.f == 0) {
                throw new NoSuchElementException();
            }
            T t = this.f1547e;
            if (t == null) {
                throw new NullPointerException("null cannot be cast to non-null type T");
            }
            this.f = -1;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(e.p.c.a<? extends T> aVar, l<? super T, ? extends T> lVar) {
        e.p.d.i.d(aVar, "getInitialValue");
        e.p.d.i.d(lVar, "getNextValue");
        this.a = aVar;
        this.f1546b = lVar;
    }

    @Override // e.t.c
    public Iterator<T> iterator() {
        return new a();
    }
}
