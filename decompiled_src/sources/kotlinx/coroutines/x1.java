package kotlinx.coroutines;

/* loaded from: classes.dex */
public final class x1 {

    /* renamed from: b, reason: collision with root package name */
    public static final x1 f1616b = new x1();
    private static final ThreadLocal<u0> a = new ThreadLocal<>();

    private x1() {
    }

    public final u0 a() {
        u0 u0Var = a.get();
        if (u0Var != null) {
            return u0Var;
        }
        u0 a2 = x0.a();
        a.set(a2);
        return a2;
    }

    public final void b() {
        a.set(null);
    }

    public final void c(u0 u0Var) {
        a.set(u0Var);
    }
}
