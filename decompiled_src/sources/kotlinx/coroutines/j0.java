package kotlinx.coroutines;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* loaded from: classes.dex */
public final class j0 extends v0 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;
    private static final long k;
    public static final j0 l;

    static {
        Long l2;
        j0 j0Var = new j0();
        l = j0Var;
        u0.u(j0Var, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l2 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l2 = 1000L;
        }
        k = timeUnit.toNanos(l2.longValue());
    }

    private j0() {
    }

    private final synchronized void Q() {
        if (S()) {
            debugStatus = 3;
            L();
            notifyAll();
        }
    }

    private final synchronized Thread R() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    private final boolean S() {
        int i = debugStatus;
        return i == 2 || i == 3;
    }

    private final synchronized boolean T() {
        if (S()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean I;
        x1.f1616b.c(this);
        y1 a = z1.a();
        if (a != null) {
            a.e();
        }
        try {
            if (!T()) {
                if (I) {
                    return;
                } else {
                    return;
                }
            }
            long j = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long J = J();
                if (J == Long.MAX_VALUE) {
                    y1 a2 = z1.a();
                    long h = a2 != null ? a2.h() : System.nanoTime();
                    if (j == Long.MAX_VALUE) {
                        j = k + h;
                    }
                    long j2 = j - h;
                    if (j2 <= 0) {
                        _thread = null;
                        Q();
                        y1 a3 = z1.a();
                        if (a3 != null) {
                            a3.d();
                        }
                        if (I()) {
                            return;
                        }
                        z();
                        return;
                    }
                    J = e.r.f.d(J, j2);
                } else {
                    j = Long.MAX_VALUE;
                }
                if (J > 0) {
                    if (S()) {
                        _thread = null;
                        Q();
                        y1 a4 = z1.a();
                        if (a4 != null) {
                            a4.d();
                        }
                        if (I()) {
                            return;
                        }
                        z();
                        return;
                    }
                    y1 a5 = z1.a();
                    if (a5 != null) {
                        a5.b(this, J);
                    } else {
                        LockSupport.parkNanos(this, J);
                    }
                }
            }
        } finally {
            _thread = null;
            Q();
            y1 a6 = z1.a();
            if (a6 != null) {
                a6.d();
            }
            if (!I()) {
                z();
            }
        }
    }

    @Override // kotlinx.coroutines.w0
    protected Thread z() {
        Thread thread = _thread;
        return thread != null ? thread : R();
    }
}
