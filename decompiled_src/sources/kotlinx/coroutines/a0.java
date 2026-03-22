package kotlinx.coroutines;

/* loaded from: classes.dex */
public final class a0 {
    public static final void a(e.m.g gVar, Throwable th) {
        try {
            CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) gVar.get(CoroutineExceptionHandler.f1554c);
            if (coroutineExceptionHandler != null) {
                coroutineExceptionHandler.handleException(gVar, th);
            } else {
                z.a(gVar, th);
            }
        } catch (Throwable th2) {
            z.a(gVar, b(th, th2));
        }
    }

    public static final Throwable b(Throwable th, Throwable th2) {
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        e.b.a(runtimeException, th);
        return runtimeException;
    }
}
