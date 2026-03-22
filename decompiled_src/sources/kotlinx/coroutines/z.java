package kotlinx.coroutines;

import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class z {
    private static final List<CoroutineExceptionHandler> a;

    static {
        e.t.c a2;
        List<CoroutineExceptionHandler> f;
        a2 = e.t.g.a(defpackage.a.a());
        f = e.t.i.f(a2);
        a = f;
    }

    public static final void a(e.m.g gVar, Throwable th) {
        Iterator<CoroutineExceptionHandler> it = a.iterator();
        while (it.hasNext()) {
            try {
                it.next().handleException(gVar, th);
            } catch (Throwable th2) {
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, a0.b(th, th2));
            }
        }
        Thread currentThread2 = Thread.currentThread();
        currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, th);
    }
}
