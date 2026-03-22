package kotlinx.coroutines;

import e.f;

/* loaded from: classes.dex */
public final class i0 {
    public static final String a(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static final String b(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String c(e.m.d<?> dVar) {
        Object m266constructorimpl;
        if (dVar instanceof m0) {
            return dVar.toString();
        }
        try {
            f.a aVar = e.f.Companion;
            m266constructorimpl = e.f.m266constructorimpl(dVar + '@' + b(dVar));
        } catch (Throwable th) {
            f.a aVar2 = e.f.Companion;
            m266constructorimpl = e.f.m266constructorimpl(e.g.a(th));
        }
        if (e.f.m269exceptionOrNullimpl(m266constructorimpl) != null) {
            m266constructorimpl = dVar.getClass().getName() + '@' + b(dVar);
        }
        return (String) m266constructorimpl;
    }
}
