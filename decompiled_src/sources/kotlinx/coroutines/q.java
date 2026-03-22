package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes.dex */
public class q {

    /* renamed from: b, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f1608b = AtomicIntegerFieldUpdater.newUpdater(q.class, "_handled");
    private volatile int _handled;
    public final Throwable a;

    public q(Throwable th, boolean z) {
        this.a = th;
        this._handled = z ? 1 : 0;
    }

    public /* synthetic */ q(Throwable th, boolean z, int i, e.p.d.e eVar) {
        this(th, (i & 2) != 0 ? false : z);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [int, boolean] */
    public final boolean a() {
        return this._handled;
    }

    public final boolean b() {
        return f1608b.compareAndSet(this, 0, 1);
    }

    public String toString() {
        return i0.a(this) + '[' + this.a + ']';
    }
}
