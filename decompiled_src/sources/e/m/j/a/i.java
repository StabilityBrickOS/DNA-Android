package e.m.j.a;

/* loaded from: classes.dex */
public abstract class i extends a {
    public i(e.m.d<Object> dVar) {
        super(dVar);
        if (dVar != null) {
            if (!(dVar.getContext() == e.m.h.INSTANCE)) {
                throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
            }
        }
    }

    @Override // e.m.j.a.a, e.m.d
    public e.m.g getContext() {
        return e.m.h.INSTANCE;
    }
}
