package kotlinx.coroutines;

/* loaded from: classes.dex */
public final class r {
    public static final <T> Object a(Object obj) {
        Throwable m269exceptionOrNullimpl = e.f.m269exceptionOrNullimpl(obj);
        return m269exceptionOrNullimpl == null ? obj : new q(m269exceptionOrNullimpl, false, 2, null);
    }

    public static final <T> Object b(Object obj, h<?> hVar) {
        Throwable m269exceptionOrNullimpl = e.f.m269exceptionOrNullimpl(obj);
        if (m269exceptionOrNullimpl != null) {
            if (h0.d() && (hVar instanceof e.m.j.a.d)) {
                m269exceptionOrNullimpl = kotlinx.coroutines.internal.q.j(m269exceptionOrNullimpl, (e.m.j.a.d) hVar);
            }
            obj = new q(m269exceptionOrNullimpl, false, 2, null);
        }
        return obj;
    }
}
