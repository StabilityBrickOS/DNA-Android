package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f1 extends j1<h1> {
    private static final AtomicIntegerFieldUpdater j = AtomicIntegerFieldUpdater.newUpdater(f1.class, "_invoked");
    private volatile int _invoked;
    private final e.p.c.l<Throwable, e.j> i;

    /* JADX WARN: Multi-variable type inference failed */
    public f1(h1 h1Var, e.p.c.l<? super Throwable, e.j> lVar) {
        super(h1Var);
        this.i = lVar;
        this._invoked = 0;
    }

    @Override // e.p.c.l
    public /* bridge */ /* synthetic */ e.j invoke(Throwable th) {
        r(th);
        return e.j.a;
    }

    @Override // kotlinx.coroutines.u
    public void r(Throwable th) {
        if (j.compareAndSet(this, 0, 1)) {
            this.i.invoke(th);
        }
    }

    @Override // kotlinx.coroutines.internal.i
    public String toString() {
        return "InvokeOnCancelling[" + i0.a(this) + '@' + i0.b(this) + ']';
    }
}
