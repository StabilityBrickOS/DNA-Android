package kotlinx.coroutines;

import e.m.g;

/* loaded from: classes.dex */
public interface CoroutineExceptionHandler extends g.b {

    /* renamed from: c, reason: collision with root package name */
    public static final a f1554c = a.a;

    /* loaded from: classes.dex */
    public static final class a implements g.c<CoroutineExceptionHandler> {
        static final /* synthetic */ a a = new a();

        private a() {
        }
    }

    void handleException(e.m.g gVar, Throwable th);
}
