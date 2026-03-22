package kotlinx.coroutines;

/* loaded from: classes.dex */
public final class b1 implements c1 {

    /* renamed from: e, reason: collision with root package name */
    private final q1 f1558e;

    public b1(q1 q1Var) {
        this.f1558e = q1Var;
    }

    @Override // kotlinx.coroutines.c1
    public boolean a() {
        return false;
    }

    @Override // kotlinx.coroutines.c1
    public q1 c() {
        return this.f1558e;
    }

    public String toString() {
        return h0.c() ? c().r("New") : super.toString();
    }
}
