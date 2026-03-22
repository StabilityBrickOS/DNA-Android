package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public class j<E> {
    private static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "_cur");
    private volatile Object _cur;

    public j(boolean z) {
        this._cur = new k(8, z);
    }

    public final boolean a(E e2) {
        while (true) {
            k kVar = (k) this._cur;
            int a2 = kVar.a(e2);
            if (a2 == 0) {
                return true;
            }
            if (a2 == 1) {
                a.compareAndSet(this, kVar, kVar.i());
            } else if (a2 == 2) {
                return false;
            }
        }
    }

    public final void b() {
        while (true) {
            k kVar = (k) this._cur;
            if (kVar.d()) {
                return;
            } else {
                a.compareAndSet(this, kVar, kVar.i());
            }
        }
    }

    public final int c() {
        return ((k) this._cur).f();
    }

    public final E d() {
        while (true) {
            k kVar = (k) this._cur;
            E e2 = (E) kVar.j();
            if (e2 != k.g) {
                return e2;
            }
            a.compareAndSet(this, kVar, kVar.i());
        }
    }
}
