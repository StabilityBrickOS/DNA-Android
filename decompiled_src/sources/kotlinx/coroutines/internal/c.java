package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.h0;

/* loaded from: classes.dex */
public abstract class c<T> extends o {
    private static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_consensus");
    private volatile Object _consensus;

    public c() {
        Object obj;
        obj = b.a;
        this._consensus = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.o
    public c<?> a() {
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.o
    public final Object c(Object obj) {
        Object obj2;
        Object obj3 = this._consensus;
        obj2 = b.a;
        if (obj3 == obj2) {
            obj3 = e(g(obj));
        }
        d(obj, obj3);
        return obj3;
    }

    public abstract void d(T t, Object obj);

    public final Object e(Object obj) {
        Object obj2;
        Object obj3;
        Object obj4;
        if (h0.a()) {
            obj4 = b.a;
            if (!(obj != obj4)) {
                throw new AssertionError();
            }
        }
        Object obj5 = this._consensus;
        obj2 = b.a;
        if (obj5 != obj2) {
            return obj5;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        obj3 = b.a;
        return atomicReferenceFieldUpdater.compareAndSet(this, obj3, obj) ? obj : this._consensus;
    }

    public long f() {
        return 0L;
    }

    public abstract Object g(T t);
}
