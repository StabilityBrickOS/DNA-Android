package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.p1;

/* loaded from: classes.dex */
public final class l {
    private static final boolean a;

    /* renamed from: b, reason: collision with root package name */
    public static final p1 f1590b;

    static {
        l lVar = new l();
        a = s.e("kotlinx.coroutines.fast.service.loader", true);
        f1590b = lVar.a();
    }

    private l() {
    }

    private final p1 a() {
        e.t.c a2;
        List<MainDispatcherFactory> f;
        Object next;
        p1 d2;
        try {
            if (a) {
                f = e.a.c();
            } else {
                a2 = e.t.g.a(defpackage.a.b());
                f = e.t.i.f(a2);
            }
            Iterator<T> it = f.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int loadPriority = ((MainDispatcherFactory) next).getLoadPriority();
                    do {
                        Object next2 = it.next();
                        int loadPriority2 = ((MainDispatcherFactory) next2).getLoadPriority();
                        if (loadPriority < loadPriority2) {
                            next = next2;
                            loadPriority = loadPriority2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            MainDispatcherFactory mainDispatcherFactory = (MainDispatcherFactory) next;
            return (mainDispatcherFactory == null || (d2 = m.d(mainDispatcherFactory, f)) == null) ? m.b(null, null, 3, null) : d2;
        } catch (Throwable th) {
            return m.b(th, null, 2, null);
        }
    }
}
