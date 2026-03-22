package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlinx.coroutines.v0;

/* loaded from: classes.dex */
public abstract class w0 extends u0 {
    /* JADX INFO: Access modifiers changed from: protected */
    public final void A(long j, v0.a aVar) {
        if (h0.a()) {
            if (!(this != j0.l)) {
                throw new AssertionError();
            }
        }
        j0.l.M(j, aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void B() {
        Thread z = z();
        if (Thread.currentThread() != z) {
            y1 a = z1.a();
            if (a != null) {
                a.a(z);
            } else {
                LockSupport.unpark(z);
            }
        }
    }

    protected abstract Thread z();
}
