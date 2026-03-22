package kotlinx.coroutines.e2;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlinx.coroutines.z0;

/* loaded from: classes.dex */
final class f extends z0 implements j, Executor {
    private static final AtomicIntegerFieldUpdater k = AtomicIntegerFieldUpdater.newUpdater(f.class, "inFlightTasks");
    private final d g;
    private final int h;
    private final String i;
    private final int j;
    private final ConcurrentLinkedQueue<Runnable> f = new ConcurrentLinkedQueue<>();
    private volatile int inFlightTasks = 0;

    public f(d dVar, int i, String str, int i2) {
        this.g = dVar;
        this.h = i;
        this.i = str;
        this.j = i2;
    }

    private final void p(Runnable runnable, boolean z) {
        while (k.incrementAndGet(this) > this.h) {
            this.f.add(runnable);
            if (k.decrementAndGet(this) >= this.h || (runnable = this.f.poll()) == null) {
                return;
            }
        }
        this.g.q(runnable, this, z);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        p(runnable, false);
    }

    @Override // kotlinx.coroutines.e2.j
    public int g() {
        return this.j;
    }

    @Override // kotlinx.coroutines.e2.j
    public void k() {
        Runnable poll = this.f.poll();
        if (poll != null) {
            this.g.q(poll, this, true);
            return;
        }
        k.decrementAndGet(this);
        Runnable poll2 = this.f.poll();
        if (poll2 != null) {
            p(poll2, true);
        }
    }

    @Override // kotlinx.coroutines.y
    public void n(e.m.g gVar, Runnable runnable) {
        p(runnable, false);
    }

    @Override // kotlinx.coroutines.y
    public String toString() {
        String str = this.i;
        if (str != null) {
            return str;
        }
        return super.toString() + "[dispatcher = " + this.g + ']';
    }
}
