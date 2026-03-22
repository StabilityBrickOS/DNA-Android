package kotlinx.coroutines;

/* loaded from: classes.dex */
final class s0 extends f {

    /* renamed from: e, reason: collision with root package name */
    private final r0 f1611e;

    public s0(r0 r0Var) {
        this.f1611e = r0Var;
    }

    @Override // kotlinx.coroutines.g
    public void a(Throwable th) {
        this.f1611e.b();
    }

    @Override // e.p.c.l
    public /* bridge */ /* synthetic */ e.j invoke(Throwable th) {
        a(th);
        return e.j.a;
    }

    public String toString() {
        return "DisposeOnCancel[" + this.f1611e + ']';
    }
}
