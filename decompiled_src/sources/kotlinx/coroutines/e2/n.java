package kotlinx.coroutines.e2;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.h0;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: b, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f1571b = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "lastScheduledTask");

    /* renamed from: c, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f1572c = AtomicIntegerFieldUpdater.newUpdater(n.class, "producerIndex");

    /* renamed from: d, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f1573d = AtomicIntegerFieldUpdater.newUpdater(n.class, "consumerIndex");

    /* renamed from: e, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f1574e = AtomicIntegerFieldUpdater.newUpdater(n.class, "blockingTasksInBuffer");
    private final AtomicReferenceArray<i> a = new AtomicReferenceArray<>(128);
    private volatile Object lastScheduledTask = null;
    private volatile int producerIndex = 0;
    private volatile int consumerIndex = 0;
    private volatile int blockingTasksInBuffer = 0;

    public static /* synthetic */ i b(n nVar, i iVar, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return nVar.a(iVar, z);
    }

    private final i c(i iVar) {
        if (iVar.f.g() == 1) {
            f1574e.incrementAndGet(this);
        }
        if (e() == 127) {
            return iVar;
        }
        int i = this.producerIndex & 127;
        while (this.a.get(i) != null) {
            Thread.yield();
        }
        this.a.lazySet(i, iVar);
        f1572c.incrementAndGet(this);
        return null;
    }

    private final void d(i iVar) {
        if (iVar != null) {
            if (iVar.f.g() == 1) {
                int decrementAndGet = f1574e.decrementAndGet(this);
                if (h0.a()) {
                    if (!(decrementAndGet >= 0)) {
                        throw new AssertionError();
                    }
                }
            }
        }
    }

    private final i i() {
        i andSet;
        while (true) {
            int i = this.consumerIndex;
            if (i - this.producerIndex == 0) {
                return null;
            }
            int i2 = i & 127;
            if (f1573d.compareAndSet(this, i, i + 1) && (andSet = this.a.getAndSet(i2, null)) != null) {
                d(andSet);
                return andSet;
            }
        }
    }

    private final boolean j(e eVar) {
        i i = i();
        if (i == null) {
            return false;
        }
        eVar.a(i);
        return true;
    }

    private final long m(n nVar, boolean z) {
        i iVar;
        do {
            iVar = (i) nVar.lastScheduledTask;
            if (iVar == null) {
                return -2L;
            }
            if (z) {
                if (!(iVar.f.g() == 1)) {
                    return -2L;
                }
            }
            long a = l.f1570e.a() - iVar.f1566e;
            long j = l.a;
            if (a < j) {
                return j - a;
            }
        } while (!f1571b.compareAndSet(nVar, iVar, null));
        b(this, iVar, false, 2, null);
        return -1L;
    }

    public final i a(i iVar, boolean z) {
        if (z) {
            return c(iVar);
        }
        i iVar2 = (i) f1571b.getAndSet(this, iVar);
        if (iVar2 != null) {
            return c(iVar2);
        }
        return null;
    }

    public final int e() {
        return this.producerIndex - this.consumerIndex;
    }

    public final int f() {
        return this.lastScheduledTask != null ? e() + 1 : e();
    }

    public final void g(e eVar) {
        i iVar = (i) f1571b.getAndSet(this, null);
        if (iVar != null) {
            eVar.a(iVar);
        }
        do {
        } while (j(eVar));
    }

    public final i h() {
        i iVar = (i) f1571b.getAndSet(this, null);
        return iVar != null ? iVar : i();
    }

    public final long k(n nVar) {
        if (h0.a()) {
            if (!(e() == 0)) {
                throw new AssertionError();
            }
        }
        int i = nVar.producerIndex;
        AtomicReferenceArray<i> atomicReferenceArray = nVar.a;
        for (int i2 = nVar.consumerIndex; i2 != i; i2++) {
            int i3 = i2 & 127;
            if (nVar.blockingTasksInBuffer == 0) {
                break;
            }
            i iVar = atomicReferenceArray.get(i3);
            if (iVar != null) {
                if ((iVar.f.g() == 1) && atomicReferenceArray.compareAndSet(i3, iVar, null)) {
                    f1574e.decrementAndGet(nVar);
                    b(this, iVar, false, 2, null);
                    return -1L;
                }
            }
        }
        return m(nVar, true);
    }

    public final long l(n nVar) {
        if (h0.a()) {
            if (!(e() == 0)) {
                throw new AssertionError();
            }
        }
        i i = nVar.i();
        if (i == null) {
            return m(nVar, false);
        }
        i b2 = b(this, i, false, 2, null);
        if (!h0.a()) {
            return -1L;
        }
        if (b2 == null) {
            return -1L;
        }
        throw new AssertionError();
    }
}
