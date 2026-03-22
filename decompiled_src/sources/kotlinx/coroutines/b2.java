package kotlinx.coroutines;

/* loaded from: classes.dex */
public final class b2 extends y {
    public static final b2 f = new b2();

    private b2() {
    }

    @Override // kotlinx.coroutines.y
    public void n(e.m.g gVar, Runnable runnable) {
        c2 c2Var = (c2) gVar.get(c2.f);
        if (c2Var == null) {
            throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
        }
        c2Var.f1560e = true;
    }

    @Override // kotlinx.coroutines.y
    public boolean o(e.m.g gVar) {
        return false;
    }

    @Override // kotlinx.coroutines.y
    public String toString() {
        return "Dispatchers.Unconfined";
    }
}
